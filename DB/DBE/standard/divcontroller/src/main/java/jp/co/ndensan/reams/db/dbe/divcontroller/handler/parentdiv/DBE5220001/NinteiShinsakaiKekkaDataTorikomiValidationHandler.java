/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsakaiDataName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.dgTorikomiTaiasho_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE5220001_介護認定審査会審査結果データ取込み（モバイル）バリデーションクラスです
 *
 * @reamsid_L DBE-1841-010 xuyongchao
 */
public class NinteiShinsakaiKekkaDataTorikomiValidationHandler {

    private final NinteiShinsakaiKekkaDataTorikomiDiv div;
    private static final RString 分割 = new RString("＿");
    private static final int 回数 = 0;
    private static final int ファイル名 = 1;
    private static final RString KEY_0 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiShinsakaiKekkaDataTorikomiValidationHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        this.div = div;
    }

    /**
     * 対象未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象未選択チェック(ValidationMessageControlPairs validPairs) {
        if (div.getDgTorikomiTaiasho().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(NinteiShinsakaiKekkaDataTorikomiMessages.対象未選択チェック));
        }
        return validPairs;
    }

    /**
     * 一致性チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @param fileName fileName
     * @param filePath filePath
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一致性チェック(ValidationMessageControlPairs validPairs, RString fileName, RString filePath) {
        boolean flag = true;
        List<RString> splite = fileName.split(分割.toString());
        if (splite.size() < 2) {
            validPairs.add(new ValidationMessageControlPair(NinteiShinsakaiKekkaDataTorikomiMessages.一致性チェック, div.getUplPanel()));
            return validPairs;
        }
        for (ShinsakaiDataName shinsakaiData : ShinsakaiDataName.values()) {
            for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getDataSource()) {
                if (row.getCsvName().equals(splite.get(ファイル名)) && shinsakaiData.getファイル名称().equals(splite.get(ファイル名))) {
                    CsvListReader read = new CsvListReader.InstanceBuilder(filePath).build();
                    Decimal 件数 = new Decimal(getSize(read));
                    row.getDataNum().setValue(件数);
                    set隠し項目(shinsakaiData, splite, 件数);
                    flag = false;
                }
            }
        }
        if (flag) {
            validPairs.add(new ValidationMessageControlPair(NinteiShinsakaiKekkaDataTorikomiMessages.一致性チェック, div.getUplPanel()));
        }
        return validPairs;
    }

    /**
     * 取込みファイルの開催回数が一致しているかをチェックします。
     *
     * @param validPairs
     * @return
     */
    public ValidationMessageControlPairs 回数チェック(ValidationMessageControlPairs validPairs) {
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(KEY_0)) {
            check開催回数一致(validPairs);
        }
        return validPairs;
    }

    private void check開催回数一致(ValidationMessageControlPairs validPairs) {
        if (div.getRadShinsain().getSelectedKey().equals(KEY_0)) {
            if (!div.getHdnTxtKaisaiKaisuIin().equals(div.getHdnTxtKaisaiKaisuJoho())
                || !div.getHdnTxtKaisaiKaisuIin().equals(div.getHdnTxtKaisaiKaisuKekka())
                || !div.getHdnTxtKaisaiKaisuJoho().equals(div.getHdnTxtKaisaiKaisuKekka())) {
                validPairs.add(new ValidationMessageControlPair(
                    new ValidationMessage(UrErrorMessages.項目に対する制約, "開催回", "一つ"), div.getDgTorikomiTaiasho()));
            }
        } else {
            if (!div.getHdnTxtKaisaiKaisuJoho().equals(div.getHdnTxtKaisaiKaisuKekka())) {
                validPairs.add(new ValidationMessageControlPair(
                    new ValidationMessage(UrErrorMessages.項目に対する制約, "開催回", "一つ"), div.getDgTorikomiTaiasho()));
            }
        }
    }

    private void set隠し項目(ShinsakaiDataName shinsakaiData, List<RString> splite, Decimal 件数) {
        if (shinsakaiData == ShinsakaiDataName.審査会情報) {
            div.setHdnTxtKaisaiKaisuJoho(splite.get(回数));
            div.setHdnTxtKensuShinsakaiJoho(new RString(件数.toString()));
        } else if (shinsakaiData == ShinsakaiDataName.審査委員) {
            div.setHdnTxtKaisaiKaisuIin(splite.get(回数));
            div.setHdnTxtKensuShinsaIin(new RString(件数.toString()));
        } else if (shinsakaiData == ShinsakaiDataName.審査結果) {
            div.setHdnTxtKaisaiKaisuKekka(splite.get(回数));
            div.setHdnTxtKensuShinsaKekka(new RString(件数.toString()));
        } else {
            div.setHdnTxtKaisaiKaisuNintei(splite.get(回数));
            div.setHdnTxtKensuNintei(new RString(件数.toString()));
        }
    }

    private int getSize(CsvListReader read) {
        int size = 0;
        while (read.readLine() != null) {
            size++;
        }
        read.close();
        return size;
    }

    /**
     * データ件数チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ件数チェック(ValidationMessageControlPairs validPairs) {
        for (dgTorikomiTaiasho_Row row : div.getDgTorikomiTaiasho().getDataSource()) {
            if (null == row.getDataNum().getValue() || 0 == row.getDataNum().getValue().compareTo(Decimal.ZERO)) {
                validPairs.add(new ValidationMessageControlPair(new ValidationMessage(
                    UrErrorMessages.対象データなし_追加メッセージあり, row.getFileName().toString()), div.getDgTorikomiTaiasho()));
            }
        }
        return validPairs;
    }

    private static enum NinteiShinsakaiKekkaDataTorikomiMessages implements IValidationMessage {

        対象未選択チェック(UrErrorMessages.選択されていない, "取込みファイル内容一覧対象"),
        一致性チェック(UrErrorMessages.不正, "アップロードファイルの名称");
        private final Message message;

        private NinteiShinsakaiKekkaDataTorikomiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static final class ValidationMessage implements IValidationMessage {

        private final Message message;

        private ValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
