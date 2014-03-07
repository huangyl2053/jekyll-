/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResult {

    private final NinteichosaResultOfGaikyo 概況調査結果;
    private final NinteichosaResultOfKihon 基本調査結果;

    /**
     * インスタンスを生成します。
     *
     * @param 概況調査結果 概況調査結果
     * @param 基本調査結果 基本調査結果
     */
    public NinteichosaResult(NinteichosaResultOfGaikyo 概況調査結果, NinteichosaResultOfKihon 基本調査結果) {
        this.概況調査結果 = requireNonNull(概況調査結果, Messages.E00001.replace("概況調査結果").getMessage());
        this.基本調査結果 = requireNonNull(基本調査結果, Messages.E00001.replace("基本調査結果").getMessage());
    }

    /**
     * 概況調査結果を返します。
     *
     * @return 概況調査結果
     */
    public NinteichosaResultOfGaikyo get概況調査結果() {
        return 概況調査結果;
    }

    /**
     * 基本調査結果を返します。
     *
     * @return 基本調査結果
     */
    public NinteichosaResultOfKihon get基本調査結果() {
        return 基本調査結果;
    }
}
