/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成時エラー結果クラスです。
 *
 * @author n8344
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiErrKekkaCSVEntity {

    @CsvField(order = 1)
    private RString 合議体NO;
    @CsvField(order = 2)
    private RString 合議体名称;
    @CsvField(order = 3)
    private RString 有効開始日;
    @CsvField(order = 4)
    private RString 有効終了日;
    @CsvField(order = 5)
    private RString 合議体開始予定時刻;
    @CsvField(order = 6)
    private RString 合議体終了予定時刻;
    @CsvField(order = 7)
    private RString 審査会予定定員;
    @CsvField(order = 8)
    private RString 審査会自動割当定員;
    @CsvField(order = 9)
    private RString 審査会委員定員;
    @CsvField(order = 10)
    private RString 開催場所コード;
    @CsvField(order = 11)
    private RString 精神科医所属;
    @CsvField(order = 12)
    private RString 合議体ダミーフラグ;
    @CsvField(order = 13)
    private RString 審査会委員コード;
    @CsvField(order = 14)
    private RString 補欠;
    @CsvField(order = 15)
    private RString 合議体長区分コード;
    @CsvField(order = 16)
    private RString エラー事由;

}
