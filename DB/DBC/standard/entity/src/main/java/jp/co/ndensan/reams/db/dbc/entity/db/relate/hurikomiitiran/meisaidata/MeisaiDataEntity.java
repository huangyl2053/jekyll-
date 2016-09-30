/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 振込明細一覧表明細Entity
 *
 * @reamsid_L DBC-2180-050 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MeisaiDataEntity {

    private FurikomiDetailTempTableEntity 振込明細一時TBL;
    private RString 様式連番;
    private RString 名寄せ件数;
    private RString 印字様式名称;
    private RString 印字様式番号;
    private Decimal 様式別集計金額;
    private RString 集計様式番号;
}
