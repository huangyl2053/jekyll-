/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2430011;

import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KetteiTimestampBusiness;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100020.DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2430011.ShikyuKetteitsuchishoParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2430011.ShikyuKetteitsuchishoParameterHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2430011.ShikyuKetteitsuchishoParameterValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoManager;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成のコントローラクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class ShikyuKetteitsuchishoParameter {

    private static final RString 前排他キー = new RString("DBCKOGAKUGASSANJIKOFUTANGAKU");

    /**
     * 画面初期化します。
     *
     * @param div 画面情報
     * @return ResponseData<ShikyuKetteitsuchishoParameterDiv>
     */
    public ResponseData<ShikyuKetteitsuchishoParameterDiv> onLoad(ShikyuKetteitsuchishoParameterDiv div) {
        RString temp市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value();
        KetteiTimestampBusiness business = KaishuriyushoShikyuKetteitsuchishoManager.createInstance().get前回の実行情報(
                KaishuriyushoShikyuKetteitsuchishoMybatisParameter.create前回の実行情報取得パラメータ(temp市町村コード));
        getHandler(div).onLoad(business);
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチを起動します。
     *
     * @param div 画面情報
     * @return ResponseData<ShikyuKetteitsuchishoParameterDiv>
     */
    public ResponseData<DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter> onClick_btnBatchRegister(ShikyuKetteitsuchishoParameterDiv div) {
        DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter parameter = getHandler(div).create決定通知書作成パラメータ();
        return ResponseData.of(parameter).respond();
    }

    /**
     * バッチを起動前に検証します。
     *
     * @param div 画面情報
     * @return ResponseData<ShikyuKetteitsuchishoParameterDiv>
     */
    public ResponseData<ShikyuKetteitsuchishoParameterDiv> onBeforeOpenDialog_btnBatchRegister(ShikyuKetteitsuchishoParameterDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).check決定日の必須入力();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        ValidationMessageControlPairs pairs1 = getValidationHandler(div).check決定日_開始日と決定日_終了日の比較();
        if (pairs1.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs1).respond();
        }
        ValidationMessageControlPairs pairs2 = getValidationHandler(div).check事業者DDLの必須入力();
        if (pairs2.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs2).respond();
        }
        // TODO 出力順の相関方針が確定しないので、実装ができません
//        ValidationMessageControlPairs pairs3 = getValidationHandler(div).check出力順の必須設定();
//        if (pairs3.iterator().hasNext()) {
//            return ResponseData.of(div).addValidationMessages(pairs3).respond();
//        }
        ValidationMessageControlPairs pairs4 = getValidationHandler(div).check前回作成期間重複();
        if (pairs4.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs4).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者DDL表示制御を変更します。
     *
     * @param div 画面情報
     * @return ResponseData<ShikyuKetteitsuchishoParameterDiv>
     */
    public ResponseData<ShikyuKetteitsuchishoParameterDiv> onChange_chkShiteiJigyoshaNomi(ShikyuKetteitsuchishoParameterDiv div) {
        getHandler(div).onChange_chkShiteiJigyoshaNomi();
        return ResponseData.of(div).respond();
    }

    private ShikyuKetteitsuchishoParameterHandler getHandler(ShikyuKetteitsuchishoParameterDiv div) {
        return new ShikyuKetteitsuchishoParameterHandler(div);
    }

    private ShikyuKetteitsuchishoParameterValidationHandler getValidationHandler(ShikyuKetteitsuchishoParameterDiv div) {
        return new ShikyuKetteitsuchishoParameterValidationHandler(div);
    }
}
