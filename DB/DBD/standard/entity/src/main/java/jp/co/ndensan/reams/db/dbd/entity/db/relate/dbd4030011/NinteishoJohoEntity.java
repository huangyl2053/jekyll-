/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定書情報Entityの情報を取得するEntityクラスです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishoJohoEntity {

    private HihokenshaNo 被保険者番号;
    private RDate 発行日;
    private RString 申請者;
    private RString 申請者住所;
    private RString 申請者氏名;
    private RString 対象者住所;
    private RString 対象者氏名;
    private RString 対象者生年月日;
    private RString 対象者性別;
    private RString 障害理由区分;
    private RString 障害理由内容;
    private FlexibleDate 要介護認定日;
    private FlexibleYear 対象年度;
    private RString 文書番号;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
}
