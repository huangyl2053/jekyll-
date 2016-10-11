/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchosofujohorenkei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiMybitisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 特徴送付情報連携のProcessParameterクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoSofuJohoRenkeiProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private RYearMonth 処理対象年月;
    private List<RString> 市町村コードリスト;

    private Map<RString, RString> ファイルOutputMap;
    private Map<RString, Integer> レコード件数OutputMap;

    /**
     * 特徴送付情報連携のMybitisParameterを作成する。
     *
     * @return TokuchoSofuJohoRenkeiMybitisParameter
     */
    public TokuchoSofuJohoRenkeiMybitisParameter toTokuchoSofuJohoRenkeiMybitisParameter() {
        return new TokuchoSofuJohoRenkeiMybitisParameter(処理年度, 処理対象年月, 市町村コードリスト);
    }
}
