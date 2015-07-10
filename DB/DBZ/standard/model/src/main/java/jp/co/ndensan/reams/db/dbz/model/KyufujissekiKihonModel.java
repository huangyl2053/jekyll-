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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績基本のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiKihonModel implements Serializable {

    private DbT3017KyufujissekiKihonEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiKihonModel() {
        entity = new DbT3017KyufujissekiKihonEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3017KyufujissekiKihonEntity
     */
    public KyufujissekiKihonModel(DbT3017KyufujissekiKihonEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3017KyufujissekiKihonEntityを返します。
     *
     * @return DbT3017KyufujissekiKihonEntity
     */
    public DbT3017KyufujissekiKihonEntity getEntity() {
        return entity;
    }

    /**
     * DbT3017KyufujissekiKihonEntityを設定します。
     *
     * @param entity DbT3017KyufujissekiKihonEntity
     */
    public void setEntity(DbT3017KyufujissekiKihonEntity entity) {
        this.entity = entity;
    }

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
    public JigyoshaNo get事業所番号() {
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
     * 保険者番号_後期を返します。
     *
     * @return 保険者番号_後期
     */
    public RString get保険者番号_後期() {
        return entity.getKokiHokenshaNo();
    }

    /**
     * 被保険者番号_後期を返します。
     *
     * @return 被保険者番号_後期
     */
    public RString get被保険者番号_後期() {
        return entity.getKokiHiHokenshaNo();
    }

    /**
     * 保険者番号_国保を返します。
     *
     * @return 保険者番号_国保
     */
    public RString get保険者番号_国保() {
        return entity.getKokuhoHokenshaNo();
    }

    /**
     * 被保険者証番号_国保を返します。
     *
     * @return 被保険者証番号_国保
     */
    public RString get被保険者証番号_国保() {
        return entity.getKokuhoHiHokenshashoNo();
    }

    /**
     * 個人番号_国保を返します。
     *
     * @return 個人番号_国保
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
     * 事業所番号_居宅介護支援事業所等を返します。
     *
     * @return 事業所番号_居宅介護支援事業所等
     */
    public JigyoshaNo get事業所番号_居宅介護支援事業所等() {
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
     * 中止理由_入所_院前の状況コードを返します。
     *
     * @return 中止理由_入所_院前の状況コード
     */
    public RString get中止理由_入所_院前の状況コード() {
        return entity.getChushiRiyuNyushomaeJyokyoCode();
    }

    /**
     * 入所_院年月日を返します。
     *
     * @return 入所_院年月日
     */
    public FlexibleDate get入所_院年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所_院年月日を返します。
     *
     * @return 退所_院年月日
     */
    public FlexibleDate get退所_院年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所_院実日数を返します。
     *
     * @return 入所_院実日数
     */
    public int get入所_院実日数() {
        return entity.getNyushoJitsunissu();
    }

    /**
     * 外泊日数を返します。
     *
     * @return 外泊日数
     */
    public int get外泊日数() {
        return entity.getGaihakuNissu();
    }

    /**
     * 退所_院後の状態コードを返します。
     *
     * @return 退所_院後の状態コード
     */
    public RString get退所_院後の状態コード() {
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
    public int get前_保険_サービス単位数() {
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
    public int get前_保険_利用者負担額() {
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
    public int get前_保険_特定入所者介護サービス費等請求額() {
        return entity.getMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 前_公費１_サービス単位数を返します。
     *
     * @return 前_公費１_サービス単位数
     */
    public int get前_公費１_サービス単位数() {
        return entity.getMaeKohi1ServiceTanisu();
    }

    /**
     * 前_公費１_請求額を返します。
     *
     * @return 前_公費１_請求額
     */
    public int get前_公費１_請求額() {
        return entity.getMaeKohi1Seikyugaku();
    }

    /**
     * 前_公費１_本人負担額を返します。
     *
     * @return 前_公費１_本人負担額
     */
    public int get前_公費１_本人負担額() {
        return entity.getMaeKohi1RiyoshaFutangaku();
    }

    /**
     * 前_公費１_緊急時施設療養費請求額を返します。
     *
     * @return 前_公費１_緊急時施設療養費請求額
     */
    public int get前_公費１_緊急時施設療養費請求額() {
        return entity.getMaeKohi1KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_公費１_特定診療費請求額を返します。
     *
     * @return 前_公費１_特定診療費請求額
     */
    public int get前_公費１_特定診療費請求額() {
        return entity.getMaeKohi1TokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_公費１_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_公費１_特定入所者介護サービス費等請求額
     */
    public int get前_公費１_特定入所者介護サービス費等請求額() {
        return entity.getMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 前_公費２_サービス単位数を返します。
     *
     * @return 前_公費２_サービス単位数
     */
    public int get前_公費２_サービス単位数() {
        return entity.getMaeKohi2ServiceTanisu();
    }

    /**
     * 前_公費２_請求額を返します。
     *
     * @return 前_公費２_請求額
     */
    public int get前_公費２_請求額() {
        return entity.getMaeKohi2Seikyugaku();
    }

    /**
     * 前_公費２_本人負担額を返します。
     *
     * @return 前_公費２_本人負担額
     */
    public int get前_公費２_本人負担額() {
        return entity.getMaeKohi2RiyoshaFutangaku();
    }

    /**
     * 前_公費２_緊急時施設療養費請求額を返します。
     *
     * @return 前_公費２_緊急時施設療養費請求額
     */
    public int get前_公費２_緊急時施設療養費請求額() {
        return entity.getMaeKohi2KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_公費２_特定診療費請求額を返します。
     *
     * @return 前_公費２_特定診療費請求額
     */
    public int get前_公費２_特定診療費請求額() {
        return entity.getMaeKohi2TokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_公費２_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_公費２_特定入所者介護サービス費等請求額
     */
    public int get前_公費２_特定入所者介護サービス費等請求額() {
        return entity.getMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 前_公費３_サービス単位数を返します。
     *
     * @return 前_公費３_サービス単位数
     */
    public int get前_公費３_サービス単位数() {
        return entity.getMaeKohi3ServiceTanisu();
    }

    /**
     * 前_公費３_請求額を返します。
     *
     * @return 前_公費３_請求額
     */
    public int get前_公費３_請求額() {
        return entity.getMaeKohi3Seikyugaku();
    }

    /**
     * 前_公費３_本人負担額を返します。
     *
     * @return 前_公費３_本人負担額
     */
    public int get前_公費３_本人負担額() {
        return entity.getMaeKohi3RiyoshaFutangaku();
    }

    /**
     * 前_公費３_緊急時施設療養費請求額を返します。
     *
     * @return 前_公費３_緊急時施設療養費請求額
     */
    public int get前_公費３_緊急時施設療養費請求額() {
        return entity.getMaeKohi3KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 前_公費３_特定診療費請求額を返します。
     *
     * @return 前_公費３_特定診療費請求額
     */
    public int get前_公費３_特定診療費請求額() {
        return entity.getMaeKohi3TokuteiShinryohiSeikyugaku();
    }

    /**
     * 前_公費３_特定入所者介護サービス費等請求額を返します。
     *
     * @return 前_公費３_特定入所者介護サービス費等請求額
     */
    public int get前_公費３_特定入所者介護サービス費等請求額() {
        return entity.getMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_保険_サービス単位数を返します。
     *
     * @return 後_保険_サービス単位数
     */
    public int get後_保険_サービス単位数() {
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
    public int get後_保険_利用者負担額() {
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
    public int get後_保険_特定入所者介護サービス費等請求額() {
        return entity.getAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_公費１_サービス単位数を返します。
     *
     * @return 後_公費１_サービス単位数
     */
    public int get後_公費１_サービス単位数() {
        return entity.getAtoKohi1ServiceTanisu();
    }

    /**
     * 後_公費１_請求額を返します。
     *
     * @return 後_公費１_請求額
     */
    public int get後_公費１_請求額() {
        return entity.getAtoKohi1Seikyugaku();
    }

    /**
     * 後_公費１_本人負担額を返します。
     *
     * @return 後_公費１_本人負担額
     */
    public int get後_公費１_本人負担額() {
        return entity.getAtoKohi1RiyoshaFutangaku();
    }

    /**
     * 後_公費１_緊急時施設療養費請求額を返します。
     *
     * @return 後_公費１_緊急時施設療養費請求額
     */
    public int get後_公費１_緊急時施設療養費請求額() {
        return entity.getAtoKohi1KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_公費１_特定診療費請求額を返します。
     *
     * @return 後_公費１_特定診療費請求額
     */
    public int get後_公費１_特定診療費請求額() {
        return entity.getAtoKohi1TokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_公費１_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_公費１_特定入所者介護サービス費等請求額
     */
    public int get後_公費１_特定入所者介護サービス費等請求額() {
        return entity.getAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_公費２_サービス単位数を返します。
     *
     * @return 後_公費２_サービス単位数
     */
    public int get後_公費２_サービス単位数() {
        return entity.getAtoKohi2ServiceTanisu();
    }

    /**
     * 後_公費２_請求額を返します。
     *
     * @return 後_公費２_請求額
     */
    public int get後_公費２_請求額() {
        return entity.getAtoKohi2Seikyugaku();
    }

    /**
     * 後_公費２_利用者負担額を返します。
     *
     * @return 後_公費２_利用者負担額
     */
    public int get後_公費２_利用者負担額() {
        return entity.getAtoKohi2RiyoshaFutangaku();
    }

    /**
     * 後_公費２_緊急時施設療養費請求額を返します。
     *
     * @return 後_公費２_緊急時施設療養費請求額
     */
    public int get後_公費２_緊急時施設療養費請求額() {
        return entity.getAtoKohi2KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_公費２_特定診療費請求額を返します。
     *
     * @return 後_公費２_特定診療費請求額
     */
    public int get後_公費２_特定診療費請求額() {
        return entity.getAtoKohi2TokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_公費２_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_公費２_特定入所者介護サービス費等請求額
     */
    public int get後_公費２_特定入所者介護サービス費等請求額() {
        return entity.getAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku();
    }

    /**
     * 後_公費３_サービス単位数を返します。
     *
     * @return 後_公費３_サービス単位数
     */
    public int get後_公費３_サービス単位数() {
        return entity.getAtoKohi3ServiceTanisu();
    }

    /**
     * 後_公費３_請求額を返します。
     *
     * @return 後_公費３_請求額
     */
    public int get後_公費３_請求額() {
        return entity.getAtoKohi3Seikyugaku();
    }

    /**
     * 後_公費３_利用者負担額を返します。
     *
     * @return 後_公費３_利用者負担額
     */
    public int get後_公費３_利用者負担額() {
        return entity.getAtoKohi3RiyoshaFutangaku();
    }

    /**
     * 後_公費３_緊急時施設療養費請求額を返します。
     *
     * @return 後_公費３_緊急時施設療養費請求額
     */
    public int get後_公費３_緊急時施設療養費請求額() {
        return entity.getAtoKohi3KinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 後_公費３_特定診療費請求額を返します。
     *
     * @return 後_公費３_特定診療費請求額
     */
    public int get後_公費３_特定診療費請求額() {
        return entity.getAtoKohi3TokuteiShinryohiSeikyugaku();
    }

    /**
     * 後_公費３_特定入所者介護サービス費等請求額を返します。
     *
     * @return 後_公費３_特定入所者介護サービス費等請求額
     */
    public int get後_公費３_特定入所者介護サービス費等請求額() {
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
    public boolean get保険者保有給付実績情報削除済フラグ() {
        return entity.getHokenshaHoyuKyufujissekiJohoSakujoFlag();
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     */
    public void set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     */
    public void setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
    }

    /**
     * 給付実績情報作成区分コードを設定します。
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     */
    public void set給付実績情報作成区分コード(RString 給付実績情報作成区分コード) {
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setHokenshaNo(証記載保険者番号);
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
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 給付実績区分コードを設定します。
     *
     * @param 給付実績区分コード 給付実績区分コード
     */
    public void set給付実績区分コード(RString 給付実績区分コード) {
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        entity.setKyufuJissekiKubunCode(給付実績区分コード);
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     */
    public void set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
    }

    /**
     * 公費１_負担者番号を設定します。
     *
     * @param 公費１_負担者番号 公費１_負担者番号
     */
    public void set公費１_負担者番号(RString 公費１_負担者番号) {
        requireNonNull(公費１_負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_負担者番号"));
        entity.setKohi1FutanshaNo(公費１_負担者番号);
    }

    /**
     * 公費１_受給者番号を設定します。
     *
     * @param 公費１_受給者番号 公費１_受給者番号
     */
    public void set公費１_受給者番号(RString 公費１_受給者番号) {
        requireNonNull(公費１_受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_受給者番号"));
        entity.setKohi1JukyushaNo(公費１_受給者番号);
    }

    /**
     * 公費２_負担者番号を設定します。
     *
     * @param 公費２_負担者番号 公費２_負担者番号
     */
    public void set公費２_負担者番号(RString 公費２_負担者番号) {
        requireNonNull(公費２_負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_負担者番号"));
        entity.setKohi2FutanshaNo(公費２_負担者番号);
    }

    /**
     * 公費２_受給者番号を設定します。
     *
     * @param 公費２_受給者番号 公費２_受給者番号
     */
    public void set公費２_受給者番号(RString 公費２_受給者番号) {
        requireNonNull(公費２_受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_受給者番号"));
        entity.setKohi2JukyushaNo(公費２_受給者番号);
    }

    /**
     * 公費３_負担者番号を設定します。
     *
     * @param 公費３_負担者番号 公費３_負担者番号
     */
    public void set公費３_負担者番号(RString 公費３_負担者番号) {
        requireNonNull(公費３_負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_負担者番号"));
        entity.setKohi3FutanshaNo(公費３_負担者番号);
    }

    /**
     * 公費３_受給者番号を設定します。
     *
     * @param 公費３_受給者番号 公費３_受給者番号
     */
    public void set公費３_受給者番号(RString 公費３_受給者番号) {
        requireNonNull(公費３_受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_受給者番号"));
        entity.setKohi3JukyushaNo(公費３_受給者番号);
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
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     */
    public void set要介護状態区分コード(RString 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYoKaigoJotaiKubunCode(要介護状態区分コード);
    }

    /**
     * 旧措置入所者特例コードを設定します。
     *
     * @param 旧措置入所者特例コード 旧措置入所者特例コード
     */
    public void set旧措置入所者特例コード(RString 旧措置入所者特例コード) {
        requireNonNull(旧措置入所者特例コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置入所者特例コード"));
        entity.setKyuSochiNyushoshaTokureiCode(旧措置入所者特例コード);
    }

    /**
     * 認定有効期間_開始年月日を設定します。
     *
     * @param 認定有効期間_開始年月日 認定有効期間_開始年月日
     */
    public void set認定有効期間_開始年月日(FlexibleDate 認定有効期間_開始年月日) {
        requireNonNull(認定有効期間_開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間_開始年月日"));
        entity.setNinteiYukoKaishiYMD(認定有効期間_開始年月日);
    }

    /**
     * 認定有功期間_終了年月日を設定します。
     *
     * @param 認定有功期間_終了年月日 認定有功期間_終了年月日
     */
    public void set認定有功期間_終了年月日(FlexibleDate 認定有功期間_終了年月日) {
        requireNonNull(認定有功期間_終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有功期間_終了年月日"));
        entity.setNinteiYukoShuryoYMD(認定有功期間_終了年月日);
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
        entity.setRojinhokenJukyushaNo(老人保健受給者番号);
    }

    /**
     * 保険者番号_後期を設定します。
     *
     * @param 保険者番号_後期 保険者番号_後期
     */
    public void set保険者番号_後期(RString 保険者番号_後期) {
        requireNonNull(保険者番号_後期, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号_後期"));
        entity.setKokiHokenshaNo(保険者番号_後期);
    }

    /**
     * 被保険者番号_後期を設定します。
     *
     * @param 被保険者番号_後期 被保険者番号_後期
     */
    public void set被保険者番号_後期(RString 被保険者番号_後期) {
        requireNonNull(被保険者番号_後期, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号_後期"));
        entity.setKokiHiHokenshaNo(被保険者番号_後期);
    }

    /**
     * 保険者番号_国保を設定します。
     *
     * @param 保険者番号_国保 保険者番号_国保
     */
    public void set保険者番号_国保(RString 保険者番号_国保) {
        requireNonNull(保険者番号_国保, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号_国保"));
        entity.setKokuhoHokenshaNo(保険者番号_国保);
    }

    /**
     * 被保険者証番号_国保を設定します。
     *
     * @param 被保険者証番号_国保 被保険者証番号_国保
     */
    public void set被保険者証番号_国保(RString 被保険者証番号_国保) {
        requireNonNull(被保険者証番号_国保, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者証番号_国保"));
        entity.setKokuhoHiHokenshashoNo(被保険者証番号_国保);
    }

    /**
     * 個人番号_国保を設定します。
     *
     * @param 個人番号_国保 個人番号_国保
     */
    public void set個人番号_国保(RString 個人番号_国保) {
        requireNonNull(個人番号_国保, UrSystemErrorMessages.値がnull.getReplacedMessage("個人番号_国保"));
        entity.setKokuhoKojinNo(個人番号_国保);
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
     * 事業所番号_居宅介護支援事業所等を設定します。
     *
     * @param 事業所番号_居宅介護支援事業所等 事業所番号_居宅介護支援事業所等
     */
    public void set事業所番号_居宅介護支援事業所等(JigyoshaNo 事業所番号_居宅介護支援事業所等) {
        requireNonNull(事業所番号_居宅介護支援事業所等, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号_居宅介護支援事業所等"));
        entity.setKyotakuKaigoShienJigyoshoNo(事業所番号_居宅介護支援事業所等);
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     */
    public void set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
    }

    /**
     * 中止年月日を設定します。
     *
     * @param 中止年月日 中止年月日
     */
    public void set中止年月日(FlexibleDate 中止年月日) {
        requireNonNull(中止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("中止年月日"));
        entity.setChushiYMD(中止年月日);
    }

    /**
     * 中止理由_入所_院前の状況コードを設定します。
     *
     * @param 中止理由_入所_院前の状況コード 中止理由_入所_院前の状況コード
     */
    public void set中止理由_入所_院前の状況コード(RString 中止理由_入所_院前の状況コード) {
        requireNonNull(中止理由_入所_院前の状況コード, UrSystemErrorMessages.値がnull.getReplacedMessage("中止理由_入所_院前の状況コード"));
        entity.setChushiRiyuNyushomaeJyokyoCode(中止理由_入所_院前の状況コード);
    }

    /**
     * 入所_院年月日を設定します。
     *
     * @param 入所_院年月日 入所_院年月日
     */
    public void set入所_院年月日(FlexibleDate 入所_院年月日) {
        requireNonNull(入所_院年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所_院年月日"));
        entity.setNyushoYMD(入所_院年月日);
    }

    /**
     * 退所_院年月日を設定します。
     *
     * @param 退所_院年月日 退所_院年月日
     */
    public void set退所_院年月日(FlexibleDate 退所_院年月日) {
        requireNonNull(退所_院年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所_院年月日"));
        entity.setTaishoYMD(退所_院年月日);
    }

    /**
     * 入所_院実日数を設定します。
     *
     * @param 入所_院実日数 入所_院実日数
     */
    public void set入所_院実日数(int 入所_院実日数) {
        requireNonNull(入所_院実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("入所_院実日数"));
        entity.setNyushoJitsunissu(入所_院実日数);
    }

    /**
     * 外泊日数を設定します。
     *
     * @param 外泊日数 外泊日数
     */
    public void set外泊日数(int 外泊日数) {
        requireNonNull(外泊日数, UrSystemErrorMessages.値がnull.getReplacedMessage("外泊日数"));
        entity.setGaihakuNissu(外泊日数);
    }

    /**
     * 退所_院後の状態コードを設定します。
     *
     * @param 退所_院後の状態コード 退所_院後の状態コード
     */
    public void set退所_院後の状態コード(RString 退所_院後の状態コード) {
        requireNonNull(退所_院後の状態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("退所_院後の状態コード"));
        entity.setTaishogoJotaiCode(退所_院後の状態コード);
    }

    /**
     * 保険給付率を設定します。
     *
     * @param 保険給付率 保険給付率
     */
    public void set保険給付率(HokenKyufuRitsu 保険給付率) {
        requireNonNull(保険給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付率"));
        entity.setHokenKyufuritsu(保険給付率);
    }

    /**
     * 公費１給付率を設定します。
     *
     * @param 公費１給付率 公費１給付率
     */
    public void set公費１給付率(HokenKyufuRitsu 公費１給付率) {
        requireNonNull(公費１給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１給付率"));
        entity.setKohi1Kyufuritsu(公費１給付率);
    }

    /**
     * 公費２給付率を設定します。
     *
     * @param 公費２給付率 公費２給付率
     */
    public void set公費２給付率(HokenKyufuRitsu 公費２給付率) {
        requireNonNull(公費２給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２給付率"));
        entity.setKohi2Kyufuritsu(公費２給付率);
    }

    /**
     * 公費３給付率を設定します。
     *
     * @param 公費３給付率 公費３給付率
     */
    public void set公費３給付率(HokenKyufuRitsu 公費３給付率) {
        requireNonNull(公費３給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３給付率"));
        entity.setKohi3Kyufuritsu(公費３給付率);
    }

    /**
     * 前_保険_サービス単位数を設定します。
     *
     * @param 前_保険_サービス単位数 前_保険_サービス単位数
     */
    public void set前_保険_サービス単位数(int 前_保険_サービス単位数) {
        requireNonNull(前_保険_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前_保険_サービス単位数"));
        entity.setMaeHokenServiceTanisu(前_保険_サービス単位数);
    }

    /**
     * 前_保険_請求額を設定します。
     *
     * @param 前_保険_請求額 前_保険_請求額
     */
    public void set前_保険_請求額(Decimal 前_保険_請求額) {
        requireNonNull(前_保険_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_保険_請求額"));
        entity.setMaeHokenSeikyugaku(前_保険_請求額);
    }

    /**
     * 前_保険_利用者負担額を設定します。
     *
     * @param 前_保険_利用者負担額 前_保険_利用者負担額
     */
    public void set前_保険_利用者負担額(int 前_保険_利用者負担額) {
        requireNonNull(前_保険_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_保険_利用者負担額"));
        entity.setMaeHokenRiyoshaFutangaku(前_保険_利用者負担額);
    }

    /**
     * 前_保険_緊急時施設療養費請求額を設定します。
     *
     * @param 前_保険_緊急時施設療養費請求額 前_保険_緊急時施設療養費請求額
     */
    public void set前_保険_緊急時施設療養費請求額(Decimal 前_保険_緊急時施設療養費請求額) {
        requireNonNull(前_保険_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_保険_緊急時施設療養費請求額"));
        entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(前_保険_緊急時施設療養費請求額);
    }

    /**
     * 前_保険_特定診療費請求額を設定します。
     *
     * @param 前_保険_特定診療費請求額 前_保険_特定診療費請求額
     */
    public void set前_保険_特定診療費請求額(Decimal 前_保険_特定診療費請求額) {
        requireNonNull(前_保険_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_保険_特定診療費請求額"));
        entity.setMaeHokenTokuteiShinryohiSeikyugaku(前_保険_特定診療費請求額);
    }

    /**
     * 前_保険_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前_保険_特定入所者介護サービス費等請求額 前_保険_特定入所者介護サービス費等請求額
     */
    public void set前_保険_特定入所者介護サービス費等請求額(int 前_保険_特定入所者介護サービス費等請求額) {
        requireNonNull(前_保険_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_保険_特定入所者介護サービス費等請求額"));
        entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(前_保険_特定入所者介護サービス費等請求額);
    }

    /**
     * 前_公費１_サービス単位数を設定します。
     *
     * @param 前_公費１_サービス単位数 前_公費１_サービス単位数
     */
    public void set前_公費１_サービス単位数(int 前_公費１_サービス単位数) {
        requireNonNull(前_公費１_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費１_サービス単位数"));
        entity.setMaeKohi1ServiceTanisu(前_公費１_サービス単位数);
    }

    /**
     * 前_公費１_請求額を設定します。
     *
     * @param 前_公費１_請求額 前_公費１_請求額
     */
    public void set前_公費１_請求額(int 前_公費１_請求額) {
        requireNonNull(前_公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費１_請求額"));
        entity.setMaeKohi1Seikyugaku(前_公費１_請求額);
    }

    /**
     * 前_公費１_本人負担額を設定します。
     *
     * @param 前_公費１_本人負担額 前_公費１_本人負担額
     */
    public void set前_公費１_本人負担額(int 前_公費１_本人負担額) {
        requireNonNull(前_公費１_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費１_本人負担額"));
        entity.setMaeKohi1RiyoshaFutangaku(前_公費１_本人負担額);
    }

    /**
     * 前_公費１_緊急時施設療養費請求額を設定します。
     *
     * @param 前_公費１_緊急時施設療養費請求額 前_公費１_緊急時施設療養費請求額
     */
    public void set前_公費１_緊急時施設療養費請求額(int 前_公費１_緊急時施設療養費請求額) {
        requireNonNull(前_公費１_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費１_緊急時施設療養費請求額"));
        entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(前_公費１_緊急時施設療養費請求額);
    }

    /**
     * 前_公費１_特定診療費請求額を設定します。
     *
     * @param 前_公費１_特定診療費請求額 前_公費１_特定診療費請求額
     */
    public void set前_公費１_特定診療費請求額(int 前_公費１_特定診療費請求額) {
        requireNonNull(前_公費１_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費１_特定診療費請求額"));
        entity.setMaeKohi1TokuteiShinryohiSeikyugaku(前_公費１_特定診療費請求額);
    }

    /**
     * 前_公費１_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前_公費１_特定入所者介護サービス費等請求額 前_公費１_特定入所者介護サービス費等請求額
     */
    public void set前_公費１_特定入所者介護サービス費等請求額(int 前_公費１_特定入所者介護サービス費等請求額) {
        requireNonNull(前_公費１_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費１_特定入所者介護サービス費等請求額"));
        entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(前_公費１_特定入所者介護サービス費等請求額);
    }

    /**
     * 前_公費２_サービス単位数を設定します。
     *
     * @param 前_公費２_サービス単位数 前_公費２_サービス単位数
     */
    public void set前_公費２_サービス単位数(int 前_公費２_サービス単位数) {
        requireNonNull(前_公費２_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費２_サービス単位数"));
        entity.setMaeKohi2ServiceTanisu(前_公費２_サービス単位数);
    }

    /**
     * 前_公費２_請求額を設定します。
     *
     * @param 前_公費２_請求額 前_公費２_請求額
     */
    public void set前_公費２_請求額(int 前_公費２_請求額) {
        requireNonNull(前_公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費２_請求額"));
        entity.setMaeKohi2Seikyugaku(前_公費２_請求額);
    }

    /**
     * 前_公費２_本人負担額を設定します。
     *
     * @param 前_公費２_本人負担額 前_公費２_本人負担額
     */
    public void set前_公費２_本人負担額(int 前_公費２_本人負担額) {
        requireNonNull(前_公費２_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費２_本人負担額"));
        entity.setMaeKohi2RiyoshaFutangaku(前_公費２_本人負担額);
    }

    /**
     * 前_公費２_緊急時施設療養費請求額を設定します。
     *
     * @param 前_公費２_緊急時施設療養費請求額 前_公費２_緊急時施設療養費請求額
     */
    public void set前_公費２_緊急時施設療養費請求額(int 前_公費２_緊急時施設療養費請求額) {
        requireNonNull(前_公費２_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費２_緊急時施設療養費請求額"));
        entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(前_公費２_緊急時施設療養費請求額);
    }

    /**
     * 前_公費２_特定診療費請求額を設定します。
     *
     * @param 前_公費２_特定診療費請求額 前_公費２_特定診療費請求額
     */
    public void set前_公費２_特定診療費請求額(int 前_公費２_特定診療費請求額) {
        requireNonNull(前_公費２_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費２_特定診療費請求額"));
        entity.setMaeKohi2TokuteiShinryohiSeikyugaku(前_公費２_特定診療費請求額);
    }

    /**
     * 前_公費２_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前_公費２_特定入所者介護サービス費等請求額 前_公費２_特定入所者介護サービス費等請求額
     */
    public void set前_公費２_特定入所者介護サービス費等請求額(int 前_公費２_特定入所者介護サービス費等請求額) {
        requireNonNull(前_公費２_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費２_特定入所者介護サービス費等請求額"));
        entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(前_公費２_特定入所者介護サービス費等請求額);
    }

    /**
     * 前_公費３_サービス単位数を設定します。
     *
     * @param 前_公費３_サービス単位数 前_公費３_サービス単位数
     */
    public void set前_公費３_サービス単位数(int 前_公費３_サービス単位数) {
        requireNonNull(前_公費３_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費３_サービス単位数"));
        entity.setMaeKohi3ServiceTanisu(前_公費３_サービス単位数);
    }

    /**
     * 前_公費３_請求額を設定します。
     *
     * @param 前_公費３_請求額 前_公費３_請求額
     */
    public void set前_公費３_請求額(int 前_公費３_請求額) {
        requireNonNull(前_公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費３_請求額"));
        entity.setMaeKohi3Seikyugaku(前_公費３_請求額);
    }

    /**
     * 前_公費３_本人負担額を設定します。
     *
     * @param 前_公費３_本人負担額 前_公費３_本人負担額
     */
    public void set前_公費３_本人負担額(int 前_公費３_本人負担額) {
        requireNonNull(前_公費３_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費３_本人負担額"));
        entity.setMaeKohi3RiyoshaFutangaku(前_公費３_本人負担額);
    }

    /**
     * 前_公費３_緊急時施設療養費請求額を設定します。
     *
     * @param 前_公費３_緊急時施設療養費請求額 前_公費３_緊急時施設療養費請求額
     */
    public void set前_公費３_緊急時施設療養費請求額(int 前_公費３_緊急時施設療養費請求額) {
        requireNonNull(前_公費３_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費３_緊急時施設療養費請求額"));
        entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(前_公費３_緊急時施設療養費請求額);
    }

    /**
     * 前_公費３_特定診療費請求額を設定します。
     *
     * @param 前_公費３_特定診療費請求額 前_公費３_特定診療費請求額
     */
    public void set前_公費３_特定診療費請求額(int 前_公費３_特定診療費請求額) {
        requireNonNull(前_公費３_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費３_特定診療費請求額"));
        entity.setMaeKohi3TokuteiShinryohiSeikyugaku(前_公費３_特定診療費請求額);
    }

    /**
     * 前_公費３_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前_公費３_特定入所者介護サービス費等請求額 前_公費３_特定入所者介護サービス費等請求額
     */
    public void set前_公費３_特定入所者介護サービス費等請求額(int 前_公費３_特定入所者介護サービス費等請求額) {
        requireNonNull(前_公費３_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前_公費３_特定入所者介護サービス費等請求額"));
        entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(前_公費３_特定入所者介護サービス費等請求額);
    }

    /**
     * 後_保険_サービス単位数を設定します。
     *
     * @param 後_保険_サービス単位数 後_保険_サービス単位数
     */
    public void set後_保険_サービス単位数(int 後_保険_サービス単位数) {
        requireNonNull(後_保険_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_サービス単位数"));
        entity.setAtoHokenServiceTanisu(後_保険_サービス単位数);
    }

    /**
     * 後_保険_請求額を設定します。
     *
     * @param 後_保険_請求額 後_保険_請求額
     */
    public void set後_保険_請求額(Decimal 後_保険_請求額) {
        requireNonNull(後_保険_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_請求額"));
        entity.setAtoHokenSeikyugaku(後_保険_請求額);
    }

    /**
     * 後_保険_利用者負担額を設定します。
     *
     * @param 後_保険_利用者負担額 後_保険_利用者負担額
     */
    public void set後_保険_利用者負担額(int 後_保険_利用者負担額) {
        requireNonNull(後_保険_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_利用者負担額"));
        entity.setAtoHokenRiyoshaFutangaku(後_保険_利用者負担額);
    }

    /**
     * 後_緊急時施設療養費請求額を設定します。
     *
     * @param 後_緊急時施設療養費請求額 後_緊急時施設療養費請求額
     */
    public void set後_緊急時施設療養費請求額(Decimal 後_緊急時施設療養費請求額) {
        requireNonNull(後_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_緊急時施設療養費請求額"));
        entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(後_緊急時施設療養費請求額);
    }

    /**
     * 後_保険_特定診療費請求額を設定します。
     *
     * @param 後_保険_特定診療費請求額 後_保険_特定診療費請求額
     */
    public void set後_保険_特定診療費請求額(Decimal 後_保険_特定診療費請求額) {
        requireNonNull(後_保険_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_特定診療費請求額"));
        entity.setAtoHokenTokuteiShinryohiSeikyugaku(後_保険_特定診療費請求額);
    }

    /**
     * 後_保険_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後_保険_特定入所者介護サービス費等請求額 後_保険_特定入所者介護サービス費等請求額
     */
    public void set後_保険_特定入所者介護サービス費等請求額(int 後_保険_特定入所者介護サービス費等請求額) {
        requireNonNull(後_保険_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_特定入所者介護サービス費等請求額"));
        entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(後_保険_特定入所者介護サービス費等請求額);
    }

    /**
     * 後_公費１_サービス単位数を設定します。
     *
     * @param 後_公費１_サービス単位数 後_公費１_サービス単位数
     */
    public void set後_公費１_サービス単位数(int 後_公費１_サービス単位数) {
        requireNonNull(後_公費１_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_サービス単位数"));
        entity.setAtoKohi1ServiceTanisu(後_公費１_サービス単位数);
    }

    /**
     * 後_公費１_請求額を設定します。
     *
     * @param 後_公費１_請求額 後_公費１_請求額
     */
    public void set後_公費１_請求額(int 後_公費１_請求額) {
        requireNonNull(後_公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_請求額"));
        entity.setAtoKohi1Seikyugaku(後_公費１_請求額);
    }

    /**
     * 後_公費１_本人負担額を設定します。
     *
     * @param 後_公費１_本人負担額 後_公費１_本人負担額
     */
    public void set後_公費１_本人負担額(int 後_公費１_本人負担額) {
        requireNonNull(後_公費１_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_本人負担額"));
        entity.setAtoKohi1RiyoshaFutangaku(後_公費１_本人負担額);
    }

    /**
     * 後_公費１_緊急時施設療養費請求額を設定します。
     *
     * @param 後_公費１_緊急時施設療養費請求額 後_公費１_緊急時施設療養費請求額
     */
    public void set後_公費１_緊急時施設療養費請求額(int 後_公費１_緊急時施設療養費請求額) {
        requireNonNull(後_公費１_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_緊急時施設療養費請求額"));
        entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(後_公費１_緊急時施設療養費請求額);
    }

    /**
     * 後_公費１_特定診療費請求額を設定します。
     *
     * @param 後_公費１_特定診療費請求額 後_公費１_特定診療費請求額
     */
    public void set後_公費１_特定診療費請求額(int 後_公費１_特定診療費請求額) {
        requireNonNull(後_公費１_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_特定診療費請求額"));
        entity.setAtoKohi1TokuteiShinryohiSeikyugaku(後_公費１_特定診療費請求額);
    }

    /**
     * 後_公費１_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後_公費１_特定入所者介護サービス費等請求額 後_公費１_特定入所者介護サービス費等請求額
     */
    public void set後_公費１_特定入所者介護サービス費等請求額(int 後_公費１_特定入所者介護サービス費等請求額) {
        requireNonNull(後_公費１_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_特定入所者介護サービス費等請求額"));
        entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(後_公費１_特定入所者介護サービス費等請求額);
    }

    /**
     * 後_公費２_サービス単位数を設定します。
     *
     * @param 後_公費２_サービス単位数 後_公費２_サービス単位数
     */
    public void set後_公費２_サービス単位数(int 後_公費２_サービス単位数) {
        requireNonNull(後_公費２_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_サービス単位数"));
        entity.setAtoKohi2ServiceTanisu(後_公費２_サービス単位数);
    }

    /**
     * 後_公費２_請求額を設定します。
     *
     * @param 後_公費２_請求額 後_公費２_請求額
     */
    public void set後_公費２_請求額(int 後_公費２_請求額) {
        requireNonNull(後_公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_請求額"));
        entity.setAtoKohi2Seikyugaku(後_公費２_請求額);
    }

    /**
     * 後_公費２_利用者負担額を設定します。
     *
     * @param 後_公費２_利用者負担額 後_公費２_利用者負担額
     */
    public void set後_公費２_利用者負担額(int 後_公費２_利用者負担額) {
        requireNonNull(後_公費２_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_利用者負担額"));
        entity.setAtoKohi2RiyoshaFutangaku(後_公費２_利用者負担額);
    }

    /**
     * 後_公費２_緊急時施設療養費請求額を設定します。
     *
     * @param 後_公費２_緊急時施設療養費請求額 後_公費２_緊急時施設療養費請求額
     */
    public void set後_公費２_緊急時施設療養費請求額(int 後_公費２_緊急時施設療養費請求額) {
        requireNonNull(後_公費２_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_緊急時施設療養費請求額"));
        entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(後_公費２_緊急時施設療養費請求額);
    }

    /**
     * 後_公費２_特定診療費請求額を設定します。
     *
     * @param 後_公費２_特定診療費請求額 後_公費２_特定診療費請求額
     */
    public void set後_公費２_特定診療費請求額(int 後_公費２_特定診療費請求額) {
        requireNonNull(後_公費２_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_特定診療費請求額"));
        entity.setAtoKohi2TokuteiShinryohiSeikyugaku(後_公費２_特定診療費請求額);
    }

    /**
     * 後_公費２_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後_公費２_特定入所者介護サービス費等請求額 後_公費２_特定入所者介護サービス費等請求額
     */
    public void set後_公費２_特定入所者介護サービス費等請求額(int 後_公費２_特定入所者介護サービス費等請求額) {
        requireNonNull(後_公費２_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_特定入所者介護サービス費等請求額"));
        entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(後_公費２_特定入所者介護サービス費等請求額);
    }

    /**
     * 後_公費３_サービス単位数を設定します。
     *
     * @param 後_公費３_サービス単位数 後_公費３_サービス単位数
     */
    public void set後_公費３_サービス単位数(int 後_公費３_サービス単位数) {
        requireNonNull(後_公費３_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_サービス単位数"));
        entity.setAtoKohi3ServiceTanisu(後_公費３_サービス単位数);
    }

    /**
     * 後_公費３_請求額を設定します。
     *
     * @param 後_公費３_請求額 後_公費３_請求額
     */
    public void set後_公費３_請求額(int 後_公費３_請求額) {
        requireNonNull(後_公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_請求額"));
        entity.setAtoKohi3Seikyugaku(後_公費３_請求額);
    }

    /**
     * 後_公費３_利用者負担額を設定します。
     *
     * @param 後_公費３_利用者負担額 後_公費３_利用者負担額
     */
    public void set後_公費３_利用者負担額(int 後_公費３_利用者負担額) {
        requireNonNull(後_公費３_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_利用者負担額"));
        entity.setAtoKohi3RiyoshaFutangaku(後_公費３_利用者負担額);
    }

    /**
     * 後_公費３_緊急時施設療養費請求額を設定します。
     *
     * @param 後_公費３_緊急時施設療養費請求額 後_公費３_緊急時施設療養費請求額
     */
    public void set後_公費３_緊急時施設療養費請求額(int 後_公費３_緊急時施設療養費請求額) {
        requireNonNull(後_公費３_緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_緊急時施設療養費請求額"));
        entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(後_公費３_緊急時施設療養費請求額);
    }

    /**
     * 後_公費３_特定診療費請求額を設定します。
     *
     * @param 後_公費３_特定診療費請求額 後_公費３_特定診療費請求額
     */
    public void set後_公費３_特定診療費請求額(int 後_公費３_特定診療費請求額) {
        requireNonNull(後_公費３_特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_特定診療費請求額"));
        entity.setAtoKohi3TokuteiShinryohiSeikyugaku(後_公費３_特定診療費請求額);
    }

    /**
     * 後_公費３_特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後_公費３_特定入所者介護サービス費等請求額 後_公費３_特定入所者介護サービス費等請求額
     */
    public void set後_公費３_特定入所者介護サービス費等請求額(int 後_公費３_特定入所者介護サービス費等請求額) {
        requireNonNull(後_公費３_特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_特定入所者介護サービス費等請求額"));
        entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(後_公費３_特定入所者介護サービス費等請求額);
    }

    /**
     * 警告区分コードを設定します。
     *
     * @param 警告区分コード 警告区分コード
     */
    public void set警告区分コード(RString 警告区分コード) {
        requireNonNull(警告区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("警告区分コード"));
        entity.setKeikaiKubunCode(警告区分コード);
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     */
    public void set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
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
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     */
    public void set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
    }

    /**
     * 独自作成区分を設定します。
     *
     * @param 独自作成区分 独自作成区分
     */
    public void set独自作成区分(RString 独自作成区分) {
        requireNonNull(独自作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("独自作成区分"));
        entity.setDokujiSakuseiKubun(独自作成区分);
    }

    /**
     * 保険者保有給付実績情報削除済フラグを設定します。
     *
     * @param 保険者保有給付実績情報削除済フラグ 保険者保有給付実績情報削除済フラグ
     */
    public void set保険者保有給付実績情報削除済フラグ(boolean 保険者保有給付実績情報削除済フラグ) {
        requireNonNull(保険者保有給付実績情報削除済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者保有給付実績情報削除済フラグ"));
        entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(保険者保有給付実績情報削除済フラグ);
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
