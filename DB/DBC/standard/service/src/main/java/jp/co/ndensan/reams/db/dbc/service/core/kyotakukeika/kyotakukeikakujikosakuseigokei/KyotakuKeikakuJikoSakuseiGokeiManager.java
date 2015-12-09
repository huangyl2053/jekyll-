/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakujikosakuseigokei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成合計を管理するクラスです。
 */
public class KyotakuKeikakuJikoSakuseiGokeiManager {

    private final DbT3009KyotakuKeikakuJikoSakuseiGokeiDac dac;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJikoSakuseiGokeiManager() {
        dac = InstanceProvider.create(DbT3009KyotakuKeikakuJikoSakuseiGokeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiDac}
     */
    KyotakuKeikakuJikoSakuseiGokeiManager(DbT3009KyotakuKeikakuJikoSakuseiGokeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する居宅給付計画自己作成合計を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @return KyotakuKeikakuJikoSakuseiGokei
     */
    @Transaction
    public KyotakuKeikakuJikoSakuseiGokei get居宅給付計画自己作成合計(
             HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));

        DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年月,
                履歴番号,
                居宅サービス区分,
                サービス提供事業者番号,
                サービス種類コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyotakuKeikakuJikoSakuseiGokei(entity);
    }

    /**
     * 居宅給付計画自己作成合計を全件返します。
     *
     * @return KyotakuKeikakuJikoSakuseiGokeiの{@code list}
     */
    @Transaction
    public List<KyotakuKeikakuJikoSakuseiGokei> get居宅給付計画自己作成合計一覧() {
        List<KyotakuKeikakuJikoSakuseiGokei> businessList = new ArrayList<>();

        for (DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyotakuKeikakuJikoSakuseiGokei(entity));
        }

        return businessList;
    }

    /**
     * 居宅給付計画自己作成合計{@link KyotakuKeikakuJikoSakuseiGokei}を保存します。
     *
     * @param 居宅給付計画自己作成合計 {@link KyotakuKeikakuJikoSakuseiGokei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save居宅給付計画自己作成合計(KyotakuKeikakuJikoSakuseiGokei 居宅給付計画自己作成合計) {
        requireNonNull(居宅給付計画自己作成合計, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成合計"));
        if (!居宅給付計画自己作成合計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(居宅給付計画自己作成合計.toEntity());
    }
}
