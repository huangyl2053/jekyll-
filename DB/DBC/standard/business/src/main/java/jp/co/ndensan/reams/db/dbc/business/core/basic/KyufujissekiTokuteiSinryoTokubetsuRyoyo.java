/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
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
 * 給付実績特定診療費_特別療養費を管理するクラスです。
 */
public class KyufujissekiTokuteiSinryoTokubetsuRyoyo 
extends ModelBase<KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier, 
        DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity, 
        KyufujissekiTokuteiSinryoTokubetsuRyoyo> implements Serializable {

    private final DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity;
    private final KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績特定診療費_特別療養費の新規作成時に使用します。
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
    public KyufujissekiTokuteiSinryoTokubetsuRyoyo(KokanShikibetsuNo 交換情報識別番号,
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
        this.entity = new DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setRecodeJunjiNo(特定診療情報レコード順次番号);
        this.id = new KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier(
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
     * DBより取得した{@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}より{@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyo(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績特定診療費_特別療養費"));
        this.id = new KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier(
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
     * @param entity
     * {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}
     * @param id {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier}
     */
    KyufujissekiTokuteiSinryoTokubetsuRyoyo(
            DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity,
            KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id
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
     * 識別番号を返します。
     *
     * @return 識別番号
     */
    public RString get識別番号() {
        return entity.getShikibetsuNo();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTanisu();
    }

    /**
     * 保険_回数を返します。
     *
     * @return 保険_回数
     */
    public Decimal get保険_回数() {
        return entity.getHokenKaisu();
    }

    /**
     * 保険_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 保険_ｻｰﾋﾞｽ単位数
     */
    public int get保険_ｻｰﾋﾞｽ単位数() {
        return entity.getHokenServiceTanisu();
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
     * 公費１_回数を返します。
     *
     * @return 公費１_回数
     */
    public Decimal get公費１_回数() {
        return entity.getKohi1Kaisu();
    }

    /**
     * 公費１_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 公費１_ｻｰﾋﾞｽ単位数
     */
    public int get公費１_ｻｰﾋﾞｽ単位数() {
        return entity.getKohi1ServiceTanisu();
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
     * 公費２_回数を返します。
     *
     * @return 公費２_回数
     */
    public Decimal get公費２_回数() {
        return entity.getKohi2Kaisu();
    }

    /**
     * 公費２_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 公費２_ｻｰﾋﾞｽ単位数
     */
    public int get公費２_ｻｰﾋﾞｽ単位数() {
        return entity.getKohi2ServiceTanisu();
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
     * 公費３_回数を返します。
     *
     * @return 公費３_回数
     */
    public Decimal get公費３_回数() {
        return entity.getKohi3Kaisu();
    }

    /**
     * 公費３_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 公費３_ｻｰﾋﾞｽ単位数
     */
    public int get公費３_ｻｰﾋﾞｽ単位数() {
        return entity.getKohi3ServiceTanisu();
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
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 後_単位数を返します。
     *
     * @return 後_単位数
     */
    public Decimal get後_単位数() {
        return entity.getAtoTanisu();
    }

    /**
     * 後_保険_回数を返します。
     *
     * @return 後_保険_回数
     */
    public Decimal get後_保険_回数() {
        return entity.getAtoHokenKaisu();
    }

    /**
     * 後_保険_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_保険_ｻｰﾋﾞｽ単位数
     */
    public int get後_保険_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoHokenServiceTanisu();
    }

    /**
     * 後_保険_合計単位数を返します。
     *
     * @return 後_保険_合計単位数
     */
    public int get後_保険_合計単位数() {
        return entity.getAtoHokenTotalTanisu();
    }

    /**
     * 後_公費１_回数を返します。
     *
     * @return 後_公費１_回数
     */
    public Decimal get後_公費１_回数() {
        return entity.getAtoKohi1Kaisu();
    }

    /**
     * 後_公費１_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_公費１_ｻｰﾋﾞｽ単位数
     */
    public int get後_公費１_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoKohi1ServiceTanisu();
    }

    /**
     * 後_公費１_合計単位数を返します。
     *
     * @return 後_公費１_合計単位数
     */
    public int get後_公費１_合計単位数() {
        return entity.getAtoKohi1TotalTanisu();
    }

    /**
     * 後_公費２_回数を返します。
     *
     * @return 後_公費２_回数
     */
    public Decimal get後_公費２_回数() {
        return entity.getAtoKohi2Kaisu();
    }

    /**
     * 後_公費２_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_公費２_ｻｰﾋﾞｽ単位数
     */
    public int get後_公費２_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoKohi2ServiceTanisu();
    }

    /**
     * 後_公費２_合計単位数を返します。
     *
     * @return 後_公費２_合計単位数
     */
    public int get後_公費２_合計単位数() {
        return entity.getAtoKohi2TotalTanisu();
    }

    /**
     * 後_公費３_回数を返します。
     *
     * @return 後_公費３_回数
     */
    public Decimal get後_公費３_回数() {
        return entity.getAtoKohi3Kaisu();
    }

    /**
     * 後_公費３_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_公費３_ｻｰﾋﾞｽ単位数
     */
    public int get後_公費３_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoKohi3ServiceTanisu();
    }

    /**
     * 後_公費３_合計単位数を返します。
     *
     * @return 後_公費３_合計単位数
     */
    public int get後_公費３_合計単位数() {
        return entity.getAtoKohi3TotalTanisu();
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
     * {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}のクローンを返します。
     *
     * @return {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}のクローン
     */
    @Override
    public DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績特定診療費_特別療養費の識別子{@link KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier}を返します。
     *
     * @return
     * 給付実績特定診療費_特別療養費の識別子{@link KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier}
     */
    @Override
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績特定診療費_特別療養費を削除対象とします。<br/>
     * {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}
     */
    @Override
    public KyufujissekiTokuteiSinryoTokubetsuRyoyo deleted() {
        DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiTokuteiSinryoTokubetsuRyoyo(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}のシリアライズ形式
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

        private final DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity;
        private final KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id;

        private _SerializationProxy(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity, 
                KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiTokuteiSinryoTokubetsuRyoyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder createBuilderForEdit() {
        return new KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
