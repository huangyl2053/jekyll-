/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のバッチフ処理parameterHandlerクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU080010_TokuteiKojinJohoTeikyoParameterHandler implements Serializable {

    private RString 特定個人情報名コード;
    private TeikyoYohi 被保険者;
    private TeikyoYohi 住特;
    private TeikyoYohi 受給者;
    private TeikyoYohi 負担割合;
    private TeikyoYohi 給付;
    private TeikyoYohi 総合事業;
}
