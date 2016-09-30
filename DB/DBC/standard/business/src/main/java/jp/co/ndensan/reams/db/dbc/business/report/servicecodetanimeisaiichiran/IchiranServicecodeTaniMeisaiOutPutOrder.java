/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecodetanimeisaiichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力対象データ取得enumクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public enum IchiranServicecodeTaniMeisaiOutPutOrder implements IReportItems {

    /**
     * 入力識別番号
     */
    入力識別番号(new RString("0304"), new RString("nyuryokuShikibetsuNo"),
            new RString("\"DbWT3470chohyouShutsuryokuyou\".\"inputShikibetsuNo\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("shoKisaiHokenshaNo"),
            new RString("\"DbWT3470chohyouShutsuryokuyou\".\"shokisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("hihokenshaNo"),
            new RString("\"DbWT3470chohyouShutsuryokuyou\".\"hiHokenshaNo\"")),
    /**
     * サービス年月
     */
    サービス年月(new RString("0301"), new RString("serviceYM"),
            new RString("\"DbWT3470chohyouShutsuryokuyou\".\"serviceTeikyoYM\"")),
    /**
     * 指定事業者番号
     */
    指定事業者番号(new RString("0303"), new RString("jigyoshaNo"),
            new RString("\"DbWT3470chohyouShutsuryokuyou\".\"jigyoshoNo\"")),
    /**
     * サービス種類
     */
    サービス種類(new RString("0308"), new RString("serviceShuruiCode"),
            new RString("\"DbWT3470chohyouShutsuryokuyou\".\"serviceShuruiCode\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private IchiranServicecodeTaniMeisaiOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }

    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;
    }

}
