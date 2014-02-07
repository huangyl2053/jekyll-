/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun5;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査第5群）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihon5 {

    private final ChosaKekkaKubun5.Kusuri 薬の内服;
    private final ChosaKekkaKubun5.KinsenKanri 金銭の管理;
    private final ChosaKekkaKubun5.IshiKettei 日常の意思決定;
    private final ChosaKekkaKubun5.ShudanFutekio 集団への不適応;
    private final ChosaKekkaKubun5.Kaimono 買い物;
    private final ChosaKekkaKubun5.Chori 簡単な調理;

    /**
     * インスタンスを生成します。
     *
     * @param 薬の内服 薬の内服
     * @param 金銭の管理 金銭の管理
     * @param 日常の意思決定 日常の意思決定
     * @param 集団への不適応 集団への不適応
     * @param 買い物 買い物
     * @param 簡単な調理 簡単な調理
     */
    public ChosaKekkaKihon5(
            ChosaKekkaKubun5.Kusuri 薬の内服,
            ChosaKekkaKubun5.KinsenKanri 金銭の管理,
            ChosaKekkaKubun5.IshiKettei 日常の意思決定,
            ChosaKekkaKubun5.ShudanFutekio 集団への不適応,
            ChosaKekkaKubun5.Kaimono 買い物,
            ChosaKekkaKubun5.Chori 簡単な調理) {
        this.薬の内服 = requireNonNull(薬の内服, Messages.E00001.replace("薬の内服").getMessage());
        this.金銭の管理 = requireNonNull(金銭の管理, Messages.E00001.replace("金銭の管理").getMessage());
        this.日常の意思決定 = requireNonNull(日常の意思決定, Messages.E00001.replace("日常の意思決定").getMessage());
        this.集団への不適応 = requireNonNull(集団への不適応, Messages.E00001.replace("集団への不適応").getMessage());
        this.買い物 = requireNonNull(買い物, Messages.E00001.replace("買い物").getMessage());
        this.簡単な調理 = requireNonNull(簡単な調理, Messages.E00001.replace("簡単な調理").getMessage());
    }

    /**
     * 薬の内服を返します。
     *
     * @return 薬の内服
     */
    public ChosaKekkaKubun5.Kusuri get薬の内服() {
        return 薬の内服;
    }

    /**
     * 金銭の管理を返します。
     *
     * @return 金銭の管理
     */
    public ChosaKekkaKubun5.KinsenKanri get金銭の管理() {
        return 金銭の管理;
    }

    /**
     * 日常の意思決定を返します。
     *
     * @return 日常の意思決定
     */
    public ChosaKekkaKubun5.IshiKettei get日常の意思決定() {
        return 日常の意思決定;
    }

    /**
     * 集団への不適応を返します。
     *
     * @return 集団への不適応
     */
    public ChosaKekkaKubun5.ShudanFutekio get集団への不適応() {
        return 集団への不適応;
    }

    /**
     * 買い物を返します。
     *
     * @return 買い物
     */
    public ChosaKekkaKubun5.Kaimono get買い物() {
        return 買い物;
    }

    /**
     * 簡単な調理を返します。
     *
     * @return 簡単な調理
     */
    public ChosaKekkaKubun5.Chori get簡単な調理() {
        return 簡単な調理;
    }
}
