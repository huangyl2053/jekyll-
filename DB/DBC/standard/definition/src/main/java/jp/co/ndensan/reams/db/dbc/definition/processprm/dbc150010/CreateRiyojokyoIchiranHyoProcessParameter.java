/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 利用状況一覧表作成のProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateRiyojokyoIchiranHyoProcessParameter implements IBatchProcessParameter {

    private RString 対象年月;
    private RString 開始年月;
    private RString 終了年月;
    private RString 被保険者番号;
    private RString 事業者番号;
    private RString 利用実績区分;
    private RString 居宅利用率指定;
    private RString 開始居宅利用率;
    private RString 終了居宅利用率;
    private RString 訪問利用率指定;
    private RString 開始訪問居宅利用率;
    private RString 終了訪問居宅利用率;
    private RString 地区指定;
    private Map<RString, RString> 選択地区リスト;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 旧市町村コード;
    private RString 旧市町村名称;
    private RString 導入形態コード;
    private RString 統計表出力区分;
    private RString 明細リスト出力区分;
    private RString 明細CSV出力区分;
    private RString 明細合計出力区分;
    private RString 項目名付加;
    private RString 連番付加;
    private RString 日付スラッシュ編集;
    private RString 出力順ID;
    private int 更新データ件数;

    /**
     * コンストラクタです。
     *
     * @param 対象年月 対象年月
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月 終了年月
     * @param 被保険者番号 被保険者番号 被保険者番号
     * @param 事業者番号 事業者番号
     * @param 利用実績区分 利用実績区分
     * @param 居宅利用率指定 居宅利用率指定
     * @param 開始居宅利用率 開始居宅利用率
     * @param 終了居宅利用率 終了居宅利用率
     * @param 訪問利用率指定 訪問利用率指定
     * @param 開始訪問居宅利用率 開始訪問居宅利用率
     * @param 終了訪問居宅利用率 終了訪問居宅利用率
     * @param 地区指定 地区指定
     * @param 選択地区リスト 選択地区リスト
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 旧市町村コード 旧市町村コード
     * @param 旧市町村名称 旧市町村名称
     * @param 導入形態コード 導入形態コード
     * @param 統計表出力区分 統計表出力区分
     * @param 明細リスト出力区分 明細リスト出力区分
     * @param 明細CSV出力区分 明細CSV出力区分
     * @param 明細合計出力区分 明細合計出力区分
     * @param 項目名付加 項目名付加
     * @param 連番付加 連番付加
     * @param 日付スラッシュ編集 日付スラッシュ編集
     * @param 出力順ID 出力順ID
     * @param 更新データ件数 更新データ件数
     */
    public CreateRiyojokyoIchiranHyoProcessParameter(RString 対象年月, RString 開始年月, RString 終了年月,
            RString 被保険者番号, RString 事業者番号, RString 利用実績区分, RString 居宅利用率指定, RString 開始居宅利用率,
            RString 終了居宅利用率, RString 訪問利用率指定, RString 開始訪問居宅利用率, RString 終了訪問居宅利用率,
            RString 地区指定, Map<RString, RString> 選択地区リスト, RString 市町村コード, RString 市町村名称,
            RString 旧市町村コード, RString 旧市町村名称, RString 導入形態コード, RString 統計表出力区分,
            RString 明細リスト出力区分, RString 明細CSV出力区分, RString 明細合計出力区分, RString 項目名付加,
            RString 連番付加, RString 日付スラッシュ編集, RString 出力順ID, int 更新データ件数) {

        this.対象年月 = 対象年月;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.被保険者番号 = 被保険者番号;
        this.事業者番号 = 事業者番号;
        this.利用実績区分 = 利用実績区分;
        this.居宅利用率指定 = 居宅利用率指定;
        this.開始居宅利用率 = 開始居宅利用率;
        this.終了居宅利用率 = 終了居宅利用率;
        this.訪問利用率指定 = 訪問利用率指定;
        this.開始訪問居宅利用率 = 開始訪問居宅利用率;
        this.終了訪問居宅利用率 = 終了訪問居宅利用率;
        this.地区指定 = 地区指定;
        this.選択地区リスト = 選択地区リスト;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.旧市町村コード = 旧市町村コード;
        this.旧市町村名称 = 旧市町村名称;
        this.導入形態コード = 導入形態コード;
        this.統計表出力区分 = 統計表出力区分;
        this.明細リスト出力区分 = 明細リスト出力区分;
        this.明細CSV出力区分 = 明細CSV出力区分;
        this.明細合計出力区分 = 明細合計出力区分;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ編集 = 日付スラッシュ編集;
        this.出力順ID = 出力順ID;
        this.更新データ件数 = 更新データ件数;
    }
}
