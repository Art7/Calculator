package main;

/**
 * Created by Artur on 28.04.2015.
 */
public class Main {
    public static void main(String[] args) {
        Model logic = new Model();
        ViewCalculator gui = new ViewCalculator(logic);
        gui.buildGUI();
    }
}
//1) ������ 0 ok
//2) �������� ����� ���������� ������� ��� �������������� �������� ok
//3) ��������� �� ��������� �������  ok
//4) ������� ���������� ��� ������ "." ok
//5) ����� - ������ ���. ��������:  ok
// - ������ � (������ ��������)  ok
// - ������ Backspace  ok
//6) ��������� ���� ������ ok
//7) ���������� ������� ������������ ����������  ok