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
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 償還払い状況照会_基本情報のハンドラクラスです。
 */
public class KihonInfoHandler {

    private final KihonInfoDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final RString 有 = new RString("2");
    private static final RString 自己作成 = new RString("3");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

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
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJutoku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().getTokuteiShikkanSetteiKubun())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setDisplayNone(false);
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setVisible(true);
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setVisible(false);
            div.getPanelTwo().getBtnKinkyujiShisetuRyoyouhi().setDisplayNone(true);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setVisible(false);
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
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelTwo().getTxtShinseiDate().setValue(new RDate(申請日.toString()));
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    public void set基本内容エリア(ShokanKihon shokanKihon, KaigoJigyoshaReturnEntity kaigoJigyoshaEntity,
            FlexibleYearMonth サービス年月) {

        UzT0007CodeEntity code = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(new RString("0001")), new Code(shokanKihon.get居宅サービス計画作成区分コード()), FlexibleDate.getNowDate());
        List<KeyValueDataSource> keyValueDataSource1 = new ArrayList<>();
        keyValueDataSource1.add(new KeyValueDataSource(new RString("key0"), code.getコード名称()));
        div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().setDataSource(keyValueDataSource1);
        div.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun().setSelectedKey(new RString("key0"));
        if (有.equals(shokanKihon.get旧措置入所者特例コード())) {
            List<RString> sources = new ArrayList<>();
            sources.add(new RString("key0"));
            div.getPanelKihon().getPanelKyotaku().getChkKyusochi().setSelectedItemsByKey(sources);
        }

        if (!自己作成.equals(shokanKihon.get居宅サービス計画作成区分コード())) {
            div.getPanelKihon().getPanelKyotaku().getTxtJigyosha().setValue(shokanKihon.get事業者番号().value());
            div.getPanelKihon().getPanelKyotaku().getTxtJigyoshaName().setValue(kaigoJigyoshaEntity.getEntity()
                    .getJigyoshaName().value());
        }
        div.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu().setValue(shokanKihon.get保険給付率().value());
        div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan()
                .setFromValue(new RDate(shokanKihon.get開始年月日().toString()));
        div.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan()
                .setToValue(new RDate(shokanKihon.get中止年月日().toString()));

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
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        if (平成２１年４月.isBeforeOrEquals(サービス年月) && list.contains(様式番号)) {
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setVisible(false);
        } else {
            UzT0007CodeEntity code4 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                    new CodeShubetsu(new RString("0009")), new Code(shokanKihon.get中止理由_入所_院前の状況コード()), FlexibleDate.getNowDate());
            List<KeyValueDataSource> keyValueDataSource2 = new ArrayList<>();
            keyValueDataSource2.add(new KeyValueDataSource(new RString("key0"), code4.getコード名称()));
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setDataSource(keyValueDataSource2);
            div.getPanelKihon().getPanelServiceKikan().getDdlCyushiRiyu().setSelectedKey(new RString("key0"));
        }
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD().setValue(new RDate(
                shokanKihon.get入所_院年月日().toString()));
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu().setValue(
                new Decimal(shokanKihon.get入所_院実日数()));
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD().setValue(new RDate(
                shokanKihon.get退所_院年月日().toString()));
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu().setValue(new Decimal(shokanKihon.get外泊日数()));
        if (サービス年月.isBefore(平成２１年４月)
                || (平成２１年４月.isBeforeOrEquals(サービス年月)
                && !list.contains(様式番号))) {
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setVisible(false);
        } else {
            UzT0007CodeEntity code3 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                    new CodeShubetsu(new RString("0048")), new Code(shokanKihon.get中止理由_入所_院前の状況コード()), FlexibleDate.getNowDate());
            List<KeyValueDataSource> keyValueDataSource3 = new ArrayList<>();
            keyValueDataSource3.add(new KeyValueDataSource(new RString("key0"), code3.getコード名称()));
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setDataSource(keyValueDataSource3);
            div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState().setSelectedKey(new RString("key0"));
        }
        UzT0007CodeEntity code2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(new RString("0010")), new Code(shokanKihon.get退所_院後の状態コード()), FlexibleDate.getNowDate());
        List<KeyValueDataSource> keyValueDataSource4 = new ArrayList<>();
        keyValueDataSource4.add(new KeyValueDataSource(new RString("key0"), code2.getコード名称()));
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().setDataSource(keyValueDataSource4);
        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlTaishoMaeState().setSelectedKey(new RString("key0"));
    }
}
