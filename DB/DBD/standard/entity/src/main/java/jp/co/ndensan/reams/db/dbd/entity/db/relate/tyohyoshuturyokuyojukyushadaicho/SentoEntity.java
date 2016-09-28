/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 先頭Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SentoEntity {

    private RString 保険者番号;
    private RString 保険者名称;
    private RString 証記載保険者コード;
    private RString 証記載保険者名;
    private RString 被保険者に対するページ;
    private RString 総ページ;
    private RString 被保険者番号;
    private RString 被保険者名;
    private RString 被保険者名カナ;
    private RString 性別;
    private FlexibleDate 生年月日;
    private RString 住所コード;
    private RString 住所;
    private RString 世帯コード;
    private RString 住民コード;
    private RString 現状態;
    private RString 行政区コード;
    private RString 行政区名称;
    private RString 連絡先区分1;
    private RString 連絡先1;
    private RString 連絡先区分2;
    private RString 連絡先2;
    private RString 老健市町村コード;
    private RString 老健市町村名称;
    private RString 老健受給者番号;
    private RString 地区タイトル1;
    private RString 地区タイトル2;
    private RString 地区タイトル3;
    private RString 地区コード1;
    private RString 地区コード2;
    private RString 地区コード3;
    private RString 医療種別;
    private RString 医療保険者番号;
    private RString 医療保険者名称;
    private RString 記号番号;
    private FlexibleYearMonth 直近管理票;
    private FlexibleYearMonth 直近実績;
    private FlexibleYearMonth 直近高額;
    private FlexibleYearMonth 直近償還;
    private RString 直近所得段階;
    private RString 調査先郵便番号;
    private RString 調査先住所;
    private RString 調査先名称;
    private RString 調査先電話番号;
    private RString 備考;

}
