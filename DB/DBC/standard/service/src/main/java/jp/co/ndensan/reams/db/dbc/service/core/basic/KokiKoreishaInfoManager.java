/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokiKoreishaInfo;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7124KokiKoreishaInfoDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * KokiKoreishaInfoを管理するクラスです。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class KokiKoreishaInfoManager {

    private final DbT7124KokiKoreishaInfoDac dac;

    /**
     * コンストラクタです。
     */
    public KokiKoreishaInfoManager() {
        dac = InstanceProvider.create(DbT7124KokiKoreishaInfoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dac {@link DbT7124KokiKoreishaInfoDac}
     */
    KokiKoreishaInfoManager(DbT7124KokiKoreishaInfoDac dac) {
        this.dac = dac;
    }

    /**
     * 後期高齢者情報を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return KokiKoreishaInfo
     */
    @Transaction
    public KokiKoreishaInfo get後期高齢者情報(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbT7124KokiKoreishaInfoEntity entity = dac.selectByKey(識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KokiKoreishaInfo(entity);
    }

    /**
     * 後期高齢者情報を保存します。
     *
     * @param 後期高齢者情報 KokiKoreishaInfo
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save後期高齢者情報(KokiKoreishaInfo 後期高齢者情報) {
        requireNonNull(後期高齢者情報, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者情報"));
        return 1 == dac.save(後期高齢者情報.toEntity());
    }
}
