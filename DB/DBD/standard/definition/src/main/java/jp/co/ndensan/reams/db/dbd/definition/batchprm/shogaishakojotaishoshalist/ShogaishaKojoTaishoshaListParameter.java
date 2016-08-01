/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.shogaishakojotaishoshalist;

import jp.co.ndensan.reams.db.dbd.definition.core.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListData;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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

    private RDate 対象年度;
    private Decimal 被保険者番号;
    private RString 氏名;
    private RString 認定区分;
    private RString 認定内容;
    private RString 認知症高齢者の日常生活自立度;
    private RString 障害高齢者の日常生活自立度;
    private RString 障がい者手帳;
    private RString 喪失事由;
    private RDate 喪失日FROM;
    private RDate 喪失日TO;
    private RDate 決定日FROM;
    private RDate 決定日TO;
    private RString 前回非該当者;
    private RDate 交付日;
    private RString 出力順;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDbd100025BatchParameter(ShogaishaKojoTaishoshaListData tempData) {
        this.対象年度 = tempData.get対象年度();
        this.被保険者番号 = tempData.get被保険者番号();
        this.氏名 = tempData.get氏名();
        this.認定区分 = tempData.get認定区分();
        this.認定内容 = tempData.get認定内容();
        this.認知症高齢者の日常生活自立度 = tempData.get認知症高齢者の日常生活自立度();
        this.障害高齢者の日常生活自立度 = tempData.get障害高齢者の日常生活自立度();
        this.障がい者手帳 = tempData.get障がい者手帳();
        this.喪失事由 = tempData.get喪失事由();
        this.喪失日FROM = tempData.get喪失日FROM();
        this.喪失日TO = tempData.get喪失日TO();
        this.決定日FROM = tempData.get決定日FROM();
        this.決定日TO = tempData.get決定日TO();
        this.前回非該当者 = tempData.get前回非該当者();
        this.交付日 = tempData.get交付日();
        this.出力順 = tempData.get出力順();
    }

}
