/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;

/**
 * 広域加入日以前のデータを取得パラメータです。
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiOutGetBeforeKanyuYMDEntity implements IBatchProcessParameter, IMyBatisParameter {

    private DbT7051KoseiShichosonMasterEntity dbT7051Entity;
    private DbWT1001HihokenshaTempEntity dbWT1001Entity;

}
