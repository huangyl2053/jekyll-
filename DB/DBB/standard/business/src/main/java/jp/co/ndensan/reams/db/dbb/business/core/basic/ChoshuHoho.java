/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護徴収方法を管理するクラスです。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public class ChoshuHoho extends ModelBase<ChoshuHohoIdentifier, DbT2001ChoshuHohoEntity, ChoshuHoho> implements Serializable {

    private final DbT2001ChoshuHohoEntity entity;
    private final ChoshuHohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護徴収方法の新規作成時に使用します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public ChoshuHoho(FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT2001ChoshuHohoEntity();
        this.entity.setFukaNendo(賦課年度);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ChoshuHohoIdentifier(
                賦課年度,
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2001ChoshuHohoEntity}より{@link ChoshuHoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT2001ChoshuHohoEntity}
     */
    public ChoshuHoho(DbT2001ChoshuHohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護徴収方法"));
        this.id = new ChoshuHohoIdentifier(
                entity.getFukaNendo(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2001ChoshuHohoEntity}
     * @param id {@link ChoshuHohoIdentifier}
     */
    ChoshuHoho(
            DbT2001ChoshuHohoEntity entity,
            ChoshuHohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 徴収方法4月を返します。
     *
     * @return 徴収方法4月
     */
    public RString get徴収方法4月() {
        return entity.getChoshuHoho4gatsu();
    }

    /**
     * 徴収方法5月を返します。
     *
     * @return 徴収方法5月
     */
    public RString get徴収方法5月() {
        return entity.getChoshuHoho5gatsu();
    }

    /**
     * 徴収方法6月を返します。
     *
     * @return 徴収方法6月
     */
    public RString get徴収方法6月() {
        return entity.getChoshuHoho6gatsu();
    }

    /**
     * 徴収方法7月を返します。
     *
     * @return 徴収方法7月
     */
    public RString get徴収方法7月() {
        return entity.getChoshuHoho7gatsu();
    }

    /**
     * 徴収方法8月を返します。
     *
     * @return 徴収方法8月
     */
    public RString get徴収方法8月() {
        return entity.getChoshuHoho8gatsu();
    }

    /**
     * 徴収方法9月を返します。
     *
     * @return 徴収方法9月
     */
    public RString get徴収方法9月() {
        return entity.getChoshuHoho9gatsu();
    }

    /**
     * 徴収方法10月を返します。
     *
     * @return 徴収方法10月
     */
    public RString get徴収方法10月() {
        return entity.getChoshuHoho10gatsu();
    }

    /**
     * 徴収方法11月を返します。
     *
     * @return 徴収方法11月
     */
    public RString get徴収方法11月() {
        return entity.getChoshuHoho11gatsu();
    }

    /**
     * 徴収方法12月を返します。
     *
     * @return 徴収方法12月
     */
    public RString get徴収方法12月() {
        return entity.getChoshuHoho12gatsu();
    }

    /**
     * 徴収方法1月を返します。
     *
     * @return 徴収方法1月
     */
    public RString get徴収方法1月() {
        return entity.getChoshuHoho1gatsu();
    }

    /**
     * 徴収方法2月を返します。
     *
     * @return 徴収方法2月
     */
    public RString get徴収方法2月() {
        return entity.getChoshuHoho2gatsu();
    }

    /**
     * 徴収方法3月を返します。
     *
     * @return 徴収方法3月
     */
    public RString get徴収方法3月() {
        return entity.getChoshuHoho3gatsu();
    }

    /**
     * 徴収方法翌4月を返します。
     *
     * @return 徴収方法翌4月
     */
    public RString get徴収方法翌4月() {
        return entity.getChoshuHohoYoku4gatsu();
    }

    /**
     * 徴収方法翌5月を返します。
     *
     * @return 徴収方法翌5月
     */
    public RString get徴収方法翌5月() {
        return entity.getChoshuHohoYoku5gatsu();
    }

    /**
     * 徴収方法翌6月を返します。
     *
     * @return 徴収方法翌6月
     */
    public RString get徴収方法翌6月() {
        return entity.getChoshuHohoYoku6gatsu();
    }

    /**
     * 徴収方法翌7月を返します。
     *
     * @return 徴収方法翌7月
     */
    public RString get徴収方法翌7月() {
        return entity.getChoshuHohoYoku7gatsu();
    }

    /**
     * 徴収方法翌8月を返します。
     *
     * @return 徴収方法翌8月
     */
    public RString get徴収方法翌8月() {
        return entity.getChoshuHohoYoku8gatsu();
    }

    /**
     * 徴収方法翌9月を返します。
     *
     * @return 徴収方法翌9月
     */
    public RString get徴収方法翌9月() {
        return entity.getChoshuHohoYoku9gatsu();
    }

    /**
     * 仮徴収・基礎年金番号を返します。
     *
     * @return 仮徴収・基礎年金番号
     */
    public RString get仮徴収_基礎年金番号() {
        return entity.getKariNenkinNo();
    }

    /**
     * 仮徴収・年金コードを返します。
     *
     * @return 仮徴収・年金コード
     */
    public RString get仮徴収_年金コード() {
        return entity.getKariNenkinCode();
    }

    /**
     * 仮徴収・捕捉月を返します。
     *
     * @return 仮徴収・捕捉月
     */
    public RString get仮徴収_捕捉月() {
        return entity.getKariHosokuM();
    }

    /**
     * 本徴収・基礎年金番号を返します。
     *
     * @return 本徴収・基礎年金番号
     */
    public RString get本徴収_基礎年金番号() {
        return entity.getHonNenkinNo();
    }

    /**
     * 本徴収・年金コードを返します。
     *
     * @return 本徴収・年金コード
     */
    public RString get本徴収_年金コード() {
        return entity.getHonNenkinCode();
    }

    /**
     * 本徴収・捕捉月を返します。
     *
     * @return 本徴収・捕捉月
     */
    public RString get本徴収_捕捉月() {
        return entity.getHonHosokuM();
    }

    /**
     * 翌年度仮徴収・基礎年金番号を返します。
     *
     * @return 翌年度仮徴収・基礎年金番号
     */
    public RString get翌年度仮徴収_基礎年金番号() {
        return entity.getYokunendoKariNenkinNo();
    }

    /**
     * 翌年度仮徴収・年金コードを返します。
     *
     * @return 翌年度仮徴収・年金コード
     */
    public RString get翌年度仮徴収_年金コード() {
        return entity.getYokunendoKariNenkinCode();
    }

    /**
     * 翌年度仮徴収・捕捉月を返します。
     *
     * @return 翌年度仮徴収・捕捉月
     */
    public RString get翌年度仮徴収_捕捉月() {
        return entity.getYokunendoKariHosokuM();
    }

    /**
     * 依頼情報送付済みフラグを返します。
     *
     * @return 依頼情報送付済みフラグ
     */
    public boolean is依頼情報送付済みフラグ() {
        return entity.getIraiSohuzumiFlag();
    }

    /**
     * 追加依頼情報送付済みフラグを返します。
     *
     * @return 追加依頼情報送付済みフラグ
     */
    public boolean is追加依頼情報送付済みフラグ() {
        return entity.getTsuikaIraiSohuzumiFlag();
    }

    /**
     * 特別徴収停止日時を返します。
     *
     * @return 特別徴収停止日時
     */
    public YMDHMS get特別徴収停止日時() {
        return entity.getTokuchoTeishiNichiji();
    }

    /**
     * 特別徴収停止事由コードを返します。
     *
     * @return 特別徴収停止事由コード
     */
    public RString get特別徴収停止事由コード() {
        return entity.getTokuchoTeishiJiyuCode();
    }

    /**
     * {@link DbT2001ChoshuHohoEntity}のクローンを返します。
     *
     * @return {@link DbT2001ChoshuHohoEntity}のクローン
     */
    @Override
    public DbT2001ChoshuHohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護徴収方法の識別子{@link ChoshuHohoIdentifier}を返します。
     *
     * @return 介護徴収方法の識別子{@link ChoshuHohoIdentifier}
     */
    @Override
    public ChoshuHohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護徴収方法を削除対象とします。<br/> {@link DbT2001ChoshuHohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChoshuHoho}
     */
    @Override
    public ChoshuHoho deleted() {
        DbT2001ChoshuHohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChoshuHoho(deletedEntity, id);
    }

    /**
     * 保持する介護徴収方法を登録対象とします。<br/> {@link DbT2001ChoshuHohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば登録状態にします。
     *
     * @return 登録対象処理実施後の{@link ChoshuHoho}
     */
    public ChoshuHoho added() {
        DbT2001ChoshuHohoEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        return new ChoshuHoho(addedEntity, id);
    }

    /**
     * {@link ChoshuHoho}のシリアライズ形式を提供します。
     *
     * @return {@link ChoshuHoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT2001ChoshuHohoEntity entity;
        private final ChoshuHohoIdentifier id;

        private _SerializationProxy(DbT2001ChoshuHohoEntity entity, ChoshuHohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChoshuHoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChoshuHohoBuilder createBuilderForEdit() {
        return new ChoshuHohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
