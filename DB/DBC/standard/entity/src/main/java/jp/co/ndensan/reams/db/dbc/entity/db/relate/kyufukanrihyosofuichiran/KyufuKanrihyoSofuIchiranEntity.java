/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosofuichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC200009_給付管理票送付一覧表のEntityクラスです。
 *
 * @reamsid_L DBC-2840-041 kanghongsong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuKanrihyoSofuIchiranEntity {

    private RString yubinNo;
    private RString choikiCode;
    private RString gyoseikuCode;
    private RString shimei50onKana;
    private RString shichosonCode;
    private RString hihokenshaNo;
    private RString riyoYM;
    private RString yokaigoJotaiKubunCode;
    private FlexibleYearMonth 処理年月;
    private RDateTime 作成日時;
    private RString 保険者番号;
    private RString 保険者名;
    private Map<RString, RString> 出力順Map;
    private List<RString> 改頁リスト;
    private RString 備考タイトル;
    private FlexibleYearMonth 利用年月;
    private RString 被保険者番号;
    private RString 宛名名称;
    private RString 更新区分;
    private RString 帳票通番カウンター;
    private RString 居宅サービス区分;
    private RString 表示用要介護状態区分コード;
    private Decimal 表示用支給限度単位数;
    private FlexibleYearMonth 限度額管理開始年月日;
    private FlexibleYearMonth 支給限度有効終了年月;
    private RString 指定サービス単位_日数;
    private RString 基準該当サービス単位_日数;
    private Decimal 明細合計単位数;
    private RString 備考;
    private RString 備考_証記載保険者番号;
    private Decimal 合計件数_新規;
    private Decimal 合計件数_修正;
    private Decimal 合計件数_取消;
}
