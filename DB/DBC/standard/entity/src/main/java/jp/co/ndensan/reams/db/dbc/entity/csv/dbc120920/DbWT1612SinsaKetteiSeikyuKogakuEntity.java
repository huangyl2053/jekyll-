/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求高額一時TBLクラスです。
 *
 * @reamsid_L DBC-2500-012 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1612SinsaKetteiSeikyuKogakuEntity {

    private int 履歴番号;
    private Decimal 高額_高額該当件数;
    private Decimal 高額_高額介護サービス費;
    private Decimal 高額_公費負担額;

}
