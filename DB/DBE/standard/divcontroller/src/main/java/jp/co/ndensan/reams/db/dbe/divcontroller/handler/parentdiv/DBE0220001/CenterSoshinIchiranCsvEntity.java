/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信一覧CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-010 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterSoshinIchiranCsvEntity {

    @CsvField(order = 10, name = "状態")
    private final RString 状態;
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
    @CsvField(order = 70, name = "(申請区分)法令")
    private final RString 申請区分_法令;
    @CsvField(order = 80, name = "(月例処理)月例処理完了日")
    private final RString 月例処理_月例処理完了日;
    @CsvField(order = 90, name = "(月例処理)センター送信日")
    private final RString 月例処理_センター送信日;

    /**
     * コンストラクタです。
     *
     * @param 状態 状態
     * @param 保険者 保険者
     * @param 認定申請日 認定申請日
     * @param 被保険者_被保番号 被保険者_被保番号
     * @param 被保険者_氏名 被保険者_氏名
     * @param 申請区分_申請時 申請区分_申請時
     * @param 申請区分_法令 申請区分_法令
     * @param 月例処理_月例処理完了日 月例処理_月例処理完了日
     * @param 月例処理_センター送信日 月例処理_センター送信日
     */
    public CenterSoshinIchiranCsvEntity(
            RString 状態,
            RString 保険者,
            RString 認定申請日,
            RString 被保険者_被保番号,
            RString 被保険者_氏名,
            RString 申請区分_申請時,
            RString 申請区分_法令,
            RString 月例処理_月例処理完了日,
            RString 月例処理_センター送信日) {
        this.状態 = 状態;
        this.保険者 = 保険者;
        this.認定申請日 = 認定申請日;
        this.被保険者_被保番号 = 被保険者_被保番号;
        this.被保険者_氏名 = 被保険者_氏名;
        this.申請区分_申請時 = 申請区分_申請時;
        this.申請区分_法令 = 申請区分_法令;
        this.月例処理_月例処理完了日 = 月例処理_月例処理完了日;
        this.月例処理_センター送信日 = 月例処理_センター送信日;
    }
}
