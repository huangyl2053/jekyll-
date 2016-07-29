/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4040011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011.ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 *
 * @author tianyh
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoHandler {

    private final ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div;

    public ShogaishaKojoTaishoshaNinteishoHakkoHandler(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        this.div = div;
    }

    public void initialize(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {

        div.getTaishoshaAtena().initialize(識別コード);
//        div.getTaishoshaKaigoShikaku().initialize(被保険者番号);
//
//        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
//                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
//        if (!RealInitialLocker.tryGetLock(排他キー)) {
//            div.getShogaishaKojoNinteishoHakko().setReadOnly(true);
//            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
//        } else {
//            前排他の設定(被保険者番号);
//        }
//
//        PersonalData personalData = toPersonalData(識別コード, 被保険者番号);
//        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private void 前排他の設定(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.lock(排他キー);
    }

    public void 前排他の解除(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.release(new LockingKey(排他キー));
    }

    public PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

}
