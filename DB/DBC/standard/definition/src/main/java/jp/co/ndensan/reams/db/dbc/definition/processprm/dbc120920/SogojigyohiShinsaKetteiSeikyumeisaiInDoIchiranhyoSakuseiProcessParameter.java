/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120920;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費審査決定請求明細表情報取込一覧表作成パラメータです。
 *
 * @reamsid_L DBC-2500-012 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShinsaKetteiSeikyumeisaiInDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private ReportId 帳票ID;
    private RString 出力順ID;
    private SubGyomuCode サブ業務コード;
    private RDateTime システム日付;
}
