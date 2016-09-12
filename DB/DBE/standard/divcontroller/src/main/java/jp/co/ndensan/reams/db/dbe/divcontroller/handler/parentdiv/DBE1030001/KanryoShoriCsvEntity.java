/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・審査受付CSVEntityクラスです。
 *
 * @reamsid_L DBE-2060-010 wangrenze
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanryoShoriCsvEntity {

    @CsvField(order = 10, name = "申請書管理番号")
    private final RString 申請書管理番号;
    @CsvField(order = 20, name = "保険者")
    private final RString 保険者;
    @CsvField(order = 30, name = "認定申請日")
    private final RString 認定申請日;
    @CsvField(order = 40, name = "被保険者_被保番号")
    private final RString 被保険者_被保番号;
    @CsvField(order = 50, name = "被保険者_氏名")
    private final RString 被保険者_氏名;
    @CsvField(order = 60, name = "申請区分_申請時")
    private final RString 申請区分_申請時;
    @CsvField(order = 70, name = "申請受付_完了日")
    private final RString 申請受付_完了日;

    /**
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 保険者 保険者
     * @param 認定申請日 認定申請日
     * @param 被保険者_被保番号 被保険者_被保番号
     * @param 被保険者_氏名 被保険者_氏名
     * @param 申請区分_申請時 申請区分_申請時
     * @param 申請受付_完了日 申請受付_完了日
     */
    public KanryoShoriCsvEntity(
            RString 申請書管理番号,
            RString 保険者,
            RString 認定申請日,
            RString 被保険者_被保番号,
            RString 被保険者_氏名,
            RString 申請区分_申請時,
            RString 申請受付_完了日
    ) {
        this.申請書管理番号 = 申請書管理番号;
        this.保険者 = 保険者;
        this.認定申請日 = 認定申請日;
        this.被保険者_被保番号 = 被保険者_被保番号;
        this.被保険者_氏名 = 被保険者_氏名;
        this.申請区分_申請時 = 申請区分_申請時;
        this.申請受付_完了日 = 申請受付_完了日;

    }
}
