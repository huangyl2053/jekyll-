/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6070001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinhoshunyuryoku.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.DBE6070001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.dgShinsakaiJisseki_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShinsakaiIinHoshuJissekiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 審査会委員報酬入力のDivControllerです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public class ShinsakaiIinHoshuNyuryoku {

    private static final RString 前方一致 = new RString("前方一致");
    private static final RString 後方一致 = new RString("後方一致");
    private static final RString 完全一致 = new RString("完全一致");
    private static final RString 部分一致 = new RString("部分一致");
    private final ShinsakaiIinHoshuJissekiJohoManager shinasamanager;
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString ROOTTITLE = new RString("審査会委員報酬入力の保存処理が完了しました。");

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinHoshuNyuryoku() {
        this.shinasamanager = InstanceProvider.create(ShinsakaiIinHoshuJissekiJohoManager.class);
    }

    /**
     * 審査会委員報酬入力の初期化です。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onLoad(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE6070001StateName.検索);
    }

    /**
     * 条件をクリアするのボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_clear(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).get条件をクリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_Check(ShinsakaiIinHoshuNyuryokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidatison(div).必須入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        Decimal 最大表示件数;
        boolean is前方一致 = false;
        boolean is後方一致 = false;
        boolean is完全一致 = false;
        boolean is部分一致 = false;
        if (前方一致.equals(div.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType().getSelectedValue())) {
            is前方一致 = true;
        }
        if (後方一致.equals(div.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType().getSelectedValue())) {
            is後方一致 = true;
        }
        if (完全一致.equals(div.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType().getSelectedValue())) {
            is完全一致 = true;
        }
        if (部分一致.equals(div.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType().getSelectedValue())) {
            is部分一致 = true;
        }
        RString 介護認定審査会委員氏名 = div.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei().getValue();
        if (!div.getShinsakaiIinKensakuJoken().getTextBoxNum().getText().isNullOrEmpty()) {
            最大表示件数 = new Decimal(Integer.valueOf(div.getShinsakaiIinKensakuJoken().getTextBoxNum().getValue().toString()));
        } else {
            最大表示件数 = new Decimal(1);
        }
        List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku = ShinsakaiIinHoshuNyuryokuFinder
                .createInstance().get審査会委員一覧(ShinsakaiIinHoshuNyuryokuMapperParameter.createSelectListParam(
                                介護認定審査会委員氏名, is前方一致, is後方一致, is完全一致, is部分一致, 最大表示件数, null,
                                null, null, null, false, false)).records();
        ValidationMessageControlPairs validPairs実績一覧データ空チェック = getValidatison(div).validateFor実績一覧データ空チェック(shinsakaiIinHoshuNyuryoku);
        if (validPairs実績一覧データ空チェック.iterator().hasNext()) {
            div.getShinsakaiIin().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(validPairs実績一覧データ空チェック).respond();
        }
        getHandler(div).edit審査会委員一覧情報(shinsakaiIinHoshuNyuryoku);
        return ResponseData.of(div).setState(DBE6070001StateName.審査会委員一覧);
    }

    /**
     * 「選択」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClik_SelectButton(ShinsakaiIinHoshuNyuryokuDiv div) {
        boolean hasFromDate = false;
        boolean hasToDate = false;
        boolean isNULL = false;
        List<ShinsakaiIinHoshuJissekiJoho> shinasa = shinasamanager.get介護認定審査会委員報酬実績情報一覧().records();
        Models<ShinsakaiIinHoshuJissekiJohoIdentifier, ShinsakaiIinHoshuJissekiJoho> chikuNinteiChosain = Models.create(shinasa);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, chikuNinteiChosain);
        RString コード = div.getDgShinsakaiIin().getSelectedItems().get(0).getCode();
        RDate fromDate = div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().getFromValue();
        if (fromDate != null) {
            hasFromDate = true;
        }
        RDate toDate = div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().getToValue();
        if (toDate != null) {
            hasToDate = true;
        }
        List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku = ShinsakaiIinHoshuNyuryokuFinder
                .createInstance().get審査会実績(ShinsakaiIinHoshuNyuryokuMapperParameter.createSelectListParam(
                                null, false, false, false, false, null, コード,
                                fromDate, toDate, null, hasFromDate, hasToDate)).records();
        if (shinsakaiIinHoshuNyuryoku == null || shinsakaiIinHoshuNyuryoku.isEmpty()) {
            isNULL = true;
        }
        getHandler(div).set審査会実績(shinsakaiIinHoshuNyuryoku, isNULL);
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績一覧);
    }

    /**
     * 「修正」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_Modify(ShinsakaiIinHoshuNyuryokuDiv div) {
        //TODO 審査報酬額が空白の場合、テーブル「介護認定審査委員報酬単価」より取得した単価未実装。
        if (div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKekkaKaisaiBango().isNullOrEmpty()) {
            getHandler(div).set追加();
        } else {
            getHandler(div).set修正();
        }
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績明細);
    }

    /**
     * 「削除」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_Delete(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).get削除();
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績明細);
    }

    /**
     * 「報酬税率」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_HoshuZeiritsu(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set報酬税率();
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績明細);
    }

    /**
     * 「審査報酬額」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_ShinsaHoshugaku(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set審査報酬額();
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績明細);
    }

    /**
     * 「その他報酬」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_SonotaHoshu(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).setその他報酬();
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績明細);
    }

    /**
     * 「交通費等」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_Kotsuhito(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set交通費等();
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績明細);
    }

    /**
     * 「登録する」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_btnToroku(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set登録する();
        return ResponseData.of(div).setState(DBE6070001StateName.審査会実績一覧);
    }

    /**
     * 「入力を取りやめる」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_reSave(ShinsakaiIinHoshuNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBE6070001StateName.審査会実績一覧);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_btnModoru(ShinsakaiIinHoshuNyuryokuDiv div) {
        return ResponseData.of(div).setState(DBE6070001StateName.審査会委員一覧);
    }

    /**
     * 「保存する」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_btnHozonsuru(ShinsakaiIinHoshuNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<ShinsakaiIinHoshuJissekiJohoIdentifier, ShinsakaiIinHoshuJissekiJoho> models = ViewStateHolder.get(
                    ViewStateKeys.介護認定審査会開催予定情報, Models.class);
            List<dgShinsakaiJisseki_Row> listEntity = div.getDgShinsakaiJisseki().getDataSource();
            for (dgShinsakaiJisseki_Row row : listEntity) {
                if (状態_修正.equals(row.getColumnState())) {
                    ShinsakaiIinHoshuNyuryokuFinder.createInstance().update(getHandler(div).onClick_Update(models, row).build());
                } else if (状態_削除.equals(row.getColumnState())) {
                    ShinsakaiIinHoshuJissekiJohoIdentifier key = getHandler(div).getKey();
                    ShinsakaiIinHoshuNyuryokuFinder.createInstance().delete(models, key);
                } else if (状態_追加.equals(row.getColumnState())) {
                    ShinsakaiIinHoshuNyuryokuFinder.createInstance().insert(getHandler(div).getValues(row).build());
                }
            }
            div.getShinsakaiMessage().getCcdKaigoKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE6070001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「報酬区分」onChangeです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onChange_HoshuKubun(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).edit報酬区分();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実施日」onChangeです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onChange_JissekiNengappi(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).edit実施日();
        return ResponseData.of(div).respond();
    }

    private ShinsakaiIinHoshuNyuryokuHandler getHandler(ShinsakaiIinHoshuNyuryokuDiv div) {
        return new ShinsakaiIinHoshuNyuryokuHandler(div);
    }

    private ShinsakaiIinHoshuNyuryokuValidatisonHandler getValidatison(ShinsakaiIinHoshuNyuryokuDiv div) {
        return new ShinsakaiIinHoshuNyuryokuValidatisonHandler(div);
    }
}
