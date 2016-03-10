/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.dgKeyakusya_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受領委任払いの契約事業者Handlerクラスです。
 */
public class PnlTotalHandler {

    private final PnlTotalDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");

    /**
     * 初期化
     *
     * @param div PnlTotalDiv
     */
    public PnlTotalHandler(PnlTotalDiv div) {
        this.div = div;
    }

    /**
     * 初期化設定
     */
    public void set初期化状態() {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (修正.equals(状態)) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowSelectButtonColumn(false);
        }
        if (参照.equals(状態)) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.福祉用具.getコード(), KeiyakuServiceShurui.福祉用具.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.住宅改修.getコード(), KeiyakuServiceShurui.住宅改修.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.予防福祉用具.getコード(), KeiyakuServiceShurui.予防福祉用具.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.予防住宅改修.getコード(), KeiyakuServiceShurui.予防住宅改修.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.償還払支給.getコード(), KeiyakuServiceShurui.償還払支給.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.高額給付支給.getコード(), KeiyakuServiceShurui.高額給付支給.get名称()));

        div.getPnlSearch().getDdlKeiyakuServiceShurui().setDataSource(keiyakuServiceShuruiList);
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setSelectedKey(RString.EMPTY);

        RString maxCount = BusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxCount().setValue(new Decimal(maxCount.toString()));
        div.getPnlKeiyakusyaList().getBtnSearchAgain().setDisabled(true);
    }

    /**
     * 契約者一覧データを取得します。
     *
     * @return List<ShokanJuryoininKeiyakusha>
     */
    public List<ShokanJuryoininKeiyakusha> get契約者一覧() {
        ShokanJuryoininKeiyakushaFinder finder = InstanceProvider.create(ShokanJuryoininKeiyakushaFinder.class);
        List<ShokanJuryoininKeiyakusha> shokanList = finder.getShokanJuryoininKeiyakushaList(createParameter());
        return shokanList;
    }

    /**
     * グレードの初期化設定。
     *
     * @param shokanList
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
            // TODO
            row.setTxtShimei(new RString("宛名"));
            row.getTxtKeiyakuShenseibi().setValue(new RDate(list.get申請年月日().toString()));
            row.getTxtKeiyakuKeteibi().setValue(new RDate(list.get決定年月日().toString()));
            row.setTxtKeiyakuJigyoshaNo(list.get契約事業者番号());
            //TODO
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

    public void putViewStateHolder() {
        ViewStateHolder.put(ViewStateKeys.契約者一覧情報キー, createParameter());
        ViewStateHolder.put(ViewStateKeys.被保険者名, div.getTxtName().getValue());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getTxtHihokenshaNo().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者番号, div.getTxtJigyoshakeiyakuNo().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者名, div.getTxtJigyoshakeiyakuName().getValue());
    }

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
        ViewStateHolder.put(ViewStateKeys.処理モード, 状態);
    }

    /**
     * パラメータを作成する。
     *
     * @return ShokanJuryoininKeiyakushaParameter　パラメータ
     */
    public ShokanJuryoininKeiyakushaParameter createParameter() {
        ShokanJuryoininKeiyakushaParameter parameter = new ShokanJuryoininKeiyakushaParameter(
                new HihokenshaNo(div.getTxtHihokenshaNo().getValue()),
                div.getTxtShinseiYMDRange().getFromValue() == null ? null
                : new FlexibleDate(div.getTxtShinseiYMDRange().getFromValue().toDateString()),
                div.getTxtShinseiYMDRange().getToValue() == null ? null
                : new FlexibleDate(div.getTxtShinseiYMDRange().getToValue().toDateString()),
                div.getTxtKetteYMDRange().getFromValue() == null ? null
                : new FlexibleDate(div.getTxtKetteYMDRange().getFromValue().toDateString()),
                div.getTxtKetteYMDRange().getToValue() == null ? null
                : new FlexibleDate(div.getTxtKetteYMDRange().getToValue().toDateString()),
                div.getTxtJigyoshakeiyakuNo().getValue().isEmpty() ? null
                : div.getTxtJigyoshakeiyakuNo().getValue(),
                div.getDdlKeiyakuServiceShurui().getSelectedKey().isEmpty() ? null
                : div.getDdlKeiyakuServiceShurui().getSelectedKey(),
                div.getTxtYear().getDomain() == null ? null
                : new FlexibleYear(div.getTxtYear().getDomain().toDateString()),
                div.getTxtKeiyakuNo().getValue().isEmpty() ? null : div.getTxtKeiyakuNo().getValue());
        return parameter;
    }
}
