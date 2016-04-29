/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoShurui;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 徴収猶予の情報
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoshuYuyoJoho {

    private DbT2002FukaEntity 介護賦課;
    private DbT2006ChoshuYuyoEntity 介護賦課徴収猶予;
    private DbT2007KibetsuChoshuYuyoEntity 介護期別徴収猶予;
    private DbT2003KibetsuEntity 介護期別;
    private UrT0705ChoteiKyotsuEntity 調定共通;

    private Decimal 特徴期別金額01;
    private Decimal 特徴期別金額02;
    private Decimal 特徴期別金額03;
    private Decimal 特徴期別金額04;
    private Decimal 特徴期別金額05;
    private Decimal 特徴期別金額06;
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

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 徴収猶予状態区分;
    private RString 通知書番号;
    private RString 世帯コード;
    private RString 被保険者番号;
    private RString 識別コード;
    private FlexibleDate 徴収猶予決定日;
    private HokenryoChoshuYuyoShurui 徴収猶予種類;
    private RString 徴収猶予取消事由;

}
