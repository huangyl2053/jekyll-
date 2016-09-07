/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特徴平準化計算対象者一覧entity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijyunkaRokuBatchFukaGakuEntity {

    private RString 保険料段階仮算定時;
    private Decimal 特徴期期別金額01;
    private Decimal 特徴期期別金額02;
    private Decimal 特徴期期別金額03;
    private Decimal 普徴期期別金額01;
    private Decimal 普徴期期別金額02;
    private Decimal 普徴期期別金額03;
    private Decimal 普徴期期別金額04;
    private Decimal 普徴期期別金額05;
    private Decimal 普徴期期別金額06;
    private Decimal 普徴期期別金額07;
    private Decimal 普徴期期別金額08;
    private Decimal 普徴期期別金額09;
    private Decimal 普徴期期別金額10;
    private Decimal 普徴期期別金額11;
    private Decimal 普徴期期別金額12;
}
