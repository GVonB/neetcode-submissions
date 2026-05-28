# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        fast_point = head
        slow_point = head

        while fast_point and fast_point.next:
            slow_point = slow_point.next
            fast_point = fast_point.next.next
                
            if slow_point == fast_point:
                return True
        return False