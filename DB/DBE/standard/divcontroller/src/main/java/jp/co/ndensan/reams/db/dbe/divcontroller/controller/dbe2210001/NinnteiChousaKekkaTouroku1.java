/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1Handler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1 {

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString 登録グループコード_1 = new RString("1");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 施設 = new RString("施設");
    private static final RString カンマ = new RString(",");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;
    private static final RString 厚労省IF識別コード_02A = new RString("02A");
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_99A = new RString("99A");
    private static final int データベース内連番_1 = 1;
    private static final int データベース内連番_2 = 2;
    private static final int データベース内連番_3 = 3;
    private static final int データベース内連番_4 = 4;
    private static final int データベース内連番_5 = 5;
    private static final int データベース内連番_6 = 6;
    private static final int データベース内連番_7 = 7;
    private static final int データベース内連番_8 = 8;
    private static final int データベース内連番_9 = 9;
    private static final int データベース内連番_10 = 10;
    private static final int データベース内連番_11 = 11;
    private static final int データベース内連番_12 = 12;
    private static final int データベース内連番_13 = 13;
    private static final int データベース内連番_14 = 14;
    private static final int データベース内連番_15 = 15;
    private static final int データベース内連番_16 = 16;
    private static final int データベース内連番_17 = 17;
    private static final int データベース内連番_18 = 18;
    private static final int データベース内連番_19 = 19;
    private static final int データベース内連番_20 = 20;

    /**
     * 認定調査結果登録1の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onLoad(NinnteiChousaKekkaTouroku1Div div) {

        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBE2210001StateName.調査結果登録);
    }

    /**
     * 現在のサービス区分radのonChange処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_radGenzaiService(NinnteiChousaKekkaTouroku1Div div) {

        boolean 変更あり = false;
        RString 選択値 = div.getRadGenzaiservis().getSelectedKey();
        RString 変更前の設定値;
        RString 現在の設定値 = RString.EMPTY;
        if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の予防給付サービス, RString.class);
        } else if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
            for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の介護給付サービス, RString.class);
        } else {
            getHandler(div).予防給付サービス非表示();
            getHandler(div).介護給付サービス非表示();
            ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 選択値);
            return ResponseData.of(div).respond();
        }
        RString 元の選択 = ViewStateHolder.get(Dbe2210001Keys.現在のサービス区分, RString.class);
        if (!元の選択.equals(なし_選択)) {
            変更あり = !現在の設定値.toString().equalsIgnoreCase(変更前の設定値.toString());
        }

        if (変更あり && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getRadGenzaiservis().setSelectedKey(元の選択);
            return ResponseData.of(div).respond();
        }
        getHandler(div).在宅編集内容の破棄(選択値);
        ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 選択値);
        return ResponseData.of(div).respond();
    }

    /**
     * 「在宅・施設」tplのクリック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_tabChosaBasho(NinnteiChousaKekkaTouroku1Div div) {
        RString title = div.getTabChosaBasho().getSelectedItem().getTitle();
        if (在宅.equals(title)) {
            return 在宅クリック(div);
        } else if (施設.equals(title)) {
            return 施設クリック(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 在宅tplのクリック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    private ResponseData<NinnteiChousaKekkaTouroku1Div> 在宅クリック(NinnteiChousaKekkaTouroku1Div div) {

        RString 実施場所 = RString.EMPTY;  // TODO div.getCcdChosaJisshishaJoho()  実施場所の判断  3月実装予定#74645
        if (ChosaJisshiBashoCode.自宅外.getコード().equals(実施場所)) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.自宅外で在宅.getMessage().getCode(),
                    DbeWarningMessages.自宅外で在宅.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbeWarningMessages.自宅外で在宅.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            // TODO 「概況調査場所は」在宅”にset  divは3月実装予定#74645
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設tplのクリック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    private ResponseData<NinnteiChousaKekkaTouroku1Div> 施設クリック(NinnteiChousaKekkaTouroku1Div div) {

        RString 実施場所 = RString.EMPTY;  // TODO div.getCcdChosaJisshishaJoho()  実施場所の判断 divは3月実装予定#74645
        if (ChosaJisshiBashoCode.自宅内.getコード().equals(実施場所)) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.自宅内で施設.getMessage().getCode(),
                    DbeWarningMessages.自宅内で施設.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbeWarningMessages.自宅内で施設.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            // TODO 概況調査場所は”施設”になる   3月実装予定#74645
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実施場所selectのonChange処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_selectJisshiBasho(NinnteiChousaKekkaTouroku1Div div) {
        // TODO共有子DIVで取得できない　3月実装予定#74645
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「一次判定を実施する」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onBeforeOpenDialog_btnIchiHanteiJisshi(NinnteiChousaKekkaTouroku1Div div) {
        // TODO 「DBZ.IchijiHanteiKekkaJoho」  #75188 この機能はTodoとしてください。また、テストも未実施で良いです。
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された情報を「一次判定結果」へセットします。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnIchiHanteiJisshi(NinnteiChousaKekkaTouroku1Div div) {
        // TODO #75188 この機能はTodoとしてください。また、テストも未実施で良いです。
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「定型文」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onBeforeOpenDialog_btnTeikeibun(NinnteiChousaKekkaTouroku1Div div) {
        div.setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHidden登録グループコード(登録グループコード_1);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された情報を概況調査定型文へセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnTeikeibun(NinnteiChousaKekkaTouroku1Div div) {
        div.getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「前回値をコピーする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnZenkaiCopy(NinnteiChousaKekkaTouroku1Div div) { //TODO 共有子DIVにて対応を行います。
//        ShinseishoKanriNo 前回申請書管理番号 = getHandler(div).get前回申請書管理番号();
//        int 前回最大認定調査依頼履歴番号 = getHandler(div).get前回最大認定調査依頼履歴番号(前回申請書管理番号);
//        RString 調査項目 = getHandler(div).get調査項目(前回申請書管理番号, 前回最大認定調査依頼履歴番号);
        // TODO # 75188 共有子DIVにて対応を行います。  基本調査の共有子DIVは四次設計対象になっています。
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「概況特記を入力する」を押下する処理です。（DBE2210002　概況特記入力画面へ遷移する）
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnGaikyoTokkiInput(NinnteiChousaKekkaTouroku1Div div) {

        // TODO 調査実施日が未入力の判断 specで  divは3月実装予定#74645
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            set画面遷移パラメータ();
            return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.概況特記入力を表示).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「特記事項一覧を表示する」を押下する処理です。（DBE2210003　特記事項一覧画面へ遷移する）
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnTokkiJikoIchiran(NinnteiChousaKekkaTouroku1Div div) {

        // TODO 調査実施日が未入力の判断 specで divは3月実装予定#74645
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            set画面遷移パラメータ();
            return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.特記事項一覧を表示).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「入力内容をキャンセルする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnCancel(NinnteiChousaKekkaTouroku1Div div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).resetData();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「調査結果を保存する」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onclick_btnChosaKekkaUpdate(NinnteiChousaKekkaTouroku1Div div) {

        // TODO 調査実施日が未入力の判断 specで 3月実装予定#74645
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        // TODO 基本調査の第1群～第5群＆生活自立度に未入力項目があるの場合、エラーメッセージを表示する    #75188基本調査の共有子DIVは四次設計対象になっています。
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue()
                    .concat(new RString("ShinseishoKanriNo")).concat(temp_申請書管理番号.getColumnValue()));
            boolean getLock = RealInitialLocker.tryGetLock(排他キー);
            if (!getLock) {
                throw new ApplicationException(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage());
            }
            更新処理(div);

            RealInitialLocker.release(排他キー);
            return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.特記事項一覧を表示).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 更新処理(NinnteiChousaKekkaTouroku1Div div) {

        認定調査依頼情報の更新();
        概況調査の更新();
        RString 選択値 = div.getRadGenzaiservis().getSelectedKey();
        if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            予防給付サービス状況の更新(div);
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            介護給付サービス状況の更新(div);
        }
        サービス状況フラグの更新(div);
        記入項目の更新(div);
        施設利用の更新(div);
        調査項目の更新();
    }

    private void 認定調査依頼情報の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosaIraiJohoManager dbt5201Manager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho dbt5201 = dbt5201Manager.get認定調査依頼情報(temp_申請書管理番号, temp_認定調査履歴番号);
        NinteichosaIraiJohoBuilder dbt5201Bulid = dbt5201.createBuilderForEdit();
        dbt5201Bulid.set認定調査回数(1);
        dbt5201Manager.save認定調査依頼情報(dbt5201Bulid.build());
    }

    private void 概況調査の更新() {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoGaikyoChosa dbt5202 = new NinteichosahyoGaikyoChosa(temp_申請書管理番号, temp_認定調査履歴番号, new RString("1"));  //TODO QA
        NinteichosahyoGaikyoChosaBuilder dbt5202builder = dbt5202.createBuilderForEdit();
        dbt5202builder.set利用施設住所(AtenaJusho.EMPTY); // TODO  画面入力値（divが未実装）
        NinteichosahyoGaikyoChosaManager dbt5202Manager = new NinteichosahyoGaikyoChosaManager();
        dbt5202Manager.save認定調査票_概況調査_子(dbt5202builder.build());
    }

    private void サービス状況フラグの更新(NinnteiChousaKekkaTouroku1Div div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoServiceJokyoFlagManager dbt5208Manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag dbt5208 = new NinteichosahyoServiceJokyoFlag(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        NinteichosahyoServiceJokyoFlagBuilder dbt5202Builder = dbt5208.createBuilderForEdit();
        RString 住宅改修 = div.getRadJutakuKaishu().getSelectedKey();
        if (住宅改修_有.equals(住宅改修)) {
            dbt5202Builder.setサービスの状況フラグ(true);
        } else if (住宅改修_無.equals(住宅改修)) {
            dbt5202Builder.setサービスの状況フラグ(false);
        }
        dbt5208Manager.save認定調査票_概況調査_サービスの状況フラグ(dbt5202Builder.build());
    }

    private void 記入項目の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        NinteichosahyoKinyuItemManager dbt5209Manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        NinteichosahyoKinyuItemBuilder dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(div.getTxtShichosonTokubetsuKyufu().getValue());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());

        dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(div.getTxtKyufuIgaiJutakuService().getValue());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());
    }

    private void 調査項目の更新() {
//        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
//        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        // TODO divは3月実装予定#74645
//        NinteichosahyoChosaItemManager dbt5211Manager = new NinteichosahyoChosaItemManager();
//        NinteichosahyoChosaItem dbt5211 = new NinteichosahyoChosaItem(temp_申請書管理番号, temp_認定調査履歴番号, 1);
//        dbt5211Manager.save認定調査票_基本調査_調査項目(null);
    }

    private void 予防給付サービス状況の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
        }

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        List<dgRiyoSerViceFirstHalf_Row> firstHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (dgRiyoSerViceFirstHalf_Row firstRow : firstHalf) {
            利用状況 = firstRow.getServiceJokyo().getValue();
            連番 = 連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 介護給付サービス状況の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = new ArrayList<>();
        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_13);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
            連番List.add(データベース内連番_17);
            連番List.add(データベース内連番_18);
        }

        if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_19);
            連番List.add(データベース内連番_20);
        }

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
            利用状況 = row.getServiceJokyo().getValue();
            連番 = 連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 施設利用の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
        } else if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_9);
        }

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        int index = 0;
        int 連番;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            連番 = 連番List.get(index++);
            NinteichosahyoShisetsuRiyo dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(row.getShisetsuRiyoUmu());
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void set画面遷移パラメータ() {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, temp_申請書管理番号);
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, temp_認定調査履歴番号);
        // TODO 調査実施のパラメータ   divは3月実装予定#74645
    }

    private NinnteiChousaKekkaTouroku1Handler getHandler(NinnteiChousaKekkaTouroku1Div div) {
        return new NinnteiChousaKekkaTouroku1Handler(div);
    }

    private NinnteiChousaKekkaTouroku1ValidationHandler getValidationHandler() {
        return new NinnteiChousaKekkaTouroku1ValidationHandler();
    }

}
