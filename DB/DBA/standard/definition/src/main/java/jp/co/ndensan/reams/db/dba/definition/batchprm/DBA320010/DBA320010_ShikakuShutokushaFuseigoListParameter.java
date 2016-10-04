/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA320010;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba320010.ShikakuShutokushaFuseigoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格取得者不整合リストクラスです。
 *
 * @reamsid_L DBU-4020-010 linghuhang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBA320010_ShikakuShutokushaFuseigoListParameter extends BatchParameterBase {

    private static final String SHUTURYOKUTAISHOUKUBUN = "shuturyokuTaishouKubun";
    @BatchParameter(key = SHUTURYOKUTAISHOUKUBUN, name = "出力対象区分")
    private RString shuturyokuTaishouKubun;

    /**
     * コンストラクタです。
     */
    public DBA320010_ShikakuShutokushaFuseigoListParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param shuturyokuTaishouKubun 出力対象区分
     */
    public DBA320010_ShikakuShutokushaFuseigoListParameter(RString shuturyokuTaishouKubun) {
        this.shuturyokuTaishouKubun = shuturyokuTaishouKubun;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return ShikakuShutokushaFuseigoProcessParameter
     */
    public ShikakuShutokushaFuseigoProcessParameter toShikakuShutokushaFuseigoProcessParameter() {
        return new ShikakuShutokushaFuseigoProcessParameter(shuturyokuTaishouKubun);
    }
}
