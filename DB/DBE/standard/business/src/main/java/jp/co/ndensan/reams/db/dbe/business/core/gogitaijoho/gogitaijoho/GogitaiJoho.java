/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaiWariateIinJoho.GogitaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合議体情報を管理するクラスです。
 */
public class GogitaiJoho extends ParentModelBase<GogitaiJohoIdentifier, DbT5591GogitaiJohoEntity, GogitaiJoho> implements Serializable {

    private final DbT5591GogitaiJohoEntity entity;
    private final GogitaiJohoIdentifier id;
    private final Models<GogitaiWariateIinJohoIdentifier, GogitaiWariateIinJoho> gogitaiWariateIinJoho;
    private final Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJoho;

    /**
     * コンストラクタです。<br/>
     * 合議体情報の新規作成時に使用します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     */
    public GogitaiJoho(int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        requireNonNull(合議体有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間開始年月日"));
        this.entity = new DbT5591GogitaiJohoEntity();
        this.entity.setGogitaiNo(合議体番号);
        this.entity.setGogitaiYukoKikanKaishiYMD(合議体有効期間開始年月日);
        this.id = new GogitaiJohoIdentifier(
                合議体番号,
                合議体有効期間開始年月日
        );
        this.gogitaiWariateIinJoho = Models.create(new ArrayList<GogitaiWariateIinJoho>());
        this.shinsakaiKaisaiBashoJoho = Models.create(new ArrayList<ShinsakaiKaisaiBashoJoho>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5591GogitaiJohoEntity}より{@link GogitaiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5591GogitaiJohoEntity}
     */
    public GogitaiJoho(GogitaiJohoRelateEntity entity) {
        this.entity = requireNonNull(entity.get合議体情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報"));
        this.id = new GogitaiJohoIdentifier(
                entity.get合議体情報Entity().getGogitaiNo(),
                entity.get合議体情報Entity().getGogitaiYukoKikanKaishiYMD());
        List<GogitaiWariateIinJoho> gogitaiWariateIinJohoList = new ArrayList<>();
        for (GogitaiWariateIinJohoRelateEntity niniEntity : entity.get合議体割当委員情報Entity()) {
            gogitaiWariateIinJohoList.add(new GogitaiWariateIinJoho(niniEntity));
        }
        this.gogitaiWariateIinJoho = Models.create(gogitaiWariateIinJohoList);
        List<ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJohoList = new ArrayList<>();
        for (DbT5592ShinsakaiKaisaiBashoJohoEntity niniEntity : entity.get介護認定審査会開催場所情報Entity()) {
            shinsakaiKaisaiBashoJohoList.add(new ShinsakaiKaisaiBashoJoho(niniEntity));
        }
        this.shinsakaiKaisaiBashoJoho = Models.create(shinsakaiKaisaiBashoJohoList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5591GogitaiJohoEntity}
     * @param id {@link GogitaiJohoIdentifier}
     */
    GogitaiJoho(
            DbT5591GogitaiJohoEntity entity,
            GogitaiJohoIdentifier id, Models<GogitaiWariateIinJohoIdentifier, GogitaiWariateIinJoho> gogitaiWariateIinJoho,
            Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJoho
    ) {
        this.entity = entity;
        this.id = id;
        this.gogitaiWariateIinJoho = gogitaiWariateIinJoho;
        this.shinsakaiKaisaiBashoJoho = shinsakaiKaisaiBashoJoho;
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.getGogitaiMei();
    }

    /**
     * 合議体有効期間開始年月日を返します。
     *
     * @return 合議体有効期間開始年月日
     */
    public FlexibleDate get合議体有効期間開始年月日() {
        return entity.getGogitaiYukoKikanKaishiYMD();
    }

    /**
     * 合議体有効期間終了年月日を返します。
     *
     * @return 合議体有効期間終了年月日
     */
    public FlexibleDate get合議体有効期間終了年月日() {
        return entity.getGogitaiYukoKikanShuryoYMD();
    }

    /**
     * 合議体開始予定時刻を返します。
     *
     * @return 合議体開始予定時刻
     */
    public RString get合議体開始予定時刻() {
        return entity.getGogitaiKaishiYoteiTime();
    }

    /**
     * 合議体終了予定時刻を返します。
     *
     * @return 合議体終了予定時刻
     */
    public RString get合議体終了予定時刻() {
        return entity.getGogitaiShuryoYoteiTime();
    }

    /**
     * 介護認定審査会開催場所コードを返します。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString get介護認定審査会開催場所コード() {
        return entity.getShinsakaiKaisaiBashoCode();
    }

    /**
     * 介護認定審査会予定定員を返します。
     *
     * @return 介護認定審査会予定定員
     */
    public int get介護認定審査会予定定員() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会自動割当定員を返します。
     *
     * @return 介護認定審査会自動割当定員
     */
    public int get介護認定審査会自動割当定員() {
        return entity.getShinsakaiJidoWariateTeiin();
    }

    /**
     * 介護認定審査会委員定員を返します。
     *
     * @return 介護認定審査会委員定員
     */
    public int get介護認定審査会委員定員() {
        return entity.getShinsakaiIinTeiin();
    }

    /**
     * 合議体精神科医存在フラグを返します。
     *
     * @return 合議体精神科医存在フラグ
     */
    public boolean get合議体精神科医存在フラグ() {
        return entity.getGogitaiSeishinkaSonzaiFlag();
    }

    /**
     * 合議体ダミーフラグを返します。
     *
     * @return 合議体ダミーフラグ
     */
    public boolean get合議体ダミーフラグ() {
        return entity.getGogitaiDummyFlag();
    }

    /**
     * {@link DbT5591GogitaiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5591GogitaiJohoEntity}のクローン
     */
    @Override
    public DbT5591GogitaiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 合議体情報の識別子{@link GogitaiJohoIdentifier}を返します。
     *
     * @return 合議体情報の識別子{@link GogitaiJohoIdentifier}
     */
    @Override
    public GogitaiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 合議体情報配下の要素を削除対象とします。<br/> {@link DbT5591GogitaiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 合議体情報配下の要素である合議体割当委員情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link GogitaiJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link GogitaiJoho}
     * @throws IllegalStateException DbT5591GogitaiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public GogitaiJoho deleted() {
        DbT5591GogitaiJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GogitaiJoho(
                deletedEntity, id, gogitaiWariateIinJoho.deleted(), shinsakaiKaisaiBashoJoho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gogitaiWariateIinJoho.hasAnyChanged() || shinsakaiKaisaiBashoJoho.hasAnyChanged();
    }

    /**
     * 合議体情報のみを変更対象とします。<br/> {@link DbT5591GogitaiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GogitaiJoho}
     */
    @Override
    public GogitaiJoho modifiedModel() {
        DbT5591GogitaiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GogitaiJoho(
                modifiedEntity, id, gogitaiWariateIinJoho, shinsakaiKaisaiBashoJoho);
    }

    /**
     * 合議体情報が保持する合議体割当委員情報に対して、指定の識別子に該当する合議体割当委員情報を返します。
     *
     * @param id 合議体割当委員情報の識別子
     * @return 合議体割当委員情報
     * @throws IllegalStateException 指定の識別子に該当する合議体割当委員情報がない場合
     */
    public GogitaiWariateIinJoho getGogitaiWariateIinJoho(GogitaiWariateIinJohoIdentifier id) {
        if (gogitaiWariateIinJoho.contains(id)) {
            return gogitaiWariateIinJoho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 合議体情報が保持する合議体割当委員情報をリストで返します。
     *
     * @return 合議体割当委員情報リスト
     */
    public List<GogitaiWariateIinJoho> getGogitaiWariateIinJohoList() {
        return new ArrayList<>(gogitaiWariateIinJoho.values());
    }

    /**
     * 合議体情報が保持する介護認定審査会開催場所情報に対して、指定の識別子に該当する介護認定審査会開催場所情報を返します。
     *
     * @param id 介護認定審査会開催場所情報の識別子
     * @return 介護認定審査会開催場所情報
     * @throws IllegalStateException 指定の識別子に該当する介護認定審査会開催場所情報がない場合
     */
    public ShinsakaiKaisaiBashoJoho getShinsakaiKaisaiBashoJoho(ShinsakaiKaisaiBashoJohoIdentifier id) {
        if (shinsakaiKaisaiBashoJoho.contains(id)) {
            return shinsakaiKaisaiBashoJoho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 合議体情報が保持する介護認定審査会開催場所情報をリストで返します。
     *
     * @return 介護認定審査会開催場所情報リスト
     */
    public List<ShinsakaiKaisaiBashoJoho> getShinsakaiKaisaiBashoJohoList() {
        return new ArrayList<>(shinsakaiKaisaiBashoJoho.values());
    }

    /**
     * {@link GogitaiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link GogitaiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gogitaiWariateIinJoho, shinsakaiKaisaiBashoJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1443846235896519594L;
        private final DbT5591GogitaiJohoEntity entity;
        private final GogitaiJohoIdentifier id;
        private final Models<GogitaiWariateIinJohoIdentifier, GogitaiWariateIinJoho> gogitaiWariateIinJoho;
        private final Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJoho;

        private _SerializationProxy(
                DbT5591GogitaiJohoEntity entity,
                GogitaiJohoIdentifier id,
                Models<GogitaiWariateIinJohoIdentifier, GogitaiWariateIinJoho> gogitaiWariateIinJoho,
                Models<ShinsakaiKaisaiBashoJohoIdentifier, ShinsakaiKaisaiBashoJoho> shinsakaiKaisaiBashoJoho
        ) {
            this.entity = entity;
            this.id = id;
            this.gogitaiWariateIinJoho = gogitaiWariateIinJoho;
            this.shinsakaiKaisaiBashoJoho = shinsakaiKaisaiBashoJoho;
        }

        private Object readResolve() {
            return new GogitaiJoho(this.entity, this.id, this.gogitaiWariateIinJoho, this.shinsakaiKaisaiBashoJoho);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link GogitaiJohoBuilder#build()}を使用してください。
     *
     * @return {@link GogitaiJohoBuilder}
     */
    public GogitaiJohoBuilder createBuilderForEdit() {
        return new GogitaiJohoBuilder(entity, id, gogitaiWariateIinJoho, shinsakaiKaisaiBashoJoho);
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
        final GogitaiJoho other = (GogitaiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
