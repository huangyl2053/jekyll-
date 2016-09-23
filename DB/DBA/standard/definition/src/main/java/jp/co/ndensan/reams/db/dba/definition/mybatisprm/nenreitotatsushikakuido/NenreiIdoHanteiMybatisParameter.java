/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsushikakuido;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 判定SQL用のパラメータです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiIdoHanteiMybatisParameter {

    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 年齢到達日;

    /**
     * 判定SQL用のパラメータ作成を行います。
     *
     * @param 識別コード 識別コード
     * @param 年齢到達日 年齢到達日
     */
    public NenreiIdoHanteiMybatisParameter(ShikibetsuCode 識別コード, FlexibleDate 年齢到達日) {
        this.識別コード = 識別コード;
        this.年齢到達日 = 年齢到達日;
    }

}
