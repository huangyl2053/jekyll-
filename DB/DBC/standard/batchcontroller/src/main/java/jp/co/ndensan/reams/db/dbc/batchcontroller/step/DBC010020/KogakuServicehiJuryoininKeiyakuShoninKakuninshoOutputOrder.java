/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010020;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種お知らせ作成の出力順項目を表す列挙型です。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
public enum KogakuServicehiJuryoininKeiyakuShoninKakuninshoOutputOrder implements IReportItems {

    /**
     * 被保険者番号です。
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"高額介護事業者\".\"dbT3076KogakuJuryoininKeiyakuJigyosha_hihokenshaNo\"")),
    /**
     * 契約申請年月日です。
     */
    契約申請年月日(new RString("0345"), new RString(""), new RString("\"高額介護事業者\".\"dbT3076KogakuJuryoininKeiyakuJigyosha_shinseiYMD\"")),
    /**
     * 事業者番号です。
     */
    契約事業者番号(new RString("0341"), new RString(""), new RString("\"高額介護事業者\".\"dbT3076KogakuJuryoininKeiyakuJigyosha_jigyoshaNo\"")),
    /**
     * 契約決定年月日です。
     */
    契約決定年月日(new RString("0347"), new RString(""), new RString("\"高額介護事業者\".\"dbT3076KogakuJuryoininKeiyakuJigyosha_ketteiYMD\"")),
    /**
     * 受領委任契約番号です。
     */
    受領委任契約番号(new RString("0348"), new RString(""), new RString("\"高額介護事業者\".\"dbT3076KogakuJuryoininKeiyakuJigyosha_keiyakuNo\"")),
    /**
     * 承認期間（開始）です。
     */
    承認期間_開始(new RString("0349"), new RString(""), new RString("\"高額介護事業者\".\"dbT3076KogakuJuryoininKeiyakuJigyosha_juryoininKaishiYMD\""));

    private KogakuServicehiJuryoininKeiyakuShoninKakuninshoOutputOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }
    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

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
