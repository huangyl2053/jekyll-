/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijunka6gatsuMyBatisParameter implements IMyBatisParameter {

    private boolean 一括発行起動;
    private SubGyomuCode サブ業務コード;
    private GyomuCode 業務コード;
    private FlexibleYear 調定年度minus1;
    private FlexibleYear 調定年度;
    private List<RString> 通知内容コード;
    private RString 更正前後区分;
    private ShikibetsuCode 識別コード;
    private RString 作成処理名;
    private RString 徴収方法;
    private RString 被保険者区分;
    private RString 特別徴収_厚生労働省;
    private RString 特別徴収_地共済;

    /**
     * コンストラクタです。
     *
     * @param 一括発行起動 一括発行起動
     * @param 調定年度 調定年度
     * @param 通知内容コード 通知内容コード
     * @param 更正前後区分 更正前後区分
     * @param 作成処理名 作成処理名
     * @param 徴収方法 徴収方法
     * @param 被保険者区分 被保険者区分
     * @param 特別徴収_厚生労働省 特別徴収_厚生労働省
     * @param 特別徴収_地共済 特別徴収_地共済
     */
    public TokuchoHeijunka6gatsuMyBatisParameter(boolean 一括発行起動,
            FlexibleYear 調定年度, List<RString> 通知内容コード,
            RString 更正前後区分, RString 作成処理名, RString 徴収方法, RString 被保険者区分, RString 特別徴収_厚生労働省,
            RString 特別徴収_地共済) {

        this.サブ業務コード = SubGyomuCode.DBB介護賦課;
        this.業務コード = GyomuCode.DB介護保険;
        this.調定年度 = 調定年度;
        if (調定年度 != null) {
            this.調定年度minus1 = 調定年度.minusYear(1);
        }
        this.通知内容コード = 通知内容コード;
        this.更正前後区分 = 更正前後区分;
        this.作成処理名 = 作成処理名;
        this.一括発行起動 = 一括発行起動;
        this.徴収方法 = 徴収方法;
        this.被保険者区分 = 被保険者区分;
        this.特別徴収_厚生労働省 = 特別徴収_厚生労働省;
        this.特別徴収_地共済 = 特別徴収_地共済;
    }
}
