/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2220001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001.DBB2220001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001.TokubetsuChoshuJohoAppurodoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2220001.TokubetsuChoshuJohoAppurodoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 * 画面設計_DBB2220001_特別徴収情報アップロードのクラスです。
 *
 * @reamsid_L DBB-5670-010 chenhui
 */
public class TokubetsuChoshuJohoAppurodo {

    private static final RString 状態_市町村 = new RString("市町村");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onLoad(TokubetsuChoshuJohoAppurodoDiv div) {
        TokubetsuChoshuJohoAppurodoHandler hand = getHandler(div);
        hand.check広域保険者();
        hand.initialize();
        return ResponseData.of(div).setState(DBB2220001StateName.市町村);
    }

    /**
     * 処理年度DropdownListの変更のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onChange_ddlShoriNendo(TokubetsuChoshuJohoAppurodoDiv div) {
        getHandler(div).処理年度の変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村」もしくは「月」の切替のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onClick_grpHyojikeishiki(TokubetsuChoshuJohoAppurodoDiv div) {
        RString 状態 = getHandler(div).市町村月の切替();
        if (状態_市町村.equals(状態)) {
            return ResponseData.of(div).setState(DBB2220001StateName.市町村);
        }
        return ResponseData.of(div).setState(DBB2220001StateName.月);
    }

    /**
     * 市町村の変更のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onChange_ddlShichoson(TokubetsuChoshuJohoAppurodoDiv div) {
        getHandler(div).市町村の変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 月の変更のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onChange_ddlGetu(TokubetsuChoshuJohoAppurodoDiv div) {
        getHandler(div).月の変更();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理対象選択（市町村）のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onSelect_dgGetuShoriSelect(TokubetsuChoshuJohoAppurodoDiv div) {
        getHandler(div).処理対象選択_市町村();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理対象選択（月）のメソッドです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onSelect_dgShichosonShoriSelect(TokubetsuChoshuJohoAppurodoDiv div) {
        getHandler(div).処理対象選択_月();
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードButtonaを押します.
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     * @param files FileData[]
     * @return ResponseData<TokubetsuChoshuJohoAppurodoDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<TokubetsuChoshuJohoAppurodoDiv> onClick_btnUpload(TokubetsuChoshuJohoAppurodoDiv div, FileData[] files) {
        TokubetsuChoshuJohoAppurodoHandler hand = getHandler(div);
        boolean チェックFlag = hand.ファイルチェック(files);
        if (チェックFlag) {
            hand.upLoad(files);
        }
        return ResponseData.of(div).respond();
    }

    private TokubetsuChoshuJohoAppurodoHandler getHandler(TokubetsuChoshuJohoAppurodoDiv div) {
        return new TokubetsuChoshuJohoAppurodoHandler(div);
    }
}
