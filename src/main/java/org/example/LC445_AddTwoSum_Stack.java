package org.example;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class LC445_AddTwoSum_Stack {

    public ListNode LC445_AddTwoSum_Stack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int totalSum = 0, carry =  0;
        ListNode ans = new ListNode();

        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                totalSum += s1.pop();
            }
            if(!s2.isEmpty()){
                totalSum += s2.pop();
            }

            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }

        return carry == 0 ? ans.next : ans;


    }
}
