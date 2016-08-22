/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shinsaketteiseikyumeisaiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費等審査決定請求明細表情報取込一覧表作成パラメータです。
 *
 * @reamsid_L DBC-2500-010 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaKetteiSeiDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private ReportId 帳票ID;
    private RString 出力順ID;
    private RDateTime システム日付;
}
