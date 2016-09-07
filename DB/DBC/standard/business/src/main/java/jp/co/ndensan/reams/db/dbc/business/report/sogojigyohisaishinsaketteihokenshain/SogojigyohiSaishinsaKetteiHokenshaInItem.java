/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費再審査決定通知書情報取込一覧表帳票Item
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSaishinsaKetteiHokenshaInItem {

    private RString 印刷日時;
    private RString 取込年月;
    private RString 国保連合会名;
    private RString 審査委員会名;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 通番;
    private RString 取扱年月;
    private RString 事業者番号;
    private RString 事業者名;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 当初請求単位数;
    private RString 決定単位数;
    private RString 保険者負担額;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 申立事由コード;
    private RString 申立事由;
    private RString 原審単位数;
    private RString 調整単位数;
    private RString 決定タイトル;
    private RString 決定件数タイトル;
    private RString 決定単位数タイトル;
    private RString 決定負担額タイトル;
    private RString 調整タイトル;
    private RString 調整件数タイトル;
    private RString 調整単位数タイトル;
    private RString 調整負担額タイトル;
    private RString 総合事業費タイトル;
    private RString 総合事業費_決定_件数;
    private RString 総合事業費_決定_単位数;
    private RString 総合事業費_決定_負担額;
    private RString 総合事業費_調整_件数;
    private RString 総合事業費_調整_単位数;
    private RString 総合事業費_調整_負担額;
}
