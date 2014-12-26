/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.NinshoshaCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護支払情報のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KaigoShiharaiJohoModel implements Serializable {

    private DbT7004KaigoShiharaiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public KaigoShiharaiJohoModel() {
        entity = new DbT7004KaigoShiharaiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7004KaigoShiharaiJohoEntity
     */
    public KaigoShiharaiJohoModel(DbT7004KaigoShiharaiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7004KaigoShiharaiJohoEntityを返します。
     *
     * @return DbT7004KaigoShiharaiJohoEntity
     */
    public DbT7004KaigoShiharaiJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7004KaigoShiharaiJohoEntityを設定します。
     *
     * @param entity DbT7004KaigoShiharaiJohoEntity
     */
    public void setEntity(DbT7004KaigoShiharaiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
        return entity.getShubetsuCode();
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
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 科目コードを設定します。
     *
     * @param 科目コード 科目コード
     */
    public void set科目コード(KamokuCode 科目コード) {
        requireNonNull(科目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("科目コード"));
        entity.setKamokuCode(科目コード);
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     */
    public void set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
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
     * 支払方法区分を設定します。
     *
     * @param 支払方法区分 支払方法区分
     */
    public void set支払方法区分(RString 支払方法区分) {
        requireNonNull(支払方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法区分"));
        entity.setShiharaiHohoKubun(支払方法区分);
    }

    /**
     * 窓口支払場所コードを設定します。
     *
     * @param 窓口支払場所コード 窓口支払場所コード
     */
    public void set窓口支払場所コード(Code 窓口支払場所コード) {
        requireNonNull(窓口支払場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口支払場所コード"));
        entity.setMadoguchiShiharaiBashoCode(窓口支払場所コード);
    }

    /**
     * 窓口支払開始年月日時分を設定します。
     *
     * @param 窓口支払開始年月日時分 窓口支払開始年月日時分
     */
    public void set窓口支払開始年月日時分(YMDHM 窓口支払開始年月日時分) {
        requireNonNull(窓口支払開始年月日時分, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口支払開始年月日時分"));
        entity.setMadoguchiShiharaiKaishiYMDHM(窓口支払開始年月日時分);
    }

    /**
     * 窓口支払終了年月日時分を設定します。
     *
     * @param 窓口支払終了年月日時分 窓口支払終了年月日時分
     */
    public void set窓口支払終了年月日時分(YMDHM 窓口支払終了年月日時分) {
        requireNonNull(窓口支払終了年月日時分, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口支払終了年月日時分"));
        entity.setMadoguchiShiharaiShuryoYMDHM(窓口支払終了年月日時分);
    }

    /**
     * 振込予定年月日を設定します。
     *
     * @param 振込予定年月日 振込予定年月日
     */
    public void set振込予定年月日(FlexibleDate 振込予定年月日) {
        requireNonNull(振込予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("振込予定年月日"));
        entity.setFurikomiYoteiYMD(振込予定年月日);
    }

    /**
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     */
    public void set支払金額(int 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShiharaiKingaku(支払金額);
    }

    /**
     * 種別コードを設定します。
     *
     * @param 種別コード 種別コード
     */
    public void set種別コード(Code 種別コード) {
        requireNonNull(種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("種別コード"));
        entity.setShubetsuCode(種別コード);
    }

    /**
     * 用途区分コードを設定します。
     *
     * @param 用途区分コード 用途区分コード
     */
    public void set用途区分コード(Code 用途区分コード) {
        requireNonNull(用途区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("用途区分コード"));
        entity.setYotoKubunCode(用途区分コード);
    }

    /**
     * 認証日１を設定します。
     *
     * @param 認証日１ 認証日１
     */
    public void set認証日１(FlexibleDate 認証日１) {
        requireNonNull(認証日１, UrSystemErrorMessages.値がnull.getReplacedMessage("認証日１"));
        entity.setNinshoYMD1(認証日１);
    }

    /**
     * 認証者コード１を設定します。
     *
     * @param 認証者コード１ 認証者コード１
     */
    public void set認証者コード１(NinshoshaCode 認証者コード１) {
        requireNonNull(認証者コード１, UrSystemErrorMessages.値がnull.getReplacedMessage("認証者コード１"));
        entity.setNinshoshaCode1(認証者コード１);
    }

    /**
     * 認証日２を設定します。
     *
     * @param 認証日２ 認証日２
     */
    public void set認証日２(FlexibleDate 認証日２) {
        requireNonNull(認証日２, UrSystemErrorMessages.値がnull.getReplacedMessage("認証日２"));
        entity.setNinshoYMD2(認証日２);
    }

    /**
     * 認証者コード２を設定します。
     *
     * @param 認証者コード２ 認証者コード２
     */
    public void set認証者コード２(NinshoshaCode 認証者コード２) {
        requireNonNull(認証者コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("認証者コード２"));
        entity.setNinshoshaCode2(認証者コード２);
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
