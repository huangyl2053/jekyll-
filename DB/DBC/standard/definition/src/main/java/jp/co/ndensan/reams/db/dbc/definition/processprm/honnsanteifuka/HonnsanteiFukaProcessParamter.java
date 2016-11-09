/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.honnsanteifuka;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.honnsanteifuka.HonnsanteiFukaMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 共同処理用受給者異動のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-2770-060 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HonnsanteiFukaProcessParamter implements IBatchProcessParameter {

    private final RString 処理対象年月;
    private final RString 再処理区分;
    private final RString 合併区分;

    /**
     * コンストラクタです。
     *
     * @param 処理対象年月 処理対象年月
     * @param 再処理区分 再処理区分
     * @param 合併区分 合併区分
     */
    public HonnsanteiFukaProcessParamter(RString 処理対象年月, RString 再処理区分, RString 合併区分) {
        this.処理対象年月 = 処理対象年月;
        this.再処理区分 = 再処理区分;
        this.合併区分 = 合併区分;
    }

    /**
     * 送付データ作成処理mybatisのパラメータを生成します。
     *
     * @return HonnsanteiFukaMybatisParamter
     */
    public HonnsanteiFukaMybatisParamter toSofuDataMybitisParamter() {
        return HonnsanteiFukaMybatisParamter.createSofuDataParam(処理対象年月, 再処理区分);
    }

    /**
     * 処理対象年月mybatisのパラメータを生成します。
     *
     * @return 処理対象年月
     */
    public RString toSyoriMybitisParamter() {
        return 処理対象年月;
    }
}
