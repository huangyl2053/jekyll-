/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodetanimeisaiichiran;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の取得処理MybatisParameterクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiMybatisParameter implements IMyBatisParameter {

    private RString 対象年月;
    private FlexibleYearMonth 開始年月;
    private FlexibleYearMonth 終了年月;
    private RString 被保険者番号;
    private RString 事業者番号;
    private List<RString> 認定結果リスト;
    private List<RString> サービス種類コードリスト;
    private RString サービス項目コード;
    private RString 地区指定;
    private List<RString> 選択地区リスト;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 旧市町村コード;
    private RString 旧市町村名称;
    private RString 導入形態コード;
    private RString サービス種類コード;
    private FlexibleYearMonth サービス提供年月;
    private RString 出力順;
    private RString 種別;

    /**
     * コンストラクタです
     *
     * @param 対象年月 RString
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 被保険者番号 RString
     * @param 事業者番号 RString
     * @param 認定結果リスト List<RString>
     * @param サービス種類コードリスト List<RString>
     * @param サービス項目コード RString
     * @param 地区指定 RString
     * @param 選択地区リスト List<RString>
     * @param 市町村コード RString
     * @param 市町村名称 RString
     * @param 旧市町村コード RString
     * @param 旧市町村名称 RString
     * @param 導入形態コード RString
     * @param 出力順 RString
     */
    public KyufuJissekiMybatisParameter(
            RString 対象年月,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            RString 被保険者番号,
            RString 事業者番号,
            List<RString> 認定結果リスト,
            List<RString> サービス種類コードリスト,
            RString サービス項目コード,
            RString 地区指定,
            List<RString> 選択地区リスト,
            RString 市町村コード,
            RString 市町村名称,
            RString 旧市町村コード,
            RString 旧市町村名称,
            RString 導入形態コード,
            RString 出力順
    ) {
        this.対象年月 = 対象年月;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.被保険者番号 = 被保険者番号;
        this.事業者番号 = 事業者番号;
        this.認定結果リスト = 認定結果リスト;
        this.サービス種類コードリスト = サービス種類コードリスト;
        this.サービス項目コード = サービス項目コード;
        this.地区指定 = 地区指定;
        this.選択地区リスト = 選択地区リスト;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.旧市町村コード = 旧市町村コード;
        this.旧市町村名称 = 旧市町村名称;
        this.導入形態コード = 導入形態コード;
        this.出力順 = 出力順;
    }

    /**
     * コンストラクタです
     *
     * @param 種別 RString
     */
    public KyufuJissekiMybatisParameter(
            RString 種別
    ) {
        this.種別 = 種別;
    }

}
