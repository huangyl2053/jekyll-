/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 証交付回収を管理するクラスです。
 */
public class ShoKofuKaishu extends ParentModelBase<ShoKofuKaishuIdentifier, DbT7037ShoKofuKaishuEntity, ShoKofuKaishu> implements Serializable {

    private final DbT7037ShoKofuKaishuEntity entity;
    private final ShoKofuKaishuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 証交付回収の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 交付証種類 交付証種類
     * @param 履歴番号 履歴番号
     */
    public ShoKofuKaishu(HihokenshaNo 被保険者番号,
            RString 交付証種類,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7037ShoKofuKaishuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKofuShoShurui(交付証種類);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShoKofuKaishuIdentifier(
                被保険者番号,
                交付証種類,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7037ShoKofuKaishuEntity}より{@link ShoKofuKaishu}を生成します。
     *
     * @param entity DBより取得した{@link DbT7037ShoKofuKaishuEntity}
     */
    public ShoKofuKaishu(DbT7037ShoKofuKaishuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収"));
        this.id = new ShoKofuKaishuIdentifier(
                entity.getHihokenshaNo(),
                entity.getKofuShoShurui(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7037ShoKofuKaishuEntity}
     * @param id {@link ShoKofuKaishuIdentifier}
     */
    ShoKofuKaishu(
            DbT7037ShoKofuKaishuEntity entity,
            ShoKofuKaishuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 交付証種類を返します。
     *
     * @return 交付証種類
     */
    public RString get交付証種類() {
        return entity.getKofuShoShurui();
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
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
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return entity.getKofuYMD();
    }

    /**
     * 有効期限を返します。
     *
     * @return 有効期限
     */
    public FlexibleDate get有効期限() {
        return entity.getYukoKigenYMD();
    }

    /**
     * 交付事由を返します。
     *
     * @return 交付事由
     */
    public RString get交付事由() {
        return entity.getKofuJiyu();
    }

    /**
     * 交付理由を返します。
     *
     * @return 交付理由
     */
    public RString get交付理由() {
        return entity.getKofuRiyu();
    }

    /**
     * 回収年月日を返します。
     *
     * @return 回収年月日
     */
    public FlexibleDate get回収年月日() {
        return entity.getKaishuYMD();
    }

    /**
     * 回収事由を返します。
     *
     * @return 回収事由
     */
    public RString get回収事由() {
        return entity.getKaishuJiyu();
    }

    /**
     * 回収理由を返します。
     *
     * @return 回収理由
     */
    public RString get回収理由() {
        return entity.getKaishuRiyu();
    }

    /**
     * 単票発行有無フラグを返します。
     *
     * @return 単票発行有無フラグ
     */
    public boolean get単票発行有無フラグ() {
        return entity.getTanpyoHakkoUmuFlag();
    }

    /**
     * 発行処理日時を返します。
     *
     * @return 発行処理日時
     */
    public YMDHMS get発行処理日時() {
        return entity.getHakkoShoriTimestamp();
    }

    /**
     * 新様式印書済区分コードを返します。
     *
     * @return 新様式印書済区分コード
     */
    public RString get新様式印書済区分コード() {
        return entity.getShinYoshikiSumiKubunCode();
    }

    /**
     * 証様式区分コードを返します。
     *
     * @return 証様式区分コード
     */
    public RString get証様式区分コード() {
        return entity.getShoYoshikiKubunCode();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT7037ShoKofuKaishuEntity}のクローンを返します。
     *
     * @return {@link DbT7037ShoKofuKaishuEntity}のクローン
     */
    @Override
    public DbT7037ShoKofuKaishuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 証交付回収の識別子{@link ShoKofuKaishuIdentifier}を返します。
     *
     * @return 証交付回収の識別子{@link ShoKofuKaishuIdentifier}
     */
    @Override
    public ShoKofuKaishuIdentifier identifier() {
        return this.id;
    }

    /**
     * 証交付回収のみを変更対象とします。<br/>
     * {@link DbT7037ShoKofuKaishuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShoKofuKaishu}
     */
    @Override
    public ShoKofuKaishu modifiedModel() {
        DbT7037ShoKofuKaishuEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShoKofuKaishu(
                modifiedEntity, id);
    }

    /**
     * 保持する証交付回収を削除対象とします。<br/>
     * {@link DbT7037ShoKofuKaishuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShoKofuKaishu}
     */
    @Override
    public ShoKofuKaishu deleted() {
        DbT7037ShoKofuKaishuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShoKofuKaishu(deletedEntity, id);
    }

    /**
     * {@link ShoKofuKaishu}のシリアライズ形式を提供します。
     *
     * @return {@link ShoKofuKaishu}のシリアライズ形式
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
        private final DbT7037ShoKofuKaishuEntity entity;
        private final ShoKofuKaishuIdentifier id;

        private _SerializationProxy(DbT7037ShoKofuKaishuEntity entity, ShoKofuKaishuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShoKofuKaishu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShoKofuKaishuBuilder createBuilderForEdit() {
        return new ShoKofuKaishuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
