/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 収入情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunyuJoho {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private Decimal 特徴収入額01;
    private Decimal 特徴収入額02;
    private Decimal 特徴収入額03;
    private Decimal 特徴収入額04;
    private Decimal 特徴収入額05;
    private Decimal 特徴収入額06;
    private Decimal 普徴収入額01;
    private Decimal 普徴収入額02;
    private Decimal 普徴収入額03;
    private Decimal 普徴収入額04;
    private Decimal 普徴収入額05;
    private Decimal 普徴収入額06;
    private Decimal 普徴収入額07;
    private Decimal 普徴収入額08;
    private Decimal 普徴収入額09;
    private Decimal 普徴収入額10;
    private Decimal 普徴収入額11;
    private Decimal 普徴収入額12;
    private Decimal 普徴収入額13;
    private Decimal 普徴収入額14;

}
