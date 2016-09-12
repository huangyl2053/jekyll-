/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事前審査結果登録データ作成Entityクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JizenShinsaKekkaRelateEntity implements Serializable {

    private RString shinsakaiKaisaiNo;
    private ShinseishoKanriNo shinseishoKanriNo;
    private int shinsakaiOrder;
    private RString shinsakaiIinCode;
    private Code koroshoIfShikibetsuCode;
}
