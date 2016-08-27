/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 氏名カナ突合結果一時SQL検索結果Entityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiKanaTotsugoResultEntity {

    private RString dtレコード区分;
    private RString dt市町村コード;
    private RString dt年金保険者コード;
    private RString dt通知内容コード;
    private RString dt予備1;
    private RString dt制度コード;
    private FlexibleDate dt作成年月日;
    private RString dt基礎年金番号;
    private RString dt年金コード;
    private RString dt予備2;
    private FlexibleDate dt生年月日;
    private RString dt性別;
    private RString dtカナ氏名;
    private RString dtシフトコード1;
    private RString dt漢字氏名;
    private RString dtシフトコード2;
    private YubinNo dt郵便番号;
    private RString dtカナ住所;
    private RString dtシフトコード3;
    private RString dt漢字住所;
    private RString dtシフトコード4;
    private RString dt対象年;
    private RString dt訂正表示;
    private RString dt各種区分;
    private RString dt処理結果;
    private RString dt予備3;
    private RString dt予備4;
    private Decimal dt金額1;
    private Decimal dt金額予備1;
    private Decimal dt金額予備2;
    private RString dt予備5;
    private RString dt共済年金証書記号番号;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 世帯コード;
    private RString 宛名カナ氏名;
    private FlexibleDate 宛名生年月日;
    private RString 宛名性別;
}
