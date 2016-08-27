/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定実施状況表（統計表）Entityクラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JissiJyokyohyoHakkouEntity {

    private RString 取得条件;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 年月;
    private int 数量;
}
