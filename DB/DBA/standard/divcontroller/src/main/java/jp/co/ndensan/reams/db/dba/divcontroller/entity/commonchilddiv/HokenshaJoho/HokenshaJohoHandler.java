/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokenja.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokenja.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokenja.HokenjaMapperParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA6010012.DataGrid1_Row;
import jp.co.ndensan.reams.db.dba.service.core.hokenja.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 *
 * {@link HokenshaJohoDiv}のHandlerクラスです。
 */
public class HokenshaJohoHandler {

    private final HokenshaJohoDiv div;
    private RString kenCode;

    public HokenshaJohoHandler(HokenshaJohoDiv div) {
        this.div = div;
    }

    public void onBlur_txtHokenshaNo(HokenshaJohoDiv div) {
        HokenjaMapperParameter parameter = HokenjaMapperParameter.createHokenjaNoParam(
                new HokenjaNo(div.getTxtHokenshaNo().getValue()));
        Hokensha ent = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(parameter);
        if (ent == null) {
            div.getTxtHokenshaMeisho().setValue(RString.EMPTY);
        } else {
            div.getTxtHokenshaMeisho().setValue(ent.get保険者名());
        }
    }

    public ResponseData<HokenshaJohoDiv> on保険者検索(HokenshaJohoDiv div) {
        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
        if (div.getTxtHokenshaNo().getValue().isEmpty()) {
            kenCode = new RString("");
        } else {
            kenCode = new RString(div.getTxtHokenshaNo().getValue().toString().substring(0, 2));
        }
        HokenjaMapperParameter parameter = HokenjaMapperParameter.createKenCodeParam(kenCode);
        List<Hokensha> hokenjaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(parameter);
//        List<DataGrid1_Row> list = new ArrayList<>();
        DataGrid1_Row row = new DataGrid1_Row();
        for (Hokensha guide : hokenjaList) {
//            row.setDefaultDataName0(guide.get保険者番号());
//            row.setDefaultDataName1(guide.get保険者名());
        }
//        list.add(row);
        //div.getDataGrid1().setDataSource(list);
        List<KenCodeJigyoshaInputGuide> KenCodeList = HokenshaNyuryokuHojoFinder.createInstance().getKenCodeJigyoshaInputGuide();
        DropDownList dropdownlist = new DropDownList();
        for (KenCodeJigyoshaInputGuide guide : KenCodeList) {
            dropdownlist.setSelectedKey(guide.get都道府県住所コード());
            dropdownlist.setSelectedValue(guide.get都道府県名());
        }
        return responseData;
    }

    public ResponseData<HokenshaJohoDiv> on保険者を表示する(HokenshaJohoDiv div) {
        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();
//        kenCode = div.getDropDownList().getValue();
        HokenjaMapperParameter parameter = HokenjaMapperParameter.createKenCodeParam(kenCode);
        List<Hokensha> hokenjaList = HokenshaNyuryokuHojoFinder.createInstance().getHokenshaList(parameter);
//        List<DataGrid1_Row> list = new ArrayList<>();
        DataGrid1_Row row = new DataGrid1_Row();
        for (Hokensha guide : hokenjaList) {
//            row.setDefaultDataName0(guide.get保険者番号());
//            row.setDefaultDataName1(guide.get保険者名());
        }
//        list.add(row);
        //div.getDataGrid1().setDataSource(list);
        return responseData;
    }

    public ResponseData<HokenshaJohoDiv> on選択(HokenshaJohoDiv div) {
        ResponseData<HokenshaJohoDiv> responseData = new ResponseData<>();

        return responseData;
    }

}
