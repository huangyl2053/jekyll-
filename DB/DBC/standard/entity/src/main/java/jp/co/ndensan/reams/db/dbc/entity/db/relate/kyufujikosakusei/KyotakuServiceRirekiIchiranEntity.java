/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス履歴一覧クラスです。
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceRirekiIchiranEntity implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private FlexibleYearMonth 対象年月;
    private RString 作成区分コード;
    private RString 事業者番号;
    private RString 事業者名;
    private RString 委託先情報者コード;
    private RString 委託先情報者名;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private FlexibleDate 届出日;
    private RDateTime 更新日;
    private int 最大履歴番号;
    private RString 届出区分;
    private RString 氏名;
    private RString カナ;
    private RString 関係区分;
    private RString 電話番号;
    private RString 郵便番号;
    private RString 住所;
    private ServiceShuruiCode サービス種類コード;
    private YubinNo 事業者郵便番号;
    private AtenaJusho 事業者住所;
    private TelNo 事業者電話番号;
    private AtenaMeisho 管理者名;
    private FlexibleDate 事業者変更年月日;
    private RString 事業者変更事由;
    private RString 居宅総合事業区分;
}
