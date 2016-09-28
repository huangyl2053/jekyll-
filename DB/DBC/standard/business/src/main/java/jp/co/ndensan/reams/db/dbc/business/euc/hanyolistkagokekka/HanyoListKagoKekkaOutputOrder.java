/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkagokekka;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(過誤結果情報)ORDERBYデータの編集クラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
public enum HanyoListKagoKekkaOutputOrder implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"ShikibetsuTaisho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"ShikibetsuTaisho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"dbT1001HihokenshaDaicho_shichosonCode\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("\"dbT3061KagoKetteiMeisai_shokisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"dbT3061KagoKetteiMeisai_hiHokenshaNo\"")),
    /**
     * 要介護度
     */
    要介護度(new RString("0403"), new RString(""), new RString("")),
    /**
     * 認定開始日
     */
    認定開始日(new RString("0411"), new RString(""), new RString("")),
    /**
     * サービス年月
     */
    サービス年月(new RString("0301"), new RString(""), new RString("dbT3061KagoKetteiMeisai_serviceTeikyoYM")),
    /**
     * 取り扱い年月
     */
    取り扱い年月(new RString("0310"), new RString(""), new RString("dbT3061KagoKetteiMeisai_torikomiYM")),
    /**
     * 保険者区分
     */
    保険者区分(new RString("0501"), new RString(""), new RString("dbT3061KagoKetteiMeisai_hokenshaKubun"));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListKagoKekkaOutputOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
