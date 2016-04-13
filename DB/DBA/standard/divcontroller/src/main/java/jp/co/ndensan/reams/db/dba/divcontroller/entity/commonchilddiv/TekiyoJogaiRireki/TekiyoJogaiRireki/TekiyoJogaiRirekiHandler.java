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
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.TekiyoJogaishaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaIdentifier;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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
    private static final RString 除外者解除 = new RString("除外者解除");
    private static final int PADZERO = 4;
    private static final CodeShubetsu 介護除外適用理由 = new CodeShubetsu("0119");
    private static final CodeShubetsu 介護除外解除理由 = new CodeShubetsu("0123");
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
            div.getDatagridTekiyoJogai().getGridSetting().getColumns().get(0).setVisible(false);
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
            div.getDatagridTekiyoJogai().getGridSetting().getColumns().get(0).setVisible(false);
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
            div.getPanelTekiyoInput().setVisible(false);
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
            div.getDatagridTekiyoJogai().getGridSetting().getColumns().get(0).setVisible(true);
            div.getPanelTekiyoJokaiTekiInput().setVisible(false);
            div.getPanelTekiyoJokaiKaiJyoInput().setVisible(false);
            div.getPanelTekiyoInput().setVisible(true);
            set適用除外者明細エリア_履歴変更();
            div.getBtnInputClear().setVisible(true);
            div.getBtnInputClear().setDisabled(false);
            div.getBtnKakutei().setVisible(true);
            div.getBtnKakutei().setDisabled(false);
        } else if (状態_照会.equals(親画面状態)) {
            div.getBtnAdd().setVisible(false);
            div.getDatagridTekiyoJogai().getGridSetting().setIsShowSelectButtonColumn(true);
            div.getDatagridTekiyoJogai().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDatagridTekiyoJogai().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDatagridTekiyoJogai().getGridSetting().getColumns().get(0).setVisible(false);
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
        set適用除外者明細エリア(null, 状態_訂正履歴);
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を適用除外者明細エリアへ設定します。
     */
    public void onClick_Update() {
        div.setStauts(状態_修正);
        set適用除外者明細エリア(div.getDatagridTekiyoJogai().getActiveRow(), 状態_修正);
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
        FlexibleDate 異動日 = new FlexibleDate(選択データ.getIdoYMD());
        RString 最大枝番;
        RString 最新履歴番号;
        RString 枝番;
        RString 履歴番号;
        if (rowList != null && !rowList.isEmpty()) {
            最大枝番 = rowList.get(0).getEdaNo();
            最新履歴番号 = rowList.get(0).getRirekiNo();
            int rirekiNoMax = Integer.parseInt(最新履歴番号.toString());
            枝番 = new RString(String.valueOf(Integer.valueOf(最大枝番.toString()) + 1)).padZeroToLeft(PADZERO);
            履歴番号 = new RString(String.valueOf(rirekiNoMax + 1));
        } else {
            rowList = new ArrayList();
            枝番 = new RString("0001");
            履歴番号 = new RString("1");
        }
        if (状態_修正.equals(画面状態) || 状態_訂正履歴.equals(画面状態)) {
            if (!状態_削除.equals(選択データ.getStatus())) {
                if (状態_追加.equals(選択データ.getStatus())) {
                    選択データ.setStatus(選択データ.getStatus());
                } else {
                    選択データ.setStatus(状態_修正);
                }
                選択データ.setTekiyoDate(div.getPanelTekiyoInput().getTxtTekiyoDate());
                選択データ.setTekiyoTodokeDate(div.getPanelTekiyoInput().getTxtTekiyoTodokeDate());
                選択データ.setTekiyoJiyuCode(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey());
                選択データ.setTekiyoJiyu(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedValue());
                選択データ.setKayijoDate(div.getPanelTekiyoInput().getTxtKayijoDate());
                選択データ.setKaijoTodokeDate(div.getPanelTekiyoInput().getTxtKaijoTodokedeDate());
                選択データ.setKaijoJiyuCode(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey());
                選択データ.setKaijoJiyu(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedValue());
                TekiyoJogaisha 適用除外者の識別子 = new TekiyoJogaisha(識別コード, 異動日, 枝番);
                適用除外者Model.add(適用除外者の識別子);
            }
        } else if (状態_適用登録.equals(画面状態)) {
            datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();
            row.setStatus(状態_追加);
            row.setTekiyoDate(div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput());
            row.setTekiyoTodokeDate(div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn());
            row.setTekiyoJiyuCode(div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedKey());
            row.setTekiyoJiyu(div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedValue());
            row.setNyuShoDate(div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput());
            row.setNyuShoShisetu(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            row.setDaichoShubetsu(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getDaichoShubetsu());
            row.setShisetsuShurui(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().get施設種類());
            rowList.add(row);
            ShisetsuNyutaisho taisho = new ShisetsuNyutaisho(識別コード, Integer.parseInt(履歴番号.toString()));
            保険施設入退所Model.add(taisho);
            TekiyoJogaisha 適用除外者の識別子
                    = new TekiyoJogaisha(識別コード, new FlexibleDate(
                                    div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue().toString()), 枝番);
            適用除外者Model.add(適用除外者の識別子);
            Collections.sort(rowList, new DateComparator());
        } else if (状態_追加.equals(画面状態)) {
            datagridTekiyoJogai_Row row = new datagridTekiyoJogai_Row();
            row.setStatus(状態_追加);
            row.setTekiyoDate(div.getPanelTekiyoInput().getTxtTekiyoDate());
            row.setTekiyoTodokeDate(div.getPanelTekiyoInput().getTxtTekiyoTodokeDate());
            row.setTekiyoJiyuCode(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey());
            row.setTekiyoJiyu(div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedValue());
            row.setKayijoDate(div.getPanelTekiyoInput().getTxtKayijoDate());
            row.setKaijoTodokeDate(div.getPanelTekiyoInput().getTxtKaijoTodokedeDate());
            row.setKaijoJiyuCode(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey());
            row.setKaijoJiyu(div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedValue());
            rowList.add(row);
            TekiyoJogaisha 適用除外者の識別子
                    = new TekiyoJogaisha(識別コード, new FlexibleDate(
                                    div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().getValue().toString()), 枝番);
            適用除外者Model.add(適用除外者の識別子);
            Collections.sort(rowList, new DateComparator());
        } else if (状態_削除.equals(画面状態)) {
            if (状態_追加.equals(選択データ.getStatus())) {
                rowList.remove(選択データ);
            } else {
                選択データ.setStatus(状態_削除);
                TekiyoJogaisha 適用除外者の識別子 = new TekiyoJogaisha(識別コード, 異動日, 枝番);
                適用除外者Model.add(適用除外者の識別子);
            }
        } else if (状態_解除.equals(画面状態) && !rowList.isEmpty()) {
            datagridTekiyoJogai_Row row = rowList.get(0);
            row.setStatus(状態_修正);
            row.setTaiShoDate(div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput());
            row.setKayijoDate(div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput());
            row.setKaijoTodokeDate(div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn());
            row.setKaijoJiyuCode(div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedKey());
            row.setKaijoJiyu(div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedValue());
            ShisetsuNyutaisho taisho = new ShisetsuNyutaisho(識別コード, Integer.parseInt(履歴番号.toString()));
            保険施設入退所Model.add(taisho);
            TekiyoJogaisha 適用除外者の識別子
                    = new TekiyoJogaisha(識別コード, new FlexibleDate(
                                    div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue().toString()), 枝番);
            適用除外者Model.add(適用除外者の識別子);
        }
        Collections.sort(rowList, new DateComparator());
        div.getDatagridTekiyoJogai().setDataSource(rowList);
        div.setStauts(RString.EMPTY);
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報, 適用除外者Model);
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報, 保険施設入退所Model);
    }

    /**
     * 「取消する」ボタンを押下する場合、入力の内容をクリアします。
     *
     * @param 画面状態 画面状態
     */
    public void onClick_Torikeshi(RString 画面状態) {
        clear適用除外情報入力エリア(画面状態);
    }

    /**
     * 適用除外者管理の共有子DIVの画面内容から、適用除外者情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    public void saveTekiyoJogaisha(ShikibetsuCode 識別コード) {
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> 適用除外者Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_適用除外者情報, Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.適用除外者管理_保険施設入退所情報, Models.class);
        for (datagridTekiyoJogai_Row row : rowList) {
            RString 最大枝番 = rowList.get(0).getEdaNo();
            RString 履歴番号 = rowList.get(0).getRirekiNo();
            FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
            RString 枝番 = new RString(String.valueOf(Integer.valueOf(最大枝番.toString()) + 1)).padZeroToLeft(PADZERO);
            if (row.getRowState() == null) {
                continue;
            }
            if (状態_追加.equals(row.getStatus())) {
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 異動日, 枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(set適用除外者情報(
                        適用除外者Model.get(適用除外者の識別子), row).toEntity());
            } else if (状態_修正.equals(row.getStatus())) {
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 異動日, row.getEdaNo());
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 異動日, 枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(
                        set修正状態適用除外者情報(適用除外者Model.get(適用除外者の識別子), row).toEntity());
            } else if (状態_削除.equals(row.getStatus())) {
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 異動日, row.getEdaNo());
            } else if (状態_適用登録.equals(new RString(div.getMode_DisplayMode().toString()))) {
                // TODO 丁一 「画面喪失チェック処理」を呼び出す　2016/04/10
                // TODO　丁一　被保険者台帳管理（資格喪失）実装しない。　2016/04/10
                // RString 画面喪失 = 被保険者台帳管理.ShikakuSoshitsuCheck(識別コード, null);
                RString 画面喪失 = new RString("");
                if (DbaErrorMessages.住所地特例として未適用.getMessage().getCode().equals(画面喪失.toString())) {
                    throw new ApplicationException(DbaErrorMessages.住所地特例として未適用.getMessage());
                }
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 異動日, row.getEdaNo());
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 異動日, 枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(
                        set適用状態適用除外者情報(適用除外者Model.get(適用除外者の識別子), row).toEntity());

                int rirekiNo = Integer.parseInt(履歴番号.toString());
                int 最大履歴番号 = rirekiNo + 1;
                ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(識別コード, 最大履歴番号);
                TaJushochiTokureisyaKanriManager.createInstance().regShisetsuNyutaisho(
                        set適用状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity());

                if (!(DbaErrorMessages.被保険者履歴に期間重複.getMessage().getCode().equals(画面喪失.toString())
                        && DbaErrorMessages.被保険者履歴に期間重複.getMessage().getCode().equals(画面喪失.toString()))) {
                    // TODO 丁一 「被保険者台帳管理（資格喪失）登録処理」を呼び出す　2016/04/10
                    // TODO　丁一　被保険者台帳管理（資格喪失）実装しない。　2016/04/10
                }
            } else if (状態_解除.equals(new RString(div.getMode_DisplayMode().toString()))) {
                TekiyoJogaishaManager.createInstance().delTekiyoJogaisha(識別コード, 異動日, row.getEdaNo());
                TekiyoJogaishaIdentifier 適用除外者の識別子
                        = new TekiyoJogaishaIdentifier(識別コード, 異動日, 枝番);
                TekiyoJogaishaManager.createInstance().regTekiyoJogaisha(
                        set解除状態適用除外者情報(適用除外者Model.get(適用除外者の識別子), row).toEntity());

                ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(
                        識別コード, Integer.getInteger(row.getRirekiNo().toString()));
                TekiyoJogaishaManager.createInstance().updateKaigoJogaiTokureiTaishoShisetsu(
                        set解除状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity());
                if (除外者解除.equals(row.getKaijoJiyu())) {
                    TekiyoJogaishaManager.createInstance().saveHihokenshaShutoku(
                            row.getKaijoJiyu(),
                            new FlexibleDate(row.getKayijoDate().toString()),
                            識別コード,
                            new FlexibleDate(row.getKaijoTodokeDate().toString()));
                }
            }
        }
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
            } else {
                row.setNyuShoShisetu(RString.EMPTY);
            }
            row.setDaichoShubetsu(適用除外者情報.get台帳種別());
            row.setShisetsuShurui(適用除外者情報.get入所施設種類());
            row.setRirekiNo(new RString(適用除外者情報.get履歴番号().toString()));
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
        div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().setNyuryokuShisetsuKodo(RString.EMPTY);
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
            div.getPanelTekiyoInput().getTxtTekiyoDate().setValue(
                    new RDate(適用除外者情報.get(0).get適用年月日().toString()));
            div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setValue(
                    new RDate(適用除外者情報.get(0).get適用届出年月日().toString()));
            div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedKey(適用除外者情報.get(0).get適用除外適用事由コード());
            div.getPanelTekiyoInput().getTxtKayijoDate().setValue(
                    new RDate(適用除外者情報.get(0).get解除年月日().toString()));
            div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setValue(
                    new RDate(適用除外者情報.get(0).get解除届出年月日().toString()));
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
        div.getPanelTekiyoInput().getTxtTekiyoDate().setDisabled(false);
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().setDisabled(false);
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDisabled(false);
        div.getPanelTekiyoInput().getTxtKayijoDate().setDisabled(false);
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().setDisabled(false);
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDisabled(false);

        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setDataSource(set適用事由());
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setDataSource(set解除事由());
        div.getPanelTekiyoInput().getTxtTekiyoDate().clearValue();
        div.getPanelTekiyoInput().getTxtTekiyoTodokeDate().clearValue();
        div.getPanelTekiyoInput().getDdlTekiyoJiyu().setSelectedValue(RString.EMPTY);
        div.getPanelTekiyoInput().getTxtKayijoDate().clearValue();
        div.getPanelTekiyoInput().getTxtKaijoTodokedeDate().clearValue();
        div.getPanelTekiyoInput().getDdlKaijyoJiyu().setSelectedValue(RString.EMPTY);
    }

    private void clear適用除外情報入力エリア(RString 画面状態) {
        if (状態_適用登録.equals(画面状態)) {
            div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().clearValue();
            div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().clearValue();
            div.getPanelTekiyoJokaiTekiInput().getTxtTkyoTododkDateIn().clearValue();
            div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().setSelectedValue(RString.EMPTY);
            div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().clear();
            div.getBtnAdd().setDisabled(false);
        } else if (状態_解除.equals(画面状態)) {
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtTaisyoDateInput().clearValue();
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().clearValue();
            div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoTododkDateIn().clearValue();
            div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().setSelectedValue(RString.EMPTY);
        } else if (状態_追加.equals(画面状態) || 状態_訂正履歴.equals(画面状態) || 状態_修正.equals(画面状態)) {
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
            異動事由コード = row.getTekiyoJiyu();
        } else {
            異動事由コード = row.getKaijoJiyu();
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(new FlexibleDate(row.getKayijoDate().getValue().toDateString()))
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(異動事由コード)
                .set市町村コード(association.get地方公共団体コード())
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(new FlexibleDate(row.getTekiyoDate().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(new FlexibleDate(row.getKayijoDate().getValue().toDateString()))
                .set解除届出年月日(new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString()))
                .set解除受付年月日(new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString()))
                .set入所通知発行日(FlexibleDate.EMPTY)
                .set退所通知発行日(FlexibleDate.EMPTY)
                .set変更通知発行日(FlexibleDate.EMPTY)
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set修正状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(new FlexibleDate(row.getKayijoDate().getValue().toDateString()))
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getIdoJiyuCode())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(new FlexibleDate(row.getTekiyoDate().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(new FlexibleDate(row.getKayijoDate().getValue().toDateString()))
                .set解除届出年月日(new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString()))
                .set解除受付年月日(new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString()))
                .set入所通知発行日(new FlexibleDate(row.getNyushoTsuchiHakkoYMD()))
                .set退所通知発行日(new FlexibleDate(row.getTaishoTsuchiHakkoYMD()))
                .set変更通知発行日(new FlexibleDate(row.getHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set適用状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(new FlexibleDate(row.getTekiyoDate().getValue().toDateString()))
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getTekiyoJiyuCode())
                .set市町村コード(association.get地方公共団体コード())
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(new FlexibleDate(row.getTekiyoDate().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(FlexibleDate.EMPTY)
                .set解除届出年月日(FlexibleDate.EMPTY)
                .set解除受付年月日(FlexibleDate.EMPTY)
                .set入所通知発行日(FlexibleDate.EMPTY)
                .set退所通知発行日(FlexibleDate.EMPTY)
                .set変更通知発行日(FlexibleDate.EMPTY)
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set解除状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(new FlexibleDate(row.getKayijoDate().getValue().toDateString()))
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getKaijoJiyuCode())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(new FlexibleDate(row.getTekiyoDate().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(new FlexibleDate(row.getKayijoDate().getValue().toDateString()))
                .set解除届出年月日(new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString()))
                .set解除受付年月日(new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString()))
                .set入所通知発行日(new FlexibleDate(row.getNyushoTsuchiHakkoYMD()))
                .set退所通知発行日(new FlexibleDate(row.getTaishoTsuchiHakkoYMD()))
                .set変更通知発行日(new FlexibleDate(row.getHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private ShisetsuNyutaisho set適用状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            datagridTekiyoJogai_Row row) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return taisho.createBuilderForEdit()
                .set市町村コード(association.get地方公共団体コード())
                .set台帳種別(new RString("3"))
                .set入所施設種類(row.getShisetsuShurui())
                .set入所施設コード(new JigyoshaNo(row.getNyuShoShisetu()))
                .set入所処理年月日(new FlexibleDate(RDate.getNowDateTime().getDate().toDateString()))
                .set入所年月日(new FlexibleDate(row.getNyuShoDate().toString()))
                .set退所年月日(FlexibleDate.EMPTY)
                .set退所処理年月日(FlexibleDate.EMPTY)
                .set部屋記号番号(RString.EMPTY)
                .build();
    }

    private ShisetsuNyutaisho set解除状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            datagridTekiyoJogai_Row row) {
        return taisho.createBuilderForEdit()
                .set退所年月日(new FlexibleDate(row.getTaiShoDate().toString()))
                .set退所処理年月日(new FlexibleDate(RDate.getNowDateTime().getDate().toDateString()))
                .build();
    }

    private static class DateComparator implements Comparator<datagridTekiyoJogai_Row>, Serializable {

        @Override
        public int compare(datagridTekiyoJogai_Row o1, datagridTekiyoJogai_Row o2) {
            return o2.getTekiyoDate().getValue().compareTo(o1.getTekiyoDate().getValue());
        }
    }
}
