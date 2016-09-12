/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710022;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.UpdSyokanbaraiketeJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.ShokanbaraiketteiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710022.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShokanharaKeteiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710022.ShoukanFutsuKetteiJouhouTourokuParameter;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMN52002_住宅改修費支給申請_償還払決定情報登録
 *
 * @reamsid_L DBC-0992-110 yangchenbing
 */
public final class MainPanelHandler {

    private final MainPanelDiv div;
    private static final RString 受託なし = new RString("1");
    private static final RString 受託あり = new RString("2");

    private MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     *
     * @param div div
     * @return MainPanelHandler
     */
    public static MainPanelHandler of(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    /**
     * 初期化
     *
     * @param 証明書 証明書
     * @param 整理番号 整理番号
     * @param サービス年月 サービス年月
     * @param 給付率 給付率
     */
    public void set初期化(RString 証明書, RString 整理番号, FlexibleYearMonth サービス年月, Decimal 給付率) {
        List<ShikibetsuNoKanri> 様式名称情報 = JutakukaishuSikyuShinseiManager.createInstance().
                getYoshikiName(サービス年月);
        List<KeyValueDataSource> sources = new ArrayList<>();
        if (様式名称情報 != null && !様式名称情報.isEmpty()) {
            for (ShikibetsuNoKanri db : 様式名称情報) {
                sources.add(new KeyValueDataSource(db.get識別番号(), db.get名称()));
            }
        }
        div.getDdlSyomeisyo().setDataSource(sources);
        div.getDdlSyomeisyo().setSelectedKey(証明書);
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtKyufuritsu().setValue(給付率);
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtSeiriNo().setValue(整理番号);
        div.getJutakuKaishuShinseiInfoPanel().getCommHeadPanel().getTxtTeikyoYM().setValue(new RDate(サービス年月.toString()));
    }

    /**
     * 内容変更状態
     *
     * @param parameter ShoukanFutsuKetteiJouhouTourokuParameter
     * @return boolean
     */
    public boolean is内容変更状態(ShoukanFutsuKetteiJouhouTourokuParameter parameter) {
        ShokanbaraiketteiJohoDiv shokanbaraiketteiJohoDiv = (ShokanbaraiketteiJohoDiv) div.getJutakuKaishuShinseiInfoPanel()
                .getShokanbaraiKetteiJyohoPanel().getCcdShokanbaraiketteiJoho();
        RDate 決定日New = shokanbaraiketteiJohoDiv.getTxtKetebi().getValue();
        RDate 決定日Old = parameter.get決定日();
        if (!決定日New.equals(決定日Old)) {
            return true;
        }
        RString 支給区分New = shokanbaraiketteiJohoDiv.getRdoShikyukubun().getSelectedKey();
        RString 支給区分Old = parameter.get支給区分();
        if (!支給区分New.equals(支給区分Old)) {
            return true;
        }
        if (ShikyuFushikyuKubun.支給.getコード().equals(支給区分New)) {

            Decimal 支払金額合計New = shokanbaraiketteiJohoDiv.getTxtShiharaikingakugoke().getValue();
            Decimal 支払金額合計Old = parameter.get支払金額合計();
            if (!支払金額合計New.equals(支払金額合計Old)) {
                return true;
            }
            Decimal 増減単位New = shokanbaraiketteiJohoDiv.getTxtZogentani().getValue();
            Decimal 増減単位Old = parameter.get増減単位();
            if (増減単位New.equals(増減単位Old)) {
                return true;
            }
            RString 増減理由New = shokanbaraiketteiJohoDiv.getTxtZogenriyu().getValue();
            RString 増減理由Old = parameter.get増減理由();
            return 増減理由チェック(増減理由New, 増減理由Old);
        } else {
            RString fuSyikyuriyu1New = shokanbaraiketteiJohoDiv.getTxtFuSyikyuriyu1().getValue();
            RString fuSyikyuriyu1Old = parameter.get不支給理由１();
            if (!fuSyikyuriyu1New.equals(fuSyikyuriyu1Old)) {
                return true;
            }
            RString fuSyikyuriyu2New = shokanbaraiketteiJohoDiv.getTxtFushikyuriyu2().getValue();
            RString fuSyikyuriyu2Old = parameter.get不支給理由２();
            return !fuSyikyuriyu2New.equals(fuSyikyuriyu2Old);
        }
    }

    private boolean 増減理由チェック(RString 増減理由New, RString 増減理由Old) {
        if (増減理由New.isNullOrEmpty() && 増減理由Old.isNullOrEmpty()) {
            return false;
        } else if (増減理由New.isNullOrEmpty() || 増減理由Old.isNullOrEmpty()) {
            return true;
        } else {
            return !増減理由New.equals(増減理由Old);
        }
    }

    /**
     * set画面データ
     *
     * @return parameter
     */
    public ShoukanFutsuKetteiJouhouTourokuParameter set画面データ() {
        ShoukanFutsuKetteiJouhouTourokuParameter parameter = new ShoukanFutsuKetteiJouhouTourokuParameter();
        parameter.set決定日(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue());
        parameter.set支給区分(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey());
        parameter.set支払金額合計(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue());
        parameter.set増減単位(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue());
        parameter.set増減理由(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue());
        parameter.set不支給理由１(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue());
        parameter.set不支給理由２(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue());
        return parameter;
    }

    /**
     * 申請内容の保存
     *
     * @param 検索情報キー ShokanharaKeteiJyohoParameter
     * @return 保存処理結果
     */
    public boolean 保存処理(ShokanharaKeteiJyohoParameter 検索情報キー) {
        HihokenshaNo 被保険者番号 = 検索情報キー.get被保険者番号();
        RString 整理番号 = 検索情報キー.get整理番号();
        FlexibleYearMonth サービス年月 = 検索情報キー.getサービス提供年月();
        RString 証明書 = 検索情報キー.get証明書();
        ShikibetsuCode 識別コード = 検索情報キー.get識別コード();
        FlexibleDate 決定日 = new FlexibleDate(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toDateString());
        RString 支給区分 = div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getRdoShikyukubun().getSelectedKey();
        FlexibleDate 決定年月日 = 決定日;
        RString 支給決定区分 = 支給区分;
        Decimal 支払金額 = div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue();
        Decimal 前回支払金額 = 支払金額;
        Decimal 差額金額合計 = div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtSagakuGoke().getValue();

        UpdSyokanbaraiketeJoho parameter = UpdSyokanbaraiketeJoho.createSelectByKeyParam(
                被保険者番号, サービス年月, 整理番号, 証明書, 識別コード, 検索情報キー.get保険者番号(), 決定日, 支給区分,
                決定年月日, 支給決定区分, 支払金額, 前回支払金額, 差額金額合計);
        ShokanShinsei dbt3034 = new ShokanShinsei(被保険者番号, サービス年月, 整理番号);

        RString 国保連共同処理受託区分_償還 = DbBusinessConfig.get(
                ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託なし.equals(国保連共同処理受託区分_償還)) {
            dbt3034 = dbt3034.createBuilderForEdit().set支給申請審査区分(ShikyushinseiShinsaKubun.審査済.getコード()).
                    set審査方法区分(ShinsaHohoKubun.審査済み.getコード()).
                    set審査年月日(決定日).build();
            if (ShikyuFushikyuKubun.不支給.getコード().equals(支給区分)) {
                dbt3034 = dbt3034.createBuilderForEdit().set審査結果(ShinsaNaiyoKubun.却下する.getコード()).build();
            } else if (ShikyuFushikyuKubun.支給.getコード().equals(支給区分)) {
                dbt3034 = dbt3034.createBuilderForEdit().set審査結果(ShinsaNaiyoKubun.承認する.getコード()).build();
            }
        } else if (受託あり.equals(国保連共同処理受託区分_償還)) {
            dbt3034 = dbt3034.createBuilderForEdit().set支給申請審査区分(ShikyushinseiShinsaKubun.未審査.getコード()).
                    set審査方法区分(ShinsaHohoKubun.審査依頼.getコード()).
                    set審査年月日(null).set審査結果(null).build();
        }

        ShokanShukei dbt3053 = new ShokanShukei(被保険者番号, サービス年月, 整理番号,
                new JigyoshaNo(整理番号), 整理番号, 整理番号, 証明書);
        dbt3053 = dbt3053.createBuilderForEdit().set審査方法区分コード(dbt3034.get審査方法区分()).
                set審査年月(決定日.getYearMonth()).set支給区分コード(支給区分).
                set支払金額(支払金額.intValue()).
                set増減点(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                        getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogentani().getValue().intValue()).
                set請求額差額金額(差額金額合計.intValue()).
                set増減理由等(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                        getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtZogenriyu().getValue()).
                set不支給理由等(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                        getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFuSyikyuriyu1().getValue()).
                set購入_改修履歴等(div.getJutakuKaishuShinseiInfoPanel().getShokanbaraiKetteiJyohoPanel().
                        getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtFushikyuriyu2().getValue()).
                build();

        JutakukaishuSikyuShinseiManager manager = JutakukaishuSikyuShinseiManager.createInstance();

        return manager.updSyokanbaraiketeJoho(parameter, dbt3034, dbt3053);
    }

}
