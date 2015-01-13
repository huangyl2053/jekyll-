/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujiKouseiJuminDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3336
 */
public class SokujiKouseiJumin {

    public ResponseData<SokujiKouseiJuminDiv> onLoad_SokujiKouseiJumin(SokujiKouseiJuminDiv sokujiKouseiJuminDiv) {
//        AtenaShokaiSimple.setData(sokujiKouseiJuminDiv.getSokujiKouseiAtena().getAtenaInfo(), new ShikibetsuCode("000000000000094"));

        List<HashMap> SokujiKouseiKihonData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/SokujiKouseiKihon.yml"));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtTsuchishoNo().setValue(new RString(SokujiKouseiKihonData.get(0).get("通知書番号").toString()));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtHihokenshaNo().setValue(new RString(SokujiKouseiKihonData.get(0).get("被保番号").toString()));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtHokenryoDankai().setValue(new RString(SokujiKouseiKihonData.get(0).get("保険料段階").toString()));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtShutokuYmd().setValue(new FlexibleDate(SokujiKouseiKihonData.get(0).get("資格取得日").toString()));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtShutokuJiyu().setValue(new RString(SokujiKouseiKihonData.get(0).get("資格取得事由").toString()));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtSoshitsuYmd().setValue(new FlexibleDate(SokujiKouseiKihonData.get(0).get("資格喪失日").toString()));
        sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtSoshitsuJiyu().setValue(new RString(SokujiKouseiKihonData.get(0).get("資格喪失事由").toString()));

        ResponseData<SokujiKouseiJuminDiv> response = new ResponseData<>();
        response.data = sokujiKouseiJuminDiv;
        return response;
    }
}
