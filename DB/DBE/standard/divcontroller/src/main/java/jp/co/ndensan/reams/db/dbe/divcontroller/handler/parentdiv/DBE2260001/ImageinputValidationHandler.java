/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.ImageinputDiv;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * イメージ取込（定型・定形外）に関連するバリデーションを行います。
 */
public class ImageinputValidationHandler {

    private final ImageinputDiv div;

    /**
     * @param div {@link ImageinputDiv}
     */
    public ImageinputValidationHandler(ImageinputDiv div) {
        this.div = div;
    }

    /**
     * アップロードされたファイルに対するバリデーションを行い結果を返します。
     *
     * @param sharedFileEntryDescriptorValue アップロードされたファイルをまとめて保持する共有ファイルを表す文字列
     * @return バリデーションの結果
     */
    public ValidationMessageControlPairs validateUploadedFiles(RString sharedFileEntryDescriptorValue) {
        Map<OcrDataType, OcrFiles> filesByType = OcrTorikomiUtil.copyToLocalAndGroupingByType(
                ReadOnlySharedFileEntryDescriptor.fromString(sharedFileEntryDescriptorValue.toString())
        );
        ValidationMessageControlPairs v = new ValidationMessageControlPairs();
        OcrFiles iken = filesByType.get(OcrDataType.意見書);
        boolean existsIkenCSV = !iken.findCsvFilePath().isEmpty();
        boolean existsIkenCA3 = !iken.findCa3FilePath().isEmpty();
        if (existsIkenCSV && !existsIkenCA3) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToUploadIkenCa3, div.getImageinputFile()));
        }
        if (!existsIkenCSV && existsIkenCA3) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToUploadIkenCsv, div.getImageinputFile()));
        }
        OcrFiles sonota = filesByType.get(OcrDataType.その他資料);
        boolean existsSonotaCSV = !sonota.findCsvFilePath().isEmpty();
        boolean existsSonotaCA3 = !sonota.findCa3FilePath().isEmpty();
        if (existsSonotaCSV && !existsSonotaCA3) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToUploadSonotaCa3, div.getImageinputFile()));
        }
        if (!existsSonotaCSV && existsSonotaCA3) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToUploadSonotaCsv, div.getImageinputFile()));
        }
        OcrFiles chosa = filesByType.get(OcrDataType.調査票);
        if (!chosa.isEmpty()) {
            RStringBuilder builder = new RStringBuilder();
            if (!chosa.findCsvFilePath().isEmpty()) {
                builder.append(OcrDataType.調査票.csvFileName());
            }
            if (!chosa.findCa3FilePath().isEmpty()) {
                appendIfNotEmpty(builder, "、");
                builder.append(OcrDataType.調査票.ca3FileName());
            }
            v.add(new ValidationMessageControlPair(
                    new ValidationMessage(DbeErrorMessages.イメージ取込_調査票をアップロード.getMessage().replace(builder.toString())),
                    div.getImageinputFile()));
            return v;
        }
        if (!existsIkenCSV && !existsIkenCA3 && !existsSonotaCSV && !existsSonotaCA3) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToReUpload, div.getImageinputFile()));
        }
        return v;
    }

    private static void appendIfNotEmpty(RStringBuilder builder, String appending) {
        if (builder.length() != 0) {
            builder.append(appending);
        }
    }

    @lombok.AllArgsConstructor
    private static class ValidationMessage implements IValidationMessage {

        private final Message message;

        @Override
        public Message getMessage() {
            return this.message;
        }
    }

    private enum ValidationMessages implements IValidationMessage {

        NeedToUploadIkenCsv(DbeErrorMessages.要アップロード, OcrDataType.意見書.csvFileName().toString()),
        NeedToUploadIkenCa3(DbeErrorMessages.要アップロード, OcrDataType.意見書.ca3FileName().toString()),
        NeedToUploadSonotaCsv(DbeErrorMessages.要アップロード, OcrDataType.その他資料.csvFileName().toString()),
        NeedToUploadSonotaCa3(DbeErrorMessages.要アップロード, OcrDataType.その他資料.ca3FileName().toString()),
        NeedToReUpload(DbeErrorMessages.OCR取込用ファイルが未アップロード);

        private final Message m;

        private ValidationMessages(IMessageGettable e, String... replacer) {
            this.m = e.getMessage().replace(replacer);
        }

        @Override
        public Message getMessage() {
            return m;
        }
    }
}
