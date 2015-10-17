/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護問合せ先を管理するクラスです。
 */
public class KaigoToiawasesaki extends ParentModelBase<KaigoToiawasesakiIdentifier, DbT7069KaigoToiawasesakiEntity, KaigoToiawasesaki> implements Serializable {

    private final DbT7069KaigoToiawasesakiEntity entity;
    private final KaigoToiawasesakiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護問合せ先の新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     */
    public KaigoToiawasesaki(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        this.entity = new DbT7069KaigoToiawasesakiEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setChohyoBunruiID(帳票分類ID);
        this.id = new KaigoToiawasesakiIdentifier(
                サブ業務コード,
                帳票分類ID
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7069KaigoToiawasesakiEntity}より{@link KaigoToiawasesaki}を生成します。
     *
     * @param entity DBより取得した{@link DbT7069KaigoToiawasesakiEntity}
     */
    public KaigoToiawasesaki(DbT7069KaigoToiawasesakiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護問合せ先"));
        this.id = new KaigoToiawasesakiIdentifier(
                entity.getSubGyomuCode(),
                entity.getChohyoBunruiID());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7069KaigoToiawasesakiEntity}
     * @param id {@link KaigoToiawasesakiIdentifier}
     */
    KaigoToiawasesaki(
            DbT7069KaigoToiawasesakiEntity entity,
            KaigoToiawasesakiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }

    /**
     * 帳票分類IDを返します。
     *
     * @return 帳票分類ID
     */
    public ReportId get帳票分類ID() {
        return entity.getChohyoBunruiID();
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
     * 所在地を返します。
     *
     * @return 所在地
     */
    public RString get所在地() {
        return entity.getShozaichi();
    }

    /**
     * 庁舎名を返します。
     *
     * @return 庁舎名
     */
    public RString get庁舎名() {
        return entity.getChoshaName();
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
     * 内線番号を返します。
     *
     * @return 内線番号
     */
    public RString get内線番号() {
        return entity.getNaisenNo();
    }

    /**
     * 部署名を返します。
     *
     * @return 部署名
     */
    public RString get部署名() {
        return entity.getBushoName();
    }

    /**
     * 担当者名を返します。
     *
     * @return 担当者名
     */
    public RString get担当者名() {
        return entity.getTantoshaName();
    }

    /**
     * {@link DbT7069KaigoToiawasesakiEntity}のクローンを返します。
     *
     * @return {@link DbT7069KaigoToiawasesakiEntity}のクローン
     */
    @Override
    public DbT7069KaigoToiawasesakiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護問合せ先の識別子{@link KaigoToiawasesakiIdentifier}を返します。
     *
     * @return 介護問合せ先の識別子{@link KaigoToiawasesakiIdentifier}
     */
    @Override
    public KaigoToiawasesakiIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護問合せ先のみを変更対象とします。<br/>
     * {@link DbT7069KaigoToiawasesakiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoToiawasesaki}
     */
    @Override
    public KaigoToiawasesaki modifiedModel() {
        DbT7069KaigoToiawasesakiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoToiawasesaki(
                modifiedEntity, id);
    }

    /**
     * 保持する介護問合せ先を削除対象とします。<br/>
     * {@link DbT7069KaigoToiawasesakiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoToiawasesaki}
     */
    @Override
    public KaigoToiawasesaki deleted() {
        DbT7069KaigoToiawasesakiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoToiawasesaki(deletedEntity, id);
    }

    /**
     * {@link KaigoToiawasesaki}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoToiawasesaki}のシリアライズ形式
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
        private final DbT7069KaigoToiawasesakiEntity entity;
        private final KaigoToiawasesakiIdentifier id;

        private _SerializationProxy(DbT7069KaigoToiawasesakiEntity entity, KaigoToiawasesakiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoToiawasesaki(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoToiawasesakiBuilder createBuilderForEdit() {
        return new KaigoToiawasesakiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
