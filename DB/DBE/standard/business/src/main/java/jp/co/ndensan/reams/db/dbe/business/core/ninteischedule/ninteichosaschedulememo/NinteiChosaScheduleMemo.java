/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteichosaschedulememo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査スケジュールメモ情報を管理するクラスです。
 */
public class NinteiChosaScheduleMemo extends ModelBase<NinteiChosaScheduleMemoIdentifier, DbT5222NinteiChosaScheduleMemoEntity, NinteiChosaScheduleMemo> implements Serializable {
    private static final long serialVersionUID = 4441122624281562268L;

    private final DbT5222NinteiChosaScheduleMemoEntity entity;
    private final NinteiChosaScheduleMemoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査スケジュールメモ情報の新規作成時に使用します。
     *
     * @param メモ年月日 メモ年月日
     * @param 調査地区コード 調査地区コード
     * @param メモ区分 メモ区分
     * @param 連番 連番
     */
    public NinteiChosaScheduleMemo(FlexibleDate メモ年月日,
Code 調査地区コード,
Code メモ区分,
int 連番) {
        requireNonNull(メモ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ年月日"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(メモ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5222NinteiChosaScheduleMemoEntity();
        this.entity.setMemoYMD(メモ年月日);
        this.entity.setChosachikucode(調査地区コード);
        this.entity.setMemoKubun(メモ区分);
        this.entity.setRemban(連番);
        this.id = new NinteiChosaScheduleMemoIdentifier(
        メモ年月日,
        調査地区コード,
        メモ区分,
        連番
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5222NinteiChosaScheduleMemoEntity}より{@link NinteiChosaScheduleMemo}を生成します。
     *
     * @param entity DBより取得した{@link DbT5222NinteiChosaScheduleMemoEntity}
     */
    public NinteiChosaScheduleMemo(DbT5222NinteiChosaScheduleMemoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュールメモ情報"));
        this.id = new NinteiChosaScheduleMemoIdentifier(
                entity.getMemoYMD(),
                entity.getChosachikucode(),
                entity.getMemoKubun(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5222NinteiChosaScheduleMemoEntity}
     * @param id {@link NinteiChosaScheduleMemoIdentifier}
     */
    NinteiChosaScheduleMemo(
            DbT5222NinteiChosaScheduleMemoEntity entity,
            NinteiChosaScheduleMemoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * メモ年月日を返します。
     *
     * @return メモ年月日
     */
    public FlexibleDate getメモ年月日() {
        return entity.getMemoYMD();
    }

    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosachikucode();
    }

    /**
     * メモ区分を返します。
     *
     * @return メモ区分
     */
    public Code getメモ区分() {
        return entity.getMemoKubun();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRemban();
    }

    /**
     * メモ指定調査地区コードを返します。
     *
     * @return メモ指定調査地区コード
     */
    public Code getメモ指定調査地区コード() {
        return entity.getMemoShiteiChosaChikuCode();
    }

    /**
     * 作成者を返します。
     *
     * @return 作成者
     */
    public RString get作成者() {
        return entity.getSakuseisha();
    }

    /**
     * メモ重要度を返します。
     *
     * @return メモ重要度
     */
    public Code getメモ重要度() {
        return entity.getMemoPriority();
    }

    /**
     * メモ内容を返します。
     *
     * @return メモ内容
     */
    public RString getメモ内容() {
        return entity.getMemoNaiyo();
    }

    /**
     * {@link DbT5222NinteiChosaScheduleMemoEntity}のクローンを返します。
     *
     * @return {@link DbT5222NinteiChosaScheduleMemoEntity}のクローン
     */
    @Override
    public DbT5222NinteiChosaScheduleMemoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査スケジュールメモ情報の識別子{@link NinteiChosaScheduleMemoIdentifier}を返します。
     *
     * @return 認定調査スケジュールメモ情報の識別子{@link NinteiChosaScheduleMemoIdentifier}
     */
    @Override
    public NinteiChosaScheduleMemoIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査スケジュールメモ情報のみを変更対象とします。<br/>
     * {@link DbT5222NinteiChosaScheduleMemoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiChosaScheduleMemo}
     */
    public NinteiChosaScheduleMemo modifiedModel() {
        DbT5222NinteiChosaScheduleMemoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteiChosaScheduleMemo(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査スケジュールメモ情報を削除対象とします。<br/>
     * {@link DbT5222NinteiChosaScheduleMemoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteiChosaScheduleMemo}
     */
    @Override
    public NinteiChosaScheduleMemo deleted() {
        DbT5222NinteiChosaScheduleMemoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiChosaScheduleMemo(deletedEntity, id);
    }
    /**
     * {@link NinteiChosaScheduleMemo}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiChosaScheduleMemo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }
    
    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {
        private static final long serialVersionUID = 5501732245720506682L;
        private final DbT5222NinteiChosaScheduleMemoEntity entity;
        private final NinteiChosaScheduleMemoIdentifier id;

        private _SerializationProxy(DbT5222NinteiChosaScheduleMemoEntity entity,NinteiChosaScheduleMemoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteiChosaScheduleMemo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteiChosaScheduleMemoBuilder createBuilderForEdit() {
        return new NinteiChosaScheduleMemoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
