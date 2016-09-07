/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB3140001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB314001.DBB314001_GemmenParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001.IkkatsuGenmenDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001.IkkatsuGenmenHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001.IkkatsuGenmenValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
public class IkkatsuGenmen {

    private static final RString 町域 = new RString("町域");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 地区１ = new RString("地区１");
    private static final RString 地区２ = new RString("地区２");
    private static final RString 地区３ = new RString("地区３");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div IkkatsuGenmenDiv
     * @return ResponseData
     */
    public ResponseData<IkkatsuGenmenDiv> onLoad(IkkatsuGenmenDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div IkkatsuGenmenDiv
     * @return ResponseData
     */
    public ResponseData<IkkatsuGenmenDiv> onBeforeOpenCheck(IkkatsuGenmenDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor決定日が未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<DBB314001_GemmenParameter> onClick_IkkatsuGenmen(IkkatsuGenmenDiv div) {
        DBB314001_GemmenParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBB314001_GemmenParameter setBatchParameter(IkkatsuGenmenDiv div) {

        DBB314001_GemmenParameter parameter = new DBB314001_GemmenParameter();
        parameter.setChoteiNendo(new FlexibleYear(div.getTxtChoteiNendo().getValue().getYear().toString()));
        parameter.setFukaNendo(new FlexibleYear(div.getTxtFukaNendo().getValue().getYear().toString()));
        if (div.getCcdChikuShichosonSelect().get選択対象().equals(町域)) {
            List<RString> list = getList(div);
            parameter.setList町域コード(list);
        } else {
            parameter.setList町域コード(null);
        }
        if (div.getCcdChikuShichosonSelect().get選択対象().equals(行政区)) {
            List<RString> list = getList(div);
            parameter.setList行政区コード(list);
        } else {
            parameter.setList行政区コード(null);
        }
        if (div.getCcdChikuShichosonSelect().get選択対象().equals(地区１)) {
            List<RString> list = getList(div);
            parameter.setList地区1コード(list);
        } else {
            parameter.setList地区1コード(null);
        }
        if (div.getCcdChikuShichosonSelect().get選択対象().equals(地区２)) {
            List<RString> list = getList(div);
            parameter.setList地区2コード(list);
        } else {
            parameter.setList地区2コード(null);
        }
        if (div.getCcdChikuShichosonSelect().get選択対象().equals(地区３)) {
            List<RString> list = getList(div);
            parameter.setList地区3コード(list);
        } else {
            parameter.setList地区3コード(null);
        }
        parameter.setShinseiYMD(new FlexibleDate(div.getTxtShinseiYMD().getValue().toString()));
        parameter.setGemmenJiyuCode(new Code(div.getTxtGemmenShurui().getValue()));
        parameter.setShinseiJiyu(div.getTxtShinseiRiyu().getValue());
        parameter.setKetteiYMD(div.getTxtKetteiYMD().getValue());
        parameter.setGemmenJiyu(div.getTxtKetteiRiyu().getValue());
        return parameter;
    }

    private List<RString> getList(IkkatsuGenmenDiv div) {
        Map<RString, RString> map = div.getCcdChikuShichosonSelect().get選択結果();
        List<RString> list = new ArrayList();
        for (RString row : map.keySet()) {
            list.add(row);
        }
        return list;
    }

    private IkkatsuGenmenHandler getHandler(IkkatsuGenmenDiv div) {
        return new IkkatsuGenmenHandler(div);
    }

    private IkkatsuGenmenValidationHandler getValidationHandler(IkkatsuGenmenDiv div) {
        return new IkkatsuGenmenValidationHandler(div);
    }
}
