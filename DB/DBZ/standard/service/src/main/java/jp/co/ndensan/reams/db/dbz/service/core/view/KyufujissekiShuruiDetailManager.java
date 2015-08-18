/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.KyufujissekiShuruiDetail;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV3016KyufujissekiShuruiDetailDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績種類詳細を管理するクラスです。
 */
public class KyufujissekiShuruiDetailManager {

    private final DbV3016KyufujissekiShuruiDetailDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiShuruiDetailManager() {
        dac = InstanceProvider.create(DbV3016KyufujissekiShuruiDetailDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV3016KyufujissekiShuruiDetailDac}
     */
    KyufujissekiShuruiDetailManager(DbV3016KyufujissekiShuruiDetailDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績種類詳細を返します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @return KyufujissekiShuruiDetail
     */
    @Transaction
    public KyufujissekiShuruiDetail get給付実績種類詳細(
            ShikibetsuCode 交換情報識別番号,
            ShikibetsuCode 入力識別番号,
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

        DbV3016KyufujissekiShuruiDetailEntity entity = dac.selectByKey(
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
        return new KyufujissekiShuruiDetail(entity);
    }

    /**
     * 給付実績種類詳細を全件返します。
     *
     * @return KyufujissekiShuruiDetailの{@code list}
     */
    @Transaction
    public List<KyufujissekiShuruiDetail> get給付実績種類詳細一覧() {
        List<KyufujissekiShuruiDetail> businessList = new ArrayList<>();

        for (DbV3016KyufujissekiShuruiDetailEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiShuruiDetail(entity));
        }

        return businessList;
    }

    /**
     * 給付実績種類詳細{@link KyufujissekiShuruiDetail}を保存します。
     *
     * @param 給付実績種類詳細 {@link KyufujissekiShuruiDetail}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績種類詳細(KyufujissekiShuruiDetail 給付実績種類詳細) {
        requireNonNull(給付実績種類詳細, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績種類詳細"));
        if (!給付実績種類詳細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績種類詳細.toEntity());
    }
}
