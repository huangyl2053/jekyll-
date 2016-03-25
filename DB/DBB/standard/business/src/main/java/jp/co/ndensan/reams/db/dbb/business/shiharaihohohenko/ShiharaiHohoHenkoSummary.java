/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.shiharaihohohenko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 支払方法変更概況です。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoSummary {

    //TODO QA #80225
    //private ShiharaiHenkoTorokuKubun 支払方法変更_登録区分;
    private FlexibleDate 支払方法変更_開始日;
    private FlexibleDate 支払方法変更_終了日;
    //private ShiharaiHenkoTorokuKubun 給付額減額_登録区分;
    private FlexibleDate 給付額減額_開始日;
    private FlexibleDate 給付額減額_終了日;

}
