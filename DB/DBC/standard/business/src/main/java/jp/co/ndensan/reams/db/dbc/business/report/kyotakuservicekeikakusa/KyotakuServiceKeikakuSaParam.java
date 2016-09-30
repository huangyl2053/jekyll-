/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計画届出状況情報クラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceKeikakuSaParam {

    private KyotakuServiceKeikakuSaList 計画届出状況情報リスト;
    private RDateTime システム日時;
    private RString 申請日;
    private RString 対象者;
    private RString 届出状況;
    private FlexibleDate 基準日;
    private Association 地方公共団体;
    private IOutputOrder 出力順;
    private int 連番;

}
