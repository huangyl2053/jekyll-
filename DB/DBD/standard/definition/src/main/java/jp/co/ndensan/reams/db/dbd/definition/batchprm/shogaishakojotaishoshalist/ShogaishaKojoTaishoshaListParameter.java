/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.shogaishakojotaishoshalist;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4030011.ShogaishakojoTaishoshaListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 障がい者控除対象者認定書リスト_バッチ用のパラメータです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaListParameter extends BatchParameterBase {

    @BatchParameter(key = "対象年度", name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = "被保険者番号", name = "被保険者番号")
    private RString 被保険者番号;
    @BatchParameter(key = "氏名", name = "氏名")
    private RString 氏名;
    @BatchParameter(key = "認定区分", name = "認定区分")
    private RString 認定区分;
    @BatchParameter(key = "認定内容", name = "認定内容")
    private RString 認定内容;
    @BatchParameter(key = "認知症高齢者の日常生活自立度", name = "認知症高齢者の日常生活自立度")
    private RString 認知症高齢者の日常生活自立度;
    @BatchParameter(key = "障害高齢者の日常生活自立度", name = "障害高齢者の日常生活自立度")
    private RString 障害高齢者の日常生活自立度;
    @BatchParameter(key = "障がい者手帳", name = "障がい者手帳")
    private RString 障がい者手帳;
    @BatchParameter(key = "喪失事由", name = "喪失事由")
    private RString 喪失事由;
    @BatchParameter(key = "喪失日FROM", name = "喪失日FROM")
    private FlexibleDate 喪失日FROM;
    @BatchParameter(key = "喪失日TO", name = "喪失日TO")
    private FlexibleDate 喪失日TO;
    @BatchParameter(key = "決定日FROM", name = "決定日FROM")
    private FlexibleDate 決定日FROM;
    @BatchParameter(key = "決定日TO", name = "決定日TO")
    private FlexibleDate 決定日TO;
    @BatchParameter(key = "対象年度", name = "対象年度")
    private RString 前回非該当者;
    @BatchParameter(key = "交付日", name = "交付日")
    private RDate 交付日;
    @BatchParameter(key = "出力順", name = "出力順")
    private RString 出力順;

    /**
     *
     * @return KoshinTaishoshaKanriProcessParameter
     */
    public ShogaishakojoTaishoshaListProcessParameter toShogaishakojoTaishoshaListProcessParameter() {
        return new ShogaishakojoTaishoshaListProcessParameter(対象年度, 被保険者番号, 氏名, 認定区分, 認定内容,
                認知症高齢者の日常生活自立度, 障害高齢者の日常生活自立度, 障がい者手帳, 喪失事由, 喪失日FROM, 喪失日TO,
                決定日FROM, 決定日TO, 前回非該当者, 交付日, 出力順);
    }

}
