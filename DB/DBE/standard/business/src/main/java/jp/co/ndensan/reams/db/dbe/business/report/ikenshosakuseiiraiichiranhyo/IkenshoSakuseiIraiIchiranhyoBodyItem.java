/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼一覧のITEMです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoSakuseiIraiIchiranhyoBodyItem {

    private final RString listIchiranhyo_2;
    private final RString listIchiranhyo_3;
    private final RString listIchiranhyo_4;
    private final RString listIchiranhyo_5;
    private final RString listIchiranhyo_6;
    private final RString listIchiranhyo_7;
    private final RString listIchiranhyo_8;
    private final RString listIchiranhyo_9;

    /**
     * インスタンスを生成します。
     *
     * @param listIchiranhyo_2 担当医
     * @param listIchiranhyo_3 被保険者番号
     * @param listIchiranhyo_4 被保険者名
     * @param listIchiranhyo_5 被保険者名（カナ）
     * @param listIchiranhyo_6 住所
     * @param listIchiranhyo_7 生年月日
     * @param listIchiranhyo_8 性別
     * @param listIchiranhyo_9 提出期限
     */
    public IkenshoSakuseiIraiIchiranhyoBodyItem(RString listIchiranhyo_2, RString listIchiranhyo_3,
            RString listIchiranhyo_4, RString listIchiranhyo_5, RString listIchiranhyo_6, RString listIchiranhyo_7, RString listIchiranhyo_8,
            RString listIchiranhyo_9) {
        this.listIchiranhyo_2 = listIchiranhyo_2;
        this.listIchiranhyo_3 = listIchiranhyo_3;
        this.listIchiranhyo_4 = listIchiranhyo_4;
        this.listIchiranhyo_5 = listIchiranhyo_5;
        this.listIchiranhyo_6 = listIchiranhyo_6;
        this.listIchiranhyo_7 = listIchiranhyo_7;
        this.listIchiranhyo_8 = listIchiranhyo_8;
        this.listIchiranhyo_9 = listIchiranhyo_9;
    }
}
