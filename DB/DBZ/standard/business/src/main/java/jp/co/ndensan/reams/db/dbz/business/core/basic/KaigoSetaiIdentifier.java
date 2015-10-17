/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護世帯の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KaigoSetaiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 管理識別区分;
    private final FlexibleDate 世帯把握基準年月日;
    private final int 世帯員管理連番;
    private final ShikibetsuCode 世帯員識別コード;
    private final RString 本人区分;
    private final FlexibleYear 課税年度;
    private final RString 課税非課税区分;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 管理識別区分 管理識別区分
     * @param 世帯把握基準年月日 世帯把握基準年月日
     * @param 世帯員管理連番 世帯員管理連番
     * @param 世帯員識別コード 世帯員識別コード
     * @param 本人区分 本人区分
     * @param 課税年度 課税年度
     * @param 課税非課税区分 課税非課税区分
     */
    public KaigoSetaiIdentifier(HihokenshaNo 被保険者番号,
            RString 管理識別区分,
            FlexibleDate 世帯把握基準年月日,
            int 世帯員管理連番,
            ShikibetsuCode 世帯員識別コード,
            RString 本人区分,
            FlexibleYear 課税年度,
            RString 課税非課税区分) {
        this.被保険者番号 = 被保険者番号;
        this.管理識別区分 = 管理識別区分;
        this.世帯把握基準年月日 = 世帯把握基準年月日;
        this.世帯員管理連番 = 世帯員管理連番;
        this.世帯員識別コード = 世帯員識別コード;
        this.本人区分 = 本人区分;
        this.課税年度 = 課税年度;
        this.課税非課税区分 = 課税非課税区分;
    }
}
