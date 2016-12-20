/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医意見書依頼一覧CSVEntityクラスです。
 *
 * @reamsid_L DBE-0320-010 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoIraiCsvEntity {

    @CsvField(order = 10, name = "申請書管理番号")
    private final RString 申請書管理番号;
    @CsvField(order = 20, name = "状態")
    private final RString 状態;
    @CsvField(order = 30, name = "保険者")
    private final RString 保険者;
    @CsvField(order = 40, name = "認定申請日")
    private final RString 認定申請日;
    @CsvField(order = 50, name = "被保番号")
    private final RString 被保番号;
    @CsvField(order = 60, name = "氏名")
    private final RString 氏名;
    @CsvField(order = 70, name = "申請時コード")
    private final RString 申請時コード;
    @CsvField(order = 80, name = "申請時")
    private final RString 申請時;
    @CsvField(order = 90, name = "再意見書回数")
    private final Decimal 再意見書回数;
    @CsvField(order = 100, name = "依頼日")
    private final RString 依頼日;
    @CsvField(order = 110, name = "依頼書発行日")
    private final RString 依頼書発行日;
    @CsvField(order = 120, name = "意見書出力日")
    private final RString 意見書出力日;
    @CsvField(order = 130, name = "依頼期限")
    private final RString 依頼期限;
    @CsvField(order = 140, name = "初回_2回目コード")
    private final RString 初回_2回目コード;
    @CsvField(order = 150, name = "初回_2回目")
    private final RString 初回_2回目;
    @CsvField(order = 160, name = "医療機関")
    private final RString 医療機関;
    @CsvField(order = 170, name = "主治医")
    private final RString 主治医;
    @CsvField(order = 180, name = "前回主治医医療機関情報")
    private final RString 前回主治医医療機関情報;
    @CsvField(order = 190, name = "前回主治医情報")
    private final RString 前回主治医情報;
    @CsvField(order = 200, name = "郵便番号")
    private final RString 郵便番号;
    @CsvField(order = 210, name = "住所")
    private final RString 住所;
    @CsvField(order = 220, name = "入所施設コード")
    private final RString 入所施設コード;
    @CsvField(order = 230, name = "入所施設")
    private final RString 入所施設;
    @CsvField(order = 240, name = "経過日数")
    private final int 経過日数;

    /**
     * コンストラクタです。
     * @param 申請書管理番号 申請書管理番号
     * @param 状態 状態
     * @param 保険者 保険者
     * @param 認定申請日 認定申請日
     * @param 被保番号 被保番号
     * @param 氏名 氏名
     * @param 申請時コード 申請時コード
     * @param 申請時 申請時
     * @param 再意見書回数 再意見書回数
     * @param 依頼日 依頼日
     * @param 依頼書発行日 依頼書発行日
     * @param 意見書出力日 意見書出力日
     * @param 依頼期限 依頼期限
     * @param 初回_2回目コード 初回_2回目コード
     * @param 初回_2回目 初回_2回目
     * @param 医療機関 医療機関
     * @param 主治医 主治医
     * @param 前回主治医医療機関情報 前回主治医医療機関情報
     * @param 前回主治医情報 前回主治医情報
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 入所施設コード 入所施設コード
     * @param 入所施設 入所施設
     * @param 経過日数 経過日数
     */
    public ShujiiIkenshoIraiCsvEntity(
            RString 申請書管理番号,
            RString 状態,
            RString 保険者,
            RString 認定申請日,
            RString 被保番号,
            RString 氏名,
            RString 申請時コード,
            RString 申請時,
            Decimal 再意見書回数,
            RString 依頼日,
            RString 依頼書発行日,
            RString 意見書出力日,
            RString 依頼期限,
            RString 初回_2回目コード,
            RString 初回_2回目,
            RString 医療機関,
            RString 主治医,
            RString 前回主治医医療機関情報,
            RString 前回主治医情報,
            RString 郵便番号,
            RString 住所,
            RString 入所施設コード,
            RString 入所施設,
            int 経過日数) {
        this.申請書管理番号 = 申請書管理番号;
        this.状態 = 状態;
        this.保険者 = 保険者;
        this.認定申請日 = 認定申請日;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.申請時コード = 申請時コード;
        this.申請時 = 申請時;
        this.再意見書回数 = 再意見書回数;
        this.依頼日 = 依頼日;
        this.依頼書発行日 = 依頼書発行日;
        this.意見書出力日 = 意見書出力日;
        this.依頼期限 = 依頼期限;
        this.初回_2回目コード = 初回_2回目コード;
        this.初回_2回目 = 初回_2回目;
        this.医療機関 = 医療機関;
        this.主治医 = 主治医;
        this.前回主治医医療機関情報 = 前回主治医医療機関情報;
        this.前回主治医情報 = 前回主治医情報;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.入所施設コード = 入所施設コード;
        this.入所施設 = 入所施設;
        this.経過日数 = 経過日数;
    }
}
