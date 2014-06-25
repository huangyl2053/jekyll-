/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.AtenaJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgdGaitoushaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N2810
 */
public class AtenaJoho {

    private static final RString FukaKihon = new RString("FukaKihon.yml");

    public ResponseData<AtenaJohoDiv> onLoad(AtenaJohoDiv atenajohoDiv) {
        AtenaShokaiSimpleDiv atenashokaiDiv = atenajohoDiv.getKaigoAtenaInfo().getAtenaInfo();
        AtenaShokaiSimple.setData(atenashokaiDiv, new ShikibetsuCode("000000000000019"));
        KaigoFukaKihonDiv kaigofukakihonDiv = atenajohoDiv.getKaigoFukaKihon();

        loadKaigoFukaKihon(kaigofukakihonDiv);

        ResponseData<AtenaJohoDiv> response = new ResponseData<>();
        response.data = atenajohoDiv;
        return response;
    }

    private void loadKaigoFukaKihon(KaigoFukaKihonDiv kaigofukakihonDiv) {
          RString shikibetsuCd = new RString("000000000000019");
           
        //Yaml データ読み込み
        List<HashMap> yamlArray = YamlLoader.DBB.loadAsList(FukaKihon);
       
        for (HashMap demoData : yamlArray) {
            // コンストラクタにMapを渡して生成。
            ControlGenerator cg = new ControlGenerator(demoData);

            if (shikibetsuCd.contains(cg.getAsRString("識別コード"))) {
                  kaigofukakihonDiv.getTxtTsuchishoNo().setValue(cg.getAsRString("通知書番号"));
                  kaigofukakihonDiv.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
                  kaigofukakihonDiv.getTxtHokenryoDankai().setValue(cg.getAsRString("保険料段階"));
                  kaigofukakihonDiv.getTxtShutokuYmd().setValue(new RDate(cg.getAsRString("資格取得日").toString()));
                  kaigofukakihonDiv.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
                  //kaigofukakihonDiv.getTxtSoshitsuYmd().setValue(new RDate(cg.getAsRString("資格喪失日").toString()));
                  kaigofukakihonDiv.getTxtSoshitsuYmd().clearValue();
                  kaigofukakihonDiv.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
            }
        }

    }

}
