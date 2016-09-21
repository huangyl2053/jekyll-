/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LDNS donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiDataEntity {

    private RString 比較キー;
    private RString kozaNayoseKey;
    private int 件数;
    private Decimal 合計振込金額;
    private int データ区分件数;
    private FurikomiDetailTempTableEntity 振込明細一時Entity;

}
