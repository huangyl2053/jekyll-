/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 健康かるて連携データ作成のMybatisParameterです。
 *
 * @reamsid_L DBC-5020-040 zhaoyao
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KenkouKaruteRenkeiDataMybatisParameter implements IMyBatisParameter {

    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    protected KenkouKaruteRenkeiDataMybatisParameter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 健康かるて連携データ作成のMybatisParamete作成。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return KenkouKaruteRenkeiDataMybatisParameter
     */
    public static KenkouKaruteRenkeiDataMybatisParameter creatMybatisParameter(RString psmShikibetsuTaisho) {
        return new KenkouKaruteRenkeiDataMybatisParameter(psmShikibetsuTaisho);
    }
}
