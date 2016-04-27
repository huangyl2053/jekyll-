package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE7010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001.HokokuShiryoSakuSeiParameterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 報告資料発行画面のハンドラークラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public class HokokuShiryoSakuSeiParameterHandler {

    private static final List<RString> CHECKなし = new ArrayList<>();

    private final HokokuShiryoSakuSeiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HokokuShiryoSakuSeiParameterHandler(HokokuShiryoSakuSeiParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void inint_Clear() {

        div.getChkShutsuryokuChohyo().setSelectedItemsByKey(CHECKなし);
        div.getChkCsvShutsuryoku().setSelectedItemsByKey(CHECKなし);
        div.getTxtShuturyokuSaki().setValue(
                BusinessConfig.get(ConfigNameDBE.県報告資料ファイル名称, SubGyomuCode.DBE認定支援));
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChkHihokenshaKubun().setSelectedItemsByKey(CHECKなし);
        div.getTxtTaishoNendo().setValue(RDate.getNowDate());
        div.getChkModifyTaishoTsuki().setSelectedItemsByKey(CHECKなし);
        div.getTxtKijyunYMD().setValue(RDate.getNowDate());
        div.getTxtKijyunYMD().setDisabled(true);
        div.getChkModifyTaishoGeppi().setSelectedItemsByKey(CHECKなし);
        div.getDdlTsuki().setSelectedKey(new RString(String.valueOf(RDate.getNowDate().getMonthValue())));
        div.getDdlTsuki().setDisabled(true);
        div.getTxtTaishoGappi().clearFromValue();
        div.getTxtTaishoGappi().clearToValue();
        div.getTxtTaishoGappi().setDisabled(true);
        div.getChkShukeiTani().setSelectedItemsByKey(CHECKなし);
    }

}
