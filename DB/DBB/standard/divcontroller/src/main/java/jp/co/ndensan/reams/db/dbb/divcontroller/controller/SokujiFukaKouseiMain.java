/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.FukakonkyoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.FukakonkyoMaeDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujikouseiJiyuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujikouseiKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.tabSokujiKouseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.tblSanteinokisoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.tblSanteinokisoMaeDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N8211 田辺 紘一
 */
public class SokujiFukaKouseiMain {

    public ResponseData<SokujiFukaKouseiMainDiv> onLoad(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv) {
        ResponseData<SokujiFukaKouseiMainDiv> response = new ResponseData<>();

        setParam(sokujiFukaKouseiMainDiv);

        response.data = sokujiFukaKouseiMainDiv;
        return response;
    }

    private void setParam(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv) {
        
        tabSokujiKouseiDiv tabSokujiKouseiDiv = sokujiFukaKouseiMainDiv.getTabSokujiKousei();

        List<HashMap> fukaKoseiData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB8120001/FukaKosei.yml"));
        List<HashMap> fukaKonkyoData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB8120001/FukaKonkyo.yml"));
        List<HashMap> kiwarigakuData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB8120001/Kiwarigaku.yml"));
        List<HashMap> santeiKisoData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB8120001/SanteiKiso.yml"));
        List<HashMap> choteiZiyuData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB8120001/ChoteiZiyu.yml"));
        
        setSokujikouseiKey(sokujiFukaKouseiMainDiv, fukaKoseiData);
        setSokujikouseiFukakonkyo(tabSokujiKouseiDiv, fukaKonkyoData);
        setKiwarigaku(tabSokujiKouseiDiv, kiwarigakuData, sokujiFukaKouseiMainDiv);
        setSanteiKiso(tabSokujiKouseiDiv, santeiKisoData);
        setChoteiZiyu(tabSokujiKouseiDiv, choteiZiyuData);
    }


    private void setSokujikouseiKey(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv, List<HashMap> fukaKoseiData) {
        String 賦課年度 = (String) fukaKoseiData.get(0).get("賦課年度");

        sokujiFukaKouseiMainDiv.getSokujikouseiKey().getTxtFukaNendo().setValue(new RString(賦課年度));
        sokujiFukaKouseiMainDiv.getSokujikouseiKey().getTxtChoteiYMD().setValue(RDateTime.now().getDate());
    }

    private void setSokujikouseiFukakonkyo(tabSokujiKouseiDiv taSokujiKouseiDiv, List<HashMap> kosei) {
        FukakonkyoMaeDiv fukakonkyoMaeDiv = taSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoMae();
        FukakonkyoAtoDiv fukakonkyoAtoDiv  = taSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoAto();

        String 資格取得日_前 = (String) kosei.get(1).get("資格取得日");
        String 資格喪失日_前 = (String) kosei.get(1).get("資格喪失日");
        String 生保開始日_前 = (String) kosei.get(1).get("生保開始日");
        String 生保終了日_前 = (String) kosei.get(1).get("生保終了日");
        String 老年開始日_前 = (String) kosei.get(1).get("資格開始日");
        String 老年終了日_前 = (String) kosei.get(1).get("資格終了日");
        String 本人課税_前 = (String) kosei.get(1).get("本人課税");
        String 世帯課税_前 = (String) kosei.get(1).get("世帯課税");
        String 合計所得金額_前 = (String) kosei.get(1).get("合計所得金額");
        String 公的年金収入_前 = (String) kosei.get(1).get("公的年金収入");
        String 保険料段階_前 = (String) kosei.get(1).get("保険料段階");
        String 減免額_前 = (String) kosei.get(1).get("減免額");
        String 年間保険料額_前 =  (String) kosei.get(1).get("年間保険料額");

        String 資格取得日_後 = (String) kosei.get(2).get("資格取得日");
        String 資格喪失日_後 = (String) kosei.get(2).get("資格喪失日");
        String 生保開始日_後 = (String) kosei.get(2).get("生保開始日");
        String 生保終了日_後 = (String) kosei.get(2).get("生保終了日");
        String 老年開始日_後 = (String) kosei.get(2).get("資格開始日");
        String 老年終了日_後 = (String) kosei.get(2).get("資格終了日");
        String 本人課税_後 =  (String) kosei.get(2).get("本人課税");
        String 世帯課税_後 =  (String) kosei.get(2).get("世帯課税");
        String 合計所得金額_後 =  (String) kosei.get(2).get("合計所得金額");
        String 公的年金収入_後 =  (String) kosei.get(2).get("公的年金収入");
        String 保険料段階_後 =  (String) kosei.get(2).get("保険料段階");
        String 減免額_後 =  (String) kosei.get(2).get("減免額");
        String 年間保険料額_後 =  (String) kosei.get(2).get("年間保険料額");
        
        NumberFormat isComma = NumberFormat.getNumberInstance();

        if ( 資格取得日_前 != null) fukakonkyoMaeDiv.getTxtShikakushutokuYMD1().setValue(new FlexibleDate(資格取得日_前));
        if ( 資格喪失日_前 != null) fukakonkyoMaeDiv.getTxtShikakusoshitsuYMD1().setValue(new FlexibleDate(資格喪失日_前));
        if ( 生保開始日_前 != null) fukakonkyoMaeDiv.getTxtSeihoKaishiYMD1().setValue(new FlexibleDate(生保開始日_前));
        if ( 生保終了日_前 != null) fukakonkyoMaeDiv.getTxtSeihoShuryoYMD1().setValue(new FlexibleDate(生保終了日_前));
        if ( 老年開始日_前 != null) fukakonkyoMaeDiv.getTxtRonenKaishiYMD1().setValue(new FlexibleDate(老年開始日_前));
        if ( 老年終了日_前 != null) fukakonkyoMaeDiv.getTxtRonenShuryoYMD1().setValue(new FlexibleDate(老年終了日_前));
        if ( 本人課税_前 != null) fukakonkyoMaeDiv.getTxtHonninKazei1().setValue(new RString(本人課税_前));
        if ( 世帯課税_前 != null)  fukakonkyoMaeDiv.getTxtSetaiKazei1().setValue(new RString(世帯課税_前));
        if ( 合計所得金額_前 != null)  fukakonkyoMaeDiv.getTxtGoukeiShotoku1().setValue(new Decimal(合計所得金額_前));
        if ( 公的年金収入_前 != null)  fukakonkyoMaeDiv.getTxtNenkinShunyu1().setValue(new Decimal(公的年金収入_前));
        if ( 保険料段階_前 != null)  fukakonkyoMaeDiv.getTxtHokenryoDankai1().setValue(new RString(保険料段階_前));
        if ( 減免額_前 != null)  fukakonkyoMaeDiv.getTxtGemmenGaku1().setValue(new Decimal(減免額_前));
        if ( 年間保険料額_前 != null)  fukakonkyoMaeDiv.getTxtNenkanHokenryo1().setValue(new Decimal(年間保険料額_前));
   
        if ( 資格取得日_後 != null) fukakonkyoAtoDiv.getTxtShikakushutokuYMD2().setValue(new FlexibleDate(資格取得日_後));
        if ( 資格喪失日_後 != null) fukakonkyoAtoDiv.getTxtShikakusoshitsuYMD2().setValue(new FlexibleDate(資格喪失日_後));
        if ( 生保開始日_後 != null) fukakonkyoAtoDiv.getTxtSeihoKaishiYMD2().setValue(new FlexibleDate(生保開始日_後));
        if ( 生保終了日_後 != null) fukakonkyoAtoDiv.getTxtSeihoShuryoYMD2().setValue(new FlexibleDate(生保終了日_後));
        if ( 老年開始日_後 != null) fukakonkyoAtoDiv.getTxtRonenKaishiYMD2().setValue(new FlexibleDate(老年開始日_後));
        if ( 老年終了日_後 != null) fukakonkyoAtoDiv.getTxtRonenShuryoYMD2().setValue(new FlexibleDate(老年終了日_後));
        if ( 本人課税_後 != null) fukakonkyoAtoDiv.getTxtHonninKazei2().setValue(new RString(本人課税_後));
        if ( 世帯課税_後 != null)  fukakonkyoAtoDiv.getTxtSetaiKazei2().setValue(new RString(世帯課税_後));
        if ( 合計所得金額_後 != null)  fukakonkyoAtoDiv.getTxtGoukeiShotoku2().setValue(new Decimal(合計所得金額_後));
        if ( 公的年金収入_後 != null)  fukakonkyoAtoDiv.getTxtNenkinShunyu2().setValue(new Decimal(公的年金収入_後));
        if ( 保険料段階_後 != null)  fukakonkyoAtoDiv.getTxtHokenryoDankai2().setValue(new RString(保険料段階_後));
        if ( 減免額_後 != null)  fukakonkyoAtoDiv.getTxtGemmenGaku2().setValue(new Decimal(減免額_後));
        if ( 年間保険料額_後 != null)  fukakonkyoAtoDiv.getTxtNenkanHokenryo2().setValue(new Decimal(年間保険料額_後));
    }    

    private void setKiwarigaku(
            tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> kiwarigakuData, SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv)
            throws NumberFormatException, IllegalArgumentException {
        SokujikouseiKiwarigakuDiv sokujikouseiKiwarigakuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiKiwarigaku();

        String 特徴更正前4月 = null;
        String 特徴更正後4月 = null;
        String 特徴増減4月 = null;
        String 特徴納付額4月 = null;
        String 普徴更正前4月 = null;
        String 普徴更正後4月 = null;
        String 普徴増減4月 = null;
        String 普徴納期限4月 = null;
        String 普徴納付額4月 = null;

        String 普徴更正前5月 = null;
        String 普徴更正後5月 = null;
        String 普徴増減5月 = null;
        String 普徴納期限5月 = null;
        String 普徴納付額5月 = null;       
        
        String 特徴更正前6月 = null;
        String 特徴更正後6月 = null;
        String 特徴増減6月 = null;
        String 特徴納付額6月 = null;
        String 普徴更正前6月 = null;
        String 普徴更正後6月 = null;
        String 普徴増減6月 = null;
        String 普徴納期限6月 = null;
        String 普徴納付額6月 = null;

        String 普徴更正前7月 = null;
        String 普徴更正後7月 = null;
        String 普徴増減7月 = null;
        String 普徴納期限7月 = null;
        String 普徴納付額7月 = null;

        String 特徴更正前8月 = null;
        String 特徴更正後8月 = null;
        String 特徴増減8月 = null;
        String 特徴納付額8月 = null;
        String 普徴更正前8月 = null;
        String 普徴更正後8月 = null;
        String 普徴増減8月 = null;
        String 普徴納期限8月 = null;
        String 普徴納付額8月 = null;

        String 普徴更正前9月 = null;
        String 普徴更正後9月 = null;
        String 普徴増減9月 = null;
        String 普徴納期限9月 = null;
        String 普徴納付額9月 = null;

        String 特徴更正前10月 = null;
        String 特徴更正後10月 = null;
        String 特徴増減10月 = null;
        String 特徴納付額10月 = null;
        String 普徴更正前10月 = null;
        String 普徴更正後10月 = null;
        String 普徴増減10月 = null;
        String 普徴納期限10月 = null;
        String 普徴納付額10月 = null;

        String 普徴更正前11月 = null;
        String 普徴更正後11月 = null;
        String 普徴増減11月 = null;
        String 普徴納期限11月 = null;
        String 普徴納付額11月 = null;

        String 特徴更正前12月 = null;
        String 特徴更正後12月 = null;
        String 特徴増減12月 = null;
        String 特徴納付額12月 = null;
        String 普徴更正前12月 = null;
        String 普徴更正後12月 = null;
        String 普徴増減12月 = null;
        String 普徴納期限12月 = null;
        String 普徴納付額12月 = null;

        String 普徴更正前1月 = null;
        String 普徴更正後1月 = null;
        String 普徴増減1月 = null;
        String 普徴納期限1月 = null;
        String 普徴納付額1月 = null;

        String 特徴更正前2月 = null;
        String 特徴更正後2月 = null;
        String 特徴増減2月 = null;
        String 特徴納付額2月 = null;
        String 普徴更正前2月 = null;
        String 普徴更正後2月 = null;
        String 普徴増減2月 = null;
        String 普徴納期限2月 = null;
        String 普徴納付額2月 = null;

        String 普徴更正前3月 = null;
        String 普徴更正後3月 = null;
        String 普徴増減3月 = null;
        String 普徴納期限3月 = null;
        String 普徴納付額3月 = null;
        
        String 特徴更正前合計;
        String 特徴更正後合計;
        String 特徴納付額合計;
        String 特徴増減合計;
        String 普徴更正前合計;
        String 普徴更正後合計;
        String 普徴納付額合計;
        String 普徴増減合計;
        
        for (int i = 1; i <= Integer.parseInt(kiwarigakuData.get(0).get("データ数").toString()); i++) {
            if(kiwarigakuData.get(i).get("月").equals("4")) { 
                特徴更正前4月 = (String) kiwarigakuData.get(i).get("特徴更正前");
                特徴更正後4月 = (String) kiwarigakuData.get(i).get("特徴更正後");
                特徴増減4月 = (String) kiwarigakuData.get(i).get("特徴増減");
                特徴納付額4月 = (String) kiwarigakuData.get(i).get("特徴納付額");
                普徴更正前4月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後4月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減4月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額4月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限4月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("5"))) { 
                普徴更正前5月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後5月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減5月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額5月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限5月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("6"))) { 
                特徴更正前6月 = (String) kiwarigakuData.get(i).get("特徴更正前");
                特徴更正後6月 = (String) kiwarigakuData.get(i).get("特徴更正後");
                特徴増減6月 = (String) kiwarigakuData.get(i).get("特徴増減");
                特徴納付額6月 = (String) kiwarigakuData.get(i).get("特徴納付額");
                普徴更正前6月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後6月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減6月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額6月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限6月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("7"))) { 
                普徴更正前7月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後7月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減7月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額7月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限7月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("8"))) { 
                特徴更正前8月 = (String) kiwarigakuData.get(i).get("特徴更正前");
                特徴更正後8月 = (String) kiwarigakuData.get(i).get("特徴更正後");
                特徴増減8月 = (String) kiwarigakuData.get(i).get("特徴増減");
                特徴納付額8月 = (String) kiwarigakuData.get(i).get("特徴納付額");
                普徴更正前8月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後8月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減8月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額8月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限8月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("9"))) { 
                普徴更正前9月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後9月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減9月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額9月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限9月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("10"))) { 
                特徴更正前10月 = (String) kiwarigakuData.get(i).get("特徴更正前");
                特徴更正後10月 = (String) kiwarigakuData.get(i).get("特徴更正後");
                特徴増減10月 = (String) kiwarigakuData.get(i).get("特徴増減");
                特徴納付額10月 = (String) kiwarigakuData.get(i).get("特徴納付額");
                普徴更正前10月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後10月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減10月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額10月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限10月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("11"))) { 
                普徴更正前11月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後11月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減11月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額11月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限11月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("12"))) { 
                特徴更正前12月 = (String) kiwarigakuData.get(i).get("特徴更正前");
                特徴更正後12月 = (String) kiwarigakuData.get(i).get("特徴更正後");
                特徴増減12月 = (String) kiwarigakuData.get(i).get("特徴増減");
                特徴納付額12月 = (String) kiwarigakuData.get(i).get("特徴納付額");
                普徴更正前12月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後12月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減12月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額12月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限12月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("1"))) { 
                普徴更正前1月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後1月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減1月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額1月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限1月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("2"))) { 
                特徴更正前2月 = (String) kiwarigakuData.get(i).get("特徴更正前");
                特徴更正後2月 = (String) kiwarigakuData.get(i).get("特徴更正後");
                特徴増減2月 = (String) kiwarigakuData.get(i).get("特徴増減");
                特徴納付額2月 = (String) kiwarigakuData.get(i).get("特徴納付額");
                普徴更正前2月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後2月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減2月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額2月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限2月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            } else if (kiwarigakuData.get(i).get("月").equals(("3"))) { 
                普徴更正前3月 = (String) kiwarigakuData.get(i).get("普徴更正前");
                普徴更正後3月 = (String) kiwarigakuData.get(i).get("普徴更正後");
                普徴増減3月 = (String) kiwarigakuData.get(i).get("普徴増減");
                普徴納付額3月 =  (String) kiwarigakuData.get(i).get("普徴納付額");
                普徴納期限3月 = (String) kiwarigakuData.get(i).get("普徴納期限");
            }
        }
        

        RString 選択月 = sokujiFukaKouseiMainDiv.getSokujikouseiKey().getDdlKoseiTsuki().getSelectedItem();

        NumberFormat isComma = NumberFormat.getNumberInstance();
        
        //4月
        if (特徴更正前4月 != null) 特徴更正前4月 = isComma.format(parseInt(特徴更正前4月));
        if (特徴増減4月 != null) 特徴増減4月 = isComma.format(parseInt(特徴増減4月));
        if (特徴納付額4月 != null) 特徴納付額4月 = isComma.format(parseInt(特徴納付額4月));
        if (普徴更正前4月 != null) 普徴更正前4月 = isComma.format(parseInt(普徴更正前4月));
        if (普徴増減4月 != null) 普徴増減4月 = isComma.format(parseInt(普徴増減4月));
        if (普徴納付額4月 != null) 普徴納付額4月 = isComma.format(parseInt(普徴納付額4月));

        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue1().setText(new RString(特徴更正前4月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue1().setText(new RString(特徴増減4月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue1().setText(new RString(特徴納付額4月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue1().setText(new RString(普徴更正前4月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue1().setText(new RString(普徴増減4月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue1().setText(new RString(普徴納付額4月));

        if (Integer.parseInt(選択月.toString()) > 4) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue1().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().setDisplayNone(false);
            if (特徴更正後4月 != null) 特徴更正後4月 = isComma.format(parseInt(特徴更正後4月));
            if (普徴更正後4月 != null) 普徴更正後4月 = isComma.format(parseInt(普徴更正後4月));
            if (特徴更正後4月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue1().setText(new RString(特徴更正後4月));
            if (普徴更正後4月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().setText(new RString(普徴更正後4月));
            if (普徴納期限4月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().setText(new RString(普徴納期限4月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo1().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo1().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().setDisplayNone(false);
            if (特徴更正後4月 != null)
                sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo1().setValue(new Decimal(Integer.parseInt(特徴更正後4月)));
            if (普徴更正後4月 != null)
                sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().setValue(new Decimal(Integer.parseInt(普徴更正後4月)));
            if (普徴納期限4月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().setValue(new RDate(普徴納期限4月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue1().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().setDisplayNone(true);
        }

        //5月
        if (普徴更正前5月 != null) 普徴更正前5月 = isComma.format(parseInt(普徴更正前5月));
        if (普徴増減5月 != null) 普徴増減5月 = isComma.format(parseInt(普徴増減5月));
        if (普徴納付額5月 != null) 普徴納付額5月 = isComma.format(parseInt(普徴納付額5月));

        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue2().setText(new RString(普徴更正前5月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue2().setText(new RString(普徴増減5月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue2().setText(new RString(普徴納付額5月));

        if (普徴更正後5月 != null) 普徴更正後5月 = isComma.format(parseInt(普徴更正後5月));
        if (Integer.parseInt(選択月.toString()) > 5) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().setDisplayNone(false);
            if (普徴更正後5月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().setText(new RString(普徴更正後5月));
            if (普徴納期限5月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().setText(new RString(普徴納期限5月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().setDisplayNone(false);
            if (普徴更正後5月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().setValue(new Decimal(普徴更正後5月));
            if (普徴納期限5月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().setValue(new RDate(普徴納期限5月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().setDisplayNone(true);
        }

        //6月
        if (特徴更正前6月 != null) 特徴更正前6月 = isComma.format(parseInt(特徴更正前6月));
        if (特徴増減6月 != null) 特徴増減6月 = isComma.format(parseInt(特徴増減6月));
        if (特徴納付額6月 != null) 特徴納付額6月 = isComma.format(parseInt(特徴納付額6月));
        if (普徴更正前6月 != null) 普徴更正前6月 = isComma.format(parseInt(普徴更正前6月));
        if (普徴増減6月 != null) 普徴増減6月 = isComma.format(parseInt(普徴増減6月));
        if (普徴納付額6月 != null) 普徴納付額6月 = isComma.format(parseInt(普徴納付額6月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue2().setText(new RString(特徴更正前6月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue2().setText(new RString(特徴増減6月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue2().setText(new RString(特徴納付額6月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue3().setText(new RString(普徴更正前6月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue3().setText(new RString(普徴増減6月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue3().setText(new RString(普徴納付額6月));
        
        if (Integer.parseInt(選択月.toString()) > 6) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue2().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().setDisplayNone(false);
            if (特徴更正後6月 != null) 特徴更正後6月 = isComma.format(parseInt(特徴更正後6月));
            if (特徴更正後6月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue2().setText(new RString(特徴更正後6月));
            if (普徴更正後6月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().setText(new RString(普徴更正後6月));
            if (普徴納期限6月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().setText(new RString(普徴納期限6月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo2().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo2().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().setDisplayNone(false);
            if (特徴更正後6月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo2().setValue(new Decimal(特徴更正後6月));
            if (普徴更正後6月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().setValue(new Decimal(普徴更正後6月));
            if (普徴納期限6月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().setValue(new RDate(普徴納期限6月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue2().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().setDisplayNone(true);
        }

        //7月
        if (普徴更正前7月 != null) 普徴更正前7月 = isComma.format(parseInt(普徴更正前7月));
        if (普徴増減7月 != null) 普徴増減7月 = isComma.format(parseInt(普徴増減7月));
        if (普徴納付額7月 != null) 普徴納付額7月 = isComma.format(parseInt(普徴納付額7月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue4().setText(new RString(普徴更正前7月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue4().setText(new RString(普徴増減7月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue4().setText(new RString(普徴納付額7月));
        
        if (Integer.parseInt(選択月.toString()) > 7) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().setDisplayNone(false);
            if (普徴更正後7月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().setText(new RString(普徴更正後7月));
            if (普徴納期限7月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().setText(new RString(普徴納期限7月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().setDisplayNone(false);
            if (普徴更正後7月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().setValue(new Decimal(普徴更正後7月));
            if (普徴納期限7月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().setValue(new RDate(普徴納期限7月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().setDisplayNone(true);
        }

        //8月
        if (特徴更正前8月 != null) 特徴更正前8月 = isComma.format(parseInt(特徴更正前8月));
        if (特徴増減8月 != null) 特徴増減8月 = isComma.format(parseInt(特徴増減8月));
        if (特徴納付額8月 != null) 特徴納付額8月 = isComma.format(parseInt(特徴納付額8月));
        if (普徴更正前8月 != null) 普徴更正前8月 = isComma.format(parseInt(普徴更正前8月));
        if (普徴増減8月 != null) 普徴増減8月 = isComma.format(parseInt(普徴増減8月));
        if (普徴納付額8月 != null) 普徴納付額8月 = isComma.format(parseInt(普徴納付額8月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue3().setText(new RString(特徴更正前8月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue3().setText(new RString(特徴増減8月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue3().setText(new RString(特徴納付額8月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue5().setText(new RString(普徴更正前8月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue5().setText(new RString(普徴増減8月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue5().setText(new RString(普徴納付額8月));

        if (Integer.parseInt(選択月.toString()) > 8) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue3().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().setDisplayNone(false);
            if (特徴更正後8月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue3().setText(new RString(特徴更正後8月));
            if (普徴更正後8月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().setText(new RString(普徴更正後8月));
            if (普徴納期限8月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().setText(new RString(普徴納期限8月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo3().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo3().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().setDisplayNone(false);
            if (特徴更正後8月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo3().setValue(new Decimal(特徴更正後8月));
            if (普徴更正後8月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().setValue(new Decimal(普徴更正後8月));
            if (普徴納期限8月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().setValue(new RDate(普徴納期限8月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue3().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().setDisplayNone(true);
        }

        //9月
        if (普徴更正前9月 != null) 普徴更正前9月 = isComma.format(parseInt(普徴更正前9月));
        if (普徴増減9月 != null) 普徴増減9月 = isComma.format(parseInt(普徴増減9月));
        if (普徴納付額9月 != null) 普徴納付額9月 = isComma.format(parseInt(普徴納付額9月));

        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue6().setText(new RString(普徴更正前9月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue6().setText(new RString(普徴増減9月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue6().setText(new RString(普徴納付額9月));
        
        if (Integer.parseInt(選択月.toString()) > 9) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().setDisplayNone(false);
            if (普徴更正後9月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().setText(new RString(普徴更正後9月));
            if (普徴納期限9月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().setText(new RString(普徴納期限9月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().setDisplayNone(false);
            if (普徴更正後9月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().setValue(new Decimal(普徴更正後9月));
            if (普徴納期限9月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().setValue(new RDate(普徴納期限9月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().setDisplayNone(true);
        }

        //10月
        if (特徴更正前10月 != null) 特徴更正前10月 = isComma.format(parseInt(特徴更正前10月));
        if (特徴増減10月 != null) 特徴増減10月 = isComma.format(parseInt(特徴増減10月));
        if (特徴納付額10月 != null) 特徴納付額10月 = isComma.format(parseInt(特徴納付額10月));
        if (普徴更正前10月 != null) 普徴更正前10月 = isComma.format(parseInt(普徴更正前10月));
        if (普徴増減10月 != null) 普徴増減10月 = isComma.format(parseInt(普徴増減10月));
        if (普徴納付額10月 != null) 普徴納付額10月 = isComma.format(parseInt(普徴納付額10月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue4().setText(new RString(特徴更正前10月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue4().setText(new RString(特徴増減10月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue4().setText(new RString(特徴納付額10月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue7().setText(new RString(普徴更正前10月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue7().setText(new RString(普徴増減10月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue7().setText(new RString(普徴納付額10月));
        
        if (Integer.parseInt(選択月.toString()) > 10) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue4().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().setDisplayNone(false);
            if (特徴更正後10月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue4().setText(new RString(特徴更正後10月));
            if (普徴更正後10月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().setText(new RString(普徴更正後10月));
            if (普徴納期限10月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().setText(new RString(普徴納期限10月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo4().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo4().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().setDisplayNone(false);
            if (特徴更正後10月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo4().setValue(new Decimal(特徴更正後10月));
            if (普徴更正後10月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().setValue(new Decimal(普徴更正後10月));
            if (普徴納期限10月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().setValue(new RDate(普徴納期限10月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue4().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().setDisplayNone(true);
        }

        //11月
        if (普徴更正前11月 != null) 普徴更正前11月 = isComma.format(parseInt(普徴更正前11月));
        if (普徴増減11月 != null) 普徴増減11月 = isComma.format(parseInt(普徴増減11月));
        if (普徴納付額11月 != null) 普徴納付額11月 = isComma.format(parseInt(普徴納付額11月));

        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue8().setText(new RString(普徴更正前11月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue8().setText(new RString(普徴増減11月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue8().setText(new RString(普徴納付額11月));
        
        if (Integer.parseInt(選択月.toString()) > 11) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().setDisplayNone(false);
            if (普徴更正後11月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().setText(new RString(普徴更正後11月));
            if (普徴納期限11月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().setText(new RString(普徴納期限11月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().setDisplayNone(false);
            if (普徴更正後11月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().setValue(new Decimal(普徴更正後11月));
            if (普徴納期限11月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().setValue(new RDate(普徴納期限11月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().setDisplayNone(true);
        }

        //12月
        if (特徴更正前12月 != null) 特徴更正前12月 = isComma.format(parseInt(特徴更正前12月));
        if (特徴増減12月 != null) 特徴増減12月 = isComma.format(parseInt(特徴増減12月));
        if (特徴納付額12月 != null) 特徴納付額12月 = isComma.format(parseInt(特徴納付額12月));
        if (普徴更正前12月 != null) 普徴更正前12月 = isComma.format(parseInt(普徴更正前12月));
        if (普徴増減12月 != null) 普徴増減12月 = isComma.format(parseInt(普徴増減12月));
        if (普徴納付額12月 != null) 普徴納付額12月 = isComma.format(parseInt(普徴納付額12月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue5().setText(new RString(特徴更正前12月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue5().setText(new RString(特徴増減12月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue5().setText(new RString(特徴納付額12月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue9().setText(new RString(普徴更正前12月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue9().setText(new RString(普徴増減12月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue9().setText(new RString(普徴納付額12月));

        if (Integer.parseInt(選択月.toString()) > 12) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue5().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().setDisplayNone(false);
            if (特徴更正後12月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue5().setText(new RString(特徴更正後12月));
            if (普徴更正後12月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().setText(new RString(普徴更正後12月));
            if (普徴納期限12月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().setText(new RString(普徴納期限12月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo5().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo5().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().setDisplayNone(false);
            if (特徴更正後12月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo5().setValue(new Decimal(特徴更正後12月));
            if (普徴更正後12月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().setValue(new Decimal(普徴更正後12月));
            if (普徴納期限12月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().setValue(new RDate(普徴納期限12月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue5().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().setDisplayNone(true);
        }

        //1月
        if (普徴更正前1月 != null) 普徴更正前1月 = isComma.format(parseInt(普徴更正前1月));
        if (普徴増減1月 != null) 普徴増減1月 = isComma.format(parseInt(普徴増減1月));
        if (普徴納付額1月 != null) 普徴納付額1月 = isComma.format(parseInt(普徴納付額1月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue10().setText(new RString(普徴更正前1月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue10().setText(new RString(普徴増減1月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue10().setText(new RString(普徴納付額1月));
        
        if (Integer.parseInt(選択月.toString()) > 13) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().setDisplayNone(false);
            if (普徴更正後1月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().setText(new RString(普徴更正後1月));
            if (普徴納期限1月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().setText(new RString(普徴納期限1月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().setDisplayNone(false);
            if (普徴更正後1月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().setValue(new Decimal(普徴更正後1月));
            if (普徴納期限1月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().setValue(new RDate(普徴納期限1月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().setDisplayNone(true);
        }
        
        //2月
        if (特徴更正前2月 != null) 特徴更正前2月 = isComma.format(parseInt(特徴更正前2月));
        if (特徴増減2月 != null) 特徴増減2月 = isComma.format(parseInt(特徴増減2月));
        if (特徴納付額2月 != null) 特徴納付額2月 = isComma.format(parseInt(特徴納付額2月));
        if (普徴更正前2月 != null) 普徴更正前2月 = isComma.format(parseInt(普徴更正前2月));
        if (普徴増減2月 != null) 普徴増減2月 = isComma.format(parseInt(普徴増減2月));
        if (普徴納付額2月 != null) 普徴納付額2月 = isComma.format(parseInt(普徴納付額2月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue6().setText(new RString(特徴更正前2月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue6().setText(new RString(特徴増減2月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue6().setText(new RString(特徴納付額2月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue11().setText(new RString(普徴更正前2月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue11().setText(new RString(普徴増減2月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue11().setText(new RString(普徴納付額2月));
        if (Integer.parseInt(選択月.toString()) > 14) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue6().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().setDisplayNone(false);
            if (特徴更正後2月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue6().setText(new RString(特徴更正後2月));
            if (普徴更正後2月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().setText(new RString(普徴更正後2月));
            if (普徴納期限2月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().setText(new RString(普徴納期限2月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo6().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo6().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().setDisplayNone(false);
            if (特徴更正後2月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo6().setValue(new Decimal(特徴更正後2月));
            if (普徴更正後2月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().setValue(new Decimal(普徴更正後2月));
            if (普徴納期限2月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().setValue(new RDate(普徴納期限2月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue6().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().setDisplayNone(true);
        }

        //3月
        if (普徴更正前3月 != null) 普徴更正前3月 = isComma.format(parseInt(普徴更正前3月));
        if (普徴増減3月 != null) 普徴増減3月 = isComma.format(parseInt(普徴増減3月));
        if (普徴納付額3月 != null) 普徴納付額3月 = isComma.format(parseInt(普徴納付額3月));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue12().setText(new RString(普徴更正前3月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue12().setText(new RString(普徴増減3月));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue12().setText(new RString(普徴納付額3月));

        if (Integer.parseInt(選択月.toString()) > 15) {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().setDisplayNone(false);
            if (普徴更正後3月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().setText(new RString(普徴更正後3月));
            if (普徴納期限3月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().setText(new RString(普徴納期限3月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo6().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().setDisplayNone(true);
        } else {
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().setDisplayNone(false);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().setDisplayNone(false);
            if (普徴更正後3月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().setValue(new Decimal(普徴更正後3月));
            if (普徴納期限3月 != null) sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().setValue(new RDate(普徴納期限3月));
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().setDisplayNone(true);
            sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().setDisplayNone(true);
        }
        
        特徴更正前合計 = (String)  kiwarigakuData.get(0).get("特徴更正前合計");
        特徴更正後合計 = (String)  kiwarigakuData.get(0).get("特徴更正後合計");
        特徴納付額合計 = (String)  kiwarigakuData.get(0).get("特徴納付額合計");
        特徴増減合計 = (String)  kiwarigakuData.get(0).get("特徴増減合計");
        普徴更正前合計 = (String)  kiwarigakuData.get(0).get("普徴更正前合計");
        普徴更正後合計 = (String)  kiwarigakuData.get(0).get("普徴更正後合計");
        普徴納付額合計 = (String)  kiwarigakuData.get(0).get("普徴納付額合計");
        普徴増減合計 = (String)  kiwarigakuData.get(0).get("普徴増減合計");
        
        if (特徴更正前合計 != null) 特徴更正前合計 = isComma.format(parseInt(特徴更正前合計));
        if (特徴更正後合計 != null) 特徴更正後合計 = isComma.format(parseInt(特徴更正後合計));
        if (特徴納付額合計 != null) 特徴納付額合計 = isComma.format(parseInt(特徴納付額合計));
        if (特徴増減合計 != null) 特徴増減合計 = isComma.format(parseInt(特徴増減合計));
        if (普徴更正前合計 != null) 普徴更正前合計 = isComma.format(parseInt(普徴更正前合計));
        if (普徴更正後合計 != null) 普徴更正後合計 = isComma.format(parseInt(普徴更正後合計));
        if (普徴納付額合計 != null) 普徴納付額合計 = isComma.format(parseInt(普徴納付額合計));
        if (普徴増減合計 != null) 普徴増減合計 = isComma.format(parseInt(普徴増減合計));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeSum().setText(new RString(特徴更正前合計));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoSum().setText(new RString(特徴更正後合計));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuSum().setText(new RString(特徴納付額合計));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenSum().setText(new RString(特徴増減合計));
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeSum().setText(new RString(普徴更正前合計));        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoSum().setText(new RString(普徴更正後合計));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuSum().setText(new RString(普徴納付額合計));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenSum().setText(new RString(普徴増減合計));
    }

    private void setSanteiKiso(tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> santeiKisoData) {
        tblSanteinokisoMaeDiv tplSanteinokisoMaeDiv = tabSokujiKouseiDiv.getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae();
        tblSanteinokisoAtoDiv tplSanteinokisoAtoDiv = tabSokujiKouseiDiv.getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto();
 
        NumberFormat isComma = NumberFormat.getNumberInstance();
        
        String 期間_前 = (String) santeiKisoData.get(0).get("期間");
        String 月数_前 = (String) santeiKisoData.get(0).get("月数");
        String 保険料段階_前 = (String) santeiKisoData.get(0).get("保険料段階");
        String 保険料率_前 = (String) santeiKisoData.get(0).get("保険料率");
        String 保険料算出額_前 = (String) santeiKisoData.get(0).get("保険料算出額");
        String 保険料額_前 = (String) santeiKisoData.get(0).get("保険料額");
 
        if (保険料率_前 != null) 保険料率_前 = isComma.format(Integer.parseInt(保険料率_前));
        if (保険料算出額_前 != null) 保険料算出額_前 = isComma.format(Integer.parseInt(保険料算出額_前));
        if (保険料額_前 != null) 保険料額_前 = isComma.format(Integer.parseInt(保険料額_前));
        
        tplSanteinokisoMaeDiv.getLblKikanMae1().setText(new RString(期間_前));
        tplSanteinokisoMaeDiv.getLblTsukisuMae1().setText(new RString(月数_前));
        tplSanteinokisoMaeDiv.getLblHokenryoDankaiMae1().setText(new RString(保険料段階_前));
        tplSanteinokisoMaeDiv.getLblHokenryoritsuMae1().setText(new RString(保険料率_前));
        tplSanteinokisoMaeDiv.getLblHokenryoSanshutsuGakuMae1().setText(new RString(保険料算出額_前));
        tplSanteinokisoMaeDiv.getLblHokenryoGakuMae1().setText(new RString(保険料額_前));

        String 期間_後 = (String) santeiKisoData.get(1).get("期間");
        String 月数_後 = (String) santeiKisoData.get(1).get("月数");
        String 保険料段階_後 = (String) santeiKisoData.get(1).get("保険料段階");
        String 保険料率_後 = (String) santeiKisoData.get(1).get("保険料率");
        String 保険料算出額_後 = (String) santeiKisoData.get(1).get("保険料算出額");
        String 保険料額_後 = (String) santeiKisoData.get(1).get("保険料額");

        if (保険料率_後 != null) 保険料率_後 = isComma.format(Integer.parseInt(保険料率_後));
        if (保険料算出額_後 != null) 保険料算出額_後 = isComma.format(Integer.parseInt(保険料算出額_後));
        if (保険料額_後 != null) 保険料額_後 = isComma.format(Integer.parseInt(保険料額_後));
        
        tplSanteinokisoAtoDiv.getLblKikanAto1().setText(new RString(期間_後));
        tplSanteinokisoAtoDiv.getLblTsukisuAto1().setText(new RString(月数_後));
        tplSanteinokisoAtoDiv.getLblHokenryoDankaiAto1().setText(new RString(保険料段階_後));
        tplSanteinokisoAtoDiv.getLblHokenryoritsuAto1().setText(new RString(保険料率_後));
        tplSanteinokisoAtoDiv.getLblHokenryoSanshutsuGakuAto1().setText(new RString(保険料算出額_後));
        tplSanteinokisoAtoDiv.getLblHokenryoGakuAto1().setText(new RString(保険料額_後));
    }

    private void setChoteiZiyu(tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> choteiZiyuData) {
        SokujikouseiJiyuDiv sokujikouseiJiyuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab2().getSokujikouseiJiyu();
        
        String 調定事由1 = (String) choteiZiyuData.get(0).get("調定事由1");
        String 調定事由2 = (String) choteiZiyuData.get(0).get("調定事由2");
        String 調定事由3 = (String) choteiZiyuData.get(0).get("調定事由3");
        String 調定事由4 = (String) choteiZiyuData.get(0).get("調定事由4");
        
        sokujikouseiJiyuDiv.getTxtChoteiJiyu1().setValue(new RString(調定事由1));
        sokujikouseiJiyuDiv.getTxtChoteiJiyu2().setValue(new RString(調定事由2));
        sokujikouseiJiyuDiv.getTxtChoteiJiyu3().setValue(new RString(調定事由3));
        sokujikouseiJiyuDiv.getTxtChoteiJiyu4().setValue(new RString(調定事由4));
    }
}
