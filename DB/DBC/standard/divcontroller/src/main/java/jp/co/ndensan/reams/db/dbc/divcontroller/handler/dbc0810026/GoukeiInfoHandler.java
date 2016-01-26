/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810026;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810026.GoukeiInfoDiv;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_合計情報のハンドラクラスです。
 * @author GC xuhao
 */
public class GoukeiInfoHandler {
    
    private final GoukeiInfoDiv div;
    private static final RString 設定不可 = new RString("0");
    
    public GoukeiInfoHandler(GoukeiInfoDiv div) {
        this.div = div;
    }
    
    public void initialize(List<ShokanKihon> shokanKihonList,  List<ShokanShokujiHiyo> shokanShokujiHiyoList) {
        div.getPanelGoukeiInfo().getTxtServiceTanyi().setValue(new Decimal(shokanKihonList.get(0).getサービス単位数()));
        div.getPanelGoukeiInfo().getTxtHokenSeikyugaku().setValue(shokanKihonList.get(0).get保険請求額());
        div.getPanelGoukeiInfo().getTxtRiyoshafutangaku().setValue(new Decimal(shokanKihonList.get(0).get利用者負担額()));
        div.getPanelGoukeiInfo().getTxtKinkyujiShisetsuRyoyo().setValue(shokanKihonList.get(0).get緊急時施設療養費請求額());
        div.getPanelGoukeiInfo().getTxtTokuteiShinryo().setValue(shokanKihonList.get(0).get特定診療費請求額());
        div.getPanelGoukeiInfo().getTxtKinkyujiShisetsuRyoyo().setValue(
                new Decimal(shokanShokujiHiyoList.get(0).get食事提供費請求額()));
    }
    
    /**
     * ボタン表示制御を処理します。
     * @param shikibetsuNoKanriEntity
     * @param サービス年月 
     */
       public void setボタン表示制御処理(ShikibetsuNoKanriEntity shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (new RString("2").equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }
}
