/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpokyuyoshiki1;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業状況報告年報（様式１・２　所得段階）のパラメータクラスです。
 *
 * @reamsid_L DBU-5610-060 kanghongsong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuNenpoKyuyoshiki1 {

    private RDateTime 処理日時;
    private RString 保険者番号;
    private RString 保険者名;
    private FlexibleYearMonth 集計期間FROM;
    private FlexibleYearMonth 集計期間TO;
    private FlexibleYear 集計年度;
    private RString 第１段階_被保険者数;
    private RString 第２段階_被保険者数;
    private RString 第３段階_被保険者数;
    private RString 第４段階_被保険者数;
    private RString 第５段階_被保険者数;
    private RString 第６段階１_被保険者数;
    private RString 第６段階２_被保険者数;
    private RString 第６段階３_被保険者数;
    private RString 第６段階４_被保険者数;
    private RString 第７段階１_被保険者数;
    private RString 第７段階２_被保険者数;
    private RString 第７段階３_被保険者数;
    private RString 第７段階４_被保険者数;
    private RString 第８段階１_被保険者数;
    private RString 第８段階２_被保険者数;
    private RString 第８段階３_被保険者数;
    private RString 第８段階４_被保険者数;
    private RString 第９段階１_被保険者数;
    private RString 第９段階２_被保険者数;
    private RString 第９段階３_被保険者数;
    private RString 第９段階４_被保険者数;
    private RString 第９段階５_被保険者数;
    private RString 第９段階６_被保険者数;
    private RString 第９段階７_被保険者数;
    private RString 第９段階８_被保険者数;
    private RString 第９段階９_被保険者数;
    private RString 不明_被保険者週;
    private RString 不明_所得段階;
    private RString 標準月額保険料;
    private RString 合計;

}
