/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4121ShinseiRirekiJohoUketsukeDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請届出情報のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public class DbT4121ShinseiRirekiJohoManager {

    private final DbT4121ShinseiRirekiJohoUketsukeDac dac;

    /**
     * コンストラクタです。
     */
    public DbT4121ShinseiRirekiJohoManager() {
        dac = InstanceProvider.create(DbT4121ShinseiRirekiJohoUketsukeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4121ShinseiRirekiJohoUketsukeDac}
     */
    DbT4121ShinseiRirekiJohoManager(DbT4121ShinseiRirekiJohoUketsukeDac dac) {
        this.dac = dac;
    }

    /**
     * 申請履歴情報{@link ShinseiRirekiJoho}を保存します。
     *
     * @param 申請履歴情報 {@link ShinseiRirekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請履歴情報(DbT4121ShinseiRirekiJoho 申請履歴情報) {
        requireNonNull(申請履歴情報, UrSystemErrorMessages.値がnull.getReplacedMessage("申請履歴情報"));
        if (!申請履歴情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(申請履歴情報.toEntity());
    }

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @return 申請履歴情報
     */
    public DbT4121ShinseiRirekiJoho get申請履歴情報ByKey(ShinseishoKanriNo 申請管理番号) {
        DbT4121ShinseiRirekiJohoEntity entity = dac.selectByKey(申請管理番号);
        if (entity == null) {
            return null;
        }
        return new DbT4121ShinseiRirekiJoho(entity);
    }
}
