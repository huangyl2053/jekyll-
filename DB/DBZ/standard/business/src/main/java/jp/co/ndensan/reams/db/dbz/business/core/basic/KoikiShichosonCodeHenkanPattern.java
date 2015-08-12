/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbz.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.dbz.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域市町村管理コード変換パターンを管理するクラスです。
 */
public class KoikiShichosonCodeHenkanPattern extends ParentModelBase<KoikiShichosonCodeHenkanPatternIdentifier, DbT7024KoikiShichosonCodeHenkanPatternEntity, KoikiShichosonCodeHenkanPattern> implements Serializable {

    private final DbT7024KoikiShichosonCodeHenkanPatternEntity entity;
    private final KoikiShichosonCodeHenkanPatternIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 広域市町村管理コード変換パターンの新規作成時に使用します。
     *
     * @param 広域内市町村番号 広域内市町村番号
     * @param 市町村コード 市町村コード
     * @param コード区分 コード区分
     */
    public KoikiShichosonCodeHenkanPattern(RString 広域内市町村番号,
LasdecCode 市町村コード,
RString コード区分) {
        requireNonNull(広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        this.entity = new DbT7024KoikiShichosonCodeHenkanPatternEntity();
        this.entity.setKoikiShichosonNo(広域内市町村番号);
        this.entity.setShichosonCode(市町村コード);
        this.entity.setCodeKubun(コード区分);
        this.id = new KoikiShichosonCodeHenkanPatternIdentifier(
        広域内市町村番号,
        市町村コード,
        コード区分
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7024KoikiShichosonCodeHenkanPatternEntity}より{@link KoikiShichosonCodeHenkanPattern}を生成します。
     *
     * @param entity DBより取得した{@link DbT7024KoikiShichosonCodeHenkanPatternEntity}
     */
    public KoikiShichosonCodeHenkanPattern(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("広域市町村管理コード変換パターン"));
        this.id = new KoikiShichosonCodeHenkanPatternIdentifier(
                entity.getKoikiShichosonNo(),
                entity.getShichosonCode(),
                entity.getCodeKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}
     * @param id {@link KoikiShichosonCodeHenkanPatternIdentifier}
     */
    KoikiShichosonCodeHenkanPattern(
            DbT7024KoikiShichosonCodeHenkanPatternEntity entity,
            KoikiShichosonCodeHenkanPatternIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 広域内市町村番号を返します。
     *
     * @return 広域内市町村番号
     */
    public RString get広域内市町村番号() {
        return entity.getKoikiShichosonNo();
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
     * コード区分を返します。
     *
     * @return コード区分
     */
    public RString getコード区分() {
        return entity.getCodeKubun();
    }

    /**
     * コード変換テーブル使用区分を返します。
     *
     * @return コード変換テーブル使用区分
     */
    public RString getコード変換テーブル使用区分() {
        return entity.getCodeHenkanTableShiyoUmu();
    }

    /**
     * 自動採番区分を返します。
     *
     * @return 自動採番区分
     */
    public RString get自動採番区分() {
        return entity.getJidoSaibanKubun();
    }

    /**
     * 市町村用コード桁数を返します。
     *
     * @return 市町村用コード桁数
     */
    public int get市町村用コード桁数() {
        return entity.getShichosonCodeKetasu();
    }

    /**
     * 市町村用コード開始位置を返します。
     *
     * @return 市町村用コード開始位置
     */
    public int get市町村用コード開始位置() {
        return entity.getShichosonCodeKaishiIchi();
    }

    /**
     * 市町村用コード使用桁数を返します。
     *
     * @return 市町村用コード使用桁数
     */
    public int get市町村用コード使用桁数() {
        return entity.getShichosonCodeShiyoKetasu();
    }

    /**
     * 市町村用チェックディジット有無区分を返します。
     *
     * @return 市町村用チェックディジット有無区分
     */
    public RString get市町村用チェックディジット有無区分() {
        return entity.getShichosonNinshoNoUmu();
    }

    /**
     * 広域用コード桁数を返します。
     *
     * @return 広域用コード桁数
     */
    public int get広域用コード桁数() {
        return entity.getKoikiCodeKetasu();
    }

    /**
     * 広域用コード開始位置を返します。
     *
     * @return 広域用コード開始位置
     */
    public int get広域用コード開始位置() {
        return entity.getKoikiCodeKaishiIchi();
    }

    /**
     * 広域用コード使用桁数を返します。
     *
     * @return 広域用コード使用桁数
     */
    public int get広域用コード使用桁数() {
        return entity.getKoikiCodeShiyoKetasu();
    }

    /**
     * 広域用チェックディジット有無区分を返します。
     *
     * @return 広域用チェックディジット有無区分
     */
    public RString get広域用チェックディジット有無区分() {
        return entity.getKoikiNinshoNoUmu();
    }

    /**
     * 広域内市町村番号付加区分を返します。
     *
     * @return 広域内市町村番号付加区分
     */
    public RString get広域内市町村番号付加区分() {
        return entity.getShichosonNoFukaKubun();
    }

    /**
     * {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}のクローンを返します。
     *
     * @return {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}のクローン
     */
    @Override
    public DbT7024KoikiShichosonCodeHenkanPatternEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 広域市町村管理コード変換パターンの識別子{@link KoikiShichosonCodeHenkanPatternIdentifier}を返します。
     *
     * @return 広域市町村管理コード変換パターンの識別子{@link KoikiShichosonCodeHenkanPatternIdentifier}
     */
    @Override
    public KoikiShichosonCodeHenkanPatternIdentifier identifier() {
        return this.id;
    }

    /**
     * 広域市町村管理コード変換パターンのみを変更対象とします。<br/>
     * {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KoikiShichosonCodeHenkanPattern}
     */
    @Override
    public KoikiShichosonCodeHenkanPattern modifiedModel() {
        DbT7024KoikiShichosonCodeHenkanPatternEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KoikiShichosonCodeHenkanPattern(
                modifiedEntity, id);
    }

    /**
     * 保持する広域市町村管理コード変換パターンを削除対象とします。<br/>
     * {@link DbT7024KoikiShichosonCodeHenkanPatternEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KoikiShichosonCodeHenkanPattern}
     */
    @Override
    public KoikiShichosonCodeHenkanPattern deleted() {
        DbT7024KoikiShichosonCodeHenkanPatternEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KoikiShichosonCodeHenkanPattern(deletedEntity, id);
    }
    /**
     * {@link KoikiShichosonCodeHenkanPattern}のシリアライズ形式を提供します。
     *
     * @return {@link KoikiShichosonCodeHenkanPattern}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT7024KoikiShichosonCodeHenkanPatternEntity entity;
        private final KoikiShichosonCodeHenkanPatternIdentifier id;

        private _SerializationProxy(DbT7024KoikiShichosonCodeHenkanPatternEntity entity,KoikiShichosonCodeHenkanPatternIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KoikiShichosonCodeHenkanPattern(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KoikiShichosonCodeHenkanPatternBuilder createBuilderForEdit() {
        return new KoikiShichosonCodeHenkanPatternBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
