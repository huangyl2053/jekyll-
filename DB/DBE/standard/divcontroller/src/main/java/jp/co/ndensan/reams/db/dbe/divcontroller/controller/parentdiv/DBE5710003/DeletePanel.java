/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710003;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003.DeletePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003.DeletePanelHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003.DeletePanelValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定イメージ情報削除のクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public class DeletePanel {

    private static final RString KEY_調査票特記 = new RString("1");
    private static final RString KEY_調査票概況 = new RString("2");
    private static final RString KEY_主治医意見書 = new RString("3");
    private static final RString KEY_その他資料 = new RString("4");
    private RString 確認メッセージ出力区分;
    private static final RString 確認メッセージ出力要 = new RString("1");
    private static final RString イメージファイルが存在区分_存在しない = new RString("1");
    private static final RString イメージファイルが存在区分_原本とマスキングが両方存在 = new RString("2");
    private ReadOnlySharedFileEntryDescriptor descriptor;

    /**
     * 要介護認定イメージ情報削除に初期化を設定します。
     *
     * @param div 要介護認定イメージ情報削除Div
     * @return ResponseData
     */
    public ResponseData<DeletePanelDiv> onLoad(DeletePanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンを押下する場合、イメージを削除します。
     *
     * @param div 要介護認定イメージ情報削除Div
     * @return ResponseData
     */
    public ResponseData<DeletePanelDiv> onClick_btnDelete(DeletePanelDiv div) {
        ImagekanriJoho イメージ管理情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        List<RString> 選択したイメージ対象 = div.getChkImage().getSelectedKeys();
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).入力チェック_btnDelete();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        確認メッセージ出力区分 = RString.EMPTY;
        descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(
                イメージ管理情報.get証記載保険者番号().concat(イメージ管理情報.get被保険者番号())),
                イメージ管理情報.getイメージ共有ファイルID());
        ValidationMessageControlPairs イメージ削除チェック = イメージ削除チェック(div, 選択したイメージ対象, descriptor);
        if (イメージ削除チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(イメージ削除チェック).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                    UrQuestionMessages.削除の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (!確認メッセージ出力要.equals(確認メッセージ出力区分)) {
                SharedFile.deleteFileInEntry(descriptor, イメージ管理情報.get証記載保険者番号().concat(イメージ管理情報.get被保険者番号()).toString());
                updateOrDelete(div);
                return ResponseData.of(div).addMessage(UrInformationMessages.処理完了.getMessage()).respond();
            }
        }
        if (確認メッセージ出力要.equals(確認メッセージ出力区分)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("原本を削除します").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            SharedFile.deleteFileInEntry(descriptor, イメージ管理情報.get証記載保険者番号().concat(イメージ管理情報.get被保険者番号()).toString());
            updateOrDelete(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.処理完了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private DeletePanelHandler getHandler(DeletePanelDiv div) {
        return new DeletePanelHandler(div);
    }

    private DeletePanelValidationHandler getValidationHandler(DeletePanelDiv div) {
        return new DeletePanelValidationHandler(div);
    }

    private ValidationMessageControlPairs イメージ削除チェック(DeletePanelDiv div, List<RString> 選択したイメージ対象,
            ReadOnlySharedFileEntryDescriptor descriptor) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ImagekanriJoho イメージ管理情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        RString 認定調査委託先コード = イメージ管理情報.get認定調査委託先コード().value();
        RString 認定調査員コード = イメージ管理情報.get認定調査員コード();
        RString 申請書管理番号 = イメージ管理情報.get申請書管理番号().value();
        int 認定調査依頼履歴番号 = イメージ管理情報.get認定調査依頼履歴番号();
        for (RString key : 選択したイメージ対象) {
            if (KEY_調査票特記.equals(key)) {
                ValidationMessageControlPairs controlPairs = 調査票特記チェック(div, descriptor,
                        認定調査委託先コード, 認定調査員コード, 申請書管理番号, 認定調査依頼履歴番号);
                if (controlPairs.iterator().hasNext()) {
                    return controlPairs;
                }
            } else if (KEY_調査票概況.equals(key)) {
                ValidationMessageControlPairs controlPairs = 調査票概況チェック(div, descriptor,
                        認定調査委託先コード, 認定調査員コード, 申請書管理番号, 認定調査依頼履歴番号);
                if (controlPairs.iterator().hasNext()) {
                    return controlPairs;
                }
            } else if (KEY_主治医意見書.equals(key)) {
                ValidationMessageControlPairs controlPairs = 主治医意見書チェック(div, descriptor,
                        イメージ管理情報.get主治医医療機関コード(), イメージ管理情報.get主治医コード(),
                        申請書管理番号, イメージ管理情報.get主治医意見書作成依頼履歴番号());
                if (controlPairs.iterator().hasNext()) {
                    return controlPairs;
                }
            } else if (KEY_その他資料.equals(key)) {
                RString イメージファイルが存在区分 = getHandler(div).getその他資料のイメージファイルが存在区分(
                        descriptor, 確認メッセージ出力区分);
                if (イメージファイルが存在区分_存在しない.equals(イメージファイルが存在区分)) {
                    確認メッセージ出力区分 = RString.EMPTY;
                    return getValidationHandler(div).その他資料イメージファイル存在チェック();
                }
                if (イメージファイルが存在区分_原本とマスキングが両方存在.equals(イメージファイルが存在区分)) {
                    確認メッセージ出力区分 = 確認メッセージ出力要;
                }
            }
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 調査票特記チェック(DeletePanelDiv div, ReadOnlySharedFileEntryDescriptor descriptor,
            RString 認定調査委託先コード, RString 認定調査員コード, RString 申請書管理番号,
            Integer 認定調査依頼履歴番号) {
        RString イメージファイルが存在区分 = getHandler(div).get調査票特記のイメージファイルが存在区分(descriptor, 確認メッセージ出力区分);
        if (イメージファイルが存在区分_存在しない.equals(イメージファイルが存在区分)) {
            確認メッセージ出力区分 = RString.EMPTY;
            return getValidationHandler(div).調査票特記イメージファイル存在チェック();
        } else {
            if (イメージファイルが存在区分_原本とマスキングが両方存在.equals(イメージファイルが存在区分)) {
                確認メッセージ出力区分 = 確認メッセージ出力要;
            }
            FlexibleDate 認定調査委託料支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getChosaItakuryoShiharaiYMD(
                    認定調査委託先コード, 認定調査員コード, new ShinseishoKanriNo(申請書管理番号), 認定調査依頼履歴番号);
            if (認定調査委託料支払年月日 != null && !認定調査委託料支払年月日.isEmpty()) {
                return getValidationHandler(div).認定調査委託料支払年月日チェック();
            }
        }
        return new ValidationMessageControlPairs();
    }

    private ValidationMessageControlPairs 調査票概況チェック(DeletePanelDiv div, ReadOnlySharedFileEntryDescriptor descriptor,
            RString 認定調査委託先コード, RString 認定調査員コード, RString 申請書管理番号, Integer 認定調査依頼履歴番号) {

        if (getHandler(div).is調査票概況のイメージファイルが存在しない(descriptor)) {
            return getValidationHandler(div).調査票概況イメージファイル存在チェック();
        } else {
            FlexibleDate 認定調査委託料支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getChosaItakuryoShiharaiYMD(
                    認定調査委託先コード, 認定調査員コード, new ShinseishoKanriNo(申請書管理番号), 認定調査依頼履歴番号);
            if (認定調査委託料支払年月日 != null && !認定調査委託料支払年月日.isEmpty()) {
                return getValidationHandler(div).認定調査委託料支払年月日チェック();
            }
        }
        return new ValidationMessageControlPairs();
    }

    private ValidationMessageControlPairs 主治医意見書チェック(DeletePanelDiv div, ReadOnlySharedFileEntryDescriptor descriptor,
            RString 主治医医療機関コード, RString 主治医コード, RString 申請書管理番号, Integer 主治医意見書作成依頼履歴番号) {
        RString イメージファイルが存在区分 = getHandler(div).get主治医意見書のイメージファイルが存在区分(descriptor, 確認メッセージ出力区分);
        if (イメージファイルが存在区分_存在しない.equals(イメージファイルが存在区分)) {
            確認メッセージ出力区分 = RString.EMPTY;
            return getValidationHandler(div).主治医意見書イメージファイル存在チェック();
        } else {
            if (イメージファイルが存在区分_原本とマスキングが両方存在.equals(イメージファイルが存在区分)) {
                確認メッセージ出力区分 = 確認メッセージ出力要;
            }
            FlexibleDate 主治医意見書報酬支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getHoshuShiharaiYMD(
                    主治医医療機関コード, 主治医コード, new ShinseishoKanriNo(申請書管理番号), 主治医意見書作成依頼履歴番号);
            if (主治医意見書報酬支払年月日 != null && !主治医意見書報酬支払年月日.isEmpty()) {
                return getValidationHandler(div).主治医意見書報酬支払年月日チェック();
            }
        }
        return new ValidationMessageControlPairs();
    }

    private void updateOrDelete(DeletePanelDiv div) {
        ImagekanriJoho イメージ管理情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        YokaigoninteiimagesakujoManager.createInstance().updateOrDelete(イメージ管理情報,
                div.getChkImage().getSelectedKeys(), div.getRadDeleteTaisho().getSelectedKey());
    }

}
