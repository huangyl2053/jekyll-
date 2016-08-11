/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiValidationHandler;
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
        getHandler(div).onLoad(shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告, 処理名List, 枝番List).records());
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンの 集計のみの 処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_shukei(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString 決定年月で集計 = new RString("keiteiYM4");
        RString 給付決定年月で集計 = new RString("keiteiYM5");
        if (div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(集計後に印刷)) {
            div.getCblOutputTaisho4().setVisible(true);
            div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
            div.getCblOutputTaisho5().setVisible(true);
            div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
            getHandler(div).set日付();
            getHandler(div).set時刻();
        } else if (div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(過去の集計結果を印刷)) {
            onLoad(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンの 集計後に印刷の　処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_shukeiOutput(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString 決定年月で集計 = new RString("keiteiYM4");
        RString 給付決定年月で集計 = new RString("keiteiYM5");
        if (div.getTblJikkoTani().getRadJikkoTaniShukeiOnly().getSelectedKey().equals(集計のみ)) {
            div.getCblOutputTaisho4().setVisible(true);
            div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
            div.getCblOutputTaisho5().setVisible(true);
            div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
            getHandler(div).set日付();
            getHandler(div).set時刻();
        } else if (div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(過去の集計結果を印刷)) {
            onLoad(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンの 過去の集計結果を印刷の　処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_kakoShukeiOutput(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        if (div.getTblJikkoTani().getRadJikkoTaniShukeiOnly().getSelectedKey().equals(集計のみ)
                || div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(過去の集計結果を印刷)) {
            onLoad(div);
            div.setShichosonList(null);
            getHandler(div).set日付();
            getHandler(div).set時刻();
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
        RDate 日付 = new RDate("平成12年5月");
        if (div.getTblJikkoTani().getRadJikkoTaniShukeiOnly().getSelectedKey().equals(集計のみ)
                || div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(過去の集計結果を印刷)) {
            if (div.getTxtHokokuYM().getValue() == null) {
                return ResponseData.of(div).addValidationMessages(getValidationHandler().check必須入力項目(new RString("報告年月"))).respond();
            }
            if (div.getTxtHokokuYM().getValue().isBefore(日付)) {
                return ResponseData.of(div).addValidationMessages(getValidationHandler().check以降の日付を設定()).respond();
            }
        }
        getHandler(div).set報告年月();
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
        getHandler(div).set月報報告_一般状況1_11onClick();
        getHandler(div).set月報報告_一般状況12_14_現物分onClick();
        getHandler(div).set月報報告_保険給付決定_現物分_onClick();
        getHandler(div).set月報報告_一般状況12_14_償還分();
        getHandler(div).set月報報告_保険給付決定_償還分();
        getHandler(div).set月報報告_保険給付決定_高額分();
        getHandler(div).set月報報告_保険給付決定_高額分算分();
        getHandler(div).setチェックボックス設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 合併市町村用保険者選択ラジオボタン の処理です。
     *
     * @param div 事業状況報告（月報）作成Div
     * @return ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoSakuseiDiv> onChange_radGappeiShichoson(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        RString 保険者分 = new RString("gappei");
        RString 旧市町村分 = new RString("kyuShichoson");
        if (div.getTblJikkoTani().getRadGappeiShichoson().getSelectedKey().equals(保険者分)) {
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(false);
        } else if (div.getTblJikkoTani().getRadGappeiShichoson().getSelectedKey().equals(旧市町村分)) {
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(true);
            div.setShichosonKubun(new RString("2"));
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
        RString 広域分 = new RString("koiki");
        RString 構成市町村分 = new RString("koseiShichoson");
        if (div.getTblJikkoTani().getRadKoikiRengo().getSelectedKey().equals(広域分)) {
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(false);
        } else if (div.getTblJikkoTani().getRadKoikiRengo().getSelectedKey().equals(構成市町村分)) {
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(true);
            div.setShichosonKubun(new RString("1"));
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

    private JigyoJokyoHokokuGeppoSakuseiHandler getHandler(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        return new JigyoJokyoHokokuGeppoSakuseiHandler(div);
    }

    private JigyoJokyoHokokuGeppoSakuseiValidationHandler getValidationHandler() {
        return new JigyoJokyoHokokuGeppoSakuseiValidationHandler();
    }
}
