/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.keikakutodokedejokyo.KeikakuTodokedeJokyoProcessParam;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 計画届出状況リストバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC160010_KeikakuTodokedeJokyoIchiranParameter extends BatchParameterBase {

    @BatchParameter(key = "jyukyuushinseibiFrom", name = "受給申請日From")
    private FlexibleDate jyukyuushinseibiFrom;
    @BatchParameter(key = "jyukyuushinseibiTo", name = "受給申請日To")
    private FlexibleDate jyukyuushinseibiTo;
    @BatchParameter(key = "taisyoushatyuusyutu", name = "対象者抽出")
    private RString taisyoushatyuusyutu;
    @BatchParameter(key = "todokeidejyoukyou", name = "届出状況")
    private RString todokeidejyoukyou;
    @BatchParameter(key = "kijyunbi", name = "基準日")
    private FlexibleDate kijyunbi;
    @BatchParameter(key = "shutsuryokujunId", name = "出力順ID")
    private Long shutsuryokujunId;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KeikakuTodokedeJokyoProcessParam toProcessParameter() {
        return new KeikakuTodokedeJokyoProcessParam(jyukyuushinseibiFrom,
                jyukyuushinseibiTo,
                taisyoushatyuusyutu,
                todokeidejyoukyou,
                kijyunbi,
                shutsuryokujunId);
    }

}
