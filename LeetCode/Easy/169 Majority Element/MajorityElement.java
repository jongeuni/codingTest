class MajorityElement {
    public int majorityElement(int[] nums) {
        double time = nums.length/2.0;
        
        for (int num: nums) {
            int count = 0;
            for(int n : nums) {
                if (n==num) {
                    count++;
                }
            }
            if(count>=time) {
                return num;
            }
        }
        return -1;
    }
}

