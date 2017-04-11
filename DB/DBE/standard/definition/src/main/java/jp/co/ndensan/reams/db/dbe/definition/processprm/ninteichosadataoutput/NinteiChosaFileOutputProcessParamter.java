/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaFileOutputMybitisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaFileOutputProcessParamter implements IBatchProcessParameter {

    private final List<RString> shinseishoKanriNoList;
    private final RString shichosonCode;
    private final RString addedFileName;
    private final RString tempFilePath;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList
     * @param shichosonCode
     * @param addedFileName
     * @param tempFilePath
     */
    public NinteiChosaFileOutputProcessParamter(
            List<RString> shinseishoKanriNoList,
            RString shichosonCode,
            RString addedFileName,
            RString tempFilePath) {
        this.shinseishoKanriNoList = shinseishoKanriNoList;
        this.shichosonCode = shichosonCode;
        this.addedFileName = addedFileName;
        this.tempFilePath = tempFilePath;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaDataOutputBatchMybitisParameter
     */
    public NinteiChosaFileOutputMybitisParameter toNinteiChosaFileOutputMybitisParameter() {
        return NinteiChosaFileOutputMybitisParameter.createSelectByKeyParam(shinseishoKanriNoList);
    }
}
