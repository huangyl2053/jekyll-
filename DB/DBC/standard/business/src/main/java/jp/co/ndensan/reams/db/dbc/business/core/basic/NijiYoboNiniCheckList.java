/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防任意チェックリストを管理するクラスです。
 */
public class NijiYoboNiniCheckList extends ModelBase<NijiYoboNiniCheckListIdentifier, DbT3102NijiYoboNiniCheckListEntity, NijiYoboNiniCheckList> implements Serializable {

    private final DbT3102NijiYoboNiniCheckListEntity entity;
    private final NijiYoboNiniCheckListIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 二次予防任意チェックリストの新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 任意質問番号 任意質問番号
     * @param 履歴番号 履歴番号
     */
    public NijiYoboNiniCheckList(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 任意質問番号,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(任意質問番号, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3102NijiYoboNiniCheckListEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setUketsukeYMD(受付年月日);
        this.entity.setNiniShitsumonNo(任意質問番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new NijiYoboNiniCheckListIdentifier(
                識別コード,
                被保険者番号,
                受付年月日,
                任意質問番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3102NijiYoboNiniCheckListEntity}より{@link NijiYoboNiniCheckList}を生成します。
     *
     * @param entity DBより取得した{@link DbT3102NijiYoboNiniCheckListEntity}
     */
    public NijiYoboNiniCheckList(DbT3102NijiYoboNiniCheckListEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防任意チェックリスト"));
        this.id = new NijiYoboNiniCheckListIdentifier(
                entity.getShikibetsuCode(),
                entity.getHihokenshaNo(),
                entity.getUketsukeYMD(),
                entity.getNiniShitsumonNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3102NijiYoboNiniCheckListEntity}
     * @param id {@link NijiYoboNiniCheckListIdentifier}
     */
    NijiYoboNiniCheckList(
            DbT3102NijiYoboNiniCheckListEntity entity,
            NijiYoboNiniCheckListIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 任意質問番号を返します。
     *
     * @return 任意質問番号
     */
    public Decimal get任意質問番号() {
        return entity.getNiniShitsumonNo();
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
     * 任意質問事項を返します。
     *
     * @return 任意質問事項
     */
    public Decimal get任意質問事項() {
        return entity.getNiniShitsumonJiko();
    }

    /**
     * {@link DbT3102NijiYoboNiniCheckListEntity}のクローンを返します。
     *
     * @return {@link DbT3102NijiYoboNiniCheckListEntity}のクローン
     */
    @Override
    public DbT3102NijiYoboNiniCheckListEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 二次予防任意チェックリストの識別子{@link NijiYoboNiniCheckListIdentifier}を返します。
     *
     * @return 二次予防任意チェックリストの識別子{@link NijiYoboNiniCheckListIdentifier}
     */
    @Override
    public NijiYoboNiniCheckListIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する二次予防任意チェックリストを削除対象とします。<br/>
     * {@link DbT3102NijiYoboNiniCheckListEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NijiYoboNiniCheckList}
     */
    @Override
    public NijiYoboNiniCheckList deleted() {
        DbT3102NijiYoboNiniCheckListEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NijiYoboNiniCheckList(deletedEntity, id);
    }

    /**
     * {@link NijiYoboNiniCheckList}のシリアライズ形式を提供します。
     *
     * @return {@link NijiYoboNiniCheckList}のシリアライズ形式
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

        private final DbT3102NijiYoboNiniCheckListEntity entity;
        private final NijiYoboNiniCheckListIdentifier id;

        private _SerializationProxy(DbT3102NijiYoboNiniCheckListEntity entity, NijiYoboNiniCheckListIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NijiYoboNiniCheckList(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NijiYoboNiniCheckListBuilder createBuilderForEdit() {
        return new NijiYoboNiniCheckListBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
