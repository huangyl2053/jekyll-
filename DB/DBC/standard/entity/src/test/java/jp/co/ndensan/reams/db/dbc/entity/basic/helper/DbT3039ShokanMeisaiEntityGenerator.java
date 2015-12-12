/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3039ShokanMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode("1");
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_日数_回数 = new Decimal(0);
    public static final int DEFAULT_サービス単位数 = 1;
    public static final RString DEFAULT_摘要 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3039ShokanMeisaiEntityGenerator() {
    }

    public static DbT3039ShokanMeisaiEntity createDbT3039ShokanMeisaiEntity() {
        DbT3039ShokanMeisaiEntity entity = new DbT3039ShokanMeisaiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setNissuKaisu(DEFAULT_日数_回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setTekiyo(DEFAULT_摘要);
        return entity;
    }
}
