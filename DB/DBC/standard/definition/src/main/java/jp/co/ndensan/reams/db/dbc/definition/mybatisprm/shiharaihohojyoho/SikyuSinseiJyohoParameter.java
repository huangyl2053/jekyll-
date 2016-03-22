/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 支給申請情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SikyuSinseiJyohoParameter implements Serializable {

    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth shikyushinseiServiceYM;
    private RString shikyushinseiSeiriNo;
    private ShiharaiHohoKubun shiharaiHohoKubun;
    private RString keiyakuNo;
    private RDate startYMD;
    private RDate endYMD;
    private RTime startHHMM;
    private RTime endHHMM;
    private long kozaId;
    private RString shiharaiBasho;
}
