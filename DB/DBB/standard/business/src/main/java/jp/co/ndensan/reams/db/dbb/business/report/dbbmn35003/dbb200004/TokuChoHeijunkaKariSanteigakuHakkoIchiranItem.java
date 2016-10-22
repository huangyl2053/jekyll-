/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表の情報です。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranItem {

    private RString printTimeStamp;
    private RString nendo;
    private RString hokenshaNo;
    private RString hokenshaName;
    private RString shutsuryokujun1;
    private RString shutsuryokujun2;
    private RString shutsuryokujun3;
    private RString shutsuryokujun4;
    private RString shutsuryokujun5;
    private RString kaipage1;
    private RString kaipage2;
    private RString kaipage3;
    private RString kaipage4;
    private RString kaipage5;
    private RString 連番;
    private RString 郵便番号;
    private RString 住所;
    private RString 行政区名称;
    private RString 行政区コード;
    private RString 性別;
    private RString 生年月日;
    private RString 変更前特徴額_１期;
    private RString 変更前特徴額_２期;
    private RString 変更前特徴額_３期;
    private RString 通知書番号;
    private RString 世帯コード;
    private RString 被保険者氏名;
    private RString 特別徴収義務者;
    private RString 特別徴対象年金;
    private RString 変更後特徴額_１期;
    private RString 変更後特徴額_２期;
    private RString 変更後特徴額_３期;

}
