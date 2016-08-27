/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.nenjiriyoshafutanwariaihantei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年次利用者負担割合判定のMybaticParameter
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenjiRiyoshaFutanwariaiHanteiMybaticParameter implements IMyBatisParameter {

    private final FlexibleDate 基準日;
    private final RString 処理状態;
    private final FlexibleYear 対象年度;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 処理状態 処理状態
     * @param 対象年度 対象年度
     */
    public NenjiRiyoshaFutanwariaiHanteiMybaticParameter(FlexibleDate 基準日, RString 処理状態, FlexibleYear 対象年度) {
        this.基準日 = 基準日;
        this.処理状態 = 処理状態;
        this.対象年度 = 対象年度;
    }

}
