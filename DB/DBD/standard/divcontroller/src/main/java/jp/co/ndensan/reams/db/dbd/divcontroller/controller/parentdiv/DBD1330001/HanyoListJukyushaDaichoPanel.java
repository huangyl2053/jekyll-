/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1330001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710100.DBD710100_HanyoListHikazeiNenkinTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1330001.HanyoListJukyushaDaichoPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1330001.HanyoListJukyushaDaichoPanelHandler;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 画面設計_DBD1330001_汎用リスト出力(非課税年金対象者)のクラスです。
 *
 * @reamsid_L DBD-5820-010 zhengsongling
 */
public class HanyoListJukyushaDaichoPanel {

    private static final RString 単一 = new RString("単一");
    private static final RString 広域 = new RString("広域");

    /**
     * 初期化状態です。
     *
     * @param div div
     * @return ResponseData<HanyoListJukyushaDaichoPanelDiv>
     */
    public ResponseData<HanyoListJukyushaDaichoPanelDiv> onLoad(HanyoListJukyushaDaichoPanelDiv div) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 導入形態 = get導入形態();
        getHandler(div).onLoad(導入形態, 調定年度);
        return ResponseData.of(div).respond();
    }

    /**
     * 年度選択肢の設定です。
     *
     * @param div div
     * @return ResponseData<HanyoListJukyushaDaichoPanelDiv>
     */
    public ResponseData<HanyoListJukyushaDaichoPanelDiv> onClick_ChushutsuJokenSentaku(HanyoListJukyushaDaichoPanelDiv div) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        getHandler(div).onClick_抽出条件選択(調定年度);
        return ResponseData.of(div).respond();
    }

    /**
     * 非課税年金対象者の条件を保存する。
     *
     * @param div div
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_nenkinTaishoshaParamSave(HanyoListJukyushaDaichoPanelDiv div) {

        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).条件を保存する());
        return responseData;
    }

    /**
     * 非課税年金対象者の条件を復元する。
     *
     * @param div div
     * @return ResponseData<HanyoListJukyushaDaichoPanelDiv>
     */
    public ResponseData<HanyoListJukyushaDaichoPanelDiv> onClick_nenkinTaishoshaParamRestore(HanyoListJukyushaDaichoPanelDiv div) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        getHandler(div).条件を復元する(調定年度);
        return ResponseData.of(div).respond();
    }

    /**
     * 非課税年金対象者の実行です。
     *
     * @param div div
     * @return ResponseData<DBD710100_HanyoListHikazeiNenkinTaishoshaParameter>
     */
    public ResponseData<DBD710100_HanyoListHikazeiNenkinTaishoshaParameter> onClick_Execute(HanyoListJukyushaDaichoPanelDiv div) {
        return ResponseData.of(getHandler(div).onClick_実行()).respond();
    }

    private RString get導入形態() {
        RString 導入形態;
        List<KaigoDonyuKeitai> kaigoDonyuKeitai
                = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        if (kaigoDonyuKeitai.get(0).get導入形態コード().is単一()) {
            導入形態 = 単一;
        } else if (kaigoDonyuKeitai.get(0).get導入形態コード().is広域()) {
            導入形態 = 広域;
        } else {
            導入形態 = RString.EMPTY;
        }
        return 導入形態;
    }

    private HanyoListJukyushaDaichoPanelHandler getHandler(HanyoListJukyushaDaichoPanelDiv div) {
        return new HanyoListJukyushaDaichoPanelHandler(div);
    }
}
