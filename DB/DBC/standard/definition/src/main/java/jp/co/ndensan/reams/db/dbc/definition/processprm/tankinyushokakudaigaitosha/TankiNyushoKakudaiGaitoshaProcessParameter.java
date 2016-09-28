/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.tankinyushokakudaigaitosha;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_短期入所拡大該当者のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TankiNyushoKakudaiGaitoshaProcessParameter implements IBatchProcessParameter {

    private final RString 帳票ID;
    private final long 出力順ID;
    private final RString 出力順項目ID;
    private final boolean is項目名付加;
    private final boolean is連番付加;
    private final boolean is日付編集;
    private final RString 保険者コード;
    private final RString 抽出区分;
    private final RString 適用開始年月From;
    private final RString 適用開始年月To;
    private final RString 適用終了年月From;
    private final RString 適用終了年月To;
    private final RString 限度額管理期間数;

    /**
     * コンストラクタです。
     *
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @param 出力順項目ID 出力順項目ID
     * @param is項目名付加 is項目名付加
     * @param is連番付加 is連番付加
     * @param is日付編集 is日付編集
     * @param 保険者コード 保険者コード
     * @param 抽出区分 適用開始年月From
     * @param 適用開始年月From 適用開始年月From
     * @param 適用開始年月To 適用開始年月To
     * @param 適用終了年月From 適用終了年月From
     * @param 適用終了年月To 適用終了年月To
     * @param 限度額管理期間数 限度額管理期間数
     */
    public TankiNyushoKakudaiGaitoshaProcessParameter(RString 帳票ID,
            long 出力順ID,
            RString 出力順項目ID,
            boolean is項目名付加,
            boolean is連番付加,
            boolean is日付編集,
            RString 保険者コード,
            RString 抽出区分,
            RString 適用開始年月From,
            RString 適用開始年月To,
            RString 適用終了年月From,
            RString 適用終了年月To,
            RString 限度額管理期間数) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.出力順項目ID = 出力順項目ID;
        this.is項目名付加 = is項目名付加;
        this.is連番付加 = is連番付加;
        this.is日付編集 = is日付編集;
        this.保険者コード = 保険者コード;
        this.抽出区分 = 抽出区分;
        this.適用開始年月From = 適用開始年月From;
        this.適用開始年月To = 適用開始年月To;
        this.適用終了年月From = 適用終了年月From;
        this.適用終了年月To = 適用終了年月To;
        this.限度額管理期間数 = 限度額管理期間数;
    }
}
