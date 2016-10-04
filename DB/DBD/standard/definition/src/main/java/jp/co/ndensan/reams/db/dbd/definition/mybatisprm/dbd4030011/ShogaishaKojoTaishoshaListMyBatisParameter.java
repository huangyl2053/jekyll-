/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4030011;

import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 障がい者控除対象者認定書リスト_SQLパラメータクラスです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaListMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleYear 対象年度;
    private final RString 被保険者番号;
    private final RString 氏名;
    private final RString 認定区分;
    private final RString 認定内容;
    private final RString 認知症高齢者の日常生活自立度;
    private final RString 障害高齢者の日常生活自立度;
    private final RString 障がい者手帳;
    private final RString 喪失事由;
    private final FlexibleDate 喪失日FROM;
    private final FlexibleDate 喪失日TO;
    private final FlexibleDate 決定日FROM;
    private final FlexibleDate 決定日TO;
    private final RDate 交付日;
    private final RString 前回非該当者;
    private final boolean 障がい者手帳あり;
    private final boolean 障がい者手帳なし;
    private final boolean 前回非該当者含まない;
    private boolean is_被保険者番号 = false;
    private boolean is_氏名 = false;
    private boolean is_認定区分 = false;
    private boolean is_認定内容 = false;
    private boolean is_認知症高齢者 = false;
    private boolean is_障害高齢者 = false;
    private boolean is_障がい者手帳 = false;
    private boolean is_喪失事由 = false;
    private boolean is_喪失日FROM = false;
    private boolean is_喪失日TO = false;
    private boolean is_決定日FROM = false;
    private boolean is_決定日TO = false;
    private final FlexibleYear 対象年度plus1;
    private final RString 障がい者控除;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 対象年度 対象年度
     * @param 被保険者番号 被保険者番号
     * @param 氏名 氏名
     * @param 認定区分 認定区分
     * @param 認定内容 認定内容
     * @param 認知症高齢者の日常生活自立度 認知症高齢者の日常生活自立度
     * @param 障害高齢者の日常生活自立度 障害高齢者の日常生活自立度
     * @param 障がい者手帳 障がい者手帳
     * @param 喪失事由 喪失事由
     * @param 喪失日FROM 喪失日FROM
     * @param 喪失日TO 喪失日TO
     * @param 決定日FROM 決定日FROM
     * @param 決定日TO 決定日TO
     * @param 交付日 交付日
     * @param 前回非該当者 前回非該当者
     * @param 出力順 出力順
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     */
    public ShogaishaKojoTaishoshaListMyBatisParameter(FlexibleYear 対象年度, RString 被保険者番号, RString 氏名, RString 認定区分,
            RString 認定内容, RString 認知症高齢者の日常生活自立度, RString 障害高齢者の日常生活自立度, RString 障がい者手帳,
            RString 喪失事由, FlexibleDate 喪失日FROM, FlexibleDate 喪失日TO, FlexibleDate 決定日FROM, FlexibleDate 決定日TO,
            RDate 交付日, RString 前回非該当者, RString 出力順,
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {

        super(shikibetsuTaishoPSMSearchKey);
        this.対象年度 = 対象年度;
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.認定区分 = 認定区分;
        this.認定内容 = 認定内容;
        this.認知症高齢者の日常生活自立度 = 認知症高齢者の日常生活自立度;
        this.障害高齢者の日常生活自立度 = 障害高齢者の日常生活自立度;
        this.障がい者手帳 = 障がい者手帳;
        this.喪失事由 = 喪失事由;
        this.喪失日FROM = 喪失日FROM;
        this.喪失日TO = 喪失日TO;
        this.決定日FROM = 決定日FROM;
        this.決定日TO = 決定日TO;
        this.交付日 = 交付日;
        this.障がい者手帳あり = new RString("あり").equals(障がい者手帳);
        this.障がい者手帳なし = new RString("なし").equals(障がい者手帳);
        this.前回非該当者 = 前回非該当者;
        this.前回非該当者含まない = new RString("含まない").equals(前回非該当者);
        this.対象年度plus1 = 対象年度.minusYear(1);
        this.障がい者控除 = GemmenGengakuShurui.障がい者控除.getコード();
        this.出力順 = 出力順;
        edit被保険者番号(被保険者番号);
        edit氏名(氏名);
        edit認定区分(認定区分);
        edit認定内容(認定内容);
        if (認知症高齢者の日常生活自立度 != null && !認知症高齢者の日常生活自立度.isEmpty()) {
            is_認知症高齢者 = true;
        }
        if (障害高齢者の日常生活自立度 != null && !障害高齢者の日常生活自立度.isEmpty()) {
            is_障害高齢者 = true;
        }
        edit障がい者手帳(障がい者手帳);
        edit喪失決定(喪失事由, 喪失日FROM, 喪失日TO, 決定日FROM, 決定日TO);
    }

    private void edit被保険者番号(RString 被保険者番号) {
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            is_被保険者番号 = true;
        }
    }

    private void edit氏名(RString 氏名) {
        if (氏名 != null && !氏名.isEmpty()) {
            is_氏名 = true;
        }
    }

    private void edit認定区分(RString 認定区分) {
        if (認定区分 != null && !認定区分.isEmpty()) {
            is_認定区分 = true;
        }
    }

    private void edit認定内容(RString 認定内容) {
        if (認定内容 != null && !認定内容.isEmpty()) {
            is_認定内容 = true;
        }
    }

    private void edit障がい者手帳(RString 障がい者手帳) {
        if (障がい者手帳 != null && !障がい者手帳.isEmpty()) {
            is_障がい者手帳 = true;
        }
    }

    private void edit喪失決定(RString 喪失事由, FlexibleDate 喪失日FROM, FlexibleDate 喪失日TO, FlexibleDate 決定日FROM, FlexibleDate 決定日TO) {
        if (喪失事由 != null && !喪失事由.isEmpty()) {
            is_喪失事由 = true;
        }
        if (喪失日FROM != null && !喪失日FROM.isEmpty()) {
            is_喪失日FROM = true;
        }
        if (喪失日TO != null && !喪失日TO.isEmpty()) {
            is_喪失日TO = true;
        }
        if (決定日FROM != null && !決定日FROM.isEmpty()) {
            is_決定日FROM = true;
        }
        if (決定日TO != null && !決定日TO.isEmpty()) {
            is_決定日TO = true;
        }
    }
}
