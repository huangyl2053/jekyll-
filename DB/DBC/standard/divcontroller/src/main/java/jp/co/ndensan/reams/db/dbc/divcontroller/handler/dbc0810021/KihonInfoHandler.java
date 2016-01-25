/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021.KihonInfoDiv;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 償還払い状況照会_基本情報のハンドラクラスです。
 *
 * @author wangkanglei
 */
public class KihonInfoHandler {

    private final KihonInfoDiv div;
    private static final RString 設定不可 = new RString("0");

    public KihonInfoHandler(KihonInfoDiv div) {
        this.div = div;
    }

    public void setボタン表示制御処理(ShikibetsuNoKanriEntity shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiDown().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiShinryohi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelTwo().getBtnTokuteiNyushosyaHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelTwo().getBtnSyokujiHiyo().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShukeiSetteiKubun())) {
            div.getPanelTwo().getBtnSeikyugakuShukei().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelTwo().getBtnShafukuKeigenGaku().setDisabled(true);
        }
        // TODO 給付費明細（住特）
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (new RString("2").equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && new FlexibleYearMonth("201204").isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setVisible(false);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getKinkyuShisetsuRyoyoSetteiKubun())) {
                div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setDisabled(true);
            }
        }
    }

    public void setヘッダーエリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelTwo().getTxtShinseiDate().setValue(new RDate(申請日.toString()));
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    public void set基本内容エリア(List<ShokanKihon> shokanKihonEntity, KaigoJigyoshaReturnEntity kaigoJigyoshaEntity, FlexibleYearMonth サービス年月) {

        for (ShokanKihon shokanKihon : shokanKihonEntity) {
            // TODO コードから名称表示
            div.getPanelKihon().getPanelKyotaku().getTxtKeikakuSakuseiKubun().setValue(shokanKihon.get居宅サービス計画作成区分コード());
            // TODO 旧措置施設入所者特例
            if (new RString("2").equals(shokanKihon.get旧措置入所者特例コード())) {
                List<RString> sources = new ArrayList<>();
                sources.add(new RString("key0"));
                div.getPanelKihon().getPanelKyotaku().getChkKyusochi().setSelectedItemsByKey(sources);
            }
            // TODO 計画作成区分が「自己作成」の場合、空白
            if (!new RString("3").equals(shokanKihon.get居宅サービス計画作成区分コード())) {
                div.getPanelKihon().getPanelKyotaku().getTxtJigyosha().setValue(shokanKihon.get事業者番号().value());
                div.getPanelKihon().getPanelKyotaku().getTxtJigyoshaName().setValue(kaigoJigyoshaEntity.getEntity()
                        .getJigyoshaName().value());
            }
            div.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu().setValue(shokanKihon.get保険給付率().value());
            div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan()
                    .setFromValue(new RDate(shokanKihon.get開始年月日().toString()));
            div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan()
                    .setToValue(new RDate(shokanKihon.get中止年月日().toString()));
            // TODO
            List<RString> list = new ArrayList<>();
            list.add(new RString("2171"));
            list.add(new RString("2172"));
            list.add(new RString("2173"));
            list.add(new RString("2174"));
            list.add(new RString("2181"));
            list.add(new RString("2182"));
            list.add(new RString("2183"));
            list.add(new RString("2191"));
            list.add(new RString("2192"));
            list.add(new RString("2193"));
            list.add(new RString("2194"));
            list.add(new RString("2195"));
            list.add(new RString("21A1"));
            list.add(new RString("21A2"));
            list.add(new RString("21A3"));
            if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス年月) && list.contains(new RString("21A4"))) {
                div.getPanelKihon().getPanelServiceKikan().getTxtCyushiRiyu().setVisible(false);
            } else {
                div.getPanelKihon().getPanelServiceKikan().getTxtCyushiRiyu().setValue(shokanKihon.get中止理由_入所_院前の状況コード());
            }
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().setValue(new RDate(shokanKihon.get入所_院年月日().toString()));
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().setValue(shokanKihon.get入所_院実日数());
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().setValue(new RDate(shokanKihon.get退所_院年月日().toString()));
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().setValue(shokanKihon.get外泊日数());
            if (サービス年月.isBefore(new FlexibleYearMonth("200904"))
                    || (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス年月)
                    && !list.contains(new RString("21A3")))) {
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoMaeState().setVisible(false);
            } else {
                // TODO 償還払請求基本．入所(院)前の状況 ?
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoMaeState()
                        .setValue(new RString("入所(院)前の状況"));
            }
            // TODO　コードから名称表示
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoMaeState()
                    .setValue(shokanKihon.get退所_院後の状態コード());
        }
    }
}
