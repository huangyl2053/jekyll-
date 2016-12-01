/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業報告統計データを管理するクラスです。
 *
 * @reamsid_L DBU-9999-022 wangkanglei
 */
public class JigyoHokokuTokeiData
        extends ModelBase<JigyoHokokuTokeiDataIdentifier, DbT7021JigyoHokokuTokeiDataEntity, JigyoHokokuTokeiData> implements Serializable {

    private final DbT7021JigyoHokokuTokeiDataEntity entity;
    private final JigyoHokokuTokeiDataIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業報告統計データの新規作成時に使用します。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 集計対象月 集計対象月
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 集計単位 集計単位
     * @param 縦番号 縦番号
     * @param 横番号 横番号
     */
    public JigyoHokokuTokeiData(FlexibleYear 報告年,
            RString 報告月,
            FlexibleYear 集計対象年,
            RString 集計対象月,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号,
            Code 集計番号,
            Code 集計単位,
            Decimal 縦番号,
            Decimal 横番号) {
        requireNonNull(報告年, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年"));
        requireNonNull(報告月, UrSystemErrorMessages.値がnull.getReplacedMessage("報告月"));
        requireNonNull(集計対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象年"));
        requireNonNull(集計対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象月"));
        requireNonNull(統計対象区分, UrSystemErrorMessages.値がnull.getReplacedMessage("統計対象区分"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(表番号, UrSystemErrorMessages.値がnull.getReplacedMessage("表番号"));
        requireNonNull(集計番号, UrSystemErrorMessages.値がnull.getReplacedMessage("集計番号"));
        requireNonNull(集計単位, UrSystemErrorMessages.値がnull.getReplacedMessage("集計単位"));
        requireNonNull(縦番号, UrSystemErrorMessages.値がnull.getReplacedMessage("縦番号"));
        requireNonNull(横番号, UrSystemErrorMessages.値がnull.getReplacedMessage("横番号"));
        this.entity = new DbT7021JigyoHokokuTokeiDataEntity();
        this.entity.setHokokuYSeireki(報告年);
        this.entity.setHokokuM(報告月);
        this.entity.setShukeiTaishoYSeireki(集計対象年);
        this.entity.setShukeiTaishoM(集計対象月);
        this.entity.setToukeiTaishoKubun(統計対象区分);
        this.entity.setShichosonCode(市町村コード);
        this.entity.setHyoNo(表番号);
        this.entity.setShukeiNo(集計番号);
        this.entity.setShukeiTani(集計単位);
        this.entity.setTateNo(縦番号);
        this.entity.setYokoNo(横番号);
        this.id = new JigyoHokokuTokeiDataIdentifier(
                報告年,
                報告月,
                集計対象年,
                集計対象月,
                統計対象区分,
                市町村コード,
                表番号,
                集計番号,
                集計単位,
                縦番号,
                横番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7021JigyoHokokuTokeiDataEntity}より{@link JigyoHokokuTokeiData}を生成します。
     *
     * @param entity DBより取得した{@link DbT7021JigyoHokokuTokeiDataEntity}
     */
    public JigyoHokokuTokeiData(DbT7021JigyoHokokuTokeiDataEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業報告統計データ"));
        this.id = new JigyoHokokuTokeiDataIdentifier(
                entity.getHokokuYSeireki(),
                entity.getHokokuM(),
                entity.getShukeiTaishoYSeireki(),
                entity.getShukeiTaishoM(),
                entity.getToukeiTaishoKubun(),
                entity.getShichosonCode(),
                entity.getHyoNo(),
                entity.getShukeiNo(),
                entity.getShukeiTani(),
                entity.getTateNo(),
                entity.getYokoNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7021JigyoHokokuTokeiDataEntity}
     * @param id {@link JigyoHokokuTokeiDataIdentifier}
     */
    JigyoHokokuTokeiData(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuTokeiDataIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 報告年を返します。
     *
     * @return 報告年
     */
    public FlexibleYear get報告年() {
        return entity.getHokokuYSeireki();
    }

    /**
     * 報告月を返します。
     *
     * @return 報告月
     */
    public RString get報告月() {
        return entity.getHokokuM();
    }

    /**
     * 集計対象年を返します。
     *
     * @return 集計対象年
     */
    public FlexibleYear get集計対象年() {
        return entity.getShukeiTaishoYSeireki();
    }

    /**
     * 集計対象月を返します。
     *
     * @return 集計対象月
     */
    public RString get集計対象月() {
        return entity.getShukeiTaishoM();
    }

    /**
     * 統計対象区分を返します。
     *
     * @return 統計対象区分
     */
    public RString get統計対象区分() {
        return entity.getToukeiTaishoKubun();
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
     * 表番号を返します。
     *
     * @return 表番号
     */
    public Code get表番号() {
        return entity.getHyoNo();
    }

    /**
     * 集計番号を返します。
     *
     * @return 集計番号
     */
    public Code get集計番号() {
        return entity.getShukeiNo();
    }

    /**
     * 集計単位を返します。
     *
     * @return 集計単位
     */
    public Code get集計単位() {
        return entity.getShukeiTani();
    }

    /**
     * 縦番号を返します。
     *
     * @return 縦番号
     */
    public Decimal get縦番号() {
        return entity.getTateNo();
    }

    /**
     * 横番号を返します。
     *
     * @return 横番号
     */
    public Decimal get横番号() {
        return entity.getYokoNo();
    }

    /**
     * 集計結果値を返します。
     *
     * @return 集計結果値
     */
    public Decimal get集計結果値() {
        return entity.getShukeiKekkaAtai();
    }

    /**
     * 集計項目名称を返します。
     *
     * @return 集計項目名称
     */
    public RString get集計項目名称() {
        return entity.getShukeiKomokuMeisho();
    }

    /**
     * 縦項目コードを返します。
     *
     * @return 縦項目コード
     */
    public Code get縦項目コード() {
        return entity.getTateKomokuCode();
    }

    /**
     * 横項目コードを返します。
     *
     * @return 横項目コード
     */
    public Code get横項目コード() {
        return entity.getYokoKomokuCode();
    }

    /**
     * {@link DbT7021JigyoHokokuTokeiDataEntity}のクローンを返します。
     *
     * @return {@link DbT7021JigyoHokokuTokeiDataEntity}のクローン
     */
    @Override
    public DbT7021JigyoHokokuTokeiDataEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業報告統計データの識別子{@link JigyoHokokuTokeiDataIdentifier}を返します。
     *
     * @return 事業報告統計データの識別子{@link JigyoHokokuTokeiDataIdentifier}
     */
    @Override
    public JigyoHokokuTokeiDataIdentifier identifier() {
        return this.id;
    }

    /**
     * 事業報告統計データのみを変更対象とします。<br/>
     * {@link DbT7021JigyoHokokuTokeiDataEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JigyoHokokuTokeiData}
     */
    public JigyoHokokuTokeiData modifiedModel() {
        DbT7021JigyoHokokuTokeiDataEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JigyoHokokuTokeiData(
                modifiedEntity, id);
    }

    /**
     * 事業報告統計データのみを追加対象とします。<br/>
     * {@link DbT7021JigyoHokokuTokeiDataEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば追加状態にします。
     *
     * @return 変更対象処理実施後の{@link JigyoHokokuTokeiData}
     */
    public JigyoHokokuTokeiData addedModel() {
        DbT7021JigyoHokokuTokeiDataEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Added);
        return new JigyoHokokuTokeiData(
                modifiedEntity, id);
    }

    /**
     * 保持する事業報告統計データを削除対象とします。<br/>
     * {@link DbT7021JigyoHokokuTokeiDataEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoHokokuTokeiData}
     */
    @Override
    public JigyoHokokuTokeiData deleted() {
        DbT7021JigyoHokokuTokeiDataEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JigyoHokokuTokeiData(deletedEntity, id);
    }

    /**
     * {@link JigyoHokokuTokeiData}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoHokokuTokeiData}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1;
        private final DbT7021JigyoHokokuTokeiDataEntity entity;
        private final JigyoHokokuTokeiDataIdentifier id;

        private _SerializationProxy(DbT7021JigyoHokokuTokeiDataEntity entity, JigyoHokokuTokeiDataIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoHokokuTokeiData(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoHokokuTokeiDataBuilder createBuilderForEdit() {
        return new JigyoHokokuTokeiDataBuilder(entity, id);
    }
}
