/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.jizenshinsakekka;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事前審査結果登録データ作成CsvEntityクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class JizenShinsaKekkaCsvEntity {

    @CsvField(order = 10, name = "審査会番号")
    private RString shinsakaiKaisaiNo;
    @CsvField(order = 20, name = "申請書管理番号")
    private RString shinseishoKanriNo;
    @CsvField(order = 30, name = "審査会審査順")
    private RString shinsakaiOrder;
    @CsvField(order = 40, name = "審査会委員コード")
    private RString shinsakaiIinCode;
    @CsvField(order = 50, name = "厚労省IF識別コード")
    private RString koroshoIfShikibetsuCode;
    @CsvField(order = 60, name = "二次判定結果コード")
    private RString hanteikekkaCode;
    @CsvField(order = 70, name = "二次判定結果")
    private RString hanteikekka;
    @CsvField(order = 80, name = "有効期間")
    private RString yuukouKikan;

    /**
     * コンストラクタです。
     *
     * @param 審査会番号 審査会番号
     * @param 申請書管理番号 申請書管理番号
     * @param 審査会審査順 審査会審査順
     * @param 審査会委員コード 審査会委員コード
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 二次判定結果コード 二次判定結果コード
     * @param 二次判定結果 二次判定結果
     * @param 有効期間 有効期間
     */
    public JizenShinsaKekkaCsvEntity(RString 審査会番号,
            RString 申請書管理番号,
            RString 審査会審査順,
            RString 審査会委員コード,
            RString 厚労省IF識別コード,
            RString 二次判定結果コード,
            RString 二次判定結果,
            RString 有効期間) {
        this.shinsakaiKaisaiNo = 審査会番号;
        this.shinseishoKanriNo = 申請書管理番号;
        this.shinsakaiOrder = 審査会審査順;
        this.shinsakaiIinCode = 審査会委員コード;
        this.koroshoIfShikibetsuCode = 厚労省IF識別コード;
        this.hanteikekkaCode = 二次判定結果コード;
        this.hanteikekka = 二次判定結果;
        this.yuukouKikan = 有効期間;
    }
}
