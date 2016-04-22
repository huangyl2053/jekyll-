/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TashichosonBusiness;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.definition.message.DbaQuestionMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu.HihokenshashikakusoshitsuManager;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 他住所地特例者管理のクラス。
 *
 * @reamsid_L DBA-0200-010 linghuhang
 */
public class TaJushochiTokureishaKanriHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 他特例解除 = new RString("01");
    private static final RString 転入 = new RString("01");
    private static final RString 除外者適用 = new RString("01");
    private static final CodeShubetsu 介護他特適用理由 = new CodeShubetsu("0118");
    private static final CodeShubetsu 介護他特解除理由 = new CodeShubetsu("0122");
    private static RString 変更後枝番 = new RString("0001");

    private static final RString 照会モード = new RString("Shokai");
    private static final RString 訂正モード = new RString("Teisei");
    private static final RString 適用モード = new RString("Tekiyo");
    private static final RString 解除モード = new RString("Kaijyo");
    private final TaJushochiTokureishaKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 証交付回収情報パネル
     */
    public TaJushochiTokureishaKanriHandler(TaJushochiTokureishaKanriDiv div) {
        this.div = div;
    }

    /**
     * 他住所地特例者管理に初期化を設定します。
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード) {
        div.getTajushochiTokureiInput().setHiddenInputShikibetsuCode(識別コード.getColumnValue());
        RString 親画面状態 = new RString(div.getMode_DisplayMode().toString());
        TaJushochiTokureisyaKanriMaster 最新適用情報 = null;
        List<TaJushochiTokureisyaKanriMaster> 適用情報
                = TaJushochiTokureisyaKanriManager.createInstance().getTaJushochiTokureiTekiyoJyoho(識別コード).records();
        if (適用情報 != null && !適用情報.isEmpty()) {
            TashichosonBusiness 住所地特例Model = TaJushochiTokureisyaKanriManager.createInstance().get他市町村住所地特例(識別コード);
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_他住所地特例, Models.create(住所地特例Model.get住所地特例List()));
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_保険施設入退所, Models.create(住所地特例Model.get施設入退所Lsit()));
            set一覧の設定(適用情報);
            最新適用情報 = 適用情報.get(0);
        } else {
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_他住所地特例, Models.create(new ArrayList()));
            ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_保険施設入退所, Models.create(new ArrayList()));
        }
        switch (div.getMode_DisplayMode()) {
            case Shokai:
                div.getDdlTekiyoJiyo().setDataSource(set適用事由());
                div.getDdlKaijyoJiyo().setDataSource(set解除事由());
                break;
            case Teisei:
                set他市町村住所地特例情報入力エリア非活性の設定();
                div.getDdlTekiyoJiyo().setDataSource(set適用事由());
                div.getDdlKaijyoJiyo().setDataSource(set解除事由());
                div.getBtnKakunin().setDisabled(true);
                div.getBtnTorikeshi().setDisabled(true);
                break;
            case Tekiyo:
                div.getDdlTekiyoJiyo().setDataSource(set適用事由());
                if (最新適用情報 != null) {
                    set他市町村住所地特例情報入力エリア(最新適用情報, 親画面状態);
                }
                ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
                div.getCcdShisetsuJoho().initialize();
                break;
            case Kaijyo:
                div.getDdlKaijyoJiyo().setDataSource(set解除事由());
                if (最新適用情報 != null) {
                    set他市町村住所地特例情報入力エリア(最新適用情報, 親画面状態);
                }
                break;
            case ShisetuHenko:
                break;
            default:
                break;
        }
    }

    /**
     * 「過去の履歴を追加する」ボタンを押下する場合、他市町村住所地特例情報入力エリア全項目をクリアします。
     */
    public void onClick_BtnAdd() {
        div.setStrate(状態_追加);
        set他市町村住所地特例情報入力エリア活性の設定();
        clear他市町村住所地特例情報入力エリア();
        div.getDdlTekiyoJiyo().setDataSource(set適用事由());
        div.getDdlKaijyoJiyo().setDataSource(set解除事由());
    }

    /**
     * 「選択」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     */
    public void onClick_Selsect() {
        set他市町村住所地特例情報入力エリア(div.getDgJushochiTokureiRireki().getActiveRow(), new RString(div.getMode_DisplayMode().toString()));
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     */
    public void onClick_Update() {
        div.setStrate(状態_修正);
        div.setSelectData(new RString(String.valueOf(div.getDgJushochiTokureiRireki().getClickedItem().getId())));
        set他市町村住所地特例情報入力エリア活性の設定();
        dgJushochiTokureiRireki_Row 選択データ = div.getDgJushochiTokureiRireki().getActiveRow();
        set他市町村住所地特例情報入力エリア(選択データ, new RString(div.getMode_DisplayMode().toString()));
        if (選択データ.getKaijoYMD().getValue() == null) {
            div.getTxtKaijyobi().setDisabled(true);
            div.getTxtKaijyoTodokedebi().setDisabled(true);
            div.getDdlKaijyoJiyo().setDisabled(true);
        }
    }

    /**
     * 「削除」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     */
    public void onClick_Delete() {
        div.setStrate(状態_削除);
        set他市町村住所地特例情報入力エリア非活性の設定();
        div.getBtnKakunin().setDisabled(false);
        div.getBtnTorikeshi().setDisabled(false);
        set他市町村住所地特例情報入力エリア(div.getDgJushochiTokureiRireki().getActiveRow(), new RString(div.getMode_DisplayMode().toString()));
    }

    /**
     * 最新適用情報の解除日がある場合、非活性で表示します。
     *
     * @param 親画面状態 親画面状態
     */
    public void onClick_onBlur(RString 親画面状態) {
        if (適用モード.equals(親画面状態) && div.getTxtNyusyobi().getValue() != null) {
            if (div.getTxtTekiyobi().getValue() == null) {
                div.getTxtTekiyobi().setValue(new RDate(div.getTxtNyusyobi().getValue().toString()));
            }
            if (div.getTxtTekiyoTodokedebi().getValue() == null) {
                div.getTxtTekiyoTodokedebi().setValue(new RDate(div.getTxtNyusyobi().getValue().toString()));
            }
        } else if (解除モード.equals(親画面状態) && div.getTxtTasyobi().getValue() != null) {
            if (div.getTxtKaijyobi().getValue() == null) {
                div.getTxtKaijyobi().setValue(new RDate(div.getTxtTasyobi().getValue().toString()));
            }
            if (div.getTxtKaijyoTodokedebi().getValue() == null) {
                div.getTxtKaijyoTodokedebi().setValue(new RDate(div.getTxtTasyobi().getValue().toString()));
            }
        }
    }

    /**
     * 「取消する」ボタンを押下する場合、入力の内容をクリアします。
     */
    public void onClick_Torikeshi() {
        clear他市町村住所地特例情報入力エリア();
    }

    /**
     * 修正対象のデータから変更します。
     *
     * @return 修正対象のデータから変更結果 true/変更、false/変更しない。
     */
    public boolean isデータ変更() {
        dgJushochiTokureiRireki_Row 選択データ
                = div.getDgJushochiTokureiRireki().getDataSource().get(Integer.parseInt(div.getSelectData().toString()));
        if ((選択データ.getKaijoYMD().getValue() == null && div.getTxtKaijyobi().getValue() != null)
                || ((選択データ.getSochiHihokenshaNo() == null
                || 選択データ.getSochiHihokenshaNo().isEmpty()) && div.getTxtHihoNo().getValue() != null)) {
            return true;
        }
        return !選択データ.getTekiyoYMD().getValue().equals(div.getTxtTekiyobi().getValue())
                || !選択データ.getTekiyoTodokedeYMD().getValue().equals(div.getTxtTekiyoTodokedebi().getValue())
                || !選択データ.getTekiyoJiyuCode().equals(div.getDdlTekiyoJiyo().getSelectedValue())
                || !選択データ.getKaijoYMD().getValue().equals(div.getTxtKaijyobi().getValue())
                || !選択データ.getKaijoTodokedeYMD().getValue().equals(div.getTxtKaijyoTodokedebi().getValue())
                || !選択データ.getKaijoJiyuCode().equals(div.getDdlKaijyoJiyo().getSelectedValue())
                || !選択データ.getSochiHihokenshaNo().equals(div.getTxtHihoNo().getValue());
    }

    private RString get変更後枝番(boolean is解除日, dgJushochiTokureiRireki_Row row, List<dgJushochiTokureiRireki_Row> rowList, RString 変更後適用日) {
        if (is解除日) {
            for (dgJushochiTokureiRireki_Row rireki_Row : rowList) {
                if (変更後適用日.equals(rireki_Row.getHenkouzenTekiyoYMD())) {
                    変更後枝番 = new RString(Integer.parseInt(rireki_Row.getHenkouzenEdaNo().toString()) + 1).padZeroToLeft(4);
                } else {
                    変更後枝番 = new RString(Integer.parseInt(row.getHenkouzenEdaNo().toString()) + 1).padZeroToLeft(4);
                }
            }
        }
        return 変更後枝番;
    }

    /**
     * 「異動内容を確認する」ボタンを押下する場合、入力の内容を最新の適用情報に反映します。
     *
     * @param rireki_Row 選択データ
     * @param 親画面状態 親画面状態
     */
    public void onClick_BtnKakunin(dgJushochiTokureiRireki_Row rireki_Row, RString 親画面状態) {
        Models<TashichosonJushochiTokureiIdentifier, TashichosonJushochiTokurei> 他住所地特例Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_他住所地特例, Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_保険施設入退所, Models.class);

        List<dgJushochiTokureiRireki_Row> rowList = div.getDgJushochiTokureiRireki().getDataSource();
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTajushochiTokureiInput().getHiddenInputShikibetsuCode());
        FlexibleDate 異動日 = new FlexibleDate(div.getTajushochiTokureiInput().getHiddenInputIdoYMD());
        if (rowList == null || rowList.isEmpty()) {
            rowList = new ArrayList();
        }
        boolean is解除日 = false;
        if (状態_修正.equals(div.getStrate())) {
            RString 変更後解除日 = div.getTxtKaijyobi().getValue().toDateString();
            RString 変更後適用日 = div.getTxtTekiyobi().getValue().toDateString();
            変更後枝番 = get変更後枝番(is解除日, null, rowList, 変更後適用日);
            for (dgJushochiTokureiRireki_Row row : rowList) {
                if (変更後解除日.equals(row.getHenkouzenIdoYMD())) {
                    is解除日 = true;
                    変更後枝番 = get変更後枝番(is解除日, row, rowList, 変更後適用日);
                    break;
                }
            }
        }

        if ((訂正モード.equals(親画面状態))) {
            if (状態_追加.equals(div.getStrate())) {
                rireki_Row = new dgJushochiTokureiRireki_Row();
            }
            if (状態_修正.equals(div.getStrate())) {
                rireki_Row.getTekiyoYMD().setValue(new RDate(div.getTxtTekiyobi().getValue().toString()));
                rireki_Row.getTekiyoTodokedeYMD().setValue(new RDate(div.getTxtTekiyoTodokedebi().getValue().toString()));
                rireki_Row.setTekiyoJiyuCode(div.getDdlTekiyoJiyo().getSelectedValue());
                rireki_Row.setTekiyoJiyu(div.getDdlTekiyoJiyo().getSelectedKey());
                rireki_Row.getKaijoYMD().setValue(new RDate(div.getTxtKaijyobi().getValue().toString()));
                rireki_Row.getKaijoTodokedeYMD().setValue(new RDate(div.getTxtKaijyoTodokedebi().getValue().toString()));
                rireki_Row.setKaijoJiyuCode(div.getDdlKaijyoJiyo().getSelectedValue());
                rireki_Row.setKaijoJiyu(div.getDdlKaijyoJiyo().getSelectedKey());
                rireki_Row.setSochiHihokenshaNo(div.getTxtHihoNo().getValue());
                if (div.getCcdHokensha().getHokenjaName() != null) {
                    rireki_Row.setSochiHokenshaNo(div.getCcdHokensha().getHokenjaName());
                }
                if (div.getCcdHokensha().getHokenjaNo() != null) {
                    rireki_Row.setSochiHokensha(div.getCcdHokensha().getHokenjaNo());
                }
                rireki_Row.setIdoYMD(div.getTxtKaijyobi().getValue().toDateString());
                rireki_Row.setHenkouzenEdaNo(変更後枝番);
                if (RowState.Unchanged.equals(rireki_Row.getRowState())) {
                    rireki_Row.setRowState(RowState.Modified);
                }

                TashichosonJushochiTokurei 住所地特例の識別子
                        = new TashichosonJushochiTokurei(識別コード,
                                new FlexibleDate(div.getTxtKaijyobi().getValue().toDateString()), 変更後枝番);
                他住所地特例Model.add(住所地特例の識別子);
            }
            if (状態_削除.equals(div.getStrate())) {
                if (RowState.Unchanged.equals(rireki_Row.getRowState())) {
                    rireki_Row.setRowState(RowState.Deleted);
                    TashichosonJushochiTokurei 住所地特例の識別子
                            = new TashichosonJushochiTokurei(識別コード, 異動日, rireki_Row.getEdaNo());
                    他住所地特例Model.add(住所地特例の識別子);
                } else {
                    rowList.remove(rireki_Row);
                }
            }
            if (状態_追加.equals(div.getStrate())) {
                rireki_Row.setRowState(RowState.Added);
                rireki_Row.setShikibetsuCode(識別コード.getColumnValue());
                rireki_Row.setIdoYMD(div.getTajushochiTokureiInput().getHiddenInputIdoYMD());
                rireki_Row.setEdaNo(変更後枝番);
                rireki_Row.getTekiyoYMD().setValue(new RDate(div.getTxtTekiyobi().getValue().toString()));
                if (div.getTxtTekiyoTodokedebi().getValue() != null) {
                    rireki_Row.getTekiyoTodokedeYMD().setValue(new RDate(div.getTxtTekiyoTodokedebi().getValue().toString()));
                }
                rireki_Row.setTekiyoJiyuCode(div.getDdlTekiyoJiyo().getSelectedValue());
                rireki_Row.setTekiyoJiyu(div.getDdlTekiyoJiyo().getSelectedKey());
                rireki_Row.getKaijoYMD().setValue(new RDate(div.getTxtKaijyobi().getValue().toString()));
                if (div.getTxtKaijyoTodokedebi().getValue() != null) {
                    rireki_Row.getKaijoTodokedeYMD().setValue(new RDate(div.getTxtKaijyoTodokedebi().getValue().toString()));
                }
                rireki_Row.setKaijoJiyuCode(div.getDdlKaijyoJiyo().getSelectedValue());
                rireki_Row.setKaijoJiyu(div.getDdlKaijyoJiyo().getSelectedKey());
                rireki_Row.setSochiHihokenshaNo(div.getTxtHihoNo().getValue());
                if (div.getCcdHokensha().getHokenjaNo() != null) {
                    rireki_Row.setSochiHokensha(div.getCcdHokensha().getHokenjaNo());
                }
                if (div.getCcdHokensha().getHokenjaName() != null) {
                    rireki_Row.setSochiHokenshaNo(div.getCcdHokensha().getHokenjaName());
                }
                rowList.add(rireki_Row);
                TashichosonJushochiTokurei 住所地特例の識別子
                        = new TashichosonJushochiTokurei(識別コード, new FlexibleDate(div.getTxtKaijyobi().getValue().toString()), 変更後枝番);
                他住所地特例Model.add(住所地特例の識別子);
            }
            Collections.sort(rowList, new DateComparator());
        } else if (適用モード.equals(親画面状態)) {
            Collections.sort(rowList, new DateComparatorRirekiNo());
            dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row();
            if (div.getTxtNyusyobi().getValue() != null) {
                row.getNyushoYMD().setValue(new RDate(div.getTxtNyusyobi().getValue().toString()));
            }
            if (div.getTxtTekiyobi().getValue() != null) {
                row.getTekiyoYMD().setValue(new RDate(div.getTxtTekiyobi().getValue().toString()));
            }
            if (div.getTxtTekiyoTodokedebi().getValue() != null) {
                row.getTekiyoTodokedeYMD().setValue(new RDate(div.getTxtTekiyoTodokedebi().getValue().toString()));
            }
            if (div.getDdlTekiyoJiyo().getSelectedKey() != null) {
                row.setTekiyoJiyu(div.getDdlTekiyoJiyo().getSelectedKey());
                row.setTekiyoJiyuCode(div.getDdlTekiyoJiyo().getSelectedValue());
            } else {
                row.setTekiyoJiyuCode(RString.EMPTY);
            }
            if (div.getTxtHihoNo().getValue() != null) {
                row.setSochiHihokenshaNo(div.getTxtHihoNo().getValue());
            }
            if (div.getCcdHokensha().getHokenjaNo() != null) {
                row.setSochiHokensha(div.getCcdHokensha().getHokenjaNo());
            }
            if (div.getCcdHokensha().getHokenjaName() != null) {
                row.setSochiHokenshaNo(div.getCcdHokensha().getHokenjaName());
            }
            if (div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo() != null) {
                row.setNyushoShisetsu(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            }
            if (div.getCcdShisetsuJoho().getNyuryokuShisetsuMeisho() != null) {
                row.setNyushoShisetsuCode(div.getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            }
            row.setNyushoShisetsuShurui(div.getCcdShisetsuJoho().get施設種類());
            RString 履歴番号 = rowList.get(0).getRirekiNo();
            if (RString.isNullOrEmpty(履歴番号)) {
                履歴番号 = new RString("0");
            }
            int 最新履歴番号 = Integer.parseInt(履歴番号.toString()) + 1;
            rowList.add(row);
            ShisetsuNyutaisho taisho = new ShisetsuNyutaisho(識別コード, 最新履歴番号);
            TashichosonJushochiTokurei 住所地特例の識別子
                    = new TashichosonJushochiTokurei(識別コード, new FlexibleDate(div.getTxtTekiyobi().getValue().toString()), 変更後枝番);
            他住所地特例Model.add(住所地特例の識別子);
            保険施設入退所Model.add(taisho);
            div.getPanShisetsuJoho().setDisabled(true);
            div.getCcdShisetsuJoho().clear();
            div.getCcdShisetsuJoho().initialize();
            Collections.sort(rowList, new DateComparator());
        } else if (解除モード.equals(親画面状態)) {
            dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row();
            if (div.getDgJushochiTokureiRireki().getDataSource() != null
                    && !div.getDgJushochiTokureiRireki().getDataSource().isEmpty()) {
                row = div.getDgJushochiTokureiRireki().getDataSource().get(0);
            }
            if (div.getTxtTasyobi().getValue() != null) {
                row.getTaishoYMD().setValue(new RDate(div.getTxtTasyobi().getValue().toString()));
            }
            if (div.getTxtKaijyobi().getValue() != null) {
                row.getKaijoYMD().setValue(new RDate(div.getTxtKaijyobi().getValue().toString()));
            }
            if (div.getTxtKaijyoTodokedebi().getValue() != null) {
                row.getKaijoTodokedeYMD().setValue(new RDate(div.getTxtKaijyoTodokedebi().getValue().toString()));
            }
            if (div.getDdlKaijyoJiyo().getSelectedKey() != null
                    && !div.getDdlKaijyoJiyo().getSelectedKey().isEmpty()) {
                row.setKaijoJiyu(div.getDdlKaijyoJiyo().getSelectedKey());
                row.setKaijoJiyuCode(div.getDdlKaijyoJiyo().getSelectedValue());
            } else {
                row.setKaijoJiyuCode(RString.EMPTY);
            }
            RString 変更前枝番 = row.getEdaNo();
            変更後枝番 = new RString(Integer.parseInt(変更前枝番.toString()) + 1).padZeroToLeft(4);
            row.setHenkouzenEdaNo(変更後枝番);
            TashichosonJushochiTokurei 住所地特例の識別子
                    = new TashichosonJushochiTokurei(識別コード, new FlexibleDate(div.getTxtKaijyobi().getValue().toString()), 変更後枝番);
            他住所地特例Model.add(住所地特例の識別子);
            div.getTxtTasyobi().clearValue();
            div.getTxtKaijyobi().clearValue();
            div.getTxtKaijyoTodokedebi().clearValue();
            div.getDdlKaijyoJiyo().setSelectedKey(RString.EMPTY);
        }
        div.setStrate(RString.EMPTY);
        div.getDgJushochiTokureiRireki().setDataSource(rowList);
        set他市町村住所地特例情報入力エリア非活性の設定();
        clear他市町村住所地特例情報入力エリア();
        div.getBtnKakunin().setDisabled(true);
        div.getBtnTorikeshi().setDisabled(true);
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_他住所地特例, 他住所地特例Model);
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_保険施設入退所, 保険施設入退所Model);
    }

    /**
     * 他住所地特例者の共有子DIVの画面内容から、他市町村住所地特例情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    public void saveTaJushochiTokurei(ShikibetsuCode 識別コード) {
        List<dgJushochiTokureiRireki_Row> rowList = div.getDgJushochiTokureiRireki().getDataSource();
        Models<TashichosonJushochiTokureiIdentifier, TashichosonJushochiTokurei> 他住所地特例Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_他住所地特例, Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys.他住所地特例者管理_保険施設入退所, Models.class);
        for (dgJushochiTokureiRireki_Row row : rowList) {
            FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
            if (訂正モード.equals(new RString(div.getMode_DisplayMode().toString()))
                    && (row.getRowState() == null || RowState.Unchanged.equals(row.getRowState()))) {
                continue;
            }
            if (RowState.Added.equals(row.getRowState())) {
                TashichosonJushochiTokureiIdentifier 住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, new FlexibleDate(row.getKaijoYMD().getValue().toString()), 変更後枝番);
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set他住所地特例(他住所地特例Model.get(住所地特例の識別子), row).toEntity());
            } else if (RowState.Modified.equals(row.getRowState())) {
                TashichosonJushochiTokureiIdentifier 更新前住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, new FlexibleDate(row.getHenkouzenIdoYMD()), row.getEdaNo());
                TaJushochiTokureisyaKanriManager.createInstance().delTaJushochiTokurei(他住所地特例Model.get(更新前住所地特例の識別子).
                        createBuilderForEdit().set論理削除フラグ(true).build().toEntity());
                TashichosonJushochiTokureiIdentifier 住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, 異動日, row.getHenkouzenEdaNo());
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set修正状態他住所地特例(他住所地特例Model.get(住所地特例の識別子),
                        他住所地特例Model.get(更新前住所地特例の識別子), row).toEntity());
            } else if (適用モード.equals(new RString(div.getMode_DisplayMode().toString()))) {
                RString 画面喪失 = HihokenshashikakusoshitsuManager.createInstance().shikakuSoshitsuCheck(識別コード, HihokenshaNo.EMPTY);
                FlexibleDate 適用異動日;
                dgJushochiTokureiRireki_Row 適用情報;
                if (RString.isNullOrEmpty(画面喪失) && !rowList.isEmpty()) {
                    TaJushochiTokureisyaKanriManager.createInstance().saveHihokenshaSositu(
                            new KaigoTatokuTekiyoJiyu(rowList.get(0).getTekiyoJiyu()),
                            new FlexibleDate(rowList.get(0).getTekiyoYMD().getValue().toString()),
                            new FlexibleDate(rowList.get(0).getTekiyoTodokedeYMD().getValue().toString()),
                            識別コード);
                    適用異動日 = new FlexibleDate(rowList.get(0).getTekiyoYMD().getValue().toString());
                    適用情報 = rowList.get(0);
                } else {
                    throw new ApplicationException(DbaErrorMessages.住所地特例として未適用.getMessage());
                }
                TashichosonJushochiTokureiIdentifier 住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, 適用異動日, 変更後枝番);
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set適用状態他住所地特例(他住所地特例Model.get(住所地特例の識別子), 適用情報).toEntity());
                Collections.sort(rowList, new DateComparatorRirekiNo());
                RString 履歴番号 = rowList.get(0).getRirekiNo();
                int 最新履歴番号 = Integer.parseInt(履歴番号.toString()) + 1;
                ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(識別コード, 最新履歴番号);
                TaJushochiTokureisyaKanriManager.createInstance().regShisetsuNyutaisho(set適用状態介護保険施設入退所(保険施設入退所Model.get(taisho), 適用情報).toEntity());
                Collections.sort(rowList, new DateComparator());
                break;
            } else if (解除モード.equals(new RString(div.getMode_DisplayMode().toString()))) {
                TashichosonJushochiTokureiIdentifier 更新前住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, new FlexibleDate(row.getIdoYMD().toString()), row.getEdaNo());
                TaJushochiTokureisyaKanriManager.createInstance().delTaJushochiTokurei(他住所地特例Model.get(更新前住所地特例の識別子).
                        createBuilderForEdit().set論理削除フラグ(true).build().toEntity());
                TashichosonJushochiTokureiIdentifier 住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, new FlexibleDate(row.getKaijoYMD().getValue().toString()), row.getHenkouzenEdaNo());
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set解除状態他住所地特例(他住所地特例Model.get(住所地特例の識別子),
                        他住所地特例Model.get(更新前住所地特例の識別子), row).toEntity());
                ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                TaJushochiTokureisyaKanriManager.createInstance().updShisetsuNyutaisho(set解除状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity());
                if (他特例解除.equals(row.getKaijoJiyu())) {
                    if (!TaJushochiTokureisyaKanriManager.createInstance().checkAge(識別コード, new FlexibleDate(row.getKaijoYMD().getValue().toString()))) {
                        if (new RString(DbaQuestionMessages.資格取得確認.getMessage().getCode())
                                .equals(ResponseHolder.getMessageCode())
                                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                            TaJushochiTokureisyaKanriManager.createInstance().saveHihokenshaShutoku(
                                    new KaigoTatokuKaijoJiyu(row.getKaijoJiyu()),
                                    new FlexibleDate(row.getKaijoYMD().getValue().toString()),
                                    new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toString()),
                                    識別コード);
                        }
                    } else {
                        TaJushochiTokureisyaKanriManager.createInstance().saveHihokenshaShutoku(
                                new KaigoTatokuKaijoJiyu(row.getKaijoJiyu()),
                                new FlexibleDate(row.getKaijoYMD().getValue().toString()),
                                new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toString()),
                                識別コード);
                    }
                    break;
                }
            } else if (RowState.Deleted.equals(row.getRowState())) {
                TashichosonJushochiTokureiIdentifier 住所地特例の識別子
                        = new TashichosonJushochiTokureiIdentifier(識別コード, 異動日, row.getEdaNo());
                TaJushochiTokureisyaKanriManager.createInstance().delTaJushochiTokurei(他住所地特例Model.get(住所地特例の識別子).
                        createBuilderForEdit().set論理削除フラグ(true).build().toEntity());
            }
        }
    }

    /**
     * 適用情報一覧を取得します。
     *
     * @return 適用情報一覧 適用情報一覧
     */
    public List<dgJushochiTokureiRireki_Row> get適用情報一覧() {
        return div.getDgJushochiTokureiRireki().getDataSource();
    }

    private void set一覧の設定(List<TaJushochiTokureisyaKanriMaster> 適用情報List) {
        List<dgJushochiTokureiRireki_Row> rowList = new ArrayList<>();
        for (TaJushochiTokureisyaKanriMaster master : 適用情報List) {
            dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row();
            row.setShikibetsuCode(master.getShikibetsuCode().getColumnValue());
            row.setIdoYMD(new RString(master.getIdoYMD().toString()));
            row.setEdaNo(nullTOEmpty(master.getEdaNo()));
            if (master.getTekiyoYMD() != null && !master.getTekiyoYMD().isEmpty()) {
                row.getTekiyoYMD().setValue(new RDate(master.getTekiyoYMD().toString()));
                row.setHenkouzenTekiyoYMD(new RString(master.getTekiyoYMD().toString()));
            } else {
                row.getTekiyoYMD().clearValue();
            }
            if (master.getTekiyoTodokedeYMD() != null && !master.getTekiyoTodokedeYMD().isEmpty()) {
                row.getTekiyoTodokedeYMD().setValue(new RDate(master.getTekiyoTodokedeYMD().toString()));
            } else {
                row.getTekiyoTodokedeYMD().clearValue();
            }
            row.setTekiyoJiyuCode(get適用事由(master.getTekiyoJiyuCode()));
            if (master.getKaijoYMD() != null && !master.getKaijoYMD().isEmpty()) {
                row.getKaijoYMD().setValue(new RDate(master.getKaijoYMD().toString()));
            } else {
                row.getKaijoYMD().clearValue();
            }
            if (master.getKaijoTodokedeYMD() != null && !master.getKaijoTodokedeYMD().isEmpty()) {
                row.getKaijoTodokedeYMD().setValue(new RDate(master.getKaijoTodokedeYMD().toString()));
            } else {
                row.getKaijoTodokedeYMD().clearValue();
            }
            row.setKaijoJiyuCode(get解除事由(master.getKaijoJiyuCode()));
            row.setRirekiNo(new RString(nullTOZero(master.getRirekiNo()).toString()));
            if (master.getNyushoYMD() != null && !master.getNyushoYMD().isEmpty()) {
                row.getNyushoYMD().setValue(new RDate(master.getNyushoYMD().toString()));
            } else {
                row.getNyushoYMD().clearValue();
            }
            if (master.getTaishoYMD() != null && !master.getTaishoYMD().isEmpty()) {
                row.getTaishoYMD().setValue(new RDate(master.getTaishoYMD().toString()));
            } else {
                row.getTaishoYMD().clearValue();
            }
            row.setNyushoShisetsuShurui(master.getNyushoShisetsuShurui());
            row.setNyushoShisetsuCode(nullTOEmpty(master.getJigyoshaName()).getColumnValue());
            row.setSochiHokenshaNo(nullTOEmpty(master.getHokenjaName()));
            row.setSochiHihokenshaNo(nullTOEmpty(master.getSochiHihokenshaNo().getColumnValue()));
            row.setTekiyoJiyu(master.getTekiyoJiyuCode());
            row.setKaijoJiyu(master.getKaijoJiyuCode());
            row.setShichosonCode(master.getShichosonCode().getColumnValue());
            row.setSochiHokensha(master.getSochiHokenshaNo().getColumnValue());
            row.setTatokuRenrakuhyoHakkoYMD(new RString(master.getTatokuRenrakuhyoHakkoYMD().toString()));
            row.setShisetsuTaishoTsuchiHakkoYMD(new RString(master.getShisetsuTaishoTsuchiHakkoYMD().toString()));
            row.setShisetsuHenkoTsuchiHakkoYMD(new RString(master.getShisetsuHenkoTsuchiHakkoYMD().toString()));
            row.setNyushoShisetsu(nullTOEmpty(master.getNyushoShisetsuCode()).getColumnValue());
            row.setIdoJiyuCode(nullTOEmpty(master.getIdoJiyuCode()));
            row.setTekiyoUketsukeYMD(new RString(master.getTekiyoUketsukeYMD().toString()));
            row.setHenkouzenIdoYMD(new RString(master.getIdoYMD().toString()));
            row.setHenkouzenEdaNo(nullTOEmpty(master.getEdaNo()));
            rowList.add(row);
        }
        div.getDgJushochiTokureiRireki().setDataSource(rowList);
    }

    private void set他市町村住所地特例情報入力エリア(
            dgJushochiTokureiRireki_Row kanriMaster,
            RString 親画面状態) {
        if (照会モード.equals(親画面状態) || 訂正モード.equals(親画面状態)) {
            if (kanriMaster.getTekiyoYMD().getValue() != null) {
                div.getTxtTekiyobi().setValue(new RDate(kanriMaster.getTekiyoYMD().getValue().toString()));
            } else {
                div.getTxtTekiyobi().clearValue();
            }
            if (kanriMaster.getTekiyoTodokedeYMD().getValue() != null) {
                div.getTxtTekiyoTodokedebi().setValue(new RDate(kanriMaster.getTekiyoTodokedeYMD().getValue().toString()));
            } else {
                div.getTxtTekiyoTodokedebi().clearValue();
            }
            選択適用事由(kanriMaster.getTekiyoJiyu());
            if (kanriMaster.getKaijoYMD().getValue() != null) {
                div.getTxtKaijyobi().setValue(new RDate(kanriMaster.getKaijoYMD().getValue().toString()));
            } else {
                div.getTxtKaijyobi().clearValue();
            }
            if (kanriMaster.getKaijoTodokedeYMD().getValue() != null) {
                div.getTxtKaijyoTodokedebi().setValue(new RDate(kanriMaster.getKaijoTodokedeYMD().getValue().toString()));
            } else {
                div.getTxtKaijyoTodokedebi().clearValue();
            }
            選択解除事由(kanriMaster.getKaijoJiyu());
            div.getTajushochiTokureiInput().setHiddenInputShikibetsuCode(kanriMaster.getShikibetsuCode());
            div.getTajushochiTokureiInput().setHiddenInputIdoYMD(kanriMaster.getIdoYMD());
            div.getTajushochiTokureiInput().setHiddenInputEdaNo(kanriMaster.getEdaNo());
            div.getTxtHihoNo().setValue(kanriMaster.getSochiHihokenshaNo());
            div.getCcdHokensha().setHokenjaNo(kanriMaster.getSochiHokensha());
            if (!RString.isNullOrEmpty(kanriMaster.getSochiHokenshaNo())) {
                div.getCcdHokensha().setHokenjaName(kanriMaster.getSochiHokenshaNo());
            }
        }
    }

    private void set他市町村住所地特例情報入力エリア(
            TaJushochiTokureisyaKanriMaster kanriMaster,
            RString 親画面状態) {
        if (適用モード.equals(親画面状態)) {
            UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
            if (宛名情報 != null) {
                宛名情報の処理(宛名情報);
            }
            if (kanriMaster.getKaijoYMD() == null
                    || kanriMaster.getKaijoYMD().isEmpty()) {
                div.getTxtNyusyobi().setDisabled(true);
                div.getTxtTekiyobi().setDisabled(true);
                div.getTxtTekiyoTodokedebi().setDisabled(true);
                div.getDdlTekiyoJiyo().setDisabled(true);
                div.getTxtHihoNo().setDisabled(true);
                div.getPanShisetsuJoho().setDisabled(true);
                div.getPanSotimotoJyoho().setDisabled(true);
                div.getBtnKakunin().setDisabled(true);
            }
        } else if (解除モード.equals(親画面状態)) {
            if (kanriMaster.getTaishoYMD() != null && !kanriMaster.getTaishoYMD().isEmpty()) {
                div.getTxtTasyobi().setValue(new RDate(kanriMaster.getTaishoYMD().toString()));
            }
            if (kanriMaster.getKaijoTodokedeYMD() != null && !kanriMaster.getKaijoTodokedeYMD().isEmpty()) {
                div.getTxtKaijyoTodokedebi().setValue(new RDate(kanriMaster.getKaijoTodokedeYMD().toString()));
            }
            選択解除事由(kanriMaster.getKaijoJiyuCode());
            if (kanriMaster.getKaijoYMD() != null
                    && !kanriMaster.getKaijoYMD().isEmpty()) {
                div.getTxtTasyobi().setDisabled(true);
                div.getTxtKaijyobi().setDisabled(true);
                div.getTxtKaijyoTodokedebi().setDisabled(true);
                div.getDdlKaijyoJiyo().setDisabled(true);
                div.getBtnKakunin().setDisabled(true);
                div.getTxtKaijyobi().setValue(new RDate(kanriMaster.getKaijoYMD().toString()));
            }
        }
    }

    private void 宛名情報の処理(UaFt200FindShikibetsuTaishoEntity 宛名情報) {
        if (転入.equals(宛名情報.getIdoJiyuCode())) {
            FlexibleDate 異動日 = 宛名情報.getIdoYMD();
            FlexibleDate 届出日 = 宛名情報.getTodokedeYMD();
            if (異動日 != null && !異動日.isEmpty()) {
                div.getTxtTekiyobi().setValue(new RDate(異動日.toString()));
            }
            if (届出日 != null && !届出日.isEmpty()) {
                div.getTxtTekiyoTodokedebi().setValue(new RDate(届出日.toString()));
            }
            div.getDdlTekiyoJiyo().setSelectedKey(除外者適用);
        }
    }

    private TashichosonJushochiTokurei set他住所地特例(
            TashichosonJushochiTokurei tokurei,
            dgJushochiTokureiRireki_Row row) {
        RString 異動事由コード;
        if (row.getKaijoYMD().getValue() == null) {
            異動事由コード = row.getTekiyoJiyu();
        } else {
            異動事由コード = row.getKaijoJiyu();
        }
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
        return tokurei.createBuilderForEdit()
                .set異動事由コード(異動事由コード)
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set他市町村住所地特例適用事由コード(row.getTekiyoJiyu())
                .set適用年月日(new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set他市町村住所地特例解除事由コード(row.getKaijoJiyu())
                .set解除年月日(new FlexibleDate(row.getKaijoYMD().getValue().toDateString()))
                .set解除届出年月日(new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toDateString()))
                .set解除受付年月日(new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toDateString()))
                .set措置保険者番号(new ShoKisaiHokenshaNo(row.getSochiHokensha()))
                .set措置被保険者番号(new HihokenshaNo(row.getSochiHihokenshaNo()))
                .set論理削除フラグ(false)
                .build();
    }

    private TashichosonJushochiTokurei set適用状態他住所地特例(
            TashichosonJushochiTokurei tokurei,
            dgJushochiTokureiRireki_Row row) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
        return tokurei.createBuilderForEdit()
                .set異動事由コード(row.getTekiyoJiyu())
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set他市町村住所地特例適用事由コード(row.getTekiyoJiyu())
                .set適用年月日(new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set措置保険者番号(new ShoKisaiHokenshaNo(row.getSochiHokensha()))
                .set措置被保険者番号(new HihokenshaNo(row.getSochiHihokenshaNo()))
                .set論理削除フラグ(false)
                .build();
    }

    private TashichosonJushochiTokurei set修正状態他住所地特例(
            TashichosonJushochiTokurei tokurei,
            TashichosonJushochiTokurei 更新前データ,
            dgJushochiTokureiRireki_Row row) {
        return tokurei.createBuilderForEdit()
                .set異動事由コード(row.getTekiyoJiyu())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set他市町村住所地特例適用事由コード(row.getTekiyoJiyu())
                .set適用年月日(new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set適用受付年月日(更新前データ.get適用受付年月日())
                .set他市町村住所地特例解除事由コード(row.getKaijoJiyu())
                .set解除年月日(new FlexibleDate(row.getKaijoYMD().getValue().toDateString()))
                .set解除届出年月日(new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toDateString()))
                .set解除受付年月日(new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toDateString()))
                .set措置保険者番号(new ShoKisaiHokenshaNo(row.getSochiHokensha()))
                .set措置被保険者番号(new HihokenshaNo(row.getSochiHihokenshaNo()))
                .set他特例連絡票発行年月日(更新前データ.get他特例連絡票発行年月日())
                .set施設退所通知発行年月日(更新前データ.get施設退所通知発行年月日())
                .set施設変更通知発行年月日(更新前データ.get施設変更通知発行年月日())
                .set論理削除フラグ(false)
                .build();
    }

    private TashichosonJushochiTokurei set解除状態他住所地特例(
            TashichosonJushochiTokurei tokurei,
            TashichosonJushochiTokurei 更新前データ,
            dgJushochiTokureiRireki_Row row) {
        return tokurei.createBuilderForEdit()
                .set異動事由コード(row.getKaijoJiyu())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set他市町村住所地特例適用事由コード(row.getTekiyoJiyu())
                .set適用年月日(new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set適用受付年月日(更新前データ.get適用受付年月日())
                .set他市町村住所地特例解除事由コード(row.getKaijoJiyu())
                .set解除年月日(new FlexibleDate(row.getKaijoYMD().getValue().toDateString()))
                .set解除届出年月日(new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toDateString()))
                .set解除受付年月日(new FlexibleDate(row.getKaijoTodokedeYMD().getValue().toDateString()))
                .set措置保険者番号(new ShoKisaiHokenshaNo(row.getSochiHokensha()))
                .set措置被保険者番号(new HihokenshaNo(row.getSochiHihokenshaNo()))
                .set他特例連絡票発行年月日(更新前データ.get他特例連絡票発行年月日())
                .set施設退所通知発行年月日(更新前データ.get施設退所通知発行年月日())
                .set施設変更通知発行年月日(更新前データ.get施設変更通知発行年月日())
                .set論理削除フラグ(false)
                .build();
    }

    private ShisetsuNyutaisho set適用状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            dgJushochiTokureiRireki_Row row) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報();
        return taisho.createBuilderForEdit()
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set台帳種別(new RString("2"))
                .set入所施設種類(row.getNyushoShisetsuShurui())
                .set入所施設コード(new JigyoshaNo(row.getNyushoShisetsu()))
                .set入所処理年月日(new FlexibleDate(RDate.getNowDateTime().getDate().toDateString()))
                .set入所年月日(new FlexibleDate(row.getNyushoYMD().getValue().toString()))
                .build();
    }

    private ShisetsuNyutaisho set解除状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            dgJushochiTokureiRireki_Row row) {
        return taisho.createBuilderForEdit()
                .set退所年月日(new FlexibleDate(row.getTaishoYMD().getValue().toString()))
                .set退所処理年月日(new FlexibleDate(RDate.getNowDateTime().getDate().toDateString()))
                .build();
    }

    private void set他市町村住所地特例情報入力エリア非活性の設定() {
        div.getTxtTasyobi().setDisabled(true);
        div.getTxtNyusyobi().setDisabled(true);
        div.getTxtTekiyobi().setDisabled(true);
        div.getTxtTekiyoTodokedebi().setDisabled(true);
        div.getDdlTekiyoJiyo().setDisabled(true);
        div.getTxtKaijyobi().setDisabled(true);
        div.getTxtKaijyoTodokedebi().setDisabled(true);
        div.getDdlKaijyoJiyo().setDisabled(true);
        div.getTxtHihoNo().setDisabled(true);
        div.getPanSotimotoJyoho().setDisabled(true);
    }

    private void set他市町村住所地特例情報入力エリア活性の設定() {
        div.getTxtTekiyobi().setDisabled(false);
        div.getTxtTekiyoTodokedebi().setDisabled(false);
        div.getDdlTekiyoJiyo().setDisabled(false);
        div.getTxtKaijyobi().setDisabled(false);
        div.getTxtKaijyoTodokedebi().setDisabled(false);
        div.getDdlKaijyoJiyo().setDisabled(false);
        div.getTxtHihoNo().setDisabled(false);
        div.getPanSotimotoJyoho().setDisabled(false);
        div.getBtnKakunin().setDisabled(false);
        div.getBtnTorikeshi().setDisabled(false);
    }

    private void clear他市町村住所地特例情報入力エリア() {
        div.getTxtNyusyobi().clearValue();
        div.getTxtTekiyobi().clearValue();
        div.getTxtTekiyoTodokedebi().clearValue();
        div.getDdlTekiyoJiyo().setSelectedKey(RString.EMPTY);
        div.getTxtKaijyobi().clearValue();
        div.getTxtKaijyoTodokedebi().clearValue();
        div.getDdlKaijyoJiyo().setSelectedKey(RString.EMPTY);
        div.getTxtHihoNo().clearValue();
        div.getCcdHokensha().clear();
    }

    private RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private AtenaMeisho nullTOEmpty(AtenaMeisho 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return AtenaMeisho.EMPTY;
        }
        return 項目;
    }

    private JigyoshaNo nullTOEmpty(JigyoshaNo 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return JigyoshaNo.EMPTY;
        }
        return 項目;
    }

    private Decimal nullTOZero(Decimal 項目) {
        if (項目 == null) {
            return Decimal.ZERO;
        }
        return 項目;
    }

    private RString get適用事由(RString 適用事由コード) {
        if (適用事由コード == null || 適用事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(介護他特適用理由, new Code(適用事由コード));
    }

    private RString get解除事由(RString 解除事由コード) {
        if (解除事由コード == null || 解除事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(介護他特解除理由, new Code(解除事由コード));
    }

    private List<KeyValueDataSource> set適用事由() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        List<UzT0007CodeEntity> 適用事由Key = CodeMaster.getCode(介護他特適用理由);
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
        List<UzT0007CodeEntity> 解除事由Key = CodeMaster.getCode(介護他特解除理由);
        for (UzT0007CodeEntity key : 解除事由Key) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(key.getコード().getColumnValue());
            keyValue.setValue(key.getコード名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private void 選択適用事由(RString 選択キ) {
        List<KeyValueDataSource> 適用事由情報 = set適用事由();
        for (KeyValueDataSource 適用事由 : 適用事由情報) {
            if (選択キ != null && !選択キ.isEmpty() && 選択キ.equals(適用事由.getKey())) {
                div.getDdlTekiyoJiyo().setSelectedKey(選択キ);
                div.getDdlTekiyoJiyo().setSelectedValue(適用事由.getValue());
            }
        }
    }

    private void 選択解除事由(RString 選択キ) {
        List<KeyValueDataSource> 解除事由情報 = set解除事由();
        for (KeyValueDataSource 解除事由 : 解除事由情報) {
            if (選択キ != null && !選択キ.isEmpty() && 選択キ.equals(解除事由.getKey())) {
                div.getDdlKaijyoJiyo().setSelectedKey(選択キ);
                div.getDdlKaijyoJiyo().setSelectedValue(解除事由.getValue());
            }
        }
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報() {
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getTajushochiTokureiInput().getHiddenInputShikibetsuCode());
        return TaJushochiTokureisyaKanriManager.createInstance().select宛名情報PSM(識別コード);
    }

    private static class DateComparator implements Comparator<dgJushochiTokureiRireki_Row>, Serializable {

        private static final long serialVersionUID = -2802794987962551749L;

        @Override
        public int compare(dgJushochiTokureiRireki_Row o1, dgJushochiTokureiRireki_Row o2) {
            return o2.getTekiyoYMD().getValue().
                    compareTo(o1.getTekiyoYMD().getValue());
        }
    }

    private static class DateComparatorRirekiNo implements Comparator<dgJushochiTokureiRireki_Row>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(dgJushochiTokureiRireki_Row o1, dgJushochiTokureiRireki_Row o2) {
            return o2.getRirekiNo().
                    compareTo(o1.getRirekiNo());
        }
    }
}
