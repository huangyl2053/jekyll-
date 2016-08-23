/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費再審査決定通知書情報取込一覧表（公費）帳票のPageBreakenum。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public enum SogojigyohiSaishinsaOutPutOrder implements IReportItems {

    /**
     * 公費負担者番号
     */
    公費負担者番号(new RString("0134"), new RString("kohiFutanshaNo"), new RString("DbWT3064.\"hdrShoHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0360"), new RString("listLower_1"), new RString("DbWT0001.\"hihokenshaNo\"")),
    /**
     * サービス提供年月
     */
    サービス提供年月(new RString("0361"), new RString("listUpper_5"), new RString("DbWT3064.\"serviceTeikyoYm\"")),
    /**
     * 事業所番号
     */
    事業者番号(new RString("0362"), new RString("listUpper_3"), new RString("DbWT3064.\"jigyoshoNo\"")),
    /**
     * 取り扱い年月
     */
    取り扱い年月(
            new RString("0363"), new RString("listUpper_2"), new RString("DbWT3064.\"toriatsukaiYm\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private SogojigyohiSaishinsaOutPutOrder(RString 項目ID, RString フォームフィールド名,
            RString myBatis項目名) {
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
