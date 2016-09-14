/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票出力用一時TBLに更新ProcessParameterクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3470UpdateProcessParameter implements IBatchProcessParameter {

    private RString サービス種類コード;
    private RString ソート用サービス項目コード;
    private RString 要介護状態区分コード;
    private Decimal 日数_回数集計値;
    private Decimal 単位数集計値;
    private int 履歴番号;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyufuJissekiMeisaiGetMybatisParameter toMybatisParam() {
        return new KyufuJissekiMeisaiGetMybatisParameter(
                サービス種類コード,
                ソート用サービス項目コード);
    }

}
