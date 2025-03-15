import java.util.*;

public class MatrixTraversal {
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> output = new ArrayList<>();
        int top = 0, left = 0, bottom = grid.length - 1, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) output.add(grid[top][i]);
            top++;
            for (int i = top; i <= bottom; i++) output.add(grid[i][right]);
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) output.add(grid[bottom][i]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) output.add(grid[i][left]);
                left++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt(), cols = input.nextInt();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = input.nextInt();

        List<Integer> result = spiralOrder(grid);
        for (int num : result) System.out.print(num + " ");
    }
}

________________________________________________________________

import java.util.*;

public class StockProfit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt(), prices[] = new int[count];

        for (int i = 0; i < count; i++) prices[i] = input.nextInt();

        System.out.println("Max earnings: " + bestProfit(prices));
    }

    static int bestProfit(int[] prices) {
        int profit = 0, minPrice = Integer.MAX_VALUE;
        for (int cost : prices) {
            minPrice = Math.min(minPrice, cost);
            profit = Math.max(profit, cost - minPrice);
        }
        return profit;
    }
}

________________________________________________________________

import java.util.*;

class MissingValues {
    public static List<Integer> findGaps(int[] array) {
        Set<Integer> found = new HashSet<>();
        List<Integer> missing = new ArrayList<>();

        for (int num : array) {
            found.add(num);
        }

        for (int i = 1; i <= array.length; i++) {
            if (!found.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        System.out.println(findGaps(array));

        input.close();
    }
}

________________________________________________________________

class PeakSequence {
    public static int longestPeak(int[] nums) {
        int length = nums.length;
        int maxPeak = 0;
        int idx = 1;

        while (idx < length - 1) {
            if (nums[idx - 1] < nums[idx] && nums[idx] > nums[idx + 1]) {
                int left = idx - 1, right = idx + 1;
                while (left > 0 && nums[left - 1] < nums[left]) left--;
                while (right < length - 1 && nums[right] > nums[right + 1]) right++;
                maxPeak = Math.max(maxPeak, right - left + 1);
                idx = right;
            } else {
                idx++;
            }
        }
        return maxPeak >= 3 ? maxPeak : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestPeak(nums));
    }
}

________________________________________________________________

import java.util.*;

public class JourneyTime {
    public static int minTravelTime(int[][] locations) {
        int totalTime = 0;
        
        for (int i = 1; i < locations.length; i++) {
            int xChange = Math.abs(locations[i][0] - locations[i - 1][0]);
            int yChange = Math.abs(locations[i][1] - locations[i - 1][1]);
            totalTime += Math.max(xChange, yChange);
        }
        
        return totalTime;
    }

    public static void main(String[] args) {
        int[][] locations = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTravelTime(locations));
    }
}

________________________________________________________________

import java.util.*;

public class MissingDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println(findLost(numbers));
        input.close();
    }

    static int findLost(int[] numbers) {
        int xorSum = 0;

        for (int i = 0; i <= numbers.length; i++) {
            xorSum ^= i;
        }
        for (int num : numbers) {
            xorSum ^= num;
        }

        return xorSum;
    }
}

________________________________________________________________

class IslandGroups {
    public static void searchIsland(char[][] land, int row, int col) {
        int rows = land.length, cols = land[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || land[row][col] == '0') {
            return;
        }

        land[row][col] = '0';

        searchIsland(land, row + 1, col);
        searchIsland(land, row - 1, col);
        searchIsland(land, row, col + 1);
        searchIsland(land, row, col - 1);
    }

    public static int countGroups(char[][] land) {
        int totalIslands = 0;
        int rows = land.length, cols = land[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (land[row][col] == '1') {
                    totalIslands++;
                    searchIsland(land, row, col);
                }
            }
        }

        return totalIslands;
    }

    public static void main(String[] args) {
        char[][] land = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(countGroups(land));
    }
}
