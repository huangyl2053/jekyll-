/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会審査結果登録（OCR)CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiData implements Serializable {

    private static final long serialVersionUID = 5345660945759531003L;

    private int 項目数;
    private RString OK_NG;
    @CsvField(order = 1, name = "ID1")
    private RString ID1;
    @CsvField(order = 2, name = "審査会開催番号")
    private RString 審査会開催番号;
    @CsvField(order = 3, name = "審査会開催日")
    private RString 審査会開催日;
    @CsvField(order = 4, name = "開催開始時間")
    private RString 開催開始時間;
    @CsvField(order = 5, name = "開催終了時間")
    private RString 開催終了時間;
    @CsvField(order = 6, name = "実施人数")
    private RString 実施人数;
    @CsvField(order = 7, name = "審査員コード1")
    private RString 審査員コード1;
    @CsvField(order = 8, name = "審査員1")
    private RString 審査員1;
    @CsvField(order = 9, name = "審査員コード2")
    private RString 審査員コード2;
    @CsvField(order = 10, name = "審査員2")
    private RString 審査員2;
    @CsvField(order = 11, name = "審査員コード3")
    private RString 審査員コード3;
    @CsvField(order = 12, name = "審査員3")
    private RString 審査員3;
    @CsvField(order = 13, name = "審査員コード4")
    private RString 審査員コード4;
    @CsvField(order = 14, name = "審査員4")
    private RString 審査員4;
    @CsvField(order = 15, name = "審査員コード5")
    private RString 審査員コード5;
    @CsvField(order = 16, name = "審査員5")
    private RString 審査員5;
    @CsvField(order = 17, name = "審査員コード6")
    private RString 審査員コード6;
    @CsvField(order = 18, name = "審査員6")
    private RString 審査員6;
    @CsvField(order = 19, name = "審査員コード7")
    private RString 審査員コード7;
    @CsvField(order = 20, name = "審査員7")
    private RString 審査員7;
    @CsvField(order = 21, name = "審査員コード8")
    private RString 審査員コード8;
    @CsvField(order = 22, name = "審査員8")
    private RString 審査員8;
    @CsvField(order = 23, name = "ID2")
    private RString ID2;
    @CsvField(order = 24, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 25, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 26, name = "非該当")
    private RString 非該当;
    @CsvField(order = 27, name = "要支援1")
    private RString 要支援1;
    @CsvField(order = 28, name = "要支援2")
    private RString 要支援2;
    @CsvField(order = 29, name = "要介護1")
    private RString 要介護1;
    @CsvField(order = 30, name = "要介護2")
    private RString 要介護2;
    @CsvField(order = 31, name = "要介護3")
    private RString 要介護3;
    @CsvField(order = 32, name = "要介護4")
    private RString 要介護4;
    @CsvField(order = 33, name = "要介護5")
    private RString 要介護5;
    @CsvField(order = 34, name = "状態像1")
    private RString 状態像1;
    @CsvField(order = 35, name = "状態像2")
    private RString 状態像2;
    @CsvField(order = 36, name = "再調査")
    private RString 再調査;
    @CsvField(order = 37, name = "取下げ")
    private RString 取下げ;
    @CsvField(order = 38, name = "認定有効期間")
    private RString 認定有効期間;

    private int no;
    private RString 保険者;
    private ShinseishoKanriNo 申請書管理番号;
    private Code 厚労省IF識別コード;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分申請時コード;
    private AtenaMeisho 被保険者氏名;
    private RString dbt5101_被保険者番号;
    private RString 証記載保険者番号;
    private Code 要介護認定一次判定結果コード;
    private Code 二次判定要介護状態区分コード;
    private FlexibleDate 二次判定年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private int 合議体番号;
    private RString 介護認定審査会開催予定場所コード;
    private RDateTime イメージ共有ファイルID;
}
