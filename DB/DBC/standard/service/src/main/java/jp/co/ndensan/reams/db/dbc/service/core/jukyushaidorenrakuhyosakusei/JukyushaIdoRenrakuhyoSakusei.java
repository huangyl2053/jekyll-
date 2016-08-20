 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyosakusei;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyosakusei.JukyushaIdoRenrakuhyoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoSakuseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN83001_受給者異動連絡票作成（画面）です
 *
 * @reamsid_L DBC-2102-020 lihang
 */
public class JukyushaIdoRenrakuhyoSakusei {

    private final DbT3001JukyushaIdoRenrakuhyoSakuseiDac dac;

    /**
     * コンストラクタです。
     */
    JukyushaIdoRenrakuhyoSakusei() {
        dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoSakuseiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     */
    JukyushaIdoRenrakuhyoSakusei(DbT3001JukyushaIdoRenrakuhyoSakuseiDac dbT3001Dac) {
        this.dac = dbT3001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoSakusei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoSakusei}のインスタンス
     */
    public static JukyushaIdoRenrakuhyoSakusei createInstance() {
        return InstanceProvider.create(JukyushaIdoRenrakuhyoSakusei.class);
    }

    private RString compareRString(RString obj1, RString obj2) {
        if (RString.isNullOrEmpty(obj1) && RString.isNullOrEmpty(obj2)) {
            return RString.EMPTY;
        } else if (RString.isNullOrEmpty(obj1) && !RString.isNullOrEmpty(obj2)) {
            return obj2;
        } else if (!RString.isNullOrEmpty(obj1) && RString.isNullOrEmpty(obj2)) {
            return RString.EMPTY;
        } else if (!obj1.equals(obj2)) {
            return obj2;
        }
        return RString.EMPTY;
    }

    private FlexibleDate compareFlexibleDate(FlexibleDate obj1, FlexibleDate obj2) {
        if ((obj1 == null || obj1.isEmpty()) && (obj2 == null || obj2.isEmpty())) {
            return FlexibleDate.EMPTY;
        } else if ((obj1 == null || obj1.isEmpty())
                && (obj2 != null && !obj2.isEmpty())) {
            return obj2;
        } else if ((obj1 != null && !obj1.isEmpty()) && (obj2 == null || obj2.isEmpty())) {
            return FlexibleDate.EMPTY;
        } else if (!obj1.equals(obj2)) {
            return obj2;
        }
        return FlexibleDate.EMPTY;
    }

    /**
     * 出力用受給者訂正情報Entity
     *
     * @param 変更後entity JukyushaIdoRenrakuhyoTorokuEntity
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    public JukyushaIdoRenrakuhyoSakuseiRelateEntity 出力用受給者訂正情報Entity(JukyushaIdoRenrakuhyoTorokuEntity 変更後entity) {
        JukyushaIdoRenrakuhyoTorokuEntity 変更前entity = 変更前受給者訂正情報作成(変更後entity);
        JukyushaIdoRenrakuhyoSakuseiRelateEntity relateEntity
                = new JukyushaIdoRenrakuhyoSakuseiRelateEntity(変更前entity, 変更後entity, new JukyushaIdoRenrakuhyoTorokuEntity());
        relateEntity.get出力用受給者訂正情報Entity().set作成年月日(変更後entity.get作成年月日());
        relateEntity.get出力用受給者訂正情報Entity().set氏名性別生年月日を印字する(変更後entity.get氏名性別生年月日を印字する());
        relateEntity.get出力用受給者訂正情報Entity().set証記載保険者番号(変更後entity.get証記載保険者番号());
        relateEntity.get出力用受給者訂正情報Entity().set被保険者番号(変更後entity.get被保険者番号());
        relateEntity.get出力用受給者訂正情報Entity().set異動年月日(変更後entity.get異動年月日());
        relateEntity.get出力用受給者訂正情報Entity().set異動区分(変更後entity.get異動区分());
        relateEntity.get出力用受給者訂正情報Entity().set異動事由(変更後entity.get異動事由());
        relateEntity.get出力用受給者訂正情報Entity().set訂正年月日(変更後entity.get訂正年月日());
        relateEntity.get出力用受給者訂正情報Entity().set訂正区分コード(変更後entity.get訂正区分コード());
        relateEntity.get出力用受給者訂正情報Entity().set性別(変更後entity.get性別());
        relateEntity.get出力用受給者訂正情報Entity().set被保険者氏名カナ(変更後entity.get被保険者氏名カナ());
        relateEntity.get出力用受給者訂正情報Entity().set生年月日(変更後entity.get生年月日());
        relateEntity.get出力用受給者訂正情報Entity().setみなし区分(compareRString(変更前entity.getみなし区分(), 変更後entity.getみなし区分()));
        relateEntity.get出力用受給者訂正情報Entity().set支給限度基準額1(compareRString(変更前entity.get支給限度基準額1(), 変更後entity.get支給限度基準額1()));
        relateEntity.get出力用受給者訂正情報Entity().set支給限度基準額２(compareRString(変更前entity.get支給限度基準額２(), 変更後entity.get支給限度基準額２()));
        relateEntity.get出力用受給者訂正情報Entity().set計画作成区分(compareRString(変更前entity.get計画作成区分(), 変更後entity.get計画作成区分()));
        relateEntity.get出力用受給者訂正情報Entity().set居宅支援事業者番号(compareRString(変更前entity.get居宅支援事業者番号(), 変更後entity.get居宅支援事業者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set減免申請中区分(compareRString(変更前entity.get減免申請中区分(), 変更後entity.get減免申請中区分()));
        relateEntity.get出力用受給者訂正情報Entity().set利用者負担区分(compareRString(変更前entity.get利用者負担区分(), 変更後entity.get利用者負担区分()));
        relateEntity.get出力用受給者訂正情報Entity().set利用給付率(compareRString(変更前entity.get利用給付率(), 変更後entity.get利用給付率()));
        relateEntity.get出力用受給者訂正情報Entity().set要介護状態区分(compareRString(変更前entity.get要介護状態区分(), 変更後entity.get要介護状態区分()));
        relateEntity.get出力用受給者訂正情報Entity().set標準負担区分(compareRString(変更前entity.get標準負担区分(), 変更後entity.get標準負担区分()));
        relateEntity.get出力用受給者訂正情報Entity().set標準負担額(compareRString((変更前entity.get標準負担額()), 変更後entity.get標準負担額()));
        relateEntity.get出力用受給者訂正情報Entity().set認定申請中区分(compareRString(変更前entity.get認定申請中区分(), 変更後entity.get認定申請中区分()));
        relateEntity.get出力用受給者訂正情報Entity().setｻｰﾋﾞｽ区分(compareRString(変更前entity.
                getｻｰﾋﾞｽ区分(), 変更後entity.getｻｰﾋﾞｽ区分()));
        relateEntity.get出力用受給者訂正情報Entity().set特例減額措置対象(compareRString(変更前entity.
                get特例減額措置対象(), 変更後entity.get特例減額措置対象()));
        relateEntity.get出力用受給者訂正情報Entity().set食費負担限度額(compareRString(変更前entity.
                get食費負担限度額(), 変更後entity.get食費負担限度額()));
        relateEntity.get出力用受給者訂正情報Entity().setﾕﾆｯﾄ型個室(compareRString(変更前entity.
                getﾕﾆｯﾄ型個室(), 変更後entity.getﾕﾆｯﾄ型個室()));
        relateEntity.get出力用受給者訂正情報Entity().setﾕﾆｯﾄ型準個室(compareRString(変更前entity.
                getﾕﾆｯﾄ型準個室(), 変更後entity.getﾕﾆｯﾄ型準個室()));
        relateEntity.get出力用受給者訂正情報Entity().set従来型個室特(compareRString(変更前entity.
                get従来型個室特(), 変更後entity.get従来型個室特()));
        relateEntity.get出力用受給者訂正情報Entity().set従来型個室老療(compareRString(変更前entity.
                get従来型個室老療(), 変更後entity.get従来型個室老療()));
        relateEntity.get出力用受給者訂正情報Entity().set多床室(compareRString(変更前entity.
                get多床室(), 変更後entity.get多床室()));
        relateEntity.get出力用受給者訂正情報Entity().set新１(compareRString(変更前entity.get新１(), 変更後entity.get新１()));
        relateEntity.get出力用受給者訂正情報Entity().set新２(compareRString(変更前entity.get新２(), 変更後entity.get新２()));
        relateEntity.get出力用受給者訂正情報Entity().set新３(compareRString(変更前entity.get新３(), 変更後entity.get新３()));
        relateEntity.get出力用受給者訂正情報Entity().set広域保険者番号(compareRString(変更前entity.
                get広域保険者番号(), 変更後entity.get広域保険者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set老人保健市町村番号(compareRString(変更前entity.
                get老人保健市町村番号(), 変更後entity.get老人保健市町村番号()));
        relateEntity.get出力用受給者訂正情報Entity().set老人保健受給者番号(compareRString(変更前entity.
                get老人保健受給者番号(), 変更後entity.get老人保健受給者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set老人保健公費負担者番号(compareRString(変更前entity.
                get老人保健公費負担者番号(), 変更後entity.get老人保健公費負担者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set軽減率(compareRString(変更前entity.
                get軽減率(), 変更後entity.get軽減率()));
        relateEntity.get出力用受給者訂正情報Entity().set二次予防事業区分(compareRString(変更前entity.
                get二次予防事業区分(), 変更後entity.get二次予防事業区分()));
        relateEntity.get出力用受給者訂正情報Entity().set申請種別(compareRString(変更前entity.
                get申請種別(), 変更後entity.get申請種別()));
        relateEntity.get出力用受給者訂正情報Entity().set変更申請中区分(compareRString(変更前entity.
                get変更申請中区分(), 変更後entity.get変更申請中区分()));
        relateEntity.get出力用受給者訂正情報Entity().set国保保険者番号(compareRString(変更前entity.
                get国保保険者番号(), 変更後entity.get国保保険者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set国保被保険者証番号(compareRString(変更前entity.
                get国保被保険者証番号(), 変更後entity.get国保被保険者証番号()));
        relateEntity.get出力用受給者訂正情報Entity().set国保個人番号(compareRString(変更前entity.
                get国保個人番号(), 変更後entity.get国保個人番号()));
        relateEntity.get出力用受給者訂正情報Entity().set後期高齢保険者番号(compareRString(変更前entity.
                get後期高齢保険者番号(), 変更後entity.get後期高齢保険者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set後期高齢被保険者番号(compareRString(変更前entity.
                get後期高齢被保険者番号(), 変更後entity.get後期高齢被保険者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set住特対象者区分(compareRString(変更前entity.
                get住特対象者区分(), 変更後entity.get住特対象者区分()));
        relateEntity.get出力用受給者訂正情報Entity().set住特施設所在保険者番号(compareRString(変更前entity.
                get住特施設所在保険者番号(), 変更後entity.get住特施設所在保険者番号()));
        relateEntity.get出力用受給者訂正情報Entity().set資格取得年月日(compareFlexibleDate(変更前entity.
                get資格取得年月日(), 変更後entity.get資格取得年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set資格喪失年月日(compareFlexibleDate(変更前entity.
                get資格喪失年月日(), 変更後entity.get資格喪失年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set有効期間開始年月日(compareFlexibleDate(変更前entity.
                get有効期間開始年月日(), 変更後entity.get有効期間開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set有効期間終了年月日(compareFlexibleDate(変更前entity.
                get有効期間終了年月日(), 変更後entity.get有効期間終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set上限管理適用開始年月日１(compareFlexibleDate(変更前entity.
                get上限管理適用開始年月日１(), 変更後entity.get上限管理適用開始年月日１()));
        relateEntity.get出力用受給者訂正情報Entity().set上限管理終了年月日１(compareFlexibleDate(変更前entity.
                get上限管理終了年月日１(), 変更後entity.get上限管理終了年月日１()));
        relateEntity.get出力用受給者訂正情報Entity().set上限管理適用開始年月日２(compareFlexibleDate(変更前entity.
                get上限管理適用開始年月日２(), 変更後entity.get上限管理適用開始年月日２()));
        relateEntity.get出力用受給者訂正情報Entity().set上限管理終了年月日２(compareFlexibleDate(変更前entity.
                get上限管理終了年月日２(), 変更後entity.get上限管理終了年月日２()));
        relateEntity.get出力用受給者訂正情報Entity().set居宅適用開始年月日(compareFlexibleDate(変更前entity.
                get居宅適用開始年月日(), 変更後entity.get居宅適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set居宅適用終了年月日(compareFlexibleDate(変更前entity.
                get居宅適用終了年月日(), 変更後entity.get居宅適用終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set利用適用開始年月日(compareFlexibleDate(変更前entity.
                get利用適用開始年月日(), 変更後entity.get利用適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set利用適用終了年月日(compareFlexibleDate(変更前entity.
                get利用適用終了年月日(), 変更後entity.get利用適用終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set標準適用開始年月日(compareFlexibleDate(変更前entity.
                get標準適用開始年月日(), 変更後entity.get標準適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set標準適用終了年月日(compareFlexibleDate(変更前entity.
                get標準適用終了年月日(), 変更後entity.get標準適用終了年月日()));
        relateEntity.get変更後受給者訂正情報Entity().set償還払化適用開始年月日(compareFlexibleDate(変更前entity.
                get償還払化適用開始年月日(), 変更後entity.get償還払化適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set償還払化適用終了年月日(compareFlexibleDate(変更前entity.
                get償還払化適用終了年月日(), 変更後entity.get償還払化適用終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set給付率引下げ適用開始年月日(compareFlexibleDate(変更前entity.
                get給付率引下げ適用開始年月日(), 変更後entity.get給付率引下げ適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set給付率引下げ適用終了年月日(compareFlexibleDate(変更前entity.
                get給付率引下げ適用終了年月日(), 変更後entity.get給付率引下げ適用終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set特定入所者適用開始年月日(compareFlexibleDate(変更前entity.
                get特定入所者適用開始年月日(), 変更後entity.get特定入所者適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set特定入所者適用終了年月日(compareFlexibleDate(変更前entity.
                get特定入所者適用終了年月日(), 変更後entity.get特定入所者適用終了年月日()));
        if (変更前entity.get公費負担上限額減額() != 変更後entity.get公費負担上限額減額()) {
            relateEntity.get出力用受給者訂正情報Entity().set公費負担上限額減額(変更後entity.get公費負担上限額減額());
        } else {
            //TODO
            relateEntity.get出力用受給者訂正情報Entity().set公費負担上限額減額(false);
        }
        if (変更前entity.get小規模居宅ｻｰﾋﾞｽ利用() != 変更後entity.get小規模居宅ｻｰﾋﾞｽ利用()) {
            relateEntity.get出力用受給者訂正情報Entity().set小規模居宅ｻｰﾋﾞｽ利用(変更後entity.get小規模居宅ｻｰﾋﾞｽ利用());
        } else {
            relateEntity.get出力用受給者訂正情報Entity().set公費負担上限額減額(false);
        }
        relateEntity.get出力用受給者訂正情報Entity().set軽減率適用開始年月日(compareFlexibleDate(変更前entity.
                get軽減率適用開始年月日(), 変更後entity.get軽減率適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set軽減率適用終了年月日(compareFlexibleDate(変更前entity.
                get軽減率適用終了年月日(), 変更後entity.get軽減率適用終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set二次予防有効期間開始年月日(compareFlexibleDate(変更前entity.
                get二次予防有効期間開始年月日(), 変更後entity.get二次予防有効期間開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set二次予防有効期間終了年月日(compareFlexibleDate(変更前entity.
                get二次予防有効期間終了年月日(), 変更後entity.get二次予防有効期間終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set申請年月日(compareFlexibleDate(変更前entity.
                get申請年月日(), 変更後entity.get申請年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set住特適用開始年月日(compareFlexibleDate(変更前entity.
                get住特適用開始年月日(), 変更後entity.get住特適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set住特適用終了年月日(compareFlexibleDate(変更前entity.
                get住特適用終了年月日(), 変更後entity.get住特適用終了年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set二割負担適用開始年月日(compareFlexibleDate(変更前entity.
                get二割負担適用開始年月日(), 変更後entity.get二割負担適用開始年月日()));
        relateEntity.get出力用受給者訂正情報Entity().set二割負担適用終了年月日(compareFlexibleDate(変更前entity.
                get二割負担適用終了年月日(), 変更後entity.get二割負担適用終了年月日()));
        return relateEntity;
    }

    /**
     * 受給者訂正連絡票データを作成する
     *
     * @param entity JukyushaIdoRenrakuhyoTorokuEntity
     * @return JukyushaIdoRenrakuhyoSakuseiRelateEntity
     */
    public JukyushaIdoRenrakuhyoTorokuEntity 変更前受給者訂正情報作成(JukyushaIdoRenrakuhyoTorokuEntity entity) {
        JukyushaIdoRenrakuhyoTorokuEntity relateEntity = new JukyushaIdoRenrakuhyoTorokuEntity();
        DbT3001JukyushaIdoRenrakuhyoEntity 変更前Entity = dac.select受給者訂正情報を取得(entity.get被保険者番号(),
                new RString(relateEntity.get異動年月日().toString()));
        relateEntity.set上限管理終了年月日１(変更前Entity.getNijiyoboJigyoYukoKikanKaishiYMD());
        if (変更前Entity == null) {
            return null;
        }
        relateEntity.set作成年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
        if (変更前Entity.getShoKisaiHokenshaNo() != null) {
            relateEntity.set証記載保険者番号(変更前Entity.getShoKisaiHokenshaNo().getColumnValue());
        }
        if (変更前Entity.getHiHokenshaNo() != null) {
            relateEntity.set被保険者番号(変更前Entity.getHiHokenshaNo().getColumnValue());
        }
        relateEntity.set氏名性別生年月日を印字する(entity.get氏名性別生年月日を印字する());
        relateEntity.set異動年月日(変更前Entity.getIdoYMD());
        relateEntity.set異動区分(変更前Entity.getIdoKubunCode());
        relateEntity.set性別(変更前Entity.getSeibetsuCode());
        relateEntity.set異動事由(変更前Entity.getJukyushaIdoJiyu());
        relateEntity.set被保険者氏名カナ(変更前Entity.getHiHokenshaNameKana());
        relateEntity.set生年月日(変更前Entity.getUmareYMD());
        relateEntity.set資格取得年月日(変更前Entity.getShikakuShutokuYMD());
        relateEntity.set資格喪失年月日(変更前Entity.getShikakuSoshitsuYMD());
        relateEntity.setみなし区分(変更前Entity.getMinashiYokaigoJotaiKubunCode());
        relateEntity.set要介護状態区分(変更前Entity.getYokaigoJotaiKubunCode());
        relateEntity.set有効期間開始年月日(変更前Entity.getNinteiYukoKikankaishiYMD());
        relateEntity.set有効期間終了年月日(new FlexibleDate(
                変更前Entity.getNinteiYukoKikanShuryoYMD()));
        relateEntity.set支給限度基準額1(new RString(
                変更前Entity.getHomonTsushoServiceShikyuGendoKijungaku()));
        relateEntity.set上限管理適用開始年月日１(
                変更前Entity.getHomonTsushoServiceJogenKanriTekiyoKaishiYMD());
        relateEntity.set上限管理終了年月日１(new FlexibleDate(
                変更前Entity.getHomonTsushoServiceJogenKanriTekiyoShuryoYMD()));
        relateEntity.set支給限度基準額２(new RString(
                変更前Entity.getTankiNyushoServiceShikyuGendoKijungaku()));
        relateEntity.set上限管理適用開始年月日２(変更前Entity.
                getTankinyushoServiceJogenKanriTekiyoKaishiYMD());
        relateEntity.set上限管理終了年月日２(
                変更前Entity.getTankinyushoServiceJogenKanriTekiyoShuryoYMD());
        relateEntity.set計画作成区分(変更前Entity.getKyotakuServiceSakuseiKubunCode());
        relateEntity.set居宅支援事業者番号(変更前Entity.getKyotakuKaigoShienJigyoshoNo());
        relateEntity.set居宅適用開始年月日(new FlexibleDate(
                変更前Entity.getKyotakuServiceTekiyoKaishiYMD()));
        relateEntity.set居宅適用終了年月日(new FlexibleDate(
                変更前Entity.getKyotakuServiceTekiyoShuryoYMD()));
        relateEntity.set減免申請中区分(変更前Entity.getGemmenShinseichuKubunCode());
        relateEntity.set利用者負担区分(変更前Entity.getRiyoshaFutanKubunCode());
        Decimal kyufuritsu = 変更前Entity.getKyufuritsu();
        if (kyufuritsu != null) {
            relateEntity.set利用給付率(new RString(kyufuritsu.toString()));
        }
        relateEntity.set利用適用開始年月日(new FlexibleDate(変更前Entity.getTekiyoKaishiYMD()));
        relateEntity.set利用適用終了年月日(new FlexibleDate(変更前Entity.getTekiyoShuryoYMD()));
        relateEntity.set標準負担区分(変更前Entity.getHyojunFutanKubunCode());
        Decimal futangaku = 変更前Entity.getFutangaku();
        if (futangaku != null) {
            relateEntity.set標準負担額(new RString(futangaku.toString()));
        }
        relateEntity.set標準適用開始年月日(new FlexibleDate(
                変更前Entity.getFutangakuTekiyoKaishiYMD()));
        relateEntity.set標準適用終了年月日(new FlexibleDate(
                変更前Entity.getFutangakuTekiyoShuryoYMD()));
        relateEntity.set公費負担上限額減額(変更前Entity.getKohiFutanJogenGengakuAriFlag());
        relateEntity.set償還払化適用開始年月日(new FlexibleDate(
                変更前Entity.getShokanbaraikaKaishiYMD()));
        relateEntity.set償還払化適用終了年月日(new FlexibleDate(
                変更前Entity.getShokanbaraikaShuryoYMD()));
        relateEntity.set給付率引下げ適用開始年月日(new FlexibleDate(
                変更前Entity.getKyufuritsuHikisageKaishiYMD()));
        relateEntity.set給付率引下げ適用終了年月日(new FlexibleDate(
                変更前Entity.getKyufuritsuHikisageShuryoYMD()));
        relateEntity.set認定申請中区分(
                変更前Entity.getTokuteiNyushoshaNinteiShinseichuKubunCode());
        relateEntity.setｻｰﾋﾞｽ区分(変更前Entity.getTokuteiNyushoshaKaigoServiceKubunCode());
        relateEntity.set特例減額措置対象(変更前Entity.getKaizeisoTokureiGengakuSochiTaishoFlag());
        relateEntity.set食費負担限度額(変更前Entity.getShokuhiFutanGendogaku());
        relateEntity.setﾕﾆｯﾄ型個室(変更前Entity.getKyojuhiUnitGataKoshitsuFutanGendogaku());
        relateEntity.setﾕﾆｯﾄ型準個室(変更前Entity.getKyojuhiUnitGataJunKoshitsuFutanGendogaku());
        relateEntity.set従来型個室特(
                変更前Entity.getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku());
        relateEntity.set従来型個室老療(
                変更前Entity.getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku());
        relateEntity.set多床室(変更前Entity.getKyujuhiTashoshitsuFutanGendogaku());
        relateEntity.set新１(変更前Entity.getKyotakuhiShin1FutanGendogaku());
        relateEntity.set新２(変更前Entity.getKyotakuhiShin2FutanGendogaku());
        relateEntity.set新３(変更前Entity.getKyotakuhiShin3FutanGendogaku());
        relateEntity.set特定入所者適用開始年月日(new FlexibleDate(
                変更前Entity.getFutanGendogakuTekiyoKaishiYMD()));
        relateEntity.set特定入所者適用終了年月日(new FlexibleDate(
                変更前Entity.getFutanGendogakuTekiyoShuryoYMD()));
        ShoKisaiHokenshaNo koikiRengoHokenshaNo = 変更前Entity.getKoikiRengoHokenshaNo();
        if (koikiRengoHokenshaNo != null) {
            relateEntity.set広域保険者番号(koikiRengoHokenshaNo.getColumnValue());
        }
        relateEntity.set老人保健市町村番号(変更前Entity.getRojinHokenShichosonNo());
        relateEntity.set老人保健受給者番号(変更前Entity.getRojinHokenJukyushaNo());
        relateEntity.set老人保健公費負担者番号(変更前Entity.getKohiFutanshaNo());
        relateEntity.set軽減率(変更前Entity.getKeigenritsu());
        relateEntity.set軽減率適用開始年月日(new FlexibleDate(
                変更前Entity.getKeigenritsuTekiyoKaishiYMD()));
        relateEntity.set軽減率適用終了年月日(new FlexibleDate(
                変更前Entity.getKeigenritsuTekiyoShuryoYMD()));
        relateEntity.set小規模居宅ｻｰﾋﾞｽ利用(
                変更前Entity.getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag());
        relateEntity.set二次予防事業区分(変更前Entity.getNijiyoboJigyoKubunCode());
        relateEntity.set二次予防有効期間開始年月日(
                変更前Entity.getNijiyoboJigyoYukoKikanKaishiYMD());
        relateEntity.set二次予防有効期間終了年月日(
                変更前Entity.getNijiyoboJigyoYukoKikanShuryoYMD());
        relateEntity.set申請種別(変更前Entity.getShinseiShubetsuCode());
        relateEntity.set変更申請中区分(変更前Entity.getHenkoShinseichuKubunCode());
        relateEntity.set申請年月日(変更前Entity.getShinseiYMD());
        relateEntity.set国保保険者番号(変更前Entity.getKokuhoHokenshaNo());
        relateEntity.set国保被保険者証番号(変更前Entity.getKokuhoHiHokenshaNo());
        relateEntity.set国保個人番号(変更前Entity.getKokuhoKojinNo());
        relateEntity.set後期高齢保険者番号(変更前Entity.getKokiKoureiIryoHokenshaNo());
        relateEntity.set後期高齢被保険者番号(変更前Entity.getKokikoureiIryoHiHokenshaNo());
        relateEntity.set住特対象者区分(変更前Entity.getJushochiTokureiTaishoshaKubunCode());
        relateEntity.set住特施設所在保険者番号(変更前Entity.getShisetsuShozaiHokenjaNo());
        relateEntity.set住特適用開始年月日(new FlexibleDate(
                変更前Entity.getJushochiTokureiTekiyoKaishiYMD()));
        relateEntity.set住特適用終了年月日(new FlexibleDate(
                変更前Entity.getJushochiTokureiTekiyoShuryoYMD()));
        relateEntity.set二割負担適用開始年月日(new FlexibleDate(
                変更前Entity.getRiyosyaFutanWariaiYukoKaishiYMD()));
        relateEntity.set二割負担適用終了年月日(new FlexibleDate(
                変更前Entity.getRiyosyaFutanWariaiYukoShuryoYMD()));
        relateEntity.set訂正年月日(変更前Entity.getTeiseiYMD());
        relateEntity.set訂正区分コード(変更前Entity.getTeiseiKubunCode());
        return relateEntity;
    }

}
