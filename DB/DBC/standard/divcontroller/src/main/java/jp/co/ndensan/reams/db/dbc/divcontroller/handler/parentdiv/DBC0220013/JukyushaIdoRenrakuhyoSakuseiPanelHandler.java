/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220013;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013.JukyushaIdoRenrakuhyoSakuseiPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBCMN83001_受給者異動連絡票作成です
 *
 * @reamsid_L DBC-2102-010 lihang
 */
public class JukyushaIdoRenrakuhyoSakuseiPanelHandler {

    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private final JukyushaIdoRenrakuhyoSakuseiPanelDiv div;

    /**
     * コンストラクタです。
     *
     *
     * @param div JukyushaIdoRenrakuhyoSakuseiPanelDiv
     */
    public JukyushaIdoRenrakuhyoSakuseiPanelHandler(JukyushaIdoRenrakuhyoSakuseiPanelDiv div) {
        this.div = div;
    }

    /**
     * 受給者訂正連絡票Entityです
     *
     * @param 作成年月日 FlexibleDate
     * @param 氏名性別生年月日を印字する RString
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者訂正連絡票Entity(
            FlexibleDate 作成年月日, RString 氏名性別生年月日を印字する) {
        JukyushaIdoRenrakuhyoTorokuEntity entity = div.getCcdJukyushaIdoRenrakuhyo().get受給者訂正連絡票Entity();
        entity.set作成年月日(作成年月日);
        entity.set氏名性別生年月日を印字する(氏名性別生年月日を印字する);
        return entity;
    }

    /**
     * 受給者異動連絡票Entityです
     *
     * @param 作成年月日 FlexibleDate
     * @param 氏名性別生年月日を印字する RString
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity get受給者異動連絡票Entity(
            FlexibleDate 作成年月日, RString 氏名性別生年月日を印字する) {
        JukyushaIdoRenrakuhyoTorokuEntity entity
                = div.getCcdJukyushaIdoRenrakuhyo().get受給者異動連絡票Entity();
        entity.set作成年月日(作成年月日);
        entity.set氏名性別生年月日を印字する(氏名性別生年月日を印字する);
        return entity;
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保番号 RString
     */
    public void 前排他キーの解除(RString 被保番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保番号));
        RealInitialLocker.release(排他キー);
    }

    /**
     * 受給者異動連絡票内容変更状態です。
     *
     * @param 変更前entity JukyushaIdoRenrakuhyo
     * @param 変更後entity JukyushaIdoRenrakuhyo
     * @return boolean
     */
    public boolean is受給者異動連絡票内容変更状態(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is基本比較データ(変更前entity, 変更後entity)
                || is要介護認定エリア(変更前entity, 変更後entity)
                || is支給限度基準額エリア(変更前entity, 変更後entity)
                || is居宅サービス計画エリア(変更前entity, 変更後entity)
                || is住所地特例エリア(変更前entity, 変更後entity)
                || is減免_減額エリア(変更前entity, 変更後entity)
                || is後期高齢_国保エリア(変更前entity, 変更後entity)
                || is給付制限エリア(変更前entity, 変更後entity)
                || is殘りの比較データ(変更前entity, 変更後entity);
    }

    private boolean is基本比較データ(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更年月日(変更前entity.get異動年月日(), 変更後entity.get異動年月日())
                || is比較変更文字列(変更前entity.get異動区分コード(), 変更後entity.get異動区分コード())
                || is比較変更文字列(変更前entity.get受給者異動事由(), 変更後entity.get受給者異動事由())
                || is比較変更文字列(変更前entity.get被保険者氏名カナ(), 変更後entity.get被保険者氏名カナ())
                || is比較変更年月日(変更前entity.get生年月日(), 変更後entity.get生年月日())
                || is比較変更文字列(変更前entity.get性別コード(), 変更後entity.get性別コード())
                || is比較変更年月日(変更前entity.get資格取得年月日(), 変更後entity.get資格取得年月日())
                || is比較変更年月日(変更前entity.get資格喪失年月日(), 変更後entity.get資格喪失年月日())
                || is比較変更文字列(変更前entity.get証記載保険者番号().value(), 変更後entity.get証記載保険者番号().value())
                || is比較広域保険者番号(変更前entity.get広域連合_政令市_保険者番号(),
                        変更後entity.get広域連合_政令市_保険者番号())
                || is比較変更年月(変更前entity.get送付年月(), 変更後entity.get送付年月())
                || is比較変更年月日(変更前entity.get訂正年月日(), 変更後entity.get訂正年月日())
                || is比較変更文字列(変更前entity.get訂正区分コード(), 変更後entity.get訂正区分コード());
    }

    private boolean is要介護認定エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更年月日(変更前entity.get申請年月日(), 変更後entity.get申請年月日())
                || is比較変更文字列(変更前entity.get申請種別コード(), 変更後entity.get申請種別コード())
                || is比較変更文字列(変更前entity.get要介護状態区分コード(),
                        変更後entity.get要介護状態区分コード())
                || is比較変更文字列(変更前entity.get変更申請中区分コード(), 変更後entity.get変更申請中区分コード())
                || is比較変更年月日(変更前entity.get認定有効期間開始年月日(), 変更後entity.get認定有効期間開始年月日())
                || is比較変更文字列(変更前entity.get認定有効期間終了年月日(), 変更後entity.get認定有効期間終了年月日())
                || is比較変更文字列(変更前entity.getみなし要介護状態区分コード(),
                        変更後entity.getみなし要介護状態区分コード());
    }

    private boolean is支給限度基準額エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return 変更前entity.get訪問通所サービス支給限度基準額() != 変更後entity.get訪問通所サービス支給限度基準額()
                || is比較変更年月日(変更前entity.get訪問通所サービス上限管理適用期間開始年月日(),
                        変更後entity.get訪問通所サービス上限管理適用期間開始年月日())
                || is比較変更文字列(変更前entity.get訪問通所サービス上限管理適用期間終了年月日(),
                        変更後entity.get訪問通所サービス上限管理適用期間終了年月日())
                || 変更前entity.get短期入所サービス支給限度基準額() != 変更後entity.get短期入所サービス支給限度基準額()
                || is比較変更年月日(変更前entity.get短期入所サービス上限管理適用期間開始年月日(),
                        変更後entity.get短期入所サービス上限管理適用期間開始年月日())
                || is比較変更年月日(変更前entity.get短期入所サービス上限管理適用期間終了年月日(),
                        変更後entity.get短期入所サービス上限管理適用期間終了年月日());
    }

    private boolean is居宅サービス計画エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get居宅サービス計画作成区分コード(),
                変更後entity.get居宅サービス計画作成区分コード())
                || is比較変更文字列(変更前entity.get居宅介護支援事業所番号(), 変更後entity.get居宅介護支援事業所番号())
                || is比較変更文字列(変更前entity.get居宅サービス計画適用開始年月日(),
                        変更後entity.get居宅サービス計画適用開始年月日())
                || is比較変更文字列(変更前entity.get居宅サービス計画適用終了年月日(),
                        変更後entity.get居宅サービス計画適用終了年月日())
                || 変更前entity.is小多機能居宅介護利用開始月利用有フラグ()
                != 変更後entity.is小多機能居宅介護利用開始月利用有フラグ();
    }

    private boolean is住所地特例エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get住所地特例対象者区分コード(),
                変更後entity.get住所地特例対象者区分コード())
                || is比較変更文字列(変更前entity.get住所地特例適用開始日(), 変更後entity.get住所地特例適用開始日())
                || is比較変更文字列(変更前entity.get住所地特例適用終了日(), 変更後entity.get住所地特例適用終了日())
                || is比較変更文字列(変更前entity.get施設所在保険者番号(), 変更後entity.get施設所在保険者番号());
    }

    private boolean is減免_減額エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get減免申請中区分コード(), 変更後entity.get減免申請中区分コード())
                || is比較変更文字列(変更前entity.get利用者負担区分コード(), 変更後entity.get利用者負担区分コード())
                || is比較変更数字(変更前entity.get給付率(), 変更後entity.get給付率())
                || is比較変更文字列(変更前entity.get適用開始年月日(), 変更後entity.get適用開始年月日())
                || is比較変更文字列(変更前entity.get適用終了年月日(), 変更後entity.get適用終了年月日())
                || is比較変更文字列(変更前entity.get軽減率(), 変更後entity.get軽減率())
                || is比較変更文字列(変更前entity.get軽減率適用開始年月日(), 変更後entity.get軽減率適用開始年月日())
                || is比較変更文字列(変更前entity.get軽減率適用終了年月日(), 変更後entity.get軽減率適用終了年月日())
                || is比較変更文字列(変更前entity.get標準負担区分コード(), 変更後entity.get標準負担区分コード())
                || is比較変更数字(変更前entity.get負担額(), 変更後entity.get負担額())
                || is比較変更文字列(変更前entity.get負担額適用開始年月日(), 変更後entity.get負担額適用開始年月日())
                || is比較変更文字列(変更前entity.get負担額適用終了年月日(), 変更後entity.get負担額適用終了年月日())
                || is比較変更文字列(変更前entity.get特定入所者認定申請中区分コード(),
                        変更後entity.get特定入所者認定申請中区分コード())
                || is比較変更文字列(変更前entity.get特定入所者介護サービス区分コード(),
                        変更後entity.get特定入所者介護サービス区分コード())
                || 変更前entity.is課税層の特例減額措置対象フラグ() != 変更後entity.is課税層の特例減額措置対象フラグ()
                || is減額エリア(変更前entity, 変更後entity);
    }

    private boolean is減額エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get食費負担限度額(), 変更後entity.get食費負担限度額())
                || is比較変更文字列(変更前entity.get負担限度額適用開始年月日(), 変更後entity.get負担限度額適用開始年月日())
                || is比較変更文字列(変更前entity.get負担限度額適用終了年月日(), 変更後entity.get負担限度額適用終了年月日())
                || is比較変更文字列(変更前entity.get居住費従来型個室特養等負担限度額(),
                        変更後entity.get居住費従来型個室特養等負担限度額())
                || is比較変更文字列(変更前entity.get居住費従来型個室老健療養等負担限度額(),
                        変更後entity.get居住費従来型個室老健療養等負担限度額())
                || is比較変更文字列(変更前entity.get居住費多床室負担限度額(), 変更後entity.get居住費多床室負担限度額())
                || is比較変更文字列(変更前entity.get居住費ユニット型個室負担限度額(),
                        変更後entity.get居住費ユニット型個室負担限度額())
                || is比較変更文字列(変更前entity.get居住費ユニット型個室負担限度額(),
                        変更後entity.get居住費ユニット型準個室負担限度額())
                || is比較変更文字列(変更前entity.get居宅費_新１_負担限度額(),
                        変更後entity.get居宅費_新１_負担限度額())
                || is比較変更文字列(変更前entity.get居宅費_新２_負担限度額(),
                        変更後entity.get居宅費_新２_負担限度額())
                || is比較変更文字列(変更前entity.get居宅費_新３_負担限度額(),
                        変更後entity.get居宅費_新３_負担限度額());
    }

    private boolean is後期高齢_国保エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get後期高齢者医療保険者番号(), 変更後entity.get後期高齢者医療保険者番号())
                || is比較変更文字列(変更前entity.get後期高齢者医療被保険者番号(),
                        変更後entity.get後期高齢者医療被保険者番号())
                || is比較変更文字列(変更前entity.get後期高齢者医療被保険者番号(),
                        変更後entity.get後期高齢者医療被保険者番号())
                || is比較変更文字列(変更前entity.get国民健康保険保険者番号(),
                        変更後entity.get国民健康保険保険者番号())
                || is比較変更文字列(変更前entity.get国民健康保険被保険者証番号(),
                        変更後entity.get国民健康保険被保険者証番号())
                || is比較変更文字列(変更前entity.get国民健康保険個人番号(), 変更後entity.get国民健康保険個人番号());
    }

    private boolean is給付制限エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return 変更前entity.is公費負担上限額減額有フラグ() != 変更後entity.is公費負担上限額減額有フラグ()
                || is比較変更文字列(変更前entity.get償還払化開始年月日(), 変更後entity.get償還払化開始年月日())
                || is比較変更文字列(変更前entity.get償還払化終了年月日(), 変更後entity.get償還払化終了年月日())
                || is比較変更文字列(変更前entity.get給付率引下げ開始年月日(), 変更後entity.get給付率引下げ開始年月日())
                || is比較変更文字列(変更前entity.get給付率引下げ終了年月日(), 変更後entity.get給付率引下げ終了年月日());
    }

    private boolean is殘りの比較データ(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get利用者負担割合有効開始日(), 変更後entity.get利用者負担割合有効開始日())
                || is比較変更文字列(変更前entity.get利用者負担割合有効終了日(), 変更後entity.get利用者負担割合有効終了日())
                || is比較変更文字列(変更前entity.get利用者負担割合有効終了日(), 変更後entity.get利用者負担割合有効終了日())
                || is比較変更文字列(変更前entity.get二次予防事業区分コード(), 変更後entity.get二次予防事業区分コード())
                || is比較変更年月日(変更前entity.get二次予防事業有効期間開始年月日(),
                        変更後entity.get二次予防事業有効期間開始年月日())
                || is比較変更年月日(変更前entity.get二次予防事業有効期間終了年月日(),
                        変更後entity.get二次予防事業有効期間終了年月日())
                || is比較変更文字列(変更前entity.get老人保健市町村番号(), 変更後entity.get老人保健市町村番号())
                || is比較変更文字列(変更前entity.get老人保健受給者番号(), 変更後entity.get老人保健受給者番号())
                || is比較変更文字列(変更前entity.get公費負担者番号(), 変更後entity.get公費負担者番号());
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

    private boolean is比較変更年月(FlexibleYearMonth s1, FlexibleYearMonth s2) {
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
