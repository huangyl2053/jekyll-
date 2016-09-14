/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業高額決定通知書と事業高額決定通知書(支払予定日あり）帳票用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuKetteiTsuchishoReportEntity implements Serializable {

    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 文書番号;
    private RString テスト出力フラグ;
    private RString タイトル;
    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString 受付年月日;
    private RString 決定年月日;
    private RString 本人支払額;
    private RString 対象年月;
    private RString 給付の種類;
    private RString 支給結果;
    private RString 決定額;
    private RString 支給金額;
    private RString 理由タイトル;
    private RString 不支給理由;
    private RString 窓口払;
    private RString 口座払;
    private RString 取り消し持ちもの;
    private RString 持ちもの;
    private RString 取り消し支払場所;
    private RString 支払場所;
    private RString 支払期間;
    private RString 取り消し支払期間;
    private RString 金融機関;
    private RString 支店;
    private RString 種別タイトル;
    private RString 口座種別;
    private RString 番号タイトル;
    private RString 口座番号;
    private RString 口座名義人;
    private RString 支払予定日;
    private RString 決定通知書番号;
    private RString 通番;
}
