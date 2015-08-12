/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績基本を管理するクラスです。
 */
public class KyufujissekiKihonManager {

    private final DbT3017KyufujissekiKihonDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiKihonManager() {
        dac = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3017KyufujissekiKihonDac}
     */
    KyufujissekiKihonManager(DbT3017KyufujissekiKihonDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績基本を返します。
     *
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 給付実績情報作成区分コード KyufuSakuseiKubunCode
     * @param 証記載保険者番号 HokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 給付実績区分コード KyufuJissekiKubunCode
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @return KyufujissekiKihon
     */
    @Transaction
    public KyufujissekiKihon get給付実績基本(
            KokanShikibetsuCode 交換情報識別番号,
            NyuryokuShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            RString 給付実績情報作成区分コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 給付実績区分コード,
            JigyoshaNo 事業所番号,
            RString 通し番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));

        DbT3017KyufujissekiKihonEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                給付実績情報作成区分コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                給付実績区分コード,
                事業所番号,
                通し番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiKihon(entity);
    }

    /**
     * 給付実績基本を全件返します。
     *
     * @return List<KyufujissekiKihon>
     */
    @Transaction
    public List<KyufujissekiKihon> get給付実績基本一覧() {
        List<KyufujissekiKihon> businessList = new ArrayList<>();

        for (DbT3017KyufujissekiKihonEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiKihon(entity));
        }

        return businessList;
    }

    /**
     * 給付実績基本{@link KyufujissekiKihon}を保存します。
     *
     * @param 給付実績基本 {@link KyufujissekiKihon}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績基本(KyufujissekiKihon 給付実績基本) {
        requireNonNull(給付実績基本, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績基本"));
        if (!給付実績基本.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績基本.toEntity());
    }
}
