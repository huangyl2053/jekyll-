/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定における、日常生活自立度の組み合わせについての情報を持つクラスです。<br/>
 * このクラスは、障害高齢者と認知症高齢者の日常生活自立度を組み合わせた場合に、どの要介護度に、<br/>
 * どの程度の割合でなりそうかの情報を、数値で保持しています。<br/>
 * 認定ソフト2006の際に使用された指標になります。
 *
 * <pre>例）
 * 自立...0
 * 要支援...10
 * 要介護1...20
 * 要介護2...30
 * 要介護3...30
 * 要介護4...10
 * 要介護5...0
 * 割合なので合計は100になる。
 * </pre>
 *
 * @author n8178 城間篤人
 */
public class NichijoSeikatsuJiritsudoKumiawase {

    private final int 自立;
    private final int 要支援;
    private final int 要介護1;
    private final int 要介護2;
    private final int 要介護3;
    private final int 要介護4;
    private final int 要介護5;

    /**
     * 引数から日常生活自立度組み合わせを構成する割合を受け取り、インスタンスを生成します。
     *
     * @param 自立 自立
     * @param 要支援 要支援
     * @param 要介護1 要介護1
     * @param 要介護2 要介護2
     * @param 要介護3 要介護3
     * @param 要介護4 要介護4
     * @param 要介護5 要介護5
     * @throws IllegalArgumentException 0より小さい数字が渡された場合
     */
    public NichijoSeikatsuJiritsudoKumiawase(int 自立, int 要支援, int 要介護1, int 要介護2,
            int 要介護3, int 要介護4, int 要介護5) throws IllegalArgumentException {
        RString エラーメッセージ = new RString("0以上");
        check0以下(自立, Messages.E00013.replace("自立", エラーメッセージ.toString()).getMessage());
        check0以下(要支援, Messages.E00013.replace("要支援", エラーメッセージ.toString()).getMessage());
        check0以下(要介護1, Messages.E00013.replace("要介護1", エラーメッセージ.toString()).getMessage());
        check0以下(要介護2, Messages.E00013.replace("要介護2", エラーメッセージ.toString()).getMessage());
        check0以下(要介護3, Messages.E00013.replace("要介護3", エラーメッセージ.toString()).getMessage());
        check0以下(要介護4, Messages.E00013.replace("要介護4", エラーメッセージ.toString()).getMessage());
        check0以下(要介護5, Messages.E00013.replace("要介護5", エラーメッセージ.toString()).getMessage());

        this.自立 = 自立;
        this.要支援 = 要支援;
        this.要介護1 = 要介護1;
        this.要介護2 = 要介護2;
        this.要介護3 = 要介護3;
        this.要介護4 = 要介護4;
        this.要介護5 = 要介護5;
    }

    private int check0以下(int check対象, String エラーメッセージ) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラーメッセージ);
        }
        return check対象;
    }

    /**
     * 日常生活自立度組み合わせにおける、自立の割合を返します。
     *
     * @return 自立の割合
     */
    public int get自立() {
        return 自立;
    }

    /**
     * 日常生活自立度組み合わせにおける、要支援の割合を返します。
     *
     * @return 要支援の割合
     */
    public int get要支援() {
        return 要支援;
    }

    /**
     * 日常生活自立度組み合わせにおける、要介護1の割合を返します。
     *
     * @return 要介護1の割合
     */
    public int get要介護1() {
        return 要介護1;
    }

    /**
     * 日常生活自立度組み合わせにおける、要介護2の割合を返します。
     *
     * @return 要介護2の割合
     */
    public int get要介護2() {
        return 要介護2;
    }

    /**
     * 日常生活自立度組み合わせにおける、要介護3の割合を返します。
     *
     * @return 要介護3の割合
     */
    public int get要介護3() {
        return 要介護3;
    }

    /**
     * 日常生活自立度組み合わせにおける、要介護4の割合を返します。
     *
     * @return 要介護4の割合
     */
    public int get要介護4() {
        return 要介護4;
    }

    /**
     * 日常生活自立度組み合わせにおける、要介護5の割合を返します。
     *
     * @return 要介護5の割合
     */
    public int get要介護5() {
        return 要介護5;
    }
}
