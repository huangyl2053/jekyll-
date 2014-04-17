/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護状態を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
// TODO N8156 宮本 康 申請情報の「前回結果」としても使用する為、「認定の結果」であることが判断できるクラス名を検討する。
public class YokaigoJotai {

    private final YokaigoJotaiKubun 要介護状態区分;
    private final NinteiYukoKikan 認定有効期間;

    /**
     * インスタンスを生成します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 認定有効期間 認定有効期間
     */
    public YokaigoJotai(YokaigoJotaiKubun 要介護状態区分, NinteiYukoKikan 認定有効期間) {
        this.要介護状態区分 = requireNonNull(要介護状態区分, Messages.E00001.replace("要介護状態区分").getMessage());
        this.認定有効期間 = requireNonNull(認定有効期間, Messages.E00001.replace("認定有効期間").getMessage());
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public YokaigoJotaiKubun get要介護状態区分() {
        return 要介護状態区分;
    }

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    public NinteiYukoKikan get認定有効期間() {
        return 認定有効期間;
    }
}
