/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

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

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final int DEFAULT_履歴番号 = 0;
    public static final Decimal DEFAULT_サービス費用合計額 = new Decimal(0);
    public static final Decimal DEFAULT_利用者負担額 = new Decimal(0);
    public static final RString DEFAULT_高額給付根拠 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3054KogakuKyufuTaishoshaMeisaiEntityGenerator() {
    }

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
