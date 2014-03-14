/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 一次判定における、日常生活自立度の組み合わせについての情報を持つクラスです。
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

    public NichijoSeikatsuJiritsudoKumiawase(int 自立, int 要支援, int 要介護1, int 要介護2,
            int 要介護3, int 要介護4, int 要介護5) throws IllegalArgumentException {
        check0以下(自立, Messages.E00013.replace("自立", "0以上").getMessage());
        check0以下(要支援, Messages.E00013.replace("要支援", "0以上").getMessage());
        check0以下(要介護1, Messages.E00013.replace("要介護1", "0以上").getMessage());
        check0以下(要介護2, Messages.E00013.replace("要介護2", "0以上").getMessage());
        check0以下(要介護3, Messages.E00013.replace("要介護3", "0以上").getMessage());
        check0以下(要介護4, Messages.E00013.replace("要介護4", "0以上").getMessage());
        check0以下(要介護5, Messages.E00013.replace("要介護5", "0以上").getMessage());

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
