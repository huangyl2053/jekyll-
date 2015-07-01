/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.INinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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

    /**
     * 認定申請情報を登録します。
     *
     * @param 認定申請情報 IRenrakusakiJoho
     * @return 登録件数
     */
    @Override
    public int save認定申請情報(INinteiShinseiJoho 認定申請情報) {
        INinteiShinseiJohoEntity entity = 認定申請情報.getEntity();
        if (認定申請情報.getState() == EntityDataState.Added) {
            return dac.insert(entity);
        } else if (認定申請情報.getState() == EntityDataState.Modified) {
            return dac.update(entity);
        } else if (認定申請情報.getState() == EntityDataState.Deleted) {
            return dac.delete(entity);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }

}
