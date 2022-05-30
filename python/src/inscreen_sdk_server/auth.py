import base64
import json
from time import time
from Cryptodome.Cipher import AES
from Cryptodome.Random import get_random_bytes


def create_inscreen_token(api_key, v, team_id, user_id, timestamp=None):
    """Create an authentication token.

    Args:
      api_key (str): An inScreen API key
      v (int): The authentication version, must be 1
      team_id (str): A team ID that was previously created in upsertTeam
      user_id (str): A user ID that was previously created in upsertUser
      timestamp (int): Optionally set the session start time (default: now)

    Returns:
      str: An inScreen authentication token.
    """
    key = base64.urlsafe_b64decode(api_key + '=' * (4 - len(api_key) % 4))
    timestamp = timestamp if timestamp is not None else int(time())
    session = {'v': v, 'teamId': team_id, 'userId': user_id, 'timestamp': timestamp}
    base64_session = json.dumps(session, separators=(',', ':')).encode('utf-8')
    iv = get_random_bytes(12)
    cipher = AES.new(key, AES.MODE_GCM, nonce=iv)
    ciphertext, tag = cipher.encrypt_and_digest(base64_session)
    return b''.join(
      [base64.urlsafe_b64encode(val).rstrip((b'=')) for val in [iv, tag, ciphertext]]
    )
