/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 申請届出者情報を作成するクラスです。
 *
 * @author n8223
 */
public interface IShinseitodokedeJohoManager {

    /**
     * 申請届出者情報を全件取得します。
     *
     * @return ItemList<IShinseitodokedeJoho>
     */
    ItemList<IShinseitodokedeJoho> find申請届出者情報();

    /**
     * 申請書管理番号に合致する新制度どけでしゃ情報を取得します。
     *
     * @param 申請管理番号 申請書管理番号
     * @return Optional<IShinseitodokedeJoho>
     */
    Optional<IShinseitodokedeJoho> find申請届出者情報(ShinseishoKanriNo 申請管理番号);

    /**
     * 申請届出者情報を登録します。
     *
     * @param 申請届出者 IShinseitodokedeJoho
     * @return 登録件数
     */
    int save申請届出者情報(IShinseitodokedeJoho 申請届出者);

}
