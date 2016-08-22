/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0600051;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbu.business.core.jyumikonyujyoho.JyuMiKoNyuJyoHoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyumikonyujyoho.JyuMiKoNyuJyoHoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600051.PanelAtenaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0600051.PanelAtenaHandler;
import jp.co.ndensan.reams.db.dbu.service.core.basic.jyumikonyujyoho.JyuMiKoNyuJyoHoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBU0600051_総合照会_住民固有情報クラスです。
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
public class PanelAtena {

    private final JyuMiKoNyuJyoHoFinder finder;

    /**
     * コンストラクタです。
     *
     */
    public PanelAtena() {
        this.finder = JyuMiKoNyuJyoHoFinder.createInstance();
    }

    /**
     * 総合照会_住民固有情報の初期処理を表示します。
     *
     * @param div PanelAtenaDiv
     * @return ResponseData
     */
    public ResponseData<PanelAtenaDiv> onLoad(PanelAtenaDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        getHandler(div).initializtion(識別コード, 被保険者番号);
        List<RoreiFukushiNenkinJukyusha> 老齢福祉年金受給者情報 = get老齢福祉年金受給者情報(被保険者番号);
        List<JyuMiKoNyuJyoHoBusiness> 生保受給者情報 = get生保受給者情報(識別コード);
        RString 生活保護扶助種類 = get生活保護扶助種類(識別コード);
        List<JyuMiKoNyuJyoHoBusiness> 境界層管理情報 = get境界層管理情報取得(被保険者番号);
        HokenryoDankaiList 保険料段階リスト = get保険料段階リスト(div, 境界層管理情報);
        getHandler(div).editSyori(老齢福祉年金受給者情報, 生保受給者情報, 生活保護扶助種類, 境界層管理情報, 保険料段階リスト);
        return ResponseData.of(div).respond();
    }

    private List<RoreiFukushiNenkinJukyusha> get老齢福祉年金受給者情報(HihokenshaNo 被保険者番号) {

        return finder.get老齢福祉年金受給者情報(被保険者番号).records();
    }

    private List<JyuMiKoNyuJyoHoBusiness> get生保受給者情報(ShikibetsuCode 識別コード) {

        return finder.get生保受給者情報の取得(JyuMiKoNyuJyoHoParameter
                .createParameter(識別コード.value(), GyomuCode.DB介護保険.value(), RString.EMPTY)).records();
    }

    private RString get生活保護扶助種類(ShikibetsuCode 識別コード) {

        return finder.get生活保護扶助種類の取得(JyuMiKoNyuJyoHoParameter
                .createParameter(識別コード.value(), GyomuCode.DB介護保険.value(), RString.EMPTY));
    }

    private List<JyuMiKoNyuJyoHoBusiness> get境界層管理情報取得(HihokenshaNo 被保険者番号) {

        return finder.get境界層管理情報取得(JyuMiKoNyuJyoHoParameter
                .createParameter(RString.EMPTY, RString.EMPTY, 被保険者番号.value())).records();
    }

    private HokenryoDankaiList get保険料段階リスト(PanelAtenaDiv div, List<JyuMiKoNyuJyoHoBusiness> 境界層管理情報) {

        FlexibleYear 賦課年度 = getHandler(div).get仮の賦課年度(境界層管理情報);
        return HokenryoDankaiSettings.createInstance().get保険料段階ListIn(賦課年度);
    }

    private PanelAtenaHandler getHandler(PanelAtenaDiv div) {
        return new PanelAtenaHandler(div);
    }
}
