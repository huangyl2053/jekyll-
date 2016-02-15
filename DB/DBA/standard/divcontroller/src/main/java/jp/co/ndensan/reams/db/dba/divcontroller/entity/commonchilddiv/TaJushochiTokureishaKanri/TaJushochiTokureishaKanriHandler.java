/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 他住所地特例者管理のクラス。
 */
public class TaJushochiTokureishaKanriHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_適用 = new RString("適用");
    private static final RString 状態_解除 = new RString("解除");
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_変更 = new RString("変更");
    private static final RString 他特例解除 = new RString("01");
    private static final RString 転入 = new RString("01");
    private static final RString 除外者適用 = new RString("01");
    private static final CodeShubetsu 介護他特適用理由 = new CodeShubetsu("0118");
    private static final CodeShubetsu 介護他特解除理由 = new CodeShubetsu("0122");
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
     */
    public void initialize() {
        RString 親画面状態 = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        SearchResult<TaJushochiTokureisyaKanriMaster> 適用情報
                = TaJushochiTokureisyaKanriManager.createInstance().getTaJushochiTokureiTekiyoJyoho(識別コード);

        div.getBtnAdd().setVisible(false);
        div.getDgJushochiTokureiRireki().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getDgJushochiTokureiRireki().getGridSetting().setIsShowModifyButtonColumn(false);
        div.getDgJushochiTokureiRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getPanSotimotoJyoho().setDisabled(false);
        set一覧の設定(適用情報.records());
        if (状態_照会.equals(親画面状態)) {
            div.getDgJushochiTokureiRireki().getGridSetting().setIsShowSelectButtonColumn(true);
            set他市町村住所地特例情報入力エリア非活性の設定();
            div.getTxtNyusyobi().setDisplayNone(true);
            div.getTxtTasyobi().setDisplayNone(true);
            div.getTxtKaijyobi().setWrap(true);
            div.getPanShisetsuJoho().setVisible(false);
            div.getBtnKakunin().setVisible(false);
            div.getDdlTekiyoJiyo().setDataSource(set適用事由());
            div.getDdlKaijyoJiyo().setDataSource(set解除事由());
        } else if (状態_修正.equals(親画面状態)) {
            div.getTxtNyusyobi().setDisplayNone(true);
            div.getTxtTasyobi().setDisplayNone(true);
            div.getTxtKaijyobi().setWrap(true);
            div.getBtnAdd().setVisible(true);
            div.getDgJushochiTokureiRireki().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getDgJushochiTokureiRireki().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getPanShisetsuJoho().setVisible(false);
            set他市町村住所地特例情報入力エリア非活性の設定();
            div.getDdlTekiyoJiyo().setDataSource(set適用事由());
            div.getDdlKaijyoJiyo().setDataSource(set解除事由());
            div.getBtnKakunin().setDisabled(true);
        } else if (状態_適用.equals(親画面状態)) {
            div.getTxtTasyobi().setDisplayNone(true);
            div.getTxtKaijyobi().setDisplayNone(true);
            div.getTxtKaijyoTodokedebi().setDisplayNone(true);
            div.getDdlKaijyoJiyo().setDisplayNone(true);
            div.getPanSotimotoJyoho().setDisabled(false);
            div.getPanShisetsuJoho().setVisible(true);
            div.getCcdShisetsuJoho().initialize();
            set他市町村住所地特例情報入力エリア(適用情報.records().get(0), 親画面状態);
            div.getDdlTekiyoJiyo().setDataSource(set適用事由());
            div.getDgJushochiTokureiRireki().getGridSetting().getColumns().get(0).setVisible(false);
        } else if (状態_解除.equals(親画面状態)) {
            div.getTxtNyusyobi().setDisplayNone(true);
            div.getTxtTekiyobi().setDisplayNone(true);
            div.getTxtTekiyoTodokedebi().setDisplayNone(true);
            div.getDdlTekiyoJiyo().setDisplayNone(true);
            div.getPanSotimotoJyoho().setVisible(false);
            div.getPanShisetsuJoho().setVisible(false);
            div.getBtnKakunin().setVisible(true);
            set他市町村住所地特例情報入力エリア(適用情報.records().get(0), 親画面状態);
            div.getDdlKaijyoJiyo().setDataSource(set解除事由());
            div.getDgJushochiTokureiRireki().getGridSetting().getColumns().get(0).setVisible(false);
        } else if (状態_変更.equals(親画面状態)) {
            div.getTajushochiTokureiInput().setVisible(false);
            div.getDgJushochiTokureiRireki().getGridSetting().getColumns().get(0).setVisible(false);
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
        set他市町村住所地特例情報入力エリア(div.getDgJushochiTokureiRireki().getActiveRow(), 状態_照会);
    }

    /**
     * 「修正」ボタンを押下する場合、選択した行の適用情報を他市町村住所地特例情報入力エリアへ設定します。
     */
    public void onClick_Update() {
        div.setStrate(状態_修正);
        div.setSelectData(new RString(String.valueOf(div.getDgJushochiTokureiRireki().getClickedItem().getId())));
        set他市町村住所地特例情報入力エリア活性の設定();
        dgJushochiTokureiRireki_Row 選択データ = div.getDgJushochiTokureiRireki().getActiveRow();
        set他市町村住所地特例情報入力エリア(選択データ, 状態_修正);
        if (選択データ.getKaijoYMD() == null) {
            div.getTxtKaijyobi().setDisabled(true);
        }
        if (選択データ.getKaijoTodokedeYMD() == null) {
            div.getTxtKaijyoTodokedebi().setDisabled(true);
        }
        if (選択データ.getKaijoJiyuCode() == null || 選択データ.getKaijoJiyuCode().isEmpty()) {
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
        set他市町村住所地特例情報入力エリア(div.getDgJushochiTokureiRireki().getActiveRow(), 状態_修正);
    }

    /**
     * 最新適用情報の解除日がある場合、非活性で表示します。
     *
     * @param 親画面状態 親画面状態
     */
    public void onClick_onBlur(RString 親画面状態) {
        if (状態_適用.equals(親画面状態)) {
            if (div.getTxtNyusyobi().getValue() != null
                    && (div.getTxtTekiyobi().getValue() == null
                    || div.getTxtTekiyoTodokedebi() == null)) {
                div.getTxtTekiyobi().setValue(new RDate(div.getTxtNyusyobi().getValue().toString()));
                div.getTxtTekiyoTodokedebi().setValue(new RDate(div.getTxtNyusyobi().getValue().toString()));
            }
        } else if (状態_解除.equals(親画面状態)) {
            if (div.getTxtTasyobi().getValue() != null
                    && (div.getTxtKaijyobi().getValue() == null
                    || div.getTxtKaijyoTodokedebi().getValue() == null)) {
                div.getTxtKaijyobi().setValue(new RDate(div.getTxtTasyobi().getValue().toString()));
                div.getTxtKaijyoTodokedebi().setValue(new RDate(div.getTxtTasyobi().getValue().toString()));
            }
        }
    }

    /**
     * 「異動内容を確認する」ボタンを押下する場合、入力の内容を最新の適用情報に反映します。
     *
     * @param rireki_Row 選択データ
     * @param 親画面状態 親画面状態
     */
    public void onClick_BtnKakunin(dgJushochiTokureiRireki_Row rireki_Row, RString 親画面状態) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        List<dgJushochiTokureiRireki_Row> rowList = div.getDgJushochiTokureiRireki().getDataSource();
        if ((状態_修正.equals(親画面状態))) {
            if (状態_追加.equals(div.getStrate())) {
                rireki_Row = new dgJushochiTokureiRireki_Row();
            }
            if (!状態_削除.equals(div.getStrate())
                    && !状態_追加.equals(rireki_Row.getJyoTai())) {
                rireki_Row.setJyoTai(div.getStrate());
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
            } else {
                rowList.remove(rireki_Row);
            }
            if (状態_追加.equals(div.getStrate())) {
                rireki_Row.setShikibetsuCode(識別コード.getColumnValue());
                if (div.getCcdHokensha().getHokenjaNo() != null) {
                    rireki_Row.setSochiHokensha(div.getCcdHokensha().getHokenjaNo());
                }
                if (div.getCcdHokensha().getHokenjaName() != null) {
                    rireki_Row.setSochiHokenshaNo(div.getCcdHokensha().getHokenjaName());
                }
                rowList.add(rireki_Row);
            }
            clear他市町村住所地特例情報入力エリア();
        } else if (状態_適用.equals(親画面状態)) {
            dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row();
            row.setJyoTai(親画面状態);

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
            rowList.add(row);
        } else if (状態_解除.equals(親画面状態)) {
            dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row();
            row.setJyoTai(親画面状態);
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
            rowList.add(row);
            div.getTxtTasyobi().setDisabled(false);
            div.getTxtKaijyobi().setDisabled(false);
            div.getTxtKaijyoTodokedebi().setDisabled(false);
            div.getDdlKaijyoJiyo().setDisabled(false);
            div.getTxtTasyobi().clearValue();
            div.getTxtKaijyobi().clearValue();
            div.getTxtKaijyoTodokedebi().clearValue();
            div.getDdlKaijyoJiyo().setSelectedKey(RString.EMPTY);
            set他市町村住所地特例情報入力エリア活性の設定();
        }
        div.setStrate(RString.EMPTY);
        Collections.sort(rowList, new DateComparator());
        div.getDgJushochiTokureiRireki().setDataSource(rowList);
        set他市町村住所地特例情報入力エリア非活性の設定();
        div.getBtnKakunin().setDisabled(true);
    }

    /**
     * 他住所地特例者の共有子DIVの画面内容から、他市町村住所地特例情報をDBに反映します。
     */
    public void saveTaJushochiTokurei() {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        List<dgJushochiTokureiRireki_Row> rowList = div.getDgJushochiTokureiRireki().getDataSource();

        for (dgJushochiTokureiRireki_Row row : rowList) {
            RString 最大枝番 = rowList.get(0).getEdaNo();
            RString 履歴番号 = rowList.get(0).getRirekiNo();
            if (row.getJyoTai() == null || row.getJyoTai().isEmpty()) {
                continue;
            }
            if (状態_追加.equals(row.getJyoTai())) {
                FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
                int intEdaNoMax = Integer.parseInt(最大枝番.toString());
                RString 枝番 = new RString(String.valueOf(intEdaNoMax + 1));
                TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(識別コード, 異動日, 枝番);
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set他住所地特例(tokurei, row).toEntity());
            } else if (状態_修正.equals(row.getJyoTai())) {
                FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
                int intEdaNoMax = Integer.parseInt(最大枝番.toString());
                RString 枝番 = new RString(String.valueOf(intEdaNoMax + 1));
                TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(識別コード, 異動日, 枝番);
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set解除状態他住所地特例(tokurei, row).toEntity());
            } else if (状態_適用.equals(row.getJyoTai())) {
                // TODO 凌護行 被保険者台帳管理（資格喪失）実装しないのため、１．４．１　資格喪失チェック実装しない。
                //TODO　凌護行　被保険者台帳管理（資格喪失）実装しない。　2016/01/26。
//                RString 画面喪失 = 被保険者台帳管理.ShikakuSoshitsuCheck(識別コード, null);
                RString 画面喪失 = new RString("");
                if (画面喪失.isEmpty()) {
                    TaJushochiTokureisyaKanriManager.createInstance().saveHihokenshaSositu(
                            new KaigoTatokuTekiyoJiyu(row.getTekiyoJiyu()),
                            new FlexibleDate(row.getTekiyoYMD().toString()),
                            new FlexibleDate(row.getTekiyoTodokedeYMD().toString()),
                            識別コード);
                } else {
                    throw new ApplicationException(DbaErrorMessages.住所地特例として未適用.getMessage());
                }
                FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
                int intEdaNoMax = Integer.parseInt(最大枝番.toString());
                RString 枝番 = new RString(String.valueOf(intEdaNoMax + 1));
                TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(識別コード, 異動日, 枝番);
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set適用状態他住所地特例(tokurei, row).toEntity());

                int rirekiNo = Integer.parseInt(履歴番号.toString());
                Decimal 最大履歴番号 = new Decimal(String.valueOf((rirekiNo + 1)));
                ShisetsuNyutaisho taisho = new ShisetsuNyutaisho(識別コード, 最大履歴番号);
                TaJushochiTokureisyaKanriManager.createInstance().regShisetsuNyutaisho(set適用状態介護保険施設入退所(taisho, row).toEntity());

            } else if (状態_解除.equals(row.getJyoTai())) {
                FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
                int intEdaNoMax = Integer.parseInt(最大枝番.toString());
                RString 枝番 = new RString(String.valueOf(intEdaNoMax + 1));
                TashichosonJushochiTokurei tokurei = new TashichosonJushochiTokurei(識別コード, 異動日, 枝番);
                TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(set解除状態他住所地特例(tokurei, row).toEntity());
                TaJushochiTokureisyaKanriManager.createInstance().delTaJushochiTokurei(識別コード, 異動日, row.getEdaNo());
                ShisetsuNyutaisho taisho = new ShisetsuNyutaisho(識別コード, new Decimal(row.getRirekiNo().toString()));
                TaJushochiTokureisyaKanriManager.createInstance().updShisetsuNyutaisho(set解除状態介護保険施設入退所(taisho, row).toEntity());

                if (他特例解除.equals(row.getKaijoJiyu())) {
                    if (!TaJushochiTokureisyaKanriManager.createInstance().checkAge(識別コード, new FlexibleDate(row.getKaijoYMD().toString()))) {
                        // TODO 凌護行 クラス「DBAQuestionMessages」が無し、QA回答まち、2016/1/28
                        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                                .equals(ResponseHolder.getMessageCode())
                                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                            TaJushochiTokureisyaKanriManager.createInstance().saveHihokenshaShutoku(
                                    new KaigoTatokuKaijoJiyu(row.getKaijoJiyu()),
                                    new FlexibleDate(row.getKaijoYMD().toString()),
                                    new FlexibleDate(row.getKaijoTodokedeYMD().toString()),
                                    識別コード);
                        } else {
                            continue;
                        }
                    } else {
                        TaJushochiTokureisyaKanriManager.createInstance().saveHihokenshaShutoku(
                                new KaigoTatokuKaijoJiyu(row.getKaijoJiyu()),
                                new FlexibleDate(row.getKaijoYMD().toString()),
                                new FlexibleDate(row.getKaijoTodokedeYMD().toString()),
                                識別コード);
                    }
                }
                TaJushochiTokureisyaKanriManager.createInstance().delTaJushochiTokurei(識別コード, 異動日, row.getEdaNo());
            } else if (状態_削除.equals(row.getJyoTai())) {
                FlexibleDate 異動日 = new FlexibleDate(row.getIdoYMD());
                RString 枝番 = row.getEdaNo();
                TaJushochiTokureisyaKanriManager.createInstance().delTaJushochiTokurei(識別コード, 異動日, 枝番);
            }
        }
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
            rowList.add(row);
        }
        div.getDgJushochiTokureiRireki().setDataSource(rowList);
    }

    private void set他市町村住所地特例情報入力エリア(
            dgJushochiTokureiRireki_Row kanriMaster,
            RString 親画面状態) {
        if (状態_照会.equals(親画面状態) || 状態_修正.equals(親画面状態)) {
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
            div.getTxtHihoNo().setValue(kanriMaster.getSochiHihokenshaNo());
        }
    }

    private void set他市町村住所地特例情報入力エリア(
            TaJushochiTokureisyaKanriMaster kanriMaster,
            RString 親画面状態) {
        if (状態_適用.equals(親画面状態)) {
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            UaFt200FindShikibetsuTaishoEntity 宛名情報
                    = TaJushochiTokureisyaKanriManager.createInstance().select宛名情報PSM(識別コード);
            if (宛名情報 != null) {
                if (転入.equals(宛名情報.getIdoJiyuCode())) {
                    if (宛名情報.getIdoYMD() != null) {
                        div.getTxtTekiyobi().setValue(new RDate(宛名情報.getIdoYMD().toString()));
                    }
                    if (宛名情報.getTodokedeYMD() != null) {
                        div.getTxtTekiyoTodokedebi().setValue(new RDate(宛名情報.getTodokedeYMD().toString()));
                    }
                    div.getDdlTekiyoJiyo().setSelectedValue(除外者適用);
                }
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
        } else if (状態_解除.equals(親画面状態)) {
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

    private TashichosonJushochiTokurei set他住所地特例(
            TashichosonJushochiTokurei tokurei,
            dgJushochiTokureiRireki_Row row) {
        RString 異動事由コード;
        if (row.getKaijoYMD().getValue() == null) {
            異動事由コード = row.getTekiyoJiyu();
        } else {
            異動事由コード = row.getKaijoJiyu();
        }
        return tokurei.createBuilderForEdit()
                .set異動事由コード(異動事由コード)
                //              TODO　凌護行　「業務コンフィグ．導入団体コード」取得不明、　QA589回答まち、23016/1/28
                //                .set市町村コード(LasdecCode.EMPTY)
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
                .set他特例連絡票発行年月日(FlexibleDate.EMPTY)
                .set施設退所通知発行年月日(FlexibleDate.EMPTY)
                .set施設変更通知発行年月日(FlexibleDate.EMPTY)
                .set論理削除フラグ(false)
                .build();
    }

    private TashichosonJushochiTokurei set適用状態他住所地特例(
            TashichosonJushochiTokurei tokurei,
            dgJushochiTokureiRireki_Row row) {
        return tokurei.createBuilderForEdit()
                .set異動事由コード(row.getTekiyoJiyu())
                //              TODO　凌護行　「業務コンフィグ．導入団体コード」取得不明、　QA589回答まち、23016/1/28
                //                .set市町村コード(LasdecCode.EMPTY)
                .set他市町村住所地特例適用事由コード(row.getTekiyoJiyu())
                .set適用年月日(new FlexibleDate(row.getTekiyoYMD().getValue().toDateString()))
                .set適用届出年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set適用受付年月日(new FlexibleDate(row.getTekiyoTodokedeYMD().getValue().toDateString()))
                .set他市町村住所地特例解除事由コード(RString.EMPTY)
                .set解除年月日(FlexibleDate.EMPTY)
                .set解除届出年月日(FlexibleDate.EMPTY)
                .set解除受付年月日(FlexibleDate.EMPTY)
                .set措置保険者番号(new ShoKisaiHokenshaNo(row.getSochiHokensha()))
                .set措置被保険者番号(new HihokenshaNo(row.getSochiHihokenshaNo()))
                .set他特例連絡票発行年月日(FlexibleDate.EMPTY)
                .set施設退所通知発行年月日(FlexibleDate.EMPTY)
                .set施設変更通知発行年月日(FlexibleDate.EMPTY)
                .set論理削除フラグ(false)
                .build();
    }

    private TashichosonJushochiTokurei set解除状態他住所地特例(
            TashichosonJushochiTokurei tokurei,
            dgJushochiTokureiRireki_Row row) {
        return tokurei.createBuilderForEdit()
                .set異動事由コード(row.getTekiyoJiyu())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
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
                .set他特例連絡票発行年月日(new FlexibleDate(row.getTatokuRenrakuhyoHakkoYMD()))
                .set施設退所通知発行年月日(new FlexibleDate(row.getShisetsuTaishoTsuchiHakkoYMD()))
                .set施設変更通知発行年月日(new FlexibleDate(row.getShisetsuHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private ShisetsuNyutaisho set適用状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            dgJushochiTokureiRireki_Row row) {
        return taisho.createBuilderForEdit()
                //              TODO　凌護行　「業務コンフィグ．導入団体コード」取得不明、　QA589回答まち、23016/1/28
                //        .set市町村コード(LasdecCode.EMPTY)
                .set台帳種別(new RString("2"))
                .set入所施設種類(row.getNyushoShisetsuCode())
                .set入所施設コード(new JigyoshaNo(row.getNyushoShisetsu()))
                .set入所処理年月日(new FlexibleDate(RDate.getNowDateTime().getDate().toDateString()))
                .set入所年月日(new FlexibleDate(row.getNyushoYMD().toString()))
                .set退所年月日(FlexibleDate.EMPTY)
                .set退所処理年月日(FlexibleDate.EMPTY)
                .set部屋記号番号(RString.EMPTY)
                .build();
    }

    private ShisetsuNyutaisho set解除状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            dgJushochiTokureiRireki_Row row) {
        return taisho.createBuilderForEdit()
                .set退所年月日(new FlexibleDate(row.getTaishoYMD().toString()))
                .set退所処理年月日(new FlexibleDate(RDate.getNowDateTime().getDate().toDateString()))
                .build();
    }

    private void set他市町村住所地特例情報入力エリア非活性の設定() {
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
    }

    private void clear他市町村住所地特例情報入力エリア() {
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

    private static class DateComparator implements Comparator<dgJushochiTokureiRireki_Row> {

        @Override
        public int compare(dgJushochiTokureiRireki_Row o1, dgJushochiTokureiRireki_Row o2) {
            return o2.getTekiyoYMD().getValue().
                    compareTo(o1.getTekiyoYMD().getValue());
        }
    }
}
