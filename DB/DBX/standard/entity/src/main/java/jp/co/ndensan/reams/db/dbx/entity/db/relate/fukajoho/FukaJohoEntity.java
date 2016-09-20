/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.fukajoho;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課根拠照会のEntityクラスです。
 *
 * @reamsid_L DBB-5723-020 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoEntity {

    private DbT2002FukaEntity 介護賦課Entity;
    private int 期;
    private Decimal 調定額;

}
