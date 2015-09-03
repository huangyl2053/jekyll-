/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3027KyufujissekiJutakuKaishuhiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績住宅改修費を管理するクラスです。
 */
public class KyufujissekiJutakuKaishuhiManager {

    private final DbT3027KyufujissekiJutakuKaishuhiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiJutakuKaishuhiManager() {
        dac = InstanceProvider.create(DbT3027KyufujissekiJutakuKaishuhiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3027KyufujissekiJutakuKaishuhiDac}
     */
    KyufujissekiJutakuKaishuhiManager(DbT3027KyufujissekiJutakuKaishuhiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績住宅改修費を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @param 明細番号 MeisaiNo
     * @return KyufujissekiJutakuKaishuhi
     */
    @Transaction
    public KyufujissekiJutakuKaishuhi get給付実績住宅改修費(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 明細番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));

        DbT3027KyufujissekiJutakuKaishuhiEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                明細番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiJutakuKaishuhi(entity);
    }

    /**
     * 給付実績住宅改修費を全件返します。
     *
     * @return List<KyufujissekiJutakuKaishuhi>
     */
    @Transaction
    public List<KyufujissekiJutakuKaishuhi> get給付実績住宅改修費一覧() {
        List<KyufujissekiJutakuKaishuhi> businessList = new ArrayList<>();

        for (DbT3027KyufujissekiJutakuKaishuhiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiJutakuKaishuhi(entity));
        }

        return businessList;
    }

    /**
     * 給付実績住宅改修費{@link KyufujissekiJutakuKaishuhi}を保存します。
     *
     * @param 給付実績住宅改修費 {@link KyufujissekiJutakuKaishuhi}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績住宅改修費(KyufujissekiJutakuKaishuhi 給付実績住宅改修費) {
        requireNonNull(給付実績住宅改修費, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績住宅改修費"));
        if (!給付実績住宅改修費.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績住宅改修費.toEntity());
    }
}
