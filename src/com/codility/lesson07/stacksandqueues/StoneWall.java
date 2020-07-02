package com.codility.lesson07.stacksandqueues;

import java.util.Stack;

/**
 * 
 * You are going to build a stone wall. The wall should be straight and N meters
 * long, and its thickness should be constant; however, it should have different
 * heights in different places. The height of the wall is specified by an array
 * H of N positive integers. H[I] is the height of the wall from I to I+1 meters
 * to the right of its left end. In particular, H[0] is the height of the wall's
 * left end and H[N−1] is the height of the wall's right end.
 * 
 * The wall should be built of cuboid stone blocks (that is, all sides of such
 * blocks are rectangular). Your task is to compute the minimum number of blocks
 * needed to build the wall.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] H); }
 * 
 * that, given an array H of N positive integers specifying the height of the
 * wall, returns the minimum number of blocks needed to build it.
 * 
 * For example, given array H containing N = 9 integers:
 * 
 * - H[0] = 8 
 * - H[1] = 8 
 * - H[2] = 5 
 * - H[3] = 7 
 * - H[4] = 9 
 * - H[5] = 8 
 * - H[6] = 7 
 * - H[7] = 4 
 * - H[8] = 8 
 * 
 * the function should return 7. The figure shows one possible arrangement
 * of seven blocks.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * - N is an integer within the range [1..100,000]; 
 * - each element of array H is an integer within the range [1..1,000,000,000].
 * 
 * @author fabiano
 *
 */
public class StoneWall {

     public int solution(int[] H) {
        int minimumBlocks = 0;
        Stack<Block> blocks = new Stack<>();
        for (int height : H) {
            // if there are no blocks, create new
            if (blocks.isEmpty()) {
                Block block = new Block(0, height);
                blocks.push(block);
            } 
            // if current block if taller than last one, this means a new block over the last one
            else if (height > blocks.peek().getUpperHeight()) {
                Block topBlock = new Block(blocks.peek().getUpperHeight(), height);
                blocks.push(topBlock);
            } 
            // if current block is smaller, then that means we'll need to either add a new block or continue using a previous one with same height
            else if (height < blocks.peek().getUpperHeight()) {
                // while current block is smaller than previous ones in the stack, that means we can't use them, they're done (so let's count them).                 
                while (!blocks.empty() && height < blocks.peek().getUpperHeight()) {
                    blocks.pop();
                    minimumBlocks++;
                }
                // if there are no more blocks OR current block is taller than latest one in the stack, let's create a new block. 
                if (blocks.empty() || height > blocks.peek().getUpperHeight()){
                    int lowerHeight = blocks.empty() ? 0 : blocks.peek().getUpperHeight();
                    Block topBlock = new Block(lowerHeight, height);
                    blocks.push(topBlock);
                } else if (height == blocks.peek().getUpperHeight()) {
                    // if it has same height as latest block, do nothing: the current height is part of the block!
                }
            }
        }
        // return blocks in the stack + blocks already market as "done"
        return blocks.size() + minimumBlocks;
    }
    
    class Block {
        public Block(int lowerHeight, int upperHeight) {
            super();
            this.upperHeight = upperHeight;
            this.lowerHeight = lowerHeight;
        }
        int upperHeight;
        int lowerHeight;
        public int getUpperHeight() {
            return upperHeight;
        }
        public void setUpperHeight(int upperHeight) {
            this.upperHeight = upperHeight;
        }
        public int getLowerHeight() {
            return lowerHeight;
        }
        public void setLowerHeight(int lowerHeight) {
            this.lowerHeight = lowerHeight;
        }
    }
}
