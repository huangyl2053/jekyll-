/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_生活保護受給者CsvEntity(連番なし)。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuhogoJukyushaCsvEntity {

    @CsvField(order = 1, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 2, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 3, name = "氏名")
    private RString 氏名;
    @CsvField(order = 4, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 5, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 6, name = "年齢")
    private RString 年齢;
    @CsvField(order = 7, name = "性別")
    private RString 性別;
    @CsvField(order = 8, name = "続柄コード")
    private RString 続柄コード;
    @CsvField(order = 9, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 10, name = "世帯主名")
    private RString 世帯主名;
    @CsvField(order = 11, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 12, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 13, name = "住所_番地_方書")
    private RString 住所_番地_方書;
    @CsvField(order = 14, name = "住所")
    private RString 住所;
    @CsvField(order = 15, name = "番地")
    private RString 番地;
    @CsvField(order = 16, name = "方書")
    private RString 方書;
    @CsvField(order = 17, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 18, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 19, name = "地区１")
    private RString 地区１;
    @CsvField(order = 20, name = "地区２")
    private RString 地区２;
    @CsvField(order = 21, name = "地区３")
    private RString 地区３;
    @CsvField(order = 22, name = "連絡先１")
    private RString 連絡先１;
    @CsvField(order = 23, name = "連絡先２")
    private RString 連絡先２;
    @CsvField(order = 24, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 25, name = "登録事由")
    private RString 登録事由;
    @CsvField(order = 26, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 27, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 28, name = "住定事由")
    private RString 住定事由;
    @CsvField(order = 29, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 30, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 31, name = "消除事由")
    private RString 消除事由;
    @CsvField(order = 32, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 33, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 34, name = "前住所郵便番号")
    private RString 前住所郵便番号;
    @CsvField(order = 35, name = "前住所_番地_方書")
    private RString 前住所_番地_方書;
    @CsvField(order = 36, name = "前住所")
    private RString 前住所;
    @CsvField(order = 37, name = "前住所番地")
    private RString 前住所番地;
    @CsvField(order = 38, name = "前住所方書")
    private RString 前住所方書;
    @CsvField(order = 39, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 40, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 41, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 42, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 43, name = "空白")
    private RString 空白;
    @CsvField(order = 44, name = "送付先氏名")
    private RString 送付先氏名;
    @CsvField(order = 45, name = "送付先氏名カナ")
    private RString 送付先氏名カナ;
    @CsvField(order = 46, name = "送付先住所コード")
    private RString 送付先住所コード;
    @CsvField(order = 47, name = "送付先郵便番号")
    private RString 送付先郵便番号;
    @CsvField(order = 48, name = "送付先住所_番地_方書")
    private RString 送付先住所_番地_方書;
    @CsvField(order = 49, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 50, name = "送付先番地")
    private RString 送付先番地;
    @CsvField(order = 51, name = "送付先方書")
    private RString 送付先方書;
    @CsvField(order = 52, name = "送付先行政区コード")
    private RString 送付先行政区コード;
    @CsvField(order = 53, name = "送付先行政区名")
    private RString 送付先行政区名;
    @CsvField(order = 54, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 55, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 56, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 57, name = "資格取得届出日")
    private RString 資格取得届出日;
    @CsvField(order = 58, name = "喪失事由")
    private RString 喪失事由;
    @CsvField(order = 59, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 60, name = "資格喪失届日")
    private RString 資格喪失届日;
    @CsvField(order = 61, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 62, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 63, name = "資格_証記載保険者番号")
    private RString 資格_証記載保険者番号;
    @CsvField(order = 64, name = "老齢福祉年金開始日")
    private RString 老齢福祉年金開始日;
    @CsvField(order = 65, name = "老齢福祉年金終了日")
    private RString 老齢福祉年金終了日;
    @CsvField(order = 66, name = "生活保護開始日")
    private RString 生活保護開始日;
    @CsvField(order = 67, name = "生活保護終了日")
    private RString 生活保護終了日;
    @CsvField(order = 68, name = "生活保護種別")
    private RString 生活保護種別;
    @CsvField(order = 69, name = "医療保険種別")
    private RString 医療保険種別;
    @CsvField(order = 70, name = "医療保険番号")
    private RString 医療保険番号;
    @CsvField(order = 71, name = "医療保険者名")
    private RString 医療保険者名;
    @CsvField(order = 72, name = "医療保険記号番号")
    private RString 医療保険記号番号;
}
