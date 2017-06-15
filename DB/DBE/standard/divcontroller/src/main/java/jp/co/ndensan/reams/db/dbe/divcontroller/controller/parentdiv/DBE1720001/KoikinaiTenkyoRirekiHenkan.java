/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1720001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.DBE1720001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.KoikinaiTenkyoRirekiHenkanDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1720001.KoikinaiTenkyoRirekiHenkanHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1720001.KoikinaiTenkyoRirekiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 画面設計_DBE1720001_広域内転居画面クラスです
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
public class KoikinaiTenkyoRirekiHenkan {

    private static final RString TRUE = new RString("True");
    private static final RString 状態_更新 = new RString("更新");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KoikinaiTenkyoRirekiHenkanDiv>
     */
    public ResponseData<KoikinaiTenkyoRirekiHenkanDiv> onLoad(KoikinaiTenkyoRirekiHenkanDiv div) {
        getHandler(div).setOnLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件より、適当な条件を連結して、申請者一覧情報を検索する
     *
     * @param div 画面情報
     * @return ResponseData<KoikinaiTenkyoRirekiHenkanDiv>
     */
    public ResponseData<KoikinaiTenkyoRirekiHenkanDiv> onClick_Kensaku(KoikinaiTenkyoRirekiHenkanDiv div) {
        if (!ResponseHolder.isReRequest()) {
            List<dgShinseishaIchiran_Row> dataGridList = div.getDgShinseishaIchiran().getDataSource();
            for (dgShinseishaIchiran_Row row : dataGridList) {
                RString state = row.getColumnState();
                if (状態_更新.equals(state)) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
            }
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || !ResponseHolder.isReRequest()) {
            if (0 == searchShinseisyaInfo(div)) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
        }
        if (new RString(UrInformationMessages.該当データなし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            div.getShinseishaIchiran().getDgShinseishaIchiran().getDataSource().clear();
            return ResponseData.of(div).setState(DBE1720001StateName.初期表示);
        }
        return ResponseData.of(div).setState(DBE1720001StateName.申請者一覧);
    }

    /**
     * 「選択」ボタン処理です。
     *
     * @param div 画面情報
     * @return <KoikinaiTenkyoRirekiHenkanDiv>
     */
    public ResponseData<KoikinaiTenkyoRirekiHenkanDiv> onClick_Sentaku(KoikinaiTenkyoRirekiHenkanDiv div) {
        getHandler(div).onClick_btnSentaku(createListFromDbT7051KoseiShichosonMaster());
        return ResponseData.of(div).respond();
    }

    /**
     * 「登録する」ボタン処理です。
     *
     * @param div 画面情報
     * @return <KoikinaiTenkyoRirekiHenkanDiv>
     */
    public ResponseData<KoikinaiTenkyoRirekiHenkanDiv> onClick_Touroku(KoikinaiTenkyoRirekiHenkanDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).証記載保険者番号チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onClick_btnTouroku();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン処理です。
     *
     * @param div 画面情報
     * @return <KoikinaiTenkyoRirekiHenkanDiv>
     */
    public ResponseData<KoikinaiTenkyoRirekiHenkanDiv> onClick_Hozon(KoikinaiTenkyoRirekiHenkanDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            updateDbT5101NinteiShinseiJoho(div);
            div.getShinsakaiMessage().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE1720001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするボタン処理です。
     *
     * @param div 画面情報
     * @return <KoikinaiTenkyoRirekiHenkanDiv>
     */
    public ResponseData<KoikinaiTenkyoRirekiHenkanDiv> onClick_JoukenClear(KoikinaiTenkyoRirekiHenkanDiv div) {
        getHandler(div).onClick_JoukenClear();
        return ResponseData.of(div).respond();
    }

    private int searchShinseisyaInfo(KoikinaiTenkyoRirekiHenkanDiv div) {
        KoikinaiTenkyoRirekiHenkanMapperParameter parameter = KoikinaiTenkyoRirekiHenkanMapperParameter.createSelectByKeyParam(
                div.getTxtHihokenshaNumber().getValue(),
                new AtenaMeisho(div.getTxtHihokenshaNameJyouken().getValue()),
                div.getTxtNinteiShinseiDateRange().getFromValue() == null ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getTxtNinteiShinseiDateRange().getFromValue().toString()),
                div.getTxtNinteiShinseiDateRange().getToValue() == null ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getTxtNinteiShinseiDateRange().getToValue().toString()),
                div.getTxtBirthDateRange().getFromValue() == null ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getTxtBirthDateRange().getFromValue().toString()),
                div.getTxtBirthDateRange().getToValue() == null ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getTxtBirthDateRange().getToValue().toString()),
                new Code(div.getDdlShinseijiShinseiKubun().getSelectedKey()),
                div.getDdlHihokenshaNameMatchType().getSelectedKey(),
                div.getChkMinashiFlag().getSelectedKeys().contains(TRUE),
                div.getDdlShinseijiShinseiKubun().getSelectedKey(),
                div.getChkSeibetsu().getSelectedKeys(),
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード(),
                div.getTextBoxNum().getValue()
        );
        KoikinaiTenkyoRirekiHenkanFinder koikinaitenkyofinder = KoikinaiTenkyoRirekiHenkanFinder.createInstance();
        SearchResult<jp.co.ndensan.reams.db.dbe.business.core.basic.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkan> 申請者一覧情報List
                = koikinaitenkyofinder.getKoikinaiTenkyoList(parameter);
        List<NinteiShinseiJoho> 一覧情報 = koikinaitenkyofinder.getUpdateDataList(parameter).records();
        if (null != 申請者一覧情報List.records() && !申請者一覧情報List.records().isEmpty()) {
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho
                    = Models.create(一覧情報);
            ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, ninteiShinseiJoho);
            getHandler(div).setShinseisyaitiran(申請者一覧情報List);
            return 申請者一覧情報List.records().size();
        } else {
            return 0;
        }
    }

    private KoikinaiTenkyoRirekiHenkanHandler getHandler(KoikinaiTenkyoRirekiHenkanDiv div) {
        return new KoikinaiTenkyoRirekiHenkanHandler(div);
    }

    private KoikinaiTenkyoRirekiValidationHandler getValidationHandler(KoikinaiTenkyoRirekiHenkanDiv div) {
        return new KoikinaiTenkyoRirekiValidationHandler(div);
    }

    private List<KeyValueDataSource> createListFromDbT7051KoseiShichosonMaster() {
        KoikinaiTenkyoRirekiHenkanFinder koikinaitenkyofinder = KoikinaiTenkyoRirekiHenkanFinder.createInstance();
        return koikinaitenkyofinder.creatListFromDbT7051().records();
    }

    private void updateDbT5101NinteiShinseiJoho(KoikinaiTenkyoRirekiHenkanDiv div) {
        List<dgShinseishaIchiran_Row> dataGridList = div.getDgShinseishaIchiran().getDataSource();
        for (int index = 0; index < div.getDgShinseishaIchiran().getTotalRecords(); index++) {
            RString state = dataGridList.get(index).getColumnState();
            // TODO 過去の認定情報データの更新扱いについて確認後実装してください。更新データについては以下が考えられる
            // 過去データ全て更新・有効な過去データ更新・該当データと1個前データ更新・該当データ更新
//            KoikinaiTenkyoRirekiHenkanFinder finder = KoikinaiTenkyoRirekiHenkanFinder.createInstance();
            ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(
                    dataGridList.get(index).getShinseishoKanriNo());
            RString shokisaihokenshaNo = dataGridList.get(index).getShoKisaiHokenshaNo();
//            boolean flag = true;
//            if (finder.getZenkaiShinseishoKanriNo(shinseishoKanriNo) == null) {
//                flag = false;
//            }
            if (状態_更新.equals(state)) {
                upDateNinteiShinseiJoho(shinseishoKanriNo, shokisaihokenshaNo, false);
//                if (flag) {
//                    upDateNinteiShinseiJoho(finder.getZenkaiShinseishoKanriNo(shinseishoKanriNo), shokisaihokenshaNo, flag);
//                }
            }
        }
    }

    private void upDateNinteiShinseiJoho(ShinseishoKanriNo shinseishoKanriNo, RString shokisaihokenshaNo, boolean flag) {
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> models
                = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, Models.class);
        NinteiShinseiJohoManager manager = NinteiShinseiJohoManager.createInstance();
        if (flag) {
            NinteiShinseiJoho ninteiShinseiJoho = manager.get要介護認定申請情報(shinseishoKanriNo);
            ninteiShinseiJoho = ninteiShinseiJoho.createBuilderForEdit().set証記載保険者番号(shokisaihokenshaNo).build();
            manager.save要介護認定申請情報(ninteiShinseiJoho);
        } else {
            for (NinteiShinseiJoho ninteiShinseiJoho : models) {
                if (ninteiShinseiJoho.get申請書管理番号().equals(shinseishoKanriNo)) {
                    manager.save要介護認定申請情報(ninteiShinseiJoho.createBuilderForEdit().set証記載保険者番号(shokisaihokenshaNo).build().modifiedModel());
                }
            }
        }
    }
}
