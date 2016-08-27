/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4030011;

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
    private final FlexibleYear 対象年度plus1;

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
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     */
    public ShogaishaKojoTaishoshaListMyBatisParameter(FlexibleYear 対象年度, RString 被保険者番号, RString 氏名, RString 認定区分,
            RString 認定内容, RString 認知症高齢者の日常生活自立度, RString 障害高齢者の日常生活自立度, RString 障がい者手帳,
            RString 喪失事由, FlexibleDate 喪失日FROM, FlexibleDate 喪失日TO, FlexibleDate 決定日FROM, FlexibleDate 決定日TO,
            RDate 交付日, RString 前回非該当者,
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
    }

}
