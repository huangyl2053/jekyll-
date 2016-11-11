/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(高額介護サービス費状況)Entityクラスです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyouRisutoSyuturyokuEntity {

    private int 区分;
    private HihokenshaNo 被保険者番号key;
    private FlexibleYearMonth サービス提供年月key;
    private Decimal 履歴番号key;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了時間;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 履歴番号;
    private HokenshaNo 証記載保険者番号;
    private FlexibleDate 申請年月日;
    private RString 申請理由;
    private RString 申請者区分;
    private AtenaMeisho 申請者氏名;
    private AtenaKanaMeisho 申請者氏名カナ;
    private TelNo 申請者電話番号;
    private FlexibleDate 受付年月日;
    private RString 支払方法区分コード;
    private Decimal 合計_高額支給額;
    private Decimal サービス費用合計額合計;
    private Decimal 利用者負担額合計;
    private Decimal 算定基準額;
    private Decimal 支払済金額合計;
    private FlexibleYearMonth 対象者受取年月;
    private FlexibleYearMonth 対象者判定審査年月;
    private boolean 自動償還対象フラグ;
    private FlexibleDate 決定年月日;
    private Decimal 本人支払額;
    private RString 判定_支給区分コード;
    private Decimal 支給金額;
    private RString 不支給理由;
    private RString 審査方法区分;
    private FlexibleYearMonth 判定結果送付年月;
    private FlexibleDate 決定通知書作成年月日;
    private FlexibleDate 振込通知書作成年月日;
    private RString 通知書番号;
    private Decimal 利用者負担額;
    private RString 決定_支給区分コード;
    private FlexibleYearMonth 決定年月;
    private Decimal 決定_高額支給額;
    private FlexibleYearMonth 決定者受取年月;
    private RString 高額給付根拠;

    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private KozaRelateEntity 口座情報;

    private LasdecCode 市町村コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 被保険者区分コード;
    private HihokenshaNo 被保険者番号;
    private boolean 住所地特例フラグ;
    private boolean 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private LasdecCode 被保険者市町村コード;

    private JigyoshaNo 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private RString 入所施設種類;

    private AtenaMeisho 事業者名称_60;
    private AtenaKanaMeisho 事業者名称カナ_60;
    private YubinNo 郵便番号_60;
    private AtenaJusho 事業者住所_60;
    private TelNo 電話番号_60;
    private TelNo fax番号_60;
    private Decimal 所属人数_60;
    private Decimal 利用者数_60;
    private FlexibleDate 有効開始日_60;
    private FlexibleDate 有効終了日_60;
    private RString サービス実施地域_60;
    private AtenaMeisho 代表者名_62;
    private AtenaKanaMeisho 代表者名カナ_62;
    private RString 代表者役職名_62;

    private AtenaMeisho 事業者名称_05;
    private AtenaKanaMeisho 事業者名称カナ_05;
    private YubinNo 郵便番号_05;
    private AtenaJusho 事業者住所_05;
    private TelNo 電話番号_05;
    private TelNo fax番号_05;
    private Decimal 所属人数;
    private Decimal 利用者数;
    private FlexibleDate 有効開始日_05;
    private FlexibleDate 有効終了日_05;
    private AtenaMeisho 代表者名_05;
    private AtenaKanaMeisho 代表者名カナ_05;
    private RString 役職_05;

    private Code 受給申請事由;
    private FlexibleDate 受給申請年月日;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始日;
    private FlexibleDate 認定有効期間終了日;
    private FlexibleDate 受給認定日;
    private RString 旧措置フラグ;
    private Code みなし要介護区分コード;
    private Code 直近異動事由コード;

}
