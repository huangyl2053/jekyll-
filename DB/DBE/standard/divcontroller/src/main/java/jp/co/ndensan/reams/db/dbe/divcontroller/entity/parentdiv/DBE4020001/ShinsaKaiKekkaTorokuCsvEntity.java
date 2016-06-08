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

    @CsvField(order = 1, name = "申請書管理番号")
    private final RString shinseishoKanriNo;
    @CsvField(order = 2, name = "厚労省IF識別コード")
    private final RString koroshoIfShikibetsuCode;
    @CsvField(order = 3, name = "(被保険者)被保番号")
    private final RString hihokenshaNo;
    @CsvField(order = 4, name = "(被保険者)氏名")
    private final RString hihokenshaName;
    @CsvField(order = 5, name = "(申請区分)申請時コード")
    private final RString shinseijiKubunCode;
    @CsvField(order = 6, name = "(申請区分)申請時")
    private final RString shinseijiKubun;
    @CsvField(order = 7, name = "(申請区分)法令コード")
    private final RString ninteiShinseiHoreiKubunCode;
    @CsvField(order = 8, name = "(申請区分)法令")
    private final RString ninteiShinseiHoreiKubun;
    @CsvField(order = 9, name = "認定申請日")
    private final RString ninteiShinseiYMD;
    @CsvField(order = 10, name = "(二次判定)完了日")
    private final RString ninteiShinsakaiKanryoYMD;
    @CsvField(order = 11, name = "(二次判定)結果登録")
    private final RString nijiHanteiKekkaInputYMD;
    @CsvField(order = 12, name = "(二次判定)入力方法コード")
    private final RString nijiHanteiKekkaInputHohoCode;
    @CsvField(order = 13, name = "(二次判定)入力方法")
    private final RString nijiHanteiKekkaInputHoho;
    @CsvField(order = 14, name = "(二次判定)二次判定結果")
    private final RString yokaigoJotaiKubunCode;
    @CsvField(order = 15, name = "(二次判定)二次判定結果")
    private final RString yokaigoIfJotaiKubunCode;
    @CsvField(order = 16, name = "(二次判定)有効期間")
    private final RString nijiHanteiNinteiYukoKikan;
    @CsvField(order = 17, name = "(二次判定)審査会開催日")
    private final RString shinsakaiKaisaiYMD;
    @CsvField(order = 18, name = "(二次判定)審査会番号")
    private final RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     * @param hihokenshaNo (被保険者)被保番号
     * @param hihokenshaName (被保険者)氏名
     * @param shinseijiKubunCode (申請区分)申請時コード
     * @param shinseijiKubun (申請区分)申請時
     * @param ninteiShinseiHoreiKubunCode (申請区分)法令コード
     * @param ninteiShinseiHoreiKubun (申請区分)法令
     * @param ninteiShinseiYMD 認定申請日
     * @param ninteiShinsakaiKanryoYMD (二次判定)完了日
     * @param nijiHanteiKekkaInputYMD (二次判定)結果登録
     * @param nijiHanteiKekkaInputHohoCode (二次判定)入力方法コード
     * @param nijiHanteiKekkaInputHoho (二次判定)入力方法
     * @param yokaigoJotaiKubunCode (二次判定)二次判定結果
     * @param yokaigoIfJotaiKubunCode (二次判定)二次判定結果
     * @param nijiHanteiNinteiYukoKikan (二次判定)有効期間
     * @param shinsakaiKaisaiYMD (二次判定)審査会開催日
     * @param shinsakaiKaisaiNo (二次判定)審査会番号
     */
    public ShinsaKaiKekkaTorokuCsvEntity(
            RString shinseishoKanriNo,
            RString koroshoIfShikibetsuCode,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString shinseijiKubunCode,
            RString shinseijiKubun,
            RString ninteiShinseiHoreiKubunCode,
            RString ninteiShinseiHoreiKubun,
            RString ninteiShinseiYMD,
            RString ninteiShinsakaiKanryoYMD,
            RString nijiHanteiKekkaInputYMD,
            RString nijiHanteiKekkaInputHohoCode,
            RString nijiHanteiKekkaInputHoho,
            RString yokaigoJotaiKubunCode,
            RString yokaigoIfJotaiKubunCode,
            RString nijiHanteiNinteiYukoKikan,
            RString shinsakaiKaisaiYMD,
            RString shinsakaiKaisaiNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.shinseijiKubunCode = shinseijiKubunCode;
        this.shinseijiKubun = shinseijiKubun;
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
        this.ninteiShinseiHoreiKubun = ninteiShinseiHoreiKubun;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.ninteiShinsakaiKanryoYMD = ninteiShinsakaiKanryoYMD;
        this.nijiHanteiKekkaInputYMD = nijiHanteiKekkaInputYMD;
        this.nijiHanteiKekkaInputHohoCode = nijiHanteiKekkaInputHohoCode;
        this.nijiHanteiKekkaInputHoho = nijiHanteiKekkaInputHoho;
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
        this.yokaigoIfJotaiKubunCode = yokaigoIfJotaiKubunCode;
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }
}
