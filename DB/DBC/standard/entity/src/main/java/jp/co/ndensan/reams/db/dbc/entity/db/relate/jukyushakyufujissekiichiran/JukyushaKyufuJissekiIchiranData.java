/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者給付実績一覧表 のパラメータクラスです。
 *
 * @reamsid_L DBC-3070-040 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufuJissekiIchiranData {

    private RDateTime 作成日時;
    private RString ページ数;
    private RString 市町村コード;
    private RString 市町村名;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 要介護度;
    private FlexibleYearMonth サービス提供年月;
    private RString 公費負担者1;
    private RString 公費受給者1;
    private RString サービス単位数_保険;
    private RString サービス単位数_公費1;
    private RString 請求額_保険;
    private RString 請求額_公費1;
    private RString 負担額_利用者;
    private RString 負担額_公費本人1;
    private RString 緊急時施設療養請求合計額_保険;
    private RString 緊急時施設療養請求合計額_公費1;
    private RString 特定診療請求合計額_保険;
    private RString 特定診療請求合計額_公費1;
    private RString 特定入所者介護費等請求額_保険;
    private RString 特定入所者介護費等請求額_公費1;
    private RString 識別コード;
    private RString 住所;
    private RString 様式;
    private RString 公費負担者2;
    private RString 公費受給者2;
    private RString サービス単位数_公費2;
    private RString 請求額_公費2;
    private RString 負担額_公費本人2;
    private RString 緊急時施設療養請求合計額_公費2;
    private RString 特定診療請求合計額_公費2;
    private RString 特定入所者介護費等請求額_公費2;
    private FlexibleYearMonth 審査年月;
    private RString 世帯コード;
    private RString 事業者番号;
    private RString 事業者名称;
    private RString 実績区分;
    private RString 公費負担者3;
    private RString 公費受給者3;
    private RString サービス単位数_公費3;
    private RString 請求額_公費3;
    private RString 負担額_公費本人3;
    private RString 緊急時施設療養請求合計額_公費3;
    private RString 特定診療請求合計額_公費3;
    private RString 特定入所者介護費等請求額_公費3;
}
