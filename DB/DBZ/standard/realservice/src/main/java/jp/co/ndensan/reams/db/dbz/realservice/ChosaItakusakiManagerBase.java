/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 調査委託先情報を取得するクラスです。
 *
 * @author n8223　朴義一
 */
public abstract class ChosaItakusakiManagerBase implements IChosaItakusakiManager {

    /**
     * 調査委託先情報を取得します。
     *
     * @return 調査委託先情報
     */
    @Override
    public abstract ItemList<INinteichosaItakusakiJoho> find調査委託先情報();

    /**
     * 調査委託先情報を取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 認定調査委託先コード ChosaItakusakiCode
     * @return 調査委託先情報
     */
    @Override
    public abstract Optional<INinteichosaItakusakiJoho> find調査委託先情報(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード);

    /**
     * 調査委託先情報を更新します。
     *
     * @param 調査委託先情報 INinteichosaItakusakiJoho
     * @return　更新件数
     */
    @Override
    public abstract int save調査委託先(INinteichosaItakusakiJoho 調査委託先情報);

}
