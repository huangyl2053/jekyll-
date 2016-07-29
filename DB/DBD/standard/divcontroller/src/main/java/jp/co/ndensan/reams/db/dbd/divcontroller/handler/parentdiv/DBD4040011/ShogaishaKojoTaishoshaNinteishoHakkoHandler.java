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
 * 障がい者控除対象者認定ハンドラクラスです
 *
 * @reamsid_L DBD-3870-010 tianyh
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoHandler {

    private final ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     */
    public ShogaishaKojoTaishoshaNinteishoHakkoHandler(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void initialize(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {

        div.getTaishoshaAtena().initialize(識別コード);
    }

    /**
     * 前排他の設定
     *
     * @param 被保険者番号 被保険者番号
     */
    private void 前排他の設定(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.lock(排他キー);
    }

    /**
     * 前排他の解除
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他の解除(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.release(new LockingKey(排他キー));
    }

    /**
     * PersonalDataを取得します
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return PersonalData
     */
    public PersonalData toPersonalData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

}
