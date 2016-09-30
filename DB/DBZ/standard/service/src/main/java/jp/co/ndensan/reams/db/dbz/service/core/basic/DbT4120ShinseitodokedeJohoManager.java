/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4120ShinseitodokedeJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請届出情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-013 huangh
 */
public class DbT4120ShinseitodokedeJohoManager {

    private final DbT4120ShinseitodokedeJohoDac dac;

    /**
     * コンストラクタです。
     */
    public DbT4120ShinseitodokedeJohoManager() {
        dac = InstanceProvider.create(DbT4120ShinseitodokedeJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4120ShinseitodokedeJohoDac}
     */
    DbT4120ShinseitodokedeJohoManager(DbT4120ShinseitodokedeJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 受給者台帳を全件返します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return List<JukyushaDaicho>
     */
    @Transaction
    public DbT4120ShinseitodokedeJoho get申請届出情報(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        DbT4120ShinseitodokedeJohoEntity entity = dac.selectByKey(申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();

        return new DbT4120ShinseitodokedeJoho(entity);
    }

    /**
     * 申請届出情報{@link ShinseitodokedeJoho}を保存します。
     *
     * @param 申請届出情報 {@link ShinseitodokedeJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請届出情報(DbT4120ShinseitodokedeJoho 申請届出情報) {
        requireNonNull(申請届出情報, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出情報"));
        if (!申請届出情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(申請届出情報.toEntity());
    }
}
