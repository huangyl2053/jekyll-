/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB3150001;

import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kaigofukachoshuyuyo.KaigoFukaChoshuYuyoParam;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.DBB3150001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001.ChoshuYuyoJuminKihonHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001.ChoshuYuyoJuminKihonValidationHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001.ChoshuYuyoPrintinfoHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001.ChoshuYuyoPrintinfoValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukachoshuyuyo.KaigoFukaChoshuYuyo;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
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
 * 介護保険料徴収猶予画面のクラスです。
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ChoshuYuyoJuminKihon {

    private static final int ゼロ_定値 = 0;
    private static final int イチ_定値 = 1;
    private static final RString 画面モード_取消 = new RString("取消");
    private static final RString 画面モード_訂正 = new RString("訂正");
//    private static final RString 状況_申請 = new RString("申請");
//    private static final RString 状況_決定 = new RString("決定");
//    private static final RString 処理_取消 = new RString("取消");
//    private static final RString 状況_訂正 = new RString("訂正した内容で、決定");
//    private static final RString 処理_登録 = new RString("登録");
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
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onLoad(ChoshuYuyoJuminKihonDiv div) {
        ChoshuYuyoJuminKihonHandler handler = getHandler(div);
        FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        ShikibetsuCode 識別コード = 賦課対象者.get識別コード();
        HihokenshaNo 被保険者番号 = 賦課対象者.get被保険者番号();
        FlexibleYear 賦課年度 = 賦課対象者.get賦課年度();
        TsuchishoNo 通知書番号 = 賦課対象者.get通知書番号();
        LasdecCode 市町村コード = 賦課対象者.get市町村コード();
        KaigoFukaKihonSearchKey.Builder builder = new KaigoFukaKihonSearchKey.Builder(通知書番号, 賦課年度, 市町村コード, 識別コード);
        KaigoFukaKihonSearchKey searchKey = builder.build();

        handler.loadヘッダパネル(識別コード, searchKey);
        int 全賦課履歴データ件数 = handler.load全賦課履歴情報グリッド(被保険者番号, new FukaNendo(賦課年度));
        if (全賦課履歴データ件数 == ゼロ_定値) {
            handler.setDisabled制御();
            handler.loadパネル状態2();
            handler.set全賦課履歴情報Visible(true);
            ValidationMessageControlPairs pairs = new ChoshuYuyoJuminKihonValidationHandler(div).賦課情報の存在チェック();
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else if (全賦課履歴データ件数 == イチ_定値) {
            Fuka 賦課基本 = handler.get賦課基本();
            ChoshuYuyoJoho 徴収猶予の情報 = KaigoFukaChoshuYuyo.createInstance()
                    .getJokyo(賦課基本.get調定年度(), 賦課基本.get賦課年度(), 賦課基本.get通知書番号());
            load(徴収猶予の情報, div);
            handler.set全賦課履歴情報Visible(false);
        } else {
            handler.loadパネル状態2();
            handler.set全賦課履歴情報Visible(true);
        }
        return createResponse(div);
    }

    /**
     * 全賦課履歴情報グリッドの選択ボタン押下のメソッドです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onSelectBySelectButton_dgFukaRirekiAll(ChoshuYuyoJuminKihonDiv div) {
        ChoshuYuyoJuminKihonHandler handler = getHandler(div);
        handler.clear();
        ChoshuYuyoJoho 徴収猶予の情報 = handler.onClick_選択ボタン();
        load(徴収猶予の情報, div);
        handler.set全賦課履歴情報Visible(true);
        return createResponse(div);
    }

    private Decimal load(ChoshuYuyoJoho 徴収猶予の情報, ChoshuYuyoJuminKihonDiv div) {
        ChoshuYuyoJuminKihonHandler handler = getHandler(div);
        if (徴収猶予の情報 != null) {
            ViewStateHolder.put(ViewStateKeys.徴収猶予の情報, 徴収猶予の情報);
            ViewStateHolder.put(ViewStateKeys.賦課年度, 徴収猶予の情報.get賦課年度());
        }
        RString 状況 = handler.load状況情報パネル(徴収猶予の情報);
        Code 減免種類コード = handler.load申請情報パネル(徴収猶予の情報);
        ViewStateHolder.put(ViewStateKeys.猶予種類コード, 減免種類コード);
        handler.load決定情報パネル(徴収猶予の情報);
        Decimal 普通徴収_合計 = handler.load普通徴収猶予情報パネル(徴収猶予の情報);
        handler.loadパネル状態1(状況, 徴収猶予の情報);
        return 普通徴収_合計;
    }

    /**
     * 「訂正する」ボタン押下のメソッドです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onClick_btnTesei(ChoshuYuyoJuminKihonDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード_訂正);
        getHandler(div).onClick_訂正の状態();
        return createResponse(div);
    }

    /**
     * 「取消する」ボタン押下のメソッドです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onClick_btnTorikeshi(ChoshuYuyoJuminKihonDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード_取消);
        getHandler(div).onClick_取消の状態();
        return createResponse(div);
    }

    /**
     * 取消種類選択ボタンのonOkClose事件です。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onOkClose_btnTorikeshiShurui(ChoshuYuyoJuminKihonDiv div) {
        Code 取消種類code = getHandler(div).onOkClose取消種類();
        ViewStateHolder.put(ViewStateKeys.取消種類コード, 取消種類code);
        return createResponse(div);
    }

    /**
     * 猶予種類選択ボタンのonOkClose事件です。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onOkClose_btnGemmenShurui(ChoshuYuyoJuminKihonDiv div) {
        Code 猶予種類code = getHandler(div).onOkClose猶予種類();
        ViewStateHolder.put(ViewStateKeys.猶予種類コード, 猶予種類code);
        return createResponse(div);
    }

    /**
     * 「保存する」ボタン押下のメソッドです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 更新結果確認画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onClick_btnUpt(ChoshuYuyoJuminKihonDiv div) {
        ChoshuYuyoJoho 徴収猶予の情報 = ViewStateHolder.get(ViewStateKeys.徴収猶予の情報, ChoshuYuyoJoho.class);
        ChoshuYuyoJuminKihonHandler handler = getHandler(div);
        // TODO QA1158 メッセージ 「%1情報を%2します。よろしいですか？」 がありません。
//        RString 入力状況 = handler.メッセージ判断(徴収猶予の情報);
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
            Code 猶予種類コード = ViewStateHolder.get(ViewStateKeys.猶予種類コード, Code.class);
            Code 取消種類コード = ViewStateHolder.get(ViewStateKeys.取消種類コード, Code.class);
            KaigoFukaChoshuYuyoParam 画面情報param = handler.get画面情報param(徴収猶予の情報, 猶予種類コード, 取消種類コード);
            KaigoFukaChoshuYuyo.createInstance().saveDBDate(徴収猶予の情報, 画面情報param);
            createHandler(div).initialize(徴収猶予の情報.get賦課年度(), 徴収猶予の情報.get調定年度(), 徴収猶予の情報.get通知書番号());
            return ResponseData.of(div).setState(DBB3150001StateName.更新結果確認);
        }
        return createResponse(div);
    }

    /**
     * 「取消をやめる」と「訂正をやめる」ボタン押下のメソッドです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return 介護保険料徴収猶予画面
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onClick_btnTorikeshiCansel(ChoshuYuyoJuminKihonDiv div) {
        ChoshuYuyoJuminKihonHandler handler = getHandler(div);
        ChoshuYuyoJoho 徴収猶予の情報 = ViewStateHolder.get(ViewStateKeys.徴収猶予の情報, ChoshuYuyoJoho.class);
        RString 状況 = handler.load状況情報パネル(徴収猶予の情報);
        handler.loadパネル状態1(状況, 徴収猶予の情報);
        handler.setRequired();
        return createResponse(div);
    }

    /**
     * 「発行する」ボタン押下のチックです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return ResponseData
     */
    public ResponseData<ChoshuYuyoJuminKihonDiv> onClick_btnPrtCheck(ChoshuYuyoJuminKihonDiv div) {
        ValidationMessageControlPairs pairs = new ChoshuYuyoPrintinfoValidationHandler(div).未指定のValidate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン事件のメソッドです。
     *
     * @param div ChoshuYuyoJuminKihonDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnExcute(ChoshuYuyoJuminKihonDiv div) {

        ChoshuYuyoJoho 徴収猶予の情報 = ViewStateHolder.get(ViewStateKeys.徴収猶予の情報, ChoshuYuyoJoho.class);
        SourceDataCollection data = createHandler(div).onClick発行する(徴収猶予の情報.get賦課年度(), 徴収猶予の情報.get調定年度(), 徴収猶予の情報.get通知書番号());
        return ResponseData.of(data).respond();
    }

    private ChoshuYuyoPrintinfoHandler createHandler(ChoshuYuyoJuminKihonDiv div) {
        return new ChoshuYuyoPrintinfoHandler(div);
    }

    private ChoshuYuyoJuminKihonHandler getHandler(ChoshuYuyoJuminKihonDiv div) {
        return new ChoshuYuyoJuminKihonHandler(div);
    }

    private ResponseData<ChoshuYuyoJuminKihonDiv> createResponse(ChoshuYuyoJuminKihonDiv div) {
        return ResponseData.of(div).respond();
    }
}
