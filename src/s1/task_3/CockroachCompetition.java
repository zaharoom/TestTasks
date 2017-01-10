package s1.task_3;

/**
 * Напишите классы реализующие “Тараканьи бега”:
 * - В бегах участвуют несколько тараканов (класс Cockroach), выполняющимися в отдельных потоках.
 * - Тараканы стартуют одновременно по сигналу судьи (класс Judge).
 * - После того как все тараканы закончили бег судья подводит результаты и запускает следующий круг соревнований.
 * Примечания:
 * - Тараканы должны быть “многоразовыми” - поток таракана бежит все этапы а не только один.
 * - Во время проведения результатов тараканы стоят.
 */

public class CockroachCompetition {
    public static void main(String[] args) {
        Judge judge = new Judge();
        //Name of each Cockroach myst be unique. It needs to proper counting total results because names are keys of Map items
        judge.addCockroachToRun("Vasily");
        judge.addCockroachToRun("Vovchik");
        judge.addCockroachToRun("Zahar");
        judge.addCockroachToRun("Eldar");
        judge.addCockroachToRun("Irka");
        judge.addCockroachToRun("Mashka");
        judge.startRun(3);
    }
}
