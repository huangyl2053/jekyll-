/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.DeletableImages;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.ImageType;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTargets;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003.DeletePanelDiv;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定イメージ情報削除のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public class DeletePanelValidationHandler {

    private final DeletePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定イメージ情報削除Div
     */
    public DeletePanelValidationHandler(DeletePanelDiv div) {
        this.div = div;
    }

    /**
     * 「削除」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateInput() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<RString> list = new ArrayList<>();
        list.addAll(div.getChkChosahyo().getSelectedKeys());
        list.addAll(div.getChkGaikyoTokki().getSelectedKeys());
        list.addAll(div.getChkIkensho().getSelectedKeys());
        list.addAll(div.getChkSonota().getSelectedKeys());
        if (list.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.削除ファイル未指定));
        }
        return validationMessages;
    }

    /**
     * 削除可能かどうかを検査します。
     *
     * @param targets 指定された削除対象
     * @param イメージ管理情報 イメージ管理情報
     * @return バリデーションの結果
     */
    public ValidationMessageControlPairs validateDeletable(OperationTargets targets, ImagekanriJoho イメージ管理情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        DeletableImages deletableImage = イメージ管理情報.get審査会割当履歴().findDeletableImages();
        if (targets.contains(ImageType.調査票)) {
            ValidationMessageControlPairs controlPairs = 調査票特記チェック(deletableImage, イメージ管理情報);
            if (controlPairs.iterator().hasNext()) {
                return controlPairs;
            }
        }
        if (targets.contains(ImageType.概況特記)) {
            ValidationMessageControlPairs controlPairs = 調査票概況チェック(deletableImage, イメージ管理情報);
            if (controlPairs.iterator().hasNext()) {
                return controlPairs;
            }
        }
        if (targets.contains(ImageType.意見書)) {
            ValidationMessageControlPairs controlPairs = 主治医意見書チェック(deletableImage, イメージ管理情報);
            if (controlPairs.iterator().hasNext()) {
                return controlPairs;
            }
        }
        return validationMessages;
    }

    private ValidationMessageControlPairs 調査票特記チェック(DeletableImages di, ImagekanriJoho imageKanriJoho) {
        if (!di.canDelete調査票()) {
            return message再意見書時_調査票削除不可();
        }
        FlexibleDate 認定調査委託料支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getChosaItakuryoShiharaiYMD(
                imageKanriJoho.get認定調査委託先コード(), imageKanriJoho.get認定調査員コード(),
                imageKanriJoho.get申請書管理番号(), imageKanriJoho.get認定調査依頼履歴番号());
        if (認定調査委託料支払年月日 != null && !認定調査委託料支払年月日.isEmpty()) {
            return message報酬支払済時_調査票削除不可();
        }
        return new ValidationMessageControlPairs();
    }

    private ValidationMessageControlPairs message再意見書時_調査票削除不可() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.再意見書時_調査票削除不可, div.getChkChosahyo()));
        return validationMessages;
    }

    private ValidationMessageControlPairs message報酬支払済時_調査票削除不可() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.調査票削除不可));
        return validationMessages;
    }

    private ValidationMessageControlPairs 調査票概況チェック(DeletableImages di, ImagekanriJoho imageKanriJoho) {
        if (!di.canDelete調査票()) {
            return message再意見書時_調査票削除不可();
        }
        FlexibleDate 認定調査委託料支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getChosaItakuryoShiharaiYMD(
                imageKanriJoho.get認定調査委託先コード(), imageKanriJoho.get認定調査員コード(),
                imageKanriJoho.get申請書管理番号(), imageKanriJoho.get認定調査依頼履歴番号());
        if (認定調査委託料支払年月日 != null && !認定調査委託料支払年月日.isEmpty()) {
            return message報酬支払済時_調査票削除不可();
        }
        return new ValidationMessageControlPairs();
    }

    private ValidationMessageControlPairs 主治医意見書チェック(DeletableImages di, ImagekanriJoho imageKanriJoho) {
        if (!di.canDelete意見書()) {
            return message再調査票時_意見書削除不可();
        }
        FlexibleDate 主治医意見書報酬支払年月日 = YokaigoninteiimagesakujoManager.createInstance().getHoshuShiharaiYMD(
                imageKanriJoho.get主治医医療機関コード(), imageKanriJoho.get主治医コード(),
                imageKanriJoho.get申請書管理番号(), imageKanriJoho.get主治医意見書作成依頼履歴番号());
        if (主治医意見書報酬支払年月日 != null && !主治医意見書報酬支払年月日.isEmpty()) {
            return message報酬支払済み時_意見書削除不可();
        }
        return new ValidationMessageControlPairs();
    }

    private ValidationMessageControlPairs message再調査票時_意見書削除不可() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.再調査票時_意見書削除不可, div.getChkIkensho()));
        return validationMessages;
    }

    private ValidationMessageControlPairs message報酬支払済み時_意見書削除不可() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.主治医意見書削除不可));
        return validationMessages;
    }

    /**
     * @return 意見書が削除できない場合のメッセージ
     */
    private static enum RRVMessages implements IValidationMessage {

        削除ファイル未指定(UrErrorMessages.未指定, "削除ファイルを"),
        調査票削除不可(UrErrorMessages.削除不可, "認定調査委託料が支払われた"),
        主治医意見書削除不可(UrErrorMessages.削除不可, "主治医意見書報酬が支払われた"),
        再意見書時_調査票削除不可(UrErrorMessages.削除不可, "認定調査票は、再調査の対象ではない"),
        再調査票時_意見書削除不可(UrErrorMessages.削除不可, "主治医意見書は、再調査の対象ではない");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
