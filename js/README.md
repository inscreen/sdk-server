# @inscreen/sdk-server

A changelog is available in the [GitHub releases page](https://github.com/inscreen/sdk-server/releases).

A feature comparison between different SDKs can be found in the [global README](https://github.com/inscreen/sdk-server/blob/main/README.md).

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