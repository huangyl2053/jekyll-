/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.kyufugakugengakukanrilist;

import jp.co.ndensan.reams.db.dbd.definition.core.kyufugakugengakukanrilist.KyufugakuGengakuKanriListData;
import jp.co.ndensan.reams.db.dbd.definition.processprm.kyufugakugengakukanrilist.KyufugakuGengakuKanriListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額管理リスト_バッチ用のパラメータです。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
public class KyufugakuGengakuKanriListFlowParameter extends BatchParameterBase {

    private RDate 基準日;
    private RString 対象区分;
    private boolean 通知書未発行者抽出;
    private boolean 減額適用中者抽出;
    private RDate 減額適用中者抽出基準日;
    private boolean 減額終了日抽出;
    private RDate 減額終了日範囲From;
    private RDate 減額終了日範囲To;
    private boolean 保険料完納者出力;
    private RString 改頁出力順ID;
    private RString 帳票ID;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDbd209010BatchParameter(KyufugakuGengakuKanriListData tempData) {
        this.基準日 = tempData.get基準日();
        this.対象区分 = tempData.get対象区分();
        this.通知書未発行者抽出 = tempData.is通知書未発行者抽出();
        this.減額適用中者抽出 = tempData.is減額適用中者抽出();
        this.減額適用中者抽出基準日 = tempData.get減額適用中者抽出基準日();
        this.減額終了日抽出 = tempData.is減額終了日抽出();
        this.減額終了日範囲From = tempData.get減額終了日範囲From();
        this.減額終了日範囲To = tempData.get減額終了日範囲To();
        this.保険料完納者出力 = tempData.is保険料完納者出力();
        this.改頁出力順ID = tempData.get改頁出力順ID();
        this.帳票ID = tempData.get帳票ID();
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public KyufugakuGengakuKanriListProcessParameter toKyufugakuGengakuKanriListProcessParameter() {
        return new KyufugakuGengakuKanriListProcessParameter(
                this.基準日,
                this.対象区分,
                this.通知書未発行者抽出,
                this.減額適用中者抽出,
                this.減額適用中者抽出基準日,
                this.減額終了日抽出,
                this.減額終了日範囲From,
                this.減額終了日範囲To,
                this.保険料完納者出力,
                this.改頁出力順ID,
                this.帳票ID);

    }
}
