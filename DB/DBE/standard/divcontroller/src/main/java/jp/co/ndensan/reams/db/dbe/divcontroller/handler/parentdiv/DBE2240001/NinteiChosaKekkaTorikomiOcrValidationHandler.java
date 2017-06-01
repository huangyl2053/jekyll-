/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiChosaOCRTorikomiDiv;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調査結果取込(OCR)に関連するバリデーションを行います。
 *
 */
public class NinteiChosaKekkaTorikomiOcrValidationHandler {

    private final NinteiChosaOCRTorikomiDiv div;

    /**
     * @param div {@link NinteiChosaOCRTorikomiDiv}
     */
    public NinteiChosaKekkaTorikomiOcrValidationHandler(NinteiChosaOCRTorikomiDiv div) {
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
        OcrFiles chosa = filesByType.get(OcrDataType.調査票);
        boolean existsChosaCSV = !chosa.findCsvFilePath().isEmpty();
        boolean existsChosaCA3 = !chosa.findCa3FilePath().isEmpty();
        if (!existsChosaCSV) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToUploadCsv, div.getNinteiChosaOCRTorikomiFile()));
        }
        if (!existsChosaCA3) {
            v.add(new ValidationMessageControlPair(ValidationMessages.NeedToUploadCa3, div.getNinteiChosaOCRTorikomiFile()));
        }
        return v;
    }
    
    /**
     * zip処理が2回目のときにエラーメッセージを返します。
     * 
     * @return ValidationMessageControlPairs
     * @param count
     */
    public ValidationMessageControlPairs validationZip(int count) {
        ValidationMessageControlPairs v = new ValidationMessageControlPairs();
        if (count > 1) {
            v.add(new ValidationMessageControlPair(ValidationMessages.zipファイル複数, div.getNinteiChosaOCRTorikomiFile()));
        }
        return v;
    }

    private enum ValidationMessages implements IValidationMessage {

        NeedToUploadCsv(DbeErrorMessages.要アップロード, OcrDataType.調査票.csvFileName().toString()),
        NeedToUploadCa3(DbeErrorMessages.要アップロード, OcrDataType.調査票.ca3FileName().toString()),
        zipファイル複数(DbeErrorMessages.zipファイル複数);

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
