package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay.ImageDisplayValidationHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001.DBE5710001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001.YokaigoninteiimagekanriDiv;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagekanri.YokaigoninteiimagekanriFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定イメージ情報管理のコントローラです。
 *
 * @reamsid_L DBE-1670-010 wangxiaodong
 */
public class Yokaigoninteiimagekanri {

    private static final RString その他資料原本 = new RString("_BAK");
    private static final RString その他資料1 = new RString("A0");
    private static final RString その他資料2 = new RString("B0");
    private static final RString その他資料3 = new RString("C0");
    private static final RString その他資料4 = new RString("D0");
    private static final RString その他資料5 = new RString("E0");
    private static final RString その他資料6 = new RString("F0");
    private static final RString その他資料 = new RString("F1401");
    private static final RString イメージ区分_調査票概況 = new RString("1");
    private static final RString イメージ区分_意見書定型 = new RString("2");
    private static final RString イメージ区分_その他資料 = new RString("3");
    private static final RString イメージ区分_意見書定型外 = new RString("4");
    private static final int その他資料MAX = 6;
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
        init_SetDisabled(div);
        init_SetValue(div, イメージ管理情報);
        if (イメージ管理情報.getイメージ共有ファイルID() != null) {
            RString toCopyPath = DBEImageUtil.copySharedFiles(
                    イメージ管理情報.getイメージ共有ファイルID(), div.getHdnShokisaiHokenshaNo().concat(div.getHdnHihokenshaNo()));
            div.setHdnImageLocalCopyPath(toCopyPath);
            if (hasその他資料イメージ(toCopyPath)) {
                div.getRadSonota().setSelectedIndex(0);
            }
        } else {
            div.getRadSonota().setSelectedIndex(1);
            div.getBtnGaikyoTokuki().setDisabled(true);
            div.getBtnIkenshoTeikeigai().setDisabled(true);
            div.getBtnIkenshoTeikei().setDisabled(true);
            div.getBtnSonota().setDisabled(true);
        }
        if (イメージ管理情報.getイメージ共有ファイルID() == null) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnImageOutput"), true);
            if ((イメージ管理情報.get認定審査会完了年月日() == null || イメージ管理情報.get認定審査会完了年月日().isEmpty())
                    && (イメージ管理情報.getセンター送信年月日() == null || イメージ管理情報.getセンター送信年月日().isEmpty())) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnImageDelete"), true);
            }
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
     * イメージ削除ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnImageDelete(YokaigoninteiimagekanriDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBE5710001TransitionEventName.要介護認定イメージ情報削除へ).respond();
    }

    /**
     * 概況特記ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnGaikyoTokki(YokaigoninteiimagekanriDiv div) {
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
     * 調査票概況ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnChosahyoGaikyo(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.イメージ区分, イメージ区分_調査票概況);
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ImagekanriJoho イメージ管理情報 = finder.getImageJoho(申請書管理番号);
        if (イメージ管理情報.getイメージ共有ファイルID() == null) {
            ValidationMessageControlPairs validPairs = getValidationHandler().イメージ存在チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ImageDisplayValidationHandler getValidationHandler() {
        return new ImageDisplayValidationHandler();
    }

    /**
     * 意見書定型外ボタンをクリックします。
     *
     * @param div 介護認定審査会委員情報
     * @return ResponseData
     */
    public ResponseData<YokaigoninteiimagekanriDiv> onClick_btnIkenshoTeikeigai(YokaigoninteiimagekanriDiv div) {
        ViewStateHolder.put(ViewStateKeys.イメージ区分, イメージ区分_意見書定型外);
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ImagekanriJoho イメージ管理情報 = finder.getImageJoho(申請書管理番号);
        if (イメージ管理情報.getイメージ共有ファイルID() == null) {
            ValidationMessageControlPairs validPairs = getValidationHandler().イメージ存在チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
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
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ImagekanriJoho イメージ管理情報 = finder.getImageJoho(申請書管理番号);
        if (イメージ管理情報.getイメージ共有ファイルID() == null) {
            ValidationMessageControlPairs validPairs = getValidationHandler().イメージ存在チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
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
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ImagekanriJoho イメージ管理情報 = finder.getImageJoho(申請書管理番号);
        if (イメージ管理情報.getイメージ共有ファイルID() == null) {
            ValidationMessageControlPairs validPairs = getValidationHandler().イメージ存在チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private void init_SetDisabled(YokaigoninteiimagekanriDiv div) {
        div.getTxtShinseiYMD().setDisabled(true);
        div.getTxtJuryoYMD().setDisabled(true);
        div.getTxtJishiYMD().setDisabled(true);
        div.getTxtReadYMD().setDisabled(true);
        div.getTxtKinyuYMD().setDisabled(true);
        div.getRadSonota().setDisabled(true);
    }

    private void init_SetValue(YokaigoninteiimagekanriDiv div, ImagekanriJoho イメージ管理情報) {
        if (イメージ管理情報.get認定申請日() != null) {
            div.getTxtShinseiYMD().setValue(new RDate(イメージ管理情報.get認定申請日().toString()));
        }
        if (イメージ管理情報.get認定調査受領年月日() != null) {
            div.getTxtJuryoYMD().setValue(new RDate(イメージ管理情報.get認定調査受領年月日().toString()));
        }
        if (イメージ管理情報.get認定調査実施年月日() != null) {
            div.getTxtJishiYMD().setValue(new RDate(イメージ管理情報.get認定調査実施年月日().toString()));
        }
        if (イメージ管理情報.get主治医意見書読取年月日() != null && !イメージ管理情報.get主治医意見書読取年月日().isEmpty()) {
            div.getTxtReadYMD().setValue(new RDate(イメージ管理情報.get主治医意見書読取年月日().toString()));
        }
        if (イメージ管理情報.get主治医意見書記入年月日() != null && !イメージ管理情報.get主治医意見書記入年月日().isEmpty()) {
            div.getTxtKinyuYMD().setValue(new RDate(イメージ管理情報.get主治医意見書記入年月日().toString()));
        }
    }

    private boolean hasその他資料イメージ(RString toCopyPath) {
        List<RString> その他資料ファイル名 = getその他資料ファイル名();
        for (RString その他資料ファイル : その他資料ファイル名) {
            if (Directory.exists(Path.combinePath(toCopyPath, その他資料ファイル))) {
                return true;
            }
        }
        return false;
    }

    private List<RString> getその他資料ファイル名() {
        List<RString> その他資料ファイル名 = new ArrayList<>();
        getその他資料ファイル名(その他資料ファイル名, その他資料1);
        getその他資料ファイル名(その他資料ファイル名, その他資料2);
        getその他資料ファイル名(その他資料ファイル名, その他資料3);
        getその他資料ファイル名(その他資料ファイル名, その他資料4);
        getその他資料ファイル名(その他資料ファイル名, その他資料5);
        getその他資料ファイル名(その他資料ファイル名, その他資料6);
        return その他資料ファイル名;
    }

    private void getその他資料ファイル名(List<RString> その他資料ファイル名, RString その他資料種別) {
        RStringBuilder builder = new RStringBuilder(その他資料);
        for (int i = 1; i <= その他資料MAX; i++) {
            builder.append(その他資料種別);
            builder.append(i);
            その他資料ファイル名.add(builder.toRString());
            builder.append(その他資料原本);
            その他資料ファイル名.add(builder.toRString());
            builder = new RStringBuilder(その他資料);
        }
    }
}
