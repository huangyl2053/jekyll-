/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboJigyoTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.nijiyobojigyotaishosha.NijiYoboJigyoTaishoshaHolder;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.dgKihonInfo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 総合事業（経過措置）対象者登録画面
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class NijiyoboJohoTaishoshaTorokuPanelHandler {

    private static final RString 空白 = RString.EMPTY;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString BTN_保存する = new RString("btnHozonn");
    private static final RString ZERO = new RString("0");
    private final NijiyoboJohoTaishoshaTorokuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaigoShienSenmoninTouroku1Div
     */
    public NijiyoboJohoTaishoshaTorokuPanelHandler(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化を処理します。
     *
     * @param 資格対象者 TaishoshaKey
     * @param 二次予防情報対象一覧List List<NijiYoboJigyoTaishosha>
     */
    public void onLoad(TaishoshaKey 資格対象者, List<NijiYoboJigyoTaishosha> 二次予防情報対象一覧List) {
        div.set被保険者番号(資格対象者.get被保険者番号().getColumnValue());
        initialize(資格対象者);
        二次予防情報対象一覧グリッドを表示する(二次予防情報対象一覧List);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_保存する, true);
    }

    private void initialize(TaishoshaKey 資格対象者) {
        div.getKaigoAtenaInfoChildDiv1().initialize(資格対象者.get識別コード());
        div.getKaiigoShikakCommonChildDiv2().initialize(資格対象者.get被保険者番号());
    }

    private void 二次予防情報対象一覧グリッドを表示する(List<NijiYoboJigyoTaishosha> 二次予防情報対象一覧List) {
        List<dgKihonInfo_Row> rowList = new ArrayList<>();
        if (null != 二次予防情報対象一覧List && (!二次予防情報対象一覧List.isEmpty())) {
            for (NijiYoboJigyoTaishosha 二次予防情報 : 二次予防情報対象一覧List) {
                dgKihonInfo_Row row = new dgKihonInfo_Row();
                row.setJoutai(空白);
                if (null != 二次予防情報.get適用開始年月日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get適用開始年月日()))) {
                    row.getTekiyouKaishiBi().setValue(new RDate(二次予防情報.get適用開始年月日().toString()));
                }
                if (null != 二次予防情報.get適用終了年月日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get適用終了年月日()))) {
                    row.getTekiyouShuuryouBi().setValue(new RDate(二次予防情報.get適用終了年月日().toString()));
                }
                if (null != 二次予防情報.get調査実施日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get調査実施日()))) {
                    row.getChousaZisshiBi().setValue(new RDate(二次予防情報.get調査実施日().toString()));
                }
                if (null != 二次予防情報.get決定年月日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get決定年月日()))) {
                    row.getKetteiBi().setValue(new RDate(二次予防情報.get決定年月日().toString()));
                }
                row.setRirekiNo(new RString(二次予防情報.get履歴番号()));
                rowList.add(row);
            }
            sortDg二次予防情報対象一覧(rowList);
        }
        div.getKihonnInfo().getDgKihonInfo().setDataSource(rowList);
    }

    private void sortDg二次予防情報対象一覧(List<dgKihonInfo_Row> rowList) {
        Collections.sort(rowList, new Comparator<dgKihonInfo_Row>() {
            @Override
            public int compare(dgKihonInfo_Row row1, dgKihonInfo_Row row2) {
                return row1.getTekiyouKaishiBi().getValue().isBefore(row2.getTekiyouKaishiBi().getValue()) ? -1 : 1;
            }
        });
    }

    /**
     * 「追加する」ボタンを処理します。
     */
    public void onClick_btnAdd() {
        div.setOperateState(追加);
        二次予防情報対象詳細パネルにクリアする();
        二次予防情報対象詳細パネルに制御を設定する();
    }

    private void 二次予防情報対象詳細パネルにクリアする() {
        div.getSoukoinfo().getTxtymfromto().clearFromValue();
        div.getSoukoinfo().getTxtymfromto().clearToValue();
        div.getSoukoinfo().getTxtChousaZisshibi().clearValue();
        div.getSoukoinfo().getTxtKetteibi().clearValue();
        div.getSoukoinfo().getBtnConfirm().setDisabled(false);
    }

    private void 二次予防情報対象詳細パネルに制御を設定する() {
        boolean is削除状態 = 削除.equals(div.getOperateState());
        div.getSoukoinfo().getTxtymfromto().setDisabled(is削除状態);
        div.getSoukoinfo().getTxtChousaZisshibi().setDisabled(is削除状態);
        div.getSoukoinfo().getTxtKetteibi().setDisabled(is削除状態);

        if (!is削除状態) {
            二次予防情報対象詳細パネルに確定するボタン制御を設定する();
        }
    }

    private void 二次予防情報対象詳細パネルに確定するボタン制御を設定する() {
        List<dgKihonInfo_Row> rowList = div.getKihonnInfo().getDgKihonInfo().getDataSource();
        boolean is適用開始日と登録済みの適用期間が重なる = false;
        RDate 適用開始日 = div.getSoukoinfo().getTxtymfromto().getFromValue();
        RString clickRirekiNo = 追加.equals(div.getOperateState()) ? ZERO
                : div.getKihonnInfo().getDgKihonInfo().getClickedItem().getRirekiNo();
        for (dgKihonInfo_Row row : rowList) {
            RDate 登録済みの適用期間開始日 = row.getTekiyouKaishiBi().getValue();
            RDate 登録済みの適用期間終了日 = row.getTekiyouShuuryouBi().getValue();
            if (null == 適用開始日) {
                is適用開始日と登録済みの適用期間が重なる = true;
            } else if ((!clickRirekiNo.equals(row.getRirekiNo()))
                    && (null != 登録済みの適用期間開始日 && 登録済みの適用期間開始日.isBeforeOrEquals(適用開始日)
                    && null != 登録済みの適用期間終了日 && 適用開始日.isBeforeOrEquals(登録済みの適用期間終了日))) {
                is適用開始日と登録済みの適用期間が重なる = true;
            }
        }
        div.getSoukoinfo().getBtnConfirm().setDisabled(is適用開始日と登録済みの適用期間が重なる);
    }

    /**
     * 「追加する」ボタンを処理します。
     */
    public void onClick_dgModify() {
        div.setOperateState(修正);
        二次予防情報対象詳細パネルにクリアする();
        二次予防情報対象詳細パネルに表示する();
        二次予防情報対象詳細パネルに制御を設定する();
    }

    private void 二次予防情報対象詳細パネルに表示する() {
        dgKihonInfo_Row row = div.getKihonnInfo().getDgKihonInfo().getClickedItem();
        div.getSoukoinfo().getTxtymfromto().clearFromValue();
        div.getSoukoinfo().getTxtymfromto().clearToValue();
        if (null != row.getTekiyouKaishiBi().getValue()) {
            div.getSoukoinfo().getTxtymfromto().setFromValue(row.getTekiyouKaishiBi().getValue());
        }
        if (null != row.getTekiyouShuuryouBi().getValue()) {
            div.getSoukoinfo().getTxtymfromto().setToValue(row.getTekiyouShuuryouBi().getValue());
        }
        div.getSoukoinfo().getTxtChousaZisshibi().clearValue();
        if (null != row.getChousaZisshiBi().getValue()) {
            div.getSoukoinfo().getTxtChousaZisshibi().setValue(row.getChousaZisshiBi().getValue());
        }
        div.getSoukoinfo().getTxtKetteibi().clearValue();
        if (null != row.getKetteiBi().getValue()) {
            div.getSoukoinfo().getTxtKetteibi().setValue(row.getKetteiBi().getValue());
        }
    }

    /**
     * 「追加する」ボタンを処理します。
     */
    public void onClick_dgDelete() {
        div.setOperateState(削除);
        二次予防情報対象詳細パネルにクリアする();
        二次予防情報対象詳細パネルに表示する();
        二次予防情報対象詳細パネルに制御を設定する();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 適用期間の変更を処理します。
     */
    public void onChange_dateRange() {
        二次予防情報対象詳細パネルに確定するボタン制御を設定する();
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「確定する」ボタンを処理します。
     */
    public void onClick_btnConfim() {
        if (追加.equals(div.getOperateState())) {
            dgKihonInfo_Row row = new dgKihonInfo_Row();
            row.setJoutai(追加);
            二次予防情報対象一覧に修正された行の内容を変更する(row);
            div.getKihonnInfo().getDgKihonInfo().getDataSource().add(row);

            List<dgKihonInfo_Row> rowList = div.getKihonnInfo().getDgKihonInfo().getDataSource();
            sortDg二次予防情報対象一覧(rowList);
            div.getKihonnInfo().getDgKihonInfo().setDataSource(rowList);
        }
        if (修正.equals(div.getOperateState())) {
            dgKihonInfo_Row row = div.getKihonnInfo().getDgKihonInfo().getClickedItem();
            if (!追加.equals(row.getJoutai())) {
                row.setJoutai(修正);
            }
            二次予防情報対象一覧に修正された行の内容を変更する(row);
        }
        if (削除.equals(div.getOperateState())) {
            dgKihonInfo_Row row = div.getKihonnInfo().getDgKihonInfo().getClickedItem();
            if (追加.equals(row.getJoutai())) {
                div.getKihonnInfo().getDgKihonInfo().getDataSource().remove(
                        div.getKihonnInfo().getDgKihonInfo().getClickedRowId());
            } else {
                row.setJoutai(削除);
                二次予防情報対象一覧に修正された行の内容を変更する(row);
            }
        }
    }

    private void 二次予防情報対象一覧に修正された行の内容を変更する(dgKihonInfo_Row row) {
        row.getTekiyouKaishiBi().setValue(div.getSoukoinfo().getTxtymfromto().getFromValue());
        row.getTekiyouShuuryouBi().setValue(div.getSoukoinfo().getTxtymfromto().getToValue());
        row.getChousaZisshiBi().setValue(div.getSoukoinfo().getTxtChousaZisshibi().getValue());
        row.getKetteiBi().setValue(div.getSoukoinfo().getTxtKetteibi().getValue());
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「取消する」ボタンを処理します。
     */
    public void onClick_btnCancel() {
        div.setOperateState(空白);
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「保存する」ボタンの制御を処理します。
     */
    public void onState_btnSave() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_保存する, true);
        List<dgKihonInfo_Row> rowList = div.getKihonnInfo().getDgKihonInfo().getDataSource();
        for (dgKihonInfo_Row row : rowList) {
            if (!空白.equals(row.getJoutai())) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_保存する, false);
            }
        }
    }

    /**
     * 二次予防情報対象一覧のデータを保存します。
     *
     * @param rowList List<dgKihonInfo_Row>
     * @param 被保険者番号 HihokenshaNo
     * @param holder NijiYoboJigyoTaishoshaHolder
     */
    public void 二次予防情報対象一覧のデータを保存する(List<dgKihonInfo_Row> rowList,
            HihokenshaNo 被保険者番号, NijiYoboJigyoTaishoshaHolder holder) {
        int 履歴番号MAX = 0;
        for (dgKihonInfo_Row row : rowList) {
            if ((!追加.equals(row.getJoutai())) && (!RString.isNullOrEmpty(row.getRirekiNo()))
                    && 履歴番号MAX < Integer.parseInt(row.getRirekiNo().toString())) {
                履歴番号MAX = Integer.parseInt(row.getRirekiNo().toString());
            }
        }
        List<NijiYoboJigyoTaishosha> changeItems = new ArrayList<>();
        for (dgKihonInfo_Row row : rowList) {
            if (追加.equals(row.getJoutai())) {
                履歴番号MAX++;
                NijiYoboJigyoTaishosha changeItem = new NijiYoboJigyoTaishosha(被保険者番号, 履歴番号MAX).createBuilderForEdit()
                        .set適用開始年月日(null == row.getTekiyouKaishiBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyouKaishiBi().getValue().toString()))
                        .set適用終了年月日(null == row.getTekiyouShuuryouBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyouShuuryouBi().getValue().toString()))
                        .set調査実施日(null == row.getChousaZisshiBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getChousaZisshiBi().getValue().toString()))
                        .set決定年月日(null == row.getKetteiBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getKetteiBi().getValue().toString()))
                        .set受付年月日(FlexibleDate.EMPTY)
                        .build();
                changeItems.add(changeItem);
            }
            if (修正.equals(row.getJoutai())) {
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                NijiYoboJigyoTaishosha changeItem
                        = holder.getNijiYoboJigyoTaishosha(new NijiYoboJigyoTaishoshaIdentifier(被保険者番号, 履歴番号)).createBuilderForEdit()
                        .set適用開始年月日(null == row.getTekiyouKaishiBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyouKaishiBi().getValue().toString()))
                        .set適用終了年月日(null == row.getTekiyouShuuryouBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyouShuuryouBi().getValue().toString()))
                        .set調査実施日(null == row.getChousaZisshiBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getChousaZisshiBi().getValue().toString()))
                        .set決定年月日(null == row.getKetteiBi().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getKetteiBi().getValue().toString()))
                        .build();
                changeItems.add(changeItem);
            }
            if (削除.equals(row.getJoutai())) {
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                NijiYoboJigyoTaishosha changeItem
                        = holder.getNijiYoboJigyoTaishosha(new NijiYoboJigyoTaishoshaIdentifier(被保険者番号, 履歴番号)).deleted();
                changeItems.add(changeItem);
            }
        }
        if (!changeItems.isEmpty()) {
            NijiYoboJigyoTaishoshaManager manager = new NijiYoboJigyoTaishoshaManager();
            for (NijiYoboJigyoTaishosha changeItem : changeItems) {
                manager.saveOrDeletePhysicalBy二次予防事業対象者(changeItem);
            }
        }
    }
}
