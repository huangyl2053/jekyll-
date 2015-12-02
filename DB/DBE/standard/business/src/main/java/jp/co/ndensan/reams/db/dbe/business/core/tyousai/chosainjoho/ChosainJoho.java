/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査員情報を管理するクラスです。
 */
public class ChosainJoho extends ModelBase<ChosainJohoIdentifier, DbT5913ChosainJohoEntity, ChosainJoho> implements Serializable {

    private static final long serialVersionUID = 1471570426779306781L;

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
            RString 認定調査委託先コード,
            RString 認定調査員コード) {
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
     * 所属機関名称を返します。
     *
     * @return 所属機関名称
     */
    public RString get所属機関名称() {
        return entity.getShozokuKikanName();
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
    public ChosainJoho modifiedModel() {
        DbT5913ChosainJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
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
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1471570426779306781L;
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
        final ChosainJoho other = (ChosainJoho) obj;
        return Objects.equals(this.id, other.id);
    }

}
