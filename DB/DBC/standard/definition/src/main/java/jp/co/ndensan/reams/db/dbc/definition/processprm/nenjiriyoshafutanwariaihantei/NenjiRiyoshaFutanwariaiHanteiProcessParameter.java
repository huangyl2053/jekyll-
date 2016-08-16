/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiMybaticParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年次利用者負担割合判定のProcessParameter
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenjiRiyoshaFutanwariaiHanteiProcessParameter implements IBatchProcessParameter {

    private final FlexibleDate 基準日;
    private final RString 処理状態;
    private final FlexibleYear 対象年度;
    private final YMDHMS 処理日時;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 処理状態 処理状態
     * @param 対象年度 対象年度
     * @param 処理日時 処理日時
     */
    public NenjiRiyoshaFutanwariaiHanteiProcessParameter(FlexibleDate 基準日, RString 処理状態, FlexibleYear 対象年度, YMDHMS 処理日時) {
        this.処理状態 = 処理状態;
        this.基準日 = 基準日;
        this.対象年度 = 対象年度;
        this.処理日時 = 処理日時;
    }

    /**
     * 年次利用者負担割合判定のMybaticParameter作成する。
     *
     * @return NenjiRiyoshaFutanwariaiHanteiMybaticParameter
     */
    public NenjiRiyoshaFutanwariaiHanteiMybaticParameter toNenjiRiyoshaFutanwariaiHanteiMybaticParameter() {
        return new NenjiRiyoshaFutanwariaiHanteiMybaticParameter(基準日, 処理状態, 対象年度);
    }

}
