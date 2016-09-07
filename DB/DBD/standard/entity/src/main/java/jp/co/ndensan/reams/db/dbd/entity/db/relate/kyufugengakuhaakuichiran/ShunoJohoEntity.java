/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納情報Entity
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoEntity {

    private List<ShunoKibetsuEntity> 期別情報;
    private FlexibleYear 賦課年度;
    private FlexibleYear 調定年度;
    private TokuchoFuchoKubun 特徴普徴区分;
    private RString 収納情報なし;

}
