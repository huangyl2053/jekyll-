/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelate;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiDiv.DisplayMode;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.TekiyoJogaishaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaIdentifier;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 適用除外者管理のクラス。
 *
 * @reamsid_L DBA-0210-010 dingyi
 */
public class TekiyoJogaiRirekiHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString 適用除外者 = new RString("適用除外者");
    private static final int PADZERO = 4;
    private static final RString 開始枝番 = new RString("0001");

    private final TekiyoJogaiRirekiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 適用除外者管理パネル
     */
    public TekiyoJogaiRirekiHandler(TekiyoJogaiRirekiDiv div) {
        this.div = div;
    }

    /**
     * 適用除外者管理に初期化を設定します。
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード) {
        div.setHiddenInputShikibetsuCode(識別コード.getColumnValue());
        List<TekiyoJogaishaRelate> 適用除外者情報
                = TekiyoJogaishaManager.createInstance().getTekiyoJogaishaLst(識別コード, false).records();
        if (適用除外者情報 != null && !適用除外者情報.isEmpty()) {
            set適用除外者一覧(適用除外者情報);
            TekiyoJogaishaBusiness 適用除外者管理Model
                    = TekiyoJogaishaManager.createInstance().get適用除外者と施設入退所情報(識別コード, false);
            ViewStateHolder.put(ViewStateKeys.適用除外者情報,
                    Models.create(適用除外者管理Model.get適用除外者List()));
            ViewStateHolder.put(ViewStateKeys.保険施設入退所情報,
                    Models.create(適用除外者管理Model.get施設入退所Lsit()));
        } else {
            ViewStateHolder.put(ViewStateKeys.適用除外者情報,
                    Models.create(new ArrayList<TekiyoJogaisha>()));
            ViewStateHolder.put(ViewStateKeys.保険施設入退所情報,
                    Models.create(new ArrayList<ShisetsuNyutaisho>()));
        }

        switch (div.getMode_DisplayMode()) {
            case 適用登録モード:
                div.getBtnAdd().setVisible(true);
                div.getBtnAdd().setDisabled(true);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowSelectButtonColumn(false);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowModifyButtonColumn(true);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowDeleteButtonColumn(true);
                div.getPanelTekiyoJokaiTekiInput().setVisible(true);
                div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
                div.getPanelTekiyoInput().setVisible(false);
                set適用除外者明細エリア_除外者適用();
                div.getBtnInputClear().setVisible(true);
                div.getBtnInputClear().setDisabled(false);
                div.getBtnKakutei().setVisible(true);
                div.getBtnKakutei().setDisabled(false);
                if (適用除外者情報 != null && !適用除外者情報.isEmpty()
                    && (適用除外者情報.get(0).get解除年月日() == null
                        || 適用除外者情報.get(0).get解除年月日().isEmpty())) {
                    div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().setDisabled(true);
                    div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().setDisabled(true);
                    div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().setDisabled(true);
                    div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setDisabled(true);
                    div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().setDisabled(true);
                    div.getBtnInputClear().setDisabled(true);
                    div.getBtnKakutei().setDisabled(true);
                }
                return;
            case 解除モード:
                div.getBtnAdd().setVisible(true);
                div.getBtnAdd().setDisabled(true);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowSelectButtonColumn(false);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowModifyButtonColumn(false);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowDeleteButtonColumn(false);
                div.getPanelTekiyoJokaiTekiInput().setVisible(false);
                div.getPanelTekiyoJokaiKaiJyoInput().setVisible(true);
                div.getPanelTekiyoInput().setVisible(false);
                set適用除外者明細エリア_除外者解除();
                div.getBtnInputClear().setVisible(true);
                div.getBtnKakutei().setVisible(true);
                if (適用除外者情報 == null || 適用除外者情報.isEmpty()) {
                    div.getBtnInputClear().setDisabled(true);
                    div.getBtnKakutei().setDisabled(true);
                } else {
                    div.getBtnInputClear().setDisabled(false);
                    if (適用除外者情報.get(0).get解除年月日() != null
                        && !適用除外者情報.get(0).get解除年月日().isEmpty()) {
                        div.getBtnKakutei().setDisabled(true);
                    } else {
                        div.getBtnKakutei().setDisabled(false);
                    }
                }
                return;
            case 施設変更モード:
                div.getPanelTekiyoRireki().setVisible(false);
                div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
                div.getPanelTekiyoJokaiTekiInput().setVisible(false);
                div.getPanelTekiyoInput().setVisible(true);
                set適用除外者明細エリア_履歴変更(適用除外者情報);
                div.getBtnInputClear().setVisible(true);
                div.getBtnInputClear().setDisabled(false);
                div.getBtnKakutei().setVisible(true);
                div.getBtnKakutei().setDisabled(false);
                return;
            case 訂正履歴モード:
                div.getBtnAdd().setVisible(true);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowSelectButtonColumn(false);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowModifyButtonColumn(true);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowDeleteButtonColumn(true);
                div.getPanelTekiyoJokaiTekiInput().setVisible(false);
                div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
                div.getPanelTekiyoInput().setVisible(true);
                set適用除外者明細エリア_履歴変更();
                div.getBtnInputClear().setVisible(true);
                div.getBtnInputClear().setDisabled(true);
                div.getBtnKakutei().setVisible(true);
                div.getBtnKakutei().setDisabled(true);
                return;
            case 照会モード:
                div.getBtnAdd().setVisible(false);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowSelectButtonColumn(true);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowModifyButtonColumn(false);
                div.getDatagridTekiyoJogai().getGridSetting().setIsShowDeleteButtonColumn(false);
                div.getPanelTekiyoJokaiTekiInput().setVisible(false);
                div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
                div.getPanelTekiyoInput().setVisible(true);
                set適用除外者明細エリア_履歴変更();
                div.getBtnInputClear().setVisible(false);
                div.getBtnKakutei().setVisible(false);
            default:
        }
    }

    private void set適用除外者明細エリア_履歴変更() {
        div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(true);
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(true);
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(true);
        div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(true);
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(true);
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(true);
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDataSource(set適用事由());
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDataSource(set解除事由());
        div.getPanelTekiyoInput().getTxtTekiyoDate().clearValue();
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().clearValue();
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedValue(RString.EMPTY);
        div.getPanelTekiyoInput().getTxtKayijoDate().clearValue();
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().clearValue();
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setSelectedValue(RString.EMPTY);
    }

    /**
     * 「選択」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     */
    public void onClick_Selected() {
        set適用除外者明細エリア(div.getDatagridTekiyoJogai().getActiveRow(), DisplayMode.照会モード /*状態_照会*/);
    }

    /**
     * 「追加する」ボタンを押下する場合、適用除外者明細エリア全項目をクリアします。
     */
    public void onClick_BtnAdd() {
        div.setStauts(状態_追加);
        DisplayMode mode = div.getMode_DisplayMode();
        switch (mode) {
            case 適用登録モード:
                div.getPanelTekiyoJokaiTekiInput().setDisabled(false);
                clear適用除外情報入力エリア();
                div.getBtnAdd().setDisabled(true);
                div.getBtnInputClear().setVisible(true);
                div.getBtnInputClear().setDisabled(false);
                div.getBtnKakutei().setVisible(true);
                div.getBtnKakutei().setDisabled(false);
                return;
            default:
                set適用除外者明細エリア(null, mode);
                setDisabled(div.getPanelTekiyoInput(), false);
                div.getBtnAdd().setDisabled(true);
        }
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     */
    public void onClick_Update() {
        div.setStauts(状態_修正);
        switch (div.getMode_DisplayMode()) {
            case 適用登録モード:
                setTekiyoJokaiTekiInputToSelectedRow(div.getPanelTekiyoJokaiTekiInput(), div.getDatagridTekiyoJogai().getClickedItem());
                break;
            default:
                setTekiyoInputToSelectedRow(div.getPanelTekiyoInput(), div.getDatagridTekiyoJogai().getClickedItem());
                setDisabled(div.getPanelTekiyoInput(), false);
        }
        div.getBtnInputClear().setVisible(true);
        div.getBtnInputClear().setDisabled(false);
        div.getBtnKakutei().setVisible(true);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 「削除」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     */
    public void onClick_Delete() {
        div.setStauts(状態_削除);
        setTekiyoInputToSelectedRow(div.getPanelTekiyoInput(), div.getDatagridTekiyoJogai().getClickedItem());
        div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(true);
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(true);
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(true);
        div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(true);
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(true);
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(true);
        div.getBtnInputClear().setDisabled(false);
        div.getBtnKakutei().setDisabled(false);
    }

    /**
     * 「適用除外情報を確定する」ボタンを押下する場合、入力の内容を適用情報一覧に反映します。
     *
     * @param 選択データ 選択データ
     * @param 画面状態 画面状態
     */
    public void onClick_BtnKakunin(datagridTekiyoJogai_Row 選択データ) {
        switch (div.getMode_DisplayMode()) {
            case 適用登録モード:
                onClick_BtnKakunin_適用登録モード(div);
                div.getPanelTekiyoJokaiTekiInput().setDisabled(true);
                div.getBtnAdd().setDisabled(true);
                break;
            case 解除モード:
                onClick_BtnKakunin_解除モード(div);
                div.getPanelTekiyoJokaiKaiJyoInput().setDisabled(true);
                break;
            case 訂正履歴モード:
                onClick_BtnKakunin_訂正履歴モード(div, 選択データ);
                div.getPanelTekiyoInput().setDisabled(true);
                div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(true);
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(true);
                div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(true);
                div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(true);
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(true);
                div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(true);
            default:
        }
        div.setStauts(RString.EMPTY);
        clear適用除外情報入力エリア();
        div.getBtnInputClear().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
    }

    private static void onClick_BtnKakunin_適用登録モード(TekiyoJogaiRirekiDiv div) {
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();

        int 最新履歴番号 = 0;
        Collections.sort(rowList, new DateComparatoRrirekiNo());
        if (!rowList.isEmpty() && !RString.isNullOrEmpty(rowList.get(0).getRirekiNo())) {
            最新履歴番号 = Integer.parseInt(rowList.get(0).getRirekiNo().toString());
        }

        RString 履歴番号 = new RString(最新履歴番号 + 1);
        RString 枝番 = 開始枝番;
        FlexibleDate 異動日 = new FlexibleDate(div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue().toString());
        datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();
        row.setRowState(RowState.Added);
        row.setJotai(状態_追加);
        row.getTekiyoDate().setValue(div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue());
        row.getTekiyoTodokeDate().setValue(div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().getValue());
        row.setTekiyoJiyuCode(div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedKey());
        row.setTekiyoJiyu(div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedValue());
        row.getNyuShoDate().setValue(div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue());
        row.setNyushoShisetsuCode(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        row.setNyuShoShisetu(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
        row.setDaichoShubetsu(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getDaichoShubetsu());
        row.setShisetsuShurui(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().get施設種類());
        row.setRirekiNo(履歴番号);
        row.setHenkougoTekiyoDate(new RString(異動日.toString()));
        row.setHenkougoIdoYMD(new RString(異動日.toString()));
        row.setHenkougoEdaNo(枝番);
        row.setModifyButtonState(DataGridButtonState.Enabled);
        row.setDeleteButtonState(DataGridButtonState.Enabled);
        rowList.add(row);

        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> tekiyoJogaishas
                = ViewStateHolder.get(ViewStateKeys.適用除外者情報,
                        Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaishos
                = ViewStateHolder.get(ViewStateKeys.保険施設入退所情報,
                        Models.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHiddenInputShikibetsuCode());
        ShisetsuNyutaisho sn = new ShisetsuNyutaisho(識別コード, Integer.parseInt(履歴番号.toString()));
        shisetsuNyutaishos.add(sn);
        TekiyoJogaisha tj = new TekiyoJogaisha(識別コード, 異動日, 枝番);
        tekiyoJogaishas.add(tj);
        Collections.sort(rowList, new DateComparator());
        div.getDatagridTekiyoJogai().setDataSource(rowList);
        ViewStateHolder.put(ViewStateKeys.適用除外者情報, tekiyoJogaishas);
        ViewStateHolder.put(ViewStateKeys.保険施設入退所情報, shisetsuNyutaishos);
    }

    private static void onClick_BtnKakunin_解除モード(TekiyoJogaiRirekiDiv div) {
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        if (rowList.isEmpty()) {
            return;
        }

        datagridTekiyoJogai_Row row = rowList.get(0);
        RString 枝番 = new RString(Integer.parseInt(row.getEdaNo().trim().toString()) + 1).padZeroToLeft(PADZERO);
        FlexibleDate 異動日 = new FlexibleDate(div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue().toString());
        row.setRowState(RowState.Modified);
        row.setJotai(状態_修正);
        row.getTaiShoDate().setValue(div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().getValue());
        row.getKayijoDate().setValue(div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue());
        row.getKaijoTodokeDate().setValue(div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().getValue());
        row.setKaijoJiyuCode(div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedKey());
        row.setKaijoJiyu(div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedValue());
        row.setHenkoumaeTekiyoDate(row.getTekiyoDate().getValue().toDateString());
        row.setHenkoumaeIdoYMD(row.getIdoYMD());
        row.setHenkoumaeEdaNo(row.getEdaNo());
        row.setHenkougoTekiyoDate(row.getTekiyoDate().getValue().toDateString());
        row.setHenkougoIdoYMD(new RString(異動日.toString()));
        row.setHenkougoEdaNo(枝番);

        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> tekiyoJogaishas
                = ViewStateHolder.get(ViewStateKeys.適用除外者情報,
                        Models.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHiddenInputShikibetsuCode());
        TekiyoJogaisha tekiyoJogaisha = new TekiyoJogaisha(識別コード, 異動日, 枝番);
        tekiyoJogaishas.add(tekiyoJogaisha);
        ViewStateHolder.put(ViewStateKeys.適用除外者情報, tekiyoJogaishas);
    }

    private static void onClick_BtnKakunin_訂正履歴モード(TekiyoJogaiRirekiDiv div, datagridTekiyoJogai_Row 選択データ) {
        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> tekiyoJogaishas
                = ViewStateHolder.get(ViewStateKeys.適用除外者情報,
                        Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> shisetsuNyutaishos
                = ViewStateHolder.get(ViewStateKeys.保険施設入退所情報,
                        Models.class);
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHiddenInputShikibetsuCode());

        if (状態_修正.equals(div.getStauts())) {
            if (!isデータ変更(div, 選択データ)) {
                return;
            }

            if (!RowState.Added.equals(選択データ.getRowState())) {
                選択データ.setRowState(RowState.Modified);
                選択データ.setJotai(状態_修正);
            }
            RDate 変更後適用日 = div.getPanelTekiyoInput().getTxtTekiyoDate().getValue();
            RDate 変更後解除日 = div.getPanelTekiyoInput().getTxtKayijoDate().getValue();
            選択データ.getTekiyoDate().setValue(変更後適用日);
            選択データ.getTekiyoTodokeDate().setValue(div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().getValue());
            選択データ.setTekiyoJiyuCode(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey());
            選択データ.setTekiyoJiyu(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedValue());
            選択データ.getKayijoDate().setValue(変更後解除日);
            選択データ.getKaijoTodokeDate().setValue(div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().getValue());
            選択データ.setKaijoJiyuCode(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey());
            選択データ.setIdoJiyuCode(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey());
            選択データ.setKaijoJiyu(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedValue());

            boolean is異動日変更 = !変更後解除日.toDateString().equals(選択データ.getHenkoumaeIdoYMD());
            RString 枝番 = 開始枝番;
            for (datagridTekiyoJogai_Row row : rowList) {
                if (is異動日変更) {
                    if (変更後解除日.toDateString().equals(row.getHenkougoIdoYMD())
                        && 変更後適用日.toDateString().equals(row.getHenkougoTekiyoDate())) {
                        枝番 = new RString(Integer.parseInt(row.getHenkougoEdaNo().toString()) + 1).padZeroToLeft(PADZERO);
                        break;
                    } else {
                        枝番 = 開始枝番;
                    }
                } else {
                    if (変更後適用日.toDateString().equals(row.getHenkougoTekiyoDate())) {
                        枝番 = new RString(Integer.parseInt(row.getHenkougoEdaNo().toString()) + 1).padZeroToLeft(PADZERO);
                        break;
                    } else {
                        枝番 = new RString(Integer.parseInt(row.getHenkoumaeEdaNo().toString()) + 1).padZeroToLeft(PADZERO);
                    }
                }
            }
            選択データ.setHenkoumaeTekiyoDate(選択データ.getTekiyoDate().getValue().toDateString());
            選択データ.setHenkoumaeIdoYMD(選択データ.getIdoYMD());
            選択データ.setHenkoumaeEdaNo(選択データ.getEdaNo());
            選択データ.setHenkougoTekiyoDate(変更後適用日.toDateString());
            選択データ.setHenkougoIdoYMD(変更後解除日.toDateString());
            選択データ.setHenkougoEdaNo(枝番);
            TekiyoJogaisha tj = new TekiyoJogaisha(識別コード, new FlexibleDate(選択データ.getHenkougoIdoYMD()), 枝番);
            tekiyoJogaishas.add(tj);
        } else if (状態_追加.equals(div.getStauts())) {
            datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();
            RString 枝番 = 開始枝番;
            row.setRowState(RowState.Added);
            row.setJotai(状態_追加);
            RDate 適用日 = div.getPanelTekiyoInput().getTxtTekiyoDate().getValue();
            RDate 解除日 = div.getPanelTekiyoInput().getTxtKayijoDate().getValue();
            row.getTekiyoDate().setValue(div.getPanelTekiyoInput().getTxtTekiyoDate().getValue());
            row.getTekiyoTodokeDate().setValue(div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().getValue());
            row.setTekiyoJiyuCode(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey());
            row.setTekiyoJiyu(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedValue());
            row.getKayijoDate().setValue(div.getPanelTekiyoInput().getTxtKayijoDate().getValue());
            row.getKaijoTodokeDate().setValue(div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().getValue());
            row.setKaijoJiyuCode(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey());
            row.setKaijoJiyu(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedValue());
            row.setIdoYMD(div.getPanelTekiyoInput().getTxtKayijoDate().getValue().toDateString());
            row.setEdaNo(枝番);
            row.setHenkoumaeTekiyoDate(適用日.toDateString());
            row.setHenkoumaeIdoYMD(解除日.toDateString());
            row.setHenkoumaeEdaNo(枝番);
            row.setHenkougoTekiyoDate(適用日.toDateString());
            row.setHenkougoIdoYMD(解除日.toDateString());
            row.setHenkougoEdaNo(枝番);
            rowList.add(row);
            TekiyoJogaisha tj = new TekiyoJogaisha(識別コード, new FlexibleDate(解除日.toDateString()), 枝番);
            tekiyoJogaishas.add(tj);
            Collections.sort(rowList, new DateComparator());
        } else if (状態_削除.equals(div.getStauts())) {
            if (RowState.Added.equals(選択データ.getRowState())) {
                rowList.remove(選択データ);
            } else {
                選択データ.setRowState(RowState.Deleted);
                選択データ.setJotai(状態_削除);
            }
        }
        div.getDatagridTekiyoJogai().setDataSource(rowList);
        ViewStateHolder.put(ViewStateKeys.適用除外者情報, tekiyoJogaishas);
        ViewStateHolder.put(ViewStateKeys.保険施設入退所情報, shisetsuNyutaishos);
    }

    /**
     * 「取消する」ボタンを押下する場合、入力の内容をクリアします。
     *
     */
    public void onClick_Torikeshi() {
        clear適用除外情報入力エリア();
        switch (div.getMode_DisplayMode()) {
            case 適用登録モード:
                div.getPanelTekiyoJokaiTekiInput().setDisabled(true);
                div.getBtnAdd().setDisabled(false);
                div.getBtnInputClear().setDisabled(true);
                div.getBtnKakutei().setDisabled(true);
                return;
            case 解除モード:
                div.getPanelTekiyoJokaiKaiJyoInput().setDisabled(false);
                div.getBtnInputClear().setDisabled(false);
                return;
            case 訂正履歴モード:
                div.getBtnAdd().setDisabled(false);
                div.getPanelTekiyoInput().setDisabled(true);
                div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(true);
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(true);
                div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(true);
                div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(true);
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(true);
                div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(true);
                div.getBtnInputClear().setDisabled(true);
                div.getBtnKakutei().setDisabled(true);
            default:
        }
    }

    /**
     * 適用除外者管理の共有子DIVの画面内容から、適用除外者情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    public void saveTekiyoJogaisha(ShikibetsuCode 識別コード) {
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> 適用除外者Model
                = ViewStateHolder.get(ViewStateKeys.適用除外者情報, Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(ViewStateKeys.保険施設入退所情報, Models.class);

        for (datagridTekiyoJogai_Row row : rowList) {
            if (row.getRowState() == null || RowState.Unchanged.equals(row.getRowState())) {
                continue;
            }

            FlexibleDate 変更前異動日 = new FlexibleDate(row.getHenkoumaeIdoYMD());
            FlexibleDate 変更後異動日 = new FlexibleDate(row.getHenkougoIdoYMD());
            RString 変更前枝番 = row.getHenkoumaeEdaNo();
            RString 変更後枝番 = row.getHenkougoEdaNo();
            switch (div.getMode_DisplayMode()) {
                case 適用登録モード:
                    TekiyoJogaishaIdentifier torokuTarget
                            = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                    ShisetsuNyutaishoIdentifier taishoTarget
                            = new ShisetsuNyutaishoIdentifier(識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                    TekiyoJogaishaManager.createInstance().saveTekiyoJogaisha適用登録(
                            set適用状態適用除外者情報(適用除外者Model.get(torokuTarget), row).toEntity(),
                            set適用状態介護保険施設入退所(保険施設入退所Model.get(taishoTarget), row).toEntity(),
                            識別コード);
                    Collections.sort(rowList, new DateComparator());
                    break;
                case 解除モード:
                    TekiyoJogaishaIdentifier beforeIdentifier
                            = new TekiyoJogaishaIdentifier(識別コード, 変更前異動日, 変更前枝番);
                    TekiyoJogaishaIdentifier afterIdentifiier
                            = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                    ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(
                            識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                    TekiyoJogaishaManager.createInstance().saveTekiyoJogaisha解除(
                            適用除外者Model.get(beforeIdentifier).createBuilderForEdit().set論理削除フラグ(true).build().toEntity(),
                            set解除状態適用除外者情報(適用除外者Model.get(afterIdentifiier), row).toEntity(),
                            set解除状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity(), 識別コード);
            }

            if (RowState.Added.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                set適用除外者情報(適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番)), row)
                                .toEntity()
                        );
            } else if (RowState.Modified.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更前異動日, 変更前枝番))
                                .createBuilderForEdit().set論理削除フラグ(true).build()
                                .toEntity()
                        );
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                set修正状態適用除外者情報(適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番)), row)
                                .toEntity()
                        );
            } else if (RowState.Deleted.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更前異動日, 変更前枝番))
                                .createBuilderForEdit()
                                .set論理削除フラグ(true)
                                .build().toEntity()
                        );
            }
        }
    }

    /**
     * 除外者適用パネルの入所日がある場合、適用日・適用届出日を設定します。
     */
    public void onBlur_Tekiyo() {
        RDate 入所日 = div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue();
        if (入所日 == null) {
            return;
        }
        if (div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue() == null) {
            div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().setValue(入所日);
        }
        if (div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().getValue() == null) {
            div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().setValue(入所日);
        }
    }

    /**
     * 除外者解除パネルの退所日がある場合、解除日・解除届出日を設定します。
     */
    public void onBlur_Kayijo() {
        RDate 退所日 = div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().getValue();
        if (退所日 == null) {
            return;
        }
        if (div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue() == null) {
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().setValue(退所日);
        }
        if (div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().getValue() == null) {
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().setValue(退所日);
        }
    }

    /**
     * 除外者履歴変更パネルの適用日がある場合、適用届出日を設定します。
     */
    public void onBlur_TekiyoRireki() {
        RDate 適用日 = div.getPanelTekiyoInput().getTxtTekiyoDate().getValue();
        if (適用日 != null && div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().getValue() == null) {
            div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setValue(適用日);
        }
    }

    /**
     * 除外者履歴変更パネルの解除日がある場合、解除届出日を設定します。
     */
    public void onBlur_KayijoRireki() {
        RDate 解除日 = div.getPanelTekiyoInput().getTxtKayijoDate().getValue();
        if (解除日 != null && div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().getValue() == null) {
            div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setValue(解除日);
        }
    }

    /**
     * 適用情報一覧を取得します。
     *
     * @return 適用情報一覧
     */
    public List<datagridTekiyoJogai_Row> get適用情報一覧() {
        return div.getDatagridTekiyoJogai().getDataSource();
    }

    private void set適用除外者一覧(List<TekiyoJogaishaRelate> 適用除外者情報リスト) {
        List<datagridTekiyoJogai_Row> rowList = new ArrayList<>();
        for (TekiyoJogaishaRelate 適用除外者情報 : 適用除外者情報リスト) {
            datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();

            if (適用除外者情報.get適用年月日() != null && !適用除外者情報.get適用年月日().isEmpty()) {
                row.getTekiyoDate().setValue(new RDate(適用除外者情報.get適用年月日().toString()));
            } else {
                row.getTekiyoDate().clearValue();
            }
            if (適用除外者情報.get適用届出年月日() != null && !適用除外者情報.get適用届出年月日().isEmpty()) {
                row.getTekiyoTodokeDate().setValue(new RDate(適用除外者情報.get適用届出年月日().toString()));
            } else {
                row.getTekiyoTodokeDate().clearValue();
            }
            row.setTekiyoJiyu((適用除外者情報.get適用除外適用事由コード()));
            if (適用除外者情報.get解除年月日() != null && !適用除外者情報.get解除年月日().isEmpty()) {
                row.getKayijoDate().setValue(new RDate(適用除外者情報.get解除年月日().toString()));
            } else {
                row.getKayijoDate().clearValue();
            }
            if (適用除外者情報.get解除届出年月日() != null && !適用除外者情報.get解除届出年月日().isEmpty()) {
                row.getKaijoTodokeDate().setValue(new RDate(適用除外者情報.get解除届出年月日().toString()));
            } else {
                row.getKaijoTodokeDate().clearValue();
            }
            row.setTekiyoJiyuCode(適用除外者情報.get適用除外適用事由コード());
            row.setTekiyoJiyu(get適用事由(適用除外者情報.get適用除外適用事由コード()));
            row.setKaijoJiyuCode(適用除外者情報.get適用除外解除事由コード());
            row.setKaijoJiyu(get解除事由(適用除外者情報.get適用除外解除事由コード()));
            if (適用除外者情報.get入所年月日() != null && !適用除外者情報.get入所年月日().isEmpty()) {
                row.getNyuShoDate().setValue(new RDate(適用除外者情報.get入所年月日().toString()));
            } else {
                row.getNyuShoDate().clearValue();
            }
            if (適用除外者情報.get退所年月日() != null && !適用除外者情報.get退所年月日().isEmpty()) {
                row.getTaiShoDate().setValue(new RDate(適用除外者情報.get退所年月日().toString()));
            } else {
                row.getTaiShoDate().clearValue();
            }
            if (適用除外者情報.get事業者名称() != null && !適用除外者情報.get事業者名称().isEmpty()) {
                row.setNyuShoShisetu(適用除外者情報.get事業者名称().getColumnValue());
                row.setNyushoShisetsuCode(適用除外者情報.get入所施設コード().getColumnValue());
            } else {
                row.setNyuShoShisetu(RString.EMPTY);
                row.setNyushoShisetsuCode(RString.EMPTY);
            }
            row.setDaichoShubetsu(適用除外者情報.get台帳種別());
            row.setShisetsuShurui(適用除外者情報.get入所施設種類());
            if (適用除外者情報.get履歴番号() != null) {
                row.setRirekiNo(new RString(適用除外者情報.get履歴番号().toString()));
            } else {
                row.setRirekiNo(RString.EMPTY);
            }
            row.setIdoYMD(new RString(適用除外者情報.get異動日().toString()));
            row.setIdoJiyuCode(適用除外者情報.get異動事由コード());
            row.setEdaNo(適用除外者情報.get枝番());
            row.setShichosonCode(適用除外者情報.get市町村コード());
            if (適用除外者情報.get入所通知発行日() != null && !適用除外者情報.get入所通知発行日().isEmpty()) {
                row.setNyushoTsuchiHakkoYMD(new RString(適用除外者情報.get入所通知発行日().toString()));
            } else {
                row.setNyushoTsuchiHakkoYMD(RString.EMPTY);
            }
            if (適用除外者情報.get退所通知発行日() != null && !適用除外者情報.get退所通知発行日().isEmpty()) {
                row.setTaishoTsuchiHakkoYMD(new RString(適用除外者情報.get退所通知発行日().toString()));
            } else {
                row.setTaishoTsuchiHakkoYMD(RString.EMPTY);
            }
            if (適用除外者情報.get変更通知発行日() != null && !適用除外者情報.get変更通知発行日().isEmpty()) {
                row.setHenkoTsuchiHakkoYMD(new RString(適用除外者情報.get変更通知発行日().toString()));
            } else {
                row.setHenkoTsuchiHakkoYMD(RString.EMPTY);
            }
            row.setHenkoumaeTekiyoDate(new RString(適用除外者情報.get適用年月日().toString()));
            row.setHenkoumaeIdoYMD(new RString(適用除外者情報.get異動日().toString()));
            row.setHenkoumaeEdaNo(適用除外者情報.get枝番());
            row.setHenkougoTekiyoDate(new RString(適用除外者情報.get適用年月日().toString()));
            row.setHenkougoIdoYMD(new RString(適用除外者情報.get異動日().toString()));
            row.setHenkougoEdaNo(適用除外者情報.get枝番());

            switch (div.getMode_DisplayMode()) {
                case 適用登録モード:
                    row.setModifyButtonState(DataGridButtonState.Disabled);
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
            }

            rowList.add(row);
        }
        div.getDatagridTekiyoJogai().setDataSource(rowList);
    }

    private void set適用除外者明細エリア(datagridTekiyoJogai_Row 選択されたレコード, DisplayMode 画面状態) {
        switch (画面状態) {
            case 照会モード:
                setTekiyoInputToSelectedRow(div.getPanelTekiyoInput(), 選択されたレコード);
                return;
            case 訂正履歴モード:
                set適用除外者明細エリア_履歴変更();
                div.getBtnInputClear().setVisible(true);
                div.getBtnInputClear().setDisabled(false);
                div.getBtnKakutei().setVisible(true);
                div.getBtnKakutei().setDisabled(false);
            default:
        }
    }

    private static void setTekiyoInputToSelectedRow(panelTekiyoInputDiv div, datagridTekiyoJogai_Row selectedRow) {
        div.getDdlTekiyoJiyu().setDataSource(set適用事由());
        div.getDdlKaijyoJiyu().setDataSource(set解除事由());

        if (selectedRow.getTekiyoDate() != null) {
            div.getTxtTekiyoDate().setValue(selectedRow.getTekiyoDate().getValue());
        } else {
            div.getTxtTekiyoDate().clearValue();
        }
        if (selectedRow.getTekiyoTodokeDate() != null) {
            div.getTxtTekiyoTodokeDate().setValue(selectedRow.getTekiyoTodokeDate().getValue());
        } else {
            div.getTxtTekiyoTodokeDate().clearValue();
        }
        div.getDdlTekiyoJiyu().setSelectedValue(selectedRow.getTekiyoJiyu());
        if (selectedRow.getKayijoDate() != null) {
            div.getTxtKayijoDate().setValue(selectedRow.getKayijoDate().getValue());
        } else {
            div.getTxtKayijoDate().clearValue();
        }
        if (selectedRow.getKaijoTodokeDate() != null) {
            div.getTxtKaijoTodokedeDate().setValue(
                    selectedRow.getKaijoTodokeDate().getValue());
        } else {
            div.getTxtKaijoTodokedeDate().clearValue();
        }
        div.getDdlKaijyoJiyu().setSelectedValue(selectedRow.getKaijoJiyu());
    }

    private static void setTekiyoJokaiTekiInputToSelectedRow(panelTekiyoJokaiTekiInputDiv div, datagridTekiyoJogai_Row selectedRow) {
        if (selectedRow.getTekiyoDate() != null) {
            div.getTxtTekiyoDateInput().setValue(selectedRow.getTekiyoDate().getValue());
        } else {
            div.getTxtTekiyoDateInput();
        }
        if (selectedRow.getTekiyoTodokeDate() != null) {
            div.getTxtTkyoTododkDateIn().setValue(selectedRow.getTekiyoTodokeDate().getValue());
        } else {
            div.getTxtTkyoTododkDateIn().clearValue();
        }
        if (selectedRow.getNyuShoDate() != null) {
            div.getTxtNyusyoDateInput().setValue(selectedRow.getNyuShoDate().getValue());
        } else {
            div.getTxtNyusyoDateInput().clearValue();
        }
        div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(selectedRow.getNyushoShisetsuCode());
    }

    private void set適用除外者明細エリア_除外者適用() {
        div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().setDisabled(false);
        div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().setDisabled(false);
        div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().setDisabled(false);
        div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setDisabled(false);
        div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().setDisabled(false);

        div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().clearValue();
        div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().clearValue();
        div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().clearValue();
        div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setDataSource(set適用事由());
        div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setSelectedValue(RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        ViewStateHolder.put(ViewStateKeys.適用除外者, 適用除外者);
        div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().initialize();
    }

    private void set適用除外者明細エリア_除外者解除() {
        div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().setDisabled(false);
        div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().setDisabled(false);
        div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().setDisabled(false);
        div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().setDisabled(false);

        div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().clearValue();
        div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().clearValue();
        div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().clearValue();
        div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().setDataSource(set解除事由());
        div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().setSelectedValue(RString.EMPTY);
    }

    private void set適用除外者明細エリア_履歴変更(List<TekiyoJogaishaRelate> 適用除外者情報) {
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDataSource(set適用事由());
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDataSource(set解除事由());
        if (適用除外者情報 != null && !適用除外者情報.isEmpty()) {
            if (適用除外者情報.get(0).get適用年月日() != null) {
                div.getPanelTekiyoInput().getTxtTekiyoDate().setValue(
                        new RDate(適用除外者情報.get(0).get適用年月日().toString()));
            } else {
                div.getPanelTekiyoInput().getTxtTekiyoDate().clearValue();
            }
            if (適用除外者情報.get(0).get適用届出年月日() != null) {
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setValue(
                        new RDate(適用除外者情報.get(0).get適用届出年月日().toString()));
            } else {
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().clearValue();
            }
            div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedKey(適用除外者情報.get(0).get適用除外適用事由コード());

            if (適用除外者情報.get(0).get解除年月日() != null) {
                div.getPanelTekiyoInput().getTxtKayijoDate().setValue(
                        new RDate(適用除外者情報.get(0).get解除年月日().toString()));
            } else {
                div.getPanelTekiyoInput().getTxtKayijoDate().clearValue();
            }
            if (適用除外者情報.get(0).get解除届出年月日() != null) {
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setValue(
                        new RDate(適用除外者情報.get(0).get解除届出年月日().toString()));
            } else {
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().clearValue();
            }
            div.getPanelTekiyoInput().getDdlKaijyoJiyu().setSelectedKey(適用除外者情報.get(0).get適用除外解除事由コード());
        }
        div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(true);
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(true);
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(true);
        div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(true);
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(true);
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(true);
    }

    private void clear適用除外情報入力エリア() {
        switch (div.getMode_DisplayMode()) {
            case 適用登録モード:
                div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().clearValue();
                div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().clearValue();
                div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().clearValue();
                div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setSelectedValue(RString.EMPTY);
                div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().clear();
                return;
            case 解除モード:
                div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().clearValue();
                div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().clearValue();
                div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().clearValue();
                div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().setSelectedValue(RString.EMPTY);
            case 訂正履歴モード:
                div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDataSource(set適用事由());
                div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDataSource(set解除事由());
                div.getPanelTekiyoInput().getTxtTekiyoDate().clearValue();
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().clearValue();
                div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedValue(RString.EMPTY);
                div.getPanelTekiyoInput().getTxtKayijoDate().clearValue();
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().clearValue();
                div.getPanelTekiyoInput().getDdlKaijyoJiyu().setSelectedValue(RString.EMPTY);
                div.getBtnAdd().setDisabled(false);
            default:
        }
    }

    private static void setDisabled(panelTekiyoInputDiv div, boolean disabled) {
        div.setDisabled(disabled);
        div.getTxtTekiyoDate().setDisabled(disabled);
        div.getTxtTekiyoTodokeDate().setDisabled(disabled);
        div.getDdlTekiyoJiyu().setDisabled(disabled);
        div.getTxtKayijoDate().setDisabled(disabled);
        div.getTxtKaijoTodokedeDate().setDisabled(disabled);
        div.getDdlKaijyoJiyu().setDisabled(disabled);
    }

    private static RString get適用事由(RString 適用事由コード) {
        if (適用事由コード == null || 適用事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格適用事由_除外者.getコード(),
                new Code(適用事由コード), FlexibleDate.getNowDate());
    }

    private static RString get解除事由(RString 解除事由コード) {
        if (解除事由コード == null || 解除事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格解除事由_除外者.getコード(),
                new Code(解除事由コード), FlexibleDate.getNowDate());
    }

    private static List<KeyValueDataSource> set適用事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> 適用事由Key = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格適用事由_除外者.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity key : 適用事由Key) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(key.getコード().getColumnValue());
            keyValue.setValue(key.getコード略称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private static List<KeyValueDataSource> set解除事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> 解除事由Key = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格解除事由_除外者.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity key : 解除事由Key) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(key.getコード().getColumnValue());
            keyValue.setValue(key.getコード略称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private TekiyoJogaisha set適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        RString 異動事由コード;
        if (row.getKayijoDate().getValue() == null) {
            異動事由コード = row.getTekiyoJiyuCode();
        } else {
            異動事由コード = row.getKaijoJiyuCode();
        }
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 解除日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        if (row.getKayijoDate().getValue() != null) {
            解除日 = new FlexibleDate(row.getKayijoDate().getValue().toDateString());
        }
        if (row.getKaijoTodokeDate().getValue() != null) {
            解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(解除日)
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(異動事由コード)
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(解除日)
                .set解除届出年月日(解除届出日)
                .set解除受付年月日(解除届出日)
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set修正状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        FlexibleDate 解除日 = FlexibleDate.EMPTY;
        FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        if (row.getKayijoDate().getValue() != null) {
            解除日 = new FlexibleDate(row.getKayijoDate().getValue().toDateString());
        }
        if (row.getKaijoTodokeDate().getValue() != null) {
            解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(tekiyoJogaisha.get異動日())
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getIdoJiyuCode())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(解除日)
                .set解除届出年月日(解除届出日)
                .set解除受付年月日(解除届出日)
                .set入所通知発行日(new FlexibleDate(row.getNyushoTsuchiHakkoYMD()))
                .set退所通知発行日(new FlexibleDate(row.getTaishoTsuchiHakkoYMD()))
                .set変更通知発行日(new FlexibleDate(row.getHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set適用状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(適用日)
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getTekiyoJiyuCode())
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set解除状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        FlexibleDate 解除日 = FlexibleDate.EMPTY;
        FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        if (row.getKayijoDate().getValue() != null) {
            解除日 = new FlexibleDate(row.getKayijoDate().getValue().toDateString());
        }
        if (row.getKaijoTodokeDate().getValue() != null) {
            解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(解除日)
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getKaijoJiyuCode())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(解除日)
                .set解除届出年月日(解除届出日)
                .set解除受付年月日(解除届出日)
                .set入所通知発行日(new FlexibleDate(row.getNyushoTsuchiHakkoYMD()))
                .set退所通知発行日(new FlexibleDate(row.getTaishoTsuchiHakkoYMD()))
                .set変更通知発行日(new FlexibleDate(row.getHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private ShisetsuNyutaisho set適用状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            datagridTekiyoJogai_Row row) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
        return taisho.createBuilderForEdit()
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set台帳種別(new RString("3"))
                .set入所施設種類(row.getShisetsuShurui())
                .set入所施設コード(new JigyoshaNo(row.getNyushoShisetsuCode()))
                .set入所処理年月日(FlexibleDate.getNowDate())
                .set入所年月日(new FlexibleDate(row.getNyuShoDate().getValue().toDateString()))
                .build();
    }

    private ShisetsuNyutaisho set解除状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            datagridTekiyoJogai_Row row) {
        return taisho.createBuilderForEdit()
                .set退所年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set退所処理年月日(FlexibleDate.getNowDate())
                .build();
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報() {
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHiddenInputShikibetsuCode());
        return TekiyoJogaishaManager.createInstance().get宛名情報(識別コード);
    }

    private static boolean isデータ変更(TekiyoJogaiRirekiDiv div, datagridTekiyoJogai_Row 選択データ) {
        if (選択データ.getTekiyoDate().getValue().equals(div.getPanelTekiyoInput().getTxtTekiyoDate().getValue())
            && 選択データ.getTekiyoTodokeDate().getValue().equals(div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().getValue())
            && 選択データ.getTekiyoJiyuCode().equals(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey())
            && 選択データ.getKayijoDate().getValue().equals(div.getPanelTekiyoInput().getTxtKayijoDate().getValue())
            && 選択データ.getKaijoTodokeDate().getValue().equals(div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().getValue())
            && 選択データ.getKaijoJiyuCode().equals(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey())) {
            return false;
        }
        return true;
    }

    private static class DateComparator implements Comparator<datagridTekiyoJogai_Row>, Serializable {

        private static final long serialVersionUID = 5006325486336899667L;

        @Override
        public int compare(datagridTekiyoJogai_Row o1, datagridTekiyoJogai_Row o2) {
            return o2.getTekiyoDate().getValue().compareTo(o1.getTekiyoDate().getValue());
        }
    }

    private static class DateComparatoRrirekiNo implements Comparator<datagridTekiyoJogai_Row>, Serializable {

        private static final long serialVersionUID = 6830800829524381370L;

        @Override
        public int compare(datagridTekiyoJogai_Row o1, datagridTekiyoJogai_Row o2) {
            return o1.getRirekiNo().compareTo(o2.getRirekiNo());
        }
    }
}
