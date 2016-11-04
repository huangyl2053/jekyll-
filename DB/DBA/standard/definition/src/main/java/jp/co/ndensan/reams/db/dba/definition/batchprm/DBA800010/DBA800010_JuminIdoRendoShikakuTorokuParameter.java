/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA800010;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連動資格登録のバッチParameterクラスです。
 *
 * @reamsid_L DBA-1410-010 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBA800010_JuminIdoRendoShikakuTorokuParameter extends BatchParameterBase {

    private static final String DUMMY = "Dummy";

    @BatchParameter(key = DUMMY, name = "Dummy")
    private RString dummy;

    /**
     * コンストラクタです。
     */
    public DBA800010_JuminIdoRendoShikakuTorokuParameter() {
        dummy = RString.EMPTY;
    }
}
