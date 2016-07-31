/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3100001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・一次判定CSVEntityクラスです。
 *
 * @reamsid_L DBE-2070-010 wangrenze
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanryoshoriCsvEntity {

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
    @CsvField(order = 70, name = "調査票入手_完了日")
    private final RString 調査票入手_完了日;
    @CsvField(order = 80, name = "意見書入手_完了日")
    private final RString 意見書入手_完了日;
    @CsvField(order = 90, name = "一次判定_完了日")
    private final RString 一次判定_完了日;
    @CsvField(order = 100, name = "一次判定_仮一次判定")
    private final RString 一次判定_仮一次判定;
    @CsvField(order = 110, name = "一次判定_一次判定")
    private final RString 一次判定_一次判定;
    @CsvField(order = 120, name = "一次判定_一次判定結果")
    private final RString 一次判定_一次判定結果;
    @CsvField(order = 130, name = "一次判定_警告コード")
    private final RString 一次判定_警告コード;

    /**
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 保険者 保険者
     * @param 認定申請日 認定申請日
     * @param 被保険者_被保番号 被保険者_被保番号
     * @param 被保険者_氏名 被保険者_氏名
     * @param 申請区分_申請時 申請区分_申請時
     * @param 調査票入手_完了日 調査票入手_完了日
     * @param 意見書入手_完了日 意見書入手_完了日
     * @param 一次判定_完了日 一次判定_完了日
     * @param 一次判定_仮一次判定 一次判定_仮一次判定
     * @param 一次判定_一次判定 一次判定_一次判定
     * @param 一次判定_一次判定結果 一次判定_一次判定結果
     * @param 一次判定_警告コード 一次判定_警告コード
     */
    public KanryoshoriCsvEntity(
            RString 申請書管理番号,
            RString 保険者,
            RString 認定申請日,
            RString 被保険者_被保番号,
            RString 被保険者_氏名,
            RString 申請区分_申請時,
            RString 調査票入手_完了日,
            RString 意見書入手_完了日,
            RString 一次判定_完了日,
            RString 一次判定_仮一次判定,
            RString 一次判定_一次判定,
            RString 一次判定_一次判定結果,
            RString 一次判定_警告コード
    ) {
        this.申請書管理番号 = 申請書管理番号;
        this.保険者 = 保険者;
        this.認定申請日 = 認定申請日;
        this.被保険者_被保番号 = 被保険者_被保番号;
        this.被保険者_氏名 = 被保険者_氏名;
        this.申請区分_申請時 = 申請区分_申請時;
        this.調査票入手_完了日 = 調査票入手_完了日;
        this.意見書入手_完了日 = 意見書入手_完了日;
        this.一次判定_完了日 = 一次判定_完了日;
        this.一次判定_仮一次判定 = 一次判定_仮一次判定;
        this.一次判定_一次判定 = 一次判定_一次判定;
        this.一次判定_一次判定結果 = 一次判定_一次判定結果;
        this.一次判定_警告コード = 一次判定_警告コード;

    }
}
