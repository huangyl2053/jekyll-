/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-3080-030 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufujissekiDaichoSyutuMybatisParameter implements IMyBatisParameter {

    private final RString 出力順;

    /**
     * コンストラクタ
     *
     * @param 出力順 出力順
     */
    protected JukyushaKyufujissekiDaichoSyutuMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 出力順 出力順
     * @return JukyushaKyufujissekiDaichoSyutuMybatisParameter
     */
    public static JukyushaKyufujissekiDaichoSyutuMybatisParameter createParam(RString 出力順) {
        return new JukyushaKyufujissekiDaichoSyutuMybatisParameter(出力順);
    }

}
