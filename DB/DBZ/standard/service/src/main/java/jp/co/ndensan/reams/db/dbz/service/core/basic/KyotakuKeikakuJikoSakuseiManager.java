/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成を管理するクラスです。
 */
public class KyotakuKeikakuJikoSakuseiManager {

    private final DbT3007KyotakuKeikakuJikoSakuseiDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJikoSakuseiManager() {
        dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3007KyotakuKeikakuJikoSakuseiDac}
     */
    KyotakuKeikakuJikoSakuseiManager(DbT3007KyotakuKeikakuJikoSakuseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する居宅給付計画自己作成を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return KyotakuKeikakuJikoSakusei
     */
    @Transaction
    public KyotakuKeikakuJikoSakusei get居宅給付計画自己作成(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3007KyotakuKeikakuJikoSakuseiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyotakuKeikakuJikoSakusei(entity);
    }

    /**
     * 居宅給付計画自己作成を全件返します。
     *
     * @return List<KyotakuKeikakuJikoSakusei>
     */
    @Transaction
    public List<KyotakuKeikakuJikoSakusei> get居宅給付計画自己作成一覧() {
        List<KyotakuKeikakuJikoSakusei> businessList = new ArrayList<>();

        for (DbT3007KyotakuKeikakuJikoSakuseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyotakuKeikakuJikoSakusei(entity));
        }

        return businessList;
    }

    /**
     * 居宅給付計画自己作成{@link KyotakuKeikakuJikoSakusei}を保存します。
     *
     * @param 居宅給付計画自己作成 {@link KyotakuKeikakuJikoSakusei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save居宅給付計画自己作成(KyotakuKeikakuJikoSakusei 居宅給付計画自己作成) {
        requireNonNull(居宅給付計画自己作成, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成"));
        if (!居宅給付計画自己作成.hasChanged()) {
            return false;
        }
        return 1 == dac.save(居宅給付計画自己作成.toEntity());
    }
}
