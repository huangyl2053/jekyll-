/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoikiGaijiHenkanErrorLog;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7034KoikiGaijiHenkanErrorLogDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域外字変換エラーログを管理するクラスです。
 */
public class KoikiGaijiHenkanErrorLogManager {

    private final DbT7034KoikiGaijiHenkanErrorLogDac dac;

    /**
     * コンストラクタです。
     */
    public KoikiGaijiHenkanErrorLogManager() {
        dac = InstanceProvider.create(DbT7034KoikiGaijiHenkanErrorLogDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7034KoikiGaijiHenkanErrorLogDac}
     */
    KoikiGaijiHenkanErrorLogManager(DbT7034KoikiGaijiHenkanErrorLogDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する広域外字変換エラーログを返します。
     *
     * @param 処理番号 ShoriNo
     * @param 連番 RenNo
     * @param エラー表示連番 ErrorHyojiRenban
     * @return KoikiGaijiHenkanErrorLog
     */
    @Transaction
    public KoikiGaijiHenkanErrorLog get広域外字変換エラーログ(
            RString 処理番号,
            RString 連番,
            RString エラー表示連番) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(エラー表示連番, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示連番"));

        DbT7034KoikiGaijiHenkanErrorLogEntity entity = dac.selectByKey(
                処理番号,
                連番,
                エラー表示連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KoikiGaijiHenkanErrorLog(entity);
    }

    /**
     * 広域外字変換エラーログを全件返します。
     *
     * @return List<KoikiGaijiHenkanErrorLog>
     */
    @Transaction
    public List<KoikiGaijiHenkanErrorLog> get広域外字変換エラーログ一覧() {
        List<KoikiGaijiHenkanErrorLog> businessList = new ArrayList<>();

        for (DbT7034KoikiGaijiHenkanErrorLogEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KoikiGaijiHenkanErrorLog(entity));
        }

        return businessList;
    }

    /**
     * 広域外字変換エラーログ{@link KoikiGaijiHenkanErrorLog}を保存します。
     *
     * @param 広域外字変換エラーログ {@link KoikiGaijiHenkanErrorLog}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save広域外字変換エラーログ(KoikiGaijiHenkanErrorLog 広域外字変換エラーログ) {
        requireNonNull(広域外字変換エラーログ, UrSystemErrorMessages.値がnull.getReplacedMessage("広域外字変換エラーログ"));
        if (!広域外字変換エラーログ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(広域外字変換エラーログ.toEntity());
    }
}
