/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodeichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNJ2006_サービスコード一覧表のMybatisパラメータクラスです。
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIchiranMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 基準年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス項目コード;
    private List<Code> サービス分類s;
    private RString 抽出条件区分;
    private int サービス項目コード桁目;
}
