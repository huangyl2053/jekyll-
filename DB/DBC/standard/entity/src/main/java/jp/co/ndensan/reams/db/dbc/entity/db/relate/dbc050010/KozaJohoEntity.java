/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 口座払の口座情報取得SQL検索結果クラスです．
 *
 * @reamsid_L DBC-2180-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KozaJohoEntity {

    private FurikomiDetailTempTableEntity 振込明細一時Entity;
    private TokuteiKozaRelateEntity 口座;

}
