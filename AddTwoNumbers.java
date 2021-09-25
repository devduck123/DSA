// given two non-empty linked lists representing integers:
// return the sum of the two represented integers as a linkedlist
// NOTE: digits are stored in reverse order (simpler)
// NOTE: working with non-negative integers

public class AddTwoNumbers {
    public static void main (String[] args) {
        ListNode num1 = new ListNode();
        ListNode num2 = new ListNode();

        // num1 = 342 = [2, 4, 3] stored in reverse
        num1.val = 2;
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(3);

        // num2 = 465 = [5, 6, 4] stored in reverse
        num2.val = 5;
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);

        // output (sum) should be 807 = [7, 0, 8] stored in reverse

        // check num1 digits
        // System.out.print("num1: ");
        // System.out.print(num1.val);
        // System.out.print(num1.next.val);
        // System.out.println(num1.next.next.val);

        // check num2 digits
        // System.out.print("num2: ");
        // System.out.print(num2.val);
        // System.out.print(num2.next.val);
        // System.out.println(num2.next.next.val);

        // print sum
        System.out.println("SUM: " + addTwoNumbers(num1, num2).val 
                            + "" + addTwoNumbers(num1, num2).next.val 
                            + "" + addTwoNumbers(num1, num2).next.next.val);
    }

    static ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        // tricky part is handling overflow
        //  ex: 5 + 7 = 12 -> current=2, next=+1

        ListNode dummyHead = new ListNode(0);
        ListNode sum = dummyHead;

        // prepare for overflow
        int carry = 0;

        // as long as one of the lists are not null...
        while (num1 != null || num2 != null) {
            // if list not null assign the value, otherwise value = 0
            int num1_val = (num1 != null) ? num1.val : 0;
            int num2_val = (num2 != null) ? num2.val : 0;

            int currentSum = num1_val + num2_val + carry;
            // don't add carry till iteration to next digit
            carry = currentSum / 10; // grab 1st digit, our case has 1 as a max (9+9=18)
            int lastDigit = currentSum % 10; // grab last digit

            // put digits in, starting with lastDigit (current)
            ListNode newNode = new ListNode(lastDigit);
            sum.next = newNode;

            if (num1 != null) { num1 = num1.next; }
            if (num2 != null) { num2 = num2.next; }
            sum = sum.next;
        }

        // add place for carry in sum (if last digit overflows)
        if (carry > 0) {
            System.out.println("ACCESSED");
            ListNode newNode = new ListNode(carry);
            sum.next = newNode;
            sum = sum.next;
        }

        return dummyHead.next;
    }
}


