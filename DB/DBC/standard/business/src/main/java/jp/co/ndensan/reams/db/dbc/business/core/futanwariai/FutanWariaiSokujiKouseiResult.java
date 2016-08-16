/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.futanwariai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariai.FutanWariaiSokujiKouseiRelateEntity;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担割合明細情報クラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class FutanWariaiSokujiKouseiResult
        extends ParentModelBase<RiyoshaFutanWariaiIdentifier, DbT3113RiyoshaFutanWariaiEntity, FutanWariaiSokujiKouseiResult>
        implements Serializable {

    private final DbT3113RiyoshaFutanWariaiEntity entity;
    private final RiyoshaFutanWariaiIdentifier id;
    private final Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細;

    /**
     * コンストラクタです。<br/>
     * 利用者負担割合明細の新規作成時に使用します。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public FutanWariaiSokujiKouseiResult(FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3113RiyoshaFutanWariaiEntity();
        this.entity.setNendo(年度);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new RiyoshaFutanWariaiIdentifier(
                年度,
                被保険者番号,
                履歴番号);
        this.利用者負担割合明細 = Models.create(new ArrayList<RiyoshaFutanWariaiMeisai>());
    }

    /**
     * コンストラクタです。<br/>
     * 利用者負担割合明細の新規作成時に使用します。
     */
    public FutanWariaiSokujiKouseiResult() {
        this.entity = new DbT3113RiyoshaFutanWariaiEntity();
        this.id = null;
        this.利用者負担割合明細 = Models.create(new ArrayList<RiyoshaFutanWariaiMeisai>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link FutanWariaiSokujiKouseiRelateEntity}より{@link FutanWariaiSokujiKouseiResult}を生成します。
     *
     * @param entity DBより取得した{@link FutanWariaiSokujiKouseiRelateEntity}
     */
    public FutanWariaiSokujiKouseiResult(FutanWariaiSokujiKouseiRelateEntity entity) {
        this.entity = requireNonNull(entity.get利用者負担割合(), UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合"));
        this.id = new RiyoshaFutanWariaiIdentifier(
                entity.get利用者負担割合().getNendo(),
                entity.get利用者負担割合().getHihokenshaNo(),
                entity.get利用者負担割合().getRirekiNo());
        List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細list = new ArrayList();
        for (DbT3114RiyoshaFutanWariaiMeisaiEntity 利用者負担割合明細entity : entity.get利用者負担割合明細()) {
            利用者負担割合明細list.add(new RiyoshaFutanWariaiMeisai(利用者負担割合明細entity));
        }
        this.利用者負担割合明細 = Models.create(利用者負担割合明細list);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3113RiyoshaFutanWariaiEntity}
     * @param id {@link RiyoshaFutanWariaiIdentifier}
     */
    FutanWariaiSokujiKouseiResult(
            DbT3113RiyoshaFutanWariaiEntity entity,
            RiyoshaFutanWariaiIdentifier id,
            Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細
    ) {
        this.entity = entity;
        this.id = id;
        this.利用者負担割合明細 = 利用者負担割合明細;
    }

    /**
     * 利用者負担割合明細のリストを返します。
     *
     * @return {@link RiyoshaFutanWariaiMeisai}のリスト
     */
    public List<RiyoshaFutanWariaiMeisai> get利用者負担割合明細list() {
        return new ArrayList<>(利用者負担割合明細.clone().values());
    }

    /**
     * 利用者負担割合明細を返します。
     *
     * @param id {@link RiyoshaFutanWariaiMeisaiIdentifier}
     * @return {@link RiyoshaFutanWariaiMeisai}
     */
    public RiyoshaFutanWariaiMeisai get利用者負担割合明細(RiyoshaFutanWariaiMeisaiIdentifier id) {
        if (利用者負担割合明細.contains(id)) {
            return 利用者負担割合明細.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    //TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return entity.getNendo();
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
     * 発行不要フラグを返します。
     *
     * @return 発行不要フラグ
     */
    public boolean is発行不要フラグ() {
        return entity.getHakoFuyoFlag();
    }

    /**
     * 職権変更フラグを返します。
     *
     * @return 職権変更フラグ
     */
    public boolean is職権変更フラグ() {
        return entity.getShokenFlag();
    }

    /**
     * 判定日を返します。
     *
     * @return 判定日
     */
    public FlexibleDate get判定日() {
        return entity.getHanteiYMD();
    }

    /**
     * 判定区分を返します。
     *
     * @return 判定区分
     */
    public RString get判定区分() {
        return entity.getHanteiKubun();
    }

    /**
     * 更正事由を返します。
     *
     * @return 更正事由
     */
    public Code get更正事由() {
        return entity.getKoseiJiyu();
    }

    /**
     * 発行区分を返します。
     *
     * @return 発行区分
     */
    public RString get発行区分() {
        return entity.getHakoKubun();
    }

    /**
     * 発行日を返します。
     *
     * @return 発行日
     */
    public FlexibleDate get発行日() {
        return entity.getHakoYMD();
    }

    /**
     * 交付日を返します。
     *
     * @return 交付日
     */
    public FlexibleDate get交付日() {
        return entity.getKofuYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT3113RiyoshaFutanWariaiEntity}のクローンを返します。
     *
     * @return {@link DbT3113RiyoshaFutanWariaiEntity}のクローン
     */
    @Override
    public DbT3113RiyoshaFutanWariaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 利用者負担割合の識別子{@link RiyoshaFutanWariaiIdentifier}を返します。
     *
     * @return 利用者負担割合の識別子{@link RiyoshaFutanWariaiIdentifier}
     */
    @Override
    public RiyoshaFutanWariaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 利用者負担割合のみを変更対象とします。<br/>
     * {@link DbT3113RiyoshaFutanWariaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShikyuTeishiRelate}
     */
    @Override
    public FutanWariaiSokujiKouseiResult modifiedModel() {
        DbT3113RiyoshaFutanWariaiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FutanWariaiSokujiKouseiResult(
                modifiedEntity, id, 利用者負担割合明細);
    }

    /**
     * 保持する利用者負担割合を削除対象とします。
     * <br/> {@link DbT3113RiyoshaFutanWariaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RiyoshaFutanWariai}
     */
    @Override
    public FutanWariaiSokujiKouseiResult deleted() {
        DbT3113RiyoshaFutanWariaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FutanWariaiSokujiKouseiResult(deletedEntity, id, 利用者負担割合明細);
    }

    /**
     * {@link RiyoshaFutanWariai}のシリアライズ形式を提供します。
     *
     * @return {@link RiyoshaFutanWariai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, 利用者負担割合明細);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * getRiyoshaFutanWariaiMeisaiList
     *
     * @return UnsupportedOperationException("Not supported yet.")
     */
    public List<RiyoshaFutanWariaiMeisai> getRiyoshaFutanWariaiMeisaiList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3113RiyoshaFutanWariaiEntity entity;
        private final RiyoshaFutanWariaiIdentifier id;
        private final Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細;

        private _SerializationProxy(DbT3113RiyoshaFutanWariaiEntity entity, RiyoshaFutanWariaiIdentifier id,
                Models<RiyoshaFutanWariaiMeisaiIdentifier, RiyoshaFutanWariaiMeisai> 利用者負担割合明細) {
            this.entity = entity;
            this.id = id;
            this.利用者負担割合明細 = 利用者負担割合明細;
        }

        private Object readResolve() {
            return new FutanWariaiSokujiKouseiResult(this.entity, this.id, this.利用者負担割合明細);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FutanWariaiSokujiKouseiResultBuilder createBuilderForEdit() {
        return new FutanWariaiSokujiKouseiResultBuilder(entity, id, 利用者負担割合明細);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
