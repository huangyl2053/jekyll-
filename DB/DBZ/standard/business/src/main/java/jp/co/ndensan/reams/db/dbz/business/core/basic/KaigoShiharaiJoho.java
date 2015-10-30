/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.NinshoshaCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護支払情報を管理するクラスです。
 */
public class KaigoShiharaiJoho extends 
        ParentModelBase<KaigoShiharaiJohoIdentifier, 
        DbT7004KaigoShiharaiJohoEntity, KaigoShiharaiJoho> implements Serializable {

    private final DbT7004KaigoShiharaiJohoEntity entity;
    private final KaigoShiharaiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護支払情報の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 科目コード 科目コード
     * @param 決定年月日 決定年月日
     */
    public KaigoShiharaiJoho(ShikibetsuCode 識別コード,
            KamokuCode 科目コード,
            FlexibleDate 決定年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(科目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("科目コード"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        this.entity = new DbT7004KaigoShiharaiJohoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setKamokuCode(科目コード);
        this.entity.setKetteiYMD(決定年月日);
        this.id = new KaigoShiharaiJohoIdentifier(
                識別コード,
                科目コード,
                決定年月日
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7004KaigoShiharaiJohoEntity}より{@link KaigoShiharaiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT7004KaigoShiharaiJohoEntity}
     */
    public KaigoShiharaiJoho(DbT7004KaigoShiharaiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支払情報"));
        this.id = new KaigoShiharaiJohoIdentifier(
                entity.getShikibetsuCode(),
                entity.getKamokuCode(),
                entity.getKetteiYMD());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7004KaigoShiharaiJohoEntity}
     * @param id {@link KaigoShiharaiJohoIdentifier}
     */
    KaigoShiharaiJoho(
            DbT7004KaigoShiharaiJohoEntity entity,
            KaigoShiharaiJohoIdentifier id
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
     * 科目コードを返します。
     *
     * @return 科目コード
     */
    public KamokuCode get科目コード() {
        return entity.getKamokuCode();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 支払方法区分を返します。
     *
     * @return 支払方法区分
     */
    public RString get支払方法区分() {
        return entity.getShiharaiHohoKubun();
    }

    /**
     * 窓口支払場所コードを返します。
     *
     * @return 窓口支払場所コード
     */
    public Code get窓口支払場所コード() {
        return entity.getMadoguchiShiharaiBashoCode();
    }

    /**
     * 窓口支払開始年月日時分を返します。
     *
     * @return 窓口支払開始年月日時分
     */
    public YMDHM get窓口支払開始年月日時分() {
        return entity.getMadoguchiShiharaiKaishiYMDHM();
    }

    /**
     * 窓口支払終了年月日時分を返します。
     *
     * @return 窓口支払終了年月日時分
     */
    public YMDHM get窓口支払終了年月日時分() {
        return entity.getMadoguchiShiharaiShuryoYMDHM();
    }

    /**
     * 振込予定年月日を返します。
     *
     * @return 振込予定年月日
     */
    public FlexibleDate get振込予定年月日() {
        return entity.getFurikomiYoteiYMD();
    }

    /**
     * 支払金額を返します。
     *
     * @return 支払金額
     */
    public int get支払金額() {
        return entity.getShiharaiKingaku();
    }

    /**
     * 種別コードを返します。
     *
     * @return 種別コード
     */
    public Code get種別コード() {
        return entity.getSyubetsuCode();
    }

    /**
     * 用途区分コードを返します。
     *
     * @return 用途区分コード
     */
    public Code get用途区分コード() {
        return entity.getYotoKubunCode();
    }

    /**
     * 認証日１を返します。
     *
     * @return 認証日１
     */
    public FlexibleDate get認証日１() {
        return entity.getNinshoYMD1();
    }

    /**
     * 認証者コード１を返します。
     *
     * @return 認証者コード１
     */
    public NinshoshaCode get認証者コード１() {
        return entity.getNinshoshaCode1();
    }

    /**
     * 認証日２を返します。
     *
     * @return 認証日２
     */
    public FlexibleDate get認証日２() {
        return entity.getNinshoYMD2();
    }

    /**
     * 認証者コード２を返します。
     *
     * @return 認証者コード２
     */
    public NinshoshaCode get認証者コード２() {
        return entity.getNinshoshaCode2();
    }

    /**
     * {@link DbT7004KaigoShiharaiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT7004KaigoShiharaiJohoEntity}のクローン
     */
    @Override
    public DbT7004KaigoShiharaiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護支払情報の識別子{@link KaigoShiharaiJohoIdentifier}を返します。
     *
     * @return 介護支払情報の識別子{@link KaigoShiharaiJohoIdentifier}
     */
    @Override
    public KaigoShiharaiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護支払情報のみを変更対象とします。<br/>
     * {@link DbT7004KaigoShiharaiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoShiharaiJoho}
     */
    @Override
    public KaigoShiharaiJoho modifiedModel() {
        DbT7004KaigoShiharaiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoShiharaiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護支払情報を削除対象とします。<br/>
     * {@link DbT7004KaigoShiharaiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoShiharaiJoho}
     */
    @Override
    public KaigoShiharaiJoho deleted() {
        DbT7004KaigoShiharaiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoShiharaiJoho(deletedEntity, id);
    }

    /**
     * {@link KaigoShiharaiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoShiharaiJoho}のシリアライズ形式
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
        private final DbT7004KaigoShiharaiJohoEntity entity;
        private final KaigoShiharaiJohoIdentifier id;

        private _SerializationProxy(DbT7004KaigoShiharaiJohoEntity entity, KaigoShiharaiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoShiharaiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoShiharaiJohoBuilder createBuilderForEdit() {
        return new KaigoShiharaiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
