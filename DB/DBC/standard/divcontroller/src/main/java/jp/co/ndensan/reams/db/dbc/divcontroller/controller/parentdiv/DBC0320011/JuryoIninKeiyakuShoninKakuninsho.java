/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0320011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc010010.DBC010010_JuryoininKeiyakuShoninKakuninshoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0320011.DBC0320011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0320011.JuryoIninKeiyakuShoninKakuninshoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0320011.JuryoIninKeiyakuShoninKakuninshoValidationHandler;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険受領委任契約承認（不承認）確認書です。
 *
 * @reamsid_L DBC-1910-010 lihang
 */
public class JuryoIninKeiyakuShoninKakuninsho {

    /**
     * onLoadです
     *
     * @param div JuryoIninKeiyakuShoninKakuninshoDiv
     * @return ResponseData
     */
    public ResponseData<JuryoIninKeiyakuShoninKakuninshoDiv> onLoad(JuryoIninKeiyakuShoninKakuninshoDiv div) {

        RString メニューID = ResponseHolder.getMenuID();
        LockingKey 前排他キー = new LockingKey(メニューID);
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        RealInitialLocker.release(前排他キー);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100029.getReportId());
        return ResponseData.of(div).setState(DBC0320011StateName.承認確認書作成);
    }

    /**
     * 「実行する」ボタンのメソッドです。
     *
     * @param div JuryoIninKeiyakuShoninKakuninshoDiv
     * @return ResponseData
     */
    public ResponseData<JuryoIninKeiyakuShoninKakuninshoDiv> onClick_beforPrint(JuryoIninKeiyakuShoninKakuninshoDiv div) {
        ValidationMessageControlPairs validPairs = getCheckHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下します。
     *
     * @param div JuryoIninKeiyakuShoninKakuninshoDiv
     * @return ResponseData
     */
    public ResponseData<DBC010010_JuryoininKeiyakuShoninKakuninshoParameter> onClick_BtnPrint(JuryoIninKeiyakuShoninKakuninshoDiv div) {
        DBC010010_JuryoininKeiyakuShoninKakuninshoParameter parameter = new DBC010010_JuryoininKeiyakuShoninKakuninshoParameter();
        parameter.set契約申請日開始(new FlexibleDate(div.getJuryoininChushutsuJoken().getTxtKeiyakuShinseiYMD().getFromValue().toDateString()));
        parameter.set契約申請日終了(new FlexibleDate(div.getJuryoininChushutsuJoken().getTxtKeiyakuShinseiYMD().getToValue().toDateString()));
        parameter.set契約決定日開始(new FlexibleDate(div.getJuryoininChushutsuJoken().getTxtKeiyakuKetteiYMD().getFromValue().toDateString()));
        parameter.set契約決定日終了(new FlexibleDate(div.getJuryoininChushutsuJoken().getTxtKeiyakuKetteiYMD().getToValue().toDateString()));
        parameter.set発行済(div.getJuryoininChushutsuJoken().getRadHakkoSumi().getSelectedKey());
        parameter.set通知日(new FlexibleDate(div.getJuryoininChushutsuJoken().getTxtTsuchiYMD().getValue().toDateString()));
        parameter.set文書番号(div.getJuryoininChushutsuJoken().getCcdBunshoBangoInput().get文書番号());
        if (div.getCcdChohyoShutsuryokujun().getSelected出力順() != null) {
            parameter.set改頁出力順ID(new RString(div.getCcdChohyoShutsuryokujun().getSelected出力順().get出力順ID()));
        }
        parameter.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        parameter.set処理日時(RDateTime.now());
        return ResponseData.of(parameter).respond();
    }

    private JuryoIninKeiyakuShoninKakuninshoValidationHandler
            getCheckHandler(JuryoIninKeiyakuShoninKakuninshoDiv div) {
        return new JuryoIninKeiyakuShoninKakuninshoValidationHandler(div);
    }
}
