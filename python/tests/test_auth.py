from inscreen_sdk_server import create_inscreen_token

__author__ = "InScreen, Inc."
__copyright__ = "InScreen, Inc."
__license__ = "MIT"


def test_create_inscreen_token():
    """API Tests"""
    assert len(create_inscreen_token(
        'FAoVh0gN1ZG6PgNNV30aWbOXZM6VhSNtVzL7QfY7cD8',
        v=1,
        team_id='2432423',
        user_id='435454'
    ).decode('utf-8')) == 128
