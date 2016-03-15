/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会開催予定情報を管理するクラスです。
 */
public class ShinsakaiKaisaiYoteiJoho
        extends ParentModelBase<ShinsakaiKaisaiYoteiJohoIdentifier, DbT5501ShinsakaiKaisaiYoteiJohoEntity, ShinsakaiKaisaiYoteiJoho>
        implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT5501ShinsakaiKaisaiYoteiJohoEntity entity;
    private final ShinsakaiKaisaiYoteiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催予定情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiKaisaiYoteiJoho(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        this.entity = new DbT5501ShinsakaiKaisaiYoteiJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.id = new ShinsakaiKaisaiYoteiJohoIdentifier(
                介護認定審査会開催番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}より{@link ShinsakaiKaisaiYoteiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}
     */
    public ShinsakaiKaisaiYoteiJoho(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));
        this.id = new ShinsakaiKaisaiYoteiJohoIdentifier(
                entity.getShinsakaiKaisaiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}
     * @param id {@link ShinsakaiKaisaiYoteiJohoIdentifier}
     */
    ShinsakaiKaisaiYoteiJoho(
            DbT5501ShinsakaiKaisaiYoteiJohoEntity entity,
            ShinsakaiKaisaiYoteiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 論理削除行であればtrueを返します。
     *
     * @return 論理削除行であればtrue
     */
    public boolean is論理削除行であればtrue() {
        return entity.getIsDeleted();
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会開催予定年月日を返します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会開始予定時刻を返します。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString get介護認定審査会開始予定時刻() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 介護認定審査会終了予定時刻を返します。
     *
     * @return 介護認定審査会終了予定時刻
     */
    public RString get介護認定審査会終了予定時刻() {
        return entity.getShinsakaiShuryoYoteiTime();
    }

    /**
     * 介護認定審査会開催予定場所コードを返します。
     *
     * @return 介護認定審査会開催予定場所コード
     */
    public RString get介護認定審査会開催予定場所コード() {
        return entity.getShinsakaiKaisaiYoteiBashoCode();
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
     * 介護認定審査会予定定員を返します。
     *
     * @return 介護認定審査会予定定員
     */
    public int get介護認定審査会予定定員() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会最大定員を返します。
     *
     * @return 介護認定審査会最大定員
     */
    public int get介護認定審査会最大定員() {
        return entity.getShinsakaiSaidaiTeiin();
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
     * 介護認定審査会資料作成年月日を返します。
     *
     * @return 介護認定審査会資料作成年月日
     */
    public FlexibleDate get介護認定審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 介護認定審査会進捗状況を返します。
     *
     * @return 介護認定審査会進捗状況
     */
    public Code get介護認定審査会進捗状況() {
        return entity.getShinsakaiShinchokuJokyo();
    }

    /**
     * 介護認定審査会割当済み人数を返します。
     *
     * @return 介護認定審査会割当済み人数
     */
    public int get介護認定審査会割当済み人数() {
        return entity.getShinsakaiWariateZumiNinzu();
    }

    /**
     * 資料作成済フラグを返します。
     *
     * @return 資料作成済フラグ
     */
    public boolean is資料作成済フラグ() {
        return entity.getShiryoSakuseiZumiFlag();
    }

    /**
     * モバイルデータ出力年月日を返します。
     *
     * @return モバイルデータ出力年月日
     */
    public FlexibleDate getモバイルデータ出力年月日() {
        return entity.getMobileDataOutputYMD();
    }

    /**
     * {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}のクローン
     */
    @Override
    public DbT5501ShinsakaiKaisaiYoteiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会開催予定情報の識別子{@link ShinsakaiKaisaiYoteiJohoIdentifier}を返します。
     *
     * @return 介護認定審査会開催予定情報の識別子{@link ShinsakaiKaisaiYoteiJohoIdentifier}
     */
    @Override
    public ShinsakaiKaisaiYoteiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会開催予定情報のみを変更対象とします。<br/> {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiKaisaiYoteiJoho}
     */
    @Override
    public ShinsakaiKaisaiYoteiJoho modifiedModel() {
        DbT5501ShinsakaiKaisaiYoteiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiKaisaiYoteiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会開催予定情報を削除対象とします。<br/> {@link DbT5501ShinsakaiKaisaiYoteiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiKaisaiYoteiJoho}
     */
    @Override
    public ShinsakaiKaisaiYoteiJoho deleted() {
        DbT5501ShinsakaiKaisaiYoteiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiKaisaiYoteiJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiKaisaiYoteiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiKaisaiYoteiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1477122396355518492L;
        private final DbT5501ShinsakaiKaisaiYoteiJohoEntity entity;
        private final ShinsakaiKaisaiYoteiJohoIdentifier id;

        private _SerializationProxy(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity, ShinsakaiKaisaiYoteiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiKaisaiYoteiJoho(this.entity, this.id);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiKaisaiYoteiJohoBuilder createBuilderForEdit() {
        return new ShinsakaiKaisaiYoteiJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiKaisaiYoteiJoho other = (ShinsakaiKaisaiYoteiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
