/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.shikakukubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保詳細クラスです。
 *
 */
public class HihousyosaiFinderParameter {

    private final HihokenshaNo hihokenshaNo;
    private final FlexibleDate idoYMD;
    private final RString edaNo;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @param 枝番 RString
     */
    private HihousyosaiFinderParameter(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD,
            RString edaNo
    ) {
        this.hihokenshaNo = hihokenshaNo;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
    }

    public static HihousyosaiFinderParameter createHihousyosaiFinderParameter(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD,
            RString edaNo
    ) {
        return new HihousyosaiFinderParameter(hihokenshaNo, idoYMD, edaNo);
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return edaNo;
    }

}
