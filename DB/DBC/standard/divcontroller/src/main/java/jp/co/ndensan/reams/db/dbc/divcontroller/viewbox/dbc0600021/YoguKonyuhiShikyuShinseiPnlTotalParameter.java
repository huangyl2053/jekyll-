/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600021;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 福祉用具購入費支給申請_明細登録画面データ
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YoguKonyuhiShikyuShinseiPnlTotalParameter implements Serializable {

    private RDate サービス提供年月;
    private RString 整理番号;
    private Decimal 給付率;
    private RString 保険者;
    private Boolean 国保連再送付;
    private RString 事業者;
    private RString 証明書;
    private RString 審査結果;
    private RDate 申請日;
    private RDate 受付年月日;
    private RDate 領収年月日;
    private RString 申請者区分;
    private RString 申請理由;
    private RString 事業者コード;
    private RString 氏名１;
    private RString 氏名２;
    private RString 電話番号;
    private RString 郵便番号;
    private RString 住所;
    private RString 支払方法;
    private RString 窓口払い_支払場所;
    private RString 窓口払い_開始日;
    private RString 窓口払い_開始時間;
    private RString 窓口払い_終了日;
    private RString 窓口払い_終了時間;
    private RString 口座払い_口座ＩＤ;
    private RString 口座払い_金融機関コード;
    private RString 口座払い_支店コード;
    private RString 口座払い_店番;
    private RString 口座払い_預金種別;
    private RString 口座払い_口座番号;
    private RString 口座払い_金融機関名;
    private RString 口座払い_名義人_カナ;
    private RString 口座払い_名義人_漢字;
    private RString 受領委任払い_契約番号;
    private RString 受領委任払い_契約事業者;
    private RString 受領委任払い_金融機関コード;
    private RString 受領委任払い_支店コード;
    private RString 受領委任払い_店番;
    private RString 受領委任払い_預金種別;
    private RString 受領委任払い_口座番号;
    private RString 受領委任払い_金融機関名;
    private RString 受領委任払い_名義人_カナ;
    private RString 受領委任払い_名義人_漢字;
}
