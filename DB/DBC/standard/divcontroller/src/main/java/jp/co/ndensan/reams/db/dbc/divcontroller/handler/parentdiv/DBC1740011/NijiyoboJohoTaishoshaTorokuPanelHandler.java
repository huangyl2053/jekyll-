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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.dgNijiyoboJohoTaishoIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.NijiYoboJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 総合事業（経過措置）対象者登録画面
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class NijiyoboJohoTaishoshaTorokuPanelHandler {

    private static final RString 空白 = RString.EMPTY;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
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
        div.set識別コード(資格対象者.get識別コード().getColumnValue());
        initialize(資格対象者);
        二次予防情報対象一覧グリッドを表示する(二次予防情報対象一覧List);
    }

    private void initialize(TaishoshaKey 資格対象者) {
        div.getCcdKaigoAtenaInfo().initialize(資格対象者.get識別コード());
        div.getCcdKaiigoShikakuKihon().initialize(資格対象者.get被保険者番号());
    }

    private void 二次予防情報対象一覧グリッドを表示する(List<NijiYoboJigyoTaishosha> 二次予防情報対象一覧List) {
        List<dgNijiyoboJohoTaishoIchiran_Row> rowList = new ArrayList<>();
        if (null != 二次予防情報対象一覧List && (!二次予防情報対象一覧List.isEmpty())) {
            for (NijiYoboJigyoTaishosha 二次予防情報 : 二次予防情報対象一覧List) {
                dgNijiyoboJohoTaishoIchiran_Row row = new dgNijiyoboJohoTaishoIchiran_Row();
                row.setRowState(RowState.Unchanged);
                if (null != 二次予防情報.get適用開始年月日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get適用開始年月日()))) {
                    row.getTekiyoKaishiYMD().setValue(new RDate(二次予防情報.get適用開始年月日().toString()));
                }
                if (null != 二次予防情報.get適用終了年月日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get適用終了年月日()))) {
                    row.getTekiyoShuryoYMD().setValue(new RDate(二次予防情報.get適用終了年月日().toString()));
                }
                if (null != 二次予防情報.get調査実施日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get調査実施日()))) {
                    row.getChosaJisshiYMD().setValue(new RDate(二次予防情報.get調査実施日().toString()));
                }
                if (null != 二次予防情報.get決定年月日() && (!FlexibleDate.EMPTY.equals(二次予防情報.get決定年月日()))) {
                    row.getKetteiYMD().setValue(new RDate(二次予防情報.get決定年月日().toString()));
                }
                row.setRirekiNo(new RString(二次予防情報.get履歴番号()));
                rowList.add(row);
            }
            sortDg二次予防情報対象一覧(rowList);
        }
        div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().setDataSource(rowList);
    }

    private void sortDg二次予防情報対象一覧(List<dgNijiyoboJohoTaishoIchiran_Row> rowList) {
        Collections.sort(rowList, new Comparator<dgNijiyoboJohoTaishoIchiran_Row>() {
            @Override
            public int compare(dgNijiyoboJohoTaishoIchiran_Row row1, dgNijiyoboJohoTaishoIchiran_Row row2) {
                return row1.getTekiyoKaishiYMD().getValue().isBefore(row2.getTekiyoKaishiYMD().getValue()) ? -1 : 1;
            }
        });
    }

    /**
     * 「追加する」ボタンを処理します。
     */
    public void onClick_btnAdd() {
        div.setOperateState(追加);
        二次予防情報対象詳細パネルにクリアする();
        二次予防情報対象詳細パネルに確定するボタン制御を設定する();
    }

    private void 二次予防情報対象詳細パネルにクリアする() {
        div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().clearFromValue();
        div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().clearToValue();
        div.getNijiyoboJohoShosai().getTxtChosaJisshiYMD().clearValue();
        div.getNijiyoboJohoShosai().getTxtKetteiYMD().clearValue();
        div.getNijiyoboJohoShosai().getBtnConfirm().setDisabled(false);
    }

    private void 二次予防情報対象詳細パネルに確定するボタン制御を設定する() {
        List<dgNijiyoboJohoTaishoIchiran_Row> rowList = div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getDataSource();
        boolean is適用開始日と登録済みの適用期間が重なる = false;
        RDate 適用開始日 = div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().getFromValue();
        RString clickRirekiNo = 追加.equals(div.getOperateState()) ? ZERO
                : div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getClickedItem().getRirekiNo();
        for (dgNijiyoboJohoTaishoIchiran_Row row : rowList) {
            RDate 登録済みの適用期間開始日 = row.getTekiyoKaishiYMD().getValue();
            RDate 登録済みの適用期間終了日 = row.getTekiyoShuryoYMD().getValue();
            if (null == 適用開始日) {
                is適用開始日と登録済みの適用期間が重なる = true;
            } else if ((!clickRirekiNo.equals(row.getRirekiNo()))
                    && (null != 登録済みの適用期間開始日 && 登録済みの適用期間開始日.isBeforeOrEquals(適用開始日)
                    && null != 登録済みの適用期間終了日 && 適用開始日.isBeforeOrEquals(登録済みの適用期間終了日))) {
                is適用開始日と登録済みの適用期間が重なる = true;
            }
        }
        div.getNijiyoboJohoShosai().getBtnConfirm().setDisabled(is適用開始日と登録済みの適用期間が重なる);
    }

    /**
     * 「追加する」ボタンを処理します。
     */
    public void onClick_dgModify() {
        div.setOperateState(修正);
        二次予防情報対象詳細パネルにクリアする();
        二次予防情報対象詳細パネルに表示する();
        二次予防情報対象詳細パネルに確定するボタン制御を設定する();
    }

    private void 二次予防情報対象詳細パネルに表示する() {
        dgNijiyoboJohoTaishoIchiran_Row row = div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getClickedItem();
        div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().clearFromValue();
        div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().clearToValue();
        if (null != row.getTekiyoKaishiYMD().getValue()) {
            div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().setFromValue(row.getTekiyoKaishiYMD().getValue());
        }
        if (null != row.getTekiyoShuryoYMD().getValue()) {
            div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().setToValue(row.getTekiyoShuryoYMD().getValue());
        }
        div.getNijiyoboJohoShosai().getTxtChosaJisshiYMD().clearValue();
        if (null != row.getChosaJisshiYMD().getValue()) {
            div.getNijiyoboJohoShosai().getTxtChosaJisshiYMD().setValue(row.getChosaJisshiYMD().getValue());
        }
        div.getNijiyoboJohoShosai().getTxtKetteiYMD().clearValue();
        if (null != row.getKetteiYMD().getValue()) {
            div.getNijiyoboJohoShosai().getTxtKetteiYMD().setValue(row.getKetteiYMD().getValue());
        }
    }

    /**
     * 「追加する」ボタンを処理します。
     */
    public void onClick_dgDelete() {
        if (RowState.Added != div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getClickedItem().getRowState()) {
            div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getClickedItem().setRowState(RowState.Deleted);
        } else {
            div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getDataSource().remove(
                    div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getClickedRowId());
        }
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
            dgNijiyoboJohoTaishoIchiran_Row row = new dgNijiyoboJohoTaishoIchiran_Row();
            row.setRowState(RowState.Added);
            二次予防情報対象一覧に修正された行の内容を変更する(row);
            div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getDataSource().add(row);

            List<dgNijiyoboJohoTaishoIchiran_Row> rowList = div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getDataSource();
            sortDg二次予防情報対象一覧(rowList);
            div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().setDataSource(rowList);
        }
        if (修正.equals(div.getOperateState())) {
            dgNijiyoboJohoTaishoIchiran_Row row = div.getNijiyoboJohoTaishoIchiran().getDgNijiyoboJohoTaishoIchiran().getClickedItem();
            if (RowState.Added != row.getRowState()) {
                row.setRowState(RowState.Modified);
            }
            二次予防情報対象一覧に修正された行の内容を変更する(row);
        }
    }

    private void 二次予防情報対象一覧に修正された行の内容を変更する(dgNijiyoboJohoTaishoIchiran_Row row) {
        row.getTekiyoKaishiYMD().setValue(div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().getFromValue());
        row.getTekiyoShuryoYMD().setValue(div.getNijiyoboJohoShosai().getTxtTekiyoKikanYMD().getToValue());
        row.getChosaJisshiYMD().setValue(div.getNijiyoboJohoShosai().getTxtChosaJisshiYMD().getValue());
        row.getKetteiYMD().setValue(div.getNijiyoboJohoShosai().getTxtKetteiYMD().getValue());
    }

    /**
     * 総合事業（経過措置）対象者登録画面 「取消する」ボタンを処理します。
     */
    public void onClick_btnCancel() {
        div.setOperateState(空白);
    }

    /**
     * 総合事業（経過措置）対象者登録画面ボタンの制御を処理します。
     *
     * @param is非活性_追加するボタン boolean
     */
    public void onState(boolean is非活性_追加するボタン) {
        div.getNijiyoboJohoTaishoIchiran().getBtnAdd().setDisabled(is非活性_追加するボタン);
    }

    /**
     * 二次予防情報対象一覧のデータを保存します。
     *
     * @param rowList List<dgNijiyoboJohoTaishoIchiran_Row>
     * @param 被保険者番号 HihokenshaNo
     * @param holder NijiYoboJigyoTaishoshaHolder
     */
    public void 二次予防情報対象一覧のデータを保存する(List<dgNijiyoboJohoTaishoIchiran_Row> rowList,
            HihokenshaNo 被保険者番号, NijiYoboJigyoTaishoshaHolder holder) {
        int 履歴番号MAX = 0;
        for (dgNijiyoboJohoTaishoIchiran_Row row : rowList) {
            if ((RowState.Added != row.getRowState()) && (!RString.isNullOrEmpty(row.getRirekiNo()))
                    && 履歴番号MAX < Integer.parseInt(row.getRirekiNo().toString())) {
                履歴番号MAX = Integer.parseInt(row.getRirekiNo().toString());
            }
        }
        List<NijiYoboJigyoTaishosha> changeItems = new ArrayList<>();
        for (dgNijiyoboJohoTaishoIchiran_Row row : rowList) {
            if (RowState.Added == row.getRowState()) {
                履歴番号MAX++;
                NijiYoboJigyoTaishosha changeItem = new NijiYoboJigyoTaishosha(被保険者番号, 履歴番号MAX).createBuilderForEdit()
                        .set適用開始年月日(null == row.getTekiyoKaishiYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyoKaishiYMD().getValue().toString()))
                        .set適用終了年月日(null == row.getTekiyoShuryoYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyoShuryoYMD().getValue().toString()))
                        .set調査実施日(null == row.getChosaJisshiYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getChosaJisshiYMD().getValue().toString()))
                        .set決定年月日(null == row.getKetteiYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getKetteiYMD().getValue().toString()))
                        .set受付年月日(FlexibleDate.EMPTY)
                        .build();
                changeItems.add(changeItem);
            }
            if (RowState.Modified == row.getRowState()) {
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                NijiYoboJigyoTaishosha changeItem
                        = holder.getNijiYoboJigyoTaishosha(new NijiYoboJigyoTaishoshaIdentifier(被保険者番号, 履歴番号)).createBuilderForEdit()
                        .set適用開始年月日(null == row.getTekiyoKaishiYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyoKaishiYMD().getValue().toString()))
                        .set適用終了年月日(null == row.getTekiyoShuryoYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getTekiyoShuryoYMD().getValue().toString()))
                        .set調査実施日(null == row.getChosaJisshiYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getChosaJisshiYMD().getValue().toString()))
                        .set決定年月日(null == row.getKetteiYMD().getValue() ? FlexibleDate.EMPTY
                                : new FlexibleDate(row.getKetteiYMD().getValue().toString()))
                        .build();
                changeItems.add(changeItem);
            }
            if (RowState.Deleted == row.getRowState()) {
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                NijiYoboJigyoTaishosha changeItem
                        = holder.getNijiYoboJigyoTaishosha(new NijiYoboJigyoTaishoshaIdentifier(被保険者番号, 履歴番号)).deleted();
                changeItems.add(changeItem);
            }
        }
        二次予防情報対象一覧のデータ更新する(changeItems);
    }

    private void 二次予防情報対象一覧のデータ更新する(List<NijiYoboJigyoTaishosha> changeItems) {
        boolean isSuccess = true;
        if (null != changeItems && (!changeItems.isEmpty())) {
            NijiYoboJigyoTaishoshaManager manager = new NijiYoboJigyoTaishoshaManager();
            for (NijiYoboJigyoTaishosha changeItem : changeItems) {
                if (!manager.saveOrDeletePhysicalBy二次予防事業対象者(changeItem)) {
                    isSuccess = false;
                }
            }
        }
        div.getCcdKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                div.get被保険者番号(), div.getNijiyoboTaishosha().getCcdKaigoAtenaInfo().get氏名漢字(), isSuccess);
    }
}
