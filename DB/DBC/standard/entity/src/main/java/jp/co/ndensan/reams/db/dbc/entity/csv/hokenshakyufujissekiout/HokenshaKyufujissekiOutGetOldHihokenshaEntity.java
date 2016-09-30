/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;

/**
 * 旧被保険者番号の取得パラメータです。
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiOutGetOldHihokenshaEntity {

    private DbT7026ShinKyuHihokenshaNoHenkanEntity dbT7026Entity;
    private DbWT1001HihokenshaTempEntity dbWT1001Entity;

}
