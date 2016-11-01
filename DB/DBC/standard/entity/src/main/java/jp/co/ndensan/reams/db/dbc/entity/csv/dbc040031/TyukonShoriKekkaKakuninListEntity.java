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

    @CsvField(order = 1, name = "作成日時")
    private final RString 作成日時;
    @CsvField(order = 2, name = "処理名")
    private final RString 処理名;
    @CsvField(order = 3, length = 6, name = "証記載保険者番号")
    private final RString 証記載保険者番号;
    @CsvField(order = 4, length = 10, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 5, name = "被保険者カナ氏名")
    private final RString 被保険者カナ氏名;
    @CsvField(order = 6, name = "被保険者氏名")
    private final RString 被保険者氏名;
    @CsvField(order = 7, name = "被保険者番号")
    private final RString キー1被保険者番号;
    @CsvField(order = 8, name = "対象年度")
    private final RString 対象年度;
    @CsvField(order = 9, name = "エラー内容")
    private final RString エラー内容;

    /**
     * コンストラクタのメソッドです。
     *
     * @param 作成日時
     * @param 処理名
     * @param 証記載保険者番号
     * @param 被保険者番号
     * @param 被保険者カナ氏名
     * @param 被保険者氏名
     * @param キー1被保険者番号
     * @param 対象年度
     * @param エラー内容
     */
    public TyukonShoriKekkaKakuninListEntity(RString 作成日時, RString 処理名, RString 証記載保険者番号, RString 被保険者番号,
            RString 被保険者カナ氏名, RString 被保険者氏名, RString キー1被保険者番号, RString 対象年度, RString エラー内容) {
        this.作成日時 = 作成日時;
        this.処理名 = 処理名;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.被保険者カナ氏名 = 被保険者カナ氏名;
        this.被保険者氏名 = 被保険者氏名;
        this.キー1被保険者番号 = キー1被保険者番号;
        this.対象年度 = 対象年度;
        this.エラー内容 = エラー内容;
    }
}
