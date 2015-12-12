/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績特定診療費を管理するクラスです。
 */
public class KyufujissekiTokuteiSinryohi 
extends ModelBase<KyufujissekiTokuteiSinryohiIdentifier, 
        DbT3020KyufujissekiTokuteiSinryohiEntity, 
        KyufujissekiTokuteiSinryohi> implements Serializable {

    private final DbT3020KyufujissekiTokuteiSinryohiEntity entity;
    private final KyufujissekiTokuteiSinryohiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績特定診療費の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @param 特定診療情報レコード順次番号 特定診療情報レコード順次番号
     */
    public KyufujissekiTokuteiSinryohi(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 特定診療情報レコード順次番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(特定診療情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療情報レコード順次番号"));
        this.entity = new DbT3020KyufujissekiTokuteiSinryohiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setRecodeJunjiNo(特定診療情報レコード順次番号);
        this.id = new KyufujissekiTokuteiSinryohiIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                特定診療情報レコード順次番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3020KyufujissekiTokuteiSinryohiEntity}より{@link KyufujissekiTokuteiSinryohi}を生成します。
     *
     * @param entity DBより取得した{@link DbT3020KyufujissekiTokuteiSinryohiEntity}
     */
    public KyufujissekiTokuteiSinryohi(DbT3020KyufujissekiTokuteiSinryohiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績特定診療費"));
        this.id = new KyufujissekiTokuteiSinryohiIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getRecodeJunjiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3020KyufujissekiTokuteiSinryohiEntity}
     * @param id {@link KyufujissekiTokuteiSinryohiIdentifier}
     */
    KyufujissekiTokuteiSinryohi(
            DbT3020KyufujissekiTokuteiSinryohiEntity entity,
            KyufujissekiTokuteiSinryohiIdentifier id
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
        return entity.getKokanJohoShikibetsuNo();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
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
     * 特定診療情報レコード順次番号を返します。
     *
     * @return 特定診療情報レコード順次番号
     */
    public RString get特定診療情報レコード順次番号() {
        return entity.getRecodeJunjiNo();
    }

    /**
     * 傷病名を返します。
     *
     * @return 傷病名
     */
    public RString get傷病名() {
        return entity.getShobyoName();
    }

    /**
     * 保険_指導管理料等を返します。
     *
     * @return 保険_指導管理料等
     */
    public int get保険_指導管理料等() {
        return entity.getHokenShidoKanriryo();
    }

    /**
     * 保険_単純エックス線を返します。
     *
     * @return 保険_単純エックス線
     */
    public int get保険_単純エックス線() {
        return entity.getHokenTanjunXsen();
    }

    /**
     * 保険_リハビリテーションを返します。
     *
     * @return 保険_リハビリテーション
     */
    public int get保険_リハビリテーション() {
        return entity.getHokenRehabilitation();
    }

    /**
     * 保険_精神科専門療法を返します。
     *
     * @return 保険_精神科専門療法
     */
    public int get保険_精神科専門療法() {
        return entity.getHokenSeishinkaSemmonRyoho();
    }

    /**
     * 保険_合計単位数を返します。
     *
     * @return 保険_合計単位数
     */
    public int get保険_合計単位数() {
        return entity.getHokenTotalTanisu();
    }

    /**
     * 公費１_指導管理料等を返します。
     *
     * @return 公費１_指導管理料等
     */
    public int get公費１_指導管理料等() {
        return entity.getKohi1ShidoKanriryo();
    }

    /**
     * 公費１_単純エックス線を返します。
     *
     * @return 公費１_単純エックス線
     */
    public int get公費１_単純エックス線() {
        return entity.getKohi1TanjunXsen();
    }

    /**
     * 公費１_リハビリテーションを返します。
     *
     * @return 公費１_リハビリテーション
     */
    public int get公費１_リハビリテーション() {
        return entity.getKohi1Rehabilitation();
    }

    /**
     * 公費１_精神科専門療法を返します。
     *
     * @return 公費１_精神科専門療法
     */
    public int get公費１_精神科専門療法() {
        return entity.getKohi1SeishinkaSemmonRyoho();
    }

    /**
     * 公費１_合計単位数を返します。
     *
     * @return 公費１_合計単位数
     */
    public int get公費１_合計単位数() {
        return entity.getKohi1TotalTanisu();
    }

    /**
     * 公費２_指導管理料等を返します。
     *
     * @return 公費２_指導管理料等
     */
    public int get公費２_指導管理料等() {
        return entity.getKohi2ShidoKanriryo();
    }

    /**
     * 公費２_単純エックス線を返します。
     *
     * @return 公費２_単純エックス線
     */
    public int get公費２_単純エックス線() {
        return entity.getKohi2TanjunXsen();
    }

    /**
     * 公費２_リハビリテーションを返します。
     *
     * @return 公費２_リハビリテーション
     */
    public int get公費２_リハビリテーション() {
        return entity.getKohi2Rehabilitation();
    }

    /**
     * 公費２_精神科専門療法を返します。
     *
     * @return 公費２_精神科専門療法
     */
    public int get公費２_精神科専門療法() {
        return entity.getKohi2SeishinkaSemmonRyoho();
    }

    /**
     * 公費２_合計単位数を返します。
     *
     * @return 公費２_合計単位数
     */
    public int get公費２_合計単位数() {
        return entity.getKohi2TotalTanisu();
    }

    /**
     * 公費３_指導管理料等を返します。
     *
     * @return 公費３_指導管理料等
     */
    public int get公費３_指導管理料等() {
        return entity.getKohi3ShidoKanriryo();
    }

    /**
     * 公費３_単純エックス線を返します。
     *
     * @return 公費３_単純エックス線
     */
    public int get公費３_単純エックス線() {
        return entity.getKohi3TanjunXsen();
    }

    /**
     * 公費３_リハビリテーションを返します。
     *
     * @return 公費３_リハビリテーション
     */
    public int get公費３_リハビリテーション() {
        return entity.getKohi3Rehabilitation();
    }

    /**
     * 公費３_精神科専門療法を返します。
     *
     * @return 公費３_精神科専門療法
     */
    public int get公費３_精神科専門療法() {
        return entity.getKohi3SeishinkaSemmonRyoho();
    }

    /**
     * 公費３_合計単位数を返します。
     *
     * @return 公費３_合計単位数
     */
    public int get公費３_合計単位数() {
        return entity.getKohi3TotalTanisu();
    }

    /**
     * 摘要１を返します。
     *
     * @return 摘要１
     */
    public RString get摘要１() {
        return entity.getTekiyo1();
    }

    /**
     * 摘要２を返します。
     *
     * @return 摘要２
     */
    public RString get摘要２() {
        return entity.getTekiyo2();
    }

    /**
     * 摘要３を返します。
     *
     * @return 摘要３
     */
    public RString get摘要３() {
        return entity.getTekiyo3();
    }

    /**
     * 摘要４を返します。
     *
     * @return 摘要４
     */
    public RString get摘要４() {
        return entity.getTekiyo4();
    }

    /**
     * 摘要５を返します。
     *
     * @return 摘要５
     */
    public RString get摘要５() {
        return entity.getTekiyo5();
    }

    /**
     * 摘要６を返します。
     *
     * @return 摘要６
     */
    public RString get摘要６() {
        return entity.getTekiyo6();
    }

    /**
     * 摘要７を返します。
     *
     * @return 摘要７
     */
    public RString get摘要７() {
        return entity.getTekiyo7();
    }

    /**
     * 摘要８を返します。
     *
     * @return 摘要８
     */
    public RString get摘要８() {
        return entity.getTekiyo8();
    }

    /**
     * 摘要９を返します。
     *
     * @return 摘要９
     */
    public RString get摘要９() {
        return entity.getTekiyo9();
    }

    /**
     * 摘要１０を返します。
     *
     * @return 摘要１０
     */
    public RString get摘要１０() {
        return entity.getTekiyo10();
    }

    /**
     * 摘要１１を返します。
     *
     * @return 摘要１１
     */
    public RString get摘要１１() {
        return entity.getTekiyo11();
    }

    /**
     * 摘要１２を返します。
     *
     * @return 摘要１２
     */
    public RString get摘要１２() {
        return entity.getTekiyo12();
    }

    /**
     * 摘要１３を返します。
     *
     * @return 摘要１３
     */
    public RString get摘要１３() {
        return entity.getTekiyo13();
    }

    /**
     * 摘要１４を返します。
     *
     * @return 摘要１４
     */
    public RString get摘要１４() {
        return entity.getTekiyo14();
    }

    /**
     * 摘要１５を返します。
     *
     * @return 摘要１５
     */
    public RString get摘要１５() {
        return entity.getTekiyo15();
    }

    /**
     * 摘要１６を返します。
     *
     * @return 摘要１６
     */
    public RString get摘要１６() {
        return entity.getTekiyo16();
    }

    /**
     * 摘要１７を返します。
     *
     * @return 摘要１７
     */
    public RString get摘要１７() {
        return entity.getTekiyo17();
    }

    /**
     * 摘要１８を返します。
     *
     * @return 摘要１８
     */
    public RString get摘要１８() {
        return entity.getTekiyo18();
    }

    /**
     * 摘要１９を返します。
     *
     * @return 摘要１９
     */
    public RString get摘要１９() {
        return entity.getTekiyo19();
    }

    /**
     * 摘要２０を返します。
     *
     * @return 摘要２０
     */
    public RString get摘要２０() {
        return entity.getTekiyo20();
    }

    /**
     * 後_保険_指導管理料等を返します。
     *
     * @return 後_保険_指導管理料等
     */
    public int get後_保険_指導管理料等() {
        return entity.getAtoHokenShidoKanriryo();
    }

    /**
     * 後_保険_単純エックス線を返します。
     *
     * @return 後_保険_単純エックス線
     */
    public int get後_保険_単純エックス線() {
        return entity.getAtoHokenTanjunXsen();
    }

    /**
     * 後_保険_リハビリテーションを返します。
     *
     * @return 後_保険_リハビリテーション
     */
    public int get後_保険_リハビリテーション() {
        return entity.getAtoHokenRehabilitation();
    }

    /**
     * 後_保険_精神科専門療法を返します。
     *
     * @return 後_保険_精神科専門療法
     */
    public int get後_保険_精神科専門療法() {
        return entity.getAtoHokenSeishinkaSemmonRyoho();
    }

    /**
     * 後_公費１_指導管理料等を返します。
     *
     * @return 後_公費１_指導管理料等
     */
    public int get後_公費１_指導管理料等() {
        return entity.getAtoKohi1ShidoKanriryo();
    }

    /**
     * 後_公費１_単純エックス線を返します。
     *
     * @return 後_公費１_単純エックス線
     */
    public int get後_公費１_単純エックス線() {
        return entity.getAtoKohi1TanjunXsen();
    }

    /**
     * 後_公費１_リハビリテーションを返します。
     *
     * @return 後_公費１_リハビリテーション
     */
    public int get後_公費１_リハビリテーション() {
        return entity.getAtoKohi1Rehabilitation();
    }

    /**
     * 後_公費１_精神科専門療法を返します。
     *
     * @return 後_公費１_精神科専門療法
     */
    public int get後_公費１_精神科専門療法() {
        return entity.getAtoKohi1SeishinkaSemmonRyoho();
    }

    /**
     * 後_公費２_指導管理料等を返します。
     *
     * @return 後_公費２_指導管理料等
     */
    public int get後_公費２_指導管理料等() {
        return entity.getAtoKohi2ShidoKanriryo();
    }

    /**
     * 後_公費２_単純エックス線を返します。
     *
     * @return 後_公費２_単純エックス線
     */
    public int get後_公費２_単純エックス線() {
        return entity.getAtoKohi2TanjunXsen();
    }

    /**
     * 後_公費２_リハビリテーションを返します。
     *
     * @return 後_公費２_リハビリテーション
     */
    public int get後_公費２_リハビリテーション() {
        return entity.getAtoKohi2Rehabilitation();
    }

    /**
     * 後_公費２_精神科専門療法を返します。
     *
     * @return 後_公費２_精神科専門療法
     */
    public int get後_公費２_精神科専門療法() {
        return entity.getAtoKohi2SeishinkaSemmonRyoho();
    }

    /**
     * 後_公費３_指導管理料等を返します。
     *
     * @return 後_公費３_指導管理料等
     */
    public int get後_公費３_指導管理料等() {
        return entity.getAtoKohi3ShidoKanriryo();
    }

    /**
     * 後_公費３_単純エックス線を返します。
     *
     * @return 後_公費３_単純エックス線
     */
    public int get後_公費３_単純エックス線() {
        return entity.getAtoKohi3TanjunXsen();
    }

    /**
     * 後_公費３_リハビリテーションを返します。
     *
     * @return 後_公費３_リハビリテーション
     */
    public int get後_公費３_リハビリテーション() {
        return entity.getAtoKohi3Rehabilitation();
    }

    /**
     * 後_公費３_精神科専門療法を返します。
     *
     * @return 後_公費３_精神科専門療法
     */
    public int get後_公費３_精神科専門療法() {
        return entity.getAtoKohi3SeishinkaSemmonRyoho();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public Decimal get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public Decimal get過誤回数() {
        return entity.getKagoKaisu();
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
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * {@link DbT3020KyufujissekiTokuteiSinryohiEntity}のクローンを返します。
     *
     * @return {@link DbT3020KyufujissekiTokuteiSinryohiEntity}のクローン
     */
    @Override
    public DbT3020KyufujissekiTokuteiSinryohiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績特定診療費の識別子{@link KyufujissekiTokuteiSinryohiIdentifier}を返します。
     *
     * @return 給付実績特定診療費の識別子{@link KyufujissekiTokuteiSinryohiIdentifier}
     */
    @Override
    public KyufujissekiTokuteiSinryohiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績特定診療費を削除対象とします。<br/>
     * {@link DbT3020KyufujissekiTokuteiSinryohiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiTokuteiSinryohi}
     */
    @Override
    public KyufujissekiTokuteiSinryohi deleted() {
        DbT3020KyufujissekiTokuteiSinryohiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiTokuteiSinryohi(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiTokuteiSinryohi}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiTokuteiSinryohi}のシリアライズ形式
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

        private final DbT3020KyufujissekiTokuteiSinryohiEntity entity;
        private final KyufujissekiTokuteiSinryohiIdentifier id;

        private _SerializationProxy(DbT3020KyufujissekiTokuteiSinryohiEntity entity, KyufujissekiTokuteiSinryohiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiTokuteiSinryohi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiTokuteiSinryohiBuilder createBuilderForEdit() {
        return new KyufujissekiTokuteiSinryohiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
