/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;

/**
 * 証記載保険者名取得Entityクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoKisaiHokenshaNoNameEntity {

    private int 連番;
    private DbWT3470ServiceMeisaichukanTempEntity サービス明細;
    private DbT7051KoseiShichosonMasterEntity 証記載保険者;

}
