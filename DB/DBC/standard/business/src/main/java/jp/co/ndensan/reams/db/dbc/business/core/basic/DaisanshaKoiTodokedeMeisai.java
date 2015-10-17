/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3085DaisanshaKoiTodokedeMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為届出詳細を管理するクラスです。
 */
public class DaisanshaKoiTodokedeMeisai extends ModelBase<DaisanshaKoiTodokedeMeisaiIdentifier, DbT3085DaisanshaKoiTodokedeMeisaiEntity, DaisanshaKoiTodokedeMeisai> implements Serializable {

    private final DbT3085DaisanshaKoiTodokedeMeisaiEntity entity;
    private final DaisanshaKoiTodokedeMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護第三者行為届出詳細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiTodokedeMeisai(HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3085DaisanshaKoiTodokedeMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTodokedeKanriNo(第三者行為届出管理番号);
        this.entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DaisanshaKoiTodokedeMeisaiIdentifier(
                被保険者番号,
                第三者行為届出管理番号,
                サービス提供事業者番号,
                サービス種類コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}より{@link DaisanshaKoiTodokedeMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}
     */
    public DaisanshaKoiTodokedeMeisai(DbT3085DaisanshaKoiTodokedeMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為届出詳細"));
        this.id = new DaisanshaKoiTodokedeMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTodokedeKanriNo(),
                entity.getServiceTeikyoJigyoshaNo(),
                entity.getServiceShuruiCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}
     * @param id {@link DaisanshaKoiTodokedeMeisaiIdentifier}
     */
    DaisanshaKoiTodokedeMeisai(
            DbT3085DaisanshaKoiTodokedeMeisaiEntity entity,
            DaisanshaKoiTodokedeMeisaiIdentifier id
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
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
    }

    /**
     * サービス提供事業者番号を返します。
     *
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getサービス提供事業者番号() {
        return entity.getServiceTeikyoJigyoshaNo();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * サービス利用開始年月日を返します。
     *
     * @return サービス利用開始年月日
     */
    public FlexibleDate getサービス利用開始年月日() {
        return entity.getServiceRiyoKaishiYMD();
    }

    /**
     * {@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}のクローン
     */
    @Override
    public DbT3085DaisanshaKoiTodokedeMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護第三者行為届出詳細の識別子{@link DaisanshaKoiTodokedeMeisaiIdentifier}を返します。
     *
     * @return 介護第三者行為届出詳細の識別子{@link DaisanshaKoiTodokedeMeisaiIdentifier}
     */
    @Override
    public DaisanshaKoiTodokedeMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護第三者行為届出詳細を削除対象とします。<br/>
     * {@link DbT3085DaisanshaKoiTodokedeMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DaisanshaKoiTodokedeMeisai}
     */
    @Override
    public DaisanshaKoiTodokedeMeisai deleted() {
        DbT3085DaisanshaKoiTodokedeMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DaisanshaKoiTodokedeMeisai(deletedEntity, id);
    }

    /**
     * {@link DaisanshaKoiTodokedeMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link DaisanshaKoiTodokedeMeisai}のシリアライズ形式
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

        private final DbT3085DaisanshaKoiTodokedeMeisaiEntity entity;
        private final DaisanshaKoiTodokedeMeisaiIdentifier id;

        private _SerializationProxy(DbT3085DaisanshaKoiTodokedeMeisaiEntity entity, DaisanshaKoiTodokedeMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DaisanshaKoiTodokedeMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DaisanshaKoiTodokedeMeisaiBuilder createBuilderForEdit() {
        return new DaisanshaKoiTodokedeMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
