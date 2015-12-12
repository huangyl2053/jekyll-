/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson.GappeiShichosonIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiJohoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合併情報を管理するクラスです。
 */
public class GappeiJoho extends ParentModelBase<GappeiJohoIdentifier, DbT7055GappeiJohoEntity, GappeiJoho> implements Serializable {

    private static final long serialVersionUID = -4878571272595491588L;

    private final DbT7055GappeiJohoEntity entity;
    private final GappeiJohoIdentifier id;
    private final Models<GappeiShichosonIdentifier, GappeiShichoson> gappeiShichoson;

    /**
     * コンストラクタです。<br/>
     * 合併情報の新規作成時に使用します。
     *
     * @param 合併年月日 合併年月日
     * @param 地域番号 地域番号
     */
    public GappeiJoho(FlexibleDate 合併年月日,
            RString 地域番号) {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        this.entity = new DbT7055GappeiJohoEntity();
        this.entity.setGappeiYMD(合併年月日);
        this.entity.setChiikiNo(地域番号);
        this.id = new GappeiJohoIdentifier(
                合併年月日,
                地域番号
        );
        this.gappeiShichoson = Models.create(new ArrayList<GappeiShichoson>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7055GappeiJohoEntity}より{@link GappeiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT7055GappeiJohoEntity}
     */
    public GappeiJoho(GappeiJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get合併情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        this.id = new GappeiJohoIdentifier(
                entity.get合併情報Entity().getGappeiYMD(),
                entity.get合併情報Entity().getChiikiNo());

        List<GappeiShichoson> gappeiShichosonList = new ArrayList<>();
        for (DbT7056GappeiShichosonEntity niniEntity : entity.get合併市町村Entity()) {
            gappeiShichosonList.add(new GappeiShichoson(niniEntity));
        }
        this.gappeiShichoson = Models.create(gappeiShichosonList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7055GappeiJohoEntity}
     * @param id {@link GappeiJohoIdentifier}
     */
    GappeiJoho(
            DbT7055GappeiJohoEntity entity,
            GappeiJohoIdentifier id,
            Models<GappeiShichosonIdentifier, GappeiShichoson> gappeiShichoson
    ) {
        this.entity = entity;
        this.id = id;
        this.gappeiShichoson = gappeiShichoson;
    }

    /**
     * 合併年月日を返します。
     *
     * @return 合併年月日
     */
    public FlexibleDate get合併年月日() {
        return entity.getGappeiYMD();
    }

    /**
     * 地域番号を返します。
     *
     * @return 地域番号
     */
    public RString get地域番号() {
        return entity.getChiikiNo();
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
     * 合併種類を返します。
     *
     * @return 合併種類
     */
    public RString get合併種類() {
        return entity.getGappeiShurui();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 旧市町村情報付与終了年月日を返します。
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate get旧市町村情報付与終了年月日() {
        return entity.getKyuJohoFuyoToYMD();
    }

    /**
     * 国保連データ連携開始年月日を返します。
     *
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate get国保連データ連携開始年月日() {
        return entity.getKokuhorenDataFromYMD();
    }

    /**
     * {@link DbT7055GappeiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT7055GappeiJohoEntity}のクローン
     */
    @Override
    public DbT7055GappeiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 合併情報の識別子{@link GappeiJohoIdentifier}を返します。
     *
     * @return 合併情報の識別子{@link GappeiJohoIdentifier}
     */
    @Override
    public GappeiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 合併情報のみを変更対象とします。<br/>
     * {@link DbT7055GappeiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GappeiJoho}
     */
    @Override
    public GappeiJoho modifiedModel() {
        DbT7055GappeiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GappeiJoho(
                modifiedEntity, id, gappeiShichoson);
    }

    /**
     * 合併情報配下の要素を削除対象とします。<br/>
     * {@link DbT7055GappeiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 合併情報配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link GappeiJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link GappeiJoho}
     * @throws IllegalStateException DbT7055GappeiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public GappeiJoho deleted() {
        DbT7055GappeiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GappeiJoho(deletedEntity, id, gappeiShichoson.deleted());
    }

    /**
     * {@link GappeiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link GappeiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gappeiShichoson);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gappeiShichoson.hasAnyChanged();
    }

    /**
     * 合併情報が保持する合併市町村情報に対して、指定の識別子に該当する合併市町村情報を返します。
     *
     * @param id 合併市町村情報の識別子
     * @return 合併市町村情報
     * @throws IllegalStateException 指定の識別子に該当する合併市町村情報がない場合
     */
    public GappeiShichoson getGappeiShichoson(GappeiShichosonIdentifier id) {
        if (gappeiShichoson.contains(id)) {
            return gappeiShichoson.clone().get(id);
        }

        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 合併情報が保持する合併市町村情報をリストで返します。
     *
     * @return 合併市町村情報リスト
     */
    public List<GappeiShichoson> getGappeiShichosonList() {
        return new ArrayList<>(gappeiShichoson.values());
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -6759729045529889408L;

        private final DbT7055GappeiJohoEntity entity;
        private final GappeiJohoIdentifier id;

        private final Models<GappeiShichosonIdentifier, GappeiShichoson> gappeiShichoson;

        private _SerializationProxy(
                DbT7055GappeiJohoEntity entity,
                GappeiJohoIdentifier id,
                Models<GappeiShichosonIdentifier, GappeiShichoson> gappeiShichoson
        ) {
            this.entity = entity;
            this.id = id;
            this.gappeiShichoson = gappeiShichoson;
        }

        private Object readResolve() {
            return new GappeiJoho(this.entity, this.id, this.gappeiShichoson);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link GappeiJohoBuilder#build()}を使用してください。
     *
     * @return {@link GappeiJohoBuilder}
     */
    public GappeiJohoBuilder createBuilderForEdit() {
        return new GappeiJohoBuilder(entity, id, gappeiShichoson);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final GappeiJoho other = (GappeiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
