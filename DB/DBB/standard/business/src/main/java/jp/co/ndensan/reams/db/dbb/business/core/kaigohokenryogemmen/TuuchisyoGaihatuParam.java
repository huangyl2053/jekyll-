/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen;

import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書発行パラメータ
 *
 * @reamsid_L DBB-1660-090 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TuuchisyoGaihatuParam {

    private FukaJoho 賦課の情報_更正前;
    private FukaJoho 賦課の情報_更正後;
    private boolean 減免決定_出力有無;
    private FlexibleDate 減免決定_発行日;
    private RString 減免決定_文書番号;
    private boolean 減免取消_出力有無;
    private FlexibleDate 減免取消_発行日;
    private RString 減免取消_文書番号;
    private boolean 変更兼特徴中止_出力有無;
    private FlexibleDate 変更兼特徴中止_発行日;
    private RString 変更兼特徴中止_文書番号;
    private boolean 納入_出力有無;
    private FlexibleDate 納入_発行日;
    private FlexibleDate 納入_送付日;
    private RString 納入_出力期;
    private RString 納入_出力方法;
    private RString 納入_出力形式;
    private boolean 賦課台帳_出力有無;
}
