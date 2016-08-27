package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiNyushoResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * サービス利用票情報共有子Div用インタフェースクラスです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public interface IServiceRiyohyoInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * サービス利用票情報共有子Div初期化のメソッドです。
     *
     * @param 表示モード RString
     * @param 利用年月 FlexibleYearMonth
     * @param 対象年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 履歴番号 int
     */
    public void initialize(RString 表示モード, FlexibleYearMonth 利用年月, FlexibleYearMonth 対象年月,
            HihokenshaNo 被保険者番号, RString 居宅総合事業区分, int 履歴番号);

    /**
     * 届出日をセットします。
     *
     * @param 届出日 RDate
     */
    public void setTodokedeYMD(RDate 届出日);

    /**
     * 適用期間開始日をセットします。
     *
     * @param 適用期間開始日 RDate
     */
    public void setTekiyoKikanFrom(RDate 適用期間開始日);

    /**
     * 適用期間終日をセットします。
     *
     * @param 適用期間終日 RDate
     */
    public void setTekiyoKikanTo(RDate 適用期間終日);

    /**
     * 暫定区分を取得します。
     *
     * @return boolean
     */
    public boolean isChkZanteiKubunAllSelected();

    /**
     * 送付年月を取得します。
     *
     * @return RDate
     */
    public RDate getSofuYM();

    /**
     * 更新区分を取得します。
     *
     * @return RString
     */
    public RString getKoshinKbn();

    /**
     * 利用年月を取得します。
     *
     * @return RDate
     */
    public RDate getRiyoYM();

    /**
     * DB追加処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param 短期入所情報 TankiNyushoResult
     */
    public void DB追加処理(RString 居宅総合事業区分, TankiNyushoResult 短期入所情報);

    /**
     * DB修正処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param 短期入所情報 TankiNyushoResult
     */
    public void DB修正処理(RString 居宅総合事業区分, TankiNyushoResult 短期入所情報);

    /**
     * データ整合性チェックします。
     *
     * @param サービス利用票情報 List<KyufuJikoSakuseiResult>
     */
    public void データ整合性チェック(List<KyufuJikoSakuseiResult> サービス利用票情報);

    /**
     * 保存処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param サービス利用票情報 List<KyufuJikoSakuseiResult>
     */
    public void init保存処理(RString 居宅総合事業区分, List<KyufuJikoSakuseiResult> サービス利用票情報);

    /**
     * 削除処理メソッドです。
     *
     * @param 居宅総合事業区分 RString
     * @param 短期入所情報 TankiNyushoResult
     */
    public void DB削除処理(RString 居宅総合事業区分, TankiNyushoResult 短期入所情報);

    /**
     * サービス利用票情報取得メソッドです。
     *
     * @return List<KyufuJikoSakuseiResult>
     */
    public List<KyufuJikoSakuseiResult> getサービス利用票情報();

}
