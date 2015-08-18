/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7061JuryoIninKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受領委任契約事業者を管理するクラスです。
 */
public class JuryoIninKeiyakuJigyosha extends ModelBase<JuryoIninKeiyakuJigyoshaIdentifier, DbT7061JuryoIninKeiyakuJigyoshaEntity, JuryoIninKeiyakuJigyosha> implements Serializable {

    private final DbT7061JuryoIninKeiyakuJigyoshaEntity entity;
    private final JuryoIninKeiyakuJigyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受領委任契約事業者の新規作成時に使用します。
     *
     * @param 受領委任契約事業者番号 受領委任契約事業者番号
     * @param 受領委任契約開始日 受領委任契約開始日
     * @param 契約サービス種別 契約サービス種別
     */
    public JuryoIninKeiyakuJigyosha(KaigoJigyoshaNo 受領委任契約事業者番号,
            FlexibleDate 受領委任契約開始日,
            RString 契約サービス種別) {
        requireNonNull(受領委任契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者番号"));
        requireNonNull(受領委任契約開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約開始日"));
        requireNonNull(契約サービス種別, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種別"));
        this.entity = new DbT7061JuryoIninKeiyakuJigyoshaEntity();
        this.entity.setJigyoshaNo(受領委任契約事業者番号);
        this.entity.setKeiyakuKaishiYMD(受領委任契約開始日);
        this.entity.setServiceShubetsuCode(new ServiceShubetsuCode(契約サービス種別));
        this.id = new JuryoIninKeiyakuJigyoshaIdentifier(
                受領委任契約事業者番号,
                受領委任契約開始日,
                契約サービス種別
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7061JuryoIninKeiyakuJigyoshaEntity}より{@link JuryoIninKeiyakuJigyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT7061JuryoIninKeiyakuJigyoshaEntity}
     */
    public JuryoIninKeiyakuJigyosha(DbT7061JuryoIninKeiyakuJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者"));
        this.id = new JuryoIninKeiyakuJigyoshaIdentifier(
                entity.getJigyoshaNo(),
                entity.getKeiyakuKaishiYMD(),
                entity.getServiceShubetsuCode().getColumnValue());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7061JuryoIninKeiyakuJigyoshaEntity}
     * @param id {@link JuryoIninKeiyakuJigyoshaIdentifier}
     */
    JuryoIninKeiyakuJigyosha(
            DbT7061JuryoIninKeiyakuJigyoshaEntity entity,
            JuryoIninKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 受領委任契約事業者番号を返します。
     *
     * @return 受領委任契約事業者番号
     */
    public KaigoJigyoshaNo get受領委任契約事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 受領委任契約開始日を返します。
     *
     * @return 受領委任契約開始日
     */
    public FlexibleDate get受領委任契約開始日() {
        return entity.getKeiyakuKaishiYMD();
    }

    /**
     * 受領委任契約終了日を返します。
     *
     * @return 受領委任契約終了日
     */
    public FlexibleDate get受領委任契約終了日() {
        return entity.getKeiyakuShuryoYMD();
    }

    /**
     * 契約サービス種別を返します。
     *
     * @return 契約サービス種別
     */
    public RString get契約サービス種別() {
        return entity.getServiceShubetsuCode().getColumnValue();
    }

    /**
     * 契約事業者郵便番号を返します。
     *
     * @return 契約事業者郵便番号
     */
    public YubinNo get契約事業者郵便番号() {
        return entity.getJigyoshaYubinNo();
    }

    /**
     * 契約事業者住所を返します。
     *
     * @return 契約事業者住所
     */
    public AtenaJusho get契約事業者住所() {
        return entity.getJigyoshaJusho();
    }

    /**
     * 契約事業者電話番号を返します。
     *
     * @return 契約事業者電話番号
     */
    public TelNo get契約事業者電話番号() {
        return entity.getJigyoshaTelNo();
    }

    /**
     * 契約事業者FAX番号を返します。
     *
     * @return 契約事業者FAX番号
     */
    public TelNo get契約事業者FAX番号() {
        return entity.getJigyoshaFaxNo();
    }

    /**
     * {@link DbT7061JuryoIninKeiyakuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT7061JuryoIninKeiyakuJigyoshaEntity}のクローン
     */
    @Override
    public DbT7061JuryoIninKeiyakuJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受領委任契約事業者の識別子{@link JuryoIninKeiyakuJigyoshaIdentifier}を返します。
     *
     * @return 受領委任契約事業者の識別子{@link JuryoIninKeiyakuJigyoshaIdentifier}
     */
    @Override
    public JuryoIninKeiyakuJigyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する受領委任契約事業者を削除対象とします。<br/>
     * {@link DbT7061JuryoIninKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JuryoIninKeiyakuJigyosha}
     */
    @Override
    public JuryoIninKeiyakuJigyosha deleted() {
        DbT7061JuryoIninKeiyakuJigyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JuryoIninKeiyakuJigyosha(deletedEntity, id);
    }

    /**
     * {@link JuryoIninKeiyakuJigyosha}のシリアライズ形式を提供します。
     *
     * @return {@link JuryoIninKeiyakuJigyosha}のシリアライズ形式
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

        private final DbT7061JuryoIninKeiyakuJigyoshaEntity entity;
        private final JuryoIninKeiyakuJigyoshaIdentifier id;

        private _SerializationProxy(DbT7061JuryoIninKeiyakuJigyoshaEntity entity, JuryoIninKeiyakuJigyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JuryoIninKeiyakuJigyosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JuryoIninKeiyakuJigyoshaBuilder createBuilderForEdit() {
        return new JuryoIninKeiyakuJigyoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
