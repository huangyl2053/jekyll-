/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE511001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.gogitaijohosakusei.GogitaiJohoSakuseiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 合議体情報一括作成のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-0090-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBE511001_GogitaiIkkatuParameter extends BatchParameterBase {

    private static final String SHARED_FILE_ID = "sharedFileID";
    private static final String SHARED_FILE_NAME = "sharedFileName";
    private static final String INPUT_FILE_NAME = "inputFileName";

    @BatchParameter(key = SHARED_FILE_ID, name = "共有ファイルID")
    private RDateTime sharedFileID;
    @BatchParameter(key = SHARED_FILE_NAME, name = "共有ファイル定義名")
    private RString sharedFileName;
    @BatchParameter(key = INPUT_FILE_NAME, name = "ファイル名")
    private RString inputFileName;

    /**
     * 合議体情報一括作成のバッチ処理パラメータークラス作成
     *
     * @return GogitaiJohoSakuseiProcessParamter
     */
    public GogitaiJohoSakuseiProcessParamter toGogitaiJohoSakuseiProcessParamter() {
        return new GogitaiJohoSakuseiProcessParamter(
                sharedFileID, sharedFileName, inputFileName);
    }
}
