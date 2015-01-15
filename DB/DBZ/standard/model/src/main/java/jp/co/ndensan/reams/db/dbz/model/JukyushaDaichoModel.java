/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 受給者台帳のモデルクラスです。
 *
 * @author n8187 久保田 英男
 */
public class JukyushaDaichoModel implements Serializable {

    private DbT4001JukyushaDaichoEntity entity;

    /**
     * コンストラクタです。
     */
    public JukyushaDaichoModel() {
        entity = new DbT4001JukyushaDaichoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4001JukyushaDaichoEntity
     */
    public JukyushaDaichoModel(DbT4001JukyushaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4001JukyushaDaichoEntityを返します。
     *
     * @return DbT4001JukyushaDaichoEntity
     */
    public DbT4001JukyushaDaichoEntity getEntity() {
        return entity;
    }

    /**
     * DbT4001JukyushaDaichoEntityを設定します。
     *
     * @param entity DbT4001JukyushaDaichoEntity
     */
    public void setEntity(DbT4001JukyushaDaichoEntity entity) {
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimeStamp();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public ShishoCode get支所コード() {
        return entity.getShishoCode();
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
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public ChikuCode get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 喪失年月日を返します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return entity.getSoshitsuYMD();
    }

    /**
     * 2号特定疾病コードを返します。
     *
     * @return 2号特定疾病コード
     */
    public Code get2号特定疾病コード() {
        return entity.getNigouTokuteiShippeiCode();
    }

    /**
     * 直近異動年月日を返します。
     *
     * @return 直近異動年月日
     */
    public FlexibleDate get直近異動年月日() {
        return entity.getChokkinIdoYMD();
    }

    /**
     * 直近異動事由コードを返します。
     *
     * @return 直近異動事由コード
     */
    public Code get直近異動事由コード() {
        return entity.getChokkinIdoJiyuCode();
    }

    /**
     * 支給限度単位数を返します。
     *
     * @return 支給限度単位数
     */
    public Decimal get支給限度単位数() {
        return entity.getShikyuGendoTanisu();
    }

    /**
     * 支給限度有効開始年月日を返します。
     *
     * @return 支給限度有効開始年月日
     */
    public FlexibleDate get支給限度有効開始年月日() {
        return entity.getShikyuGendoKaishiYMD();
    }

    /**
     * 支給限度有効終了年月日を返します。
     *
     * @return 支給限度有効終了年月日
     */
    public FlexibleDate get支給限度有効終了年月日() {
        return entity.getShikyuGendoShuryoYMD();
    }

    /**
     * 短期入所支給限度日数を返します。
     *
     * @return 短期入所支給限度日数
     */
    public int get短期入所支給限度日数() {
        return entity.getTankiSikyuGendoNissu();
    }

    /**
     * 短期入所支給限度開始年月日を返します。
     *
     * @return 短期入所支給限度開始年月日
     */
    public FlexibleDate get短期入所支給限度開始年月日() {
        return entity.getTankiShikyuGendoKaishiYMD();
    }

    /**
     * 短期入所支給限度終了年月日を返します。
     *
     * @return 短期入所支給限度終了年月日
     */
    public FlexibleDate get短期入所支給限度終了年月日() {
        return entity.getTankiShikyuGendoShuryoYMD();
    }

    /**
     * 自動割当除外者区分を返します。
     *
     * @return 自動割当除外者区分
     */
    public RString get自動割当除外者区分() {
        return entity.getJidoWariateJogaishaKubun();
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimeStamp(処理日時);
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     */
    public void set支所コード(ShishoCode 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
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
     * 地区コードを設定します。
     *
     * @param 地区コード 地区コード
     */
    public void set地区コード(ChikuCode 地区コード) {
        requireNonNull(地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地区コード"));
        entity.setChikuCode(地区コード);
    }

    /**
     * 喪失年月日を設定します。
     *
     * @param 喪失年月日 喪失年月日
     */
    public void set喪失年月日(FlexibleDate 喪失年月日) {
        requireNonNull(喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("喪失年月日"));
        entity.setSoshitsuYMD(喪失年月日);
    }

    /**
     * 2号特定疾病コードを設定します。
     *
     * @param 特定疾病コード 特定疾病コード
     */
    public void set2号特定疾病コード(Code 特定疾病コード) {
        requireNonNull(特定疾病コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定疾病コード"));
        entity.setNigouTokuteiShippeiCode(特定疾病コード);
    }

    /**
     * 直近異動年月日を設定します。
     *
     * @param 直近異動年月日 直近異動年月日
     */
    public void set直近異動年月日(FlexibleDate 直近異動年月日) {
        requireNonNull(直近異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("直近異動年月日"));
        entity.setChokkinIdoYMD(直近異動年月日);
    }

    /**
     * 直近異動事由コードを設定します。
     *
     * @param 直近異動事由コード 直近異動事由コード
     */
    public void set直近異動事由コード(Code 直近異動事由コード) {
        requireNonNull(直近異動事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("直近異動事由コード"));
        entity.setChokkinIdoJiyuCode(直近異動事由コード);
    }

    /**
     * 支給限度単位数を設定します。
     *
     * @param 支給限度単位数 支給限度単位数
     */
    public void set支給限度単位数(Decimal 支給限度単位数) {
        requireNonNull(支給限度単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度単位数"));
        entity.setShikyuGendoTanisu(支給限度単位数);
    }

    /**
     * 支給限度有効開始年月日を設定します。
     *
     * @param 支給限度有効開始年月日 支給限度有効開始年月日
     */
    public void set支給限度有効開始年月日(FlexibleDate 支給限度有効開始年月日) {
        requireNonNull(支給限度有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度有効開始年月日"));
        entity.setShikyuGendoKaishiYMD(支給限度有効開始年月日);
    }

    /**
     * 支給限度有効終了年月日を設定します。
     *
     * @param 支給限度有効終了年月日 支給限度有効終了年月日
     */
    public void set支給限度有効終了年月日(FlexibleDate 支給限度有効終了年月日) {
        requireNonNull(支給限度有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給限度有効終了年月日"));
        entity.setShikyuGendoShuryoYMD(支給限度有効終了年月日);
    }

    /**
     * 短期入所支給限度日数を設定します。
     *
     * @param 短期入所支給限度日数 短期入所支給限度日数
     */
    public void set短期入所支給限度日数(int 短期入所支給限度日数) {
        requireNonNull(短期入所支給限度日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度日数"));
        entity.setTankiSikyuGendoNissu(短期入所支給限度日数);
    }

    /**
     * 短期入所支給限度開始年月日を設定します。
     *
     * @param 短期入所支給限度開始年月日 短期入所支給限度開始年月日
     */
    public void set短期入所支給限度開始年月日(FlexibleDate 短期入所支給限度開始年月日) {
        requireNonNull(短期入所支給限度開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度開始年月日"));
        entity.setTankiShikyuGendoKaishiYMD(短期入所支給限度開始年月日);
    }

    /**
     * 短期入所支給限度終了年月日を設定します。
     *
     * @param 短期入所支給限度終了年月日 短期入所支給限度終了年月日
     */
    public void set短期入所支給限度終了年月日(FlexibleDate 短期入所支給限度終了年月日) {
        requireNonNull(短期入所支給限度終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所支給限度終了年月日"));
        entity.setTankiShikyuGendoShuryoYMD(短期入所支給限度終了年月日);
    }

    /**
     * 自動割当除外者区分を設定します。
     *
     * @param 自動割当除外者区分 自動割当除外者区分
     */
    public void set自動割当除外者区分(RString 自動割当除外者区分) {
        requireNonNull(自動割当除外者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("自動割当除外者区分"));
        entity.setJidoWariateJogaishaKubun(自動割当除外者区分);
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
