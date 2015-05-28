/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 調査委託先に関する情報を取得するクラスです。
 *
 * @author n8223　朴義一
 */
public interface IChosaItakusakiManager {

    /**
     * 調査委託先情報を取得します。
     *
     * @return 調査委託先情報(全件)
     */
    ItemList<INinteichosaItakusakiJoho> find調査委託先情報();

    /**
     * 調査委託先情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 調査委託先情報(1件）
     */
    Optional<INinteichosaItakusakiJoho> find調査委託先情報(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード);
}
