package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ShinsakaiWariateHistories;
import static jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages.審査会結果登録済み_イメージ削除不可;
import static jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages.審査会資料作成済みイメージ_削除確認;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001.DBE5710001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001.YokaigoninteiimagekanriDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710001.YokaigoninteiimagekanriHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagekanri.YokaigoninteiimagekanriFinder;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定イメージ情報管理のコントローラです。
 *
 * @reamsid_L DBE-1670-010 wangxiaodong
 */
public class Yokaigoninteiimagekanri {

    private static final RString イメージ区分_調査票概況 = new RString("1");
    private static final RString イメージ区分_意見書定型 = new RString("2");
    private static final RString イメージ区分_その他資料 = new RString("3");
    private static final RString イメージ区分_意見書定型外 = new RString("4");
    private final YokaigoninteiimagekanriFinder finder;

    /**
     * コンストラクタです。
     */
    public Yokaigoninteiimagekanri() {
        finder = YokaigoninteiimagekanriFinder.createInstance();
    }

    /**
     * 画面初期化表示です。
     *
     * @param div 要介護認定イメージ情報管理
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onLoad(YokaigoninteiimagekanriDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ImagekanriJoho イメージ管理情報 = finder.getImageJoho(申請書管理番号);
        ViewStateHolder.put(ViewStateKeys.イメージ情報, イメージ管理情報);
        div.getCcdNinteiShinseishaKihonInfo().initialize(new ShinseishoKanriNo(申請書管理番号));
        if (イメージ管理情報.get申請書管理番号() != null && !イメージ管理情報.get申請書管理番号().isEmpty()) {
            div.setHdnShinseishoKanriNo(イメージ管理情報.get申請書管理番号().value());
            div.setHdnHihokenshaNo(イメージ管理情報.get被保険者番号());
            div.setHdnShokisaiHokenshaNo(イメージ管理情報.get証記載保険者番号());
        }
        if (イメージ管理情報.get認定調査依頼履歴番号() != 0) {
            div.setHdnNinteichosaRirekiNo(new RString(イメージ管理情報.get認定調査依頼履歴番号()));
        }
        if (イメージ管理情報.get概況調査テキストイメージ区分() != null && !イメージ管理情報.get概況調査テキストイメージ区分().isEmpty()) {
            div.setHdnGaikyoChosaTextImageKubun(イメージ管理情報.get概況調査テキストイメージ区分());
        }
        init_SetTextControlDisabled(div);
        init_SetTextValue(div, イメージ管理情報);
        init_SetBtnControlDisabled(div);
        if (イメージ管理情報.getイメージ共有ファイルID() != null) {
            RString toCopyPath = DBEImageUtil.copySharedFiles(
                    イメージ管理情報.getイメージ共有ファイルID(), div.getHdnShokisaiHokenshaNo().concat(div.getHdnHihokenshaNo()));
            ViewStateHolder.put(ViewStateKeys.イメージ取込み, toCopyPath);
            div.setHdnImageLocalCopyPath(toCopyPath);
            ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(
                    イメージ管理情報.get証記載保険者番号().concat(イメージ管理情報.get被保険者番号())),
                    イメージ管理情報.getイメージ共有ファイルID());
            setBtnControllerDisabled(div, descriptor);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * イメージ出力ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnImageOutput(YokaigoninteiimagekanriDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5710001TransitionEventName.要介護認定イメージ情報出力へ).respond();
    }

    /**
     * btnReSearch処理。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> btnReSearch(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.機能詳細画面から再検索, Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * イメージ削除ボタンがクリックされた際の処理です。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnImageDelete(YokaigoninteiimagekanriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ImagekanriJoho imageKanri = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
            ShinsakaiWariateHistories histories = imageKanri.get審査会割当履歴();
            if (histories.findDeletableImages().isNone()) {
                return ResponseData.of(div)
                        .addMessage(審査会結果登録済み_イメージ削除不可.getMessage())
                        .respond();
            }
            if (histories.had審査会資料Published()) {
                return ResponseData.of(div)
                        .addMessage(審査会資料作成済みイメージ_削除確認.getMessage())
                        .respond();
            }
        }
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        String messageCode = ResponseHolder.getMessageCode().toString();
        if (審査会結果登録済み_イメージ削除不可.getMessage().getCode().equals(messageCode)) {
            return ResponseData.of(div).respond();
        }
        if (審査会資料作成済みイメージ_削除確認.getMessage().getCode().equals(messageCode)
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE5710001TransitionEventName.要介護認定イメージ情報削除へ).respond();
    }

    /**
     * 概況調査ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnGaikyoChosa(YokaigoninteiimagekanriDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 認定調査依頼履歴番号 = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getHdnHihokenshaNo());
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getHdnShokisaiHokenshaNo());
        div.setHdnShinseishoKanriNo(申請書管理番号);
        div.setHdnNinteichosaRirekiNo(認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 調査票特記ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnChosahyoTokki(YokaigoninteiimagekanriDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 認定調査依頼履歴番号 = new RString(ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getHdnHihokenshaNo());
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getHdnShokisaiHokenshaNo());
        div.setHdnShinseishoKanriNo(申請書管理番号);
        div.setHdnNinteichosaRirekiNo(認定調査依頼履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 概況特記ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnGaikyoTokki(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.イメージ区分, イメージ区分_調査票概況);
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書定型外ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnIkenshoTeikeigai(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.イメージ区分, イメージ区分_意見書定型外);
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書定型ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnIkenshoTeikei(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.イメージ区分, イメージ区分_意見書定型);
        return ResponseData.of(div).respond();
    }

    /**
     * その他資料ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnSonota(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.イメージ区分, イメージ区分_その他資料);
        return ResponseData.of(div).respond();
    }

    private void init_SetTextControlDisabled(YokaigoninteiimagekanriDiv div) {
        div.getTxtShinseiYMD().setDisabled(true);
        div.getTxtJuryoYMD().setDisabled(true);
        div.getTxtJishiYMD().setDisabled(true);
        div.getTxtReadYMD().setDisabled(true);
        div.getTxtKinyuYMD().setDisabled(true);
        div.getRadSonota().setDisabled(true);
    }

    private void init_SetTextValue(YokaigoninteiimagekanriDiv div, ImagekanriJoho イメージ管理情報) {
        if (イメージ管理情報.get認定申請日() != null) {
            div.getTxtShinseiYMD().setValue(new RDate(イメージ管理情報.get認定申請日().toString()));
        }
        if (isValid(イメージ管理情報.get認定調査受領年月日())) {
            div.getTxtJuryoYMD().setValue(new RDate(イメージ管理情報.get認定調査受領年月日().toString()));
        }
        if (isValid(イメージ管理情報.get認定調査実施年月日())) {
            div.getTxtJishiYMD().setValue(new RDate(イメージ管理情報.get認定調査実施年月日().toString()));
        }
        if (isValid(イメージ管理情報.get主治医意見書読取年月日())) {
            div.getTxtReadYMD().setValue(new RDate(イメージ管理情報.get主治医意見書読取年月日().toString()));
        }
        if (isValid(イメージ管理情報.get主治医意見書記入年月日())) {
            div.getTxtKinyuYMD().setValue(new RDate(イメージ管理情報.get主治医意見書記入年月日().toString()));
        }
    }

    private static boolean isValid(FlexibleDate fDate) {
        return fDate != null && fDate.isValid();
    }

    private void init_SetBtnControlDisabled(YokaigoninteiimagekanriDiv div) {
        div.getRadSonota().setSelectedIndex(1);
        div.getBtnGaikyoChosa().setDisabled(true);
        div.getBtnChosahyoTokuki().setDisabled(true);
        div.getBtnGaikyoTokki().setDisabled(true);
        div.getBtnIkenshoTeikei().setDisabled(true);
        div.getBtnIkenshoTeikeigai().setDisabled(true);
        div.getBtnSonota().setDisabled(true);
        setDisabledCommonBtnField(true);
    }

    private void setBtnControllerDisabled(YokaigoninteiimagekanriDiv div, ReadOnlySharedFileEntryDescriptor ro_sfed) {
        List<RString> 存在したイメージファイル名 = YokaigoninteiimagesakujoManager.createInstance().get存在したイメージファイル名(ro_sfed);
        if (存在したイメージファイル名 != null && !存在したイメージファイル名.isEmpty() && !存在したイメージファイル名.contains(null)) {
            if (getHandler(div).isExistsGaikyoChosaImageFile(存在したイメージファイル名)) {
                div.getBtnGaikyoChosa().setDisabled(false);
                setDisabledCommonBtnField(false);
            }
            if (getHandler(div).isExistsChosahyoTokkiImageFile(存在したイメージファイル名)) {
                div.getBtnChosahyoTokuki().setDisabled(false);
                setDisabledCommonBtnField(false);
            }
            if (getHandler(div).isExistsGaikyoTokkiImageFile(存在したイメージファイル名)) {
                div.getBtnGaikyoTokki().setDisabled(false);
                setDisabledCommonBtnField(false);
            }
            if (getHandler(div).isExistsOpinionFileTeikeiImageFile(存在したイメージファイル名)) {
                div.getBtnIkenshoTeikei().setDisabled(false);
                setDisabledCommonBtnField(false);
            }
            if (getHandler(div).isExistsOpinionFileTeikeigaiImageFile(存在したイメージファイル名)) {
                div.getBtnIkenshoTeikeigai().setDisabled(false);
                setDisabledCommonBtnField(false);
            }
            if (getHandler(div).isExistsOtherFileImageFile(存在したイメージファイル名)) {
                div.getRadSonota().setSelectedIndex(0);
                div.getBtnSonota().setDisabled(false);
                setDisabledCommonBtnField(false);
            }
        }
    }

    private void setDisabledCommonBtnField(boolean obj) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnImageOutput"), obj);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnImageDelete"), obj);
    }

    private YokaigoninteiimagekanriHandler getHandler(YokaigoninteiimagekanriDiv div) {
        return new YokaigoninteiimagekanriHandler(div);
    }
}
