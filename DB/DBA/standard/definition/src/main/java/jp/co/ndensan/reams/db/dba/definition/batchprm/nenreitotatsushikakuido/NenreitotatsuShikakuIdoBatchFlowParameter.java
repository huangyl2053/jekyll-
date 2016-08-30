/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsushikakuido.HihokenshaDaichoKoshinProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 65歳年齢到達資格異動バッチパラメータクラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
@Getter
@Setter
public class NenreitotatsuShikakuIdoBatchFlowParameter extends BatchParameterBase {

    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;

    /**
     * コンストラクタです。
     */
    public NenreitotatsuShikakuIdoBatchFlowParameter() {
        this.kaishiYMD = FlexibleDate.EMPTY;
        this.shuryoYMD = FlexibleDate.EMPTY;
    }

    /**
     * 65歳年齢到達資格異動バッチパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     */
    private NenreitotatsuShikakuIdoBatchFlowParameter(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD
    ) {
        this.kaishiYMD = kaishiYMD;
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * 65歳年齢到達資格異動バッチのパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     * @return 65歳年齢到達資格異動バッチパラメータ
     */
    public NenreitotatsuShikakuIdoBatchFlowParameter createRoreiFukushiParam(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD) {
        return new NenreitotatsuShikakuIdoBatchFlowParameter(
                kaishiYMD,
                shuryoYMD);
    }

    /**
     * 認定調査督促対象者一覧表作成のパラメータを作成します。
     *
     * @return 認定調査督促対象者一覧表作成のパラメータ
     */
    public HihokenshaDaichoKoshinProcessParameter toShikakuIdoTaishoshaShutokuProcessParameter() {

        HihokenshaDaichoKoshinProcessParameter parameter = new HihokenshaDaichoKoshinProcessParameter();
        parameter.set開始日(kaishiYMD);
        parameter.set終了日(shuryoYMD);
        return parameter;
    }
}
