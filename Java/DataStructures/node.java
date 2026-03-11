import java.util.*;

// ╔═══════════════════════════════════════════════════════════════════════╗
// ║          COMPLETE BEGINNER'S GUIDE TO NODES IN JAVA                 ║
// ║                                                                     ║
// ║  Topics Covered:                                                    ║
// ║    1. What is a Node? (Concept + Memory Model)                      ║
// ║    2. Singly Linked List  — Node with ONE pointer                   ║
// ║    3. Doubly Linked List  — Node with TWO pointers                  ║
// ║    4. Binary Tree / BST   — Node with LEFT & RIGHT children         ║
// ║    5. Operations: Insert, Delete, Search, Reverse, Traverse         ║
// ╚═══════════════════════════════════════════════════════════════════════╝

public class node {

    // ┌─────────────────────────────────────────────────────────────────┐
    // │  CONCEPT 1: WHAT IS A NODE?                                    │
    // └─────────────────────────────────────────────────────────────────┘
    //
    //  A "Node" is the fundamental building block of linked data structures.
    //
    //  Think of it like a box with TWO compartments:
    //    ┌──────────┬──────────┐
    //    │   DATA   │   LINK   │    <-- this is one Node
    //    └──────────┴──────────┘
    //
    //  - DATA compartment : stores the actual value (int, String, etc.)
    //  - LINK compartment : stores the MEMORY ADDRESS of the next node
    //
    //  WHY NOT JUST USE AN ARRAY?
    //  ─────────────────────────
    //  Arrays store elements in CONTIGUOUS (side-by-side) memory.
    //    - Pros: Fast access by index — arr[3] is instant (O(1))
    //    - Cons: Fixed size; inserting/deleting in the middle is slow (O(n))
    //
    //  Nodes (Linked structures) store elements ANYWHERE in memory,
    //  connected by references (pointers).
    //    - Pros: Dynamic size; insert/delete at known position is O(1)
    //    - Cons: No direct index access; must walk from the head (O(n))
    //
    //  MEMORY PICTURE — How nodes actually live in RAM:
    //
    //    Address 0x100        Address 0x350        Address 0x220
    //    ┌────┬───────┐      ┌────┬───────┐      ┌────┬──────┐
    //    │ 10 │ 0x350 │ ---> │ 20 │ 0x220 │ ---> │ 30 │ null │
    //    └────┴───────┘      └────┴───────┘      └────┴──────┘
    //
    //  Notice: the addresses are NOT sequential. Each node can be
    //  anywhere in memory — the "next" field is what chains them together.
    //
    //  KEY TERMINOLOGY:
    //  ────────────────
    //  head  = the FIRST node in the list (our entry point)
    //  tail  = the LAST node (its "next" is null)
    //  null  = means "points to nothing" — end of the chain
    //  this  = refers to the CURRENT object instance in Java


    // ┌─────────────────────────────────────────────────────────────────┐
    // │  CONCEPT 2: SINGLY LINKED LIST NODE                            │
    // └─────────────────────────────────────────────────────────────────┘
    //
    //  Each node has exactly ONE pointer → the "next" node.
    //  You can only travel FORWARD (head → tail), never backward.
    //
    //  Visual:
    //    head
    //     │
    //     ▼
    //   [10] -> [20] -> [30] -> [40] -> null
    //
    //  "static class" means this inner class belongs to the outer class
    //  itself (not to an instance of it). This lets us use it inside
    //  static methods like main() without creating a 'node' object.

    static class SinglyNode {

        int data;           // The value this node stores
        SinglyNode next;    // Reference (pointer) to the NEXT node in the chain

        // Constructor — called when we write: new SinglyNode(10)
        //
        // TRICKY LINE:  this.data = data;
        //   "this.data" = the instance variable (field) of THIS object
        //   "data"      = the parameter passed into the constructor
        //   Without "this", Java would think both refer to the parameter.
        //
        // TRICKY LINE:  this.next = null;
        //   When a node is first created, it doesn't point anywhere yet.
        //   null means "no next node" — we'll connect it later.

        SinglyNode(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // ┌─────────────────────────────────────────────────────────────────┐
    // │  CONCEPT 3: DOUBLY LINKED LIST NODE                            │
    // └─────────────────────────────────────────────────────────────────┘
    //
    //  Each node has TWO pointers: "prev" (previous) and "next".
    //  You can travel BOTH forward and backward.
    //
    //  Visual:
    //    null <── [100] ──> [200] ──> [300] ──> null
    //             ◄──── [200] ◄──── [300]
    //
    //  More precisely:
    //    null <-prev- [100] -next-> [200] -next-> [300] -next-> null
    //                 [100] <-prev- [200] <-prev- [300]
    //
    //  USE CASE: Browser history (back/forward), undo/redo, music playlists.
    //  TRADE-OFF: Uses more memory (extra pointer per node) but allows
    //             O(1) backward traversal and easier deletion from both ends.

    static class DoublyNode {

        int data;           // The value this node stores
        DoublyNode prev;    // Points to the PREVIOUS node (or null if first)
        DoublyNode next;    // Points to the NEXT node (or null if last)

        // Both prev and next start as null — this node is isolated until
        // we manually link it to other nodes.

        DoublyNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }


    // ┌─────────────────────────────────────────────────────────────────┐
    // │  CONCEPT 4: BINARY TREE NODE                                   │
    // └─────────────────────────────────────────────────────────────────┘
    //
    //  Instead of a "next" pointer, a tree node has TWO child pointers:
    //  "left" and "right". This creates a branching (hierarchical) structure.
    //
    //  Visual — a Binary Search Tree (BST):
    //
    //              50            <-- root (top-most node, no parent)
    //             /  \
    //           30    70         <-- internal nodes (have children)
    //          / \   / \
    //        20  40 60  80      <-- leaf nodes (no children, both null)
    //
    //  BST RULE: For every node —
    //    • All values in the LEFT subtree  are LESS than the node
    //    • All values in the RIGHT subtree are GREATER than the node
    //
    //  This rule makes searching very efficient — at each step we
    //  eliminate half the tree, giving O(log n) average time.
    //
    //  TERMINOLOGY:
    //    root   = top node (like "head" for linked lists)
    //    leaf   = node with no children (left == null AND right == null)
    //    depth  = how many edges from the root to this node
    //    height = longest path from this node down to a leaf

    static class TreeNode {

        int data;           // The value this node stores
        TreeNode left;      // Reference to the LEFT child (smaller values in BST)
        TreeNode right;     // Reference to the RIGHT child (larger values in BST)

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    // ╔═══════════════════════════════════════════════════════════════════╗
    // ║  SINGLY LINKED LIST — OPERATIONS                                ║
    // ╚═══════════════════════════════════════════════════════════════════╝


    // ── INSERT AT END ─────────────────────────────────────────────────
    //
    //  Goal: Add a new node AFTER the last node in the list.
    //
    //  Strategy:
    //    1. Create a new node with the given value.
    //    2. If the list is empty (head == null), the new node IS the list.
    //    3. Otherwise, walk to the last node and link it to the new node.
    //
    //  Before:  [10] -> [20] -> [30] -> null
    //  After:   [10] -> [20] -> [30] -> [40] -> null
    //
    //  Time: O(n) because we must walk to the end.

    static SinglyNode insertAtEnd(SinglyNode head, int value) {

        SinglyNode newNode = new SinglyNode(value);

        // EDGE CASE: If head is null, the list is empty.
        // The new node becomes both the head and the tail.
        if (head == null) {
            return newNode;
        }

        // Start at the head and walk forward until we find the last node.
        //
        // TRICKY LINE:  while (current.next != null)
        //   We check current.NEXT (not current itself) because we need
        //   to STOP at the last node — the one whose .next IS null.
        //   If we checked (current != null) instead, we'd walk past the
        //   last node and 'current' would be null — we couldn't link anything.

        SinglyNode current = head;
        while (current.next != null) {
            current = current.next;     // Move one step forward
        }

        // Now 'current' is the last node. Hook the new node onto it.
        current.next = newNode;

        return head;    // Head hasn't changed.
    }


    // ── INSERT AT BEGINNING ───────────────────────────────────────────
    //
    //  Goal: Add a new node BEFORE the current head.
    //
    //  Before:  head -> [10] -> [20] -> null
    //  After:   head -> [5] -> [10] -> [20] -> null
    //
    //  This is O(1) — no walking needed! We just redirect pointers.

    static SinglyNode insertAtBeginning(SinglyNode head, int value) {

        SinglyNode newNode = new SinglyNode(value);

        // TRICKY LINE:  newNode.next = head;
        //   The new node's "next" now points to whatever "head" pointed to.
        //   Even if head is null (empty list), this still works correctly:
        //   newNode.next becomes null, meaning this is the only node.

        newNode.next = head;

        return newNode;     // The new node is now the HEAD of the list.
    }


    // ── DELETE BY VALUE ───────────────────────────────────────────────
    //
    //  Goal: Remove the FIRST node that contains the given value.
    //
    //  Strategy:
    //    1. If head holds the value, return head.next (skip the head).
    //    2. Otherwise, find the node JUST BEFORE the target node,
    //       and make it skip over the target.
    //
    //  Before:  [5] -> [10] -> [20] -> [30] -> null   (delete 20)
    //  After:   [5] -> [10] ────────-> [30] -> null
    //
    //  The "deleted" node (20) becomes unreachable and Java's Garbage
    //  Collector will automatically reclaim its memory.

    static SinglyNode deleteByValue(SinglyNode head, int value) {

        if (head == null) return null;     // Nothing to delete from empty list

        // Special case: the HEAD itself is the node to delete.
        // Return head.next, effectively removing the old head.
        if (head.data == value) {
            return head.next;
        }

        // Walk the list, but stop at the node BEFORE the target.
        //
        // TRICKY LINE:  while (current.next != null && current.next.data != value)
        //   We look at current.next.data (ONE node ahead) because we need
        //   to modify current.next — you can't unlink a node unless you
        //   have access to the node BEFORE it in a singly linked list.
        //   (This is a key limitation vs. doubly linked lists.)

        SinglyNode current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        // TRICKY LINE:  current.next = current.next.next;
        //
        //   Before:  current -> [TARGET] -> [after]
        //   After:   current ───────────--> [after]
        //
        //   We skip over TARGET by pointing current.next directly to
        //   whatever TARGET was pointing to (current.next.next).
        //   TARGET is now orphaned — no one references it anymore.

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Value " + value + " not found in the list.");
        }

        return head;
    }


    // ── SEARCH ────────────────────────────────────────────────────────
    //
    //  Goal: Check if a value exists anywhere in the list.
    //  Strategy: Walk from head to tail, comparing each node's data.
    //  Time: O(n) — worst case, we check every node.

    static boolean search(SinglyNode head, int value) {

        SinglyNode current = head;

        while (current != null) {
            if (current.data == value) {
                return true;        // Found it!
            }
            current = current.next; // Move to the next node
        }

        return false;   // Reached the end without finding it
    }


    // ── COUNT NODES ───────────────────────────────────────────────────
    //
    //  Simply walk the entire list, incrementing a counter at each step.

    static int countNodes(SinglyNode head) {

        int count = 0;
        SinglyNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }


    // ── REVERSE A LINKED LIST ─────────────────────────────────────────
    //
    //  Goal: Flip the direction of all pointers so the list runs backward.
    //
    //  Before:  [10] -> [20] -> [30] -> null
    //  After:   [30] -> [20] -> [10] -> null
    //
    //  This is one of the TRICKIEST linked list operations for beginners.
    //  We use THREE pointers:
    //    prev    = the node behind us  (starts at null)
    //    current = the node we're at   (starts at head)
    //    next    = the node ahead of us (saved before we reroute)
    //
    //  STEP-BY-STEP WALKTHROUGH (list: 10 -> 20 -> 30 -> null):
    //
    //  ── Iteration 1 (current = [10]) ──
    //    next = [20]                  // save what comes after
    //    [10].next = null (prev)      // reverse: [10] now points backward
    //    prev = [10]                  // advance prev
    //    current = [20]               // advance current
    //
    //    State: null <- [10]    [20] -> [30] -> null
    //
    //  ── Iteration 2 (current = [20]) ──
    //    next = [30]
    //    [20].next = [10]             // reverse: [20] now points to [10]
    //    prev = [20]
    //    current = [30]
    //
    //    State: null <- [10] <- [20]    [30] -> null
    //
    //  ── Iteration 3 (current = [30]) ──
    //    next = null
    //    [30].next = [20]             // reverse: [30] now points to [20]
    //    prev = [30]
    //    current = null               // loop ends
    //
    //    State: null <- [10] <- [20] <- [30]
    //                                    ↑
    //                                   prev = new head!

    static SinglyNode reverse(SinglyNode head) {

        SinglyNode prev = null;       // Nothing behind us initially
        SinglyNode current = head;    // Start at the head
        SinglyNode next;              // Will be assigned inside the loop

        while (current != null) {

            next = current.next;      // SAVE the next node before we break the link

            // TRICKY LINE:  current.next = prev;
            //   This is the actual REVERSAL. Instead of pointing forward,
            //   the current node now points BACKWARD to 'prev'.
            //   On the first iteration, prev is null, so the old head
            //   becomes the new tail (points to null).

            current.next = prev;

            prev = current;           // Advance: prev moves to where current is
            current = next;           // Advance: current moves to the saved next
        }

        // When the loop ends, current is null and prev is the LAST node
        // we visited — which is now the NEW head of the reversed list.
        return prev;
    }


    // ── PRINT LINKED LIST ─────────────────────────────────────────────
    //  Walk from head to null, printing each node's data.

    static void printList(SinglyNode head) {
        SinglyNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    // ╔═══════════════════════════════════════════════════════════════════╗
    // ║  BINARY SEARCH TREE (BST) — OPERATIONS                          ║
    // ╚═══════════════════════════════════════════════════════════════════╝


    // ── INSERT INTO BST (RECURSIVE) ───────────────────────────────────
    //
    //  Goal: Place a new value in the correct position so the BST
    //        property is maintained.
    //
    //  BST Rule reminder:
    //    left subtree  < node < right subtree
    //
    //  Strategy (recursive):
    //    • If tree is empty (root == null), create and return a new node.
    //    • If value < root.data, insert into the LEFT subtree.
    //    • If value > root.data, insert into the RIGHT subtree.
    //    • If value == root.data, do nothing (ignore duplicates).
    //
    //  TRICKY LINE:  root.left = insertBST(root.left, value);
    //    This is RECURSION — the method calls itself with a smaller tree.
    //    Each recursive call goes one level deeper until it finds a null
    //    spot, creates a new node there, and returns it. The returned
    //    node gets assigned as the left (or right) child, reconnecting
    //    the tree on the way back up.
    //
    //  Example: inserting 25 into the tree below:
    //
    //         50                     50
    //        /  \                   /  \
    //      30    70     --->      30    70
    //     / \                   / \
    //   20  40                20  40
    //                        /
    //                      25   <-- inserted here (25 < 30, 25 > 20)
    //
    //  Time: O(log n) average, O(n) worst case (if tree is a straight line).

    static TreeNode insertBST(TreeNode root, int value) {

        // Base case: found an empty spot — this is where the new node goes.
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.data) {
            root.left = insertBST(root.left, value);   // Go left
        } else if (value > root.data) {
            root.right = insertBST(root.right, value);  // Go right
        }
        // If value == root.data, we do nothing (no duplicates in this BST).

        return root;
    }


    // ── TREE TRAVERSALS ───────────────────────────────────────────────
    //
    //  "Traversal" means visiting every node in a specific order.
    //  There are three classic depth-first traversals:
    //
    //  For this tree:
    //              50
    //             /  \
    //           30    70
    //          / \   / \
    //        20  40 60  80
    //
    //  ┌───────────────┬──────────────────┬─────────────────────────────┐
    //  │  Traversal    │  Visit Order     │  Output                    │
    //  ├───────────────┼──────────────────┼─────────────────────────────┤
    //  │  In-order     │  Left→Root→Right │  20 30 40 50 60 70 80      │
    //  │  Pre-order    │  Root→Left→Right │  50 30 20 40 70 60 80      │
    //  │  Post-order   │  Left→Right→Root │  20 40 30 60 80 70 50      │
    //  └───────────────┴──────────────────┴─────────────────────────────┘
    //
    //  IN-ORDER gives SORTED output for a BST — this is very useful!
    //  PRE-ORDER is useful for copying/serializing a tree.
    //  POST-ORDER is useful for deleting a tree (children before parent).
    //
    //  All three use RECURSION. The base case is: if root is null, stop.
    //  The only difference is WHEN we print root.data relative to the
    //  recursive calls.

    // In-order: Left, then Root, then Right
    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);                 // Visit entire left subtree
            System.out.print(root.data + " ");  // Visit this node
            inOrder(root.right);                // Visit entire right subtree
        }
    }

    // Pre-order: Root first, then Left, then Right
    static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");  // Visit this node FIRST
            preOrder(root.left);                 // Then left subtree
            preOrder(root.right);                // Then right subtree
        }
    }

    // Post-order: Left, then Right, then Root last
    static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);                // Left subtree first
            postOrder(root.right);               // Right subtree second
            System.out.print(root.data + " ");   // Visit this node LAST
        }
    }


    // ╔═══════════════════════════════════════════════════════════════════╗
    // ║  MAIN METHOD — DEMO & OUTPUT                                    ║
    // ╚═══════════════════════════════════════════════════════════════════╝

    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║     NODES IN JAVA — COMPLETE BEGINNER GUIDE  ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");


        // ─────────────────────────────────────────────────────
        //  DEMO 1: SINGLY LINKED LIST
        // ─────────────────────────────────────────────────────

        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│  DEMO 1: Singly Linked List         │");
        System.out.println("└─────────────────────────────────────┘\n");

        // 'head' is our only entry point into the list.
        // It starts as null because the list is empty.
        SinglyNode head = null;

        // Build list by inserting at the end
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 20);
        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 40);

        System.out.print("  Built list:               ");
        printList(head);
        // Expected: 10 -> 20 -> 30 -> 40 -> null

        // Insert at the beginning — O(1), no traversal needed
        head = insertAtBeginning(head, 5);
        System.out.print("  Insert 5 at beginning:    ");
        printList(head);
        // Expected: 5 -> 10 -> 20 -> 30 -> 40 -> null

        // Search for values
        System.out.println("  Search for 30:            " + (search(head, 30) ? "Found!" : "Not Found"));
        System.out.println("  Search for 99:            " + (search(head, 99) ? "Found!" : "Not Found"));

        // Count nodes
        System.out.println("  Total nodes:              " + countNodes(head));

        // Delete a node by value
        head = deleteByValue(head, 20);
        System.out.print("  After deleting 20:        ");
        printList(head);
        // Expected: 5 -> 10 -> 30 -> 40 -> null

        // Reverse the entire list
        head = reverse(head);
        System.out.print("  After reversing:          ");
        printList(head);
        // Expected: 40 -> 30 -> 10 -> 5 -> null


        // ─────────────────────────────────────────────────────
        //  DEMO 2: DOUBLY LINKED LIST
        // ─────────────────────────────────────────────────────

        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│  DEMO 2: Doubly Linked List         │");
        System.out.println("└─────────────────────────────────────┘\n");

        // Create three isolated doubly-linked nodes
        DoublyNode d1 = new DoublyNode(100);
        DoublyNode d2 = new DoublyNode(200);
        DoublyNode d3 = new DoublyNode(300);

        // Manually link them together: d1 <--> d2 <--> d3
        //
        // IMPORTANT: Every connection needs TWO assignments:
        //   d1.next = d2;   (d1 points forward to d2)
        //   d2.prev = d1;   (d2 points backward to d1)
        // If you forget one, traversal in that direction will break!

        d1.next = d2;      // d1 --next--> d2
        d2.prev = d1;      // d1 <--prev-- d2
        d2.next = d3;      // d2 --next--> d3
        d3.prev = d2;      // d2 <--prev-- d3

        // Traverse FORWARD (using .next)
        System.out.print("  Forward traversal:   ");
        DoublyNode temp = d1;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
        // Expected: 100 <-> 200 <-> 300 <-> null

        // Traverse BACKWARD (using .prev) — start from the LAST node
        System.out.print("  Backward traversal:  ");
        temp = d3;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
        // Expected: 300 <-> 200 <-> 100 <-> null

        // BONUS: Inserting a node between d1 and d2
        DoublyNode d15 = new DoublyNode(150);
        d15.next = d2;      // 150 points forward to 200
        d15.prev = d1;      // 150 points backward to 100
        d1.next = d15;      // 100 now points forward to 150 (not 200)
        d2.prev = d15;      // 200 now points backward to 150 (not 100)

        System.out.print("  After inserting 150: ");
        temp = d1;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
        // Expected: 100 <-> 150 <-> 200 <-> 300 <-> null


        // ─────────────────────────────────────────────────────
        //  DEMO 3: BINARY SEARCH TREE
        // ─────────────────────────────────────────────────────

        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│  DEMO 3: Binary Search Tree (BST)   │");
        System.out.println("└─────────────────────────────────────┘\n");

        TreeNode root = null;       // Tree starts empty
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        System.out.print("  Inserting values: ");
        for (int v : values) {
            System.out.print(v + " ");
            root = insertBST(root, v);
        }
        System.out.println("\n");

        // The tree now looks like this:
        //
        //              50
        //             /  \
        //           30    70
        //          / \   / \
        //        20  40 60  80
        //
        // Verify with traversals:

        System.out.print("  In-order   (Left→Root→Right) : ");
        inOrder(root);
        System.out.println();
        // Expected: 20 30 40 50 60 70 80  (sorted — always true for BST!)

        System.out.print("  Pre-order  (Root→Left→Right) : ");
        preOrder(root);
        System.out.println();
        // Expected: 50 30 20 40 70 60 80

        System.out.print("  Post-order (Left→Right→Root) : ");
        postOrder(root);
        System.out.println();
        // Expected: 20 40 30 60 80 70 50


        // ─────────────────────────────────────────────────────
        //  QUICK REFERENCE SUMMARY
        // ─────────────────────────────────────────────────────

        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║              QUICK REFERENCE CHEAT SHEET              ║");
        System.out.println("╠═══════════════════════════════════════════════════════╣");
        System.out.println("║                                                       ║");
        System.out.println("║  Singly Node:  data + next                            ║");
        System.out.println("║  Doubly Node:  data + prev + next                     ║");
        System.out.println("║  Tree Node:    data + left + right                    ║");
        System.out.println("║                                                       ║");
        System.out.println("║  Operations          Singly LL    Array               ║");
        System.out.println("║  ─────────────────────────────────────────             ║");
        System.out.println("║  Insert at start     O(1)         O(n)                ║");
        System.out.println("║  Insert at end       O(n)         O(1)*               ║");
        System.out.println("║  Delete by value     O(n)         O(n)                ║");
        System.out.println("║  Search              O(n)         O(n) / O(log n)**   ║");
        System.out.println("║  Access by index     O(n)         O(1)                ║");
        System.out.println("║                                                       ║");
        System.out.println("║  * amortized   ** if sorted (binary search)           ║");
        System.out.println("║                                                       ║");
        System.out.println("║  BST Operations      Average      Worst               ║");
        System.out.println("║  ─────────────────────────────────────────             ║");
        System.out.println("║  Insert / Search     O(log n)     O(n)                ║");
        System.out.println("║  In-order traversal  O(n)         O(n)                ║");
        System.out.println("║                                                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
    }
}