const majorityElement = function (nums) {
  const majorCount = nums.length;

  let map = new Map();
  let answer;

  nums.forEach((e) => {
    const n = typeof map.get(e) == "undefined" ? 0 : map.get(e);
    if (n + 1 >= majorCount / 2) {
      answer = e;
    } else {
      map.set(e, n + 1);
    }
  });

  return answer;
};
