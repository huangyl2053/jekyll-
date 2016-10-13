/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100010.KaishuriyushoSeikyushoShinseishoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のProcessParameter
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaishuriyushoSeikyushoShinseishoProcessParameter implements IBatchProcessParameter {

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RDate 作成申請年月日開始;
    private RDate 作成申請年月日終了;
    private FlexibleDate 作成日;
    private RString 処理対象区分;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタです.
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 作成申請年月日開始 作成申請年月日開始
     * @param 作成申請年月日終了 作成申請年月日終了
     * @param 作成日 作成日
     * @param 処理対象区分 処理対象区分
     */
    public KaishuriyushoSeikyushoShinseishoProcessParameter(LasdecCode 市町村コード,
            RString 市町村名,
            RDate 作成申請年月日開始,
            RDate 作成申請年月日終了,
            FlexibleDate 作成日,
            RString 処理対象区分) {
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.作成申請年月日開始 = 作成申請年月日開始;
        this.作成申請年月日終了 = 作成申請年月日終了;
        this.作成日 = 作成日;
        this.処理対象区分 = 処理対象区分;
    }

    /**
     * 住宅改修理由書作成手数料請求書兼申請書作成のMybatisParameterを作成する。
     *
     * @return KaishuriyushoSeikyushoShinseishoMybatisParameter
     */
    public KaishuriyushoSeikyushoShinseishoMybatisParameter toKaishuriyushoSeikyushoShinseishoMybatisParameter() {
        return new KaishuriyushoSeikyushoShinseishoMybatisParameter(市町村コード, 市町村名, 作成申請年月日開始, 作成申請年月日終了, 作成日, 処理対象区分,
                new RString("DBC"), new RString("住宅改修理由書作成手数料請求書兼申請書作成"), new RString("0000"),
                new RString("0000"), new RString("0001"), psmShikibetsuTaisho);
    }
}
