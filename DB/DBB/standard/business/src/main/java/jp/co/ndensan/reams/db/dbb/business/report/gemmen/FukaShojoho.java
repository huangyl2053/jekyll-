/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課の情報クラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaShojoho {

    private DbT2002FukaEntity 介護賦課;
    private DbT2003KibetsuEntity 介護期別;
    private UrT0705ChoteiKyotsuEntity 調定共通;
    private DbT2001ChoshuHohoEntity 介護徴収方法;
    //特徴期別金額（更正前）
    private Decimal 特徴期別金額01;
    private Decimal 特徴期別金額02;
    private Decimal 特徴期別金額03;
    private Decimal 特徴期別金額04;
    private Decimal 特徴期別金額05;
    private Decimal 特徴期別金額06;
    //普徴期別金額（更正前）
    private Decimal 普徴期別金額01;
    private Decimal 普徴期別金額02;
    private Decimal 普徴期別金額03;
    private Decimal 普徴期別金額04;
    private Decimal 普徴期別金額05;
    private Decimal 普徴期別金額06;
    private Decimal 普徴期別金額07;
    private Decimal 普徴期別金額08;
    private Decimal 普徴期別金額09;
    private Decimal 普徴期別金額10;
    private Decimal 普徴期別金額11;
    private Decimal 普徴期別金額12;
    private Decimal 普徴期別金額13;
    private Decimal 普徴期別金額14;
    private Decimal 減免額;
    private Decimal 減免前介護保険料;
    private Decimal 確定介護保険料;

}
