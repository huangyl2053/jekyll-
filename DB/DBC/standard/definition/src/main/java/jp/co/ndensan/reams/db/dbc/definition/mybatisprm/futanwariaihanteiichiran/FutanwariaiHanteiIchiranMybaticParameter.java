/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaihanteiichiran;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合判定一覧出力（共通）のMybaticParameter
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanwariaiHanteiIchiranMybaticParameter implements IMyBatisParameter {

    private final RString 処理区分;
    private final FlexibleYear 対象年度;
    private final FlexibleDate 基準日;
    private final boolean テストモード;
    private FlexibleDate 現年度開始日;
    private FlexibleDate 現年度終了日;
    private FlexibleYear 来年度;
    private FlexibleYear 先年度;
    private final RString 八月一日 = new RString("0801");
    private final RString 七月三十一日 = new RString("0731");

    /**
     * コンストラクタです。
     *
     * @param 処理区分 処理区分
     * @param 対象年度 対象年度
     * @param テストモード テストモード
     * @param 基準日 基準日
     */
    public FutanwariaiHanteiIchiranMybaticParameter(RString 処理区分, FlexibleYear 対象年度, boolean テストモード, FlexibleDate 基準日) {
        this.処理区分 = 処理区分;
        this.対象年度 = 対象年度;
        this.基準日 = 基準日;
        this.テストモード = テストモード;
        if (!対象年度.isEmpty()) {
            来年度 = 対象年度.plusYear(1);
            先年度 = 対象年度.minusYear(1);
            現年度開始日 = new FlexibleDate(対象年度.toDateString().concat(八月一日));
            現年度終了日 = new FlexibleDate(対象年度.plusYear(1).toDateString().concat(七月三十一日));
        }
    }
}
