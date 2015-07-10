/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求所定疾患施設療養費等エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final RString DEFAULT_順次番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_緊急時傷病名１ = new RString("1");
    public static final RString DEFAULT_緊急時傷病名２ = new RString("1");
    public static final RString DEFAULT_緊急時傷病名３ = new RString("1");
    public static final FlexibleDate DEFAULT_緊急時治療開始年月日１ = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_緊急時治療開始年月日２ = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_緊急時治療開始年月日３ = new FlexibleDate("20140402");
    public static final int DEFAULT_往診日数 = 1;
    public static final RString DEFAULT_往診医療機関名 = new RString("1");
    public static final int DEFAULT_通院日数 = 1;
    public static final RString DEFAULT_通院医療機関名 = new RString("1");
    public static final int DEFAULT_緊急時治療管理単位数 = 1;
    public static final int DEFAULT_緊急時治療管理日数 = 1;
    public static final int DEFAULT_緊急時治療管理小計 = 1;
    public static final int DEFAULT_リハビリテーション単位数 = 1;
    public static final int DEFAULT_処置単位数 = 1;
    public static final int DEFAULT_手術単位数 = 1;
    public static final int DEFAULT_麻酔単位数 = 1;
    public static final int DEFAULT_放射線治療単位数 = 1;
    public static final RString DEFAULT_摘要１ = new RString("1");
    public static final RString DEFAULT_摘要２ = new RString("1");
    public static final RString DEFAULT_摘要３ = new RString("1");
    public static final RString DEFAULT_摘要４ = new RString("1");
    public static final RString DEFAULT_摘要５ = new RString("1");
    public static final RString DEFAULT_摘要６ = new RString("1");
    public static final RString DEFAULT_摘要７ = new RString("1");
    public static final RString DEFAULT_摘要８ = new RString("1");
    public static final RString DEFAULT_摘要９ = new RString("1");
    public static final RString DEFAULT_摘要１０ = new RString("1");
    public static final RString DEFAULT_摘要１１ = new RString("1");
    public static final RString DEFAULT_摘要１２ = new RString("1");
    public static final RString DEFAULT_摘要１３ = new RString("1");
    public static final RString DEFAULT_摘要１４ = new RString("1");
    public static final RString DEFAULT_摘要１５ = new RString("1");
    public static final RString DEFAULT_摘要１６ = new RString("1");
    public static final RString DEFAULT_摘要１７ = new RString("1");
    public static final RString DEFAULT_摘要１８ = new RString("1");
    public static final RString DEFAULT_摘要１９ = new RString("1");
    public static final RString DEFAULT_摘要２０ = new RString("1");
    public static final int DEFAULT_緊急時施設療養費合計単位数 = 1;
    public static final RString DEFAULT_所定疾患施設療養費傷病名１ = new RString("1");
    public static final RString DEFAULT_所定疾患施設療養費傷病名２ = new RString("1");
    public static final RString DEFAULT_所定疾患施設療養費傷病名３ = new RString("1");
    public static final FlexibleDate DEFAULT_所定疾患施設療養費開始年月日１ = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_所定疾患施設療養費開始年月日２ = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_所定疾患施設療養費開始年月日３ = new FlexibleDate("20140402");
    public static final int DEFAULT_所定疾患施設療養費単位数 = 1;
    public static final int DEFAULT_所定疾患施設療養費日数 = 1;
    public static final int DEFAULT_所定疾患施設療養費小計 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator() {
    }

    public static DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity() {
        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
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
        entity.setShoteiShikkanShobyoName1(DEFAULT_所定疾患施設療養費傷病名１);
        entity.setShoteiShikkanShobyoName2(DEFAULT_所定疾患施設療養費傷病名２);
        entity.setShoteiShikkanShobyoName3(DEFAULT_所定疾患施設療養費傷病名３);
        entity.setShoteiShikkanShobyoKaishiYMD1(DEFAULT_所定疾患施設療養費開始年月日１);
        entity.setShoteiShikkanShobyoKaishiYMD2(DEFAULT_所定疾患施設療養費開始年月日２);
        entity.setShoteiShikkanShobyoKaishiYMD3(DEFAULT_所定疾患施設療養費開始年月日３);
        entity.setShoteiShikkanTanisu(DEFAULT_所定疾患施設療養費単位数);
        entity.setShoteiShikkanNissu(DEFAULT_所定疾患施設療養費日数);
        entity.setShoteiShikkanSubTotal(DEFAULT_所定疾患施設療養費小計);
        return entity;
    }
}
