/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodetanimeisaiichiran.KyufuJissekiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績情報の取得処理ProcessParameterクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiProcessParameter implements IBatchProcessParameter {

    private static final RString スペース = new RString(" ");
    private static final RString 横線 = new RString("_");
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
    private int 連番;
    private RString 出力順;
    private SubGyomuCode サブ業務コード;
    private ReportId 帳票ID;
    private Long 出力順ID;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyufuJissekiMybatisParameter toMybatisParam() {
        return new KyufuJissekiMybatisParameter(
                対象年月,
                開始年月,
                終了年月,
                被保険者番号,
                事業者番号,
                認定結果リスト,
                サービス種類コードリスト,
                サービス項目コード,
                地区指定,
                選択地区リスト,
                市町村コード,
                市町村名称,
                旧市町村コード,
                旧市町村名称,
                導入形態コード,
                出力順
        );
    }

    /**
     * 帳票出力用一時TBLに登録Process用mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyufuJissekiMybatisParameter toMybatisParam_帳票出力用() {
        サービス項目コード = サービス項目コード.replace(スペース, 横線);
        return new KyufuJissekiMybatisParameter(
                対象年月,
                開始年月,
                終了年月,
                被保険者番号,
                事業者番号,
                認定結果リスト,
                サービス種類コードリスト,
                サービス項目コード.replace(スペース, 横線),
                地区指定,
                選択地区リスト,
                市町村コード,
                市町村名称,
                旧市町村コード,
                旧市町村名称,
                導入形態コード,
                出力順
        );
    }
}
