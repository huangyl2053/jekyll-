/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.futanwariaihanteiichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShoriKekkaKakuninListEntity {

    @CsvField(order = 1, name = "作成日時")
    private final RString 作成日時;
    @CsvField(order = 2, name = "処理名")
    private final RString 処理名;
    @CsvField(order = 3, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 4, name = "エラー内容")
    private final RString エラー内容;
    @CsvField(order = 5, name = "備考")
    private final RString 備考;

    /**
     * コンストラクタのメソッドです。
     *
     * @param 作成日時 作成日時
     * @param 処理名 処理名
     * @param 被保険者番号 被保険者番号
     * @param エラー内容 エラー内容
     * @param 備考 備考
     */
    public ShoriKekkaKakuninListEntity(RString 作成日時, RString 処理名, RString 被保険者番号, RString エラー内容, RString 備考) {
        this.作成日時 = 作成日時;
        this.処理名 = 処理名;
        this.被保険者番号 = 被保険者番号;
        this.エラー内容 = エラー内容;
        this.備考 = 備考;
    }

}
