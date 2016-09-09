/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1720011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishoshaBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyotaishoshatoroku.SogoJigyoTaishoshaToJotai;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.dgKihonInfo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 新総合事業・事業対象者登録画面ハンドラクラスです。
 *
 * @reamsid_L DBC-4900-010 wangjie2
 */
public class SogoJigyoTaishoshaTorokuHandler {

    private final SogoJigyoTaishoshaTorokuDiv div;
    private final RString 保存する = new RString("btnHozonn");
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報div
     */
    public SogoJigyoTaishoshaTorokuHandler(SogoJigyoTaishoshaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 総合事業対象者一覧 総合事業対象者一覧
     * @return 情報と状態List
     */
    public ArrayList<SogoJigyoTaishoshaToJotai> onLoad(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, List<SogoJigyoTaishosha> 総合事業対象者一覧) {
        div.getKaigoAtenaInfoChildDiv1().initialize(識別コード);
        div.getKaiigoShikakCommonChildDiv2().initialize(被保険者番号);
        ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List = 情報と状態初期化(総合事業対象者一覧);
        div.getSougouZigyouTaishouItiran().getDgKihonInfo().setDataSource(getDataSource(情報と状態List));
        RealInitialLocker.lock(new LockingKey(new RString("DBCHihokenshaNo").concat(被保険者番号.getColumnValue())));
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
        return 情報と状態List;
    }

    /**
     * 総合事業対象者一覧を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 総合事業対象者一覧
     */
    public List<SogoJigyoTaishosha> get総合事業対象者一覧(HihokenshaNo 被保険者番号) {
        SogoJigyoTaishoshaManager manager = new SogoJigyoTaishoshaManager();
        return manager.get総合事業対象者一覧By被保険者番号(被保険者番号);
    }

    private ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態初期化(List<SogoJigyoTaishosha> 総合事業対象者一覧) {
        ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List = new ArrayList<>();
        for (SogoJigyoTaishosha 総合事業対象者 : 総合事業対象者一覧) {
            情報と状態List.add(new SogoJigyoTaishoshaToJotai(RString.EMPTY, 総合事業対象者));
        }
        return 情報と状態List;
    }

    private List<dgKihonInfo_Row> getDataSource(ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List) {
        List<dgKihonInfo_Row> rowList = new ArrayList<>();
        for (SogoJigyoTaishoshaToJotai 情報と状態 : 情報と状態List) {
            if (!情報と状態.get状態().isEmpty()) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
            }
            SogoJigyoTaishosha 総合事業対象者 = 情報と状態.get総合事業対象();
            dgKihonInfo_Row row = new dgKihonInfo_Row();
            row.setJyoutai(情報と状態.get状態());
            if (!isNullOrEmpty(総合事業対象者.get適用開始年月日())) {
                row.setTekiyouKaishibi(総合事業対象者.get適用開始年月日().wareki().toDateString());
                row.setKaishibi(new RString(総合事業対象者.get適用開始年月日().toString()));
            }
            if (!isNullOrEmpty(総合事業対象者.get適用終了年月日())) {
                row.setTekiyouShuuryoubi(総合事業対象者.get適用終了年月日().wareki().toDateString());
                row.setShuuryoubi(new RString(総合事業対象者.get適用終了年月日().toString()));
            } else {
                row.setTekiyouShuuryoubi(RString.EMPTY);
            }
            if (!isNullOrEmpty(総合事業対象者.getチェックリスト実施日())) {
                row.setTyekkurisutoZisshibi(総合事業対象者.getチェックリスト実施日().wareki().toDateString());
            }
            if (!isNullOrEmpty(総合事業対象者.get決定年月日())) {
                row.setKetteiBi(総合事業対象者.get決定年月日().wareki().toDateString());
            }
            row.setDataId(DataPassingConverter.serialize(総合事業対象者.identifier()));
            rowList.add(row);
        }
        return rowList;
    }

    private boolean isNullOrEmpty(FlexibleDate 年月日) {
        return null == 年月日 || 年月日.isEmpty();
    }

    /**
     * 総合事業対象詳細を表示します。
     *
     * @param 状態 状態
     * @param 情報と状態 情報と状態
     */
    public void 総合事業対象詳細表示(RString 状態, SogoJigyoTaishoshaToJotai 情報と状態) {
        div.getSougouZigyouTaishouShousai().setHiddenModel(状態);
        if (null == 情報と状態) {
            div.getSougouZigyouTaishouShousai().getTxtymfromto().clearFromValue();
            div.getSougouZigyouTaishouShousai().getTxtymfromto().clearToValue();
            div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().clearValue();
            div.getSougouZigyouTaishouShousai().getTxtKetteibi().clearValue();
        } else {
            SogoJigyoTaishosha 総合事業対象 = 情報と状態.get総合事業対象();
            if (!isNullOrEmpty(総合事業対象.get適用開始年月日())) {
                div.getSougouZigyouTaishouShousai().getTxtymfromto()
                        .setFromValue(new RDate(総合事業対象.get適用開始年月日().toString()));
            } else {
                div.getSougouZigyouTaishouShousai().getTxtymfromto().clearFromValue();
            }
            if (!isNullOrEmpty(総合事業対象.get適用終了年月日())) {
                div.getSougouZigyouTaishouShousai().getTxtymfromto()
                        .setToValue(new RDate(総合事業対象.get適用終了年月日().toString()));
            } else {
                div.getSougouZigyouTaishouShousai().getTxtymfromto().clearToValue();
            }
            if (!isNullOrEmpty(総合事業対象.getチェックリスト実施日())) {
                div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi()
                        .setValue(new RDate(総合事業対象.getチェックリスト実施日().toString()));
            } else {
                div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().clearValue();
            }
            if (!isNullOrEmpty(総合事業対象.get決定年月日())) {
                div.getSougouZigyouTaishouShousai().getTxtKetteibi()
                        .setValue(new RDate(総合事業対象.get決定年月日().toString()));
            } else {
                div.getSougouZigyouTaishouShousai().getTxtKetteibi().clearValue();
            }
        }
        総合事業対象詳細制御(状態);
    }

    private void 総合事業対象詳細制御(RString 状態) {
        if (状態_削除.equals(状態)) {
            div.getSougouZigyouTaishouShousai().getTxtymfromto().setDisabled(true);
            div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().setDisabled(true);
            div.getSougouZigyouTaishouShousai().getTxtKetteibi().setDisabled(true);
            div.getSougouZigyouTaishouShousai().getBtnCancel().setDisabled(false);
            div.getSougouZigyouTaishouShousai().getBtnConfirm().setDisabled(false);
        } else {
            div.getSougouZigyouTaishouShousai().getTxtymfromto().setDisabled(false);
            div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().setDisabled(false);
            div.getSougouZigyouTaishouShousai().getTxtKetteibi().setDisabled(false);
            div.getSougouZigyouTaishouShousai().getBtnConfirm().setDisabled(false);
            div.getSougouZigyouTaishouShousai().getBtnCancel().setDisabled(false);
        }
    }

    /**
     * 確定する制御します。
     *
     * @param 情報と状態 情報と状態
     */
    public void 確定する制御(SogoJigyoTaishoshaToJotai 情報と状態) {
        RDate 画面適用開始日 = div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue();
        if (null == 画面適用開始日) {
            div.getSougouZigyouTaishouShousai().getBtnConfirm().setDisabled(true);
            return;
        }
        List<dgKihonInfo_Row> rowList = div.getSougouZigyouTaishouItiran().getDgKihonInfo().getDataSource();
        for (dgKihonInfo_Row row : rowList) {
            if (null == 情報と状態) {
                if (is適用開始日と登録済みの適用期間が重(画面適用開始日, row)) {
                    div.getSougouZigyouTaishouShousai().getBtnConfirm().setDisabled(true);
                    return;
                }
            } else {
                SogoJigyoTaishoshaIdentifier id = 情報と状態.get総合事業対象().identifier();
                if (!id.equals(DataPassingConverter.deserialize(row.getDataId(), SogoJigyoTaishoshaIdentifier.class))
                        && is適用開始日と登録済みの適用期間が重(画面適用開始日, row)) {
                    div.getSougouZigyouTaishouShousai().getBtnConfirm().setDisabled(true);
                    return;
                }
            }
        }
        div.getSougouZigyouTaishouShousai().getBtnConfirm().setDisabled(false);
    }

    private boolean is適用開始日と登録済みの適用期間が重(RDate 画面適用開始日, dgKihonInfo_Row row) {
        if (null == row.getShuuryoubi() || row.getShuuryoubi().isEmpty()) {
            return new RDate(row.getKaishibi().toString()).isBeforeOrEquals(画面適用開始日);
        } else {
            return 画面適用開始日.isBeforeOrEquals(new RDate(row.getShuuryoubi().toString()))
                    && new RDate(row.getKaishibi().toString()).isBeforeOrEquals(画面適用開始日);
        }
    }

    /**
     * 「確定する」ボタンを押下します。
     *
     * @param 最初情報 最初情報
     * @param 被保険者番号 被保険者番号
     * @param 編集情報と状態 編集情報と状態
     * @param 情報と状態List 情報と状態List
     */
    public void onClick_btnConfirm(SogoJigyoTaishosha 最初情報, HihokenshaNo 被保険者番号,
            SogoJigyoTaishoshaToJotai 編集情報と状態, ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List) {
        RString 状態 = div.getSougouZigyouTaishouShousai().getHiddenModel();
        if (状態_追加.equals(状態)) {
            追加_確定(情報と状態List, 被保険者番号);
        } else if (状態_削除.equals(状態)) {
            削除_確定(情報と状態List, 編集情報と状態);
        } else {
            if (状態_追加.equals(編集情報と状態.get状態())) {
                修正_追加_確定(情報と状態List, 編集情報と状態);
            } else {
                修正_確定(情報と状態List, 最初情報);
            }
        }
        div.getSougouZigyouTaishouItiran().getDgKihonInfo().setDataSource(getDataSource(情報と状態List));
    }

    private void 修正_追加_確定(ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List, SogoJigyoTaishoshaToJotai 編集情報と状態) {
        SogoJigyoTaishoshaIdentifier id = 編集情報と状態.get総合事業対象().identifier();
        for (int index = 0; index < 情報と状態List.size(); index++) {
            SogoJigyoTaishoshaToJotai 情報と状態 = 情報と状態List.get(index);
            if (id.equals(情報と状態.get総合事業対象().identifier())) {
                情報修正(情報と状態);
            }
        }
    }

    private void 修正_確定(ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List, SogoJigyoTaishosha 最初情報) {
        SogoJigyoTaishoshaIdentifier id = 最初情報.identifier();
        for (int index = 0; index < 情報と状態List.size(); index++) {
            SogoJigyoTaishoshaToJotai 情報と状態 = 情報と状態List.get(index);
            if (id.equals(情報と状態.get総合事業対象().identifier())) {
                if (状態_追加.equals(情報と状態.get状態())) {
                    情報修正(情報と状態);
                } else if (is情報変更(最初情報)) {
                    情報と状態.set状態(状態_修正);
                    情報修正(情報と状態);
                } else {
                    修正_確定変更なし(情報と状態List, index, 最初情報);
                }
            }
        }
    }

    private void 修正_確定変更なし(ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List, int index, SogoJigyoTaishosha 最初情報) {
        情報と状態List.remove(index);
        if (index >= 情報と状態List.size() - 1) {
            情報と状態List.add(new SogoJigyoTaishoshaToJotai(RString.EMPTY, 最初情報));
        } else {
            情報と状態List.add(index, new SogoJigyoTaishoshaToJotai(RString.EMPTY, 最初情報));
        }
    }

    private void 情報修正(SogoJigyoTaishoshaToJotai 情報と状態) {
        SogoJigyoTaishoshaBuilder builder = 情報と状態.get総合事業対象().createBuilderForEdit();
        if (div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue() != null) {
            builder.set適用開始年月日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue().toDateString()));
        } else {
            builder.set適用開始年月日(FlexibleDate.EMPTY);
        }
        if (div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue() != null) {
            builder.set適用終了年月日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue().toDateString()));
        } else {
            builder.set適用終了年月日(FlexibleDate.EMPTY);
        }
        if (div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().getValue() != null) {
            builder.setチェックリスト実施日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().getValue().toDateString()));
        } else {
            builder.setチェックリスト実施日(FlexibleDate.EMPTY);
        }
        if (div.getSougouZigyouTaishouShousai().getTxtKetteibi().getValue() != null) {
            builder.set決定年月日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtKetteibi().getValue().toDateString()));
        } else {
            builder.set決定年月日(FlexibleDate.EMPTY);
        }
        情報と状態.set総合事業対象(builder.build());
    }

    private boolean is情報変更(SogoJigyoTaishosha 最初情報) {
        return !isEquals(div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue(), 最初情報.get適用開始年月日())
                || !isEquals(div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue(), 最初情報.get適用終了年月日())
                || !isEquals(div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().getValue(), 最初情報.getチェックリスト実施日())
                || !isEquals(div.getSougouZigyouTaishouShousai().getTxtKetteibi().getValue(), 最初情報.get決定年月日());
    }

    private boolean isEquals(RDate rDate, FlexibleDate flexibleDate) {
        if (null == rDate) {
            return null == flexibleDate || flexibleDate.isEmpty();
        }
        if (isNullOrEmpty(flexibleDate)) {
            return false;
        }
        return flexibleDate.equals(new FlexibleDate(rDate.toDateString()));
    }

    private void 削除_確定(ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List, SogoJigyoTaishoshaToJotai 編集情報と状態) {
        SogoJigyoTaishoshaIdentifier id = 編集情報と状態.get総合事業対象().identifier();
        for (int index = 0; index < 情報と状態List.size(); index++) {
            SogoJigyoTaishoshaToJotai 情報と状態 = 情報と状態List.get(index);
            if (id.equals(情報と状態.get総合事業対象().identifier())) {
                if (状態_追加.equals(情報と状態.get状態())) {
                    情報と状態List.remove(index);
                } else {
                    情報と状態.set状態(状態_削除);
                }
                return;
            }
        }
    }

    private void 追加_確定(ArrayList<SogoJigyoTaishoshaToJotai> 情報と状態List, HihokenshaNo 被保険者番号) {
        if (情報と状態List.isEmpty()) {
            情報と状態List.add(get画面情報(被保険者番号, 1));
        } else {
            情報と状態List.add(0, get画面情報(被保険者番号, 情報と状態List.get(0).get総合事業対象().get履歴番号() + 1));
        }
    }

    private SogoJigyoTaishoshaToJotai get画面情報(HihokenshaNo 被保険者番号, int 履歴番号) {
        SogoJigyoTaishosha 情報 = new SogoJigyoTaishosha(被保険者番号, 履歴番号);
        SogoJigyoTaishoshaBuilder builder = 情報.createBuilderForEdit();
        if (div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue() != null) {
            builder.set適用開始年月日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue().toDateString()));
        }
        if (div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue() != null) {
            builder.set適用終了年月日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue().toDateString()));
        }
        if (div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().getValue() != null) {
            builder.setチェックリスト実施日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtChekkurisutoZisshibi().getValue().toDateString()));
        }
        if (div.getSougouZigyouTaishouShousai().getTxtKetteibi().getValue() != null) {
            builder.set決定年月日(new FlexibleDate(
                    div.getSougouZigyouTaishouShousai().getTxtKetteibi().getValue().toDateString()));
        }
        return new SogoJigyoTaishoshaToJotai(状態_追加, builder.build());
    }

    /**
     * 保存処理します。
     *
     * @param 情報と状態List 情報と状態List
     * @param 被保険者番号 被保険者番号
     */
    public void 保存処理(List<SogoJigyoTaishoshaToJotai> 情報と状態List, HihokenshaNo 被保険者番号) {
        SogoJigyoTaishoshaManager manager = new SogoJigyoTaishoshaManager();
        manager.save総合事業対象者(情報と状態List);
        RealInitialLocker.release(new LockingKey(new RString("DBCHihokenshaNo").concat(被保険者番号.getColumnValue())));
    }

    /**
     * 適用期間重複チェック処理します。
     *
     * @return 適用期間重複チェック結果
     */
    public boolean 適用期間重複チェック() {
        RDate 編集適用開始日 = div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue();
        if (null == 編集適用開始日) {
            return true;
        }
        RDate 編集適用終了日 = div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue();
        List<dgKihonInfo_Row> rowList = div.getSougouZigyouTaishouItiran().getDgKihonInfo().getDataSource();
        dgKihonInfo_Row actionRow = div.getSougouZigyouTaishouItiran().getDgKihonInfo().getActiveRow();
        List<dgKihonInfo_Row> checkRowList = new ArrayList<>();
        for (dgKihonInfo_Row row : rowList) {
            if (!状態_削除.equals(row.getJyoutai())) {
                if (状態_修正.equals(div.getSougouZigyouTaishouShousai().getHiddenModel())
                        && actionRow.equals(row)) {
                    continue;
                }
                checkRowList.add(row);
            }
        }
        if (checkRowList.isEmpty()) {
            return true;
        }
        for (dgKihonInfo_Row row : checkRowList) {
            RDate 適用開始日 = get年月日(row.getKaishibi());
            RDate 適用終了日 = get年月日(row.getShuuryoubi());
            if (null == 適用終了日) {
                if (null == 編集適用終了日) {
                    return false;
                }
                if (適用開始日.isBeforeOrEquals(編集適用終了日) && 編集適用開始日.isBeforeOrEquals(適用開始日)) {
                    return false;
                }
            } else {
                if (null == 編集適用終了日 && 編集適用開始日.isBeforeOrEquals(適用終了日)) {
                    return false;
                }
                if (編集適用終了日 != null && !編集適用終了日.isBefore(適用開始日) && !適用終了日.isBefore(編集適用開始日)) {
                    return false;
                }
            }
        }
        return true;
    }

    private RDate get年月日(RString 年月日) {
        if (null == 年月日 || 年月日.isEmpty()) {
            return null;
        }
        return new RDate(年月日.toString());
    }

    /**
     * 「保存する」ボタン活性/非活性を判定します。
     *
     * @return 適用期間重複チェック結果
     */
    public boolean is保存可() {
        List<dgKihonInfo_Row> rowList = div.getSougouZigyouTaishouItiran().getDgKihonInfo().getDataSource();
        for (dgKihonInfo_Row row : rowList) {
            if (!row.getJyoutai().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
