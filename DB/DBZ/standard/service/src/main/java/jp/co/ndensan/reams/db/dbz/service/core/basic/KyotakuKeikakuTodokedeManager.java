/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出を管理するクラスです。
 */
public class KyotakuKeikakuTodokedeManager {

    private final DbT3005KyotakuKeikakuTodokedeDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuTodokedeManager() {
        dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3005KyotakuKeikakuTodokedeDac}
     */
    KyotakuKeikakuTodokedeManager(DbT3005KyotakuKeikakuTodokedeDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する居宅給付計画届出を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return KyotakuKeikakuTodokede
     */
    @Transaction
    public KyotakuKeikakuTodokede get居宅給付計画届出(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3005KyotakuKeikakuTodokedeEntity entity = dac.selectByKey(
                被保険者番号,
                対象年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyotakuKeikakuTodokede(entity);
    }

    /**
     * 居宅給付計画届出を全件返します。
     *
     * @return List<KyotakuKeikakuTodokede>
     */
    @Transaction
    public List<KyotakuKeikakuTodokede> get居宅給付計画届出一覧() {
        List<KyotakuKeikakuTodokede> businessList = new ArrayList<>();

        for (DbT3005KyotakuKeikakuTodokedeEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyotakuKeikakuTodokede(entity));
        }

        return businessList;
    }

    /**
     * 居宅給付計画届出{@link KyotakuKeikakuTodokede}を保存します。
     *
     * @param 居宅給付計画届出 {@link KyotakuKeikakuTodokede}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save居宅給付計画届出(KyotakuKeikakuTodokede 居宅給付計画届出) {
        requireNonNull(居宅給付計画届出, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画届出"));
        if (!居宅給付計画届出.hasChanged()) {
            return false;
        }
        return 1 == dac.save(居宅給付計画届出.toEntity());
    }
}
