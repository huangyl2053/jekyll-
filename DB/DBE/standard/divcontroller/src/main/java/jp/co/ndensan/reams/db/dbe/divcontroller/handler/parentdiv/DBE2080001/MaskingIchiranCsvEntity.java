/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2080001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * マスキング情報一覧のCSVEntityクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MaskingIchiranCsvEntity {

    @CsvField(order = 10, name = "申請書管理番号")
    private final RString 申請書管理番号;
    @CsvField(order = 20, name = "保険者")
    private final RString 保険者;
    @CsvField(order = 30, name = "認定申請日")
    private final RString 認定申請日;
    @CsvField(order = 40, name = "(被保険者)被保番号")
    private final RString 被保険者_被保番号;
    @CsvField(order = 50, name = "(被保険者)氏名")
    private final RString 被保険者_氏名;
    @CsvField(order = 60, name = "(申請区分)申請時")
    private final RString 申請区分_申請時;
    @CsvField(order = 70, name = "(調査依頼)完了日")
    private final RString 調査依頼_完了日;
    @CsvField(order = 80, name = "(調査票入手)完了日")
    private final RString 調査票入手_完了日;
    @CsvField(order = 90, name = "(意見書依頼)完了日")
    private final RString 意見書依頼_完了日;
    @CsvField(order = 100, name = "(意見書入手)完了日")
    private final RString 意見書入手_完了日;
    @CsvField(order = 110, name = "(マスキング)完了日")
    private final RString マスキング_完了日;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 保険者 保険者
     * @param 認定申請日 認定申請日
     * @param 被保険者_被保番号 被保険者_被保番号
     * @param 被保険者_氏名 被保険者_氏名
     * @param 申請区分_申請時 申請区分_申請時
     * @param 調査依頼_完了日 調査依頼_完了日
     * @param 調査票入手_完了日 調査票入手_完了日
     * @param 意見書依頼_完了日 意見書依頼_完了日
     * @param 意見書入手_完了日 意見書入手_完了日
     * @param マスキング_完了日 マスキング_完了日
     */
    public MaskingIchiranCsvEntity(
            RString 申請書管理番号,
            RString 保険者,
            RString 認定申請日,
            RString 被保険者_被保番号,
            RString 被保険者_氏名,
            RString 申請区分_申請時,
            RString 調査依頼_完了日,
            RString 調査票入手_完了日,
            RString 意見書依頼_完了日,
            RString 意見書入手_完了日,
            RString マスキング_完了日) {
        this.申請書管理番号 = 申請書管理番号;
        this.保険者 = 保険者;
        this.認定申請日 = 認定申請日;
        this.被保険者_被保番号 = 被保険者_被保番号;
        this.被保険者_氏名 = 被保険者_氏名;
        this.申請区分_申請時 = 申請区分_申請時;
        this.調査依頼_完了日 = 調査依頼_完了日;
        this.調査票入手_完了日 = 調査票入手_完了日;
        this.意見書依頼_完了日 = 意見書依頼_完了日;
        this.意見書入手_完了日 = 意見書入手_完了日;
        this.マスキング_完了日 = マスキング_完了日;
    }
}
