/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetuhihokensyasuichiranhyo;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ21004_段階別被保険者数一覧表作成InputeImageDivEntity
 *
 * @reamsid_L DBB-1820-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InputeImageDivEntity {

    private FlexibleYear 調定年度;
    private FlexibleDate 本算定賦課処理日;
    private RString 広域分市町村分区分;
    private LasdecCode 市町村コードHIDDEN;
    private FlexibleDate 資格基準日;
    private FlexibleDate 調定基準日;
}
