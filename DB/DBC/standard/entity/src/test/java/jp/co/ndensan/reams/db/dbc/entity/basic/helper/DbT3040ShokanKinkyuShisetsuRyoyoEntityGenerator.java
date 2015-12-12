/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求緊急時施設療養エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
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
    public static final int DEFAULT_リハビリテーション単位数 = 1;
    public static final int DEFAULT_処置単位数 = 1;
    public static final int DEFAULT_手術単位数 = 1;
    public static final int DEFAULT_麻酔単位数 = 1;
    public static final int DEFAULT_放射線治療単位数 = 1;
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
    public static final int DEFAULT_緊急時施設療養費合計単位数 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator() {
    }

    public static DbT3040ShokanKinkyuShisetsuRyoyoEntity createDbT3040ShokanKinkyuShisetsuRyoyoEntity() {
        DbT3040ShokanKinkyuShisetsuRyoyoEntity entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKinkyuShobyoName1(DEFAULT_緊急時傷病名１);
        entity.setKinkyuShobyoName2(DEFAULT_緊急時傷病名２);
        entity.setKinkyuShobyoName3(DEFAULT_緊急時傷病名３);
        entity.setKinkyuChiryoKaishiYMD1(DEFAULT_緊急時治療開始年月日１);
        entity.setKinkyuChiryoKaishiYMD2(DEFAULT_緊急時治療開始年月日２);
        entity.setKinkyuChiryoKaishiYMD3(DEFAULT_緊急時治療開始年月日３);
        entity.setOshinNissu(DEFAULT_往診日数);
        entity.setOshinIryoKikanName(DEFAULT_往診医療機関名);
        entity.setTsuinNissu(DEFAULT_通院日数);
        entity.setTsuinKikanName(DEFAULT_通院医療機関名);
        entity.setKinkyuChiryoKanriTanisu(DEFAULT_緊急時治療管理単位数);
        entity.setKinkyuChiryoKanriNissu(DEFAULT_緊急時治療管理日数);
        entity.setKinkyuChiryoKanriSubTotal(DEFAULT_緊急時治療管理小計);
        entity.setRehabilitationTanisu(DEFAULT_リハビリテーション単位数);
        entity.setShochiTanisu(DEFAULT_処置単位数);
        entity.setShujutsuTanisu(DEFAULT_手術単位数);
        entity.setMasuiTanisu(DEFAULT_麻酔単位数);
        entity.setHoshasenChiryoTanisu(DEFAULT_放射線治療単位数);
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
        entity.setKinkyuShisetsuRyoyohiTotalTanisu(DEFAULT_緊急時施設療養費合計単位数);
        return entity;
    }
}
