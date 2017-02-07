/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class NinteiChosaFileOutputMybitisParameter implements IMyBatisParameter {

    private final RString shichosonCode;
    private final RString addedFileName;
    private final RString tempFilePath;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode
     * @param addedFileName
     * @param tempFilePath
     */
    public NinteiChosaFileOutputMybitisParameter(
            RString shichosonCode,
            RString addedFileName,
            RString tempFilePath) {
        this.shichosonCode = shichosonCode;
        this.addedFileName = addedFileName;
        this.tempFilePath = tempFilePath;
    }

    /**
     * パラメータを取得します。
     *
     * @param addedFileName
     * @param tempFilePath
     * @return バッチパラメータ
     */
    public static NinteiChosaFileOutputMybitisParameter createSelectByKeyParam(RString shichosonCode, RString addedFileName, RString tempFilePath) {
        return new NinteiChosaFileOutputMybitisParameter(shichosonCode, addedFileName, tempFilePath);
    }
}
