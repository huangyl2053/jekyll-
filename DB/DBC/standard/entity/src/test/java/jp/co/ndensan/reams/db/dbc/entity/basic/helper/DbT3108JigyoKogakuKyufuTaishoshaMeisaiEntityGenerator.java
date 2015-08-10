/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業高額介護サービス費給付対象者明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_サービス費用合計額 = new Decimal(0);
    public static final Decimal DEFAULT_利用者負担額 = new Decimal(0);
    public static final RString DEFAULT_事業高額給付根拠 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntityGenerator() {
    }

    public static DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity createDbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity() {
        DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity = new DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceHiyoGokeiGaku(DEFAULT_サービス費用合計額);
        entity.setRiyoshaFutanGaku(DEFAULT_利用者負担額);
        entity.setJigyoKogakuKyufuKonkyo(DEFAULT_事業高額給付根拠);
        return entity;
    }
}
