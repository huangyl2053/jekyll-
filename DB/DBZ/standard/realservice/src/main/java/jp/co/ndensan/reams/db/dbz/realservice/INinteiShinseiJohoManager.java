/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定申請者情報マネージャーのインターフェースです。
 *
 * @author N8235 船山 洋介
 */
public interface INinteiShinseiJohoManager {

    /**
     * 指定の申請書管理番号に該当する{@link INinteiShinseiJoho 認定申請情報}を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報
     */
    Optional<INinteiShinseiJoho> find認定申請情報(ShinseishoKanriNo 申請書管理番号);

    /**
     * {@link INinteiShinseiJoho 認定申請情報}の一覧を返します。
     *
     * @return 認定申請情報
     */
    IItemList<INinteiShinseiJoho> find認定申請情報();

    /**
     * 認定申請情報を登録します。
     *
     * @param 認定申請情報 IRenrakusakiJoho
     * @return 登録件数
     */
    int save認定申請情報(INinteiShinseiJoho 認定申請情報);
}
