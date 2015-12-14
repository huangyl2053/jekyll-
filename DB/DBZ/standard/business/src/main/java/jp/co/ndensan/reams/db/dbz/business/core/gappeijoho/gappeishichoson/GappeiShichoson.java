/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合併市町村を管理するクラスです。
 */
public class GappeiShichoson extends ModelBase<GappeiShichosonIdentifier, DbT7056GappeiShichosonEntity, GappeiShichoson> implements Serializable {

    private static final long serialVersionUID = 5427610772528976479L;

    private final DbT7056GappeiShichosonEntity entity;
    private final GappeiShichosonIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 合併市町村の新規作成時に使用します。
     *
     * @param 合併年月日 合併年月日
     * @param 地域番号 地域番号
     * @param 旧市町村コード 旧市町村コード
     */
    public GappeiShichoson(FlexibleDate 合併年月日,
            RString 地域番号,
            LasdecCode 旧市町村コード) {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));
        this.entity = new DbT7056GappeiShichosonEntity();
        this.entity.setGappeiYMD(合併年月日);
        this.entity.setChiikiNo(地域番号);
        this.entity.setKyuShichosonCode(旧市町村コード);
        this.id = new GappeiShichosonIdentifier(
                合併年月日,
                地域番号,
                旧市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7056GappeiShichosonEntity}より{@link GappeiShichoson}を生成します。
     *
     * @param entity DBより取得した{@link DbT7056GappeiShichosonEntity}
     */
    public GappeiShichoson(DbT7056GappeiShichosonEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村"));
        this.id = new GappeiShichosonIdentifier(
                entity.getGappeiYMD(),
                entity.getChiikiNo(),
                entity.getKyuShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7056GappeiShichosonEntity}
     * @param id {@link GappeiShichosonIdentifier}
     */
    GappeiShichoson(
            DbT7056GappeiShichosonEntity entity,
            GappeiShichosonIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 合併年月日を返します。
     *
     * @return 合併年月日
     */
    public FlexibleDate get合併年月日() {
        return entity.getGappeiYMD();
    }

    /**
     * 地域番号を返します。
     *
     * @return 地域番号
     */
    public RString get地域番号() {
        return entity.getChiikiNo();
    }

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 運用開始年月日を返します。
     *
     * @return 運用開始年月日
     */
    public FlexibleDate get運用開始年月日() {
        return entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了年月日を返します。
     *
     * @return 運用終了年月日
     */
    public FlexibleDate get運用終了年月日() {
        return entity.getUnyoShuryoYMD();
    }

    /**
     * 旧保険者番号を返します。
     *
     * @return 旧保険者番号
     */
    public HokenshaNo get旧保険者番号() {
        return entity.getKyuHokenshaNo();
    }

    /**
     * 旧市町村名称を返します。
     *
     * @return 旧市町村名称
     */
    public RString get旧市町村名称() {
        return entity.getKyuShichosonMeisho();
    }

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    public RString get郡名称() {
        return entity.getGunMeisho();
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
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 表示有無を返します。
     *
     * @return 表示有無
     */
    public RString get表示有無() {
        return entity.getHyojiUmu();
    }

    /**
     * {@link DbT7056GappeiShichosonEntity}のクローンを返します。
     *
     * @return {@link DbT7056GappeiShichosonEntity}のクローン
     */
    @Override
    public DbT7056GappeiShichosonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 合併市町村の識別子{@link GappeiShichosonIdentifier}を返します。
     *
     * @return 合併市町村の識別子{@link GappeiShichosonIdentifier}
     */
    @Override
    public GappeiShichosonIdentifier identifier() {
        return this.id;
    }

    /**
     * 合併市町村のみを変更対象とします。<br/> {@link DbT7056GappeiShichosonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GappeiShichoson}
     */
    public GappeiShichoson modifiedModel() {
        DbT7056GappeiShichosonEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GappeiShichoson(
                modifiedEntity, id);
    }

    /**
     * 保持する合併市町村を削除対象とします。<br/>
     * {@link DbT7056GappeiShichosonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GappeiShichoson}
     */
    @Override
    public GappeiShichoson deleted() {
        DbT7056GappeiShichosonEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GappeiShichoson(deletedEntity, id);
    }

    /**
     * {@link GappeiShichoson}のシリアライズ形式を提供します。
     *
     * @return {@link GappeiShichoson}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -4221720727880961678L;
        private final DbT7056GappeiShichosonEntity entity;
        private final GappeiShichosonIdentifier id;

        private _SerializationProxy(DbT7056GappeiShichosonEntity entity, GappeiShichosonIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GappeiShichoson(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link GappeiShichosonBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GappeiShichosonBuilder createBuilderForEdit() {
        return new GappeiShichosonBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final GappeiShichoson other = (GappeiShichoson) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
