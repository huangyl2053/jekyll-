/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hanyolisthihokenshadaicho;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link HanyoListHihokenshadaichoProcess}の資格取得判定のためのクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakShutokuHantei {

    private RString codeShubetsu;
    private Code jiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate todokedeYMD;
}
