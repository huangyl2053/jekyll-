/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.IShujiiIryokikanJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関マネージャーのベースクラスです。
 *
 * @author N8235 船山 洋介
 */
public abstract class ShujiiIryokikanManagerBase implements IShujiiIryokikanManager {

    @Override
    public abstract ItemList<IShujiiIryokikanJoho> getAll主治医医療機関();

    @Override
    public abstract Optional<IShujiiIryokikanJoho> find主治医医療機関(LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード);

}
