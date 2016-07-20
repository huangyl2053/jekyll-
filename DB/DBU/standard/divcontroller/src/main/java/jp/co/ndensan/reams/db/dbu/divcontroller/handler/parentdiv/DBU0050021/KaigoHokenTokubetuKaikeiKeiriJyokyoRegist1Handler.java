/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanri;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.Shichoson;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 介護保険特別会計経理状況登録_様式４ハンドラクラスです。
 *
 * @reamsid_L DBU-1130-020 liangbc
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler {

    private final KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div;
    private static final RString UPDATE = new RString("modify");
    private static final RString DELETE = new RString("delete");
    private static final RString ADD = new RString("add");
    private static final RString 入力未 = new RString("入力未");
    private final RString 内部処理モード_修正追加 = new RString("修正追加");
    private final RString 内部処理モード_修正 = new RString("修正");
    private final RString 内部処理モード_削除 = new RString("削除");
    private final RString 内部処理モード_追加 = new RString("追加");
    private final RString 画面表示_修正 = new RString("修正");
    private final RString 画面表示_削除 = new RString("削除");
    private final RString 画面表示_追加 = new RString("追加");
    private static final int INT3 = 3;
    private static final int INT31 = 31;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final Decimal DECIMAL_0 = new Decimal("0");
    private static final RString DOUBLE_ZEOR = new RString("00");
    private final RString 状態1 = new RString("状態1");
    private final RString 状態1_確定 = new RString("状態1_確定");
    private final RString 状態2 = new RString("状態2");
    private final RString 状態3 = new RString("状態3");
    private final Code 表番号_09 = new Code("09");
    private final Code 集計番号_0100 = new Code("0100");
    private final Code 集計単位_1 = new Code("1");
    private final RString 保険料横縦番号 = new RString("1_1");
    private final RString 総務費横縦番号 = new RString("1_2");
    private final RString 認定負担金横縦番号 = new RString("2_1");
    private final RString 介護サービス等諸費横縦番号 = new RString("2_2");
    private final RString その他横縦番号 = new RString("3_1");
    private final RString 介護予防サービス等諸費横縦番号 = new RString("3_2");
    private final RString 使用料横縦番号 = new RString("4_1");
    private final RString 高額介護サービス等費横縦番号 = new RString("4_2");
    private final RString 手数料横縦番号 = new RString("5_1");
    private final RString 高額医療合算介護サービス等費横縦番号 = new RString("5_2");
    private final RString 介護給付費負担金横縦番号 = new RString("6_1");
    private final RString 特定入所者介護サービス等費横縦番号 = new RString("6_2");
    private final RString 調整交付金横縦番号 = new RString("7_1");
    private final RString 審査支払手数料横縦番号 = new RString("7_2");
    private final RString 地域支援事業交付金_介護予防事業横縦番号 = new RString("8_1");
    private final RString 市町村特別給付費横縦番号 = new RString("8_2");
    private final RString 地域支援事業交付金_包括的支援事業横縦番号 = new RString("9_1");
    private final RString その他_保険給付費横縦番号 = new RString("9_2");
    private final RString その他_国庫支出金横縦番号 = new RString("10_1");
    private final RString 介護予防事業費横縦番号 = new RString("10_2");
    private final RString 介護給付費交付金横縦番号 = new RString("11_1");
    private final RString 包括的支援事業_任意事業_地域支援事業横縦番号 = new RString("11_2");
    private final RString 地域支援事業支援交付金横縦番号 = new RString("12_1");
    private final RString 財政安定化基金拠出金横縦番号 = new RString("12_2");
    private final RString 都道府県負担金横縦番号 = new RString("13_1");
    private final RString 相互財政安定化事業負担金横縦番号 = new RString("13_2");
    private final RString 財政安定化基金支出金横縦番号 = new RString("14_1");
    private final RString 保健福祉事業費横縦番号 = new RString("14_2");
    private final RString 都道府県支出金_地域支援事業交付金横縦番号 = new RString("15_1");
    private final RString 基金積立金横縦番号 = new RString("15_2");
    private final RString 地域支援事業交付金_任意事業横縦番号 = new RString("16_1");
    private final RString 財政安定化基金償還金横縦番号 = new RString("16_2");
    private final RString その他_都道府県支出金横縦番号 = new RString("17_1");
    private final RString その他_公債費横縦番号 = new RString("17_2");
    private final RString 相互財政安定化事業交付金横縦番号 = new RString("18_1");
    private final RString 予備費横縦番号 = new RString("18_2");
    private final RString 財産収入横縦番号 = new RString("19_1");
    private final RString 介護サービス事業勘定繰出金横縦番号 = new RString("19_2");
    private final RString 寄附金横縦番号 = new RString("20_1");
    private final RString 他会計繰出金横縦番号 = new RString("20_2");
    private final RString 一般会計繰入金横縦番号 = new RString("21_1");
    private final RString その他_諸支出金横縦番号 = new RString("21_2");
    private final RString 総務費に係る一般会計繰入金横縦番号 = new RString("22_1");
    private final RString 介護給付費準備基金繰入金横縦番号 = new RString("23_1");
    private final RString 介護サービス事業勘定繰入金横縦番号 = new RString("24_1");
    private final RString 地域支援事業繰入金_介護予防事業横縦番号 = new RString("25_1");
    private final RString 地域支援事業繰入金_任意事業横縦番号 = new RString("26_1");
    private final RString その他_繰入金横縦番号 = new RString("27_1");
    private final RString 繰越金横縦番号 = new RString("28_1");
    private final RString 財政安定化基金貸付金横縦番号 = new RString("29_1");
    private final RString その他_市町村債横縦番号 = new RString("30_1");
    private final RString 諸収入横縦番号 = new RString("31_1");
    private final RString 合計１横縦番号 = new RString("32_1");
    private final RString 合計２横縦番号 = new RString("32_2");
    private final RString 歳入歳出差引残額横縦番号 = new RString("33_1");
    private final RString うち基金繰入額横縦番号 = new RString("34_1");
    private final RString 介護給付費準備基金保有額横縦番号 = new RString("35_1");

    /**
     * コンストラクタです。
     *
     * @param div 介護保険特別会計経理状況登録_様式４情報Div
     */
    public KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param insuranceInf 引き継ぎデータ
     */
    public void onload(InsuranceInformation insuranceInf) {
        if (DELETE.equals(insuranceInf.get処理フラグ())
                || UPDATE.equals(insuranceInf.get処理フラグ())) {
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDisplayNone(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setDisplayNone(false);
            onload一覧修正Or一覧削除(insuranceInf);
        } else if (ADD.equals(insuranceInf.get処理フラグ())) {
            List<Shichoson> 市町村Lst = get市町村Lst();
            if (市町村Lst.isEmpty()) {
                throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
            }
            List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
            set年度();
            div.getCcdKanryoMessage().setDisplayNone(true);
            div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
            div.getHihokenshabango().getBntYoskiyonosan().setDisabled(false);
            div.getHihokenshabango().getBtnYoshikiyonnoni().setDisabled(false);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().setReadOnly(false);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM().setReadOnly(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango().setDisplayNone(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei().setDisplayNone(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDataSource(dataSource);
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDisabled(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setSelectedIndex(0);
            div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setDisabled(false);
            div.setShoriMode(内部処理モード_追加);
            div.setGamenMode(画面表示_追加);
            詳細データエリ表示(null, 状態1);
        }
    }

    private void onload一覧修正Or一覧削除(InsuranceInformation insuranceInf) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpo> 詳細データLst
                = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoDetal(new FlexibleYear(insuranceInf.get報告年().toString()),
                        new RString(insuranceInf.get集計対象年().toString()), insuranceInf.get統計対象区分(),
                        insuranceInf.get市町村コード(), 集計番号_0100.getColumnValue());
        if (詳細データLst.isEmpty()) {
            onload内部処理モードが修正追加(insuranceInf);
        } else {
            onload内部処理モードが修正Or削除(insuranceInf, 詳細データLst.get(0));
        }
    }

    private void onload内部処理モードが修正Or削除(InsuranceInformation insuranceInf, KaigoHokenJigyoHokokuNenpo 詳細データ) {
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        TextBoxFlexibleDate 集計年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM();
        報告年度Box.setValue(new FlexibleDate(insuranceInf.get報告年().getYearValue(), 1, 1));
        集計年度Box.setValue(new FlexibleDate(insuranceInf.get集計対象年().getYearValue(), 1, 1));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango()
                .setValue(insuranceInf.get保険者コード().getColumnValue());
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei().setValue(insuranceInf.get市町村名称());
        報告年度Box.setReadOnly(true);
        集計年度Box.setReadOnly(true);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango().setReadOnly(true);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei().setReadOnly(true);
        div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setVisible(false);
        div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setVisible(false);
        if (UPDATE.equals(insuranceInf.get処理フラグ())) {
            詳細データエリ表示(詳細データ, 状態2);
            div.getCcdKanryoMessage().setDisplayNone(true);
            div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
            div.getHihokenshabango().getBntYoskiyonosan().setDisabled(false);
            div.getHihokenshabango().getBtnYoshikiyonnoni().setDisabled(false);
            div.setShoriMode(内部処理モード_修正);
            div.setGamenMode(画面表示_修正);
        } else {
            詳細データエリ表示(詳細データ, 状態3);
            div.getCcdKanryoMessage().setDisplayNone(true);
            div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
            div.getHihokenshabango().getBtnYoshikiyonnoni()
                    .setDisabled(入力未.equals(insuranceInf.get様式４の２入力状況()));
            div.getHihokenshabango().getBntYoskiyonosan()
                    .setDisabled(入力未.equals(insuranceInf.get様式４の３入力状況()));
            div.setShoriMode(内部処理モード_削除);
            div.setGamenMode(画面表示_削除);
        }
    }

    private void onload内部処理モードが修正追加(InsuranceInformation insuranceInf) {
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        if (!(DELETE.equals(insuranceInf.get処理フラグ()))) {
            div.setShoriMode(内部処理モード_修正追加);
        }
        報告年度Box.setValue(new FlexibleDate(insuranceInf.get報告年().getYearValue(), 1, 1));
        報告年度Box.setReadOnly(true);
        TextBoxCode 保険者コードBox = div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango();
        保険者コードBox.setValue(insuranceInf.get保険者コード().getColumnValue());
        保険者コードBox.setReadOnly(true);
        TextBox 保険者名称Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei();
        保険者名称Box.setValue(insuranceInf.get市町村名称());
        保険者名称Box.setReadOnly(true);
    }

    private void set年度() {
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        TextBoxFlexibleDate 集計年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM();
        RDate date = RDate.getNowDate();
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < INT6) {
            報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        }
        報告年度Box.setValue(報告年度);
        集計年度Box.setValue(集計年度);
    }

    /**
     * 市町村Lst取得処理です。
     *
     * @return List<Shichoson>
     */
    private List<Shichoson> get市町村Lst() {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<Shichoson> 市町村Lst = 介護保険特別会計経理状況登録Manager.getShichosonCodeNameList();
        return 市町村Lst;
    }

    /**
     * 詳細データエリア表示すること処理です。
     *
     * @param 詳細データ 詳細データ
     * @param 状態 状態
     */
    private void 詳細データエリ表示(KaigoHokenJigyoHokokuNenpo 詳細データ, RString 状態) {
        if (詳細データ != null && 詳細データ.get詳細データエリア() != null && !詳細データ.get詳細データエリア().isEmpty()
                && (状態2.equals(状態) || 状態3.equals(状態))) {
            set詳細データエリア(詳細データ);
        }
        if (状態2.equals(状態) || 状態3.equals(状態) || 状態1.equals(状態) || 状態1_確定.equals(状態)) {
            Boolean isReadOnly = 状態3.equals(状態) || 状態1.equals(状態);
            is詳細データエリアReadOnly(isReadOnly);
        }
    }

    /**
     * 「保存する」ボタンを押下すること処理です。
     *
     * @param insuranceInf 引き継ぎデータ
     */
    public void onClick_btnSave(InsuranceInformation insuranceInf) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpo> 画面入力データLst = new ArrayList<>();
        if (内部処理モード_追加.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 画面入力データ = get画面入力データ(insuranceInf);
            画面入力データLst.add(画面入力データ);
            介護保険特別会計経理状況登録Manager.regKaigoHokenTokubetuKaikeiKeiriJyokyo(画面入力データLst);
            div.getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
        } else if (内部処理モード_修正.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 修正データ = get修正データ(insuranceInf);
            画面入力データLst.add(修正データ);
            介護保険特別会計経理状況登録Manager.updKaigoHokenTokubetuKaikeiKeiriJyokyo(画面入力データLst);
            div.getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        } else if (内部処理モード_修正追加.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 画面入力データ = get画面入力データ(insuranceInf);
            画面入力データLst.add(画面入力データ);
            介護保険特別会計経理状況登録Manager.regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(画面入力データLst);
            div.getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        } else if (内部処理モード_削除.equals(div.getShoriMode())) {
            介護保険特別会計経理状況登録Manager.delKaigoHokenTokubetuKaikeiKeiriJyokyo(
                    insuranceInf.get報告年(),
                    insuranceInf.get集計対象年(),
                    insuranceInf.get統計対象区分(),
                    insuranceInf.get市町村コード(),
                    insuranceInf.get表番号(), 集計番号_0100);
            div.getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("削除").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        div.getHihokenshabango().setDisplayNone(true);
        div.getCcdKanryoMessage().setDisplayNone(false);

    }

    /**
     * 「報告年度を確定する」ボタンを押下すること処理です。
     *
     * @param insuranceInf 引き継ぎデータ
     */
    public void onClick_btnConfirm(InsuranceInformation insuranceInf) {
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        LasdecCode 市町村コード = insuranceInf.get市町村コード();
        TokeiTaishoKubun 保険者区分 = TokeiTaishoKubun.空;
        List<Shichoson> 市町村Lst = get市町村Lst();
        for (Shichoson shichoson : 市町村Lst) {
            if (shichoson.get市町村コード().equals(市町村コード)) {
                保険者区分 = shichoson.get保険者区分();
                break;
            }
        }
        報告年度の確定処理(報告年度Box, 市町村コード, 保険者区分);
    }

    private void 報告年度の確定処理(TextBoxFlexibleDate 報告年度Box, LasdecCode 市町村コード, TokeiTaishoKubun 保険者区分) {
        FlexibleYear 報告年度 = get年度(div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM());
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpo> 一覧データLst
                = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoList(報告年度, 市町村コード, 保険者区分);
        if (!一覧データLst.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.該当報告年度の集計データは既に存在.getMessage());
        } else {
            報告年度Box.setReadOnly(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDisabled(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setDisabled(true);
            詳細データエリ表示(null, 状態1_確定);
        }
    }

    private FlexibleYear get年度(TextBoxFlexibleDate date) {
        return new FlexibleYear(new RString(date.getValue().toString()).substring(0, INT4));
    }

    /**
     * 「報告年度」フォーカスロスト処理です。
     */
    public void lostFocus() {
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        RString 報告年度String = 報告年度Box.getText();
        int 報告年度Year = Integer.parseInt(報告年度String.substring(0, INT4).toString());
        FlexibleDate 報告年度 = 報告年度Box.getValue();
        if (!報告年度.isEmpty()) {
            set集計年度(報告年度Year);
        }
    }

    private void set集計年度(int 報告年度Year) {
        FlexibleDate 集計年度;
        RDate date = RDate.getNowDate();
        if (報告年度Year == date.getYearValue()) {
            set集計年度_報告年度がシステム日付の年();
        } else {
            集計年度 = new FlexibleDate(報告年度Year - 1, date.getMonthValue(), date.getDayValue());
            div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().setValue(集計年度);
        }
    }

    private void set集計年度_報告年度がシステム日付の年() {
        FlexibleDate 集計年度;
        RDate date = RDate.getNowDate();
        if (date.getMonthValue() >= INT6) {
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        } else {
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        }
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().setValue(集計年度);
    }

    /**
     * 修正データの取得処理です。
     *
     * @param insuranceInf 引き継ぎデータ
     * @return 修正データ
     */
    public KaigoHokenJigyoHokokuNenpo get修正データ(InsuranceInformation insuranceInf) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpo> 詳細データLst
                = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoDetal(
                        new FlexibleYear(insuranceInf.get報告年().toString()),
                        new RString(insuranceInf.get集計対象年().toString()),
                        insuranceInf.get統計対象区分(),
                        insuranceInf.get市町村コード(),
                        集計番号_0100.getColumnValue());
        KaigoHokenJigyoHokokuNenpo 詳細データ = null;
        if (!詳細データLst.isEmpty()) {
            詳細データ = 詳細データLst.get(0);
        }
        KaigoHokenJigyoHokokuNenpo 画面入力データ = get画面入力データ(insuranceInf);
        Map<RString, Decimal> 修正データエリア = new HashMap<>();
        if (詳細データ != null) {
            for (Map.Entry<RString, Decimal> 詳細データentry : 詳細データ.get詳細データエリア().entrySet()) {
                if (!詳細データentry.getValue().equals(画面入力データ.get詳細データエリア().get(詳細データentry.getKey()))) {
                    修正データエリア.put(詳細データentry.getKey(), 画面入力データ.get詳細データエリア().get(詳細データentry.getKey()));
                }
            }
        }
        KaigoHokenJigyoHokokuNenpo 修正データ = new KaigoHokenJigyoHokokuNenpo(画面入力データ.get報告年(), 画面入力データ.get報告月(),
                画面入力データ.get集計対象年(), 画面入力データ.get集計対象月(), 画面入力データ.get統計対象区分(), 画面入力データ.get市町村コード(),
                画面入力データ.get表番号(), 画面入力データ.get集計番号(), 画面入力データ.get集計単位(), 画面入力データ.get集計項目名称(),
                画面入力データ.get縦項目コード(), 画面入力データ.get横項目コード(), 修正データエリア);
        return 修正データ;
    }

    /**
     * 画面詳細エリア入力有無の判定処理です。
     *
     * @param 画面入力データ 画面入力データ
     * @return 画面詳細エリア入力有無
     */
    public Boolean is画面詳細エリア入力有(KaigoHokenJigyoHokokuNenpo 画面入力データ) {
        Map<RString, Decimal> 詳細データエリア = 画面入力データ.get詳細データエリア();
        for (Map.Entry<RString, Decimal> 詳細データentry : 詳細データエリア.entrySet()) {
            if (!DECIMAL_0.equals(詳細データentry.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 画面入力データの取得処理です。
     *
     * @param insuranceInf 引き継ぎデータ
     * @return 画面入力データ
     */
    public KaigoHokenJigyoHokokuNenpo get画面入力データ(InsuranceInformation insuranceInf) {
        Map<RString, Decimal> 画面入力詳細データエリ = new HashMap<>();
        set画面入力詳細データエリ1(画面入力詳細データエリ);
        set画面入力詳細データエリ2(画面入力詳細データエリ);
        set画面入力詳細データエリ3(画面入力詳細データエリ);
        set画面入力詳細データエリ4(画面入力詳細データエリ);
        KaigoHokenJigyoHokokuNenpo 画面入力データ = new KaigoHokenJigyoHokokuNenpo(
                get年度(div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM()),
                DOUBLE_ZEOR,
                get年度(div.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM()),
                DOUBLE_ZEOR,
                insuranceInf.get統計対象区分(), insuranceInf.get市町村コード(), 表番号_09, 集計番号_0100,
                集計単位_1, null, null, null, 画面入力詳細データエリ
        );
        return 画面入力データ;

    }

    private void set画面入力詳細データエリ1(Map<RString, Decimal> 画面入力詳細データエリ) {
        画面入力詳細データエリ.put(保険料横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenryo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenryo().getValue());
        画面入力詳細データエリ.put(総務費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsusomu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsusomu().getValue());
        画面入力詳細データエリ.put(認定負担金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtnintei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtnintei().getValue());
        画面入力詳細データエリ.put(介護サービス等諸費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtlsabisunadoshohi().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtlsabisunadoshohi().getValue());
        画面入力詳細データエリ.put(その他横縦番号, div.getHihokenshabango().getYoshikiyonMeisai().getTxtfuntansonota().getValue() == null ? DECIMAL_0
                : div.getHihokenshabango().getYoshikiyonMeisai().getTxtfuntansonota().getValue());
        画面入力詳細データエリ.put(介護予防サービス等諸費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobonadoshohi().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobonadoshohi().getValue());
        画面入力詳細データエリ.put(使用料横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtshiyoo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtshiyoo().getValue());
        画面入力詳細データエリ.put(高額介護サービス等費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkogakukaigo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkogakukaigo().getValue());
        画面入力詳細データエリ.put(手数料横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxttesu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxttesu().getValue());
        画面入力詳細データエリ.put(高額医療合算介護サービス等費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtlkogakuiryo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtlkogakuiryo().getValue());
        画面入力詳細データエリ.put(介護給付費負担金横縦番号, div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufu().getValue());
        画面入力詳細データエリ.put(特定入所者介護サービス等費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxttokuteinyusho().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxttokuteinyusho().getValue());
        画面入力詳細データエリ.put(調整交付金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchosei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchosei().getValue());
        画面入力詳細データエリ.put(審査支払手数料横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtshinsashiharai().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtshinsashiharai().getValue());
        画面入力詳細データエリ.put(地域支援事業交付金_介護予防事業横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigoyobo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigoyobo().getValue());
        画面入力詳細データエリ.put(市町村特別給付費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtshichosontokubetsukyufu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtshichosontokubetsukyufu().getValue());
        画面入力詳細データエリ.put(地域支援事業交付金_包括的支援事業横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxthokatsu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxthokatsu().getValue());
        画面入力詳細データエリ.put(その他_保険給付費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyusonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyusonota().getValue());
    }

    private void set画面入力詳細データエリ2(Map<RString, Decimal> 画面入力詳細データエリ) {
        画面入力詳細データエリ.put(その他_国庫支出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkosonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkosonota().getValue());
        画面入力詳細データエリ.put(介護予防事業費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikikaigoyobo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikikaigoyobo().getValue());
        画面入力詳細データエリ.put(介護給付費交付金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufukofukin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufukofukin().getValue());
        画面入力詳細データエリ.put(包括的支援事業_任意事業_地域支援事業横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikihokatsujigyo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikihokatsujigyo().getValue());
        画面入力詳細データエリ.put(地域支援事業支援交付金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkofukin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkofukin().getValue());
        画面入力詳細データエリ.put(財政安定化基金拠出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanantei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanantei().getValue());
        画面入力詳細データエリ.put(都道府県負担金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukenfutankin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukenfutankin().getValue());
        画面入力詳細データエリ.put(相互財政安定化事業負担金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkozaisan().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkozaisan().getValue());
        画面入力詳細データエリ.put(財政安定化基金支出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaiseiantei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaiseiantei().getValue());
        画面入力詳細データエリ.put(保健福祉事業費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenfukushi().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenfukushi().getValue());
        画面入力詳細データエリ.put(都道府県支出金_地域支援事業交付金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienyobo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienyobo().getValue());
        画面入力詳細データエリ.put(基金積立金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkikin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkikin().getValue());
        画面入力詳細データエリ.put(地域支援事業交付金_任意事業横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienhokatsu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienhokatsu().getValue());
        画面入力詳細データエリ.put(財政安定化基金償還金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtv().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtv().getValue());
        画面入力詳細データエリ.put(その他_都道府県支出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukensonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukensonota().getValue());
        画面入力詳細データエリ.put(その他_公債費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkosaikosaisonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkosaikosaisonota().getValue());
        画面入力詳細データエリ.put(相互財政安定化事業交付金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshunyu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshunyu().getValue());
        画面入力詳細データエリ.put(予備費横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobihi().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobihi().getValue());
    }

    private void set画面入力詳細データエリ3(Map<RString, Decimal> 画面入力詳細データエリ) {
        画面入力詳細データエリ.put(財産収入横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshuny().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshuny().getValue());
        画面入力詳細データエリ.put(介護サービス事業勘定繰出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigosabisukanjo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigosabisukanjo().getValue());
        画面入力詳細データエリ.put(寄附金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkifukin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkifukin().getValue());
        画面入力詳細データエリ.put(他会計繰出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxttakaikei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxttakaikei().getValue());
        画面入力詳細データエリ.put(一般会計繰入金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtippankaikei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtippankaikei().getValue());
        画面入力詳細データエリ.put(その他_諸支出金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshishutsusonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshishutsusonota().getValue());
        画面入力詳細データエリ.put(総務費に係る一般会計繰入金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsomuhi().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsomuhi().getValue());
        画面入力詳細データエリ.put(介護給付費準備基金繰入金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtjumbikikin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtjumbikikin().getValue());
        画面入力詳細データエリ.put(介護サービス事業勘定繰入金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkaigoyobo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkaigoyobo().getValue());
        画面入力詳細データエリ.put(地域支援事業繰入金_介護予防事業横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxttiikikaigoyobo().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxttiikikaigoyobo().getValue());
        画面入力詳細データエリ.put(地域支援事業繰入金_任意事業横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurichiikishienhokatsu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurichiikishienhokatsu().getValue());
        画面入力詳細データエリ.put(その他_繰入金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurinyukinsonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurinyukinsonota().getValue());
    }

    private void set画面入力詳細データエリ4(Map<RString, Decimal> 画面入力詳細データエリ) {
        画面入力詳細データエリ.put(繰越金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurikoshikin().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurikoshikin().getValue());
        画面入力詳細データエリ.put(財政安定化基金貸付金横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaizaiseiantei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaizaiseiantei().getValue());
        画面入力詳細データエリ.put(その他_市町村債横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaisonota().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaisonota().getValue());
        画面入力詳細データエリ.put(諸収入横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshunyu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshunyu().getValue());
        画面入力詳細データエリ.put(合計１横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyugokei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyugokei().getValue());
        画面入力詳細データエリ.put(合計２横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsugoukei().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsugoukei().getValue());
        画面入力詳細データエリ.put(歳入歳出差引残額横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyushutsusa().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyushutsusa().getValue());
        画面入力詳細データエリ.put(うち基金繰入額横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue());
        画面入力詳細データエリ.put(介護給付費準備基金保有額横縦番号,
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigokyufuhijunhoyu().getValue() == null
                ? DECIMAL_0 : div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigokyufuhijunhoyu().getValue());
    }

    /**
     * 処理日付管理マスタ取得処理です。
     *
     * @return 処理日付管理マスタ
     */
    public KaigoHokenShoriDateKanri get処理日付管理マスタ() {
        FlexibleYear 集計年度 = get年度(div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM());
        KaigoHokenShoriDateKanri 処理日付管理マスタ = new KaigoHokenShoriDateKanri(SubGyomuCode.DBU介護統計報告, LasdecCode.EMPTY,
                JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況, DOUBLE_ZEOR, 集計年度, DOUBLE_ZEOR, FlexibleDate.EMPTY,
                RDate.getNowDateTime(), new FlexibleDate(集計年度.getYearValue(), INT4, 01),
                new FlexibleDate(集計年度.getYearValue() + 1, INT3, INT31), null, null);
        return 処理日付管理マスタ;
    }

    /**
     * 市町村のDataSource取得処理です。
     *
     * @param 市町村Lst 市町村Lst
     * @return DataSource
     */
    private List<KeyValueDataSource> getDataSourceFrom市町村Lst(List<Shichoson> 市町村Lst) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Shichoson shichoson : 市町村Lst) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(shichoson.get市町村コード().getColumnValue(), shichoson.get市町村名称());
            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    private void set詳細データエリア(KaigoHokenJigyoHokokuNenpo 詳細データ) {
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenryo().setValue(
                new Decimal(ObjectUtil.defaultIfNull(詳細データ.get詳細データエリア().get(保険料横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsusomu().setValue(
                new Decimal(ObjectUtil.defaultIfNull(詳細データ.get詳細データエリア().get(総務費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtnintei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(認定負担金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtlsabisunadoshohi().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護サービス等諸費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtfuntansonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobonadoshohi().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護予防サービス等諸費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshiyoo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(使用料横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkogakukaigo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(高額介護サービス等費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttesu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(手数料横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtlkogakuiryo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(高額医療合算介護サービス等費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護給付費負担金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttokuteinyusho().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(特定入所者介護サービス等費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchosei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(調整交付金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshinsashiharai().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(審査支払手数料横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigoyobo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(地域支援事業交付金_介護予防事業横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshichosontokubetsukyufu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(市町村特別給付費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokatsu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(地域支援事業交付金_包括的支援事業横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyusonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_保険給付費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkosonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_国庫支出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikikaigoyobo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護予防事業費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufukofukin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護給付費交付金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikihokatsujigyo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(包括的支援事業_任意事業_地域支援事業横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkofukin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(地域支援事業支援交付金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanantei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(財政安定化基金拠出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukenfutankin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(都道府県負担金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkozaisan().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(相互財政安定化事業負担金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaiseiantei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(財政安定化基金支出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenfukushi().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(保健福祉事業費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienyobo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(都道府県支出金_地域支援事業交付金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkikin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(基金積立金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienhokatsu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(地域支援事業交付金_任意事業横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtv().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(財政安定化基金償還金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukensonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_都道府県支出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkosaikosaisonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_公債費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshunyu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(相互財政安定化事業交付金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobihi().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(予備費横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshuny().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(財産収入横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigosabisukanjo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護サービス事業勘定繰出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkifukin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(寄附金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttakaikei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(他会計繰出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtippankaikei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(一般会計繰入金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshishutsusonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_諸支出金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsomuhi().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(総務費に係る一般会計繰入金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtjumbikikin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護給付費準備基金繰入金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkaigoyobo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護サービス事業勘定繰入金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttiikikaigoyobo().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(地域支援事業繰入金_介護予防事業横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurichiikishienhokatsu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(地域支援事業繰入金_任意事業横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurinyukinsonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_繰入金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurikoshikin().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(繰越金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaizaiseiantei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(財政安定化基金貸付金横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaisonota().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(その他_市町村債横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshunyu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(諸収入横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyugokei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(合計１横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsugoukei().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(合計２横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyushutsusa().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(歳入歳出差引残額横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtuchikikinkurigaku().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(うち基金繰入額横縦番号), new RString("0")).toString()));
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigokyufuhijunhoyu().setValue(new Decimal(ObjectUtil.defaultIfNull(
                詳細データ.get詳細データエリア().get(介護給付費準備基金保有額横縦番号), new RString("0")).toString()));
    }

    private void is詳細データエリアReadOnly(Boolean isReadOnly) {
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenryo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsusomu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtnintei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtlsabisunadoshohi().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtfuntansonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobonadoshohi().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshiyoo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkogakukaigo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttesu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtlkogakuiryo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttokuteinyusho().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchosei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshinsashiharai().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigoyobo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshichosontokubetsukyufu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokatsu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyusonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkosonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikikaigoyobo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkyufukofukin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikihokatsujigyo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkofukin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanantei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukenfutankin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkokkozaisan().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaiseiantei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxthokenfukushi().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienyobo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkikin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienhokatsu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtv().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttodofukensonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkosaikosaisonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshunyu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtyobihi().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtzaisanshuny().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigosabisukanjo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkifukin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttakaikei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtippankaikei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshishutsusonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsomuhi().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtjumbikikin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtchiikishienkaigoyobo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxttiikikaigoyobo().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurichiikishienhokatsu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurinyukinsonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkurikoshikin().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaizaiseiantei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaisonota().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtshoshunyu().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyugokei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsaishutsugoukei().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyushutsusa().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtuchikikinkurigaku().setReadOnly(isReadOnly);
        div.getHihokenshabango().getYoshikiyonMeisai().getTxtkaigokyufuhijunhoyu().setReadOnly(isReadOnly);
    }
}
