/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariai;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_修正のMybatisParameterクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiMybatisParameter implements IMyBatisParameter {

    private RString 年度;
    private RString 被保険者番号;
    private int 履歴番号;
    private RString flag;

    /**
     * FutanWariaiMybatisParameter
     */
    public FutanWariaiMybatisParameter() {

    }
}
