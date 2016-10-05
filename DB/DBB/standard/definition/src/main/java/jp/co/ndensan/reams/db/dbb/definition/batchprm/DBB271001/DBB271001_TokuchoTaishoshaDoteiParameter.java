/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB271001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.CreateGyomuHokenshaJohoGetsujiProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetDoteiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.GetMiDoteiJohoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴対象者同定（一括）のバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB271001_TokuchoTaishoshaDoteiParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private FlexibleYear 処理年度;
    private List<RString> 捕捉月;
    private RString 開始月;
    private RString 処理区分;
    private RDateTime 処理日時;

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public CreateGyomuHokenshaJohoGetsujiProcessParameter toCreateGyomuHokenshaJohoGetsujiProcessParameter() {
        return new CreateGyomuHokenshaJohoGetsujiProcessParameter(処理年度, 開始月);
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public GetDoteiJohoProcessParameter toGetDoteiJohoProcessParameter() {
        return new GetDoteiJohoProcessParameter(処理年度, 開始月, 処理日時);
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public GetMiDoteiJohoProcessParameter toGetMiDoteiJohoProcessParameter() {
        return new GetMiDoteiJohoProcessParameter(開始月, 処理日時);
    }

}
