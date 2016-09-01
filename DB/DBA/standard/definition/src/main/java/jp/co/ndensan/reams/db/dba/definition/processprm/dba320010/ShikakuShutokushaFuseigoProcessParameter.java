/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba320010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格取得者不整合リストProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShutokushaFuseigoProcessParameter implements IBatchProcessParameter {

    private final RString shuturyokuTaishouKubun;

    /**
     * コンストラクタです。
     *
     * @param shuturyokuTaishouKubun 出力対象区分
     */
    public ShikakuShutokushaFuseigoProcessParameter(RString shuturyokuTaishouKubun) {
        this.shuturyokuTaishouKubun = shuturyokuTaishouKubun;
    }
}
