/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0040011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorResult;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030010.DBU030010_JigyoHokokuNenpo_MainParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 事業状況報告（年報）作成Handlerクラスです。
 *
 * @reamsid_L DBU-5600-010 linghuhang
 */
public class JigyoJokyoHokokuNempoSakueiHandler {

    private final JigyoJokyoHokokuNempoSakueiDiv div;
    private static final int 年度始 = 2000;
    private static final int 平成17年度 = 2005;
    private static final int 平成18年度 = 2006;
    private static final int 平成20年度 = 2008;
    private static final int 年度報告月 = 13;
    private static final int INT_ITTI = 1;
    private static final int INT_NI = 2;
    private static final int INT_ZEO = 0;
    private static final int INT_YOU = 4;
    private static final int INT_ROKU = 6;
    private static final RString 市町村識別ID = new RString("00");
    private static final RString 選択する = new RString("1");
    private static final RString 選択無し = new RString("0");
    private static final RString 集計 = new RString("01");
    private static final RString 審査年月で集計選択する = new RString("2");
    private static final RString 決定年月で集計選択する = new RString("3");
    private static final RString 合併情報区分_合併あり = new RString("1");
    private static final RString 審査年月で集計 = new RString("1");
    private static final RString 決定年月で集計 = new RString("2");
    private static final RString 審査年月 = new RString("shinsaYM4");
    private static final RString 決定年月 = new RString("keiteiYM4");
    private static final RString 実行単位選択集計のみ = new RString("ITI");
    private static final RString 実行単位選択集計後に印刷 = new RString("NI");
    private static final RString 実行単位選択過去の集計 = new RString("SAN");
    private static final RString 旧市町村分 = new RString("kyuShichoson");
    private static final RString 構成市町村分 = new RString("koseiShichoson");
    private static final RString 旧市町村分コード = new RString("0");
    private static final RString 構成市町村分コード = new RString("1");
    private static final RString 年報報告様式12KEY = new RString("yoshiki12");
    private static final RString 年報報告一般状況111KEY = new RString("ippan1_11");
    private static final RString 年報報告一般状況1214現物分KEY = new RString("ippan12_14Genbutsu");
    private static final RString 年報報告保険給付決定現物分KEY = new RString("hokenKyufuGenbutsu");
    private static final RString 年報報告一般状況1214償還分KEY = new RString("ippan12_14Shokan");
    private static final RString 年報報告一般状況償還分KEY = new RString("hokenKyufuShokan");
    private static final RString 年報報告一般状況高額分KEY = new RString("hokenKyufuKogaku");
    private static final RString 年報報告一般状況高額合算分KEY = new RString("hokenKyufuKogakuGassan");

    /**
     * コンストラクタです。
     *
     * @param div 事業状況報告（年報）Div
     */
    public JigyoJokyoHokokuNempoSakueiHandler(JigyoJokyoHokokuNempoSakueiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 合併情報区分 合併情報区分
     * @param 導入形態コード 導入形態コード
     * @param 過去集計年度データ 過去集計年度データ
     */
    public void onLoad(RString 合併情報区分, RString 導入形態コード, List<ShoriDateKanri> 過去集計年度データ) {
        boolean is合併あり = false;
        boolean is単一 = false;
        boolean is広域 = false;
        RDate システム日付 = RDate.getNowDate();
        RTime システム時刻 = RDate.getNowTime();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)) {
            is単一 = true;
            div.setHiddenTanitsu(new RString("単一"));
            if (合併情報区分_合併あり.equals(合併情報区分)) {
                is合併あり = true;
                div.setHiddenGappei(new RString("合併"));
            }
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            is広域 = true;
            div.setHiddenKouiki(new RString("広域"));
        }
        set過去の集計結果表示非表示(is合併あり, is単一, is広域);
        div.getDdlHokokuNendo().setDataSource(get報告年度(システム日付));
        div.getDdlKakoHokokuNendo().setDataSource(get過去集計年度(過去集計年度データ));
        set審査年月と決定年月(システム日付);
        set作成日時(システム日付, システム時刻);
        div.getDdlKakoHokokuNendo().setDisabled(true);
        div.setHiddenJikkoTaniZen(実行単位選択集計のみ);
        setチェックボックスクリア();
        set集計と作成非活性();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param 実行単位選択 実行単位選択
     */
    public void onClick_onChangeJikkoTani(RString 実行単位選択) {
        RDate システム日付 = RDate.getNowDate();
        RTime システム時刻 = RDate.getNowTime();
        RString 実行単位選択前 = div.getHiddenJikkoTaniZen();
        if ((実行単位選択集計のみ.equals(実行単位選択前) || 実行単位選択集計後に印刷.equals(実行単位選択前))
                && 実行単位選択過去の集計.equals(実行単位選択)) {
            div.getDdlHokokuNendo().setDisabled(true);
            div.getDdlShukeiFromYM().setDisabled(true);
            div.getDdlShukeiToYM().setDisabled(true);
            div.getDdlHokokuNendo().setSelectedKey(RString.EMPTY);
            div.getDdlShukeiFromYM().setSelectedKey(RString.EMPTY);
            div.getDdlShukeiToYM().setSelectedKey(RString.EMPTY);
            set実行単位選択変更();
            set市町村選択ボタン活性();
            set作成日時();
            set集計エリア();
        }
        if (実行単位選択過去の集計.equals(実行単位選択前)
                && (実行単位選択集計のみ.equals(実行単位選択) || 実行単位選択集計後に印刷.equals(実行単位選択))) {
            div.getDdlHokokuNendo().setDisabled(false);
            div.getDdlShukeiFromYM().setDisabled(false);
            div.getDdlShukeiToYM().setDisabled(false);
            if (!RString.isNullOrEmpty(div.getHiddenGappei())) {
                div.getDdlKakoHokokuNendo().setDisabled(true);
                div.getRadGappeiShichoson().setDisabled(true);
                div.getDdlKakoHokokuNendo().setSelectedKey(RString.EMPTY);
                div.getRadGappeiShichoson().setSelectedKey(new RString("gappei"));
                div.getBtnShichosonSelect().setDisabled(true);
            } else if (!RString.isNullOrEmpty(div.getHiddenKouiki())) {
                div.getDdlKakoHokokuNendo().setDisabled(true);
                div.getRadKoikiRengo().setDisabled(true);
                div.getDdlKakoHokokuNendo().setSelectedKey(RString.EMPTY);
                div.getRadKoikiRengo().setSelectedKey(new RString("koiki"));
                div.getBtnShichosonSelect().setDisabled(true);
            }
            set作成日時(システム日付, システム時刻);
            set集計エリア();
        }
        div.setHiddenJikkoTaniZen(実行単位選択);
        setチェックボックスクリア();
        set集計と作成非活性();
    }

    /**
     * 報告年度を変更する場合、画面を表示する。
     */
    public void onClick_onChangeHokokuNendo() {
        if (!RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedKey())) {
            div.getDdlShukeiFromYM().setDataSource(get報告年月(RString.EMPTY));
            div.getDdlShukeiToYM().setDataSource(get報告年月(new RString("報告終了年月")));
        }
        setチェックボックス状況14();
        setチェックボックス非活性();
        set一般状況集計年月選択ラジオ非活性();
        set保険給付決定集計年月選択ラジオ非活性();
        clean集計年月();
        set集計年度();
        div.getDdlShukeiFromYM().setSelectedKey(RString.EMPTY);
        div.getDdlShukeiToYM().setSelectedKey(RString.EMPTY);
        if (!div.getCblShutsuryokuTaishoHokenKogakuGassan().isDisabled()) {
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況高額合算分KEY);
            div.getCblShutsuryokuTaishoHokenKogakuGassan().setSelectedItemsByKey(年報報告様式);
        }
    }

    /**
     * 報告開始年月を変更する場合、画面を表示する。
     *
     * @param システム日付 システム日付
     */
    public void onClick_onChangeShukeiFromYM(RDate システム日付) {
        RStringBuilder builder = new RStringBuilder();
        RString 状況集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        RString 給付集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        if (!RString.isNullOrEmpty(div.getDdlShukeiFromYM().getSelectedKey())) {
            FlexibleDate 集計開始年月 = new FlexibleDate(builder.append(div.getDdlHokokuNendo().getSelectedKey())
                    .append(div.getDdlShukeiFromYM().getSelectedKey()).toRString());
            if (審査年月で集計.equals(状況集計方法)) {
                div.getTxtShukeiFromYM5().setValue(集計開始年月.minusMonth(INT_ITTI));
                div.setHiddenShukeiFromYM5(new RString(集計開始年月.toString()));
            } else if (決定年月で集計.equals(状況集計方法)) {
                div.getTxtShukeiFromYM5().setValue(集計開始年月);
                div.setHiddenShukeiFromYM5(new RString(集計開始年月.minusMonth(INT_ITTI).toString()));
            }
            if (審査年月で集計.equals(給付集計方法)) {
                div.getTxtShukeiFromYM6().setValue(集計開始年月.minusMonth(INT_ITTI));
                div.setHiddenShukeiFromYM6(new RString(集計開始年月.toString()));
            } else if (決定年月で集計.equals(給付集計方法)) {
                div.getTxtShukeiFromYM6().setValue(集計開始年月);
                div.setHiddenShukeiFromYM6(new RString(集計開始年月.minusMonth(INT_ITTI).toString()));
            }
            div.getTxtShukeiFromYM1().setValue(集計開始年月);
            div.getTxtShukeiFromYM2().setValue(集計開始年月);
            div.getTxtShukeiFromYM3().setValue(集計開始年月);
            div.getTxtShukeiFromYM4().setValue(集計開始年月);
            div.getTxtShukeiFromYM7().setValue(集計開始年月);
            div.getTxtShukeiFromYM8().setValue(集計開始年月);
        } else {
            div.getTxtShukeiFromYM1().clearValue();
            div.getTxtShukeiFromYM2().clearValue();
            div.getTxtShukeiFromYM3().clearValue();
            div.getTxtShukeiFromYM4().clearValue();
            div.getTxtShukeiFromYM5().clearValue();
            div.setHiddenShukeiFromYM5(RString.EMPTY);
            div.getTxtShukeiFromYM6().clearValue();
            div.setHiddenShukeiFromYM6(RString.EMPTY);
            div.getTxtShukeiFromYM7().clearValue();
            div.getTxtShukeiFromYM8().clearValue();
        }
        setチェックボックス状況14();
        setチェックボックス非活性();
        set一般状況集計年月選択ラジオ非活性();
        set保険給付決定集計年月選択ラジオ非活性();
    }

    /**
     * 報告終了年月を変更する場合、画面を表示する。
     *
     * @param システム日付 システム日付
     */
    public void onClick_onChangeShukeiToYM(RDate システム日付) {
        RStringBuilder builder = new RStringBuilder();
        RString 状況集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        RString 給付集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        if (!RString.isNullOrEmpty(div.getDdlShukeiToYM().getSelectedKey())) {
            FlexibleDate 報告終了年月 = new FlexibleDate(builder.append(div.getDdlHokokuNendo().getSelectedKey())
                    .append(div.getDdlShukeiToYM().getSelectedKey()).toRString());
            if (審査年月で集計.equals(状況集計方法)) {
                div.getTxtShukeiToYM5().setValue(報告終了年月.minusMonth(INT_ITTI));
                div.setHiddenShukeiToYM5(new RString(報告終了年月.toString()));
            } else if (決定年月で集計.equals(状況集計方法)) {
                div.getTxtShukeiToYM5().setValue(報告終了年月);
                div.setHiddenShukeiToYM5(new RString(報告終了年月.minusMonth(INT_ITTI).toString()));
            }
            if (審査年月で集計.equals(給付集計方法)) {
                div.getTxtShukeiToYM6().setValue(報告終了年月.minusMonth(INT_ITTI));
                div.setHiddenShukeiToYM6(new RString(報告終了年月.toString()));
            } else if (決定年月で集計.equals(給付集計方法)) {
                div.getTxtShukeiToYM6().setValue(報告終了年月);
                div.setHiddenShukeiToYM6(new RString(報告終了年月.minusMonth(INT_ITTI).toString()));
            }
            div.getTxtShukeiToYM1().setValue(報告終了年月);
            div.getTxtShukeiToYM2().setValue(報告終了年月);
            div.getTxtShukeiToYM3().setValue(報告終了年月);
            div.getTxtShukeiToYM4().setValue(報告終了年月);
            div.getTxtShukeiToYM7().setValue(報告終了年月);
            div.getTxtShukeiToYM8().setValue(報告終了年月);
        } else {
            div.getTxtShukeiToYM1().clearValue();
            div.getTxtShukeiToYM2().clearValue();
            div.getTxtShukeiToYM3().clearValue();
            div.getTxtShukeiToYM4().clearValue();
            div.getTxtShukeiToYM5().clearValue();
            div.setHiddenShukeiToYM5(RString.EMPTY);
            div.getTxtShukeiToYM6().clearValue();
            div.setHiddenShukeiToYM6(RString.EMPTY);
            div.getTxtShukeiToYM7().clearValue();
            div.getTxtShukeiToYM8().clearValue();
        }
        setチェックボックス状況14();
        setチェックボックス非活性();
        set一般状況集計年月選択ラジオ非活性();
        set保険給付決定集計年月選択ラジオ非活性();
    }

    /**
     * 過去集計年度を変更する場合、画面を表示する。
     *
     * @param 様式12処理日付管理情報 様式12処理日付管理情報
     * @param 一般状況111処理日付管理情報 一般状況111処理日付管理情報
     * @param 一般状況1214現物分処理日付管理情報 一般状況1214現物分処理日付管理情報
     * @param 給付決定現物分処理日付管理情報 給付決定現物分処理日付管理情報
     * @param 一般状況1214償還分審査処理日付管理情報 一般状況1214償還分審査処理日付管理情報
     * @param 一般状況1214償還分決定処理日付管理情報 一般状況1214償還分決定処理日付管理情報
     * @param 給付決定償還分審査処理日付管理情報 給付決定償還分審査処理日付管理情報
     * @param 給付決定償還分決定処理日付管理情報 給付決定償還分決定処理日付管理情報
     * @param 給付決定高額分処理日付管理情報 給付決定高額分処理日付管理情報
     * @param 給付決定高額合算分処理日付管理情報 給付決定高額合算分処理日付管理情報
     * @param システム日付 システム日付
     */
    public void onClick_onChangeKakoHokokuNendo(ShoriDateKanri 様式12処理日付管理情報,
            ShoriDateKanri 一般状況111処理日付管理情報,
            ShoriDateKanri 一般状況1214現物分処理日付管理情報,
            ShoriDateKanri 給付決定現物分処理日付管理情報,
            ShoriDateKanri 一般状況1214償還分審査処理日付管理情報,
            ShoriDateKanri 一般状況1214償還分決定処理日付管理情報,
            ShoriDateKanri 給付決定償還分審査処理日付管理情報,
            ShoriDateKanri 給付決定償還分決定処理日付管理情報,
            ShoriDateKanri 給付決定高額分処理日付管理情報,
            ShoriDateKanri 給付決定高額合算分処理日付管理情報, RDate システム日付) {
        RString 状況集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        RString 給付集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        set集計エリア();
        set作成日時();
        if (様式12処理日付管理情報 != null) {
            div.getTxttxtShukeiNendo1().setValue(new FlexibleDate(様式12処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM1().setValue(様式12処理日付管理情報.get対象開始年月日());
            div.getTxtShukeiToYM1().setValue(様式12処理日付管理情報.get対象終了年月日());
            div.getTxtSakuseiYMD1().setValue(new FlexibleDate(様式12処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime1().setValue(様式12処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        if (一般状況111処理日付管理情報 != null) {
            div.getTxtShukeiNendo2().setValue(new FlexibleDate(一般状況111処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM2().setValue(一般状況111処理日付管理情報.get対象開始年月日());
            div.getTxtShukeiToYM2().setValue(一般状況111処理日付管理情報.get対象終了年月日());
            div.getTxtSakuseiYMD2().setValue(new FlexibleDate(一般状況111処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime2().setValue(一般状況111処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        if (一般状況1214現物分処理日付管理情報 != null) {
            div.getTxtShukeiNendo3().setValue(new FlexibleDate(一般状況1214現物分処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM3().setValue(一般状況1214現物分処理日付管理情報.get対象開始年月日());
            div.getTxtShukeiToYM3().setValue(一般状況1214現物分処理日付管理情報.get対象終了年月日());
            div.getTxtSakuseiYMD3().setValue(new FlexibleDate(一般状況1214現物分処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime3().setValue(一般状況1214現物分処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        if (給付決定現物分処理日付管理情報 != null) {
            div.getTxtShukeiNendo4().setValue(new FlexibleDate(給付決定現物分処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM4().setValue(給付決定現物分処理日付管理情報.get対象開始年月日());
            div.getTxtShukeiToYM4().setValue(給付決定現物分処理日付管理情報.get対象終了年月日());
            div.getTxtSakuseiYMD4().setValue(new FlexibleDate(給付決定現物分処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime4().setValue(給付決定現物分処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        set集計年月選択ラジオ項目設定(一般状況1214償還分審査処理日付管理情報,
                一般状況1214償還分決定処理日付管理情報,
                給付決定償還分審査処理日付管理情報,
                給付決定償還分決定処理日付管理情報, 状況集計方法, 給付集計方法);
        if (給付決定高額分処理日付管理情報 != null) {
            div.getTxtShukeiNendo7().setValue(new FlexibleDate(給付決定高額分処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM7().setValue(給付決定高額分処理日付管理情報.get対象開始年月日());
            div.getTxtShukeiToYM7().setValue(給付決定高額分処理日付管理情報.get対象終了年月日());
            div.getTxtSakuseiYMD7().setValue(new FlexibleDate(給付決定高額分処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime7().setValue(給付決定高額分処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        if (給付決定高額合算分処理日付管理情報 != null) {
            div.getTxtShukeiNendo8().setValue(new FlexibleDate(給付決定高額合算分処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM8().setValue(給付決定高額合算分処理日付管理情報.get対象開始年月日());
            div.getTxtShukeiToYM8().setValue(給付決定高額合算分処理日付管理情報.get対象終了年月日());
            div.getTxtSakuseiYMD8().setValue(new FlexibleDate(給付決定高額合算分処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime8().setValue(給付決定高額合算分処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        setチェックボックス状況14();
        setチェックボックス非活性();
        set一般状況集計年月選択ラジオ非活性();
        set保険給付決定集計年月選択ラジオ非活性();
    }

    /**
     * 合併市町村用保険者選択ラジオボタンを変更する場合、画面を表示する。
     */
    public void onClick_onChangeGappeiShichoson() {
        if (旧市町村分.equals(div.getRadGappeiShichoson().getSelectedKey())) {
            div.getBtnShichosonSelect().setDisabled(false);
            div.setShichosonKubun(旧市町村分コード);
        } else {
            div.getBtnShichosonSelect().setDisabled(true);
            div.setShichosonKubun(RString.EMPTY);
        }
    }

    /**
     * 広域構成市町村用保険者選択ラジオボタンを変更する場合、画面を表示する。
     */
    public void onClick_onChangeKoikiRengo() {
        if (構成市町村分.equals(div.getRadKoikiRengo().getSelectedKey())) {
            div.getBtnShichosonSelect().setDisabled(false);
            div.setShichosonKubun(構成市町村分コード);
        } else {
            div.getBtnShichosonSelect().setDisabled(true);
            div.setShichosonKubun(RString.EMPTY);
        }
    }

    /**
     * （すべて選択）チェックボックスを変更する場合、画面を表示する。
     */
    public void onClick_onChangeAll() {
        if (div.getCblShutsuryokuTaishoAll().isAllSelected()) {
            if (!div.getCblShutsuryokuTaishoYoshiki1().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告様式12KEY);
                div.getCblShutsuryokuTaishoYoshiki1().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoIppan1to11().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告一般状況111KEY);
                div.getCblShutsuryokuTaishoIppan1to11().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoIppanGembutsu().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告一般状況1214現物分KEY);
                div.getCblShutsuryokuTaishoIppanGembutsu().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoHokenGembutsu().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告保険給付決定現物分KEY);
                div.getCblShutsuryokuTaishoHokenGembutsu().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoIppanShokan().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告一般状況1214償還分KEY);
                div.getCblShutsuryokuTaishoIppanShokan().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoHokenShokan().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告一般状況償還分KEY);
                div.getCblShutsuryokuTaishoHokenShokan().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoHokenKogaku().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告一般状況高額分KEY);
                div.getCblShutsuryokuTaishoHokenKogaku().setSelectedItemsByKey(年報報告様式);
            }
            if (!div.getCblShutsuryokuTaishoHokenKogakuGassan().isDisabled()) {
                List<RString> 年報報告様式 = new ArrayList<>();
                年報報告様式.add(年報報告一般状況高額合算分KEY);
                div.getCblShutsuryokuTaishoHokenKogakuGassan().setSelectedItemsByKey(年報報告様式);
            }
        } else {
            setチェックボックスクリア();
        }
    }

    /**
     * 一般状況チェックボックスを変更する場合、画面を表示する。
     */
    public void onClick_onChangeIppan() {
        div.getTxtSakuseiYMD1().setDisabled(true);
        div.getTxtSakuseiTime1().setDisabled(true);
        div.getTxtSakuseiYMD2().setDisabled(true);
        div.getTxtSakuseiTime2().setDisabled(true);
        div.getTxtSakuseiYMD3().setDisabled(true);
        div.getTxtSakuseiTime3().setDisabled(true);
        div.getTxtSakuseiYMD4().setDisabled(true);
        div.getTxtSakuseiTime4().setDisabled(true);
        div.getTxtSakuseiYMD7().setDisabled(true);
        div.getTxtSakuseiTime7().setDisabled(true);
        if (div.getCblShutsuryokuTaishoYoshiki1().getSelectedKeys().contains(年報報告様式12KEY)) {
            div.getTxtSakuseiYMD1().setDisabled(false);
            div.getTxtSakuseiTime1().setDisabled(false);
        }
        if (div.getCblShutsuryokuTaishoIppan1to11().getSelectedKeys().contains(年報報告一般状況111KEY)) {
            div.getTxtSakuseiYMD2().setDisabled(false);
            div.getTxtSakuseiTime2().setDisabled(false);
        }
        if (div.getCblShutsuryokuTaishoIppanGembutsu().getSelectedKeys().contains(年報報告一般状況1214現物分KEY)) {
            div.getTxtSakuseiYMD3().setDisabled(false);
            div.getTxtSakuseiTime3().setDisabled(false);
        }
        if (div.getCblShutsuryokuTaishoHokenGembutsu().getSelectedKeys().contains(年報報告保険給付決定現物分KEY)) {
            div.getTxtSakuseiYMD4().setDisabled(false);
            div.getTxtSakuseiTime4().setDisabled(false);
        }
        if (div.getCblShutsuryokuTaishoHokenKogaku().getSelectedKeys().contains(年報報告一般状況高額分KEY)) {
            div.getTxtSakuseiYMD7().setDisabled(false);
            div.getTxtSakuseiTime7().setDisabled(false);
        }
    }

    /**
     * 一般状況12～14【償還分】と保険給付決定状況【償還分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param 一般状況 一般状況
     */
    public void onClick_onChangeIppanShokan(RString 一般状況) {
        if (RString.isNullOrEmpty(一般状況)) {
            div.getTxtSakuseiYMD5().setDisabled(true);
            div.getTxtSakuseiTime5().setDisabled(true);
            div.getRadlblShukeiType4().setDisabled(true);
            if (div.getCblShutsuryokuTaishoIppanShokan().getSelectedKeys().contains(年報報告一般状況1214償還分KEY)) {
                div.getTxtSakuseiYMD5().setDisabled(false);
                div.getTxtSakuseiTime5().setDisabled(false);
                div.getRadlblShukeiType4().setDisabled(false);
                set一般状況集計年月選択ラジオ非活性();
            }
        } else {
            div.getTxtSakuseiYMD6().setDisabled(true);
            div.getTxtSakuseiTime6().setDisabled(true);
            div.getRadlblShukeiType5().setDisabled(true);
            if (div.getCblShutsuryokuTaishoHokenShokan().getSelectedKeys().contains(年報報告一般状況償還分KEY)) {
                div.getTxtSakuseiYMD6().setDisabled(false);
                div.getTxtSakuseiTime6().setDisabled(false);
                div.getRadlblShukeiType5().setDisabled(false);
                set保険給付決定集計年月選択ラジオ非活性();
            }
        }

    }

    /**
     * 保険給付決定状況【高額合算分】チェックボックスを変更する場合、画面を表示する。
     */
    public void onClick_onChangeGassan() {
        div.getTxtSakuseiYMD8().setDisabled(true);
        div.getTxtSakuseiTime8().setDisabled(true);
        if (div.getCblShutsuryokuTaishoHokenKogakuGassan().getSelectedKeys().contains(年報報告一般状況高額合算分KEY)) {
            div.getTxtSakuseiYMD8().setDisabled(false);
            div.getTxtSakuseiTime8().setDisabled(false);
        }
    }

    /**
     * 集計年月選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param 一般状況 一般状況
     */
    public void onClick_onChangeShukeiType(RString 一般状況) {
        RString 開始年月別設定用;
        RString 終了年月別設定用;
        if (RString.isNullOrEmpty(一般状況)) {
            開始年月別設定用 = div.getHiddenShukeiFromYM5();
            終了年月別設定用 = div.getHiddenShukeiToYM5();
            div.setHiddenShukeiFromYM5(new RString(div.getTxtShukeiFromYM5().getValue().toString()));
            div.setHiddenShukeiToYM5(new RString(div.getTxtShukeiToYM5().getValue().toString()));
            if (!RString.isNullOrEmpty(開始年月別設定用)) {
                div.getTxtShukeiFromYM5().setValue(new FlexibleDate(開始年月別設定用));

            }
            if (!RString.isNullOrEmpty(終了年月別設定用)) {
                div.getTxtShukeiToYM5().setValue(new FlexibleDate(終了年月別設定用));
            }
        } else {
            開始年月別設定用 = div.getHiddenShukeiFromYM6();
            終了年月別設定用 = div.getHiddenShukeiToYM6();
            div.setHiddenShukeiFromYM6(new RString(div.getTxtShukeiFromYM6().getValue().toString()));
            div.setHiddenShukeiToYM6(new RString(div.getTxtShukeiToYM6().getValue().toString()));
            if (!RString.isNullOrEmpty(開始年月別設定用)) {
                div.getTxtShukeiFromYM6().setValue(new FlexibleDate(開始年月別設定用));
            }
            if (!RString.isNullOrEmpty(終了年月別設定用)) {
                div.getTxtShukeiToYM6().setValue(new FlexibleDate(終了年月別設定用));
            }
        }
    }

    /**
     * 実行するボタンを押下する場合、パラメータを設定する。
     *
     * @param 市町村情報 市町村情報
     * @param 引き継ぎデータ 引き継ぎデータ
     * @param 市町村識別 市町村識別
     * @param 現市町村情報 現市町村情報
     * @param 合併市町村情報 合併市町村情報
     * @return DBU030010_JigyoHokokuNenpo_MainParameter
     */
    public DBU030010_JigyoHokokuNenpo_MainParameter onClick_btnBatchParamSave(KoseiShichosonJoho 市町村情報,
            ShichosonSelectorModel 引き継ぎデータ, List<AuthorityItem> 市町村識別,
            List<KoikiZenShichosonJoho> 現市町村情報, List<GappeiCityJyoho> 合併市町村情報) {
        DBU030010_JigyoHokokuNenpo_MainParameter parameter = new DBU030010_JigyoHokokuNenpo_MainParameter();
        List<RString> 構成市町村コードリスト = new ArrayList<>();
        RString 市町村コード = RString.EMPTY;
        parameter.set報告開始年月(RString.EMPTY);
        parameter.set報告終了年月(RString.EMPTY);
        if (!RString.isNullOrEmpty(div.getRadJikkoTaniShukeiOnly().getSelectedKey())) {
            parameter.setプリントコントロール区分(new RString("1"));
            parameter.set報告年度(div.getDdlHokokuNendo().getSelectedKey());
            parameter.set報告開始年月(div.getDdlShukeiFromYM().getSelectedKey());
            parameter.set報告終了年月(div.getDdlShukeiToYM().getSelectedKey());
        } else if (!RString.isNullOrEmpty(div.getRadJikkoTani2().getSelectedKey())) {
            parameter.setプリントコントロール区分(new RString("2"));
            parameter.set報告年度(div.getDdlHokokuNendo().getSelectedKey());
            parameter.set報告開始年月(div.getDdlShukeiFromYM().getSelectedKey());
            parameter.set報告終了年月(div.getDdlShukeiToYM().getSelectedKey());
        } else {
            parameter.setプリントコントロール区分(new RString("3"));
            parameter.set報告年度(div.getDdlKakoHokokuNendo().getSelectedKey());
        }
        parameter.set処理日時(RDate.getNowDateTime());
        parameter.set旧市町村区分(div.getHiddenGappeiKoseiKubun());
        parameter.set構成市町村区分(new RString("0"));
        if (DonyuKeitaiCode.事務広域.getCode().equals(div.getHiddenDonyuKeitaiCode())) {
            parameter.set構成市町村区分(new RString("1"));
        }
        if (!RString.isNullOrEmpty(div.getHiddenTanitsu()) && 市町村情報 != null
                && 市町村情報.get市町村コード() != null
                && !市町村情報.get市町村コード().isEmpty()) {
            市町村コード = 市町村情報.get市町村コード().value();
        }
        parameter.set市町村コード(市町村コード);
        if (!RString.isNullOrEmpty(div.getHiddenKouiki())) {
            if (市町村識別ID.equals(市町村識別.get(0).getItemId())) {
                parameter.set構成市町村コードリスト(get構成市町村コードリスト(現市町村情報));
            } else {
                構成市町村コードリスト.add(市町村コード);
                parameter.set構成市町村コードリスト(構成市町村コードリスト);
            }
        }
        if (!RString.isNullOrEmpty(div.getHiddenGappei())) {
            parameter.set旧市町村コードリスト(get旧市町村コードリスト(合併市町村情報));
        }
        if (引き継ぎデータ != null) {
            if (引き継ぎデータ.getList() != null && !引き継ぎデータ.getList().isEmpty()) {
                parameter.set過去集計分旧市町村区分(
                        get過去集計分旧市町村区分(引き継ぎデータ.getList().get(0).get市町村コード().value(),
                                parameter.get旧市町村コードリスト()));
            }
            parameter.set過去集計分市町村コードリスト(get過去集計分市町村コードリスト(引き継ぎデータ.getList()));
        }

        return set出力区分(parameter);
    }

    private void set実行単位選択変更() {
        if (!RString.isNullOrEmpty(div.getHiddenGappei())) {
            div.getDdlKakoHokokuNendo().setDisabled(false);
            div.getRadGappeiShichoson().setDisabled(false);
            div.getDdlKakoHokokuNendo().setSelectedKey(RString.EMPTY);
            div.getRadGappeiShichoson().setSelectedKey(new RString("gappei"));
            div.getBtnShichosonSelect().setDisabled(true);
        } else if (!RString.isNullOrEmpty(div.getHiddenKouiki())) {
            div.getDdlKakoHokokuNendo().setDisabled(false);
            div.getRadKoikiRengo().setDisabled(false);
            div.getDdlKakoHokokuNendo().setSelectedKey(RString.EMPTY);
            div.getRadKoikiRengo().setSelectedKey(new RString("koiki"));
            div.getBtnShichosonSelect().setDisabled(true);
        }
    }

    private void set市町村選択ボタン活性() {
        if (!RString.isNullOrEmpty(div.getHiddenGappei())) {
            div.getRadGappeiShichoson().setDisabled(false);
            if (旧市町村分.equals(div.getRadGappeiShichoson().getSelectedKey())) {
                div.getBtnShichosonSelect().setDisabled(false);
            }
        } else if (!RString.isNullOrEmpty(div.getHiddenKouiki())) {
            div.getRadKoikiRengo().setDisabled(false);
            if (構成市町村分.equals(div.getRadKoikiRengo().getSelectedKey())) {
                div.getBtnShichosonSelect().setDisabled(false);
            }
        }
    }

    private void set過去の集計結果表示非表示(boolean is合併あり, boolean is単一, boolean is広域) {
        if (is単一) {
            div.getRadGappeiShichoson().setDisplayNone(true);
            div.getRadKoikiRengo().setDisplayNone(true);
            div.getBtnShichosonSelect().setDisplayNone(true);
            if (is合併あり) {
                div.getRadGappeiShichoson().setDisplayNone(false);
                div.getBtnShichosonSelect().setDisplayNone(false);
                div.getRadKoikiRengo().setDisplayNone(true);
                div.getBtnShichosonSelect().setDisabled(true);
                div.getRadGappeiShichoson().setDisabled(true);
            }
        } else if (is広域) {
            div.getRadGappeiShichoson().setDisplayNone(true);
            div.getBtnShichosonSelect().setDisabled(true);
            div.getRadKoikiRengo().setDisabled(true);
        }
    }

    private List<KeyValueDataSource> get報告年度(RDate システム日付) {
        List<KeyValueDataSource> keyValue = new ArrayList<>();
        for (int 年度 = 年度始; 年度 <= システム日付.getYearValue(); 年度++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(年度));
            dataSource.setValue(new RDate(年度).wareki().getYear());
            keyValue.add(dataSource);
        }
        Collections.sort(keyValue, new DateComparator());
        return keyValue;
    }

    private List<KeyValueDataSource> get過去集計年度(List<ShoriDateKanri> 過去集計年度データ) {
        List<KeyValueDataSource> keyValue = new ArrayList<>();
        List<RString> key = new ArrayList<>();
        for (ShoriDateKanri 過去集計年度 : 過去集計年度データ) {
            if (!key.contains(new RString(過去集計年度.get年度().getYearValue()))) {
                KeyValueDataSource dataSource = new KeyValueDataSource();
                dataSource.setKey(new RString(過去集計年度.get年度().getYearValue()));
                dataSource.setValue(new RDate(過去集計年度.get年度().toString()).wareki().getYear());
                key.add(new RString(過去集計年度.get年度().getYearValue()));
                keyValue.add(dataSource);
            }
        }
        Collections.sort(keyValue, new DateComparator());
        return keyValue;
    }

    private List<KeyValueDataSource> get報告年月(RString 報告終了年月) {
        List<KeyValueDataSource> keyValue = new ArrayList<>();
        for (int i = 1; i < 年度報告月; i++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(i).padZeroToLeft(INT_NI));
            dataSource.setValue(new RString(i).padZeroToLeft(INT_NI));
            keyValue.add(dataSource);
        }
        if (!RString.isNullOrEmpty(報告終了年月)) {
            Collections.sort(keyValue, new DateComparator());
        }
        return keyValue;
    }

    private void set審査年月と決定年月(RDate システム日付) {
        RString 状況集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        RString 給付集計方法 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, システム日付, SubGyomuCode.DBU介護統計報告);
        if (審査年月で集計.equals(状況集計方法)) {
            div.getRadlblShukeiType4().setSelectedKey(審査年月);
        } else if (決定年月で集計.equals(状況集計方法)) {
            div.getRadlblShukeiType4().setSelectedKey(決定年月);
        }
        if (審査年月で集計.equals(給付集計方法)) {
            div.getRadlblShukeiType5().setSelectedKey(審査年月);
        } else if (決定年月で集計.equals(給付集計方法)) {
            div.getRadlblShukeiType5().setSelectedKey(決定年月);
        }
    }

    private void set作成日時(RDate システム日付, RTime システム時刻) {
        FlexibleDate システム日期 = new FlexibleDate(システム日付.toDateString());
        div.getTxtSakuseiYMD1().setValue(システム日期);
        div.getTxtSakuseiTime1().setValue(システム時刻);
        div.getTxtSakuseiYMD2().setValue(システム日期);
        div.getTxtSakuseiTime2().setValue(システム時刻);
        div.getTxtSakuseiYMD3().setValue(システム日期);
        div.getTxtSakuseiTime3().setValue(システム時刻);
        div.getTxtSakuseiYMD4().setValue(システム日期);
        div.getTxtSakuseiTime4().setValue(システム時刻);
        div.getTxtSakuseiYMD5().setValue(システム日期);
        div.getTxtSakuseiTime5().setValue(システム時刻);
        div.getTxtSakuseiYMD6().setValue(システム日期);
        div.getTxtSakuseiTime6().setValue(システム時刻);
        div.getTxtSakuseiYMD7().setValue(システム日期);
        div.getTxtSakuseiTime7().setValue(システム時刻);
        div.getTxtSakuseiYMD8().setValue(システム日期);
        div.getTxtSakuseiTime8().setValue(システム時刻);
    }

    private void set作成日時() {
        div.getTxtSakuseiYMD1().clearValue();
        div.getTxtSakuseiTime1().clearValue();
        div.getTxtSakuseiYMD2().clearValue();
        div.getTxtSakuseiTime2().clearValue();
        div.getTxtSakuseiYMD3().clearValue();
        div.getTxtSakuseiTime3().clearValue();
        div.getTxtSakuseiYMD4().clearValue();
        div.getTxtSakuseiTime4().clearValue();
        div.getTxtSakuseiYMD5().clearValue();
        div.getTxtSakuseiTime5().clearValue();
        div.getTxtSakuseiYMD6().clearValue();
        div.getTxtSakuseiTime6().clearValue();
        div.getTxtSakuseiYMD7().clearValue();
        div.getTxtSakuseiTime7().clearValue();
        div.getTxtSakuseiYMD8().clearValue();
        div.getTxtSakuseiTime8().clearValue();
    }

    private void setチェックボックス状況14() {
        boolean is年報報告様式12 = false;
        boolean is年報報告一般状況111 = false;
        boolean is年報報告一般状況1214現物分 = false;
        boolean is年報報告保険給付決定現物分 = false;
        boolean is年報報告一般状況1214償還分 = false;
        boolean is年報報告一般状況償還分 = false;
        boolean is年報報告一般状況高額分 = false;
        boolean is年報報告一般状況高額合算分 = false;
        div.getCblShutsuryokuTaishoAll().setDisabled(true);
        div.getCblShutsuryokuTaishoYoshiki1().setDisabled(true);
        div.getCblShutsuryokuTaishoIppan1to11().setDisabled(true);
        div.getCblShutsuryokuTaishoIppanGembutsu().setDisabled(true);
        div.getCblShutsuryokuTaishoHokenGembutsu().setDisabled(true);
        div.getCblShutsuryokuTaishoIppanShokan().setDisabled(true);
        div.getCblShutsuryokuTaishoHokenShokan().setDisabled(true);
        div.getCblShutsuryokuTaishoHokenKogaku().setDisabled(true);
        div.getCblShutsuryokuTaishoHokenKogakuGassan().setDisabled(true);
        div.getTxtSakuseiYMD1().setDisabled(true);
        div.getTxtSakuseiTime1().setDisabled(true);
        div.getTxtSakuseiYMD2().setDisabled(true);
        div.getTxtSakuseiTime2().setDisabled(true);
        div.getTxtSakuseiYMD3().setDisabled(true);
        div.getTxtSakuseiTime3().setDisabled(true);
        div.getTxtSakuseiYMD4().setDisabled(true);
        div.getTxtSakuseiTime4().setDisabled(true);
        div.getTxtSakuseiYMD5().setDisabled(true);
        div.getTxtSakuseiTime5().setDisabled(true);
        div.getTxtSakuseiYMD6().setDisabled(true);
        div.getTxtSakuseiTime6().setDisabled(true);
        div.getTxtSakuseiYMD7().setDisabled(true);
        div.getTxtSakuseiTime7().setDisabled(true);
        div.getTxtSakuseiYMD8().setDisabled(true);
        div.getTxtSakuseiTime8().setDisabled(true);
        List<RString> key = new ArrayList<>();
        if (div.getTxtShukeiFromYM1().getValue() != null && !div.getTxtShukeiFromYM1().getValue().isEmpty()
                && div.getTxtShukeiToYM1().getValue() != null && !div.getTxtShukeiToYM1().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoYoshiki1().setDisabled(is年報報告様式12);
            div.getTxtSakuseiYMD1().setDisabled(is年報報告様式12);
            div.getTxtSakuseiTime1().setDisabled(is年報報告様式12);
            is年報報告様式12 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告様式12KEY);
            div.getCblShutsuryokuTaishoYoshiki1().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoYoshiki1().setSelectedItemsByKey(key);
        }
        if (div.getTxtShukeiFromYM2().getValue() != null && !div.getTxtShukeiFromYM2().getValue().isEmpty()
                && div.getTxtShukeiToYM2().getValue() != null && !div.getTxtShukeiToYM2().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoIppan1to11().setDisabled(is年報報告一般状況111);
            div.getTxtSakuseiYMD2().setDisabled(is年報報告一般状況111);
            div.getTxtSakuseiTime2().setDisabled(is年報報告一般状況111);
            is年報報告一般状況111 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況111KEY);
            div.getCblShutsuryokuTaishoIppan1to11().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoIppan1to11().setSelectedItemsByKey(key);
        }
        if (div.getTxtShukeiFromYM3().getValue() != null && !div.getTxtShukeiFromYM3().getValue().isEmpty()
                && div.getTxtShukeiToYM3().getValue() != null && !div.getTxtShukeiToYM3().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoIppanGembutsu().setDisabled(is年報報告一般状況1214現物分);
            div.getTxtSakuseiYMD3().setDisabled(is年報報告一般状況1214現物分);
            div.getTxtSakuseiTime3().setDisabled(is年報報告一般状況1214現物分);
            is年報報告一般状況1214現物分 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況1214現物分KEY);
            div.getCblShutsuryokuTaishoIppanGembutsu().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoIppanGembutsu().setSelectedItemsByKey(key);
        }
        if (div.getTxtShukeiFromYM4().getValue() != null && !div.getTxtShukeiFromYM4().getValue().isEmpty()
                && div.getTxtShukeiToYM4().getValue() != null && !div.getTxtShukeiToYM4().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoHokenGembutsu().setDisabled(is年報報告保険給付決定現物分);
            div.getTxtSakuseiYMD4().setDisabled(is年報報告保険給付決定現物分);
            div.getTxtSakuseiTime4().setDisabled(is年報報告保険給付決定現物分);
            is年報報告保険給付決定現物分 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告保険給付決定現物分KEY);
            div.getCblShutsuryokuTaishoHokenGembutsu().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoHokenGembutsu().setSelectedItemsByKey(key);
        }
        setチェックボックス状況58(is年報報告様式12,
                is年報報告一般状況111,
                is年報報告一般状況1214現物分,
                is年報報告保険給付決定現物分,
                is年報報告一般状況1214償還分,
                is年報報告一般状況償還分,
                is年報報告一般状況高額分,
                is年報報告一般状況高額合算分);
    }

    private void setチェックボックス状況58(boolean is年報報告様式12,
            boolean is年報報告一般状況111,
            boolean is年報報告一般状況1214現物分,
            boolean is年報報告保険給付決定現物分,
            boolean is年報報告一般状況1214償還分,
            boolean is年報報告一般状況償還分,
            boolean is年報報告一般状況高額分,
            boolean is年報報告一般状況高額合算分) {
        List<RString> key = new ArrayList<>();
        if (div.getTxtShukeiFromYM5().getValue() != null && !div.getTxtShukeiFromYM5().getValue().isEmpty()
                && div.getTxtShukeiToYM5().getValue() != null && !div.getTxtShukeiToYM5().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoIppanShokan().setDisabled(is年報報告一般状況1214償還分);
            div.getTxtSakuseiYMD5().setDisabled(is年報報告一般状況1214償還分);
            div.getTxtSakuseiTime5().setDisabled(is年報報告一般状況1214償還分);
            is年報報告一般状況1214償還分 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況1214償還分KEY);
            div.getCblShutsuryokuTaishoIppanShokan().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoIppanShokan().setSelectedItemsByKey(key);
        }
        if (div.getTxtShukeiFromYM6().getValue() != null && !div.getTxtShukeiFromYM6().getValue().isEmpty()
                && div.getTxtShukeiToYM6().getValue() != null && !div.getTxtShukeiToYM6().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoHokenShokan().setDisabled(is年報報告一般状況償還分);
            div.getTxtSakuseiYMD6().setDisabled(is年報報告一般状況償還分);
            div.getTxtSakuseiTime6().setDisabled(is年報報告一般状況償還分);
            is年報報告一般状況償還分 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況償還分KEY);
            div.getCblShutsuryokuTaishoHokenShokan().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoHokenShokan().setSelectedItemsByKey(key);
        }
        if (div.getTxtShukeiFromYM7().getValue() != null && !div.getTxtShukeiFromYM7().getValue().isEmpty()
                && div.getTxtShukeiToYM7().getValue() != null && !div.getTxtShukeiToYM7().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoHokenKogaku().setDisabled(is年報報告一般状況高額分);
            div.getTxtSakuseiYMD7().setDisabled(is年報報告一般状況高額分);
            div.getTxtSakuseiTime7().setDisabled(is年報報告一般状況高額分);
            is年報報告一般状況高額分 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況高額分KEY);
            div.getCblShutsuryokuTaishoHokenKogaku().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoHokenKogaku().setSelectedItemsByKey(key);
        }
        if (div.getTxtShukeiFromYM8().getValue() != null && !div.getTxtShukeiFromYM8().getValue().isEmpty()
                && div.getTxtShukeiToYM8().getValue() != null && !div.getTxtShukeiToYM8().getValue().isEmpty()) {
            div.getCblShutsuryokuTaishoHokenKogakuGassan().setDisabled(is年報報告一般状況高額合算分);
            div.getTxtSakuseiYMD8().setDisabled(is年報報告一般状況高額合算分);
            div.getTxtSakuseiTime8().setDisabled(is年報報告一般状況高額合算分);
            is年報報告一般状況高額合算分 = true;
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(年報報告一般状況高額合算分KEY);
            div.getCblShutsuryokuTaishoHokenKogakuGassan().setSelectedItemsByKey(年報報告様式);
        } else {
            div.getCblShutsuryokuTaishoHokenKogakuGassan().setSelectedItemsByKey(key);
        }
        setチェックボックス状況全(is年報報告様式12,
                is年報報告一般状況111,
                is年報報告一般状況1214現物分,
                is年報報告保険給付決定現物分,
                is年報報告一般状況1214償還分,
                is年報報告一般状況償還分,
                is年報報告一般状況高額分,
                is年報報告一般状況高額合算分);
    }

    private void setチェックボックス状況全(boolean is年報報告様式12,
            boolean is年報報告一般状況111,
            boolean is年報報告一般状況1214現物分,
            boolean is年報報告保険給付決定現物分,
            boolean is年報報告一般状況1214償還分,
            boolean is年報報告一般状況償還分,
            boolean is年報報告一般状況高額分,
            boolean is年報報告一般状況高額合算分) {
        if (is年報報告様式12 || is年報報告一般状況111 || is年報報告一般状況1214現物分 || is年報報告保険給付決定現物分
                || is年報報告一般状況1214償還分 || is年報報告一般状況償還分 || is年報報告一般状況高額分 || is年報報告一般状況高額合算分) {
            div.getCblShutsuryokuTaishoAll().setDisabled(false);
        }
        setチェックボックス();
    }

    private void setチェックボックス非活性() {
        if ((!RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedKey())
                && Integer.parseInt(div.getDdlHokokuNendo().getSelectedKey().toString()) < 平成17年度)
                || (!RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedKey())
                && Integer.parseInt(div.getDdlKakoHokokuNendo().getSelectedKey().toString()) < 平成17年度)) {
            div.getCblShutsuryokuTaishoYoshiki1().setDisabled(true);
            div.getTxttxtShukeiNendo1().setDisabled(true);
            div.getTxtShukeiFromYM1().setDisabled(true);
            div.getTxtShukeiToYM1().setDisabled(true);
            div.getTxtSakuseiYMD1().setDisabled(true);
            div.getTxtSakuseiTime1().setDisabled(true);
        } else {
            div.getCblShutsuryokuTaishoYoshiki1().setDisabled(false);
            div.getTxttxtShukeiNendo1().setDisabled(false);
            div.getTxtShukeiFromYM1().setDisabled(false);
            div.getTxtShukeiToYM1().setDisabled(false);
            div.getTxtSakuseiYMD1().setDisabled(false);
            div.getTxtSakuseiTime1().setDisabled(false);
        }
        if ((!RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedKey())
                && Integer.parseInt(div.getDdlHokokuNendo().getSelectedKey().toString()) < 平成18年度)
                || (!RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedKey())
                && Integer.parseInt(div.getDdlKakoHokokuNendo().getSelectedKey().toString()) < 平成18年度)) {
            div.getCblShutsuryokuTaishoHokenKogaku().setDisabled(true);
            div.getTxtShukeiNendo7().setDisabled(true);
            div.getTxtShukeiFromYM7().setDisabled(true);
            div.getTxtShukeiToYM7().setDisabled(true);
            div.getTxtSakuseiYMD7().setDisabled(true);
            div.getTxtSakuseiTime7().setDisabled(true);
        } else {
            div.getCblShutsuryokuTaishoHokenKogaku().setDisabled(false);
            div.getTxtShukeiNendo7().setDisabled(false);
            div.getTxtShukeiFromYM7().setDisabled(false);
            div.getTxtShukeiToYM7().setDisabled(false);
            div.getTxtSakuseiYMD7().setDisabled(false);
            div.getTxtSakuseiTime7().setDisabled(false);
        }
        if ((!RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedKey())
                && Integer.parseInt(div.getDdlHokokuNendo().getSelectedKey().toString()) < 平成20年度)
                || (!RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedKey())
                && Integer.parseInt(div.getDdlKakoHokokuNendo().getSelectedKey().toString()) < 平成20年度)) {
            div.getCblShutsuryokuTaishoHokenKogakuGassan().setDisabled(true);
            div.getTxtShukeiNendo8().setDisabled(true);
            div.getTxtShukeiFromYM8().setDisabled(true);
            div.getTxtShukeiToYM8().setDisabled(true);
            div.getTxtSakuseiYMD8().setDisabled(true);
            div.getTxtSakuseiTime8().setDisabled(true);
        } else {
            div.getCblShutsuryokuTaishoHokenKogakuGassan().setDisabled(false);
            div.getTxtShukeiNendo8().setDisabled(false);
            div.getTxtShukeiFromYM8().setDisabled(false);
            div.getTxtShukeiToYM8().setDisabled(false);
            div.getTxtSakuseiYMD8().setDisabled(false);
            div.getTxtSakuseiTime8().setDisabled(false);
        }
    }

    private void set一般状況集計年月選択ラジオ非活性() {
        div.getRadlblShukeiType4().setDisabled(true);
        if (div.getTxtShukeiFromYM5().getValue() != null && !div.getTxtShukeiFromYM5().getValue().isEmpty()
                && div.getTxtShukeiToYM5().getValue() != null && !div.getTxtShukeiToYM5().getValue().isEmpty()
                && !RString.isNullOrEmpty(div.getHiddenShukeiFromYM5()) && !RString.isNullOrEmpty(div.getHiddenShukeiToYM5())) {
            div.getRadlblShukeiType4().setDisabled(false);
        }
    }

    private void set保険給付決定集計年月選択ラジオ非活性() {
        div.getRadlblShukeiType5().setDisabled(true);
        if (div.getTxtShukeiFromYM6().getValue() != null && !div.getTxtShukeiFromYM6().getValue().isEmpty()
                && div.getTxtShukeiToYM6().getValue() != null && !div.getTxtShukeiToYM6().getValue().isEmpty()
                && !RString.isNullOrEmpty(div.getHiddenShukeiFromYM6()) && !RString.isNullOrEmpty(div.getHiddenShukeiToYM6())) {
            div.getRadlblShukeiType5().setDisabled(false);
        }
    }

    private void set集計年月選択ラジオ項目設定(ShoriDateKanri 一般状況1214償還分審査処理日付管理情報,
            ShoriDateKanri 一般状況1214償還分決定処理日付管理情報,
            ShoriDateKanri 給付決定償還分審査処理日付管理情報,
            ShoriDateKanri 給付決定償還分決定処理日付管理情報,
            RString 状況集計方法, RString 給付集計方法) {
        if (一般状況1214償還分審査処理日付管理情報 != null && 一般状況1214償還分決定処理日付管理情報 != null) {
            if (審査年月で集計.equals(状況集計方法)) {
                div.getTxtShukeiNendo5().setValue(new FlexibleDate(一般状況1214償還分審査処理日付管理情報.get年度().toDateString().concat(集計)));
                div.getTxtShukeiFromYM5().setValue(一般状況1214償還分審査処理日付管理情報.get対象開始年月日());
                div.setHiddenShukeiFromYM5(new RString(一般状況1214償還分審査処理日付管理情報.get対象開始年月日().toString()));
                div.getTxtShukeiToYM5().setValue(一般状況1214償還分審査処理日付管理情報.get対象終了年月日());
                div.setHiddenShukeiToYM5(new RString(一般状況1214償還分審査処理日付管理情報.get対象終了年月日().toString()));
                div.getTxtSakuseiYMD5().setValue(new FlexibleDate(一般状況1214償還分審査処理日付管理情報.get基準日時().getDate().toDateString()));
                div.getTxtSakuseiTime5().setValue(一般状況1214償還分審査処理日付管理情報.get基準日時().getRDateTime().getTime());
                div.getRadlblShukeiType4().setSelectedKey(審査年月);
            } else if (決定年月で集計.equals(状況集計方法)) {
                div.getTxtShukeiNendo5().setValue(new FlexibleDate(一般状況1214償還分決定処理日付管理情報.get年度().toDateString().concat(集計)));
                div.getTxtShukeiFromYM5().setValue(一般状況1214償還分決定処理日付管理情報.get対象開始年月日());
                div.setHiddenShukeiFromYM5(new RString(一般状況1214償還分決定処理日付管理情報.get対象開始年月日().toString()));
                div.getTxtShukeiToYM5().setValue(一般状況1214償還分決定処理日付管理情報.get対象終了年月日());
                div.setHiddenShukeiToYM5(new RString(一般状況1214償還分決定処理日付管理情報.get対象終了年月日().toString()));
                div.getTxtSakuseiYMD5().setValue(new FlexibleDate(一般状況1214償還分決定処理日付管理情報.get基準日時().getDate().toDateString()));
                div.getTxtSakuseiTime5().setValue(一般状況1214償還分決定処理日付管理情報.get基準日時().getRDateTime().getTime());
                div.getRadlblShukeiType4().setSelectedKey(決定年月);
            }
        } else if (一般状況1214償還分審査処理日付管理情報 != null && 一般状況1214償還分決定処理日付管理情報 == null) {
            div.getTxtShukeiNendo5().setValue(new FlexibleDate(一般状況1214償還分審査処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM5().setValue(一般状況1214償還分審査処理日付管理情報.get対象開始年月日());
            div.setHiddenShukeiFromYM5(RString.EMPTY);
            div.getTxtShukeiToYM5().setValue(一般状況1214償還分審査処理日付管理情報.get対象終了年月日());
            div.setHiddenShukeiToYM5(RString.EMPTY);
            div.getTxtSakuseiYMD5().setValue(new FlexibleDate(一般状況1214償還分審査処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime5().setValue(一般状況1214償還分審査処理日付管理情報.get基準日時().getRDateTime().getTime());
            div.getRadlblShukeiType4().setSelectedKey(審査年月);
        } else if (一般状況1214償還分審査処理日付管理情報 == null && 一般状況1214償還分決定処理日付管理情報 != null) {
            div.getTxtShukeiNendo5().setValue(new FlexibleDate(一般状況1214償還分決定処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM5().setValue(一般状況1214償還分決定処理日付管理情報.get対象開始年月日());
            div.setHiddenShukeiFromYM5(RString.EMPTY);
            div.getTxtShukeiToYM5().setValue(一般状況1214償還分決定処理日付管理情報.get対象終了年月日());
            div.setHiddenShukeiToYM5(RString.EMPTY);
            div.getTxtSakuseiYMD5().setValue(new FlexibleDate(一般状況1214償還分決定処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime5().setValue(一般状況1214償還分決定処理日付管理情報.get基準日時().getRDateTime().getTime());
        }
        if (給付決定償還分審査処理日付管理情報 != null && 給付決定償還分決定処理日付管理情報 != null) {
            if (審査年月で集計.equals(給付集計方法)) {
                div.getTxtShukeiNendo6().setValue(new FlexibleDate(給付決定償還分審査処理日付管理情報.get年度().toDateString()));
                div.getTxtShukeiFromYM6().setValue(給付決定償還分審査処理日付管理情報.get対象開始年月日());
                div.setHiddenShukeiFromYM6(new RString(給付決定償還分審査処理日付管理情報.get対象開始年月日().toString()));
                div.getTxtShukeiToYM6().setValue(給付決定償還分審査処理日付管理情報.get対象終了年月日());
                div.setHiddenShukeiToYM6(new RString(給付決定償還分審査処理日付管理情報.get対象終了年月日().toString()));
                div.getTxtSakuseiYMD6().setValue(new FlexibleDate(給付決定償還分審査処理日付管理情報.get基準日時().getDate().toDateString()));
                div.getTxtSakuseiTime6().setValue(給付決定償還分審査処理日付管理情報.get基準日時().getRDateTime().getTime());
                div.getRadlblShukeiType5().setSelectedKey(審査年月);
            } else if (決定年月で集計.equals(給付集計方法)) {
                div.getTxtShukeiNendo6().setValue(new FlexibleDate(給付決定償還分決定処理日付管理情報.get年度().toDateString().concat(集計)));
                div.getTxtShukeiFromYM6().setValue(給付決定償還分決定処理日付管理情報.get対象開始年月日());
                div.setHiddenShukeiFromYM6(new RString(給付決定償還分決定処理日付管理情報.get対象開始年月日().toString()));
                div.getTxtShukeiToYM6().setValue(給付決定償還分決定処理日付管理情報.get対象終了年月日());
                div.setHiddenShukeiToYM6(new RString(給付決定償還分決定処理日付管理情報.get対象終了年月日().toString()));
                div.getTxtSakuseiYMD6().setValue(new FlexibleDate(給付決定償還分決定処理日付管理情報.get基準日時().getDate().toDateString()));
                div.getTxtSakuseiTime6().setValue(給付決定償還分決定処理日付管理情報.get基準日時().getRDateTime().getTime());
                div.getRadlblShukeiType5().setSelectedKey(決定年月);
            }
        } else if (給付決定償還分審査処理日付管理情報 != null && 給付決定償還分決定処理日付管理情報 == null) {
            div.getTxtShukeiNendo6().setValue(new FlexibleDate(給付決定償還分審査処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM6().setValue(給付決定償還分審査処理日付管理情報.get対象開始年月日());
            div.setHiddenShukeiFromYM6(RString.EMPTY);
            div.getTxtShukeiToYM6().setValue(給付決定償還分審査処理日付管理情報.get対象終了年月日());
            div.setHiddenShukeiToYM6(RString.EMPTY);
            div.getTxtSakuseiYMD6().setValue(new FlexibleDate(給付決定償還分審査処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime6().setValue(給付決定償還分審査処理日付管理情報.get基準日時().getRDateTime().getTime());
            div.getRadlblShukeiType5().setSelectedKey(審査年月);
        } else if (給付決定償還分審査処理日付管理情報 == null && 給付決定償還分決定処理日付管理情報 != null) {
            div.getTxtShukeiNendo6().setValue(new FlexibleDate(給付決定償還分決定処理日付管理情報.get年度().toDateString().concat(集計)));
            div.getTxtShukeiFromYM6().setValue(給付決定償還分決定処理日付管理情報.get対象開始年月日());
            div.setHiddenShukeiFromYM6(RString.EMPTY);
            div.getTxtShukeiToYM6().setValue(給付決定償還分決定処理日付管理情報.get対象終了年月日());
            div.setHiddenShukeiToYM6(RString.EMPTY);
            div.getTxtSakuseiYMD6().setValue(new FlexibleDate(給付決定償還分決定処理日付管理情報.get基準日時().getDate().toDateString()));
            div.getTxtSakuseiTime6().setValue(給付決定償還分決定処理日付管理情報.get基準日時().getRDateTime().getTime());
            div.getRadlblShukeiType5().setSelectedKey(決定年月);
        }
    }

    private void clean集計年月() {
        div.getTxtShukeiFromYM1().clearValue();
        div.getTxtShukeiToYM1().clearValue();
        div.getTxtShukeiFromYM2().clearValue();
        div.getTxtShukeiToYM2().clearValue();
        div.getTxtShukeiFromYM3().clearValue();
        div.getTxtShukeiToYM3().clearValue();
        div.getTxtShukeiFromYM4().clearValue();
        div.getTxtShukeiToYM4().clearValue();
        div.getTxtShukeiFromYM5().clearValue();
        div.getTxtShukeiToYM5().clearValue();
        div.setHiddenShukeiFromYM5(RString.EMPTY);
        div.setHiddenShukeiToYM5(RString.EMPTY);
        div.getTxtShukeiFromYM6().clearValue();
        div.getTxtShukeiToYM6().clearValue();
        div.setHiddenShukeiFromYM6(RString.EMPTY);
        div.setHiddenShukeiToYM6(RString.EMPTY);
        div.getTxtShukeiFromYM7().clearValue();
        div.getTxtShukeiToYM7().clearValue();
        div.getTxtShukeiFromYM8().clearValue();
        div.getTxtShukeiToYM8().clearValue();
        List<RString> key = new ArrayList<>();
        div.getCblShutsuryokuTaishoYoshiki1().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoIppan1to11().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoIppanGembutsu().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenGembutsu().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoIppanShokan().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenShokan().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenKogaku().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenKogakuGassan().setSelectedItemsByKey(key);
    }

    private void set集計年度() {
        if (!RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedKey())) {
            div.getTxttxtShukeiNendo1().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo2().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo3().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo4().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo5().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo6().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo7().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
            div.getTxtShukeiNendo8().setValue(new FlexibleDate(div.getDdlHokokuNendo().getSelectedKey().concat(集計)));
        } else {
            div.getTxttxtShukeiNendo1().clearValue();
            div.getTxtShukeiNendo2().clearValue();
            div.getTxtShukeiNendo3().clearValue();
            div.getTxtShukeiNendo4().clearValue();
            div.getTxtShukeiNendo5().clearValue();
            div.getTxtShukeiNendo6().clearValue();
            div.getTxtShukeiNendo7().clearValue();
            div.getTxtShukeiNendo8().clearValue();
        }
    }

    private void setチェックボックス() {
        if (div.getCblShutsuryokuTaishoYoshiki1().isAllSelected()
                && div.getCblShutsuryokuTaishoIppan1to11().isAllSelected()
                && div.getCblShutsuryokuTaishoIppanGembutsu().isAllSelected()
                && div.getCblShutsuryokuTaishoHokenGembutsu().isAllSelected()
                && div.getCblShutsuryokuTaishoIppanShokan().isAllSelected()
                && div.getCblShutsuryokuTaishoHokenShokan().isAllSelected()
                && div.getCblShutsuryokuTaishoHokenKogaku().isAllSelected()
                && div.getCblShutsuryokuTaishoHokenKogakuGassan().isAllSelected()) {
            List<RString> 年報報告様式 = new ArrayList<>();
            年報報告様式.add(new RString("all"));
            div.getCblShutsuryokuTaishoAll().setSelectedItemsByKey(年報報告様式);
        }
    }

    private DBU030010_JigyoHokokuNenpo_MainParameter set出力区分(DBU030010_JigyoHokokuNenpo_MainParameter parameter) {
        List<RString> 集計年度 = new ArrayList<>();
        List<RString> 集計開始年月 = new ArrayList<>();
        List<RString> 集計終了年月 = new ArrayList<>();
        List<RDateTime> 作成日時 = new ArrayList<>();
        List<RString> 出力区分リスト = new ArrayList<>();
        集計年度.add(RString.EMPTY);
        集計開始年月.add(RString.EMPTY);
        集計終了年月.add(RString.EMPTY);
        作成日時.add(RDateTime.MAX);
        出力区分リスト.add(RString.EMPTY);
        if (div.getCblShutsuryokuTaishoYoshiki1().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxttxtShukeiNendo1().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM1().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM1().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD1().getValue(), div.getTxtSakuseiTime1().getValue()));
            出力区分リスト.add(選択する);
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoIppan1to11().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo2().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM2().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM2().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD2().getValue(), div.getTxtSakuseiTime2().getValue()));
            出力区分リスト.add(選択する);
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoIppanGembutsu().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo3().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM3().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM3().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD3().getValue(), div.getTxtSakuseiTime3().getValue()));
            出力区分リスト.add(選択する);
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoIppanShokan().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo5().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM5().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM5().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD5().getValue(), div.getTxtSakuseiTime5().getValue()));
            if (審査年月.equals(div.getRadlblShukeiType4().getSelectedKey())) {
                出力区分リスト.add(審査年月で集計選択する);
            } else {
                出力区分リスト.add(決定年月で集計選択する);
            }
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoHokenGembutsu().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo4().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM4().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM4().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD4().getValue(), div.getTxtSakuseiTime4().getValue()));
            出力区分リスト.add(選択する);
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoHokenShokan().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo6().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM6().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM6().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD6().getValue(), div.getTxtSakuseiTime6().getValue()));
            if (審査年月.equals(div.getRadlblShukeiType5().getSelectedKey())) {
                出力区分リスト.add(審査年月で集計選択する);
            } else {
                出力区分リスト.add(決定年月で集計選択する);
            }
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoHokenKogaku().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo7().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM7().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM7().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD7().getValue(), div.getTxtSakuseiTime7().getValue()));
            出力区分リスト.add(選択する);
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        if (div.getCblShutsuryokuTaishoHokenKogakuGassan().isAllSelected()) {
            集計年度.add(get集計年度(div.getTxtShukeiNendo8().getValue()));
            集計開始年月.add(get集計年月(div.getTxtShukeiFromYM8().getValue()));
            集計終了年月.add(get集計年月(div.getTxtShukeiToYM8().getValue()));
            作成日時.add(get作成日時(div.getTxtSakuseiYMD8().getValue(), div.getTxtSakuseiTime8().getValue()));
            出力区分リスト.add(選択する);
        } else {
            集計年度.add(RString.EMPTY);
            集計開始年月.add(RString.EMPTY);
            集計終了年月.add(RString.EMPTY);
            作成日時.add(RDateTime.MAX);
            出力区分リスト.add(選択無し);
        }
        parameter.set集計年度(集計年度);
        parameter.set集計開始年月(集計開始年月);
        parameter.set集計終了年月(集計終了年月);
        parameter.set作成日時(作成日時);
        parameter.set出力区分リスト(出力区分リスト);
        return parameter;
    }

    private RString get集計年度(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return new RString(日期.toString().substring(INT_ZEO, INT_YOU));
        }
        return RString.EMPTY;
    }

    private RString get集計年月(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return new RString(日期.toString().substring(INT_ZEO, INT_ROKU));
        }
        return RString.EMPTY;
    }

    private RDateTime get作成日時(FlexibleDate 作成日, RTime 作成時) {
        return RDateTime.of(作成日.getYearValue(), 作成日.getMonthValue(),
                作成日.getDayValue(), 作成時.getHour(), 作成時.getSecond());
    }

    private List<RString> get構成市町村コードリスト(List<KoikiZenShichosonJoho> 現市町村情報) {
        List<RString> 構成市町村コードリスト = new ArrayList<>();
        for (KoikiZenShichosonJoho 現市町村 : 現市町村情報) {
            構成市町村コードリスト.add(現市町村.get市町村コード().value());
        }
        return 構成市町村コードリスト;
    }

    private List<RString> get旧市町村コードリスト(List<GappeiCityJyoho> 合併市町村情報) {
        List<RString> 旧市町村コードリスト = new ArrayList<>();
        for (GappeiCityJyoho 合併市町村 : 合併市町村情報) {
            旧市町村コードリスト.add(合併市町村.get市町村コード().value());
        }
        return 旧市町村コードリスト;
    }

    private List<RString> get過去集計分市町村コードリスト(List<ShichosonSelectorResult> 市町村選択検索結果) {
        List<RString> 過去集計分市町村コードリスト = new ArrayList<>();
        for (ShichosonSelectorResult 市町村選択結果 : 市町村選択検索結果) {
            過去集計分市町村コードリスト.add(市町村選択結果.get市町村コード().value());
        }
        return 過去集計分市町村コードリスト;
    }

    private RString get過去集計分旧市町村区分(RString 市町村コード, List<RString> 旧市町村コードリスト) {
        if (旧市町村コードリスト != null && !旧市町村コードリスト.isEmpty()) {
            for (RString 旧市町村コード : 旧市町村コードリスト) {
                if (市町村コード.equals(旧市町村コード)) {
                    return new RString("1");
                }
            }
        }
        return new RString("2");
    }

    private void set集計エリア() {
        div.getTxttxtShukeiNendo1().clearValue();
        div.getTxtShukeiNendo2().clearValue();
        div.getTxtShukeiNendo3().clearValue();
        div.getTxtShukeiNendo4().clearValue();
        div.getTxtShukeiNendo5().clearValue();
        div.getTxtShukeiNendo6().clearValue();
        div.getTxtShukeiNendo7().clearValue();
        div.getTxtShukeiNendo8().clearValue();
        div.getTxtShukeiFromYM1().clearValue();
        div.getTxtShukeiFromYM2().clearValue();
        div.getTxtShukeiFromYM3().clearValue();
        div.getTxtShukeiFromYM4().clearValue();
        div.getTxtShukeiFromYM5().clearValue();
        div.setHiddenShukeiFromYM5(RString.EMPTY);
        div.getTxtShukeiFromYM6().clearValue();
        div.setHiddenShukeiFromYM6(RString.EMPTY);
        div.getTxtShukeiFromYM7().clearValue();
        div.getTxtShukeiFromYM8().clearValue();
        div.getTxtShukeiToYM1().clearValue();
        div.getTxtShukeiToYM2().clearValue();
        div.getTxtShukeiToYM3().clearValue();
        div.getTxtShukeiToYM4().clearValue();
        div.getTxtShukeiToYM5().clearValue();
        div.setHiddenShukeiToYM5(RString.EMPTY);
        div.getTxtShukeiToYM6().clearValue();
        div.setHiddenShukeiToYM6(RString.EMPTY);
        div.getTxtShukeiToYM7().clearValue();
        div.getTxtShukeiToYM8().clearValue();
    }

    private void set集計と作成非活性() {
        div.getTxtSakuseiYMD1().setDisabled(false);
        div.getTxtSakuseiYMD2().setDisabled(false);
        div.getTxtSakuseiYMD3().setDisabled(false);
        div.getTxtSakuseiYMD4().setDisabled(false);
        div.getTxtSakuseiYMD5().setDisabled(false);
        div.getTxtSakuseiYMD6().setDisabled(false);
        div.getTxtSakuseiYMD7().setDisabled(false);
        div.getTxtSakuseiYMD8().setDisabled(false);
        div.getRadlblShukeiType4().setDisabled(false);
        div.getRadlblShukeiType5().setDisabled(false);
        div.getTxtSakuseiTime1().setDisabled(false);
        div.getTxtSakuseiTime2().setDisabled(false);
        div.getTxtSakuseiTime3().setDisabled(false);
        div.getTxtSakuseiTime4().setDisabled(false);
        div.getTxtSakuseiTime5().setDisabled(false);
        div.getTxtSakuseiTime6().setDisabled(false);
        div.getTxtSakuseiTime7().setDisabled(false);
        div.getTxtSakuseiTime8().setDisabled(false);
        if (!div.getCblShutsuryokuTaishoYoshiki1().isDisabled()) {
            div.getTxtSakuseiYMD1().setDisabled(true);
            div.getTxtSakuseiTime1().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoIppan1to11().isDisabled()) {
            div.getTxtSakuseiYMD2().setDisabled(true);
            div.getTxtSakuseiTime2().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoIppanGembutsu().isDisabled()) {
            div.getTxtSakuseiYMD3().setDisabled(true);
            div.getTxtSakuseiTime3().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoHokenGembutsu().isDisabled()) {
            div.getTxtSakuseiYMD4().setDisabled(true);
            div.getTxtSakuseiTime4().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoIppanShokan().isDisabled()) {
            div.getTxtSakuseiYMD5().setDisabled(true);
            div.getTxtSakuseiTime5().setDisabled(true);
            div.getRadlblShukeiType4().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoHokenShokan().isDisabled()) {
            div.getTxtSakuseiYMD6().setDisabled(true);
            div.getTxtSakuseiTime6().setDisabled(true);
            div.getRadlblShukeiType5().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoHokenKogaku().isDisabled()) {
            div.getTxtSakuseiYMD7().setDisabled(true);
            div.getTxtSakuseiTime7().setDisabled(true);
        }
        if (!div.getCblShutsuryokuTaishoHokenKogakuGassan().isDisabled()) {
            div.getTxtSakuseiYMD8().setDisabled(true);
            div.getTxtSakuseiTime8().setDisabled(true);
        }
    }

    private void setチェックボックスクリア() {
        List<RString> key = new ArrayList<>();
        div.getCblShutsuryokuTaishoAll().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoYoshiki1().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoIppan1to11().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoIppanGembutsu().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenGembutsu().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoIppanShokan().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenShokan().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenKogaku().setSelectedItemsByKey(key);
        div.getCblShutsuryokuTaishoHokenKogakuGassan().setSelectedItemsByKey(key);
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getKey().compareTo(o1.getKey());
        }
    }
}
