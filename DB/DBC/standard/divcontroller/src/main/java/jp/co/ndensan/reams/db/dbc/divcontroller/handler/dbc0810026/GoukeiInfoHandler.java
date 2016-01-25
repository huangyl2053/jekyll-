/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810026;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810026.GoukeiInfoDiv;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import static jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.YamawakeType.設定不可;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author yebangqiang
 */
public class GoukeiInfoHandler {
    
    private final GoukeiInfoDiv div;
    
    public GoukeiInfoHandler(GoukeiInfoDiv div) {
        this.div = div;
    }
    
    public void initialize(List<DbT3038ShokanKihonEntity> shokanKihonList,  List<DbT3043ShokanShokujiHiyoEntity> shokanShokujiHiyoList) {
        div.getPanelGoukeiInfo().getTxtServiceTanyi().setValue(new Decimal(shokanKihonList.get(0).getServiceTanisu()));
        div.getPanelGoukeiInfo().getTxtHokenSeikyugaku().setValue(shokanKihonList.get(0).getHokenSeikyugaku());
        div.getPanelGoukeiInfo().getTxtRiyoshafutangaku().setValue(new Decimal(shokanKihonList.get(0).getRiyoshaFutangaku()));
        div.getPanelGoukeiInfo().getTxtKinkyujiShisetsuRyoyo().setValue(shokanKihonList.get(0).getKinkyuShisetsuRyoyoSeikyugaku());
        div.getPanelGoukeiInfo().getTxtTokuteiShinryo().setValue(shokanKihonList.get(0).getTokuteiShinryoSeikyugaku());
        div.getPanelGoukeiInfo().getTxtKinkyujiShisetsuRyoyo().setValue(new Decimal(shokanShokujiHiyoList.get(0).getShokujiTeikyohiSeikyugaku()));
    }
    
    public void setボタン表示制御処理() {

        if (設定不可.equals(//dbt3118Entity.getKihonSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getMeisaiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteiShinryoSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(//dbt3118Entity.getTokuteiShinryoSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        // 特定入所者費用ボタン
        if (設定不可.equals(//dbt3118Entity.getTokuteinyushoshaSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        // 合計情報ボタン
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(true);
        // 「給付費明細(住所地特例)」ボタン
        if (設定不可.equals(//dbt3118Entity.getMeisaiJushochitokureiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
         // TODO 平成２４年４月
//        if (new RString("2").equals(shikibetsuNoKanriEntity.get特定疾患施設療養設定区分())
//                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
//            // 緊急時施設療養費
//            div.getPanelHead().getBtnKinkyujiShisetsu().setVisible(false);
//        } else {
//            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
//            if (設定不可.equals(shikibetsuNoKanriEntity.get緊急時施設療養設定区分())) {
//                div.getPanelTwo().getBtnKinkyujiShisetsu().setDisabled(true);
//            }
//        }
        // 「食事費用」ボタン
        if (設定不可.equals(//dbt3118Entity.getShokujiHiyosetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        // 「請求額集計」ボタン
        if (設定不可.equals(//dbt3118Entity.getShukeiSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        // 「社福軽減額」ボタン
        if (設定不可.equals(//dbt3118Entity.getShakaifukushiKeigenSetteiKubun()
                new RString("0"))) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
    }
}
