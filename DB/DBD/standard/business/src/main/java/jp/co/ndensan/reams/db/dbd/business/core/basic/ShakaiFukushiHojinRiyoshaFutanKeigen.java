/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 社会福祉法人等利用者負担軽減を管理するクラスです。
 */
public class ShakaiFukushiHojinRiyoshaFutanKeigen
        extends
        ModelBase<
        ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier, DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity, ShakaiFukushiHojinRiyoshaFutanKeigen>
        implements
        Serializable {

    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity;
    private final ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 社会福祉法人等利用者負担軽減の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigen(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.entity = new DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.id = new ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier(
                証記載保険者番号,
                被保険者番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}より{@link ShakaiFukushiHojinRiyoshaFutanKeigen}を生成します。
     *
     * @param entity DBより取得した{@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigen(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減"));
        this.id = new ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}
     * @param id {@link ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier}
     */
    ShakaiFukushiHojinRiyoshaFutanKeigen(
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity,
            ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
        return entity.getHihokenshaNo();
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
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 生活保護受給有無を返します。
     *
     * @return 生活保護受給有無
     */
    public boolean is生活保護受給有無() {
        return entity.getSeihoJukyuUmu();
    }

    /**
     * 老齢福祉年金受給有無を返します。
     *
     * @return 老齢福祉年金受給有無
     */
    public boolean is老齢福祉年金受給有無() {
        return entity.getRoreiFukushiNenkinJukyuUmu();
    }

    /**
     * 生保扶助見直し特例有無を返します。
     *
     * @return 生保扶助見直し特例有無
     */
    public boolean is生保扶助見直し特例有無() {
        return entity.getSeihoFujoMinaoshiTokureiUmu();
    }

    /**
     * 軽減率（分子）を返します。
     *
     * @return 軽減率（分子）
     */
    public Decimal get軽減率分子() {
        return entity.getKeigenritsu_Bunshi();
    }

    /**
     * 軽減率（分母）を返します。
     *
     * @return 軽減率（分母）
     */
    public Decimal get軽減率分母() {
        return entity.getKeigenritsu_Bumbo();
    }

    /**
     * 居宅サービス限定を返します。
     *
     * @return 居宅サービス限定
     */
    public boolean is居宅サービス限定() {
        return entity.getKyotakuServiceGentei();
    }

    /**
     * 居住費・食費のみを返します。
     *
     * @return 居住費・食費のみ
     */
    public boolean is居住費食費のみ() {
        return entity.getKyojuhiShokuhiNomi();
    }

    /**
     * 旧措置者ユニット型個室のみを返します。
     *
     * @return 旧措置者ユニット型個室のみ
     */
    public boolean is旧措置者ユニット型個室のみ() {
        return entity.getKyusochishaUnitTypeKoshitsuNomi();
    }

    /**
     * 確認番号を返します。
     *
     * @return 確認番号
     */
    public RString get確認番号() {
        return entity.getKakuninNo();
    }

    /**
     * 減免区分を返します。
     *
     * @return 減免区分
     */
    public RString get減免区分() {
        return entity.getGemmenKubun();
    }

    /**
     * {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}のクローンを返します。
     *
     * @return {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}のクローン
     */
    @Override
    public DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 社会福祉法人等利用者負担軽減の識別子{@link ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier}を返します。
     *
     * @return 社会福祉法人等利用者負担軽減の識別子{@link ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier}
     */
    @Override
    public ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する社会福祉法人等利用者負担軽減を削除対象とします。<br/>
     * {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShakaiFukushiHojinRiyoshaFutanKeigen}
     */
    @Override
    public ShakaiFukushiHojinRiyoshaFutanKeigen deleted() {
        DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShakaiFukushiHojinRiyoshaFutanKeigen(deletedEntity, id);
    }

    /**
     * {@link ShakaiFukushiHojinRiyoshaFutanKeigen}のシリアライズ形式を提供します。
     *
     * @return {@link ShakaiFukushiHojinRiyoshaFutanKeigen}のシリアライズ形式
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

        private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity;
        private final ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier id;

        private _SerializationProxy(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity, ShakaiFukushiHojinRiyoshaFutanKeigenIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShakaiFukushiHojinRiyoshaFutanKeigen(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShakaiFukushiHojinRiyoshaFutanKeigenBuilder createBuilderForEdit() {
        return new ShakaiFukushiHojinRiyoshaFutanKeigenBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
