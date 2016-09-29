/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表のEntity
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuShomeishoDateEntity {

    private int 被保険者_連番;
    private RString 被保険者_証記載保険者番号;
    private RString 被保険者_被保険者番号;
    private RString 被保険者_サービス提供年月末日;
    private RString 被保険者_被保険者カナ氏名;
    private RString 被保険者_被保険者氏名;
    private RString 被保険者_旧市町村コード;
    private RString 被保険者_変換被保険者番号;
    private RString 被保険者_登録被保険者番号;
    private RString 被保険者_市町村コード;
    private RString 被保険者_管内管外区分;
    private RString 被保険者_郵便番号;
    private RString 被保険者_町域コード;
    private RString 被保険者_行政区コード;
    private RString 被保険者_行政区名;
    private RString 被保険者_住所;
    private RString 被保険者_番地;
    private RString 被保険者_方書;
    private RString 被保険者_宛名カナ名称;
    private RString 被保険者_宛名名称;
    private RString 被保険者_氏名50音カナ;
    private RString 被保険者_識別コード;
    private RString 被保険者_資格取得日;
    private RString 被保険者_資格取得事由コード;
    private RString 被保険者_資格喪失日;
    private RString 被保険者_資格喪失事由コード;
    private RString 被保険者_世帯集約番号;
    private int 高額合算自己負担額_連番;
    private HihokenshaNo 高額合算自己負担額_被保険者番号;
    private FlexibleYear 高額合算自己負担額_対象年度;
    private ShoKisaiHokenshaNo 高額合算自己負担額_保険者番号;
    private RString 高額合算自己負担額_支給申請書整理番号;
    private int 高額合算自己負担額_履歴番号;
    private RString 高額合算自己負担額_保険制度コード;
    private RString 高額合算自己負担額_保険者名;
    private RString 高額合算自己負担額_国保被保険者証記号;
    private AtenaKanaMeisho 高額合算自己負担額_被保険者氏名カナ;
    private AtenaMeisho 高額合算自己負担額_被保険者氏名;
    private FlexibleDate 高額合算自己負担額_生年月日;
    private Code 高額合算自己負担額_性別;
    private RString 高額合算自己負担額_所得区分;
    private RString 高額合算自己負担額_70歳以上の者に係る所得区分;
    private RString 高額合算自己負担額_自己負担額証明書整理番号;
    private RString 高額合算自己負担額_後期保険者番号;
    private RString 高額合算自己負担額_後期被保険者番号;
    private RString 高額合算自己負担額_国保保険者番号;
    private RString 高額合算自己負担額_国保被保険者証番号;
    private RString 高額合算自己負担額_国保個人番号;
    private RString 高額合算自己負担額_異動区分;
    private RString 高額合算自己負担額_補正済自己負担額送付区分;
    private FlexibleDate 高額合算自己負担額_対象計算期間開始年月日;
    private FlexibleDate 高額合算自己負担額_対象計算期間終了年月日;
    private FlexibleDate 高額合算自己負担額_被保険者期間開始年月日;
    private FlexibleDate 高額合算自己負担額_被保険者期間終了年月日;
    private FlexibleDate 高額合算自己負担額_申請年月日;
    private Decimal 高額合算自己負担額_合計_自己負担額;
    private Decimal 高額合算自己負担額_合計_70_74自己負担額_内訳;
    private Decimal 高額合算自己負担額_合計_70未満高額支給額;
    private Decimal 高額合算自己負担額_合計_70_74高額支給額;
    private Decimal 高額合算自己負担額_補正済_合計_自己負担額;
    private Decimal 高額合算自己負担額_補正済_合計_70_74自己負担額_内訳;
    private Decimal 高額合算自己負担額_補正済_合計_70未満高額支給額;
    private Decimal 高額合算自己負担額_補正済_合計_70_74高額支給額;
    private AtenaMeisho 高額合算自己負担額_宛先氏名;
    private YubinNo 高額合算自己負担額_宛先郵便番号;
    private RString 高額合算自己負担額_宛先住所;
    private RString 高額合算自己負担額_窓口払対象者判定コード;
    private RString 高額合算自己負担額_支払場所;
    private FlexibleDate 高額合算自己負担額_支払期間開始年月日;
    private FlexibleDate 高額合算自己負担額_支払期間終了年月日;
    private RString 高額合算自己負担額_閉庁内容;
    private RString 高額合算自己負担額_支払期間開始時間;
    private RString 高額合算自己負担額_支払期間終了時間;
    private RString 高額合算自己負担額_備考;
    private RString 高額合算自己負担額_データ作成区分;
    private FlexibleYearMonth 高額合算自己負担額_自己負担額確認情報受取年月;
    private FlexibleYearMonth 高額合算自己負担額_補正済自己負担額情報送付年月;
    private FlexibleYearMonth 高額合算自己負担額_自己負担額証明書情報受取年月;
    private RString 高額合算自己負担額_再送フラグ;
    private RString 高額合算自己負担額_送付対象外フラグ;
    private FlexibleDate 高額合算自己負担額_自己負担額計算年月日;
    private FlexibleDate 高額合算自己負担額_自己負担額証明書作成年月日;
    private RString 高額合算自己負担額_後期_国保処理区分;
    private RString 高額合算自己負担額_自己負担額証明書リアル発行フラグ;
    private FlexibleDate 高額合算自己負担額_バッチ補正実施年月日;
    private FlexibleDate 高額合算自己負担額_リアル補正実施年月日;
    private Boolean 高額合算自己負担額_更新フラグ;
    private boolean 高額合算自己負担額_自己負担額差異フラグ;

}
