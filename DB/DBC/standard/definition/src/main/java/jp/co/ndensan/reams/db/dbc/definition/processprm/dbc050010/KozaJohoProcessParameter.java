/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LDNS donghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KozaJohoProcessParameter {

    private RDate 振込指定年月日;

    /**
     * コンストラクタ
     *
     * @param 振込指定年月日 RDate
     */
    public KozaJohoProcessParameter(RDate 振込指定年月日) {
        this.振込指定年月日 = 振込指定年月日;
    }

}
