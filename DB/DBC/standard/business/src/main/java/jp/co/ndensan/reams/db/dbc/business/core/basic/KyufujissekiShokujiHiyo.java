/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3022KyufujissekiShokujiHiyoEntity;
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
 * 給付実績食事費用を管理するクラスです。
 */
public class KyufujissekiShokujiHiyo extends 
        ModelBase<KyufujissekiShokujiHiyoIdentifier, 
        DbT3022KyufujissekiShokujiHiyoEntity, 
        KyufujissekiShokujiHiyo> implements Serializable {

    private final DbT3022KyufujissekiShokujiHiyoEntity entity;
    private final KyufujissekiShokujiHiyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績食事費用の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     */
    public KyufujissekiShokujiHiyo(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        this.entity = new DbT3022KyufujissekiShokujiHiyoEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.id = new KyufujissekiShokujiHiyoIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3022KyufujissekiShokujiHiyoEntity}より{@link KyufujissekiShokujiHiyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3022KyufujissekiShokujiHiyoEntity}
     */
    public KyufujissekiShokujiHiyo(DbT3022KyufujissekiShokujiHiyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績食事費用"));
        this.id = new KyufujissekiShokujiHiyoIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3022KyufujissekiShokujiHiyoEntity}
     * @param id {@link KyufujissekiShokujiHiyoIdentifier}
     */
    KyufujissekiShokujiHiyo(
            DbT3022KyufujissekiShokujiHiyoEntity entity,
            KyufujissekiShokujiHiyoIdentifier id
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
     * 基本_提供日数を返します。
     *
     * @return 基本_提供日数
     */
    public Decimal get基本_提供日数() {
        return entity.getKihonTeikyoNissu();
    }

    /**
     * 基本_提供単価を返します。
     *
     * @return 基本_提供単価
     */
    public Decimal get基本_提供単価() {
        return entity.getKihonTeikyoTanka();
    }

    /**
     * 基本_提供金額を返します。
     *
     * @return 基本_提供金額
     */
    public Decimal get基本_提供金額() {
        return entity.getKihonTeikyoKingaku();
    }

    /**
     * 特別_提供日数を返します。
     *
     * @return 特別_提供日数
     */
    public Decimal get特別_提供日数() {
        return entity.getTokubestuTeikyoNissu();
    }

    /**
     * 特別_提供単価を返します。
     *
     * @return 特別_提供単価
     */
    public Decimal get特別_提供単価() {
        return entity.getTokubestuTeikyoTanka();
    }

    /**
     * 特別_提供金額を返します。
     *
     * @return 特別_提供金額
     */
    public Decimal get特別_提供金額() {
        return entity.getTokubestuTeikyoKingaku();
    }

    /**
     * 食事提供延べ日数を返します。
     *
     * @return 食事提供延べ日数
     */
    public Decimal get食事提供延べ日数() {
        return entity.getSyokujiTeikyoNissu();
    }

    /**
     * 公費１対象食事提供延べ日数を返します。
     *
     * @return 公費１対象食事提供延べ日数
     */
    public Decimal get公費１対象食事提供延べ日数() {
        return entity.getKohi1SyokujiTeikyoNissu();
    }

    /**
     * 公費２対象食事提供延べ日数を返します。
     *
     * @return 公費２対象食事提供延べ日数
     */
    public Decimal get公費２対象食事提供延べ日数() {
        return entity.getKohi2SyokujiTeikyoNissu();
    }

    /**
     * 公費３対象食事提供延べ日数を返します。
     *
     * @return 公費３対象食事提供延べ日数
     */
    public Decimal get公費３対象食事提供延べ日数() {
        return entity.getKohi3SyokujiTeikyoNissu();
    }

    /**
     * 食事提供費合計を返します。
     *
     * @return 食事提供費合計
     */
    public Decimal get食事提供費合計() {
        return entity.getSyokujiTeikyohiTotal();
    }

    /**
     * 標準負担額_月額を返します。
     *
     * @return 標準負担額_月額
     */
    public Decimal get標準負担額_月額() {
        return entity.getGetsugakuHyojunFutanGaku();
    }

    /**
     * 食事提供費請求額を返します。
     *
     * @return 食事提供費請求額
     */
    public Decimal get食事提供費請求額() {
        return entity.getSyokujiTeikyohiSeikyugaku();
    }

    /**
     * 公費１食事提供費請求額を返します。
     *
     * @return 公費１食事提供費請求額
     */
    public Decimal get公費１食事提供費請求額() {
        return entity.getKohi1SyokujiTeikyohiSeikyugaku();
    }

    /**
     * 公費２食事提供費請求額を返します。
     *
     * @return 公費２食事提供費請求額
     */
    public Decimal get公費２食事提供費請求額() {
        return entity.getKohi2SyokujiTeikyohiSeikyugaku();
    }

    /**
     * 公費３食事提供費請求額を返します。
     *
     * @return 公費３食事提供費請求額
     */
    public Decimal get公費３食事提供費請求額() {
        return entity.getKohi3SyokujiTeikyohiSeikyugaku();
    }

    /**
     * 標準負担額_日額を返します。
     *
     * @return 標準負担額_日額
     */
    public Decimal get標準負担額_日額() {
        return entity.getNichigakuHyojunFutanGaku();
    }

    /**
     * 後_基本食提供費用提供単価を返します。
     *
     * @return 後_基本食提供費用提供単価
     */
    public Decimal get後_基本食提供費用提供単価() {
        return entity.getAtoKihonTeikyoTanka();
    }

    /**
     * 後_特別食提供費用提供単価を返します。
     *
     * @return 後_特別食提供費用提供単価
     */
    public Decimal get後_特別食提供費用提供単価() {
        return entity.getAtoTokubestuTeikyoTanka();
    }

    /**
     * 後_食事提供費請求額を返します。
     *
     * @return 後_食事提供費請求額
     */
    public Decimal get後_食事提供費請求額() {
        return entity.getAtoSyokujiTeikyohiSeikyugaku();
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
     * {@link DbT3022KyufujissekiShokujiHiyoEntity}のクローンを返します。
     *
     * @return {@link DbT3022KyufujissekiShokujiHiyoEntity}のクローン
     */
    @Override
    public DbT3022KyufujissekiShokujiHiyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績食事費用の識別子{@link KyufujissekiShokujiHiyoIdentifier}を返します。
     *
     * @return 給付実績食事費用の識別子{@link KyufujissekiShokujiHiyoIdentifier}
     */
    @Override
    public KyufujissekiShokujiHiyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績食事費用を削除対象とします。<br/>
     * {@link DbT3022KyufujissekiShokujiHiyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiShokujiHiyo}
     */
    @Override
    public KyufujissekiShokujiHiyo deleted() {
        DbT3022KyufujissekiShokujiHiyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiShokujiHiyo(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiShokujiHiyo}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiShokujiHiyo}のシリアライズ形式
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

        private final DbT3022KyufujissekiShokujiHiyoEntity entity;
        private final KyufujissekiShokujiHiyoIdentifier id;

        private _SerializationProxy(DbT3022KyufujissekiShokujiHiyoEntity entity, KyufujissekiShokujiHiyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiShokujiHiyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiShokujiHiyoBuilder createBuilderForEdit() {
        return new KyufujissekiShokujiHiyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
