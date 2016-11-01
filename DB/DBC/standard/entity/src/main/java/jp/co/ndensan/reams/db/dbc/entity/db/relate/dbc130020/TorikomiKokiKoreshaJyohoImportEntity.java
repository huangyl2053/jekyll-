/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 取込後期高齢者情報のEntityクラスです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiKokiKoreshaJyohoImportEntity extends DbTableEntityBase<TorikomiKokiKoreshaJyohoImportEntity> implements IDbAccessable {

    @CsvField(order = 10, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 20, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 30, name = "後期高齢保険者番号(市町村)")
    private RString 後期高齢保険者番号_市町村;
    @CsvField(order = 40, name = "後期高齢保険者番号(広域)")
    private RString 後期高齢保険者番号_広域;
    @CsvField(order = 50, name = "後期高齢被保険者番号")
    private RString 後期高齢被保険者番号;
    @CsvField(order = 60, name = "資格取得事由コード")
    private RString 資格取得事由コード;
    @CsvField(order = 70, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 80, name = "資格喪失事由コード")
    private RString 資格喪失事由コード;
    @CsvField(order = 90, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 100, name = "保険者適用開始日")
    private RString 保険者適用開始日;
    @CsvField(order = 110, name = "保険者適用終了日")
    private RString 保険者適用終了日;
    @CsvField(order = 120, name = "個人区分コード")
    private RString 個人区分コード;
    @CsvField(order = 130, name = "登録区分")
    private RString 登録区分;

}
