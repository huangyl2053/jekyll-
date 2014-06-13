/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoNinteishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
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
     * @param hakkoPanel 認定書発行Panel
     * @param searchPanel 該当者検索Panel
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onLoad(
            ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv hakkoPanel,
            ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv searchPanel) {

        ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> response = new ResponseData<>();

        set障害者控除対象者情報(searchPanel.getShogaishaKojoTaishoshaList().
                getDgSearchResult().getClickedItem(), hakkoPanel);

        response.data = hakkoPanel;
        return response;
    }

    /**
     * 対象者の情報をコピーするボタンが押された時の処理です。
     *
     * @param hakkoPanel 認定書発行Panel
     * @param searchPanel 該当者検索Panel
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onClick_copyToTaishoshaInfomation(
            ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv hakkoPanel,
            ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv searchPanel) {

        ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> response = new ResponseData<>();

        set申請者情報(hakkoPanel);

        System.out.println(searchPanel.getShogaishaKojoTaishoshaList().getDgSearchResult().getClickedRowId());
        response.data = hakkoPanel;
        return response;
    }

    private void set障害者控除対象者情報(dgSearchResult_Row row, ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv hakkoPanel) {
        set基本情報(row, hakkoPanel.getTaishoshaAtena());
        set介護情報(row.getId(), hakkoPanel.getTaishoshaKaigoShikaku());
        set障害者控除明細(row.getId(), hakkoPanel.getShogaishaKojoNinteishoHakko());

    }

    private void set基本情報(dgSearchResult_Row row, AtenaShokaiSimpleDiv atenaDiv) {
        AtenaShokaiSimple.setData(atenaDiv, new ShikibetsuCode(row.getShikibetsuCode()));
    }

    private void set介護情報(int rowId, KaigoShikakuKihonDiv kaigoDiv) {
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4040011/KaigoShikakuKihon.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(rowId));

        kaigoDiv.getTxtHihokenshaNo().setValue(cg.getAsRString("被保番号"));
        kaigoDiv.getTxtShikakuJotai().setValue(cg.getAsRString("資格状態"));
        kaigoDiv.getTxtShutokuYmd().setValue(cg.getAsRDate("取得日"));
        kaigoDiv.getTxtSoshitsuYmd().setValue(cg.getAsRDate("喪失日"));
        kaigoDiv.getTxtShutokuJiyu().setValue(cg.getAsRString("取得事由"));
        kaigoDiv.getTxtSoshitsuJiyu().setValue(cg.getAsRString("喪失事由"));
        kaigoDiv.getTxtJutokuTekiyo().setValue(cg.getAsRDate("住特開始"));
        kaigoDiv.getTxtJutokuKaijo().setValue(cg.getAsRDate("住特終了"));
        kaigoDiv.getTxtYokaigoJotaiKubun().setValue(cg.getAsRString("要介護度"));
        kaigoDiv.getTxtNinteiKaishiYmd().setValue(cg.getAsRDate("認定開始日"));
        kaigoDiv.getTxtNinteiShuryoYmd().setValue(cg.getAsRDate("認定終了日"));
        kaigoDiv.getTxtKyuSochiNyusho().setValue(cg.getAsRString("旧措置入所"));
    }

    private void set障害者控除明細(int rowId, ShogaishaKojoNinteishoHakkoDiv hakkoDiv) {
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4040011/SearchResultOfGaitosha.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(rowId));

        hakkoDiv.getShogaishaKojoTaishoshaDetail().getTxtNinteiKubun().setValue(cg.getAsRString("認定区分"));
        hakkoDiv.getShogaishaKojoTaishoshaDetail().getTxtNinteiNaiyo().setValue(cg.getAsRString("認定内容"));
        hakkoDiv.getShogaishaKojoTaishoshaDetail().getTxtJiritsudo().setValue(cg.getAsRString("自立度"));

        hakkoDiv.getShogaishaKojoNinteisho().getNinteishoPrintSetting().
                getTxtIssueDate().setValue(cg.getAsRDate("発行日"));

    }

    private void set申請者情報(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv hakkoPanel) {

        hakkoPanel.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().
                getShogaishaKojoShinseisha().getTxtShinseishaName().setValue(
                        hakkoPanel.getTaishoshaAtena().getTxtAtenaMeisho().getValue());

        hakkoPanel.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().
                getShogaishaKojoShinseisha().getTxtShinseishaName().setValue(
                        hakkoPanel.getTaishoshaAtena().getTxtJusho().getValue());
    }
}
