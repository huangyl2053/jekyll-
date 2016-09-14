/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150050;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード単位明細リストのBatchParameterです。
 *
 * @reamsid_L DBC-3330-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC150050_ServicecodeTaniMeisaiIchiranParameter extends BatchParameterBase {

    private static final String KEY_対象年月 = "対象年月";
    private static final String KEY_開始年月 = "開始年月";
    private static final String KEY_終了年月 = "終了年月";
    private static final String KEY_被保険者番号 = "被保険者番号";
    private static final String KEY_事業者番号 = "事業者番号";
    private static final String KEY_認定結果リスト = "認定結果リスト";
    private static final String KEY_サービス種類コードリスト = "サービス種類コードリスト";
    private static final String KEY_サービス項目コード = "サービス項目コード";
    private static final String KEY_地区指定 = "地区指定";
    private static final String KEY_選択地区リスト = "選択地区リスト";
    private static final String KEY_市町村コード = "市町村コード";
    private static final String KEY_市町村名称 = "市町村名称";
    private static final String KEY_旧市町村コード = "旧市町村コード";
    private static final String KEY_旧市町村名称 = "旧市町村名称";
    private static final String KEY_導入形態コード = "導入形態コード";

    @BatchParameter(key = KEY_対象年月, name = "対象年月")
    private RString 対象年月;
    @BatchParameter(key = KEY_開始年月, name = "開始年月")
    private FlexibleYearMonth 開始年月;
    @BatchParameter(key = KEY_終了年月, name = "終了年月")
    private FlexibleYearMonth 終了年月;
    @BatchParameter(key = KEY_被保険者番号, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @BatchParameter(key = KEY_事業者番号, name = "事業者番号")
    private RString 事業者番号;
    @BatchParameter(key = KEY_認定結果リスト, name = "認定結果リスト")
    private List<RString> 認定結果リスト;
    @BatchParameter(key = KEY_サービス種類コードリスト, name = "サービス種類コードリスト")
    private List<ServiceShuruiCode> サービス種類コードリスト;
    @BatchParameter(key = KEY_サービス項目コード, name = "サービス項目コード")
    private RString サービス項目コード;
    @BatchParameter(key = KEY_地区指定, name = "地区指定")
    private RString 地区指定;
    @BatchParameter(key = KEY_選択地区リスト, name = "選択地区リスト")
    private Map<RString, RString> 選択地区リスト;
    @BatchParameter(key = KEY_市町村コード, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = KEY_市町村名称, name = "市町村名称")
    private RString 市町村名称;
    @BatchParameter(key = KEY_旧市町村コード, name = "旧市町村コード")
    private RString 旧市町村コード;
    @BatchParameter(key = KEY_旧市町村名称, name = "旧市町村名称")
    private RString 旧市町村名称;
    @BatchParameter(key = KEY_導入形態コード, name = "導入形態コード")
    private RString 導入形態コード;
}
