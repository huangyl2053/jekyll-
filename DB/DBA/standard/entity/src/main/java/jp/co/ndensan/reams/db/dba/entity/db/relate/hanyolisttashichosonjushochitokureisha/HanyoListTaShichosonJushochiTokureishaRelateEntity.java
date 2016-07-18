/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttashichosonjushochitokureisha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_他市町村住所地特例者Entity。
 *
 * @reamsid_L DBA-1590-030 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListTaShichosonJushochiTokureishaRelateEntity {

    private RString 被保険者番号;
    private RString 資格取得事由;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格取得届出日;
    private RString 喪失事由;
    private FlexibleDate 資格喪失日;
    private FlexibleDate 資格喪失届日;
    private RString 資格区分;
    private RString 住所地特例状態;
    private RString 広域内住所地特例フラグ;
    private RString 広住特措置元市町村コード;
    private RString 市町村コード;
    private RString 他住所特例適用事由;
    private FlexibleDate 他住所特例適用日;
    private FlexibleDate 他住所特例適用届出日;
    private RString 他住所特例解除事由;
    private FlexibleDate 他住所特例解除日;
    private FlexibleDate 他住所特例解除届出日;
    private RString 他住所特例施設コード;
    private RString 他住所特例施設名称;
    private RString 他住所特例施設郵便番号;
    private RString 他住所特例施設住所;
    private RString 他住所特例施設電話番号;
    private FlexibleDate 他住所特例入所日;
    private FlexibleDate 他住所特例退所日;
    private RString 前保険者番号;
    private RString 他被保険者番号;
    private FlexibleDate 他住所特例連絡票発行日;
    private FlexibleDate 施設退所通知発行日;
    private FlexibleDate 施設変更通知発行日;
    private RString 医療保険種別;
    private RString 医療保険番号;
    private RString 医療保険者名;
    private RString 医療保険記号番号;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
