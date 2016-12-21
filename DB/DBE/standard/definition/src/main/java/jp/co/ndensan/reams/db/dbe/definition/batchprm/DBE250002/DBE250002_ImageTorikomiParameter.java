/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2818
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE250002_ImageTorikomiParameter extends BatchParameterBase {

    private static final String KYOYU_FILE_ENTRY = "KyoyuFileEntry";

    @BatchParameter(key = KYOYU_FILE_ENTRY, name = "共有ファイルエントリ情報文字列")
    private RString 共有ファイルエントリ情報文字列;

    /**
     * イメージ取込（規定・規定外）バッチパラメータクラスのコンストラクタです。
     *
     * @param 共有ファイルエントリ情報文字列 アップロードされた共有ファイルのエントリ情報
     */
    public DBE250002_ImageTorikomiParameter(RString 共有ファイルエントリ情報文字列) {
        this.共有ファイルエントリ情報文字列 = 共有ファイルエントリ情報文字列;
    }
}
