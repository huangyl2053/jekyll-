/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額決定通知一覧表のPageBreakenum
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public enum KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder implements IReportItems {

    /**
     * 事業者番号
     */
    年度("3001", "年度", "\"DbT3116KijunShunyugakuTekiyoKanri\".\"nendo\""),
    /**
     * 被保険者番号
     */
    申請年月日("3002", "申請年月日", "\"DbT3116KijunShunyugakuTekiyoKanri\".\"shinseiYMD\""),
    /**
     * 被保険者番号
     */
    決定年月日("3003", "決定年月日", "\"DbT3116KijunShunyugakuTekiyoKanri\".\"ketteiYMD\""),
    /**
     * 被保険者番号
     */
    適用開始年月("3004", "適用開始年月", "\"DbT3116KijunShunyugakuTekiyoKanri\".\"tekiyoKaishiYMD\""),
    /**
     * 被保険者番号
     */
    算定基準額("3005", "算定基準額", "\"DbT3116KijunShunyugakuTekiyoKanri\".\"santeiKijungaku\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.myBatis項目名 = new RString(myBatis項目名);
    }

    @Override
    public RString get項目ID() {
        return this.項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return this.フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return this.myBatis項目名;
    }

}
