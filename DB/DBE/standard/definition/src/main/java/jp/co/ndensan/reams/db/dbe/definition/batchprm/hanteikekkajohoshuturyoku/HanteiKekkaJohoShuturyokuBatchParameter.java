/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.hanteikekkajohoshuturyoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 判定結果情報出力(介護認定審査会)バッチのパラメータ。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanteiKekkaJohoShuturyokuBatchParameter extends BatchParameterBase {

    private static final String KEY_HAKKOUTYOUHYOU = "hakkouTyouhyou";
    private static final String KEY_KAISAIBANGOULIST = "kaisaiBangouList";
    private static final String KEY_KAISAIBANGOU = "kaisaiBangou";

    @BatchParameter(key = KEY_HAKKOUTYOUHYOU, name = "発行帳票")
    private RString hakkouTyouhyou;
    @BatchParameter(key = KEY_KAISAIBANGOULIST, name = "開催番号")
    private List<RString> kaisaiBangouList;
    @BatchParameter(key = KEY_KAISAIBANGOU, name = "開催番号")
    private RString kaisaiBangou;

    /**
     * バーチのパラメータを作成します。
     *
     * @return HanteiKekkaJohoShuturyokuProcessParameter
     */
    public HanteiKekkaJohoShuturyokuProcessParameter toHanteiKekkaJohoShuturyokuProcessParameter() {
        return new HanteiKekkaJohoShuturyokuProcessParameter(
                hakkouTyouhyou,
                kaisaiBangouList,
                kaisaiBangou);
    }
}
