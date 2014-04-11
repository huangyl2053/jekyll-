/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiKijunTimeItemGroup;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 一時判定における、要介護認定等基準時間の情報を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class YokaigoNinteiKijunTime {

    private final Map<YokaigoNinteiKijunTimeItemGroup, Integer> 要介護認定等基準時間;

    /**
     * 要介護認定等基準時間の情報を受け取り、インスタンスを生成します。
     *
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 要介護認定等基準時間の中に、0より小さい数値が存在したとき
     */
    public YokaigoNinteiKijunTime(Map<YokaigoNinteiKijunTimeItemGroup, Integer> 要介護認定等基準時間)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(要介護認定等基準時間, Messages.E00003.replace("要介護認定等基準時間", getClass().getName()).getMessage());

        for (int 得点 : 要介護認定等基準時間.values()) {
            check0未満(得点, Messages.E00013.replace("要介護認定等基準時間", "全て0以上").getMessage());
        }

        this.要介護認定等基準時間 = new EnumMap<>(要介護認定等基準時間);
    }

    private int check0未満(int check対象, String エラーメッセージ) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラーメッセージ);
        }
        return check対象;
    }

    /**
     * 要介護認定等基準時間の項目を指定して、対応する数字を取得します。
     *
     * @param 基準時間項目 要介護認定等基準時間項目
     * @return 指定した基準時間
     */
    public int get基準時間(YokaigoNinteiKijunTimeItemGroup 基準時間項目) {
        return 要介護認定等基準時間.get(基準時間項目);
    }
}
