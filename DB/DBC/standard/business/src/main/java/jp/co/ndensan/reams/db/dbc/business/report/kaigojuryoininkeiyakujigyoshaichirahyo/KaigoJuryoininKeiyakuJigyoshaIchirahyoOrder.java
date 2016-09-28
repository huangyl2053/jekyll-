/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険受領委任契約承認（不承認）確認書出力順項目を表す列挙型です。
 *
 * @reamsid_L DBC-2110-030 liuxiaoyu
 *
 */
public enum KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder implements IReportItems {

    /**
     * 契約事業者番号です。
     */
    契約事業者番号(new RString("0341"), new RString("keiyakuJigyoshaNo"),
            new RString("A.\"keiyakuJigyoshaNo\"")),
    /**
     * 契約事業者郵便番号 です。
     */
    契約事業者郵便番号(new RString("0342"), new RString("keiyakuJigyoshaYubinNo"),
            new RString("A.\"keiyakuJigyoshaYubinNo\"")),
    /**
     * 契約開始年月日です。
     */
    契約開始年月日(new RString("0343"), new RString("kaishiYMD"), new RString("A.\"kaishiYMD\"")),
    /**
     * 契約種別です。
     */
    契約種別(new RString("0344"), new RString("keiyakuShurui"), new RString("A.\"keiyakuShurui\""));
    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KaigoJuryoininKeiyakuJigyoshaIchirahyoOrder(RString 項目ID, RString フォームフィールド名,
            RString myBatis項目名) {
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
