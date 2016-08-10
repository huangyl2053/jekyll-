/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB3110001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.NendobunFukaGemmenList;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.KaigoHokenryoGemmenParam;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.NendobunFukaGemmenListResult;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.DBB3110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001.GemmenJuminKihonHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001.GemmenJuminKihonValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.kaigohokenryogemmen.KaigoHokenryoGemmen;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey.Builder;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
//    private static final RString 状況_申請 = new RString("申請");
//    private static final RString 状況_決定 = new RString("決定");
//    private static final RString 状況_訂正 = new RString("訂正した内容で、決定");
//    private static final RString 処理_登録 = new RString("登録");
    private static final RString 処理_取消 = new RString("取消");
    private static final RString 発行ボタンSHOW = new RString("1");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString 定値_イチ = new RString("1");
//    private static final RString 入力状況_新規申請 = new RString("新規_申請");
//    private static final RString 入力状況_新規決定 = new RString("新規_決定");
//    private static final RString 入力状況_申請中申請 = new RString("申請中_申請");
//    private static final RString 入力状況_申請中決定 = new RString("申請中_決定");
//    private static final RString 入力状況_申請中取消 = new RString("申請中_取消");
//    private static final RString 入力状況_決定済訂正 = new RString("決定済_訂正");
//    private static final RString 入力状況_決定済取消 = new RString("決定済_取消");

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
        TsuchishoNo 通知書番号 = 賦課対象者.get通知書番号();
        LasdecCode 市町村コード = 賦課対象者.get市町村コード();
        Builder builder = new Builder(通知書番号, 賦課年度, 市町村コード, 識別コード);
        KaigoFukaKihonSearchKey searchKey = builder.build();

        handler.loadヘッダパネル(識別コード, searchKey);

        // TODO QA1131 viewStateの賦課年度（ただし、検索画面で「全年度」を指定した場合は空白）  どのをより判断ですが？
        IItemList<Fuka> 全賦課履歴データ = handler.load全賦課履歴情報グリッド(被保険者番号, new FukaNendo(賦課年度));
        if (全賦課履歴データ == null) {
            ValidationMessageControlPairs pairs = new GemmenJuminKihonValidationHandler(div).賦課情報の存在チェック();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        } else {
            if (!全賦課履歴データ.isEmpty()) {
                Fuka 賦課基本 = 全賦課履歴データ.toList().get(0);
                NendobunFukaGemmenListResult 減免リスト = KaigoHokenryoGemmen.createInstance()
                        .getJokyo(賦課基本.get調定年度(), 賦課基本.get賦課年度(),
                                div.getCcdKaigoFukaKihon().get通知書番号(), div.getCcdKaigoFukaKihon().get被保番号());
                load(減免リスト, div);
            } else {
                handler.loadパネル状態2();
            }
        }
        return createResponse(div);
    }

    /**
     * 全賦課履歴情報グリッドの選択ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<GemmenJuminKihonDiv> onSelectBySelectButton_dgFukaRirekiAll(GemmenJuminKihonDiv div) {
        // TODO QA932 選択された全賦課履歴情報グリッドの明細の取得メソッドがありません。
        GemmenJuminKihonHandler handler = getHandler(div);
        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        NendobunFukaGemmenListResult 減免リスト = handler.onClick_選択ボタン(被保険者番号);
        load(減免リスト, div);
        return createResponse(div);
    }

    private void load(NendobunFukaGemmenListResult 減免リスト, GemmenJuminKihonDiv div) {
        GemmenJuminKihonHandler handler = getHandler(div);
        ViewStateHolder.put(ViewStateKeys.年度分賦課減免リスト, 減免リスト.get年度分賦課減免リスト());
        ViewStateHolder.put(ViewStateKeys.徴収方法, 減免リスト.get介護徴収方法());
        ViewStateHolder.put(ViewStateKeys.賦課年度, 減免リスト.get年度分賦課減免リスト().get賦課年度());
        GemmenJoho 最新減免の情報 = 減免リスト.get年度分賦課減免リスト().get最新減免の情報();
        RString 状況 = handler.load状況情報パネル(最新減免の情報);
        Code 減免種類コード = handler.load申請情報パネル(最新減免の情報);
        ViewStateHolder.put(ViewStateKeys.減免種類コード, 減免種類コード);
        handler.load決定情報パネル(最新減免の情報);
        handler.load減免情報パネル(減免リスト);
        handler.loadパネル状態1(状況, 減免リスト.get年度分賦課減免リスト());
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
        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();
        NendobunFukaGemmenList 年度分賦課減免リスト = ViewStateHolder.get(ViewStateKeys.年度分賦課減免リスト, NendobunFukaGemmenList.class);
        Map<RString, List> map = getHandler(div).計算する(年度分賦課減免リスト, 賦課年度, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.減免後の普徴金額LIST, (ArrayList) map.get(定値_ゼロ));
        ViewStateHolder.put(ViewStateKeys.減免後の特徴と過年度金額LIST, (ArrayList) map.get(定値_イチ));
        return createResponse(div);
    }

    /**
     * 「保存する」ボタン押下のメソッドです。
     *
     * @param div GemmenJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<GemmenJuminKihonDiv> onClick_btnUpt(GemmenJuminKihonDiv div) {
        NendobunFukaGemmenList 年度分賦課減免リスト = ViewStateHolder.get(ViewStateKeys.年度分賦課減免リスト, NendobunFukaGemmenList.class);
        GemmenJoho 最新減免の情報 = 年度分賦課減免リスト.get最新減免の情報();
        GemmenJuminKihonValidationHandler validationHandler = new GemmenJuminKihonValidationHandler(div);
        ValidationMessageControlPairs pairs = validationHandler.減免額の整合性チェック();
        pairs.add(validationHandler.決定日の必須入力チェック());
        pairs.add(validationHandler.減免額の必須入力チェック());
        pairs.add(validationHandler.計算処理の未実行チェック(最新減免の情報));
        pairs.add(validationHandler.減免額の整合性チェック２(最新減免の情報));
        pairs.add(validationHandler.決定日の必須入力チェック２());
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        GemmenJuminKihonHandler handler = getHandler(div);
        // TODO QA1158 メッセージ 「%1情報を%2します。よろしいですか？」 がありません。
//        RString 入力状況 = handler.メッセージ判断(最新減免の情報, 画面モード);
//        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
//        QuestionMessage message = null;
//        if (入力状況_新規申請.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_申請.toString()).replace(処理_登録.toString()).evaluate());
//        } else if (入力状況_新規決定.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_決定.toString()).replace(処理_登録.toString()).evaluate());
//        } else if (入力状況_申請中申請.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_申請.toString()).replace(処理_登録.toString()).evaluate());
//        } else if (入力状況_申請中決定.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_決定.toString()).replace(処理_登録.toString()).evaluate());
//        } else if (入力状況_申請中取消.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_申請.toString()).replace(処理_取消.toString()).evaluate());
//        } else if (入力状況_決定済訂正.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_訂正.toString()).replace(処理_登録.toString()).evaluate());
//        } else if (入力状況_決定済取消.equals(入力状況)) {
//            message = new QuestionMessage(DbzQuestionMessages.判断基準より前の日付.getMessage().getCode(),
//                    DbzQuestionMessages.判断基準より前の日付.getMessage().replace(状況_決定.toString()).replace(処理_取消.toString()).evaluate());
//        }
        QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                UrQuestionMessages.保存の確認.getMessage().evaluate());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
            HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
            FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();
            List<Decimal> 減免後の普徴金額LIST = ViewStateHolder.get(ViewStateKeys.減免後の普徴金額LIST, List.class);
            List<Decimal> 減免後の特徴と過年度金額LIST = ViewStateHolder.get(ViewStateKeys.減免後の特徴と過年度金額LIST, List.class);
            年度分賦課減免リスト = handler.保存前の編集(年度分賦課減免リスト, 賦課年度, 被保険者番号, 減免後の普徴金額LIST, 減免後の特徴と過年度金額LIST);
            ViewStateHolder.put(ViewStateKeys.年度分賦課減免リスト, 年度分賦課減免リスト);
            Code 減免種類コード = ViewStateHolder.get(ViewStateKeys.減免種類コード, Code.class);
            Code 取消種類コード = ViewStateHolder.get(ViewStateKeys.取消種類コード, Code.class);
            KaigoHokenryoGemmenParam 画面情報param = handler.get画面情報param(減免種類コード, 取消種類コード);
            KaigoHokenryoGemmen.createInstance().saveDBDate(年度分賦課減免リスト.get最新減免の情報(), 画面情報param);
            boolean show発行ボタン = getHandler(div).onClick_btnUpt(年度分賦課減免リスト);
            if (show発行ボタン) {
                ViewStateHolder.put(ViewStateKeys.実行フラグ, 発行ボタンSHOW);
            } else {
                ViewStateHolder.put(ViewStateKeys.実行フラグ, 処理_取消);
            }
            return ResponseData.of(div).setState(DBB3110001StateName.更新結果確認);
        }
        return createResponse(div);
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

    /**
     * onOkClose_btnTorikeshiShurui事件です。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<GemmenJuminKihonDiv> onOkClose_btnTorikeshiShurui(GemmenJuminKihonDiv div) {
        Code 取消種類code = getHandler(div).onOkClose取消種類();
        ViewStateHolder.put(ViewStateKeys.取消種類コード, 取消種類code);
        return createResponse(div);
    }

    /**
     * onOkClose_btnGemmenShurui事件です。
     *
     * @param div HanyorisutoPanelDiv
     * @return ResponseData
     */
    public ResponseData<GemmenJuminKihonDiv> onOkClose_btnGemmenShurui(GemmenJuminKihonDiv div) {
        Code 減免種類code = getHandler(div).onOkClose減免種類();
        ViewStateHolder.put(ViewStateKeys.減免種類コード, 減免種類code);
        return createResponse(div);
    }

    private GemmenJuminKihonHandler getHandler(GemmenJuminKihonDiv div) {
        return new GemmenJuminKihonHandler(div);
    }

    private ResponseData<GemmenJuminKihonDiv> createResponse(GemmenJuminKihonDiv div) {
        return ResponseData.of(div).respond();
    }
}
