/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;

/**
 * の編集用のデータ取得の編集用のデータ取得Entity。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokiKoreshaJyohoResultEntity {

    private DbT7124KokiKoreishaInfoEntity 現在後期高齢者情報;
    private TorikomiKokiKoreshaJyohoEntity 取込後期高齢者情報Entity;
}
