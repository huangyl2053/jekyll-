/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理日付管理マスタを管理するクラスです。
 */
public class ShoriDateKanri extends ParentModelBase<ShoriDateKanriIdentifier, DbT7022ShoriDateKanriEntity, ShoriDateKanri> implements Serializable {

    private final DbT7022ShoriDateKanriEntity entity;
    private final ShoriDateKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 処理日付管理マスタの新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 市町村コード 市町村コード
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @param 年度内連番 年度内連番
     */
    public ShoriDateKanri(SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));
        this.entity = new DbT7022ShoriDateKanriEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setShichosonCode(市町村コード);
        this.entity.setShoriName(処理名);
        this.entity.setShoriEdaban(処理枝番);
        this.entity.setNendo(年度);
        this.entity.setNendoNaiRenban(年度内連番);
        this.id = new ShoriDateKanriIdentifier(
                サブ業務コード,
                市町村コード,
                処理名,
                処理枝番,
                年度,
                年度内連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7022ShoriDateKanriEntity}より{@link ShoriDateKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7022ShoriDateKanriEntity}
     */
    public ShoriDateKanri(DbT7022ShoriDateKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理マスタ"));
        this.id = new ShoriDateKanriIdentifier(
                entity.getSubGyomuCode(),
                entity.getShichosonCode(),
                entity.getShoriName(),
                entity.getShoriEdaban(),
                entity.getNendo(),
                entity.getNendoNaiRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7022ShoriDateKanriEntity}
     * @param id {@link ShoriDateKanriIdentifier}
     */
    ShoriDateKanri(
            DbT7022ShoriDateKanriEntity entity,
            ShoriDateKanriIdentifier id
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 処理名を返します。
     *
     * @return 処理名
     */
    public RString get処理名() {
        return entity.getShoriName();
    }

    /**
     * 処理枝番を返します。
     *
     * @return 処理枝番
     */
    public RString get処理枝番() {
        return entity.getShoriEdaban();
    }

    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return entity.getNendo();
    }

    /**
     * 年度内連番を返します。
     *
     * @return 年度内連番
     */
    public RString get年度内連番() {
        return entity.getNendoNaiRenban();
    }

    /**
     * 基準年月日を返します。
     *
     * @return 基準年月日
     */
    public FlexibleDate get基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 基準日時を返します。
     *
     * @return 基準日時
     */
    public YMDHMS get基準日時() {
        return entity.getKijunTimestamp();
    }

    /**
     * 対象開始年月日を返します。
     *
     * @return 対象開始年月日
     */
    public FlexibleDate get対象開始年月日() {
        return entity.getTaishoKaishiYMD();
    }

    /**
     * 対象終了年月日を返します。
     *
     * @return 対象終了年月日
     */
    public FlexibleDate get対象終了年月日() {
        return entity.getTaishoShuryoYMD();
    }

    /**
     * 対象開始日時を返します。
     *
     * @return 対象開始日時
     */
    public YMDHMS get対象開始日時() {
        return entity.getTaishoKaishiTimestamp();
    }

    /**
     * 対象終了日時を返します。
     *
     * @return 対象終了日時
     */
    public YMDHMS get対象終了日時() {
        return entity.getTaishoShuryoTimestamp();
    }

    /**
     * {@link DbT7022ShoriDateKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7022ShoriDateKanriEntity}のクローン
     */
    @Override
    public DbT7022ShoriDateKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 処理日付管理マスタの識別子{@link ShoriDateKanriIdentifier}を返します。
     *
     * @return 処理日付管理マスタの識別子{@link ShoriDateKanriIdentifier}
     */
    @Override
    public ShoriDateKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 処理日付管理マスタのみを変更対象とします。<br/>
     * {@link DbT7022ShoriDateKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShoriDateKanri}
     */
    @Override
    public ShoriDateKanri modifiedModel() {
        DbT7022ShoriDateKanriEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShoriDateKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する処理日付管理マスタを削除対象とします。<br/>
     * {@link DbT7022ShoriDateKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShoriDateKanri}
     */
    @Override
    public ShoriDateKanri deleted() {
        DbT7022ShoriDateKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShoriDateKanri(deletedEntity, id);
    }

    /**
     * {@link ShoriDateKanri}のシリアライズ形式を提供します。
     *
     * @return {@link ShoriDateKanri}のシリアライズ形式
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
        private final DbT7022ShoriDateKanriEntity entity;
        private final ShoriDateKanriIdentifier id;

        private _SerializationProxy(DbT7022ShoriDateKanriEntity entity, ShoriDateKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShoriDateKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShoriDateKanriBuilder createBuilderForEdit() {
        return new ShoriDateKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
