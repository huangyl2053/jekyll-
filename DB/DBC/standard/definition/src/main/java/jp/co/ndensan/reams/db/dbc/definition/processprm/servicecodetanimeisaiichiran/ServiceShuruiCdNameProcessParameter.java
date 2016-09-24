/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodetanimeisaiichiran.KyufuJissekiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績情報の取得処理ProcessParameterクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceShuruiCdNameProcessParameter implements IBatchProcessParameter {

    private RString 種別;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyufuJissekiMybatisParameter toMybatisParam() {
        return new KyufuJissekiMybatisParameter(
                種別
        );
    }
}
