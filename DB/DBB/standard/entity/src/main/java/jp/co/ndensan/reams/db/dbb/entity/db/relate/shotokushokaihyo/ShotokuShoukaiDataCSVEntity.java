/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票データTempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiDataCSVEntity {

    @CsvField(order = 10, name = "世帯コード")
    private SetaiCode 世帯コード;
    @CsvField(order = 20, name = "カナ氏名")
    private AtenaKanaMeisho カナ氏名;
    @CsvField(order = 30, name = "前住所")
    private RString 前住所;
    @CsvField(order = 40, name = "生年月日")
    private FlexibleDate 生年月日;
    @CsvField(order = 50, name = "照会日")
    private FlexibleDate 照会日;
    @CsvField(order = 60, name = "転入日")
    private FlexibleDate 転入日;
    @CsvField(order = 70, name = "種別")
    private RString 種別;
    @CsvField(order = 80, name = "識別コード")
    private ShikibetsuCode 識別コード;
    @CsvField(order = 90, name = "氏名")
    private AtenaMeisho 氏名;
    @CsvField(order = 100, name = "現住所")
    private RString 現住所;
    @CsvField(order = 110, name = "性別")
    private RString 性別;
    @CsvField(order = 120, name = "転出日")
    private FlexibleDate 転出日;
    @CsvField(order = 130, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;

}
