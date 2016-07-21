/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttekiyojogaisha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_適用除外者Entity。
 *
 * @reamsid_L DBA-1600-030 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListTekiyoJogaishaRelateEntity {

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
    private RString 適用除外適用事由;
    private FlexibleDate 適用除外適用日;
    private FlexibleDate 適用除外適用届出日;
    private RString 適用除外解除事由;
    private FlexibleDate 適用除外解除日;
    private FlexibleDate 適用除外解除届出日;
    private RString 適用除外施設コード;
    private RString 適用除外施設名称;
    private FlexibleDate 適用除外入所日;
    private FlexibleDate 適用除外退所日;
    private RString 適用除外施設郵便番号;
    private RString 適用除外施設住所;
    private RString 適用除外施設電話番号;
    private FlexibleDate 施設退所通知発行日;
    private FlexibleDate 施設変更通知発行日;
    private RString 医療保険種別;
    private RString 医療保険番号;
    private RString 医療保険者名;
    private RString 医療保険記号番号;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
}
