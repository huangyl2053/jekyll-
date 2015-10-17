/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者施設入退所Aliveを管理するクラスです。
 */
public class HihokenshaShisetsuNyutaishoAlive extends ModelBase<HihokenshaShisetsuNyutaishoAliveIdentifier, DbV1004HihokenshaShisetsuNyutaishoEntity, HihokenshaShisetsuNyutaishoAlive> implements Serializable {

    private final DbV1004HihokenshaShisetsuNyutaishoEntity entity;
    private final HihokenshaShisetsuNyutaishoAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 被保険者施設入退所Aliveの新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public HihokenshaShisetsuNyutaishoAlive(ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbV1004HihokenshaShisetsuNyutaishoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new HihokenshaShisetsuNyutaishoAliveIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV1004HihokenshaShisetsuNyutaishoEntity}より{@link HihokenshaShisetsuNyutaishoAlive}を生成します。
     *
     * @param entity DBより取得した{@link DbV1004HihokenshaShisetsuNyutaishoEntity}
     */
    public HihokenshaShisetsuNyutaishoAlive(DbV1004HihokenshaShisetsuNyutaishoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者施設入退所Alive"));
        this.id = new HihokenshaShisetsuNyutaishoAliveIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV1004HihokenshaShisetsuNyutaishoEntity}
     * @param id {@link HihokenshaShisetsuNyutaishoAliveIdentifier}
     */
    HihokenshaShisetsuNyutaishoAlive(
            DbV1004HihokenshaShisetsuNyutaishoEntity entity,
            HihokenshaShisetsuNyutaishoAliveIdentifier id
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
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
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 入所施設種類を返します。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return entity.getNyushoShisetsuShurui();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return new JigyoshaNo(entity.getNyushoShisetsuCode().getColumnValue());
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * {@link DbV1004HihokenshaShisetsuNyutaishoEntity}のクローンを返します。
     *
     * @return {@link DbV1004HihokenshaShisetsuNyutaishoEntity}のクローン
     */
    @Override
    public DbV1004HihokenshaShisetsuNyutaishoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 被保険者施設入退所Aliveの識別子{@link HihokenshaShisetsuNyutaishoAliveIdentifier}を返します。
     *
     * @return
     * 被保険者施設入退所Aliveの識別子{@link HihokenshaShisetsuNyutaishoAliveIdentifier}
     */
    @Override
    public HihokenshaShisetsuNyutaishoAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する被保険者施設入退所Aliveを削除対象とします。<br/>
     * {@link DbV1004HihokenshaShisetsuNyutaishoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link HihokenshaShisetsuNyutaishoAlive}
     */
    @Override
    public HihokenshaShisetsuNyutaishoAlive deleted() {
        DbV1004HihokenshaShisetsuNyutaishoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HihokenshaShisetsuNyutaishoAlive(deletedEntity, id);
    }

    /**
     * {@link HihokenshaShisetsuNyutaishoAlive}のシリアライズ形式を提供します。
     *
     * @return {@link HihokenshaShisetsuNyutaishoAlive}のシリアライズ形式
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

        private final DbV1004HihokenshaShisetsuNyutaishoEntity entity;
        private final HihokenshaShisetsuNyutaishoAliveIdentifier id;

        private _SerializationProxy(DbV1004HihokenshaShisetsuNyutaishoEntity entity, HihokenshaShisetsuNyutaishoAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new HihokenshaShisetsuNyutaishoAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public HihokenshaShisetsuNyutaishoAliveBuilder createBuilderForEdit() {
        return new HihokenshaShisetsuNyutaishoAliveBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
