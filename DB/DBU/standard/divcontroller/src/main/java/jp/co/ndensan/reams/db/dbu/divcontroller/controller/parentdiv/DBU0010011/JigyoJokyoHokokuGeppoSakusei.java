/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010010.DBU010010_JigyoHokokuGeppo_MainParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 事業状況報告（月報）作成の処理です。
 *
 * @reamsid_L DBU-5550-010 dangjingjing
 */
public class JigyoJokyoHokokuGeppoSakusei {
    private static final RString 集計のみ = new RString("shukei");
    private static final RString 集計後に印刷 = new RString("shukeiOutput");
    private static final RString 過去の集計結果を印刷 = new RString("kakoShukeiOutput");
    private static final RString 報告年月_完全未確定 = new RString("default");

    /**
     * 事業状況報告（月報）作成 の初期化処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onLoad(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        div.setKijun(new RString("nashi"));
        div.setHdnJkkoutani(集計のみ);
        div.setKakuteiHokokuYM(報告年月_完全未確定);
        getHandler(div).onLoad(get過去集計情報の取得());
        div.getRadGappeiShichoson().setDisabled(true);
        div.getRadKoikiRengo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンの 集計のみの 処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_shukei(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString jkkouTani = div.getHdnJkkoutani();
        if (集計後に印刷.equals(jkkouTani)) {
            RString 決定年月で集計 = new RString("keiteiYM4");
            RString 給付決定年月で集計 = new RString("keiteiYM5");
            div.getCblOutputTaisho4().setVisible(true);
            div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
            div.getCblOutputTaisho5().setVisible(true);
            div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
            getHandler(div).set日付時刻();
        }
        if (過去の集計結果を印刷.equals(jkkouTani)) {
            onLoad(div);
        }
        div.getBtnKakutei().setDisabled(false);
        div.getTxtHokokuYM().setDisabled(false);
        div.getDdlKakoHokokuYM().setDisabled(true);
        div.setHdnJkkoutani(集計のみ);
        div.getRadGappeiShichoson().setDisabled(true);
        div.getRadKoikiRengo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンの 集計後に印刷の　処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_shukeiOutput(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString jkkouTani = div.getHdnJkkoutani();
        if (集計のみ.equals(jkkouTani)) {
            RString 決定年月で集計 = new RString("keiteiYM4");
            RString 給付決定年月で集計 = new RString("keiteiYM5");
            div.getCblOutputTaisho4().setVisible(true);
            div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
            div.getCblOutputTaisho5().setVisible(true);
            div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
            getHandler(div).set日付時刻();
        }
        if (過去の集計結果を印刷.equals(jkkouTani)) {
            onLoad(div);
        }
        div.getBtnKakutei().setDisabled(false);
        div.getTxtHokokuYM().setDisabled(false);
        div.getDdlKakoHokokuYM().setDisabled(true);
        div.setHdnJkkoutani(集計後に印刷);
        div.getRadGappeiShichoson().setDisabled(true);
        div.getRadKoikiRengo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンの 過去の集計結果を印刷の　処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_kakoShukeiOutput(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString jkkouTani = div.getHdnJkkoutani();
        if (集計のみ.equals(jkkouTani) || 集計後に印刷.equals(jkkouTani)) {
            onLoad(div);
            div.setShichosonList(null);
            getHandler(div).set過去処理クリア();
        }
        div.getBtnKakutei().setDisabled(true);
        div.getTxtHokokuYM().setDisabled(true);
        div.getDdlKakoHokokuYM().setDisabled(false);
        div.setHdnJkkoutani(過去の集計結果を印刷);
        div.getRadGappeiShichoson().setDisabled(false);
        div.getRadKoikiRengo().setDisabled(false);
        if (new RString(div.getRadGappeiShichoson().getControlValue().toString()).equals(new RString("旧市町村分")) || new RString(div.getRadKoikiRengo().getControlValue().toString()).equals(new RString("構成市町村分"))) {
            div.getBtnShichosonSelect().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 確認するボタンの処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onClick_btnKakutei(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RDate 報告年月 = div.getTxtHokokuYM().getValue();
        RDate 日付 = new RDate("平成12年4月");
        if (報告年月 == null) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check必須入力項目(new RString("報告年月"))).respond();
        }
        if (!日付.isBefore(報告年月)) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check以降の日付を設定()).respond();
        }
        getHandler(div).set確定処理(報告年月);
        div.setKakuteiHokokuYM(div.getTxtHokokuYM().getValue().toDateString());
        return ResponseData.of(div).respond();
    }

    /**
     * 過去報告年月DDL の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_ddlKakoHokokuYM(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).set過去処理クリア();
        if (!RString.isNullOrEmpty(new RString(div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue().toString()))) {
            getHandler(div).set月報報告_一般状況1_11onClick();
            getHandler(div).set月報報告_一般状況12_14_現物分onClick();
            getHandler(div).set月報報告_保険給付決定_現物分_onClick();
            getHandler(div).set月報報告_一般状況12_14_償還分();
            getHandler(div).set月報報告_保険給付決定_償還分();
            getHandler(div).set月報報告_保険給付決定_高額分();
            getHandler(div).set月報報告_保険給付決定_高額合算分();
            getHandler(div).setすべて選択チェックボックス();
        } 
        return ResponseData.of(div).respond();
    }

    /**
     * 合併市町村用保険者選択ラジオボタン の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_radGappeiShichoson(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString 旧市町村分 = new RString("kyuShichoson");
        if (div.getTblJikkoTani().getRadGappeiShichoson().getSelectedKey().equals(旧市町村分)) {
            div.setShichosonKubun(new RString("2"));
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(false);
        } else {
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 広域構成市町村用保険者選択ラジオボタン の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_radKoikiRengo(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString 構成市町村分 = new RString("koseiShichoson");
        if (div.getTblJikkoTani().getRadKoikiRengo().getSelectedKey().equals(構成市町村分)) {
            div.setShichosonKubun(new RString("1"));
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(false);
        } else {
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * すべて選択チェックボックス の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaishoAll(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックスAll();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況1～11の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho1(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス1();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況12～14【現物分】の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho2(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス2();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【現物分】の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho3(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス3();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況12～14【償還分】の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho4(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス4();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況１２～１４【償還分】集計年月選択ラジオボタンの処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_radlblShukeiType4(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).onChange一般状況12to14集計年月();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】集計年月選択ラジオボタン の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_radlblShukeiType5(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).onChange保険給付決定状況集計年月();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho5(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス5();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【高額分】　チェックボックス の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho6(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス6();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【高額合算分】の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho7(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).setチェックボックス7();
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタン
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onClick_onBeforeOpen(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        ShichosonSelectorModel model = new ShichosonSelectorModel();
        RString 市町村区分 = RString.EMPTY;
        if (div.getRadGappeiShichoson().getSelectedKey().equals(new RString("kyuShichoson"))) {
            市町村区分 = new RString("0");
        }
        if (div.getRadKoikiRengo().getSelectedKey().equals(new RString("koseiShichoson"))) {
            市町村区分 = new RString("1");
        }
        model.setShichosonModel(市町村区分);
        div.setShichosonKubun(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタン
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onClick_onOkClose(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getShichosonKubun(), ShichosonSelectorModel.class);
        div.setShichosonKubun(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押します。
     *
     * @param div div
     * @return ResponseData<DBU010010_JigyoHokokuGeppo_MainParameter>
     */
    public ResponseData<DBU010010_JigyoHokokuGeppo_MainParameter> onClick_Jikou(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        onClick_btnJikkoCheck(div);
        return ResponseData.of(getHandler(div).onClick_Jikou()).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 事業報告月報作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    private ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onClick_btnJikkoCheck(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RDate 報告年月 = div.getTxtHokokuYM().getValue();
        RString jkkouTani = div.getHdnJkkoutani();

        if (過去の集計結果を印刷.equals(jkkouTani)) {
            return check過去集計結果印刷(div);
        } else {
            return check集計処理(div, 報告年月);
        }
    }

    private ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> check過去集計結果印刷(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        if (RString.isNullOrEmpty(div.getDdlKakoHokokuYM().getSelectedValue())) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check必須入力項目(new RString("過去報告年月"))).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> check集計処理(JigyoJokyoHokokuGeppoSakuseiDiv div, RDate 報告年月) {
        if (報告年月 != null) {
            return check集計処理_報告年月NotNull(div, 報告年月);
        } else {
            return check集計処理_報告年月Null(div);
        }
    }

    private ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> check集計処理_報告年月Null(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        if (div.getKakuteiHokokuYM().equals(報告年月_完全未確定)) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check必須入力項目(new RString("報告年月"))).respond();
        } else {
            div.getTxtHokokuYM().setValue(new RDate(div.getKakuteiHokokuYM().toString()));
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> check集計処理_報告年月NotNull(JigyoJokyoHokokuGeppoSakuseiDiv div, RDate 報告年月) {
        if (div.getKakuteiHokokuYM().equals(報告年月_完全未確定)) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check報告年月を確定()).respond();
        } else if (div.getHdnJkkoutani() != 過去の集計結果を印刷 && !div.getKakuteiHokokuYM().equals(報告年月.toDateString())) {
            div.getTxtHokokuYM().setValue(new RDate(div.getKakuteiHokokuYM().toString()));
        }
        return ResponseData.of(div).respond();
    }

    private List<ShoriDateKanri> get過去集計情報の取得() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        List<RString> 処理名List = new ArrayList<>();
        処理名List.add(Syorimei.月報報告一般状況１_１１.get名称());
        処理名List.add(Syorimei.月報報告一般状況１２_１４現物分.get名称());
        処理名List.add(Syorimei.月報報告一般状況１２_１４償還分審査.get名称());
        処理名List.add(Syorimei.月報報告一般状況１２_１４償還分決定.get名称());
        処理名List.add(Syorimei.月報報告保険給付決定現物分.get名称());
        処理名List.add(Syorimei.月報報告保険給付決定償還分審査.get名称());
        処理名List.add(Syorimei.月報報告保険給付決定償還分決定.get名称());
        処理名List.add(Syorimei.月報報告保険給付決定高額分.get名称());
        処理名List.add(Syorimei.月報報告保険給付決定高額合算分.get名称());
        List<RString> 枝番List = new ArrayList<>();
        枝番List.add(new RString("0001"));
        枝番List.add(new RString("0002"));
        枝番List.add(new RString("0003"));
        枝番List.add(new RString("0004"));
        枝番List.add(new RString("0005"));
        枝番List.add(new RString("0006"));
        枝番List.add(new RString("0007"));
        枝番List.add(new RString("0008"));
        枝番List.add(new RString("0009"));
        枝番List.add(new RString("0010"));
        枝番List.add(new RString("0011"));
        枝番List.add(new RString("0012"));
        return shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告, 処理名List, 枝番List).records();
    }

    private JigyoJokyoHokokuGeppoSakuseiHandler getHandler(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        return new JigyoJokyoHokokuGeppoSakuseiHandler(div);
    }

    private JigyoJokyoHokokuGeppoSakuseiValidationHandler getValidationHandler() {
        return new JigyoJokyoHokokuGeppoSakuseiValidationHandler();
    }
}
