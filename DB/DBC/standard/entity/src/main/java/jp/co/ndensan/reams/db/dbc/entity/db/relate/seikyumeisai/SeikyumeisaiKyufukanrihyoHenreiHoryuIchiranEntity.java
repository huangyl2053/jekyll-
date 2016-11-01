/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyumeisai;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 請求明細・給付管理票返戻（保留）一覧表のEntityです。
 *
 * @reamsid_L DBC-2830-030 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity {

    private RString 審査年月;
    private RString 国保連合会名;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 事業者番号;
    private RString 事業者名;
    private RString 登録被保険者番号;
    private RString 宛名名称;
    private RString 種別;
    private RString サービス提供年月;
    private RString サービス種類コード;
    private RString サービス項目コード等;
    private Decimal 単位数;
    private RString 事由;
    private RString 内容;
    private RString 備考;
    private RString 被保険者番号;
    private RString 識別コード;
    private RString 被保険者氏名;
    private RDateTime 作成日時;
}
