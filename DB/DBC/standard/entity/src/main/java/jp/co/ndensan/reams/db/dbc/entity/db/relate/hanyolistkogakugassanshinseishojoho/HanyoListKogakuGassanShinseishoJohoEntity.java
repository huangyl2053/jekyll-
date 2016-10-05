/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshinseishojoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)Entity
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanShinseishoJohoEntity {

    private FlexibleYear 高額合算申請書_対象年度;
    private RString 高額合算申請書_整理番号;
    private RString 高額合算申請書_履歴番号;
    private RString 高額合算申請書_被保険者番号;
    private RString 高額合算申請書_申請状況区分;
    private FlexibleDate 高額合算申請書_申請年月日;
    private RString 高額合算申請書_支給申請書整理番号;
    private RString 高額合算申請書_国保支給申請書整理番号;
    private RString 高額合算申請書_支給申請区分;
    private FlexibleDate 高額合算申請書_対象計算期間開始年月日;
    private FlexibleDate 高額合算申請書_対象計算期間終了年月日;
    private RString 高額合算申請書_支給申請形態;
    private RString 高額合算申請書_自己負担額証明書交付申請の有無;
    private RString 高額合算申請書_申請代表者氏名;
    private RString 高額合算申請書_所得区分;
    private RString 高額合算申請書_70歳以上の者に係る所得区分;
    private FlexibleDate 高額合算申請書_資格喪失年月日;
    private RString 高額合算申請書_資格喪失事由;
    private FlexibleDate 高額合算申請書_加入期間開始年月日;
    private FlexibleDate 高額合算申請書_加入期間終了年月日;
    private RString 高額合算申請書_国保保険者番号;
    private RString 高額合算申請書_国保保険者名称;
    private RString 高額合算申請書_国保被保険者証記号;
    private RString 高額合算申請書_国保被保険者証番号;
    private RString 高額合算申請書_国保世帯番号;
    private RString 高額合算申請書_国保続柄;
    private FlexibleDate 高額合算申請書_国保加入期間開始年月日;
    private FlexibleDate 高額合算申請書_国保加入期間終了年月日;
    private RString 高額合算申請書_後期保険者番号;
    private RString 高額合算申請書_後期広域連合名称;
    private RString 高額合算申請書_後期被保険者番号;
    private FlexibleDate 高額合算申請書_後期加入期間開始年月日;
    private FlexibleDate 高額合算申請書_後期加入期間終了年月日;
    private RString 高額合算申請書_支払方法区分;
    private RString 高額合算申請書_支払場所;
    private FlexibleDate 高額合算申請書_支払期間開始年月日;
    private FlexibleDate 高額合算申請書_支払期間終了年月日;
    private RString 高額合算申請書_支払期間開始時間;
    private RString 高額合算申請書_支払期間終了時間;
    private RString 高額合算申請書_口座ID;
    private FlexibleYearMonth 高額合算申請書_支給申請書情報送付年月;
    private FlexibleYearMonth 高額合算申請書_自己負担額計算年月;
    private RString 高額合算申請書加入歴01_保険者名;
    private HokenshaNo 高額合算申請書加入歴_保険者番号;
    private FlexibleDate 高額合算申請書加入歴01_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴01_加入期間終了年月日;
    private RString 高額合算申請書加入歴01_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴02_保険者名;
    private FlexibleDate 高額合算申請書加入歴02_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴02_加入期間終了年月日;
    private RString 高額合算申請書加入歴02_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴03_保険者名;
    private FlexibleDate 高額合算申請書加入歴03_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴03_加入期間終了年月日;
    private RString 高額合算申請書加入歴03_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴04_保険者名;
    private FlexibleDate 高額合算申請書加入歴04_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴04_加入期間終了年月日;
    private RString 高額合算申請書加入歴04_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴05_保険者名;
    private FlexibleDate 高額合算申請書加入歴05_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴05_加入期間終了年月日;
    private RString 高額合算申請書加入歴05_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴06_保険者名;
    private FlexibleDate 高額合算申請書加入歴06_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴06_加入期間終了年月日;
    private RString 高額合算申請書加入歴06_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴07_保険者名;
    private FlexibleDate 高額合算申請書加入歴07_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴07_加入期間終了年月日;
    private RString 高額合算申請書加入歴07_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴08_保険者名;
    private FlexibleDate 高額合算申請書加入歴08_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴08_加入期間終了年月日;
    private RString 高額合算申請書加入歴08_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴09_保険者名;
    private FlexibleDate 高額合算申請書加入歴09_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴09_加入期間終了年月日;
    private RString 高額合算申請書加入歴09_自己負担額証明書整理番号;
    private RString 高額合算申請書加入歴10_保険者名;
    private FlexibleDate 高額合算申請書加入歴10_加入期間開始年月日;
    private FlexibleDate 高額合算申請書加入歴10_加入期間終了年月日;
    private RString 高額合算申請書加入歴10_自己負担額証明書整理番号;
    private LasdecCode 最新被保台帳_市町村コード;
    private HihokenshaNo 最新被保台帳_被保険者番号;
    private RString 最新被保台帳_資格取得事由コード;
    private FlexibleDate 最新被保台帳_資格取得年月日;
    private FlexibleDate 最新被保台帳_資格取得届出年月日;
    private RString 最新被保台帳_資格喪失事由コード;
    private FlexibleDate 最新被保台帳_資格喪失年月日;
    private FlexibleDate 最新被保台帳_資格喪失届出年月日;
    private RString 最新被保台帳_被保険者区分コード;
    private boolean 最新被保台帳_住所地特例フラグ;
    private RString 受給者台帳_受給申請事由;
    private RString 受給者台帳_要支援者認定申請区分;
    private FlexibleDate 受給者台帳_受給申請年月日;
    private RString 受給者台帳_要介護認定状態区分コード;
    private FlexibleDate 受給者台帳_認定有効期間開始年月日;
    private FlexibleDate 受給者台帳_認定有効期間終了年月日;
    private FlexibleDate 受給者台帳_認定年月日;
    private boolean 受給者台帳_旧措置者フラグ;
    private RString 受給者台帳_みなし要介護区分コード;
    private RString 受給者台帳_直近異動事由コード;

    /**
     * -- GETTER -- 宛名Entity。
     *
     * @return 宛名Entity -- SETTER -- 宛名Entity。
     *
     * @param 宛名Entity 宛名Entity
     */
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    /**
     * -- GETTER -- 宛先Entity。
     *
     * @return 宛先Entity -- SETTER -- 宛先Entity。
     *
     * @param 宛先Entity 宛先Entity
     */
    private UaFt250FindAtesakiEntity 宛先Entity;
    /**
     * -- GETTER -- 受給者台帳Entity。
     *
     * @return 受給者台帳Entity -- SETTER -- 受給者台帳Entity。
     *
     * @param 受給者台帳Entity 受給者台帳Entity
     */

    /**
     * -- GETTER -- 口座情報Entity。
     *
     * @return 口座情報Entity -- SETTER -- 口座情報Entity。
     *
     * @param 口座情報Entity 口座情報Entity
     */
    private KozaRelateEntity 口座情報Entity;

}
