/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.tsuchishohakkojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tsuchishohakkojoho.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5122TsuchishoHakkoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 通知書発行情報を管理するクラスです。
 */
public class TsuchishoHakkoJohoManager {

    private final DbT5122TsuchishoHakkoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public TsuchishoHakkoJohoManager() {
        dac = InstanceProvider.create(DbT5122TsuchishoHakkoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5122TsuchishoHakkoJohoDac}
     */
    TsuchishoHakkoJohoManager(DbT5122TsuchishoHakkoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 通知書発行情報{@link TsuchishoHakkoJoho}を保存します。
     *
     * @param 通知書発行情報 {@link TsuchishoHakkoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save通知書発行情報(TsuchishoHakkoJoho 通知書発行情報) {
        requireNonNull(通知書発行情報, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書発行情報"));
        if (!通知書発行情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(通知書発行情報.toEntity());
    }
}
