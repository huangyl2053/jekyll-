/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;

/**
 * 特定個人情報提供のバッチフ処理parameterクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU080010_TokuteiKojinJohoTeikyoParameter extends BatchParameterBase {

    private static final String TOKUTEIKOJINJOHO = "TokuteiKojinJoho";

    @BatchParameter(key = TOKUTEIKOJINJOHO, name = "特定個人情報")
    private List<DBU080010_TokuteiKojinJohoTeikyoParameterHandler> 特定個人情報;

    /**
     * コンストラクタです。
     */
    public DBU080010_TokuteiKojinJohoTeikyoParameter() {

    }
}
