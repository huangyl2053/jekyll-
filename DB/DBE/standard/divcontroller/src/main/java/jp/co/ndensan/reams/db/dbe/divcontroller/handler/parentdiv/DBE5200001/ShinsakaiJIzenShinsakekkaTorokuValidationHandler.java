/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5200001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaiJIzenShinsakekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001.ShinsakaikekkaIchiranInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenShinsakekkaIchiranFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会委員事前審査結果登録の画面処理ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public class ShinsakaiJIzenShinsakekkaTorokuValidationHandler {

    private static final RString 出力名 = new RString("JizenShinsaKekka");
    private static final RString 下線 = new RString("_");
    private static final RString CSV_TAIPU = new RString(".csv");
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
     * @param uploadedFiles アップロードされたファイル
     * @param 開催番号 開催番号
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateUploadedFiles(FileData[] uploadedFiles, RString 開催番号) {
        ValidationMessageControlPairs vp = new ValidationMessageControlPairs();
        final List<RString> 審査員s = ShinsakaiJIzenShinsakekkaIchiranFinder.createInstance().get審査員(開催番号).records();
        final List<RString> uploadedFileNames = toFileNames(uploadedFiles);
        final RStringBuilder name = new RStringBuilder();
        for (RString fileName : asRequiredFileNames(開催番号, 審査員s)) {
            if (!uploadedFileNames.contains(fileName)) {
                name.append(fileName).append(RString.HALF_SPACE);
            }
        }
        if (name.length() != 0) {
            vp.add(new ValidationMessageControlPair(
                    new ShinsakaiJIzenShinsakekkaTorokuValidationHandler.ValidationCheckMessages(
                            UrErrorMessages.対象ファイルが存在しない, name.toString())));
        }
        return vp;
    }

    private static List<RString> asRequiredFileNames(RString 審査会番号, List<RString> 審査会委員コードリスト) {
        List<RString> fileNameList = new ArrayList();
        for (RString 審査会委員コード : 審査会委員コードリスト) {
            fileNameList.add(new RStringBuilder(出力名).append(下線).append(審査会番号).append(下線)
                    .append(審査会委員コード).append(CSV_TAIPU).toRString());
        }
        return fileNameList;
    }

    private static List<RString> toFileNames(FileData[] files) {
        List<RString> list = new ArrayList<>();
        for (FileData f : files) {
            list.add(f.getFileName());
        }
        return list;
    }

    /**
     * ヌルチェック
     *
     * @param parsed アップロードされたCSVファイルを解析した結果
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs ヌルチェック_btnGetResult(Map<String, List<ShinsakaikekkaIchiranInputCsvEntity>> parsed) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RStringBuilder names = new RStringBuilder();
        for (Map.Entry<String, List<ShinsakaikekkaIchiranInputCsvEntity>> entry : parsed.entrySet()) {
            if (entry.getValue().isEmpty()) {
                names.append(entry.getKey());
            }
        }
        if (names.length() == 0) {
            return validationMessages;
        }
        validationMessages.add(new ValidationMessageControlPair(
                new ShinsakaiJIzenShinsakekkaTorokuValidationHandler.ValidationCheckMessages(
                        UrErrorMessages.対象データなし_追加メッセージあり, names.toString())));
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
