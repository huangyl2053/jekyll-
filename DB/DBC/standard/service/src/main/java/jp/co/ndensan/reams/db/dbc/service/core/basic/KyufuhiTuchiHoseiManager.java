/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiTuchiHosei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3067KyufuhiTuchiHoseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3067KyufuhiTuchiHoseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費通知補正を管理するクラスです。
 *
 * @reamsid_L DBC-9999-011 xuyongchao
 */
public class KyufuhiTuchiHoseiManager {

    private final DbT3067KyufuhiTuchiHoseiDac dac;

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuhiTuchiHoseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyufuhiTuchiHoseiManager}のインスタンス
     */
    public static KyufuhiTuchiHoseiManager createInstance() {
        return InstanceProvider.create(KyufuhiTuchiHoseiManager.class);
    }

    /**
     * コンストラクタです。
     */
    public KyufuhiTuchiHoseiManager() {
        dac = InstanceProvider.create(DbT3067KyufuhiTuchiHoseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3067KyufuhiTuchiHoseiDac}
     */
    KyufuhiTuchiHoseiManager(DbT3067KyufuhiTuchiHoseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費通知補正を返します。
     *
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 履歴番号 RirekiNo
     * @return KyufuhiTuchiHosei
     */
    @Transaction
    public KyufuhiTuchiHosei get給付費通知補正(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3067KyufuhiTuchiHoseiEntity entity = dac.selectByKey(
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                サービス種類コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiTuchiHosei(entity);
    }

    /**
     * 給付費通知補正を全件返します。
     *
     * @return List<KyufuhiTuchiHosei>
     */
    @Transaction
    public List<KyufuhiTuchiHosei> get給付費通知補正一覧() {
        List<KyufuhiTuchiHosei> businessList = new ArrayList<>();

        for (DbT3067KyufuhiTuchiHoseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiTuchiHosei(entity));
        }

        return businessList;
    }

    /**
     * 給付費通知補正{@link KyufuhiTuchiHosei}を保存します。
     *
     * @param 給付費通知補正 {@link KyufuhiTuchiHosei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費通知補正(KyufuhiTuchiHosei 給付費通知補正) {
        requireNonNull(給付費通知補正, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費通知補正"));
        if (!給付費通知補正.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費通知補正.toEntity());
    }
}
