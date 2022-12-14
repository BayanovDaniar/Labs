package Var10.Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    static JFrame jFrame = getJFrame();
    //Переменная счетчик для компоновки частей
    static int numb_rows_panel = 2;

    //Создаем вкладки
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();


    public static void main(String[] args) {
        //получаем банк
        Bank bank = createBank();

        //Создаем панель закладок
        JTabbedPane jTabbedPane = new JTabbedPane();
        //Прикрепляем панель к окну
        jFrame.add(jTabbedPane);
        //Прикрепляем вкладки к панели
        jTabbedPane.add(jPanel, "ATM`s");
        jTabbedPane.add(jPanel1, "Info about account");

        //Вызываем метод отображения панели со счетами
        setJPanelAccount(bank);
        //Вызываем метод отображения панели с банкоматами
        setJPanelATM(bank);


        //Компонуем
        jFrame.pack();
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

                //Объединяем в массив компонент для передачи диалоговому окну
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
        jFrame.pack();

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

    //Создание банка вынесено в метод
    public static Bank createBank(){
        Bank bank = new Bank("Sberbank");

        ATM atm = new ATM(111, "Eliseeva, 12");
        ATM atm1 = new ATM(222, "Usova, 34");
        ATM atm2 = new ATM(333, "Komarova, 4");

        Account account = new UsualAccount("00001", "0000", 12345 );
        Account account1 = new UsualAccount("00002", "1111", 654 );
        Account account2 = new UsualAccount("00003", "2222", 2341 );
        Account account3 = new UsualAccount("00004", "3333", 10345);
        Account account4 = new UsualAccount("00005", "4444", 10554 );
        Account account5 = new UsualAccount("00006", "5555", 123432 );

        Account account6 = new PreferentialAccount("00007", "6666", 2343);
        Account account7 = new PreferentialAccount("00008", "7777", 34543);
        Account account8 = new PreferentialAccount("00009", "8888", 87843);
        Account account9 = new PreferentialAccount("00010", "9999", 5673);


        bank.addATM(atm);
        bank.addATM(atm1);
        bank.addATM(atm2);

        bank.addAccount(account);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        bank.addAccount(account5);
        bank.addAccount(account6);
        bank.addAccount(account7);
        bank.addAccount(account8);
        bank.addAccount(account9);

        return bank;
    }


}


