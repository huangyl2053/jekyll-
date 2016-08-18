/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受給者異動送付を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class JukyushaIdoRenrakuhyo
        extends ModelBase<JukyushaIdoRenrakuhyoIdentifier, DbT3001JukyushaIdoRenrakuhyoEntity, JukyushaIdoRenrakuhyo>
        implements Serializable {

    private final DbT3001JukyushaIdoRenrakuhyoEntity entity;
    private final JukyushaIdoRenrakuhyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受給者異動送付の新規作成時に使用します。
     *
     * @param 異動年月日 異動年月日
     * @param 異動区分コード 異動区分コード
     * @param 受給者異動事由 受給者異動事由
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public JukyushaIdoRenrakuhyo(FlexibleDate 異動年月日,
            RString 異動区分コード,
            RString 受給者異動事由,
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3001JukyushaIdoRenrakuhyoEntity();
        this.entity.setIdoYMD(異動年月日);
        this.entity.setIdoKubunCode(異動区分コード);
        this.entity.setJukyushaIdoJiyu(受給者異動事由);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new JukyushaIdoRenrakuhyoIdentifier(
                異動年月日,
                異動区分コード,
                受給者異動事由,
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3001JukyushaIdoRenrakuhyoEntity}より{@link JukyushaIdoRenrakuhyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3001JukyushaIdoRenrakuhyoEntity}
     */
    public JukyushaIdoRenrakuhyo(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動送付"));
        this.id = new JukyushaIdoRenrakuhyoIdentifier(
                entity.getIdoYMD(),
                entity.getIdoKubunCode(),
                entity.getJukyushaIdoJiyu(),
                entity.getShoKisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3001JukyushaIdoRenrakuhyoEntity}
     * @param id {@link JukyushaIdoRenrakuhyoIdentifier}
     */
    JukyushaIdoRenrakuhyo(
            DbT3001JukyushaIdoRenrakuhyoEntity entity,
            JukyushaIdoRenrakuhyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
    public ShoKisaiHokenshaNo get証記載保険者番号() {
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
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
     * 広域連合（政令市）保険者番号を返します。
     *
     * @return 広域連合（政令市）保険者番号
     */
    public ShoKisaiHokenshaNo get広域連合_政令市_保険者番号() {
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
    public RString get認定有効期間終了年月日() {
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
    public RString get居宅介護支援事業所番号() {
        return entity.getKyotakuKaigoShienJigyoshoNo();
    }

    /**
     * 居宅サービス計画適用開始年月日を返します。
     *
     * @return 居宅サービス計画適用開始年月日
     */
    public RString get居宅サービス計画適用開始年月日() {
        return entity.getKyotakuServiceTekiyoKaishiYMD();
    }

    /**
     * 居宅サービス計画適用終了年月日を返します。
     *
     * @return 居宅サービス計画適用終了年月日
     */
    public RString get居宅サービス計画適用終了年月日() {
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
    public RString get訪問通所サービス上限管理適用期間終了年月日() {
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
    public boolean is公費負担上限額減額有フラグ() {
        return entity.getKohiFutanJogenGengakuAriFlag();
    }

    /**
     * 償還払化開始年月日を返します。
     *
     * @return 償還払化開始年月日
     */
    public RString get償還払化開始年月日() {
        return entity.getShokanbaraikaKaishiYMD();
    }

    /**
     * 償還払化終了年月日を返します。
     *
     * @return 償還払化終了年月日
     */
    public RString get償還払化終了年月日() {
        return entity.getShokanbaraikaShuryoYMD();
    }

    /**
     * 給付率引下げ開始年月日を返します。
     *
     * @return 給付率引下げ開始年月日
     */
    public RString get給付率引下げ開始年月日() {
        return entity.getKyufuritsuHikisageKaishiYMD();
    }

    /**
     * 給付率引下げ終了年月日を返します。
     *
     * @return 給付率引下げ終了年月日
     */
    public RString get給付率引下げ終了年月日() {
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
    public Decimal get給付率() {
        return entity.getKyufuritsu();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public RString get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public RString get適用終了年月日() {
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
    public Decimal get負担額() {
        return entity.getFutangaku();
    }

    /**
     * 負担額適用開始年月日を返します。
     *
     * @return 負担額適用開始年月日
     */
    public RString get負担額適用開始年月日() {
        return entity.getFutangakuTekiyoKaishiYMD();
    }

    /**
     * 負担額適用終了年月日を返します。
     *
     * @return 負担額適用終了年月日
     */
    public RString get負担額適用終了年月日() {
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
    public RString is課税層の特例減額措置対象フラグ() {
        return entity.getKaizeisoTokureiGengakuSochiTaishoFlag();
    }

    /**
     * 食費負担限度額を返します。
     *
     * @return 食費負担限度額
     */
    public RString get食費負担限度額() {
        return entity.getShokuhiFutanGendogaku();
    }

    /**
     * 居住費ユニット型個室負担限度額を返します。
     *
     * @return 居住費ユニット型個室負担限度額
     */
    public RString get居住費ユニット型個室負担限度額() {
        return entity.getKyojuhiUnitGataKoshitsuFutanGendogaku();
    }

    /**
     * 居住費ユニット型準個室負担限度額を返します。
     *
     * @return 居住費ユニット型準個室負担限度額
     */
    public RString get居住費ユニット型準個室負担限度額() {
        return entity.getKyojuhiUnitGataJunKoshitsuFutanGendogaku();
    }

    /**
     * 居住費従来型個室特養等負担限度額を返します。
     *
     * @return 居住費従来型個室特養等負担限度額
     */
    public RString get居住費従来型個室特養等負担限度額() {
        return entity.getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku();
    }

    /**
     * 居住費従来型個室老健療養等負担限度額を返します。
     *
     * @return 居住費従来型個室老健療養等負担限度額
     */
    public RString get居住費従来型個室老健療養等負担限度額() {
        return entity.getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku();
    }

    /**
     * 居住費多床室負担限度額を返します。
     *
     * @return 居住費多床室負担限度額
     */
    public RString get居住費多床室負担限度額() {
        return entity.getKyujuhiTashoshitsuFutanGendogaku();
    }

    /**
     * 負担限度額適用開始年月日を返します。
     *
     * @return 負担限度額適用開始年月日
     */
    public RString get負担限度額適用開始年月日() {
        return entity.getFutanGendogakuTekiyoKaishiYMD();
    }

    /**
     * 負担限度額適用終了年月日を返します。
     *
     * @return 負担限度額適用終了年月日
     */
    public RString get負担限度額適用終了年月日() {
        return entity.getFutanGendogakuTekiyoShuryoYMD();
    }

    /**
     * 軽減率を返します。
     *
     * @return 軽減率
     */
    public RString get軽減率() {
        return entity.getKeigenritsu();
    }

    /**
     * 軽減率適用開始年月日を返します。
     *
     * @return 軽減率適用開始年月日
     */
    public RString get軽減率適用開始年月日() {
        return entity.getKeigenritsuTekiyoKaishiYMD();
    }

    /**
     * 軽減率適用終了年月日を返します。
     *
     * @return 軽減率適用終了年月日
     */
    public RString get軽減率適用終了年月日() {
        return entity.getKeigenritsuTekiyoShuryoYMD();
    }

    /**
     * 小多機能居宅介護利用開始月利用有フラグを返します。
     *
     * @return 小多機能居宅介護利用開始月利用有フラグ
     */
    public boolean is小多機能居宅介護利用開始月利用有フラグ() {
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
    public boolean is訂正連絡票フラグ() {
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
     * 住所地特例対象者区分コードを返します。
     *
     * @return 住所地特例対象者区分コード
     */
    public RString get住所地特例対象者区分コード() {
        return entity.getJushochiTokureiTaishoshaKubunCode();
    }

    /**
     * 施設所在保険者番号を返します。
     *
     * @return 施設所在保険者番号
     */
    public RString get施設所在保険者番号() {
        return entity.getShisetsuShozaiHokenjaNo();
    }

    /**
     * 住所地特例適用開始日を返します。
     *
     * @return 住所地特例適用開始日
     */
    public RString get住所地特例適用開始日() {
        return entity.getJushochiTokureiTekiyoKaishiYMD();
    }

    /**
     * 住所地特例適用終了日を返します。
     *
     * @return 住所地特例適用終了日
     */
    public RString get住所地特例適用終了日() {
        return entity.getJushochiTokureiTekiyoShuryoYMD();
    }

    /**
     * 居宅費（新１）負担限度額を返します。
     *
     * @return 居宅費（新１）負担限度額
     */
    public RString get居宅費_新１_負担限度額() {
        return entity.getKyotakuhiShin1FutanGendogaku();
    }

    /**
     * 居宅費（新２）負担限度額を返します。
     *
     * @return 居宅費（新２）負担限度額
     */
    public RString get居宅費_新２_負担限度額() {
        return entity.getKyotakuhiShin2FutanGendogaku();
    }

    /**
     * 居宅費（新３）負担限度額を返します。
     *
     * @return 居宅費（新３）負担限度額
     */
    public RString get居宅費_新３_負担限度額() {
        return entity.getKyotakuhiShin3FutanGendogaku();
    }

    /**
     * 利用者負担割合有効開始日を返します。
     *
     * @return 利用者負担割合有効開始日
     */
    public RString get利用者負担割合有効開始日() {
        return entity.getRiyosyaFutanWariaiYukoKaishiYMD();
    }

    /**
     * 利用者負担割合有効終了日を返します。
     *
     * @return 利用者負担割合有効終了日
     */
    public RString get利用者負担割合有効終了日() {
        return entity.getRiyosyaFutanWariaiYukoShuryoYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * 訂正年月日を返します。
     *
     * @return 訂正年月日
     */
    public FlexibleDate get訂正年月日() {
        return entity.getTeiseiYMD();
    }

    /**
     * 訂正区分コードを返します。
     *
     * @return 訂正区分コード
     */
    public RString get訂正区分コード() {
        return entity.getTeiseiKubunCode();
    }

    /**
     * {@link DbT3001JukyushaIdoRenrakuhyoEntity}のクローンを返します。
     *
     * @return {@link DbT3001JukyushaIdoRenrakuhyoEntity}のクローン
     */
    @Override
    public DbT3001JukyushaIdoRenrakuhyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受給者異動送付の識別子{@link JukyushaIdoRenrakuhyoIdentifier}を返します。
     *
     * @return 受給者異動送付の識別子{@link JukyushaIdoRenrakuhyoIdentifier}
     */
    @Override
    public JukyushaIdoRenrakuhyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する受給者異動送付を削除対象とします。<br/>
     * {@link DbT3001JukyushaIdoRenrakuhyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JukyushaIdoRenrakuhyo}
     */
    @Override
    public JukyushaIdoRenrakuhyo deleted() {
        DbT3001JukyushaIdoRenrakuhyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JukyushaIdoRenrakuhyo(deletedEntity, id);
    }

    /**
     * add KogakuShikyuHanteiKekka
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public JukyushaIdoRenrakuhyo added() {
        DbT3001JukyushaIdoRenrakuhyoEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        //TODO メッセージの検討
        return new JukyushaIdoRenrakuhyo(addedEntity, id);
    }

    /**
     * {@link JukyushaIdoRenrakuhyo}のシリアライズ形式を提供します。
     *
     * @return {@link JukyushaIdoRenrakuhyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3001JukyushaIdoRenrakuhyoEntity entity;
        private final JukyushaIdoRenrakuhyoIdentifier id;

        private _SerializationProxy(DbT3001JukyushaIdoRenrakuhyoEntity entity, JukyushaIdoRenrakuhyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JukyushaIdoRenrakuhyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JukyushaIdoRenrakuhyoBuilder createBuilderForEdit() {
        return new JukyushaIdoRenrakuhyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
