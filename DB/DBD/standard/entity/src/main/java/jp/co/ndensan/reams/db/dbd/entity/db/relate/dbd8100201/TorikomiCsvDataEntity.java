/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取込データ一時作成_共有ファイルに取得CSVデータEntityクラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiCsvDataEntity {

    @FldField(order = 0, length = 6)
    private RString 提出元ID;
    @FldField(order = 6, length = 3)
    private RString 媒体通番;
    @FldField(order = 9, length = 8)
    private RString 作成年月日1;
    @FldField(order = 17, length = 31)
    private RString 予備;
    @FldField(order = 48, length = 6)
    private RString ファイル格納件数;
    @FldField(order = 54, length = 42)
    private RString 予備0;
    @FldField(order = 96, length = 1)
    private RString ヘッダレコード区分;
    @FldField(order = 97, length = 5)
    private RString ヘッダ市町村コード;
    @FldField(order = 102, length = 3)
    private RString ヘッダ年金保険者コード;
    @FldField(order = 105, length = 2)
    private RString ヘッダ通知内容コード;
    @FldField(order = 107, length = 1)
    private RString ヘッダ媒体コード;
    @FldField(order = 108, length = 1)
    private RString ヘッダ制度コード;
    @FldField(order = 109, length = 8)
    private RString ヘッダ作成年月日;
    @FldField(order = 117, length = 479)
    private RString ヘッダ予備;
    @FldField(order = 596, length = 1)
    private RString レコード区分;
    @FldField(order = 597, length = 5)
    private RString 市町村コード;
    @FldField(order = 602, length = 3)
    private RString 年金保険者コード;
    @FldField(order = 605, length = 2)
    private RString 通知内容コード;
    @FldField(order = 607, length = 1)
    private RString 予備1;
    @FldField(order = 608, length = 1)
    private RString 制度コード;
    @FldField(order = 609, length = 8)
    private RString 作成年月日;
    @FldField(order = 617, length = 10)
    private RString 基礎年金番号;
    @FldField(order = 627, length = 4)
    private RString 年金コード;
    @FldField(order = 631, length = 3)
    private RString 予備2;
    @FldField(order = 634, length = 8)
    private RString 生年月日;
    @FldField(order = 642, length = 1)
    private RString 性別;
    @FldField(order = 643, length = 25)
    private RString カナ氏名;
    @FldField(order = 668, length = 3)
    private RString シフトコード1;
    @FldField(order = 671, length = 50)
    private RString 漢字氏名;
    @FldField(order = 721, length = 3)
    private RString シフトコード2;
    @FldField(order = 724, length = 7)
    private RString 郵便番号;
    @FldField(order = 731, length = 80)
    private RString カナ住所;
    @FldField(order = 811, length = 3)
    private RString シフトコード3;
    @FldField(order = 814, length = 160)
    private RString 漢字住所;
    @FldField(order = 974, length = 3)
    private RString シフトコード4;
    @FldField(order = 977, length = 4)
    private RString 対象年;
    @FldField(order = 981, length = 1)
    private RString 訂正表示;
    @FldField(order = 982, length = 2)
    private RString 各種区分;
    @FldField(order = 984, length = 2)
    private RString 処理結果;
    @FldField(order = 986, length = 1)
    private RString 予備3;
    @FldField(order = 987, length = 8)
    private RString 予備4;
    @FldField(order = 995, length = 11)
    private RString 金額１;
    @FldField(order = 1006, length = 11)
    private RString 金額予備1;
    @FldField(order = 1017, length = 11)
    private RString 金額予備2;
    @FldField(order = 1028, length = 53)
    private RString 予備5;
    @FldField(order = 1081, length = 15)
    private RString 共済年金証書記号番号;
    @FldField(order = 1096, length = 1)
    private RString トレイラレコード区分;
    @FldField(order = 1097, length = 5)
    private RString トレイラ市町村コード;
    @FldField(order = 1102, length = 3)
    private RString トレイラ年金保険者コード;
    @FldField(order = 1105, length = 2)
    private RString トレイラ通知内容コード;
    @FldField(order = 1107, length = 1)
    private RString トレイラ予備;
    @FldField(order = 1108, length = 1)
    private RString トレイラ制度コード;
    @FldField(order = 1109, length = 8)
    private RString トレイラ作成年月日;
    @FldField(order = 1117, length = 9)
    private RString トレイラ合計件数;
    @FldField(order = 1126, length = 11)
    private RString トレイラレ金額１;
    @FldField(order = 1137, length = 11)
    private RString トレイラ金額予備1;
    @FldField(order = 1148, length = 11)
    private RString トレイラ金額予備2;
    @FldField(order = 1159, length = 437)
    private RString トレイラ予備1;
}
