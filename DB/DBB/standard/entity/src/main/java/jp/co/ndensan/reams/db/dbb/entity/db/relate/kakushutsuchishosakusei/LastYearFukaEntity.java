/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 前年度賦課の情報Entityクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class LastYearFukaEntity implements Serializable {

    private DbT2002FukaEntity 介護賦課;
    private int 期;
    private Decimal 調定額;

}
