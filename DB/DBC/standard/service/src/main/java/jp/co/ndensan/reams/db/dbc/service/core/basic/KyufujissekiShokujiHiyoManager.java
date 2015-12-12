/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3022KyufujissekiShokujiHiyoDac;
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
 * 給付実績食事費用を管理するクラスです。
 */
public class KyufujissekiShokujiHiyoManager {

    private final DbT3022KyufujissekiShokujiHiyoDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiShokujiHiyoManager() {
        dac = InstanceProvider.create(DbT3022KyufujissekiShokujiHiyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3022KyufujissekiShokujiHiyoDac}
     */
    KyufujissekiShokujiHiyoManager(DbT3022KyufujissekiShokujiHiyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績食事費用を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @return KyufujissekiShokujiHiyo
     */
    @Transaction
    public KyufujissekiShokujiHiyo get給付実績食事費用(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));

        DbT3022KyufujissekiShokujiHiyoEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiShokujiHiyo(entity);
    }

    /**
     * 給付実績食事費用を全件返します。
     *
     * @return List<KyufujissekiShokujiHiyo>
     */
    @Transaction
    public List<KyufujissekiShokujiHiyo> get給付実績食事費用一覧() {
        List<KyufujissekiShokujiHiyo> businessList = new ArrayList<>();

        for (DbT3022KyufujissekiShokujiHiyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiShokujiHiyo(entity));
        }

        return businessList;
    }

    /**
     * 給付実績食事費用{@link KyufujissekiShokujiHiyo}を保存します。
     *
     * @param 給付実績食事費用 {@link KyufujissekiShokujiHiyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績食事費用(KyufujissekiShokujiHiyo 給付実績食事費用) {
        requireNonNull(給付実績食事費用, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績食事費用"));
        if (!給付実績食事費用.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績食事費用.toEntity());
    }
}
