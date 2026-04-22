package crowdstrike;

public class SearchInRoatatedSortedArray {

    public boolean search(int[] nums, int target){
        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2; // overflow-safe midpoint

            if(nums[mid] == target) return true;

            if(nums[left] == nums[mid]){
                left++;
                continue;
            }

            // if left half is sorted
            if(nums[left] < nums[mid]){
                // Target falls within the sorted left range
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } // right half is sorted
            else{
                // Target falls within the sorted right range
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid -1;
            }

        }
        return false;
    }

    public int findMin(int[] nums){
        int left =0, right = nums.length-1;

        while(left < right){
            int mid =  left + (right-left)/2;

            if(nums[mid] > nums[right]){
                // min is right half ( rotation point is there )
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                // mid could be the minimum - don't exclude it.
                right = mid;
            } else {
                // nums[mid] == nums[right]; can't determine - shring right
                right --;
            }

        }

        return nums[left]; // left == right converged on min

    }


}
