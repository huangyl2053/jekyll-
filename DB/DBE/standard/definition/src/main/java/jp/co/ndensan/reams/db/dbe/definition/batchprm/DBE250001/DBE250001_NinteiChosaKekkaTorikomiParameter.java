/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenChosainFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenTokkiRembanChofuku;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ パラメータ クラスです。
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE250001_NinteiChosaKekkaTorikomiParameter extends BatchParameterBase {

    private static final String KYOYU_FILE_ENTRY = "KyoyuFileEntry";

    @BatchParameter(key = KYOYU_FILE_ENTRY, name = "共有ファイルエントリ情報文字列")
    private RString 共有ファイルエントリ情報文字列;

    private TreatmentWhenChosainFuicchi 調査員不一致時処理方法;
    private TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法;
    private TreatmentWhenTokkiRembanChofuku 特記連番重複時処理方法;

    public DBE250001_NinteiChosaKekkaTorikomiParameter() {
    }

    /**
     * 認定調査結果取込み（OCR）バッチパラメータクラスのコンストラクタです。
     *
     * @param 共有ファイルエントリ情報文字列 アップロードされた共有ファイルのエントリ情報
     */
    public DBE250001_NinteiChosaKekkaTorikomiParameter(RString 共有ファイルエントリ情報文字列) {
        this.共有ファイルエントリ情報文字列 = 共有ファイルエントリ情報文字列;
        this.調査員不一致時処理方法 = TreatmentWhenChosainFuicchi.処理を継続する;
        this.一次判定済み時処理方法 = TreatmentWhenIchijiHanteiZumi.エラーとする;
        this.特記連番重複時処理方法 = TreatmentWhenTokkiRembanChofuku.上書きしない;
    }

    /**
     * @param 処理日 処理日
     * @param catalogFilePath catalogFilePath
     * @param imageFilePaths 全イメージファイルのPath
     * @param tempTableName 一時テーブル名
     * @return {@link OcrDataReadProcessParameter}
     */
    public OcrDataReadProcessParameter toOcrDataReadProcessParameter(RDate 処理日,
            RString catalogFilePath,
            OcrFiles imageFilePaths,
            RString tempTableName) {
        return new OcrDataReadProcessParameter(
                処理日, catalogFilePath, imageFilePaths, tempTableName,
                調査員不一致時処理方法, 一次判定済み時処理方法, 特記連番重複時処理方法);
    }
}
