/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ocr;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ocr.OcrCsvMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ ファイルの読み取り Processパラメタです。
 *
 * @author n8429
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrDataReadProcessParameter implements IBatchProcessParameter {

    @lombok.Getter
    private final RDate 処理日;
    @lombok.Getter
    private final OcrFiles ファイルPath;
    @lombok.Getter
    private final OcrFiles imageFilePaths;
    @lombok.Getter
    private final RString tempTableName;

    /**
     * @param 処理日 処理日
     * @param ファイルPath ファイルPath
     * @param imageFilePaths 全イメージファイルのPath
     * @param tempTableName 一時テーブル名
     */
    public OcrDataReadProcessParameter(
            RDate 処理日,
            OcrFiles ファイルPath,
            OcrFiles imageFilePaths,
            RString tempTableName
    ) {
        this.処理日 = 処理日;
        this.ファイルPath = ファイルPath;
        this.imageFilePaths = imageFilePaths;
        this.tempTableName = tempTableName;
    }

    /**
     * @return {@link OcrCsvMapperParameter}
     */
    public OcrCsvMapperParameter toOcrCsvMapperParameter() {
        return OcrCsvMapperParameter.selectForm(this.tempTableName);
    }
}
