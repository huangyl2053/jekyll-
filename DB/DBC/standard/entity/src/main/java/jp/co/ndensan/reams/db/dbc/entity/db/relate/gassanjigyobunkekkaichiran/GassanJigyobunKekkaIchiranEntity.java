/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunkekkaichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業分支給額計算データのクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJigyobunKekkaIchiranEntity {

    private HihokenshaNo 支給額_被保険者番号;
    private RString 宛名氏名;
    private int 件数;
    private RString 支給額_支給申請書整理番号;
    private RString 決定_支給区分コード;
    private RString 決定_支払方法区分;
    private RString 金融機関支店コード;
    private RString 金融機関コード;
    private RString 口座番号;
    private RString 決定_支払場所;
    private RString 支給額明細_自己負担額証明書整理番号;

    private Decimal 支給額_世帯負担総額;
    private Decimal 支給額_介護等合算一部負担金等世帯合算額;
    private Decimal 支給額_70歳以上介護等合算一部負担金等世帯合算額;
    private Decimal 支給額_介護等合算算定基準額;
    private Decimal 支給額_70歳以上介護等合算算定基準額;
    private Decimal 支給額_世帯支給総額;
    private Decimal 支給額_うち70歳以上分世帯支給総額;
    private Decimal 支給額_按分後支給額;
    private Decimal 支給額_うち70歳以上分按分後支給額;
    private ShikibetsuCode 識別コード;

}
