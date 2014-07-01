/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.FukakonkyoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.FukakonkyoMaeDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujikouseiJiyuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujikouseiKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.tabSokujiKouseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.tblSanteinokisoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.tblSanteinokisoMaeDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8211 田辺 紘一
 */
public class SokujiFukaKouseiMain {

    private static final int _1期 = 1;
    private static final int _2期 = 2;
    private static final int _3期 = 3;
    private static final int _4期 = 4;
    private static final int _5期 = 5;
    private static final int _6期 = 6;

    private static final int _1月 = 1;
    private static final int _2月 = 2;
    private static final int _3月 = 3;
    private static final int _4月 = 4;
    private static final int _5月 = 5;
    private static final int _6月 = 6;
    private static final int _7月 = 7;
    private static final int _8月 = 8;
    private static final int _9月 = 9;
    private static final int _10月 = 10;
    private static final int _11月 = 11;
    private static final int _12月 = 12;

    private static final RString 更正前 = new RString("更正前");
    private static final RString 更正後 = new RString("更正後");

    public ResponseData<SokujiFukaKouseiMainDiv> onLoad_SokujiFukaKouseiMainDiv(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv) {
        ResponseData<SokujiFukaKouseiMainDiv> response = new ResponseData<>();

        setParam(sokujiFukaKouseiMainDiv);

        response.data = sokujiFukaKouseiMainDiv;
        return response;
    }

    private void setParam(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv) {

        tabSokujiKouseiDiv tabSokujiKouseiDiv = sokujiFukaKouseiMainDiv.getTabSokujiKousei();

        List<HashMap> fukaKoseiData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/FukaKosei.yml"));
        List<HashMap> fukaKonkyoData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/FukaKonkyo.yml"));
        List<HashMap> kiwarigakuDataTokucho = YamlLoader.DBB.loadAsList(new RString("DBB8120001/KiwarigakuTokucho.yml"));
        List<HashMap> kiwarigakuDataTokuchoGokei = YamlLoader.DBB.loadAsList(new RString("DBB8120001/KiwarigakuTokuchoGokei.yml"));
        List<HashMap> kiwarigakuDataFuchoGokei = YamlLoader.DBB.loadAsList(new RString("DBB8120001/KiwarigakuFuchoGokei.yml"));
        List<HashMap> santeiKisoData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/SanteiKiso.yml"));
        List<HashMap> choteiJiyuData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/ChoteiJiyu.yml"));
        List<HashMap> choteiNendoData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/SokujiFukaKouseiMainChotei.yml"));

        List<HashMap> kiwarigakuDataFucho;
        if (sokujiFukaKouseiMainDiv.getDdlKoseiTsuki().getSelectedItem().equals(new RString("7"))) {
            kiwarigakuDataFucho = YamlLoader.DBB.loadAsList(new RString("DBB8120001/KiwarigakuFucho7gatu.yml"));
        } else if (sokujiFukaKouseiMainDiv.getDdlKoseiTsuki().getSelectedItem().equals(new RString("8"))) {
            kiwarigakuDataFucho = YamlLoader.DBB.loadAsList(new RString("DBB8120001/KiwarigakuFucho8gatu.yml"));
        } else {
            kiwarigakuDataFucho = null;
        }

        setSokujikouseiKey(sokujiFukaKouseiMainDiv, fukaKoseiData);
        setSokujiFukaKouseiMainChotei(sokujiFukaKouseiMainDiv, choteiNendoData);        
        setSokujikouseiFukakonkyo(tabSokujiKouseiDiv, fukaKonkyoData);
        setKiwarigakuTokucho(tabSokujiKouseiDiv, kiwarigakuDataTokucho, sokujiFukaKouseiMainDiv);
        setKiwarigakuFucho(tabSokujiKouseiDiv, kiwarigakuDataFucho);
        setKiwarigakuTokuchoGokei(tabSokujiKouseiDiv, kiwarigakuDataTokuchoGokei);
        setKiwarigakuFuchoGokei(tabSokujiKouseiDiv, kiwarigakuDataFuchoGokei);
        setSanteiKiso(tabSokujiKouseiDiv, santeiKisoData);
        setChoteiJiyu(tabSokujiKouseiDiv, choteiJiyuData);
  
    }

    private void setKiwarigakuTokucho(
            tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> kiwarigakuDataTokubetsu, SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv)
            throws NumberFormatException, IllegalArgumentException {
        SokujikouseiKiwarigakuDiv sokujikouseiKiwarigakuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiKiwarigaku();

        for (HashMap kiwariToku : kiwarigakuDataTokubetsu) {
            ControlGenerator cg = new ControlGenerator(kiwariToku);
            switch (cg.getAsDecimal("期").intValue()) {
                case _1期:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue1().setText(cg.getAsRString("特徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue1().setText(cg.getAsRString("特徴更正後"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue1().setText(cg.getAsRString("特徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue1().setText(cg.getAsRString("特徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo1().setDisplayNone(true);
                    break;
                case _2期:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue2().setText(cg.getAsRString("特徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue2().setText(cg.getAsRString("特徴更正後"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue2().setText(cg.getAsRString("特徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue2().setText(cg.getAsRString("特徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo2().setDisplayNone(true);
                    break;
                case _3期:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue3().setText(cg.getAsRString("特徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue3().setText(cg.getAsRString("特徴更正後"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue3().setText(cg.getAsRString("特徴増減"));
                     sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue3().setText(cg.getAsRString("特徴納付額"));
                   sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo3().setDisplayNone(true);
                    break;
                case _4期:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue4().setText(cg.getAsRString("特徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue4().setText(cg.getAsRString("特徴更正後"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue4().setText(cg.getAsRString("特徴増減"));
                     sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue4().setText(cg.getAsRString("特徴納付額"));
                   sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo4().setDisplayNone(true);
                    break;
                case _5期:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue5().setText(cg.getAsRString("特徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue5().setText(cg.getAsRString("特徴更正後"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue5().setText(cg.getAsRString("特徴増減"));
                     sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue5().setText(cg.getAsRString("特徴納付額"));
                   sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo5().setDisplayNone(true);
                    break;
                case _6期:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeValue6().setText(cg.getAsRString("特徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoValue6().setText(cg.getAsRString("特徴更正後"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenValue6().setText(cg.getAsRString("特徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuValue6().setText(cg.getAsRString("特徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtTokuchoKoseiGo6().setDisplayNone(true);
                    break;

                default:
                    throw new IllegalArgumentException();
            }

        }
    }

    private void setKiwarigakuTokuchoGokei(
            tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> kiwarigakuDataTokubetsu)
            throws NumberFormatException, IllegalArgumentException {
        SokujikouseiKiwarigakuDiv sokujikouseiKiwarigakuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiKiwarigaku();
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiMaeSum().setText(new RString(kiwarigakuDataTokubetsu.get(0).get("特徴更正前合計").toString()));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoKoseiGoSum().setText(new RString(kiwarigakuDataTokubetsu.get(0).get("特徴更正後合計").toString()));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoZogenSum().setText(new RString(kiwarigakuDataTokubetsu.get(0).get("特徴増減合計").toString()));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblTokuchoNofugakuSum().setText(new RString(kiwarigakuDataTokubetsu.get(0).get("特徴納付額合計").toString()));
    }

    private void setKiwarigakuFucho(
            tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> kiwarigakuDataHutsuu)
            throws NumberFormatException, IllegalArgumentException {
        SokujikouseiKiwarigakuDiv sokujikouseiKiwarigakuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiKiwarigaku();

        initDisp(sokujikouseiKiwarigakuDiv);

        for (HashMap kiwariHutsuu : kiwarigakuDataHutsuu) {
            ControlGenerator cg = new ControlGenerator(kiwariHutsuu);
            switch (cg.getAsDecimal("月").intValue()) {

                case _4月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue1().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue1().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue1().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().setDisplayNone(true);
                    }
                    break;
                case _5月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue2().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue2().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue2().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().setDisplayNone(true);
                    }
                    break;
                case _6月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue3().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue3().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue3().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().setDisplayNone(true);
                    }
                    break;
                case _7月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue4().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue4().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue4().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().setDisplayNone(true);
                    }
                    break;
                case _8月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue5().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue5().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue5().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().setDisplayNone(true);
                    }
                    break;
                case _9月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue6().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue6().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue6().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().setDisplayNone(true);
                    }
                    break;
                case _10月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue7().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue7().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue7().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().setDisplayNone(true);
                    }
                    break;
                case _11月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue8().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue8().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue8().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().setDisplayNone(true);
                    }
                    break;
                case _12月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue9().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue9().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue9().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().setDisplayNone(true);
                    }
                    break;
                case _1月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue10().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue10().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue10().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().setDisplayNone(true);
                    }
                    break;
                case _2月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue11().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue11().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue11().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().setDisplayNone(true);
                    }
                    break;
                case _3月:
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeValue12().setText(cg.getAsRString("普徴更正前"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().setText(cg.getAsRString("普徴更正後ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().setValue(cg.getAsDecimal("普徴更正後ボックス"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenValue12().setText(cg.getAsRString("普徴増減"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuValue12().setText(cg.getAsRString("普徴納付額"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().setText(cg.getAsRString("普徴納期限ラベル"));
                    sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().setValue(cg.getAsRDate("普徴納期限ボックス"));
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().getText().isEmpty()) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().setDisplayNone(true);
                    }
                    if (sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().getValue() == null) {
                        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().setDisplayNone(true);
                    }
                    break;

                default:
                    throw new IllegalArgumentException();
            }

        }
    }

    private void initDisp(SokujikouseiKiwarigakuDiv sokujikouseiKiwarigakuDiv) {

        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue1().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo1().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue1().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen1().setDisplayNone(false);
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue2().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo2().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue2().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen2().setDisplayNone(false);
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue3().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo3().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue3().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen3().setDisplayNone(false);
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue4().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo4().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue4().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen4().setDisplayNone(false);        

        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue5().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo5().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue5().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen5().setDisplayNone(false);        
 
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue6().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo6().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue6().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen6().setDisplayNone(false);  
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue7().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo7().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue7().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen7().setDisplayNone(false);           
   
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue8().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo8().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue8().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen8().setDisplayNone(false);       
  
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue9().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo9().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue9().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen9().setDisplayNone(false);    
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue10().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo10().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue10().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen10().setDisplayNone(false); 
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue11().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo11().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue11().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen11().setDisplayNone(false);     
        
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoValue12().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoKoseiGo12().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNokigenValue12().setDisplayNone(false);
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getTxtFuchoNokigen12().setDisplayNone(false);           
    }

    private void setKiwarigakuFuchoGokei(
            tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> kiwarigakuDataFuchoGokei)
            throws NumberFormatException, IllegalArgumentException {
        SokujikouseiKiwarigakuDiv sokujikouseiKiwarigakuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiKiwarigaku();
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiMaeSum().setText(new RString(kiwarigakuDataFuchoGokei.get(0).get("普徴更正前合計").toString()));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoKoseiGoSum().setText(new RString(kiwarigakuDataFuchoGokei.get(0).get("普徴更正後合計").toString()));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoZogenSum().setText(new RString(kiwarigakuDataFuchoGokei.get(0).get("普徴増減合計").toString()));
        sokujikouseiKiwarigakuDiv.getTblKiwarigaku().getLblFuchoNofugakuSum().setText(new RString(kiwarigakuDataFuchoGokei.get(0).get("普徴納付額合計").toString()));
    }

    private void setSokujikouseiKey(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv, List<HashMap> fukaKoseiData) {
        String 賦課年度 = (String) fukaKoseiData.get(0).get("賦課年度");

        sokujiFukaKouseiMainDiv.getTxtFukaNendo().setValue(new RString(賦課年度));
    }

    private void setSokujikouseiFukakonkyo(tabSokujiKouseiDiv taSokujiKouseiDiv, List<HashMap> koseiData) {

        for (HashMap kosei : koseiData) {
            ControlGenerator cg = new ControlGenerator(kosei);

            if (cg.getAsRString("更正前後").equals(更正前)) {

                FukakonkyoMaeDiv fukakonkyoMaeDiv = taSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoMae();

                fukakonkyoMaeDiv.getTxtShikakushutokuYMD1().setValue(new FlexibleDate(cg.getAsRString("資格取得日")));
                fukakonkyoMaeDiv.getTxtShikakusoshitsuYMD1().setValue(new FlexibleDate(cg.getAsRString("資格喪失日")));
                fukakonkyoMaeDiv.getTxtSeihoKaishiYMD1().setValue(new FlexibleDate(cg.getAsRString("生保開始日")));
                fukakonkyoMaeDiv.getTxtSeihoShuryoYMD1().setValue(new FlexibleDate(cg.getAsRString("生保終了日")));
                fukakonkyoMaeDiv.getTxtHonninKazei1().setValue(cg.getAsRString("本人課税"));
                fukakonkyoMaeDiv.getTxtSetaiKazei1().setValue(cg.getAsRString("世帯課税"));
                fukakonkyoMaeDiv.getTxtGoukeiShotoku1().setValue(cg.getAsDecimal("合計所得金額"));
                fukakonkyoMaeDiv.getTxtNenkinShunyu1().setValue(cg.getAsDecimal("公的年金収入"));
                fukakonkyoMaeDiv.getTxtHokenryoDankai1().setValue(cg.getAsRString("保険料段階"));
                fukakonkyoMaeDiv.getTxtGemmenGaku1().setValue(cg.getAsDecimal("減免額"));
                fukakonkyoMaeDiv.getTxtNenkanHokenryo1().setValue(cg.getAsDecimal("年間保険料額"));
            } else if (cg.getAsRString("更正前後").equals(更正後)) {
                FukakonkyoAtoDiv fukakonkyoAtoDiv = taSokujiKouseiDiv.getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoAto();

                fukakonkyoAtoDiv.getTxtShikakushutokuYMD2().setValue(new FlexibleDate(cg.getAsRString("資格取得日")));
                fukakonkyoAtoDiv.getTxtShikakusoshitsuYMD2().setValue(new FlexibleDate(cg.getAsRString("資格喪失日")));
                fukakonkyoAtoDiv.getTxtSeihoKaishiYMD2().setValue(new FlexibleDate(cg.getAsRString("生保開始日")));
                fukakonkyoAtoDiv.getTxtSeihoShuryoYMD2().setValue(new FlexibleDate(cg.getAsRString("生保終了日")));
                fukakonkyoAtoDiv.getTxtHonninKazei2().setValue(cg.getAsRString("本人課税"));
                fukakonkyoAtoDiv.getTxtSetaiKazei2().setValue(cg.getAsRString("世帯課税"));
                fukakonkyoAtoDiv.getTxtGoukeiShotoku2().setValue(cg.getAsDecimal("合計所得金額"));
                fukakonkyoAtoDiv.getTxtNenkinShunyu2().setValue(cg.getAsDecimal("公的年金収入"));
                fukakonkyoAtoDiv.getTxtHokenryoDankai2().setValue(cg.getAsRString("保険料段階"));
                fukakonkyoAtoDiv.getTxtGemmenGaku2().setValue(cg.getAsDecimal("減免額"));
                fukakonkyoAtoDiv.getTxtNenkanHokenryo2().setValue(cg.getAsDecimal("年間保険料額"));
            }
        }
    }

    private void setSanteiKiso(tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> santeiKisoData) {

        for (HashMap santeikiso : santeiKisoData) {
            ControlGenerator cg = new ControlGenerator(santeikiso);

            if (cg.getAsRString("更正前後").equals(更正前)) {

                tblSanteinokisoMaeDiv tplSanteinokisoMaeDiv = tabSokujiKouseiDiv.getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoMae();

                tplSanteinokisoMaeDiv.getLblKikanMae1().setText(cg.getAsRString("期間"));
                tplSanteinokisoMaeDiv.getLblHokenryoDankaiMae1().setText(cg.getAsRString("月数"));
                tplSanteinokisoMaeDiv.getLblHokenryoDankaiMae1().setText(cg.getAsRString("保険料段階"));
                tplSanteinokisoMaeDiv.getLblHokenryoritsuMae1().setText(cg.getAsRString("保険料率"));
                tplSanteinokisoMaeDiv.getLblHokenryoSanshutsuGakuMae1().setText(cg.getAsRString("保険料算出額"));
                tplSanteinokisoMaeDiv.getLblHokenryoGakuMae1().setText(cg.getAsRString("保険料額"));
            } else if (cg.getAsRString("更正前後").equals(更正後)) {
                tblSanteinokisoAtoDiv tplSanteinokisoAtoDiv = tabSokujiKouseiDiv.getSokujiKoseiTab2().getSokujikouseiSanteinoKiso().getTblSanteinokisoAto();

                tplSanteinokisoAtoDiv.getLblKikanAto1().setText(cg.getAsRString("期間"));
                tplSanteinokisoAtoDiv.getLblTsukisuAto1().setText(cg.getAsRString("月数"));
                tplSanteinokisoAtoDiv.getLblHokenryoDankaiAto1().setText(cg.getAsRString("保険料段階"));
                tplSanteinokisoAtoDiv.getLblHokenryoritsuAto1().setText(cg.getAsRString("保険料率"));
                tplSanteinokisoAtoDiv.getLblHokenryoSanshutsuGakuAto1().setText(cg.getAsRString("保険料算出額"));
                tplSanteinokisoAtoDiv.getLblHokenryoGakuAto1().setText(cg.getAsRString("保険料額"));
            }
        }
    }

    private void setChoteiJiyu(tabSokujiKouseiDiv tabSokujiKouseiDiv, List<HashMap> choteiJiyuData) {
        SokujikouseiJiyuDiv sokujikouseiJiyuDiv = tabSokujiKouseiDiv.getSokujiKoseiTab2().getSokujikouseiJiyu();

        sokujikouseiJiyuDiv.getTxtChoteiJiyu1().setValue(new RString(choteiJiyuData.get(0).get("調定事由1").toString()));
        sokujikouseiJiyuDiv.getTxtChoteiJiyu2().setValue(new RString(choteiJiyuData.get(0).get("調定事由2").toString()));
        sokujikouseiJiyuDiv.getTxtChoteiJiyu3().setValue(new RString(choteiJiyuData.get(0).get("調定事由3").toString()));
        sokujikouseiJiyuDiv.getTxtChoteiJiyu4().setValue(new RString(choteiJiyuData.get(0).get("調定事由4").toString()));
    }

    private void setSokujiFukaKouseiMainChotei(SokujiFukaKouseiMainDiv sokujiFukaKouseiMainDiv, List<HashMap> choteiNendoData) {
        sokujiFukaKouseiMainDiv.getTxtChoteiNendo().setValue(new RString(choteiNendoData.get(0).get("調定年度").toString()));
        sokujiFukaKouseiMainDiv.getTxtChoteiYMD().setValue(new RDate(choteiNendoData.get(0).get("調定日").toString()));
    }

}
