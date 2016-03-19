/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiMeisaiIchijiEntity {

    private RString 交換情報識別番号;
    private RString 帳票レコード種別;
    private int no;
    private RString 被保険者番号;
    private RString 被保険者氏名漢字;
    private RString サービス提供年月;
    private RString 利用者負担額;
    private RString 支給区分コード;
    private RString 決定年月;
    private RString 高額支給額;
    private RString 支払方法区分コード;
    private RString 支払場所;
    private RString 開始年月日;
    private RString 終了年月日;
    private RString 開始曜日;
    private RString 終了曜日;
    private RString 開始時間;
    private RString 終了時間;
    private RString 金融機関コード;
    private RString 金融機関名;
    private RString 金融機関支店コード;
    private RString 金融機関支店名;
    private RString 口座種目;
    private RString 口座種目名;
    private RString 口座番号;
    private RString 口座名義人カナ;

}
