/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodeichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodeichiran.ServicecodeIchiranMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNJ2006_サービスコード一覧表のProcessParameterのクラス
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIchiranProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 基準年月;
    private RString 抽出条件区分;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス項目コード;
    private List<Code> サービス分類s;
    private RDateTime 処理日時;
    private boolean is帳票で出力;
    private boolean isＣＳＶファイルで出力;
    private RString 表題;
    private boolean is項目名付加;
    private boolean is連番付加;
    private boolean is日付編集;
    private int サービス項目コード桁目;

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link ServicecodeIchiranMybatisParameter}
     */
    public ServicecodeIchiranMybatisParameter toMybatisParameter() {
        ServicecodeIchiranMybatisParameter param = new ServicecodeIchiranMybatisParameter();
        param.set基準年月(基準年月);
        param.setサービス項目コード(サービス項目コード);
        param.setサービス種類コード(サービス種類コード);
        param.setサービス分類s(サービス分類s);
        param.setサービス項目コード桁目(サービス項目コード桁目);
        param.set抽出条件区分(抽出条件区分);
        return param;
    }
}
