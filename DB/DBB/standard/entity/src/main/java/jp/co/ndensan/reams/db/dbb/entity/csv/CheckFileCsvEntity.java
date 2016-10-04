/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class CheckFileCsvEntity {

    @CsvField(order = 1, name = "ファイル名", length = 12)
    private final RString ファイル名;
    @CsvField(order = 2, name = "更新日時", length = 17)
    private final RString 更新日時;
    @CsvField(order = 3, name = "データ種別", length = 3)
    private final RString データ種別;
    @CsvField(order = 4, name = "対象年月", length = 6)
    private final RString 対象年月;
    @CsvField(order = 5, name = "市町村コード", length = 5)
    private final RString 市町村コード;
    @CsvField(order = 6, name = "作成年月日", length = 8)
    private final RString 作成年月日;
    @CsvField(order = 7, name = "ファイル格納件数", length = 6)
    private final RString ファイル格納件数;

    /**
     * コンストラクタのメソッドです。
     *
     * @param ファイル名 ファイル名
     * @param 更新日時 更新日時
     * @param データ種別 データ種別
     * @param 対象年月 対象年月
     * @param 市町村コード 市町村コード
     * @param 作成年月日 作成年月日
     * @param ファイル格納件数 ファイル格納件数
     */
    public CheckFileCsvEntity(RString ファイル名, RString 更新日時, RString データ種別, RString 対象年月, RString 市町村コード, RString 作成年月日,
            RString ファイル格納件数) {
        this.ファイル名 = ファイル名;
        this.更新日時 = 更新日時;
        this.データ種別 = データ種別;
        this.対象年月 = 対象年月;
        this.市町村コード = 市町村コード;
        this.作成年月日 = 作成年月日;
        this.ファイル格納件数 = ファイル格納件数;
    }

}
