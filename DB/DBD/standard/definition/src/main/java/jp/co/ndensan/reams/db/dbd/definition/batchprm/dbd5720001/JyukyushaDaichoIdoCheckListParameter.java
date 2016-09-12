/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5720001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001.JyukyushaDaichoIdoCheckListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者台帳異動チェックリストのバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1770-010 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyushaDaichoIdoCheckListParameter extends BatchParameterBase {

    @BatchParameter(key = "今回抽出開始年月日", name = "今回抽出開始年月日")
    private RDate 今回抽出開始年月日;
    @BatchParameter(key = "今回抽出開始時分秒", name = "今回抽出開始時分秒")
    private RTime 今回抽出開始時分秒;
    @BatchParameter(key = "今回抽出終了年月日", name = "今回抽出終了年月日")
    private RDate 今回抽出終了年月日;
    @BatchParameter(key = "今回抽出終了時分秒", name = "今回抽出終了時分秒")
    private RTime 今回抽出終了時分秒;
    @BatchParameter(key = "出力対象", name = "出力対象")
    private RString 出力対象;
    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private Long 出力順ID;

    /**
     *
     * @return KoshinTaishoshaKanriProcessParameter
     */
    public JyukyushaDaichoIdoCheckListProcessParameter toJyukyushaDaichoIdoCheckListProcessParameter() {
        return new JyukyushaDaichoIdoCheckListProcessParameter(今回抽出開始年月日, 今回抽出開始時分秒,
                今回抽出終了年月日, 今回抽出終了時分秒, 出力対象, 出力順ID);
    }

}
