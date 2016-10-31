/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistkogakugassanshinseisho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算申請書情報)出力順クラスです。
 *
 * @reamsid_L DBC-3103-020 sunqingzhu
 */
public enum HanyoListKogakuGassanShinseishoOutPutOrder implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
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
    市町村コード(new RString("0016"), new RString(""), new RString("\"最新被保台帳_市町村コード\"")),
    /**
     * 証記載保険者番号
     *
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("SUBSTR(\"高額合算申請書_支給申請書整理番号\",6,11)")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"高額合算申請書_被保険者番号\"")),
    /**
     * 要介護度
     */
    要介護度(new RString("0403"), new RString(""), new RString("\"受給者台帳_要介護認定状態区分コード\"")),
    /**
     * 認定開始日
     *
     */
    認定開始日(new RString("0411"), new RString(""), new RString("\"受給者台帳_認定有効期間開始年月日\"")),
    /**
     * 整理番号
     *
     */
    整理番号(new RString("0337"), new RString(""), new RString("高額合算申請書_整理番号\"")),
    /**
     * 支払方法
     */
    支払方法(new RString("0312"), new RString(""), new RString("\"高額合算申請書_支払方法区分\"")),
    /**
     * 対象年度
     */
    対象年度(new RString("0334"), new RString(""), new RString("\"高額合算申請書_対象年度\""));

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListKogakuGassanShinseishoOutPutOrder(RString 項目ID,
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
