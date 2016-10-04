/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassan;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassan.KogakugassanMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算補正済自己負担額情報作成のProcessパラメータです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth shoriYM;
    private RString saishoriKubun;
    private RString shutsuryokujunId;
    private YMDHMS now;
    private RString shoriKunbun;
    private RString 保険者情報_保険者番号;
    private RString 保険者情報_保険者名称;

    /**
     * コンストラクタです。
     *
     * @param shoriYM 処理年月
     * @param saishoriKubun 再処理区分
     * @param shutsuryokujunId 出力順ID
     * @param now YMDHMS
     * @param shoriKunbun 処理区分
     */
    public KogakugassanProcessParameter(FlexibleYearMonth shoriYM,
            RString saishoriKubun,
            RString shutsuryokujunId,
            YMDHMS now,
            RString shoriKunbun) {
        this.shoriYM = shoriYM;
        this.saishoriKubun = saishoriKubun;
        this.shutsuryokujunId = shutsuryokujunId;
        this.now = now;
        this.shoriKunbun = shoriKunbun;
    }

    /**
     * MybatisParameterを作成する。
     *
     * @return KogakugassanMybatisParameter
     */
    public KogakugassanMybatisParameter toKogakugassanMybatisParameter() {
        return new KogakugassanMybatisParameter(shoriYM, saishoriKubun, shutsuryokujunId, shoriKunbun);
    }

}
