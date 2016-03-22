/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受領委任契約事業者を管理するクラスです。
 */
public class JuryoininKeiyakuJigyosha
        extends ModelBase<JuryoininKeiyakuJigyoshaIdentifier, DbT3077JuryoininKeiyakuJigyoshaEntity, JuryoininKeiyakuJigyosha>
        implements Serializable {

    private final DbT3077JuryoininKeiyakuJigyoshaEntity entity;
    private final JuryoininKeiyakuJigyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 受領委任契約事業者の新規作成時に使用します。
     *
     * @param 事業者契約番号 事業者契約番号
     */
    public JuryoininKeiyakuJigyosha(RString 事業者契約番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));
        this.entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        this.entity.setKeiyakuJigyoshaNo(事業者契約番号);
        this.id = new JuryoininKeiyakuJigyoshaIdentifier(事業者契約番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3077JuryoininKeiyakuJigyoshaEntity}より{@link JuryoininKeiyakuJigyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT3077JuryoininKeiyakuJigyoshaEntity}
     */
    public JuryoininKeiyakuJigyosha(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));
        this.id = new JuryoininKeiyakuJigyoshaIdentifier(
                entity.getKeiyakuJigyoshaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3077JuryoininKeiyakuJigyoshaEntity}
     * @param id {@link JuryoininKeiyakuJigyoshaIdentifier}
     */
    JuryoininKeiyakuJigyosha(
            DbT3077JuryoininKeiyakuJigyoshaEntity entity,
            JuryoininKeiyakuJigyoshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 事業者契約番号を返します。
     *
     * @return 事業者契約番号
     */
    public RString get事業者契約番号() {
        return entity.getKeiyakuJigyoshaNo();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getShuryoYMD();
    }

    /**
     * 契約種類を返します。
     *
     * @return 契約種類
     */
    public RString get契約種類() {
        return entity.getKeiyakuShurui();
    }

    /**
     * 契約事業者名称を返します。
     *
     * @return 契約事業者名称
     */
    public AtenaMeisho get契約事業者名称() {
        return entity.getKeiyakuJigyoshaName();
    }

    /**
     * 契約事業者カナ名称を返します。
     *
     * @return 契約事業者カナ名称
     */
    public AtenaKanaMeisho get契約事業者カナ名称() {
        return entity.getKeiyakuJigyoshaKanaName();
    }

    /**
     * 契約事業者郵便番号を返します。
     *
     * @return 契約事業者郵便番号
     */
    public YubinNo get契約事業者郵便番号() {
        return entity.getKeiyakuJigyoshaYubinNo();
    }

    /**
     * 契約事業者住所を返します。
     *
     * @return 契約事業者住所
     */
    public AtenaJusho get契約事業者住所() {
        return entity.getKeiyakuJigyoshaJusho();
    }

    /**
     * 契約代表者氏名を返します。
     *
     * @return 契約代表者氏名
     */
    public AtenaMeisho get契約代表者氏名() {
        return entity.getKeiyakuDaihyoshaName();
    }

    /**
     * 契約事業者電話番号を返します。
     *
     * @return 契約事業者電話番号
     */
    public TelNo get契約事業者電話番号() {
        return entity.getKeiyakuJigyoshaTelNo();
    }

    /**
     * 契約事業者FAX番号を返します。
     *
     * @return 契約事業者FAX番号
     */
    public TelNo get契約事業者FAX番号() {
        return entity.getKeiyakuJigyoshaFaxNo();
    }

    /**
     * 送付先郵便番号を返します。
     *
     * @return 送付先郵便番号
     */
    public YubinNo get送付先郵便番号() {
        return entity.getSofusakiYubinNo();
    }

    /**
     * 送付先住所を返します。
     *
     * @return 送付先住所
     */
    public AtenaJusho get送付先住所() {
        return entity.getSofusakiJusho();
    }

    /**
     * 送付先部署を返します。
     *
     * @return 送付先部署
     */
    public RString get送付先部署() {
        return entity.getSofusakiBusho();
    }

    /**
     * 送付先事業者名称を返します。
     *
     * @return 送付先事業者名称
     */
    public AtenaMeisho get送付先事業者名称() {
        return entity.getSofusakiJigyoshaName();
    }

    /**
     * 送付先事業者カナ名称を返します。
     *
     * @return 送付先事業者カナ名称
     */
    public AtenaKanaMeisho get送付先事業者カナ名称() {
        return entity.getSofusakiJigyoshaKanaName();
    }

    /**
     * 金融機関コードを返します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode get金融機関コード() {
        return entity.getKinyuKikanCode();
    }

    /**
     * 支店コードを返します。
     *
     * @return 支店コード
     */
    public KinyuKikanShitenCode get支店コード() {
        return entity.getShitenCode();
    }

    /**
     * 口座種別を返します。
     *
     * @return 口座種別
     */
    public RString get口座種別() {
        return entity.getKozaShubetsu();
    }

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return entity.getKozaNo();
    }

    /**
     * 口座名義人を返します。
     *
     * @return 口座名義人
     */
    public AtenaMeisho get口座名義人() {
        return entity.getKozaMeiginin();
    }

    /**
     * 口座名義人カナを返します。
     *
     * @return 口座名義人カナ
     */
    public AtenaKanaMeisho get口座名義人カナ() {
        return entity.getKozaMeigininKana();
    }

    /**
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3077JuryoininKeiyakuJigyoshaEntity}のクローン
     */
    @Override
    public DbT3077JuryoininKeiyakuJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 受領委任契約事業者の識別子{@link JuryoininKeiyakuJigyoshaIdentifier}を返します。
     *
     * @return 受領委任契約事業者の識別子{@link JuryoininKeiyakuJigyoshaIdentifier}
     */
    @Override
    public JuryoininKeiyakuJigyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する受領委任契約事業者を削除対象とします。<br/>
     * {@link DbT3077JuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JuryoininKeiyakuJigyosha}
     */
    @Override
    public JuryoininKeiyakuJigyosha deleted() {
        DbT3077JuryoininKeiyakuJigyoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JuryoininKeiyakuJigyosha(deletedEntity, id);
    }

    /**
     * {@link JuryoininKeiyakuJigyosha}のシリアライズ形式を提供します。
     *
     * @return {@link JuryoininKeiyakuJigyosha}のシリアライズ形式
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

        private final DbT3077JuryoininKeiyakuJigyoshaEntity entity;
        private final JuryoininKeiyakuJigyoshaIdentifier id;

        private _SerializationProxy(DbT3077JuryoininKeiyakuJigyoshaEntity entity, JuryoininKeiyakuJigyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JuryoininKeiyakuJigyosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JuryoininKeiyakuJigyoshaBuilder createBuilderForEdit() {
        return new JuryoininKeiyakuJigyoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
