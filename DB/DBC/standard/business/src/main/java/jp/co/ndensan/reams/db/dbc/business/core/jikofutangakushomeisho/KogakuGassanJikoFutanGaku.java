/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeisho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikoFutanGaku implements Serializable {

    private RString jikoFutanSeiriNo;
    private FlexibleDate shomeiShoSakuseiYMD;
    private RString saiKeisanKubun;
}
