/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc040031;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class TyukonShoriKekkaKakuninListEntity {

    @CsvField(order = 1, name = "業務コード")
    private final RString 業務コード;
    @CsvField(order = 2, name = "ジョブＩＤ")
    private final RString ジョブＩＤ;
    @CsvField(order = 3, name = "項目コード１")
    private final RString 項目コード１;
    @CsvField(order = 4, name = "項目コード2")
    private final RString 項目コード2;
    @CsvField(order = 5, name = "項目コード3")
    private final RString 項目コード3;
    @CsvField(order = 6, name = "項目コード4")
    private final RString 項目コード4;
    @CsvField(order = 7, name = "項目コード5")
    private final RString 項目コード5;
    @CsvField(order = 8, name = "プログラムＩＤ")
    private final RString プログラムＩＤ;
    @CsvField(order = 9, name = "プログラム名称")
    private final RString プログラム名称;
    @CsvField(order = 10, name = "項目値１")
    private final RString 項目値１;
    @CsvField(order = 11, name = "項目値2")
    private final RString 項目値2;
    @CsvField(order = 12, name = "項目値3")
    private final RString 項目値3;
    @CsvField(order = 13, name = "項目値4")
    private final RString 項目値4;
    @CsvField(order = 14, name = "項目値5")
    private final RString 項目値5;
    @CsvField(order = 15, name = "内容１")
    private final RString 内容１;
    @CsvField(order = 16, name = "内容2")
    private final RString 内容2;

    /**
     * コンストラクタのメソッドです。
     *
     * @param 業務コード RString
     * @param ジョブＩＤ RString
     * @param 項目コード１ RString
     * @param 項目コード2 RString
     * @param 項目コード3 RString
     * @param 項目コード4 RString
     * @param 項目コード5 RString
     * @param プログラムＩＤ RString
     * @param プログラム名称 RString
     * @param 項目値１ RString
     * @param 項目値2 RString
     * @param 項目値3 RString
     * @param 項目値4 RString
     * @param 項目値5 RString
     * @param 内容１ RString
     * @param 内容2 RString
     */
    public TyukonShoriKekkaKakuninListEntity(RString 業務コード, RString ジョブＩＤ, RString 項目コード１, RString 項目コード2,
            RString 項目コード3, RString 項目コード4, RString 項目コード5, RString プログラムＩＤ, RString プログラム名称,
            RString 項目値１, RString 項目値2, RString 項目値3, RString 項目値4, RString 項目値5, RString 内容１, RString 内容2) {
        this.業務コード = 業務コード;
        this.ジョブＩＤ = ジョブＩＤ;
        this.項目コード１ = 項目コード１;
        this.項目コード2 = 項目コード2;
        this.項目コード3 = 項目コード3;
        this.項目コード4 = 項目コード4;
        this.項目コード5 = 項目コード5;
        this.プログラムＩＤ = プログラムＩＤ;
        this.プログラム名称 = プログラム名称;
        this.項目値１ = 項目値１;
        this.項目値2 = 項目値2;
        this.項目値3 = 項目値3;
        this.項目値4 = 項目値4;
        this.項目値5 = 項目値5;
        this.内容１ = 内容１;
        this.内容2 = 内容2;
    }

}
