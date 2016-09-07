/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_生活保護受給者Entity。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuhogoJukyushaRelateEntity {

    private RString 市町村コード;
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
    private FlexibleDate 老齢福祉年金開始日;
    private FlexibleDate 老齢福祉年金終了日;
    private RString 識別コード;
    private RString 業務コード;
    private FlexibleDate 生活保護開始日;
    private FlexibleDate 生活保護終了日;
    private RString 生活保護種別;
    private RString 医療保険種別;
    private RString 医療保険番号;
    private RString 医療保険者名;
    private RString 医療保険記号番号;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
