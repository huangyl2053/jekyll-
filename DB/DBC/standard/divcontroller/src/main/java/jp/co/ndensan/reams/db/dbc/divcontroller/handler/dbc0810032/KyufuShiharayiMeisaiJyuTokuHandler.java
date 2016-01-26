/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810032;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.KyufuShiharayiMeisaiJyuTokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.dgdKyufuhiMeisai_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author quxiaodong
 */
public class KyufuShiharayiMeisaiJyuTokuHandler {

    private final KyufuShiharayiMeisaiJyuTokuDiv div;
    private static final RString 設定不可 = new RString("0");

    public KyufuShiharayiMeisaiJyuTokuHandler(KyufuShiharayiMeisaiJyuTokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     */
    public void initialize(List<ShokanMeisaiJushochiTokurei> ShokanMeisaiList) {
        div.getPanelTwo().getTxtJigyoshaBango().setValue(new RString("001"));
        div.getPanelTwo().getTxtMeisaiBango().setValue(new RString("002"));
        div.getPanelTwo().getTxtShomeisho().setValue(new RString("証明書証明書証明書証明書証明書"));
        List<dgdKyufuhiMeisai_Row> rowList = new ArrayList<>();
        for (ShokanMeisaiJushochiTokurei ShokanMeisai : ShokanMeisaiList) {
            dgdKyufuhiMeisai_Row row = new dgdKyufuhiMeisai_Row();
            row.setServiceCode(new RString(ShokanMeisai.getサービス項目コード().toString()));
            row.setTanyi(new RString(ShokanMeisai.get単位数().toString()));
            row.setKaisuuNissu(new RString(ShokanMeisai.get日数_回数().toString()));
            row.setServiceTanyi(new RString(Integer.toString(ShokanMeisai.getサービス単位数())));
            row.setShisetuShozaiHokenshaBango(new RString(ShokanMeisai.get施設所在保険者番号().toString()));
            row.setTekiyo(new RString(ShokanMeisai.get摘要().toString()));
            rowList.add(row);

        }
        div.getDgdKyufuhiMeisai().setDataSource(rowList);

    }

    public void setボタン表示制御処理() {
        if (設定不可.equals(//dbt3118Entity.getKihonSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getMeisaiSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteiShinryoSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteiShinryoSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnGoukeiInfo().setDisabled(true);
        }

        if (new RString("2").equals(//dbt3118Entity.getKihonSetteiKubun()
                new RString("0"))) {
            // 「緊急時・所定疾患」ボタンを活性に表示、「緊急時施設療養費」ボタンを非表示
//            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setDisabled(true);
        } else {
            //  「緊急時・所定疾患」ボタンを非表示
//            div.getPanelTwo().getBtnKinkyushisetuRyoyouhi().setVisible(true);
// 「緊急時施設療養費」ボタン
            if (設定不可.equals( // dbt3118Entity.getKinkyuShisetsuRyoyoSetteiKubun()
                    new RString("0"))) {
                div.getPanelTwo().getBtnTokuteiShinryouhi().setDisabled(true);
            }
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelTwo().getBtnShafukukeigenGaku().setDisabled(true);
        }

    }

}
