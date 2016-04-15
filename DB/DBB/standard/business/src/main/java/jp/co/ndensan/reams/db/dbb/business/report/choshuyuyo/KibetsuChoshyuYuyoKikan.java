/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期別徴収猶予期間のEntity
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuChoshyuYuyoKikan {

    private RString 特徴期;
    private RString 特徴月;
    private RString 特徴期別金額;
    private RString 普徴期;
    private RString 普徴月;
    private RString 普徴期別金額;
    private RString 徴収猶予期間;
}
