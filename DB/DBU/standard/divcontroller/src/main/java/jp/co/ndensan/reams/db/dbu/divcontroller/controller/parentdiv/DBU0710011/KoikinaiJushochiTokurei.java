/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0710011;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050010.DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.koikinaijushochitokurei.KoikinaiJushochiTokureiEnum;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0710011.KoikinaiJushochiTokureiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0710011.KoikinaiJushochiTokureiHandler;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 広域内住所地特例者一覧表Divを制御します。
 *
 * @reamsid_L DBU-1140-010 dongyabin
 */
public class KoikinaiJushochiTokurei {

    /**
     * 画面初期化処理です。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     * @return ResponseData<KoikinaiJushochiTokureiDiv>
     */
    public ResponseData<KoikinaiJushochiTokureiDiv> onload(KoikinaiJushochiTokureiDiv div) {
        div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBU介護統計報告, new ReportId(KoikinaiJushochiTokureiEnum.ReportId.getコード()));
        SearchResult<KoikiZenShichosonJoho> 市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
        getHandler(div).onLoad(市町村List);
        return ResponseData.of(div).respond();
    }

    /**
     * 「直近」ラジオボタンを選択します。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     * @return ResponseData<KoikinaiJushochiTokureiDiv>
     */
    public ResponseData<KoikinaiJushochiTokureiDiv> clickRadChokin(KoikinaiJushochiTokureiDiv div) {
        getHandler(div).clickRadChokin();
        return ResponseData.of(div).respond();
    }

    /**
     * 「基準日」ラジオボタンを選択します。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     * @return ResponseData<KoikinaiJushochiTokureiDiv>
     */
    public ResponseData<KoikinaiJushochiTokureiDiv> clickRadKijyunbi(KoikinaiJushochiTokureiDiv div) {
        getHandler(div).clickRadKijyunbi();
        return ResponseData.of(div).respond();
    }

    /**
     * 「範囲」ラジオボタンを選択します。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     * @return ResponseData<KoikinaiJushochiTokureiDiv>
     */
    public ResponseData<KoikinaiJushochiTokureiDiv> clickRadHani(KoikinaiJushochiTokureiDiv div) {
        getHandler(div).clickRadHani();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下前のチェック実行します。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     * @return ResponseData<KoikinaiJushochiTokureiDiv>
     */
    public ResponseData<KoikinaiJushochiTokureiDiv> isCheck(KoikinaiJushochiTokureiDiv div) {
        getHandler(div).is入力チェック();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下後バッチを起動します。
     *
     * @param div KoikinaiJushochiTokurei のクラスファイル
     * @return ResponseData<KoikinaiJushochiTokureiDiv>
     */
    public ResponseData<DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter> clickBatch(KoikinaiJushochiTokureiDiv div) {
        return ResponseData.of(getHandler(div).click実行()).respond();
    }

    private KoikinaiJushochiTokureiHandler getHandler(KoikinaiJushochiTokureiDiv div) {
        return new KoikinaiJushochiTokureiHandler(div);
    }

}
