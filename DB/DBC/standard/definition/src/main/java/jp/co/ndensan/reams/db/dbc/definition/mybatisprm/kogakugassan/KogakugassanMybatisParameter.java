/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassan;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のMybatisパラメータです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth shoriYM;
    private RString saishoriKubun;
    private RString shutsuryokujunId;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param shoriYM 処理年月
     * @param saishoriKubun 再処理区分
     * @param shutsuryokujunId 出力順ID
     */
    public KogakugassanMybatisParameter(FlexibleYearMonth shoriYM,
            RString saishoriKubun,
            RString shutsuryokujunId) {
        this.shoriYM = shoriYM;
        this.saishoriKubun = saishoriKubun;
        this.shutsuryokujunId = shutsuryokujunId;
    }

}
