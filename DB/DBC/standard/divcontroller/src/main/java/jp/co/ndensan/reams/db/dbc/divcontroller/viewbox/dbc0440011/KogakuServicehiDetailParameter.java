/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0440011;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBCMN42001_高額サービス費支給申請登録
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiDetailParameter implements Serializable {

    private RDate 申請日;
    private RString 申請者区分;
    private RString 証記載保険者番号;
    private boolean 国保連再送;
    private RString 氏名_漢字;
    private RString 氏名_カナ;
    private RString 電話番号;
    private RString 申請理由;
    private Decimal 支払金額合計;
    private RString 窓口払い_支払場所;
    private RString 窓口払い_開始日;
    private RString 窓口払い_開始時間;
    private RString 窓口払い_終了日;
    private RString 窓口払い_終了時間;
    private RString 口座払い_口座ＩＤ;
    private RString 受領委任払い_契約番号;
    private RDate 受付日;
    private Decimal 本人支払額;
    private RDate 決定日;
    private RString 支給区分;
    private RString 審査方法区分;
    private RString 世帯集約番号;
    private Decimal 支給金額;
    private RString 高額自動償還;
    private RString 支給しない理由;

}
