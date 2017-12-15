package TaskManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {
    Journal journal = new Journal();
    private JButton addTaskButton;
    private JEditorPane contactsEditorPane;
    private JLabel contactsLabel;
    private JScrollPane contactsScrollPane;
    private JButton deleteAllTaskButton;
    private JButton deleteTaskButton;
    private JEditorPane descriptionEditorPane;
    private JLabel descriptionLabel;
    private JScrollPane descriptionScrollPane;
    private JList<String> taskList;
    private JLabel taskListLabel;
    private JPanel taskListPanel;
    private JScrollPane taskListScrollPane;

    private static final String titleName = "Планировщик задач";
    private static final String addTask = "Добавить задачу";
    private static final String deleteTask = "Удалить задачу";
    private static final String deleteAllTask = "Удалить все задачи";
    private static final String pathIcon = "src/images/icon.png";
    private static final String xmlFile = "journal.xml";

    public UI() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        Image image = Toolkit.getDefaultToolkit().getImage(pathIcon);
        setBounds(dimension.width/2 - 450, dimension.height/2 - 300, 900, 600);
        setTitle(titleName);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(image);
        taskListPanel = new JPanel();
        taskListScrollPane = new JScrollPane();
        taskList = new JList<>();
        taskListLabel = new JLabel();
        contactsScrollPane = new JScrollPane();
        contactsEditorPane = new JEditorPane();
        contactsLabel = new JLabel();
        descriptionScrollPane = new JScrollPane();
        descriptionEditorPane = new JEditorPane();
        descriptionLabel = new JLabel();
        addTaskButton = new JButton();
        deleteAllTaskButton = new JButton();
        deleteTaskButton = new JButton();

        taskList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() {
                return strings.length;
            }
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        /*taskList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            }
        });
        taskList.addInputMethodListener(new InputMethodListener() {
            public void caretPositionChanged(InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(InputMethodEvent evt) {
                taskListInputMethodTextChanged(evt);
            }
        });*/
        taskListScrollPane.setViewportView(taskList);

        taskListLabel.setText("Список задач:");

        contactsScrollPane.setViewportView(contactsEditorPane);

        contactsLabel.setText("Контакты:");

        descriptionScrollPane.setViewportView(descriptionEditorPane);

        descriptionLabel.setText("Описание:");

        javax.swing.GroupLayout taskListPanelLayout = new javax.swing.GroupLayout(taskListPanel);
        taskListPanel.setLayout(taskListPanelLayout);
        taskListPanelLayout.setHorizontalGroup(
                taskListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(taskListPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(taskListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(taskListPanelLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(taskListLabel)
                                                .addGap(212, 212, 212)
                                                .addComponent(descriptionLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(taskListPanelLayout.createSequentialGroup()
                                                .addComponent(taskListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(taskListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(taskListPanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(contactsLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(contactsScrollPane)
                                                        .addComponent(descriptionScrollPane)))))
        );
        taskListPanelLayout.setVerticalGroup(
                taskListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(taskListPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(taskListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(taskListLabel)
                                        .addComponent(descriptionLabel))
                                .addGap(7, 7, 7)
                                .addGroup(taskListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(taskListScrollPane)
                                        .addGroup(taskListPanelLayout.createSequentialGroup()
                                                .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(contactsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contactsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        addTaskButton.setText(addTask);
        addTaskButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new AddTaskWindow().setVisible(true);
            }
        });
        deleteTaskButton.setText(deleteTask);
        deleteTaskButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        deleteAllTaskButton.setText(deleteAllTask);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(deleteTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                                                .addComponent(deleteAllTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(taskListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(addTaskButton)
                                                .addComponent(deleteTaskButton))
                                        .addComponent(deleteAllTaskButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(taskListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    class AddTaskWindow extends JDialog {
        private JScrollPane contactsScrollPane;
        private JScrollPane descriptionScrollPane;
        private JEditorPane enterContactsField;
        private JLabel enterContactsLabel;
        private JTextField enterDateField;
        private JLabel enterDateLabel;
        private JEditorPane enterDescriptionField;
        private JLabel enterDescriptionLabel;
        private JTextField enterNameField;
        private JLabel enterNameLabel;
        private JPanel jPanel;
        private JButton saveButton;
        private final String titleName = "Создание задачи";
        private final String saveButtonText = "Сохранить задачу";

        AddTaskWindow() {
            initComponents();
        }

        public void addNewTask(String name, String desc, String date, String contacts) {
            Task task = new Task(name, desc, date, contacts);
            journal.xmlToObject(xmlFile);
            journal.add(task);
            journal.objectToXml(journal, xmlFile);
        }

        private void initComponents() {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            setBounds(dimension.width/2 - 300, dimension.height/2 - 280, 600, 560);
            Image image = Toolkit.getDefaultToolkit().getImage(pathIcon);
            setIconImage(image);
            setTitle(titleName);
            jPanel = new JPanel();
            enterDateField = new JTextField();
            enterDateLabel = new JLabel();
            enterNameLabel = new JLabel();
            enterNameField = new JTextField();
            descriptionScrollPane = new JScrollPane();
            enterDescriptionField = new JEditorPane();
            enterDescriptionLabel = new JLabel();
            enterContactsLabel = new JLabel();
            contactsScrollPane = new JScrollPane();
            enterContactsField = new JEditorPane();
            saveButton = new JButton();

            enterDateLabel.setText("Введите дату и время в формате...");

            enterNameLabel.setText("Введите название задачи:");

            descriptionScrollPane.setViewportView(enterDescriptionField);

            enterDescriptionLabel.setText("Введите описание задачи:");

            enterContactsLabel.setText("Введите контакты:");

            contactsScrollPane.setViewportView(enterContactsField);

            saveButton.setText(saveButtonText);
            saveButton.addActionListener(evt -> {
                String name = enterNameField.getText();
                String desc = enterDescriptionField.getText();
                String date = enterDateField.getText();
                String cont = enterContactsField.getText();
                addNewTask(name, desc, date, cont);
                dispose();
            });

            javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
            jPanel.setLayout(jPanelLayout);
            jPanelLayout.setHorizontalGroup(
                    jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(contactsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                            .addComponent(descriptionScrollPane)
                                            .addComponent(enterNameField)
                                            .addComponent(enterDateField)
                                            .addComponent(enterDateLabel)
                                            .addComponent(enterNameLabel)
                                            .addComponent(enterDescriptionLabel)
                                            .addComponent(enterContactsLabel)
                                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanelLayout.setVerticalGroup(
                    jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(enterDateLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enterDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(enterNameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(enterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(enterDescriptionLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(enterContactsLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(contactsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(saveButton)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(() -> new UI().setVisible(true));
    }
}