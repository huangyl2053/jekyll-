/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会登録出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiTorokuCsvEntity {

    @CsvField(order = 1, name = "状態")
    private final RString jotai;
    @CsvField(order = 2, name = "保険者")
    private final RString shichosonMeisho;
    @CsvField(order = 3, name = "認定申請日")
    private final RString ninteiShinseiYMD;
    @CsvField(order = 4, name = "(被保険者)被保番号")
    private final RString hihokenshaNo;
    @CsvField(order = 5, name = "(被保険者)氏名")
    private final RString hihokenshaName;
    @CsvField(order = 6, name = "(申請区分)申請時")
    private final RString shinseijiKubun;
    @CsvField(order = 7, name = "(申請区分)法令")
    private final RString ninteiShinseiHoreiKubun;
    @CsvField(order = 8, name = "(調査票入手)完了日")
    private final RString ninteichosaKanryoYMD;
    @CsvField(order = 9, name = "(意見書入手)完了日")
    private final RString ikenshoTorokuKanryoYMD;
    @CsvField(order = 10, name = "(マスキング)完了日")
    private final RString maskingKanryoYMD;
    @CsvField(order = 11, name = "(審査会登録)審査会割付日")
    private final RString kaiWariateKanryoYMD;
    @CsvField(order = 12, name = "(審査会登録)審査会開催日")
    private final RString shinsakaiKaisaiYoteiYMD;
    @CsvField(order = 13, name = "(審査会登録)開催時間")
    private final RString shinsakaiKaishiYoteiTime;
    @CsvField(order = 14, name = "(審査会登録)優先割付者")
    private final RString yusenWaritsukeKubunName;
    @CsvField(order = 15, name = "(審査会登録)審査会番号")
    private final RString shinsakaiKaisaiNo;
    @CsvField(order = 16, name = "(審査会登録)合議体")
    private final RString gogitaiNo;

    /**
     * コンストラクタです。
     *
     * @param jotai 状態
     * @param shichosonMeisho 保険者
     * @param ninteiShinseiYMD 認定申請日
     * @param hihokenshaNo (被保険者)被保番号
     * @param hihokenshaName (被保険者)氏名
     * @param ninteiShinseiHoreiKubun (申請区分)法令
     * @param shinseijiKubun (申請区分)申請時
     * @param ninteichosaKanryoYMD (調査票入手)完了日
     * @param ikenshoTorokuKanryoYMD (意見書入手)完了日
     * @param maskingKanryoYMD (マスキング)完了日
     * @param kaiWariateKanryoYMD (審査会登録)審査会割付日
     * @param shinsakaiKaisaiYoteiYMD (審査会登録)審査会開催日
     * @param shinsakaiKaishiYoteiTime (審査会登録)開催時間
     * @param yusenWaritsukeKubunName (審査会登録)優先割付者
     * @param shinsakaiKaisaiNo (審査会登録)審査会番号
     * @param gogitaiNo (審査会登録)合議体
     */
    public ShinsakaiTorokuCsvEntity(
            RString jotai,
            RString shichosonMeisho,
            RString ninteiShinseiYMD,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString shinseijiKubun,
            RString ninteiShinseiHoreiKubun,
            RString ninteichosaKanryoYMD,
            RString ikenshoTorokuKanryoYMD,
            RString maskingKanryoYMD,
            RString kaiWariateKanryoYMD,
            RString shinsakaiKaisaiYoteiYMD,
            RString shinsakaiKaishiYoteiTime,
            RString yusenWaritsukeKubunName,
            RString shinsakaiKaisaiNo,
            RString gogitaiNo) {
        this.jotai = jotai;
        this.shichosonMeisho = shichosonMeisho;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.shinseijiKubun = shinseijiKubun;
        this.ninteiShinseiHoreiKubun = ninteiShinseiHoreiKubun;
        this.ninteichosaKanryoYMD = ninteichosaKanryoYMD;
        this.ikenshoTorokuKanryoYMD = ikenshoTorokuKanryoYMD;
        this.maskingKanryoYMD = maskingKanryoYMD;
        this.kaiWariateKanryoYMD = kaiWariateKanryoYMD;
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
        this.yusenWaritsukeKubunName = yusenWaritsukeKubunName;
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
        this.gogitaiNo = gogitaiNo;
    }
}
