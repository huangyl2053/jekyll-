/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(利用者負担割合)のRelateEntityクラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoRiyoshaFutanWariaiEntity {

    private RString 被保険者台帳管理_被保険者番号;
    private RString 被保険者台帳管理_資格取得事由コード;
    private FlexibleDate 被保険者台帳管理_資格取得年月日;
    private FlexibleDate 被保険者台帳管理_資格取得届出年月日;
    private RString 被保険者台帳管理_資格喪失事由コード;
    private FlexibleDate 被保険者台帳管理_資格喪失年月日;
    private FlexibleDate 被保険者台帳管理_資格喪失届出年月日;
    private RString 被保険者台帳管理_被保険者区分コード;
    private RString 被保険者台帳管理_住所地特例フラグ;
    private RString 被保険者台帳管理_市町村コード;
    private RString 被保険者台帳管理_広域内住所地特例フラグ;
    private RString 被保険者台帳管理_広住特措置元市町村コード;
    private RString 識別コード;
    private int 履歴番号;
    private RString 枝番号;
    private boolean 利用者負担割合_職権変更フラグ;
    private RString 利用者負担割合明細_資格区分;
    private RString 利用者負担割合明細_負担割合区分;
    private FlexibleDate 利用者負担割合_判定日;
    private RString 利用者負担割合_判定区分;
    private FlexibleDate 利用者負担割合明細_有効開始日;
    private FlexibleDate 利用者負担割合明細_有効終了日;
    private Decimal 利用者負担割合明細_本人合計所得金額;
    private int 利用者負担割合明細_世帯１号被保険者数;
    private Decimal 利用者負担割合明細_年金収入合計;
    private Decimal 利用者負担割合明細_その他の合計所得金額合計;
    private RString 利用者負担割合_更正事由;
    private FlexibleDate 利用者負担割合_交付日;
    private boolean 利用者負担割合明細_論理削除フラグ;
    private FlexibleYear 利用者負担割合_年度;
    private int 利用者負担割合_履歴番号;
    private int 利用者負担割合明細_枝番号;
    private int 利用者負担割合明細2_枝番号;
    private int 利用者負担割合明細2_履歴番号;
    private int 利用者負担割合明細_履歴番号;
    private boolean 利用者負担割合_発行不要フラグ;
    private RString 利用者負担割合_発行区分;
    private FlexibleDate 利用者負担割合_発行日;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
