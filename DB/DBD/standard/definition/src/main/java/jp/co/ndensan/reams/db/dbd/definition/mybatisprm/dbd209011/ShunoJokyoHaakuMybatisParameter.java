/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd209011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 収納状況把握情報の取得SQL用パラメタークラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShunoJokyoHaakuMybatisParameter implements IMyBatisParameter {

    private RString psmShikibetsuTaisho;
    private FlexibleYear 日付関連_調定年度;
    private RString 基準日;
    private RDate 基準日RDATE;

    /**
     * コンストラクタです
     *
     * @param 基準日 基準日
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 日付関連_調定年度 日付関連_調定年度
     */
    public ShunoJokyoHaakuMybatisParameter(FlexibleDate 基準日, FlexibleYear 日付関連_調定年度, RString psmShikibetsuTaisho) {
        if (基準日 != null && !基準日.isEmpty()) {
            this.基準日 = new RString(基準日.toString());
            this.基準日RDATE = new RDate(基準日.toString());
        }
        this.日付関連_調定年度 = 日付関連_調定年度;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;

    }

}
