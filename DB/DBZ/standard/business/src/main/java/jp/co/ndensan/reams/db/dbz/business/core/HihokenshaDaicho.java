/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳管理を管理するクラスです。
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class HihokenshaDaicho extends ModelBase<HihokenshaDaichoIdentifier, DbT1001HihokenshaDaichoEntity, HihokenshaDaicho>
        implements Serializable {

    private final DbT1001HihokenshaDaichoEntity entity;
    private final HihokenshaDaichoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 被保険者台帳管理の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public HihokenshaDaicho(HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new DbT1001HihokenshaDaichoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setIdoYMD(異動日);
        this.entity.setEdaNo(枝番);
        this.id = new HihokenshaDaichoIdentifier(
                被保険者番号,
                異動日,
                枝番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1001HihokenshaDaichoEntity}より{@link HihokenshaDaicho}を生成します。
     *
     * @param entity DBより取得した{@link DbT1001HihokenshaDaichoEntity}
     */
    public HihokenshaDaicho(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理"));
        this.id = new HihokenshaDaichoIdentifier(
                entity.getHihokenshaNo(),
                entity.getIdoYMD(),
                entity.getEdaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1001HihokenshaDaichoEntity}
     * @param id {@link HihokenshaDaichoIdentifier}
     */
    HihokenshaDaicho(
            DbT1001HihokenshaDaichoEntity entity,
            HihokenshaDaichoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 異動事由コードを返します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return entity.getIdoJiyuCode();
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出年月日を返します。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate get資格取得届出年月日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 第1号資格取得年月日を返します。
     *
     * @return 第1号資格取得年月日
     */
    public FlexibleDate get第1号資格取得年月日() {
        return entity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出年月日を返します。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate get資格喪失届出年月日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 資格変更事由コードを返します。
     *
     * @return 資格変更事由コード
     */
    public RString get資格変更事由コード() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更年月日を返します。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate get資格変更年月日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更届出年月日を返します。
     *
     * @return 資格変更届出年月日
     */
    public FlexibleDate get資格変更届出年月日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 住所地特例適用事由コードを返します。
     *
     * @return 住所地特例適用事由コード
     */
    public RString get住所地特例適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 住所地特例解除事由コードを返します。
     *
     * @return 住所地特例解除事由コード
     */
    public RString get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 広域内住所地特例フラグを返します。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString get広域内住所地特例フラグ() {
        return entity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT1001HihokenshaDaichoEntity}のクローンを返します。
     *
     * @return {@link DbT1001HihokenshaDaichoEntity}のクローン
     */
    @Override
    public DbT1001HihokenshaDaichoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 被保険者台帳管理の識別子{@link HihokenshaDaichoIdentifier}を返します。
     *
     * @return 被保険者台帳管理の識別子{@link HihokenshaDaichoIdentifier}
     */
    @Override
    public HihokenshaDaichoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する被保険者台帳管理を削除対象とします。<br/>
     * {@link DbT1001HihokenshaDaichoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link HihokenshaDaicho}
     */
    @Override
    public HihokenshaDaicho deleted() {
        DbT1001HihokenshaDaichoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HihokenshaDaicho(deletedEntity, id);
    }

    /**
     * 被保険者台帳管理のみを変更対象とします。<br/>
     * {@link DbT1001HihokenshaDaichoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link HihokenshaDaicho}
     */
    public HihokenshaDaicho modifiedModel() {
        DbT1001HihokenshaDaichoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new HihokenshaDaicho(
                modifiedEntity, id);
    }

    /**
     * {@link HihokenshaDaicho}のシリアライズ形式を提供します。
     *
     * @return {@link HihokenshaDaicho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT1001HihokenshaDaichoEntity entity;
        private final HihokenshaDaichoIdentifier id;

        private _SerializationProxy(DbT1001HihokenshaDaichoEntity entity, HihokenshaDaichoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new HihokenshaDaicho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public HihokenshaDaichoBuilder createBuilderForEdit() {
        return new HihokenshaDaichoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
    /**
     * 被保険者台帳と同一のデータを持つ、新しい被保険者台帳情報を作成します。
     * 被保険者台帳の前履歴データを元に、新規に履歴を発生させたい場合などに使用します。
     *
     * @return 新規被保険者台帳Entity
     */
    public HihokenshaDaicho createNewCopyData() {
        DbT1001HihokenshaDaichoEntity newEntity = new DbT1001HihokenshaDaichoEntity();
        newEntity.setHihokenshaNo(entity.getHihokenshaNo());
        newEntity.setIdoYMD(entity.getIdoYMD());
        newEntity.setEdaNo(entity.getEdaNo());
        newEntity.setIdoJiyuCode(entity.getIdoJiyuCode());
        newEntity.setShichosonCode(entity.getShichosonCode());
        newEntity.setShikibetsuCode(entity.getShikibetsuCode());
        newEntity.setShikakuShutokuJiyuCode(entity.getShikakuShutokuJiyuCode());
        newEntity.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        newEntity.setShikakuShutokuTodokedeYMD(entity.getShikakuShutokuTodokedeYMD());
        newEntity.setIchigoShikakuShutokuYMD(entity.getIchigoShikakuShutokuYMD());
        newEntity.setHihokennshaKubunCode(entity.getHihokennshaKubunCode());
        newEntity.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        newEntity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        newEntity.setShikakuSoshitsuTodokedeYMD(entity.getShikakuSoshitsuTodokedeYMD());
        newEntity.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        newEntity.setShikakuHenkoYMD(entity.getShikakuHenkoYMD());
        newEntity.setShikakuHenkoTodokedeYMD(entity.getShikakuHenkoTodokedeYMD());
        newEntity.setJushochitokureiTekiyoJiyuCode(entity.getJushochitokureiTekiyoJiyuCode());
        newEntity.setJushochitokureiTekiyoYMD(entity.getJushochitokureiTekiyoYMD());
        newEntity.setJushochitokureiTekiyoTodokedeYMD(entity.getJushochitokureiTekiyoTodokedeYMD());
        newEntity.setJushochitokureiKaijoJiyuCode(entity.getJushochitokureiKaijoJiyuCode());
        newEntity.setJushochitokureiKaijoYMD(entity.getJushochitokureiKaijoYMD());
        newEntity.setJushochitokureiKaijoTodokedeYMD(entity.getJushochitokureiKaijoTodokedeYMD());
        newEntity.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        newEntity.setKoikinaiJushochiTokureiFlag(entity.getKoikinaiJushochiTokureiFlag());
        newEntity.setKoikinaiTokureiSochimotoShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCode());
        newEntity.setKyuShichosonCode(entity.getKyuShichosonCode());
        newEntity.setLogicalDeletedFlag(entity.getLogicalDeletedFlag());
        return new HihokenshaDaicho(newEntity);
    }
}
