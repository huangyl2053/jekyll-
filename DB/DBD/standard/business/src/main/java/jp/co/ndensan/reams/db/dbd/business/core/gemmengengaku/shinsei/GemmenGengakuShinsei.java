/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 減免減額申請を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class GemmenGengakuShinsei
        extends ModelBase<GemmenGengakuShinseiIdentifier, DbT4010GemmenGengakuShinseiEntity, GemmenGengakuShinsei>
        implements Serializable {

    private final DbT4010GemmenGengakuShinseiEntity entity;
    private final GemmenGengakuShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 減免減額申請の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     */
    public GemmenGengakuShinsei(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 減免減額種類,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4010GemmenGengakuShinseiEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setGemmenGengakuShurui(減免減額種類);
        this.entity.setShinseiRirekiNo(履歴番号);
        this.id = new GemmenGengakuShinseiIdentifier(
                証記載保険者番号,
                被保険者番号,
                減免減額種類,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4010GemmenGengakuShinseiEntity}より{@link GemmenGengakuShinsei}を生成します。
     *
     * @param entity DBより取得した{@link DbT4010GemmenGengakuShinseiEntity}
     */
    public GemmenGengakuShinsei(DbT4010GemmenGengakuShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額申請"));
        this.id = new GemmenGengakuShinseiIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getGemmenGengakuShurui(),
                entity.getShinseiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4010GemmenGengakuShinseiEntity}
     * @param id {@link GemmenGengakuShinseiIdentifier}
     */
    GemmenGengakuShinsei(
            DbT4010GemmenGengakuShinseiEntity entity,
            GemmenGengakuShinseiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 減免減額種類を返します。
     *
     * @return 減免減額種類
     */
    public RString get減免減額種類() {
        return entity.getGemmenGengakuShurui();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getShinseiRirekiNo();
    }

    /**
     * 申請届出代行区分を返します。
     *
     * @return 申請届出代行区分
     */
    public RString get申請届出代行区分() {
        return entity.getShinseiTodokedeDaikoKubun();
    }

    /**
     * 申請届出者氏名を返します。
     *
     * @return 申請届出者氏名
     */
    public AtenaMeisho get申請届出者氏名() {
        return entity.getShinseiTodokedeshaShimei();
    }

    /**
     * 申請届出者氏名カナを返します。
     *
     * @return 申請届出者氏名カナ
     */
    public AtenaKanaMeisho get申請届出者氏名カナ() {
        return entity.getShinseiTodokedeshaKanaShimei();
    }

    /**
     * 申請届出者続柄を返します。
     *
     * @return 申請届出者続柄
     */
    public RString get申請届出者続柄() {
        return entity.getShinseiTodokedeshaTsuzukigara();
    }

    /**
     * 申請届出代行事業者番号を返します。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo get申請届出代行事業者番号() {
        return entity.getShinseiTodokedeDaikoJigyoshaNo();
    }

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.getJigyoshaKubun();
    }

    /**
     * 申請届出者郵便番号を返します。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo get申請届出者郵便番号() {
        return entity.getShinseiTodokedeshaYubinNo();
    }

    /**
     * 申請届出者住所を返します。
     *
     * @return 申請届出者住所
     */
    public AtenaJusho get申請届出者住所() {
        return entity.getShinseiTodokedeshaJusho();
    }

    /**
     * 申請届出者電話番号を返します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.getShinseiTodokedeshaTelNo();
    }

    /**
     * {@link DbT4010GemmenGengakuShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT4010GemmenGengakuShinseiEntity}のクローン
     */
    @Override
    public DbT4010GemmenGengakuShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 減免減額申請の識別子{@link GemmenGengakuShinseiIdentifier}を返します。
     *
     * @return 減免減額申請の識別子{@link GemmenGengakuShinseiIdentifier}
     */
    @Override
    public GemmenGengakuShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 減免減額申請のみを変更対象とします。<br/> {@link DbT4010GemmenGengakuShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GemmenGengakuShinsei}
     */
    public GemmenGengakuShinsei modifiedModel() {
        DbT4010GemmenGengakuShinseiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GemmenGengakuShinsei(
                modifiedEntity, id);
    }

    /**
     * 減免減額申請のみを変更対象とします。<br/> {@link DbT4010GemmenGengakuShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GemmenGengakuShinsei}
     */
    public GemmenGengakuShinsei added() {
        DbT4010GemmenGengakuShinseiEntity addedEntity = entity.clone();
        if (!addedEntity.getState().equals(EntityDataState.Deleted)) {
            addedEntity.setState(EntityDataState.Added);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GemmenGengakuShinsei(
                addedEntity, id);
    }

    /**
     * 保持する減免減額申請を削除対象とします。<br/> {@link DbT4010GemmenGengakuShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GemmenGengakuShinsei}
     */
    @Override
    public GemmenGengakuShinsei deleted() {
        DbT4010GemmenGengakuShinseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GemmenGengakuShinsei(deletedEntity, id);
    }

    /**
     * {@link GemmenGengakuShinsei}のシリアライズ形式を提供します。
     *
     * @return {@link GemmenGengakuShinsei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5913859297067475692L;
        private final DbT4010GemmenGengakuShinseiEntity entity;
        private final GemmenGengakuShinseiIdentifier id;

        private _SerializationProxy(DbT4010GemmenGengakuShinseiEntity entity, GemmenGengakuShinseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GemmenGengakuShinsei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GemmenGengakuShinseiBuilder createBuilderForEdit() {
        return new GemmenGengakuShinseiBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final GemmenGengakuShinsei other = (GemmenGengakuShinsei) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
