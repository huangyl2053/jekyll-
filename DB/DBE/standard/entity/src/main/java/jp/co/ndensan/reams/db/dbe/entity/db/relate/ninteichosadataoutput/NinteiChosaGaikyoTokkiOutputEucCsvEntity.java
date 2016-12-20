/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）概況特記事項CSV用データEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaGaikyoTokkiOutputEucCsvEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private RString 申請書管理番号;
    @CsvField(order = 2, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "認定申請年月日")
    private RString 認定申請年月日;
    @CsvField(order = 5, name = "概況特記事項（主訴）")
    private RString 概況特記事項主訴;
    @CsvField(order = 6, name = "概況特記事項（家族状況）")
    private RString 概況特記事項家族状況;
    @CsvField(order = 7, name = "概況特記事項（居住環境）")
    private RString 概況特記事項居住環境;
    @CsvField(order = 8, name = "概況特記事項（機器・器械）")
    private RString 概況特記事項機器器械;

}
