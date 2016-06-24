/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisosochishinsei;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層措置申請を管理するクラスです。
 *
 * @reamsid_L DBA-9999-013 huangh
 */
public class KyokaisoSochiShinsei extends ModelBase<KyokaisoSochiShinseiIdentifier, DbT1013KyokaisoSochiShinseiEntity, KyokaisoSochiShinsei>
        implements Serializable {

    private final DbT1013KyokaisoSochiShinseiEntity entity;
    private final KyokaisoSochiShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 境界層措置申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param リンク番号 リンク番号
     */
    public KyokaisoSochiShinsei(HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        this.entity = new DbT1013KyokaisoSochiShinseiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号.intValue());
        this.entity.setLinkNo(リンク番号.intValue());
        this.id = new KyokaisoSochiShinseiIdentifier(
                被保険者番号,
                履歴番号,
                リンク番号
        );
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1013KyokaisoSochiShinseiEntity}
     * @param id {@link KyokaisoSochiShinseiIdentifier}
     */
    KyokaisoSochiShinsei(
            DbT1013KyokaisoSochiShinseiEntity entity,
            KyokaisoSochiShinseiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1013KyokaisoSochiShinseiEntity}
     */
    public KyokaisoSochiShinsei(DbT1013KyokaisoSochiShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層保険料段階"));
        this.id = new KyokaisoSochiShinseiIdentifier(
                entity.getHihokenshaNo(),
                new Decimal(entity.getRirekiNo()),
                new Decimal(entity.getLinkNo()));
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
     * リンク番号を返します。
     *
     * @return リンク番号
     */
    public int getリンク番号() {
        return entity.getLinkNo();
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 申請廃止区分を返します。
     *
     * @return 申請廃止区分
     */
    public RString get申請廃止区分() {
        return entity.getShinsei_HaishiKubun();
    }

    /**
     * 申請廃止年月日を返します。
     *
     * @return 申請廃止年月日
     */
    public FlexibleDate get申請廃止年月日() {
        return entity.getShinsei_HaishiYMD();
    }

    /**
     * 保護不要根拠減額金額を返します。
     *
     * @return 保護不要根拠減額金額
     */
    public Decimal get保護不要根拠減額金額() {
        return entity.getHogoHuyoKonkyoGengakuKingaku();
    }

    /**
     * 境界層証明書交付年月日を返します。
     *
     * @return 境界層証明書交付年月日
     */
    public FlexibleDate get境界層証明書交付年月日() {
        return entity.getKyokaisoShomeishoKofuYMD();
    }

    /**
     * 給付額減額取消減額自己負担月額を返します。
     *
     * @return 給付額減額取消減額自己負担月額
     */
    public Decimal get給付額減額取消減額自己負担月額() {
        return entity.getKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku();
    }

    /**
     * 居住費軽減減額自己負担月額を返します。
     *
     * @return 居住費軽減減額自己負担月額
     */
    public Decimal get居住費軽減減額自己負担月額() {
        return entity.getKyojuhiKeigen_GengakuJikofutanGetsugaku();
    }

    /**
     * 居住費軽減負担限度額段階コードを返します。
     *
     * @return 居住費軽減負担限度額段階コード
     */
    public RString get居住費軽減負担限度額段階コード() {
        return entity.getKyojuhiKeigen_FutangendogakuDankaiCode();
    }

    /**
     * 食費軽減減額自己負担月額を返します。
     *
     * @return 食費軽減減額自己負担月額
     */
    public Decimal get食費軽減減額自己負担月額() {
        return entity.getShokuhiKeigen_GengakuJikofutanGetsugaku();
    }

    /**
     * 食費軽減負担限度額段階コードを返します。
     *
     * @return 食費軽減負担限度額段階コード
     */
    public RString get食費軽減負担限度額段階コード() {
        return entity.getShokuhiKeigen_FutangendogakuDankaiCode();
    }

    /**
     * 利用者負担世帯合算額減額自己負担月額を返します。
     *
     * @return 利用者負担世帯合算額減額自己負担月額
     */
    public Decimal get利用者負担世帯合算額減額自己負担月額() {
        return entity.getRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku();
    }

    /**
     * 保険料減額減額自己負担月額を返します。
     *
     * @return 保険料減額減額自己負担月額
     */
    public Decimal get保険料減額減額自己負担月額() {
        return entity.getHokenryoGengaku_GengakuJikofutanGetsugaku();
    }

    /**
     * 減額自己負担月額合計額を返します。
     *
     * @return 減額自己負担月額合計額
     */
    public Decimal get減額自己負担月額合計額() {
        return entity.getGengakuJikofutanGetsugakuGokeigaku();
    }

    /**
     * 境界層措置決定年月日を返します。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate get境界層措置決定年月日() {
        return entity.getKyukaisoSochiKetteiYMD();
    }

    /**
     * 措置該当非該当区分を返します。
     *
     * @return 措置該当非該当区分
     */
    public RString get措置該当非該当区分() {
        return entity.getSochiGaito_HigaitoKubun();
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
     * {@link DbT1013KyokaisoSochiShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT1013KyokaisoSochiShinseiEntity}のクローン
     */
    @Override
    public DbT1013KyokaisoSochiShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 境界層措置申請の識別子{@link KyokaisoSochiShinseiIdentifier}を返します。
     *
     * @return 境界層措置申請の識別子{@link KyokaisoSochiShinseiIdentifier}
     */
    @Override
    public KyokaisoSochiShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 境界層措置申請配下の要素を削除対象とします。<br/> {@link DbT1013KyokaisoSochiShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 境界層措置申請配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link KyokaisoSochiShinsei}を返します。
     *
     * @return 削除対象処理実施後の{@link KyokaisoSochiShinsei}
     * @throws IllegalStateException DbT1013KyokaisoSochiShinseiEntityのデータ状態が変更の場合
     */
    @Override
    public KyokaisoSochiShinsei deleted() {
        DbT1013KyokaisoSochiShinseiEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyokaisoSochiShinsei(
                deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 境界層措置申請のみを変更対象とします。<br/> {@link DbT1013KyokaisoSochiShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyokaisoSochiShinsei}
     */
    public KyokaisoSochiShinsei modifiedModel() {
        DbT1013KyokaisoSochiShinseiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyokaisoSochiShinsei(
                modifiedEntity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.entity);
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KyokaisoSochiShinsei other = (KyokaisoSochiShinsei) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
