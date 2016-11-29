/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費公費受給者別一覧表のBusinessです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KohijukyushaBetsuIchiranBusiness {

    private RDateTime 作成日時;
    private FlexibleYearMonth 審査年月;
    private RString 国保連合会名;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private RString 公費受給者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業所番号;
    private RString 事業所名;
    private RString サービス種類名;
    private RString サービス項目名;
    private RString 日数回数;
    private RString 公費対象単位数;
    private RString 公費負担金額;
    private RString 公費分本人負担額;
    private HihokenshaNo 登録被保険者番号;
    private RString 宛名名称;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 公費対象単位数集計;
    private RString 公費負担金額集計;
    private RString 公費分本人負担額集計;
}
