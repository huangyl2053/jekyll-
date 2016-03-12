/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 償還払い状況照会_請求額集計
 *
 *
 */
public class SeikyuGakuShukeiHandler {

    private final SeikyuGakuShukeiDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");

    /**
     * 初期化
     *
     * @param div SeikyuGakuShukeiDiv
     */
    public SeikyuGakuShukeiHandler(SeikyuGakuShukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param shkanList List
     */
    public void initialize(List<ShokanShukeiResult> shkanList) {
        List<dgdSeikyugakushukei_Row> rowList = new ArrayList<>();
        for (ShokanShukeiResult shokanshukei : shkanList) {
            dgdSeikyugakushukei_Row row = new dgdSeikyugakushukei_Row();
            row.setDefaultDataName1(shokanshukei.getServiceShuruiRyakusho());
            row.getDefaultDataName2().setValue(new Decimal(shokanshukei.getShukei().get単位数合計()));
            row.getDefaultDataName3().setValue(shokanshukei.getShukei().get単位数単価());
            row.getDefaultDataName4().setValue(shokanshukei.getShukei().get請求額());
            if (ShinsaHohoKubun.toValue(shokanshukei.getShukei().get審査方法区分コード()) != null) {
                row.setDefaultDataName5(ShinsaHohoKubun.toValue(shokanshukei.getShukei().get審査方法区分コード()).get名称());
            }
            row.getDefaultDataName6().setValue(new Decimal(shokanshukei.getShukei().get利用者負担額()));
            row.getDefaultDataName8().setValue(new Decimal(shokanshukei.getShukei().get限度額管理対象外単位数()));
            row.getDefaultDataName9().setValue(new Decimal(shokanshukei.getShukei().get短期入所計画日数()));
            row.getDefaultDataName10().setValue(new Decimal(shokanshukei.getShukei().get短期入所実日数()));
            row.getDefaultDataName11().setValue(new Decimal(shokanshukei.getShukei().get出来高医療費単位数合計()));
            row.getDefaultDataName12().setValue(shokanshukei.getShukei().get出来高医療費請求額());
            row.getDefaultDataName13().setValue(shokanshukei.getShukei().get出来高医療費利用者負担額());
            row.getDefaultDataName14().setValue(new Decimal(shokanshukei.getShukei().get計画単位数()));
            row.getDefaultDataName15().setValue(new Decimal(shokanshukei.getShukei().get限度額管理対象単位数()));
            row.getDefaultDataName16().setValue(new Decimal(shokanshukei.getShukei().getサービス実日数()));
            rowList.add(row);
        }
        div.getDgdSeikyugakushukei().setDataSource(rowList);

    }

    /**
     * setヘッダーエリア
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @param 申請日 RString
     * @param 明細番号 RString
     * @param 証明書 RString
     */
    public void setヘッダーエリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RString 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    /**
     *
     * @param shkanList List
     * @param entity ShokanKihon
     */
    public void selectButton(List<ShokanShukeiResult> shkanList, ShokanKihon entity) {

        ShokanShukeiResult shokanshukei = shkanList.get(0);

        div.getPanelSeikyuShokai().getTxtServiceShurui().setValue(shokanshukei.getShukei().getサービス種類コード().value());
        div.getPanelSeikyuShokai().getTxtJitsuNissu().setValue(new Decimal(
                shokanshukei.getShukei().toEntity().getTankiNyushoJitsunissu()));
        List<KeyValueDataSource> source = new ArrayList<>();
        div.getPanelSeikyuShokai().getTxtJitsuNissu().setValue(new Decimal(shokanshukei.getShukei().getサービス実日数()));
        source.add(new KeyValueDataSource(shokanshukei.getShukei().get審査方法区分コード(), new RString("審査方法区分")));
        div.getPanelSeikyuShokai().getRdoShinsahouhou().setDataSource(source);
        div.getPanelSeikyuShokai().getRdoShinsahouhou().setSelectedKey(shokanshukei.getShukei().get審査方法区分コード());
        div.getPanelSeikyuShokai().getTxtKyufuritsu().setValue(new Decimal(entity.get保険給付率().toString()));
        div.getPanelSeikyuShokai().getTxtKeikakuTanyi().setValue(new Decimal(shokanshukei.getShukei().get計画単位数()));
        div.getPanelSeikyuShokai().getTxtTaishoTanyi().setValue(
                new Decimal(shokanshukei.getShukei().get限度額管理対象単位数()));
        div.getPanelSeikyuShokai().getTxtTaishoGaiTanyi().setValue(
                new Decimal(shokanshukei.getShukei().get限度額管理対象外単位数()));
        div.getPanelSeikyuShokai().getTxtKeikakuNissu().setValue(
                new Decimal(shokanshukei.getShukei().get短期入所計画日数()));
        div.getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho().setValue(
                new Decimal(shokanshukei.getShukei().get短期入所実日数()));
        div.getPanelSeikyuShokai().getTxtTanyigokeiHokenbun().setValue(new Decimal(shokanshukei.getShukei().get単位数合計()));
        div.getPanelSeikyuShokai().getTxtTanyiTanka().setValue(shokanshukei.getShukei().get単位数単価());
        div.getPanelSeikyuShokai().getTxtSeikyugakuHoken().setValue(shokanshukei.getShukei().get請求額());
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanHoken().setValue(new Decimal(shokanshukei.getShukei().get利用者負担額()));
        div.getPanelSeikyuShokai().getTxtSagakukinngakuHoken().setValue(new Decimal(shokanshukei.getShukei().get請求額差額金額()));
        div.getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun().setValue(
                new Decimal(shokanshukei.getShukei().get出来高医療費単位数合計()));
        div.getPanelSeikyuShokai().getTxtSeikyugakuDekikata().setValue(
                shokanshukei.getShukei().get出来高医療費請求額());
        div.getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata().setValue(
                shokanshukei.getShukei().get出来高医療費利用者負担額());
        div.getPanelSeikyuShokai().getTxtSagakukinngakuDekikata().setValue(
                new Decimal(shokanshukei.getShukei().get出来高請求額差額金額()));

    }

    /**
     * 制御処理
     *
     * @param shikibetsuNoKanriEntity ShikibetsuNoKanriResult
     * @param サービス年月 FlexibleYearMonth
     */
    public void setボタン表示制御処理(ShikibetsuNoKanriResult shikibetsuNoKanriEntity, FlexibleYearMonth サービス年月) {

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
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get明細住所地特例設定区分())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get食事費用設定区分())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }

        if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get社会福祉法人軽減設定区分())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        if (設定可_任意.equals(shikibetsuNoKanriEntity.getEntity().get特定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setDisplayNone(false);
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(true);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setVisible(false);
            div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getPanelHead().getBtnKinkyujiShoteiShikkan().setVisible(false);
            if (設定不可.equals(shikibetsuNoKanriEntity.getEntity().get緊急時施設療養設定区分())) {
                div.getPanelHead().getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            }
        }
    }

}
