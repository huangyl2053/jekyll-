/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0310003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.TsuchishoUchiwakeJoken;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbQuestionMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.DBB0310003TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310003.HonKakushuTsuchiUchiwakeKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0310003.HonKakushuTsuchiUchiwakeKakuninHandler;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteifuka.Honsanteifuka;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 打ち分け方法確認のPanelクラスです。
 *
 * @reamsid_L DBB-0780-020 gongliang
 */
public class HonKakushuTsuchiUchiwakeKakunin {

    private static final RString 保存名称R = new RString("保存名称");

    /**
     * 打ち分け方法確認画面の初期化メソッド。
     *
     * @param div HonKakushuTsuchiUchiwakeKakuninDiv
     * @return 打ち分け方法確認の画面。
     */
    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onLoad(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        List<TsuchishoUchiwakeJoken> 打分け方法List = 本算定賦課計算.getutiwakehouhoujyoho1();
        if (打分け方法List != null) {
            getHandler(div).show打分け方法(打分け方法List);
            RString 打ち分け条件 = 打分け方法List.get(0).get打ち分け条件();
            List<TsuchishoUchiwakeJoken> 方法情報一覧 = 本算定賦課計算.getutiwakehouhoujyoho2(打ち分け条件);
            if (方法情報一覧 != null) {
                getHandler(div).show打分け方法情報(方法情報一覧.get(0));
                ViewStateHolder.put(ViewStateKeys.打分け方法情報キー, 打ち分け条件);
            }
        } else {
            getHandler(div).show空の打分け();
            ViewStateHolder.put(ViewStateKeys.打分け方法情報キー, RString.EMPTY);
        }
        return createResponse(div);
    }

    /**
     * 打分け方法切替時の保存処理
     *
     * @param div HonKakushuTsuchiUchiwakeKakuninDiv
     * @return 打ち分け方法確認の画面
     */
    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onSelect(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        HonKakushuTsuchiUchiwakeKakuninHandler handler = getHandler(div);
        RString 切替前の打ち分け条件 = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);

        List<TsuchishoUchiwakeJoken> 打分け方法 = 本算定賦課計算.getutiwakehouhoujyoho2(切替前の打ち分け条件);
        boolean 変更flag = handler.変更有無(打分け方法.get(0));
        if (変更flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbbQuestionMessages.変更途中の内容破棄確認.getMessage().getCode(),
                        DbbQuestionMessages.変更途中の内容破棄確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            RString 打ち分け条件画面 = div.getTxtTsuchishoSetteiHozonMeisho().getValue();
            if (new RString(DbbQuestionMessages.変更途中の内容破棄確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No
                    && (打ち分け条件画面 == null || 打ち分け条件画面.isEmpty())) {
                throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(保存名称R.toString()).evaluate());
            } else if (new RString(DbbQuestionMessages.変更途中の内容破棄確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                TsuchishoUchiwakeJoken 変更打分け方法 = handler.get確認画面の打分け方法(false, 切替前の打ち分け条件, 切替前の打ち分け条件);
                handler.切替時保存処理(変更打分け方法);
            }
        }
        RString 打ち分け条件 = div.getHonKakushuTsuchiUchiwakeSentaku()
                .getDgKakushuTsuchiUchiwakeSentaku().getClickedItem().getTxtJokenMeisho();
        List<TsuchishoUchiwakeJoken> 打分け方法List = 本算定賦課計算.getutiwakehouhoujyoho1();
        if (打分け方法List != null) {
            getHandler(div).show打分け方法(打分け方法List);
        }
        List<TsuchishoUchiwakeJoken> 方法情報一覧 = 本算定賦課計算.getutiwakehouhoujyoho2(打ち分け条件);
        if (方法情報一覧 == null) {
            return createResponse(div);
        }
        handler.show打分け方法情報(方法情報一覧.get(0));
        div.getTxtTsuchishoSetteiHozonMeisho().setValue(打ち分け条件);
        ViewStateHolder.put(ViewStateKeys.打分け方法情報キー, 打ち分け条件);
        return createResponse(div);
    }

    /**
     * 「設定を保存する」ボタン押下時の保存処理
     *
     * @param div HonKakushuTsuchiUchiwakeKakuninDiv
     * @return 打ち分け方法確認の画面
     */
    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onClick_btnTsuchishoSetteiHozon(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        RString 打ち分け条件画面 = div.getTxtTsuchishoSetteiHozonMeisho().getValue();
        if (打ち分け条件画面 == null || 打ち分け条件画面.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(保存名称R.toString()).evaluate());
        }
        HonKakushuTsuchiUchiwakeKakuninHandler handler = getHandler(div);
        int 変更区分 = handler.変更区分();
        if (変更区分 == 1) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbbQuestionMessages.打分け方法名称の上書き確認.getMessage().getCode(),
                        DbbQuestionMessages.打分け方法名称の上書き確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbbQuestionMessages.打分け方法名称の上書き確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RString 打ち分け条件view = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);
                handler.設定時保存処理_変更区分(打ち分け条件画面, 打ち分け条件view);
                ViewStateHolder.put(ViewStateKeys.打分け方法情報キー, 打ち分け条件画面);
            }
        } else {
            RString 打ち分け条件view = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);
            handler.設定時保存処理_変更区分(打ち分け条件画面, 打ち分け条件view);
            ViewStateHolder.put(ViewStateKeys.打分け方法情報キー, 打ち分け条件画面);
        }
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        List<TsuchishoUchiwakeJoken> 打分け方法List = 本算定賦課計算.getutiwakehouhoujyoho1();
        if (打分け方法List != null) {
            getHandler(div).show打分け方法(打分け方法List);
            List<TsuchishoUchiwakeJoken> 方法情報一覧 = 本算定賦課計算.getutiwakehouhoujyoho2(打ち分け条件画面);
            if (方法情報一覧 != null) {
                getHandler(div).show打分け方法情報(方法情報一覧.get(0));
            }
        }
        return createResponse(div);
    }

    /**
     * 「設定を完了する」ボタンボタン押下時の保存処理
     *
     * @param div HonKakushuTsuchiUchiwakeKakuninDiv
     * @return 打ち分け方法確認の画面
     */
    public ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> onClick_btnSetteiKanryo(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        Honsanteifuka 本算定賦課計算 = Honsanteifuka.createInstance();
        HonKakushuTsuchiUchiwakeKakuninHandler handler = getHandler(div);
        RString 打ち分け条件view = ViewStateHolder.get(ViewStateKeys.打分け方法情報キー, RString.class);
        boolean 変更flag;
        if (打ち分け条件view == null || 打ち分け条件view.isEmpty()) {
            変更flag = handler.変更有無();
        } else {
            List<TsuchishoUchiwakeJoken> 打分け方法 = 本算定賦課計算.getutiwakehouhoujyoho2(打ち分け条件view);
            変更flag = handler.変更有無(打分け方法.get(0));
        }

        if (変更flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbbQuestionMessages.変更途中の内容破棄確認.getMessage().getCode(),
                        DbbQuestionMessages.変更途中の内容破棄確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbbQuestionMessages.変更途中の内容破棄確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                throw new ApplicationException(DbbInformationMessages.打分け方法保存指示.getMessage().evaluate());
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBB0310003TransitionEventName.完了).respond();
    }

    private HonKakushuTsuchiUchiwakeKakuninHandler getHandler(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        return new HonKakushuTsuchiUchiwakeKakuninHandler(div);
    }

    private ResponseData<HonKakushuTsuchiUchiwakeKakuninDiv> createResponse(HonKakushuTsuchiUchiwakeKakuninDiv div) {
        return ResponseData.of(div).respond();
    }
}
