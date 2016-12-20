/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医医療機関情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShujiiIryoKikanJoho
        extends ModelBase<ShujiiIryoKikanJohoIdentifier, DbT5911ShujiiIryoKikanJohoEntity, ShujiiIryoKikanJoho>
        implements Serializable {

    private final DbT5911ShujiiIryoKikanJohoEntity entity;
    private final ShujiiIryoKikanJohoIdentifier id;
    private final Models<ShujiiJohoIdentifier, ShujiiJoho> shujiiJoho;

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
        this.shujiiJoho = Models.create(new ArrayList<ShujiiJoho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5911ShujiiIryoKikanJohoEntity}より{@link ShujiiIryoKikanJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5911ShujiiIryoKikanJohoEntity}
     */
    public ShujiiIryoKikanJoho(ShujiiIryoKikanJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get主治医医療機関情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報"));
        this.id = new ShujiiIryoKikanJohoIdentifier(
                entity.get主治医医療機関情報Entity().getShichosonCode(),
                entity.get主治医医療機関情報Entity().getShujiiIryokikanCode());

        List<ShujiiJoho> shujiiJohoList = new ArrayList<>();
        for (DbT5912ShujiiJohoEntity shujiiJohoEntity : entity.get主治医情報Entity()) {
            shujiiJohoList.add(new ShujiiJoho(shujiiJohoEntity));
        }
        this.shujiiJoho = Models.create(shujiiJohoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5911ShujiiIryoKikanJohoEntity}
     * @param id {@link ShujiiIryoKikanJohoIdentifier}
     */
    ShujiiIryoKikanJoho(
            DbT5911ShujiiIryoKikanJohoEntity entity,
            ShujiiIryoKikanJohoIdentifier id,
            Models<ShujiiJohoIdentifier, ShujiiJoho> shujiiJoho
    ) {
        this.entity = entity;
        this.id = id;
        this.shujiiJoho = shujiiJoho;
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
    public RString get代表者名() {
        return entity.getDaihyoshaName();
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
     * 主治医医療機関情報配下の要素を削除対象とします。<br/> {@link DbT5911ShujiiIryoKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 主治医医療機関情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link ShujiiIryoKikanJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link ShujiiIryoKikanJoho}
     * @throws IllegalStateException DbT5911ShujiiIryoKikanJohoEntityのデータ状態が変更の場合
     */
    @Override
    public ShujiiIryoKikanJoho deleted() {
        DbT5911ShujiiIryoKikanJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIryoKikanJoho(
                deletedEntity, id, shujiiJoho.deleted());
    }

    @Override
    public boolean hasChanged() {

        return hasChangedEntity() || shujiiJoho.hasAnyChanged();

    }

    /**
     * 主治医医療機関情報のみを変更対象とします。<br/> {@link DbT5911ShujiiIryoKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIryoKikanJoho}
     */
    public ShujiiIryoKikanJoho modifiedModel() {
        DbT5911ShujiiIryoKikanJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIryoKikanJoho(
                modifiedEntity, id, shujiiJoho);
    }

    /**
     * 主治医医療機関情報が保持する主治医情報に対して、指定の識別子に該当する主治医情報を返します。
     *
     * @param id 主治医情報の識別子
     * @return 主治医情報
     * @throws IllegalStateException 指定の識別子に該当する主治医情報がない場合
     */
    public ShujiiJoho getShujiiJoho(ShujiiJohoIdentifier id) {
        if (shujiiJoho.contains(id)) {
            return shujiiJoho.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 主治医医療機関情報が保持する主治医情報をリストで返します。
     *
     * @return 主治医情報リスト
     */
    public List<ShujiiJoho> getShujiiJohoList() {
        return new ArrayList<>(shujiiJoho.values());
    }

    /**
     * {@link ShujiiIryoKikanJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIryoKikanJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shujiiJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5911ShujiiIryoKikanJohoEntity entity;
        private final ShujiiIryoKikanJohoIdentifier id;
        private final Models<ShujiiJohoIdentifier, ShujiiJoho> shujiiJoho;

        private _SerializationProxy(
                DbT5911ShujiiIryoKikanJohoEntity entity,
                ShujiiIryoKikanJohoIdentifier id,
                Models<ShujiiJohoIdentifier, ShujiiJoho> shujiiJoho
        ) {
            this.entity = entity;
            this.id = id;
            this.shujiiJoho = shujiiJoho;
        }

        private Object readResolve() {
            return new ShujiiIryoKikanJoho(this.entity, this.id, this.shujiiJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShujiiIryoKikanJohoBuilder#build()}を使用してください。
     *
     * @return {@link ShujiiIryoKikanJohoBuilder}
     */
    public ShujiiIryoKikanJohoBuilder createBuilderForEdit() {
        return new ShujiiIryoKikanJohoBuilder(entity, id, shujiiJoho);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final ShujiiIryoKikanJoho other = (ShujiiIryoKikanJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
