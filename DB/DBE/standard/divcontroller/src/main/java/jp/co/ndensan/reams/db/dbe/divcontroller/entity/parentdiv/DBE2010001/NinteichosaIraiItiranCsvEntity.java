/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査依頼（認定調査依頼一覧）出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiItiranCsvEntity {

    @CsvField(order = 1, name = "状態")
    private final RString jotai;
    @CsvField(order = 2, name = "申請書管理番号")
    private final RString shinseishoKanriNo;
    @CsvField(order = 3, name = "保険者")
    private final RString hihokensha;
    @CsvField(order = 4, name = "認定申請日")
    private final RString ninteiShinseiYMD;
    @CsvField(order = 5, name = "(被保険者)被保番号")
    private final RString hihokenshaNo;
    @CsvField(order = 6, name = "(被保険者)氏名")
    private final RString hihokenshaName;
    @CsvField(order = 7, name = "(申請区分)申請時コード")
    private final RString ninteiShinseiShinseijiKubunCode;
    @CsvField(order = 8, name = "(申請区分)申請時")
    private final RString ninteiShinseiShinseijiKubunName;
    @CsvField(order = 9, name = "(調査依頼)再調査回数")
    private final RString saiChosaIraiKaisu;
    @CsvField(order = 10, name = "(調査依頼)依頼書発行日")
    private final RString iraishoHakkoYMD;
    @CsvField(order = 11, name = "(調査依頼)調査票等出力年月日")
    private final RString chosahyoTouShutsuryokuYMD;
    @CsvField(order = 12, name = "(調査依頼)データ出力日")
    private final RString dataShutsuryokuYMD;
    @CsvField(order = 13, name = "(調査依頼)調査期限")
    private final RString ninteichosaKigenYMD;
    @CsvField(order = 14, name = "(調査依頼)調査依頼区分")
    private final RString ninteichosaIraiKubun;
    @CsvField(order = 15, name = "(今回調査)調査委託先")
    private final RString ninteichosaItakusaki;
    @CsvField(order = 16, name = "(今回調査)調査員")
    private final RString chosainShimei;
    @CsvField(order = 17, name = "(今回調査)調査回数")
    private final RString ninteichosaIraiKaisu;
    @CsvField(order = 18, name = "(前回調査)調査委託先")
    private final RString zenkaiChosaItakusaki;
    @CsvField(order = 19, name = "(前回調査)調査員")
    private final RString zenkaiChosain;
    @CsvField(order = 20, name = "(前々回調査)調査委託先")
    private final RString zenzenkaiChosaItakusaki;
    @CsvField(order = 21, name = "(前々回調査)調査員")
    private final RString zenzenkaiChosain;
    @CsvField(order = 22, name = "郵便番号")
    private final RString yubinNo;
    @CsvField(order = 23, name = "住所")
    private final RString jusho;
    @CsvField(order = 24, name = "入所施設")
    private final RString nyushoShisetsu;
    @CsvField(order = 25, name = "(調査督促)督促発行日")
    private final RString ninteichosaTokusokuYMD;
    @CsvField(order = 26, name = "(調査督促)方法")
    private final RString ninteichosaTokusokuHoho;
    @CsvField(order = 27, name = "(調査督促)回数")
    private final RString ninteichosaTokusokuKaisu;
    @CsvField(order = 28, name = "(調査督促)期限")
    private final RString ninteichosaKusokuKigenYMD;
    @CsvField(order = 29, name = "(調査督促)地区コード")
    private final RString chikuCode;
    @CsvField(order = 30, name = "(調査督促)地区")
    private final RString chikuName;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param hihokensha 保険者
     * @param ninteiShinseiYMD 認定申請日
     * @param hihokenshaNo (被保険者)被保番号
     * @param hihokenshaName (被保険者)氏名
     * @param ninteiShinseiShinseijiKubunCode (申請区分)申請時コード
     * @param ninteiShinseiShinseijiKubunName (申請区分)申請時
     * @param ninteichosaIraiKanryoYMD (調査依頼)完了日
     * @param saiChosaIraiKaisu (調査依頼)再調査回数
     * @param iraishoHakkoYMD (調査依頼)依頼書発行日
     * @param chosahyoTouShutsuryokuYMD (調査依頼)調査票等出力年月日
     * @param dataShutsuryokuYMD (調査依頼)データ出力日
     * @param ninteichosaKigenYMD (調査依頼)調査期限
     * @param ninteichosaIraiKubun (調査依頼)調査依頼区分
     * @param ninteichosaItakusaki (今回調査)調査委託先
     * @param chosainShimei (今回調査)調査員
     * @param ninteichosaIraiKaisu (今回調査)調査回数
     * @param zenkaiChosaItakusaki (前回調査)調査委託先
     * @param zenkaiChosain (前回調査)調査員
     * @param zenzenkaiChosaItakusaki (前々回調査)調査委託先
     * @param zenzenkaiChosain (前々回調査)調査員
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param nyushoShisetsu 入所施設
     * @param ninteichosaTokusokuYMD (調査督促)督促発行日
     * @param ninteichosaTokusokuHoho (調査督促)方法
     * @param ninteichosaTokusokuKaisu (調査督促)回数
     * @param ninteichosaKusokuKigenYMD (調査督促)期限
     * @param chikuCode (調査督促)地区コード
     * @param chikuName (調査督促)地区
     *
     */
    public NinteichosaIraiItiranCsvEntity(
        RString jotai,
        RString shinseishoKanriNo,
        RString hihokensha,
        RString ninteiShinseiYMD,
        RString hihokenshaNo,
        RString hihokenshaName,
        RString ninteiShinseiShinseijiKubunCode,
        RString ninteiShinseiShinseijiKubunName,
        RString saiChosaIraiKaisu,
        RString iraishoHakkoYMD,
        RString chosahyoTouShutsuryokuYMD,
        RString dataShutsuryokuYMD,
        RString ninteichosaKigenYMD,
        RString ninteichosaIraiKubun,
        RString ninteichosaItakusaki,
        RString chosainShimei,
        RString ninteichosaIraiKaisu,
        RString zenkaiChosaItakusaki,
        RString zenkaiChosain,
        RString zenzenkaiChosaItakusaki,
        RString zenzenkaiChosain,
        RString yubinNo,
        RString jusho,
        RString nyushoShisetsu,
        RString ninteichosaTokusokuYMD,
        RString ninteichosaTokusokuHoho,
        RString ninteichosaTokusokuKaisu,
        RString ninteichosaKusokuKigenYMD,
        RString chikuCode,
        RString chikuName) {
        this.jotai = jotai;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.hihokensha = hihokensha;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
        this.ninteiShinseiShinseijiKubunName = ninteiShinseiShinseijiKubunName;
        this.saiChosaIraiKaisu = saiChosaIraiKaisu;
        this.iraishoHakkoYMD = iraishoHakkoYMD;
        this.chosahyoTouShutsuryokuYMD = chosahyoTouShutsuryokuYMD;
        this.dataShutsuryokuYMD = dataShutsuryokuYMD;
        this.ninteichosaKigenYMD = ninteichosaKigenYMD;
        this.ninteichosaIraiKubun = ninteichosaIraiKubun;
        this.ninteichosaItakusaki = ninteichosaItakusaki;
        this.chosainShimei = chosainShimei;
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
        this.zenkaiChosain = zenkaiChosain;
        this.zenzenkaiChosaItakusaki = zenzenkaiChosaItakusaki;
        this.zenzenkaiChosain = zenzenkaiChosain;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.nyushoShisetsu = nyushoShisetsu;
        this.ninteichosaTokusokuYMD = ninteichosaTokusokuYMD;
        this.ninteichosaTokusokuHoho = ninteichosaTokusokuHoho;
        this.ninteichosaTokusokuKaisu = ninteichosaTokusokuKaisu;
        this.ninteichosaKusokuKigenYMD = ninteichosaKusokuKigenYMD;
        this.chikuCode = chikuCode;
        this.chikuName = chikuName;
    }
}
