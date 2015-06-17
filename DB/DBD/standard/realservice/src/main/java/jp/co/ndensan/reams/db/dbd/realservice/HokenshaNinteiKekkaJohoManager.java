/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.HokenshaNinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbd.business.INinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.INinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4102HokenshaNinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給(DBD)の要介護認定結果情報を管理するクラスです。
 *
 * @author n8223 朴義一
 */
public class HokenshaNinteiKekkaJohoManager extends NinteiKekkaJohoManagerBase {

    private DbT4102HokenshaNinteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public HokenshaNinteiKekkaJohoManager() {
        this.dac = InstanceProvider.create(DbT4102HokenshaNinteiKekkaJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 要介護認定結果情報dac
     */
    HokenshaNinteiKekkaJohoManager(DbT4102HokenshaNinteiKekkaJohoDac dac) {
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
                .map(new IFunction<DbT4102NinteiKekkaJohoEntity, INinteiKekkaJoho>() {
                    @Override
                    public INinteiKekkaJoho apply(DbT4102NinteiKekkaJohoEntity t) {
                        return new HokenshaNinteiKekkaJoho(t);
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
