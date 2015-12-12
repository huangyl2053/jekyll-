/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 給付実績基本を管理するクラスです。
 */
public class KyufujissekiKihon 
extends ModelBase<KyufujissekiKihonIdentifier, 
        DbT3017KyufujissekiKihonEntity, 
        KyufujissekiKihon> implements Serializable {

    private final DbT3017KyufujissekiKihonEntity entity;
    private final KyufujissekiKihonIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績基本の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 給付実績区分コード 給付実績区分コード
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     */
    public KyufujissekiKihon(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            RString 給付実績情報作成区分コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 給付実績区分コード,
            JigyoshaNo 事業所番号,
            RString 通し番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        this.entity = new DbT3017KyufujissekiKihonEntity();
        this.entity.setKokanShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        this.entity.setHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setKyufuJissekiKubunCode(給付実績区分コード);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.id = new KyufujissekiKihonIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                給付実績情報作成区分コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                給付実績区分コード,
                事業所番号,
                通し番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3017KyufujissekiKihonEntity}より{@link KyufujissekiKihon}を生成します。
     *
     * @param entity DBより取得した{@link DbT3017KyufujissekiKihonEntity}
     */
    public KyufujissekiKihon(DbT3017KyufujissekiKihonEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績基本"));
        this.id = new KyufujissekiKihonIdentifier(
                entity.getKokanShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getKyufuSakuseiKubunCode(),
                entity.getHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getKyufuJissekiKubunCode(),
                entity.getJigyoshoNo(),
                entity.getToshiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3017KyufujissekiKihonEntity}
     * @param id {@link KyufujissekiKihonIdentifier}
     */
    KyufujissekiKihon(
            DbT3017KyufujissekiKihonEntity entity,
            KyufujissekiKihonIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
    }

    /**
     * 給付実績情報作成区分コードを返します。
     *
     * @return 給付実績情報作成区分コード
     */
    public RString get給付実績情報作成区分コード() {
        return entity.getKyufuSakuseiKubunCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getHokenshaNo();
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 給付実績区分コードを返します。
     *
     * @return 給付実績区分コード
     */
    public RString get給付実績区分コード() {
        return entity.getKyufuJissekiKubunCode();
    }

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
    }

    /**
     * 公費１_負担者番号を返します。
     *
     * @return 公費１_負担者番号
     */
    public RString get公費１_負担者番号() {
        return entity.getKohi1FutanshaNo();
    }

    /**
     * 公費１_受給者番号を返します。
     *
     * @return 公費１_受給者番号
     */
    public RString get公費１_受給者番号() {
        return entity.getKohi1JukyushaNo();
    }

    /**
     * 公費２_負担者番号を返します。
     *
     * @return 公費２_負担者番号
     */
    public RString get公費２_負担者番号() {
        return entity.getKohi2FutanshaNo();
    }

    /**
     * 公費２_受給者番号を返します。
     *
     * @return 公費２_受給者番号
     */
    public RString get公費２_受給者番号() {
        return entity.getKohi2JukyushaNo();
    }

    /**
     * 公費３_負担者番号を返します。
     *
     * @return 公費３_負担者番号
     */
    public RString get公費３_負担者番号() {
        return entity.getKohi3FutanshaNo();
    }

    /**
     * 公費３_受給者番号を返します。
     *
     * @return 公費３_受給者番号
     */
    public RString get公費３_受給者番号() {
        return entity.getKohi3JukyushaNo();
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
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return entity.getYoKaigoJotaiKubunCode();
    }

    /**
     * 旧措置入所者特例コードを返します。
     *
     * @return 旧措置入所者特例コード
     */
    public RString get旧措置入所者特例コード() {
        return entity.getKyuSochiNyushoshaTokureiCode();
    }

    /**
     * 認定有効期間_開始年月日を返します。
     *
     * @return 認定有効期間_開始年月日
     */
    public FlexibleDate get認定有効期間_開始年月日() {
        return entity.getNinteiYukoKaishiYMD();
    }

    /**
     * 認定有功期間_終了年月日を返します。
     *
     * @return 認定有功期間_終了年月日
     */
    public FlexibleDate get認定有功期間_終了年月日() {
        return entity.getNinteiYukoShuryoYMD();
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
        return entity.getRojinhokenJukyushaNo();
    }

    /**
     * 保険者番号（後期）を返します。
     *
     * @return 保険者番号（後期）
     */
    public RString get保険者番号_後期() {
        return entity.getKokiHokenshaNo();
    }

    /**
     * 被保険者番号（後期）を返します。
     *
     * @return 被保険者番号（後期）
     */
    public RString get被保険者番号_後期() {
        return entity.getKokiHiHokenshaNo();
    }

    /**
     * 保険者番号（国保）を返します。
     *
     * @return 保険者番号（国保）
     */
    public RString get保険者番号_国保() {
        return entity.getKokuhoHokenshaNo();
    }

    /**
     * 被保険者証番号（国保）を返します。
     *
     * @return 被保険者証番号（国保）
     */
    public RString get被保険者証番号_国保() {
        return entity.getKokuhoHiHokenshashoNo();
    }

    /**
     * 個人番号（国保）を返します。
     *
     * @return 個人番号（国保）
     */
    public RString get個人番号_国保() {
        return entity.getKokuhoKojinNo();
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
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 中止年月日を返します。
     *
     * @return 中止年月日
     */
    public FlexibleDate get中止年月日() {
        return entity.getChushiYMD();
    }

    /**
     * 中止理由_入所（院）前の状況コードを返します。
     *
     * @return 中止理由_入所（院）前の状況コード
     */
    public RString get中止理由_入所_院_前の状況コード() {
        return entity.getChushiRiyuNyushomaeJyokyoCode();
    }

    /**
     * 入所（院）年月日を返します。
     *
     * @return 入所（院）年月日
     */
    public FlexibleDate get入所_院_年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所（院）年月日を返します。
     *
     * @return 退所（院）年月日
     */
    public FlexibleDate get退所_院_年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所（院）実日数を返します。
     *
     * @return 入所（院）実日数
     */
    public Decimal get入所_院_実日数() {
        return entity.getNyushoJitsunissu();
    }

    /**
     * 外泊日数を返します。
     *
     * @return 外泊日数
     */
    public Decimal get外泊日数() {
        return entity.getGaihakuNissu();
    }

    /**
     * 退所（院）後の状態コードを返します。
     *
     * @return 退所（院）後の状態コード
     */
    public RString get退所_院_後の状態コード() {
        return entity.getTaishogoJotaiCode();
    }

    /**
     * 保険給付率を返します。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu get保険給付率() {
        return entity.getHokenKyufuritsu();
    }

    /**
     * 公費１給付率を返します。
     *
     * @return 公費１給付率
     */
    public HokenKyufuRitsu get公費１給付率() {
        return entity.getKohi1Kyufuritsu();
    }

    /**
     * 公費２給付率を返します。
     *
     * @return 公費２給付率
     */
    public HokenKyufuRitsu get公費２給付率() {
        return entity.getKohi2Kyufuritsu();
    }

    /**
     * 公費３給付率を返します。
     *
     * @return 公費３給付率
     */
    public HokenKyufuRitsu get公費３給付率() {
        return entity.getKohi3Kyufuritsu();
    }

    /**
     * 前_保険_サービス単位数を返します。
     *
     * @return 前_保険_サービス単位数
     */
    public Decimal get前_保険_サービス単位数() {
        return entity.getMaeHokenServiceTanisu();
    }

    /**
     * 前_保険_請求額を返します。
     *
     * @return 前_保険_請求額
     */
    public Decimal get前_保険_請求額() {
        return entity.getMaeHokenSeikyugaku();
    }

    /**
     * 前_保険_利用者負担額を返します。
     *
     * @return 前_保険_利用者負担額
     */
    public Decimal get前_保険_利用者負担額() {
        return entity.getMaeHokenRiyoshaFutangaku();
    }

    /**
     * 前_保険_緊急時施設療養費請求額を返します。
     *
     * @return 前_保険_緊急時施設療養費請求額
     */
    public Decimal get前_保険_緊急時施設療養費請求額() {
        return entity.getMaeHokenKinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_保険_特定診療費請求額を返します。
     *
     * @return 前_保険_特定診療費請求額
     */
    public Decimal get前_保険_特定診療費請求額() {
        return entity.getMaeHokenTokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_保険_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_保険_特定入所者介護サービス費等請求額
     */
    public Decimal get前_保険_特定入所者介護サービス費等請求額() {
        return entity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 前_公費１_サービス単位数を返します。
     *
     * @return 前_公費１_サービス単位数
     */
    public Decimal get前_公費１_サービス単位数() {
        return entity.getMaeKohi1ServiceTanisu();
    }

    /**
     * 前_公費１_請求額を返します。
     *
     * @return 前_公費１_請求額
     */
    public Decimal get前_公費１_請求額() {
        return entity.getMaeKohi1Seikyugaku();
    }

    /**
     * 前_公費１_本人負担額を返します。
     *
     * @return 前_公費１_本人負担額
     */
    public Decimal get前_公費１_本人負担額() {
        return entity.getMaeKohi1RiyoshaFutangaku();
    }

    /**
     * 前_公費１_緊急時施設療養費請求額を返します。
     *
     * @return 前_公費１_緊急時施設療養費請求額
     */
    public Decimal get前_公費１_緊急時施設療養費請求額() {
        return entity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_公費１_特定診療費請求額を返します。
     *
     * @return 前_公費１_特定診療費請求額
     */
    public Decimal get前_公費１_特定診療費請求額() {
        return entity.getMaeKohi1TokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_公費１_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_公費１_特定入所者介護サービス費等請求額
     */
    public Decimal get前_公費１_特定入所者介護サービス費等請求額() {
        return entity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 前_公費２_サービス単位数を返します。
     *
     * @return 前_公費２_サービス単位数
     */
    public Decimal get前_公費２_サービス単位数() {
        return entity.getMaeKohi2ServiceTanisu();
    }

    /**
     * 前_公費２_請求額を返します。
     *
     * @return 前_公費２_請求額
     */
    public Decimal get前_公費２_請求額() {
        return entity.getMaeKohi2Seikyugaku();
    }

    /**
     * 前_公費２_本人負担額を返します。
     *
     * @return 前_公費２_本人負担額
     */
    public Decimal get前_公費２_本人負担額() {
        return entity.getMaeKohi2RiyoshaFutangaku();
    }

    /**
     * 前_公費２_緊急時施設療養費請求額を返します。
     *
     * @return 前_公費２_緊急時施設療養費請求額
     */
    public Decimal get前_公費２_緊急時施設療養費請求額() {
        return entity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_公費２_特定診療費請求額を返します。
     *
     * @return 前_公費２_特定診療費請求額
     */
    public Decimal get前_公費２_特定診療費請求額() {
        return entity.getMaeKohi2TokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_公費２_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_公費２_特定入所者介護サービス費等請求額
     */
    public Decimal get前_公費２_特定入所者介護サービス費等請求額() {
        return entity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 前_公費３_サービス単位数を返します。
     *
     * @return 前_公費３_サービス単位数
     */
    public Decimal get前_公費３_サービス単位数() {
        return entity.getMaeKohi3ServiceTanisu();
    }

    /**
     * 前_公費３_請求額を返します。
     *
     * @return 前_公費３_請求額
     */
    public Decimal get前_公費３_請求額() {
        return entity.getMaeKohi3Seikyugaku();
    }

    /**
     * 前_公費３_本人負担額を返します。
     *
     * @return 前_公費３_本人負担額
     */
    public Decimal get前_公費３_本人負担額() {
        return entity.getMaeKohi3RiyoshaFutangaku();
    }

    /**
     * 前_公費３_緊急時施設療養費請求額を返します。
     *
     * @return 前_公費３_緊急時施設療養費請求額
     */
    public Decimal get前_公費３_緊急時施設療養費請求額() {
        return entity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_公費３_特定診療費請求額を返します。
     *
     * @return 前_公費３_特定診療費請求額
     */
    public Decimal get前_公費３_特定診療費請求額() {
        return entity.getMaeKohi3TokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_公費３_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_公費３_特定入所者介護サービス費等請求額
     */
    public Decimal get前_公費３_特定入所者介護サービス費等請求額() {
        return entity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_保険_サービス単位数を返します。
     *
     * @return 後_保険_サービス単位数
     */
    public Decimal get後_保険_サービス単位数() {
        return entity.getAtoHokenServiceTanisu();
    }

    /**
     * 後_保険_請求額を返します。
     *
     * @return 後_保険_請求額
     */
    public Decimal get後_保険_請求額() {
        return entity.getAtoHokenSeikyugaku();
    }

    /**
     * 後_保険_利用者負担額を返します。
     *
     * @return 後_保険_利用者負担額
     */
    public Decimal get後_保険_利用者負担額() {
        return entity.getAtoHokenRiyoshaFutangaku();
    }

    /**
     * 後_緊急時施設療養費請求額を返します。
     *
     * @return 後_緊急時施設療養費請求額
     */
    public Decimal get後_緊急時施設療養費請求額() {
        return entity.getAtoHokenKinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_保険_特定診療費請求額を返します。
     *
     * @return 後_保険_特定診療費請求額
     */
    public Decimal get後_保険_特定診療費請求額() {
        return entity.getAtoHokenTokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_保険_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_保険_特定入所者介護サービス費等請求額
     */
    public Decimal get後_保険_特定入所者介護サービス費等請求額() {
        return entity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_公費１_サービス単位数を返します。
     *
     * @return 後_公費１_サービス単位数
     */
    public Decimal get後_公費１_サービス単位数() {
        return entity.getAtoKohi1ServiceTanisu();
    }

    /**
     * 後_公費１_請求額を返します。
     *
     * @return 後_公費１_請求額
     */
    public Decimal get後_公費１_請求額() {
        return entity.getAtoKohi1Seikyugaku();
    }

    /**
     * 後_公費１_本人負担額を返します。
     *
     * @return 後_公費１_本人負担額
     */
    public Decimal get後_公費１_本人負担額() {
        return entity.getAtoKohi1RiyoshaFutangaku();
    }

    /**
     * 後_公費１_緊急時施設療養費請求額を返します。
     *
     * @return 後_公費１_緊急時施設療養費請求額
     */
    public Decimal get後_公費１_緊急時施設療養費請求額() {
        return entity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_公費１_特定診療費請求額を返します。
     *
     * @return 後_公費１_特定診療費請求額
     */
    public Decimal get後_公費１_特定診療費請求額() {
        return entity.getAtoKohi1TokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_公費１_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_公費１_特定入所者介護サービス費等請求額
     */
    public Decimal get後_公費１_特定入所者介護サービス費等請求額() {
        return entity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_公費２_サービス単位数を返します。
     *
     * @return 後_公費２_サービス単位数
     */
    public Decimal get後_公費２_サービス単位数() {
        return entity.getAtoKohi2ServiceTanisu();
    }

    /**
     * 後_公費２_請求額を返します。
     *
     * @return 後_公費２_請求額
     */
    public Decimal get後_公費２_請求額() {
        return entity.getAtoKohi2Seikyugaku();
    }

    /**
     * 後_公費２_利用者負担額を返します。
     *
     * @return 後_公費２_利用者負担額
     */
    public Decimal get後_公費２_利用者負担額() {
        return entity.getAtoKohi2RiyoshaFutangaku();
    }

    /**
     * 後_公費２_緊急時施設療養費請求額を返します。
     *
     * @return 後_公費２_緊急時施設療養費請求額
     */
    public Decimal get後_公費２_緊急時施設療養費請求額() {
        return entity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_公費２_特定診療費請求額を返します。
     *
     * @return 後_公費２_特定診療費請求額
     */
    public Decimal get後_公費２_特定診療費請求額() {
        return entity.getAtoKohi2TokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_公費２_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_公費２_特定入所者介護サービス費等請求額
     */
    public Decimal get後_公費２_特定入所者介護サービス費等請求額() {
        return entity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_公費３_サービス単位数を返します。
     *
     * @return 後_公費３_サービス単位数
     */
    public Decimal get後_公費３_サービス単位数() {
        return entity.getAtoKohi3ServiceTanisu();
    }

    /**
     * 後_公費３_請求額を返します。
     *
     * @return 後_公費３_請求額
     */
    public Decimal get後_公費３_請求額() {
        return entity.getAtoKohi3Seikyugaku();
    }

    /**
     * 後_公費３_利用者負担額を返します。
     *
     * @return 後_公費３_利用者負担額
     */
    public Decimal get後_公費３_利用者負担額() {
        return entity.getAtoKohi3RiyoshaFutangaku();
    }

    /**
     * 後_公費３_緊急時施設療養費請求額を返します。
     *
     * @return 後_公費３_緊急時施設療養費請求額
     */
    public Decimal get後_公費３_緊急時施設療養費請求額() {
        return entity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_公費３_特定診療費請求額を返します。
     *
     * @return 後_公費３_特定診療費請求額
     */
    public Decimal get後_公費３_特定診療費請求額() {
        return entity.getAtoKohi3TokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_公費３_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_公費３_特定入所者介護サービス費等請求額
     */
    public Decimal get後_公費３_特定入所者介護サービス費等請求額() {
        return entity.getAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 警告区分コードを返します。
     *
     * @return 警告区分コード
     */
    public RString get警告区分コード() {
        return entity.getKeikaiKubunCode();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
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
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * 独自作成区分を返します。
     *
     * @return 独自作成区分
     */
    public RString get独自作成区分() {
        return entity.getDokujiSakuseiKubun();
    }

    /**
     * 保険者保有給付実績情報削除済フラグを返します。
     *
     * @return 保険者保有給付実績情報削除済フラグ
     */
    public boolean is保険者保有給付実績情報削除済フラグ() {
        return entity.getHokenshaHoyuKyufujissekiJohoSakujoFlag();
    }

    /**
     * {@link DbT3017KyufujissekiKihonEntity}のクローンを返します。
     *
     * @return {@link DbT3017KyufujissekiKihonEntity}のクローン
     */
    @Override
    public DbT3017KyufujissekiKihonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績基本の識別子{@link KyufujissekiKihonIdentifier}を返します。
     *
     * @return 給付実績基本の識別子{@link KyufujissekiKihonIdentifier}
     */
    @Override
    public KyufujissekiKihonIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績基本を削除対象とします。<br/>
     * {@link DbT3017KyufujissekiKihonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiKihon}
     */
    @Override
    public KyufujissekiKihon deleted() {
        DbT3017KyufujissekiKihonEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiKihon(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiKihon}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiKihon}のシリアライズ形式
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

        private final DbT3017KyufujissekiKihonEntity entity;
        private final KyufujissekiKihonIdentifier id;

        private _SerializationProxy(DbT3017KyufujissekiKihonEntity entity, KyufujissekiKihonIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiKihon(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiKihonBuilder createBuilderForEdit() {
        return new KyufujissekiKihonBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
