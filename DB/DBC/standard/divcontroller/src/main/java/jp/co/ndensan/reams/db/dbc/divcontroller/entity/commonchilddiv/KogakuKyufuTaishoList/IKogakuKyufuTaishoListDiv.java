package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public interface IKogakuKyufuTaishoListDiv extends ICommonChildDivBaseProperties {

    /**
     * 高額給付対象一覧共有子DivのInterface
     *
     * @param メニューID RString
     * @param 画面モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     */
    public void initialize(RString メニューID, RString 画面モード,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, int 履歴番号);

    /**
     * 明細合計区分を取得します。
     *
     * @return RString
     */
    public RString get明細合計区分();

    /**
     * 事業者コードを取得します。
     *
     * @return RString
     */
    public RString get事業者コード();

    /**
     * 事業者名称を取得します。
     *
     * @return RString
     */
    public RString get事業者名称();

    /**
     * サービス種類を取得します。
     *
     * @return RString
     */
    public RString getサービス種類();

    /**
     * サービス種類名称を取得します。
     *
     * @return RString
     */
    public RString getサービス種類名称();

    /**
     * サービス費用合計を取得します。
     *
     * @return Decimal
     */
    public Decimal getサービス費用合計();

    /**
     * 利用者負担合計を取得します。
     *
     * @return Decimal
     */
    public Decimal get利用者負担合計();

    /**
     * 算定基準額を取得します。
     *
     * @return Decimal
     */
    public Decimal get算定基準額();

    /**
     * 支払済額を取得します。
     *
     * @return Decimal
     */
    public Decimal get支払済額();

    /**
     * 月遅れ区分を取得します。
     *
     * @return RString
     */
    public RString get月遅れ区分();

    /**
     * 世帯所得区分を取得します。
     *
     * @return RString
     */
    public RString get世帯所得区分();

    /**
     * 本人所得区分を取得します。
     *
     * @return RString
     */
    public RString get本人所得区分();

    /**
     * 合算区分を取得します。
     *
     * @return RString
     */
    public RString get合算区分();

    /**
     * 老齢福祉年金を取得します。
     *
     * @return RString
     */
    public RString get老齢福祉年金();

    /**
     * 利用者負担第２段階を取得します。
     *
     * @return RString
     */
    public RString get利用者負担第２段階();

    /**
     * 利用者負担第２段階を取得します。
     *
     * @return RString
     */
    public RString get激変緩和区分();
}
