/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1050021;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.DBA1050021StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.DBA1050021TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021.HihokenshaShikakuPanelValidationHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021.HihokenshaShisakuPanalHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.db.dba.service.core.nyutaishoshakanri.NyutaishoshaKanriFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.business.core.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 被保険者資格詳細異動クラスです。
 *
 * @reamsid_L DBA-0521-020 lijia
 *
 */
public class HihokenshaShisakuPanal {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_照会 = new RString("照会");
    private final HihokenshaShikakuTeiseiManager manager = HihokenshaShikakuTeiseiManager.createInstance();
    private final RString 広域保険者 = new RString("1");
    private static final LockingKey 前排他ロックキー = new LockingKey("ShikakuShosaiIdo");

    /**
     * 被保険者資格詳細異動Divを初期化します。
     *
     * @param div 被保険者資格詳細異動Div
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onLoad(HihokenshaShisakuPanalDiv div) {
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);

        TaishoshaKey 対象者キー = ViewStateHolder.get(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保番号 = 対象者キー.get被保険者番号();
        ShikibetsuCode 識別コード = 対象者キー.get識別コード();

        List<HihokenshaDaicho> hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報_修正後, ArrayList.class);
        if (hihoDaicho == null) {
            hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報, ArrayList.class);
        }
        FlexibleDate shikakuShutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_資格取得日, FlexibleDate.class);
        getHandler(div).initialize(初期_状態, hihoDaicho, 識別コード, 被保番号, shikakuShutokuDate);

        if (状態_追加.equals(初期_状態)) {
            return ResponseData.of(div).setState(DBA1050021StateName.追加状態);
        } else if (状態_修正.equals(初期_状態)) {
            return ResponseData.of(div).setState(DBA1050021StateName.修正状態);
        } else if (状態_削除.equals(初期_状態)) {
            return ResponseData.of(div).setState(DBA1050021StateName.削除状態);
        } else if (状態_照会.equals(初期_状態)) {
            return ResponseData.of(div).setState(DBA1050021StateName.照会状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資格異動の訂正を保存する」ボタンの押下を処理です。//今後、修正を確定するButtonになる。
     *
     * @param div 被保険者資格詳細異動Div
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onClick_btnSave(HihokenshaShisakuPanalDiv div) {
        ValidationMessageControlPairs pairs = is暦上日(div);
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        資格異動訂正の確定処理(div);
        return ResponseData.of(div).forwardWithEventName(DBA1050021TransitionEventName.資格異動の訂正を保存する).respond();

    }

    private void 資格異動訂正の確定処理(HihokenshaShisakuPanalDiv div) {
        施設入退所履歴期間重複チェック処理(div);
        List<HihokenshaDaicho> 資格訂正情報 = create被保険者入力情報統合リスト(div);
        outputList(資格訂正情報);

        HihokenshaDaichoList 降順List = new HihokenshaDaichoList(ItemList.of(資格訂正情報));
        manager.checkShikakuTorukuList(降順List.to昇順List().toList(), get当該識別対象の生年月日(div));

        ArrayList<HihokenshaDaicho> serial修正後データ = new ArrayList<>();
        serial修正後データ.addAll(資格訂正情報);

        List<HihokenshaDaicho> hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報_修正後, ArrayList.class);
        if (hihoDaicho == null) {
            hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報, ArrayList.class);
        }
        FlexibleDate shutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_資格取得日, FlexibleDate.class);

        List<HihokenshaDaicho> shuseimaeExclusion = new ArrayList<>();
        for (HihokenshaDaicho daicho : hihoDaicho) {
            if (daicho.get資格取得年月日() != null && daicho.get資格取得年月日().equals(shutokuDate)) {
                continue;
            }
            shuseimaeExclusion.add(daicho);
        }

        serial修正後データ.addAll(shuseimaeExclusion);
        ViewStateHolder.put(ViewStateKeys.対象者_被保険者台帳情報_修正後, serial修正後データ);
        outputList(資格訂正情報);
    }

    private void outputList(Collection<HihokenshaDaicho> collection) {
        int num = 0;
        for (HihokenshaDaicho hiho : collection) {
            System.out.print(num + "番目のデータ--------------,");
            System.out.print(hiho.get被保険者番号().getColumnValue() + ",");
            System.out.print(hiho.get異動日() + ",");
            System.out.print(hiho.get枝番() + ",");
            System.out.print(hiho.get異動事由コード() + ",");
            System.out.print(hiho.get市町村コード() + ",");
            System.out.print(hiho.get識別コード() + ",");
            System.out.print(hiho.get資格取得事由コード() + ",");
            System.out.print(hiho.get資格取得年月日() + ",");
            System.out.print(hiho.get資格取得届出年月日() + ",");
            System.out.print(hiho.get第1号資格取得年月日() + ",");
            System.out.print(hiho.get被保険者区分コード() + ",");
            System.out.print(hiho.get資格喪失事由コード() + ",");
            System.out.print(hiho.get資格喪失年月日() + ",");
            System.out.print(hiho.get資格喪失届出年月日() + ",");
            System.out.print(hiho.get資格変更事由コード() + ",");
            System.out.print(hiho.get資格変更年月日() + ",");
            System.out.print(hiho.get資格変更届出年月日() + ",");
            System.out.print(hiho.get住所地特例適用事由コード() + ",");
            System.out.print(hiho.get適用年月日() + ",");
            System.out.print(hiho.get適用届出年月日() + ",");
            System.out.print(hiho.get住所地特例解除事由コード() + ",");
            System.out.print(hiho.get解除年月日() + ",");
            System.out.print(hiho.get解除届出年月日() + ",");
            System.out.print(hiho.get住所地特例フラグ() + ",");
            System.out.print(hiho.get広域内住所地特例フラグ() + ",");
            System.out.print(hiho.get広住特措置元市町村コード() + ",");
            System.out.print(hiho.get旧市町村コード() + ",");
            System.out.print(hiho.is論理削除フラグ() + ",");
            System.out.print(hiho.toEntity().getState().name() + ",");
            System.out.println();
            num++;
        }
    }

    private ValidationMessageControlPairs is暦上日(HihokenshaShisakuPanalDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtShutokuDate()));
        pairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtShutokuTodokedeDate()));
        pairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getTxtSoshitsuDate()));
        pairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getTxtSoshitsuTodokedeDate()));
        return pairs;
    }

    private void 施設入退所履歴期間重複チェック処理(HihokenshaShisakuPanalDiv div) {
        NyutaishoshaKanriFinder finder = NyutaishoshaKanriFinder.createInstance();
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> model = div.getCcdShisetsuNyutaishoDialogButton().get施設入退所データ();
        for (ShisetsuNyutaisho 施設入退所履歴 : model) {
            FlexibleDate nyushoDate = 施設入退所履歴.get入所年月日();
            FlexibleDate taishoDate = 施設入退所履歴.get退所年月日();
            RString 入所施設種類 = 施設入退所履歴.get入所施設種類();
            boolean checkFlag = finder.isRirekiKikanJufukuFlag(
                    nyushoDate,
                    taishoDate,
                    入所施設種類);
            if (checkFlag) {
                throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
            }
        }
    }

    private List<HihokenshaDaicho> create被保険者入力情報統合リスト(HihokenshaShisakuPanalDiv div) {

        List<HihokenshaDaicho> 入力内容反映前 = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報_修正後, ArrayList.class);
        if (入力内容反映前 == null) {
            入力内容反映前 = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報, ArrayList.class);
        }

        FlexibleDate shikakuShutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_資格取得日, FlexibleDate.class);
        HihokenshaDaichoList hihoList = new HihokenshaDaichoList(ItemList.of(入力内容反映前));
        IItemList<HihokenshaDaicho> oneSeasonList = hihoList.toOneSeasonList(shikakuShutokuDate);
        入力内容反映前 = oneSeasonList.toList();
        outputList(入力内容反映前);

        List<HihokenshaDaicho> 住所地特例情報
                = div.getCcdJutokuDialogButton().get修正後被保険者データ().toList();
        System.out.println("住所地特例データ");
        outputList(住所地特例情報);

        List<HihokenshaDaicho> 資格変更履歴情報
                = div.getCcdShikakuHenkoDialogButton().get修正後被保険者データ().toList();
        System.out.println("資格変更履歴データ");
        outputList(資格変更履歴情報);

        List<HihokenshaDaicho> 資格訂正登録リスト = new ArrayList<>();
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        System.out.println(初期_状態);
        if (状態_追加.equals(初期_状態)) {
            資格訂正登録リスト.addAll(入力内容反映前);
            資格訂正登録リスト.addAll(住所地特例情報);
            資格訂正登録リスト.addAll(資格変更履歴情報);
        }
        if (状態_修正.equals(初期_状態)) {
            資格訂正登録リスト = getHandler(div).create住所地特例データ統合リスト(入力内容反映前, 住所地特例情報);
            outputList(資格訂正登録リスト);
            資格訂正登録リスト = getHandler(div).create資格変更データ統合リスト(資格訂正登録リスト, 資格変更履歴情報);
            outputList(資格訂正登録リスト);
        }
        資格訂正登録リスト = getHandler(div).create引継情報反映リスト(資格訂正登録リスト);
        outputList(資格訂正登録リスト);
        return 資格訂正登録リスト;
    }

    private IDateOfBirth get当該識別対象の生年月日(HihokenshaShisakuPanalDiv div) {
        FlexibleDate birth = div.getKihonJoho().getCcdKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD().getValue();
        return DateOfBirthFactory.createInstance(birth);
    }

    /**
     * 「資格異動の訂正を削除する」ボタンの押下を処理です。
     *
     * @param div 被保険者資格詳細異動Div
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onClick_btnDelete(HihokenshaShisakuPanalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);

            FlexibleDate shikakuShutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_資格取得日, FlexibleDate.class);
            manager.deleteHihokenshaShikakuTeisei(被保険者番号, shikakuShutokuDate);
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(div).forwardWithEventName(DBA1050021TransitionEventName.資格異動の訂正を保存する).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 所在保険者部品連動処理します。
     *
     * @param div HihokenshaShisakuPanalDiv
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onClick_Change(HihokenshaShisakuPanalDiv div) {

        List<HihokenshaDaicho> hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報, ArrayList.class);
        FlexibleDate shikakuShutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_資格取得日, FlexibleDate.class);
        HihokenshaDaicho 資格得喪情報 = getHandler(div).get最新資格得喪データ(hihoDaicho, shikakuShutokuDate);

        RString 導入形態コード = div.getHiddenDonyuKeitaiCode();
        if (広域保険者.equals(getHandler(div).広域と市町村判断()) && !RString.isNullOrEmpty(広域保険者)) {
            List<Shichoson> 旧保険者情報 = getHandler(div).旧保険者取得(
                    資格得喪情報.get市町村コード(),
                    導入形態コード,
                    資格得喪情報.get広住特措置元市町村コード());
            List<KeyValueDataSource> keyValueList = new ArrayList<>();
            for (Shichoson 旧保険者 : 旧保険者情報) {
                KeyValueDataSource keyValue = new KeyValueDataSource();
                keyValue.setKey(旧保険者.get旧市町村コード().getColumnValue());
                keyValue.setValue(new RString(旧保険者.get旧市町村コード().getColumnValue() + " " + 旧保険者.get旧市町村名称()));
                keyValueList.add(keyValue);
            }
            div.getShikakuShosai().getDdlShutokuKyuHokensha().setDataSource(keyValueList);

        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「資格異動訂正に戻る」ボタンの押下を処理です。
     *
     * @param div 被保険者資格詳細異動Div
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onClick_btnBack(HihokenshaShisakuPanalDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBA1050021TransitionEventName.履歴一覧に戻る).respond();
    }

    private HihokenshaShisakuPanalHandler getHandler(HihokenshaShisakuPanalDiv div) {
        return new HihokenshaShisakuPanalHandler(div);
    }

    private enum HihokenshaShisakuPanalErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private HihokenshaShisakuPanalErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    /**
     * 新規資格得喪失を確定するBTNをクリックした場合のイベントを定義します。
     * 資格得喪を新規に追加する場合に、起点となる資格取得・喪失情報を設定します。
     * 設定後に確定BTNをクリックする（本イベント）を実行することで、新規に入力した資格得喪情報が起点となり、
     * 以降は修正処理と同等の操作を可能にします。
     *
     * @param div HihokenshaShisakuPanalDiv
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onClick_btnTokusoKakutei(HihokenshaShisakuPanalDiv div) {

        HihokenshaShikakuPanelValidationHandler validationHandler = new HihokenshaShikakuPanelValidationHandler(div);
        HihokenshaShisakuPanalHandler handler = getHandler(div);

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        pairs.add(is暦上日(div));
        pairs.add(validationHandler.validate資格取得情報());
        pairs.add(validationHandler.validate資格喪失情報());

        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        TaishoshaKey 対象者キー = ViewStateHolder.get(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保番号 = 対象者キー.get被保険者番号();
        ShikibetsuCode 識別コード = 対象者キー.get識別コード();
        List<HihokenshaDaicho> newHihoList = handler.createNewRirekiData(被保番号, 識別コード);

        List<HihokenshaDaicho> hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報_修正後, ArrayList.class);
        if (hihoDaicho == null) {
            hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報, ArrayList.class);
        }

        FlexibleDate shikakuShutokuDate = div.getTxtShutokuDate().getValue();
        ViewStateHolder.put(ViewStateKeys.対象者_資格取得日, shikakuShutokuDate);

        newHihoList.addAll(hihoDaicho);
        ArrayList serialNewHihoList = new ArrayList<>();
        serialNewHihoList.addAll(newHihoList);
        ViewStateHolder.put(ViewStateKeys.対象者_被保険者台帳情報_修正後, serialNewHihoList);

        div.getCcdJutokuDialogButton().initialize(ItemList.of(newHihoList), 被保番号, shikakuShutokuDate, JushochiTokureiState.登録);
        div.getCcdShikakuHenkoDialogButton().initialize(ItemList.of(newHihoList), 被保番号, 識別コード, shikakuShutokuDate, ShikakuHenkoState.登録);

        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        div.getShikakuShosaiDialogs().setDisabled(false);
        div.getBtnTokusoKakutei().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }
}
