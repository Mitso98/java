public class ArrayAlgo {
    public int max(int[] arr) {
        long old = System.nanoTime();

        int result = 0;
        for (int i : arr) {
            if (result < i) {
                result = i;
            }
        }
        long current = System.nanoTime();

        System.out.println("Time taken in MS: " + ((current - old) / 1000));
        return result;
    }

    public int min(int[] arr) {
        long old = System.nanoTime();
        int result = 0;
        for (int i : arr) {
            if (result > i) {
                result = i;
            }
        }

        long current = System.nanoTime();

        System.out.println("Time taken in MS: " + ((current - old) / 1000));
        return result;
    }

    public int binarySearch(int[] arr, int target, int min, int max) {

        if (max >= min) {

            int mid = min + (max - min) / 2;

            if (target == arr[mid]) {
                return mid;
            }
            if (arr[mid] > target) {
                return binarySearch(arr, target, min, mid - 1);
            }
            return binarySearch(arr, target, mid + 1, max);

        }

        return -1;

    }
}
