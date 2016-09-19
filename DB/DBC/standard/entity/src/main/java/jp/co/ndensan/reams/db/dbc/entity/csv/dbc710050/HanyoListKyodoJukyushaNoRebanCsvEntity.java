/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc710050;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_共同処理用受給者情報（基本）連番出力しないCSVデータのEntityクラスです。
 *
 * @reamsid_L DBC-3097-020 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyodoJukyushaNoRebanCsvEntity {

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
    @CsvField(order = 13, name = "住所＋番地＋方書")
    private RString 住所番地方書;
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
    @CsvField(order = 35, name = "前住所＋番地＋方書")
    private RString 前住所番地方書;
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
    @CsvField(order = 44, name = "処理対象年月")
    private RString 処理対象年月;
    @CsvField(order = 45, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 46, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 47, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 48, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 49, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 50, name = "（給付）証記載保険者番号")
    private RString 給付_証記載保険者番号;
    @CsvField(order = 51, name = "被保険者氏名漢字")
    private RString 被保険者氏名漢字;
    @CsvField(order = 52, name = "送付郵便番号")
    private RString 送付郵便番号;
    @CsvField(order = 53, name = "送付住所カナ")
    private RString 送付住所カナ;
    @CsvField(order = 54, name = "送付住所")
    private RString 送付住所;
    @CsvField(order = 55, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 56, name = "帳票出力順序コード")
    private RString 帳票出力順序コード;

    /**
     * コンストラクタです。
     */
    public HanyoListKyodoJukyushaNoRebanCsvEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 住民種別 住民種別
     * @param 氏名 氏名
     * @param 氏名カナ 氏名カナ
     * @param 生年月日 生年月日
     * @param 年齢 年齢
     * @param 性別 性別
     * @param 続柄コード 続柄コード
     * @param 世帯コード 世帯コード
     * @param 世帯主名 世帯主名
     * @param 住所コード 住所コード
     * @param 郵便番号 郵便番号
     * @param 住所_番地_方書 住所_番地_方書
     * @param 住所 住所
     * @param 番地 番地
     * @param 方書 方書
     * @param 行政区コード 行政区コード
     * @param 行政区名 行政区名
     * @param 地区１ 地区１
     * @param 地区２ 地区２
     * @param 地区３ 地区３
     * @param 連絡先１ 連絡先１
     * @param 連絡先２ 連絡先２
     * @param 登録異動日 登録異動日
     * @param 登録事由 登録事由
     * @param 登録届出日 登録届出日
     * @param 住定異動日 住定異動日
     * @param 住定事由 住定事由
     * @param 住定届出日 住定届出日
     * @param 消除異動日 消除異動日
     * @param 消除事由 消除事由
     * @param 消除届出日 消除届出日
     * @param 転出入理由 転出入理由
     * @param 前住所郵便番号 前住所郵便番号
     * @param 前住所_番地_方書 前住所_番地_方書
     * @param 前住所 前住所
     * @param 前住所番地 前住所番地
     * @param 前住所方書 前住所方書
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 保険者コード 保険者コード
     * @param 保険者名 保険者名
     * @param 空白 空白
     * @param 処理対象年月 処理対象年月
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 異動年月日 異動年月日
     * @param 異動区分 異動区分
     * @param 異動事由 異動事由
     * @param （給付）証記載保険者番号 （給付）証記載保険者番号
     * @param 被保険者氏名漢字 被保険者氏名漢字
     * @param 送付郵便番号 送付郵便番号
     * @param 送付住所カナ 送付住所カナ
     * @param 送付住所 送付住所
     * @param 電話番号 電話番号
     * @param 帳票出力順序コード 帳票出力順序コード
     *
     */
    public HanyoListKyodoJukyushaNoRebanCsvEntity(RString 識別コード,
            RString 住民種別, RString 氏名, RString 氏名カナ, RString 生年月日, RString 年齢,
            RString 性別, RString 続柄コード, RString 世帯コード, RString 世帯主名, RString 住所コード,
            RString 郵便番号, RString 住所_番地_方書, RString 住所, RString 番地, RString 方書, RString 行政区コード,
            RString 行政区名, RString 地区１, RString 地区２, RString 地区３, RString 連絡先１, RString 連絡先２,
            RString 登録異動日, RString 登録事由, RString 登録届出日, RString 住定異動日, RString 住定事由, RString 住定届出日,
            RString 消除異動日, RString 消除事由, RString 消除届出日, RString 転出入理由, RString 前住所郵便番号, RString 前住所_番地_方書,
            RString 前住所, RString 前住所番地, RString 前住所方書, RString 市町村コード, RString 市町村名, RString 保険者コード,
            RString 保険者名, RString 空白, RString 処理対象年月, RString 被保険者番号, RString 履歴番号, RString 異動年月日, RString 異動区分,
            RString 異動事由, RString 給付_証記載保険者番号, RString 被保険者氏名漢字, RString 送付郵便番号, RString 送付住所カナ,
            RString 送付住所, RString 電話番号, RString 帳票出力順序コード) {
        this.識別コード = 識別コード;
        this.住民種別 = 住民種別;
        this.氏名 = 氏名;
        this.氏名カナ = 氏名カナ;
        this.生年月日 = 生年月日;
        this.年齢 = 年齢;
        this.性別 = 性別;
        this.続柄コード = 続柄コード;
        this.世帯コード = 世帯コード;
        this.世帯主名 = 世帯主名;
        this.住所コード = 住所コード;
        this.郵便番号 = 郵便番号;
        this.住所番地方書 = 住所_番地_方書;
        this.住所 = 住所;
        this.番地 = 番地;
        this.方書 = 方書;
        this.行政区コード = 行政区コード;
        this.行政区名 = 行政区名;
        this.地区１ = 地区１;
        this.地区２ = 地区２;
        this.地区３ = 地区３;
        this.連絡先１ = 連絡先１;
        this.連絡先２ = 連絡先２;
        this.登録異動日 = 登録異動日;
        this.登録事由 = 登録事由;
        this.登録届出日 = 登録届出日;
        this.住定異動日 = 住定異動日;
        this.住定事由 = 住定事由;
        this.住定届出日 = 住定届出日;
        this.消除異動日 = 消除異動日;
        this.消除事由 = 消除事由;
        this.消除届出日 = 消除届出日;
        this.転出入理由 = 転出入理由;
        this.前住所郵便番号 = 前住所郵便番号;
        this.前住所番地方書 = 前住所_番地_方書;
        this.前住所 = 前住所;
        this.前住所番地 = 前住所番地;
        this.前住所方書 = 前住所方書;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.保険者コード = 保険者コード;
        this.保険者名 = 保険者名;
        this.空白 = 空白;
        this.処理対象年月 = 処理対象年月;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.異動年月日 = 異動年月日;
        this.異動区分 = 異動区分;
        this.異動事由 = 異動事由;
        this.給付_証記載保険者番号 = 給付_証記載保険者番号;
        this.被保険者氏名漢字 = 被保険者氏名漢字;
        this.送付郵便番号 = 送付郵便番号;
        this.送付住所カナ = 送付住所カナ;
        this.送付住所 = 送付住所;
        this.電話番号 = 電話番号;
        this.帳票出力順序コード = 帳票出力順序コード;
    }
}
