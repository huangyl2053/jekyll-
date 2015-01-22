/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufuInCtrlTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.KyufuKanrihyoCSVDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.KyufuKanrihyoCSVHeaderEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810 久保 里史
 */
public class KyufuKanrihyoInBatch {

    public DbTKyufuInCtrlTempTableEntity CreateControlRecord(List<RString> input) {

        DbTKyufuInCtrlTempTableEntity result = new DbTKyufuInCtrlTempTableEntity();
        KyufuKanrihyoCSVHeaderEntity entity = ListToObjectMappingHelper.toObject(KyufuKanrihyoCSVHeaderEntity.class, input);

        result.setRecordShubetsu(trim囲み文字(entity.getRecordShubetsu()));
        result.setRecordNo(trim囲み文字(entity.getRecordNo()));
        result.setVolumeRenban(trim囲み文字(entity.getVolumeRenban()));
        result.setRecordKensu(trim囲み文字(entity.getRecordKensu()));
        result.setDataShubetsu(trim囲み文字(entity.getDataShubetsu()));
        result.setFukushijimushoTokuteiNo(trim囲み文字(entity.getFukushijimushoTokuteiNo()));
        result.setHokenshaNo(trim囲み文字(entity.getHokenshaNo()));
        result.setJigyoshoNo(trim囲み文字(entity.getJigyoshoNo()));
        result.setTodofukenNo(trim囲み文字(entity.getTodofukenNo()));
        result.setBaitaiKubun(trim囲み文字(entity.getBaitaiKubun()));
        result.setShoriTaishoYM(trim囲み文字(entity.getShoritaishoYM()));
        result.setFileKanriNo(trim囲み文字(entity.getFilekanriNo()));

        return result;
    }

    public DbTKyufukanrihyoDataTempTableEntity CreateDataRecord(List<RString> input) {

        DbTKyufukanrihyoDataTempTableEntity result = new DbTKyufukanrihyoDataTempTableEntity();
        KyufuKanrihyoCSVDataEntity entity = ListToObjectMappingHelper.toObject(KyufuKanrihyoCSVDataEntity.class, input);

        result.setRecordShubetsu(trim囲み文字(entity.getRecordshubetsu()));
        result.setRenban(trim囲み文字(entity.getRenban()));
        result.setKokanjohoShikibetsuNo(trim囲み文字(entity.getKokanjohoshikibetsuno()));
        result.setChohyoRecordShubetsu(trim囲み文字(entity.getChohyorecordshubetsu()));
        result.setShinsaYM(trim囲み文字(entity.getShinsaym()));
        result.setTaishoYM(trim囲み文字(entity.getTaishoym()));
        result.setHokenshaNo(trim囲み文字(entity.getHokenshano()));
        result.setKyotakuShienJigyoshoNo(trim囲み文字(entity.getKyotakushienjigyoshono()));
        result.setKyufukanrihyoSakuseiKubunCode(trim囲み文字(entity.getKyufukanrihyosakuseikubuncode()));
        result.setKyufukanrihyoSakuseiYMD(trim囲み文字(entity.getKyufukanrihyosakuseiymd()));
        result.setKyufukanrihyoShubetsuKubunCode(trim囲み文字(entity.getKyufukanrihyoshubetsukubuncode()));
        result.setKyufukanrihyoMeisaigyoNo(trim囲み文字(entity.getKyufukanrihyomeisaigyono()));
        result.setHihokenshaNo(trim囲み文字(entity.getHihokenshano()));
        result.setSeinengappiYMD(trim囲み文字(entity.getSeinengappiymd()));
        result.setSeibetsuCode(trim囲み文字(entity.getSeibetsucode()));
        result.setYokaigojotaiKubunCode(trim囲み文字(entity.getYokaigojotaikubuncode()));
        result.setGendogakuTekiyoKaishiYMD(trim囲み文字(entity.getGendogakutekiyokaishiymd()));
        result.setGendogakuTekiyoShuryoYMD(trim囲み文字(entity.getGendogakutekiyoshuryoymd()));
        result.setKyotakuKaigoyoboShikyugendogaku(trim囲み文字(entity.getKyotakukaigoyoboshikyugendogaku()));
        result.setKyotakuKeikakuSakuseiKubunCode(trim囲み文字(entity.getKyotakukeikakusakuseikubuncode()));
        result.setServiceTeikyoJigyoshoNo(trim囲み文字(entity.getServiceteikyojigyoshono()));
        result.setShiteiKijunGaitoJigyoshoKubunCode(trim囲み文字(entity.getShiteikijungaitojigyoshokubuncode()));
        result.setServiceShuruiCode(trim囲み文字(entity.getServiceshuruicode()));
        result.setKyufuKeikakuTanisuNissu(trim囲み文字(entity.getKyufukeikakutanisunissu()));
        result.setZentsukiMadeKyufuKeikakuNissu(trim囲み文字(entity.getZentsukimadekyufukeikakunissu()));
        result.setShiteiServiceShokei(trim囲み文字(entity.getShiteiserviceshokei()));
        result.setKijunGaitoServiceShokei(trim囲み文字(entity.getKijungaitoserviceshokei()));
        result.setKyufuKeikakuGokeiTanisuNissu(trim囲み文字(entity.getKyufukeikakugokeitanisunissu()));
        result.setKaigoshienSenmoninNo(trim囲み文字(entity.getKaigoshiensenmoninno()));
        result.setItakusakiKyotakuKaigoshienJigyoshoNo(trim囲み文字(entity.getItakusakikyotakukaigoshienjigyoshono()));
        result.setItakusakiKaigoshienSenmoninNo(trim囲み文字(entity.getItakusakikaigoshiensenmoninno()));

        return result;
    }

    public DbT3014KyufuKanrihyo200004Entity CreateKyufuKanrihyo200004Record(DbTKyufukanrihyoDataTempTableEntity input, RString shoriYM) {

        DbT3014KyufuKanrihyo200004Entity result = new DbT3014KyufuKanrihyo200004Entity();

        result.setShinsaYM(new FlexibleYearMonth(input.getShinsaYM()));
        result.setServiceTeikyoYM(new FlexibleYearMonth(input.getTaishoYM()));
        result.setShokisaiHokenshaNo(input.getShokisaiHokenshaNo());
        result.setKyotakushienJigyoshoNo(input.getKyotakuShienJigyoshoNo());
        result.setKyufuKanrihyoSakuseiKubunCode(input.getKyufukanrihyoSakuseiKubunCode());
        result.setKyufuKanrihyoSakuseiYMD(new FlexibleDate(input.getKyufukanrihyoSakuseiYMD()));
        result.setKyufuKanrihyoShubetsuKubunCode(input.getKyufukanrihyoShubetsuKubunCode());
        result.setKyufuKanrihyoMeisaiLineNo(input.getKyufukanrihyoMeisaigyoNo());
        result.setHokenshaNo(input.getHokenshaNo());
        result.setHiHokenshaNo(input.getHihokenshaNo());
        result.setHiHokenshaUmareYMD(new FlexibleDate(input.getSeinengappiYMD()));
        result.setSeibetsuCode(input.getSeibetsuCode());
        result.setYoKaigoJotaiKubunCode(input.getYokaigojotaiKubunCode());
        result.setGendogakuTekiyoKaishiYM(new FlexibleYearMonth(input.getGendogakuTekiyoKaishiYMD()));
        result.setGendogakuTekiyoShuryoYM(new FlexibleYearMonth(input.getGendogakuTekiyoShuryoYMD()));
        result.setKyotakuKaigoYoboShikyuGendogaku(checkDecimal(input.getKyotakuKaigoyoboShikyugendogaku()));
        result.setKyotakuServicePlanSakuseiKubunCode(input.getKyotakuKeikakuSakuseiKubunCode());
        result.setServiceJigyoshoNo(input.getServiceTeikyoJigyoshoNo());
        result.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(input.getShiteiKijunGaitoJigyoshoKubunCode());
        result.setServiceShuruiCode(input.getServiceShuruiCode());
        result.setKyufuKeikakuTanisuNissu(checkDecimal(input.getKyufuKeikakuTanisuNissu()));
        result.setKyufuKeikakuNissu(checkDecimal(input.getZentsukiMadeKyufuKeikakuNissu()));
        result.setShiteiServiceSubTotal(checkDecimal(input.getShiteiServiceShokei()));
        result.setKijyunGaitoServiceSubTotal(checkDecimal(input.getKijunGaitoServiceShokei()));
        result.setKyufuKeikakuTotalTanisuNissu(checkDecimal(input.getKyufuKeikakuGokeiTanisuNissu()));

        result.setTorikomiYM(new FlexibleYearMonth(shoriYM));

        return result;
    }

    public DbT3015KyufuKanrihyo200604Entity CreateKyufuKanrihyo200604Record(DbTKyufukanrihyoDataTempTableEntity input, RString shoriYM) {

        DbT3015KyufuKanrihyo200604Entity result = new DbT3015KyufuKanrihyo200604Entity();

        result.setShinsaYM(new FlexibleYearMonth(input.getShinsaYM()));
        result.setServiceTeikyoYM(new FlexibleYearMonth(input.getTaishoYM()));
        result.setShokisaiHokenshaNo(input.getShokisaiHokenshaNo());
        result.setKyotakushienJigyoshoNo(input.getKyotakuShienJigyoshoNo());
        result.setKyufuSakuseiKubunCode(input.getKyufukanrihyoSakuseiKubunCode());
        result.setKyufuSakuseiYMD(new FlexibleDate(input.getKyufukanrihyoSakuseiYMD()));
        result.setKyufuShubetsuKubunCode(input.getKyufukanrihyoShubetsuKubunCode());
        result.setKyufuMeisaiLineNo(input.getKyufukanrihyoMeisaigyoNo());
        result.setHokenshaNo(input.getHokenshaNo());
        result.setHiHokenshaNo(input.getHihokenshaNo());
        result.setHiHokenshaUmareYMD(new FlexibleDate(input.getSeinengappiYMD()));
        result.setSeibetsuCode(input.getSeibetsuCode());
        result.setYoKaigoJotaiKubunCode(input.getYokaigojotaiKubunCode());
        result.setGendogakuTekiyoKaishiYM(new FlexibleYearMonth(input.getGendogakuTekiyoKaishiYMD()));
        result.setGendogakuTekiyoShuryoYM(new FlexibleYearMonth(input.getGendogakuTekiyoShuryoYMD()));
        result.setKyotakuKaigoYoboShikyuGendogaku(checkDecimal(input.getKyotakuKaigoyoboShikyugendogaku()));
        result.setKyotakuServicePlanSakuseiKubunCode(input.getKyotakuKeikakuSakuseiKubunCode());
        result.setServiceJigyoshoNo(input.getServiceTeikyoJigyoshoNo());
        result.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(input.getShiteiKijunGaitoJigyoshoKubunCode());
        result.setServiceShuruiCode(input.getServiceShuruiCode());
        result.setKyufuKeikakuTanisuNissu(checkInteger(input.getKyufuKeikakuTanisuNissu()));
        result.setKyufuKeikakuNissu(checkInteger(input.getZentsukiMadeKyufuKeikakuNissu()));
        result.setShiteiServiceSubTotal(checkInteger(input.getShiteiServiceShokei()));
        result.setKijyunGaitoServiceSubTotal(checkInteger(input.getKijunGaitoServiceShokei()));
        result.setKyufuKeikakuTotalTanisuNissu(checkInteger(input.getKyufuKeikakuGokeiTanisuNissu()));

        result.setTantoKaigoShienSemmoninNo(input.getKaigoshienSenmoninNo());
        result.setKaigoShienJigyoshaNo(input.getItakusakiKyotakuKaigoshienJigyoshoNo());
        result.setItakusakiTantoKaigoShienSemmoninNo(input.getItakusakiKaigoshienSenmoninNo());

        result.setTorikomiYM(new FlexibleYearMonth(shoriYM));

        return result;
    }

    public DbT3104KokuhorenInterfaceKanriEntity CreateKokuhorenIFKanriRecord(DbT3104KokuhorenInterfaceKanriEntity kokuhorenIFkanri, List<DbTKyufuInCtrlTempTableEntity> kyufuCtrlTemps, RString fileName, RString shoriNichiji) {

        kokuhorenIFkanri.setSofuTorikomiKubun(new RString("2"));
        kokuhorenIFkanri.setShoriJotaiKubun(new RString("3"));
        kokuhorenIFkanri.setShoriJisshiTimestamp(new YMDHMS(shoriNichiji));
        kokuhorenIFkanri.setSaiShoriKahiKubun(false);
        kokuhorenIFkanri.setShoriJikkoKaisu(kokuhorenIFkanri.getShoriJikkoKaisu().add(1));
        kokuhorenIFkanri.setFileName1(fileName);
        kokuhorenIFkanri.setFileKensu1(kyufuCtrlTemps.size());
        kokuhorenIFkanri.setSaiShoriFukaKubun(false);

        Integer ctrlRecordKensu = 0;
        Integer kagoCtrlRecordKensu = 0;
        for (DbTKyufuInCtrlTempTableEntity kyufuCtrlTemp : kyufuCtrlTemps) {
            if (kyufuCtrlTemp.getFileBunruiCode().compareTo(new RString("0111")) != 0) {
                ctrlRecordKensu = ctrlRecordKensu + Integer.valueOf(kyufuCtrlTemp.getRecordKensu().toString());
                kokuhorenIFkanri.setCtrlShoriYM(new RYearMonth(kyufuCtrlTemp.getShoriTaishoYM()));
            } else {
                kagoCtrlRecordKensu = kagoCtrlRecordKensu + Integer.valueOf(kyufuCtrlTemp.getRecordKensu().toString());
                kokuhorenIFkanri.setKagoCtrlShoriYM(new RYearMonth(kyufuCtrlTemp.getShoriTaishoYM()));
            }
        }
        kokuhorenIFkanri.setCtrlRecordKensu(ctrlRecordKensu);
        kokuhorenIFkanri.setKagoCtrlRecordKensu(kagoCtrlRecordKensu);
        kokuhorenIFkanri.setJissekiDataShinsaYM(new RYearMonth(kyufuCtrlTemps.get(0).getJissekiDataShinsaYM()));

        return kokuhorenIFkanri;
    }

    private RString trim囲み文字(RString 対象文字列) {

        final char trim文字 = '"';

        try {

            対象文字列 = 対象文字列.trim(trim文字);
        } catch (NullPointerException e) {
            対象文字列 = RString.EMPTY;
        }
        return 対象文字列;
    }

    private Decimal checkDecimal(RString 金額) {
        if (金額 == null || 金額.isEmpty()) {
            return new Decimal(0);
        }

        return new Decimal(金額.toString());
    }

    private Integer checkInteger(RString 金額) {
        if (金額 == null || 金額.isEmpty()) {
            return new Integer(0);
        }

        return new Integer(金額.toString());
    }
}
