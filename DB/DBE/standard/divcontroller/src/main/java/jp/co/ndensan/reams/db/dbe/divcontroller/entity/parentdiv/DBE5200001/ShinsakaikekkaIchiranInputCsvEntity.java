/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会結果一覧の入力用データCSVEntityクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaikekkaIchiranInputCsvEntity {

    @CsvField(order = 1, name = "審査会番号")
    private RString shinsakaiKaisaiNo;
    @CsvField(order = 2, name = "申請書管理番号")
    private RString shinseishoKanriNo;
    @CsvField(order = 3, name = "審査会審査順")
    private RString shinsakaiOrder;
    @CsvField(order = 4, name = "審査会委員コード")
    private RString shinsakaiIinCode;
    @CsvField(order = 5, name = "厚労省IF識別コード")
    private RString koroshoIfShikibetsuCode;
    @CsvField(order = 6, name = "二次判定結果コード")
    private RString nijiHanteiKekkaCode;
    @CsvField(order = 7, name = "二次判定結果")
    private RString nijiHanteiKekka;
    @CsvField(order = 8, name = "有効期間")
    private RString yukokikan;
}
