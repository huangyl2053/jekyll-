/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ocr;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenChosainFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenTokkiRembanChofuku;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ocr.OcrCsvMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ ファイルの読み取り Processパラメタです。
 *
 * @author n8429
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrDataReadProcessParameter implements IBatchProcessParameter {

    private final RDate 処理日;
    private final RString catalogFilePath;
    private final OcrFiles imageFilePaths;
    private final RString tempTableName;
    private final TreatmentWhenChosainFuicchi 調査員不一致時処理方法;
    private final TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法;
    private final TreatmentWhenTokkiRembanChofuku 特記連番重複時処理方法;

    /**
     * @param 処理日 処理日
     * @param catalogFilePath catalogFilePath
     * @param imageFilePaths 全イメージファイルのPath
     * @param tempTableName 一時テーブル名
     * @param 調査員不一致時処理方法
     * @param 一次判定済み時処理方法
     * @param 特記連番重複時処理方法
     */
    public OcrDataReadProcessParameter(
            RDate 処理日,
            RString catalogFilePath,
            OcrFiles imageFilePaths,
            RString tempTableName,
            TreatmentWhenChosainFuicchi 調査員不一致時処理方法,
            TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法,
            TreatmentWhenTokkiRembanChofuku 特記連番重複時処理方法
    ) {
        this.処理日 = 処理日;
        this.catalogFilePath = catalogFilePath;
        this.imageFilePaths = imageFilePaths;
        this.tempTableName = tempTableName;
        this.調査員不一致時処理方法 = 調査員不一致時処理方法;
        this.一次判定済み時処理方法 = 一次判定済み時処理方法;
        this.特記連番重複時処理方法 = 特記連番重複時処理方法;
    }

    /**
     * @return {@link OcrCsvMapperParameter}
     */
    public OcrCsvMapperParameter toOcrCsvMapperParameter() {
        return OcrCsvMapperParameter.selectForm(this.tempTableName);
    }
}
