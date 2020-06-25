package dp;
/*
 NowCoder每天要给很多人发邮件。有一天他发现发错了邮件，把发给A的邮件发给了B，
把发给B的邮件发给了A。于是他就思考，要给n个人发邮件，在每个人仅收到1封邮件的情况下，
有多少种情况是所有人都收到了错误的邮件？
  即没有人收到属于自己的邮件

当n个编号元素放在n个编号位置，元素编号与位置编号各不对应的方法数用dp[n]表示，
那么dp[n-1]就表示n-1个编号元素放在n-1个编号位置，各不对应的方法数，其它类推.
  第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
  第二步，放编号为k的元素，这时有两种情况：⑴把它放到位置n，那么，
对于剩下的n-1个元素，由于第k个元素放到了位置n，
剩下n-2个元素就有dp[n-2]种方法；⑵第k个元素不把它放到位置n，
这时，对于这n-1个元素，有dp[n-1]种方法；

public int erroNum(int n){
    if(n=0)
        return 0;
    if(n=1)
        return 0;
    int []dp=new int [n+1];
    dp[0]=0;
    dp[1]=0;
    dp[2]=1;
    for(int i=3;i<=n;i++){
        dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
    }
    return dp[n];
}
 */
public class 信件错排 {
    public int erroNum(int n){
        if (n ==0 || n == 1){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++){
            dp[i] = (i - 1)*(dp[i - 2] + dp[i - 1]);
        }
        return dp[n];
    }
}
