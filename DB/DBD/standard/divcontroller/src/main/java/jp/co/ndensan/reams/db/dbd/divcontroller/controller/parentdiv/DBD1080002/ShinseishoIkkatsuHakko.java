/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1080002;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.business.core.basic.KouhoushaJoho;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShinseishoHakkoTaishoshaHaakuBatch;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd102020.DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.kouhoushajoho.KouhoushaJohoParameter;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.DBD1080002StateName.世帯所得;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.DBD1080002TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.ShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002.ddlKohoshaList_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1080002.ShinseishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1080002.ShinseishoIkkatsuHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.kouhoushajoho.KouhoushaJohoService;
import jp.co.ndensan.reams.db.dbd.service.core.kouhoushajoho.ShinseishoIkkatsuHakkoService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 減免減額申請書一括発行のDivControllerです。
 *
 * @reamsid_L DBD-3530-050 liuyl
 */
public class ShinseishoIkkatsuHakko {

    /**
     * 画面初期化処理です。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<ShinseishoIkkatsuHakkoDiv>
     */
    public ResponseData<ShinseishoIkkatsuHakkoDiv> onLoad(ShinseishoIkkatsuHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 減免・減額種類を選択する。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<ShinseishoIkkatsuHakkoDiv>
     */
    public ResponseData<ShinseishoIkkatsuHakkoDiv> onChange_Shurui(ShinseishoIkkatsuHakkoDiv div) {
        List<KeyValueDataSource> dataSource = getHandler(div).getDataSource(div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().
                getSelectedKey());
        div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().setDataSource(dataSource);
        div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().setSelectedKey(new RString("empty"));
        div.getGenmenShinseiHaakuList().getTxtKijunYMD().clearValue();
        div.getGenmenShinseiHaakuList().getTxtShotokuNendo().clearDomain();
        List<ddlKohoshaList_Row> data = new ArrayList<>();
        div.getGenmenShinseiHaakuList().getDdlKohoshaList().setDataSource(data);
        getHandler(div).set帳票文言();
        return ResponseData.of(div).respond();

    }

    /**
     * 「世帯所得」のアイコンボタンをクリックする。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<ShinseishoIkkatsuHakkoDiv>
     */
    public ResponseData<ShinseishoIkkatsuHakkoDiv> onClick_State(ShinseishoIkkatsuHakkoDiv div) {
        ddlKohoshaList_Row row = div.getGenmenShinseiHaakuList().getDdlKohoshaList().getClickedItem();
        div.getSetaiShotokuIchiranPanel().getCcdSetaiShotokuIchiranPanel().initialize(new ShikibetsuCode(row.getShikibetsuCode()),
                div.getGenmenShinseiHaakuList().getTxtKijunYMD().getValue(), div.getGenmenShinseiHaakuList().getTxtShotokuNendo().getDomain(),
                new YMDHMS(div.getGenmenShinseiHaakuList().getDdlShoriTimestamp().getSelectedValue()));
        return ResponseData.of(div).setState(世帯所得);
    }

    /**
     * 「給付実績」のアイコンボタンをクリックする。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<ShinseishoIkkatsuHakkoDiv>
     */
    public ResponseData<ShinseishoIkkatsuHakkoDiv> onClickDbz(ShinseishoIkkatsuHakkoDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD1080002TransitionEventName.完了).respond();
    }

    /**
     * 「実行する」の前処理です。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<ShinseishoIkkatsuHakkoDiv>
     */
    public ResponseData<ShinseishoIkkatsuHakkoDiv> before_btnRegister(ShinseishoIkkatsuHakkoDiv div) {
        ShinseishoIkkatsuHakkoValidationHandler validationHander = new ShinseishoIkkatsuHakkoValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validationHander.候補者を選択しない(pairs, div);
        validationHander.出力チェックボックスを選択しない(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        ShinseishoIkkatsuHakkoService shinseisho = new ShinseishoIkkatsuHakkoService();
        List<ddlKohoshaList_Row> selectedItem = div.getGenmenShinseiHaakuList().getDdlKohoshaList().getSelectedItems();
        for (ddlKohoshaList_Row row : selectedItem) {
            UUID 発行処理ID = UUID.randomUUID();
            ViewStateHolder.put(Keys.発行処理ID, 発行処理ID);
            shinseisho.insertDbT4032(UUID.fromString(row.getHaakuShoriID().toString()), 発行処理ID);
            shinseisho.insertDbT4033(new HihokenshaNo(row.getHihoNo()), 発行処理ID);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「把握リストを発行する」の処理です。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter>
     */
    public ResponseData<DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter> onClick_btnprint(ShinseishoIkkatsuHakkoDiv div) {
        UUID 発行処理ID = ViewStateHolder.get(Keys.発行処理ID, UUID.class);
        DBD102020_GemmenGengakuShinseishoIkkatsuHakkoParameter parameter = getHandler(div).getParameter(発行処理ID);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「検索する」ボタンをクリックする。
     *
     * @param div ShinseishoIkkatsuHakkoDiv
     * @return ResponseData<ShinseishoIkkatsuHakkoDiv>
     */
    public ResponseData<ShinseishoIkkatsuHakkoDiv> onClick_Check(ShinseishoIkkatsuHakkoDiv div) {
        ShinseishoIkkatsuHakkoValidationHandler validationHander = new ShinseishoIkkatsuHakkoValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validationHander.処理日時必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        ShinseishoHakkoTaishoshaHaakuBatch shineisho = getHandler(div).get把握情報();
        if (shineisho == null) {
            div.getGenmenShinseiHaakuList().getTxtKijunYMD().clearValue();
            div.getGenmenShinseiHaakuList().getTxtShotokuNendo().clearDomain();
            List<ddlKohoshaList_Row> 候補者情報List = new ArrayList<>();
            div.getGenmenShinseiHaakuList().getDdlKohoshaList().setDataSource(候補者情報List);
            getHandler(div).set帳票文言();
            getHandler(div).set帳票出力順(div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue());
            return ResponseData.of(div).respond();
        } else {
            div.getGenmenShinseiHaakuList().getTxtKijunYMD().setValue(shineisho.get基準日());
            div.getGenmenShinseiHaakuList().getTxtShotokuNendo().setDomain(shineisho.get所得年度().getNendo());
            KouhoushaJohoParameter parameter = new KouhoushaJohoParameter(shineisho.get基準日(), shineisho.getバッチ処理日時(),
                    div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().
                    getSelectedKey());
            KouhoushaJohoService kouhoushaJohoSerive = KouhoushaJohoService.creatInstence();
            List<KouhoushaJoho> 候補者情報List = kouhoushaJohoSerive.find候補者情報(parameter);
            div.getGenmenShinseiHaakuList().getDdlKohoshaList().setDataSource(getHandler(div).get候補者情報(候補者情報List));
            getHandler(div).set帳票文言();
            getHandler(div).set帳票出力順(div.getGenmenShinseiHaakuList().getDdlGemmenGengakuShurui().getSelectedValue());
            for (KouhoushaJoho kouhoushaJoho : 候補者情報List) {
                ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("'被保険者番号"),
                        kouhoushaJoho.get被保険者番号().value());
                AccessLogger.log(AccessLogType.照会, PersonalData.withHojinNo(kouhoushaJoho.get識別コード(), expandedInfo));
            }
        }
        return ResponseData.of(div).respond();
    }

    private ShinseishoIkkatsuHakkoHandler getHandler(ShinseishoIkkatsuHakkoDiv div) {
        return new ShinseishoIkkatsuHakkoHandler(div);
    }

    private enum Keys {

        /**
         * 発行処理ID
         */
        発行処理ID;

        @Override
        public String toString() {
            return this.getDeclaringClass().getName().concat(name()).toString();
        }
    }

}
