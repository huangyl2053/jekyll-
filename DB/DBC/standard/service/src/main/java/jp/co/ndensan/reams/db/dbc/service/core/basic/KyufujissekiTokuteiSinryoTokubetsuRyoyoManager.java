/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績特定診療費_特別療養費を管理するクラスです。
 */
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoManager {

    private final DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoManager() {
        dac = InstanceProvider.create(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac}
     */
    KyufujissekiTokuteiSinryoTokubetsuRyoyoManager(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績特定診療費_特別療養費を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @param 特定診療情報レコード順次番号 RecodeJunjiNo
     * @return KyufujissekiTokuteiSinryoTokubetsuRyoyo
     */
    @Transaction
    public KyufujissekiTokuteiSinryoTokubetsuRyoyo get給付実績特定診療費_特別療養費(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 特定診療情報レコード順次番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(特定診療情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療情報レコード順次番号"));

        DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                特定診療情報レコード順次番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiTokuteiSinryoTokubetsuRyoyo(entity);
    }

    /**
     * 給付実績特定診療費_特別療養費を全件返します。
     *
     * @return List<KyufujissekiTokuteiSinryoTokubetsuRyoyo>
     */
    @Transaction
    public List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> get給付実績特定診療費_特別療養費一覧() {
        List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> businessList = new ArrayList<>();

        for (DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiTokuteiSinryoTokubetsuRyoyo(entity));
        }

        return businessList;
    }

    /**
     * 給付実績特定診療費_特別療養費{@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}を保存します。
     *
     * @param 給付実績特定診療費_特別療養費 {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績特定診療費_特別療養費(KyufujissekiTokuteiSinryoTokubetsuRyoyo 給付実績特定診療費_特別療養費) {
        requireNonNull(給付実績特定診療費_特別療養費, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績特定診療費_特別療養費")
        );
        if (!給付実績特定診療費_特別療養費.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績特定診療費_特別療養費.toEntity());
    }
}
