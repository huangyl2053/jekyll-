/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防基本チェックリストを管理するクラスです。
 */
public class NijiYoboKihonCheckList extends ModelBase<NijiYoboKihonCheckListIdentifier, DbT3101NijiYoboKihonCheckListEntity, NijiYoboKihonCheckList> implements Serializable {

    private final DbT3101NijiYoboKihonCheckListEntity entity;
    private final NijiYoboKihonCheckListIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 二次予防基本チェックリストの新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public NijiYoboKihonCheckList(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3101NijiYoboKihonCheckListEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setUketsukeYMD(受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new NijiYoboKihonCheckListIdentifier(
                識別コード,
                被保険者番号,
                受付年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3101NijiYoboKihonCheckListEntity}より{@link NijiYoboKihonCheckList}を生成します。
     *
     * @param entity DBより取得した{@link DbT3101NijiYoboKihonCheckListEntity}
     */
    public NijiYoboKihonCheckList(DbT3101NijiYoboKihonCheckListEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防基本チェックリスト"));
        this.id = new NijiYoboKihonCheckListIdentifier(
                entity.getShikibetsuCode(),
                entity.getHihokenshaNo(),
                entity.getUketsukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3101NijiYoboKihonCheckListEntity}
     * @param id {@link NijiYoboKihonCheckListIdentifier}
     */
    NijiYoboKihonCheckList(
            DbT3101NijiYoboKihonCheckListEntity entity,
            NijiYoboKihonCheckListIdentifier id
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 記入年月日を返します。
     *
     * @return 記入年月日
     */
    public FlexibleDate get記入年月日() {
        return entity.getKinyuYMD();
    }

    /**
     * 質問事項１を返します。
     *
     * @return 質問事項１
     */
    public Decimal get質問事項１() {
        return entity.getShitsumonJiko01();
    }

    /**
     * 質問事項２を返します。
     *
     * @return 質問事項２
     */
    public Decimal get質問事項２() {
        return entity.getShitsumonJiko02();
    }

    /**
     * 質問事項３を返します。
     *
     * @return 質問事項３
     */
    public Decimal get質問事項３() {
        return entity.getShitsumonJiko03();
    }

    /**
     * 質問事項４を返します。
     *
     * @return 質問事項４
     */
    public Decimal get質問事項４() {
        return entity.getShitsumonJiko04();
    }

    /**
     * 質問事項５を返します。
     *
     * @return 質問事項５
     */
    public Decimal get質問事項５() {
        return entity.getShitsumonJiko05();
    }

    /**
     * 質問事項６を返します。
     *
     * @return 質問事項６
     */
    public Decimal get質問事項６() {
        return entity.getShitsumonJiko06();
    }

    /**
     * 質問事項７を返します。
     *
     * @return 質問事項７
     */
    public Decimal get質問事項７() {
        return entity.getShitsumonJiko07();
    }

    /**
     * 質問事項８を返します。
     *
     * @return 質問事項８
     */
    public Decimal get質問事項８() {
        return entity.getShitsumonJiko08();
    }

    /**
     * 質問事項９を返します。
     *
     * @return 質問事項９
     */
    public Decimal get質問事項９() {
        return entity.getShitsumonJiko09();
    }

    /**
     * 質問事項１０を返します。
     *
     * @return 質問事項１０
     */
    public Decimal get質問事項１０() {
        return entity.getShitsumonJiko10();
    }

    /**
     * 質問事項１１を返します。
     *
     * @return 質問事項１１
     */
    public Decimal get質問事項１１() {
        return entity.getShitsumonJiko11();
    }

    /**
     * 質問事項１２身長を返します。
     *
     * @return 質問事項１２身長
     */
    public Decimal get質問事項１２身長() {
        return entity.getShitsumonJiko12Shincho();
    }

    /**
     * 質問事項１２体重を返します。
     *
     * @return 質問事項１２体重
     */
    public Decimal get質問事項１２体重() {
        return entity.getShitsumonJiko12Taiju();
    }

    /**
     * 質問事項１３を返します。
     *
     * @return 質問事項１３
     */
    public Decimal get質問事項１３() {
        return entity.getShitsumonJiko13();
    }

    /**
     * 質問事項１４を返します。
     *
     * @return 質問事項１４
     */
    public Decimal get質問事項１４() {
        return entity.getShitsumonJiko14();
    }

    /**
     * 質問事項１５を返します。
     *
     * @return 質問事項１５
     */
    public Decimal get質問事項１５() {
        return entity.getShitsumonJiko15();
    }

    /**
     * 質問事項１６を返します。
     *
     * @return 質問事項１６
     */
    public Decimal get質問事項１６() {
        return entity.getShitsumonJiko16();
    }

    /**
     * 質問事項１７を返します。
     *
     * @return 質問事項１７
     */
    public Decimal get質問事項１７() {
        return entity.getShitsumonJiko17();
    }

    /**
     * 質問事項１８を返します。
     *
     * @return 質問事項１８
     */
    public Decimal get質問事項１８() {
        return entity.getShitsumonJiko18();
    }

    /**
     * 質問事項１９を返します。
     *
     * @return 質問事項１９
     */
    public Decimal get質問事項１９() {
        return entity.getShitsumonJiko19();
    }

    /**
     * 質問事項２０を返します。
     *
     * @return 質問事項２０
     */
    public Decimal get質問事項２０() {
        return entity.getShitsumonJiko20();
    }

    /**
     * 質問事項２１を返します。
     *
     * @return 質問事項２１
     */
    public Decimal get質問事項２１() {
        return entity.getShitsumonJiko21();
    }

    /**
     * 質問事項２２を返します。
     *
     * @return 質問事項２２
     */
    public Decimal get質問事項２２() {
        return entity.getShitsumonJiko22();
    }

    /**
     * 質問事項２３を返します。
     *
     * @return 質問事項２３
     */
    public Decimal get質問事項２３() {
        return entity.getShitsumonJiko23();
    }

    /**
     * 質問事項２４を返します。
     *
     * @return 質問事項２４
     */
    public Decimal get質問事項２４() {
        return entity.getShitsumonJiko24();
    }

    /**
     * 質問事項２５を返します。
     *
     * @return 質問事項２５
     */
    public Decimal get質問事項２５() {
        return entity.getShitsumonJiko25();
    }

    /**
     * {@link DbT3101NijiYoboKihonCheckListEntity}のクローンを返します。
     *
     * @return {@link DbT3101NijiYoboKihonCheckListEntity}のクローン
     */
    @Override
    public DbT3101NijiYoboKihonCheckListEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 二次予防基本チェックリストの識別子{@link NijiYoboKihonCheckListIdentifier}を返します。
     *
     * @return 二次予防基本チェックリストの識別子{@link NijiYoboKihonCheckListIdentifier}
     */
    @Override
    public NijiYoboKihonCheckListIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する二次予防基本チェックリストを削除対象とします。<br/>
     * {@link DbT3101NijiYoboKihonCheckListEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NijiYoboKihonCheckList}
     */
    @Override
    public NijiYoboKihonCheckList deleted() {
        DbT3101NijiYoboKihonCheckListEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NijiYoboKihonCheckList(deletedEntity, id);
    }

    /**
     * {@link NijiYoboKihonCheckList}のシリアライズ形式を提供します。
     *
     * @return {@link NijiYoboKihonCheckList}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public NijiYoboKihonCheckList modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<NijiYoboNiniCheckList> getNijiYoboNiniCheckListList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<NijiYoboCheckListHanteiKekka> getNijiYoboCheckListHanteiKekkaList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3101NijiYoboKihonCheckListEntity entity;
        private final NijiYoboKihonCheckListIdentifier id;

        private _SerializationProxy(DbT3101NijiYoboKihonCheckListEntity entity, NijiYoboKihonCheckListIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NijiYoboKihonCheckList(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NijiYoboKihonCheckListBuilder createBuilderForEdit() {
        return new NijiYoboKihonCheckListBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
