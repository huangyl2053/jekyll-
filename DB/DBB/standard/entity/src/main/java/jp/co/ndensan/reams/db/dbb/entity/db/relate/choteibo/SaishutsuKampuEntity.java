/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 歳出還付Entityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishutsuKampuEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private Decimal tkSaishutsuKampuCount;
    private Decimal tkSaishutsuKampuChoteiGaku;
    private Decimal fuSaishutsuKampuCount;
    private Decimal fuSaishutsuKampuChoteiGaku;
}
