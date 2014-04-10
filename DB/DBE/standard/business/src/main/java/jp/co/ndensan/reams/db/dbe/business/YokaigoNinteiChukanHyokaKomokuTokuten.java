/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定における、要介護認定中間評価項目得点群の情報を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class YokaigoNinteiChukanHyokaKomokuTokuten {

    private final int 第1群;
    private final int 第2群;
    private final int 第3群;
    private final int 第4群;
    private final int 第5群;
    private final int 第6群;
    private final int 第7群;

    /**
     * 中間評価項目得点群を受け取り、インスタンスを生成します。
     *
     * @param 第1群 第1群
     * @param 第2群 第2群
     * @param 第3群 第3群
     * @param 第4群 第4群
     * @param 第5群 第5群
     * @param 第6群 第6群
     * @param 第7群 第7群
     * @throws IllegalArgumentException 引数のいずれかに、0より小さい数値が渡されたとき
     */
    public YokaigoNinteiChukanHyokaKomokuTokuten(int 第1群, int 第2群, int 第3群, int 第4群,
            int 第5群, int 第6群, int 第7群) throws IllegalArgumentException {
        RString エラー表示 = new RString("0以上");
        check0以下(第1群, Messages.E00013.replace("中間評価項目得点第1群", エラー表示.toString()).getMessage());
        check0以下(第2群, Messages.E00013.replace("中間評価項目得点第2群", エラー表示.toString()).getMessage());
        check0以下(第3群, Messages.E00013.replace("中間評価項目得点第3群", エラー表示.toString()).getMessage());
        check0以下(第4群, Messages.E00013.replace("中間評価項目得点第4群", エラー表示.toString()).getMessage());
        check0以下(第5群, Messages.E00013.replace("中間評価項目得点第5群", エラー表示.toString()).getMessage());
        check0以下(第6群, Messages.E00013.replace("中間評価項目得点第6群", エラー表示.toString()).getMessage());
        check0以下(第7群, Messages.E00013.replace("中間評価項目得点第7群", エラー表示.toString()).getMessage());

        this.第1群 = 第1群;
        this.第2群 = 第2群;
        this.第3群 = 第3群;
        this.第4群 = 第4群;
        this.第5群 = 第5群;
        this.第6群 = 第6群;
        this.第7群 = 第7群;
    }

    private int check0以下(int check対象, String エラーメッセージ) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラーメッセージ);
        }
        return check対象;
    }

    /**
     * 第1群を返します。
     *
     * @return 第1群
     */
    public int get第1群() {
        return 第1群;
    }

    /**
     * 第2群を返します。
     *
     * @return 第2群
     */
    public int get第2群() {
        return 第2群;
    }

    /**
     * 第3群を返します。
     *
     * @return 第3群
     */
    public int get第3群() {
        return 第3群;
    }

    /**
     * 第4群を返します。
     *
     * @return 第4群
     */
    public int get第4群() {
        return 第4群;
    }

    /**
     * 第5群を返します。
     *
     * @return 第5群
     */
    public int get第5群() {
        return 第5群;
    }

    /**
     * 第6群を返します。
     *
     * @return 第6群
     */
    public int get第6群() {
        return 第6群;
    }

    /**
     * 第7群を返します。
     *
     * @return 第7群
     */
    public int get第7群() {
        return 第7群;
    }
}
