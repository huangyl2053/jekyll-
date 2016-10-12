/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス1SQL検索結果の収納情報クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoEntity {
//賦課

    private FlexibleYear 賦課_調定年度;
    private FlexibleYear 賦課_賦課年度;
    private TsuchishoNo 賦課_通知書番号;
    private int 賦課_履歴番号;
    private HihokenshaNo 賦課_被保険者番号;
    private ShikibetsuCode 賦課_識別コード;
    private SetaiCode 賦課_世帯コード;
    private int 賦課_世帯員数;
    private FlexibleDate 賦課_資格取得日;
    private RString 賦課_資格取得事由;
    private FlexibleDate 賦課_資格喪失日;
    private RString 賦課_資格喪失事由;
    private RString 賦課_生活保護扶助種類;
    private FlexibleDate 賦課_生保開始日;
    private FlexibleDate 賦課_生保廃止日;
    private FlexibleDate 賦課_老年開始日;
    private FlexibleDate 賦課_老年廃止日;
    private FlexibleDate 賦課_賦課期日;
    private RString 賦課_課税区分;
    private RString 賦課_世帯課税区分;
    private Decimal 賦課_合計所得金額;
    private Decimal 賦課_公的年金収入額;
    private RString 賦課_保険料段階;
    private RString 賦課_保険料算定段階1;
    private Decimal 賦課_算定年額保険料1;
    private FlexibleYearMonth 賦課_月割開始年月1;
    private FlexibleYearMonth 賦課_月割終了年月1;
    private RString 賦課_保険料算定段階2;
    private Decimal 賦課_算定年額保険料2;
    private FlexibleYearMonth 賦課_月割開始年月2;
    private FlexibleYearMonth 賦課_月割終了年月2;
    private YMDHMS 賦課_調定日時;
    private RString 賦課_調定事由1;
    private RString 賦課_調定事由2;
    private RString 賦課_調定事由3;
    private RString 賦課_調定事由4;
    private RString 賦課_更正月;
    private Decimal 賦課_減免前介護保険料_年額;
    private Decimal 賦課_減免額;
    private Decimal 賦課_確定介護保険料年額;
    private RString 賦課_保険料段階_仮算定時;
    private int 賦課_徴収方法履歴番号;
    private YMDHMS 賦課_異動基準日時;
    private RString 賦課_口座区分;
    private RString 賦課_境界層区分;
    private RString 賦課_職権区分;
    private LasdecCode 賦課_賦課市町村コード;
    private Decimal 賦課_特徴歳出還付額;
    private Decimal 賦課_普徴歳出還付額;

    //介護期別
    private FlexibleYear 介護期別_調定年度;
    private FlexibleYear 介護期別_賦課年度;
    private TsuchishoNo 介護期別_通知書番号;
    private int 介護期別_履歴番号;
    private RString 介護期別_徴収方法;
    private int 介護期別_期;
    private Decimal 介護期別_調定ID;

    //調定共通_介護継承
    private Long 調定共通_介護継承_調定ID;
    private int 調定共通_介護継承_履歴番号;
    private Long 調定共通_介護継承_収納ID;
    private RYear 調定共通_介護継承_会計年度;
    private RYear 調定共通_介護継承_処理年度;
    private int 調定共通_介護継承_処理番号;
    private int 調定共通_介護継承_更正回数;
    private RString 調定共通_介護継承_調定事由コード;
    private RDate 調定共通_介護継承_調定年月日;
    private Decimal 調定共通_介護継承_調定額;
    private Decimal 調定共通_介護継承_消費税額;
    private RDate 調定共通_介護継承_納期限;
    private RDate 調定共通_介護継承_法定納期限等;
    private boolean 調定共通_介護継承_賦課処理状況;

    //時効
    private ShoKisaiHokenshaNo 時効_証記載保険者番号;
    private HihokenshaNo 時効_被保険者番号;
    private RYear 時効_調定年度;
    private RYear 時効_賦課年度;
    private RString 時効_特徴_普徴区分;
    private TsuchishoNo 時効_通知書番号;
    private RString 時効_収納期_月;
    private int 時効_履歴番号;
    private FlexibleDate 時効_時効起算年月日;
    private RString 時効_時効起算日区分;
    private boolean 時効_論理削除フラグ;

    private List<ShunyuJohoEntity> 収入情報リスト;

    //督促状発行履歴
    private RString 督促状発行履歴_収納ID;
    private FlexibleDate 督促状発行履歴_督促状発行年月日;
}
