/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ocr;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenShujiiFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ocr.OcrCsvMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ ファイルの読み取り Processパラメタです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageInputProcessParameter implements IBatchProcessParameter {

    private final RDate 処理日;
    private final RString catalogFilePath;
    private final OcrFiles imageFilePaths;
    private final RString tempTableName;
    private final TreatmentWhenShujiiFuicchi 主治医不一致時処理方法;
    private final TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法;

    /**
     * @param 処理日 処理日
     * @param catalogFilePath catalogFilePath
     * @param imageFilePaths 全イメージファイルのPath
     * @param tempTableName 一時テーブル名
     * @param 主治医不一致時処理方法 依頼と取込結果の主治医が異なる場合の処理方法
     * @param 一次判定済み時処理方法 一次判定済データを取り込んだ際の処理方法
     */
    public ImageInputProcessParameter(
            RDate 処理日,
            RString catalogFilePath,
            OcrFiles imageFilePaths,
            RString tempTableName,
            TreatmentWhenShujiiFuicchi 主治医不一致時処理方法,
            TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法
    ) {
        this.処理日 = 処理日;
        this.catalogFilePath = catalogFilePath;
        this.imageFilePaths = imageFilePaths;
        this.tempTableName = tempTableName;
        this.主治医不一致時処理方法 = 主治医不一致時処理方法;
        this.一次判定済み時処理方法 = 一次判定済み時処理方法;
    }

    /**
     * @return {@link OcrCsvMapperParameter}
     */
    public OcrCsvMapperParameter toOcrCsvMapperParameter() {
        return OcrCsvMapperParameter.selectForm(this.tempTableName);
    }
}
