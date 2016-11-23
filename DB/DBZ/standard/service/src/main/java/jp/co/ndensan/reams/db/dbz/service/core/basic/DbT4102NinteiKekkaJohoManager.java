/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author n3213
 */
public class DbT4102NinteiKekkaJohoManager {

    private final DbT4102NinteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public DbT4102NinteiKekkaJohoManager() {
        dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4102NinteiKekkaJohoDac}
     */
    DbT4102NinteiKekkaJohoManager(DbT4102NinteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4102NinteiKekkaJoho
     */
    @Transaction
    public DbT4102NinteiKekkaJoho get要介護認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT4102NinteiKekkaJohoEntity entity = dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DbT4102NinteiKekkaJoho(entity);
    }
}
