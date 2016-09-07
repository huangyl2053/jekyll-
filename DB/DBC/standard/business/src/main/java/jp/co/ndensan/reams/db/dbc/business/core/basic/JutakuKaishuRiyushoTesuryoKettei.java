/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 住宅改修理由書作成手数料請求決定を管理するクラスです。
 */
public class JutakuKaishuRiyushoTesuryoKettei
       extends ModelBase<JutakuKaishuRiyushoTesuryoKetteiIdentifier, DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity, JutakuKaishuRiyushoTesuryoKettei>
       implements Serializable {

    private final DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity;
    private final JutakuKaishuRiyushoTesuryoKetteiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 住宅改修理由書作成手数料請求決定の新規作成時に使用します。
     *
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     * @param 決定年月日 決定年月日
     * @param 履歴番号 履歴番号
     */
    public JutakuKaishuRiyushoTesuryoKettei(JigyoshaNo 介護住宅改修理由書作成事業者番号,
            FlexibleDate 決定年月日,
            Decimal 履歴番号) {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
        this.entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
        this.entity.setKetteiYMD(決定年月日);
        this.entity.setRirekiNo(履歴番号.intValue());
        this.id = new JutakuKaishuRiyushoTesuryoKetteiIdentifier(
                介護住宅改修理由書作成事業者番号,
                決定年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}より{@link JutakuKaishuRiyushoTesuryoKettei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}
     */
    public JutakuKaishuRiyushoTesuryoKettei(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求決定"));
        this.id = new JutakuKaishuRiyushoTesuryoKetteiIdentifier(
                entity.getRiyushoSakuseiJigyoshaNo(),
                entity.getKetteiYMD(),
                new Decimal(entity.getRirekiNo()));
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}
     * @param id {@link JutakuKaishuRiyushoTesuryoKetteiIdentifier}
     */
    JutakuKaishuRiyushoTesuryoKettei(
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity,
            JutakuKaishuRiyushoTesuryoKetteiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 介護住宅改修理由書作成事業者番号を返します。
     *
     * @return 介護住宅改修理由書作成事業者番号
     */
    public JigyoshaNo get介護住宅改修理由書作成事業者番号() {
        return entity.getRiyushoSakuseiJigyoshaNo();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return new Decimal(entity.getRirekiNo());
    }

    /**
     * 支給・不支給決定年月日を返します。
     *
     * @return 支給・不支給決定年月日
     */
    public FlexibleDate get支給_不支給決定年月日() {
        return entity.getShikyu_FushikyuKetteiYMD();
    }

    /**
     * 支給・不支給区分を返します。
     *
     * @return 支給・不支給区分
     */
    public RString get支給_不支給区分() {
        return entity.getShikyu_FushikyuKubun();
    }

    /**
     * 償還不支給理由等を返します。
     *
     * @return 償還不支給理由等
     */
    public RString get償還不支給理由等() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 住宅改修理由書作成手数料支払予定日を返します。
     *
     * @return 住宅改修理由書作成手数料支払予定日
     */
    public FlexibleDate get住宅改修理由書作成手数料支払予定日() {
        return entity.getTesuryoShiharaiYoteiYMD();
    }

    /**
     * {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}のクローンを返します。
     *
     * @return {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}のクローン
     */
    @Override
    public DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 住宅改修理由書作成手数料請求決定の識別子{@link JutakuKaishuRiyushoTesuryoKetteiIdentifier}を返します。
     *
     * @return 住宅改修理由書作成手数料請求決定の識別子{@link JutakuKaishuRiyushoTesuryoKetteiIdentifier}
     */
    @Override
    public JutakuKaishuRiyushoTesuryoKetteiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する住宅改修理由書作成手数料請求決定を削除対象とします。<br/>
     * {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JutakuKaishuRiyushoTesuryoKettei}
     */
    @Override
    public JutakuKaishuRiyushoTesuryoKettei deleted() {
        DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JutakuKaishuRiyushoTesuryoKettei(deletedEntity, id);
    }

    /**
     * {@link JutakuKaishuRiyushoTesuryoKettei}のシリアライズ形式を提供します。
     *
     * @return {@link JutakuKaishuRiyushoTesuryoKettei}のシリアライズ形式
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

        private final DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity;
        private final JutakuKaishuRiyushoTesuryoKetteiIdentifier id;

        private _SerializationProxy(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity, JutakuKaishuRiyushoTesuryoKetteiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JutakuKaishuRiyushoTesuryoKettei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JutakuKaishuRiyushoTesuryoKetteiBuilder createBuilderForEdit() {
        return new JutakuKaishuRiyushoTesuryoKetteiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
