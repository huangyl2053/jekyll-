/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;

/**
 * 償還払請求明細・住所地特例取得Entityクラスです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsMeisaiJutokuTempEntity implements Serializable {

    private DbWT2111ShokanShinseiTempEntity 償還払支給申請一時Entity;
    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
    private DbT3107ShokanMeisaiJushochiTokureiEntity 明細_住所地特例Entity;

}
