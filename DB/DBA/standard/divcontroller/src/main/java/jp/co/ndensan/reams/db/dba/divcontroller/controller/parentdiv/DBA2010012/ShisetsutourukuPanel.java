/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010012;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012.DBA2010012StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012.ShisetsutourukuPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010012.ShisetsutourukuPanelHandler;
import jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri.KaigoJigyoshaShisetsuKanriManager;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 施設登録のクラスです。
 *
 * @reamsid_L DBA-0340-040 wanghui
 */
public class ShisetsutourukuPanel {

    private static final RString 追加 = new RString("追加状態");
    private static final RString 修正 = new RString("修正状態");
    private static final RString 削除 = new RString("削除状態");
    private static final RString 照会 = new RString("照会状態");
    private static final RString 事業者種別 = new RString("21");
    private RString 変更区分;
    private final KaigoJigyoshaShisetsuKanriManager manager;

    /**
     * コンストラクタです。
     */
    public ShisetsutourukuPanel() {
        manager = KaigoJigyoshaShisetsuKanriManager.createInstance();
    }

    /**
     * 初期化の設定します。
     *
     * @param div ShisetsutourukuPanel
     * @return ResponseData<ShisetsutourukuPanel>
     */
    public ResponseData<ShisetsutourukuPanelDiv> onLoad(ShisetsutourukuPanelDiv div) {
        if (追加.equals(ViewStateHolder.get(ViewStateKeys.介護事業者_状態, RString.class))) {
            getHandler(div).initialize();
            return ResponseData.of(div).setState(DBA2010012StateName.追加状態);
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.介護事業者_状態, RString.class))) {
            getHandler(div).initialize();
            List<KaigoJogaiTokureiTaishoShisetsu> list = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter(div)).records();
            getHandler(div).set施設情報エリア(list);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010012StateName.修正状態);
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.介護事業者_状態, RString.class))) {
            getHandler(div).initialize();
            List<KaigoJogaiTokureiTaishoShisetsu> list = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter(div)).records();
            getHandler(div).set施設情報エリア(list);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010012StateName.削除状態);
        }
        if (照会.equals(ViewStateHolder.get(ViewStateKeys.介護事業者_状態, RString.class))) {
            getHandler(div).initialize();
            List<KaigoJogaiTokureiTaishoShisetsu> list = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter(div)).records();
            getHandler(div).set施設情報エリア(list);
            return ResponseData.of(div).setState(DBA2010012StateName.照会状態);
        }
        ViewStateHolder.put(ViewStateKeys.サービス登録_有効開始日, div.getTxtShisetsuYukoKaishiYMD().getValue());
        ViewStateHolder.put(ViewStateKeys.サービス登録_サービス情報, KaigoJogaiTokureiTaishoShisetsu.class);
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者種類の変更した時。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> onChange_ServiceShurui(ShisetsutourukuPanelDiv div) {
        getHandler(div).set事業者種類();
        return ResponseData.of(div).respond();
    }

    /**
     * 施設情報を保存する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> onClick_HoZonn(ShisetsutourukuPanelDiv div) {
        if (追加.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の追加処理(div);
            }
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の修正処理(div);
            }
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の削除処理(div);
            }
        }
        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    /**
     * 「完了する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> btnComplete(ShisetsutourukuPanelDiv div) {
        //TODO: 前排他制御

        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    /**
     * 「再検索する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> onClick_Search(ShisetsutourukuPanelDiv div) {
        //TODO: 前排他制御
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShisetsutourukuPanelHandler getHandler(ShisetsutourukuPanelDiv div) {
        return new ShisetsutourukuPanelHandler(div);
    }

    private void set有効期間合理性チェック(ShisetsutourukuPanelDiv div) {
        JigyoshaMode mode = ViewStateHolder.get(ViewStateKeys.介護事業者_介護事業者情報, JigyoshaMode.class);
        KaigoJigyoshaParameter paramter = KaigoJigyoshaParameter
                .createParam(mode.getJigyoshaNo() == null ? RString.EMPTY : mode.getJigyoshaNo().value(),
                        div.getTxtShisetsuYukoKaishiYMD().getValue(),
                        ViewStateHolder.get(ViewStateKeys.サービス登録_サービス種類コード, RString.class),
                        div.getTxtShisetsuYukoShuryoYMD().getValue());

        KaigoJogaiTokureiParameter 重複paramter = KaigoJogaiTokureiParameter
                .createParam(RString.EMPTY,
                        div.getTxtShisetsuYukoKaishiYMD().getValue(),
                        div.getTxtShisetsuYukoShuryoYMD().getValue());
        if (!manager.checkKikanGorisei(重複paramter)) {
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
        if (!manager.checkKikanJufuku(paramter)) {
            throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
        }
    }

    private KaigoJigyoshaShisetsuKanriMapperParameter 事業者情報取得paramter(ShisetsutourukuPanelDiv div) {
        JigyoshaMode mode = ViewStateHolder.get(ViewStateKeys.介護事業者_介護事業者情報, JigyoshaMode.class);
        return KaigoJigyoshaShisetsuKanriMapperParameter
                .createParam(div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(),
                        new FlexibleDate(mode.getYukoKaishiYMD()),
                        mode.getJigyoshaNo() == null ? RString.EMPTY : mode.getJigyoshaNo().value(),
                        ViewStateHolder.get(ViewStateKeys.サービス登録_サービス種類コード, RString.class),
                        FlexibleDate.EMPTY);
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の検索処理(ShisetsutourukuPanelDiv div) {
        List<KaigoJogaiTokureiTaishoShisetsu> 事業者登録情報List = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter(div)).records();
        KaigoJogaiTokureiTaishoShisetsu business = null;
        if (!事業者登録情報List.isEmpty()) {
            business = 事業者登録情報List.get(0);
        }
        ViewStateHolder.put(ViewStateKeys.サービス登録_サービス情報, business);
        getHandler(div).set施設情報エリア(事業者登録情報List);
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の追加処理(ShisetsutourukuPanelDiv div) {
        KaigoJogaiTokureiTaishoShisetsu business = new KaigoJogaiTokureiTaishoShisetsu(div.getTxtShisetsuJigyoshaNo().getValue(),
                div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(), div.getTxtShisetsuYukoKaishiYMD().getValue());
        KaigoJogaiTokureiTaishoShisetsuBuilder builde = business.createBuilderForEdit();
        builde.set有効開始年月日(div.getTxtShisetsuYukoKaishiYMD().getValue());
        builde.set有効終了年月日(div.getTxtShisetsuYukoShuryoYMD().getValue());
        builde.set管内_管外区分(div.getRadShisetsuKannaiKangaiKubun().getSelectedKey());
        builde.set事業者番号(div.getTxtShisetsuJigyoshaNo().getValue());
        builde.set事業者名称(new AtenaMeisho(div.getTxtShisetsuJigyoshaName().getValue()));
        builde.set事業者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuJigyoshaNameKana().getValue()));
        builde.set事業開始年月日(div.getTxtShisetsuJigyoKaishiYMD().getValue());
        builde.set事業休止年月日(div.getTxtShisetsuJigyoKyushuYMD().getValue());
        builde.set事業再開年月日(div.getTxtShisetsuJigyoSaikaiYMD().getValue());
        builde.set事業廃止年月日(div.getTxtShisetsuJigyoHaishiYMD().getValue());
        builde.set郵便番号(div.getTxtShisetsuYubinNo().getValue());
        builde.set電話番号(new TelNo(div.getTxtShisetsuTelNo().getValue()));
        builde.setFax番号(new TelNo(div.getTxtShisetsuFaxNo().getValue()));
        builde.set事業者住所(div.getTxtShisetsuJusho().getValue());
        builde.set事業者住所カナ(div.getTxtShisetsuJushoKana().getValue());
        builde.set代表者名称(new AtenaMeisho(div.getTxtShisetsuDaihyoshaName().getValue()));
        builde.set代表者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuDaihyoshaNameKana().getValue()));
        builde.set役職(div.getTxtShisetsuYakushoku().getValue());
        builde.set備考(div.getTxtShisetsuBiko().getValue());
        business = builde.build();
        set有効期間合理性チェック(div);
        manager.insertJigyoshaJoho(null, 事業者種別, business);
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("追加").evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の修正処理(ShisetsutourukuPanelDiv div) {
        KaigoJogaiTokureiTaishoShisetsu 事業者情報
                = ViewStateHolder.get(ViewStateKeys.サービス登録_サービス情報, KaigoJogaiTokureiTaishoShisetsu.class);
        事業者情報.toEntity().setState(EntityDataState.Modified);
        KaigoJogaiTokureiTaishoShisetsuBuilder builde = 事業者情報.createBuilderForEdit();
        builde.set有効開始年月日(div.getTxtShisetsuYukoKaishiYMD().getValue());
        builde.set有効終了年月日(div.getTxtShisetsuYukoShuryoYMD().getValue());
        builde.set管内_管外区分(div.getRadShisetsuKannaiKangaiKubun().getSelectedKey());
        builde.set事業者番号(div.getTxtShisetsuJigyoshaNo().getValue());
        builde.set事業者名称(new AtenaMeisho(div.getTxtShisetsuJigyoshaName().getValue()));
        builde.set事業者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuJigyoshaNameKana().getValue()));
        builde.set事業開始年月日(div.getTxtShisetsuJigyoKaishiYMD().getValue());
        builde.set事業休止年月日(div.getTxtShisetsuJigyoKyushuYMD().getValue());
        builde.set事業再開年月日(div.getTxtShisetsuJigyoSaikaiYMD().getValue());
        builde.set事業廃止年月日(div.getTxtShisetsuJigyoHaishiYMD().getValue());
        builde.set郵便番号(div.getTxtShisetsuYubinNo().getValue());
        builde.set電話番号(new TelNo(div.getTxtShisetsuTelNo().getValue()));
        builde.setFax番号(new TelNo(div.getTxtShisetsuFaxNo().getValue()));
        builde.set事業者住所(div.getTxtShisetsuJusho().getValue());
        builde.set事業者住所カナ(div.getTxtShisetsuJushoKana().getValue());
        builde.set代表者名称(new AtenaMeisho(div.getTxtShisetsuDaihyoshaName().getValue()));
        builde.set代表者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuDaihyoshaNameKana().getValue()));
        builde.set役職(div.getTxtShisetsuYakushoku().getValue());
        builde.set備考(div.getTxtShisetsuBiko().getValue());
        事業者情報 = builde.build();
        set有効期間合理性チェック(div);
        変更区分 = new RString("1");
        if (ViewStateHolder.get(ViewStateKeys.サービス登録_有効開始日, FlexibleDate.class).equals(div.getTxtShisetsuYukoKaishiYMD().getValue())) {
            変更区分 = new RString("2");
            manager.updateJigyoshaJoho(null, 事業者種別, 事業者情報, 変更区分);
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("修正").evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
        }
        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の削除処理(ShisetsutourukuPanelDiv div) {
        KaigoJogaiTokureiTaishoShisetsu 事業者情報
                = ViewStateHolder.get(ViewStateKeys.サービス登録_サービス情報, KaigoJogaiTokureiTaishoShisetsu.class);
        事業者情報.toEntity().setState(EntityDataState.Deleted);
        事業者情報 = 事業者情報.deleted();
        manager.saveOrDelete(事業者情報);
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("削除").evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }
}
