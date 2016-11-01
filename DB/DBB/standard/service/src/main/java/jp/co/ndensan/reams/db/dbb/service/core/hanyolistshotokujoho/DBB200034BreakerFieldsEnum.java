/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hanyolistshotokujoho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報Enumクラスです。
 *
 * @reamsid_L DBB-1901-030 surun
 */
public enum DBB200034BreakerFieldsEnum implements IReportItems {

    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"ShikibetsuTaisho\".\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString(""), new RString("\"ShikibetsuTaisho\".\"setaiCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShikibetsuTaisho\".\"kanaShimei\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString(""), new RString("\"ShikibetsuTaisho\".\"seinengappiYMD\"")),
    /**
     * 課税区分
     */
    課税区分(new RString("0218"), new RString(""), new RString("DbV2502.\"kazeiKubun\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString(""), new RString("DbV2502.\"shikibetsuCode\"")),
    /**
     * 保険料段階
     */
    保険料段階(new RString("0201"), new RString(""), new RString("B.\"hokenryoDankai\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("B.\"hihokenshaNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private DBB200034BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
