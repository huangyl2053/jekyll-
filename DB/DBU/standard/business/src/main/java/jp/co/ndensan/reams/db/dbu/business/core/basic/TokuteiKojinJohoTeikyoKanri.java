/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特定個人情報提供管理を管理するクラスです。
 *
 * @reamsid_L DBU-9999-013 wangchao
 */
public class TokuteiKojinJohoTeikyoKanri extends ModelBase<TokuteiKojinJohoTeikyoKanriIdentifier, DbT7304TokuteiKojinJohoTeikyoKanriEntity, TokuteiKojinJohoTeikyoKanri> implements Serializable {

    private final DbT7304TokuteiKojinJohoTeikyoKanriEntity entity;
    private final TokuteiKojinJohoTeikyoKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 特定個人情報提供管理の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param データセットレコードキー データセットレコードキー
     */
    public TokuteiKojinJohoTeikyoKanri(HihokenshaNo 被保険者番号,
            RString データセットレコードキー) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(データセットレコードキー, UrSystemErrorMessages.値がnull.getReplacedMessage("データセットレコードキー"));
        this.entity = new DbT7304TokuteiKojinJohoTeikyoKanriEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setDataSetRecordKey(データセットレコードキー);
        this.id = new TokuteiKojinJohoTeikyoKanriIdentifier(
                被保険者番号,
                データセットレコードキー
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}より{@link TokuteiKojinJohoTeikyoKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}
     */
    public TokuteiKojinJohoTeikyoKanri(DbT7304TokuteiKojinJohoTeikyoKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特定個人情報提供管理"));
        this.id = new TokuteiKojinJohoTeikyoKanriIdentifier(
                entity.getHihokenshaNo(),
                entity.getDataSetRecordKey());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}
     * @param id {@link TokuteiKojinJohoTeikyoKanriIdentifier}
     */
    TokuteiKojinJohoTeikyoKanri(
            DbT7304TokuteiKojinJohoTeikyoKanriEntity entity,
            TokuteiKojinJohoTeikyoKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * データセットレコードキーを返します。
     *
     * @return データセットレコードキー
     */
    public RString getデータセットレコードキー() {
        return entity.getDataSetRecordKey();
    }

    /**
     * 提供日時を返します。
     *
     * @return 提供日時
     */
    public RDateTime get提供日時() {
        return entity.getTeikyoNichiji();
    }

    /**
     * 新規異動区分を返します。
     *
     * @return 新規異動区分
     */
    public RString get新規異動区分() {
        return entity.getShinkiIdoKubun();
    }

    /**
     * 提供区分を返します。
     *
     * @return 提供区分
     */
    public RString get提供区分() {
        return entity.getTeikyoKubun();
    }

    /**
     * 特定個人情報名コードを返します。
     *
     * @return 特定個人情報名コード
     */
    public RString get特定個人情報名コード() {
        return entity.getTokuteiKojinJohoMeiCode();
    }

    /**
     * 版番号を返します。
     *
     * @return 版番号
     */
    public RString get版番号() {
        return entity.getHanNo();
    }

    /**
     * データセット番号を返します。
     *
     * @return データセット番号
     */
    public RString getデータセット番号() {
        return entity.getDataSetNo();
    }

    /**
     * 公開年月日を返します。
     *
     * @return 公開年月日
     */
    public FlexibleDate get公開年月日() {
        return entity.getKokaiYMD();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getTateNo();
    }

    /**
     * 送信内容１を返します。
     *
     * @return 送信内容１
     */
    public RString get送信内容１() {
        return entity.getSoshinNaiyo01();
    }

    /**
     * 未設定事由１を返します。
     *
     * @return 未設定事由１
     */
    public RString get未設定事由１() {
        return entity.getMisetteiJiyu01();
    }

    /**
     * 送信内容２を返します。
     *
     * @return 送信内容２
     */
    public RString get送信内容２() {
        return entity.getSoshinNaiyo02();
    }

    /**
     * 未設定事由２を返します。
     *
     * @return 未設定事由２
     */
    public RString get未設定事由２() {
        return entity.getMisetteiJiyu02();
    }

    /**
     * 送信内容３を返します。
     *
     * @return 送信内容３
     */
    public RString get送信内容３() {
        return entity.getSoshinNaiyo03();
    }

    /**
     * 未設定事由３を返します。
     *
     * @return 未設定事由３
     */
    public RString get未設定事由３() {
        return entity.getMisetteiJiyu03();
    }

    /**
     * 送信内容４を返します。
     *
     * @return 送信内容４
     */
    public RString get送信内容４() {
        return entity.getSoshinNaiyo04();
    }

    /**
     * 未設定事由４を返します。
     *
     * @return 未設定事由４
     */
    public RString get未設定事由４() {
        return entity.getMisetteiJiyu04();
    }

    /**
     * 送信内容５を返します。
     *
     * @return 送信内容５
     */
    public RString get送信内容５() {
        return entity.getSoshinNaiyo05();
    }

    /**
     * 未設定事由５を返します。
     *
     * @return 未設定事由５
     */
    public RString get未設定事由５() {
        return entity.getMisetteiJiyu05();
    }

    /**
     * 送信内容６を返します。
     *
     * @return 送信内容６
     */
    public RString get送信内容６() {
        return entity.getSoshinNaiyo06();
    }

    /**
     * 未設定事由６を返します。
     *
     * @return 未設定事由６
     */
    public RString get未設定事由６() {
        return entity.getMisetteiJiyu06();
    }

    /**
     * 送信内容７を返します。
     *
     * @return 送信内容７
     */
    public RString get送信内容７() {
        return entity.getSoshinNaiyo07();
    }

    /**
     * 未設定事由７を返します。
     *
     * @return 未設定事由７
     */
    public RString get未設定事由７() {
        return entity.getMisetteiJiyu07();
    }

    /**
     * 送信内容８を返します。
     *
     * @return 送信内容８
     */
    public RString get送信内容８() {
        return entity.getSoshinNaiyo08();
    }

    /**
     * 未設定事由８を返します。
     *
     * @return 未設定事由８
     */
    public RString get未設定事由８() {
        return entity.getMisetteiJiyu08();
    }

    /**
     * 送信内容９を返します。
     *
     * @return 送信内容９
     */
    public RString get送信内容９() {
        return entity.getSoshinNaiyo09();
    }

    /**
     * 未設定事由９を返します。
     *
     * @return 未設定事由９
     */
    public RString get未設定事由９() {
        return entity.getMisetteiJiyu09();
    }

    /**
     * 送信内容１０を返します。
     *
     * @return 送信内容１０
     */
    public RString get送信内容１０() {
        return entity.getSoshinNaiyo10();
    }

    /**
     * 未設定事由１０を返します。
     *
     * @return 未設定事由１０
     */
    public RString get未設定事由１０() {
        return entity.getMisetteiJiyu10();
    }

    /**
     * {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}のクローン
     */
    @Override
    public DbT7304TokuteiKojinJohoTeikyoKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 特定個人情報提供管理の識別子{@link TokuteiKojinJohoTeikyoKanriIdentifier}を返します。
     *
     * @return 特定個人情報提供管理の識別子{@link TokuteiKojinJohoTeikyoKanriIdentifier}
     */
    @Override
    public TokuteiKojinJohoTeikyoKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 特定個人情報提供管理のみを変更対象とします。<br/> {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TokuteiKojinJohoTeikyoKanri}
     */
    public TokuteiKojinJohoTeikyoKanri modifiedModel() {
        DbT7304TokuteiKojinJohoTeikyoKanriEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TokuteiKojinJohoTeikyoKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する特定個人情報提供管理を削除対象とします。<br/> {@link DbT7304TokuteiKojinJohoTeikyoKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TokuteiKojinJohoTeikyoKanri}
     */
    @Override
    public TokuteiKojinJohoTeikyoKanri deleted() {
        DbT7304TokuteiKojinJohoTeikyoKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokuteiKojinJohoTeikyoKanri(deletedEntity, id);
    }

    /**
     * {@link TokuteiKojinJohoTeikyoKanri}のシリアライズ形式を提供します。
     *
     * @return {@link TokuteiKojinJohoTeikyoKanri}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1;
        private final DbT7304TokuteiKojinJohoTeikyoKanriEntity entity;
        private final TokuteiKojinJohoTeikyoKanriIdentifier id;

        private _SerializationProxy(DbT7304TokuteiKojinJohoTeikyoKanriEntity entity, TokuteiKojinJohoTeikyoKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TokuteiKojinJohoTeikyoKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TokuteiKojinJohoTeikyoKanriBuilder createBuilderForEdit() {
        return new TokuteiKojinJohoTeikyoKanriBuilder(entity, id);
    }

}
