/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明書の帳票出力用データEntityです。
 *
 * @reamsid_L DBU-1080-010 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BenmeisyoTyohyoDataEntity {

    private RString 送付先郵便番号;
    private RString 送付先住所;
    private RString 送付先名称;
    private FlexibleDate 弁明書作成日;
    private RString 弁明の件名;
    private RString 弁明の内容;
    private RString 認証者役職名;
    private RString 認職者氏名;
    private RString 電子公印;
    private RString 公印省略;
    private RString 公印文字列;
    private RString 文言;
    private HihokenshaNo 被保険者番号;
    private IName 被保険者氏名;
    private YubinNo 被保険者郵便番号;
    private RString 被保険者住所;
    private RString 被保険者生年月日;
    private RString 被保険者性別;

}
