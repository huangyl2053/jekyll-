/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査一覧エラーリストCSVのEntityクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class NinteichosaIchiranErrorListCsvEntity {

    @CsvField(order = 1, name = "保険者")
    private final RString 保険者;
    @CsvField(order = 2, name = "認定申請日")
    private final RString 認定申請日;
    @CsvField(order = 3, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 4, name = "被保険者氏名")
    private final RString 被保険者氏名;
    @CsvField(order = 5, name = "申請区分（申請時）")
    private final RString 申請区分_申請時;
    @CsvField(order = 6, name = "依頼完了日")
    private final RString 依頼完了日;
    @CsvField(order = 7, name = "調査委託先コード")
    private final RString 調査委託先コード;
    @CsvField(order = 8, name = "調査委託先名")
    private final RString 調査委託先名;
    @CsvField(order = 9, name = "調査員コード")
    private final RString 調査員コード;
    @CsvField(order = 10, name = "調査員名")
    private final RString 調査員名;
    @CsvField(order = 11, name = "調査実施日")
    private final RString 調査実施日;
    @CsvField(order = 12, name = "申請書管理番号")
    private final RString 申請書管理番号;
    @CsvField(order = 13, name = "履歴番号")
    private final RString 履歴番号;
    @CsvField(order = 14, name = "エラー事由")
    private final RString エラー事由;

    /**
     * コンストラクタです。
     *
     * @param 保険者 保険者
     * @param 認定申請日 認定申請日
     * @param 被保険者番号 被保険者番号
     * @param 被保険者氏名 被保険者氏名
     * @param 申請区分_申請時 申請区分_申請時
     * @param 依頼完了日 依頼完了日
     * @param 調査委託先コード 調査委託先コード
     * @param 調査委託先名 調査委託先名
     * @param 調査員コード 調査員コード
     * @param 調査員名 調査員名
     * @param 調査実施日 調査実施日
     * @param 申請書管理番号 申請書管理番号
     * @param 履歴番号 履歴番号
     * @param エラー事由 エラー事由
     */
    public NinteichosaIchiranErrorListCsvEntity(
            RString 保険者,
            RString 認定申請日,
            RString 被保険者番号,
            RString 被保険者氏名,
            RString 申請区分_申請時,
            RString 依頼完了日,
            RString 調査委託先コード,
            RString 調査委託先名,
            RString 調査員コード,
            RString 調査員名,
            RString 調査実施日,
            RString 申請書管理番号,
            RString 履歴番号,
            RString エラー事由) {
        this.保険者 = 保険者;
        this.認定申請日 = 認定申請日;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 被保険者氏名;
        this.申請区分_申請時 = 申請区分_申請時;
        this.依頼完了日 = 依頼完了日;
        this.調査委託先コード = 調査委託先コード;
        this.調査委託先名 = 調査委託先名;
        this.調査員コード = 調査員コード;
        this.調査員名 = 調査員名;
        this.調査実施日 = 調査実施日;
        this.申請書管理番号 = 申請書管理番号;
        this.履歴番号 = 履歴番号;
        this.エラー事由 = エラー事由;
    }
}
