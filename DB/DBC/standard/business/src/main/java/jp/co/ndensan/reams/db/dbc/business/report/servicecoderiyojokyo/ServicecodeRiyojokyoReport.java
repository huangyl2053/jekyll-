/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecoderiyojokyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecoderiyojokyo.ServicecodeRiyojokyoReportEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * サービスコード別利用状況作成ReportEntityクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeRiyojokyoReport {

    private ServicecodeRiyojokyoReportEntity 明細リスト;
    private RString 条件１;
    private RString 条件２;
    private RString 条件３;
    private HihokenshaNo 保険者番号;
    private RString 保険者名;
    private RString タイトル;
}
