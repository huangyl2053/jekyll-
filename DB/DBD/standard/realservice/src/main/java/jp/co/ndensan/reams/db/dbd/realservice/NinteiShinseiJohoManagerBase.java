/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定申請情報のベースクラスです。
 *
 * @author N8235 船山 洋介
 */
public abstract class NinteiShinseiJohoManagerBase implements INinteiShinseiJohoManager {

    @Override
    public abstract Optional<INinteiShinseiJoho> find認定申請情報(ShinseishoKanriNo 申請書管理番号);

    @Override
    public abstract IItemList<INinteiShinseiJoho> find認定申請情報();

    @Override
    public abstract int save認定申請情報(INinteiShinseiJoho 認定申請情報);

}
