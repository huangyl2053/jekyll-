/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001;

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
public class DBE250001_NinteiChosaKekkaTorikomiParameter extends BatchParameterBase {

    private static final String KYOYU_FILE_ENTRY = "KyoyuFileEntry";

    @BatchParameter(key = KYOYU_FILE_ENTRY, name = "共有ファイルエントリ情報文字列")
    private RString 共有ファイルエントリ情報文字列;

    public DBE250001_NinteiChosaKekkaTorikomiParameter() {

    }

    /**
     * 認定調査結果取込み（OCR）バッチパラメータクラスのコンストラクタです。
     *
     * @param 共有ファイルエントリ情報文字列 アップロードされた共有ファイルのエントリ情報
     */
    public DBE250001_NinteiChosaKekkaTorikomiParameter(RString 共有ファイルエントリ情報文字列) {
        this.共有ファイルエントリ情報文字列 = 共有ファイルエントリ情報文字列;
    }

}
