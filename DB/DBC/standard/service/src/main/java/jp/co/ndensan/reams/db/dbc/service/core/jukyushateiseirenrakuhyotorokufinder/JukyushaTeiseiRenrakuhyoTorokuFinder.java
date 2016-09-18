/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotorokufinder;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokufinder.JukyushaTeiseiRenrakuhyoTorokuFinderResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBCZB00001_受給者異動情報変更箇所判定
 *
 * @reamsid_L DBC-2101-050 quxiaodong
 */
public class JukyushaTeiseiRenrakuhyoTorokuFinder {

    private final DbT3001JukyushaIdoRenrakuhyoDac 受給者異動送付Dac;
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");

    /**
     * コンストラクタです。
     */
    public JukyushaTeiseiRenrakuhyoTorokuFinder() {
        this.受給者異動送付Dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukyushaTeiseiRenrakuhyoTorokuFinder}のインスタンス
     */
    public static JukyushaTeiseiRenrakuhyoTorokuFinder createInstance() {
        return InstanceProvider.create(JukyushaTeiseiRenrakuhyoTorokuFinder.class);
    }

    /**
     * 変更前の訂正情報を作成する
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param 異動年月日 FlexibleDate
     * @param 作成年月日 FlexibleDate
     * @param 氏名_性別_生年月日を印字す RString
     * @return JukyushaIdoRenrakuhyo
     */
    @Transaction
    public JukyushaTeiseiRenrakuhyoTorokuFinderResult editHenkomaeTeiseiJoho(
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            FlexibleDate 異動年月日,
            FlexibleDate 作成年月日,
            RString 氏名_性別_生年月日を印字す) {
        JukyushaTeiseiRenrakuhyoTorokuFinderResult 変更前受給者訂正情報Entity
                = new JukyushaTeiseiRenrakuhyoTorokuFinderResult();
        DbT3001JukyushaIdoRenrakuhyoEntity entity = 受給者異動送付Dac.getAllByKey(
                被保険者番号, 異動年月日, 履歴番号);
        if (entity != null) {
            entity.initializeMd5();
            変更前受給者訂正情報Entity.set作成年月日(作成年月日);
            変更前受給者訂正情報Entity.set氏名_性別_生年月日を印字する(氏名_性別_生年月日を印字す);
            変更前受給者訂正情報Entity.set受給者異動送付entity(new JukyushaIdoRenrakuhyo(entity));
            return 変更前受給者訂正情報Entity;
        }
        return null;
    }

    /**
     * 変更後の訂正情報を作成する
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param 異動年月日 FlexibleDate
     * @param 作成年月日 FlexibleDate
     * @param 氏名_性別_生年月日を印字する RString
     * @return JukyushaIdoRenrakuhyo
     */
    @Transaction
    public JukyushaTeiseiRenrakuhyoTorokuFinderResult editHenkoGoTeiseiJoho(
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            FlexibleDate 異動年月日,
            FlexibleDate 作成年月日,
            RString 氏名_性別_生年月日を印字する) {
        JukyushaTeiseiRenrakuhyoTorokuFinderResult 変更後受給者訂正情報Entity
                = new JukyushaTeiseiRenrakuhyoTorokuFinderResult();
        DbT3001JukyushaIdoRenrakuhyoEntity entity = 受給者異動送付Dac.getAllByKey(
                被保険者番号, 異動年月日, 履歴番号);
        if (entity != null) {
            entity.initializeMd5();
            変更後受給者訂正情報Entity.set作成年月日(作成年月日);
            変更後受給者訂正情報Entity.set受給者異動送付entity(new JukyushaIdoRenrakuhyo(entity));
            変更後受給者訂正情報Entity.set氏名_性別_生年月日を印字する(氏名_性別_生年月日を印字する);
            return 変更後受給者訂正情報Entity;
        }
        return null;
    }

    /**
     * 受給者訂正情報を取得する。
     *
     * @param 論理削除フラグ boolean
     * @param 受給者子Div JukyushaIdoRenrakuhyo
     * @param 変更前受給者訂正情報Entity JukyushaIdoRenrakuhyo
     * @param 変更後受給者訂正情報Entity JukyushaTeiseiRenrakuhyoTorokuFinderResult
     * @return JukyushaTeiseiRenrakuhyoTorokuFinderResult
     */
    public JukyushaTeiseiRenrakuhyoTorokuFinderResult judgeHenkokasho(
            boolean 論理削除フラグ,
            JukyushaIdoRenrakuhyo 受給者子Div,
            JukyushaTeiseiRenrakuhyoTorokuFinderResult 変更前受給者訂正情報Entity,
            JukyushaTeiseiRenrakuhyoTorokuFinderResult 変更後受給者訂正情報Entity) {
        JukyushaTeiseiRenrakuhyoTorokuFinderResult 出力用受給者訂正情報Entity
                = new JukyushaTeiseiRenrakuhyoTorokuFinderResult();
        if (!論理削除フラグ) {
            if (受給者子Div != null && TWO.equals(受給者子Div.get訂正区分コード()) && 変更後受給者訂正情報Entity != null
                    && 変更前受給者訂正情報Entity != null) {
                JukyushaIdoRenrakuhyo 変更後Entity = 変更後受給者訂正情報Entity.get受給者異動送付entity();
                出力用受給者訂正情報Entity.set受給者異動送付entity(get変更後受給者訂正情報修正Entity(
                        変更前受給者訂正情報Entity.get受給者異動送付entity(), 変更後Entity));
                出力用受給者訂正情報Entity.set氏名_性別_生年月日を印字する(
                        変更後受給者訂正情報Entity.get氏名_性別_生年月日を印字する());
                出力用受給者訂正情報Entity.set作成年月日(変更後受給者訂正情報Entity.get作成年月日());
            }
            if (受給者子Div != null && THREE.equals(受給者子Div.get訂正区分コード())
                    && 変更前受給者訂正情報Entity != null && 変更後受給者訂正情報Entity != null) {
                JukyushaIdoRenrakuhyo 変更前Entity = 変更前受給者訂正情報Entity.get受給者異動送付entity();
                変更前Entity = 変更前Entity
                        .createBuilderForEdit()
                        .set訂正区分コード(THREE)
                        .set訂正年月日(FlexibleDate.getNowDate()).build();
                出力用受給者訂正情報Entity.set受給者異動送付entity(変更前Entity);
                出力用受給者訂正情報Entity.set氏名_性別_生年月日を印字する(
                        変更前受給者訂正情報Entity.get氏名_性別_生年月日を印字する());
                出力用受給者訂正情報Entity.set作成年月日(変更前受給者訂正情報Entity.get作成年月日());
            }
        } else {
            if (変更後受給者訂正情報Entity != null && 変更前受給者訂正情報Entity != null) {
                JukyushaIdoRenrakuhyo 変更後Entity = 変更後受給者訂正情報Entity.
                        get受給者異動送付entity().createBuilderForEdit()
                        .set訂正区分コード(TWO)
                        .set訂正年月日(FlexibleDate.getNowDate()).build();
                出力用受給者訂正情報Entity.set受給者異動送付entity(get変更後受給者訂正情報修正Entity(
                        変更前受給者訂正情報Entity.get受給者異動送付entity(), 変更後Entity));
                if (変更前受給者訂正情報Entity.get受給者異動送付entity().is公費負担上限額減額有フラグ()
                        != 変更後Entity.is公費負担上限額減額有フラグ()) {
                    出力用受給者訂正情報Entity.set公費負担上限額減額有フラグ(変更後Entity.is公費負担上限額減額有フラグ());
                } else {
                    出力用受給者訂正情報Entity.set公費負担上限額減額有フラグ(null);
                }
                if (変更前受給者訂正情報Entity.get受給者異動送付entity().is小多機能居宅介護利用開始月利用有フラグ()
                        != 変更後Entity.is小多機能居宅介護利用開始月利用有フラグ()) {
                    出力用受給者訂正情報Entity.set小多機能居宅介護利用開始月利用有フラグ(
                            変更後Entity.is小多機能居宅介護利用開始月利用有フラグ());
                } else {
                    出力用受給者訂正情報Entity.set小多機能居宅介護利用開始月利用有フラグ(null);
                }
                出力用受給者訂正情報Entity.set氏名_性別_生年月日を印字する(
                        変更後受給者訂正情報Entity.get氏名_性別_生年月日を印字する());
                出力用受給者訂正情報Entity.set作成年月日(変更後受給者訂正情報Entity.get作成年月日());
            }
        }
        return 出力用受給者訂正情報Entity;
    }

    private JukyushaIdoRenrakuhyo get変更後受給者訂正情報修正Entity(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        if (!is比較変更年月日(変更前entity.get資格取得年月日(), 変更後entity.get資格取得年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().set資格取得年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get資格喪失年月日(), 変更後entity.get資格喪失年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().set資格喪失年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.getみなし要介護状態区分コード(), 変更後entity.getみなし要介護状態区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().setみなし要介護状態区分コード(RString.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get認定有効期間開始年月日(), 変更後entity.get認定有効期間開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().set認定有効期間開始年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get認定有効期間終了年月日(), 変更後entity.get認定有効期間終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().set認定有効期間終了年月日(RString.EMPTY).build();
        }
        if (変更前entity.get訪問通所サービス支給限度基準額() != 変更後entity.get訪問通所サービス支給限度基準額()) {
            変更後entity = 変更後entity.createBuilderForEdit().set訪問通所サービス支給限度基準額(0).build();
        }
        if (!is比較変更年月日(変更前entity.get訪問通所サービス上限管理適用期間開始年月日(),
                変更後entity.get訪問通所サービス上限管理適用期間開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set訪問通所サービス上限管理適用期間開始年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get訪問通所サービス上限管理適用期間終了年月日(),
                変更後entity.get訪問通所サービス上限管理適用期間終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set訪問通所サービス上限管理適用期間終了年月日(RString.EMPTY).build();
        }
        if (変更前entity.get短期入所サービス支給限度基準額() != 変更後entity.get短期入所サービス支給限度基準額()) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set短期入所サービス支給限度基準額(0).build();
        }
        if (!is比較変更年月日(変更前entity.get短期入所サービス上限管理適用期間開始年月日(),
                変更後entity.get短期入所サービス上限管理適用期間開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set短期入所サービス上限管理適用期間開始年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get短期入所サービス上限管理適用期間終了年月日(),
                変更後entity.get短期入所サービス上限管理適用期間終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set短期入所サービス上限管理適用期間終了年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅サービス計画作成区分コード(),
                変更後entity.get居宅サービス計画作成区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅サービス計画作成区分コード(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅介護支援事業所番号(),
                変更後entity.get居宅介護支援事業所番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅介護支援事業所番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅サービス計画適用開始年月日(),
                変更後entity.get居宅サービス計画適用開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅サービス計画適用開始年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅サービス計画適用終了年月日(),
                変更後entity.get居宅サービス計画適用終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅サービス計画適用終了年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get減免申請中区分コード(),
                変更後entity.get減免申請中区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set減免申請中区分コード(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get利用者負担区分コード(),
                変更後entity.get利用者負担区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set利用者負担区分コード(RString.EMPTY).build();
        }
        if (!is比較変更数字(変更前entity.get給付率(), 変更後entity.get給付率())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set給付率(null).build();
        }
        return get変更後受給者訂正情報修正Entity_One(変更前entity, 変更後entity);
    }

    private JukyushaIdoRenrakuhyo get変更後受給者訂正情報修正Entity_One(JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        if (!is比較変更文字列(変更前entity.is課税層の特例減額措置対象フラグ(),
                変更後entity.is課税層の特例減額措置対象フラグ())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set課税層の特例減額措置対象フラグ(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get食費負担限度額(), 変更後entity.get食費負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set食費負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居住費ユニット型個室負担限度額(),
                変更後entity.get居住費ユニット型個室負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居住費ユニット型個室負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居住費ユニット型準個室負担限度額(),
                変更後entity.get居住費ユニット型準個室負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居住費ユニット型準個室負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居住費従来型個室特養等負担限度額(),
                変更後entity.get居住費従来型個室特養等負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居住費従来型個室特養等負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居住費従来型個室老健療養等負担限度額(),
                変更後entity.get居住費従来型個室老健療養等負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居住費従来型個室老健療養等負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居住費多床室負担限度額(), 変更後entity.get居住費多床室負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居住費多床室負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅費_新１_負担限度額(), 変更後entity.get居宅費_新１_負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅費_新１_負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅費_新２_負担限度額(), 変更後entity.get居宅費_新２_負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅費_新２_負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get居宅費_新３_負担限度額(), 変更後entity.get居宅費_新３_負担限度額())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set居宅費_新３_負担限度額(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get負担限度額適用開始年月日(), 変更後entity.get負担限度額適用開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set負担限度額適用開始年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get負担限度額適用終了年月日(), 変更後entity.get負担限度額適用終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set負担限度額適用終了年月日(RString.EMPTY).build();
        }
        if (!is比較広域保険者番号(変更前entity.get広域連合_政令市_保険者番号(),
                変更後entity.get広域連合_政令市_保険者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set広域連合_政令市_保険者番号(ShoKisaiHokenshaNo.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get老人保健市町村番号(), 変更後entity.get老人保健市町村番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set老人保健市町村番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get老人保健受給者番号(), 変更後entity.get老人保健受給者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set老人保健受給者番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get公費負担者番号(), 変更後entity.get公費負担者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set公費負担者番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get軽減率(), 変更後entity.get軽減率())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set軽減率(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get軽減率適用開始年月日(), 変更後entity.get軽減率適用開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set軽減率適用開始年月日(RString.EMPTY).build();
        }
        return get変更後受給者訂正情報修正Entity_Two(変更前entity, 変更後entity);
    }

    private JukyushaIdoRenrakuhyo get変更後受給者訂正情報修正Entity_Two(JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        if (!is比較変更文字列(変更前entity.get軽減率適用終了年月日(), 変更後entity.get軽減率適用終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set軽減率適用終了年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get二次予防事業区分コード(), 変更後entity.get二次予防事業区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set二次予防事業区分コード(RString.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get二次予防事業有効期間開始年月日(),
                変更後entity.get二次予防事業有効期間開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set二次予防事業有効期間開始年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get二次予防事業有効期間終了年月日(),
                変更後entity.get二次予防事業有効期間終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set二次予防事業有効期間終了年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get申請種別コード(), 変更後entity.get申請種別コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set申請種別コード(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get変更申請中区分コード(), 変更後entity.get変更申請中区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set変更申請中区分コード(RString.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get申請年月日(), 変更後entity.get申請年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set申請年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get国民健康保険保険者番号(), 変更後entity.get国民健康保険保険者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set国民健康保険保険者番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get国民健康保険被保険者証番号(), 変更後entity.get国民健康保険被保険者証番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set国民健康保険被保険者証番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get国民健康保険個人番号(), 変更後entity.get国民健康保険個人番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set国民健康保険個人番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get後期高齢者医療保険者番号(), 変更後entity.get後期高齢者医療保険者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set後期高齢者医療保険者番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get後期高齢者医療被保険者番号(), 変更後entity.get後期高齢者医療被保険者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set後期高齢者医療被保険者番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get住所地特例対象者区分コード(), 変更後entity.get住所地特例対象者区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set住所地特例対象者区分コード(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get施設所在保険者番号(), 変更後entity.get施設所在保険者番号())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set施設所在保険者番号(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get住所地特例適用開始日(), 変更後entity.get住所地特例適用開始日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set住所地特例適用開始日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get住所地特例適用終了日(), 変更後entity.get住所地特例適用終了日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set住所地特例適用終了日(RString.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get二次予防事業有効期間開始年月日(),
                変更後entity.get二次予防事業有効期間開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set二次予防事業有効期間開始年月日(FlexibleDate.EMPTY).build();
        }
        if (!is比較変更年月日(変更前entity.get二次予防事業有効期間終了年月日(),
                変更後entity.get二次予防事業有効期間終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set二次予防事業有効期間終了年月日(FlexibleDate.EMPTY).build();
        }
        return get変更後受給者訂正情報修正Entity_Three(変更前entity, 変更後entity);
    }

    private JukyushaIdoRenrakuhyo get変更後受給者訂正情報修正Entity_Three(JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        if (!is比較変更文字列(変更前entity.get適用開始年月日(), 変更後entity.get適用開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set適用開始年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get適用終了年月日(), 変更後entity.get適用終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set適用終了年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get償還払化開始年月日(), 変更後entity.get償還払化開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set償還払化開始年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get償還払化終了年月日(), 変更後entity.get償還払化終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set償還払化終了年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get給付率引下げ開始年月日(), 変更後entity.get給付率引下げ開始年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set給付率引下げ開始年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get給付率引下げ終了年月日(), 変更後entity.get給付率引下げ終了年月日())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set給付率引下げ終了年月日(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get特定入所者認定申請中区分コード(),
                変更後entity.get特定入所者認定申請中区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set特定入所者認定申請中区分コード(RString.EMPTY).build();
        }
        if (!is比較変更文字列(変更前entity.get特定入所者介護サービス区分コード(),
                変更後entity.get特定入所者介護サービス区分コード())) {
            変更後entity = 変更後entity.createBuilderForEdit().
                    set特定入所者介護サービス区分コード(RString.EMPTY).build();
        }
        return 変更後entity;
    }

    private boolean is比較変更文字列(RString s1, RString s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更年月日(FlexibleDate s1, FlexibleDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較広域保険者番号(ShoKisaiHokenshaNo s1, ShoKisaiHokenshaNo s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更数字(Decimal s1, Decimal s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }
}
