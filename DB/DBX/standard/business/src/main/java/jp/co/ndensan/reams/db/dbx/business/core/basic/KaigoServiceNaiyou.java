/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護サービス内容を管理するクラスです。
 */
public class KaigoServiceNaiyou extends
        ModelBase<KaigoServiceNaiyouIdentifier, DbT7131KaigoServiceNaiyouEntity, KaigoServiceNaiyou> 
        implements Serializable {

    private final DbT7131KaigoServiceNaiyouEntity entity;
    private final KaigoServiceNaiyouIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護サービス内容の新規作成時に使用します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 提供開始年月 提供開始年月
     * @param 履歴番号 履歴番号
     */
    public KaigoServiceNaiyou(KaigoServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 提供開始年月,
            Decimal 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7131KaigoServiceNaiyouEntity();
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setServiceKoumokuCode(サービス項目コード);
        this.entity.setTeikyoKaishiYM(提供開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KaigoServiceNaiyouIdentifier(
                サービス種類コード,
                サービス項目コード,
                提供開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7131KaigoServiceNaiyouEntity}より{@link KaigoServiceNaiyou}を生成します。
     *
     * @param entity DBより取得した{@link DbT7131KaigoServiceNaiyouEntity}
     */
    public KaigoServiceNaiyou(DbT7131KaigoServiceNaiyouEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容"));
        this.id = new KaigoServiceNaiyouIdentifier(
                entity.getServiceShuruiCode(),
                entity.getServiceKoumokuCode(),
                entity.getTeikyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7131KaigoServiceNaiyouEntity}
     * @param id {@link KaigoServiceNaiyouIdentifier}
     */
    KaigoServiceNaiyou(
            DbT7131KaigoServiceNaiyouEntity entity,
            KaigoServiceNaiyouIdentifier id
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
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public RString getサービス項目コード() {
        return entity.getServiceKoumokuCode();
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 提供終了年月を返します。
     *
     * @return 提供終了年月
     */
    public FlexibleYearMonth get提供終了年月() {
        return entity.getTeikyoShuryoYM();
    }

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    public RString getサービス名称() {
        return entity.getServiceName();
    }

    /**
     * サービス略称を返します。
     *
     * @return サービス略称
     */
    public RString getサービス略称() {
        return entity.getServiceNameRyaku();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 単位数識別を返します。
     *
     * @return 単位数識別
     */
    public Code get単位数識別() {
        return entity.getTanisuShikibetsuCode().value();
    }

    /**
     * 単位数算定単位を返します。
     *
     * @return 単位数算定単位
     */
    public Code get単位数算定単位() {
        return entity.getTanisuSanteiTani().value();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    public Code get異動事由() {
        return entity.getIdouJiyuCode().value();
    }

    /**
     * {@link DbT7131KaigoServiceNaiyouEntity}のクローンを返します。
     *
     * @return {@link DbT7131KaigoServiceNaiyouEntity}のクローン
     */
    @Override
    public DbT7131KaigoServiceNaiyouEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護サービス内容の識別子{@link KaigoServiceNaiyouIdentifier}を返します。
     *
     * @return 介護サービス内容の識別子{@link KaigoServiceNaiyouIdentifier}
     */
    @Override
    public KaigoServiceNaiyouIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護サービス内容を削除対象とします。<br/>
     * {@link DbT7131KaigoServiceNaiyouEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoServiceNaiyou}
     */
    @Override
    public KaigoServiceNaiyou deleted() {
        DbT7131KaigoServiceNaiyouEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoServiceNaiyou(deletedEntity, id);
    }

    /**
     * {@link KaigoServiceNaiyou}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoServiceNaiyou}のシリアライズ形式
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

        private final DbT7131KaigoServiceNaiyouEntity entity;
        private final KaigoServiceNaiyouIdentifier id;

        private _SerializationProxy(DbT7131KaigoServiceNaiyouEntity entity, KaigoServiceNaiyouIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoServiceNaiyou(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoServiceNaiyouBuilder createBuilderForEdit() {
        return new KaigoServiceNaiyouBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
