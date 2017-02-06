/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査委託先口座未登録情報CSVのクラスです
 *
 * @author n8430
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaItakusakiKozaMitorokuJohoCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "市町村")
    private RString 市町村;
    @CsvField(order = 3, name = "調査委託先コード")
    private RString 調査委託先コード;
    @CsvField(order = 4, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 5, name = "調査委託先名称")
    private RString 調査委託先名称;
    @CsvField(order = 6, name = "調査委託先カナ名称")
    private RString 調査委託先カナ名称;
    @CsvField(order = 7, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 8, name = "住所")
    private RString 住所;
    @CsvField(order = 9, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 10, name = "ＦＡＸ番号")
    private RString ＦＡＸ番号;
    @CsvField(order = 11, name = "機関代表者氏名")
    private RString 機関代表者氏名;
    @CsvField(order = 12, name = "機関代表者カナ氏名")
    private RString 機関代表者カナ氏名;
    @CsvField(order = 13, name = "調査委託区分コード")
    private RString 調査委託区分コード;
    @CsvField(order = 14, name = "調査委託区分")
    private RString 調査委託区分;
    @CsvField(order = 15, name = "特定調査員の表示")
    private RString 特定調査員表示フラグ;
    @CsvField(order = 16, name = "割付定員")
    private RString 割付定員;
    @CsvField(order = 17, name = "割付地区コード")
    private RString 割付地区コード;
    @CsvField(order = 18, name = "割付地区名称")
    private RString 割付地区名称;
    @CsvField(order = 19, name = "自動割付可否")
    private RString 自動割付フラグ;
    @CsvField(order = 20, name = "機関の区分コード")
    private RString 機関の区分コード;
    @CsvField(order = 21, name = "機関の区分")
    private RString 機関の区分;
    @CsvField(order = 22, name = "調査委託先の状況")
    private RString 状況フラグ;
}
