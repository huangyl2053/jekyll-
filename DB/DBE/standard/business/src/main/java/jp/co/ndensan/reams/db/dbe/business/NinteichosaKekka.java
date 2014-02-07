/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekka {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 要介護認定調査履歴番号;
    private final ChosaKekkaGaikyo 概況情報;
    private final ChosaKekkaKihon 基本情報;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 概況情報 概況情報
     * @param 基本情報 基本情報
     */
    public NinteichosaKekka(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            ChosaKekkaGaikyo 概況情報,
            ChosaKekkaKihon 基本情報) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.要介護認定調査履歴番号 = 要介護認定調査履歴番号;
        this.概況情報 = requireNonNull(概況情報, Messages.E00001.replace("概況情報").getMessage());
        this.基本情報 = requireNonNull(基本情報, Messages.E00001.replace("基本情報").getMessage());
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 要介護認定調査履歴番号を返します。
     *
     * @return 要介護認定調査履歴番号
     */
    public int get要介護認定調査履歴番号() {
        return 要介護認定調査履歴番号;
    }

    /**
     * 要介護認定調査の概況調査情報を返します。
     *
     * @return 概況情報
     */
    public ChosaKekkaGaikyo get概況情報() {
        return 概況情報;
    }

    /**
     * 要介護認定調査の基本調査情報を返します。
     *
     * @return 基本情報
     */
    public ChosaKekkaKihon get基本情報() {
        return 基本情報;
    }
}
