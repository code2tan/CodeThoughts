package org.algorithm;

import org.algorithm.struct.ListNode;

class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        head.next = removeNodes(head.next);
        if (head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        ListNode result = new Solution2487().removeNodes(listNode);
        StringBuffer stringBuffer = new StringBuffer();
        while (result != null) {
            stringBuffer.append(result.val);
            if (result.next != null) {
                stringBuffer.append("->");
            }
            result = result.next;
        }
        System.out.println(stringBuffer);

    }
}
