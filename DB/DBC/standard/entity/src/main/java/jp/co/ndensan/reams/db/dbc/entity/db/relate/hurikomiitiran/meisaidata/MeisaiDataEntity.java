/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;

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
    private List<PrintNoKingakuEntity> 印字様式番号別金額List;
}
