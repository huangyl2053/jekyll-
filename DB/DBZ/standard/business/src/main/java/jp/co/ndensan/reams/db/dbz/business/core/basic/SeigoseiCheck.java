/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 整合性チェック情報を管理するクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class SeigoseiCheck extends
        ModelBase<SeigoseiCheckIdentifier, DbT1014SeigoseiCheckEntity, SeigoseiCheck> implements Serializable {

    private static final long serialVersionUID = -5178249623509403119L;
    private final DbT1014SeigoseiCheckEntity entity;
    private final SeigoseiCheckIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 整合性チェック情報の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     */
    public SeigoseiCheck(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.entity = new DbT1014SeigoseiCheckEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.id = new SeigoseiCheckIdentifier(
                識別コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link SeigoseiCheckEntity}より{@link SeigoseiCheck}を生成します。
     *
     * @param entity DBより取得した{@link SeigoseiCheckEntity}
     */
    public SeigoseiCheck(DbT1014SeigoseiCheckEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("整合性チェック情報"));
        this.id = new SeigoseiCheckIdentifier(
                entity.getShikibetsuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link SeigoseiCheckEntity}
     * @param id {@link SeigoseiCheckIdentifier}
     */
    SeigoseiCheck(
            DbT1014SeigoseiCheckEntity entity,
            SeigoseiCheckIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 対象外フラグを返します。
     *
     * @return 対象外フラグ
     */
    public boolean is対象外フラグ() {
        return entity.getTaishogaiFlag();
    }

    /**
     * 不整合理由コードを返します。
     *
     * @return 不整合理由コード
     */
    public RString get不整合理由コード() {
        return entity.getFuseigoRiyuCode();
    }

    /**
     * 登録日時を返します。
     *
     * @return 登録日時
     */
    public RDateTime get登録日時() {
        return entity.getTorokuTimestamp();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRierkiNo();
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 届出年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get届出年月日() {
        return entity.getTodokedeYMD();
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
     * 処理事由コードを返します。
     *
     * @return 処理事由コード
     */
    public RString get処理事由コード() {
        return entity.getShoriJiyuCode();
    }

    /**
     * 処理年月日を返します。
     *
     * @return 処理年月日
     */
    public FlexibleDate get処理年月日() {
        return entity.getShoriYMD();
    }

    /**
     * 住民種別コードを返します。
     *
     * @return 住民種別コード
     */
    public RString get住民種別コード() {
        return entity.getJuminShubetsuCode();
    }

    /**
     * 住民状態コードを返します。
     *
     * @return 住民状態コード
     */
    public RString get住民状態コード() {
        return entity.getJuminJotaiCode();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード
     */
    public RString get登録事由コード() {
        return entity.getTorokuJiyuCode();
    }

    /**
     * 登録異動年月日を返します。
     *
     * @return 登録異動年月日
     */
    public FlexibleDate get登録異動年月日() {
        return entity.getTorokuIdoYMD();
    }

    /**
     * 登録届出年月日を返します。
     *
     * @return 登録届出年月日
     */
    public FlexibleDate get登録届出年月日() {
        return entity.getTorokuTodokedeYMD();
    }

    /**
     * 消除事由コードを返します。
     *
     * @return 消除事由コード
     */
    public RString get消除事由コード() {
        return entity.getShojoJiyuCode();
    }

    /**
     * 消除異動年月日を返します。
     *
     * @return 消除異動年月日
     */
    public FlexibleDate get消除異動年月日() {
        return entity.getShojoIdoYMD();
    }

    /**
     * 消除届出年月日を返します。
     *
     * @return 消除届出年月日
     */
    public FlexibleDate get消除届出年月日() {
        return entity.getShojoTodokedeYMD();
    }

    /**
     * 消除通知フラグを返します。
     *
     * @return 消除通知フラグ
     */
    public boolean is消除通知フラグ() {
        return entity.getShojoTsuchiFlag();
    }

    /**
     * 転出予定異動年月日を返します。
     *
     * @return 転出予定異動年月日
     */
    public FlexibleDate get転出予定異動年月日() {
        return entity.getTenshutsuYoteiIdoYMD();
    }

    /**
     * 転出確定異動年月日を返します。
     *
     * @return 転出確定異動年月日
     */
    public FlexibleDate get転出確定異動年月日() {
        return entity.getTenshutsuKakuteiIdoYMD();
    }

    /**
     * 転出確定通知年月日を返します。
     *
     * @return 転出確定通知年月日
     */
    public FlexibleDate get転出確定通知年月日() {
        return entity.getTenshutsuKakuteiTsuchiYMD();
    }

    /**
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 資格異動日を返します。
     *
     * @return 資格異動日
     */
    public FlexibleDate get資格異動日() {
        return entity.getShikakuIdoYMD();
    }

    /**
     * 資格異動枝番を返します。
     *
     * @return 資格異動枝番
     */
    public RString get資格異動枝番() {
        return entity.getShikakuIdoEdaNo();
    }

    /**
     * 資格異動事由コードを返します。
     *
     * @return 資格異動事由コード
     */
    public RString get資格異動事由コード() {
        return entity.getShikakuIdoJiyuCode();
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 取得適用事由コードを返します。
     *
     * @return 取得適用事由コード
     */
    public RString get取得適用事由コード() {
        return entity.getShutokuTekiyoJiyuCode();
    }

    /**
     * 取得適用年月日を返します。
     *
     * @return 取得適用年月日
     */
    public FlexibleDate get取得適用年月日() {
        return entity.getShutokuTekiyoYMD();
    }

    /**
     * 取得適用届出年月日を返します。
     *
     * @return 取得適用届出年月日
     */
    public FlexibleDate get取得適用届出年月日() {
        return entity.getShutokuTekiyoTodokedeYMD();
    }

    /**
     * 喪失解除事由コードを返します。
     *
     * @return 喪失解除事由コード
     */
    public RString get喪失解除事由コード() {
        return entity.getSoshitsuKaijoJiyuCode();
    }

    /**
     * 喪失解除年月日を返します。
     *
     * @return 喪失解除年月日
     */
    public FlexibleDate get喪失解除年月日() {
        return entity.getSoshitsuKaijoYMD();
    }

    /**
     * 喪失解除届出年月日を返します。
     *
     * @return 喪失解除届出年月日
     */
    public FlexibleDate get喪失解除届出年月日() {
        return entity.getSoshitsuKaijoTodokedeYMD();
    }

    /**
     * 第１号取得年月日を返します。
     *
     * @return 第１号取得年月日
     */
    public FlexibleDate get第１号取得年月日() {
        return entity.getIchigoShutokuYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokenshaKubunCode();
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
     * 住特適用事由コードを返します。
     *
     * @return 住特適用事由コード
     */
    public RString get住特適用事由コード() {
        return entity.getJutokuTekiyoJiyuCode();
    }

    /**
     * 住特適用年月日を返します。
     *
     * @return 住特適用年月日
     */
    public FlexibleDate get住特適用年月日() {
        return entity.getJutokuTekiyoYMD();
    }

    /**
     * 住特適用届出年月日を返します。
     *
     * @return 住特適用届出年月日
     */
    public FlexibleDate get住特適用届出年月日() {
        return entity.getJutokuTekiyoTodokedeYMD();
    }

    /**
     * 住特解除事由コードを返します。
     *
     * @return 住特解除事由コード
     */
    public RString get住特解除事由コード() {
        return entity.getJutokuKaijoJiyuCode();
    }

    /**
     * 住特解除年月日を返します。
     *
     * @return 住特解除年月日
     */
    public FlexibleDate get住特解除年月日() {
        return entity.getJutokuKaijoYMD();
    }

    /**
     * 住特解除届出年月日を返します。
     *
     * @return 住特解除届出年月日
     */
    public FlexibleDate get住特解除届出年月日() {
        return entity.getJutokuKaijoTodokedeYMD();
    }

    /**
     * {@link SeigoseiCheckEntity}のクローンを返します。
     *
     * @return {@link SeigoseiCheckEntity}のクローン
     */
    @Override
    public DbT1014SeigoseiCheckEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 整合性チェック情報の識別子{@link SeigoseiCheckIdentifier}を返します。
     *
     * @return 整合性チェック情報の識別子{@link SeigoseiCheckIdentifier}
     */
    @Override
    public SeigoseiCheckIdentifier identifier() {
        return this.id;
    }

    /**
     * 整合性チェック情報のみを変更対象とします。<br/> {@link SeigoseiCheckEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SeigoseiCheck}
     */
    public SeigoseiCheck modifiedModel() {
        DbT1014SeigoseiCheckEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SeigoseiCheck(
                modifiedEntity, id);
    }

    /**
     * 保持する整合性チェック情報を削除対象とします。<br/> {@link SeigoseiCheckEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SeigoseiCheck}
     */
    @Override
    public SeigoseiCheck deleted() {
        DbT1014SeigoseiCheckEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SeigoseiCheck(deletedEntity, id);
    }

    /**
     * {@link SeigoseiCheck}のシリアライズ形式を提供します。
     *
     * @return {@link SeigoseiCheck}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -7461308017106396206L;
        private final DbT1014SeigoseiCheckEntity entity;
        private final SeigoseiCheckIdentifier id;

        private _SerializationProxy(DbT1014SeigoseiCheckEntity entity, SeigoseiCheckIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SeigoseiCheck(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SeigoseiCheckBuilder createBuilderForEdit() {
        return new SeigoseiCheckBuilder(entity, id);
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
        final SeigoseiCheck other = (SeigoseiCheck) obj;
        return Objects.equals(this.id, other.id);
    }
}
