class Solution {
public:
    Node* connect(Node* root) {
        queue<Node*> q;
        q.push(root);

        while (root && !q.empty()) {
            int q_size = q.size();
            Node* prev = NULL;

            while (q_size--) {
                Node* front = q.front();
                q.pop();

                if (front->left)
                    q.push(front->left);

                if (front->right)
                    q.push(front->right);

                if (!prev) {
                    prev = front;
                    continue;
                }

                prev->next = front;
                prev = front;
            }
        }

        return root;
    }
};