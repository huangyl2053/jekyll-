/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhoShikakuInfo;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7123KokuhoShikakuInfoDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7123KokuhoShikakuInfoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保資格詳細情報を管理するクラスです。
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class KokuhoShikakuInfoManager {

    private final DbT7123KokuhoShikakuInfoDac dac;
    private static final RString 国保資格詳細情報 = new RString("国保資格詳細情報");

    /**
     * コンストラクタです。
     */
    public KokuhoShikakuInfoManager() {
        dac = InstanceProvider.create(DbT7123KokuhoShikakuInfoDac.class);
    }

    /**
     * 国保資格詳細情報のビジネスを生成します。
     *
     * @return 認定延期通知発行のビジネス
     */
    public static KokuhoShikakuInfoManager createInstance() {
        return InstanceProvider.create(KokuhoShikakuInfoManager.class);
    }

    /**
     * 主キーに合致する国保資格詳細情報を管理サービスコードを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return SogoJigyoServiceCode
     */
    @Transaction
    public KokuhoShikakuInfo get国保資格詳細情報(
            ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード.toString()));
        DbT7123KokuhoShikakuInfoEntity entity = dac.selectByKey(識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KokuhoShikakuInfo(entity);
    }

    /**
     * 国保資格詳細情報{@link kokuhoShikakuInfo}を保存します。
     *
     * @param kokuhoShikakuInfo {@link kokuhoShikakuInfo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save国保資格詳細情報(KokuhoShikakuInfo kokuhoShikakuInfo) {
        requireNonNull(kokuhoShikakuInfo, UrSystemErrorMessages.値がnull.getReplacedMessage(国保資格詳細情報.toString()));
        return 1 == dac.save(kokuhoShikakuInfo.toEntity());
    }

}
