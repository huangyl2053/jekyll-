/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiHander;
import static jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002.NinteiChosaScheduleShosaiHander.Temp_地区コード1;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper.ChosainJohoFander;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * @author 863
 */
public class NinteiChosaScheduleShosai {

    public static RString Temp_画面番号 = new RString("2");
    public static FlexibleDate Temp_設定日 = new FlexibleDate("20121212");
    public static Code Temp_地区コード = new Code("");
    public static RString Temp_遷移元画面番号 = new RString("1");
    public static LasdecCode Temp_保険者 = new LasdecCode("");
    public static boolean Temp_調査員状況02 = true;
    public static RString Temp_認定調査委託先コード = new RString("");

    public ResponseData<NinteiChosaScheduleShosaiDiv> onLoad(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(Temp_設定日, Temp_地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        List<UzT0007CodeEntity> get対象地区List = CodeMaster.getCode(new CodeShubetsu("5002"));
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査スケジュール詳細情報(Temp_設定日, Temp_調査員状況02, Temp_地区コード, Temp_保険者, Temp_認定調査委託先コード);
        List<ChikuNinteiChosain> 認定調査スケジュールList = ChosainJohoFander.createInstance().get認定調査スケジュール詳細情報1(parameter).records();
        getHandler(div).onLoad(通常件数, 重要件数, get対象地区List, Temp_遷移元画面番号, 認定調査スケジュールList);
        responseData.data = div;
        return responseData;
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onselect_対象地区(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        Temp_設定日 = div.getTxtSetteiDate().getValue();
        // TODO jp.co.ndensan.reams.uz.uza.util.code.getCode
        Temp_地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey().toString());
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_保険者名(Temp_地区コード);
        List<ChikuNinteiKoseiShichoson> 保険者List = ChosainJohoFander.createInstance().get保険者(parameter).records();
        ChosainJohoParameter parame = ChosainJohoParameter.createParam_メモ情報件数(Temp_設定日, Temp_地区コード);
        int 通常件数 = ChosainJohoFander.createInstance().get通常メモ情報件数(parame);
        int 重要件数 = ChosainJohoFander.createInstance().get重要メモ情報件数(parame);
        getHandler(div).onselect_保険者名称取得(保険者List, 通常件数, 重要件数);
        responseData.data = div;
        return responseData;
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onselect_保険者(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        LasdecCode 市町村コード = new LasdecCode(div.getDdlHokensha().getSelectedKey().toString());
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査委託先名称(Temp_地区コード, 市町村コード);
        List<ChikuNinteiNinteichosa> 認定調査委託先名List = ChosainJohoFander.createInstance().get認定調査委託先名称(parameter).records();
        getHandler(div).set認定調査委託先DDL(認定調査委託先名List);
        responseData.data = div;
        return responseData;
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onclick_検索する(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        Temp_設定日 = div.getSearchNinteiChosaSchedule().getTxtSetteiDate().getValue();
        if (div.getSearchNinteiChosaSchedule().getRadChosainJokyo().getSelectedKey().toString().equals("key0")) {
            Temp_調査員状況02 = true;
        } else if (div.getSearchNinteiChosaSchedule().getRadChosainJokyo().getSelectedKey().toString().equals("key1")) {
            Temp_調査員状況02 = false;
        }
        Temp_地区コード1 = new Code(div.getSearchNinteiChosaSchedule().getDdlTaishoChiku().getSelectedKey());
        Temp_保険者 = new LasdecCode(div.getSearchNinteiChosaSchedule().getDdlHokensha().getSelectedKey());
        Temp_認定調査委託先コード = div.getSearchNinteiChosaSchedule().getDdlninteiChosaItakusaki().getSelectedKey();
        ChosainJohoParameter parameter = ChosainJohoParameter.createParam_認定調査スケジュール詳細情報(Temp_設定日, Temp_調査員状況02, Temp_地区コード, Temp_保険者, Temp_認定調査委託先コード);
        List<ChikuNinteiChosain> 認定調査スケジュールList = ChosainJohoFander.createInstance().get認定調査スケジュール詳細情報1(parameter).records();
        getHandler(div).set認定調査スケジュール詳細情報(認定調査スケジュールList);
        responseData.data = div;
        return responseData;
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onselect_前日へ(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onselect_次日へ(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }

    public ResponseData<NinteiChosaScheduleShosaiDiv> onclick_編集(NinteiChosaScheduleShosaiDiv div) {
        ResponseData<NinteiChosaScheduleShosaiDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }

    private NinteiChosaScheduleShosaiHander getHandler(NinteiChosaScheduleShosaiDiv div) {
        return new NinteiChosaScheduleShosaiHander(div);
    }
}
