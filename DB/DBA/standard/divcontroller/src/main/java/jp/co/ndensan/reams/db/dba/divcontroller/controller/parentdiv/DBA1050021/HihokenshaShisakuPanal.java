/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1050021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.DBA1050021StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.DBA1050021TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021.HihokenshaShisakuPanalHandler;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.db.dba.service.core.nyutaishoshakanri.NyutaishoshaKanriFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.IAtenaShokaiSimple;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private static final Integer 被保履歴追加 = 1;
    private static final Integer 資格訂正修正 = 2;
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

        List<HihokenshaDaicho> hihoDaicho = ViewStateHolder.get(ViewStateKeys.対象者_被保険者台帳情報, ArrayList.class);
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
     * 「資格異動の訂正を保存する」ボタンの押下を処理です。
     *
     * @param div 被保険者資格詳細異動Div
     * @return ResponseData<HihokenshaShisakuPanalDiv> 被保険者資格詳細異動Div
     */
    public ResponseData<HihokenshaShisakuPanalDiv> onClick_btnSave(HihokenshaShisakuPanalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = is暦上日(div);
            if (pairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            資格異動訂正の保存処理(div);
            return ResponseData.of(div).forwardWithEventName(DBA1050021TransitionEventName.資格異動の訂正を保存する).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 資格異動訂正の保存処理(HihokenshaShisakuPanalDiv div) {
        施設入退所履歴期間重複チェック処理(div);
        List<HihokenshaDaicho> 資格訂正情報 = 資格訂正登録リスト取得処理(div);
        manager.checkShikakuTorukuList(資格訂正情報, get当該識別対象の生年月日(div));
        資格訂正処理(div, 資格訂正情報);
        //div.getShikakuShosai().getTabShisakuShosaiRireki().getCcdShisetsuNyutaishoRirekiKanri().saveShisetsuNyutaisho();
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
//        NyutaishoshaKanriFinder finder = NyutaishoshaKanriFinder.createInstance();
//        List<dgShisetsuNyutaishoRireki_Row> 施設入退所履歴一覧List
//                = div.getShikakuShosai().getTabShisakuShosaiRireki().getCcdShisetsuNyutaishoRirekiKanri().get施設入退所履歴一覧();
//        for (dgShisetsuNyutaishoRireki_Row 施設入退所履歴 : 施設入退所履歴一覧List) {
//            TextBoxFlexibleDate nyushoDate = 施設入退所履歴.getNyushoDate();
//            TextBoxFlexibleDate taishoDate = 施設入退所履歴.getTaishoDate();
//            RString 入所施設種類 = 施設入退所履歴.getShisetsuShuruiKey();
//            boolean checkFlag = finder.isRirekiKikanJufukuFlag(
//                    nyushoDate.getValue(),
//                    taishoDate.getValue(),
//                    入所施設種類);
//            if (checkFlag) {
//                throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
//            }
//        }
    }

    private List<HihokenshaDaicho> 資格訂正登録リスト取得処理(HihokenshaShisakuPanalDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        ShikakuRirekiJoho 資格詳細情報 = getHandler(div).get資格詳細情報();
        List<HihokenshaDaicho> 住所地特例情報 = null;
//                = div.getShikakuShosai().getTabShisakuShosaiRireki().getCcdJushochiTokureiRirekiList().getDataList();
        List<HihokenshaDaicho> 資格変更履歴情報 = null;
//                = div.getShikakuShosai().getTabShisakuShosaiRireki().getCcdShikakuHenkoRireki().getGridDataFor資格詳細異動().records();
        List<HihokenshaDaicho> 資格訂正登録リスト = new ArrayList<>();
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (状態_追加.equals(初期_状態)) {
            資格訂正登録リスト = manager.getShikakuTorukuList(
                    資格詳細情報, 住所地特例情報, 資格変更履歴情報,
                    被保険者番号,
                    識別コード,
                    被保履歴追加).records();
        }
        if (状態_修正.equals(初期_状態)) {
            資格訂正登録リスト = manager.getShikakuTorukuList(
                    資格詳細情報, 住所地特例情報, 資格変更履歴情報,
                    被保険者番号,
                    識別コード,
                    資格訂正修正).records();
        }
        return 資格訂正登録リスト;
    }

    private void 資格訂正処理(HihokenshaShisakuPanalDiv div, List<HihokenshaDaicho> 資格訂正情報) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleDate 取得日 = null;
        FlexibleDate 喪失日 = null;
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (状態_追加.equals(初期_状態)) {
            TextBoxFlexibleDate shutokuDate = div.getShikakuShosai().getTxtShutokuDate();
            TextBoxFlexibleDate soshitsuDate = div.getShikakuShosai().getTxtSoshitsuDate();
            if (shutokuDate != null) {
                取得日 = div.getShikakuShosai().getTxtShutokuDate().getValue();
            }
            if (soshitsuDate != null) {
                喪失日 = div.getShikakuShosai().getTxtSoshitsuDate().getValue();
            }
        }
        if (状態_修正.equals(初期_状態)) {
            取得日 = ViewStateHolder.get(ViewStateKeys.資格得喪情報, ShikakuRirekiJoho.class).getShutokuDate();
            喪失日 = ViewStateHolder.get(ViewStateKeys.資格得喪情報, ShikakuRirekiJoho.class).getSoshitsuDate();
        }
        manager.saveHihokenshaShikakuTeisei(被保険者番号, 取得日, 喪失日, 資格訂正情報);
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
            FlexibleDate 取得日 = ViewStateHolder.get(ViewStateKeys.資格得喪情報, ShikakuRirekiJoho.class).getShutokuDate();
            manager.deleteHihokenshaShikakuTeisei(被保険者番号, 取得日);
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
        ShikakuRirekiJoho 資格得喪情報 = ViewStateHolder.get(ViewStateKeys.資格得喪情報, ShikakuRirekiJoho.class);
        RString 導入形態コード = div.getHiddenDonyuKeitaiCode();
        if (広域保険者.equals(getHandler(div).広域と市町村判断()) && !RString.isNullOrEmpty(広域保険者)) {
            List<Shichoson> 旧保険者情報 = getHandler(div).旧保険者取得(
                    new LasdecCode(資格得喪情報.getShozaiHokensha()),
                    導入形態コード,
                    new LasdecCode(資格得喪情報.getSochimotoHokensha()));
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
}
