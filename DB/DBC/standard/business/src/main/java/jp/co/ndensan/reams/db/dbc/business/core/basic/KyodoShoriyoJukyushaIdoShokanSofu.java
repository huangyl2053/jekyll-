/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 共同処理用受給者異動償還送付を管理するクラスです。
 */
public class KyodoShoriyoJukyushaIdoShokanSofu extends ModelBase<KyodoShoriyoJukyushaIdoShokanSofuIdentifier, DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity, KyodoShoriyoJukyushaIdoShokanSofu> implements Serializable {

    private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity;
    private final KyodoShoriyoJukyushaIdoShokanSofuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 共同処理用受給者異動償還送付の新規作成時に使用します。
     *
     * @param 異動年月日 異動年月日
     * @param 異動区分コード 異動区分コード
     * @param 受給者異動事由 受給者異動事由
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public KyodoShoriyoJukyushaIdoShokanSofu(FlexibleDate 異動年月日,
            RString 異動区分コード,
            RString 受給者異動事由,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
        this.entity.setIdoYMD(異動年月日);
        this.entity.setIdoKubunCode(異動区分コード);
        this.entity.setJukyushaIdoJiyu(受給者異動事由);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyodoShoriyoJukyushaIdoShokanSofuIdentifier(
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
     * DBより取得した{@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}より{@link KyodoShoriyoJukyushaIdoShokanSofu}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}
     */
    public KyodoShoriyoJukyushaIdoShokanSofu(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("共同処理用受給者異動償還送付"));
        this.id = new KyodoShoriyoJukyushaIdoShokanSofuIdentifier(
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
     * @param entity {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}
     * @param id {@link KyodoShoriyoJukyushaIdoShokanSofuIdentifier}
     */
    KyodoShoriyoJukyushaIdoShokanSofu(
            DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity,
            KyodoShoriyoJukyushaIdoShokanSofuIdentifier id
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 保険給付支払一時差止開始年月日を返します。
     *
     * @return 保険給付支払一時差止開始年月日
     */
    public FlexibleDate get保険給付支払一時差止開始年月日() {
        return entity.getHokenKyufuIchijiSashitomeKaishiYMD();
    }

    /**
     * 保険給付支払一時差止終了年月日を返します。
     *
     * @return 保険給付支払一時差止終了年月日
     */
    public FlexibleDate get保険給付支払一時差止終了年月日() {
        return entity.getHokenKyufuIchijiSashitomeShuryoYMD();
    }

    /**
     * 保険給付支払一時差止区分コードを返します。
     *
     * @return 保険給付支払一時差止区分コード
     */
    public RString get保険給付支払一時差止区分コード() {
        return entity.getHokenkyufuIchijiSashitomeKubunCode();
    }

    /**
     * 保険給付支払一時差止金額を返します。
     *
     * @return 保険給付支払一時差止金額
     */
    public Decimal get保険給付支払一時差止金額() {
        return entity.getHokenkyufuIchijiSashitomeKingaku();
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
     * {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}のクローンを返します。
     *
     * @return {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}のクローン
     */
    @Override
    public DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 共同処理用受給者異動償還送付の識別子{@link KyodoShoriyoJukyushaIdoShokanSofuIdentifier}を返します。
     *
     * @return
     * 共同処理用受給者異動償還送付の識別子{@link KyodoShoriyoJukyushaIdoShokanSofuIdentifier}
     */
    @Override
    public KyodoShoriyoJukyushaIdoShokanSofuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する共同処理用受給者異動償還送付を削除対象とします。<br/>
     * {@link DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyodoShoriyoJukyushaIdoShokanSofu}
     */
    @Override
    public KyodoShoriyoJukyushaIdoShokanSofu deleted() {
        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyodoShoriyoJukyushaIdoShokanSofu(deletedEntity, id);
    }

    /**
     * {@link KyodoShoriyoJukyushaIdoShokanSofu}のシリアライズ形式を提供します。
     *
     * @return {@link KyodoShoriyoJukyushaIdoShokanSofu}のシリアライズ形式
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

        private final DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity;
        private final KyodoShoriyoJukyushaIdoShokanSofuIdentifier id;

        private _SerializationProxy(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity, KyodoShoriyoJukyushaIdoShokanSofuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyodoShoriyoJukyushaIdoShokanSofu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyodoShoriyoJukyushaIdoShokanSofuBuilder createBuilderForEdit() {
        return new KyodoShoriyoJukyushaIdoShokanSofuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
