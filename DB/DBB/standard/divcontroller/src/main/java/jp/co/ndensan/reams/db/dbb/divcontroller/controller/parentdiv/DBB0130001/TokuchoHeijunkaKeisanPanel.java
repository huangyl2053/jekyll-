/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0130001;

import jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka8.HeijunkaKeisanPageJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.kaigofukatokuchoheijunka8.KaigoFukaTokuchoHeijunka8FlowParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130001.TokuchoHeijunkaKeisanPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0130001.TokuchoHeijunkaKeisanPanelHandler;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka8.KaigoFukaTokuchoHeijunka8;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴8月分）の画面クラスです。
 *
 * @reamsid_L DBB-0860-010 lihang
 */
public class TokuchoHeijunkaKeisanPanel {

    private static final RString 帳票グループコード = new RString("DBB0130001");
    private final RString 特別徴収平準化計算_特別徴収8月分 = new RString("DBB0130001_特別徴収平準化計算（特別徴収8月分）");

    /**
     * onLoadです
     *
     * @param div TokuchoHeijunkaKeisanPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoHeijunkaKeisanPanelDiv> onLoad(TokuchoHeijunkaKeisanPanelDiv div) {

        RDate nowDate = RDate.getNowDate();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        RString 年度 = (new RDate(調定年度.toString())).getYear().wareki().toDateString();
        div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().setValue(年度);
        div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtFukaNendo().setValue(年度);
        div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().setDisabled(true);
        div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtFukaNendo().setDisabled(true);
        div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().setDisabled(true);
        div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().setDisabled(true);
        getHandler(div).get処理状態();
        getHandler(div).get減額平準化計算方法();
        getHandler(div).get増額平準化計算方法();
        getHandler(div).setボタン制御();
        div.getTokuchoHeijunkaPanel().getCcdOutputChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 帳票グループコード);

        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnBatchRegisterです
     *
     * @param div TokuchoHeijunkaKeisanPanelDiv
     * @return ResponseData
     */
    public ResponseData<KaigoFukaTokuchoHeijunka8FlowParameter> onClick_btnBatchRegister(TokuchoHeijunkaKeisanPanelDiv div) {

        KaigoFukaTokuchoHeijunka8FlowParameter parameter = new KaigoFukaTokuchoHeijunka8FlowParameter();
        KaigoFukaTokuchoHeijunka8 特徴平準化 = new KaigoFukaTokuchoHeijunka8();
        HeijunkaKeisanPageJoho pageData = new HeijunkaKeisanPageJoho();
        for (int i = 0, len = div.getTokuchoHeijunkaPanel().getCcdOutputChohyoIchiran().get出力帳票一覧().size(); i < len; i++) {
            if (特別徴収平準化計算_特別徴収8月分.equals(
                    div.getTokuchoHeijunkaPanel().getCcdOutputChohyoIchiran().get出力帳票一覧().get(i).getChohyoID())) {
                pageData.set出力順ID(div.getTokuchoHeijunkaPanel().getCcdOutputChohyoIchiran().get出力帳票一覧().
                        get(i).getShutsuryokujunID());
            }
        }
        pageData.set増額平準化方法(div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().getValue());
        pageData.set減額平準化方法(div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().getValue());
        RDate 年度 = new RDate(div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().getValue().toString());
        pageData.set調定年度(new FlexibleYear(年度.getYear().toDateString()));
        pageData.set賦課年度(new FlexibleYear(年度.getYear().toDateString()));
        特徴平準化.getBatchiPara(pageData);
        return ResponseData.of(parameter).respond();
    }

    private TokuchoHeijunkaKeisanPanelHandler getHandler(TokuchoHeijunkaKeisanPanelDiv div) {
        return new TokuchoHeijunkaKeisanPanelHandler(div);
    }
}
