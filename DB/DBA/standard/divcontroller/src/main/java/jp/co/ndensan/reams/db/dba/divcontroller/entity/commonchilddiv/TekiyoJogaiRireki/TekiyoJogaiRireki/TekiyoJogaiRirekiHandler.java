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
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu.HihokenshashikakusoshitsuManager;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.TekiyoJogaishaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final RString 状態_適用登録 = new RString("適用登録モード");
    private static final RString 状態_解除 = new RString("解除モード");
    private static final RString 状態_施設変更 = new RString("施設変更モード");
    private static final RString 状態_訂正履歴 = new RString("訂正履歴モード");
    private static final RString 状態_照会 = new RString("照会モード");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString 適用除外者 = new RString("適用除外者");
    private static final int PADZERO = 4;
    private static final CodeShubetsu 介護除外適用理由 = new CodeShubetsu("0009");
    private static final CodeShubetsu 介護除外解除理由 = new CodeShubetsu("0012");
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
        RString 親画面状態 = new RString(div.getMode_DisplayMode().toString());
        div.setStauts(親画面状態);
        List<TekiyoJogaishaRelate> 適用除外者情報
                = TekiyoJogaishaManager.createInstance().getTekiyoJogaishaLst(識別コード, false).records();
        if (適用除外者情報 != null && !適用除外者情報.isEmpty()) {
            set適用除外者一覧(適用除外者情報);
            TekiyoJogaishaBusiness 適用除外者管理Model
                    = TekiyoJogaishaManager.createInstance().get適用除外者と施設入退所情報(識別コード, false);
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報,
                    Models.create(適用除外者管理Model.get適用除外者List()));
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報,
                    Models.create(適用除外者管理Model.get施設入退所Lsit()));
        } else {
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報,
                    Models.create(new ArrayList()));
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報,
                    Models.create(new ArrayList()));
        }
        if (状態_適用登録.equals(親画面状態)) {
            div.getBtnAdd().setVisible(true);
            div.getBtnAdd().setDisabled(true);
            div.getDatagridTekiyoJogai().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getDatagridTekiyoJogai().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDatagridTekiyoJogai().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getPanelTekiyoJokaiTekiInput().setVisible(true);
            div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
            div.getPanelTekiyoInput().setVisible(false);
            set適用除外者明細エリア_除外者適用();
            div.getBtnInputClear().setVisible(true);
            div.getBtnInputClear().setDisabled(false);
            div.getBtnKakutei().setVisible(true);
            div.getBtnKakutei().setDisabled(false);
        } else if (状態_解除.equals(親画面状態)) {
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
        } else if (状態_施設変更.equals(親画面状態)) {
            div.getPanelTekiyoRireki().setVisible(false);
            div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
            div.getPanelTekiyoJokaiTekiInput().setVisible(false);
            div.getPanelTekiyoInput().setVisible(true);
            set適用除外者明細エリア_履歴変更(適用除外者情報);
            div.getBtnInputClear().setVisible(true);
            div.getBtnInputClear().setDisabled(false);
            div.getBtnKakutei().setVisible(true);
            div.getBtnKakutei().setDisabled(false);
        } else if (状態_訂正履歴.equals(親画面状態)) {
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
        } else if (状態_照会.equals(親画面状態)) {
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
        }
    }

    /**
     * 「選択」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     */
    public void onClick_Selected() {
        set適用除外者明細エリア(div.getDatagridTekiyoJogai().getActiveRow(), 状態_照会);
    }

    /**
     * 「追加する」ボタンを押下する場合、適用除外者明細エリア全項目をクリアします。
     */
    public void onClick_BtnAdd() {
        div.setStauts(状態_追加);
        RString 親画面状態 = new RString(div.getMode_DisplayMode().toString());
        if (状態_適用登録.equals(親画面状態)) {
            div.getPanelTekiyoJokaiTekiInput().setDisabled(false);
            clear適用除外情報入力エリア();
            div.getBtnInputClear().setVisible(true);
            div.getBtnInputClear().setDisabled(false);
            div.getBtnKakutei().setVisible(true);
            div.getBtnKakutei().setDisabled(false);
        } else {
            set適用除外者明細エリア(null, 親画面状態);
            set適用除外者明細エリア状態();
        }
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     */
    public void onClick_Update() {
        div.setStauts(状態_修正);
        set適用除外者明細エリア(div.getDatagridTekiyoJogai().getActiveRow(), 状態_修正);
        set適用除外者明細エリア状態();
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
        set適用除外者明細エリア(div.getDatagridTekiyoJogai().getActiveRow(), 状態_修正);
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
    public void onClick_BtnKakunin(datagridTekiyoJogai_Row 選択データ, RString 画面状態) {
        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> 適用除外者Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報,
                        Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報,
                        Models.class);
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getHiddenInputShikibetsuCode());
        FlexibleDate 異動日;
        RString 枝番 = 開始枝番;
        if (rowList == null || rowList.isEmpty()) {
            rowList = new ArrayList();
        }
        if (状態_適用登録.equals(画面状態)) {
            int 最新履歴番号 = 0;
            Collections.sort(rowList, new DateComparatoRrirekiNo());
            if (!RString.isNullOrEmpty(rowList.get(0).getRirekiNo())) {
                最新履歴番号 = Integer.parseInt(rowList.get(0).getRirekiNo().toString());
            }
            RString 履歴番号 = new RString(最新履歴番号 + 1);
            枝番 = 開始枝番;
            異動日 = new FlexibleDate(div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue().toString());
            datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();
            row.setRowState(RowState.Added);
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
            rowList.add(row);
            ShisetsuNyutaisho taisho = new ShisetsuNyutaisho(識別コード, Integer.parseInt(履歴番号.toString()));
            保険施設入退所Model.add(taisho);
            TekiyoJogaisha 適用除外者の識別子
                    = new TekiyoJogaisha(識別コード, 異動日, 枝番);
            適用除外者Model.add(適用除外者の識別子);
            Collections.sort(rowList, new DateComparator());
            div.getPanelTekiyoJokaiTekiInput().setDisabled(true);
            div.getBtnAdd().setDisabled(true);
        } else if (状態_解除.equals(画面状態) && !rowList.isEmpty()) {
            datagridTekiyoJogai_Row row = rowList.get(0);
            枝番 = new RString(Integer.parseInt(row.getEdaNo().trim().toString()) + 1).padZeroToLeft(PADZERO);
            異動日 = new FlexibleDate(div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue().toString());
            row.setRowState(RowState.Modified);
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
            TekiyoJogaisha 適用除外者の識別子
                    = new TekiyoJogaisha(識別コード, 異動日, 枝番);
            適用除外者Model.add(適用除外者の識別子);
            div.getPanelTekiyoJokaiKaiJyoInput().setDisabled(true);
        } else if (状態_訂正履歴.equals(画面状態)) {
            if (状態_修正.equals(div.getStauts())) {
                if (RowState.Unchanged.equals(選択データ.getRowState())) {
                    選択データ.setRowState(RowState.Modified);
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
                boolean is異動日変更 = false;
                if (!変更後解除日.toDateString().equals(選択データ.getHenkoumaeIdoYMD())) {
                    is異動日変更 = true;
                }
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
                            枝番 = 開始枝番;
                        }
                    }
                }

                選択データ.setHenkoumaeTekiyoDate(選択データ.getTekiyoDate().getValue().toDateString());
                選択データ.setHenkoumaeIdoYMD(選択データ.getIdoYMD());
                選択データ.setHenkoumaeEdaNo(選択データ.getEdaNo());
                選択データ.setHenkougoTekiyoDate(変更後適用日.toDateString());
                選択データ.setHenkougoIdoYMD(変更後解除日.toDateString());
                選択データ.setHenkougoEdaNo(枝番);
                TekiyoJogaisha 適用除外者の識別子 = new TekiyoJogaisha(識別コード, new FlexibleDate(選択データ.getHenkougoIdoYMD()), 枝番);
                適用除外者Model.add(適用除外者の識別子);
            } else if (状態_追加.equals(div.getStauts())) {
                datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();
                枝番 = 開始枝番;
                row.setRowState(RowState.Added);
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
                TekiyoJogaisha 適用除外者の識別子
                        = new TekiyoJogaisha(識別コード, new FlexibleDate(解除日.toDateString()), 枝番);
                適用除外者Model.add(適用除外者の識別子);
                Collections.sort(rowList, new DateComparator());
            } else if (状態_削除.equals(div.getStauts())) {
                if (RowState.Added.equals(選択データ.getRowState())) {
                    rowList.remove(選択データ);
                } else {
                    選択データ.setRowState(RowState.Deleted);
                    異動日 = new FlexibleDate(選択データ.getIdoYMD());
                    枝番 = 選択データ.getEdaNo();
                    TekiyoJogaisha 適用除外者の識別子 = new TekiyoJogaisha(識別コード, 異動日, 枝番);
                    適用除外者Model.add(適用除外者の識別子);
                }
            }
        }
        div.getDatagridTekiyoJogai().setDataSource(rowList);
        div.setStauts(RString.EMPTY);
        clear適用除外情報入力エリア();
        div.getBtnInputClear().setDisabled(true);
        div.getBtnKakutei().setDisabled(true);
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報, 適用除外者Model);
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報, 保険施設入退所Model);
    }

    /**
     * 「取消する」ボタンを押下する場合、入力の内容をクリアします。
     *
     */
    public void onClick_Torikeshi() {
        clear適用除外情報入力エリア();
        RString 画面状態 = new RString(div.getMode_DisplayMode().toString());
        if (状態_適用登録.equals(画面状態)) {
            div.getPanelTekiyoJokaiTekiInput().setDisabled(true);
            div.getBtnAdd().setDisabled(false);
            div.getBtnInputClear().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
        } else if (状態_解除.equals(画面状態)) {
            div.getPanelTekiyoJokaiKaiJyoInput().setDisabled(false);
            div.getBtnInputClear().setDisabled(false);
        } else if (状態_訂正履歴.equals(画面状態)) {
            div.getBtnAdd().setDisabled(false);
            div.getPanelTekiyoInput().setDisabled(true);
            div.getBtnInputClear().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
        }

    }

    /**
     * 適用除外者管理の共有子DIVの画面内容から、適用除外者情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    public void saveTekiyoJogaisha(ShikibetsuCode 識別コード) {
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        RString 画面状態 = new RString(div.getMode_DisplayMode().toString());
        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> 適用除外者Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報, Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報, Models.class);
        for (datagridTekiyoJogai_Row row : rowList) {
            if (row.getRowState() == null || RowState.Unchanged.equals(row.getRowState())) {
                continue;
            }
            FlexibleDate 解除日 = FlexibleDate.EMPTY;
            FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
            FlexibleDate 変更前異動日 = new FlexibleDate(row.getHenkoumaeIdoYMD());
            FlexibleDate 変更後異動日 = new FlexibleDate(row.getHenkougoIdoYMD());
            RString 変更前枝番 = row.getHenkoumaeEdaNo();
            RString 変更後枝番 = row.getHenkougoEdaNo();
            if (row.getKayijoDate().getValue() != null) {
                解除日 = new FlexibleDate(row.getKayijoDate().getValue().toString());
            }
            if (row.getKaijoTodokeDate().getValue() != null) {
                解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toString());
            }
            if (状態_適用登録.equals(画面状態)) {
                RString 画面喪失 = HihokenshashikakusoshitsuManager.createInstance().shikakuSoshitsuCheck(識別コード, HihokenshaNo.EMPTY);
                if (DbaErrorMessages.住所地特例として未適用.getMessage().getCode().equals(画面喪失.toString())) {
                    throw new ApplicationException(DbaErrorMessages.住所地特例として未適用.getMessage());
                }
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 変更前異動日, 変更前枝番);
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(
                        set適用状態適用除外者情報(適用除外者Model.get(適用除外者の識別子), row).toEntity());

                ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                TaJushochiTokureisyaKanriManager.createInstance().regShisetsuNyutaisho(
                        set適用状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity());

                if (!(DbaErrorMessages.被保険者履歴に期間重複.getMessage().getCode().equals(画面喪失.toString())
                        && DbaErrorMessages.他の期間情報との期間重複.getMessage().getCode().equals(画面喪失.toString()))) {
                    HihokenshashikakusoshitsuManager.createInstance().saveHihokenshaShikakuSoshitsu(
                            識別コード,
                            HihokenshaNo.EMPTY,
                            new FlexibleDate(row.getTekiyoDate().getValue().toDateString()),
                            ShikakuSoshitsuJiyu.除外者.getコード(),
                            new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString()));
                }
                Collections.sort(rowList, new DateComparator());
                break;
            } else if (状態_解除.equals(new RString(div.getMode_DisplayMode().toString()))) {
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 変更前異動日, 変更前枝番);
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(
                        set解除状態適用除外者情報(適用除外者Model.get(適用除外者の識別子), row).toEntity());

                ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(
                        識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                TekiyoJogaishaManager.createInstance().updateKaigoJogaiTokureiTaishoShisetsu(
                        set解除状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity());
                if (JogaiKaijoJiyu.除外者解除.getコード().equals(row.getKaijoJiyuCode())) {
                    TekiyoJogaishaManager.createInstance().saveHihokenshaShutoku(
                            row.getKaijoJiyuCode(),
                            解除日,
                            識別コード,
                            解除届出日);
                }
                break;
            } else if (RowState.Added.equals(row.getRowState())) {
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(set適用除外者情報(
                        適用除外者Model.get(適用除外者の識別子), row).toEntity());
            } else if (RowState.Modified.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 変更前異動日, 変更前枝番);
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(
                        set修正状態適用除外者情報(適用除外者Model.get(適用除外者の識別子), row).toEntity());
            } else if (RowState.Deleted.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 変更前異動日, 変更前枝番);
            }
        }
    }

    /**
     * 除外者適用パネルの入所日がある場合、適用日・適用届出日を設定します。
     */
    public void onBlur_Tekiyo() {
        RDate 入所日 = div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue();
        if (入所日 != null) {
            if (div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue() == null) {
                div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().setValue(入所日);
            }
            if (div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().getValue() == null) {
                div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().setValue(入所日);
            }
        }
    }

    /**
     * 除外者解除パネルの退所日がある場合、解除日・解除届出日を設定します。
     */
    public void onBlur_Kayijo() {
        RDate 退所日 = div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().getValue();
        if (退所日 != null) {
            if (div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue() == null) {
                div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().setValue(退所日);
            }
            if (div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().getValue() == null) {
                div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().setValue(退所日);
            }
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
            row.setTekiyoJiyu(get適用事由(適用除外者情報.get適用除外適用事由コード()));
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
            rowList.add(row);
        }
        div.getDatagridTekiyoJogai().setDataSource(rowList);
    }

    private void set適用除外者明細エリア(
            datagridTekiyoJogai_Row 選択されたレコード,
            RString 画面状態) {
        if (状態_照会.equals(画面状態) || 状態_修正.equals(画面状態)) {
            div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDataSource(set適用事由());
            div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDataSource(set解除事由());

            if (選択されたレコード.getTekiyoDate() != null) {
                div.getPanelTekiyoInput().getTxtTekiyoDate().setValue(選択されたレコード.getTekiyoDate().getValue());
            } else {
                div.getPanelTekiyoInput().getTxtTekiyoDate().clearValue();
            }
            if (選択されたレコード.getTekiyoTodokeDate() != null) {
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setValue(
                        選択されたレコード.getTekiyoTodokeDate().getValue());
            } else {
                div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().clearValue();
            }
            div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedValue(選択されたレコード.getTekiyoJiyu());
            if (選択されたレコード.getKayijoDate() != null) {
                div.getPanelTekiyoInput().getTxtKayijoDate().setValue(選択されたレコード.getKayijoDate().getValue());
            } else {
                div.getPanelTekiyoInput().getTxtKayijoDate().clearValue();
            }
            if (選択されたレコード.getKaijoTodokeDate() != null) {
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setValue(
                        選択されたレコード.getKaijoTodokeDate().getValue());
            } else {
                div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().clearValue();
            }
            div.getPanelTekiyoInput().getDdlKaijyoJiyu().setSelectedValue(選択されたレコード.getKaijoJiyu());
        } else if (状態_訂正履歴.equals(画面状態)) {
            set適用除外者明細エリア_履歴変更();
            div.getBtnInputClear().setVisible(true);
            div.getBtnInputClear().setDisabled(false);
            div.getBtnKakutei().setVisible(true);
            div.getBtnKakutei().setDisabled(false);
        }

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

    private void clear適用除外情報入力エリア() {
        RString 画面モード = new RString(div.getMode_DisplayMode().toString());
        if (状態_適用登録.equals(画面モード)) {
            div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().clearValue();
            div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().clearValue();
            div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().clearValue();
            div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setSelectedValue(RString.EMPTY);
            div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().clear();
        } else if (状態_解除.equals(画面モード)) {
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().clearValue();
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().clearValue();
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().clearValue();
            div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().setSelectedValue(RString.EMPTY);
        } else if (状態_訂正履歴.equals(画面モード)) {
            div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDataSource(set適用事由());
            div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDataSource(set解除事由());
            div.getPanelTekiyoInput().getTxtTekiyoDate().clearValue();
            div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().clearValue();
            div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedValue(RString.EMPTY);
            div.getPanelTekiyoInput().getTxtKayijoDate().clearValue();
            div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().clearValue();
            div.getPanelTekiyoInput().getDdlKaijyoJiyu().setSelectedValue(RString.EMPTY);
            div.getBtnAdd().setDisabled(false);
        }
    }

    private void set適用除外者明細エリア状態() {
        div.getPanelTekiyoInput().setDisabled(false);
        div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(false);
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(false);
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(false);
        div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(false);
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(false);
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(false);
    }

    private RString get適用事由(RString 適用事由コード) {
        if (適用事由コード == null || 適用事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(介護除外適用理由, new Code(適用事由コード));
    }

    private RString get解除事由(RString 解除事由コード) {
        if (解除事由コード == null || 解除事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(介護除外解除理由, new Code(解除事由コード));
    }

    private List<KeyValueDataSource> set適用事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> 適用事由Key = CodeMaster.getCode(介護除外適用理由);
        for (UzT0007CodeEntity key : 適用事由Key) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(key.getコード().getColumnValue());
            keyValue.setValue(key.getコード名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> set解除事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> 解除事由Key = CodeMaster.getCode(介護除外解除理由);
        for (UzT0007CodeEntity key : 解除事由Key) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(key.getコード().getColumnValue());
            keyValue.setValue(key.getコード名称());
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
