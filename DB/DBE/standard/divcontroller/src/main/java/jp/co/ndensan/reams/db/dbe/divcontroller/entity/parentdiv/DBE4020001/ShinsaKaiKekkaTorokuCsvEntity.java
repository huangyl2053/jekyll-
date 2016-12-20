/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会結果登録出力用CSVEntityクラスです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaKaiKekkaTorokuCsvEntity {

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
    @CsvField(order = 8, name = "(二次判定)結果登録")
    private final RString nijiHanteiKekkaInputYMD;
    @CsvField(order = 9, name = "(二次判定)入力方法")
    private final RString nijiHanteiKekkaInputHoho;
    @CsvField(order = 10, name = "(二次判定)二次判定結果")
    private final RString nijiHanteiKekkaNijiHanteiKekka;
    @CsvField(order = 11, name = "(二次判定)有効期間")
    private final RString nijiHanteiNinteiYukoKikan;
    @CsvField(order = 12, name = "(二次判定)審査会開催日")
    private final RString shinsakaiKaisaiYMD;
    @CsvField(order = 13, name = "(二次判定)審査会番号")
    private final RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param jotai 状態
     * @param shichosonMeisho 保険者名
     * @param hihokenshaNo (被保険者)被保番号
     * @param hihokenshaName (被保険者)氏名
     * @param shinseijiKubun (申請区分)申請時
     * @param ninteiShinseiHoreiKubun (申請区分)法令
     * @param ninteiShinseiYMD 認定申請日
     * @param nijiHanteiKekkaInputYMD (二次判定)結果登録
     * @param nijiHanteiKekkaInputHoho (二次判定)入力方法
     * @param nijiHanteiKekkaNijiHanteiKekka (二次判定)二次判定結果
     * @param nijiHanteiNinteiYukoKikan (二次判定)有効期間
     * @param shinsakaiKaisaiYMD (二次判定)審査会開催日
     * @param shinsakaiKaisaiNo (二次判定)審査会番号
     */
    public ShinsaKaiKekkaTorokuCsvEntity(
            RString jotai,
            RString shichosonMeisho,
            RString ninteiShinseiYMD,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString shinseijiKubun,
            RString ninteiShinseiHoreiKubun,          
            RString nijiHanteiKekkaInputYMD,
            RString nijiHanteiKekkaInputHoho,
            RString nijiHanteiKekkaNijiHanteiKekka,
            RString nijiHanteiNinteiYukoKikan,
            RString shinsakaiKaisaiYMD,
            RString shinsakaiKaisaiNo) {
        this.jotai = jotai;
        this.shichosonMeisho = shichosonMeisho;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.shinseijiKubun = shinseijiKubun;
        this.ninteiShinseiHoreiKubun = ninteiShinseiHoreiKubun;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.nijiHanteiKekkaInputYMD = nijiHanteiKekkaInputYMD;
        this.nijiHanteiKekkaInputHoho = nijiHanteiKekkaInputHoho;
        this.nijiHanteiKekkaNijiHanteiKekka = nijiHanteiKekkaNijiHanteiKekka;
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }
}
