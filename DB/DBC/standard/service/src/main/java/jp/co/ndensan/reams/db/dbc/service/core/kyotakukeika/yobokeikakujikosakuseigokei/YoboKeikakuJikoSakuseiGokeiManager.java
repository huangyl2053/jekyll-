/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.yobokeikakujikosakuseigokei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseigokei.YoboKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3012YoboKeikakuJikoSakuseiGokeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成合計を管理するクラスです。
 */
public class YoboKeikakuJikoSakuseiGokeiManager {

    private final DbT3012YoboKeikakuJikoSakuseiGokeiDac dac;

    /**
     * コンストラクタです。
     */
    public YoboKeikakuJikoSakuseiGokeiManager() {
        dac = InstanceProvider.create(DbT3012YoboKeikakuJikoSakuseiGokeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3012YoboKeikakuJikoSakuseiGokeiDac}
     */
    YoboKeikakuJikoSakuseiGokeiManager(DbT3012YoboKeikakuJikoSakuseiGokeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する予防給付計画自己作成合計を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @return YoboKeikakuJikoSakuseiGokei
     */
    @Transaction
    public YoboKeikakuJikoSakuseiGokei get予防給付計画自己作成合計(
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

        DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity = dac.selectByKey(
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
        return new YoboKeikakuJikoSakuseiGokei(entity);
    }

    /**
     * 予防給付計画自己作成合計を全件返します。
     *
     * @return YoboKeikakuJikoSakuseiGokeiの{@code list}
     */
    @Transaction
    public List<YoboKeikakuJikoSakuseiGokei> get予防給付計画自己作成合計一覧() {
        List<YoboKeikakuJikoSakuseiGokei> businessList = new ArrayList<>();

        for (DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new YoboKeikakuJikoSakuseiGokei(entity));
        }

        return businessList;
    }

    /**
     * 予防給付計画自己作成合計{@link YoboKeikakuJikoSakuseiGokei}を保存します。
     *
     * @param 予防給付計画自己作成合計 {@link YoboKeikakuJikoSakuseiGokei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save予防給付計画自己作成合計(YoboKeikakuJikoSakuseiGokei 予防給付計画自己作成合計) {
        requireNonNull(予防給付計画自己作成合計, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成合計"));
        if (!予防給付計画自己作成合計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(予防給付計画自己作成合計.toEntity());
    }
}
