/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810026;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810026.GoukeiInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い状況照会_合計情報のハンドラクラスです。
 *
 * @reamsid_L DBC-1010-090 xuhao
 */
public class GoukeiInfoHandler {

    private final GoukeiInfoDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    /**
     * GoukeiInfoHandler
     *
     * @param div 画面DIV
     */
    public GoukeiInfoHandler(GoukeiInfoDiv div) {
        this.div = div;
    }

    /**
     * initialize
     *
     * @param shokanKihon shokanShokujiHiyoList
     * @param shokanShokujiHiyoList shokanShokujiHiyoList
     */
    public void initialize(ShokanKihon shokanKihon, List<ShokanShokujiHiyo> shokanShokujiHiyoList) {
        div.getPanelGoukeiInfo().getTxtServiceTanyi().setValue(new Decimal(shokanKihon.getサービス単位数()));
        div.getPanelGoukeiInfo().getTxtHokenSeikyugaku().setValue(shokanKihon.get保険請求額());
        div.getPanelGoukeiInfo().getTxtRiyoshafutangaku().setValue(new Decimal(shokanKihon.get利用者負担額()));
        div.getPanelGoukeiInfo().getTxtKinkyujiShisetsuRyoyo().setValue(shokanKihon.get緊急時施設療養費請求額());
        div.getPanelGoukeiInfo().getTxtTokuteiShinryo().setValue(shokanKihon.get特定診療費請求額());
        if (shokanShokujiHiyoList != null && !shokanShokujiHiyoList.isEmpty()) {
            div.getPanelGoukeiInfo().getTxtShokujiTeikyohi().setValue(
                    new Decimal(shokanShokujiHiyoList.get(0).get食事提供費請求額()));
        }
    }

    /**
     * ボタン表示制御を処理します。
     *
     * @param shikibetsuNoKanriEntity Entity
     * @param サービス年月 サービス年月
     */
    public void setボタン表示制御処理(
            ShikibetsuNoKanriResult shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get基本設定区分())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定診療費設定区分())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get居宅計画費設定区分())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get特定入所者設定区分())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get集計設定区分())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyuchi().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteiShokan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteiShokan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShokan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get緊急時施設療養設定区分())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }
}
