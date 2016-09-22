package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
 */
public interface IServiceTypeInputCommonChildDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを初期化します。
     */
    void initialize();

    /**
     * この共有子Divを初期化します。
     *
     * @param serviceTypeCode サービス種類コード
     */
    void initialize(RString serviceTypeCode);

    /**
     * この共有子Divを初期化します。
     *
     * @param 基準年月 基準年月
     * @param サービス種類リスト サービス種類リスト
     * @param サービス分類リスト サービス分類リスト
     * @param 抽出パターン 抽出パターン
     */
    void initialize(FlexibleYearMonth 基準年月, List<RString> サービス種類リスト, List<RString> サービス分類リスト, RString 抽出パターン);

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    void clear();

    /**
     * サービス種類コードを取得します。
     *
     * @return RString
     */
    RString getサービス種類コード();

    /**
     *
     * サービス種類名称を取得します。
     *
     * @return RString
     */
    RString getサービス種類名称();

    /**
     *
     * サービス種類略称を取得します。
     *
     * @return RString
     */
    RString getサービス種類略称();
}
