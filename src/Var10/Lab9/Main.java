package Var10.Lab9;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {


    static JFrame jFrame = getJFrame();
    //Переменная счетчик для компоновки частей
    static int numb_rows_panel = 2;

    //Создаем вкладки
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();

    //Создаем меню бар
    static JMenuBar jMenuBar = new JMenuBar();

    //Создаем несколько подменю для начального экрана
    static JMenu jMenuFile = new JMenu("File");
    static JMenuItem jMenuItemNew = new JMenuItem("New");;
    static JMenuItem jMenuItemOpen = new JMenuItem("Open");
    static JMenuItem jMenuItemSave = new JMenuItem("Save");

    //Переменная для хранения экземпляра класса
    static Bank bank;

    //Создаем панель закладок
    static JTabbedPane jTabbedPane = new JTabbedPane();

    public static void main(String[] args) {

        //Вызываем метод отображения начального окна
        start();

        //Создаем слушатель для подменю создания нового файла
        jMenuItemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Текстовое поле
                JTextField jTextField = new JTextField();

                //Массив компонент
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Bank name: "),
                        jTextField
                };

                //Вызываем диалог для ввода данных
                int result = JOptionPane.showConfirmDialog(null, inputs, "Creating bank", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    //Когда пользователь нажал окей
                    //Создаем новый банк и присваеваем его текущему
                    bank = new Bank(jTextField.getText());
                    //Устанавливаем название окна
                    jFrame.setTitle(jTextField.getText());
                    //Вызываем метод отображения остальных частей из пред. лабы
                    show();
                }

            }
        });

        //Создаем слушатель для подменю "сохранить"
        jMenuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Создаем элемент jFileChooser для возможности выбора пути к файлу
                JFileChooser jFileChooser = new JFileChooser();

                //Вызываем диалог сохранения
                int i = jFileChooser.showSaveDialog(null);
                if(i == JFileChooser.APPROVE_OPTION){
                    //если пользователь нажал "ок"
                    //Получаем путь выбранные пользователем и записываем его в переменную добавляя в конец разрешение файла
                    String filepath = jFileChooser.getSelectedFile().getPath() + ".xml";
                    //Сохраняем наш банк вызывая метод
                    saveBank(filepath,bank);
                }
            }
        });

        //Создаем слушатель для подменю "open"
        jMenuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ////Создаем элемент jFileChooser для возможности выбора пути
                JFileChooser jFileChooser = new JFileChooser("C:\\Users\\dania\\IdeaProjects\\KATA\\src\\Labs\\Var2\\Lab9");
                //Вызываем диалоговое окно для открытия файла
                int i = jFileChooser.showOpenDialog(null);
                if(i == JFileChooser.APPROVE_OPTION){
                    //Получаем путь к файлу
                    String filepath = jFileChooser.getSelectedFile().getPath() ;
                    //Вызываем метод чтения и полученный банк присваиваем нашей переменной
                    bank = getBank(filepath);
                    //Меняем заголовок окна
                    jFrame.setTitle(bank.getName());
                    show();
                }
            }
        });

    }




    //Два наших метода для сериализации из лабы 6
    public static Bank getBank(String fileName) {
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fileName))){
            return (Bank) xmlDecoder.readObject();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void saveBank(String fileName, Bank saveBank){
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName))){
            xmlEncoder.writeObject(saveBank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //тело main из предыдущей лабы вынесено в этот метод
    static void show(){
        //Очищаем меню бар, чтобы избежать наслаивания
        jMenuBar.removeAll();

        //Снова выводим начальные элементы, так как меню было очищено
        start();

        //Прикрепляем панель к окну
        jFrame.add(jTabbedPane);
        //Прикрепляем вкладки к панели
        jTabbedPane.add(jPanel, "ATM`s");
        jTabbedPane.add(jPanel1, "Info about account");

        //Вызываем метод отображения панели со счетами
        setJPanelAccount(bank);
        //Вызываем метод отображения панели с банкоматами
        setJPanelATM(bank);

        //Прикрепляем меню бар к окну
        jFrame.setJMenuBar(jMenuBar);

        //Инициализируем меню
        JMenu jMenu = new JMenu("Create");

        //Создаем вкладки подменю
        JMenuItem jMenuItem = new JMenuItem("Account");
        JMenuItem jMenuItem2 = new JMenuItem("ATM");

        //Прикрепляем подменю к меню
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        //Прикрепляем меню к меню бар
        jMenuBar.add(jMenu);

        //Создаем слушатель для подменю
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Создаем три поля для ввода данных
                JTextField jTextField = new JTextField();
                JTextField jTextField1 = new JTextField();
                JTextField jTextField2 = new JTextField();

                //Создаем радио кнопки (переключатели)
                JRadioButton jRadioButton = new JRadioButton("Usual");
                JRadioButton jRadioButton1 = new JRadioButton("Preferential");

                //Объединяем кнопки в группу
                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(jRadioButton);
                buttonGroup.add(jRadioButton1);

                //Объединяем в массив компонент для передачи диалоговому окну
                //И сразу подписываем поля
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("ID"),
                        jTextField,
                        new JLabel("Pin-code"),
                        jTextField1,
                        new JLabel("Balance"),
                        jTextField2,
                        new JLabel("Type"),
                        jRadioButton,
                        jRadioButton1
                };

                int result = JOptionPane.showConfirmDialog(null, inputs, "Creating account", JOptionPane.OK_CANCEL_OPTION);
                if(result ==0) {
                    if (jRadioButton.isSelected()) {
                        //Если выбран обычный счет создаем соответствующий счет
                        //Передавая в конструктор значения из текстовых полей
                        Account account =
                                new UsualAccount(jTextField.getText(),
                                        jTextField1.getText(),Integer.parseInt(jTextField2.getText()));

                        //Добавляем в наш банк новый счет
                        bank.addAccount(account);

                    }else{

                        //Если выбран льготный счет создаем соответствующий счет
                        //Передавая в конструктор значения из текстовых полей

                        Account account = new PreferentialAccount(jTextField.getText(),
                                jTextField1.getText(),Integer.parseInt(jTextField2.getText()));


                        //Добавляем в наш банк новый счет
                        bank.addAccount(account);
                    }

                    //Вызываем метод отображения панели со счетами
                    setJPanelAccount(bank);
                    //Вызываем метод отображения панели с банкоматами
                    setJPanelATM(bank);
                }
            }
        });

        //Создаем слушатель для подменю
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Создаем текстовое поле ввода
                JTextField jTextField = new JTextField();
                JTextField jTextField1 = new JTextField();

                //Собираем все в массив компонент и подписываем
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("ID"),
                        jTextField,
                        new JLabel("Address"),
                        jTextField1
                };

                //Аналогично предыдущему слушателю вызываем диалоговое окно
                int result = JOptionPane.showConfirmDialog(null, inputs, "Creating ATM", JOptionPane.OK_CANCEL_OPTION);
                if(result == 0){

                    //Создаем банкомат, получая значения текстовых полей, и передаем их в конструктор
                    ATM atm = new ATM(Integer.parseInt(jTextField.getText()), jTextField1.getText());

                    bank.addATM(atm);


                    //Снова собираем наши панели после обновления информации
                    setJPanelAccount(bank);
                    setJPanelATM(bank);
                    //И компонуем
                    jFrame.pack();
                }
            }
        });

    }

    //Метод для отображения стартовых элементов
    static void start(){
        //прикрепляем начальный пункт меню для возможности создать, открыть или сохранить файл
        jMenuFile.add(jMenuItemNew);
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jMenuItemSave);
        jMenuBar.add(jMenuFile);
        jFrame.setJMenuBar(jMenuBar);
    }

    //Вывод вкладки с информацией о счетах
    static void setJPanelAccount(Bank bank){
        //очищаем от предыдущих, чтобы не наслаивалось
        jPanel1.removeAll();


        //Создаем лист моделей для передачи в jlist
        DefaultListModel<Account> defaultListModel = new DefaultListModel<>();
        //Копируем туда список счетов
        defaultListModel.addAll(bank.getAccountList());

        //Создаем Jlist (список) для вывода на панель
        JList<Account> jList = new JList<>(defaultListModel);
        //Добавляем список на панель
        jPanel1.add(jList);

        //Создаем кнопку снять со счета
        JButton jButton = new JButton("Withdraw");

        //Создаем слушатель для кнопки
        //Сам слушатель реализуем в анонимном классе
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Получаем выбранный пользователем счет из списка
                Account account = jList.getSelectedValue();

                //Создаем текстовое поле ввода
                JTextField jTextField = new JTextField();
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Enter the debit amount"),
                        jTextField
                };

                //Выводим диалоговое окно
                int result = JOptionPane.showConfirmDialog(null, inputs, "Withdrawing", JOptionPane.OK_CANCEL_OPTION);

                //Проверяем результат вызова диалогова окна
                if(result == 0){
                    //Вызываем соответсвующий метод для счета
                    account.Withdraw_from_the_account(Integer.parseInt(jTextField.getText()));
                }

            }
        });

        //добавляем кнопку на панель
        jPanel1.add(jButton);

    }

    //Вывод вкладки с информацией о банкоматах
    static void setJPanelATM(Bank bank) {
        //очищаем панель
        jPanel.removeAll();

        //Изменяем переменную, отвечающую за компоновку на панели
        numb_rows_panel = bank.getAtmList().size();
        //устанавливаем сетку
        jPanel.setLayout(new GridLayout(numb_rows_panel, 2));


        for (ATM atm : bank.getAtmList()) {
            //Создаем надпись (лейбл) с номером банкомата
            JLabel jLabel = new JLabel(String.valueOf(atm.getID()));

            //Создаем поле с адресом банкомата
            JTextField jTextField = new JTextField(atm.getAddress());
            jPanel.add(jLabel);
            jPanel.add(jTextField);
        }
    }

    //Получение фрейма(Рабочей области)
    private static JFrame getJFrame() {
        //Создание фрейма
        JFrame jFrame = new JFrame() {};
        //Делаем его видимым
        jFrame.setVisible(true);
        //Создаем возможность закрыть окно
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Получаем инструменты необходимые для работы с экраном(разрешением)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Получаем разрешения экрана
        Dimension dimension = toolkit.getScreenSize();
        //Устанавливаем границы окна
        jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 500);
        //Задаем названия окна
        jFrame.setTitle("My app");
        return jFrame;
    }



}


