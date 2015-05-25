/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給(DBD)の要介護認定申請情報を管理するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class HokenshaNinteiShinseiJohoManager extends NinteiShinseiJohoManagerBase {

    private DbT4101NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    HokenshaNinteiShinseiJohoManager() {
        this.dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 保険者認定申請情報Dac
     */
    HokenshaNinteiShinseiJohoManager(DbT4101NinteiShinseiJohoDac dac) {
        this.dac = dac;
    }

    @Override
    public Optional<INinteiShinseiJoho> find認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        return dac.selectByKey(申請書管理番号)
                .map(new IFunction<DbT4101NinteiShinseiJohoEntity, INinteiShinseiJoho>() {
                    @Override
                    public INinteiShinseiJoho apply(DbT4101NinteiShinseiJohoEntity t) {
                        return new HokenshaNinteiShinseiJoho(t);
                    }
                });

    }

    @Override
    public IItemList<INinteiShinseiJoho> find認定申請情報() {
        return dac.selectAll()
                .map(new IFunction<DbT4101NinteiShinseiJohoEntity, INinteiShinseiJoho>() {
                    @Override
                    public INinteiShinseiJoho apply(DbT4101NinteiShinseiJohoEntity t) {
                        return new HokenshaNinteiShinseiJoho(t);
                    }
                });
    }

}
