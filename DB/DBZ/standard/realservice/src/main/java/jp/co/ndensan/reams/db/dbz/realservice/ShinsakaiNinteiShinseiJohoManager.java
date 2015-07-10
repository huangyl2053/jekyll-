/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.ShinsakaiNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.INinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定(DBE)の要介護認定申請情報を管理するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShinsakaiNinteiShinseiJohoManager extends NinteiShinseiJohoManagerBase {

    private final DbT5101NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    ShinsakaiNinteiShinseiJohoManager() {
        dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 審査会認定申請情報Dac
     */
    ShinsakaiNinteiShinseiJohoManager(DbT5101NinteiShinseiJohoDac dac) {
        this.dac = dac;
    }

    @Override
    public IItemList<INinteiShinseiJoho> find認定申請情報() {

        return dac.selectAll()
                .map(new IFunction<DbT5101NinteiShinseiJohoEntity, INinteiShinseiJoho>() {
                    @Override
                    public INinteiShinseiJoho apply(DbT5101NinteiShinseiJohoEntity t) {
                        return new ShinsakaiNinteiShinseiJoho(t);
                    }
                });

    }

    @Override
    public Optional<INinteiShinseiJoho> find認定申請情報(ShinseishoKanriNo 申請書管理番号) {

        return dac.selectByKey(申請書管理番号)
                .map(new IFunction<DbT5101NinteiShinseiJohoEntity, INinteiShinseiJoho>() {
                    @Override
                    public INinteiShinseiJoho apply(DbT5101NinteiShinseiJohoEntity t) {
                        return new ShinsakaiNinteiShinseiJoho(t);
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
