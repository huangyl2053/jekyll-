/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.futanwariaishoikkatsu;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaishohakko.DBC180040_FutanwariaishoHakkoParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMNK3001_負担割合証発行（一括）
 *
 * @reamsid_L DBC-4990-032 pengxingyi
 */
public class FutanwariaishoHakkoIkkatsu {

    /**
     * パラメータ設定する。
     *
     * @param 年度 FlexibleYear
     * @param 交付年月日 RDate
     * @param 発行区分 RString
     * @param 出力対象 RString
     * @param 抽出期間開始日時 RDate
     * @param 抽出期間終了日時 RDate
     * @param 出力順 RString
     * @return DBC180040_FutanwariaishoHakkoParameter
     */
    public DBC180040_FutanwariaishoHakkoParameter getBatchiParameter(FlexibleYear 年度, RDate 交付年月日, RString 発行区分,
            RString 出力対象, RDateTime 抽出期間開始日時, RDateTime 抽出期間終了日時, RString 出力順) {
        DBC180040_FutanwariaishoHakkoParameter para = new DBC180040_FutanwariaishoHakkoParameter();
        para.set年度(年度);
        para.set交付年月日(交付年月日);
        para.set発行区分(発行区分);
        para.set出力対象(出力対象);
        para.set抽出期間開始日時(抽出期間開始日時);
        para.set抽出期間終了日時(抽出期間終了日時);
        para.set出力順(出力順);
        return para;
    }
}
