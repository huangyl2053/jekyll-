/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受給者異動送付のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class JukyushaIdoRenrakuhyoModel implements Serializable {

    private DbT3001JukyushaIdoRenrakuhyoEntity entity;

    /**
     * コンストラクタです。
     */
    public JukyushaIdoRenrakuhyoModel() {
        entity = new DbT3001JukyushaIdoRenrakuhyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3001JukyushaIdoRenrakuhyoEntity
     */
    public JukyushaIdoRenrakuhyoModel(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3001JukyushaIdoRenrakuhyoEntityを返します。
     *
     * @return DbT3001JukyushaIdoRenrakuhyoEntity
     */
    public DbT3001JukyushaIdoRenrakuhyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3001JukyushaIdoRenrakuhyoEntityを設定します。
     *
     * @param entity DbT3001JukyushaIdoRenrakuhyoEntity
     */
    public void setEntity(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 異動区分コードを返します。
     *
     * @return 異動区分コード
     */
    public RString get異動区分コード() {
        return entity.getIdoKubunCode();
    }

    /**
     * 受給者異動事由を返します。
     *
     * @return 受給者異動事由
     */
    public RString get受給者異動事由() {
        return entity.getJukyushaIdoJiyu();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public RString get被保険者氏名カナ() {
        return entity.getHiHokenshaNameKana();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getUmareYMD();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.getSeibetsuCode();
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return entity.getRojinHokenShichosonNo();
    }

    /**
     * 老人保健受給者番号を返します。
     *
     * @return 老人保健受給者番号
     */
    public RString get老人保健受給者番号() {
        return entity.getRojinHokenJukyushaNo();
    }

    /**
     * 公費負担者番号を返します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.getKohiFutanshaNo();
    }

    /**
     * 広域連合_政令市保険者番号を返します。
     *
     * @return 広域連合_政令市保険者番号
     */
    public HokenshaNo get広域連合_政令市保険者番号() {
        return entity.getKoikiRengoHokenshaNo();
    }

    /**
     * 申請種別コードを返します。
     *
     * @return 申請種別コード
     */
    public RString get申請種別コード() {
        return entity.getShinseiShubetsuCode();
    }

    /**
     * 変更申請中区分コードを返します。
     *
     * @return 変更申請中区分コード
     */
    public RString get変更申請中区分コード() {
        return entity.getHenkoShinseichuKubunCode();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * みなし要介護状態区分コードを返します。
     *
     * @return みなし要介護状態区分コード
     */
    public RString getみなし要介護状態区分コード() {
        return entity.getMinashiYokaigoJotaiKubunCode();
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.getNinteiYukoKikankaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.getKyotakuServiceSakuseiKubunCode();
    }

    /**
     * 居宅介護支援事業所番号を返します。
     *
     * @return 居宅介護支援事業所番号
     */
    public JigyoshaNo get居宅介護支援事業所番号() {
        return entity.getKyotakuKaigoShienJigyoshoNo();
    }

    /**
     * 居宅サービス計画適用開始年月日を返します。
     *
     * @return 居宅サービス計画適用開始年月日
     */
    public FlexibleDate get居宅サービス計画適用開始年月日() {
        return entity.getKyotakuServiceTekiyoKaishiYMD();
    }

    /**
     * 居宅サービス計画適用終了年月日を返します。
     *
     * @return 居宅サービス計画適用終了年月日
     */
    public FlexibleDate get居宅サービス計画適用終了年月日() {
        return entity.getKyotakuServiceTekiyoShuryoYMD();
    }

    /**
     * 訪問通所サービス支給限度基準額を返します。
     *
     * @return 訪問通所サービス支給限度基準額
     */
    public int get訪問通所サービス支給限度基準額() {
        return entity.getHomonTsushoServiceShikyuGendoKijungaku();
    }

    /**
     * 訪問通所サービス上限管理適用期間開始年月日を返します。
     *
     * @return 訪問通所サービス上限管理適用期間開始年月日
     */
    public FlexibleDate get訪問通所サービス上限管理適用期間開始年月日() {
        return entity.getHomonTsushoServiceJogenKanriTekiyoKaishiYMD();
    }

    /**
     * 訪問通所サービス上限管理適用期間終了年月日を返します。
     *
     * @return 訪問通所サービス上限管理適用期間終了年月日
     */
    public FlexibleDate get訪問通所サービス上限管理適用期間終了年月日() {
        return entity.getHomonTsushoServiceJogenKanriTekiyoShuryoYMD();
    }

    /**
     * 短期入所サービス支給限度基準額を返します。
     *
     * @return 短期入所サービス支給限度基準額
     */
    public int get短期入所サービス支給限度基準額() {
        return entity.getTankiNyushoServiceShikyuGendoKijungaku();
    }

    /**
     * 短期入所サービス上限管理適用期間開始年月日を返します。
     *
     * @return 短期入所サービス上限管理適用期間開始年月日
     */
    public FlexibleDate get短期入所サービス上限管理適用期間開始年月日() {
        return entity.getTankinyushoServiceJogenKanriTekiyoKaishiYMD();
    }

    /**
     * 短期入所サービス上限管理適用期間終了年月日を返します。
     *
     * @return 短期入所サービス上限管理適用期間終了年月日
     */
    public FlexibleDate get短期入所サービス上限管理適用期間終了年月日() {
        return entity.getTankinyushoServiceJogenKanriTekiyoShuryoYMD();
    }

    /**
     * 公費負担上限額減額有フラグを返します。
     *
     * @return 公費負担上限額減額有フラグ
     */
    public boolean get公費負担上限額減額有フラグ() {
        return entity.getKohiFutanJogenGengakuAriFlag();
    }

    /**
     * 償還払化開始年月日を返します。
     *
     * @return 償還払化開始年月日
     */
    public FlexibleDate get償還払化開始年月日() {
        return entity.getShokanbaraikaKaishiYMD();
    }

    /**
     * 償還払化終了年月日を返します。
     *
     * @return 償還払化終了年月日
     */
    public FlexibleDate get償還払化終了年月日() {
        return entity.getShokanbaraikaShuryoYMD();
    }

    /**
     * 給付率引下げ開始年月日を返します。
     *
     * @return 給付率引下げ開始年月日
     */
    public FlexibleDate get給付率引下げ開始年月日() {
        return entity.getKyufuritsuHikisageKaishiYMD();
    }

    /**
     * 給付率引下げ終了年月日を返します。
     *
     * @return 給付率引下げ終了年月日
     */
    public FlexibleDate get給付率引下げ終了年月日() {
        return entity.getKyufuritsuHikisageShuryoYMD();
    }

    /**
     * 減免申請中区分コードを返します。
     *
     * @return 減免申請中区分コード
     */
    public RString get減免申請中区分コード() {
        return entity.getGemmenShinseichuKubunCode();
    }

    /**
     * 利用者負担区分コードを返します。
     *
     * @return 利用者負担区分コード
     */
    public RString get利用者負担区分コード() {
        return entity.getRiyoshaFutanKubunCode();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuritsu();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 標準負担区分コードを返します。
     *
     * @return 標準負担区分コード
     */
    public RString get標準負担区分コード() {
        return entity.getHyojunFutanKubunCode();
    }

    /**
     * 負担額を返します。
     *
     * @return 負担額
     */
    public int get負担額() {
        return entity.getFutangaku();
    }

    /**
     * 負担額適用開始年月日を返します。
     *
     * @return 負担額適用開始年月日
     */
    public FlexibleDate get負担額適用開始年月日() {
        return entity.getFutangakuTekiyoKaishiYMD();
    }

    /**
     * 負担額適用終了年月日を返します。
     *
     * @return 負担額適用終了年月日
     */
    public FlexibleDate get負担額適用終了年月日() {
        return entity.getFutangakuTekiyoShuryoYMD();
    }

    /**
     * 特定入所者認定申請中区分コードを返します。
     *
     * @return 特定入所者認定申請中区分コード
     */
    public RString get特定入所者認定申請中区分コード() {
        return entity.getTokuteiNyushoshaNinteiShinseichuKubunCode();
    }

    /**
     * 特定入所者介護サービス区分コードを返します。
     *
     * @return 特定入所者介護サービス区分コード
     */
    public RString get特定入所者介護サービス区分コード() {
        return entity.getTokuteiNyushoshaKaigoServiceKubunCode();
    }

    /**
     * 課税層の特例減額措置対象フラグを返します。
     *
     * @return 課税層の特例減額措置対象フラグ
     */
    public boolean get課税層の特例減額措置対象フラグ() {
        return entity.getKaizeisoTokureiGengakuSochiTaishoFlag();
    }

    /**
     * 食費負担限度額を返します。
     *
     * @return 食費負担限度額
     */
    public int get食費負担限度額() {
        return entity.getShokuhiFutanGendogaku();
    }

    /**
     * 居住費ユニット型個室負担限度額を返します。
     *
     * @return 居住費ユニット型個室負担限度額
     */
    public int get居住費ユニット型個室負担限度額() {
        return entity.getKyojuhiUnitGataKoshitsuFutanGendogaku();
    }

    /**
     * 居住費ユニット型準個室負担限度額を返します。
     *
     * @return 居住費ユニット型準個室負担限度額
     */
    public int get居住費ユニット型準個室負担限度額() {
        return entity.getKyojuhiUnitGataJunKoshitsuFutanGendogaku();
    }

    /**
     * 居住費従来型個室特養等負担限度額を返します。
     *
     * @return 居住費従来型個室特養等負担限度額
     */
    public int get居住費従来型個室特養等負担限度額() {
        return entity.getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku();
    }

    /**
     * 居住費従来型個室老健療養等負担限度額を返します。
     *
     * @return 居住費従来型個室老健療養等負担限度額
     */
    public int get居住費従来型個室老健療養等負担限度額() {
        return entity.getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku();
    }

    /**
     * 居住費多床室負担限度額を返します。
     *
     * @return 居住費多床室負担限度額
     */
    public int get居住費多床室負担限度額() {
        return entity.getKyujuhiTashoshitsuFutanGendogaku();
    }

    /**
     * 負担限度額適用開始年月日を返します。
     *
     * @return 負担限度額適用開始年月日
     */
    public FlexibleDate get負担限度額適用開始年月日() {
        return entity.getFutanGendogakuTekiyoKaishiYMD();
    }

    /**
     * 負担限度額適用終了年月日を返します。
     *
     * @return 負担限度額適用終了年月日
     */
    public FlexibleDate get負担限度額適用終了年月日() {
        return entity.getFutanGendogakuTekiyoShuryoYMD();
    }

    /**
     * 軽減率を返します。
     *
     * @return 軽減率
     */
    public int get軽減率() {
        return entity.getKeigenritsu();
    }

    /**
     * 軽減率適用開始年月日を返します。
     *
     * @return 軽減率適用開始年月日
     */
    public FlexibleDate get軽減率適用開始年月日() {
        return entity.getKeigenritsuTekiyoKaishiYMD();
    }

    /**
     * 軽減率適用終了年月日を返します。
     *
     * @return 軽減率適用終了年月日
     */
    public FlexibleDate get軽減率適用終了年月日() {
        return entity.getKeigenritsuTekiyoShuryoYMD();
    }

    /**
     * 小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグを返します。
     *
     * @return 小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ
     */
    public boolean get小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ() {
        return entity.getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag();
    }

    /**
     * 後期高齢者医療保険者番号を返します。
     *
     * @return 後期高齢者医療保険者番号
     */
    public RString get後期高齢者医療保険者番号() {
        return entity.getKokiKoureiIryoHokenshaNo();
    }

    /**
     * 後期高齢者医療被保険者番号を返します。
     *
     * @return 後期高齢者医療被保険者番号
     */
    public RString get後期高齢者医療被保険者番号() {
        return entity.getKokikoureiIryoHiHokenshaNo();
    }

    /**
     * 国民健康保険保険者番号を返します。
     *
     * @return 国民健康保険保険者番号
     */
    public RString get国民健康保険保険者番号() {
        return entity.getKokuhoHokenshaNo();
    }

    /**
     * 国民健康保険被保険者証番号を返します。
     *
     * @return 国民健康保険被保険者証番号
     */
    public RString get国民健康保険被保険者証番号() {
        return entity.getKokuhoHiHokenshaNo();
    }

    /**
     * 国民健康保険個人番号を返します。
     *
     * @return 国民健康保険個人番号
     */
    public RString get国民健康保険個人番号() {
        return entity.getKokuhoKojinNo();
    }

    /**
     * 二次予防事業区分コードを返します。
     *
     * @return 二次予防事業区分コード
     */
    public RString get二次予防事業区分コード() {
        return entity.getNijiyoboJigyoKubunCode();
    }

    /**
     * 二次予防事業有効期間開始年月日を返します。
     *
     * @return 二次予防事業有効期間開始年月日
     */
    public FlexibleDate get二次予防事業有効期間開始年月日() {
        return entity.getNijiyoboJigyoYukoKikanKaishiYMD();
    }

    /**
     * 二次予防事業有効期間終了年月日を返します。
     *
     * @return 二次予防事業有効期間終了年月日
     */
    public FlexibleDate get二次予防事業有効期間終了年月日() {
        return entity.getNijiyoboJigyoYukoKikanShuryoYMD();
    }

    /**
     * 訂正連絡票フラグを返します。
     *
     * @return 訂正連絡票フラグ
     */
    public boolean get訂正連絡票フラグ() {
        return entity.getTeiseiRenrakuhyoFlag();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     */
    public void set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
    }

    /**
     * 異動区分コードを設定します。
     *
     * @param 異動区分コード 異動区分コード
     */
    public void set異動区分コード(RString 異動区分コード) {
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        entity.setIdoKubunCode(異動区分コード);
    }

    /**
     * 受給者異動事由を設定します。
     *
     * @param 受給者異動事由 受給者異動事由
     */
    public void set受給者異動事由(RString 受給者異動事由) {
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        entity.setJukyushaIdoJiyu(受給者異動事由);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 被保険者氏名カナを設定します。
     *
     * @param 被保険者氏名カナ 被保険者氏名カナ
     */
    public void set被保険者氏名カナ(RString 被保険者氏名カナ) {
        requireNonNull(被保険者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名カナ"));
        entity.setHiHokenshaNameKana(被保険者氏名カナ);
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     */
    public void set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setUmareYMD(生年月日);
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     */
    public void set性別コード(RString 性別コード) {
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));
        entity.setSeibetsuCode(性別コード);
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param 資格取得年月日 資格取得年月日
     */
    public void set資格取得年月日(FlexibleDate 資格取得年月日) {
        requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(資格取得年月日);
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     */
    public void set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     */
    public void set老人保健市町村番号(RString 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinHokenShichosonNo(老人保健市町村番号);
    }

    /**
     * 老人保健受給者番号を設定します。
     *
     * @param 老人保健受給者番号 老人保健受給者番号
     */
    public void set老人保健受給者番号(RString 老人保健受給者番号) {
        requireNonNull(老人保健受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号"));
        entity.setRojinHokenJukyushaNo(老人保健受給者番号);
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     */
    public void set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohiFutanshaNo(公費負担者番号);
    }

    /**
     * 広域連合_政令市保険者番号を設定します。
     *
     * @param 広域連合_政令市保険者番号 広域連合_政令市保険者番号
     */
    public void set広域連合_政令市保険者番号(HokenshaNo 広域連合_政令市保険者番号) {
        requireNonNull(広域連合_政令市保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域連合_政令市保険者番号"));
        entity.setKoikiRengoHokenshaNo(広域連合_政令市保険者番号);
    }

    /**
     * 申請種別コードを設定します。
     *
     * @param 申請種別コード 申請種別コード
     */
    public void set申請種別コード(RString 申請種別コード) {
        requireNonNull(申請種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請種別コード"));
        entity.setShinseiShubetsuCode(申請種別コード);
    }

    /**
     * 変更申請中区分コードを設定します。
     *
     * @param 変更申請中区分コード 変更申請中区分コード
     */
    public void set変更申請中区分コード(RString 変更申請中区分コード) {
        requireNonNull(変更申請中区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("変更申請中区分コード"));
        entity.setHenkoShinseichuKubunCode(変更申請中区分コード);
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
    }

    /**
     * みなし要介護状態区分コードを設定します。
     *
     * @param みなし要介護状態区分コード みなし要介護状態区分コード
     */
    public void setみなし要介護状態区分コード(RString みなし要介護状態区分コード) {
        requireNonNull(みなし要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("みなし要介護状態区分コード"));
        entity.setMinashiYokaigoJotaiKubunCode(みなし要介護状態区分コード);
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     */
    public void set要介護状態区分コード(RString 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYokaigoJotaiKubunCode(要介護状態区分コード);
    }

    /**
     * 認定有効期間開始年月日を設定します。
     *
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     */
    public void set認定有効期間開始年月日(FlexibleDate 認定有効期間開始年月日) {
        requireNonNull(認定有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間開始年月日"));
        entity.setNinteiYukoKikankaishiYMD(認定有効期間開始年月日);
    }

    /**
     * 認定有効期間終了年月日を設定します。
     *
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     */
    public void set認定有効期間終了年月日(FlexibleDate 認定有効期間終了年月日) {
        requireNonNull(認定有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間終了年月日"));
        entity.setNinteiYukoKikanShuryoYMD(認定有効期間終了年月日);
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     */
    public void set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        requireNonNull(居宅サービス計画作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成区分コード"));
        entity.setKyotakuServiceSakuseiKubunCode(居宅サービス計画作成区分コード);
    }

    /**
     * 居宅介護支援事業所番号を設定します。
     *
     * @param 居宅介護支援事業所番号 居宅介護支援事業所番号
     */
    public void set居宅介護支援事業所番号(JigyoshaNo 居宅介護支援事業所番号) {
        requireNonNull(居宅介護支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅介護支援事業所番号"));
        entity.setKyotakuKaigoShienJigyoshoNo(居宅介護支援事業所番号);
    }

    /**
     * 居宅サービス計画適用開始年月日を設定します。
     *
     * @param 居宅サービス計画適用開始年月日 居宅サービス計画適用開始年月日
     */
    public void set居宅サービス計画適用開始年月日(FlexibleDate 居宅サービス計画適用開始年月日) {
        requireNonNull(居宅サービス計画適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画適用開始年月日"));
        entity.setKyotakuServiceTekiyoKaishiYMD(居宅サービス計画適用開始年月日);
    }

    /**
     * 居宅サービス計画適用終了年月日を設定します。
     *
     * @param 居宅サービス計画適用終了年月日 居宅サービス計画適用終了年月日
     */
    public void set居宅サービス計画適用終了年月日(FlexibleDate 居宅サービス計画適用終了年月日) {
        requireNonNull(居宅サービス計画適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画適用終了年月日"));
        entity.setKyotakuServiceTekiyoShuryoYMD(居宅サービス計画適用終了年月日);
    }

    /**
     * 訪問通所サービス支給限度基準額を設定します。
     *
     * @param 訪問通所サービス支給限度基準額 訪問通所サービス支給限度基準額
     */
    public void set訪問通所サービス支給限度基準額(int 訪問通所サービス支給限度基準額) {
        requireNonNull(訪問通所サービス支給限度基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問通所サービス支給限度基準額"));
        entity.setHomonTsushoServiceShikyuGendoKijungaku(訪問通所サービス支給限度基準額);
    }

    /**
     * 訪問通所サービス上限管理適用期間開始年月日を設定します。
     *
     * @param 訪問通所サービス上限管理適用期間開始年月日 訪問通所サービス上限管理適用期間開始年月日
     */
    public void set訪問通所サービス上限管理適用期間開始年月日(FlexibleDate 訪問通所サービス上限管理適用期間開始年月日) {
        requireNonNull(訪問通所サービス上限管理適用期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問通所サービス上限管理適用期間開始年月日"));
        entity.setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(訪問通所サービス上限管理適用期間開始年月日);
    }

    /**
     * 訪問通所サービス上限管理適用期間終了年月日を設定します。
     *
     * @param 訪問通所サービス上限管理適用期間終了年月日 訪問通所サービス上限管理適用期間終了年月日
     */
    public void set訪問通所サービス上限管理適用期間終了年月日(FlexibleDate 訪問通所サービス上限管理適用期間終了年月日) {
        requireNonNull(訪問通所サービス上限管理適用期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問通所サービス上限管理適用期間終了年月日"));
        entity.setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(訪問通所サービス上限管理適用期間終了年月日);
    }

    /**
     * 短期入所サービス支給限度基準額を設定します。
     *
     * @param 短期入所サービス支給限度基準額 短期入所サービス支給限度基準額
     */
    public void set短期入所サービス支給限度基準額(int 短期入所サービス支給限度基準額) {
        requireNonNull(短期入所サービス支給限度基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所サービス支給限度基準額"));
        entity.setTankiNyushoServiceShikyuGendoKijungaku(短期入所サービス支給限度基準額);
    }

    /**
     * 短期入所サービス上限管理適用期間開始年月日を設定します。
     *
     * @param 短期入所サービス上限管理適用期間開始年月日 短期入所サービス上限管理適用期間開始年月日
     */
    public void set短期入所サービス上限管理適用期間開始年月日(FlexibleDate 短期入所サービス上限管理適用期間開始年月日) {
        requireNonNull(短期入所サービス上限管理適用期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所サービス上限管理適用期間開始年月日"));
        entity.setTankinyushoServiceJogenKanriTekiyoKaishiYMD(短期入所サービス上限管理適用期間開始年月日);
    }

    /**
     * 短期入所サービス上限管理適用期間終了年月日を設定します。
     *
     * @param 短期入所サービス上限管理適用期間終了年月日 短期入所サービス上限管理適用期間終了年月日
     */
    public void set短期入所サービス上限管理適用期間終了年月日(FlexibleDate 短期入所サービス上限管理適用期間終了年月日) {
        requireNonNull(短期入所サービス上限管理適用期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所サービス上限管理適用期間終了年月日"));
        entity.setTankinyushoServiceJogenKanriTekiyoShuryoYMD(短期入所サービス上限管理適用期間終了年月日);
    }

    /**
     * 公費負担上限額減額有フラグを設定します。
     *
     * @param 公費負担上限額減額有フラグ 公費負担上限額減額有フラグ
     */
    public void set公費負担上限額減額有フラグ(boolean 公費負担上限額減額有フラグ) {
        requireNonNull(公費負担上限額減額有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担上限額減額有フラグ"));
        entity.setKohiFutanJogenGengakuAriFlag(公費負担上限額減額有フラグ);
    }

    /**
     * 償還払化開始年月日を設定します。
     *
     * @param 償還払化開始年月日 償還払化開始年月日
     */
    public void set償還払化開始年月日(FlexibleDate 償還払化開始年月日) {
        requireNonNull(償還払化開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化開始年月日"));
        entity.setShokanbaraikaKaishiYMD(償還払化開始年月日);
    }

    /**
     * 償還払化終了年月日を設定します。
     *
     * @param 償還払化終了年月日 償還払化終了年月日
     */
    public void set償還払化終了年月日(FlexibleDate 償還払化終了年月日) {
        requireNonNull(償還払化終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払化終了年月日"));
        entity.setShokanbaraikaShuryoYMD(償還払化終了年月日);
    }

    /**
     * 給付率引下げ開始年月日を設定します。
     *
     * @param 給付率引下げ開始年月日 給付率引下げ開始年月日
     */
    public void set給付率引下げ開始年月日(FlexibleDate 給付率引下げ開始年月日) {
        requireNonNull(給付率引下げ開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率引下げ開始年月日"));
        entity.setKyufuritsuHikisageKaishiYMD(給付率引下げ開始年月日);
    }

    /**
     * 給付率引下げ終了年月日を設定します。
     *
     * @param 給付率引下げ終了年月日 給付率引下げ終了年月日
     */
    public void set給付率引下げ終了年月日(FlexibleDate 給付率引下げ終了年月日) {
        requireNonNull(給付率引下げ終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率引下げ終了年月日"));
        entity.setKyufuritsuHikisageShuryoYMD(給付率引下げ終了年月日);
    }

    /**
     * 減免申請中区分コードを設定します。
     *
     * @param 減免申請中区分コード 減免申請中区分コード
     */
    public void set減免申請中区分コード(RString 減免申請中区分コード) {
        requireNonNull(減免申請中区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("減免申請中区分コード"));
        entity.setGemmenShinseichuKubunCode(減免申請中区分コード);
    }

    /**
     * 利用者負担区分コードを設定します。
     *
     * @param 利用者負担区分コード 利用者負担区分コード
     */
    public void set利用者負担区分コード(RString 利用者負担区分コード) {
        requireNonNull(利用者負担区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担区分コード"));
        entity.setRiyoshaFutanKubunCode(利用者負担区分コード);
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     */
    public void set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuritsu(給付率);
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     */
    public void set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     */
    public void set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
    }

    /**
     * 標準負担区分コードを設定します。
     *
     * @param 標準負担区分コード 標準負担区分コード
     */
    public void set標準負担区分コード(RString 標準負担区分コード) {
        requireNonNull(標準負担区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担区分コード"));
        entity.setHyojunFutanKubunCode(標準負担区分コード);
    }

    /**
     * 負担額を設定します。
     *
     * @param 負担額 負担額
     */
    public void set負担額(int 負担額) {
        requireNonNull(負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額"));
        entity.setFutangaku(負担額);
    }

    /**
     * 負担額適用開始年月日を設定します。
     *
     * @param 負担額適用開始年月日 負担額適用開始年月日
     */
    public void set負担額適用開始年月日(FlexibleDate 負担額適用開始年月日) {
        requireNonNull(負担額適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額適用開始年月日"));
        entity.setFutangakuTekiyoKaishiYMD(負担額適用開始年月日);
    }

    /**
     * 負担額適用終了年月日を設定します。
     *
     * @param 負担額適用終了年月日 負担額適用終了年月日
     */
    public void set負担額適用終了年月日(FlexibleDate 負担額適用終了年月日) {
        requireNonNull(負担額適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額適用終了年月日"));
        entity.setFutangakuTekiyoShuryoYMD(負担額適用終了年月日);
    }

    /**
     * 特定入所者認定申請中区分コードを設定します。
     *
     * @param 特定入所者認定申請中区分コード 特定入所者認定申請中区分コード
     */
    public void set特定入所者認定申請中区分コード(RString 特定入所者認定申請中区分コード) {
        requireNonNull(特定入所者認定申請中区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者認定申請中区分コード"));
        entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(特定入所者認定申請中区分コード);
    }

    /**
     * 特定入所者介護サービス区分コードを設定します。
     *
     * @param 特定入所者介護サービス区分コード 特定入所者介護サービス区分コード
     */
    public void set特定入所者介護サービス区分コード(RString 特定入所者介護サービス区分コード) {
        requireNonNull(特定入所者介護サービス区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス区分コード"));
        entity.setTokuteiNyushoshaKaigoServiceKubunCode(特定入所者介護サービス区分コード);
    }

    /**
     * 課税層の特例減額措置対象フラグを設定します。
     *
     * @param 課税層の特例減額措置対象フラグ 課税層の特例減額措置対象フラグ
     */
    public void set課税層の特例減額措置対象フラグ(boolean 課税層の特例減額措置対象フラグ) {
        requireNonNull(課税層の特例減額措置対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("課税層の特例減額措置対象フラグ"));
        entity.setKaizeisoTokureiGengakuSochiTaishoFlag(課税層の特例減額措置対象フラグ);
    }

    /**
     * 食費負担限度額を設定します。
     *
     * @param 食費負担限度額 食費負担限度額
     */
    public void set食費負担限度額(int 食費負担限度額) {
        requireNonNull(食費負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("食費負担限度額"));
        entity.setShokuhiFutanGendogaku(食費負担限度額);
    }

    /**
     * 居住費ユニット型個室負担限度額を設定します。
     *
     * @param 居住費ユニット型個室負担限度額 居住費ユニット型個室負担限度額
     */
    public void set居住費ユニット型個室負担限度額(int 居住費ユニット型個室負担限度額) {
        requireNonNull(居住費ユニット型個室負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費ユニット型個室負担限度額"));
        entity.setKyojuhiUnitGataKoshitsuFutanGendogaku(居住費ユニット型個室負担限度額);
    }

    /**
     * 居住費ユニット型準個室負担限度額を設定します。
     *
     * @param 居住費ユニット型準個室負担限度額 居住費ユニット型準個室負担限度額
     */
    public void set居住費ユニット型準個室負担限度額(int 居住費ユニット型準個室負担限度額) {
        requireNonNull(居住費ユニット型準個室負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費ユニット型準個室負担限度額"));
        entity.setKyojuhiUnitGataJunKoshitsuFutanGendogaku(居住費ユニット型準個室負担限度額);
    }

    /**
     * 居住費従来型個室特養等負担限度額を設定します。
     *
     * @param 居住費従来型個室特養等負担限度額 居住費従来型個室特養等負担限度額
     */
    public void set居住費従来型個室特養等負担限度額(int 居住費従来型個室特養等負担限度額) {
        requireNonNull(居住費従来型個室特養等負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費従来型個室特養等負担限度額"));
        entity.setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(居住費従来型個室特養等負担限度額);
    }

    /**
     * 居住費従来型個室老健療養等負担限度額を設定します。
     *
     * @param 居住費従来型個室老健療養等負担限度額 居住費従来型個室老健療養等負担限度額
     */
    public void set居住費従来型個室老健療養等負担限度額(int 居住費従来型個室老健療養等負担限度額) {
        requireNonNull(居住費従来型個室老健療養等負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費従来型個室老健療養等負担限度額"));
        entity.setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(居住費従来型個室老健療養等負担限度額);
    }

    /**
     * 居住費多床室負担限度額を設定します。
     *
     * @param 居住費多床室負担限度額 居住費多床室負担限度額
     */
    public void set居住費多床室負担限度額(int 居住費多床室負担限度額) {
        requireNonNull(居住費多床室負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費多床室負担限度額"));
        entity.setKyujuhiTashoshitsuFutanGendogaku(居住費多床室負担限度額);
    }

    /**
     * 負担限度額適用開始年月日を設定します。
     *
     * @param 負担限度額適用開始年月日 負担限度額適用開始年月日
     */
    public void set負担限度額適用開始年月日(FlexibleDate 負担限度額適用開始年月日) {
        requireNonNull(負担限度額適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額適用開始年月日"));
        entity.setFutanGendogakuTekiyoKaishiYMD(負担限度額適用開始年月日);
    }

    /**
     * 負担限度額適用終了年月日を設定します。
     *
     * @param 負担限度額適用終了年月日 負担限度額適用終了年月日
     */
    public void set負担限度額適用終了年月日(FlexibleDate 負担限度額適用終了年月日) {
        requireNonNull(負担限度額適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額適用終了年月日"));
        entity.setFutanGendogakuTekiyoShuryoYMD(負担限度額適用終了年月日);
    }

    /**
     * 軽減率を設定します。
     *
     * @param 軽減率 軽減率
     */
    public void set軽減率(int 軽減率) {
        requireNonNull(軽減率, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率"));
        entity.setKeigenritsu(軽減率);
    }

    /**
     * 軽減率適用開始年月日を設定します。
     *
     * @param 軽減率適用開始年月日 軽減率適用開始年月日
     */
    public void set軽減率適用開始年月日(FlexibleDate 軽減率適用開始年月日) {
        requireNonNull(軽減率適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率適用開始年月日"));
        entity.setKeigenritsuTekiyoKaishiYMD(軽減率適用開始年月日);
    }

    /**
     * 軽減率適用終了年月日を設定します。
     *
     * @param 軽減率適用終了年月日 軽減率適用終了年月日
     */
    public void set軽減率適用終了年月日(FlexibleDate 軽減率適用終了年月日) {
        requireNonNull(軽減率適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率適用終了年月日"));
        entity.setKeigenritsuTekiyoShuryoYMD(軽減率適用終了年月日);
    }

    /**
     * 小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグを設定します。
     *
     * @param 小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ 小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ
     */
    public void set小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ(boolean 小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ) {
        requireNonNull(小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ"));
        entity.setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(小規模多機能型居宅介護利用開始月居宅サービス等利用有フラグ);
    }

    /**
     * 後期高齢者医療保険者番号を設定します。
     *
     * @param 後期高齢者医療保険者番号 後期高齢者医療保険者番号
     */
    public void set後期高齢者医療保険者番号(RString 後期高齢者医療保険者番号) {
        requireNonNull(後期高齢者医療保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者医療保険者番号"));
        entity.setKokiKoureiIryoHokenshaNo(後期高齢者医療保険者番号);
    }

    /**
     * 後期高齢者医療被保険者番号を設定します。
     *
     * @param 後期高齢者医療被保険者番号 後期高齢者医療被保険者番号
     */
    public void set後期高齢者医療被保険者番号(RString 後期高齢者医療被保険者番号) {
        requireNonNull(後期高齢者医療被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者医療被保険者番号"));
        entity.setKokikoureiIryoHiHokenshaNo(後期高齢者医療被保険者番号);
    }

    /**
     * 国民健康保険保険者番号を設定します。
     *
     * @param 国民健康保険保険者番号 国民健康保険保険者番号
     */
    public void set国民健康保険保険者番号(RString 国民健康保険保険者番号) {
        requireNonNull(国民健康保険保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国民健康保険保険者番号"));
        entity.setKokuhoHokenshaNo(国民健康保険保険者番号);
    }

    /**
     * 国民健康保険被保険者証番号を設定します。
     *
     * @param 国民健康保険被保険者証番号 国民健康保険被保険者証番号
     */
    public void set国民健康保険被保険者証番号(RString 国民健康保険被保険者証番号) {
        requireNonNull(国民健康保険被保険者証番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国民健康保険被保険者証番号"));
        entity.setKokuhoHiHokenshaNo(国民健康保険被保険者証番号);
    }

    /**
     * 国民健康保険個人番号を設定します。
     *
     * @param 国民健康保険個人番号 国民健康保険個人番号
     */
    public void set国民健康保険個人番号(RString 国民健康保険個人番号) {
        requireNonNull(国民健康保険個人番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国民健康保険個人番号"));
        entity.setKokuhoKojinNo(国民健康保険個人番号);
    }

    /**
     * 二次予防事業区分コードを設定します。
     *
     * @param 二次予防事業区分コード 二次予防事業区分コード
     */
    public void set二次予防事業区分コード(RString 二次予防事業区分コード) {
        requireNonNull(二次予防事業区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業区分コード"));
        entity.setNijiyoboJigyoKubunCode(二次予防事業区分コード);
    }

    /**
     * 二次予防事業有効期間開始年月日を設定します。
     *
     * @param 二次予防事業有効期間開始年月日 二次予防事業有効期間開始年月日
     */
    public void set二次予防事業有効期間開始年月日(FlexibleDate 二次予防事業有効期間開始年月日) {
        requireNonNull(二次予防事業有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業有効期間開始年月日"));
        entity.setNijiyoboJigyoYukoKikanKaishiYMD(二次予防事業有効期間開始年月日);
    }

    /**
     * 二次予防事業有効期間終了年月日を設定します。
     *
     * @param 二次予防事業有効期間終了年月日 二次予防事業有効期間終了年月日
     */
    public void set二次予防事業有効期間終了年月日(FlexibleDate 二次予防事業有効期間終了年月日) {
        requireNonNull(二次予防事業有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業有効期間終了年月日"));
        entity.setNijiyoboJigyoYukoKikanShuryoYMD(二次予防事業有効期間終了年月日);
    }

    /**
     * 訂正連絡票フラグを設定します。
     *
     * @param 訂正連絡票フラグ 訂正連絡票フラグ
     */
    public void set訂正連絡票フラグ(boolean 訂正連絡票フラグ) {
        requireNonNull(訂正連絡票フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正連絡票フラグ"));
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     */
    public void set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
