/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku;

import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課の情報登録のRelateEntityクラスです。
 *
 * @reamsid_L DBB-9040-080 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class FukaJohoTorokuRelateEntity {

    private DbT2002FukaJohoTempTableEntity 賦課情報一時Entity;
    private Decimal 調定ID;
    private int 期;
    private KamokuCode 科目コード;
}
