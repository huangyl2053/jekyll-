/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 共同処理用受給者異動基本送付を管理するクラスです。
 */
public class KyodoShoriyoJukyushaIdoKihonSofu extends ModelBase<KyodoShoriyoJukyushaIdoKihonSofuIdentifier, DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity, KyodoShoriyoJukyushaIdoKihonSofu> implements Serializable {

    private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity;
    private final KyodoShoriyoJukyushaIdoKihonSofuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 共同処理用受給者異動基本送付の新規作成時に使用します。
     *
     * @param 異動年月日 異動年月日
     * @param 異動区分コード 異動区分コード
     * @param 受給者異動事由 受給者異動事由
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public KyodoShoriyoJukyushaIdoKihonSofu(FlexibleDate 異動年月日,
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
        this.entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
        this.entity.setIdoYMD(異動年月日);
        this.entity.setIdoKubunCode(異動区分コード);
        this.entity.setJukyushaIdoJiyu(受給者異動事由);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyodoShoriyoJukyushaIdoKihonSofuIdentifier(
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
     * DBより取得した{@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}より{@link KyodoShoriyoJukyushaIdoKihonSofu}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}
     */
    public KyodoShoriyoJukyushaIdoKihonSofu(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("共同処理用受給者異動基本送付"));
        this.id = new KyodoShoriyoJukyushaIdoKihonSofuIdentifier(
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
     * @param entity {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}
     * @param id {@link KyodoShoriyoJukyushaIdoKihonSofuIdentifier}
     */
    KyodoShoriyoJukyushaIdoKihonSofu(
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity,
            KyodoShoriyoJukyushaIdoKihonSofuIdentifier id
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
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHiHokenshaName();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所カナを返します。
     *
     * @return 住所カナ
     */
    public RString get住所カナ() {
        return entity.getDdressKana();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getAddress();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 帳票出力順序コードを返します。
     *
     * @return 帳票出力順序コード
     */
    public RString get帳票出力順序コード() {
        return entity.getChohyoOutputJunjyoCode();
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
     * {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}のクローンを返します。
     *
     * @return {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}のクローン
     */
    @Override
    public DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 共同処理用受給者異動基本送付の識別子{@link KyodoShoriyoJukyushaIdoKihonSofuIdentifier}を返します。
     *
     * @return
     * 共同処理用受給者異動基本送付の識別子{@link KyodoShoriyoJukyushaIdoKihonSofuIdentifier}
     */
    @Override
    public KyodoShoriyoJukyushaIdoKihonSofuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する共同処理用受給者異動基本送付を削除対象とします。<br/>
     * {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyodoShoriyoJukyushaIdoKihonSofu}
     */
    @Override
    public KyodoShoriyoJukyushaIdoKihonSofu deleted() {
        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyodoShoriyoJukyushaIdoKihonSofu(deletedEntity, id);
    }

    /**
     * {@link KyodoShoriyoJukyushaIdoKihonSofu}のシリアライズ形式を提供します。
     *
     * @return {@link KyodoShoriyoJukyushaIdoKihonSofu}のシリアライズ形式
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

        private final DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity;
        private final KyodoShoriyoJukyushaIdoKihonSofuIdentifier id;

        private _SerializationProxy(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity, KyodoShoriyoJukyushaIdoKihonSofuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyodoShoriyoJukyushaIdoKihonSofu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyodoShoriyoJukyushaIdoKihonSofuBuilder createBuilderForEdit() {
        return new KyodoShoriyoJukyushaIdoKihonSofuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
