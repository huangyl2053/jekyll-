/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 資格検索Aliveを管理するクラスです。
 */
public class ShikakuSearchAlive extends 
        ParentModelBase<ShikakuSearchAliveIdentifier, 
        DbV7901ShikakuSearchEntity, ShikakuSearchAlive> implements Serializable {

    private final DbV7901ShikakuSearchEntity entity;
    private final ShikakuSearchAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 資格検索Aliveの新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public ShikakuSearchAlive(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.entity = new DbV7901ShikakuSearchEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.id = new ShikakuSearchAliveIdentifier(
                被保険者番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV7901ShikakuSearchEntity}より{@link ShikakuSearchAlive}を生成します。
     *
     * @param entity DBより取得した{@link DbV7901ShikakuSearchEntity}
     */
    public ShikakuSearchAlive(DbV7901ShikakuSearchEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("資格検索Alive"));
        this.id = new ShikakuSearchAliveIdentifier(
                entity.getHihokenshaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV7901ShikakuSearchEntity}
     * @param id {@link ShikakuSearchAliveIdentifier}
     */
    ShikakuSearchAlive(
            DbV7901ShikakuSearchEntity entity,
            ShikakuSearchAliveIdentifier id
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
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 資格変更事由コードを返します。
     *
     * @return 資格変更事由コード
     */
    public RString get資格変更事由コード() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更年月日を返します。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate get資格変更年月日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 住所地特例適用事由コードを返します。
     *
     * @return 住所地特例適用事由コード
     */
    public RString get住所地特例適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 住所地特例適用年月日を返します。
     *
     * @return 住所地特例適用年月日
     */
    public FlexibleDate get住所地特例適用年月日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 住所地特例解除事由コードを返します。
     *
     * @return 住所地特例解除事由コード
     */
    public RString get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 住所地特例解除年月日を返します。
     *
     * @return 住所地特例解除年月日
     */
    public FlexibleDate get住所地特例解除年月日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 広域内住所地特例フラグを返します。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString get広域内住所地特例フラグ() {
        return entity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 適用除外適用事由コードを返します。
     *
     * @return 適用除外適用事由コード
     */
    public RString get適用除外適用事由コード() {
        return entity.getTekiyoJogaiTekiyoJiyuCode();
    }

    /**
     * 適用除外適用年月日を返します。
     *
     * @return 適用除外適用年月日
     */
    public FlexibleDate get適用除外適用年月日() {
        return entity.getTekiyoJogaiTekiyoYMD();
    }

    /**
     * 適用除外解除事由コードを返します。
     *
     * @return 適用除外解除事由コード
     */
    public RString get適用除外解除事由コード() {
        return entity.getTekiyoJogaikaijokaijoJiyuCode();
    }

    /**
     * 適用除外解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get適用除外解除年月日() {
        return entity.getTekiyoJogaiKaijoYMD();
    }

    /**
     * 他市町村住所地特例適用事由コードを返します。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public RString get他市町村住所地特例適用事由コード() {
        return entity.getTatokureiTekiyoJiyuCode();
    }

    /**
     * 他市町村住所地特例適用年月日を返します。
     *
     * @return 他市町村住所地特例適用年月日
     */
    public FlexibleDate get他市町村住所地特例適用年月日() {
        return entity.getTatokureiTekiyoYMD();
    }

    /**
     * 他市町村住所地特例解除事由コードを返します。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public RString get他市町村住所地特例解除事由コード() {
        return entity.getTatokureiKaijoJiyuCode();
    }

    /**
     * 他市町村住所地特例解除年月日を返します。
     *
     * @return 他市町村住所地特例解除年月日
     */
    public FlexibleDate get他市町村住所地特例解除年月日() {
        return entity.getTatokureiKaijoYMD();
    }

    /**
     * 受給者台帳被保険者番号を返します。
     *
     * @return 受給者台帳被保険者番号
     */
    public HihokenshaNo get受給者台帳被保険者番号() {
        return entity.getJukyushaDaichoHihokenshaNo();
    }

    /**
     * {@link DbV7901ShikakuSearchEntity}のクローンを返します。
     *
     * @return {@link DbV7901ShikakuSearchEntity}のクローン
     */
    @Override
    public DbV7901ShikakuSearchEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 資格検索Aliveの識別子{@link ShikakuSearchAliveIdentifier}を返します。
     *
     * @return 資格検索Aliveの識別子{@link ShikakuSearchAliveIdentifier}
     */
    @Override
    public ShikakuSearchAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 資格検索Aliveのみを変更対象とします。<br/>
     * {@link DbV7901ShikakuSearchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShikakuSearchAlive}
     */
    @Override
    public ShikakuSearchAlive modifiedModel() {
        DbV7901ShikakuSearchEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShikakuSearchAlive(
                modifiedEntity, id);
    }

    /**
     * 保持する資格検索Aliveを削除対象とします。<br/>
     * {@link DbV7901ShikakuSearchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShikakuSearchAlive}
     */
    @Override
    public ShikakuSearchAlive deleted() {
        DbV7901ShikakuSearchEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShikakuSearchAlive(deletedEntity, id);
    }

    /**
     * {@link ShikakuSearchAlive}のシリアライズ形式を提供します。
     *
     * @return {@link ShikakuSearchAlive}のシリアライズ形式
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
        private final DbV7901ShikakuSearchEntity entity;
        private final ShikakuSearchAliveIdentifier id;

        private _SerializationProxy(DbV7901ShikakuSearchEntity entity, ShikakuSearchAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShikakuSearchAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShikakuSearchAliveBuilder createBuilderForEdit() {
        return new ShikakuSearchAliveBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
