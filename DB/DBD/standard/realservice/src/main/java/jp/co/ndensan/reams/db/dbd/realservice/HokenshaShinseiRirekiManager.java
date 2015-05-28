/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.business.HokenshaShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給(DBD)の申請履歴情報を管理するクラスです。
 *
 * @author n8223　朴義一
 */
public class HokenshaShinseiRirekiManager extends ShinseiRirekiManagerBase {

    private final DbT4121ShinseiRirekiJohoDac dac;

    /**
     * コンストラクタです
     */
    public HokenshaShinseiRirekiManager() {
        this.dac = InstanceProvider.create(DbT4121ShinseiRirekiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 保険者申請履歴情報Dac
     */
    HokenshaShinseiRirekiManager(DbT4121ShinseiRirekiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請履歴情報
     */
    @Override
    public Optional<IShinseiRirekiJoho> find申請履歴情報(ShinseishoKanriNo 申請書管理番号) {
        return dac.selectByKey(申請書管理番号)
                .map(new IFunction<DbT4121ShinseiRirekiJohoEntity, IShinseiRirekiJoho>() {
                    @Override
                    public IShinseiRirekiJoho apply(DbT4121ShinseiRirekiJohoEntity t) {
                        return new HokenshaShinseiRirekiJoho(t);
                    }
                });
    }

}
