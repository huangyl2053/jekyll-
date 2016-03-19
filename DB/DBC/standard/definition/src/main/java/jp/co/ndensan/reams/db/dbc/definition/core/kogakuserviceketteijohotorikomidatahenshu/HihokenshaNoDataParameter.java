/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaNoDataParameter
 */
public class HihokenshaNoDataParameter {

    private final HihokenshaNo 被保険者番号;
    private final ShikibetsuCode 識別コード;
    private final RString 資格喪失事由コード;
    private final FlexibleDate 資格喪失年月日;

    private HihokenshaNoDataParameter(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            RString 資格喪失事由コード,
            FlexibleDate 資格喪失年月日) {
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
        this.資格喪失事由コード = 資格喪失事由コード;
        this.資格喪失年月日 = 資格喪失年月日;
    }

    /**
     * 被保険者情報を取得するパラメータ作成
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 資格喪失事由コード RString
     * @param 資格喪失年月日 FlexibleDate
     * @return HihokenshaNoDataParameter
     */
    public static HihokenshaNoDataParameter creatParmeter(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            RString 資格喪失事由コード,
            FlexibleDate 資格喪失年月日) {
        return new HihokenshaNoDataParameter(被保険者番号, 識別コード, 資格喪失事由コード, 資格喪失年月日);
    }
}
