/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会委員所属機関情報を管理するクラスです。
 */
public class KaigoNinteiShinsakaiIinShozokuKikanJoho extends ModelBase<KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier, DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity, KaigoNinteiShinsakaiIinShozokuKikanJoho> implements Serializable {

    private final DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity;
    private final KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会委員所属機関情報の新規作成時に使用します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 連番 連番
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJoho(RString 介護認定審査会委員コード,
            int 連番) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity();
        this.entity.setShinsakaiIinCode(介護認定審査会委員コード);
        this.entity.setRemban(連番);
        this.id = new KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier(
                介護認定審査会委員コード,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}より{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJoho(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員所属機関情報"));
        this.id = new KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier(
                entity.getShinsakaiIinCode(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}
     * @param id {@link KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier}
     */
    KaigoNinteiShinsakaiIinShozokuKikanJoho(
            DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity,
            KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護認定審査会委員コードを返します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRemban();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * その他機関コードを返します。
     *
     * @return その他機関コード
     */
    public RString getその他機関コード() {
        return entity.getSonotaKikanCode();
    }

    /**
     * {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}のクローン
     */
    @Override
    public DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会委員所属機関情報の識別子{@link KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier}を返します。
     *
     * @return 介護認定審査会委員所属機関情報の識別子{@link KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier}
     */
    @Override
    public KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会委員所属機関情報のみを変更対象とします。<br/>
     * {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJoho modifiedModel() {
        DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoNinteiShinsakaiIinShozokuKikanJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会委員所属機関情報を削除対象とします。<br/>
     * {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}
     */
    @Override
    public KaigoNinteiShinsakaiIinShozokuKikanJoho deleted() {
        DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoNinteiShinsakaiIinShozokuKikanJoho(deletedEntity, id);
    }

    /**
     * {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    /**
     * 保持する{@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}の{@link EntityDataState#Unchanged}以外であればtrueを返す。
     *
     * @return
     * 保持する{@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}の{@link EntityDataState#Unchanged}以外:true
     * それ以外:false
     */
    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 4041339883705665377L;

        private final DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity;
        private final KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier id;

        private _SerializationProxy(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity, KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoNinteiShinsakaiIinShozokuKikanJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder createBuilderForEdit() {
        return new KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final KaigoNinteiShinsakaiIinShozokuKikanJoho other = (KaigoNinteiShinsakaiIinShozokuKikanJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
