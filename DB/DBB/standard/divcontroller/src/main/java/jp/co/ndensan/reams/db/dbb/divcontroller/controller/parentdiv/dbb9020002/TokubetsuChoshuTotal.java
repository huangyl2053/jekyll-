/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb9020002;

import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.FutsuChoshuKirikaeKeisanHoho;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.DBB9020002StateName.完了;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.DBB9020002StateName.平17年以前;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.DBB9020002StateName.平18年から平20年まで;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.DBB9020002StateName.平21年以降;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.TokubetsuChoshuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb9020002.TokubetsuChoshuTotalHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb9020002.TokubetsuChoshuTotalValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理情報（特別徴収）画面クラスです。
 */
public class TokubetsuChoshuTotal {

    private static final FlexibleYear 平成21年 = new FlexibleYear("2009");
    private static final FlexibleYear 平成17年 = new FlexibleYear("2005");
    private static final RString 終了メッセージ1 = new RString("調定年度：");
    private static final RString 終了メッセージ2 = new RString("年度");
    private static final RString 終了メッセージ3 = new RString("システム管理登録_特別徴収保存処理");

    private TokubetsuChoshuTotalHandler getHandler(TokubetsuChoshuTotalDiv div) {
        return TokubetsuChoshuTotalHandler.of(div);
    }

    private TokubetsuChoshuTotalValidationHandler getTokubetsuChoshuTotalValidationHandler(TokubetsuChoshuTotalDiv div) {
        return new TokubetsuChoshuTotalValidationHandler(div);
    }

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onLoad(TokubetsuChoshuTotalDiv div) {
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage().evaluate());
        }
        getHandler(div).set初期化();
        FlexibleYear 調定年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey());
        getHandler(div).set初期値(調定年度);
        return 画面の状態遷移(div, 調定年度);
    }

    /**
     * 調定年度onChange
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onChange_ddlChoteiNendo(TokubetsuChoshuTotalDiv div) {
        FlexibleYear 調定年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey());
        getHandler(div).set市町村指定DDL(調定年度);
        getHandler(div).set初期値(調定年度);
        return 画面の状態遷移(div, 調定年度);
    }

    /**
     * 特別徴収期別情報GridチェックボックスにGridの「期」の表示を制御する
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onClick_checkBox(TokubetsuChoshuTotalDiv div) {
        getHandler(div).チェック選択制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 普通徴収切替計算方法の「期」の表示を制御する
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onChange_ddlFuchoKirikaeKeisanHoho(TokubetsuChoshuTotalDiv div) {
        if (FutsuChoshuKirikaeKeisanHoho.重複させない.getコード().equals(div.getTokubetsuChoshu()
                .getTplKibetsuHasuJoho().getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho().getSelectedKey())
                || FutsuChoshuKirikaeKeisanHoho.重複させる.getコード().equals(div.getTokubetsuChoshu()
                        .getTplKibetsuHasuJoho().getFuchoKirikaeKeisanHoho()
                        .getDdlFuchoKirikaeKeisanHoho().getSelectedKey())) {
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getFuchoKirikaeKeisanHoho()
                    .getDdlFuchoKirikaeJufukuStKi().setDisabled(true);
        } else {
            div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho().getFuchoKirikaeKeisanHoho()
                    .getDdlFuchoKirikaeJufukuStKi().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * tokuchoFrom2009の場合、「保存する」ボタン
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onClick_btnKoshinFrom2009(TokubetsuChoshuTotalDiv div) {
        return 保存処理(div);
    }

    /**
     * tokucho2006To2008の場合、「保存する」ボタン
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onClick_btnKoshinFrom2006To2008(TokubetsuChoshuTotalDiv div) {
        return 保存処理(div);
    }

    /**
     * tokuchoTo2005の場合、「保存する」ボタン
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onClick_btnKoshinTo2005(TokubetsuChoshuTotalDiv div) {
        return 保存処理(div);
    }

    /**
     * 「完了する」ボタン
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    public ResponseData<TokubetsuChoshuTotalDiv> onClick_btnEnd(TokubetsuChoshuTotalDiv div) {
        getHandler(div).前排他キーの解除();
        return ResponseData.of(div).respond();
    }

    /**
     * 調定年度DDLで選択した調定年度の状態に状態遷移する。
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    private ResponseData<TokubetsuChoshuTotalDiv> 画面の状態遷移(TokubetsuChoshuTotalDiv div, FlexibleYear 調定年度) {
        if (平成21年.isBeforeOrEquals(調定年度)) {
            div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().setVisible(true);
            return ResponseData.of(div).setState(平21年以降);
        } else if (調定年度.isBeforeOrEquals(平成17年)) {
            div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().setVisible(false);
            return ResponseData.of(div).setState(平17年以前);
        } else {
            div.getTokubetsuChoshu().getTabTokucho().getTplTokubetsuChoshuHosoku().setVisible(true);
            return ResponseData.of(div).setState(平18年から平20年まで);
        }
    }

    /**
     * 保存処理
     *
     * @param div TokubetsuChoshuTotalDiv
     * @return ResponseData<TokubetsuChoshuTotalDiv>
     */
    private ResponseData<TokubetsuChoshuTotalDiv> 保存処理(TokubetsuChoshuTotalDiv div) {
        getHandler(div).チェック選択制御();
        ValidationMessageControlPairs valid = getTokubetsuChoshuTotalValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        getHandler(div).納期限チェック();
        FlexibleYear 調定年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey());
        if (!div.getKonkaiShoriNaiyo().getDdlShichosonSelect().isVisible()) {
            getHandler(div).save納期限(調定年度);
        }
        getHandler(div).save業務コンフィグ();
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(終了メッセージ1).append(調定年度.wareki().toDateString()).append(終了メッセージ2);
        div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                rsb.toRString(),
                new RString(UrInformationMessages.正常終了.getMessage().replace(終了メッセージ3.toString()).evaluate()),
                RString.EMPTY, true);
        return ResponseData.of(div).setState(完了);
    }
}
