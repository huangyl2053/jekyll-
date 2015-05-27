/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.IShujiiIryokikanJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給(DBD)用の主治医医療機関を管理するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShinsakaiShujiiIryokikanManager extends ShujiiIryokikanManagerBase {

    private final DbT5911ShujiiIryoKikanJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiShujiiIryokikanManager() {
        this.dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     */
    ShinsakaiShujiiIryokikanManager(DbT5911ShujiiIryoKikanJohoDac dac) {
        this.dac = dac;
    }

    @Override
    public Optional<IShujiiIryokikanJoho> find主治医医療機関(LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード) {

        return dac.selectByKey(市町村コード, 主治医医療機関コード)
                .map(new IFunction<DbT5911ShujiiIryoKikanJohoEntity, IShujiiIryokikanJoho>() {
                    @Override
                    public IShujiiIryokikanJoho apply(DbT5911ShujiiIryoKikanJohoEntity t) {
                        return new ShinsakaiShujiiIryoKikanJoho(t);
                    }
                });
    }

    @Override
    public ItemList<IShujiiIryokikanJoho> getAll主治医医療機関() {

        return to主治医医療機関List(dac.selectAll());
    }

    private ItemList<IShujiiIryokikanJoho> to主治医医療機関List(ItemList<DbT5911ShujiiIryoKikanJohoEntity> entityList) {

        ItemList<IShujiiIryokikanJoho> shujiiIryoKikanJohoList = ItemList.empty();

        for (DbT5911ShujiiIryoKikanJohoEntity entity : entityList) {
            ShinsakaiShujiiIryoKikanJoho shujiiIryoKikanJoho = new ShinsakaiShujiiIryoKikanJoho(entity);
            shujiiIryoKikanJohoList.added(shujiiIryoKikanJoho);
        }

        return shujiiIryoKikanJohoList;
    }

}
