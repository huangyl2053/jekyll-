/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績所定疾患施設療養費等エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo("012340123400001");
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("1990");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final RString DEFAULT_緊急時施設療養情報レコード順次番号 = new RString("Data");
    public static final RString DEFAULT_緊急時傷病名１ = new RString("Data");
    public static final RString DEFAULT_緊急時傷病名２ = new RString("Data");
    public static final RString DEFAULT_緊急時傷病名３ = new RString("Data");
    public static final FlexibleDate DEFAULT_緊急時治療開始年月日１ = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_緊急時治療開始年月日２ = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_緊急時治療開始年月日３ = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_往診日数 = new Decimal(0);
    public static final RString DEFAULT_往診医療機関名 = new RString("Data");
    public static final Decimal DEFAULT_通院日数 = new Decimal(0);
    public static final RString DEFAULT_通院医療機関名 = new RString("Data");
    public static final int DEFAULT_緊急時治療管理単位数 = 1;
    public static final Decimal DEFAULT_緊急時治療管理日数 = new Decimal(0);
    public static final int DEFAULT_緊急時治療管理小計 = 1;
    public static final int DEFAULT_リハビリテーション点数 = 1;
    public static final int DEFAULT_処置点数 = 1;
    public static final int DEFAULT_手術点数 = 1;
    public static final int DEFAULT_麻酔点数 = 1;
    public static final int DEFAULT_放射線治療点数 = 1;
    public static final RString DEFAULT_摘要１ = new RString("Data");
    public static final RString DEFAULT_摘要２ = new RString("Data");
    public static final RString DEFAULT_摘要３ = new RString("Data");
    public static final RString DEFAULT_摘要４ = new RString("Data");
    public static final RString DEFAULT_摘要５ = new RString("Data");
    public static final RString DEFAULT_摘要６ = new RString("Data");
    public static final RString DEFAULT_摘要７ = new RString("Data");
    public static final RString DEFAULT_摘要８ = new RString("Data");
    public static final RString DEFAULT_摘要９ = new RString("Data");
    public static final RString DEFAULT_摘要１０ = new RString("Data");
    public static final RString DEFAULT_摘要１１ = new RString("Data");
    public static final RString DEFAULT_摘要１２ = new RString("Data");
    public static final RString DEFAULT_摘要１３ = new RString("Data");
    public static final RString DEFAULT_摘要１４ = new RString("Data");
    public static final RString DEFAULT_摘要１５ = new RString("Data");
    public static final RString DEFAULT_摘要１６ = new RString("Data");
    public static final RString DEFAULT_摘要１７ = new RString("Data");
    public static final RString DEFAULT_摘要１８ = new RString("Data");
    public static final RString DEFAULT_摘要１９ = new RString("Data");
    public static final RString DEFAULT_摘要２０ = new RString("Data");
    public static final int DEFAULT_緊急時施設療養費合計点数 = 1;
    public static final RString DEFAULT_所定疾患施設療養費傷病名１ = new RString("Data");
    public static final RString DEFAULT_所定疾患施設療養費傷病名２ = new RString("Data");
    public static final RString DEFAULT_所定疾患施設療養費傷病名３ = new RString("Data");
    public static final FlexibleDate DEFAULT_所定疾患施設療養費開始年月日１ = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_所定疾患施設療養費開始年月日２ = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_所定疾患施設療養費開始年月日３ = new FlexibleDate("19900101");
    public static final int DEFAULT_所定疾患施設療養費単位数 = 1;
    public static final Decimal DEFAULT_所定疾患施設療養費日数 = new Decimal(0);
    public static final int DEFAULT_所定疾患施設療養費小計 = 1;
    public static final Decimal DEFAULT_後_往診日数 = new Decimal(0);
    public static final Decimal DEFAULT_後_通院日数 = new Decimal(0);
    public static final int DEFAULT_後_緊急時治療管理単位数 = 1;
    public static final Decimal DEFAULT_後_緊急時治療管理日数 = new Decimal(0);
    public static final int DEFAULT_後_リハビリテーション点数 = 1;
    public static final int DEFAULT_後_処置点数 = 1;
    public static final int DEFAULT_後_手術点数 = 1;
    public static final int DEFAULT_後_麻酔点数 = 1;
    public static final int DEFAULT_後_放射線治療点数 = 1;
    public static final int DEFAULT_後_所定疾患施設療養費単位数 = 1;
    public static final Decimal DEFAULT_後_所定疾患施設療養費日数 = new Decimal(0);
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator() {
    }

    public static DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity() {
        DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity = new DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setRecodeJunjiNo(DEFAULT_緊急時施設療養情報レコード順次番号);
        entity.setKinkyuShobyoName1(DEFAULT_緊急時傷病名１);
        entity.setKinkyuShobyoName2(DEFAULT_緊急時傷病名２);
        entity.setKinkyuShobyoName3(DEFAULT_緊急時傷病名３);
        entity.setKinkyuChiryoKaishiYMD1(DEFAULT_緊急時治療開始年月日１);
        entity.setKinkyuChiryoKaishiYMD2(DEFAULT_緊急時治療開始年月日２);
        entity.setKinkyuChiryoKaishiYMD3(DEFAULT_緊急時治療開始年月日３);
        entity.setOshinNissu(DEFAULT_往診日数);
        entity.setOshinIryoKikanName(DEFAULT_往診医療機関名);
        entity.setTsuinNissu(DEFAULT_通院日数);
        entity.setTsuinIryoKikanName(DEFAULT_通院医療機関名);
        entity.setKinkyuChiryoKanriTanisu(DEFAULT_緊急時治療管理単位数);
        entity.setKinkyuChiryoKanriNissu(DEFAULT_緊急時治療管理日数);
        entity.setKinkyuChiryoKanriSubTotal(DEFAULT_緊急時治療管理小計);
        entity.setRehabilitationTensu(DEFAULT_リハビリテーション点数);
        entity.setShochiTensu(DEFAULT_処置点数);
        entity.setShujutsuTensu(DEFAULT_手術点数);
        entity.setMasuiTensu(DEFAULT_麻酔点数);
        entity.setHoshasenChiryoTensu(DEFAULT_放射線治療点数);
        entity.setTekiyo1(DEFAULT_摘要１);
        entity.setTekiyo2(DEFAULT_摘要２);
        entity.setTekiyo3(DEFAULT_摘要３);
        entity.setTekiyo4(DEFAULT_摘要４);
        entity.setTekiyo5(DEFAULT_摘要５);
        entity.setTekiyo6(DEFAULT_摘要６);
        entity.setTekiyo7(DEFAULT_摘要７);
        entity.setTekiyo8(DEFAULT_摘要８);
        entity.setTekiyo9(DEFAULT_摘要９);
        entity.setTekiyo10(DEFAULT_摘要１０);
        entity.setTekiyo11(DEFAULT_摘要１１);
        entity.setTekiyo12(DEFAULT_摘要１２);
        entity.setTekiyo13(DEFAULT_摘要１３);
        entity.setTekiyo14(DEFAULT_摘要１４);
        entity.setTekiyo15(DEFAULT_摘要１５);
        entity.setTekiyo16(DEFAULT_摘要１６);
        entity.setTekiyo17(DEFAULT_摘要１７);
        entity.setTekiyo18(DEFAULT_摘要１８);
        entity.setTekiyo19(DEFAULT_摘要１９);
        entity.setTekiyo20(DEFAULT_摘要２０);
        entity.setKinkyuShisetsuRyoyohiTotalTensu(DEFAULT_緊急時施設療養費合計点数);
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName1(DEFAULT_所定疾患施設療養費傷病名１);
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName2(DEFAULT_所定疾患施設療養費傷病名２);
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName3(DEFAULT_所定疾患施設療養費傷病名３);
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD1(DEFAULT_所定疾患施設療養費開始年月日１);
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD2(DEFAULT_所定疾患施設療養費開始年月日２);
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD3(DEFAULT_所定疾患施設療養費開始年月日３);
        entity.setShoteiShikkanShisetsuRyoyohiTanisu(DEFAULT_所定疾患施設療養費単位数);
        entity.setShoteiShikkanShisetsuRyoyohiNissu(DEFAULT_所定疾患施設療養費日数);
        entity.setShoteiShikkanShisetsuRyoyohiSubTotal(DEFAULT_所定疾患施設療養費小計);
        entity.setAtoOshinNissu(DEFAULT_後_往診日数);
        entity.setAtoTsuinNissu(DEFAULT_後_通院日数);
        entity.setAtoKinkyuChiryoKanriTanisu(DEFAULT_後_緊急時治療管理単位数);
        entity.setAtoKinkyuChiryoKanriNissu(DEFAULT_後_緊急時治療管理日数);
        entity.setAtoRehabilitationTensu(DEFAULT_後_リハビリテーション点数);
        entity.setAtoShochiTensu(DEFAULT_後_処置点数);
        entity.setAtoShujutsuTensu(DEFAULT_後_手術点数);
        entity.setAtoMasuiTensu(DEFAULT_後_麻酔点数);
        entity.setAtoHoshasenChiryoTensu(DEFAULT_後_放射線治療点数);
        entity.setAtoShoteiShikkanShisetsuRyoyoHiTanisu(DEFAULT_後_所定疾患施設療養費単位数);
        entity.setAtoShoteiShikkanShisetsuRyoyoHiNissu(DEFAULT_後_所定疾患施設療養費日数);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
