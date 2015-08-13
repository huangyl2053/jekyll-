/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.KyufujissekiKihonAlive;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV3017KyufujissekiKihonAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績基本Aliveを管理するクラスです。
 */
public class KyufujissekiKihonAliveManager {

    private final DbV3017KyufujissekiKihonAliveDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiKihonAliveManager() {
        dac = InstanceProvider.create(DbV3017KyufujissekiKihonAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV3017KyufujissekiKihonAliveDac}
     */
    KyufujissekiKihonAliveManager(DbV3017KyufujissekiKihonAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績基本Aliveを返します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @param 給付実績区分コード 給付実績区分コード
     * @param 通し番号 通し番号
     * @return KyufujissekiKihonAlive
     */
    @Transaction
    public KyufujissekiKihonAlive get給付実績基本Alive(
            ShikibetsuCode 交換情報識別番号,
            ShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 給付実績情報作成区分コード,
            RString 給付実績区分コード,
            RString 通し番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));

        DbV3017KyufujissekiKihonEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                給付実績情報作成区分コード,
                給付実績区分コード,
                通し番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiKihonAlive(entity);
    }

    /**
     * 給付実績基本Aliveを全件返します。
     *
     * @return KyufujissekiKihonAliveの{@code list}
     */
    @Transaction
    public List<KyufujissekiKihonAlive> get給付実績基本Alive一覧() {
        List<KyufujissekiKihonAlive> businessList = new ArrayList<>();

        for (DbV3017KyufujissekiKihonEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiKihonAlive(entity));
        }

        return businessList;
    }

    /**
     * 給付実績基本Alive{@link KyufujissekiKihonAlive}を保存します。
     *
     * @param 給付実績基本Alive {@link KyufujissekiKihonAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績基本Alive(KyufujissekiKihonAlive 給付実績基本Alive) {
        requireNonNull(給付実績基本Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績基本Alive"));
        if (!給付実績基本Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績基本Alive.toEntity());
    }
}
