/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査結果入手出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiListCsvEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private final RString shinseishoKanriNo;
    @CsvField(order = 2, name = "状態")
    private final RString jotai;
    @CsvField(order = 3, name = "保険者")
    private final RString hokensha;
    @CsvField(order = 4, name = "認定申請日")
    private final RString ninteiShinseiYMD;
    @CsvField(order = 5, name = "(被保険者)被保番号")
    private final RString hihokenshaNo;
    @CsvField(order = 6, name = "(被保険者)氏名")
    private final RString hihokenshaName;
    @CsvField(order = 7, name = "（申請区分）申請時コード")
    private final RString ninteiShinseiShinseijiKubunCode;
    @CsvField(order = 8, name = "（申請区分）申請時")
    private final RString ninteiShinseiShinseijiKubunName;
    @CsvField(order = 9, name = "(今回調査)調査委託先コード")
    private final RString ninteiChosaItakusakiCode;
    @CsvField(order = 10, name = "(今回調査)調査委託先")
    private final RString ninteiChosaItakusaki;
    @CsvField(order = 11, name = "(今回調査)調査員コード")
    private final RString ninteiChosainCode;
    @CsvField(order = 12, name = "(今回調査)調査員")
    private final RString chosainShimei;
    @CsvField(order = 13, name = "(調査票入手)調査実施日")
    private final RString ninteichosaJisshiYMD;
    @CsvField(order = 14, name = "(調査督促)督促発行日")
    private final RString ninteichosaTokusokuYMD;
    @CsvField(order = 15, name = "(調査督促)方法")
    private final RString ninteichosaTokusokuHoho;
    @CsvField(order = 16, name = "(調査督促)回数")
    private final RString ninteichosaTokusokuKaisu;
    @CsvField(order = 17, name = "(調査督促)期限")
    private final RString ninteichosaKigenYMD;
    @CsvField(order = 18, name = "地区コード")
    private final RString chikuCode;
    @CsvField(order = 19, name = "地区")
    private final RString chikuName;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param jotai 状態
     * @param hokensha 保険者
     * @param ninteiShinseiYMD 認定申請日
     * @param hihokenshaNo (被保険者)被保番号
     * @param hihokenshaName (被保険者)氏名
     * @param ninteiShinseiShinseijiKubunCode (申請区分)申請時コード
     * @param ninteiShinseiShinseijiKubunName (申請区分)申請日
     * @param ninteiChosaItakusakiCode (今回調査)調査委託先コード
     * @param ninteiChosaItakusaki (今回調査)調査委託先
     * @param ninteiChosainCode (今回調査)調査員コード
     * @param chosainShimei (今回調査)調査員
     * @param ninteichosaJisshiYMD (調査票入手)調査実施日
     * @param ninteichosaTokusokuYMD (調査督促)督促発行日
     * @param ninteichosaTokusokuHoho (調査督促)方法
     * @param ninteichosaTokusokuKaisu (調査督促)回数
     * @param ninteichosaKigenYMD (調査督促)期限
     * @param chikuCode 地区コード
     * @param chikuName 地区
     */
    public NinteichosaIraiListCsvEntity(
            RString shinseishoKanriNo,
            RString jotai,
            RString hokensha,
            RString ninteiShinseiYMD,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString ninteiShinseiShinseijiKubunCode,
            RString ninteiShinseiShinseijiKubunName,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosaItakusaki,
            RString ninteiChosainCode,
            RString chosainShimei,
            RString ninteichosaJisshiYMD,
            RString ninteichosaTokusokuYMD,
            RString ninteichosaTokusokuHoho,
            RString ninteichosaTokusokuKaisu,
            RString ninteichosaKigenYMD,
            RString chikuCode,
            RString chikuName) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.jotai = jotai;
        this.hokensha = hokensha;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
        this.ninteiShinseiShinseijiKubunName = ninteiShinseiShinseijiKubunName;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosaItakusaki = ninteiChosaItakusaki;
        this.ninteiChosainCode = ninteiChosainCode;
        this.chosainShimei = chosainShimei;
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
        this.ninteichosaTokusokuYMD = ninteichosaTokusokuYMD;
        this.ninteichosaTokusokuHoho = ninteichosaTokusokuHoho;
        this.ninteichosaTokusokuKaisu = ninteichosaTokusokuKaisu;
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
        this.chikuCode = chikuCode;
        this.chikuName = chikuName;
    }

}
