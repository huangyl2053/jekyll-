/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyojyoho.DbWT1211ShikakuShogohyoTempEntity;

/**
 * 資格照合表一時TBLと被保険者一時TBLのentityです。
 *
 * @reamsid_L DBC-2890-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoInEntity {

    private DbWT0001HihokenshaTempEntity 被保険者一時;
    private DbWT1211ShikakuShogohyoTempEntity 資格照合表一時;

}
