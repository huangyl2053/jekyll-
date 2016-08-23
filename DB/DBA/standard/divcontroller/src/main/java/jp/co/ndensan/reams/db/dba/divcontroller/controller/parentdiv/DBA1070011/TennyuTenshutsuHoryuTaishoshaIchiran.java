/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1070011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha.ITennyuTenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.DBA1070011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgKoiki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgTennyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011.dgTenshutsu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1070011.TennyuTenshutsuHoryuTaishoshaIchiranValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuTaishoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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

    /**
     * コンストラクタです。
     */
    public TennyuTenshutsuHoryuTaishoshaIchiran() {
        this.manager = TennyuTenshutsuHoryuTaishoshaManager.createInstance();
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
        save転入転出保留対象者情報ToViewState();
        List<ITennyuTenshutsuHoryuTaishosha> 転出保留対象者情報 = manager.getTenshutsuHoryuTaishoshaList().records();
        List<ITennyuTenshutsuHoryuTaishosha> 転入保留対象者情報 = manager.getTennyuHoryuTaishoshaList().records();
        List<ITennyuTenshutsuHoryuTaishosha> 広域保留対象者情報 = manager.getKoikiHoryuTaishoshaList().records();
        TennyuTenshutsuHoryuTaishoshaIchiranHandler handler = getHandler(div);
        handler.load_転入情報(転入保留対象者情報);
        handler.load_転出情報(転出保留対象者情報);
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
                    .get(ViewStateKeys.転入保留対象者情報, Models.class);
            manager.delTennyushutsuHoryuTaishosha(転入保留対象者情報.get(new TennyushutsuHoryuTaishoshaIdentifier(
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
                    .get(ViewStateKeys.転出保留対象者情報, Models.class);
            manager.delTenshutsuHoryuTaishosha(転出保留対象者情報.get(new TenshutsuHoryuTaishoshaIdentifier(
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
                    .get(ViewStateKeys.転入保留対象者情報, Models.class);
            manager.delTennyushutsuHoryuTaishosha(広域保留対象者情報.get(new TennyushutsuHoryuTaishoshaIdentifier(
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
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs message = new TennyuTenshutsuHoryuTaishoshaIchiranValidationHandler(div).doCheck();
            if (message.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(message).respond();
            }
//          TODO QA1158 画面間遷移、引数不一致
            dgTenshutsu_Row row = div.getDgTenshutsu().getSelectedItems().get(0);
            TaishoshaKey key = new TaishoshaKey(new HihokenshaNo(row.getHihokenshaNo().getText()),
                    new ShikibetsuCode(row.getShikibetsuCode().getText()), SetaiCode.EMPTY);
            ViewStateHolder.put(ViewStateKeys.資格対象者, key);
            return ResponseData.of(div).forwardWithEventName(DBA1070011TransitionEventName.転出).parameter(PARAMETER_資格喪失);
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

    private void save転入転出保留対象者情報ToViewState() {
        List<TennyushutsuHoryuTaishosha> 転入保留対象者情報List = manager.getAllTennyuHoryuTaishosha().records();
        List<TenshutsuHoryuTaishosha> 転出保留対象者情報List = manager.getAllTenshutsuHoryuTaishosha().records();
        Models<TennyushutsuHoryuTaishoshaIdentifier, TennyushutsuHoryuTaishosha> 転入保留対象者情報 = Models.create(転入保留対象者情報List);
        Models<TenshutsuHoryuTaishoshaIdentifier, TenshutsuHoryuTaishosha> 転出保留対象者情報 = Models.create(転出保留対象者情報List);
        ViewStateHolder.put(ViewStateKeys.転入保留対象者情報, 転入保留対象者情報);
        ViewStateHolder.put(ViewStateKeys.転出保留対象者情報, 転出保留対象者情報);
    }

    private TennyuTenshutsuHoryuTaishoshaIchiranHandler getHandler(TennyuTenshutsuHoryuTaishoshaIchiranDiv div) {
        return new TennyuTenshutsuHoryuTaishoshaIchiranHandler(div);
    }
}
