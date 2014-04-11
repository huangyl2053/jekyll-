/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChukanHyokaKomokuTokutenItemGroup;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 一次判定における、要介護認定中間評価項目得点群の情報を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class YokaigoNinteiChukanHyokaKomokuTokuten {

    private Map<ChukanHyokaKomokuTokutenItemGroup, Integer> 中間評価項目得点群;

    /**
     * 中間評価項目得点群の情報を受け取り、インスタンスを生成します。
     *
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 中間評価項目得点の中に、0より小さい数値が存在したとき
     */
    public YokaigoNinteiChukanHyokaKomokuTokuten(Map<ChukanHyokaKomokuTokutenItemGroup, Integer> 中間評価項目得点群)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(中間評価項目得点群, Messages.E00003.replace("中間評価項目得点群", getClass().getName()).getMessage());

        for (int 得点 : 中間評価項目得点群.values()) {
            check0未満(得点, Messages.E00013.replace("中間評価項目得点群", "全て0以上").getMessage());
        }

        this.中間評価項目得点群 = new EnumMap<>(中間評価項目得点群);
    }

    private int check0未満(int check対象, String エラーメッセージ) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラーメッセージ);
        }
        return check対象;
    }

    /**
     * 中間評価項目得点の項目を指定して、対応する数字を取得します。
     *
     * @param 得点群項目 中間評価項目得点の第何群かを指定
     * @return 指定した得点
     */
    public int get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup 得点群項目) {
        return 中間評価項目得点群.get(得点群項目);
    }
}
