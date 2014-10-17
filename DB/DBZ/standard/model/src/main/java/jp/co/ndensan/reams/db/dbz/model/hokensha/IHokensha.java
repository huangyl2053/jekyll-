/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 *
 * @author N3327 三浦 凌
 */
public interface IHokensha {

    /**
     *
     * @return
     */
    ShoKisaiHokenshaNo get証記載保険者番号();

    /**
     *
     * @return
     */
    AtenaJusho get住所();

    /**
     *
     * @return
     */
    YubinNo get郵便番号();

    /**
     *
     * @return
     */
    TelNo get電話番号();
}
