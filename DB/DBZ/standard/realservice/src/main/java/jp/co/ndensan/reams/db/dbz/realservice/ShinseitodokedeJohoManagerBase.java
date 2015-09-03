/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 申請届出情報を取得するクラスです。
 *
 * @author n8223 朴義一
 */
public abstract class ShinseitodokedeJohoManagerBase implements IShinseitodokedeJohoManager {

    @Override
    public abstract ItemList<IShinseitodokedeJoho> find申請届出者情報();

    @Override
    public abstract Optional<IShinseitodokedeJoho> find申請届出者情報(ShinseishoKanriNo 申請管理番号);

    @Override
    public abstract int save申請届出者情報(IShinseitodokedeJoho 申請届出者);
}
