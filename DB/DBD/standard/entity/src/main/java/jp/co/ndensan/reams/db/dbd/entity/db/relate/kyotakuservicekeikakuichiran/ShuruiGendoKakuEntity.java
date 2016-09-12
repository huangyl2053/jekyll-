/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 共有子Div「居宅計画」の種類限度額Entityです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuruiGendoKakuEntity {

    private ServiceShuruiCode サービス種類;
    private Decimal 支給限度単位数;
    private Decimal 種類限度内単位数;
    private Decimal 限度超過単位数;
}
