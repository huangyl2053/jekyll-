/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果情報（概況調査）を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultGaikyo {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 要介護認定調査履歴番号;
    private final NinteichosaResultGaikyoKihon 基本情報;
    private final NinteichosaResultGaikyoService サービス状況;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 基本情報 基本情報
     * @param サービス状況 サービス状況
     */
    public NinteichosaResultGaikyo(
            ShinseishoKanriNo 申請書管理番号, int 要介護認定調査履歴番号, NinteichosaResultGaikyoKihon 基本情報, NinteichosaResultGaikyoService サービス状況) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.要介護認定調査履歴番号 = 要介護認定調査履歴番号;
        this.基本情報 = requireNonNull(基本情報, Messages.E00001.replace("基本情報").getMessage());
        this.サービス状況 = requireNonNull(サービス状況, Messages.E00001.replace("サービス状況").getMessage());
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
     * 要介護認定調査（概況調査）の基本情報を返します。
     *
     * @return 基本情報
     */
    public NinteichosaResultGaikyoKihon get基本情報() {
        return 基本情報;
    }

    /**
     * 要介護認定調査（概況調査）のサービス状況に関する情報を返します。
     *
     * @return サービス状況
     */
    public NinteichosaResultGaikyoService getサービス状況() {
        return サービス状況;
    }
}
