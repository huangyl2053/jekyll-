/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定通知書の発行する用パラメータクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class PrtKetteiTsuchishoParameter implements IMyBatisParameter {

    private final RString 決定変更区分;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 決定変更区分 RString
     * @param 出力順 RString
     */
    private PrtKetteiTsuchishoParameter(
            RString 決定変更区分,
            RString 出力順) {
        this.決定変更区分 = 決定変更区分;
        this.出力順 = 出力順;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 決定変更区分 RString
     * @param 出力順 RString
     * @return PrtKetteiTsuchishoParameter パラメータ
     */
    public static PrtKetteiTsuchishoParameter createSelectByKeyParam(
            RString 決定変更区分,
            RString 出力順) {
        return new PrtKetteiTsuchishoParameter(決定変更区分, 出力順);
    }
}
