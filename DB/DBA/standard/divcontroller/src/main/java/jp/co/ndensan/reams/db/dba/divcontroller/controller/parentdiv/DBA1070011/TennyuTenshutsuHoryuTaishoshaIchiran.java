/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1070011;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu.TennyuHoryuTaisho;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu.TenshutsuHoryuTaisho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.DBA1070011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgKoiki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgTennyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgTenshutsu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dba.service.core.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 転入転出保留対象者管理のコントローラです。
 *
 * @reamsid_L DBA-0470-030 wangxiaodong
 */
public class TennyuTenshutsuHoryuTaishoshaIchiran {

    private static final RString KEY_資格取得 = new RString("DBA1010011");
    private static final RString KEY_資格喪失 = new RString("DBA1030011");
    private static final RString KEY_資格取得異動 = new RString("DBA1040011");
    private static final RString KEY_住所地特例適用 = new RString("DBA2030011");
    private static final RString KEY_他特例適用 = new RString("DBA2040011");
    private static final RString KEY_除外者適用 = new RString("DBA2050011");
    private static final RString PARAMETER_資格取得 = new RString("資格取得");
    private static final RString PARAMETER_資格喪失 = new RString("資格喪失");
    private static final RString PARAMETER_資格取得異動 = new RString("広域内転居");
    private static final RString PARAMETER_住所地特例適用 = new RString("住所地特例適用");
    private static final RString PARAMETER_他特例適用 = new RString("他特例適用");
    private static final RString PARAMETER_除外者適用 = new RString("除外者適用");
    private final TennyuTenshutsuHoryuTaishoshaManager manager;
    private final HihokenshaShikakuShutokuManager shikakuShutokuManager;

    /**
     * コンストラクタです。
     */
    public TennyuTenshutsuHoryuTaishoshaIchiran() {
        this.manager = TennyuTenshutsuHoryuTaishoshaManager.createInstance();
        this.shikakuShutokuManager = HihokenshaShikakuShutokuManager.createInstance();
    }

    /**
     * 転入転出保留対象者管理を初期化します。
     *
     * @param div 転入転出保留対象者管理
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv> onLoad(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 == null) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.完了する).respond();
        }
        DonyuKeitaiCode 導入形態コード = DonyuKeitaiCode.toValue(市町村セキュリティ情報.get導入形態コード().value());
        if (導入形態コード.is広域()) {
            div.getTplTennyu().setVisible(false);
            div.getTplTenshutsu().setVisible(false);
            div.getTabTennyuTenshutsuHoryuTaishosha().setSelectedItem(div.getTplKoiki());
        } else {
            div.getTplKoiki().setVisible(false);

        }
//<<<<<<< HEAD
//        save転入転出保留対象者情報ToViewState();
        List<TenshutsuHoryuTaisho/*ITennyuTenshutsuHoryuTaishosha*/> 転出保留対象者情報 = manager.getTenshutsuHoryuTaishoshas/*getTenshutsuHoryuTaishoshaList*/().records();
        List<TennyuHoryuTaisho/*ITennyuTenshutsuHoryuTaishosha*/> 転入保留対象者情報 = manager.getTennyuHoryuTaishoshas/*getTennyuHoryuTaishoshaList*/().records();
        List<TennyuHoryuTaisho/*ITennyuTenshutsuHoryuTaishosha*/> 広域保留対象者情報 = manager.getKoikiHoryuTaishoshas/*getKoikiHoryuTaishoshaList*/().records();
        boolean 比較結果 = false;
        for (TenshutsuHoryuTaisho/*ITennyuTenshutsuHoryuTaishosha*/ 転出対象者情報 : 転出保留対象者情報) {
            if ((転出対象者情報.get識別コード() != null) && (!転出対象者情報.get識別コード().isEmpty())
                && 転出対象者情報.get識別コード().getColumnValue().equals(ViewStateHolder.get(ViewStateKeys.識別コード, RString.class))) {
                比較結果 = true;
            }
        }
        for (TennyuHoryuTaisho/*ITennyuTenshutsuHoryuTaishosha*/ 転入対象者情報 : 転入保留対象者情報) {
            if ((転入対象者情報.get識別コード() != null) && (!転入対象者情報.get識別コード().isEmpty())
                && 転入対象者情報.get識別コード().getColumnValue().equals(ViewStateHolder.get(ViewStateKeys.識別コード, RString.class))) {
                比較結果 = true;
            }
        }
        for (TennyuHoryuTaisho/*ITennyuTenshutsuHoryuTaishosha*/ 広域対象者情報 : 広域保留対象者情報) {
            if ((広域対象者情報.get識別コード() != null) && (!広域対象者情報.get識別コード().isEmpty())
                && 広域対象者情報.get識別コード().getColumnValue().equals(ViewStateHolder.get(ViewStateKeys.識別コード, RString.class))) {
                比較結果 = true;
            }
        }
        if (!比較結果) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.完了する).respond();

        }

//=======
//        loadTplTenshutsu(div);
//        List<TennyuHoryuTaisho> 転入保留対象者情報 = manager.getTennyuHoryuTaishoshas().records();
//        save転入保留対象者情報ToViewState(転入保留対象者情報);
//        List<TennyuHoryuTaisho> 広域保留対象者情報 = manager.getKoikiHoryuTaishoshas().records();
//        save広域保留対象者情報ToViewState(広域保留対象者情報);
//>>>>>>> origin/sync
        TennyuTenshutsuHoryuTaishoshaIchiranHandler handler = getHandler(div);
        handler.load_転入情報(転入保留対象者情報);
        handler.load_広域情報(広域保留対象者情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 転入保留対象者を選択します。
     *
     * @param div 転入転出保留対象者管理
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv> onSelect_Tennyu(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        dgTennyu_Row click転入保留対象者 = div.getDgTennyu().getActiveRow();
        TaishoshaKey key = new TaishoshaKey(new HihokenshaNo(click転入保留対象者.getHihokenshaNo().getText()),
                new ShikibetsuCode(click転入保留対象者.getShikibetsuCode().getText()), SetaiCode.EMPTY);
        ViewStateHolder.put(ViewStateKeys.資格対象者, key);
        RString selectedKey = click転入保留対象者.getNextTask().getSelectedKey();
        if (KEY_資格取得.equals(selectedKey) || selectedKey.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.転入).parameter(PARAMETER_資格取得);
        }
        if (KEY_他特例適用.equals(selectedKey)) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.転入).parameter(PARAMETER_他特例適用);
        }
        if (KEY_除外者適用.equals(selectedKey)) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.転入).parameter(PARAMETER_除外者適用);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<TennyushutsuHoryuTaishoshaIdentifier, TennyushutsuHoryuTaishosha> 転入保留対象者情報
                    = (Models<TennyushutsuHoryuTaishoshaIdentifier, TennyushutsuHoryuTaishosha>) ViewStateHolder
                    .get(ViewStateKeys.転入保留対象者, Models.class);
            manager.delete転入保留対象者(転入保留対象者情報.get(new TennyushutsuHoryuTaishoshaIdentifier(
                    new ShikibetsuCode(click転入保留対象者.getShikibetsuCode().getText()),
                    Integer.parseInt(click転入保留対象者.getRirekiNo().toString()))));
            div.getDgTennyu().getDataSource().remove(click転入保留対象者);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 転出保留対象者を選択します。
     *
     * @param div 転入転出保留対象者管理
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv> onSelect_Tenshutsu(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        dgTenshutsu_Row click転出保留対象者 = div.getDgTenshutsu().getActiveRow();
        TaishoshaKey key = new TaishoshaKey(new HihokenshaNo(click転出保留対象者.getHihokenshaNo().getText()),
                new ShikibetsuCode(click転出保留対象者.getShikibetsuCode().getText()), SetaiCode.EMPTY);
        ViewStateHolder.put(ViewStateKeys.資格対象者, key);
        if (KEY_資格喪失.equals(click転出保留対象者.getNextTask().getSelectedKey())
            || click転出保留対象者.getNextTask().getSelectedKey().isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.転出).parameter(PARAMETER_資格喪失);
        }
        if (KEY_住所地特例適用.equals(click転出保留対象者.getNextTask().getSelectedKey())) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.転出).parameter(PARAMETER_住所地特例適用);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<TenshutsuHoryuTaishoshaIdentifier, TenshutsuHoryuTaishosha> 転出保留対象者情報
                    = (Models<TenshutsuHoryuTaishoshaIdentifier, TenshutsuHoryuTaishosha>) ViewStateHolder
                    .get(ViewStateKeys.転出保留対象者, Models.class);
            manager.delete転出保留対象者(転出保留対象者情報.get(new TenshutsuHoryuTaishoshaIdentifier(
                    new ShikibetsuCode(click転出保留対象者.getShikibetsuCode().getText()),
                    Integer.parseInt(click転出保留対象者.getRirekiNo().toString()))));
            div.getDgTenshutsu().getDataSource().remove(click転出保留対象者);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 広域保留対象者を選択します。
     *
     * @param div 転入転出保留対象者管理
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv> onSelect_Koiki(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        dgKoiki_Row click広域保留対象者 = div.getDgKoiki().getClickedItem();
        TaishoshaKey key = new TaishoshaKey(new HihokenshaNo(click広域保留対象者.getHihokennshaNo().getText()),
                new ShikibetsuCode(click広域保留対象者.getShikibetsuCode().getText()), SetaiCode.EMPTY);
        ViewStateHolder.put(ViewStateKeys.資格対象者, key);
        if (KEY_資格取得異動.equals(click広域保留対象者.getNextTask().getSelectedKey())
            || click広域保留対象者.getNextTask().getSelectedKey().isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.広域).parameter(PARAMETER_資格取得異動);
        }
        if (KEY_住所地特例適用.equals(click広域保留対象者.getNextTask().getSelectedKey())) {
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.広域).parameter(PARAMETER_住所地特例適用);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<TennyushutsuHoryuTaishoshaIdentifier, TennyushutsuHoryuTaishosha> 広域保留対象者情報
                    = (Models<TennyushutsuHoryuTaishoshaIdentifier, TennyushutsuHoryuTaishosha>) ViewStateHolder
                    .get(ViewStateKeys.広域転入保留対象者, Models.class);
            manager.delete転入保留対象者(広域保留対象者情報.get(new TennyushutsuHoryuTaishoshaIdentifier(
                    new ShikibetsuCode(click広域保留対象者.getShikibetsuCode().getText()),
                    Integer.parseInt(click広域保留対象者.getRirekiNo().toString()))));
            div.getDgKoiki().getDataSource().remove(click広域保留対象者);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一括で喪失処理を行います。
     *
     * @param div 転入転出保留対象者管理
     * @return ResponseData<ShikakuHenkouIdouDiv>
     */
    public ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv> onClick_btnIkkatsuSoshitsu(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
            && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes && !div.getDgTenshutsu().getDataSource().isEmpty()) {
            ValidationMessageControlPairs message = new TennyuTenshutsuHoryuTaishoshaIchiranValidationHandler(div).doCheck();
            if (message.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(message).respond();
            }
            Map<ShikibetsuCode, IKojin> 宛名Map = manager.get宛名Map(get識別コードList(div));
            Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> 被保険者台帳情報
                    = (Models<HihokenshaDaichoIdentifier, HihokenshaDaicho>) ViewStateHolder.get(
                            ViewStateKeys.被保険者台帳情報, Models.class);
            Models<TenshutsuHoryuTaishoshaIdentifier, TenshutsuHoryuTaishosha> 転出保留対象者情報
                    = (Models<TenshutsuHoryuTaishoshaIdentifier, TenshutsuHoryuTaishosha>) ViewStateHolder.get(
                            ViewStateKeys.転出保留対象者, Models.class);
            List<TenshutsuHoryuTaishosha> 転出保留対象者List = new ArrayList<>();
            List<HihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
            for (dgTenshutsu_Row row : div.getDgTenshutsu().getSelectedItems()) {
                ShikibetsuCode 識別コード = new ShikibetsuCode(row.getShikibetsuCode().getText());
                get資格異動(被保険者台帳情報, 宛名Map.get(識別コード), row, 被保険者台帳List);
                転出保留対象者List.add(転出保留対象者情報.get(
                        new TenshutsuHoryuTaishoshaIdentifier(識別コード, Integer.valueOf(row.getRirekiNo().toString()))));
            }
            manager.do一括喪失(被保険者台帳List, 転出保留対象者List);
            loadTplTenshutsu(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 完了ボタンをクリックします。
     *
     * @param div 転入転出保留対象者管理
     * @return ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv>
     */
    public ResponseData<TennyuTenshutsuHoryuTaishoshaIchiranDiv> onClick_btnComplete(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.完了する).respond();
    }

    private void get資格異動(Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> 被保険者台帳情報,
            IKojin 宛名, dgTenshutsu_Row row, List<HihokenshaDaicho> 被保険者台帳List) {
        FlexibleDate 異動日 = FlexibleDate.EMPTY;
        if (宛名 != null) {
            if (!宛名.get転出確定().get異動年月日().isEmpty()) {
                異動日 = 宛名.get転出確定().get異動年月日();
            } else if (!宛名.get転出予定().get異動年月日().isEmpty()) {
                異動日 = 宛名.get転出予定().get異動年月日();
            }
            if (!異動日.isEmpty()) {
                HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getHihokenshaNo().getText());
                RString 枝番 = shikakuShutokuManager.getSaidaiEdaban(被保険者番号, 異動日);
                被保険者台帳List.add(
                        被保険者台帳情報.get(new HihokenshaDaichoIdentifier(被保険者番号, row.getHihokenshaIdoYMD().getValue(), row.getHihokenshaEdaNo()))
                        .createBuilderForEdit().set異動日(異動日)
                        .set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード())
                        .set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード())
                        .set資格喪失年月日(異動日).set資格喪失届出年月日(異動日).set枝番(枝番).build());
            }
        }
    }

    private List<ShikibetsuCode> get識別コードList(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        for (dgTenshutsu_Row row : div.getDgTenshutsu().getDataSource()) {
            識別コードList.add(new ShikibetsuCode(row.getShikibetsuCode().getText()));
        }
        return 識別コードList;
    }

    private void save転出保留対象者情報ToViewState(List<TenshutsuHoryuTaisho> 対象者情報) {
        List<TenshutsuHoryuTaishosha> 転出保留対象者List = new ArrayList<>();
        List<HihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
        for (TenshutsuHoryuTaisho tenshutsuHoryuTaisho : 対象者情報) {
            転出保留対象者List.add(tenshutsuHoryuTaisho.get転出保留対象者());
            被保険者台帳List.add(tenshutsuHoryuTaisho.get被保険者台帳管理());
        }
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> 被保険者台帳情報 = Models.create(被保険者台帳List);
        ViewStateHolder.put(ViewStateKeys.被保険者台帳情報, 被保険者台帳情報);
        Models<TenshutsuHoryuTaishoshaIdentifier, TenshutsuHoryuTaishosha> 転出保留対象者情報 = Models.create(転出保留対象者List);
        ViewStateHolder.put(ViewStateKeys.転出保留対象者, 転出保留対象者情報);
    }

    private void loadTplTenshutsu(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        List<TenshutsuHoryuTaisho> 転出保留対象者情報 = manager.getTenshutsuHoryuTaishoshas().records();
        save転出保留対象者情報ToViewState(転出保留対象者情報);
        getHandler(div).load_転出情報(転出保留対象者情報);
    }

    private TennyuTenshutsuHoryuTaishoshaIchiranHandler getHandler(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        return new TennyuTenshutsuHoryuTaishoshaIchiranHandler(div);
    }
}
