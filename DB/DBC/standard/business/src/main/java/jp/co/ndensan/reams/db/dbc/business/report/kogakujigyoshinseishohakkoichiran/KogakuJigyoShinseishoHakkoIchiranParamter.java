/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表のパラメータクラスです。
 *
 * @reamsid_L DBC-4770-120 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
public class KogakuJigyoShinseishoHakkoIchiranParamter {

    private IOutputOrder 出力順;
    private ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private RDateTime システム日付;
    private RString 連番;
    private RString 市町村名;
}
