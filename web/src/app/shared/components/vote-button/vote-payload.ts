import { VoteType } from '../../enums/vote-type';

export class VotePayload {
    voteType: VoteType;
    postId: number;
}
