package basic_class_03;
/*
已讲解
 */

/*
如何仅用队列结构实现栈结构？
如何仅用栈结构实现队列结构？
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	public static class TwoStacksQueue {
		private final Stack<Integer> stackPush;
		private final Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}

		public void dao() {
			/*
			实现倒数据
			 */
			if (!stackPop.isEmpty()) return;
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}

		public static class TwoQueuesStack {
			private Queue<Integer> queue;
			private Queue<Integer> help;

			public TwoQueuesStack() {
				queue = new LinkedList<Integer>();
				help = new LinkedList<Integer>();
			}

			public void push(int pushInt) {
				queue.add(pushInt);
			}

			public int peek() {
				if (queue.isEmpty()) {
					throw new RuntimeException("Stack is empty!");
				}
				while (queue.size() != 1) {
					help.add(queue.poll());
				}
				int res = queue.poll();
				help.add(res);
				swap();
				return res;
			}

			public int pop() {
				if (queue.isEmpty()) {
					throw new RuntimeException("Stack is empty!");
				}
				while (queue.size() > 1) {
					help.add(queue.poll());
				}
				int res = queue.poll();
				swap();
				return res;
			}

			private void swap() {
				Queue<Integer> tmp = help;
				help = queue;
				queue = tmp;
			}
		}
	}

}
