/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeika;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeika.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成短期入所利用日数を管理するクラスです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager {

    private final DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager() {
        dac = InstanceProvider.create(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac}
     */
    KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuManager(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する居宅給付計画自己作成短期入所利用日数を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @return KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu
     */
    @Transaction
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu get居宅給付計画自己作成短期入所利用日数(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = dac.selectByKey(
                被保険者番号,
                対象年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity);
    }

    /**
     * 居宅給付計画自己作成短期入所利用日数を全件返します。
     *
     * @return KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuの{@code list}
     */
    @Transaction
    public List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> get居宅給付計画自己作成短期入所利用日数一覧() {
        List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> businessList = new ArrayList<>();

        for (DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(entity));
        }

        return businessList;
    }

    /**
     * 居宅給付計画自己作成短期入所利用日数{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}を保存します。
     *
     * @param 居宅給付計画自己作成短期入所利用日数 {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save居宅給付計画自己作成短期入所利用日数(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅給付計画自己作成短期入所利用日数) {
        requireNonNull(居宅給付計画自己作成短期入所利用日数, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成短期入所利用日数"));
        if (!居宅給付計画自己作成短期入所利用日数.hasChanged()) {
            return false;
        }
        return 1 == dac.save(居宅給付計画自己作成短期入所利用日数.toEntity());
    }

    /**
     * 居宅短期入所情報を削除します。
     *
     * @param 居宅短期入所情報 KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu
     */
    public void delete居宅短期入所情報(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅短期入所情報) {
        if (居宅短期入所情報 != null) {
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = 居宅短期入所情報.toEntity();
            entity.setState(EntityDataState.Deleted);
            dac.delete(entity);
        }
    }

    /**
     * 居宅短期入所情報を更新します。
     *
     * @param 居宅短期入所情報 KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu
     */
    public void update居宅短期入所情報(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu 居宅短期入所情報) {
        if (居宅短期入所情報 != null) {
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = 居宅短期入所情報.toEntity();
            entity.setState(EntityDataState.Modified);
            dac.save(entity);
        }
    }
}
