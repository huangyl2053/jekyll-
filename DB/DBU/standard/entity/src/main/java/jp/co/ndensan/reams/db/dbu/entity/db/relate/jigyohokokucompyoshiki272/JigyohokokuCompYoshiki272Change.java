/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7）のChangeです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyohokokuCompYoshiki272Change {

    private RString listUpper_1;
    private RString listLower_1;
    private RString 作成日時;
    private RString 集計範囲;
    private RString 集計区分;
    private RString 保険者番号;
    private RString 保険者名;

    /**
     *
     * @param listUpper_1 件数
     * @param listLower_1 給付額
     * @param 作成日時 RString
     * @param 集計範囲 RString
     * @param 集計区分 RString
     * @param 保険者番号 RString
     * @param 保険者名 RString
     */
    public JigyohokokuCompYoshiki272Change(RString listUpper_1,
            RString listLower_1,
            RString 作成日時,
            RString 集計範囲,
            RString 集計区分,
            RString 保険者番号,
            RString 保険者名) {
        this.listUpper_1 = listUpper_1;
        this.listLower_1 = listLower_1;
        this.作成日時 = 作成日時;
        this.集計範囲 = 集計範囲;
        this.集計区分 = 集計区分;
        this.保険者番号 = 保険者番号;
        this.保険者名 = 保険者名;
    }

}
