/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0040011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiValidationHandler;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KanriJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 事業状況報告（年報）作成クラスです。
 *
 * @reamsid_L DBU-5600-010 linghuhang
 */
public class JigyoJokyoHokokuNempoSakuei {

//    private static final RString 合併情報区分_合併あり = new RString("1");
//    private static final RString 市町村識別ID = new RString("00");
    private static final RString 年度 = new RString("0099");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 実行単位選択集計のみ = new RString("ITTI");
    private static final RString 実行単位選択集計後に印刷 = new RString("NI");
    private static final RString 実行単位選択過去の集計 = new RString("SAN");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onLoad(JigyoJokyoHokokuNempoSakueiDiv div) {
        RString 導入形態コード = RString.EMPTY;
        List<RString> 枝番 = new ArrayList<>();
        枝番.add(年度);
        RString 合併情報区分 = GappeiCityJohoBFinder.createInstance().getGappeijohokubun();
        div.setHiddenGappeiKoseiKubun(合併情報区分);
        KanriJoho 管理情報 = ShichosonSecurityJoho.getKanriJoho(GyomuBunrui.介護事務);
        if (管理情報 != null && 管理情報.get導入形態コード() != null && !管理情報.get導入形態コード().isEmpty()) {
            導入形態コード = 管理情報.get導入形態コード().value();
        }
        div.setHiddenDonyuKeitaiCode(導入形態コード);
        List<ShoriDateKanri> 過去集計年度データ = ShoriDateKanriManager.createInstance().
                get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告, get処理名(), 枝番).records();
        getHandler(div).onLoad(合併情報区分, 導入形態コード, 過去集計年度データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeJikkoTaniIti(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeJikkoTani(実行単位選択集計のみ);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeJikkoTaniNi(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeJikkoTani(実行単位選択集計後に印刷);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeJikkoTaniSan(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeJikkoTani(実行単位選択過去の集計);
        return ResponseData.of(div).respond();
    }

    /**
     * 報告年度を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeHokokuNendo(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeHokokuNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * 報告開始年月を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeShukeiFromYM(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiFromYM(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 報告終了年月を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeShukeiToYM(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiToYM(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 過去集計年度を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeKakoHokokuNendo(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShoriDateKanri 様式12処理日付管理情報 = null;
        ShoriDateKanri 一般状況111処理日付管理情報 = null;
        ShoriDateKanri 一般状況1214現物分処理日付管理情報 = null;
        ShoriDateKanri 給付決定現物分処理日付管理情報 = null;
        ShoriDateKanri 一般状況1214償還分審査処理日付管理情報 = null;
        ShoriDateKanri 一般状況1214償還分決定処理日付管理情報 = null;
        ShoriDateKanri 給付決定償還分審査処理日付管理情報 = null;
        ShoriDateKanri 給付決定償還分決定処理日付管理情報 = null;
        ShoriDateKanri 給付決定高額分処理日付管理情報 = null;
        ShoriDateKanri 給付決定高額合算分処理日付管理情報 = null;
        if (!RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedKey())) {
            様式12処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  様式１・２"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況111処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  一般状況１～１１"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況1214現物分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  一般状況１２～１４  現物分"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定現物分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  保険給付決定  現物分"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況1214償還分審査処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  一般状況1２～１４  償還分審査"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況1214償還分決定処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  一般状況1２～１４  償還分決定"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定償還分審査処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  保険給付決定  償還分審査"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定償還分決定処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  保険給付決定  償還分決定"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定高額分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  保険給付決定  高額分"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定高額合算分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    new RString("年報報告  保険給付決定  高額合算分"), 年度,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
        }
        getHandler(div).onClick_onChangeKakoHokokuNendo(様式12処理日付管理情報,
                一般状況111処理日付管理情報,
                一般状況1214現物分処理日付管理情報,
                給付決定現物分処理日付管理情報,
                一般状況1214償還分審査処理日付管理情報,
                一般状況1214償還分決定処理日付管理情報,
                給付決定償還分審査処理日付管理情報,
                給付決定償還分決定処理日付管理情報,
                給付決定高額分処理日付管理情報,
                給付決定高額合算分処理日付管理情報, RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 合併市町村用保険者選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeGappeiShichoson(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeGappeiShichoson();
        return ResponseData.of(div).respond();
    }

    /**
     * 広域構成市町村用保険者選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeKoikiRengo(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeKoikiRengo();
        return ResponseData.of(div).respond();
    }

    /**
     * （すべて選択）チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeAll(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeAll();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeIppan(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeIppan();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況12～14【償還分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeIppanShokan(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeIppanShokan(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeHokenShokan(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeIppanShokan(new RString("償還分"));
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【高額合算分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeGassan(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeGassan();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況１２～１４【償還分】集計年月選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeIppanShukeiType(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiType(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】集計年月選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeHokenShokanShukeiType(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiType(new RString("償還分"));
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタンを押下する、市町村選択を設定します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> btnSearch(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShichosonSelectorModel model = new ShichosonSelectorModel();
        model.setShichosonModel(div.getShichosonKubun());
        div.setKyuShichoson(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタンのOKClose時の処理を行います。<br/>
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onOkClose_btnSenTaKuSearch(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        ViewStateHolder.put(ViewStateKeys.市町村選択データ, model);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 画面情報
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_btnCheck(JigyoJokyoHokokuNempoSakueiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForUpdate(
                !RString.isNullOrEmpty(div.getHiddenGappei()), !RString.isNullOrEmpty(div.getHiddenKouiki()));
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    // TODO QA1607回答まち、バッチパラメータの設定を実装なし。
//    /**
//     * 実行するボタンを押下する場合、バッチ起動する。
//     *
//     * @param div 画面情報
//     * @return ResponseData<DBU030030_JigyoHokokuNenpo_IppanParamter>
//     */
//    public ResponseData<DBU030030_JigyoHokokuNenpo_IppanParamter> onClick_btnExecute(JigyoJokyoHokokuNempoSakueiDiv div) {
//        KoseiShichosonJoho 市町村情報 = null;
//        List<AuthorityItem> 市町村識別 = new ArrayList<>();
//        List<RString> 構成市町村コードリスト = new ArrayList<>();
//        List<RString> 旧市町村コードリスト = new ArrayList<>();
//        ShichosonSelectorModel 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.市町村選択データ, ShichosonSelectorModel.class);
//        KanriJoho 管理情報 = ShichosonSecurityJoho.getKanriJoho(GyomuBunrui.介護事務);
//        ILoginInfo iLoginInfo = UrControlDataFactory.createInstance().getLoginInfo();
//        RString userId = iLoginInfo.getUserId();
//        if (管理情報 != null) {
//            市町村情報 = 管理情報.get市町村情報();
//        }
//        if (!RString.isNullOrEmpty(div.getHiddenKouiki())) {
//            市町村識別 = ShichosonSecurityJoho.getShichosonShikibetsuId(userId);
//            if (市町村識別 != null && !市町村識別.isEmpty()) {
//                if (市町村識別ID.equals(市町村識別.get(0).getItemId())) {
//                    List<KoikiZenShichosonJoho> 現市町村情報 = KoikiShichosonJohoFinder.createInstance().
//                            getGenShichosonJoho().records();
//                    構成市町村コードリスト = get構成市町村コードリスト(現市町村情報);
//                } else {
//                    構成市町村コードリスト.add(市町村情報.get市町村コード().value());
//                }
//            }
//        }
//        if (!RString.isNullOrEmpty(div.getHiddenGappei())) {
//            List<GappeiCityJyoho> 合併市町村情報 = GappeiCityJohoBFinder.createInstance().getSennyoukouikigappeijohokensaku(
//                    HyojiUmu.表示する.getコード(), div.getHiddenDonyuKeitaiCode()).records();
//            旧市町村コードリスト = get旧市町村コードリスト(合併市町村情報);
//        }
//        return ResponseData.of(getHandler(div).onClick_btnBatchParamSave(市町村情報)).respond();
//    }
    private List<RString> get処理名() {
        List<RString> 処理名リスト = new ArrayList<>();
        for (Syorimei 処理名 : Syorimei.values()) {
            処理名リスト.add(処理名.getコード());
        }
        return 処理名リスト;
    }

//    private List<RString> get構成市町村コードリスト(List<KoikiZenShichosonJoho> 現市町村情報) {
//        List<RString> 構成市町村コードリスト = new ArrayList<>();
//        for (KoikiZenShichosonJoho 現市町村 : 現市町村情報) {
//            構成市町村コードリスト.add(現市町村.get市町村コード().value());
//        }
//        return 構成市町村コードリスト;
//    }
//
//    private List<RString> get旧市町村コードリスト(List<GappeiCityJyoho> 合併市町村情報) {
//        List<RString> 旧市町村コードリスト = new ArrayList<>();
//        for (GappeiCityJyoho 合併市町村 : 合併市町村情報) {
//            旧市町村コードリスト.add(合併市町村.get市町村コード().value());
//        }
//        return 旧市町村コードリスト;
//    }
    private JigyoJokyoHokokuNempoSakueiHandler getHandler(JigyoJokyoHokokuNempoSakueiDiv div) {
        return new JigyoJokyoHokokuNempoSakueiHandler(div);
    }

    private JigyoJokyoHokokuNempoSakueiValidationHandler getValidationHandler(JigyoJokyoHokokuNempoSakueiDiv div) {
        return new JigyoJokyoHokokuNempoSakueiValidationHandler(div);
    }
}
