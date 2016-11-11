/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護対象者抽出（遡及分）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-5750-050 houtianpeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakukaigotaishoshachushutsusokyubunParameter extends ShikibetsuTaishoIdoSearchKey implements IMyBatisParameter {

    private final RDateTime 抽出期間開始日時;
    private final RString 出力順ID;
    private final RDateTime 抽出期間終了日時;
    private final FlexibleYearMonth 開始年月;
    private final FlexibleYearMonth 終了年月;
    private final RString 宛名識別対象PSM;
    private final RString 介護保険;
    private final FlexibleYearMonth 処理年月;
    private final RString 地方公共団体コード;
    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 抽出期間開始日時 YMDHMS
     * @param 抽出期間終了日時 YMDHMS
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 宛名識別対象PSM RString
     * @param 介護保険 RString
     * @param 処理年月 FlexibleYearMonth
     * @param 出力順ID RString
     * @param 地方公共団体コード RString
     * @param 処理名 RString
     * @param key ShikibetsuTaishoIdoSearchKey
     */
    public KogakukaigotaishoshachushutsusokyubunParameter(
            RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            RString 宛名識別対象PSM,
            RString 介護保険,
            FlexibleYearMonth 処理年月,
            RString 出力順ID,
            RString 地方公共団体コード,
            RString 処理名,
            ShikibetsuTaishoIdoSearchKey key) {
        super(key.get抽出区分(),
                key.get抽出開始日時(),
                key.get抽出終了日時(),
                key.use個人のみ取得区分(),
                key.get住基異動事由コードList(),
                key.get住登外異動事由コードList(),
                key.get生年月日開始(),
                key.get生年月日終了(),
                key.get住民種別リスト(),
                key.get住民状態リスト(),
                key.get町域コード開始値(),
                key.get町域コード終了値(),
                key.get全国住所コード開始値(),
                key.get全国住所コード終了値(),
                key.get行政区コード開始値(),
                key.get行政区コード終了値(),
                key.get地区コード1開始値(),
                key.get地区コード1終了値(),
                key.get地区コード2開始値(),
                key.get地区コード2終了値(),
                key.get地区コード3開始値(),
                key.get地区コード3終了値(),
                key.get識別コード開始値(),
                key.get識別コード終了値(),
                key.get世帯コード開始値(),
                key.get世帯コード終了値());
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.宛名識別対象PSM = 宛名識別対象PSM;
        this.介護保険 = 介護保険;
        this.処理年月 = 処理年月;
        this.出力順ID = 出力順ID;
        this.地方公共団体コード = 地方公共団体コード;
        this.処理名 = 処理名;
    }

    /**
     * 識別コード検索用のパラメータを生成します。
     *
     * @param 抽出期間開始日時 RDateTime
     * @param 抽出期間終了日時 RDateTime
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 宛名識別対象PSM RString
     * @param 介護保険 RString
     * @param 処理年月 FlexibleYearMonth
     * @param 出力順ID Long
     * @param 地方公共団体コード RString
     * @param 処理名 RString
     * @param 宛名識別対象異動分取得PSM ShikibetsuTaishoIdoSearchKey
     * @return KogakukaigotaishoshachushutsusokyubunParameter
     */
    public KogakukaigotaishoshachushutsusokyubunParameter createParam(
            RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            RString 宛名識別対象PSM,
            RString 介護保険,
            FlexibleYearMonth 処理年月,
            RString 出力順ID,
            RString 地方公共団体コード,
            RString 処理名,
            ShikibetsuTaishoIdoSearchKey 宛名識別対象異動分取得PSM) {
        return new KogakukaigotaishoshachushutsusokyubunParameter(
                抽出期間開始日時,
                抽出期間終了日時,
                開始年月,
                終了年月,
                宛名識別対象PSM,
                介護保険,
                処理年月,
                出力順ID,
                地方公共団体コード,
                処理名,
                宛名識別対象異動分取得PSM);
    }
}
