/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護所得Aliveを管理するクラスです。
 */
public class KaigoShotokuAlive
        extends ParentModelBase<KaigoShotokuAliveIdentifier, DbV2502KaigoShotokuEntity, KaigoShotokuAlive>
        implements Serializable {

    private final DbV2502KaigoShotokuEntity entity;
    private final KaigoShotokuAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV2502KaigoShotokuEntity}より{@link KaigoShotokuAlive}を生成します。
     *
     * @param entity DBより取得した{@link DbV2502KaigoShotokuEntity}
     */
    public KaigoShotokuAlive(DbV2502KaigoShotokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護所得Alive"));
        this.id = new KaigoShotokuAliveIdentifier();
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV2502KaigoShotokuEntity}
     * @param id {@link KaigoShotokuAliveIdentifier}
     */
    KaigoShotokuAlive(DbV2502KaigoShotokuEntity entity, KaigoShotokuAliveIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 所得年度を返します。
     *
     * @return 所得年度
     */
    public FlexibleYear get所得年度() {
        return entity.getShotokuNendo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 課税区分_住民税減免前を返します。
     *
     * @return 課税区分_住民税減免前
     */
    public RString get課税区分_住民税減免前() {
        return entity.getKazeiKubun();
    }

    /**
     * 課税区分_住民税減免後を返します。
     *
     * @return 課税区分_住民税減免後
     */
    public RString get課税区分_住民税減免後() {
        return entity.getKazeiKubunGemmenGo();
    }

    /**
     * 激変緩和措置を返します。
     *
     * @return 激変緩和措置
     */
    public RString get激変緩和措置() {
        return entity.getGekihenKanwaKubun();
    }

    /**
     * 合計所得金額を返します。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return entity.getGokeiShotokuGaku();
    }

    /**
     * 年金収入額を返します。
     *
     * @return 年金収入額
     */
    public Decimal get年金収入額() {
        return entity.getNenkiniShunyuGaku();
    }

    /**
     * 年金所得額を返します。
     *
     * @return 年金所得額
     */
    public Decimal get年金所得額() {
        return entity.getNenkiniShotokuGaku();
    }

    /**
     * 課税所得額を返します。
     *
     * @return 課税所得額
     */
    public Decimal get課税所得額() {
        return entity.getKazeiShotokuGaku();
    }

    /**
     * 登録業務を返します。
     *
     * @return 登録業務
     */
    public RString get登録業務() {
        return new RString(String.valueOf(entity.getTorokuGyomu()));
    }

    /**
     * 更正日を返します。
     *
     * @return 更正日
     */
    public YMDHMS get更正日() {
        return entity.getShoriTimeStamp();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return new Decimal(entity.getRirekiNo());
    }

    /**
     * {@link DbV2502KaigoShotokuEntity}のクローンを返します。
     *
     * @return {@link DbV2502KaigoShotokuEntity}のクローン
     */
    @Override
    public DbV2502KaigoShotokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 資格検索Aliveの識別子{@link KaigoShotokuAliveIdentifier}を返します。
     *
     * @return 資格検索Aliveの識別子{@link KaigoShotokuAliveIdentifier}
     */
    @Override
    public KaigoShotokuAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 資格検索Aliveのみを変更対象とします。<br/>
     * {@link DbV2502KaigoShotokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShikakuSearchAlive}
     */
    @Override
    public KaigoShotokuAlive modifiedModel() {
        DbV2502KaigoShotokuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoShotokuAlive(modifiedEntity, id);
    }

    /**
     * 保持する資格検索Aliveを削除対象とします。<br/>
     * {@link DbV2502KaigoShotokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShikakuSearchAlive}
     */
    @Override
    public KaigoShotokuAlive deleted() {
        DbV2502KaigoShotokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoShotokuAlive(deletedEntity, id);
    }

    /**
     * {@link ShikakuSearchAlive}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoShotokuAlive}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L; // TODO serialVersionUIDを生成してください
        private final DbV2502KaigoShotokuEntity entity;
        private final KaigoShotokuAliveIdentifier id;

        private _SerializationProxy(DbV2502KaigoShotokuEntity entity, KaigoShotokuAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoShotokuAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoShotokuAliveBuilder createBuilderForEdit() {
        return new KaigoShotokuAliveBuilder(entity, id);
    }
}
