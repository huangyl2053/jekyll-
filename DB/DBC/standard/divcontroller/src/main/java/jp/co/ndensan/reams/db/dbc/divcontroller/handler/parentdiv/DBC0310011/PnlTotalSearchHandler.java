/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.dgKeyakusya_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalSearchParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_検索のHandlerクラス
 *
 * @reamsid_L DBC-2130-010 cuilin
 */
public class PnlTotalSearchHandler {

    private final PnlTotalSearchDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 契約者選択 = new RString("契約者選択");
    private static final RString 対象者検索 = new RString("対象者検索");
    private static final RString 事業者検索 = new RString("事業者検索");

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
     *
     * @param 表示モード RString
     * @param 画面モード RString
     */
    public void set初期化状態(RString 表示モード, RString 画面モード) {
        if (修正.equals(画面モード) || 削除.equals(画面モード)) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowSelectButtonColumn(false);
        } else if (参照.equals(画面モード)) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getPnlKeiyakusyaList().getDgKeyakusya().getGridSetting().setIsShowDeleteButtonColumn(false);
        }
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setDataSource(createDropDownList());
        if (表示モード == null || 表示モード.isEmpty()) {
            div.getPnlSearch().getDdlKeiyakuServiceShurui().setSelectedKey(RString.EMPTY);
            div.getPnlSearch().getTxtMaxCount().setValue(new Decimal(DbBusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                            SubGyomuCode.DBU介護統計報告).toString()));
        } else {
            ShokanJuryoininKeiyakushaParameter parameter = ViewStateHolder
                    .get(ViewStateKeys.契約者一覧検索キー, ShokanJuryoininKeiyakushaParameter.class);
            set基本情報パラメータ(parameter);
            if (対象者検索.equals(表示モード)) {
                TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = key.get被保険者番号();
                ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
                IName 被保険者名 = finder.get氏名(被保険者番号);
                div.getPnlSearch().getTxtHihokenshaNo().setValue(被保険者番号.getColumnValue());
                div.getPnlSearch().getTxtName().setValue(被保険者名 == null ? RString.EMPTY
                        : 被保険者名.getName().getColumnValue());
            } else if (事業者検索.equals(表示モード)) {
                JuryoininKeiyakuJigyosha data = ViewStateHolder
                        .get(ViewStateKeys.受領委任契約事業者詳細データ, JuryoininKeiyakuJigyosha.class);
                ViewStateHolder.put(ViewStateKeys.契約事業者番号, data.get契約事業者番号());
                ViewStateHolder.put(ViewStateKeys.契約事業者名, data.get契約事業者名称().getColumnValue());
                div.getPnlSearch().getTxtJigyoshakeiyakuNo().setValue(data.get契約事業者番号());
                div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(data.get契約事業者名称().getColumnValue());
            }
        }
        div.getPnlSearch().setDisplayNone(false);
        div.getPnlKeiyakusyaList().setDisplayNone(true);
        div.getPnlKeiyakusyaList().getBtnSearchAgain().setDisabled(true);
    }

    /**
     * 基本情報パラメータの設定
     *
     * @param parameter ShokanJuryoininKeiyakushaParameter
     */
    public void set基本情報パラメータ(ShokanJuryoininKeiyakushaParameter parameter) {
        if (parameter.get被保険者番号() != null && !parameter.get被保険者番号().isEmpty()) {
            div.getPnlSearch().getTxtHihokenshaNo().setValue(parameter.get被保険者番号().getColumnValue());
        }
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
                KeiyakuServiceShurui.福祉用具.getコード(), KeiyakuServiceShurui.福祉用具.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.住宅改修.getコード(), KeiyakuServiceShurui.住宅改修.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.予防福祉用具.getコード(), KeiyakuServiceShurui.予防福祉用具.get名称()));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(
                KeiyakuServiceShurui.予防住宅改修.getコード(), KeiyakuServiceShurui.予防住宅改修.get名称()));
        return keiyakuServiceShuruiList;
    }

    /**
     * 契約者一覧データを取得します。
     *
     * @param parameter パラメータ
     * @return List<ShokanJuryoininKeiyakusha>
     */
    public List<ShokanJuryoininKeiyakushaResult> get契約者一覧(ShokanJuryoininKeiyakushaParameter parameter) {
        ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
        return finder.getShokanJuryoininKeiyakushaList(parameter);
    }

    /**
     * グレードの初期化設定。
     *
     * @param shokanList List<ShokanJuryoininKeiyakusha>
     * @param maxCount Decimal
     */
    public void initializeGrid(List<ShokanJuryoininKeiyakushaResult> shokanList, Decimal maxCount) {
        div.getPnlKeiyakusyaList().setIsOpen(true);
        div.getPnlSearch().setDisplayNone(true);
        div.getPnlKeiyakusyaList().setDisplayNone(false);
        div.getPnlKeiyakusyaList().getBtnSearchAgain().setDisabled(false);
        List<dgKeyakusya_Row> rowList = new ArrayList<>();
        if (shokanList == null || shokanList.isEmpty()) {
            div.getPnlKeiyakusyaList().getDgKeyakusya().setDataSource(rowList);
            return;
        }
        int count = 0;
        for (ShokanJuryoininKeiyakushaResult list : shokanList) {
            dgKeyakusya_Row row = new dgKeyakusya_Row();
            row.setTxtKeiyakuNo(list.getEntity().getDbt3078entity().getKeiyakuNo());
            if (list.getEntity().getDbt3078entity().getKeiyakuServiceShurui() != null
                    && !list.getEntity().getDbt3078entity().getKeiyakuServiceShurui().isEmpty()) {
                row.setTxtServiceShurui(KeiyakuServiceShurui
                        .toValue(list.getEntity().getDbt3078entity().getKeiyakuServiceShurui()).get名称());
            }
            row.setTxtHihoNo(list.getEntity().getDbt3078entity().getHihokenshaNo().getColumnValue());
            IName 氏名 = list.getEntity().get氏名();
            if (氏名 != null && 氏名.getName() != null) {
                row.setTxtShimei(氏名.getName().getColumnValue());
            }
            row.getTxtKeiyakuShenseibi().setValue(new RDate(list.getEntity().getDbt3078entity().getShinseiYMD().toString()));
            FlexibleDate 決定年月日 = list.getEntity().getDbt3078entity().getKetteiYMD();
            if (決定年月日 != null && !決定年月日.isEmpty()) {
                row.getTxtKeiyakuKeteibi().setValue(new RDate(決定年月日.toString()));
            }
            row.setTxtKeiyakuJigyoshaNo(list.getEntity().getDbt3078entity().getKeiyakuJigyoshaNo());
            AtenaMeisho 契約事業者名称 = list.getEntity().getDbt3077entity().getKeiyakuJigyoshaName();
            if (契約事業者名称 != null) {
                row.setTxtKeiyakuJigyoshamei(契約事業者名称.getColumnValue());
            }
            rowList.add(row);
            count = count + 1;
            if (count >= maxCount.intValue()) {
                break;
            }
        }
        div.getPnlKeiyakusyaList().getDgKeyakusya().setDataSource(rowList);
    }

    /**
     * ViewStateHolderの設定
     *
     * @param 画面モード RString
     */
    public void putViewStateHolder(RString 画面モード) {
        List<KeyValueDataSource> keiyakuServiceShuruiList = div.getPnlSearch()
                .getDdlKeiyakuServiceShurui().getDataSource();
        dgKeyakusya_Row row = div.getPnlKeiyakusyaList().getDgKeyakusya().getClickedItem();
        RString 契約サービス種類 = RString.EMPTY;
        for (KeyValueDataSource keyValue : keiyakuServiceShuruiList) {
            if (row.getTxtServiceShurui().equals(keyValue.getValue())) {
                契約サービス種類 = keyValue.getKey();
                break;
            }
        }
        PnlTotalSearchParameter pnlTotalSearchParameter = new PnlTotalSearchParameter(
                row.getTxtKeiyakuNo(),
                契約サービス種類,
                row.getTxtHihoNo(),
                row.getTxtShimei(),
                new FlexibleDate(row.getTxtKeiyakuShenseibi().getValue().toDateString()),
                row.getTxtKeiyakuKeteibi().getValue() == null ? null
                : new FlexibleDate(row.getTxtKeiyakuKeteibi().getValue().toDateString()),
                row.getTxtKeiyakuJigyoshaNo(),
                row.getTxtKeiyakuJigyoshamei());
        ViewStateHolder.put(ViewStateKeys.契約者一覧情報, pnlTotalSearchParameter);
        ViewStateHolder.put(ViewStateKeys.受領委任契約事業者検索最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        ViewStateHolder.put(ViewStateKeys.表示モード, 契約者選択);
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
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
