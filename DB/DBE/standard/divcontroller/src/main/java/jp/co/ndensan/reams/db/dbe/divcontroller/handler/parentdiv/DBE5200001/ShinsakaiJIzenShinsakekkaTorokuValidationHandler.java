/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会委員事前審査結果登録の画面処理ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenShinsakekkaTorokuValidationHandler {

    private final ShinsakaiJIzenShinsakekkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面Divデタ
     */
    public ShinsakaiJIzenShinsakekkaTorokuValidationHandler(ShinsakaiJIzenShinsakekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @param path path
     * @param fileNames fileNames
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnGetResult(RStringBuilder path, List<RString> fileNames) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RStringBuilder name = new RStringBuilder();
        for (RString fileName : fileNames) {
            if (div.getJizenShinsakaiShiryoPublication().getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo() != null
                    && !new File(Path.combinePath(path.toRString(), fileName).toString()).exists()) {
                name.append(fileName);
            }
        }
        if (getIsExistsFile(path, fileNames).isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiJIzenShinsakekkaTorokuValidationHandler.ValidationCheckMessages(
                            UrErrorMessages.対象ファイルが存在しない, name.toString())));
        }
        return validationMessages;
    }

    /**
     * 存在のファイル取得する。
     *
     * @param path path
     * @param fileNames fileNames
     * @return 存在のファイル名リスト
     */
    public List<RString> getIsExistsFile(RStringBuilder path, List<RString> fileNames) {
        List<RString> nameExists = new ArrayList<>();
        for (RString fileName : fileNames) {
            if (new File(Path.combinePath(path.toRString(), fileName).toString()).exists()) {
                nameExists.add(fileName);
            }
        }
        return nameExists;
    }

    /**
     * ヌルチェック
     *
     * @param name 対象ファイルname
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs ヌルチェック_btnGetResult(RString name) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                new ShinsakaiJIzenShinsakekkaTorokuValidationHandler.ValidationCheckMessages(
                        UrErrorMessages.対象データなし_追加メッセージあり, name.toString())));
        return validationMessages;
    }

    private static final class ValidationCheckMessages implements IValidationMessage {

        private final Message message;

        private ValidationCheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
