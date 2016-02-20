/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.db.shokanshinseijutakukaishu;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sunhui
 */
@Getter
@Setter
public class ShokanShinseiJutakuKaishuEntity  implements Cloneable, Serializable{
    FlexibleYearMonth serviceTeikyoYM;
    RString jutakuKaishuJutakuAddress;

}
