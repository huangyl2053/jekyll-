/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用一時TBL更新ProcessParameterクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiMeisaiGetProcessParameter implements IBatchProcessParameter {

    private RString 対象年月指定;
    private RString 対象サービス種類;
    private int 連番;
    private FlexibleYearMonth 年月範囲開始;
    private FlexibleYearMonth 年月範囲終了;
    private RString 選択対象;
    private RString 市町村コード;
    private RString 旧市町村コード;
    private RString 旧市町村名;
    private List<RString> 対象コード;
    private RString サービス項目コードのまとめ方;
    private RString 出力順;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyufuJissekiMeisaiGetMybatisParameter toMybatisParam() {
        return new KyufuJissekiMeisaiGetMybatisParameter(
                対象年月指定,
                対象サービス種類,
                年月範囲開始,
                年月範囲終了,
                市町村コード,
                旧市町村コード,
                選択対象,
                対象コード,
                サービス項目コードのまとめ方,
                出力順);
    }
}
