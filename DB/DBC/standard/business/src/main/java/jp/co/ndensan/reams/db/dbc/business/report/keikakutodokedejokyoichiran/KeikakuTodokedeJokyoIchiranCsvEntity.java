/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.keikakutodokedejokyoichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KeikakuTodokedeJokyoIchiranCsvEntity {

    @CsvField(order = 1, name = "作成日時")
    private final RString hakkoNichiji;
    @CsvField(order = 2, name = "処理名")
    private final RString syoriMei;
    @CsvField(order = 3, name = "被保険者番号")
    private final RString hihokenshaNo;
    @CsvField(order = 4, name = "エラー内容")
    private final RString eramesseji;
    @CsvField(order = 5, name = "備考")
    private final RString bikou;

    /**
     * コンストラクタです。
     *
     * @param hakkoNichiji 作成日時
     * @param syoriMei 処理名
     * @param hihokenshaNo 被保険者番号
     * @param eramesseji エラー内容
     * @param bikou 備考
     */
    public KeikakuTodokedeJokyoIchiranCsvEntity(RString hakkoNichiji, RString syoriMei, RString hihokenshaNo, RString eramesseji, RString bikou) {
        this.hakkoNichiji = hakkoNichiji;
        this.syoriMei = syoriMei;
        this.hihokenshaNo = hihokenshaNo;
        this.eramesseji = eramesseji;
        this.bikou = bikou;
    }

}
