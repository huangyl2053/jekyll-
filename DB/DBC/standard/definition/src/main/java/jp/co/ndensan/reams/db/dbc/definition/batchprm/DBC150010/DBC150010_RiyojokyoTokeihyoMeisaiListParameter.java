/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150010;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * [利用状況統計表（明細リスト）作成]のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3500-010 jinjue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC150010_RiyojokyoTokeihyoMeisaiListParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    @BatchParameter(key = "対象年月", name = "対象年月")
    private RString 対象年月;
    @BatchParameter(key = "開始年月", name = "開始年月")
    private RString 開始年月;
    @BatchParameter(key = "終了年月", name = "終了年月")
    private RString 終了年月;
    @BatchParameter(key = "被保険者番号", name = "被保険者番号")
    private RString 被保険者番号;
    @BatchParameter(key = "事業者番号", name = "事業者番号")
    private RString 事業者番号;
    @BatchParameter(key = "利用実績区分", name = "利用実績区分")
    private RString 利用実績区分;
    @BatchParameter(key = "居宅利用率指定", name = "居宅利用率指定")
    private RString 居宅利用率指定;
    @BatchParameter(key = "開始居宅利用率", name = "開始居宅利用率")
    private RString 開始居宅利用率;
    @BatchParameter(key = "終了居宅利用率", name = "終了居宅利用率")
    private RString 終了居宅利用率;
    @BatchParameter(key = "訪問利用率指定", name = "訪問利用率指定")
    private RString 訪問利用率指定;
    @BatchParameter(key = "開始訪問居宅利用率", name = "開始訪問居宅利用率")
    private RString 開始訪問居宅利用率;
    @BatchParameter(key = "終了訪問居宅利用率", name = "終了訪問居宅利用率")
    private RString 終了訪問居宅利用率;
    @BatchParameter(key = "地区指定", name = "地区指定")
    private RString 地区指定;
    @BatchParameter(key = "選択地区リスト", name = "選択地区リスト")
    private Map<RString, RString> 選択地区リスト;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = "市町村名称", name = "市町村名称")
    private RString 市町村名称;
    @BatchParameter(key = "旧市町村コード", name = "旧市町村コード")
    private RString 旧市町村コード;
    @BatchParameter(key = "旧市町村名称", name = "旧市町村名称")
    private RString 旧市町村名称;
    @BatchParameter(key = "導入形態コード", name = "導入形態コード")
    private RString 導入形態コード;
    @BatchParameter(key = "統計表出力区分", name = "統計表出力区分")
    private RString 統計表出力区分;
    @BatchParameter(key = "明細リスト出力区分", name = "明細リスト出力区分")
    private RString 明細リスト出力区分;
    @BatchParameter(key = "明細CSV出力区分", name = "明細CSV出力区分")
    private RString 明細CSV出力区分;
    @BatchParameter(key = "明細合計出力区分", name = "明細合計出力区分")
    private RString 明細合計出力区分;
    @BatchParameter(key = "項目名付加", name = "項目名付加")
    private RString 項目名付加;
    @BatchParameter(key = "連番付加", name = "連番付加")
    private RString 連番付加;
    @BatchParameter(key = "日付スラッシュ編集", name = "日付スラッシュ編集")
    private RString 日付スラッシュ編集;
    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private RString 出力順ID;

    /**
     * コンストラクタです。
     */
    public DBC150010_RiyojokyoTokeihyoMeisaiListParameter() {
    }
}
