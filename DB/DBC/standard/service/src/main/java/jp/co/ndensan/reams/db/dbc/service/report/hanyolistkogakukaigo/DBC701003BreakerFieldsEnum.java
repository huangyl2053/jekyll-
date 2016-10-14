/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額介護サービス費状況)Enumクラスです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
public enum DBC701003BreakerFieldsEnum implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("A.\".\"Atesaki_gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString(""), new RString("A.\"Atesaki_honninSetaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString(""), new RString("A.\"Atesaki_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("A.\"kanaShimei\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString(""), new RString("A.\"市町村コード\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("A.\"証記載保険者番号\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("A.\"被保険者番号\"")),
    /**
     * 要介護度
     */
    要介護度(new RString("0403"), new RString(""), new RString("A.\"要介護認定状態区分コード\"")),
    /**
     * 認定開始日
     */
    認定開始日(new RString("0411"), new RString(""), new RString("A.\"認定有効期間開始日\"")),
    /**
     * サービス年月
     */
    サービス年月(new RString("0301"), new RString(""), new RString("A.\"サービス提供年月\"")),
    /**
     * 指定事業者番号
     */
    指定事業者番号(new RString("0303"), new RString(""), new RString("A.\"入所施設コード\"")),
    /**
     * 通知書作成日
     */
    通知書作成日(new RString("0410"), new RString(""), new RString("A.\"決定通知書作成年月日\"")),
    /**
     * 負担段階
     */
    負担段階(new RString("0320"), new RString(""), new RString("A.\"高額給付根拠\"")),
    /**
     * 高額自動償還
     */
    高額自動償還(new RString("0321"), new RString(""), new RString("A.\"自動償還対象フラグ\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private DBC701003BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
