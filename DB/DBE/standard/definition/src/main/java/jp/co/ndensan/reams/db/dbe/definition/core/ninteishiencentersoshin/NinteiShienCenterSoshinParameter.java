/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ninteishiencentersoshin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * センター送信準備のParameterクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShienCenterSoshinParameter {

    private boolean is未出力;
    private boolean has二次判定日_開始;
    private boolean has二次判定日_終了;
    private FlexibleDate 二次判定日_開始;
    private FlexibleDate 二次判定日_終了;
    private int 件数;

}
