/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistshokanbaraijokyo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 居宅サービス計画のenum
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public enum HanyoListKyotakuServiceKeikakuOutputOrders implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("D.\"ShikibetsuTaisho_gyoseikuCode\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("D.\"ShikibetsuTaisho_setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("D.\"ShikibetsuTaisho_shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("D.\"ShikibetsuTaisho_katakanaHyoki\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("D.dbV1001市町村コード")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("D.dbV1001市町村コード")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("D.dbv1001被保険者番号")),
    /**
     * 要介護度
     */
    要介護度(new RString("0403"), new RString("要介護認定状態区分コード"), new RString("D.dbV4001要介護認定状態区分コード")),
    /**
     * 認定開始日
     */
    認定開始日(new RString("0411"), new RString("認定有効期間開始日"), new RString("D.dbV4001認定有効期間開始日")),
    /**
     * 指定事業者番号
     */
    指定事業者番号(new RString("0303"), new RString("入所施設コード"), new RString("D.dbV1004入所施設コード")),
    /**
     * 計画事業者番号
     */
    計画事業者番号(new RString("0311"), new RString("計画事業者番号"), new RString("D.dbT3006計画事業者番号")),
    /**
     * 計画適用開始日
     */
    計画適用開始日(new RString("0409"), new RString("計画適用開始日"), new RString("D.計画適用開始日"));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HanyoListKyotakuServiceKeikakuOutputOrders(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
