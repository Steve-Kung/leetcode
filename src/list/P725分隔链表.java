package list;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

 返回一个符合上述规则的链表的列表。

 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 */
public class P725分隔链表 {
    public ListNode[] splitListToParts1(ListNode root, int k) {
        // 先遍历链表，计算长度
        ListNode p1 = root;
        int len = 0;
        while (p1 != null){
            len++;
            p1 = p1.next;
        }
        // 计算每等份可以分配到多大的长度
        int each = len/k;
        int extra = len%k;

        // 然后把每等份存入到结果数组中
        ListNode[] res = new ListNode[k];
        ListNode p2 = root;
        for (int i=0;i<k;i++){
            res[i] = p2;
            if (p2 == null){
                break;
            }
            ListNode subRoot = res[i];
            int size = each;
            if (extra-- > 0){
                size = each + 1;
            }
            while (--size > 0){
                subRoot = subRoot.next;
                p2 = p2.next;
            }
            p2 = p2.next;
            subRoot.next = null;
        }
        return res;
    }

    // 创建新链表
    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }

    // 拆分链表
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        P725分隔链表 p725分隔链表 = new P725分隔链表();
        ListNode[] listNodes = p725分隔链表.splitListToParts(root, 5);
        System.out.println(listNodes);
    }
}
