/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.gokeidata;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細一覧表合計Entity
 *
 * @reamsid_L DBC-2180-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiDataEntity {

    private RString 様式名称;
    private Decimal 要介護件数;
    private Decimal 要介護金額;
    private Decimal 要支援件数;
    private Decimal 要支援金額;
    private Decimal その他件数;
    private Decimal その他金額;
}
