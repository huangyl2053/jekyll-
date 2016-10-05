/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dankaibetsushunoritsu;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料段階別収納率一時テーブルのmybatisパラメーターです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsDankaibetsuShunoritsuTmpMybatisParamter implements IMyBatisParameter {

    private FlexibleYear 開始調定年度;
    private FlexibleYear 終了調定年度;
    private FlexibleYear 開始賦課年度;
    private FlexibleYear 終了賦課年度;
    private FlexibleYearMonth 基準年月;
    private FlexibleDate 開始生年月日;
    private FlexibleDate 終了生年月日;
    private RString 選択対象区分;
    private RString 広域判定区分;
    private List<RString> 選択対象リスト;

    private RString psmTotalShunyu;

    /**
     * コンストラクタです
     *
     * @param 開始調定年度 開始調定年度
     * @param 終了調定年度 終了調定年度
     * @param 開始賦課年度 開始賦課年度
     * @param 終了賦課年度 終了賦課年度
     * @param 基準年月 基準年月
     * @param 開始生年月日 開始生年月日
     * @param 終了生年月日 終了生年月日
     * @param 広域判定区分 広域判定区分
     * @param 選択対象区分 選択対象区分
     * @param 選択対象リスト 選択対象リスト
     * @param psmTotalShunyu psmTotalShunyu
     */
    public InsDankaibetsuShunoritsuTmpMybatisParamter(FlexibleYear 開始調定年度,
            FlexibleYear 終了調定年度,
            FlexibleYear 開始賦課年度,
            FlexibleYear 終了賦課年度,
            FlexibleYearMonth 基準年月,
            FlexibleDate 開始生年月日,
            FlexibleDate 終了生年月日,
            RString 広域判定区分,
            RString 選択対象区分,
            List<RString> 選択対象リスト,
            RString psmTotalShunyu) {
        this.開始調定年度 = 開始調定年度;
        this.終了調定年度 = 終了調定年度;
        this.開始賦課年度 = 開始賦課年度;
        this.終了賦課年度 = 終了賦課年度;
        this.基準年月 = 基準年月;
        this.開始生年月日 = 開始生年月日;
        this.終了生年月日 = 終了生年月日;
        this.広域判定区分 = 広域判定区分;
        this.選択対象区分 = 選択対象区分;
        this.選択対象リスト = 選択対象リスト;
        this.psmTotalShunyu = psmTotalShunyu;
    }
}
