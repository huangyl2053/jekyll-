/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特定診療サービスコードのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class TokuteiShinryoServiceCodeModel implements Serializable {

    private DbT7120TokuteiShinryoServiceCodeEntity entity;

    /**
     * コンストラクタです。
     */
    public TokuteiShinryoServiceCodeModel() {
        entity = new DbT7120TokuteiShinryoServiceCodeEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7120TokuteiShinryoServiceCodeEntity
     */
    public TokuteiShinryoServiceCodeModel(DbT7120TokuteiShinryoServiceCodeEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7120TokuteiShinryoServiceCodeEntityを返します。
     *
     * @return DbT7120TokuteiShinryoServiceCodeEntity
     */
    public DbT7120TokuteiShinryoServiceCodeEntity getEntity() {
        return entity;
    }

    /**
     * DbT7120TokuteiShinryoServiceCodeEntityを設定します。
     *
     * @param entity DbT7120TokuteiShinryoServiceCodeEntity
     */
    public void setEntity(DbT7120TokuteiShinryoServiceCodeEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
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
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    public RString getサービス名称() {
        return entity.getServiceMeisho();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 単位数識別を返します。
     *
     * @return 単位数識別
     */
    public RString get単位数識別() {
        return entity.getTaniSuShikibetsu();
    }

    /**
     * 算定単位を返します。
     *
     * @return 算定単位
     */
    public RString get算定単位() {
        return entity.getSanteiTani();
    }

    /**
     * 合成識別区分を返します。
     *
     * @return 合成識別区分
     */
    public RString get合成識別区分() {
        return entity.getGoseiShikibetsuKubun();
    }

    /**
     * 特定診療区分コードを返します。
     *
     * @return 特定診療区分コード
     */
    public RString get特定診療区分コード() {
        return entity.getTokuteiShinryoKubunCode();
    }

    /**
     * 特定診療項目コードを返します。
     *
     * @return 特定診療項目コード
     */
    public RString get特定診療項目コード() {
        return entity.getTokuteiShinryoKomokuCode();
    }

    /**
     * 算定制約期間を返します。
     *
     * @return 算定制約期間
     */
    public RString get算定制約期間() {
        return entity.getSanteiSeiyakuKikan();
    }

    /**
     * 算定制約回数を返します。
     *
     * @return 算定制約回数
     */
    public Decimal get算定制約回数() {
        return entity.getSanteiSeiyakuKaisu();
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     */
    public void set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     */
    public void set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     */
    public void setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceMeisho(サービス名称);
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     */
    public void set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
    }

    /**
     * 単位数識別を設定します。
     *
     * @param 単位数識別 単位数識別
     */
    public void set単位数識別(RString 単位数識別) {
        requireNonNull(単位数識別, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別"));
        entity.setTaniSuShikibetsu(単位数識別);
    }

    /**
     * 算定単位を設定します。
     *
     * @param 算定単位 算定単位
     */
    public void set算定単位(RString 算定単位) {
        requireNonNull(算定単位, UrSystemErrorMessages.値がnull.getReplacedMessage("算定単位"));
        entity.setSanteiTani(算定単位);
    }

    /**
     * 合成識別区分を設定します。
     *
     * @param 合成識別区分 合成識別区分
     */
    public void set合成識別区分(RString 合成識別区分) {
        requireNonNull(合成識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合成識別区分"));
        entity.setGoseiShikibetsuKubun(合成識別区分);
    }

    /**
     * 特定診療区分コードを設定します。
     *
     * @param 特定診療区分コード 特定診療区分コード
     */
    public void set特定診療区分コード(RString 特定診療区分コード) {
        requireNonNull(特定診療区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療区分コード"));
        entity.setTokuteiShinryoKubunCode(特定診療区分コード);
    }

    /**
     * 特定診療項目コードを設定します。
     *
     * @param 特定診療項目コード 特定診療項目コード
     */
    public void set特定診療項目コード(RString 特定診療項目コード) {
        requireNonNull(特定診療項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療項目コード"));
        entity.setTokuteiShinryoKomokuCode(特定診療項目コード);
    }

    /**
     * 算定制約期間を設定します。
     *
     * @param 算定制約期間 算定制約期間
     */
    public void set算定制約期間(RString 算定制約期間) {
        requireNonNull(算定制約期間, UrSystemErrorMessages.値がnull.getReplacedMessage("算定制約期間"));
        entity.setSanteiSeiyakuKikan(算定制約期間);
    }

    /**
     * 算定制約回数を設定します。
     *
     * @param 算定制約回数 算定制約回数
     */
    public void set算定制約回数(Decimal 算定制約回数) {
        requireNonNull(算定制約回数, UrSystemErrorMessages.値がnull.getReplacedMessage("算定制約回数"));
        entity.setSanteiSeiyakuKaisu(算定制約回数);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
