/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.IShujiiJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医マネージャーのベースクラスです。
 *
 * @author N8235 船山 洋介
 */
public abstract class ShujiiManagerBase implements IShujiiManager {

    @Override
    public abstract Optional<IShujiiJoho> find主治医(LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード, ShujiiCode 主治医コード);

    @Override
    public abstract ItemList<IShujiiJoho> getAll主治医();

}
