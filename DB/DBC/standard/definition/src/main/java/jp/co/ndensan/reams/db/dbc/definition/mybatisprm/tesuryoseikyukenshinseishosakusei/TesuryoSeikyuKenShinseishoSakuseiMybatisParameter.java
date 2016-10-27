/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tesuryoseikyukenshinseishosakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TesuryoSeikyuKenShinseishoSakuseiMybatisParameter implements IMyBatisParameter {

    private final RString 市町村コード;
    private final RString サブ業務コード = new RString("DBC");
    private final RString 処理名 = new RString("住宅改修理由書作成手数料請求書兼申請書作成");
    private final RString 処理枝番 = new RString("0000");
    private final RString 年度 = new RString("0000");
    private final RString 年度内連番 = new RString("0001");

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     */
    public TesuryoSeikyuKenShinseishoSakuseiMybatisParameter(RString 市町村コード) {
        this.市町村コード = 市町村コード;
    }

}
