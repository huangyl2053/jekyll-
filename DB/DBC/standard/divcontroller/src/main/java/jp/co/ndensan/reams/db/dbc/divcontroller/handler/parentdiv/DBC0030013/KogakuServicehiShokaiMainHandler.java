/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030013;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.KogakuServicehiShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 世帯合算並列表示のHandlerです。
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class KogakuServicehiShokaiMainHandler {

    private final KogakuServicehiShokaiMainDiv div;
    private static final RString 世帯基準の日 = new RString("01");
    private static final RString 無 = new RString("無し");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 個人番号_利用有無 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無 = new RString("法人番号 利用有無");

    /**
     * 世帯合算並列表示のHandlerです。
     *
     * @param div SetaiPanelDiv
     */
    public KogakuServicehiShokaiMainHandler(KogakuServicehiShokaiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KogakuServiceData
     */
    public void load共有子Div(KogakuServiceData 引き継ぎ情報) {
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = 引き継ぎ情報.getサービス提供年月();
//        RString 履歴番号 = 引き継ぎ情報.get履歴番号();
//        HokenshaNo 証記載保険者番号 = 引き継ぎ情報.get証記載保険者番号();
        div.getSetaiInfo().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getSetaiInfo().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            FlexibleDate 世帯基準年月日 = new FlexibleDate(サービス提供年月.toString().concat(世帯基準の日.toString()));
            FlexibleYear 所得年度 = サービス提供年月.getYear();
            div.getSetaiInfoPanel().getCcdSetaiShotokuIchiran().initialize(識別コード, 世帯基準年月日, 所得年度, null);
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code("0001"), 個人番号_利用有無, 無);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code("0002"), 法人番号_利用有無, 無);
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code("0003"), 被保険者番号R, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2, expandedInfo3);
    }
}
