/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再審査決定明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3064SaishinsaKetteiMeisaiEntityGenerator {

    public static final FlexibleYearMonth DEFAULT_取扱年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_保険者区分 = new RString("Data");
    public static final int DEFAULT_履歴番号 = 0;
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_事業所名 = new RString("Data");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_公費受給者番号 = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final RString DEFAULT_サービス種類名 = new RString("Data");
    public static final RString DEFAULT_申立事由コード = new RString("Data");
    public static final RString DEFAULT_申立事由 = new RString("Data");
    public static final RString DEFAULT_再審査結果コード = new RString("Data");
    public static final Decimal DEFAULT_当初請求単位数 = new Decimal(0);
    public static final Decimal DEFAULT_原審単位数 = new Decimal(0);
    public static final Decimal DEFAULT_申立単位数 = new Decimal(0);
    public static final Decimal DEFAULT_決定単位数 = new Decimal(0);
    public static final Decimal DEFAULT_調整単位数 = new Decimal(0);
    public static final Decimal DEFAULT_保険者負担額 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3064SaishinsaKetteiMeisaiEntityGenerator() {
    }

    public static DbT3064SaishinsaKetteiMeisaiEntity createDbT3064SaishinsaKetteiMeisaiEntity() {
        DbT3064SaishinsaKetteiMeisaiEntity entity = new DbT3064SaishinsaKetteiMeisaiEntity();
        entity.setToriatsukaiYM(DEFAULT_取扱年月);
        entity.setHokenshaKubun(DEFAULT_保険者区分);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setJigyoshoName(DEFAULT_事業所名);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setKohiJukyushaNo(DEFAULT_公費受給者番号);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceShuruiName(DEFAULT_サービス種類名);
        entity.setMoushitateJiyuCode(DEFAULT_申立事由コード);
        entity.setMoushitateJiyu(DEFAULT_申立事由);
        entity.setSaishinsaResultCode(DEFAULT_再審査結果コード);
        entity.setToshoSeikyuTanisu(DEFAULT_当初請求単位数);
        entity.setGenshinSeikyuTanisu(DEFAULT_原審単位数);
        entity.setMoushitateTanisu(DEFAULT_申立単位数);
        entity.setKetteiTanisu(DEFAULT_決定単位数);
        entity.setChoseiTanisu(DEFAULT_調整単位数);
        entity.setHokenshaFutangaku(DEFAULT_保険者負担額);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
