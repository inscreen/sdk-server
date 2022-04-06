# @inscreen/sdk-server

A changelog is available in the [GitHub releases page](https://github.com/inscreen/sdk-server/releases).

### createInScreenToken

Use this method to create secure session tokens for inScreen.

```typescript
import { createInScreenToken } from '@inscreen/sdk-server';

const inScreenToken = createInScreenToken(apiKey, {
    v: 1,
    userId: 'USER_ID_HERE',
    teamId: 'TEAM_ID_HERE',
});
```