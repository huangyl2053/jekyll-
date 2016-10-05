/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private RString レコード区分;
    private RString 市町村コード;
    private RString 年金保険者コード;
    private RString 通知内容コード;
    private RString 予備1;
    private RString 制度コード;
    private FlexibleDate 作成年月日;
    private RString 基礎年金番号;
    private RString 年金コード;
    private RString 予備2;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString カナ氏名;
    private RString シフトコード1;
    private RString 漢字氏名;
    private RString シフトコード2;
    private YubinNo 郵便番号;
    private RString カナ住所;
    private RString シフトコード3;
    private RString 漢字住所;
    private RString シフトコード4;
    private FlexibleYear 対象年;
    private RString 訂正表示;
    private RString 各種区分;
    private RString 処理結果;
    private RString 予備3;
    private RString 予備4;
    private Decimal 金額１;
    private Decimal 金額予備1;
    private Decimal 金額予備2;
    private RString 予備5;
    private RString 共済年金証書記号番号;
}
