/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4030011;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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
public class ShogaishaKojoTaishoshaListMyBatisParameter implements IMyBatisParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 氏名;
    private final RString 認定区分;
    private final RString 認定内容;
    private final RString 認知症高齢者の日常生活自立度;
    private final RString 障害高齢者の日常生活自立度;
    private final RString 障がい者手帳;
    private final RString 喪失事由;
    private final RDate 喪失日FROM;
    private final RDate 喪失日TO;
    private final RDate 決定日FROM;
    private final RDate 決定日TO;

    /**
     * コンストラクタです。
     *
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
     */
    public ShogaishaKojoTaishoshaListMyBatisParameter(HihokenshaNo 被保険者番号, RString 氏名, RString 認定区分,
            RString 認定内容, RString 認知症高齢者の日常生活自立度, RString 障害高齢者の日常生活自立度, RString 障がい者手帳,
            RString 喪失事由, RDate 喪失日FROM, RDate 喪失日TO, RDate 決定日FROM, RDate 決定日TO) {
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

    }

}
