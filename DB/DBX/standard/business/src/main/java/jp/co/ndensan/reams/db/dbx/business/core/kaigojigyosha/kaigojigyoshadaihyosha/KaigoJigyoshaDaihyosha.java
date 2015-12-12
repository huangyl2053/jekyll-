/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護事業者代表者を管理するクラスです。
 */
public class KaigoJigyoshaDaihyosha extends ModelBase<KaigoJigyoshaDaihyoshaIdentifier, DbT7062KaigoJigyoshaDaihyoshaEntity, KaigoJigyoshaDaihyosha> implements Serializable {

    private final DbT7062KaigoJigyoshaDaihyoshaEntity entity;
    private final KaigoJigyoshaDaihyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護事業者代表者の新規作成時に使用します。
     *
     * @param 事業者番号 事業者番号
     * @param 有効開始日 有効開始日
     */
    public KaigoJigyoshaDaihyosha(KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));
        this.entity = new DbT7062KaigoJigyoshaDaihyoshaEntity();
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYukoKaishiYMD(有効開始日);
        this.id = new KaigoJigyoshaDaihyoshaIdentifier(
                事業者番号,
                有効開始日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7062KaigoJigyoshaDaihyoshaEntity}より{@link KaigoJigyoshaDaihyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT7062KaigoJigyoshaDaihyoshaEntity}
     */
    public KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者代表者"));
        this.id = new KaigoJigyoshaDaihyoshaIdentifier(
                entity.getJigyoshaNo(),
                entity.getYukoKaishiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7062KaigoJigyoshaDaihyoshaEntity}
     * @param id {@link KaigoJigyoshaDaihyoshaIdentifier}
     */
    KaigoJigyoshaDaihyosha(
            DbT7062KaigoJigyoshaDaihyoshaEntity entity,
            KaigoJigyoshaDaihyoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    public AtenaMeisho get代表者名() {
        return entity.getDaihyoshaShimei();
    }

    /**
     * 代表者名カナを返します。
     *
     * @return 代表者名カナ
     */
    public AtenaKanaMeisho get代表者名カナ() {
        return entity.getDaihyoshaKanaShimei();
    }

    /**
     * 代表者郵便番号を返します。
     *
     * @return 代表者郵便番号
     */
    public YubinNo get代表者郵便番号() {
        return entity.getDaihyoshaYubinNo();
    }

    /**
     * 代表者住所を返します。
     *
     * @return 代表者住所
     */
    public AtenaJusho get代表者住所() {
        return entity.getDaihyoshaJusho();
    }

    /**
     * 代表者住所カナを返します。
     *
     * @return 代表者住所カナ
     */
    public RString get代表者住所カナ() {
        return entity.getDaihyoshaKanaJusho();
    }

    /**
     * 代表者役職名を返します。
     *
     * @return 代表者役職名
     */
    public RString get代表者役職名() {
        return entity.getDaihyoshaYakushokuMei();
    }

    /**
     * 開設者名称を返します。
     *
     * @return 開設者名称
     */
    public AtenaMeisho get開設者名称() {
        return entity.getKaisetsushaShimei();
    }

    /**
     * 開設者名称カナを返します。
     *
     * @return 開設者名称カナ
     */
    public AtenaKanaMeisho get開設者名称カナ() {
        return entity.getKaisetsushaKanaShimei();
    }

    /**
     * 開設者郵便番号を返します。
     *
     * @return 開設者郵便番号
     */
    public YubinNo get開設者郵便番号() {
        return entity.getKaisetsushaYubinNo();
    }

    /**
     * 開設者住所を返します。
     *
     * @return 開設者住所
     */
    public AtenaJusho get開設者住所() {
        return entity.getKaisetsushaJusho();
    }

    /**
     * 開設者住所カナを返します。
     *
     * @return 開設者住所カナ
     */
    public RString get開設者住所カナ() {
        return entity.getKaisetsushaKanaJusho();
    }

    /**
     * 開設者電話番号を返します。
     *
     * @return 開設者電話番号
     */
    public TelNo get開設者電話番号() {
        return entity.getKaisetsushaTelNo();
    }

    /**
     * 開設者ＦＡＸ番号を返します。
     *
     * @return 開設者ＦＡＸ番号
     */
    public TelNo get開設者ＦＡＸ番号() {
        return entity.getKaisetsushaFaxNo();
    }

    /**
     * {@link DbT7062KaigoJigyoshaDaihyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT7062KaigoJigyoshaDaihyoshaEntity}のクローン
     */
    @Override
    public DbT7062KaigoJigyoshaDaihyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護事業者代表者の識別子{@link KaigoJigyoshaDaihyoshaIdentifier}を返します。
     *
     * @return 介護事業者代表者の識別子{@link KaigoJigyoshaDaihyoshaIdentifier}
     */
    @Override
    public KaigoJigyoshaDaihyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護事業者代表者のみを変更対象とします。<br/>
     * {@link DbT7062KaigoJigyoshaDaihyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoJigyoshaDaihyosha}
     */
    public KaigoJigyoshaDaihyosha modifiedModel() {
        DbT7062KaigoJigyoshaDaihyoshaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoJigyoshaDaihyosha(
                modifiedEntity, id);
    }

    /**
     * 保持する介護事業者代表者を削除対象とします。<br/>
     * {@link DbT7062KaigoJigyoshaDaihyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoJigyoshaDaihyosha}
     */
    @Override
    public KaigoJigyoshaDaihyosha deleted() {
        DbT7062KaigoJigyoshaDaihyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoJigyoshaDaihyosha(deletedEntity, id);
    }

    /**
     * {@link KaigoJigyoshaDaihyosha}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoJigyoshaDaihyosha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -863592029193124204L;

        private final DbT7062KaigoJigyoshaDaihyoshaEntity entity;
        private final KaigoJigyoshaDaihyoshaIdentifier id;

        private _SerializationProxy(DbT7062KaigoJigyoshaDaihyoshaEntity entity, KaigoJigyoshaDaihyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoJigyoshaDaihyosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoJigyoshaDaihyoshaBuilder createBuilderForEdit() {
        return new KaigoJigyoshaDaihyoshaBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final KaigoJigyoshaDaihyosha other = (KaigoJigyoshaDaihyosha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
