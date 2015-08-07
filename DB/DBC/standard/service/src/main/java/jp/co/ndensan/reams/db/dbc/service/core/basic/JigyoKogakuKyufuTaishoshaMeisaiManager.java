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
 * 事業高額介護サービス費給付対象者明細を管理するクラスです。
 */
public class JigyoKogakuKyufuTaishoshaMeisaiManager {

    private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoKogakuKyufuTaishoshaMeisaiManager() {
        dac = InstanceProvider.create(DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac}
     */
    JigyoKogakuKyufuTaishoshaMeisaiManager(DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業高額介護サービス費給付対象者明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 履歴番号 RirekiNo
     * @return JigyoKogakuKyufuTaishoshaMeisai
     */
    @Transaction
    public JigyoKogakuKyufuTaishoshaMeisai get事業高額介護サービス費給付対象者明細(
             HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                事業者番号,
                サービス種類コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuKyufuTaishoshaMeisai(entity);
    }

    /**
     * 事業高額介護サービス費給付対象者明細を全件返します。
     *
     * @return List<JigyoKogakuKyufuTaishoshaMeisai>
     */
    @Transaction
    public List<JigyoKogakuKyufuTaishoshaMeisai> get事業高額介護サービス費給付対象者明細一覧() {
        List<JigyoKogakuKyufuTaishoshaMeisai> businessList = new ArrayList<>();

        for (DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuKyufuTaishoshaMeisai(entity));
        }

        return businessList;
    }

    /**
     * 事業高額介護サービス費給付対象者明細{@link JigyoKogakuKyufuTaishoshaMeisai}を保存します。
     *
     * @param 事業高額介護サービス費給付対象者明細 {@link JigyoKogakuKyufuTaishoshaMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save事業高額介護サービス費給付対象者明細(JigyoKogakuKyufuTaishoshaMeisai 事業高額介護サービス費給付対象者明細) {
        requireNonNull(事業高額介護サービス費給付対象者明細, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費給付対象者明細"));
        if (!事業高額介護サービス費給付対象者明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(事業高額介護サービス費給付対象者明細.toEntity());
    }
}
