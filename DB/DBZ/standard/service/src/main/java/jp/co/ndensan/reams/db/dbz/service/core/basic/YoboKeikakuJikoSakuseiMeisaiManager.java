/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisai;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成明細を管理するクラスです。
 */
public class YoboKeikakuJikoSakuseiMeisaiManager {

    private final DbT3011YoboKeikakuJikoSakuseiMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public YoboKeikakuJikoSakuseiMeisaiManager() {
        dac = InstanceProvider.create(DbT3011YoboKeikakuJikoSakuseiMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3011YoboKeikakuJikoSakuseiMeisaiDac}
     */
    YoboKeikakuJikoSakuseiMeisaiManager(DbT3011YoboKeikakuJikoSakuseiMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する予防給付計画自己作成明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @param 居宅サービス区分 KyotakuServiceKubun
     * @param サービス提供事業者番号 ServiceTeikyoJigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @return YoboKeikakuJikoSakuseiMeisai
     */
    @Transaction
    public YoboKeikakuJikoSakuseiMeisai get予防給付計画自己作成明細(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));

//        DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = dac.selectByKey(
//                被保険者番号,
//                対象年月,
//                履歴番号,
//                居宅サービス区分,
//                サービス提供事業者番号,
//                サービス種類コード,
//                サービス項目コード);
//        if (entity == null) {
//            return null;
//        }
//        entity.initializeMd5();
        return new YoboKeikakuJikoSakuseiMeisai(new DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity());
    }

    /**
     * 予防給付計画自己作成明細を全件返します。
     *
     * @return List<YoboKeikakuJikoSakuseiMeisai>
     */
    @Transaction
    public List<YoboKeikakuJikoSakuseiMeisai> get予防給付計画自己作成明細一覧() {
        List<YoboKeikakuJikoSakuseiMeisai> businessList = new ArrayList<>();

//        for (DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity : dac.selectAll()) {
//            entity.initializeMd5();
//            businessList.add(new YoboKeikakuJikoSakuseiMeisai(entity));
//        }

        return businessList;
    }

    /**
     * 予防給付計画自己作成明細{@link YoboKeikakuJikoSakuseiMeisai}を保存します。
     *
     * @param 予防給付計画自己作成明細 {@link YoboKeikakuJikoSakuseiMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save予防給付計画自己作成明細(YoboKeikakuJikoSakuseiMeisai 予防給付計画自己作成明細) {
        requireNonNull(予防給付計画自己作成明細, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成明細"));
        if (!予防給付計画自己作成明細.hasChanged()) {
            return false;
        }
//        return 1 == dac.save(予防給付計画自己作成明細.toEntity());
         return false;
    }
}
