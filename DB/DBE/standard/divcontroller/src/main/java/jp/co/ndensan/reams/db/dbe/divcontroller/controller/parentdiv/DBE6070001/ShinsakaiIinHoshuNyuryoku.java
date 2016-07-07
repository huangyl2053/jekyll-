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
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.DBE6070001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.dgShinsakaiJisseki_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShinsakaiIinHoshuJissekiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
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
    private RString 介護認定審査会委員氏名;
    private Decimal 最大表示件数;
    private boolean is前方一致 = false;
    private boolean is後方一致 = false;
    private boolean is完全一致 = false;
    private boolean is部分一致 = false;
    private RString コード;
    private RDate fromDate;
    private RDate toDate;
    private final ShinsakaiIinHoshuJissekiJohoManager shinasamanager;

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
        介護認定審査会委員氏名 = div.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei().getValue();
        最大表示件数 = new Decimal(Integer.valueOf(div.getShinsakaiIinKensakuJoken().getTxtMaxCount().getValue().toString()));
        List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku = ShinsakaiIinHoshuNyuryokuFinder
                .createInstance().get審査会委員一覧(ShinsakaiIinHoshuNyuryokuMapperParameter.createSelectListParam(
                                介護認定審査会委員氏名, is前方一致, is後方一致, is完全一致, is部分一致, 最大表示件数, コード, fromDate, toDate)).records();
        if (shinsakaiIinHoshuNyuryoku.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        div.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei().setValue(new RString(shinsakaiIinHoshuNyuryoku.size()));
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
        List<ShinsakaiIinHoshuJissekiJoho> shinasa = shinasamanager.get介護認定審査会委員報酬実績情報一覧().records();
        Models<ShinsakaiIinHoshuJissekiJohoIdentifier, ShinsakaiIinHoshuJissekiJoho> chikuNinteiChosain = Models.create(shinasa);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, chikuNinteiChosain);
        コード = div.getDgShinsakaiIin().getSelectedItems().get(0).getCode();
        div.getShinsakaiIinKensakuJoken().getTxtMaxCount().setValue(コード);
        fromDate = div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().getFromValue();
        toDate = div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().getToValue();
        List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku = ShinsakaiIinHoshuNyuryokuFinder
                .createInstance().get審査会実績(ShinsakaiIinHoshuNyuryokuMapperParameter.createSelectListParam(
                                介護認定審査会委員氏名, is前方一致, is後方一致, is完全一致, is部分一致, 最大表示件数, コード, fromDate, toDate)).records();
        if (shinsakaiIinHoshuNyuryoku.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set審査会実績(shinsakaiIinHoshuNyuryoku);
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_Modify(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set審査会実績明細();
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_Delete(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).get削除();
        return ResponseData.of(div).respond();
    }

    /**
     * 「報酬税率」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_HoshuZeiritsu(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set報酬税率();
        return ResponseData.of(div).respond();
    }

    /**
     * 「審査報酬額」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_ShinsaHoshugaku(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set審査報酬額();
        return ResponseData.of(div).respond();
    }

    /**
     * 「その他報酬」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_SonotaHoshu(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).setその他報酬();
        return ResponseData.of(div).respond();
    }

    /**
     * 「交通費等」onBlurです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onBlur_Kotsuhito(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set交通費等();
        return ResponseData.of(div).respond();
    }

    /**
     * 「登録する」ボタンです。
     *
     * @param div 審査会委員報酬入力DIV
     * @return ResponseData<ShinsakaiIinHoshuNyuryokuDiv>
     */
    public ResponseData<ShinsakaiIinHoshuNyuryokuDiv> onClick_btnToroku(ShinsakaiIinHoshuNyuryokuDiv div) {
        getHandler(div).set登録する();
        return ResponseData.of(div).respond();
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
                if (new RString("修正").equals(row.getColumnState())) {
                    ShinsakaiIinHoshuNyuryokuFinder.createInstance().update(getHandler(div).onClick_Update(models, row).build());
                } else if (new RString("削除").equals(row.getColumnState())) {
                    ShinsakaiIinHoshuJissekiJohoIdentifier key = new ShinsakaiIinHoshuJissekiJohoIdentifier(
                            new RString(div.getShinsakaiJisseki().getTxtShisakaiIinCode().toString()),
                            new Code(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun().toString()),
                            new FlexibleDate(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()),
                            Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getRemban().toString()));
                    ShinsakaiIinHoshuNyuryokuFinder.createInstance().delete(models, key);
                }
            }
            return ResponseData.of(div).setState(DBE6070001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ShinsakaiIinHoshuNyuryokuHandler getHandler(ShinsakaiIinHoshuNyuryokuDiv div) {
        return new ShinsakaiIinHoshuNyuryokuHandler(div);
    }
}
