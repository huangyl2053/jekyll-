/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe250002;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ イメージ取込み Processパラメタです。
 *
 * @author n8429
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrImageReadProcessParameter implements IBatchProcessParameter {

    private RDate 処理日;
    private RString ファイルPath;
    private List<RString> ファイルList;
    private List<RString> ファイルPathList;

    /**
     *
     * @param 処理日
     * @param ファイルPath ファイルPath
     * @param ファイルPathList
     */
    public OcrImageReadProcessParameter(
            RDate 処理日,
            RString ファイルPath,
            List<RString> ファイルPathList
    ) {
        this.処理日 = 処理日;
        this.ファイルPath = ファイルPath;
        this.ファイルPathList = ファイルPathList;
    }
}
