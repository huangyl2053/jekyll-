/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiKyushoMeisai;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3083DaisanshaKoiKyushoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3083DaisanshaKoiKyushoMeisaiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為求償明細を管理するクラスです。
 */
public class DaisanshaKoiKyushoMeisaiManager {

    private final DbT3083DaisanshaKoiKyushoMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiKyushoMeisaiManager() {
        dac = InstanceProvider.create(DbT3083DaisanshaKoiKyushoMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3083DaisanshaKoiKyushoMeisaiDac}
     */
    DaisanshaKoiKyushoMeisaiManager(DbT3083DaisanshaKoiKyushoMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護第三者行為求償明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 第三者行為求償請求番号 KyushoSeikyuNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param サービス提供事業者番号 ServiceTeikyoJigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 履歴番号 RirekiNo
     * @return DaisanshaKoiKyushoMeisai
     */
    @Transaction
    public DaisanshaKoiKyushoMeisai get介護第三者行為求償明細(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3083DaisanshaKoiKyushoMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                第三者行為届出管理番号,
                第三者行為求償請求番号,
                サービス提供年月,
                サービス提供事業者番号,
                サービス種類コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DaisanshaKoiKyushoMeisai(entity);
    }

    /**
     * 介護第三者行為求償明細を全件返します。
     *
     * @return List<DaisanshaKoiKyushoMeisai>
     */
    @Transaction
    public List<DaisanshaKoiKyushoMeisai> get介護第三者行為求償明細一覧() {
        List<DaisanshaKoiKyushoMeisai> businessList = new ArrayList<>();

        for (DbT3083DaisanshaKoiKyushoMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DaisanshaKoiKyushoMeisai(entity));
        }

        return businessList;
    }

    /**
     * 介護第三者行為求償明細{@link DaisanshaKoiKyushoMeisai}を保存します。
     *
     * @param 介護第三者行為求償明細 {@link DaisanshaKoiKyushoMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護第三者行為求償明細(DaisanshaKoiKyushoMeisai 介護第三者行為求償明細) {
        requireNonNull(介護第三者行為求償明細, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為求償明細"));
        if (!介護第三者行為求償明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護第三者行為求償明細.toEntity());
    }
}
