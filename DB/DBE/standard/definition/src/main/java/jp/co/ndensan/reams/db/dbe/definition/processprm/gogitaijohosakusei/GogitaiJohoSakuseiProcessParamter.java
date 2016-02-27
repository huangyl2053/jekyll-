/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.gogitaijohosakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報一括作成_バッチ処理クラスパラメータクラスです
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiProcessParamter implements IBatchProcessParameter {

    private RDateTime sharedFileID;
    private RString sharedFileName;
    private RString inputFileName;

    /**
     * コンストラクタです。
     *
     * @param sharedFileID 共有ファイルID
     * @param sharedFileName 共有ファイル定義名
     * @param inputFileName ファイル名
     */
    public GogitaiJohoSakuseiProcessParamter(
            RDateTime sharedFileID, RString sharedFileName,
            RString inputFileName) {
        this.sharedFileID = sharedFileID;
        this.sharedFileName = sharedFileName;
        this.inputFileName = inputFileName;
    }

}
