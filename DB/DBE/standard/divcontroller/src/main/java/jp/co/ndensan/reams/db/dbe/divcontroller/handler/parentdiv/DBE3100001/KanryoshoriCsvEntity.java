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

    @CsvField(order = 1, name = "状態")
    private final RString 状態;
    @CsvField(order = 10, name = "申請書管理番号")
    private final RString 申請書管理番号;
    @CsvField(order = 20, name = "証記載保険者")
    private final RString 証記載保険者;
    @CsvField(order = 30, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 40, name = "被保険者名")
    private final RString 被保険者名;
    @CsvField(order = 50, name = "申請日")
    private final RString 申請日;
    @CsvField(order = 60, name = "申請区分_申請時")
    private final RString 申請区分_申請時;
    @CsvField(order = 70, name = "一次判定日")
    private final RString 一次判定日;
    @CsvField(order = 80, name = "一次判定結果")
    private final RString 一次判定結果;
    @CsvField(order = 90, name = "一次判定結果コード")
    private final RString 一次判定結果コード;
    @CsvField(order = 100, name = "一次判定結果_認知症加算")
    private final RString 一次判定結果_認知症加算;
    @CsvField(order = 110, name = "一次判定結果コード_認知症加算")
    private final RString 一次判定結果コード_認知症加算;
    @CsvField(order = 120, name = "一次判定警告コード")
    private final RString 一次判定警告コード;
    @CsvField(order = 130, name = "調査実地日")
    private final RString 調査実地日;
    @CsvField(order = 140, name = "意見書受領日")
    private final RString 意見書受領日;
    @CsvField(order = 150, name = "基準時間")
    private final RString 基準時間;
    @CsvField(order = 160, name = "基準時間_食事")
    private final RString 基準時間_食事;
    @CsvField(order = 170, name = "基準時間_排泄")
    private final RString 基準時間_排泄;
    @CsvField(order = 180, name = "基準時間_移動")
    private final RString 基準時間_移動;
    @CsvField(order = 190, name = "基準時間_清潔保持")
    private final RString 基準時間_清潔保持;
    @CsvField(order = 200, name = "基準時間_間接ケア")
    private final RString 基準時間_間接ケア;
    @CsvField(order = 210, name = "基準時間_BPSD")
    private final RString 基準時間_BPSD;
    @CsvField(order = 220, name = "基準時間_機能訓練")
    private final RString 基準時間_機能訓練;
    @CsvField(order = 230, name = "基準時間_医療関連")
    private final RString 基準時間_医療関連;
    @CsvField(order = 240, name = "基準時間_認知症加算")
    private final RString 基準時間_認知症加算;
    @CsvField(order = 250, name = "中間評価項目特定第１群")
    private final RString 中間評価項目特定第１群;
    @CsvField(order = 260, name = "中間評価項目特定第２群")
    private final RString 中間評価項目特定第２群;
    @CsvField(order = 270, name = "中間評価項目特定第３群")
    private final RString 中間評価項目特定第３群;
    @CsvField(order = 280, name = "中間評価項目特定第４群")
    private final RString 中間評価項目特定第４群;
    @CsvField(order = 290, name = "中間評価項目特定第５群")
    private final RString 中間評価項目特定第５群;
    @CsvField(order = 300, name = "安定性")
    private final RString 安定性;
    @CsvField(order = 310, name = "認知症自立度２以上の蓋然性")
    private final RString 認知症自立度２以上の蓋然性;
    @CsvField(order = 320, name = "推定される給付区分")
    private final RString 推定される給付区分;
    @CsvField(order = 330, name = "厚労省IF識別コード")
    private final RString 厚労省IF識別コード;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 証記載保険者 証記載保険者
     * @param 被保険者番号 被保険者番号
     * @param 被保険者名 被保険者名
     * @param 申請日 申請日
     * @param 申請区分_申請時 申請区分_申請時
     * @param 一次判定日 一次判定日
     * @param 一次判定結果 一次判定結果
     * @param 一次判定結果コード 一次判定結果コード
     * @param 一次判定結果_認知症加算 一次判定結果_認知症加算
     * @param 一次判定結果コード_認知症加算 一次判定結果コード_認知症加算
     * @param 一次判定警告コード 一次判定警告コード
     * @param 調査実地日 調査実地日
     * @param 意見書受領日 意見書受領日
     * @param 基準時間 基準時間
     * @param 基準時間_食事 基準時間_食事
     * @param 基準時間_排泄 基準時間_排泄
     * @param 基準時間_移動 基準時間_移動
     * @param 基準時間_清潔保持 基準時間_清潔保持
     * @param 基準時間_間接ケア 基準時間_間接ケア
     * @param 基準時間_BPSD 基準時間_BPSD
     * @param 基準時間_機能訓練 基準時間_機能訓練
     * @param 基準時間_医療関連 基準時間_医療関連
     * @param 基準時間_認知症加算 基準時間_認知症加算
     * @param 中間評価項目特定第１群 中間評価項目特定第１群
     * @param 中間評価項目特定第２群 中間評価項目特定第２群
     * @param 中間評価項目特定第３群 中間評価項目特定第３群
     * @param 中間評価項目特定第４群 中間評価項目特定第４群
     * @param 中間評価項目特定第５群 中間評価項目特定第５群
     * @param 安定性 安定性
     * @param 認知症自立度２以上の蓋然性 認知症自立度２以上の蓋然性
     * @param 推定される給付区分 推定される給付区分
     * @param 厚労省IF識別コード 厚労省IF識別コード
     */
    public KanryoshoriCsvEntity(RString 状態, RString 申請書管理番号, RString 証記載保険者, RString 被保険者番号,
            RString 被保険者名, RString 申請日, RString 申請区分_申請時, RString 一次判定日,
            RString 一次判定結果, RString 一次判定結果コード, RString 一次判定結果_認知症加算,
            RString 一次判定結果コード_認知症加算, RString 一次判定警告コード, RString 調査実地日,
            RString 意見書受領日, RString 基準時間, RString 基準時間_食事, RString 基準時間_排泄,
            RString 基準時間_移動, RString 基準時間_清潔保持, RString 基準時間_間接ケア, RString 基準時間_BPSD,
            RString 基準時間_機能訓練, RString 基準時間_医療関連, RString 基準時間_認知症加算,
            RString 中間評価項目特定第１群, RString 中間評価項目特定第２群, RString 中間評価項目特定第３群,
            RString 中間評価項目特定第４群, RString 中間評価項目特定第５群, RString 安定性,
            RString 認知症自立度２以上の蓋然性, RString 推定される給付区分, RString 厚労省IF識別コード) {
        this.状態 = 状態;
        this.申請書管理番号 = 申請書管理番号;
        this.証記載保険者 = 証記載保険者;
        this.被保険者番号 = 被保険者番号;
        this.被保険者名 = 被保険者名;
        this.申請日 = 申請日;
        this.申請区分_申請時 = 申請区分_申請時;
        this.一次判定日 = 一次判定日;
        this.一次判定結果 = 一次判定結果;
        this.一次判定結果コード = 一次判定結果コード;
        this.一次判定結果_認知症加算 = 一次判定結果_認知症加算;
        this.一次判定結果コード_認知症加算 = 一次判定結果コード_認知症加算;
        this.一次判定警告コード = 一次判定警告コード;
        this.調査実地日 = 調査実地日;
        this.意見書受領日 = 意見書受領日;
        this.基準時間 = 基準時間;
        this.基準時間_食事 = 基準時間_食事;
        this.基準時間_排泄 = 基準時間_排泄;
        this.基準時間_移動 = 基準時間_移動;
        this.基準時間_清潔保持 = 基準時間_清潔保持;
        this.基準時間_間接ケア = 基準時間_間接ケア;
        this.基準時間_BPSD = 基準時間_BPSD;
        this.基準時間_機能訓練 = 基準時間_機能訓練;
        this.基準時間_医療関連 = 基準時間_医療関連;
        this.基準時間_認知症加算 = 基準時間_認知症加算;
        this.中間評価項目特定第１群 = 中間評価項目特定第１群;
        this.中間評価項目特定第２群 = 中間評価項目特定第２群;
        this.中間評価項目特定第３群 = 中間評価項目特定第３群;
        this.中間評価項目特定第４群 = 中間評価項目特定第４群;
        this.中間評価項目特定第５群 = 中間評価項目特定第５群;
        this.安定性 = 安定性;
        this.認知症自立度２以上の蓋然性 = 認知症自立度２以上の蓋然性;
        this.推定される給付区分 = 推定される給付区分;
        this.厚労省IF識別コード = 厚労省IF識別コード;
    }
}
