/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shutokujohochushutsurenkei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携（バッチ）のMybatisパラメータです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutokuJohoChushutsuRenkeiMybatisParameter implements IMyBatisParameter {

    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 出力順 RString
     */
    public ShutokuJohoChushutsuRenkeiMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }
}
