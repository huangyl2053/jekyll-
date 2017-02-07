/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenShujiiFuicchi;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.ImageInputProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2818
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE250002_ImageTorikomiParameter extends BatchParameterBase {

    private static final String KYOYU_FILE_ENTRY = "KyoyuFileEntry";

    @BatchParameter(key = KYOYU_FILE_ENTRY, name = "共有ファイルエントリ情報文字列")
    private final RString 共有ファイルエントリ情報文字列;
    @BatchParameter(key = "2", name = "一次判定済みの申請者")
    private final TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法;
    @BatchParameter(key = "3", name = "依頼時と実施時での医師の不一致")
    private final TreatmentWhenShujiiFuicchi 主治医不一致時処理方法;

    /**
     * イメージ取込（規定・規定外）バッチパラメータクラスのコンストラクタです。
     *
     * @param 共有ファイルエントリ情報文字列 アップロードされた共有ファイルのエントリ情報
     * @param 一次判定済み時処理方法 一次判定済み時処理方法
     * @param 主治医不一致時処理方法 主治医不一致時処理方法
     *
     */
    public DBE250002_ImageTorikomiParameter(
            RString 共有ファイルエントリ情報文字列,
            TreatmentWhenIchijiHanteiZumi 一次判定済み時処理方法,
            TreatmentWhenShujiiFuicchi 主治医不一致時処理方法) {
        this.共有ファイルエントリ情報文字列 = 共有ファイルエントリ情報文字列;
        this.一次判定済み時処理方法 = 一次判定済み時処理方法;
        this.主治医不一致時処理方法 = 主治医不一致時処理方法;
    }

    /**
     * @param 処理日 処理日
     * @param catalogFilePath catalogFilePath
     * @param imageFilePaths 全イメージファイルのPath
     * @param tempTableName 一時テーブル名
     * @return {@link ImageInputProcessParameter}
     */
    public ImageInputProcessParameter toImageInputProcessParameter(RDate 処理日,
            RString catalogFilePath,
            OcrFiles imageFilePaths,
            RString tempTableName) {
        return new ImageInputProcessParameter(処理日, catalogFilePath, imageFilePaths, tempTableName,
                主治医不一致時処理方法, 一次判定済み時処理方法);
    }
}
