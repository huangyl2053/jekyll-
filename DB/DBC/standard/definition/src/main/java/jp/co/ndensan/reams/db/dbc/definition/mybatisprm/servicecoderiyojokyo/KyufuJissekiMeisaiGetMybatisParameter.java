/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecoderiyojokyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の取得処理MybatisParameterクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiMeisaiGetMybatisParameter implements IMyBatisParameter {

    private RString 対象年月指定;
    private RString 対象サービス種類;
    private FlexibleYearMonth 年月範囲開始;
    private FlexibleYearMonth 年月範囲終了;
    private RString 市町村コード;
    private RString 旧市町村コード;
    private RString 選択対象;
    private List<RString> 対象コード;
    private RString サービス項目コードのまとめ方;
    private RString 出力順;

    /**
     * コンストラクタです
     *
     * @param 対象年月指定 RString
     * @param 対象サービス種類 RString
     * @param 年月範囲開始 FlexibleYearMonth
     * @param 年月範囲終了 FlexibleYearMonth
     * @param 市町村コード RString
     * @param 旧市町村コード RString
     * @param 選択対象 RString
     * @param 対象コード List<RString>
     * @param サービス項目コードのまとめ方 RString
     * @param 出力順 RString
     */
    public KyufuJissekiMeisaiGetMybatisParameter(
            RString 対象年月指定,
            RString 対象サービス種類,
            FlexibleYearMonth 年月範囲開始,
            FlexibleYearMonth 年月範囲終了,
            RString 市町村コード,
            RString 旧市町村コード,
            RString 選択対象,
            List<RString> 対象コード,
            RString サービス項目コードのまとめ方,
            RString 出力順
    ) {
        this.対象年月指定 = 対象年月指定;
        this.対象サービス種類 = 対象サービス種類;
        this.年月範囲開始 = 年月範囲開始;
        this.年月範囲終了 = 年月範囲終了;
        this.市町村コード = 市町村コード;
        this.旧市町村コード = 旧市町村コード;
        this.選択対象 = 選択対象;
        this.対象コード = 対象コード;
        this.サービス項目コードのまとめ方 = サービス項目コードのまとめ方;
        this.出力順 = 出力順;
    }

    /**
     * コンストラクタです
     *
     * @param 対象サービス種類 RString
     * @param サービス項目コードのまとめ方 RString
     */
    public KyufuJissekiMeisaiGetMybatisParameter(
            RString 対象サービス種類,
            RString サービス項目コードのまとめ方
    ) {
        this.対象サービス種類 = 対象サービス種類;
        this.サービス項目コードのまとめ方 = サービス項目コードのまとめ方;
    }

}
