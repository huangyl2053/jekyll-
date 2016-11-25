/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistkogakugassankeisan;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)出力順クラスです。
 *
 * @reamsid_L DBC-3100-020 jiangxiaolong
 */
public enum HanyoListKogakuGassanOutPutOrder implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"Atesaki_gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString(""), new RString("\"ShikibetsuTaisho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString(""), new RString("\"ShikibetsuTaisho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShikibetsuTaisho_kanaShimei\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"dbT1001HihokenshaDaicho_shichosonCode\"")),
    /**
     * 証記載保険者番号
     *
     */
    証記載保険者番号(new RString("0103"), new RString(""),
            new RString("\"dbT3072_shoKisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""),
            new RString("\"dbT3072_hihokenshaNo\"")),
    /**
     * 要介護度
     */
    要介護度(new RString("0403"), new RString(""), new RString("\"dbT4001JukyushaDaicho_yokaigoJotaiKubunCode\"")),
    /**
     * 認定開始日
     *
     */
    認定開始日(new RString("0411"), new RString(""), new RString("\"dbT4001JukyushaDaicho_ninteiYukoKikanKaishiYMD\"")),
    /**
     * 申請書整理番号
     *
     */
    申請書整理番号(new RString("0337"), new RString(""),
            new RString("\"dbT3072_shikyuShinseishoSeiriNo\"")),
    /**
     * 対象年度
     */
    対象年度(new RString("0334"), new RString(""),
            new RString("\"dbT3072_taishoNendo\""));

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListKogakuGassanOutPutOrder(RString 項目ID,
            RString フォームフィールド名, RString myBatis項目名) {
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
