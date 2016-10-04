/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosofujohorenkei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 特徴送付情報連携のMybitisParameterクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoSofuJohoRenkeiMybitisParameter implements IMyBatisParameter {

    private FlexibleYear 処理年度;
    private RYearMonth 処理対象年月;
    private List<RString> 市町村コードリスト;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 処理年度
     * @param 処理対象年月 処理対象年月
     * @param 市町村コードリスト 市町村コードリスト
     */
    public TokuchoSofuJohoRenkeiMybitisParameter(FlexibleYear 処理年度, RYearMonth 処理対象年月, List<RString> 市町村コードリスト) {
        this.処理年度 = 処理年度;
        this.処理対象年月 = 処理対象年月;
        this.市町村コードリスト = 市町村コードリスト;
    }

}
