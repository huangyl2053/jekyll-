/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のMybatisParameter
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaishuriyushoSeikyushoShinseishoMybatisParameter implements IMyBatisParameter {

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RDate 作成申請年月日開始;
    private RDate 作成申請年月日終了;
    private FlexibleDate 作成日;
    private RString 処理対象区分;
    private RString サブ業務コード;
    private RString 処理名;
    private RString 処理枝番;
    private RString 年度;
    private RString 年度内連番;
    private final RString psmShikibetsuTaisho;
    private final RString 住宅改修費申請情報 = new RString("21D");

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 作成申請年月日開始 作成申請年月日開始
     * @param 作成申請年月日終了 作成申請年月日終了
     * @param 作成日 作成日
     * @param 処理対象区分 処理対象区分
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @param 年度内連番 年度内連番
     * @param psmShikibetsuTaisho 宛名PSM
     */
    public KaishuriyushoSeikyushoShinseishoMybatisParameter(LasdecCode 市町村コード,
            RString 市町村名,
            RDate 作成申請年月日開始,
            RDate 作成申請年月日終了,
            FlexibleDate 作成日,
            RString 処理対象区分,
            RString サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            RString 年度,
            RString 年度内連番,
            RString psmShikibetsuTaisho) {
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.作成申請年月日開始 = 作成申請年月日開始;
        this.作成申請年月日終了 = 作成申請年月日終了;
        this.作成日 = 作成日;
        this.処理対象区分 = 処理対象区分;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.年度内連番 = 年度内連番;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
