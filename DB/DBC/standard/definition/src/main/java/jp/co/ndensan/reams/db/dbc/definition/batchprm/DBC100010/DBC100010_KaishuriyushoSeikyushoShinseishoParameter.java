/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010.KaishuriyushoSeikyushoShinseishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成です。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC100010_KaishuriyushoSeikyushoShinseishoParameter extends BatchParameterBase {

    @BatchParameter(key = "shichosonCode", name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = "shichosonMeisho", name = "市町村名")
    private RString 市町村名;
    @BatchParameter(key = "riyushoSakuseiShinseiYMDFrom", name = "作成申請年月日開始")
    private RDate 作成申請年月日開始;
    @BatchParameter(key = "riyushoSakuseiShinseiYMDTo", name = "作成申請年月日終了")
    private RDate 作成申請年月日終了;
    @BatchParameter(key = "sakuseibi", name = "作成日")
    private FlexibleDate 作成日;
    @BatchParameter(key = "shoritaishoukbn", name = "処理対象区分")
    private RString 処理対象区分;

    /**
     * 住宅改修理由書作成手数料請求書兼申請書作成のProcessParameterを作成する。
     *
     * @return KaishuriyushoSeikyushoShinseishoProcessParameter
     */
    public KaishuriyushoSeikyushoShinseishoProcessParameter toKaishuriyushoSeikyushoShinseishoProcessParameter() {
        return new KaishuriyushoSeikyushoShinseishoProcessParameter(市町村コード, 市町村名, 作成申請年月日開始, 作成申請年月日終了, 作成日, 処理対象区分);
    }
}
