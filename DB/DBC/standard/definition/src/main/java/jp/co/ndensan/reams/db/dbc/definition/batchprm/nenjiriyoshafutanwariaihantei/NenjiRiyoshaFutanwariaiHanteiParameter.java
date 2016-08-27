/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.nenjiriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年次利用者負担割合判定です
 *
 * @reamsid_L DBC-4980-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenjiRiyoshaFutanwariaiHanteiParameter extends BatchParameterBase {

    @BatchParameter(key = "対象年度", name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = "基準日", name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = "処理区分", name = "処理区分")
    private SaiShoriKubun 処理区分;
    @BatchParameter(key = "年度終了年月日", name = "年度終了年月日")
    private FlexibleDate 年度終了年月日;
    @BatchParameter(key = "処理日時", name = "処理日時")
    private RDateTime 処理日時;
    @BatchParameter(key = "テストモード", name = "テストモード")
    private boolean テストモード;
    @BatchParameter(key = "処理状態", name = "処理状態")
    private RString 処理状態;

    /**
     * 年次利用者負担割合判定のProcessParameter作成する。
     *
     * @return NenjiRiyoshaFutanwariaiHanteiProcessParameter
     */
    public NenjiRiyoshaFutanwariaiHanteiProcessParameter toNenjiRiyoshaFutanwariaiHanteiProcessParameter() {
        return new NenjiRiyoshaFutanwariaiHanteiProcessParameter(基準日, 処理状態, 対象年度, new YMDHMS(処理日時));
    }
}
