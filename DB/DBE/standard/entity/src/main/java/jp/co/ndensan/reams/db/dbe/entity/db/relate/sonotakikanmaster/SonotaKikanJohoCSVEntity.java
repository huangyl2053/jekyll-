/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成RelateEntityクラスです。
 *
 * @reamsid_L DBE-0090-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SonotaKikanJohoCSVEntity {

    @CsvField(order = 1)
    private RString 証記載保険者番号;
    @CsvField(order = 2)
    private RString その他機関コード;
    @CsvField(order = 3)
    private RString 機関名称;
    @CsvField(order = 4)
    private RString 機関名称カナ;
    @CsvField(order = 5)
    private RString 郵便番号;
    @CsvField(order = 6)
    private RString 住所;
    @CsvField(order = 7)
    private RString 電話番号;
    @CsvField(order = 8)
    private RString 調査委託区分;
    @CsvField(order = 9)
    private RString 機関の区分;
    
}
