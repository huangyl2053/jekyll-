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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author N2810
 */
public class AtenaJoho {

    private static final RString FukaKihon = new RString("FukaKihon.yml");

    public ResponseData<AtenaJohoDiv> onLoad(AtenaJohoDiv div) {
        AtenaJohoDiv atenajoho = (AtenaJohoDiv) ViewStateHolder.get("宛名情報", AtenaJohoDiv.class);
        //AtenaJohoDiv atenajoho = null;
        ResponseData<AtenaJohoDiv> response = new ResponseData<>();

        if (atenajoho == null) {
            AtenaShokaiSimpleDiv atenashokaiDiv = div.getKaigoAtenaInfo().getAtenaInfo();
            //ShikibetsuCode shikibetsuCode = new ShikibetsuCode((RString) ViewStateHolder.get("対象者識別コード", RString.class));
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("0000000000001901"));
            AtenaShokaiSimple.setData(atenashokaiDiv, shikibetsuCode);
            KaigoFukaKihonDiv kaigofukakihonDiv = div.getKaigoFukaKihon();

            loadKaigoFukaKihon(kaigofukakihonDiv);
            response.data = div;
        } else {
            response.data = atenajoho;
        }

        return response;
    }

    private void loadKaigoFukaKihon(KaigoFukaKihonDiv kaigofukakihonDiv) {
        RString shikibetsuCd = (RString) ViewStateHolder.get("対象者識別コード", RString.class);
        if (shikibetsuCd == null || shikibetsuCd.isEmpty()) {
            shikibetsuCd = new RString("0000000000001901");
        }

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
                if (cg.getAsRString("資格喪失日").toString() == null || cg.getAsRString("資格喪失日").toString().isEmpty()) {
                    kaigofukakihonDiv.getTxtSoshitsuYmd().clearValue();
                } else {
                    kaigofukakihonDiv.getTxtSoshitsuYmd().setValue(new RDate(cg.getAsRString("資格喪失日").toString()));
                }

                kaigofukakihonDiv.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
            }
        }

    }

}
