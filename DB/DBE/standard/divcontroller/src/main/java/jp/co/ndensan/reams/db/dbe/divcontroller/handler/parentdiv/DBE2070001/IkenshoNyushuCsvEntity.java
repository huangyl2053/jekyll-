/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2070001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医意見書入手一覧CSVEntityクラスです。
 *
 * @reamsid_L DBE-0330-010 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoNyushuCsvEntity {

    @CsvField(order = 10, name = "申請書管理番号")
    private final RString shinseishoKanriNo;
    @CsvField(order = 20, name = "状態区分")
    private final RString jyotaiKubun;
    @CsvField(order = 30, name = "保険者")
    private final RString hihokensha;
    @CsvField(order = 40, name = "認定申請日")
    private final RString ninteiShinseiYMD;
    @CsvField(order = 50, name = "被保番号")
    private final RString hihokenshaNo;
    @CsvField(order = 60, name = "氏名")
    private final RString hihokenshaName;
    @CsvField(order = 70, name = "申請時コード")
    private final RString shinseijiKubunCode;
    @CsvField(order = 80, name = "申請時")
    private final RString shinseijiKubun;
    @CsvField(order = 90, name = "依頼完了日")
    private final RString ikenshoSakuseiIraiKanryoYMD;
    @CsvField(order = 100, name = "初回_2回目コード")
    private final RString ikenshoSakuseiKaisuKubun;
    @CsvField(order = 110, name = "初回_2回目")
    private final RString ikenshoSakuseiKaisuKubunName;
    @CsvField(order = 120, name = "意見書_定型_定形外")
    private final RString ikenshoReadYMD;
    @CsvField(order = 130, name = "意見書読取日")
    private final RString ikenshoKinyuYMD;
    @CsvField(order = 140, name = "督促発行日")
    private final RString ikenshoSakuseiTokusokuYMD;
    @CsvField(order = 150, name = "方法区分")
    private final RString ikenshoSakuseiTokusokuHohoKubun;
    @CsvField(order = 160, name = "方法")
    private final RString ikenshoSakuseiTokusokuHoho;
    @CsvField(order = 170, name = "回数")
    private final Decimal ikenshoTokusokuKaisu;
    @CsvField(order = 180, name = "期限")
    private final RString ikenshoSakuseiKigenYMD;
    @CsvField(order = 190, name = "経過日数")
    private final int datesu;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param jyotaiKubun 状態区分
     * @param hihokensha 保険者
     * @param ninteiShinseiYMD 認定申請日
     * @param hihokenshaNo 被保番号
     * @param hihokenshaName 氏名
     * @param shinseijiKubunCode 申請時コード
     * @param shinseijiKubun 申請時
     * @param ikenshoSakuseiIraiKanryoYMD 依頼完了日
     * @param ikenshoSakuseiKaisuKubun 初回_2回目コード
     * @param ikenshoSakuseiKaisuKubunName 初回_2回目
     * @param ikenshoReadYMD 意見書_定型_定形外
     * @param ikenshoKinyuYMD 意見書読取日
     * @param ikenshoSakuseiTokusokuYMD 督促発行日
     * @param ikenshoSakuseiTokusokuHohoKubun 方法区分
     * @param ikenshoSakuseiTokusokuHoho 方法
     * @param ikenshoTokusokuKaisu 回数
     * @param ikenshoSakuseiKigenYMD 期限
     * @param datesu 経過日数
     */
    public IkenshoNyushuCsvEntity(
            RString shinseishoKanriNo,
            RString jyotaiKubun,
            RString hihokensha,
            RString ninteiShinseiYMD,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString shinseijiKubunCode,
            RString shinseijiKubun,
            RString ikenshoSakuseiIraiKanryoYMD,
            RString ikenshoSakuseiKaisuKubun,
            RString ikenshoSakuseiKaisuKubunName,
            RString ikenshoReadYMD,
            RString ikenshoKinyuYMD,
            RString ikenshoSakuseiTokusokuYMD,
            RString ikenshoSakuseiTokusokuHohoKubun,
            RString ikenshoSakuseiTokusokuHoho,
            Decimal ikenshoTokusokuKaisu,
            RString ikenshoSakuseiKigenYMD,
            int datesu) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.jyotaiKubun = jyotaiKubun;
        this.hihokensha = hihokensha;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.shinseijiKubunCode = shinseijiKubunCode;
        this.shinseijiKubun = shinseijiKubun;
        this.ikenshoSakuseiIraiKanryoYMD = ikenshoSakuseiIraiKanryoYMD;
        this.ikenshoSakuseiKaisuKubun = ikenshoSakuseiKaisuKubun;
        this.ikenshoSakuseiKaisuKubunName = ikenshoSakuseiKaisuKubunName;
        this.ikenshoReadYMD = ikenshoReadYMD;
        this.ikenshoKinyuYMD = ikenshoKinyuYMD;
        this.ikenshoSakuseiTokusokuYMD = ikenshoSakuseiTokusokuYMD;
        this.ikenshoSakuseiTokusokuHohoKubun = ikenshoSakuseiTokusokuHohoKubun;
        this.ikenshoSakuseiTokusokuHoho = ikenshoSakuseiTokusokuHoho;
        this.ikenshoTokusokuKaisu = ikenshoTokusokuKaisu;
        this.ikenshoSakuseiKigenYMD = ikenshoSakuseiKigenYMD;
        this.datesu = datesu;
    }

}
