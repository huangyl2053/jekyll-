/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3090001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定データ出力Entityです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ItiziHanteiZumiItiranEntity {

    @CsvField(order = 1, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 2, name = "申請日")
    private RString 申請日;
    @CsvField(order = 3, name = "被保険者_被保番号")
    private RString 被保険者_被保番号;
    @CsvField(order = 4, name = "被保険者_氏名")
    private RString 被保険者_氏名;
    @CsvField(order = 5, name = "申請区分_申請時")
    private RString 申請区分_申請時;
    @CsvField(order = 6, name = "申請区分_法令")
    private RString 申請区分_法令;
    @CsvField(order = 7, name = "一次判定_完了日")
    private RString 一次判定_完了日;
    @CsvField(order = 8, name = "一次判定_一次判定結果")
    private RString 一次判定_一次判定結果;
    @CsvField(order = 9, name = "一次判定_資料作成")
    private RString 一次判定_資料作成;
    @CsvField(order = 10, name = "一次判定_警告コード")
    private RString 一次判定_警告コード;
}
