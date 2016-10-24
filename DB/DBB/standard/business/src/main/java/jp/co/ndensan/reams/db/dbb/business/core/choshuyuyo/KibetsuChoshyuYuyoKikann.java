/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料徴収猶予画面 Entity定義_DBBGM62001_1
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KibetsuChoshyuYuyoKikann implements Serializable {

    private RString 普徴期;
    private RString 普徴月;
    private RString 普徴期別納付額;
    private FlexibleDate 徴収猶予_開始;
    private FlexibleDate 徴収猶予_終了;

}
