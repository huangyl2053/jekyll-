/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（概況調査）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaGaikyo {

    private final ChosaKekkaGaikyoKihon 基本情報;
    private final ChosaKekkaGaikyoService サービス状況;

    /**
     * インスタンスを生成します。
     *
     * @param 基本情報 基本情報
     * @param サービス状況 サービス状況
     */
    public ChosaKekkaGaikyo(
            ChosaKekkaGaikyoKihon 基本情報,
            ChosaKekkaGaikyoService サービス状況) {
        this.基本情報 = requireNonNull(基本情報, Messages.E00001.replace("基本情報").getMessage());
        this.サービス状況 = requireNonNull(サービス状況, Messages.E00001.replace("サービス状況").getMessage());
    }

    /**
     * 要介護認定調査（概況調査）の基本情報を返します。
     *
     * @return 基本情報
     */
    public ChosaKekkaGaikyoKihon get基本情報() {
        return 基本情報;
    }

    /**
     * 要介護認定調査（概況調査）のサービス状況に関する情報を返します。
     *
     * @return サービス状況
     */
    public ChosaKekkaGaikyoService getサービス状況() {
        return サービス状況;
    }
}
