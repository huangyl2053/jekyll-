/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA010010;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba010010.HihokenshaDaichoKoshinProcessParameter;
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
public class DBA010010_NenreitotatsuShikakuIdoParameter extends BatchParameterBase {

    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;

    /**
     * コンストラクタです。
     */
    public DBA010010_NenreitotatsuShikakuIdoParameter() {

    }

    /**
     * 65歳年齢到達資格異動バッチパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     */
    private DBA010010_NenreitotatsuShikakuIdoParameter(
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
    public DBA010010_NenreitotatsuShikakuIdoParameter createRoreiFukushiParam(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD) {
        return new DBA010010_NenreitotatsuShikakuIdoParameter(
                kaishiYMD,
                shuryoYMD);
    }

    /**
     * 資格異動対象者情報取得プロセスのパラメータを作成します。
     *
     * @return 資格異動対象者情報取得プロセスのパラメータ
     */
    public HihokenshaDaichoKoshinProcessParameter toShikakuIdoTaishoshaShutokuProcessParameter() {

        HihokenshaDaichoKoshinProcessParameter parameter = new HihokenshaDaichoKoshinProcessParameter();
        parameter.set開始日(kaishiYMD);
        parameter.set終了日(shuryoYMD);
        parameter.set通常運用時(false);
        return parameter;
    }
}
