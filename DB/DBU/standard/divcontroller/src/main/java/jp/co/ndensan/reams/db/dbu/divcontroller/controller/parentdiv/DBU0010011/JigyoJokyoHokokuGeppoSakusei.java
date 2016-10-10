/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010010.DBU010010_JigyoHokokuGeppo_MainParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 事業状況報告（月報）作成の処理です。
 *
 * @reamsid_L DBU-5550-010 dangjingjing
 */
public class JigyoJokyoHokokuGeppoSakusei {

    private static final RString 一般状況1_11 = new RString("ippan1_11");
    private static final RString 一般状況12_14_現物分 = new RString("ippan12_14Genbutsu");
    private static final RString 保険給付決定状況_現物分 = new RString("hokenKyufuGenbutsu");
    private static final RString 一般状況12_14_償還分 = new RString("ippan12_14Shokan");
    private static final RString 保険給付決定状況_償還分 = new RString("hokenKyufuShokan");
    private static final RString 保険給付決定状況_高額分 = new RString("hokenKyufuKogaku");
    private static final RString 保険給付決定状況_高額合算分 = new RString("hokenKyufuKogakuGassan");
    private static final RString 集計のみ = new RString("shukei");
    private static final RString 集計後に印刷 = new RString("shukeiOutput");
    private static final RString 過去の集計結果を印刷 = new RString("kakoShukeiOutput");

    /**
     * 事業状況報告（月報）作成 の初期化処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onLoad(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        div.setHdnJkkoutani(集計のみ);
        getHandler(div).onLoad(get過去集計情報の取得());
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
            div.getRadKoikiRengo().setDisabled(true);
            getHandler(div).set日付時刻();
        }
        if (過去の集計結果を印刷.equals(jkkouTani)) {
            getHandler(div).onLoad(get過去集計情報の取得());
        }
        div.getBtnKakutei().setDisabled(false);
        div.getTxtHokokuYM().setDisabled(false);
        div.getDdlKakoHokokuYM().setDisabled(true);
        div.getRadKoikiRengo().setDisabled(true);
        div.setHdnJkkoutani(集計のみ);
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
            div.getRadKoikiRengo().setDisabled(true);
            getHandler(div).set日付時刻();
        }
        if (過去の集計結果を印刷.equals(jkkouTani)) {
            getHandler(div).onLoad(get過去集計情報の取得());
        }
        div.getBtnKakutei().setDisabled(false);
        div.getTxtHokokuYM().setDisabled(false);
        div.getDdlKakoHokokuYM().setDisabled(true);
        div.setHdnJkkoutani(集計後に印刷);
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
            getHandler(div).onLoad(get過去集計情報の取得());
            div.setShichosonList(null);
            getHandler(div).set日付時刻の空白設定();
        }
        div.getBtnKakutei().setDisabled(true);
        div.getTxtHokokuYM().setDisabled(true);
        div.getDdlKakoHokokuYM().setDisabled(false);
        div.getRadKoikiRengo().setDisabled(false);
        div.setHdnJkkoutani(過去の集計結果を印刷);
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
        RDate 日付 = new RDate("平成12年5月");
        if (報告年月 == null) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check必須入力項目()).respond();
        }
        if (!日付.isBefore(報告年月)) {
            return ResponseData.of(div).addValidationMessages(getValidationHandler().check以降の日付を設定()).respond();
        }
        getHandler(div).set入力された報告年月より各集計年月の設定(報告年月);
        getHandler(div).setチェックボックス設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 過去報告年月DDL の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_ddlKakoHokokuYM(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        if (!RString.isNullOrEmpty(div.getDdlKakoHokokuYM().getSelectedValue())) {
            getHandler(div).set月報報告_一般状況1_11onClick();
            getHandler(div).set月報報告_一般状況12_14_現物分onClick();
            getHandler(div).set月報報告_保険給付決定_現物分_onClick();
            getHandler(div).set月報報告_一般状況12_14_償還分();
            getHandler(div).set月報報告_保険給付決定_償還分();
            getHandler(div).set月報報告_保険給付決定_高額分();
            getHandler(div).set月報報告_保険給付決定_高額分算分();
            getHandler(div).setチェックボックス設定();
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
        getHandler(div).setすべて選択();
        onChange_cblOutputTaisho1(div);
        onChange_cblOutputTaisho2(div);
        onChange_celOutputTaisho3(div);
        onChange_cblOutputTaisho4(div);
        onChange_cblOutputTaisho5(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 作成日時の設定 の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho1(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).set作成日時の設定();
        setすべて選択チェックボックス(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況12～14【償還分】　チェックボックス の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho2(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).set一般状況償還分();
        setすべて選択チェックボックス(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】　チェックボックス の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_celOutputTaisho3(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        getHandler(div).set保険給付償還分();
        setすべて選択チェックボックス(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況１２～１４【償還分】集計年月選択ラジオボタン の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho4(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        FlexibleDate shukeiYM4 = div.getTxtShukeiYM4().getValue();
        if (div.getRadlblShukeiType4().getSelectedKey().equals(new RString("shinsaYM4"))) {
            div.getTxtShukeiYM4().setValue(new FlexibleDate(div.getTxtShukeiYM4Bak()));
        } else if (div.getRadlblShukeiType4().getSelectedKey().equals(new RString("keiteiYM4"))) {
            div.getTxtShukeiYM4().setValue(shukeiYM4);
        }
        setすべて選択チェックボックス(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】集計年月選択ラジオボタン の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_cblOutputTaisho5(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        FlexibleDate shukeiYM5 = div.getTxtShukeiYM5().getValue();
        if (div.getRadlblShukeiType5().getSelectedKey().equals(new RString("shinsaYM5"))) {
            div.getTxtShukeiYM5().setValue(new FlexibleDate(div.getTxtShukeiYM5Bak()));
        } else if (div.getRadlblShukeiType5().getSelectedKey().equals(new RString("keiteiYM5"))) {
            div.getTxtShukeiYM5().setValue(shukeiYM5);
        }
        setすべて選択チェックボックス(div);
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
        return ResponseData.of(getHandler(div).onClick_Jikou()).respond();
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

    private void setすべて選択チェックボックス(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        List<RString> allKey = new ArrayList<>();
        if (div.getCblOutputTaisho1().getSelectedKeys().contains(一般状況1_11)
                && div.getCblOutputTaisho2().getSelectedKeys().contains(一般状況12_14_現物分)
                && div.getCblOutputTaisho3().getSelectedKeys().contains(保険給付決定状況_現物分)
                && div.getCblOutputTaisho4().getSelectedKeys().contains(一般状況12_14_償還分)
                && div.getCblOutputTaisho5().getSelectedKeys().contains(保険給付決定状況_償還分)
                && div.getCblOutputTaisho6().getSelectedKeys().contains(保険給付決定状況_高額分)
                && div.getCblOutputTaisho7().getSelectedKeys().contains(保険給付決定状況_高額合算分)) {
            allKey.add(new RString("all"));
        }
        div.getCblOutputTaishoAll().setSelectedItemsByKey(allKey);
    }

    private JigyoJokyoHokokuGeppoSakuseiHandler getHandler(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        return new JigyoJokyoHokokuGeppoSakuseiHandler(div);
    }

    private JigyoJokyoHokokuGeppoSakuseiValidationHandler getValidationHandler() {
        return new JigyoJokyoHokokuGeppoSakuseiValidationHandler();
    }
}
