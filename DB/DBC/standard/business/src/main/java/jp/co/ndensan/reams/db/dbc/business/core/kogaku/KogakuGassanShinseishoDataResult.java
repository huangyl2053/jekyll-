/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算申請書保持データです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoDataResult implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private Decimal 履歴番号;
    private RString 整理番号;
    private ShikibetsuCode 識別コード;
    private AtenaMeisho 申請代表者氏名;
    private YubinNo 申請代表者郵便番号;
    private RString 申請代表者住所;
    private TelNo 申請代表者電話番号;
}
