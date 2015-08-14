/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.ShinsakaiShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.IShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定(DBE)の申請履歴情報を管理するクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiShinseiRirekiManager extends ShinseiRirekiManagerBase {

    private final DbT5121ShinseiRirekiJohoDac dac;

    /**
     * コンストラクタです
     */
    public ShinsakaiShinseiRirekiManager() {
        this.dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 審査会申請履歴情報Dac
     */
    ShinsakaiShinseiRirekiManager(DbT5121ShinseiRirekiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @return 申請履歴情報
     */
    @Override
    public Optional<IShinseiRirekiJoho> find申請履歴情報(ShinseishoKanriNo 申請管理番号) {
        return dac.selectByKey(申請管理番号)
                .map(new IFunction<DbT5121ShinseiRirekiJohoEntity, IShinseiRirekiJoho>() {
                    @Override
                    public IShinseiRirekiJoho apply(DbT5121ShinseiRirekiJohoEntity t) {
                        return new ShinsakaiShinseiRirekiJoho(t);
                    }
                });
    }

    /**
     * 申請履歴情報を登録します。
     *
     * @param 申請履歴情報 IShinseiRirekiJoho
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save申請履歴(IShinseiRirekiJoho 申請履歴情報) {

        IShinseiRirekiJohoEntity entity = 申請履歴情報.getEntity();

        switch (申請履歴情報.getState()) {
            case Added:
                return dac.insert(entity);
            case Modified:
                return dac.update(entity);
            case Deleted:
                return dac.delete(entity);
            default:
                return 0;
        }
    }

}
