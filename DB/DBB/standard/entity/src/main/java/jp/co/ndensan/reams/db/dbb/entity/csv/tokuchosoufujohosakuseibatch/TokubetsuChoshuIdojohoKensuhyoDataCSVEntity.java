/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（特別徴収異動情報件数表ＣＳＶ）のentityです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIdojohoKensuhyoDataCSVEntity {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "作成時刻")
    private RString 作成時刻;
    @CsvField(order = 3, name = "テスト処理")
    private RString テスト処理;
    @CsvField(order = 4, name = "年金保険者名称")
    private RString 年金保険者名称;
    @CsvField(order = 5, name = "年月")
    private RString 年月;
    @CsvField(order = 6, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 7, name = "市町村名称")
    private RString 市町村名称;
    @CsvField(order = 8, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 9, name = "保険者名称")
    private RString 保険者名称;
    @CsvField(order = 10, name = "義務者コード")
    private RString 義務者コード;
    @CsvField(order = 11, name = "組合名称")
    private RString 組合名称;
    @CsvField(order = 12, name = "該当件数")
    private RString 該当件数;
    @CsvField(order = 13, name = "資格喪失")
    private RString 資格喪失;
    @CsvField(order = 14, name = "住所地特例")
    private RString 住所地特例;
    @CsvField(order = 15, name = "仮徴収額変更")
    private RString 仮徴収額変更;
    @CsvField(order = 16, name = "特徴追加依頼")
    private RString 特徴追加依頼;
    @CsvField(order = 17, name = "媒体番号")
    private RString 媒体番号;
    @CsvField(order = 18, name = "収録件数")
    private RString 収録件数;
    @CsvField(order = 19, name = "合計件数")
    private RString 合計件数;
    @CsvField(order = 20, name = "合計喪失件数")
    private RString 合計喪失件数;
    @CsvField(order = 21, name = "合計仮徴収額変更件数")
    private RString 合計仮徴収額変更件数;
    @CsvField(order = 22, name = "合計住所地特例件数")
    private RString 合計住所地特例件数;
    @CsvField(order = 23, name = "合計追加依頼件数")
    private RString 合計追加依頼件数;
}
