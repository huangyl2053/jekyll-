/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3106KyufujissekiMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績明細・住所地特例エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo("012340123400001");
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode("1");
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_日数_回数 = new Decimal(0);
    public static final Decimal DEFAULT_公費１対象日数_回数 = new Decimal(0);
    public static final Decimal DEFAULT_公費２対象日数_回数 = new Decimal(0);
    public static final Decimal DEFAULT_公費３対象日数_回数 = new Decimal(0);
    public static final int DEFAULT_サービス単位数 = 1;
    public static final int DEFAULT_公費１対象サービス単位数 = 1;
    public static final int DEFAULT_公費２対象サービス単位数 = 1;
    public static final int DEFAULT_公費３対象サービス単位数 = 1;
    public static final ShoKisaiHokenshaNo DEFAULT_施設所在保険者番号 = new ShoKisaiHokenshaNo("1");
    public static final RString DEFAULT_摘要 = new RString("Data");
    public static final Decimal DEFAULT_後_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_後_日数_回数 = new Decimal(0);
    public static final Decimal DEFAULT_後_公費１対象日数_回数 = new Decimal(0);
    public static final Decimal DEFAULT_後_公費２対象日数_回数 = new Decimal(0);
    public static final Decimal DEFAULT_後_公費３対象日数_回数 = new Decimal(0);
    public static final int DEFAULT_後_サービス単位数 = 1;
    public static final int DEFAULT_後_公費１対象サービス単位数 = 1;
    public static final int DEFAULT_後_公費２対象サービス単位数 = 1;
    public static final int DEFAULT_後_公費３対象サービス単位数 = 1;
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3106KyufujissekiMeisaiJushochiTokureiEntityGenerator() {
    }

    public static DbT3106KyufujissekiMeisaiJushochiTokureiEntity createDbT3106KyufujissekiMeisaiJushochiTokureiEntity() {
        DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity = new DbT3106KyufujissekiMeisaiJushochiTokureiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setNissuKaisu(DEFAULT_日数_回数);
        entity.setKohi1TaishoNissuKaisu(DEFAULT_公費１対象日数_回数);
        entity.setKohi2TaishoNissuKaisu(DEFAULT_公費２対象日数_回数);
        entity.setKohi3TaishoNissuKaisu(DEFAULT_公費３対象日数_回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setKohi1TaishoServiceTanisu(DEFAULT_公費１対象サービス単位数);
        entity.setKohi2TaishoServiceTanisu(DEFAULT_公費２対象サービス単位数);
        entity.setKohi3TaishoServiceTanisu(DEFAULT_公費３対象サービス単位数);
        entity.setShisetsuShozaiHokenshaNo(DEFAULT_施設所在保険者番号);
        entity.setTekiyo(DEFAULT_摘要);
        entity.setAtoTanisu(DEFAULT_後_単位数);
        entity.setAtoNissuKaisu(DEFAULT_後_日数_回数);
        entity.setAtoKohi1TaishoNissuKaisu(DEFAULT_後_公費１対象日数_回数);
        entity.setAtoKohi2TaishoNissukaisu(DEFAULT_後_公費２対象日数_回数);
        entity.setAtoKohi3TaishoNissuKaisu(DEFAULT_後_公費３対象日数_回数);
        entity.setAtoServiceTanisu(DEFAULT_後_サービス単位数);
        entity.setAtoKohi1TaishoServiceTanisu(DEFAULT_後_公費１対象サービス単位数);
        entity.setAtoKohi2TaishoServiceTanisu(DEFAULT_後_公費２対象サービス単位数);
        entity.setAtoKohi3TaishoServiceTanisu(DEFAULT_後_公費３対象サービス単位数);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
