/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医医療機関情報を管理するクラスです。
 */
public class ShujiiIryoKikanJoho extends
        ModelBase<ShujiiIryoKikanJohoIdentifier, DbT5911ShujiiIryoKikanJohoEntity, ShujiiIryoKikanJoho> implements Serializable {

    private final DbT5911ShujiiIryoKikanJohoEntity entity;
    private final ShujiiIryoKikanJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 主治医医療機関情報の新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     */
    public ShujiiIryoKikanJoho(LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        this.entity = new DbT5911ShujiiIryoKikanJohoEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setShujiiIryokikanCode(主治医医療機関コード);
        this.id = new ShujiiIryoKikanJohoIdentifier(
                市町村コード,
                主治医医療機関コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5911ShujiiIryoKikanJohoEntity}より{@link ShujiiIryoKikanJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5911ShujiiIryoKikanJohoEntity}
     */
    public ShujiiIryoKikanJoho(DbT5911ShujiiIryoKikanJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報"));
        this.id = new ShujiiIryoKikanJohoIdentifier(
                entity.getShichosonCode(),
                entity.getShujiiIryokikanCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5911ShujiiIryoKikanJohoEntity}
     * @param id {@link ShujiiIryoKikanJohoIdentifier}
     */
    ShujiiIryoKikanJoho(
            DbT5911ShujiiIryoKikanJohoEntity entity,
            ShujiiIryoKikanJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public ShujiiIryokikanCode get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    public IryoKikanCode get医療機関コード() {
        return entity.getIryokikanCode();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 医療機関名称カナを返します。
     *
     * @return 医療機関名称カナ
     */
    public RString get医療機関名称カナ() {
        return entity.getIryoKikanMeishoKana();
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
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
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
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    public AtenaMeisho get代表者名() {
        return new AtenaMeisho(entity.getDaihyoshaName());
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    public boolean is状況フラグ() {
        return entity.getJokyoFlag();
    }

    /**
     * {@link DbT5911ShujiiIryoKikanJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5911ShujiiIryoKikanJohoEntity}のクローン
     */
    @Override
    public DbT5911ShujiiIryoKikanJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 主治医医療機関情報の識別子{@link ShujiiIryoKikanJohoIdentifier}を返します。
     *
     * @return 主治医医療機関情報の識別子{@link ShujiiIryoKikanJohoIdentifier}
     */
    @Override
    public ShujiiIryoKikanJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 主治医医療機関情報のみを変更対象とします。<br/> {@link DbT5911ShujiiIryoKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIryoKikanJoho}
     */
    public ShujiiIryoKikanJoho modifiedModel() {
        DbT5911ShujiiIryoKikanJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIryoKikanJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する主治医医療機関情報を削除対象とします。<br/> {@link DbT5911ShujiiIryoKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIryoKikanJoho}
     */
    @Override
    public ShujiiIryoKikanJoho deleted() {
        DbT5911ShujiiIryoKikanJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIryoKikanJoho(deletedEntity, id);
    }

    /**
     * {@link ShujiiIryoKikanJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIryoKikanJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5911ShujiiIryoKikanJohoEntity entity;
        private final ShujiiIryoKikanJohoIdentifier id;

        private _SerializationProxy(DbT5911ShujiiIryoKikanJohoEntity entity, ShujiiIryoKikanJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIryoKikanJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIryoKikanJohoBuilder createBuilderForEdit() {
        return new ShujiiIryoKikanJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
