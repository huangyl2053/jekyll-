/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業報告統計データのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class JigyoHokokuTokeiDataModel implements Serializable {

    private DbT7021JigyoHokokuTokeiDataEntity entity;

    /**
     * コンストラクタです。
     */
    public JigyoHokokuTokeiDataModel() {
        entity = new DbT7021JigyoHokokuTokeiDataEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7021JigyoHokokuTokeiDataEntity
     */
    public JigyoHokokuTokeiDataModel(DbT7021JigyoHokokuTokeiDataEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7021JigyoHokokuTokeiDataEntityを返します。
     *
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
    public DbT7021JigyoHokokuTokeiDataEntity getEntity() {
        return entity;
    }

    /**
     * DbT7021JigyoHokokuTokeiDataEntityを設定します。
     *
     * @param entity DbT7021JigyoHokokuTokeiDataEntity
     */
    public void setEntity(DbT7021JigyoHokokuTokeiDataEntity entity) {
        this.entity = entity;
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
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
     * 報告年を設定します。
     *
     * @param 報告年 報告年
     */
    public void set報告年(FlexibleYear 報告年) {
        requireNonNull(報告年, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年"));
        entity.setHokokuYSeireki(報告年);
    }

    /**
     * 報告月を設定します。
     *
     * @param 報告月 報告月
     */
    public void set報告月(RString 報告月) {
        requireNonNull(報告月, UrSystemErrorMessages.値がnull.getReplacedMessage("報告月"));
        entity.setHokokuM(報告月);
    }

    /**
     * 集計対象年を設定します。
     *
     * @param 集計対象年 集計対象年
     */
    public void set集計対象年(FlexibleYear 集計対象年) {
        requireNonNull(集計対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象年"));
        entity.setShukeiTaishoYSeireki(集計対象年);
    }

    /**
     * 集計対象月を設定します。
     *
     * @param 集計対象月 集計対象月
     */
    public void set集計対象月(RString 集計対象月) {
        requireNonNull(集計対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象月"));
        entity.setShukeiTaishoM(集計対象月);
    }

    /**
     * 統計対象区分を設定します。
     *
     * @param 統計対象区分 統計対象区分
     */
    public void set統計対象区分(RString 統計対象区分) {
        requireNonNull(統計対象区分, UrSystemErrorMessages.値がnull.getReplacedMessage("統計対象区分"));
        entity.setToukeiTaishoKubun(統計対象区分);
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 表番号を設定します。
     *
     * @param 表番号 表番号
     */
    public void set表番号(Code 表番号) {
        requireNonNull(表番号, UrSystemErrorMessages.値がnull.getReplacedMessage("表番号"));
        entity.setHyoNo(表番号);
    }

    /**
     * 集計番号を設定します。
     *
     * @param 集計番号 集計番号
     */
    public void set集計番号(Code 集計番号) {
        requireNonNull(集計番号, UrSystemErrorMessages.値がnull.getReplacedMessage("集計番号"));
        entity.setShukeiNo(集計番号);
    }

    /**
     * 集計単位を設定します。
     *
     * @param 集計単位 集計単位
     */
    public void set集計単位(Code 集計単位) {
        requireNonNull(集計単位, UrSystemErrorMessages.値がnull.getReplacedMessage("集計単位"));
        entity.setShukeiTani(集計単位);
    }

    /**
     * 縦番号を設定します。
     *
     * @param 縦番号 縦番号
     */
    public void set縦番号(Decimal 縦番号) {
        requireNonNull(縦番号, UrSystemErrorMessages.値がnull.getReplacedMessage("縦番号"));
        entity.setTateNo(縦番号);
    }

    /**
     * 横番号を設定します。
     *
     * @param 横番号 横番号
     */
    public void set横番号(Decimal 横番号) {
        requireNonNull(横番号, UrSystemErrorMessages.値がnull.getReplacedMessage("横番号"));
        entity.setYokoNo(横番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 集計結果値を設定します。
     *
     * @param 集計結果値 集計結果値
     */
    public void set集計結果値(Decimal 集計結果値) {
        requireNonNull(集計結果値, UrSystemErrorMessages.値がnull.getReplacedMessage("集計結果値"));
        entity.setShukeiKekkaAtai(集計結果値);
    }

    /**
     * 縦項目コードを設定します。
     *
     * @param 縦項目コード 縦項目コード
     */
    public void set縦項目コード(Code 縦項目コード) {
        requireNonNull(縦項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("縦項目コード"));
        entity.setTateKomokuCode(縦項目コード);
    }

    /**
     * 横項目コードを設定します。
     *
     * @param 横項目コード 横項目コード
     */
    public void set横項目コード(Code 横項目コード) {
        requireNonNull(横項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("横項目コード"));
        entity.setYokoKomokuCode(横項目コード);
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
