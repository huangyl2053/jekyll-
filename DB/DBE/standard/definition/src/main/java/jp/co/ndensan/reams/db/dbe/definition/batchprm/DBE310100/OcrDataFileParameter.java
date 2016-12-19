/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE310100;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ パラメータ クラスです。
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrDataFileParameter extends BatchParameterBase {

    private static final String KYOYU_FILE_ENTRY = "KyoyuFileEntry";

    @BatchParameter(key = KYOYU_FILE_ENTRY, name = "共有ファイルエントリ情報文字列")
    private RString 共有ファイルエントリ情報文字列;
}
