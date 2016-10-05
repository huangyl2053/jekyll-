/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32003.ShunoJokyoHaakuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納状況把握情報の取得_Process処理パラメタークラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJokyoHaakuProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     */
    public ShunoJokyoHaakuProcessParameter(FlexibleDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 日付関連_調定年度 日付関連_調定年度
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmTotalShunyu psmTotalShunyu
     * @return ShunoJokyoHaakuMybatisParameter
     */
    public ShunoJokyoHaakuMybatisParameter toShunoJokyoHaakuMybatisParameter(
            FlexibleDate 基準日,
            FlexibleYear 日付関連_調定年度,
            RString psmShikibetsuTaisho,
            List<RString> psmTotalShunyu) {
        return new ShunoJokyoHaakuMybatisParameter(基準日, 日付関連_調定年度, psmShikibetsuTaisho, psmTotalShunyu);
    }

}
