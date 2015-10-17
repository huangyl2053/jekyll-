/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査員情報を管理するクラスです。
 */
public class ChosainJoho extends ParentModelBase<ChosainJohoIdentifier, DbT5913ChosainJohoEntity, ChosainJoho> implements Serializable {

    private final DbT5913ChosainJohoEntity entity;
    private final ChosainJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 調査員情報の新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     */
    public ChosainJoho(LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        this.entity = new DbT5913ChosainJohoEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        this.entity.setNinteiChosainNo(認定調査員コード);
        this.id = new ChosainJohoIdentifier(
                市町村コード,
                認定調査委託先コード,
                認定調査員コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5913ChosainJohoEntity}より{@link ChosainJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5913ChosainJohoEntity}
     */
    public ChosainJoho(DbT5913ChosainJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報"));
        this.id = new ChosainJohoIdentifier(
                entity.getShichosonCode(),
                entity.getNinteichosaItakusakiCode(),
                entity.getNinteiChosainNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5913ChosainJohoEntity}
     * @param id {@link ChosainJohoIdentifier}
     */
    ChosainJoho(
            DbT5913ChosainJohoEntity entity,
            ChosainJohoIdentifier id
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
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public RString get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.getChosainShikaku();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 調査可能人数_月を返します。
     *
     * @return 調査可能人数_月
     */
    public int get調査可能人数_月() {
        return entity.getChosaKanoNinzuPerMonth();
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
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    public boolean get状況フラグ() {
        return entity.getJokyoFlag();
    }

    /**
     * {@link DbT5913ChosainJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5913ChosainJohoEntity}のクローン
     */
    @Override
    public DbT5913ChosainJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 調査員情報の識別子{@link ChosainJohoIdentifier}を返します。
     *
     * @return 調査員情報の識別子{@link ChosainJohoIdentifier}
     */
    @Override
    public ChosainJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 調査員情報のみを変更対象とします。<br/>
     * {@link DbT5913ChosainJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChosainJoho}
     */
    @Override
    public ChosainJoho modifiedModel() {
        DbT5913ChosainJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChosainJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する調査員情報を削除対象とします。<br/>
     * {@link DbT5913ChosainJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChosainJoho}
     */
    @Override
    public ChosainJoho deleted() {
        DbT5913ChosainJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChosainJoho(deletedEntity, id);
    }

    /**
     * {@link ChosainJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ChosainJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT5913ChosainJohoEntity entity;
        private final ChosainJohoIdentifier id;

        private _SerializationProxy(DbT5913ChosainJohoEntity entity, ChosainJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChosainJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChosainJohoBuilder createBuilderForEdit() {
        return new ChosainJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
