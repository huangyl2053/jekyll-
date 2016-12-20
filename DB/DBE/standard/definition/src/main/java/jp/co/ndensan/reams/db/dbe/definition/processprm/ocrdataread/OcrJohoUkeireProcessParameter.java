/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.processprm.ocrdataread;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * OCR情報受入＿バッチProcessパラメタです。
 *
 * @author n8429
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrJohoUkeireProcessParameter implements IBatchProcessParameter {

    /**
     * 共有ファイルIDリスト
     */
    private final List<RString> 共有ファイルIDリスト;

    /**
     * ファイル名リスト
     */
    private final List<RString> ファイル名リスト;

    /**
     * OCR情報受入＿バッチProcessパラメタです。
     *
     * @param 共有ファイルIDリスト 共有ファイルIDリスト
     * @param ファイル名リスト ファイル名リスト
     */
    public OcrJohoUkeireProcessParameter(
            List<RString> 共有ファイルIDリスト,
            List<RString> ファイル名リスト) {
        this.共有ファイルIDリスト = 共有ファイルIDリスト;
        this.ファイル名リスト = ファイル名リスト;
    }
}
