/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0030011;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorResult;
import jp.co.ndensan.reams.db.dbu.business.core.yoshikibetsurenkeijoho.JigyoHokokuTokei;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.jigyohokokurenkei.JigyoHokokuRenkeiBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0030011.JigyoJokyoHokokuGeppoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 様式別連携情報作成処理です。
 *
 * @reamsid_L DBU-4050-010 suguangjun
 */
public class JigyoJokyoHokokuGeppoHandler {

    private static final RString 合併あり = new RString("1");
    private static final RString 審査年月 = new RString("shinsaYM4");
    private static final RString 決定年月 = new RString("keiteiYM4");
    private static final RString 一般状況14 = new RString("ippan12_14Genbutsu");
    private static final RString ALL = new RString("all");
    private static final RString 決定状況償還分 = new RString("hokenKyufuShokan");
    private static final List<RString> 一般状況10 = new ArrayList<>();
    private static final List<RString> 一般状況_合算 = new ArrayList<>();
    private static final List<RString> 一般状況14_現物分 = new ArrayList<>();
    private static final List<RString> 一般状況14_償還分 = new ArrayList<>();
    private static final List<RString> 決定状況合算 = new ArrayList<>();
    private static final List<RString> 保険給付決定状況_現物分 = new ArrayList<>();
    private static final List<RString> 決定状況合算_償還分 = new ArrayList<>();

    private final JigyoJokyoHokokuGeppoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 各種申請書Div
     */
    public JigyoJokyoHokokuGeppoHandler(JigyoJokyoHokokuGeppoDiv div) {
        this.div = div;
    }

    /**
     * 様式別連携情報の初期化処理です。
     *
     * @param kuTokeiList 過去報告年月
     */
    public void onLoad(List<JigyoHokokuTokei> kuTokeiList) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(
                GyomuBunrui.介護事務);
        RString 合併市町村 = DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (new Code(DonyuKeitaiCode.事務単一.getCode()).equals(shichosonSecurityJoho.get導入形態コード()) && 合併あり.equals(合併市町村)) {
            div.getJikkoTanni().getRadHokenshaKyuShichoson().setVisible(true);
        } else {
            div.getJikkoTanni().getRadHokenshaKyuShichoson().setVisible(false);
        }
        if (new Code(DonyuKeitaiCode.事務広域.getCode()).equals(shichosonSecurityJoho.get導入形態コード())) {
            div.getJikkoTanni().getRadKoikiKoseiShichoson().setVisible(true);
        } else {
            div.getJikkoTanni().getRadKoikiKoseiShichoson().setVisible(false);
        }
        if (new Code(DonyuKeitaiCode.事務広域.getCode()).equals(shichosonSecurityJoho.get導入形態コード()) || 合併あり.equals(合併市町村)) {
            div.getJikkoTanni().getBtnShichosonSentaku().setDisabled(true);
        } else {
            div.getJikkoTanni().getBtnShichosonSentaku().setVisible(false);
        }
        setKakoHokokuYM(kuTokeiList);
        div.setShichosonCode(RString.EMPTY);
        div.setKoikiKoseiKubun(shichosonSecurityJoho.get導入形態コード() == null ? RString.EMPTY
                : new RString(shichosonSecurityJoho.get導入形態コード().toString()));
        div.setGappeiKubun(合併市町村);
    }

    /**
     * 過去報告年月処理です。
     *
     * @param kuTokeiList 過去報告年月
     */
    public void setKakoHokokuYM(List<JigyoHokokuTokei> kuTokeiList) {
        List<KeyValueDataSource> kinyusha = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(RString.EMPTY, RString.EMPTY);
        kinyusha.add(dataSource);
        for (JigyoHokokuTokei jigyoHokokuTokei : kuTokeiList) {
            LinkedHashMap<RString, RString> linkedHashMap = jigyoHokokuTokei.get過去報告年月();
            if (linkedHashMap.entrySet().iterator().hasNext()) {
                KeyValueDataSource data = new KeyValueDataSource(linkedHashMap.entrySet().iterator().next().getKey(),
                        linkedHashMap.entrySet().iterator().next().getValue());
                kinyusha.add(data);
            }
        }
        div.getJikkoTanni().getDdlKakoHokokuYM().setDataSource(kinyusha);
    }

    /**
     * 集計年月を設定処理です。
     *
     * @param 集計年月_一般状況1から10 集計年月_一般状況1から10
     * @param 集計年月_11から14現物分 集計年月_11から14現物分
     * @param 決定年月_11から14現物分 決定年月_11から14現物分
     * @param 審査年月_11から14償還分 審査年月_11から14償還分
     * @param 審査年月_決定状況償還分 審査年月_決定状況償還分
     * @param 集計年月_決定状況現物分 集計年月_決定状況現物分
     * @param 決定年月_決定状況償還分 決定年月_決定状況償還分
     */
    public void getShukeiYM(List<JigyoHokokuTokei> 集計年月_一般状況1から10, List<JigyoHokokuTokei> 集計年月_11から14現物分,
            List<JigyoHokokuTokei> 審査年月_11から14償還分, List<JigyoHokokuTokei> 決定年月_11から14現物分,
            List<JigyoHokokuTokei> 集計年月_決定状況現物分, List<JigyoHokokuTokei> 審査年月_決定状況償還分,
            List<JigyoHokokuTokei> 決定年月_決定状況償還分) {
        if (!集計年月_一般状況1から10.isEmpty()) {
            div.getTxtShukeiYM1().setValue(集計年月_一般状況1から10.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(集計年月_一般状況1から10.get(0).get集計年月().toDateString()));
        }
        if (!集計年月_11から14現物分.isEmpty()) {
            div.getTxtShukeiYM2().setValue(集計年月_11から14現物分.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(集計年月_11から14現物分.get(0).get集計年月().toDateString()));
        }

        RString 一般状況集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (new RString("1").equals(一般状況集計方法)) {
            if (!審査年月_11から14償還分.isEmpty()) {
                div.getTxtShukeiYM3().setValue(審査年月_11から14償還分.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(審査年月_11から14償還分.get(0).get集計年月().toDateString()));
            }
            if (!決定年月_11から14現物分.isEmpty()) {
                div.setShukeiNengetsu3((決定年月_11から14現物分.get(0).get集計年月() == null ? RString.EMPTY
                        : 決定年月_11から14現物分.get(0).get集計年月().toDateString()));
            }
            if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM3().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu3())) {
                div.getRadShukeiType3().setDisabled(false);
                div.getRadShukeiType3().setSelectedKey(審査年月);
            } else if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM3().getValue()) && RString.isNullOrEmpty(div.getShukeiNengetsu3())) {
                div.getRadShukeiType3().setDisabled(true);
                div.getRadShukeiType3().setSelectedKey(審査年月);
            } else if (FlexibleDate.EMPTY.equals(div.getTxtShukeiYM3().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu3())) {
                div.getRadShukeiType3().setDisabled(true);
                div.getTxtShukeiYM3().setValue(new FlexibleDate(div.getShukeiNengetsu3()));
                div.setShukeiNengetsu3(RString.EMPTY);
                div.getRadShukeiType3().setSelectedKey(決定年月);
            } else {
                div.getRadShukeiType3().setDisabled(true);
                div.getRadShukeiType3().setSelectedKey(審査年月);
            }
        }
        getShukeiYM1(審査年月_11から14償還分, 決定年月_11から14現物分, 一般状況集計方法);
        getShukeiYM5(集計年月_決定状況現物分, 審査年月_決定状況償還分, 決定年月_決定状況償還分);
    }

    private void getShukeiYM1(List<JigyoHokokuTokei> 審査年月_11から14償還分,
            List<JigyoHokokuTokei> 決定年月_11から14現物分, RString 一般状況集計方法) {
        if (new RString("2").equals(一般状況集計方法)) {
            if (!決定年月_11から14現物分.isEmpty()) {
                div.getTxtShukeiYM3().setValue(決定年月_11から14現物分.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(決定年月_11から14現物分.get(0).get集計年月().toDateString()));
            }
            if (!審査年月_11から14償還分.isEmpty()) {
                div.setShukeiNengetsu3((審査年月_11から14償還分.get(0).get集計年月() == null ? RString.EMPTY
                        : 審査年月_11から14償還分.get(0).get集計年月().toDateString()));
            }
            if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM3().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu3())) {
                div.getRadShukeiType3().setDisabled(false);
                div.getRadShukeiType3().setSelectedKey(決定年月);
            } else if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM3().getValue()) && RString.isNullOrEmpty(div.getShukeiNengetsu3())) {
                div.getRadShukeiType3().setDisabled(true);
                div.getRadShukeiType3().setSelectedKey(決定年月);
            } else if (FlexibleDate.EMPTY.equals(div.getTxtShukeiYM3().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu3())) {
                div.getRadShukeiType3().setDisabled(true);
                div.getTxtShukeiYM3().setValue(new FlexibleDate(div.getShukeiNengetsu3()));
                div.setShukeiNengetsu3(RString.EMPTY);
                div.getRadShukeiType3().setSelectedKey(審査年月);
            } else {
                div.getRadShukeiType3().setDisabled(true);
                div.getRadShukeiType3().setSelectedKey(決定年月);
            }
        }
    }

    /**
     * 集計年月を設定処理です。
     *
     * @param 集計年月_決定状況現物分 集計年月_決定状況現物分
     * @param 審査年月_決定状況償還分 審査年月_決定状況償還分
     * @param 決定年月_決定状況償還分 決定年月_決定状況償還分
     */
    public void getShukeiYM5(List<JigyoHokokuTokei> 集計年月_決定状況現物分, List<JigyoHokokuTokei> 審査年月_決定状況償還分,
            List<JigyoHokokuTokei> 決定年月_決定状況償還分) {
        if (!集計年月_決定状況現物分.isEmpty()) {
            div.getTxtShukeiYM4().setValue(集計年月_決定状況現物分.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                    : new FlexibleDate(集計年月_決定状況現物分.get(0).get集計年月().toDateString()));
        }
        RString 保険給付集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (new RString("1").equals(保険給付集計方法)) {
            if (!審査年月_決定状況償還分.isEmpty()) {
                div.getTxtShukeiYM5().setValue(審査年月_決定状況償還分.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(審査年月_決定状況償還分.get(0).get集計年月().toDateString()));
            }
            if (!決定年月_決定状況償還分.isEmpty()) {
                div.setShukeiNengetsu5(決定年月_決定状況償還分.get(0).get集計年月() == null ? RString.EMPTY
                        : 決定年月_決定状況償還分.get(0).get集計年月().toDateString());
            }
            if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM5().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu5())) {
                div.getRadShukeiType5().setDisabled(false);
                div.getRadShukeiType5().setSelectedKey(審査年月);
            } else if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM5().getValue()) && RString.isNullOrEmpty(div.getShukeiNengetsu5())) {
                div.getRadShukeiType5().setDisabled(true);
                div.getRadShukeiType5().setSelectedKey(審査年月);
            } else if (FlexibleDate.EMPTY.equals(div.getTxtShukeiYM5().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu5())) {
                div.getRadShukeiType5().setDisabled(true);
                div.getTxtShukeiYM5().setValue(new FlexibleDate(div.getShukeiNengetsu5()));
                div.setShukeiNengetsu5(RString.EMPTY);
                div.getRadShukeiType5().setSelectedKey(決定年月);
            } else {
                div.getRadShukeiType5().setDisabled(true);
                div.getRadShukeiType5().setSelectedKey(審査年月);
            }
        }
        getShukeiYM5_1(審査年月_決定状況償還分, 決定年月_決定状況償還分, 保険給付集計方法);
    }

    private void getShukeiYM5_1(List<JigyoHokokuTokei> 審査年月_決定状況償還分,
            List<JigyoHokokuTokei> 決定年月_決定状況償還分, RString 保険給付集計方法) {
        if (new RString("2").equals(保険給付集計方法)) {
            if (!決定年月_決定状況償還分.isEmpty()) {
                div.getTxtShukeiYM5().setValue(決定年月_決定状況償還分.get(0).get集計年月() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(決定年月_決定状況償還分.get(0).get集計年月().toDateString()));
            }
            if (!審査年月_決定状況償還分.isEmpty()) {
                div.setShukeiNengetsu5(審査年月_決定状況償還分.get(0).get集計年月() == null ? RString.EMPTY
                        : 審査年月_決定状況償還分.get(0).get集計年月().toDateString());
            }
            if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM5().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu5())) {
                div.getRadShukeiType5().setDisabled(false);
                div.getRadShukeiType5().setSelectedKey(決定年月);
            } else if (!FlexibleDate.EMPTY.equals(div.getTxtShukeiYM5().getValue()) && RString.isNullOrEmpty(div.getShukeiNengetsu5())) {
                div.getRadShukeiType5().setDisabled(true);
                div.getRadShukeiType5().setSelectedKey(決定年月);
            } else if (FlexibleDate.EMPTY.equals(div.getTxtShukeiYM5().getValue()) && !RString.isNullOrEmpty(div.getShukeiNengetsu5())) {
                div.getRadShukeiType5().setDisabled(true);
                div.getTxtShukeiYM5().setValue(new FlexibleDate(div.getShukeiNengetsu5()));
                div.setShukeiNengetsu5(RString.EMPTY);
                div.getRadShukeiType5().setSelectedKey(審査年月);
            } else {
                div.getRadShukeiType5().setDisabled(true);
                div.getRadShukeiType5().setSelectedKey(決定年月);
            }
        }
    }

    /**
     * すべて選択チェックボックス処理です。
     */
    public void getCblShutsuryokuAll() {
        if (div.getCblShutsuryokuAll().getSelectedKeys().contains(ALL)) {
            if (!div.getCblIppan1to10().isDisabled()) {
                一般状況10.clear();
                一般状況10.add(new RString("ippan1_11"));
                div.getCblIppan1to10().setSelectedItemsByKey(一般状況10);
            }
            if (!div.getCblGassan1().isDisabled()) {
                一般状況_合算.clear();
                一般状況_合算.add(ALL);
                div.getCblGassan1().setSelectedItemsByKey(一般状況_合算);
            }
            if (!div.getCblIppanGembutsu().isDisabled()) {
                一般状況14_現物分.clear();
                一般状況14_現物分.add(一般状況14);
                div.getCblIppanGembutsu().setSelectedItemsByKey(一般状況14_現物分);
            }
            if (!div.getCblIppanShokan().isDisabled()) {
                一般状況14_償還分.clear();
                一般状況14_償還分.add(一般状況14);
                div.getCblIppanShokan().setSelectedItemsByKey(一般状況14_償還分);
            }
            if (!div.getCblGassan2().isDisabled()) {
                決定状況合算.clear();
                決定状況合算.add(ALL);
                div.getCblGassan2().setSelectedItemsByKey(決定状況合算);
            }
            if (!div.getCblHokenKyufuGembutsu().isDisabled()) {
                保険給付決定状況_現物分.clear();
                保険給付決定状況_現物分.add(new RString("hokenKyufuGenbutsu"));
                div.getCblHokenKyufuGembutsu().setSelectedItemsByKey(保険給付決定状況_現物分);
            }
            if (!div.getCblHokenKyufuShokan().isDisabled()) {
                決定状況合算_償還分.clear();
                決定状況合算_償還分.add(決定状況償還分);
                div.getCblHokenKyufuShokan().setSelectedItemsByKey(決定状況合算_償還分);
            }
        } else {
            一般状況10.clear();
            div.getCblIppan1to10().setSelectedItemsByKey(一般状況10);
            一般状況_合算.clear();
            div.getCblGassan1().setSelectedItemsByKey(一般状況_合算);
            一般状況14_現物分.clear();
            div.getCblIppanGembutsu().setSelectedItemsByKey(一般状況14_現物分);
            一般状況14_償還分.clear();
            div.getCblIppanShokan().setSelectedItemsByKey(一般状況14_償還分);
            if (!div.getCblGassan2().isDisabled()) {
                決定状況合算.clear();
                div.getCblGassan2().setSelectedItemsByKey(決定状況合算);
            }
            if (!div.getCblHokenKyufuGembutsu().isDisabled()) {
                保険給付決定状況_現物分.clear();
                div.getCblHokenKyufuGembutsu().setSelectedItemsByKey(保険給付決定状況_現物分);
            }
            決定状況合算_償還分.clear();
            div.getCblHokenKyufuShokan().setSelectedItemsByKey(決定状況合算_償還分);
        }
    }

    /**
     * チェックボックスの操作不可設定処理です。
     */
    public void getShutsuryokuAll() {
        if (div.getCblShutsuryokuAll().getSelectedKeys().contains(ALL)) {
            div.getCblIppan1to10().setDisabled(false);
            div.getCblGassan1().setDisabled(false);
            div.getCblIppanGembutsu().setDisabled(false);
            div.getCblIppanShokan().setDisabled(false);
            div.getCblGassan2().setDisabled(false);
            div.getCblHokenKyufuGembutsu().setDisabled(false);
            div.getCblHokenKyufuShokan().setDisabled(false);
        } else {
            if (div.getTxtShukeiYM1().getValue() == null || div.getTxtShukeiYM1().getValue().isEmpty()) {
                div.getCblIppan1to10().setDisabled(true);
            }
            if (div.getTxtShukeiYM2().getValue() == null || div.getTxtShukeiYM2().getValue().isEmpty()) {
                div.getCblIppanGembutsu().setDisabled(true);
            }
            if (div.getTxtShukeiYM3().getValue() == null || div.getTxtShukeiYM3().getValue().isEmpty()) {
                div.getCblIppanShokan().setDisabled(true);
            }
            if ((div.getTxtShukeiYM2().getValue() == null || div.getTxtShukeiYM2().getValue().isEmpty())
                    && (div.getTxtShukeiYM3().getValue() == null || div.getTxtShukeiYM3().getValue().isEmpty())) {
                div.getCblGassan1().setDisabled(true);
            }
            getShutsuryoku();
        }
        if (new FlexibleDate("平26.07").isBeforeOrEquals((new FlexibleDate(div.getJikkoTanni().getDdlKakoHokokuYM().getSelectedValue())))) {
            div.getCblHokenKyufuGembutsu().setDisabled(true);
            div.getCblGassan2().setDisabled(true);
        }
    }

    /**
     * チェックボックスの操作不可設定処理です。
     */
    public void getShutsuryoku() {
        if (div.getTxtShukeiYM4().getValue() == null || div.getTxtShukeiYM4().getValue().isEmpty()) {
            div.getCblHokenKyufuGembutsu().setDisabled(true);
        }
        if (div.getTxtShukeiYM5().getValue() == null || div.getTxtShukeiYM5().getValue().isEmpty()) {
            div.getCblHokenKyufuShokan().setDisabled(true);
        }
        if ((div.getTxtShukeiYM4().getValue() == null || div.getTxtShukeiYM4().getValue().isEmpty())
                && (div.getTxtShukeiYM5().getValue() == null || div.getTxtShukeiYM5().getValue().isEmpty())) {
            div.getCblGassan2().setDisabled(true);
        }
    }

    private void setCblGassan1() {
        if (div.getTxtShukeiYM2().getValue() != null && !div.getTxtShukeiYM2().getValue().isEmpty()) {
            div.getCblIppanGembutsu().setDisabled(false);
            一般状況14_現物分.clear();
            一般状況14_現物分.add(new RString("ippan12_14Genbutsu"));
            div.getCblIppanGembutsu().setSelectedItemsByKey(一般状況14_現物分);
        }
        if (div.getTxtShukeiYM3().getValue() != null && !div.getTxtShukeiYM3().getValue().isEmpty()) {
            div.getCblIppanShokan().setDisabled(false);
            一般状況14_償還分.clear();
            一般状況14_償還分.add(new RString("ippan12_14Genbutsu"));
            div.getCblIppanShokan().setSelectedItemsByKey(一般状況14_償還分);
        }
    }

    private void setCblGassan2() {
        if (div.getTxtShukeiYM4().getValue() != null && !div.getTxtShukeiYM4().getValue().isEmpty()) {
            保険給付決定状況_現物分.clear();
            保険給付決定状況_現物分.add(new RString("hokenKyufuGenbutsu"));
            div.getCblHokenKyufuGembutsu().setSelectedItemsByKey(保険給付決定状況_現物分);
        }
        if (div.getTxtShukeiYM5().getValue() != null && !div.getTxtShukeiYM5().getValue().isEmpty()) {
            決定状況合算_償還分.clear();
            決定状況合算_償還分.add(決定状況償還分);
            div.getCblHokenKyufuShokan().setSelectedItemsByKey(決定状況合算_償還分);
        }
    }

    /**
     * 合併市町村用保険者選択ラジオボタンの処理です。
     */
    public void setRadHokenshaKyuShichoson() {
        if (new RString("gappei").equals(div.getJikkoTanni().getRadHokenshaKyuShichoson().getSelectedKey())) {
            div.getJikkoTanni().getBtnShichosonSentaku().setDisabled(true);
        } else {
            div.getJikkoTanni().getBtnShichosonSentaku().setDisabled(false);
        }
    }

    /**
     * 広域構成市町村用保険者選択ラジオボタンの処理です。
     */
    public void setRadKoikiKoseiShichoson() {
        if (new RString("koiki").equals(div.getJikkoTanni().getRadKoikiKoseiShichoson().getSelectedKey())) {
            div.getJikkoTanni().getBtnShichosonSentaku().setDisabled(true);
        } else {
            div.getJikkoTanni().getBtnShichosonSentaku().setDisabled(false);
        }
    }

    /**
     * 集計年月3テキストボックスの処理です。
     */
    public void setShukeiType3() {
        FlexibleDate shukeiYM3 = div.getTxtShukeiYM3().getValue();
        div.getTxtShukeiYM3().setValue(new FlexibleDate(div.getShukeiNengetsu3()));
        div.setShukeiNengetsu3(shukeiYM3 == null ? RString.EMPTY : new RString(shukeiYM3.toString()));
    }

    /**
     * 集計年月5テキストボックスの処理です。
     */
    public void setShukeiType5() {
        FlexibleDate shukeiYM5 = div.getTxtShukeiYM5().getValue();
        div.getTxtShukeiYM5().setValue(new FlexibleDate(div.getShukeiNengetsu5()));
        div.setShukeiNengetsu5(shukeiYM5 == null ? RString.EMPTY : new RString(shukeiYM5.toString()));
    }

    /**
     * 集計年月テキストボックスのクリア処理です。
     */
    public void clearTxtShukeiYM() {
        div.getTxtShukeiYM1().clearValue();
        div.getTxtShukeiYM2().clearValue();
        div.getTxtShukeiYM3().clearValue();
        div.setShukeiNengetsu3(RString.EMPTY);
        div.getTxtShukeiYM4().clearValue();
        div.getTxtShukeiYM5().clearValue();
        div.setShukeiNengetsu5(RString.EMPTY);
        一般状況10.clear();
        div.getCblIppan1to10().setSelectedItemsByKey(一般状況10);
        一般状況_合算.clear();
        div.getCblGassan1().setSelectedItemsByKey(一般状況_合算);
        一般状況14_現物分.clear();
        div.getCblIppanGembutsu().setSelectedItemsByKey(一般状況14_現物分);
        一般状況14_償還分.clear();
        div.getCblIppanShokan().setSelectedItemsByKey(一般状況14_償還分);
        決定状況合算.clear();
        div.getCblGassan2().setSelectedItemsByKey(決定状況合算);
        保険給付決定状況_現物分.clear();
        div.getCblHokenKyufuGembutsu().setSelectedItemsByKey(保険給付決定状況_現物分);
        決定状況合算_償還分.clear();
        div.getCblHokenKyufuShokan().setSelectedItemsByKey(決定状況合算_償還分);
        div.getCblIppan1to10().setDisabled(false);
        div.getCblGassan1().setDisabled(false);
        div.getCblIppanGembutsu().setDisabled(false);
        div.getCblIppanShokan().setDisabled(false);
        div.getCblGassan2().setDisabled(false);
        div.getCblHokenKyufuGembutsu().setDisabled(false);
        div.getCblHokenKyufuShokan().setDisabled(false);
    }

    /**
     * チェックボックスの初期選択処理です。
     */
    public void setShutsuryoku() {
        if (div.getTxtShukeiYM1().getValue() != null && !div.getTxtShukeiYM1().getValue().isEmpty()) {
            div.getCblIppan1to10().setDisabled(false);
            一般状況10.clear();
            一般状況10.add(new RString("ippan1_11"));
            div.getCblIppan1to10().setSelectedItemsByKey(一般状況10);
        }
        if (div.getTxtShukeiYM2().getValue() == null || div.getTxtShukeiYM2().getValue().isEmpty()
                && div.getTxtShukeiYM3().getValue() == null || div.getTxtShukeiYM3().getValue().isEmpty()) {
            setCblGassan1();
        } else {
            一般状況_合算.clear();
            一般状況_合算.add(ALL);
            div.getCblGassan1().setSelectedItemsByKey(一般状況_合算);
        }
        if (div.getTxtShukeiYM4().getValue() == null || div.getTxtShukeiYM4().getValue().isEmpty()
                && div.getTxtShukeiYM5().getValue() == null || div.getTxtShukeiYM5().getValue().isEmpty()) {
            setCblGassan2();
        } else {
            決定状況合算.clear();
            決定状況合算.add(ALL);
            div.getCblGassan2().setSelectedItemsByKey(決定状況合算);
        }
    }

    /**
     * すべて選択チェックボックス操作不可設定の処理です。
     */
    public void setDisDisabledTrueToShutsuryokuAll() {
        if (div.getCblIppan1to10().isDisabled() && div.getCblGassan1().isDisabled() && div.getCblIppanGembutsu().isDisabled()
                && div.getCblIppanShokan().isDisabled() && div.getCblGassan2().isDisabled() && div.getCblHokenKyufuGembutsu().isDisabled()
                && div.getCblHokenKyufuShokan().isDisabled()) {
            div.getCblShutsuryokuAll().setDisabled(true);
        } else {
            div.getCblShutsuryokuAll().setDisabled(false);
        }
    }

    /**
     * 実行ボタン処理です
     *
     * @return HoshuShiharaiJunbiBatchParameter
     */
    public JigyoHokokuRenkeiBatchParameter onClick_btnJikko() {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        List<ShichosonSelectorResult> list = new ArrayList<>();
        if (model != null) {
            list = model.getList();
        }
        List<RString> 市町村コードリスト = new ArrayList<>();
        if (!list.isEmpty()) {
            for (ShichosonSelectorResult result : list) {
                市町村コードリスト.add(result.get市町村コード().value());
            }
        }
        JigyoHokokuRenkeiBatchParameter batchParameter = new JigyoHokokuRenkeiBatchParameter(
                div.getJikkoTanni().getDdlKakoHokokuYM().getSelectedKey(),
                dateToRString(div.getTblShutsuryokuTaisho().getTxtShukeiYM1().getValue()),
                dateToRString(div.getTblShutsuryokuTaisho().getTxtShukeiYM2().getValue()),
                dateToRString(div.getTblShutsuryokuTaisho().getTxtShukeiYM3().getValue()),
                dateToRString(div.getTblShutsuryokuTaisho().getTxtShukeiYM4().getValue()),
                dateToRString(div.getTblShutsuryokuTaisho().getTxtShukeiYM5().getValue()),
                div.getCblIppan1to10().getSelectedKeys().contains(new RString("ippan1_11")),
                div.getCblIppanGembutsu().getSelectedKeys().contains(一般状況14),
                div.getCblIppanShokan().getSelectedKeys().contains(一般状況14)
                && div.getRadShukeiType3().getSelectedKey().equals(審査年月),
                div.getCblIppanShokan().getSelectedKeys().contains(一般状況14)
                && div.getRadShukeiType3().getSelectedKey().equals(決定年月),
                div.getCblGassan1().getSelectedKeys().contains(ALL)
                && div.getRadShukeiType3().getSelectedKey().equals(審査年月),
                div.getCblIppanShokan().getSelectedKeys().contains(ALL)
                && div.getRadShukeiType3().getSelectedKey().equals(決定年月),
                div.getCblHokenKyufuGembutsu().getSelectedKeys().contains(new RString("hokenKyufuGenbutsu")),
                div.getCblHokenKyufuShokan().getSelectedKeys().contains(決定状況償還分)
                && div.getRadShukeiType5().getSelectedKey().equals(審査年月),
                div.getCblHokenKyufuShokan().getSelectedKeys().contains(決定状況償還分)
                && div.getRadShukeiType5().getSelectedKey().equals(決定年月),
                div.getCblGassan2().getSelectedKeys().contains(ALL)
                && div.getRadShukeiType5().getSelectedKey().equals(審査年月),
                div.getCblGassan2().getSelectedKeys().contains(ALL)
                && div.getRadShukeiType5().getSelectedKey().equals(決定年月),
                市町村コードリスト,
                div.getJikkoTanni().getRadHokenshaKyuShichoson().getSelectedKey().equals(new RString("gappei")),
                div.getJikkoTanni().getRadKoikiKoseiShichoson().getSelectedKey().equals(new RString("koseiShichoson"))
        );
        return batchParameter;
    }

    private RString dateToRString(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
