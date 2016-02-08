/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課徴収猶予を管理するクラスです。
 */
public class ChoshuYuyo extends ParentModelBase<ChoshuYuyoIdentifier, DbT2006ChoshuYuyoEntity, ChoshuYuyo> implements Serializable {

    private final DbT2006ChoshuYuyoEntity entity;
    private final ChoshuYuyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護賦課徴収猶予の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public ChoshuYuyo(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            Decimal 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2006ChoshuYuyoEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ChoshuYuyoIdentifier(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2006ChoshuYuyoEntity}より{@link ChoshuYuyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT2006ChoshuYuyoEntity}
     */
    public ChoshuYuyo(DbT2006ChoshuYuyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課徴収猶予"));
        this.id = new ChoshuYuyoIdentifier(
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2006ChoshuYuyoEntity}
     * @param id {@link ChoshuYuyoIdentifier}
     */
    ChoshuYuyo(
            DbT2006ChoshuYuyoEntity entity,
            ChoshuYuyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
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
     * 徴収猶予申請年月日を返します。
     *
     * @return 徴収猶予申請年月日
     */
    public FlexibleDate get徴収猶予申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 徴収猶予決定年月日を返します。
     *
     * @return 徴収猶予決定年月日
     */
    public FlexibleDate get徴収猶予決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 徴収猶予取消年月日を返します。
     *
     * @return 徴収猶予取消年月日
     */
    public FlexibleDate get徴収猶予取消年月日() {
        return entity.getTorikeshiYMD();
    }

    /**
     * 徴収猶予状態区分を返します。
     *
     * @return 徴収猶予状態区分
     */
    public RString get徴収猶予状態区分() {
        return entity.getJotaiKubun();
    }

    /**
     * 徴収猶予作成区分を返します。
     *
     * @return 徴収猶予作成区分
     */
    public RString get徴収猶予作成区分() {
        return entity.getSakuseiKubun();
    }

    /**
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 徴収猶予種類コードを返します。
     *
     * @return 徴収猶予種類コード
     */
    public Code get徴収猶予種類コード() {
        return entity.getYuyoJiyuCode();
    }

    /**
     * 徴収猶予事由を返します。
     *
     * @return 徴収猶予事由
     */
    public RString get徴収猶予事由() {
        return entity.getYuyoJiyu();
    }

    /**
     * 徴収猶予取消種類コードを返します。
     *
     * @return 徴収猶予取消種類コード
     */
    public Code get徴収猶予取消種類コード() {
        return entity.getYuyoTorikeshiJiyuCode();
    }

    /**
     * 徴収猶予取消事由を返します。
     *
     * @return 徴収猶予取消事由
     */
    public RString get徴収猶予取消事由() {
        return entity.getYuyoTorikeshiJiyu();
    }

    /**
     * {@link DbT2006ChoshuYuyoEntity}のクローンを返します。
     *
     * @return {@link DbT2006ChoshuYuyoEntity}のクローン
     */
    @Override
    public DbT2006ChoshuYuyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護賦課徴収猶予の識別子{@link ChoshuYuyoIdentifier}を返します。
     *
     * @return 介護賦課徴収猶予の識別子{@link ChoshuYuyoIdentifier}
     */
    @Override
    public ChoshuYuyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護賦課徴収猶予を削除対象とします。<br/>
     * {@link DbT2006ChoshuYuyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChoshuYuyo}
     */
    @Override
    public ChoshuYuyo deleted() {
        DbT2006ChoshuYuyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChoshuYuyo(deletedEntity, id);
    }

    /**
     * {@link ChoshuYuyo}のシリアライズ形式を提供します。
     *
     * @return {@link ChoshuYuyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ChoshuYuyo modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KibetsuChoshuYuyo> getKibetsuChoshuYuyoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT2006ChoshuYuyoEntity entity;
        private final ChoshuYuyoIdentifier id;

        private _SerializationProxy(DbT2006ChoshuYuyoEntity entity, ChoshuYuyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChoshuYuyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChoshuYuyoBuilder createBuilderForEdit() {
        return new ChoshuYuyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
