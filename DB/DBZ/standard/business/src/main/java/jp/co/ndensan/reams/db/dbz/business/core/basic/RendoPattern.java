/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連動パターンを管理するクラスです。
 */
public class RendoPattern extends 
        ParentModelBase<RendoPatternIdentifier, DbT7035RendoPatternEntity, RendoPattern> implements Serializable {

    private final DbT7035RendoPatternEntity entity;
    private final RendoPatternIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 連動パターンの新規作成時に使用します。
     *
     * @param 送信元市町村コード 送信元市町村コード
     * @param 送信先市町村コード 送信先市町村コード
     * @param 種別 種別
     * @param 有効開始年月日 有効開始年月日
     * @param 有効終了年月日 有効終了年月日
     */
    public RendoPattern(LasdecCode 送信元市町村コード,
            LasdecCode 送信先市町村コード,
            RString 種別,
            FlexibleDate 有効開始年月日,
            FlexibleDate 有効終了年月日) {
        requireNonNull(送信元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村コード"));
        requireNonNull(送信先市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村コード"));
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));
        this.entity = new DbT7035RendoPatternEntity();
        this.entity.setMotoShichosonCode(送信元市町村コード);
        this.entity.setSakiShichosonCode(送信先市町村コード);
        this.entity.setShubetsu(種別);
        this.entity.setYukoKaishiYMD(有効開始年月日);
        this.entity.setYukoShuryoYMD(有効終了年月日);
        this.id = new RendoPatternIdentifier(
                送信元市町村コード,
                送信先市町村コード,
                種別,
                有効開始年月日,
                有効終了年月日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7035RendoPatternEntity}より{@link RendoPattern}を生成します。
     *
     * @param entity DBより取得した{@link DbT7035RendoPatternEntity}
     */
    public RendoPattern(DbT7035RendoPatternEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連動パターン"));
        this.id = new RendoPatternIdentifier(
                entity.getMotoShichosonCode(),
                entity.getSakiShichosonCode(),
                entity.getShubetsu(),
                entity.getYukoKaishiYMD(),
                entity.getYukoShuryoYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7035RendoPatternEntity}
     * @param id {@link RendoPatternIdentifier}
     */
    RendoPattern(
            DbT7035RendoPatternEntity entity,
            RendoPatternIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 送信元市町村コードを返します。
     *
     * @return 送信元市町村コード
     */
    public LasdecCode get送信元市町村コード() {
        return entity.getMotoShichosonCode();
    }

    /**
     * 送信先市町村コードを返します。
     *
     * @return 送信先市町村コード
     */
    public LasdecCode get送信先市町村コード() {
        return entity.getSakiShichosonCode();
    }

    /**
     * 種別を返します。
     *
     * @return 種別
     */
    public RString get種別() {
        return entity.getShubetsu();
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return 有効終了年月日
     */
    public FlexibleDate get有効終了年月日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 連動形態コードを返します。
     *
     * @return 連動形態コード
     */
    public RString get連動形態コード() {
        return entity.getRendoKeitaiCode();
    }

    /**
     * 送信元フォーマットバージョンを返します。
     *
     * @return 送信元フォーマットバージョン
     */
    public RString get送信元フォーマットバージョン() {
        return entity.getMotoFormatVersion();
    }

    /**
     * 送信元エンコーディングを返します。
     *
     * @return 送信元エンコーディング
     */
    public RString get送信元エンコーディング() {
        return entity.getMotoEncodeKeitai();
    }

    /**
     * 送信先フォーマットバージョンを返します。
     *
     * @return 送信先フォーマットバージョン
     */
    public RString get送信先フォーマットバージョン() {
        return entity.getSakiFormatVersion();
    }

    /**
     * 送信先エンコーディングを返します。
     *
     * @return 送信先エンコーディング
     */
    public RString get送信先エンコーディング() {
        return entity.getSakiEncodeKeitai();
    }

    /**
     * コード変換区分を返します。
     *
     * @return コード変換区分
     */
    public RString getコード変換区分() {
        return entity.getCodeHenkanKubun();
    }

    /**
     * 外字変換区分を返します。
     *
     * @return 外字変換区分
     */
    public RString get外字変換区分() {
        return entity.getGaijiHenkanKubun();
    }

    /**
     * 全件連動区分を返します。
     *
     * @return 全件連動区分
     */
    public RString get全件連動区分() {
        return entity.getZenkenRendoKubun();
    }

    /**
     * 連携区分を返します。
     *
     * @return 連携区分
     */
    public RString get連携区分() {
        return entity.getRendoKubun();
    }

    /**
     * {@link DbT7035RendoPatternEntity}のクローンを返します。
     *
     * @return {@link DbT7035RendoPatternEntity}のクローン
     */
    @Override
    public DbT7035RendoPatternEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 連動パターンの識別子{@link RendoPatternIdentifier}を返します。
     *
     * @return 連動パターンの識別子{@link RendoPatternIdentifier}
     */
    @Override
    public RendoPatternIdentifier identifier() {
        return this.id;
    }

    /**
     * 連動パターンのみを変更対象とします。<br/>
     * {@link DbT7035RendoPatternEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RendoPattern}
     */
    @Override
    public RendoPattern modifiedModel() {
        DbT7035RendoPatternEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RendoPattern(
                modifiedEntity, id);
    }

    /**
     * 保持する連動パターンを削除対象とします。<br/>
     * {@link DbT7035RendoPatternEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RendoPattern}
     */
    @Override
    public RendoPattern deleted() {
        DbT7035RendoPatternEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RendoPattern(deletedEntity, id);
    }

    /**
     * {@link RendoPattern}のシリアライズ形式を提供します。
     *
     * @return {@link RendoPattern}のシリアライズ形式
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
        private final DbT7035RendoPatternEntity entity;
        private final RendoPatternIdentifier id;

        private _SerializationProxy(DbT7035RendoPatternEntity entity, RendoPatternIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RendoPattern(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RendoPatternBuilder createBuilderForEdit() {
        return new RendoPatternBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
