/**
 * @param {number[]} nums
 * @return {number}
 */
const rob = (nums) => {
  if (nums.length < 3) {
    return Math.max(0, ...nums);
  }
  for (let i = 2; i < nums.length; i++) {
    nums[i] += nums[i - 3] > nums[i - 2] ? nums[i - 3] : nums[i - 2];
  }
  return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
};
