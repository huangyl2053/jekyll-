/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc710090;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト(過誤申立情報)連番出力しないCSVデータのEntityクラスです。
 *
 * @reamsid_L DBC-3095-020 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKagoMoshitateNoRenbanCsvEntity {

    @CsvField(order = 2, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 3, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 4, name = "氏名")
    private RString 氏名;
    @CsvField(order = 5, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 6, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 7, name = "年齢")
    private RString 年齢;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "続柄コード")
    private RString 続柄コード;
    @CsvField(order = 10, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 11, name = "世帯主名")
    private RString 世帯主名;
    @CsvField(order = 12, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 13, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 14, name = "住所＋番地＋方書")
    private RString 住所番地方書;
    @CsvField(order = 15, name = "住所")
    private RString 住所;
    @CsvField(order = 16, name = "番地")
    private RString 番地;
    @CsvField(order = 17, name = "方書")
    private RString 方書;
    @CsvField(order = 18, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 19, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 20, name = "地区１")
    private RString 地区１;
    @CsvField(order = 21, name = "地区２")
    private RString 地区２;
    @CsvField(order = 22, name = "地区３")
    private RString 地区３;
    @CsvField(order = 23, name = "連絡先１")
    private RString 連絡先１;
    @CsvField(order = 24, name = "連絡先２")
    private RString 連絡先２;
    @CsvField(order = 25, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 26, name = "登録事由")
    private RString 登録事由;
    @CsvField(order = 27, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 28, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 29, name = "住定事由")
    private RString 住定事由;
    @CsvField(order = 30, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 31, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 32, name = "消除事由")
    private RString 消除事由;
    @CsvField(order = 33, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 34, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 35, name = "前住所郵便番号")
    private RString 前住所郵便番号;
    @CsvField(order = 36, name = "前住所＋番地＋方書")
    private RString 前住所番地方書;
    @CsvField(order = 37, name = "前住所")
    private RString 前住所;
    @CsvField(order = 38, name = "前住所番地")
    private RString 前住所番地;
    @CsvField(order = 39, name = "前住所方書")
    private RString 前住所方書;
    @CsvField(order = 40, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 41, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 42, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 43, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 44, name = "空白")
    private RString 空白;
    @CsvField(order = 45, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 46, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 47, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 48, name = "資格取得届出日")
    private RString 資格取得届出日;
    @CsvField(order = 49, name = "喪失事由")
    private RString 喪失事由;
    @CsvField(order = 50, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 51, name = "資格喪失届日")
    private RString 資格喪失届日;
    @CsvField(order = 52, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 53, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 54, name = "（資格）証記載保険者番号")
    private RString 資格証記載保険者番号;
    @CsvField(order = 55, name = "二次予防適用開始日")
    private RString 二次予防適用開始日;
    @CsvField(order = 56, name = "二次予防適用終了日")
    private RString 二次予防適用終了日;
    @CsvField(order = 57, name = "二次予防調査実施日")
    private RString 二次予防調査実施日;
    @CsvField(order = 58, name = "二次予防決定日")
    private RString 二次予防決定日;
    @CsvField(order = 59, name = "過誤事業者番号")
    private RString 過誤事業者番号;
    @CsvField(order = 60, name = "過誤事業者名")
    private RString 過誤事業者名;
    @CsvField(order = 61, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 62, name = "（給付）証記載保険者番号")
    private RString 給付証記載保険者番号;
    @CsvField(order = 63, name = "申立年月日")
    private RString 申立年月日;
    @CsvField(order = 64, name = "申立者区分")
    private RString 申立者区分;
    @CsvField(order = 65, name = "申立事由コード")
    private RString 申立事由コード;
    @CsvField(order = 66, name = "申立事由")
    private RString 申立事由;
    @CsvField(order = 67, name = "国保連送付年月")
    private RString 国保連送付年月;
    @CsvField(order = 68, name = "過誤申立給付区分")
    private RString 過誤申立給付区分;
    @CsvField(order = 69, name = "受給申請事由")
    private RString 受給申請事由;
    @CsvField(order = 70, name = "受給申請日")
    private RString 受給申請日;
    @CsvField(order = 71, name = "受給要介護度")
    private RString 受給要介護度;
    @CsvField(order = 72, name = "受給認定開始日")
    private RString 受給認定開始日;
    @CsvField(order = 73, name = "受給認定終了日")
    private RString 受給認定終了日;
    @CsvField(order = 74, name = "受給認定日")
    private RString 受給認定日;
    @CsvField(order = 75, name = "受給旧措置")
    private RString 受給旧措置;
    @CsvField(order = 76, name = "受給みなし更新認定")
    private RString 受給みなし更新認定;
    @CsvField(order = 77, name = "受給直近事由")
    private RString 受給直近事由;

    /**
     * コンストラクタです。
     */
    public HanyoListKagoMoshitateNoRenbanCsvEntity() {
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
     * @param 住所番地方書 住所番地方書
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
     * @param 前住所番地方書 前住所番地方書
     * @param 前住所 前住所
     * @param 前住所番地 前住所番地
     * @param 前住所方書 前住所方書
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 保険者コード 保険者コード
     * @param 保険者名 保険者名
     * @param 空白 空白
     * @param 被保険者番号 被保険者番号
     * @param 資格取得事由 資格取得事由
     * @param 資格取得日 資格取得日
     * @param 資格取得届出日 資格取得届出日
     * @param 喪失事由 喪失事由
     * @param 資格喪失日 資格喪失日
     * @param 資格喪失届日 資格喪失届日
     * @param 資格区分 資格区分
     * @param 住所地特例状態 住所地特例状態
     * @param 資格証記載保険者番号 資格証記載保険者番号
     * @param 二次予防適用開始日 二次予防適用開始日
     * @param 二次予防適用終了日 二次予防適用終了日
     * @param 二次予防調査実施日 二次予防調査実施日
     * @param 二次予防決定日 二次予防決定日
     * @param 過誤事業者番号 過誤事業者番号
     * @param 過誤事業者名 過誤事業者名
     * @param サービス提供年月 サービス提供年月
     * @param 給付証記載保険者番号 給付証記載保険者番号
     * @param 申立年月日 申立年月日
     * @param 申立者区分 申立者区分
     * @param 申立事由コード 申立事由コード
     * @param 申立事由 申立事由
     * @param 国保連送付年月 国保連送付年月
     * @param 過誤申立給付区分 過誤申立給付区分
     * @param 受給申請事由 受給申請事由
     * @param 受給申請日 受給申請日
     * @param 受給要介護度 受給要介護度
     * @param 受給認定開始日 受給認定開始日
     * @param 受給認定終了日 受給認定終了日
     * @param 受給認定日 受給認定日
     * @param 受給旧措置 受給旧措置
     * @param 受給みなし更新認定 受給みなし更新認定
     * @param 受給直近事由 受給直近事由
     */
    public HanyoListKagoMoshitateNoRenbanCsvEntity(RString 識別コード, RString 住民種別, RString 氏名, RString 氏名カナ,
            RString 生年月日, RString 年齢, RString 性別, RString 続柄コード, RString 世帯コード, RString 世帯主名, RString 住所コード,
            RString 郵便番号, RString 住所番地方書, RString 住所, RString 番地, RString 方書, RString 行政区コード,
            RString 行政区名, RString 地区１, RString 地区２, RString 地区３, RString 連絡先１, RString 連絡先２,
            RString 登録異動日, RString 登録事由, RString 登録届出日, RString 住定異動日, RString 住定事由, RString 住定届出日,
            RString 消除異動日, RString 消除事由, RString 消除届出日, RString 転出入理由, RString 前住所郵便番号, RString 前住所番地方書,
            RString 前住所, RString 前住所番地, RString 前住所方書, RString 市町村コード, RString 市町村名, RString 保険者コード, RString 保険者名,
            RString 空白, RString 被保険者番号, RString 資格取得事由, RString 資格取得日, RString 資格取得届出日, RString 喪失事由,
            RString 資格喪失日, RString 資格喪失届日, RString 資格区分, RString 住所地特例状態, RString 資格証記載保険者番号,
            RString 二次予防適用開始日, RString 二次予防適用終了日, RString 二次予防調査実施日, RString 二次予防決定日,
            RString 過誤事業者番号, RString 過誤事業者名, RString サービス提供年月, RString 給付証記載保険者番号, RString 申立年月日,
            RString 申立者区分, RString 申立事由コード, RString 申立事由, RString 国保連送付年月, RString 過誤申立給付区分,
            RString 受給申請事由, RString 受給申請日, RString 受給要介護度, RString 受給認定開始日, RString 受給認定終了日,
            RString 受給認定日, RString 受給旧措置, RString 受給みなし更新認定, RString 受給直近事由) {
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
        this.住所番地方書 = 住所番地方書;
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
        this.前住所番地方書 = 前住所番地方書;
        this.前住所 = 前住所;
        this.前住所番地 = 前住所番地;
        this.前住所方書 = 前住所方書;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.保険者コード = 保険者コード;
        this.保険者名 = 保険者名;
        this.空白 = 空白;
        this.被保険者番号 = 被保険者番号;
        this.資格取得事由 = 資格取得事由;
        this.資格取得日 = 資格取得日;
        this.資格取得届出日 = 資格取得届出日;
        this.喪失事由 = 喪失事由;
        this.資格喪失日 = 資格喪失日;
        this.資格喪失届日 = 資格喪失届日;
        this.資格区分 = 資格区分;
        this.住所地特例状態 = 住所地特例状態;
        this.資格証記載保険者番号 = 資格証記載保険者番号;
        this.二次予防適用開始日 = 二次予防適用開始日;
        this.二次予防適用終了日 = 二次予防適用終了日;
        this.二次予防調査実施日 = 二次予防調査実施日;
        this.二次予防決定日 = 二次予防決定日;
        this.過誤事業者番号 = 過誤事業者番号;
        this.過誤事業者名 = 過誤事業者名;
        this.サービス提供年月 = サービス提供年月;
        this.給付証記載保険者番号 = 給付証記載保険者番号;
        this.申立年月日 = 申立年月日;
        this.申立者区分 = 申立者区分;
        this.申立事由コード = 申立事由コード;
        this.申立事由 = 申立事由;
        this.国保連送付年月 = 国保連送付年月;
        this.過誤申立給付区分 = 過誤申立給付区分;
        this.受給申請事由 = 受給申請事由;
        this.受給申請日 = 受給申請日;
        this.受給要介護度 = 受給要介護度;
        this.受給認定開始日 = 受給認定開始日;
        this.受給認定終了日 = 受給認定終了日;
        this.受給認定日 = 受給認定日;
        this.受給旧措置 = 受給旧措置;
        this.受給みなし更新認定 = 受給みなし更新認定;
        this.受給直近事由 = 受給直近事由;
    }
}
