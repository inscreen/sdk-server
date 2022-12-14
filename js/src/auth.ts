import { createCipheriv, randomBytes } from 'crypto';

export type InScreenSession = {
    v: 1;
    userId: string;
    teamId: string;
    /** Optional, default: now */
    timestamp?: Date;
    /** Optional, default: [] */
    additionalTeamIds?: string[];
    /** Optional, default: [] */
    additionalTeamLinks?: string[];
};

export function createInScreenToken(apiKey: string, session: InScreenSession): string {
    const iv = randomBytes(12);
    const cipher = createCipheriv('aes-256-gcm', Buffer.from(apiKey, 'base64url'), iv);
    const a = cipher.update(
        JSON.stringify({
            ...session,
            timestamp: Math.floor((session.timestamp ?? new Date()).valueOf() / 1000),
        }),
        'utf8',
    );
    const b = cipher.final();
    return (
        iv.toString('base64url') +
        cipher.getAuthTag().toString('base64url') +
        Buffer.concat([a, b]).toString('base64url')
    );
}
