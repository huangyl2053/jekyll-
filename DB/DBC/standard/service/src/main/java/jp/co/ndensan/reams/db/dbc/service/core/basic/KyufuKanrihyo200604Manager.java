/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuKanrihyo200604;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3015KyufuKanrihyo200604Dac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付管理票200604を管理するクラスです。
 */
public class KyufuKanrihyo200604Manager {

    private final DbT3015KyufuKanrihyo200604Dac dac;

    /**
     * コンストラクタです。
     */
    public KyufuKanrihyo200604Manager() {
        dac = InstanceProvider.create(DbT3015KyufuKanrihyo200604Dac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3015KyufuKanrihyo200604Dac}
     */
    KyufuKanrihyo200604Manager(DbT3015KyufuKanrihyo200604Dac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付管理票200604を返します。
     *
     * @param 審査年月 ShinsaYM
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 居宅支援事業所番号 KyotakushienJigyoshoNo
     * @param 給付管理票情報作成区分コード KyufuSakuseiKubunCode
     * @param 給付管理票作成年月日 KyufuSakuseiYMD
     * @param 給付管理票種別区分コード KyufuShubetsuKubunCode
     * @param 給付管理票明細行番号 KyufuMeisaiLineNo
     * @return KyufuKanrihyo200604
     */
    @Transaction
    public KyufuKanrihyo200604 get給付管理票200604(
            FlexibleYearMonth 審査年月,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            JigyoshaNo 居宅支援事業所番号,
            RString 給付管理票情報作成区分コード,
            FlexibleDate 給付管理票作成年月日,
            RString 給付管理票種別区分コード,
            RString 給付管理票明細行番号) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(居宅支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅支援事業所番号"));
        requireNonNull(給付管理票情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票情報作成区分コード"));
        requireNonNull(給付管理票作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票作成年月日"));
        requireNonNull(給付管理票種別区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票種別区分コード"));
        requireNonNull(給付管理票明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票明細行番号"));

        DbT3015KyufuKanrihyo200604Entity entity = dac.selectByKey(
                審査年月,
                サービス提供年月,
                証記載保険者番号,
                居宅支援事業所番号,
                給付管理票情報作成区分コード,
                給付管理票作成年月日,
                給付管理票種別区分コード,
                給付管理票明細行番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuKanrihyo200604(entity);
    }

    /**
     * 給付管理票200604を全件返します。
     *
     * @return List<KyufuKanrihyo200604>
     */
    @Transaction
    public List<KyufuKanrihyo200604> get給付管理票200604一覧() {
        List<KyufuKanrihyo200604> businessList = new ArrayList<>();

        for (DbT3015KyufuKanrihyo200604Entity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuKanrihyo200604(entity));
        }

        return businessList;
    }

    /**
     * 給付管理票200604{@link KyufuKanrihyo200604}を保存します。
     *
     * @param 給付管理票200604 {@link KyufuKanrihyo200604}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付管理票200604(KyufuKanrihyo200604 給付管理票200604) {
        requireNonNull(給付管理票200604, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票200604"));
        if (!給付管理票200604.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付管理票200604.toEntity());
    }
}
