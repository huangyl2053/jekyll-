/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績集計を管理するクラスです。
 */
public class KyufujissekiShukeiManager {

    private final DbT3033KyufujissekiShukeiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiShukeiManager() {
        dac = InstanceProvider.create(DbT3033KyufujissekiShukeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3033KyufujissekiShukeiDac}
     */
    KyufujissekiShukeiManager(DbT3033KyufujissekiShukeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績集計を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @param サービス種類コード ServiceSyuruiCode
     * @return KyufujissekiShukei
     */
    @Transaction
    public KyufujissekiShukei get給付実績集計(
             KokanShikibetsuCode 交換情報識別番号,
            NyuryokuShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            ServiceShuruiCode サービス種類コード) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));

        DbT3033KyufujissekiShukeiEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                サービス種類コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiShukei(entity);
    }

    /**
     * 給付実績集計を全件返します。
     *
     * @return List<KyufujissekiShukei>
     */
    @Transaction
    public List<KyufujissekiShukei> get給付実績集計一覧() {
        List<KyufujissekiShukei> businessList = new ArrayList<>();

        for (DbT3033KyufujissekiShukeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiShukei(entity));
        }

        return businessList;
    }

    /**
     * 給付実績集計{@link KyufujissekiShukei}を保存します。
     *
     * @param 給付実績集計 {@link KyufujissekiShukei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績集計(KyufujissekiShukei 給付実績集計) {
        requireNonNull(給付実績集計, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績集計"));
        if (!給付実績集計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績集計.toEntity());
    }
}
