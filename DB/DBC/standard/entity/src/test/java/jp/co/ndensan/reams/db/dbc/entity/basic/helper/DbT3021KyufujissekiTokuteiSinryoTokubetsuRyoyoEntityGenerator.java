/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績特定診療費・特別療養費エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo("012340123400001");
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_特定診療情報レコード順次番号 = new RString("Data");
    public static final RString DEFAULT_傷病名 = new RString("Data");
    public static final RString DEFAULT_識別番号 = new RString("Data");
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_保険_回数 = new Decimal(0);
    public static final int DEFAULT_保険_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_保険_合計単位数 = 1;
    public static final Decimal DEFAULT_公費１_回数 = new Decimal(0);
    public static final int DEFAULT_公費１_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_公費１_合計単位数 = 1;
    public static final Decimal DEFAULT_公費２_回数 = new Decimal(0);
    public static final int DEFAULT_公費２_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_公費２_合計単位数 = 1;
    public static final Decimal DEFAULT_公費３_回数 = new Decimal(0);
    public static final int DEFAULT_公費３_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_公費３_合計単位数 = 1;
    public static final RString DEFAULT_摘要 = new RString("Data");
    public static final Decimal DEFAULT_後_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_後_保険_回数 = new Decimal(0);
    public static final int DEFAULT_後_保険_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_後_保険_合計単位数 = 1;
    public static final Decimal DEFAULT_後_公費１_回数 = new Decimal(0);
    public static final int DEFAULT_後_公費１_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_後_公費１_合計単位数 = 1;
    public static final Decimal DEFAULT_後_公費２_回数 = new Decimal(0);
    public static final int DEFAULT_後_公費２_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_後_公費２_合計単位数 = 1;
    public static final Decimal DEFAULT_後_公費３_回数 = new Decimal(0);
    public static final int DEFAULT_後_公費３_ｻｰﾋﾞｽ単位数 = 1;
    public static final int DEFAULT_後_公費３_合計単位数 = 1;
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityGenerator() {
    }

    public static DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity createDbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity() {
        DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity = new DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setRecodeJunjiNo(DEFAULT_特定診療情報レコード順次番号);
        entity.setShobyoName(DEFAULT_傷病名);
        entity.setShikibetsuNo(DEFAULT_識別番号);
        entity.setTanisu(DEFAULT_単位数);
        entity.setHokenKaisu(DEFAULT_保険_回数);
        entity.setHokenServiceTanisu(DEFAULT_保険_ｻｰﾋﾞｽ単位数);
        entity.setHokenTotalTanisu(DEFAULT_保険_合計単位数);
        entity.setKohi1Kaisu(DEFAULT_公費１_回数);
        entity.setKohi1ServiceTanisu(DEFAULT_公費１_ｻｰﾋﾞｽ単位数);
        entity.setKohi1TotalTanisu(DEFAULT_公費１_合計単位数);
        entity.setKohi2Kaisu(DEFAULT_公費２_回数);
        entity.setKohi2ServiceTanisu(DEFAULT_公費２_ｻｰﾋﾞｽ単位数);
        entity.setKohi2TotalTanisu(DEFAULT_公費２_合計単位数);
        entity.setKohi3Kaisu(DEFAULT_公費３_回数);
        entity.setKohi3ServiceTanisu(DEFAULT_公費３_ｻｰﾋﾞｽ単位数);
        entity.setKohi3TotalTanisu(DEFAULT_公費３_合計単位数);
        entity.setTekiyo(DEFAULT_摘要);
        entity.setAtoTanisu(DEFAULT_後_単位数);
        entity.setAtoHokenKaisu(DEFAULT_後_保険_回数);
        entity.setAtoHokenServiceTanisu(DEFAULT_後_保険_ｻｰﾋﾞｽ単位数);
        entity.setAtoHokenTotalTanisu(DEFAULT_後_保険_合計単位数);
        entity.setAtoKohi1Kaisu(DEFAULT_後_公費１_回数);
        entity.setAtoKohi1ServiceTanisu(DEFAULT_後_公費１_ｻｰﾋﾞｽ単位数);
        entity.setAtoKohi1TotalTanisu(DEFAULT_後_公費１_合計単位数);
        entity.setAtoKohi2Kaisu(DEFAULT_後_公費２_回数);
        entity.setAtoKohi2ServiceTanisu(DEFAULT_後_公費２_ｻｰﾋﾞｽ単位数);
        entity.setAtoKohi2TotalTanisu(DEFAULT_後_公費２_合計単位数);
        entity.setAtoKohi3Kaisu(DEFAULT_後_公費３_回数);
        entity.setAtoKohi3ServiceTanisu(DEFAULT_後_公費３_ｻｰﾋﾞｽ単位数);
        entity.setAtoKohi3TotalTanisu(DEFAULT_後_公費３_合計単位数);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
