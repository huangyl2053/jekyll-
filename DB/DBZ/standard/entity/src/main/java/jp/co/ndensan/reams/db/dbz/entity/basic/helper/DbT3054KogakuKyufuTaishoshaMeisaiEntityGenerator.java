/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費給付対象者明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator {

    /**
     * 被保険者番号のデフォルト値です。
     */
    public static final HihokenshaNo DEFAULT_被保険者番号;
    /**
     * サービス提供年月のデフォルト値です。
     */
    public static final FlexibleYearMonth DEFAULT_サービス提供年月;
    /**
     * 事業者番号のデフォルト値です。
     */
    public static final JigyoshaNo DEFAULT_事業者番号;
    /**
     * サービス種類コードのデフォルト値です。
     */
    public static final ServiceShuruiCode DEFAULT_サービス種類コード;
    /**
     * 履歴番号のデフォルト値です。
     */
    public static final int DEFAULT_履歴番号;
    /**
     * サービス費用合計額のデフォルト値です。
     */
    public static final Decimal DEFAULT_サービス費用合計額;
    /**
     * 利用者負担額のデフォルト値です。
     */
    public static final Decimal DEFAULT_利用者負担額;
    /**
     * 高額給付根拠のデフォルト値です。
     */
    public static final RString DEFAULT_高額給付根拠;

    static {
        DEFAULT_被保険者番号 = new HihokenshaNo("0000000273");
        DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
        DEFAULT_事業者番号 = new JigyoshaNo("1");
        DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
        DEFAULT_履歴番号 = 0;
        DEFAULT_サービス費用合計額 = new Decimal(0);
        DEFAULT_利用者負担額 = new Decimal(0);
        DEFAULT_高額給付根拠 = new RString("Data");
    }

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator() {
    }

    /**
     * テスト用の{@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}を生成します。
     *
     * @return テスト用の{@link DbT3054KogakuKyufuTaishoshaMeisaiEntity}
     */
    public static DbT3054KogakuKyufuTaishoshaMeisaiEntity createDbT3054KogakuKyufuTaishoshaMeisaiEntity() {
        DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = new DbT3054KogakuKyufuTaishoshaMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceHiyoGokeiGaku(DEFAULT_サービス費用合計額);
        entity.setRiyoshaFutanGaku(DEFAULT_利用者負担額);
        entity.setKogakuKyufuKonkyo(DEFAULT_高額給付根拠);
        return entity;
    }
}
