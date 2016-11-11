/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）の処理
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoTaishoProcessParameter implements IBatchProcessParameter {

    private RString 年度;
    private final FlexibleYearMonth 処理年月日;
    private RString 処理日時;
    private final RDateTime 抽出期間開始日時;
    private final RDateTime 抽出期間終了日時;
    private RString 帳票ID;
    private final Long 出力順ID;
    private final FlexibleYearMonth 開始年月日１;
    private final FlexibleYearMonth 終了年月日１;
    private RString 開始年月日２;
    private RString 終了年月日２;
    private boolean テスト出力;
    private RString 宛名識別対象PSM;
    private RString 介護保険;
    private FlexibleYearMonth 処理年月;
    private ShikibetsuTaishoIdoSearchKey 宛名識別対象異動分取得PSM;
    private RString 地方公共団体コード;
    private RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 処理年月日 FlexibleYearMonth
     * @param 出力順ID RString
     * @param 抽出期間開始日時 RDateTime
     * @param 開始年月日１ FlexibleYearMonth
     * @param 終了年月日１ FlexibleYearMonth
     * @param テスト出力 RString
     * @param 抽出期間終了日時 RDateTime
     */
    public KogakuKaigoTaishoProcessParameter(
            FlexibleYearMonth 処理年月日,
            RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時,
            Long 出力順ID,
            FlexibleYearMonth 開始年月日１,
            FlexibleYearMonth 終了年月日１,
            boolean テスト出力) {
        this.処理年月日 = 処理年月日;
        this.出力順ID = 出力順ID;
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.開始年月日１ = 開始年月日１;
        this.終了年月日１ = 終了年月日１;
        this.テスト出力 = テスト出力;
    }
}
