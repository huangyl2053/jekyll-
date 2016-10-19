/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kohijukyushain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費公費受給者別一覧表情報取込のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2800-010 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KohiJukyushaInMybatisParameter implements IMyBatisParameter {

    private final RString 出力順;

    /**
     * コンストラクタです。
     */
    private KohiJukyushaInMybatisParameter(
            RString 出力順) {
        this.出力順 = 出力順;
    }

    /**
     * MybatisParameterの作成です。
     *
     * @param 出力順 出力順
     * @return KohiJukyushaInMybatisParameter
     */
    public static KohiJukyushaInMybatisParameter createMybatisParameter(
            RString 出力順) {
        return new KohiJukyushaInMybatisParameter(出力順);
    }
}
