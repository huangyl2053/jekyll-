/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6080001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJissekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiryonyuryoku.ShujiiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.DBE6080001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.ShujiiIkenshoSakuseiryoNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6080001.ShujiiIkenshoSakuseiryoNyuryokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6080001.ValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiryonyuryoku.ShujiiIkenshoSakuseiryoNyuryokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 主治医意見書作成料入力のコントローラです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public class ShujiiIkenshoSakuseiryoNyuryoku {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString ROOTTITLE = new RString("主治医意見書作成料入力の保存処理が完了しました。");

    /**
     * 初期化の設定します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onLoad(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE6080001StateName.検索状態);
    }

    /**
     * 「条件をクリアする」を押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClik_Clear(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        getHandler(div).clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」を押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClik_Search(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxCount();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<ShujiiJohoBusiness> businessList = ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance()
                .getShujiiJohoList(getHandler(div).setShujiiParameter()).records();
        getHandler(div).onClik_SearchBtn(businessList);
        ValidationMessageControlPairs pairs = getValidationHandler(div).validateData(businessList);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).setState(DBE6080001StateName.主治医状態);
    }

    /**
     * 主治医情報一覧の行選択クリックします。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClik_SelectBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        List<ShujiiIkenshoHoshuJissekiJoho> 報酬実績情報 = ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance()
                .get報酬実績情報(div.getShujii().getDgShujii().getClickedItem().getShujiiIryoKikanCode(),
                        div.getShujii().getDgShujii().getClickedItem().getCode()).records();
        Models<ShujiiIkenshoHoshuJissekiJohoIdentifier, ShujiiIkenshoHoshuJissekiJoho> joho = Models.create(報酬実績情報);
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成報酬実績情報, joho);
        List<ShujiiJissekiIchiranBusiness> businessList = ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance()
                .getShujiiJissekiIchiranList(getHandler(div).setShujiiJissekiIchiranParameter()).records();
        getHandler(div).onClik_SelectBtn(businessList);
        if (businessList == null || businessList.isEmpty()) {
            return ResponseData.of(div).setState(DBE6080001StateName.実績一覧ボタンなし状態);
        } else {
            return ResponseData.of(div).setState(DBE6080001StateName.実績一覧状態);
        }
    }

    /**
     * 主治医実績情報一覧の修正ボタンを押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClick_ModifyBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        getHandler(div).onClick_ModifyOrDeleteBtn(状態_修正);
        if (Decimal.ZERO.equals(div.getShinseiJohoMeisai().getTxtIkenshoSakuseiryo().getValue())) {
            Decimal tanka = ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance().getTanka(
                    div.getShinseiJohoMeisai().getDdlZaitakuShisetsuKubun().getSelectedValue(),
                    div.getShinseiJohoMeisai().getDdlIkenshoSakuseiKaisuKubun().getSelectedValue(),
                    div.getShinseiJohoMeisai().getTxtIkenshoKinyuNengappi().getValue(),
                    div.getShinseiJohoMeisai().getTxtIkenshoJuryoNengappi().getValue());
            getHandler(div).setTanka(tanka);
            getHandler(div).onChange_Kuben();
        }
        return ResponseData.of(div).setState(DBE6080001StateName.実績明細状態);
    }

    /**
     * 主治医実績情報一覧の削除ボタンを押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClick_DeleteBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        getHandler(div).onClick_ModifyOrDeleteBtn(状態_削除);
        return ResponseData.of(div).setState(DBE6080001StateName.実績明細状態);
    }

    /**
     * 在宅施設区分/意見書作成回数区分のonchange処理です。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onChange_Kuben(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        Decimal tanka = ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance().getTanka(
                div.getShinseiJohoMeisai().getDdlZaitakuShisetsuKubun().getSelectedValue(),
                div.getShinseiJohoMeisai().getDdlIkenshoSakuseiKaisuKubun().getSelectedValue(),
                div.getShinseiJohoMeisai().getTxtIkenshoKinyuNengappi().getValue(),
                div.getShinseiJohoMeisai().getTxtIkenshoJuryoNengappi().getValue());
        getHandler(div).setTanka(tanka);
        getHandler(div).onChange_Kuben();
        return ResponseData.of(div).setState(DBE6080001StateName.実績明細状態);
    }

    /**
     * 意見書別途診療費のフォ―カスロスト処理です。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onBlur_Shinryohi(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        getHandler(div).onChange_Kuben();
        return ResponseData.of(div).setState(DBE6080001StateName.実績明細状態);
    }

    /**
     * 「入力を取りやめる」ボタンを押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClick_YameruBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onClick_ToriyameruBtn();
            return ResponseData.of(div).setState(DBE6080001StateName.実績一覧状態);
        }
        return ResponseData.of(div).setState(DBE6080001StateName.実績明細状態);
    }

    /**
     * 「登録する」ボタンを押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClick_TourokuBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        getHandler(div).onClick_TourokuBtn();
        return ResponseData.of(div).setState(DBE6080001StateName.実績一覧状態);
    }

    /**
     * 「戻る」ボタンを押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClick_ModoruBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        return ResponseData.of(div).setState(DBE6080001StateName.主治医状態);
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div ShujiiIkenshoSakuseiryoNyuryokuDiv
     * @return ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiryoNyuryokuDiv> onClick_HozonnBtn(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<ShujiiIkenshoHoshuJissekiJohoIdentifier, ShujiiIkenshoHoshuJissekiJoho> models
                    = ViewStateHolder.get(ViewStateKeys.主治医意見書作成報酬実績情報, Models.class);
            List<dgShinsakaiIin_Row> rowList = div.getShinseiJoho().getDgShinsakaiIin().getDataSource();
            for (dgShinsakaiIin_Row row : rowList) {
                if (状態_追加.equals(row.getColumnState())) {
                    ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance().insertOrUpdate(getHandler(div).onClick_Add(row).build());
                }
                if (状態_修正.equals(row.getColumnState())) {
                    ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance().insertOrUpdate(getHandler(div).onClick_Update(models, row).build());
                }
                if (状態_削除.equals(row.getColumnState())) {
                    ShujiiIkenshoHoshuJissekiJohoIdentifier key = new ShujiiIkenshoHoshuJissekiJohoIdentifier(
                            row.getShujiiIryoKikanCode(),
                            row.getShujiiCode(),
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                            Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()));
                    ShujiiIkenshoSakuseiryoNyuryokuFinder.createInstance().delete(models, key);
                }
            }
            div.getShinsakaiMessage().getCcdKaigoKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE6080001StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenshoSakuseiryoNyuryokuHandler getHandler(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        return new ShujiiIkenshoSakuseiryoNyuryokuHandler(div);
    }

    private ValidationHandler getValidationHandler(ShujiiIkenshoSakuseiryoNyuryokuDiv div) {
        return new ValidationHandler(div);
    }
}
