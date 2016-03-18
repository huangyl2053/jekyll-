/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui.JuryoIninKeiyakuShurui;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.dgKeyakusya_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_検索のHandlerクラス
 */
public class PnlTotalSearchHandler {

    private final PnlTotalSearchDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");

    /**
     * 初期化
     *
     * @param div PnlTotalSearchDiv
     */
    public PnlTotalSearchHandler(PnlTotalSearchDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッド
     *
     * @param div PnlTotalSearchDiv
     * @return PtnTotalHandler
     */
    public static PnlTotalSearchHandler of(PnlTotalSearchDiv div) {
        return new PnlTotalSearchHandler(div);
    }

    /**
     * 初期化設定
     */
    public void set初期化状態() {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (修正.equals(状態)) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowSelectButtonColumn(false);
        } else if (参照.equals(状態)) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setDataSource(createDropDownList());
        JuryoininKeiyakuJigyosha data = ViewStateHolder
                .get(ViewStateKeys.受領委任契約事業者詳細データ, JuryoininKeiyakuJigyosha.class);
        if (data != null) {
            ShokanJuryoininKeiyakushaParameter parameter = ViewStateHolder
                    .get(ViewStateKeys.基本情報パラメータ, ShokanJuryoininKeiyakushaParameter.class);
            div.getPnlSearch().getTxtHihokenshaNo().setValue(new RString(parameter.get被保険者番号().toString()));
            if (parameter.get契約申請日FROM() != null && !parameter.get契約申請日FROM().isEmpty()) {
                div.getPnlSearch().getTxtShinseiYMDRange()
                        .setFromValue(new RDate(parameter.get契約申請日FROM().toString()));
            }
            if (parameter.get契約申請日TO() != null && !parameter.get契約申請日TO().isEmpty()) {
                div.getPnlSearch().getTxtShinseiYMDRange().setToValue(new RDate(parameter.get契約申請日TO().toString()));
            }
            if (parameter.get契約決定日FROM() != null && !parameter.get契約決定日FROM().isEmpty()) {
                div.getPnlSearch().getTxtKetteYMDRange()
                        .setFromValue(new RDate(parameter.get契約決定日FROM().toString()));
            }
            if (parameter.get契約決定日TO() != null && !parameter.get契約決定日TO().isEmpty()) {
                div.getPnlSearch().getTxtKetteYMDRange().setToValue(new RDate(parameter.get契約決定日TO().toString()));
            }
            div.getPnlSearch().getTxtJigyoshakeiyakuNo().setValue(parameter.get契約事業者番号());
            if (parameter.get契約サービス種類() != null) {
                div.getPnlSearch().getDdlKeiyakuServiceShurui().setSelectedKey(parameter.get契約サービス種類());
            }
            if (parameter.get契約年度() != null && !parameter.get契約年度().isEmpty()) {
                div.getPnlSearch().getTxtYear().setDomain(new RYear(parameter.get契約年度().toDateString()));
            }
            div.getPnlSearch().getTxtKeiyakuNo().setValue(parameter.get契約番号());
            RString 被保険者名 = ViewStateHolder.get(ViewStateKeys.被保険者名, RString.class);
            div.getPnlSearch().getTxtName().setValue(被保険者名);
            RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
            div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(契約事業者名);
            Decimal 最大取得件数 = ViewStateHolder
                    .get(ViewStateKeys.受領委任契約事業者検索最大件数, Decimal.class);
            div.getPnlSearch().getTxtMaxCount().setValue(最大取得件数);
            div.getPnlSearch().getTxtJigyoshakeiyakuNo().setValue(data.get契約事業者番号());
            div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(new RString(data.get契約事業者名称().toString()));
        } else {
            div.getPnlSearch().getDdlKeiyakuServiceShurui().setSelectedKey(RString.EMPTY);
            div.getPnlSearch().getTxtMaxCount().setValue(new Decimal(DbBusinessConifg.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(),
                            SubGyomuCode.DBU介護統計報告).toString()));
        }
        div.getPnlKeiyakusyaList().getBtnSearchAgain().setDisabled(true);
    }

    /**
     * 契約種類DropDownListを作成します。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> createDropDownList() {
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修.getコード(), JuryoIninKeiyakuShurui.住宅改修.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.福祉用具.getコード(), JuryoIninKeiyakuShurui.福祉用具.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修_福祉用具.getコード(), JuryoIninKeiyakuShurui.住宅改修_福祉用具.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.償還払給付.getコード(), JuryoIninKeiyakuShurui.償還払給付.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.高額給付費.getコード(), JuryoIninKeiyakuShurui.高額給付費.get名称()));
        return keiyakuServiceShuruiList;
    }

    /**
     * 契約者一覧データを取得します。
     *
     * @param parameter パラメータ
     * @return List<ShokanJuryoininKeiyakusha>
     */
    public List<ShokanJuryoininKeiyakusha> get契約者一覧(ShokanJuryoininKeiyakushaParameter parameter) {
        ShokanJuryoininKeiyakushaFinder finder = InstanceProvider.create(ShokanJuryoininKeiyakushaFinder.class);
        return finder.getShokanJuryoininKeiyakushaList(parameter);
    }

    /**
     * グレードの初期化設定。
     *
     * @param shokanList List<ShokanJuryoininKeiyakusha>
     */
    public void initializeGrid(List<ShokanJuryoininKeiyakusha> shokanList) {
        List<dgKeyakusya_Row> rowList = new ArrayList<>();
        int maxCount = div.getPnlSearch().getTxtMaxCount().getValue().intValue();
        int count = 0;
        for (ShokanJuryoininKeiyakusha list : shokanList) {
            dgKeyakusya_Row row = new dgKeyakusya_Row();
            row.setTxtKeiyakuNo(list.get契約番号());
            row.setTxtServiceShurui(list.get契約サービス種類());
            row.setTxtHihoNo(list.get被保険者番号().getColumnValue());
            // TODO QA.334(Redmine#:78267)
            row.setTxtShimei(new RString("宛名"));
            row.getTxtKeiyakuShenseibi().setValue(new RDate(list.get申請年月日().toString()));
            row.getTxtKeiyakuKeteibi().setValue(new RDate(list.get決定年月日().toString()));
            row.setTxtKeiyakuJigyoshaNo(list.get契約事業者番号());
            // TODO QA.378(Redmine#:78539)
            row.setTxtKeiyakuJigyoshamei(new RString("届出者事業者名称"));
            rowList.add(row);
            count = count + 1;
            if (count >= maxCount) {
                break;
            }
        }
        div.getPnlSearch().setDisplayNone(true);
        div.getPnlKeiyakusyaList().setDisplayNone(false);
        div.getPnlKeiyakusyaList().getBtnSearchAgain().setDisabled(false);
        div.getPnlKeiyakusyaList().getDgKeyakusya().setDataSource(rowList);
    }

    /**
     * ViewStateHolderの設定
     *
     * @param 状態 処理モード
     */
    public void putViewStateHolder(RString 状態) {
        dgKeyakusya_Row row = div.getPnlKeiyakusyaList().getDgKeyakusya().getClickedItem();
        PnlTotalParameter pnlTotalParameter = new PnlTotalParameter(
                row.getTxtKeiyakuNo(),
                row.getTxtServiceShurui(),
                row.getTxtHihoNo(),
                row.getTxtShimei(),
                new FlexibleDate(row.getTxtKeiyakuShenseibi().getValue().toDateString()),
                new FlexibleDate(row.getTxtKeiyakuKeteibi().getValue().toDateString()),
                row.getTxtKeiyakuJigyoshaNo(),
                row.getTxtKeiyakuJigyoshamei());
        ViewStateHolder.put(ViewStateKeys.契約者一覧情報, pnlTotalParameter);
        ViewStateHolder.put(ViewStateKeys.契約者一覧検索キー, createParameter());
        ViewStateHolder.put(ViewStateKeys.受領委任契約事業者検索最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        ViewStateHolder.put(ViewStateKeys.処理モード, 状態);
    }

    /**
     * パラメータを作成する。
     *
     * @return ShokanJuryoininKeiyakushaParameter　パラメータ
     */
    public ShokanJuryoininKeiyakushaParameter createParameter() {
        ShokanJuryoininKeiyakushaParameter parameter = new ShokanJuryoininKeiyakushaParameter(
                div.getPnlSearch().getTxtHihokenshaNo().getValue().isEmpty() ? null
                : new HihokenshaNo(div.getPnlSearch().getTxtHihokenshaNo().getValue()),
                div.getPnlSearch().getTxtShinseiYMDRange().getFromValue() == null ? null
                : new FlexibleDate(div.getPnlSearch().getTxtShinseiYMDRange().getFromValue().toDateString()),
                div.getPnlSearch().getTxtShinseiYMDRange().getToValue() == null ? null
                : new FlexibleDate(div.getPnlSearch().getTxtShinseiYMDRange().getToValue().toDateString()),
                div.getPnlSearch().getTxtKetteYMDRange().getFromValue() == null ? null
                : new FlexibleDate(div.getPnlSearch().getTxtKetteYMDRange().getFromValue().toDateString()),
                div.getPnlSearch().getTxtKetteYMDRange().getToValue() == null ? null
                : new FlexibleDate(div.getPnlSearch().getTxtKetteYMDRange().getToValue().toDateString()),
                div.getPnlSearch().getTxtJigyoshakeiyakuNo().getValue().isEmpty() ? null
                : div.getPnlSearch().getTxtJigyoshakeiyakuNo().getValue(),
                div.getPnlSearch().getDdlKeiyakuServiceShurui().getSelectedKey().isEmpty() ? null
                : div.getPnlSearch().getDdlKeiyakuServiceShurui().getSelectedKey(),
                div.getPnlSearch().getTxtYear().getDomain() == null ? null
                : new FlexibleYear(div.getPnlSearch().getTxtYear().getDomain().toDateString()),
                div.getPnlSearch().getTxtKeiyakuNo().getValue().isEmpty() ? null
                : div.getPnlSearch().getTxtKeiyakuNo().getValue());
        return parameter;
    }
}
