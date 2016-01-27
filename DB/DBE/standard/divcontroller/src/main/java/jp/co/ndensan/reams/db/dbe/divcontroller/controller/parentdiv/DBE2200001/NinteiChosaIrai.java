/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinteichosaIraiJohoRelateBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.DBE2200001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001.NinteiChosaIraiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai.NinnteiChousairaiFinder;
import jp.co.ndensan.reams.db.dbe.service.report.chosairaisho.ChosaIraishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査依頼のコントローラです。
 */
public class NinteiChosaIrai {

    private static final RString WARITSUKE_ZUMI = new RString("割付済み");
    private static final RString MIWARITSUKE = new RString("未割付");
    private static final RString 設定方法 = new RString("1");
    private static final RString 提出期限_0 = new RString("0");
    private static final RString 提出期限_1 = new RString("1");
    private static final RString 提出期限_2 = new RString("2");
    private static final RString CHKIRAI_NAME = new RString("認定調査依頼書");

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onLoad(NinteiChosaIraiDiv div) {
        getHandler(div).load();

        ShoKisaiHokenshaNo 保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        RString 保険者名称 = RString.EMPTY;
        RString 支所コード = RString.EMPTY;
        LasdecCode 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード();
        if (getHandler(div).is単一保険者() && 市町村コード != null) {
            // TODO  内部QA：523 Redmine：#74276(保険者番号の取得方式が知らない、一時固定値を使用します)
            保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
            保険者名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();
            // TODO  内部QA：88 Redmine：#70702 支所情報取得につきましては、現在設計を追加で行っています。実装におかれましては、TODOとして進めてください。
            支所コード = RString.EMPTY;
        }

        // TODO  内部QA：523 Redmine：#74276(保険者番号の取得方式が知らない、一時固定値を使用します)
        保険者番号 = new ShoKisaiHokenshaNo("209007");

        ViewStateHolder.put(ViewStateKeys.支所コード, 支所コード);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 保険者番号);
        List<NinnteiChousairaiBusiness> 認定調査委託先List = NinnteiChousairaiFinder.createInstance().getNinnteiChousaItaku(
                NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(保険者番号, 支所コード)).records();
        getHandler(div).set認定調査委託先一覧(認定調査委託先List);
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査委託先一覧の選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onSelect_dgChosaItakusakiIchiran(NinteiChosaIraiDiv div) {
        dgChosaItakusakiIchiran_Row row = div.getDgChosaItakusakiIchiran().getActiveRow();
        getHandler(div).set委託先基本情報(row);
        getHandler(div).setDisabledToChosaItakusakiAndChosainKihonJoho(true);
        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(row.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, row.getChosaItakusakiCode().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査委託先の割付定員, row.getWaritsukeTeiin().getValue());
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor調査員情報(
                保険者番号, 支所コード, chosaItakusakiCode);
        List<NinnteiChousairaiBusiness> 調査員情報一覧 = NinnteiChousairaiFinder.createInstance().getChousaIn(parameter).records();
        getHandler(div).set調査員情報一覧(調査員情報一覧, row);

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査員一覧の選択処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onSelect_dgchosainIchiran(NinteiChosaIraiDiv div) {
        dgchosainIchiran_Row row = div.getChosainIchiran().getDgchosainIchiran().getActiveRow();
        getHandler(div).set委託先基本情報(row);
        ViewStateHolder.put(ViewStateKeys.調査員の当月調査可能人数, row.getChosaKanoNinzuPerMonth());

        ChosainCode chosainCode = new ChosainCode(row.getChosainCode().getValue());
        ViewStateHolder.put(ViewStateKeys.調査員コード, row.getChosainCode().getValue());
        ChosaItakusakiCode chosaItakusakiCode = new ChosaItakusakiCode(ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class));
        RString 支所コード = ViewStateHolder.get(ViewStateKeys.支所コード, RString.class);
        ShoKisaiHokenshaNo 保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);

        NinnteiChousairaiParameter parameter = NinnteiChousairaiParameter.createParamfor割付済み申請者一覧(
                保険者番号, 支所コード, chosaItakusakiCode, chosainCode);
        List<WaritsukeBusiness> 割付済み申請者一覧 = NinnteiChousairaiFinder.createInstance().getWaritsuke(parameter).records();
        getHandler(div).set割付済み申請者一覧(割付済み申請者一覧, row.getHokenshaName());
        parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(保険者番号, 支所コード);
        List<WaritsukeBusiness> 未割付申請者一覧 = NinnteiChousairaiFinder.createInstance().getShiteWaritsuke(parameter).records();
        getHandler(div).set未割付申請者一覧(未割付申請者一覧, row.getHokenshaName());

        parameter = NinnteiChousairaiParameter.createParam調査委託先Or未割付申請者(保険者番号, 支所コード);
        List<WaritsukeBusiness> 未割付再依頼一覧 = NinnteiChousairaiFinder.createInstance().getShiteWaritsukeSai(parameter).records();
        getHandler(div).set未割付申請者一覧(未割付再依頼一覧, row.getHokenshaName());

        parameter = NinnteiChousairaiParameter.createParamfor割付済み申請者一覧(保険者番号, 支所コード, chosaItakusakiCode, chosainCode);
        List<NinteichosaIraiJohoRelateBusiness> 割付済み一覧 = NinnteiChousairaiFinder.createInstance().getNinteichosaIraiJohoList(parameter).records();
        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        List<NinteichosaIraiJoho> ninteichosaIraiJohoList = new ArrayList<>();
        if (!割付済み一覧.isEmpty()) {
            ninteiKanryoJohoList = 割付済み一覧.get(0).getNinteiKanryoJohoList();
            ninteichosaIraiJohoList = 割付済み一覧.get(0).getNinteichosaIraiJohoList();
        }
        ViewStateHolder.put(ViewStateKeys.検索結果_認定調査依頼情報, Models.create(ninteichosaIraiJohoList));
        ViewStateHolder.put(ViewStateKeys.検索結果_要介護認定完了情報, Models.create(ninteiKanryoJohoList));
        getHandler(div).init印刷条件DIV();
        return ResponseData.of(div).respond();
    }

    /**
     * 「↑申請者を割付ける」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnWaritsuke(NinteiChosaIraiDiv div) {

        List<dgMiwaritsukeShinseishaIchiran_Row> selectedItems = div.getDgMiwaritsukeShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.選択されていない.getMessage().replace("未割付申請者"));
        }
        if (isWaritsuke(selectedItems, div)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbeWarningMessages.割付申請者人数が最大割付可能人数を超過.getMessage()).respond();
            }
            if (new RString(DbeWarningMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }

        for (dgMiwaritsukeShinseishaIchiran_Row row : selectedItems) {
            getHandler(div).set割付済み申請者一覧(row);
            div.getDgMiwaritsukeShinseishaIchiran().getDataSource().remove(row);
        }
        getHandler(div).initIndex();
        return ResponseData.of(div).respond();
    }

    private boolean isWaritsuke(List<dgMiwaritsukeShinseishaIchiran_Row> selectedItems, NinteiChosaIraiDiv div) {
        boolean isWaritsuke = false;
        int 割付人数 = selectedItems.size();
        int 既存割付済み人数 = getHandler(div).get既存割付済み人数();
        RString 調査員コード = ViewStateHolder.get(ViewStateKeys.調査員コード, RString.class);
        RString 認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
        int waritsukeTeiin = ViewStateHolder.get(ViewStateKeys.認定調査委託先の割付定員, Decimal.class).intValue();
        int chosaKanoNinzuPerMonth = Integer.parseInt(ViewStateHolder.get(ViewStateKeys.調査員の当月調査可能人数, RString.class).toString());
        int count = 割付人数 + 既存割付済み人数;
        if (!RString.isNullOrEmpty(認定調査委託先コード)
                && RString.isNullOrEmpty(調査員コード)
                && waritsukeTeiin < count) {
            isWaritsuke = true;
        }

        if (!RString.isNullOrEmpty(認定調査委託先コード)
                && !RString.isNullOrEmpty(調査員コード)
                && chosaKanoNinzuPerMonth < count) {
            isWaritsuke = true;
        }

        return isWaritsuke;
    }

    /**
     * 「↓割付けを解除する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnKaijo(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.選択されていない.getMessage().replace("割付済み申請者"));
        }
        boolean isSonzai = false;
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            if (!RString.isNullOrEmpty(row.getNinteichosaKanryoYMD())) {
                isSonzai = true;
                break;
            }
        }

        if (isSonzai) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.認定調査完了申請者ですが割付解除.getMessage().getCode(),
                        DbeQuestionMessages.認定調査完了申請者ですが割付解除.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.認定調査完了申請者ですが割付解除.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            getHandler(div).set未割付申請者一覧(row);
            div.getDgWaritsukeZumiShinseishaIchiran().getDataSource().remove(row);
        }
        getHandler(div).initIndex();
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定調査委託先選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosaItakusakiSentaku(NinteiChosaIraiDiv div) {
        if (getHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE2200001StateName.初期表示);
    }

    /**
     * 「認定調査員選択へ戻る」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnBackToChosainSentaku(NinteiChosaIraiDiv div) {
        if (getHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).setState(DBE2200001StateName.委託先選択後);
    }

    /**
     * 「割付内容を保存する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaIraiDiv> onClick_btnHozon(NinteiChosaIraiDiv div) {
        if (!getHandler(div).isUpdateForHozon()) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        inertNinteichosaIraiJoho(div);
        updateNinteichosaIraiJoho(div);
        // TODO 内部QA560 Redmine：    (完了メッセージの表示方式が知らない)
//        div.getKanryoMessage().setSuccessMessage(
//                new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    private void inertNinteichosaIraiJoho(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> waritsukeZumiShinseishaIchiran = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援);
        RString 調査票提出期限 = BusinessConfig.get(ConfigNameDBE.調査票提出期限, SubGyomuCode.DBE認定支援);
        FlexibleDate 認定調査依頼年月日 = new FlexibleDate(div.getTxtChosaIraiDay().getValue().toDateString());
        for (dgWaritsukeZumiShinseishaIchiran_Row row : waritsukeZumiShinseishaIchiran) {
            if (MIWARITSUKE.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 認定調査依頼履歴番号 = 1;
                RString 調査員コード = ViewStateHolder.get(ViewStateKeys.調査員コード, RString.class);
                RString 認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);

                FlexibleDate 認定申請日 = new FlexibleDate(row.getNinteiShinseiDay().getValue().toDateString());
                FlexibleDate 認定調査期限年月日;
                if (設定方法.equals(認定調査期限設定方法)) {
                    認定調査期限年月日 = 認定調査依頼年月日.plusDay(Integer.parseInt(調査票提出期限.toString()));
                } else {
                    認定調査期限年月日 = 認定申請日.plusDay(Integer.parseInt(調査票提出期限.toString()));
                }
                if (ChosaKubun.新規調査.get名称().equals(row.getChosaKubun())) {
                    NinteichosaIraiJoho ninteichosaIraiJoho = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号);
                    ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                            .set認定調査委託先コード(new JigyoshaNo(認定調査委託先コード))
                            .set認定調査員コード(調査員コード)
                            .set認定調査依頼区分コード(new Code(NinteichosaIraiKubun.初回.getCode()))
                            .set認定調査回数(0)
                            .set認定調査依頼年月日(認定調査依頼年月日)
                            .set認定調査期限年月日(認定調査期限年月日)
                            .set論理削除フラグ(false).build();
                    ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho);
                }

                if (ChosaKubun.再調査.get名称().equals(row.getChosaKubun())) {
                    認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString()) + 1;
                    NinteichosaIraiJoho ninteichosaIraiJoho = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号);
                    ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()))
                            .set認定調査委託先コード(new JigyoshaNo(認定調査委託先コード))
                            .set認定調査員コード(調査員コード)
                            .set認定調査依頼区分コード(new Code(NinteichosaIraiKubun.再調査.getCode()))
                            .set認定調査回数(1)
                            .set認定調査依頼年月日(認定調査依頼年月日)
                            .set認定調査期限年月日(認定調査期限年月日)
                            .set論理削除フラグ(false).build();
                    ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho);
                }

                row.setJotai(WARITSUKE_ZUMI);
            }
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(waritsukeZumiShinseishaIchiran);
    }

    private void updateNinteichosaIraiJoho(NinteiChosaIraiDiv div) {
        List<dgMiwaritsukeShinseishaIchiran_Row> miwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        Models<NinteichosaIraiJohoIdentifier, NinteichosaIraiJoho> ninteichosaIraiJohoList = ViewStateHolder.get(ViewStateKeys.検索結果_認定調査依頼情報, Models.class);
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJohoList = ViewStateHolder.get(ViewStateKeys.検索結果_要介護認定完了情報, Models.class);
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        NinteiKanryoJohoManager ninteiKanryoJohoManager = NinteiKanryoJohoManager.createInstance();
        for (dgMiwaritsukeShinseishaIchiran_Row row : miwaritsukeShinseishaIchiran) {
            if (WARITSUKE_ZUMI.equals(row.getJotai())) {
                ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(row.getShinseishoKanriNo());
                int 認定調査依頼履歴番号 = Integer.parseInt(row.getNinteichosaIraiRirekiNo().toString());
                NinteichosaIraiJohoIdentifier ninteichosaIraiJohoIdentifier = new NinteichosaIraiJohoIdentifier(申請書管理番号, 認定調査依頼履歴番号);
                NinteichosaIraiJoho ninteichosaIraiJoho
                        = ninteichosaIraiJohoList.get(ninteichosaIraiJohoIdentifier).createBuilderForEdit().set論理削除フラグ(true).build();
                ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho.modifiedModel());

                NinteiKanryoJohoIdentifier ninteiKanryoJohoIdentifier = new NinteiKanryoJohoIdentifier(申請書管理番号);
                NinteiKanryoJoho ninteiKanryoJoho = ninteiKanryoJohoList.get(ninteiKanryoJohoIdentifier).createBuilderForEdit().set認定調査依頼完了年月日(FlexibleDate.EMPTY)
                        .set認定調査完了年月日(FlexibleDate.EMPTY).build();
                ninteiKanryoJohoManager.save要介護認定完了情報(ninteiKanryoJoho.modifiedModel());
                row.setJotai(MIWARITSUKE);
            }
        }
    }

    /**
     * 「選択した帳票を発行する」ボタンのclick処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_BtnPrint(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        if (selectedItems.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("割付済み申請者未指定ため、依頼書の印刷"));
        }
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            if (MIWARITSUKE.equals(row.getJotai())) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("認定調査依頼が未割付のため、発行"));
            }
        }
        List<RString> chkirai = div.getChkirai().getSelectedValues();
        List<RString> chkchosa = div.getChkchosa().getSelectedValues();
        List<RString> chkchosaOcr = div.getChkchosaOcr().getSelectedValues();
        List<RString> chkchosaSonota = div.getChkchosaSonota().getSelectedValues();
        List<RString> list = new ArrayList<>();
        list.addAll(chkirai);
        list.addAll(chkchosa);
        list.addAll(chkchosaOcr);
        list.addAll(chkchosaSonota);
        if (list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("発行書類を"));
        }
        // TODO  内部QA：523 Redmine：#74276(「前排他制御を行う」の排他はしらない)
        updateNinteichosaIraiJohoForPrint(div);
        List<ChosaIraishoHeadItem> chosaIraishoHeadItemList = getHandler(div).create認定調査依頼書印刷用パラメータ();
        if (div.getChkirai().getSelectedValues().contains(CHKIRAI_NAME)) {
            return ResponseData.of(new ChosaIraishoPrintService().print(chosaIraishoHeadItemList))
                    .addMessage(UrInformationMessages.正常終了.getMessage().replace("発行処理は")).respond();
        }
        return ResponseData.of(new ChosaIraishoPrintService().print(chosaIraishoHeadItemList))
                .addMessage(UrInformationMessages.正常終了.getMessage().replace("発行処理は")).respond();
        // TODO Temp_認定調査票(概況調査) 帳票未作成
        // TODO Temp_認定調査票(基本調査)　帳票未作成
        // TODO Temp_認定調査票(特記事項)　帳票未作成
        // TODO Temp_認定調査票OCR(概況調査)　帳票未作成
        // TODO Temp_認定調査票OCR(基本調査)　帳票未作成
        // TODO Temp_認定調査票OCR(特記事項)　帳票未作成
        // TODO Temp_認定調査票(特記事項)フリー様式　帳票未作成
        // TODO Temp_認定調査票差異チェック票　帳票未作成

    }

    private void updateNinteichosaIraiJohoForPrint(NinteiChosaIraiDiv div) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        NinnteiChousairaiFinder ninnteiChousairaiFinder = NinnteiChousairaiFinder.createInstance();
        NinteichosaIraiJohoManager ninteichosaIraiJohoManager = NinteichosaIraiJohoManager.createInstance();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            List<NinteichosaIraiJoho> ninteichosaIraiJohoList = ninnteiChousairaiFinder.getNinteichosaIraiJoho(row.getShinseishoKanriNo()).records();
            if (ninteichosaIraiJohoList.isEmpty()) {
                continue;
            }
            NinteichosaIraiJoho ninteichosaIraiJoho = ninteichosaIraiJohoList.get(0);
            RString 提出期限 = div.getRadkigen().getSelectedKey();
            FlexibleDate 発行日 = new FlexibleDate(div.getTxthokkoymd().getValue().toDateString());
            FlexibleDate 共通日付 = new FlexibleDate(div.getTxtkigenymd().getValue().toDateString());
            if (div.getChkirai().getSelectedValues().contains(CHKIRAI_NAME)) {
                FlexibleDate 認定調査期限年月日 = ninteichosaIraiJoho.get認定調査依頼年月日();
                RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援);
                RString 認定調査作成期限日数 = BusinessConfig.get(ConfigNameDBE.認定調査作成期限日数, SubGyomuCode.DBE認定支援);
                if (設定方法.equals(認定調査期限設定方法) && 提出期限_0.equals(提出期限)) {
                    認定調査期限年月日 = 認定調査期限年月日.plusDay(Integer.parseInt(認定調査作成期限日数.toString()));
                } else if (設定方法.equals(認定調査期限設定方法) && 提出期限_1.equals(提出期限)) {
                    認定調査期限年月日 = FlexibleDate.EMPTY;
                } else if (設定方法.equals(認定調査期限設定方法) && 提出期限_2.equals(提出期限)) {
                    認定調査期限年月日 = 共通日付;
                }
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set依頼書出力年月日(発行日)
                        .set認定調査期限年月日(認定調査期限年月日).build();
                ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho.modifiedModel());
            } else {
                ninteichosaIraiJoho = ninteichosaIraiJoho.createBuilderForEdit().set依頼書出力年月日(発行日)
                        .set調査票等出力年月日(発行日).build();
                ninteichosaIraiJohoManager.save認定調査依頼情報(ninteichosaIraiJoho.modifiedModel());
            }
        }
    }

    private NinteiChosaIraiHandler getHandler(NinteiChosaIraiDiv div) {
        return new NinteiChosaIraiHandler(div);
    }
}
