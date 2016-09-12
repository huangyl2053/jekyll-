/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaihanteiichiran.FutanwariaiHanteiIchiranMybaticParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合判定一覧出力（共通）のProcessParameterです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiHanteiIchiranProcessParameter implements IBatchProcessParameter {

    private final RString 処理区分;
    private final FlexibleYear 対象年度;
    private final FlexibleDate 基準日;
    private final boolean テストモード;
    private final RDateTime 処理日時;

    /**
     * コンストラクタです。
     *
     * @param 処理区分 処理区分
     * @param 対象年度 対象年度
     * @param 基準日 基準日
     * @param テストモード テストモード
     * @param 処理日時 処理日時
     */
    public FutanWariaiHanteiIchiranProcessParameter(RString 処理区分, FlexibleYear 対象年度, FlexibleDate 基準日, boolean テストモード,
            RDateTime 処理日時) {
        this.処理区分 = 処理区分;
        this.対象年度 = 対象年度;
        this.基準日 = 基準日;
        this.テストモード = テストモード;
        this.処理日時 = 処理日時;
    }

    /**
     * 負担割合判定一覧出力のMybaticParameter作成する。
     *
     * @return FutanwariaiHanteiIchiranMybaticParameter
     */
    public FutanwariaiHanteiIchiranMybaticParameter toFutanwariaiHanteiIchiranMybaticParameter() {
        return new FutanwariaiHanteiIchiranMybaticParameter(処理区分, 対象年度, テストモード, 基準日);
    }
}
