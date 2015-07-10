/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.ShinsakaiNinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.INinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.INinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5102ShinsakaiNinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定(DBE)の要介護認定結果情報を管理するクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiNinteiKekkaJohoManager extends NinteiKekkaJohoManagerBase {

    private DbT5102ShinsakaiNinteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiNinteiKekkaJohoManager() {
        this.dac = InstanceProvider.create(DbT5102ShinsakaiNinteiKekkaJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 要介護認定結果情報dac
     */
    ShinsakaiNinteiKekkaJohoManager(DbT5102ShinsakaiNinteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 要介護認定結果情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請履歴情報
     */
    @Override
    public Optional<INinteiKekkaJoho> find要介護認定結果情報(ShinseishoKanriNo 申請書管理番号) {
        return dac.selectByKey(申請書管理番号)
                .map(new IFunction<DbT5102NinteiKekkaJohoEntity, INinteiKekkaJoho>() {
                    @Override
                    public INinteiKekkaJoho apply(DbT5102NinteiKekkaJohoEntity t) {
                        return new ShinsakaiNinteiKekkaJoho(t);
                    }
                });
    }

    /**
     * 要介護認定結果情報を登録します。
     *
     * @param 要介護認定結果 要介護認定結果
     * @return 登録件数
     */
    @Override
    public int save要介護認定結果(INinteiKekkaJoho 要介護認定結果) {

        INinteiKekkaJohoEntity entity = 要介護認定結果.getEntity();

        switch (要介護認定結果.getState()) {
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
