/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistshokanbaraijokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBCBT23002_汎用リスト出力(償還払い状況)Entity
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShokanbaraiJokyoEntity {

    private HihokenshaNo 被保険者番号;
    private LasdecCode 市町村コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 被保険者区分コード;
    private boolean 住所地特例フラグ;
    private boolean 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private JigyoshaNo 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private RString 入所施設種類;
    private AtenaMeisho 事業者名称_60;
    private AtenaKanaMeisho 事業者名称カナ_60;
    private YubinNo 郵便番号_60;
    private AtenaJusho 事業者住所_60;
    private AtenaMeisho 代表者名_62;
    private AtenaKanaMeisho 代表者名カナ_62;
    private RString 代表者役職名_62;
    private TelNo 電話番号_60;
    private TelNo fax番号_60;
    private Decimal 所属人数;
    private Decimal 利用者数;
    private FlexibleDate 有効開始日_60;
    private FlexibleDate 有効終了日_60;
    private RString サービス実施地域_60;
    private AtenaMeisho 事業者名称_05;
    private AtenaKanaMeisho 事業者名称カナ_05;
    private YubinNo 郵便番号_05;
    private AtenaJusho 事業者住所_05;
    private AtenaMeisho 代表者名_05;
    private AtenaKanaMeisho 代表者名カナ_05;
    private RString 役職_05;
    private TelNo 電話番号_05;
    private TelNo fax番号_05;
    private FlexibleDate 有効開始日_05;
    private FlexibleDate 有効終了日_05;
    private Code 受給申請事由;
    private FlexibleDate 受給申請年月日;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始日;
    private FlexibleDate 認定有効期間終了日;
    private FlexibleDate 受給認定日;
    private RString 旧措置者フラグ;
    private Code みなし要介護区分コード;
    private Code 直近異動事由コード;

    /**
     * -- GETTER -- 支給申請Entity。
     *
     * @return 支給申請Entity -- SETTER -- 支給申請Entity。
     *
     * @param 支給申請Entity 支給申請Entity
     */
    private DbT3034ShokanShinseiEntity 支給申請Entity;
    /**
     * -- GETTER -- 申請情報Entity。
     *
     * @return 支給住宅Entity -- SETTER -- 支給住宅Entity。
     *
     * @param 支給住宅Entity 支給住宅Entity
     */
    private DbT3035ShokanJutakuKaishuJizenShinseiEntity 支給住宅Entity;
    /**
     * -- GETTER -- 判定結果情報Entity。
     *
     * @return 償還払請求基本Entity -- SETTER -- 判定結果情報Entity。
     *
     * @param 判定結果情報Entity 判定結果情報Entity
     */
    private DbT3036ShokanHanteiKekkaEntity 判定結果情報Entity;
    /**
     * -- GETTER -- 請求基本Entity。
     *
     * @return 請求基本Entity -- SETTER -- 請求基本Entity。
     *
     * @param 請求基本Entity 請求基本Entity
     */
    private List<DbT3038ShokanKihonEntity> 請求基本List;
    /**
     * -- GETTER -- 福祉用具Entity。
     *
     * @return 請求基本Entity -- SETTER -- 福祉用具Entity。
     *
     * @param 福祉用具Entity 福祉用具Entity
     */
    private DbT3048ShokanFukushiYoguHanbaihiEntity 福祉用具Entity;
    /**
     * -- GETTER -- 請求住宅Entity。
     *
     * @return 請求基本Entity -- SETTER -- 請求住宅Entity。
     *
     * @param 請求住宅Entity 請求住宅Entity
     */
    private DbT3049ShokanJutakuKaishuEntity 請求住宅Entity;
    /**
     * -- GETTER -- 口座情報Entity。
     *
     * @return 口座情報Entity -- SETTER -- 口座情報Entity。
     *
     * @param 口座情報Entity 口座情報Entity
     */
    private KozaRelateEntity 口座情報Entity;
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
}
