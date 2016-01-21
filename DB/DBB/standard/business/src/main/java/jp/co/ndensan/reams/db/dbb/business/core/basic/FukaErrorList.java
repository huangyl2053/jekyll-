/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 賦課エラー一覧を管理するクラスです。
 */
public class FukaErrorList extends ModelBase<FukaErrorListIdentifier, DbT2010FukaErrorListEntity, FukaErrorList> implements Serializable {

    private final DbT2010FukaErrorListEntity entity;
    private final FukaErrorListIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 賦課エラー一覧の新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 内部帳票ID 内部帳票ID
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     */
    public FukaErrorList(SubGyomuCode サブ業務コード,
            RString 内部帳票ID,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(内部帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票ID"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.entity = new DbT2010FukaErrorListEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setInternalReportId(内部帳票ID);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.id = new FukaErrorListIdentifier(
                サブ業務コード,
                内部帳票ID,
                賦課年度,
                通知書番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2010FukaErrorListEntity}より{@link FukaErrorList}を生成します。
     *
     * @param entity DBより取得した{@link DbT2010FukaErrorListEntity}
     */
    public FukaErrorList(DbT2010FukaErrorListEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課エラー一覧"));
        this.id = new FukaErrorListIdentifier(
                entity.getSubGyomuCode(),
                entity.getInternalReportId(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2010FukaErrorListEntity}
     * @param id {@link FukaErrorListIdentifier}
     */
    FukaErrorList(
            DbT2010FukaErrorListEntity entity,
            FukaErrorListIdentifier id
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
     * 内部帳票IDを返します。
     *
     * @return 内部帳票ID
     */
    public RString get内部帳票ID() {
        return entity.getInternalReportId();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 内部帳票作成日時を返します。
     *
     * @return 内部帳票作成日時
     */
    public RDateTime get内部帳票作成日時() {
        return entity.getInternalReportCreationDateTime();
    }

    /**
     * バッチIDを返します。
     *
     * @return バッチID
     */
    public RString getバッチID() {
        return entity.getBatchId();
    }

    /**
     * バッチ起動日時を返します。
     *
     * @return バッチ起動日時
     */
    public RDateTime getバッチ起動日時() {
        return entity.getBatchStartingDateTime();
    }

    /**
     * エラーコードを返します。
     *
     * @return エラーコード
     */
    public Code getエラーコード() {
        return entity.getErrorCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 処理区分コードを返します。
     *
     * @return 処理区分コード
     */
    public Code get処理区分コード() {
        return entity.getShoriKubunCode();
    }

    /**
     * {@link DbT2010FukaErrorListEntity}のクローンを返します。
     *
     * @return {@link DbT2010FukaErrorListEntity}のクローン
     */
    @Override
    public DbT2010FukaErrorListEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 賦課エラー一覧の識別子{@link FukaErrorListIdentifier}を返します。
     *
     * @return 賦課エラー一覧の識別子{@link FukaErrorListIdentifier}
     */
    @Override
    public FukaErrorListIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する賦課エラー一覧を削除対象とします。<br/>
     * {@link DbT2010FukaErrorListEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FukaErrorList}
     */
    @Override
    public FukaErrorList deleted() {
        DbT2010FukaErrorListEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FukaErrorList(deletedEntity, id);
    }

    /**
     * {@link FukaErrorList}のシリアライズ形式を提供します。
     *
     * @return {@link FukaErrorList}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT2010FukaErrorListEntity entity;
        private final FukaErrorListIdentifier id;

        private _SerializationProxy(DbT2010FukaErrorListEntity entity, FukaErrorListIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FukaErrorList(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FukaErrorListBuilder createBuilderForEdit() {
        return new FukaErrorListBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
