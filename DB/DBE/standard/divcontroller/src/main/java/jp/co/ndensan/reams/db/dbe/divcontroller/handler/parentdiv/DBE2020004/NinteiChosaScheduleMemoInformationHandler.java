/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.NinteiChosaScheduleMemoInformationDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.dgListOfCommonMemo_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.dgListOfJichikuMemo_Row;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiChosaScheduleMemo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiChosaScheduleMemoBuilder;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 認定調査スケジュール登録4のクラス。
 */
public class NinteiChosaScheduleMemoInformationHandler {

    private final NinteiChosaScheduleMemoInformationDiv div;
    private static final RString 重要 = new RString("重要");
    private static final RString 通常 = new RString("通常");
    private static final RString 重要_コード = new RString("1");
    private static final RString 通常_コード = new RString("2");
    private static final RString 共通 = new RString("1");
    private static final RString 地区のみ = new RString("2");
    private static final RString 共通メモ = new RString("共通メモ一覧");
    private static final RString 自地区メモ = new RString("自地区メモ一覧");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final CodeShubetsu コード種別 = new CodeShubetsu("5002");
    private static final RString インデックス初期化 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public NinteiChosaScheduleMemoInformationHandler(NinteiChosaScheduleMemoInformationDiv div) {
        this.div = div;
    }

    /**
     * 認定調査スケジュール登録4の初期化を設定します。
     *
     * @param ninteiChosaScheduleMemoList 認定調査スケジュールメモ情報
     * @param メモ年月日 メモ年月日
     * @param 地区コード 地区コード
     * @param 通常件数 通常件数
     * @param 重要件数 重要件数
     */
    public void onLoad(List<NinteiChosaScheduleMemo> ninteiChosaScheduleMemoList,
            FlexibleDate メモ年月日, Code 地区コード, int 通常件数, int 重要件数) {

        UzT0007CodeEntity uzT0007CodeEntity = CodeMaster.getCode(SubGyomuCode.DBE認定支援, コード種別, 地区コード);
        div.getTxtSetteiDate().setValue(メモ年月日);
        div.getTxtTaishoChiku().setValue(uzT0007CodeEntity == null ? RString.EMPTY : uzT0007CodeEntity.getコード名称());
        div.getTxtNumberOfTsujoMemo().setValue(new RString(String.valueOf(重要件数)));
        div.getTxtNumberOfJuyoMemo().setValue(new RString(String.valueOf(通常件数)));

        int 共通_NO = 0;
        int 地区のみ_NO = 0;
        List<dgListOfCommonMemo_Row> 共通一覧 = new ArrayList<>();
        List<dgListOfJichikuMemo_Row> 自地区メモ一覧 = new ArrayList<>();
        div.set共通一覧インデックス(インデックス初期化);
        div.set自地区一覧インデックス(インデックス初期化);
        for (NinteiChosaScheduleMemo ninteiChosaScheduleMemo : ninteiChosaScheduleMemoList) {
            if (共通.equals(ninteiChosaScheduleMemo.getメモ区分().value())) {
                共通_NO++;
                dgListOfCommonMemo_Row dgListOfCommonMemo_Row = new dgListOfCommonMemo_Row();
                dgListOfCommonMemo_Row.setNo(new RString(String.valueOf(共通_NO)));
                dgListOfCommonMemo_Row.setCreator(ninteiChosaScheduleMemo.get作成者());
                dgListOfCommonMemo_Row.setImportance(重要);
                dgListOfCommonMemo_Row.setMemono(new RString(String.valueOf(ninteiChosaScheduleMemo.get連番())));
                dgListOfCommonMemo_Row.setMemo(ninteiChosaScheduleMemo.getメモ内容());
                dgListOfCommonMemo_Row.setMemokubun(ninteiChosaScheduleMemo.getメモ区分().value());
                共通一覧.add(dgListOfCommonMemo_Row);
            }
            if (地区のみ.equals(ninteiChosaScheduleMemo.getメモ区分().value())) {
                地区のみ_NO++;
                dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row = new dgListOfJichikuMemo_Row();
                dgListOfJichikuMemo_Row.setNo(new RString(String.valueOf(地区のみ_NO)));
                dgListOfJichikuMemo_Row.setCreator(ninteiChosaScheduleMemo.get作成者());
                dgListOfJichikuMemo_Row.setImportance(重要);
                dgListOfJichikuMemo_Row.setMemono(new RString(String.valueOf(ninteiChosaScheduleMemo.get連番())));
                dgListOfJichikuMemo_Row.setMemo(ninteiChosaScheduleMemo.getメモ内容());
                dgListOfJichikuMemo_Row.setMemokubun(ninteiChosaScheduleMemo.getメモ区分().value());
                自地区メモ一覧.add(dgListOfJichikuMemo_Row);
            }
        }
        div.set共通番号(new RString(String.valueOf(共通_NO)));
        div.set自地区番号(new RString(String.valueOf(地区のみ_NO)));
        div.getDgListOfCommonMemo().setDataSource(共通一覧);
        div.getDgListOfJichikuMemo().setDataSource(自地区メモ一覧);
        初期化状態の設定();
    }

    /**
     * 共通メモ一覧に行を追加します。
     *
     */
    public void getCommonAdd() {

        div.setメモ一覧共通(共通メモ);
        共通メモ一覧_追加の状態();
        dgListOfCommonMemo_Row commonMemoRow = new dgListOfCommonMemo_Row();
        div.set状態区分(追加);
        commonMemoRow.setNo(new RString(String.valueOf(Integer.valueOf(div.get共通番号().toString()) + 1)));
        commonMemoRow.setMemono(new RString(String.valueOf(Integer.valueOf(div.getMax連番().toString()) + 1)));
        div.set共通番号(commonMemoRow.getNo());
        div.setMax連番(commonMemoRow.getMemono());
        div.setメモ一覧自地区(RString.EMPTY);
        commonMemoRow.setCreator(ControlDataHolder.getUserName());
        div.getDgListOfCommonMemo().getDataSource().add(commonMemoRow);
    }

    /**
     * 認定調査スケジュール登録4に共通編集アイコンを実行します。
     *
     */
    public void getEditCommon() {

        dgListOfCommonMemo_Row dgListOfCommonMemo_Row = div.getDgListOfCommonMemo().getSelectedItems().get(0);
        if (!追加.equals(div.get状態区分()) && dgListOfCommonMemo_Row.getJotai().isEmpty()) {

            div.set状態区分(修正);
            div.getMaintenanceForMemo().getBtnDelete().setVisible(true);
        }
        div.setメモ一覧共通(共通メモ);
        div.setメモ一覧自地区(RString.EMPTY);
        div.getMaintenanceForMemo().getDdlShiteiChosaChiku().setDataSource(調査地区ドロップダウンリスト());
        div.set共通一覧インデックス(new RString(String.valueOf(div.getDgListOfCommonMemo().getClickedItem().getId())));
        編集と中止場合の状態();
        共通の場合にメンテナンスの設定(dgListOfCommonMemo_Row);
    }

    /**
     * 認定調査スケジュール登録4に「自地区メモ一覧に行を追加する」ボタンを実行します。
     *
     */
    public void getAutoAdd() {

        div.setメモ一覧自地区(自地区メモ);
        自地区メモ一覧_追加の状態();
        dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row = new dgListOfJichikuMemo_Row();
        div.set状態区分(追加);
        dgListOfJichikuMemo_Row.setMemono(new RString(String.valueOf(Integer.valueOf(div.getMax連番().toString()) + 1)));
        dgListOfJichikuMemo_Row.setNo(new RString(String.valueOf(Integer.valueOf(div.get自地区番号().toString()) + 1)));
        div.set自地区番号(dgListOfJichikuMemo_Row.getNo());
        div.setMax連番(dgListOfJichikuMemo_Row.getMemono());
        dgListOfJichikuMemo_Row.setCreator(ControlDataHolder.getUserName());
        div.setメモ一覧共通(RString.EMPTY);
        div.getDgListOfJichikuMemo().getDataSource().add(dgListOfJichikuMemo_Row);
    }

    /**
     * 認定調査スケジュール登録4に自地区編集アイコンを実行します。
     *
     */
    public void getEditAuto() {

        dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row = div.getDgListOfJichikuMemo().getSelectedItems().get(0);
        if (!追加.equals(div.get状態区分()) && dgListOfJichikuMemo_Row.getJotai().isEmpty()) {

            div.set状態区分(修正);
            div.getMaintenanceForMemo().getBtnDelete().setVisible(true);
        }
        div.setメモ一覧自地区(自地区メモ);
        div.setメモ一覧共通(RString.EMPTY);
        div.getMaintenanceForMemo().getDdlShiteiChosaChiku().setDataSource(調査地区ドロップダウンリスト());
        div.set自地区一覧インデックス(new RString(String.valueOf(div.getDgListOfJichikuMemo().getClickedItem().getId())));
        編集と中止場合の状態();
        自地区の場合にメンテナンスの設定(dgListOfJichikuMemo_Row);
    }

    /**
     * 認定調査スケジュール登録4に「削除する」ボタンを実行します。
     *
     */
    public void onClick_Delete() {

        if (共通メモ.equals(div.getメモ一覧共通())) {

            dgListOfCommonMemo_Row dgListOfCommonMemo_Row = div.getDgListOfCommonMemo().
                    getDataSource().get(Integer.valueOf(div.get共通一覧インデックス().toString()));
            dgListOfCommonMemo_Row.setJotai(削除);
        }
        if (自地区メモ.equals(div.getメモ一覧自地区())) {

            dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row = div.getDgListOfJichikuMemo().
                    getDataSource().get(Integer.valueOf(div.get自地区一覧インデックス().toString()));
            dgListOfJichikuMemo_Row.setJotai(削除);
        }
        div.getBtnAddForListOfCommonMemo().setDisabled(false);
        div.getBtnAddForListOfJichikuMemo().setDisabled(false);
        div.getMaintenanceForMemo().setDisplayNone(true);
    }

    /**
     * 認定調査スケジュール登録4「中止する」ボタンの処理。
     *
     */
    public void 内容の破棄() {

        div.getMaintenanceForMemo().getTxtMemoNumber().clearValue();
        div.getMaintenanceForMemo().getDdlMemoType().setSelectedKey(RString.EMPTY);
        div.getDdlShiteiChosaChiku().setSelectedKey(RString.EMPTY);
        div.getMaintenanceForMemo().getTxtCreator().clearValue();
        div.getMaintenanceForMemo().getTxtMemo().clearValue();
        div.getDdlMemoImportance().setSelectedValue(RString.EMPTY);
        編集と中止場合の状態();
    }

    /**
     * 「保存する」ボタンの共通一覧の登録編集。
     *
     * @param メモ年月日 メモ年月日
     * @param 地区コード 地区コード
     * @param dg_Row 共通メモ一覧
     * @param modelsNinteiChosaScheduleMemo 認定調査スケジュールメモ情報
     * @return 認定調査スケジュールメモ情報
     */
    public NinteiChosaScheduleMemo 共通メモ一覧_登録と修正の編集(FlexibleDate メモ年月日, Code 地区コード,
            dgListOfCommonMemo_Row dg_Row, NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo) {

        NinteiChosaScheduleMemoBuilder builder = modelsNinteiChosaScheduleMemo.createBuilderForEdit();
        builder.setメモ指定調査地区コード(new Code(dg_Row.getChikucode()));
        builder.set作成者(dg_Row.getCreator());
        if (通常.equals(dg_Row.getImportance())) {

            builder.setメモ重要度(new Code(重要_コード));
        }
        if (重要.equals(dg_Row.getImportance())) {

            builder.setメモ重要度(new Code(通常_コード));
        }
        builder.setメモ内容(dg_Row.getMemo());
        return builder.build();
    }

    /**
     * 「保存する」ボタンの自地区一覧の登録編集。
     *
     * @param メモ年月日 メモ年月日
     * @param 地区コード 地区コード
     * @param dg_Row 自地区メモ一覧
     * @param modelsNinteiChosaScheduleMemo 認定調査スケジュールメモ情報
     * @return 認定調査スケジュールメモ情報
     */
    public NinteiChosaScheduleMemo 自地区メモ一覧_登録と修正の編集(FlexibleDate メモ年月日,
            Code 地区コード, dgListOfJichikuMemo_Row dg_Row, NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo) {

        NinteiChosaScheduleMemoBuilder builder = modelsNinteiChosaScheduleMemo.createBuilderForEdit();
        builder.setメモ指定調査地区コード(new Code(dg_Row.getChikucode()));
        builder.set作成者(dg_Row.getCreator());
        if (通常.equals(dg_Row.getImportance())) {

            builder.setメモ重要度(new Code(重要_コード));
        }
        if (重要.equals(dg_Row.getImportance())) {

            builder.setメモ重要度(new Code(通常_コード));
        }
        builder.setメモ内容(dg_Row.getMemo());
        return builder.build();
    }

    /**
     * 認定調査スケジュール登録4に登録ボタンの処理を実行します。
     *
     */
    public void onClick_Login() {
        if (共通メモ.equals(div.getメモ一覧共通())) {

            dgListOfCommonMemo_Row dgListOfCommonMemo_Row = div.getDgListOfCommonMemo().
                    getDataSource().get(Integer.valueOf(div.get共通一覧インデックス().toString()));
            if (!追加.equals(dgListOfCommonMemo_Row.getJotai()) || dgListOfCommonMemo_Row.getJotai().isEmpty()) {
                dgListOfCommonMemo_Row.setJotai(修正);
            }
            if (追加.equals(div.get状態区分())) {

                dgListOfCommonMemo_Row.setJotai(追加);
            }
            登録ボタン_共通メモの編集(dgListOfCommonMemo_Row);
        }
        if (自地区メモ.equals(div.getメモ一覧自地区())) {

            dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row = div.getDgListOfJichikuMemo().
                    getDataSource().get(Integer.valueOf(div.get自地区一覧インデックス().toString()));
            if (!追加.equals(dgListOfJichikuMemo_Row.getJotai()) || dgListOfJichikuMemo_Row.getJotai().isEmpty()) {

                dgListOfJichikuMemo_Row.setJotai(修正);
            }
            if (追加.equals(div.get状態区分())) {

                dgListOfJichikuMemo_Row.setJotai(追加);
            }
            登録ボタン_自地区メモの編集(dgListOfJichikuMemo_Row);
        }
        div.set状態区分(RString.EMPTY);
        div.getBtnAddForListOfCommonMemo().setDisabled(false);
        div.getBtnAddForListOfJichikuMemo().setDisabled(false);
        div.getMaintenanceForMemo().setDisplayNone(true);
    }

    private void 登録ボタン_自地区メモの編集(dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row) {

        dgListOfJichikuMemo_Row.setMemono(div.getMaintenanceForMemo().getTxtMemoNumber().getValue());
        dgListOfJichikuMemo_Row.setMemokubun(div.getMaintenanceForMemo().getDdlMemoType().getSelectedKey());
        dgListOfJichikuMemo_Row.setChikucode(div.getDdlShiteiChosaChiku().getSelectedKey());
        dgListOfJichikuMemo_Row.setCreator(div.getMaintenanceForMemo().getTxtCreator().getValue());
        dgListOfJichikuMemo_Row.setImportance(div.getDdlMemoImportance().getSelectedValue());
        dgListOfJichikuMemo_Row.setMemo(div.getTxtMemo().getValue());
        div.getDgListOfJichikuMemo().getDataSource().set(Integer.valueOf(div.get自地区一覧インデックス().toString()), dgListOfJichikuMemo_Row);
    }

    private void 登録ボタン_共通メモの編集(dgListOfCommonMemo_Row dgListOfCommonMemo_Row) {

        dgListOfCommonMemo_Row.setMemono(div.getMaintenanceForMemo().getTxtMemoNumber().getValue());
        dgListOfCommonMemo_Row.setMemokubun(div.getMaintenanceForMemo().getDdlMemoType().getSelectedKey());
        dgListOfCommonMemo_Row.setChikucode(div.getDdlShiteiChosaChiku().getSelectedKey());
        dgListOfCommonMemo_Row.setCreator(div.getMaintenanceForMemo().getTxtCreator().getValue());
        dgListOfCommonMemo_Row.setImportance(div.getDdlMemoImportance().getSelectedValue());
        dgListOfCommonMemo_Row.setMemo(div.getTxtMemo().getValue());
        div.getDgListOfCommonMemo().getDataSource().set(Integer.valueOf(div.get共通一覧インデックス().toString()), dgListOfCommonMemo_Row);
    }

    private void 共通メモ一覧_追加の状態() {

        div.getBtnAddForListOfCommonMemo().setDisabled(true);
        div.getBtnAddForListOfJichikuMemo().setDisabled(true);
        div.getBtnDelete().setVisible(false);
    }

    private void 自地区メモ一覧_追加の状態() {

        div.getBtnAddForListOfCommonMemo().setDisabled(true);
        div.getBtnAddForListOfJichikuMemo().setDisabled(true);
        div.getBtnDelete().setVisible(false);
    }

    private void 共通の場合にメンテナンスの設定(dgListOfCommonMemo_Row dgListOfCommonMemo_Row) {

        Code 地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, Code.class);
        div.getMaintenanceForMemo().getTxtMemoNumber().setValue(dgListOfCommonMemo_Row.getMemono());
        div.getMaintenanceForMemo().getDdlMemoType().setSelectedKey(共通);
        div.getDdlShiteiChosaChiku().setSelectedKey(地区コード.value());
        div.getMaintenanceForMemo().getTxtCreator().setValue(dgListOfCommonMemo_Row.getCreator());
        div.getMaintenanceForMemo().getTxtMemo().setValue(dgListOfCommonMemo_Row.getMemo());
        div.getDdlMemoImportance().setSelectedValue(重要);
    }

    private void 自地区の場合にメンテナンスの設定(dgListOfJichikuMemo_Row dgListOfJichikuMemo_Row) {

        Code 地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, Code.class);
        div.getMaintenanceForMemo().getTxtMemoNumber().setValue(dgListOfJichikuMemo_Row.getMemono());
        div.getMaintenanceForMemo().getDdlMemoType().setSelectedKey(地区のみ);
        div.getDdlShiteiChosaChiku().setSelectedKey(地区コード.value());
        div.getMaintenanceForMemo().getTxtCreator().setValue(dgListOfJichikuMemo_Row.getCreator());
        div.getMaintenanceForMemo().getTxtMemo().setValue(dgListOfJichikuMemo_Row.getMemo());
        div.getDdlMemoImportance().setSelectedValue(重要);
    }

    private List<KeyValueDataSource> 調査地区ドロップダウンリスト() {

        List<KeyValueDataSource> dataSource = new ArrayList();
        List<UzT0007CodeEntity> 指定調査地区 = CodeMaster.getCode(SubGyomuCode.DBE認定支援, コード種別);

        for (UzT0007CodeEntity entity : 指定調査地区) {

            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().value());
            keyValue.setValue(entity.getコード名称());

            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private void 編集と中止場合の状態() {

        div.getTxtSetteiDate().setDisabled(true);
        div.getTxtTaishoChiku().setDisabled(true);
        div.getTxtNumberOfTsujoMemo().setDisabled(true);
        div.getTxtNumberOfJuyoMemo().setDisabled(true);
        div.getBtnAddForListOfCommonMemo().setDisabled(true);
        div.getBtnAddForListOfJichikuMemo().setDisabled(true);
        div.getMaintenanceForMemo().setDisplayNone(false);
        div.getBtnDelete().setVisible(true);
        div.getMaintenanceForMemo().getTxtMemoNumber().setDisabled(true);
    }

    private void 初期化状態の設定() {

        div.getTxtSetteiDate().setDisabled(true);
        div.getTxtTaishoChiku().setDisabled(true);
        div.getTxtNumberOfTsujoMemo().setDisabled(true);
        div.getTxtNumberOfJuyoMemo().setDisabled(true);
        div.getMaintenanceForMemo().setDisplayNone(true);
    }
}
