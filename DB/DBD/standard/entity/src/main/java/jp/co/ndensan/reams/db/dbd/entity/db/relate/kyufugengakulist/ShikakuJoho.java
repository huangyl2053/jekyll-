/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuJoho {

    private RString 喪失事由;
    private RString 資格区分;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private boolean 住特フラグ;
    private boolean 生保フラグ;

}
