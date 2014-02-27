/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResult {

    private final NinteichosaResultChosahyo 調査票結果;
    private final NinteichosaResultGaikyo 概況調査結果;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票結果 調査票結果
     * @param 概況調査結果 概況調査結果
     */
    public NinteichosaResult(NinteichosaResultChosahyo 調査票結果, NinteichosaResultGaikyo 概況調査結果) {
        this.調査票結果 = requireNonNull(調査票結果, Messages.E00001.replace("調査票結果").getMessage());
        this.概況調査結果 = requireNonNull(概況調査結果, Messages.E00001.replace("概況調査結果").getMessage());
    }

    /**
     * 調査票結果を返します。
     *
     * @return 調査票結果
     */
    public NinteichosaResultChosahyo get調査票結果() {
        return 調査票結果;
    }

    /**
     * 概況調査結果を返します。
     *
     * @return 概況調査結果
     */
    public NinteichosaResultGaikyo get概況調査結果() {
        return 概況調査結果;
    }
}
