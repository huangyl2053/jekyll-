/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請連携データ取込のパラメータクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RenkeiDataTorikomiBatchParamter extends BatchParameterBase {

    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String TORIKOMIFILELIST = "torikomifilelist";
    private static final String SHINSEIJOHODATALIST = "shinseiJohoDataList";

    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = TORIKOMIFILELIST, name = "取込み対象ファイルリスト")
    private List<RString> 取込み対象ファイルリスト;
    @BatchParameter(key = SHINSEIJOHODATALIST, name = "要介護認定申請情報データリスト")
    private List<ShiseiDataParameter> 申請情報データリスト;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaIraiMybitisParamter
     */
//    public RenkeiDataTorikomiProcessParamter toRenkeiDataTorikomiProcessParamter() {
//        return new RenkeiDataTorikomiProcessParamter(市町村コード,
//                取込み対象ファイルリスト,
//                申請情報データリスト);
//    }
}
