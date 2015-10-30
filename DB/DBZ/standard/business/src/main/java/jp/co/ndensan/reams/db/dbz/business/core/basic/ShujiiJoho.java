/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医情報を管理するクラスです。
 */
public class ShujiiJoho extends ParentModelBase<ShujiiJohoIdentifier, DbT5912ShujiiJohoEntity, ShujiiJoho> implements Serializable {

    private final DbT5912ShujiiJohoEntity entity;
    private final ShujiiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 主治医情報の新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     */
    public ShujiiJoho(LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード,
            ShujiiCode 主治医コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        this.entity = new DbT5912ShujiiJohoEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setShujiiIryokikanCode(主治医医療機関コード);
        this.entity.setShujiiCode(主治医コード);
        this.id = new ShujiiJohoIdentifier(
                市町村コード,
                主治医医療機関コード,
                主治医コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5912ShujiiJohoEntity}より{@link ShujiiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5912ShujiiJohoEntity}
     */
    public ShujiiJoho(DbT5912ShujiiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報"));
        this.id = new ShujiiJohoIdentifier(
                entity.getShichosonCode(),
                entity.getShujiiIryokikanCode(),
                entity.getShujiiCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5912ShujiiJohoEntity}
     * @param id {@link ShujiiJohoIdentifier}
     */
    ShujiiJoho(
            DbT5912ShujiiJohoEntity entity,
            ShujiiJohoIdentifier id
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
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public ShujiiCode get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public AtenaMeisho get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 主治医カナを返します。
     *
     * @return 主治医カナ
     */
    public AtenaKanaMeisho get主治医カナ() {
        return entity.getShujiiKana();
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
    public AtenaJusho get住所() {
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
     * 診療科名称を返します。
     *
     * @return 診療科名称
     */
    public RString get診療科名称() {
        return entity.getShinryokaName();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.getShiteiiFlag();
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
     * {@link DbT5912ShujiiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5912ShujiiJohoEntity}のクローン
     */
    @Override
    public DbT5912ShujiiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 主治医情報の識別子{@link ShujiiJohoIdentifier}を返します。
     *
     * @return 主治医情報の識別子{@link ShujiiJohoIdentifier}
     */
    @Override
    public ShujiiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 主治医情報のみを変更対象とします。<br/>
     * {@link DbT5912ShujiiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiJoho}
     */
    @Override
    public ShujiiJoho modifiedModel() {
        DbT5912ShujiiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する主治医情報を削除対象とします。<br/>
     * {@link DbT5912ShujiiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiJoho}
     */
    @Override
    public ShujiiJoho deleted() {
        DbT5912ShujiiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiJoho(deletedEntity, id);
    }

    /**
     * {@link ShujiiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiJoho}のシリアライズ形式
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
        private final DbT5912ShujiiJohoEntity entity;
        private final ShujiiJohoIdentifier id;

        private _SerializationProxy(DbT5912ShujiiJohoEntity entity, ShujiiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiJohoBuilder createBuilderForEdit() {
        return new ShujiiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
