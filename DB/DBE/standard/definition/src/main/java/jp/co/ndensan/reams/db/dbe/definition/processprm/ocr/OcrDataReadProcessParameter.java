/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ocr;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

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

    /**
     * @param 処理日 処理日
     * @param ファイルPath ファイルPath
     * @param imageFilePaths 全イメージファイルのPath
     */
    public OcrDataReadProcessParameter(
            RDate 処理日,
            OcrFiles ファイルPath,
            OcrFiles imageFilePaths
    ) {
        this.処理日 = 処理日;
        this.ファイルPath = ファイルPath;
        this.imageFilePaths = imageFilePaths;
    }
}
