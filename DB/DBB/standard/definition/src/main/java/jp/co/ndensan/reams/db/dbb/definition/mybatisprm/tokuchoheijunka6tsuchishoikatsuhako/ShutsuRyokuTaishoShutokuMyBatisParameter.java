/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)の「出力対象情報の取得」SQLパラメータクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutsuRyokuTaishoShutokuMyBatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private int 出力対象区分;

    /**
     * コンストラクタです。
     *
     * @param 出力順 出力順
     * @param 出力対象区分 出力対象区分
     */
    public ShutsuRyokuTaishoShutokuMyBatisParameter(RString 出力順, int 出力対象区分) {

        this.出力順 = 出力順;
        this.出力対象区分 = 出力対象区分;
    }
}
