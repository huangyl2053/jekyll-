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
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001.GenmenPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001.GenmenPanelHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001.GenmenPanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.core.chiku.ChikuShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
public class GenmenPanel {

    private static final RString 町域 = new RString("町域");
    private static final RString 行政区 = ChikuShubetsu.行政区.getShubetsu();
    private static final RString 地区１ = ChikuShubetsu.地区1.getShubetsu();
    private static final RString 地区２ = ChikuShubetsu.地区2.getShubetsu();
    private static final RString 地区３ = ChikuShubetsu.地区3.getShubetsu();
    private static final int NUM_4 = 4;

    /**
     * 画面初期化のメソッドます。
     *
     * @param div GenmenPanelDiv
     * @return ResponseData
     */
    public ResponseData<GenmenPanelDiv> onLoad(GenmenPanelDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * onOkClose_bth事件です。
     *
     * @param div GenmenPanelDiv
     * @return ResponseData
     */
    public ResponseData<GenmenPanelDiv> onOkClose_bth(GenmenPanelDiv div) {
        getHandler(div).onOkClosebth();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div GenmenPanelDiv
     * @return ResponseData
     */
    public ResponseData<GenmenPanelDiv> onBeforeOpenCheck(GenmenPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor決定日が未入力();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div GenmenPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBB314001_GemmenParameter> onClick_IkkatsuGenmen(GenmenPanelDiv div) {
        DBB314001_GemmenParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBB314001_GemmenParameter setBatchParameter(GenmenPanelDiv div) {
        DBB314001_GemmenParameter parameter = new DBB314001_GemmenParameter();
        parameter.setChoteiNendo(new FlexibleYear(new RDate(div.getTextBoxTyoutenendo().getValue().toString()).
                toString().substring(0, NUM_4)));
        parameter.setFukaNendo(new FlexibleYear(new RDate(div.getTextBoxFukanendo().getValue().toString()).toString().
                substring(0, NUM_4)));
        if (div.getChikuShichosonSelect().get選択対象().equals(町域)) {
            List<RString> list = getList(div);
            parameter.setList町域コード(list);
        } else {
            parameter.setList町域コード(null);
        }
        if (div.getChikuShichosonSelect().get選択対象().equals(行政区)) {
            List<RString> list = getList(div);
            parameter.setList行政区コード(list);
        } else {
            parameter.setList行政区コード(null);
        }
        if (div.getChikuShichosonSelect().get選択対象().equals(地区１)) {
            List<RString> list = getList(div);
            parameter.setList地区1コード(list);
        } else {
            parameter.setList地区1コード(null);
        }
        if (div.getChikuShichosonSelect().get選択対象().equals(地区２)) {
            List<RString> list = getList(div);
            parameter.setList地区2コード(list);
        } else {
            parameter.setList地区2コード(null);
        }
        if (div.getChikuShichosonSelect().get選択対象().equals(地区３)) {
            List<RString> list = getList(div);
            parameter.setList地区3コード(list);
        } else {
            parameter.setList地区3コード(null);
        }
        if (div.getTextBoxSinsei().getValue() != null) {
            parameter.setShinseiYMD(new FlexibleDate(div.getTextBoxSinsei().getValue().toString()));
        } else {
            parameter.setShinseiYMD(null);
        }
        if (div.getTextBoxGenmenSyurui().getValue() != null && !div.getTextBoxGenmenSyurui().getValue().isEmpty()) {
            parameter.setGemmenJiyuCode(get減免事由コード(div.getTextBoxGenmenSyurui().getValue()));
            parameter.setGemmenJiyu(get減免事由(div.getTextBoxGenmenSyurui().getValue()));
        } else {
            parameter.setGemmenJiyuCode(Code.EMPTY);
            parameter.setGemmenJiyu(RString.EMPTY);
        }
        if (!div.getTextBoxMultiLineSinseiRiryuu().getValue().isNull() && !div.getTextBoxMultiLineSinseiRiryuu().
                getValue().isEmpty()) {
            parameter.setShinseiJiyu(div.getTextBoxMultiLineSinseiRiryuu().getValue());
        } else {
            parameter.setShinseiJiyu(RString.EMPTY);
        }
        parameter.setKetteiYMD(new FlexibleDate(div.getTextBoxKette().getValue().toString()));
        if (!div.getTextBoxMultiLineKetteiRiryuu().getValue().isNull() && !div.getTextBoxMultiLineKetteiRiryuu().
                getValue().isEmpty()) {
            parameter.setKetteiJiyu(div.getTextBoxMultiLineKetteiRiryuu().getValue());
        } else {
            parameter.setKetteiJiyu(RString.EMPTY);
        }
        return parameter;
    }

    private List<RString> getList(GenmenPanelDiv div) {
        Map<RString, RString> map = div.getChikuShichosonSelect().get選択結果();
        List<RString> list = new ArrayList();
        for (RString row : map.keySet()) {
            list.add(row);
        }
        return list;
    }

    private Code get減免事由コード(RString 減免種類) {
        List<RString> 減免種類List = 減免種類.split(RString.FULL_SPACE.toString());
        return new Code(減免種類List.get(0));
    }

    private RString get減免事由(RString 減免種類) {
        List<RString> 減免種類List = 減免種類.split(RString.FULL_SPACE.toString());
        return 減免種類List.get(1);
    }

    private GenmenPanelHandler getHandler(GenmenPanelDiv div) {
        return new GenmenPanelHandler(div);
    }

    private GenmenPanelValidationHandler getValidationHandler(GenmenPanelDiv div) {
        return new GenmenPanelValidationHandler(div);
    }
}
