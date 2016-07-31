/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB3110001;

import jp.co.ndensan.reams.db.dbb.business.core.fuka.NendobunFukaGemmenList;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.NendobunFukaGemmenListResult;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.DBB3110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001.GemmenJuminKihonHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001.GemmenJuminKihonValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.kaigohokenryogemmen.KaigoHokenryoGemmen;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey.Builder;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護保険料減免画面
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenJuminKihon {

    private static final RString 画面モード_取消 = new RString("取消");
    private static final RString 画面モード_訂正 = new RString("訂正");
    private static final RString 状況_申請 = new RString("申請");
    private static final RString 状況_決定 = new RString("決定");
    private static final RString 状況_訂正 = new RString("訂正した内容で、決定");
    private static final RString 処理_登録 = new RString("登録");
    private static final RString 処理_取消 = new RString("取消");
    private static final RString 発行ボタンSHOW = new RString("1");
    private static final RString 入力状況_新規申請 = new RString("新規_申請");
    private static final RString 入力状況_新規決定 = new RString("新規_決定");
    private static final RString 入力状況_申請中申請 = new RString("申請中_申請");
    private static final RString 入力状況_申請中決定 = new RString("申請中_決定");
    private static final RString 入力状況_申請中取消 = new RString("申請中_取消");
    private static final RString 入力状況_決定済訂正 = new RString("決定済_訂正");
    private static final RString 入力状況_決定済取消 = new RString("決定済_取消");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuServicehiShokaiMainDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<GemmenJuminKihonDiv> onLoad(GemmenJuminKihonDiv div) {
        GemmenJuminKihonHandler handler = getHandler(div);
        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = 賦課対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();
        FlexibleYear 調定年度 = 賦課対象者.get調定年度();
        TsuchishoNo 通知書番号 = 賦課対象者.get通知書番号();
        LasdecCode 市町村コード = 賦課対象者.get市町村コード();
        Builder builder = new Builder(通知書番号, 賦課年度, 市町村コード, 識別コード);
        KaigoFukaKihonSearchKey searchKey = builder.build();
        handler.loadヘッダパネル(識別コード, 被保険者番号, new FukaNendo(賦課年度), searchKey);
        NendobunFukaGemmenListResult 減免リスト = KaigoHokenryoGemmen.createInstance()
                .getJokyo(調定年度, 賦課年度, 通知書番号, 被保険者番号);
//        NendobunFukaGemmenListResult 減免リスト = handler.load全賦課履歴情報グリッド(被保険者番号, 賦課年度);
//        if (減免リスト != null) {
        ViewStateHolder.put(ViewStateKeys.年度分賦課減免リスト, 減免リスト.get年度分賦課減免リスト());
//            ViewStateHolder.put(ViewStateKeys.徴収方法, 減免リスト.get介護徴収方法());
//            GemmenJoho 最新減免の情報 = 減免リスト.get年度分賦課減免リスト().get最新減免の情報();
//            RString 状況 = handler.load状況情報パネル(最新減免の情報);
//            handler.load申請情報パネル(最新減免の情報);
//            handler.load決定情報パネル(最新減免の情報);
//            handler.load減免情報パネル(減免リスト);
//            handler.loadパネル状態1(状況, 減免リスト.get年度分賦課減免リスト());
//        } else {
//            handler.loadパネル状態2();
//        }
        return createResponse(div);
    }

    /**
     * 全賦課履歴情報グリッドの選択ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<GemmenJuminKihonDiv> onSelectBySelectButton_dgFukaRirekiAll(GemmenJuminKihonDiv div) {
        GemmenJuminKihonHandler handler = getHandler(div);
//        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.識別コード, HihokenshaNo.class);
        HihokenshaNo 被保険者番号 = new HihokenshaNo("8100001");
        NendobunFukaGemmenListResult 減免リスト = handler.onClick_選択ボタン(被保険者番号);
        ViewStateHolder.put(ViewStateKeys.年度分賦課減免リスト, 減免リスト.get年度分賦課減免リスト());
        ViewStateHolder.put(ViewStateKeys.徴収方法, 減免リスト.get介護徴収方法());
        GemmenJoho 最新減免の情報 = 減免リスト.get年度分賦課減免リスト().get最新減免の情報();
        RString 状況 = handler.load状況情報パネル(最新減免の情報);
        handler.load申請情報パネル(最新減免の情報);
        handler.load決定情報パネル(最新減免の情報);
        handler.load減免情報パネル(減免リスト);
        handler.loadパネル状態1(状況, 減免リスト.get年度分賦課減免リスト());
        return createResponse(div);
    }

    /**
     * 「訂正する」ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnTesei(GemmenJuminKihonDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード_訂正);
        getHandler(div).onClick_訂正の状態();
        return createResponse(div);
    }

    /**
     * 「取消する」ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnTorikeshi(GemmenJuminKihonDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード_取消);
        getHandler(div).onClick_取消の状態();
        return createResponse(div);
    }

    /**
     * 「計算する」ボタンを押下の事件です。
     *
     * @param div KogakuServicehiShokaiMainDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnCalculate(GemmenJuminKihonDiv div) {

        return createResponse(div);
    }

    /**
     * 「保存する」ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnUpt1(GemmenJuminKihonDiv div) {
        GemmenJuminKihonHandler handler = getHandler(div);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        NendobunFukaGemmenList 年度分賦課減免リスト = ViewStateHolder.get(ViewStateKeys.年度分賦課減免リスト, NendobunFukaGemmenList.class);
        GemmenJoho 最新減免の情報 = 年度分賦課減免リスト.get最新減免の情報();
        RString 入力状況 = handler.メッセージ判断(最新減免の情報, 画面モード);
        QuestionMessage message;
        if (入力状況_新規申請.equals(入力状況)) {
            // TODO メッセージ 「%1情報を%2します。よろしいですか？」 がありません。
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_申請.toString()).replace(処理_登録.toString()).evaluate());
        } else if (入力状況_新規決定.equals(入力状況)) {
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_決定.toString()).replace(処理_登録.toString()).evaluate());
        } else if (入力状況_申請中申請.equals(入力状況)) {
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_申請.toString()).replace(処理_登録.toString()).evaluate());
        } else if (入力状況_申請中決定.equals(入力状況)) {
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_決定.toString()).replace(処理_登録.toString()).evaluate());
        } else if (入力状況_申請中取消.equals(入力状況)) {
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_申請.toString()).replace(処理_取消.toString()).evaluate());
        } else if (入力状況_決定済訂正.equals(入力状況)) {
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_訂正.toString()).replace(処理_登録.toString()).evaluate());
        } else if (入力状況_決定済取消.equals(入力状況)) {
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_決定.toString()).replace(処理_取消.toString()).evaluate());
        } else {
            // TODO その他の場合、どのメッセージを出力ですが？
            message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().replace(状況_訂正.toString()).replace(処理_取消.toString()).evaluate());
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            handler.保存前の編集(最新減免の情報);
            handler.保存前チェック処理();
        }
        return ResponseData.of(div).setState(DBB3110001StateName.更新結果確認);
    }

    /**
     * 更新結果確認画面の初期化メソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnUpt(GemmenJuminKihonDiv div) {
        NendobunFukaGemmenList 年度分賦課減免リスト = ViewStateHolder.get(ViewStateKeys.年度分賦課減免リスト, NendobunFukaGemmenList.class);
        boolean show発行ボタン = getHandler(div).onClick_btnUpt(年度分賦課減免リスト);
        if (show発行ボタン) {
            ViewStateHolder.put(ViewStateKeys.実行フラグ, 発行ボタンSHOW);
        } else {
            ViewStateHolder.put(ViewStateKeys.実行フラグ, 処理_取消);
        }
        return ResponseData.of(div).setState(DBB3110001StateName.更新結果確認);
    }

    /**
     * 「発行する」ボタン押下のチックです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnPrtCheck(GemmenJuminKihonDiv div) {
        ValidationMessageControlPairs pairs = new GemmenJuminKihonValidationHandler(div).未指定のValidate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    /**
     * 「発行する」ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return SourceDataCollection
     */
    public ResponseData<SourceDataCollection> onClick_btnPrt(GemmenJuminKihonDiv div) {
        NendobunFukaGemmenList 年度分賦課減免リスト = ViewStateHolder.get(ViewStateKeys.年度分賦課減免リスト, NendobunFukaGemmenList.class);
        SourceDataCollection collection = getHandler(div).onClick_発行(年度分賦課減免リスト);
        return ResponseData.of(collection).respond();
    }

    /**
     * 「発行する」ボタンの制御です。
     *
     * @param div GemmenJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<GemmenJuminKihonDiv> onStateTransition(GemmenJuminKihonDiv div) {
        RString show発行ボタン = ViewStateHolder.get(ViewStateKeys.実行フラグ, RString.class);
        getHandler(div).onStateTransition(show発行ボタン);
        ViewStateHolder.put(ViewStateKeys.実行フラグ, 処理_取消);
        return createResponse(div);
    }

    private GemmenJuminKihonHandler getHandler(GemmenJuminKihonDiv div) {
        return new GemmenJuminKihonHandler(div);
    }

    private ResponseData<GemmenJuminKihonDiv> createResponse(GemmenJuminKihonDiv div) {
        return ResponseData.of(div).respond();
    }
}
