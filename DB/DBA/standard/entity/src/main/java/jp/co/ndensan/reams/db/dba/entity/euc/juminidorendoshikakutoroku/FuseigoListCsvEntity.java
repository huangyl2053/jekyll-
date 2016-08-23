/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連動資格登録（制御処理）取得Businessクラスです。
 *
 * @reamsid_L DBA-1410-011 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuseigoListCsvEntity {

    @CsvField(order = 1, name = "不整合コード")
    private RString 不整合コード;
    @CsvField(order = 2, name = "不整合内容")
    private RString 不整合内容;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "異動日")
    private RString 異動日;
    @CsvField(order = 5, name = "枝番")
    private RString 枝番;
    @CsvField(order = 6, name = "異動事由コード")
    private RString 被保険者台帳_異動事由コード;
    @CsvField(order = 7, name = "異動事由")
    private RString 被保険者台帳_異動事由;
    @CsvField(order = 8, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 9, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 10, name = "資格取得事由コード")
    private RString 資格取得事由コード;
    @CsvField(order = 11, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 12, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 13, name = "資格取得届出年月日")
    private RString 資格取得届出年月日;
    @CsvField(order = 14, name = "第１号資格取得年月日")
    private RString 第１号資格取得年月日;
    @CsvField(order = 15, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 16, name = "被保険者区分")
    private RString 被保険者区分;
    @CsvField(order = 17, name = "資格喪失事由コード")
    private RString 資格喪失事由コード;
    @CsvField(order = 18, name = "資格喪失事由")
    private RString 資格喪失事由;
    @CsvField(order = 19, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 20, name = "資格喪失届出年月日")
    private RString 資格喪失届出年月日;
    @CsvField(order = 21, name = "資格変更事由コード")
    private RString 資格変更事由コード;
    @CsvField(order = 22, name = "資格変更事由")
    private RString 資格変更事由;
    @CsvField(order = 23, name = "資格変更年月日")
    private RString 資格変更年月日;
    @CsvField(order = 24, name = "資格変更届出年月日")
    private RString 資格変更届出年月日;
    @CsvField(order = 25, name = "住所地特例適用事由コード")
    private RString 住所地特例適用事由コード;
    @CsvField(order = 26, name = "住所地特例適用事由")
    private RString 住所地特例適用事由;
    @CsvField(order = 27, name = "適用年月日")
    private RString 適用年月日;
    @CsvField(order = 28, name = "適用届出年月日")
    private RString 適用届出年月日;
    @CsvField(order = 29, name = "住所地特例解除事由コード")
    private RString 住所地特例解除事由コード;
    @CsvField(order = 30, name = "住所地特例解除事由")
    private RString 住所地特例解除事由;
    @CsvField(order = 31, name = "解除年月日")
    private RString 解除年月日;
    @CsvField(order = 32, name = "解除届出年月日")
    private RString 解除届出年月日;
    @CsvField(order = 33, name = "住所地特例フラグ")
    private RString 住所地特例フラグ;
    @CsvField(order = 34, name = "広域内住所地特例フラグ")
    private RString 広域内住所地特例フラグ;
    @CsvField(order = 35, name = "広住特措置元市町村コード")
    private RString 広住特措置元市町村コード;
    @CsvField(order = 36, name = "旧市町村コード")
    private RString 旧市町村コード;
    @CsvField(order = 37, name = "異動事由コード")
    private RString 住民異動情報_異動事由コード;
    @CsvField(order = 38, name = "異動事由")
    private RString 住民異動情報_異動事由;
    @CsvField(order = 39, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 40, name = "届出年月日")
    private RString 届出年月日;
    @CsvField(order = 41, name = "氏名")
    private RString 氏名;
    @CsvField(order = 42, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 43, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 44, name = "性別")
    private RString 性別;
}
