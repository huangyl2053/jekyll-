/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinseirirekijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請履歴情報を管理するクラスです。
 */
public class ShinseiRirekiJohoManager {

    private final DbT5121ShinseiRirekiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinseiRirekiJohoManager() {
        dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5121ShinseiRirekiJohoDac}
     */
    ShinseiRirekiJohoManager(DbT5121ShinseiRirekiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請履歴情報{@link ShinseiRirekiJoho}を保存します。
     *
     * @param 申請履歴情報 {@link ShinseiRirekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請履歴情報(ShinseiRirekiJoho 申請履歴情報) {
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
    public ShinseiRirekiJoho get申請履歴情報ByKey(ShinseishoKanriNo 申請管理番号) {
        DbT5121ShinseiRirekiJohoEntity entity = dac.selectByKey(申請管理番号);
        if (entity == null) {
            return null;
        }
        return new ShinseiRirekiJoho(entity);
    }
}
