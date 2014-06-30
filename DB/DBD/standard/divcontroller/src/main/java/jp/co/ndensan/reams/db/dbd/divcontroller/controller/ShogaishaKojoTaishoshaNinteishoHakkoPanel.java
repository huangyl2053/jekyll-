/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoShinseishaDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoTaishoshaDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 障害者控除対象者認定書を個別発行する場合の障害者控除対象者情報を制御します。
 *
 * @author N3317 塚田 萌
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoPanel {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onLoad(
            ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> response = new ResponseData<>();

        set障害者控除対象者情報(panel);

        response.data = panel;
        return response;
    }

    /**
     * 対象者の情報をコピーするボタンが押された時の処理です。
     *
     * @param panel ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onClick_copyToTaishoshaInfomation(
            ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> response = new ResponseData<>();

        set申請者情報(panel);

        response.data = panel;
        return response;
    }

    private void set障害者控除対象者情報(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        set基本情報(panel);
        set介護情報(panel);
        set障害者控除明細(panel);
        clear申請者情報(panel);
    }

    private void set基本情報(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        AtenaShokaiSimple.setData(panel.getTaishoshaAtena().getAtenaInfo(), new ShikibetsuCode(new RString("012345678901234")));
    }

    private void set介護情報(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4040011/KaigoShikakuKihon.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        panel.getTaishoshaKaigoShikaku().getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        panel.getTaishoshaKaigoShikaku().getTxtShutokuYmd().setValue(cg.getAsRDate("取得日"));
        panel.getTaishoshaKaigoShikaku().getTxtSoshitsuYmd().setValue(cg.getAsRDate("喪失日"));
        panel.getTaishoshaKaigoShikaku().getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        panel.getTaishoshaKaigoShikaku().getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        panel.getTaishoshaKaigoShikaku().getTxtJutokuKubun().setValue(cg.getAsRString("住特区分"));
        panel.getTaishoshaKaigoShikaku().getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        panel.getTaishoshaKaigoShikaku().getTxtNinteiKaishiYmd().setValue(cg.getAsRDate("認定開始日"));
        panel.getTaishoshaKaigoShikaku().getTxtNinteiShuryoYmd().setValue(cg.getAsRDate("認定終了日"));
    }

    private void set障害者控除明細(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4040011/SearchResultOfGaitosha.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        ShogaishaKojoTaishoshaDetailDiv detailDiv = panel.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail();
        detailDiv.getTxtNinteiKubun().setValue(cg.getAsRString("認定区分"));
        detailDiv.getTxtNinteiNaiyo().setValue(cg.getAsRString("認定内容"));
        detailDiv.getTxtJiritsudo().setValue(cg.getAsRString("自立度"));

        panel.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getNinteishoPrintSetting().
                getTxtIssueDate().setValue(cg.getAsRDate("発行日"));
    }

    private void set申請者情報(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        AtenaShokaiSimpleDiv atenaDiv = panel.getTaishoshaAtena().getAtenaInfo();
        ShogaishaKojoShinseishaDiv shinseishaDiv = panel.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getShogaishaKojoShinseisha();
        shinseishaDiv.getTxtShinseishaName().setValue(atenaDiv.getTxtAtenaMeisho().getValue());
        shinseishaDiv.getTxtShinseishaJusho().setValue(atenaDiv.getTxtJusho().getValue());
    }

    private void clear申請者情報(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv panel) {
        ShogaishaKojoShinseishaDiv shinseishaDiv = panel.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getShogaishaKojoShinseisha();
        shinseishaDiv.getTxtShinseishaName().setValue(RString.EMPTY);
        shinseishaDiv.getTxtShinseishaJusho().setValue(RString.EMPTY);
    }
}
