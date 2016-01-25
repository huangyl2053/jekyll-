/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 基本情報登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKihonParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 提供購入年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 証明書コード;
    private final RString 明細番号;
    private final RString 旧措置入所者特例コード;
    private final RString 計画作成区分;
    private final FlexibleDate サービス期間FROM;
    private final FlexibleDate サービス期間TO;
    private final RString 中止理由入所院前の状況;
    private final FlexibleDate 入所院年月日;
    private final FlexibleDate 退所院年月日;
    private final Decimal 入所院実日数;
    private final Decimal 外泊日数;
    private final RString 退所院後の状態コード;
    private final HokenKyufuRitsu 給付率;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 旧措置入所者特例コード
     * @param 計画作成区分
     * @param サービス期間FROM
     * @param サービス期間TO
     * @param 中止理由入所院前の状況
     * @param 入所院年月日
     * @param 退所院年月日
     * @param 入所院実日数
     * @param 外泊日数
     * @param 退所院後の状態コード
     * @param 給付率
     */
    protected ShokanKihonParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth 提供購入年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 証明書コード, RString 明細番号, RString 旧措置入所者特例コード,
            RString 計画作成区分, FlexibleDate サービス期間FROM, FlexibleDate サービス期間TO,
            RString 中止理由入所院前の状況, FlexibleDate 入所院年月日, FlexibleDate 退所院年月日,
            Decimal 入所院実日数, Decimal 外泊日数, RString 退所院後の状態コード, HokenKyufuRitsu 給付率) {
        this.被保険者番号 = 被保険者番号;
        this.提供購入年月 = 提供購入年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.証明書コード = 証明書コード;
        this.明細番号 = 明細番号;
        this.旧措置入所者特例コード = 旧措置入所者特例コード;
        this.計画作成区分 = 計画作成区分;
        this.サービス期間FROM = サービス期間FROM;
        this.サービス期間TO = サービス期間TO;
        this.中止理由入所院前の状況 = 中止理由入所院前の状況;
        this.入所院年月日 = 入所院年月日;
        this.退所院年月日 = 退所院年月日;
        this.入所院実日数 = 入所院実日数;
        this.外泊日数 = 外泊日数;
        this.退所院後の状態コード = 退所院後の状態コード;
        this.給付率 = 給付率;

    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param 提供購入年月
     * @param 整理番号
     * @param 事業者番号
     * @param 証明書コード
     * @param 明細番号
     * @param 旧措置入所者特例コード
     * @param 計画作成区分
     * @param サービス期間FROM
     * @param サービス期間TO
     * @param 中止理由入所院前の状況
     * @param 入所院年月日
     * @param 退所院年月日
     * @param 入所院実日数
     * @param 外泊日数
     * @param 退所院後の状態コード
     * @param 給付率
     * @return
     */
    public static ShokanKihonParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 提供購入年月, RString 整理番号, JigyoshaNo 事業者番号, RString 証明書コード,
            RString 明細番号, RString 旧措置入所者特例コード, RString 計画作成区分, FlexibleDate サービス期間FROM,
            FlexibleDate サービス期間TO, RString 中止理由入所院前の状況,
            FlexibleDate 入所院年月日, FlexibleDate 退所院年月日, Decimal 入所院実日数, Decimal 外泊日数,
            RString 退所院後の状態コード, HokenKyufuRitsu 給付率) {
        return new ShokanKihonParameter(被保険者番号, 提供購入年月, 整理番号, 事業者番号, 証明書コード,
                明細番号, 旧措置入所者特例コード, 計画作成区分, サービス期間FROM, サービス期間TO,
                中止理由入所院前の状況, 入所院年月日, 退所院年月日,
                入所院実日数, 外泊日数, 退所院後の状態コード, 給付率);
    }
}
