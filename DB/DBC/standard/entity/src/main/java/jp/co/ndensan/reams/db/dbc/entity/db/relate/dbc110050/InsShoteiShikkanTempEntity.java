/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;

/**
 * 償還払請求所定疾患施設療養費等取得Entityクラスです.
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsShoteiShikkanTempEntity implements Serializable {

    private DbWT2111ShokanShinseiTempEntity 償還払支給申請一時Entity;
    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
    private DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity 所定疾患施設療養費Entity;
}
