/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200025;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025.ShokanRenrakuhyoSofuIchiranEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200025_償還連絡票送付一覧表帳票のパラメータです。
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanRenrakuhyoSofuIchiranParameter {

    private ShokanRenrakuhyoSofuIchiranEntity 償還連絡票一覧表データ;
    private RDateTime 作成日時;
    private RString 帳票タイトル;
    private FlexibleYearMonth 処理年月;
    private Map<RString, RString> 出力順Map;

}
