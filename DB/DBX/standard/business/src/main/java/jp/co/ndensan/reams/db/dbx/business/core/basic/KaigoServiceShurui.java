/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護サービス種類を管理するクラスです。
 */
public class KaigoServiceShurui extends
        ParentModelBase<KaigoServiceShuruiIdentifier, DbT7130KaigoServiceShuruiEntity, KaigoServiceShurui>
        implements Serializable {

    private final DbT7130KaigoServiceShuruiEntity entity;
    private final KaigoServiceShuruiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護サービス種類の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 提供開始年月 提供開始年月
     */
    public KaigoServiceShurui(KaigoServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        this.entity = new DbT7130KaigoServiceShuruiEntity();
        this.entity.setServiceShuruiCd(サービス種類コード);
        this.entity.setTeikyoKaishiYM(提供開始年月);
        this.id = new KaigoServiceShuruiIdentifier(
                サービス種類コード,
                提供開始年月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7130KaigoServiceShuruiEntity}より{@link KaigoServiceShurui}を生成します。
     *
     * @param entity DBより取得した{@link DbT7130KaigoServiceShuruiEntity}
     */
    public KaigoServiceShurui(DbT7130KaigoServiceShuruiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類"));
        this.id = new KaigoServiceShuruiIdentifier(
                entity.getServiceShuruiCd(),
                entity.getTeikyoKaishiYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7130KaigoServiceShuruiEntity}
     * @param id {@link KaigoServiceShuruiIdentifier}
     */
    KaigoServiceShurui(
            DbT7130KaigoServiceShuruiEntity entity,
            KaigoServiceShuruiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public KaigoServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCd();
    }

    /**
     * 提供開始年月を返します。
     *
     * @return 提供開始年月
     */
    public FlexibleYearMonth get提供開始年月() {
        return entity.getTeikyoKaishiYM();
    }

    /**
     * 提供終了年月を返します。
     *
     * @return 提供終了年月
     */
    public FlexibleYearMonth get提供終了年月() {
        return entity.getTeikyoshuryoYM();
    }

    /**
     * サービス種類名称を返します。
     *
     * @return サービス種類名称
     */
    public RString getサービス種類名称() {
        return entity.getServiceShuruiMeisho();
    }

    /**
     * サービス種類略称を返します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return entity.getServiceShuruiRyakusho();
    }

    /**
     * サービス分類コードを返します。
     *
     * @return サービス分類コード
     */
    public Code getサービス分類コード() {
        return entity.getServiceBunrruicode().value();
    }

    /**
     * {@link DbT7130KaigoServiceShuruiEntity}のクローンを返します。
     *
     * @return {@link DbT7130KaigoServiceShuruiEntity}のクローン
     */
    @Override
    public DbT7130KaigoServiceShuruiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護サービス種類の識別子{@link KaigoServiceShuruiIdentifier}を返します。
     *
     * @return 介護サービス種類の識別子{@link KaigoServiceShuruiIdentifier}
     */
    @Override
    public KaigoServiceShuruiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護サービス種類を削除対象とします。<br/>
     * {@link DbT7130KaigoServiceShuruiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoServiceShurui}
     */
    @Override
    public KaigoServiceShurui deleted() {
        DbT7130KaigoServiceShuruiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoServiceShurui(deletedEntity, id);
    }

    /**
     * {@link KaigoServiceShurui}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoServiceShurui}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KaigoServiceShurui modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KaigoServiceNaiyou> getKaigoServiceNaiyouList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7130KaigoServiceShuruiEntity entity;
        private final KaigoServiceShuruiIdentifier id;

        private _SerializationProxy(DbT7130KaigoServiceShuruiEntity entity, KaigoServiceShuruiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoServiceShurui(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoServiceShuruiBuilder createBuilderForEdit() {
        return new KaigoServiceShuruiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
