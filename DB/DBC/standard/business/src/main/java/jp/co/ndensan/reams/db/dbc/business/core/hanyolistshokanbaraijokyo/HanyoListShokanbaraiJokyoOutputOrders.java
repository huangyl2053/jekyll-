/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistshokanbaraijokyo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCBT23002_汎用リスト出力(償還払い状況)enum
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public enum HanyoListShokanbaraiJokyoOutputOrders implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"shikibetsuTaisho_gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"shikibetsuTaisho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"shikibetsuTaisho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("DbV1001.\"shichosonCode\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("DbV1001.\"hihokenshaNo\"")),
    /**
     * 要介護度
     */
    要介護度(new RString("0403"), new RString("要介護認定状態区分コード"), new RString("DbT4001.\"みなし要介護区分コード\"")),
    /**
     * 認定開始日
     */
    認定開始日(new RString("0411"), new RString("認定有効期間開始日"), new RString("DbT4001.\"認定有効期間開始日\"")),
    /**
     * サービス年月
     */
    サービス年月(new RString("0301"), new RString("サービス年月"), new RString("")),
    /**
     * 指定事業者番号
     */
    指定事業者番号(new RString("0303"), new RString("入所施設コード"), new RString("")),
    /**
     * 整理番号
     */
    整理番号(new RString("0305"), new RString("整理番号"), new RString("")),
    /**
     * 支払方法
     */
    支払方法(new RString("0312"), new RString("支払方法"), new RString("")),
    /**
     * 様式番号
     */
    様式番号(new RString("0315"), new RString("様式番号"), new RString("")),
    /**
     * 通知書作成日
     */
    通知書作成日(new RString("0410"), new RString("通知書作成日"), new RString(""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListShokanbaraiJokyoOutputOrders(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
