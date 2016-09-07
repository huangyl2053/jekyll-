/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1160001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1160001.ShotokuJohoShokaiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM11003_所得情報照会
 *
 * @reamsid_L DBB-1740-010 xuhao
 */
public class ShotokuJohoShokai {

    /**
     * 所得情報照会onLoad
     *
     * @param div MainPanelDiv
     * @return div
     */
    public ResponseData<ShotokuJohoShokaiDiv> onLoad(ShotokuJohoShokaiDiv div) {
        FukaTaishoshaKey viewStateData = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        TsuchishoNo 通知書番号 = viewStateData.get通知書番号();
        FlexibleYear 賦課年度 = viewStateData.get賦課年度();
        LasdecCode 市町村コード = viewStateData.get市町村コード();
        ShikibetsuCode 識別コード = viewStateData.get識別コード();
        HihokenshaNo 被保険者番号 = viewStateData.get被保険者番号();
        FlexibleDate 世帯基準年月日 = FlexibleDate.getNowDate();
        FlexibleYear 所得年度 = viewStateData.get賦課年度();
        YMDHMS 所得基準日時 = YMDHMS.now();
        div.getKaigoAtenaInfo().initialize(識別コード);
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
        div.getKaigoFukaKihon().load(searchKey);
        div.getSetaiShotokuIchiran().initialize(識別コード, 世帯基準年月日, 所得年度, 所得基準日時);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号));
        return ResponseData.of(div).respond();
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }
}
