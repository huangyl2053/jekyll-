/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）のProcessParameterのクラス
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanJikofutangakuInfoHoseiProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth kakunin_UketoriYM;
    private RDateTime handleTimestamp;
    private RString 改頁出力順ID;
    private RString 開始年月日;
    private RString 開始曜日;
    private RString 開始時間;
    private RString 終了年月日;
    private RString 終了曜日;
    private RString 終了時間;

    /**
     * MybatisParameterを作成する。
     *
     * @return KogakugassanJikofutangakuMybatisParameter
     */
    public KogakugassanJikofutangakuMybatisParameter toKogakugassanJikofutangakuMybatisParameter() {
        KogakugassanJikofutangakuMybatisParameter param = new KogakugassanJikofutangakuMybatisParameter();
        param.set確認情報受取年月(this.kakunin_UketoriYM);
        return param;
    }
}
