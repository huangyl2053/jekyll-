/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 収納情報Entity
 *
 * @reamsid_L DBD-3610-060 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShounaQingbaoEntity {

    private FlexibleYear 賦課年度;
    private RYear 調定年度;
    private RString 期別;
    private Decimal 保険料金;
    private RString 納期限;
    private Decimal 滞納額;
    private RString 滞納区分;
    private FlexibleDate 時効起算日;
    private RString 時効起算事由;
    private RString 特徴普徴区分;
    private boolean 収納情報なし;

}
