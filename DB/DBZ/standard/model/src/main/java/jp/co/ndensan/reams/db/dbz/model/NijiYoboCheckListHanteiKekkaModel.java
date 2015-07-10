/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防チェックリスト判定結果のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class NijiYoboCheckListHanteiKekkaModel implements Serializable {

    private DbT3103NijiYoboCheckListHanteiKekkaEntity entity;

    /**
     * コンストラクタです。
     */
    public NijiYoboCheckListHanteiKekkaModel() {
        entity = new DbT3103NijiYoboCheckListHanteiKekkaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3103NijiYoboCheckListHanteiKekkaEntity
     */
    public NijiYoboCheckListHanteiKekkaModel(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3103NijiYoboCheckListHanteiKekkaEntityを返します。
     *
     * @return DbT3103NijiYoboCheckListHanteiKekkaEntity
     */
    public DbT3103NijiYoboCheckListHanteiKekkaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3103NijiYoboCheckListHanteiKekkaEntityを設定します。
     *
     * @param entity DbT3103NijiYoboCheckListHanteiKekkaEntity
     */
    public void setEntity(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 点数_生活機能全般を返します。
     *
     * @return 点数_生活機能全般
     */
    public Decimal get点数_生活機能全般() {
        return entity.getTensu_SeikatsuKinoZenpan();
    }

    /**
     * 点数_運動器機能を返します。
     *
     * @return 点数_運動器機能
     */
    public Decimal get点数_運動器機能() {
        return entity.getTensu_UndokiKino();
    }

    /**
     * 点数_栄養を返します。
     *
     * @return 点数_栄養
     */
    public Decimal get点数_栄養() {
        return entity.getTensu_Eiyo();
    }

    /**
     * 点数_口腔を返します。
     *
     * @return 点数_口腔
     */
    public Decimal get点数_口腔() {
        return entity.getTensu_Koku();
    }

    /**
     * 点数_閉じこもりを返します。
     *
     * @return 点数_閉じこもり
     */
    public Decimal get点数_閉じこもり() {
        return entity.getTensu_Tojikomori();
    }

    /**
     * 点数_認知能力を返します。
     *
     * @return 点数_認知能力
     */
    public Decimal get点数_認知能力() {
        return entity.getTensu_NinchiNoryoku();
    }

    /**
     * 点数_うつを返します。
     *
     * @return 点数_うつ
     */
    public Decimal get点数_うつ() {
        return entity.getTensu_Utsu();
    }

    /**
     * 支援必要性_生活機能全般を返します。
     *
     * @return 支援必要性_生活機能全般
     */
    public int get支援必要性_生活機能全般() {
        return entity.getShien_SeikatsuKinoZenpan();
    }

    /**
     * 支援必要性_運動器機能を返します。
     *
     * @return 支援必要性_運動器機能
     */
    public int get支援必要性_運動器機能() {
        return entity.getShien_UndokiKino();
    }

    /**
     * 支援必要性_栄養を返します。
     *
     * @return 支援必要性_栄養
     */
    public int get支援必要性_栄養() {
        return entity.getShien_Eiyo();
    }

    /**
     * 支援必要性_口腔を返します。
     *
     * @return 支援必要性_口腔
     */
    public int get支援必要性_口腔() {
        return entity.getShien_Koku();
    }

    /**
     * 支援必要性_閉じこもりを返します。
     *
     * @return 支援必要性_閉じこもり
     */
    public int get支援必要性_閉じこもり() {
        return entity.getShien_Tojikomori();
    }

    /**
     * 支援必要性_認知能力を返します。
     *
     * @return 支援必要性_認知能力
     */
    public int get支援必要性_認知能力() {
        return entity.getShien_NinchiNoryoku();
    }

    /**
     * 支援必要性_うつを返します。
     *
     * @return 支援必要性_うつ
     */
    public int get支援必要性_うつ() {
        return entity.getShien_Utsu();
    }

    /**
     * 二次予防_主観的健康感を返します。
     *
     * @return 二次予防_主観的健康感
     */
    public RString get二次予防_主観的健康感() {
        return entity.getNijiYobo_ShukantekiKenkouKan();
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
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
     * 点数_生活機能全般を設定します。
     *
     * @param 点数_生活機能全般 点数_生活機能全般
     */
    public void set点数_生活機能全般(Decimal 点数_生活機能全般) {
        requireNonNull(点数_生活機能全般, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_生活機能全般"));
        entity.setTensu_SeikatsuKinoZenpan(点数_生活機能全般);
    }

    /**
     * 点数_運動器機能を設定します。
     *
     * @param 点数_運動器機能 点数_運動器機能
     */
    public void set点数_運動器機能(Decimal 点数_運動器機能) {
        requireNonNull(点数_運動器機能, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_運動器機能"));
        entity.setTensu_UndokiKino(点数_運動器機能);
    }

    /**
     * 点数_栄養を設定します。
     *
     * @param 点数_栄養 点数_栄養
     */
    public void set点数_栄養(Decimal 点数_栄養) {
        requireNonNull(点数_栄養, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_栄養"));
        entity.setTensu_Eiyo(点数_栄養);
    }

    /**
     * 点数_口腔を設定します。
     *
     * @param 点数_口腔 点数_口腔
     */
    public void set点数_口腔(Decimal 点数_口腔) {
        requireNonNull(点数_口腔, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_口腔"));
        entity.setTensu_Koku(点数_口腔);
    }

    /**
     * 点数_閉じこもりを設定します。
     *
     * @param 点数_閉じこもり 点数_閉じこもり
     */
    public void set点数_閉じこもり(Decimal 点数_閉じこもり) {
        requireNonNull(点数_閉じこもり, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_閉じこもり"));
        entity.setTensu_Tojikomori(点数_閉じこもり);
    }

    /**
     * 点数_認知能力を設定します。
     *
     * @param 点数_認知能力 点数_認知能力
     */
    public void set点数_認知能力(Decimal 点数_認知能力) {
        requireNonNull(点数_認知能力, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_認知能力"));
        entity.setTensu_NinchiNoryoku(点数_認知能力);
    }

    /**
     * 点数_うつを設定します。
     *
     * @param 点数_うつ 点数_うつ
     */
    public void set点数_うつ(Decimal 点数_うつ) {
        requireNonNull(点数_うつ, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_うつ"));
        entity.setTensu_Utsu(点数_うつ);
    }

    /**
     * 支援必要性_生活機能全般を設定します。
     *
     * @param 支援必要性_生活機能全般 支援必要性_生活機能全般
     */
    public void set支援必要性_生活機能全般(int 支援必要性_生活機能全般) {
        requireNonNull(支援必要性_生活機能全般, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_生活機能全般"));
        entity.setShien_SeikatsuKinoZenpan(支援必要性_生活機能全般);
    }

    /**
     * 支援必要性_運動器機能を設定します。
     *
     * @param 支援必要性_運動器機能 支援必要性_運動器機能
     */
    public void set支援必要性_運動器機能(int 支援必要性_運動器機能) {
        requireNonNull(支援必要性_運動器機能, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_運動器機能"));
        entity.setShien_UndokiKino(支援必要性_運動器機能);
    }

    /**
     * 支援必要性_栄養を設定します。
     *
     * @param 支援必要性_栄養 支援必要性_栄養
     */
    public void set支援必要性_栄養(int 支援必要性_栄養) {
        requireNonNull(支援必要性_栄養, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_栄養"));
        entity.setShien_Eiyo(支援必要性_栄養);
    }

    /**
     * 支援必要性_口腔を設定します。
     *
     * @param 支援必要性_口腔 支援必要性_口腔
     */
    public void set支援必要性_口腔(int 支援必要性_口腔) {
        requireNonNull(支援必要性_口腔, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_口腔"));
        entity.setShien_Koku(支援必要性_口腔);
    }

    /**
     * 支援必要性_閉じこもりを設定します。
     *
     * @param 支援必要性_閉じこもり 支援必要性_閉じこもり
     */
    public void set支援必要性_閉じこもり(int 支援必要性_閉じこもり) {
        requireNonNull(支援必要性_閉じこもり, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_閉じこもり"));
        entity.setShien_Tojikomori(支援必要性_閉じこもり);
    }

    /**
     * 支援必要性_認知能力を設定します。
     *
     * @param 支援必要性_認知能力 支援必要性_認知能力
     */
    public void set支援必要性_認知能力(int 支援必要性_認知能力) {
        requireNonNull(支援必要性_認知能力, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_認知能力"));
        entity.setShien_NinchiNoryoku(支援必要性_認知能力);
    }

    /**
     * 支援必要性_うつを設定します。
     *
     * @param 支援必要性_うつ 支援必要性_うつ
     */
    public void set支援必要性_うつ(int 支援必要性_うつ) {
        requireNonNull(支援必要性_うつ, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_うつ"));
        entity.setShien_Utsu(支援必要性_うつ);
    }

    /**
     * 二次予防_主観的健康感を設定します。
     *
     * @param 二次予防_主観的健康感 二次予防_主観的健康感
     */
    public void set二次予防_主観的健康感(RString 二次予防_主観的健康感) {
        requireNonNull(二次予防_主観的健康感, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防_主観的健康感"));
        entity.setNijiYobo_ShukantekiKenkouKan(二次予防_主観的健康感);
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
