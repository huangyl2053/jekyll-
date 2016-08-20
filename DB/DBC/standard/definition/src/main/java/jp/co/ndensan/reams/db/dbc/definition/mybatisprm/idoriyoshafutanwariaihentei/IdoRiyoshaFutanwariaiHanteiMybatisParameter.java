/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.idoriyoshafutanwariaihentei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費給付お知らせ通知書作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoRiyoshaFutanwariaiHanteiMybatisParameter implements IMyBatisParameter {

    private final FlexibleYear 対象年度;
    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 対象年度 対象年度
     * @param 処理名 処理名
     */
    public IdoRiyoshaFutanwariaiHanteiMybatisParameter(FlexibleYear 対象年度, RString 処理名) {
        this.対象年度 = 対象年度;
        this.処理名 = 処理名;
    }

}
