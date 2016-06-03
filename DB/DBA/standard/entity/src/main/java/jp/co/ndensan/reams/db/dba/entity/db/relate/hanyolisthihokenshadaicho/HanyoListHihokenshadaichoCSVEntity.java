/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisthihokenshadaicho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_被保険者台帳CSVEntityクラスです。
 *
 * @reamsid_L DBA-1610-030 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListHihokenshadaichoCSVEntity {

    @CsvField(order = 0, name = "連番")
    private final RString 連番;
    @CsvField(order = 10, name = "識別コード")
    private final ShikibetsuCode 識別コード;
    @CsvField(order = 20, name = "住民種別")
    private final RString 住民種別;
    @CsvField(order = 30, name = "氏名")
    private final AtenaMeisho 氏名;
    @CsvField(order = 40, name = "氏名カナ")
    private final AtenaKanaMeisho 氏名カナ;
    @CsvField(order = 50, name = "生年月日")
    private final RString 生年月日;
    @CsvField(order = 60, name = "年齢")
    private final RString 年齢;
    @CsvField(order = 70, name = "性別")
    private final RString 性別;
    @CsvField(order = 80, name = "続柄コード")
    private final TsuzukigaraCode 続柄コード;
    @CsvField(order = 90, name = "世帯コード")
    private final SetaiCode 世帯コード;
    @CsvField(order = 100, name = "世帯主名")
    private final AtenaMeisho 世帯主名;
    @CsvField(order = 110, name = "住所コード")
    private final ZenkokuJushoCode 住所コード;
    @CsvField(order = 120, name = "郵便番号")
    private final RString 郵便番号;
    @CsvField(order = 130, name = "住所_番地_方書")
    private final RString 住所_番地_方書;
    @CsvField(order = 140, name = "住所")
    private final AtenaJusho 住所;
    @CsvField(order = 150, name = "番地")
    private final AtenaBanchi 番地;
    @CsvField(order = 160, name = "方書")
    private final Katagaki 方書;
    @CsvField(order = 170, name = "行政区コード")
    private final GyoseikuCode 行政区コード;
    @CsvField(order = 180, name = "行政区名")
    private final RString 行政区名;
    @CsvField(order = 190, name = "地区１")
    private final RString 地区１;
    @CsvField(order = 200, name = "地区２")
    private final RString 地区２;
    @CsvField(order = 210, name = "地区３")
    private final RString 地区３;
    @CsvField(order = 220, name = "連絡先１")
    private final TelNo 連絡先１;
    @CsvField(order = 230, name = "連絡先２")
    private final TelNo 連絡先２;
    @CsvField(order = 240, name = "登録異動日")
    private final RString 登録異動日;
    @CsvField(order = 250, name = "登録事由")
    private final RString 登録事由;
    @CsvField(order = 260, name = "登録届出日")
    private final RString 登録届出日;
    @CsvField(order = 270, name = "住定異動日")
    private final RString 住定異動日;
    @CsvField(order = 280, name = "住定事由")
    private final RString 住定事由;
    @CsvField(order = 290, name = "住定届出日")
    private final RString 住定届出日;
    @CsvField(order = 300, name = "消除異動日")
    private final RString 消除異動日;
    @CsvField(order = 310, name = "消除事由")
    private final RString 消除事由;
    @CsvField(order = 320, name = "消除届出日")
    private final RString 消除届出日;
    @CsvField(order = 330, name = "転出入理由")
    private final RString 転出入理由;
    @CsvField(order = 340, name = "前住所郵便番号")
    private final YubinNo 前住所郵便番号;
    @CsvField(order = 350, name = "前住所_番地_方書")
    private final RString 前住所_番地_方書;
    @CsvField(order = 360, name = "前住所")
    private final AtenaJusho 前住所;
    @CsvField(order = 370, name = "前住所番地")
    private final AtenaBanchi 前住所番地;
    @CsvField(order = 380, name = "前住所方書")
    private final Katagaki 前住所方書;
    @CsvField(order = 390, name = "市町村コード")
    private final LasdecCode 市町村コード;
    @CsvField(order = 400, name = "市町村名")
    private final RString 市町村名;
    @CsvField(order = 410, name = "保険者コード")
    private final LasdecCode 保険者コード;
    @CsvField(order = 420, name = "保険者名")
    private final RString 保険者名;
    @CsvField(order = 430, name = "空白")
    private final RString 空白;
    @CsvField(order = 440, name = "送付先氏名")
    private final AtenaMeisho 送付先氏名;
    @CsvField(order = 450, name = "送付先氏名カナ")
    private final AtenaKanaMeisho 送付先氏名カナ;
    @CsvField(order = 460, name = "送付先住所コード")
    private final ZenkokuJushoCode 送付先住所コード;
    @CsvField(order = 470, name = "送付先郵便番号")
    private final RString 送付先郵便番号;
    @CsvField(order = 480, name = "送付先住所_番地_方書")
    private final RString 送付先住所_番地_方書;
    @CsvField(order = 490, name = "送付先住所")
    private final AtenaJusho 送付先住所;
    @CsvField(order = 500, name = "送付先番地")
    private final AtenaBanchi 送付先番地;
    @CsvField(order = 510, name = "送付先方書")
    private final Katagaki 送付先方書;
    @CsvField(order = 520, name = "送付先行政区コード")
    private final GyoseikuCode 送付先行政区コード;
    @CsvField(order = 530, name = "送付先行政区名")
    private final RString 送付先行政区名;
    @CsvField(order = 540, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 550, name = "資格取得事由")
    private final RString 資格取得事由;
    @CsvField(order = 560, name = "資格取得日")
    private final RString 資格取得日;
    @CsvField(order = 570, name = "資格取得届出日")
    private final RString 資格取得届出日;
    @CsvField(order = 580, name = "喪失事由")
    private final RString 喪失事由;
    @CsvField(order = 590, name = "資格喪失日")
    private final RString 資格喪失日;
    @CsvField(order = 600, name = "資格喪失届日")
    private final RString 資格喪失届日;
    @CsvField(order = 610, name = "資格区分")
    private final RString 資格区分;
    @CsvField(order = 620, name = "住所地特例状態")
    private final RString 住所地特例状態;
    @CsvField(order = 630, name = "資格_証記載保険者番号")
    private final RString 資格_証記載保険者番号;

    /**
     * コンストラクタ。
     *
     * @param 連番 連番
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
     * @param 送付先氏名 送付先氏名
     * @param 送付先氏名カナ 送付先氏名カナ
     * @param 送付先住所コード 送付先住所コード
     * @param 送付先郵便番号 送付先郵便番号
     * @param 送付先住所_番地_方書 送付先住所_番地_方書
     * @param 送付先住所 送付先住所
     * @param 送付先番地 送付先番地
     * @param 送付先方書 送付先方書
     * @param 送付先行政区コード 送付先行政区コード
     * @param 送付先行政区名 送付先行政区名
     * @param 被保険者番号 被保険者番号
     * @param 資格取得事由 資格取得事由
     * @param 資格取得日 資格取得日
     * @param 資格取得届出日 資格取得届出日
     * @param 喪失事由 喪失事由
     * @param 資格喪失日 資格喪失日
     * @param 資格喪失届日 資格喪失届日
     * @param 資格区分 資格区分
     * @param 住所地特例状態 住所地特例状態
     * @param 資格_証記載保険者番号 資格_証記載保険者番号
     */
    public HanyoListHihokenshadaichoCSVEntity(
            RString 連番,
            ShikibetsuCode 識別コード,
            RString 住民種別,
            AtenaMeisho 氏名,
            AtenaKanaMeisho 氏名カナ,
            RString 生年月日,
            RString 年齢,
            RString 性別,
            TsuzukigaraCode 続柄コード,
            SetaiCode 世帯コード,
            AtenaMeisho 世帯主名,
            ZenkokuJushoCode 住所コード,
            RString 郵便番号,
            RString 住所_番地_方書,
            AtenaJusho 住所,
            AtenaBanchi 番地,
            Katagaki 方書,
            GyoseikuCode 行政区コード,
            RString 行政区名,
            RString 地区１,
            RString 地区２,
            RString 地区３,
            TelNo 連絡先１,
            TelNo 連絡先２,
            RString 登録異動日,
            RString 登録事由,
            RString 登録届出日,
            RString 住定異動日,
            RString 住定事由,
            RString 住定届出日,
            RString 消除異動日,
            RString 消除事由,
            RString 消除届出日,
            RString 転出入理由,
            YubinNo 前住所郵便番号,
            RString 前住所_番地_方書,
            AtenaJusho 前住所,
            AtenaBanchi 前住所番地,
            Katagaki 前住所方書,
            LasdecCode 市町村コード,
            RString 市町村名,
            LasdecCode 保険者コード,
            RString 保険者名,
            RString 空白,
            AtenaMeisho 送付先氏名,
            AtenaKanaMeisho 送付先氏名カナ,
            ZenkokuJushoCode 送付先住所コード,
            RString 送付先郵便番号,
            RString 送付先住所_番地_方書,
            AtenaJusho 送付先住所,
            AtenaBanchi 送付先番地,
            Katagaki 送付先方書,
            GyoseikuCode 送付先行政区コード,
            RString 送付先行政区名,
            RString 被保険者番号,
            RString 資格取得事由,
            RString 資格取得日,
            RString 資格取得届出日,
            RString 喪失事由,
            RString 資格喪失日,
            RString 資格喪失届日,
            RString 資格区分,
            RString 住所地特例状態,
            RString 資格_証記載保険者番号) {
        this.連番 = 連番;
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
        this.住所_番地_方書 = 住所_番地_方書;
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
        this.前住所_番地_方書 = 前住所_番地_方書;
        this.前住所 = 前住所;
        this.前住所番地 = 前住所番地;
        this.前住所方書 = 前住所方書;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.保険者コード = 保険者コード;
        this.保険者名 = 保険者名;
        this.空白 = 空白;
        this.送付先氏名 = 送付先氏名;
        this.送付先氏名カナ = 送付先氏名カナ;
        this.送付先住所コード = 送付先住所コード;
        this.送付先郵便番号 = 送付先郵便番号;
        this.送付先住所_番地_方書 = 送付先住所_番地_方書;
        this.送付先住所 = 送付先住所;
        this.送付先番地 = 送付先番地;
        this.送付先方書 = 送付先方書;
        this.送付先行政区コード = 送付先行政区コード;
        this.送付先行政区名 = 送付先行政区名;
        this.被保険者番号 = 被保険者番号;
        this.資格取得事由 = 資格取得事由;
        this.資格取得日 = 資格取得日;
        this.資格取得届出日 = 資格取得届出日;
        this.喪失事由 = 喪失事由;
        this.資格喪失日 = 資格喪失日;
        this.資格喪失届日 = 資格喪失届日;
        this.資格区分 = 資格区分;
        this.住所地特例状態 = 住所地特例状態;
        this.資格_証記載保険者番号 = 資格_証記載保険者番号;
    }
}
