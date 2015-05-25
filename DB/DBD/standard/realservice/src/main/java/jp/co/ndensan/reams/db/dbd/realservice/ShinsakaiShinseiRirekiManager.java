/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 申請履歴情報を作成するクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiShinseiRirekiManager extends ShinseiRirekiManagerBase {

    private final DbT5121ShinseiRirekiJohoDac dac;

    /**
     * コンストラクタです
     *
     * 申請履歴情報を作成するインターフェースを生成します。
     */
    public ShinsakaiShinseiRirekiManager() {
        this.dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ShinsakaiShinseiRirekiManager(DbT5121ShinseiRirekiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請管理番号
     * @return 申請履歴情報
     */
    public Optional<IShinseiRirekiJoho> find申請履歴情報(ShinseishoKanriNo 申請管理番号) {
        return dac.selectByKey(申請管理番号)
                .map(new IFunction<DbT5121ShinseiRirekiJohoEntity, IShinseiRirekiJoho>() {
                    @Override
                    public IShinseiRirekiJoho apply(DbT5121ShinseiRirekiJohoEntity t) {
                        return new ShinsakaiShinseiRirekiJoho(t);
                    }
                });
    }

}
