
===================
inscreen_sdk_server
===================

A changelog is available in the `GitHub releases page <https://github.com/inscreen/sdk-server/releases>`_.

A feature comparison between different SDKs can be found in the `global README <https://github.com/inscreen/sdk-server/blob/main/README.md>`_.

createInScreenToken
===================

Use this method to create secure session tokens for inScreen.

.. code:: python

   import inscreen_sdk_server

   inscreen_token = inscreen_sdk_server.create_inscreen_token(
      api_key,
      v=1,
      user_id='USER_ID_HERE',
      team_id='TEAM_ID_HERE'
   )