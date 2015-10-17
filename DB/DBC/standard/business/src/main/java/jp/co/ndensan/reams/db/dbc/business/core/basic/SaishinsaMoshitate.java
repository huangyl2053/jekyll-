/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 再審査申立を管理するクラスです。
 */
public class SaishinsaMoshitate extends ModelBase<SaishinsaMoshitateIdentifier, DbT3062SaishinsaMoshitateEntity, SaishinsaMoshitate> implements Serializable {

    private final DbT3062SaishinsaMoshitateEntity entity;
    private final SaishinsaMoshitateIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 再審査申立の新規作成時に使用します。
     *
     * @param 事業所番号 事業所番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 履歴番号 履歴番号
     */
    public SaishinsaMoshitate(JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            Decimal 履歴番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3062SaishinsaMoshitateEntity();
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setServiceTeikyoShuruiCode(サービス種類コード);
        this.entity.setServiceKomokuCode(サービス項目コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new SaishinsaMoshitateIdentifier(
                事業所番号,
                被保険者番号,
                サービス提供年月,
                サービス種類コード,
                サービス項目コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3062SaishinsaMoshitateEntity}より{@link SaishinsaMoshitate}を生成します。
     *
     * @param entity DBより取得した{@link DbT3062SaishinsaMoshitateEntity}
     */
    public SaishinsaMoshitate(DbT3062SaishinsaMoshitateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査申立"));
        this.id = new SaishinsaMoshitateIdentifier(
                entity.getJigyoshoNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getServiceTeikyoShuruiCode(),
                entity.getServiceKomokuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3062SaishinsaMoshitateEntity}
     * @param id {@link SaishinsaMoshitateIdentifier}
     */
    SaishinsaMoshitate(
            DbT3062SaishinsaMoshitateEntity entity,
            SaishinsaMoshitateIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceTeikyoShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
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
     * 申立年月日を返します。
     *
     * @return 申立年月日
     */
    public FlexibleDate get申立年月日() {
        return entity.getMoshitateYMD();
    }

    /**
     * 申立者区分コードを返します。
     *
     * @return 申立者区分コード
     */
    public RString get申立者区分コード() {
        return entity.getMoshitateshaKubunCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 申立単位数を返します。
     *
     * @return 申立単位数
     */
    public int get申立単位数() {
        return entity.getMoshitateTanisu();
    }

    /**
     * 申立事由コードを返します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.getMoshitateJiyuCode();
    }

    /**
     * 国保連送付年月を返します。
     *
     * @return 国保連送付年月
     */
    public FlexibleYearMonth get国保連送付年月() {
        return entity.getKokuhorenSofuYM();
    }

    /**
     * 国保連再送付有フラグを返します。
     *
     * @return 国保連再送付有フラグ
     */
    public boolean get国保連再送付有フラグ() {
        return entity.getKokuhirenSaiSofuAriFlag();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * {@link DbT3062SaishinsaMoshitateEntity}のクローンを返します。
     *
     * @return {@link DbT3062SaishinsaMoshitateEntity}のクローン
     */
    @Override
    public DbT3062SaishinsaMoshitateEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 再審査申立の識別子{@link SaishinsaMoshitateIdentifier}を返します。
     *
     * @return 再審査申立の識別子{@link SaishinsaMoshitateIdentifier}
     */
    @Override
    public SaishinsaMoshitateIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する再審査申立を削除対象とします。<br/>
     * {@link DbT3062SaishinsaMoshitateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SaishinsaMoshitate}
     */
    @Override
    public SaishinsaMoshitate deleted() {
        DbT3062SaishinsaMoshitateEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SaishinsaMoshitate(deletedEntity, id);
    }

    /**
     * {@link SaishinsaMoshitate}のシリアライズ形式を提供します。
     *
     * @return {@link SaishinsaMoshitate}のシリアライズ形式
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

        private final DbT3062SaishinsaMoshitateEntity entity;
        private final SaishinsaMoshitateIdentifier id;

        private _SerializationProxy(DbT3062SaishinsaMoshitateEntity entity, SaishinsaMoshitateIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SaishinsaMoshitate(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SaishinsaMoshitateBuilder createBuilderForEdit() {
        return new SaishinsaMoshitateBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
