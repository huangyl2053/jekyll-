/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.dgKeyakusya_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

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
            if (list.getEntity().get識別コード() != null) {
                row.setTxtShikibetsuCode(list.getEntity().get識別コード().getColumnValue());
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
