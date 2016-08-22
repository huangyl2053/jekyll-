/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo;

import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報Entityです。
 *
 * @reamsid_L DBU-1080-010 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDateEntity {

    private IName 氏名;
    private YubinNo 郵便番号;
    private RString 住所;
    private RString 生年月日;
    private RString 性別;
}
