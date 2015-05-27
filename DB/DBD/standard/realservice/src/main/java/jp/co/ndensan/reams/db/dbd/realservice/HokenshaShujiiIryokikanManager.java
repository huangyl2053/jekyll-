/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.HokenshaShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbd.business.IShujiiIryokikanJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定用(DBE)の主治医医療機関を管理するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class HokenshaShujiiIryokikanManager extends ShujiiIryokikanManagerBase {

    private final DbT4911ShujiiIryoKikanJohoDac dac;

    /**
     * コンストラクタです。
     */
    public HokenshaShujiiIryokikanManager() {
        this.dac = InstanceProvider.create(DbT4911ShujiiIryoKikanJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     */
    HokenshaShujiiIryokikanManager(DbT4911ShujiiIryoKikanJohoDac dac) {
        this.dac = dac;
    }

    @Override
    public Optional<IShujiiIryokikanJoho> find主治医医療機関(LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード) {
        return dac.selectByKey(市町村コード, 主治医医療機関コード)
                .map(new IFunction<DbT4911ShujiiIryoKikanJohoEntity, IShujiiIryokikanJoho>() {
                    @Override
                    public IShujiiIryokikanJoho apply(DbT4911ShujiiIryoKikanJohoEntity t) {
                        return new HokenshaShujiiIryoKikanJoho(t);
                    }
                });
    }

    @Override
    public ItemList<IShujiiIryokikanJoho> getAll主治医医療機関() {

        return to主治医医療機関List(dac.selectAll());
    }

    private ItemList<IShujiiIryokikanJoho> to主治医医療機関List(ItemList<DbT4911ShujiiIryoKikanJohoEntity> entityList) {

        ItemList<IShujiiIryokikanJoho> hihokenshaShujiiIryoKikanList = ItemList.empty();

        for (DbT4911ShujiiIryoKikanJohoEntity entity : entityList) {
            HokenshaShujiiIryoKikanJoho hihokenshaShujiiIryoKikanJoho = new HokenshaShujiiIryoKikanJoho(entity);
            hihokenshaShujiiIryoKikanList.added(hihokenshaShujiiIryoKikanJoho);
        }

        return hihokenshaShujiiIryoKikanList;
    }
}
