/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動一時2と受給者異動送付一時エンティティクラスです。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoTblTmpEntity extends DbTableEntityBase<IdoTblTmpEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo 被保険者番号;
    @PrimaryKey
    private FlexibleDate 異動年月日;
    @PrimaryKey
    private int 履歴番号;
    private RString 異動区分コード;
    private RString 受給者異動事由;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 公費負担者番号;
    private ShoKisaiHokenshaNo 広域連合_政令市_保険者番号;
    private RString 申請種別コード;
    private RString 変更申請中区分コード;
    private FlexibleDate 申請年月日;
    private RString みなし要介護状態区分コード;
    private RString 要介護状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 居宅サービス計画作成区分コード;
    private RString 居宅介護支援事業所番号;
    private RString 居宅サービス計画適用開始年月日;
    private RString 居宅サービス計画適用終了年月日;
    private int 訪問通所サービス支給限度基準額;
    private FlexibleDate 訪問通所サービス上限管理適用期間開始年月日;
    private RString 訪問通所サービス上限管理適用期間終了年月日;
    private int 短期入所サービス支給限度基準額;
    private FlexibleDate 短期入所サービス上限管理適用期間開始年月日;
    private FlexibleDate 短期入所サービス上限管理適用期間終了年月日;
    private boolean 公費負担上限額減額有フラグ;
    private RString 償還払化開始年月日;
    private RString 償還払化終了年月日;
    private RString 給付率引下げ開始年月日;
    private RString 給付率引下げ終了年月日;
    private RString 減免申請中区分コード;
    private RString 利用者負担区分コード;
    private Decimal 給付率;
    private RString 適用開始年月日;
    private RString 適用終了年月日;
    private RString 標準負担区分コード;
    private Decimal 負担額;
    private RString 負担額適用開始年月日;
    private RString 負担額適用終了年月日;
    private RString 特定入所者認定申請中区分コード;
    private RString 特定入所者介護サービス区分コード;
    private RString 課税層の特例減額措置対象フラグ;
    private RString 食費負担限度額;
    private RString 居住費ユニット型個室負担限度額;
    private RString 居住費ユニット型準個室負担限度額;
    private RString 居住費従来型個室特養等負担限度額;
    private RString 居住費従来型個室老健療養等負担限度額;
    private RString 居住費多床室負担限度額;
    private RString 負担限度額適用開始年月日;
    private RString 負担限度額適用終了年月日;
    private RString 軽減率;
    private RString 軽減率適用開始年月日;
    private RString 軽減率適用終了年月日;
    private boolean 小多機能居宅介護利用開始月利用有フラグ;
    private RString 後期高齢者医療保険者番号;
    private RString 後期高齢者医療被保険者番号;
    private RString 国民健康保険保険者番号;
    private RString 国民健康保険被保険者証番号;
    private RString 国民健康保険個人番号;
    private RString 二次予防事業区分コード;
    private FlexibleDate 二次予防事業有効期間開始年月日;
    private FlexibleDate 二次予防事業有効期間終了年月日;
    private boolean 訂正連絡票フラグ;
    private FlexibleYearMonth 送付年月;
    private RString 住所地特例対象者区分コード;
    private RString 施設所在保険者番号;
    private RString 住所地特例適用開始日;
    private RString 住所地特例適用終了日;
    private RString 居宅費_新１_負担限度額;
    private RString 居宅費_新２_負担限度額;
    private RString 居宅費_新３_負担限度額;
    private RString 利用者負担割合有効開始日;
    private RString 利用者負担割合有効終了日;
    private RString 訂正区分コード;
    private FlexibleDate 訂正年月日;
    private RString 市町村コード;
    private boolean 論理削除フラグ;
    private RString エラーフラグ;

    /**
     * エンティティはコピーです。
     *
     * @return IdoTblTmpEntity
     */
    public IdoTblTmpEntity copyEntity() {
        IdoTblTmpEntity entity = new IdoTblTmpEntity();
        entity.set被保険者番号(被保険者番号);
        entity.set異動年月日(異動年月日);
        entity.set履歴番号(履歴番号);
        entity.set異動区分コード(異動区分コード);
        entity.set受給者異動事由(受給者異動事由);
        entity.set証記載保険者番号(証記載保険者番号);
        entity.set被保険者氏名カナ(被保険者氏名カナ);
        entity.set生年月日(生年月日);
        entity.set性別コード(性別コード);
        entity.set資格取得年月日(資格取得年月日);
        entity.set資格喪失年月日(資格喪失年月日);
        entity.set老人保健市町村番号(老人保健市町村番号);
        entity.set老人保健受給者番号(老人保健受給者番号);
        entity.set公費負担者番号(公費負担者番号);
        entity.set広域連合_政令市_保険者番号(広域連合_政令市_保険者番号);
        entity.set申請種別コード(申請種別コード);
        entity.set変更申請中区分コード(変更申請中区分コード);
        entity.set申請年月日(申請年月日);
        entity.setみなし要介護状態区分コード(みなし要介護状態区分コード);
        entity.set要介護状態区分コード(要介護状態区分コード);
        entity.set認定有効期間開始年月日(認定有効期間開始年月日);
        entity.set認定有効期間終了年月日(認定有効期間終了年月日);
        entity.set居宅サービス計画作成区分コード(居宅サービス計画作成区分コード);
        entity.set居宅介護支援事業所番号(居宅介護支援事業所番号);
        entity.set居宅サービス計画適用開始年月日(居宅サービス計画適用開始年月日);
        entity.set居宅サービス計画適用終了年月日(居宅サービス計画適用終了年月日);
        entity.set訪問通所サービス支給限度基準額(訪問通所サービス支給限度基準額);
        entity.set訪問通所サービス上限管理適用期間開始年月日(訪問通所サービス上限管理適用期間開始年月日);
        entity.set訪問通所サービス上限管理適用期間終了年月日(訪問通所サービス上限管理適用期間終了年月日);
        entity.set短期入所サービス支給限度基準額(短期入所サービス支給限度基準額);
        entity.set短期入所サービス上限管理適用期間開始年月日(短期入所サービス上限管理適用期間開始年月日);
        entity.set短期入所サービス上限管理適用期間終了年月日(短期入所サービス上限管理適用期間終了年月日);
        entity.set公費負担上限額減額有フラグ(公費負担上限額減額有フラグ);
        entity.set償還払化開始年月日(償還払化開始年月日);
        entity.set償還払化終了年月日(償還払化終了年月日);
        entity.set給付率引下げ開始年月日(給付率引下げ開始年月日);
        entity.set給付率引下げ終了年月日(給付率引下げ終了年月日);
        entity.set減免申請中区分コード(減免申請中区分コード);
        entity.set利用者負担区分コード(利用者負担区分コード);
        entity.set給付率(給付率);
        entity.set適用開始年月日(適用開始年月日);
        entity.set適用終了年月日(適用終了年月日);
        entity.set標準負担区分コード(標準負担区分コード);
        entity.set負担額(負担額);
        entity.set負担額適用開始年月日(負担額適用開始年月日);
        entity.set負担額適用終了年月日(負担額適用終了年月日);
        entity.set特定入所者認定申請中区分コード(特定入所者認定申請中区分コード);
        entity.set特定入所者介護サービス区分コード(特定入所者介護サービス区分コード);
        entity.set課税層の特例減額措置対象フラグ(課税層の特例減額措置対象フラグ);
        entity.set食費負担限度額(食費負担限度額);
        entity.set居住費ユニット型個室負担限度額(居住費ユニット型個室負担限度額);
        entity.set居住費ユニット型準個室負担限度額(居住費ユニット型準個室負担限度額);
        entity.set居住費従来型個室特養等負担限度額(居住費従来型個室特養等負担限度額);
        entity.set居住費従来型個室老健療養等負担限度額(居住費従来型個室老健療養等負担限度額);
        entity.set居住費多床室負担限度額(居住費多床室負担限度額);
        entity.set負担限度額適用開始年月日(負担限度額適用開始年月日);
        entity.set負担限度額適用終了年月日(負担限度額適用終了年月日);
        entity.set軽減率(軽減率);
        entity.set軽減率適用開始年月日(軽減率適用開始年月日);
        entity.set軽減率適用終了年月日(軽減率適用終了年月日);
        entity.set小多機能居宅介護利用開始月利用有フラグ(小多機能居宅介護利用開始月利用有フラグ);
        entity.set後期高齢者医療保険者番号(後期高齢者医療保険者番号);
        entity.set後期高齢者医療被保険者番号(後期高齢者医療被保険者番号);
        entity.set国民健康保険保険者番号(国民健康保険保険者番号);
        entity.set国民健康保険被保険者証番号(国民健康保険被保険者証番号);
        entity.set国民健康保険個人番号(国民健康保険個人番号);
        entity.set二次予防事業区分コード(二次予防事業区分コード);
        entity.set二次予防事業有効期間開始年月日(二次予防事業有効期間開始年月日);
        entity.set二次予防事業有効期間終了年月日(二次予防事業有効期間終了年月日);
        entity.set訂正連絡票フラグ(訂正連絡票フラグ);
        entity.set送付年月(送付年月);
        entity.set住所地特例対象者区分コード(住所地特例対象者区分コード);
        entity.set施設所在保険者番号(施設所在保険者番号);
        entity.set住所地特例適用開始日(住所地特例適用開始日);
        entity.set住所地特例適用終了日(住所地特例適用終了日);
        entity.set居宅費_新１_負担限度額(居宅費_新１_負担限度額);
        entity.set居宅費_新２_負担限度額(居宅費_新２_負担限度額);
        entity.set居宅費_新３_負担限度額(居宅費_新３_負担限度額);
        entity.set利用者負担割合有効開始日(利用者負担割合有効開始日);
        entity.set利用者負担割合有効終了日(利用者負担割合有効終了日);
        entity.set訂正区分コード(訂正区分コード);
        entity.set訂正年月日(訂正年月日);
        entity.set市町村コード(市町村コード);
        entity.set論理削除フラグ(論理削除フラグ);
        entity.setエラーフラグ(エラーフラグ);
        return entity;
    }

    /**
     * エンティティはコピーです。
     *
     * @return IdoTblTmpEntity
     */
    public DbT3001JukyushaIdoRenrakuhyoEntity copyTo3001Entity() {
        DbT3001JukyushaIdoRenrakuhyoEntity entity = new DbT3001JukyushaIdoRenrakuhyoEntity();
        entity.setHiHokenshaNo(被保険者番号);
        entity.setIdoYMD(異動年月日);
        entity.setRirekiNo(履歴番号);
        entity.setIdoKubunCode(異動区分コード);
        entity.setJukyushaIdoJiyu(受給者異動事由);
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHiHokenshaNameKana(被保険者氏名カナ);
        entity.setUmareYMD(生年月日);
        entity.setSeibetsuCode(性別コード);
        entity.setShikakuShutokuYMD(資格取得年月日);
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        entity.setRojinHokenShichosonNo(老人保健市町村番号);
        entity.setRojinHokenJukyushaNo(老人保健受給者番号);
        entity.setKohiFutanshaNo(公費負担者番号);
        entity.setKoikiRengoHokenshaNo(広域連合_政令市_保険者番号);
        entity.setShinseiShubetsuCode(申請種別コード);
        entity.setHenkoShinseichuKubunCode(変更申請中区分コード);
        entity.setShinseiYMD(申請年月日);
        entity.setMinashiYokaigoJotaiKubunCode(みなし要介護状態区分コード);
        entity.setYokaigoJotaiKubunCode(要介護状態区分コード);
        entity.setNinteiYukoKikankaishiYMD(認定有効期間開始年月日);
        entity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
        entity.setKyotakuServiceSakuseiKubunCode(居宅サービス計画作成区分コード);
        entity.setKyotakuKaigoShienJigyoshoNo(居宅介護支援事業所番号);
        entity.setKyotakuServiceTekiyoKaishiYMD(居宅サービス計画適用開始年月日);
        entity.setKyotakuServiceTekiyoShuryoYMD(居宅サービス計画適用終了年月日);
        entity.setHomonTsushoServiceShikyuGendoKijungaku(訪問通所サービス支給限度基準額);
        entity.setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(訪問通所サービス上限管理適用期間開始年月日);
        entity.setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(訪問通所サービス上限管理適用期間終了年月日);
        entity.setTankiNyushoServiceShikyuGendoKijungaku(短期入所サービス支給限度基準額);
        entity.setTankinyushoServiceJogenKanriTekiyoKaishiYMD(短期入所サービス上限管理適用期間開始年月日);
        entity.setTankinyushoServiceJogenKanriTekiyoShuryoYMD(短期入所サービス上限管理適用期間終了年月日);
        entity.setKohiFutanJogenGengakuAriFlag(公費負担上限額減額有フラグ);
        entity.setShokanbaraikaKaishiYMD(償還払化開始年月日);
        entity.setShokanbaraikaShuryoYMD(償還払化終了年月日);
        entity.setKyufuritsuHikisageKaishiYMD(給付率引下げ開始年月日);
        entity.setKyufuritsuHikisageShuryoYMD(給付率引下げ終了年月日);
        entity.setGemmenShinseichuKubunCode(減免申請中区分コード);
        entity.setRiyoshaFutanKubunCode(利用者負担区分コード);
        entity.setKyufuritsu(給付率);
        entity.setTekiyoKaishiYMD(適用開始年月日);
        entity.setTekiyoShuryoYMD(適用終了年月日);
        entity.setHyojunFutanKubunCode(標準負担区分コード);
        entity.setFutangaku(負担額);
        entity.setFutangakuTekiyoKaishiYMD(負担額適用開始年月日);
        entity.setFutangakuTekiyoShuryoYMD(負担額適用終了年月日);
        entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(特定入所者認定申請中区分コード);
        entity.setTokuteiNyushoshaKaigoServiceKubunCode(特定入所者介護サービス区分コード);
        entity.setKaizeisoTokureiGengakuSochiTaishoFlag(課税層の特例減額措置対象フラグ);
        entity.setShokuhiFutanGendogaku(食費負担限度額);
        entity.setKyojuhiUnitGataKoshitsuFutanGendogaku(居住費ユニット型個室負担限度額);
        entity.setKyojuhiUnitGataJunKoshitsuFutanGendogaku(居住費ユニット型準個室負担限度額);
        entity.setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(居住費従来型個室特養等負担限度額);
        entity.setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(居住費従来型個室老健療養等負担限度額);
        entity.setKyujuhiTashoshitsuFutanGendogaku(居住費多床室負担限度額);
        entity.setFutanGendogakuTekiyoKaishiYMD(負担限度額適用開始年月日);
        entity.setFutanGendogakuTekiyoShuryoYMD(負担限度額適用終了年月日);
        entity.setKeigenritsu(軽減率);
        entity.setKeigenritsuTekiyoKaishiYMD(軽減率適用開始年月日);
        entity.setKeigenritsuTekiyoShuryoYMD(軽減率適用終了年月日);
        entity.setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(小多機能居宅介護利用開始月利用有フラグ);
        entity.setKokiKoureiIryoHokenshaNo(後期高齢者医療保険者番号);
        entity.setKokikoureiIryoHiHokenshaNo(後期高齢者医療被保険者番号);
        entity.setKokuhoHokenshaNo(国民健康保険保険者番号);
        entity.setKokuhoHiHokenshaNo(国民健康保険被保険者証番号);
        entity.setKokuhoKojinNo(国民健康保険個人番号);
        entity.setNijiyoboJigyoKubunCode(二次予防事業区分コード);
        entity.setNijiyoboJigyoYukoKikanKaishiYMD(二次予防事業有効期間開始年月日);
        entity.setNijiyoboJigyoYukoKikanShuryoYMD(二次予防事業有効期間終了年月日);
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
        entity.setSofuYM(送付年月);
        entity.setJushochiTokureiTaishoshaKubunCode(住所地特例対象者区分コード);
        entity.setShisetsuShozaiHokenjaNo(施設所在保険者番号);
        entity.setJushochiTokureiTekiyoKaishiYMD(住所地特例適用開始日);
        entity.setJushochiTokureiTekiyoShuryoYMD(住所地特例適用終了日);
        entity.setKyotakuhiShin1FutanGendogaku(居宅費_新１_負担限度額);
        entity.setKyotakuhiShin2FutanGendogaku(居宅費_新２_負担限度額);
        entity.setKyotakuhiShin3FutanGendogaku(居宅費_新３_負担限度額);
        entity.setRiyosyaFutanWariaiYukoKaishiYMD(利用者負担割合有効開始日);
        entity.setRiyosyaFutanWariaiYukoShuryoYMD(利用者負担割合有効終了日);
        entity.setTeiseiKubunCode(訂正区分コード);
        entity.setTeiseiYMD(訂正年月日);
        entity.setLogicalDeletedFlag(論理削除フラグ);
        return entity;
    }
}
