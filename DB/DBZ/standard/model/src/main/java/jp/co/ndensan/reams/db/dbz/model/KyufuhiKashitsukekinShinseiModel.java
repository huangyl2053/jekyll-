/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3086KyufuhiKashitsukekinShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金申請のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukekinShinseiModel implements Serializable {

    private DbT3086KyufuhiKashitsukekinShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShinseiModel() {
        entity = new DbT3086KyufuhiKashitsukekinShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3086KyufuhiKashitsukekinShinseiEntity
     */
    public KyufuhiKashitsukekinShinseiModel(DbT3086KyufuhiKashitsukekinShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3086KyufuhiKashitsukekinShinseiEntityを返します。
     *
     * @return DbT3086KyufuhiKashitsukekinShinseiEntity
     */
    public DbT3086KyufuhiKashitsukekinShinseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3086KyufuhiKashitsukekinShinseiEntityを設定します。
     *
     * @param entity DbT3086KyufuhiKashitsukekinShinseiEntity
     */
    public void setEntity(DbT3086KyufuhiKashitsukekinShinseiEntity entity) {
        this.entity = entity;
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
     * 借入申請年月日を返します。
     *
     * @return 借入申請年月日
     */
    public FlexibleDate get借入申請年月日() {
        return entity.getKariireShinseiYMD();
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
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaJusho();
    }

    /**
     * 申請者氏名カナを返します。
     *
     * @return 申請者氏名カナ
     */
    public AtenaKanaMeisho get申請者氏名カナ() {
        return entity.getShinseishaShimeiKana();
    }

    /**
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public AtenaMeisho get申請者氏名() {
        return entity.getShinseishaShimei();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public TelNo get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請者との関係を返します。
     *
     * @return 申請者との関係
     */
    public RString get申請者との関係() {
        return entity.getShinseishaKankei();
    }

    /**
     * 借入利用期間開始年月日を返します。
     *
     * @return 借入利用期間開始年月日
     */
    public FlexibleDate get借入利用期間開始年月日() {
        return entity.getKariireRiyoKaishiYMD();
    }

    /**
     * 借入利用期間終了年月日を返します。
     *
     * @return 借入利用期間終了年月日
     */
    public FlexibleDate get借入利用期間終了年月日() {
        return entity.getKariireRiyoShuryoYMD();
    }

    /**
     * 貸付対象_高額介護サービス費等有無を返します。
     *
     * @return 貸付対象_高額介護サービス費等有無
     */
    public RString get貸付対象_高額介護サービス費等有無() {
        return entity.getKashitsuke_KogakuUmu();
    }

    /**
     * 貸付対象_住宅改修費等有無を返します。
     *
     * @return 貸付対象_住宅改修費等有無
     */
    public RString get貸付対象_住宅改修費等有無() {
        return entity.getKashitsuke_JutakuKaishuUmu();
    }

    /**
     * 貸付対象_福祉用具購入費等有無を返します。
     *
     * @return 貸付対象_福祉用具購入費等有無
     */
    public RString get貸付対象_福祉用具購入費等有無() {
        return entity.getKahitsuke_YoguKonyuUmu();
    }

    /**
     * 貸付対象_特例介護サービス費等有無を返します。
     *
     * @return 貸付対象_特例介護サービス費等有無
     */
    public RString get貸付対象_特例介護サービス費等有無() {
        return entity.getKashitsuke_TokureiServiceUmu();
    }

    /**
     * 保証人氏名カナを返します。
     *
     * @return 保証人氏名カナ
     */
    public AtenaKanaMeisho get保証人氏名カナ() {
        return entity.getHoshonin_ShimeiKana();
    }

    /**
     * 保証人氏名を返します。
     *
     * @return 保証人氏名
     */
    public AtenaMeisho get保証人氏名() {
        return entity.getHoshonin_Shimei();
    }

    /**
     * 保証人生年月日を返します。
     *
     * @return 保証人生年月日
     */
    public FlexibleDate get保証人生年月日() {
        return entity.getHoshonin_UmareYMD();
    }

    /**
     * 保証人性別を返します。
     *
     * @return 保証人性別
     */
    public Code get保証人性別() {
        return entity.getHoshinin_SeibetsuCd();
    }

    /**
     * 保証人郵便番号を返します。
     *
     * @return 保証人郵便番号
     */
    public YubinNo get保証人郵便番号() {
        return entity.getHoshonin_YubinNo();
    }

    /**
     * 保証人住所を返します。
     *
     * @return 保証人住所
     */
    public RString get保証人住所() {
        return entity.getHoshonin_Jusho();
    }

    /**
     * 保証人電話番号を返します。
     *
     * @return 保証人電話番号
     */
    public TelNo get保証人電話番号() {
        return entity.getHoshonin_TelNo();
    }

    /**
     * 借入申請者との関係を返します。
     *
     * @return 借入申請者との関係
     */
    public RString get借入申請者との関係() {
        return entity.getKariireShinseishaKankei();
    }

    /**
     * 保証人勤務先名称を返します。
     *
     * @return 保証人勤務先名称
     */
    public AtenaMeisho get保証人勤務先名称() {
        return entity.getHoshonin_KinmusakiMeisho();
    }

    /**
     * 保証人勤務先郵便番号を返します。
     *
     * @return 保証人勤務先郵便番号
     */
    public YubinNo get保証人勤務先郵便番号() {
        return entity.getHoshonin_KinmusakiYubinNo();
    }

    /**
     * 保証人勤務先所在地を返します。
     *
     * @return 保証人勤務先所在地
     */
    public RString get保証人勤務先所在地() {
        return entity.getHoshonin_KinmusakiJusho();
    }

    /**
     * 保証人勤務先電話番号を返します。
     *
     * @return 保証人勤務先電話番号
     */
    public TelNo get保証人勤務先電話番号() {
        return entity.getHoshonin_KinmusakiTelNo();
    }

    /**
     * 請求書_領収書の有無を返します。
     *
     * @return 請求書_領収書の有無
     */
    public RString get請求書_領収書の有無() {
        return entity.getSeikyusho_RyoshushoUmu();
    }

    /**
     * 提出物管理番号を返します。
     *
     * @return 提出物管理番号
     */
    public int get提出物管理番号() {
        return entity.getTeishutsubutsuKanriNo();
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
     * 借入申請年月日を設定します。
     *
     * @param 借入申請年月日 借入申請年月日
     */
    public void set借入申請年月日(FlexibleDate 借入申請年月日) {
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        entity.setKariireShinseiYMD(借入申請年月日);
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
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     */
    public void set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     */
    public void set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaJusho(申請者住所);
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     */
    public void set申請者氏名カナ(AtenaKanaMeisho 申請者氏名カナ) {
        requireNonNull(申請者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名カナ"));
        entity.setShinseishaShimeiKana(申請者氏名カナ);
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     */
    public void set申請者氏名(AtenaMeisho 申請者氏名) {
        requireNonNull(申請者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名"));
        entity.setShinseishaShimei(申請者氏名);
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     */
    public void set申請者電話番号(TelNo 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
    }

    /**
     * 申請者との関係を設定します。
     *
     * @param 申請者との関係 申請者との関係
     */
    public void set申請者との関係(RString 申請者との関係) {
        requireNonNull(申請者との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者との関係"));
        entity.setShinseishaKankei(申請者との関係);
    }

    /**
     * 借入利用期間開始年月日を設定します。
     *
     * @param 借入利用期間開始年月日 借入利用期間開始年月日
     */
    public void set借入利用期間開始年月日(FlexibleDate 借入利用期間開始年月日) {
        requireNonNull(借入利用期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入利用期間開始年月日"));
        entity.setKariireRiyoKaishiYMD(借入利用期間開始年月日);
    }

    /**
     * 借入利用期間終了年月日を設定します。
     *
     * @param 借入利用期間終了年月日 借入利用期間終了年月日
     */
    public void set借入利用期間終了年月日(FlexibleDate 借入利用期間終了年月日) {
        requireNonNull(借入利用期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入利用期間終了年月日"));
        entity.setKariireRiyoShuryoYMD(借入利用期間終了年月日);
    }

    /**
     * 貸付対象_高額介護サービス費等有無を設定します。
     *
     * @param 貸付対象_高額介護サービス費等有無 貸付対象_高額介護サービス費等有無
     */
    public void set貸付対象_高額介護サービス費等有無(RString 貸付対象_高額介護サービス費等有無) {
        requireNonNull(貸付対象_高額介護サービス費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象_高額介護サービス費等有無"));
        entity.setKashitsuke_KogakuUmu(貸付対象_高額介護サービス費等有無);
    }

    /**
     * 貸付対象_住宅改修費等有無を設定します。
     *
     * @param 貸付対象_住宅改修費等有無 貸付対象_住宅改修費等有無
     */
    public void set貸付対象_住宅改修費等有無(RString 貸付対象_住宅改修費等有無) {
        requireNonNull(貸付対象_住宅改修費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象_住宅改修費等有無"));
        entity.setKashitsuke_JutakuKaishuUmu(貸付対象_住宅改修費等有無);
    }

    /**
     * 貸付対象_福祉用具購入費等有無を設定します。
     *
     * @param 貸付対象_福祉用具購入費等有無 貸付対象_福祉用具購入費等有無
     */
    public void set貸付対象_福祉用具購入費等有無(RString 貸付対象_福祉用具購入費等有無) {
        requireNonNull(貸付対象_福祉用具購入費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象_福祉用具購入費等有無"));
        entity.setKahitsuke_YoguKonyuUmu(貸付対象_福祉用具購入費等有無);
    }

    /**
     * 貸付対象_特例介護サービス費等有無を設定します。
     *
     * @param 貸付対象_特例介護サービス費等有無 貸付対象_特例介護サービス費等有無
     */
    public void set貸付対象_特例介護サービス費等有無(RString 貸付対象_特例介護サービス費等有無) {
        requireNonNull(貸付対象_特例介護サービス費等有無, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付対象_特例介護サービス費等有無"));
        entity.setKashitsuke_TokureiServiceUmu(貸付対象_特例介護サービス費等有無);
    }

    /**
     * 保証人氏名カナを設定します。
     *
     * @param 保証人氏名カナ 保証人氏名カナ
     */
    public void set保証人氏名カナ(AtenaKanaMeisho 保証人氏名カナ) {
        requireNonNull(保証人氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名カナ"));
        entity.setHoshonin_ShimeiKana(保証人氏名カナ);
    }

    /**
     * 保証人氏名を設定します。
     *
     * @param 保証人氏名 保証人氏名
     */
    public void set保証人氏名(AtenaMeisho 保証人氏名) {
        requireNonNull(保証人氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人氏名"));
        entity.setHoshonin_Shimei(保証人氏名);
    }

    /**
     * 保証人生年月日を設定します。
     *
     * @param 保証人生年月日 保証人生年月日
     */
    public void set保証人生年月日(FlexibleDate 保証人生年月日) {
        requireNonNull(保証人生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人生年月日"));
        entity.setHoshonin_UmareYMD(保証人生年月日);
    }

    /**
     * 保証人性別を設定します。
     *
     * @param 保証人性別 保証人性別
     */
    public void set保証人性別(Code 保証人性別) {
        requireNonNull(保証人性別, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人性別"));
        entity.setHoshinin_SeibetsuCd(保証人性別);
    }

    /**
     * 保証人郵便番号を設定します。
     *
     * @param 保証人郵便番号 保証人郵便番号
     */
    public void set保証人郵便番号(YubinNo 保証人郵便番号) {
        requireNonNull(保証人郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人郵便番号"));
        entity.setHoshonin_YubinNo(保証人郵便番号);
    }

    /**
     * 保証人住所を設定します。
     *
     * @param 保証人住所 保証人住所
     */
    public void set保証人住所(RString 保証人住所) {
        requireNonNull(保証人住所, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人住所"));
        entity.setHoshonin_Jusho(保証人住所);
    }

    /**
     * 保証人電話番号を設定します。
     *
     * @param 保証人電話番号 保証人電話番号
     */
    public void set保証人電話番号(TelNo 保証人電話番号) {
        requireNonNull(保証人電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人電話番号"));
        entity.setHoshonin_TelNo(保証人電話番号);
    }

    /**
     * 借入申請者との関係を設定します。
     *
     * @param 借入申請者との関係 借入申請者との関係
     */
    public void set借入申請者との関係(RString 借入申請者との関係) {
        requireNonNull(借入申請者との関係, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請者との関係"));
        entity.setKariireShinseishaKankei(借入申請者との関係);
    }

    /**
     * 保証人勤務先名称を設定します。
     *
     * @param 保証人勤務先名称 保証人勤務先名称
     */
    public void set保証人勤務先名称(AtenaMeisho 保証人勤務先名称) {
        requireNonNull(保証人勤務先名称, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先名称"));
        entity.setHoshonin_KinmusakiMeisho(保証人勤務先名称);
    }

    /**
     * 保証人勤務先郵便番号を設定します。
     *
     * @param 保証人勤務先郵便番号 保証人勤務先郵便番号
     */
    public void set保証人勤務先郵便番号(YubinNo 保証人勤務先郵便番号) {
        requireNonNull(保証人勤務先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先郵便番号"));
        entity.setHoshonin_KinmusakiYubinNo(保証人勤務先郵便番号);
    }

    /**
     * 保証人勤務先所在地を設定します。
     *
     * @param 保証人勤務先所在地 保証人勤務先所在地
     */
    public void set保証人勤務先所在地(RString 保証人勤務先所在地) {
        requireNonNull(保証人勤務先所在地, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先所在地"));
        entity.setHoshonin_KinmusakiJusho(保証人勤務先所在地);
    }

    /**
     * 保証人勤務先電話番号を設定します。
     *
     * @param 保証人勤務先電話番号 保証人勤務先電話番号
     */
    public void set保証人勤務先電話番号(TelNo 保証人勤務先電話番号) {
        requireNonNull(保証人勤務先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保証人勤務先電話番号"));
        entity.setHoshonin_KinmusakiTelNo(保証人勤務先電話番号);
    }

    /**
     * 請求書_領収書の有無を設定します。
     *
     * @param 請求書_領収書の有無 請求書_領収書の有無
     */
    public void set請求書_領収書の有無(RString 請求書_領収書の有無) {
        requireNonNull(請求書_領収書の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("請求書_領収書の有無"));
        entity.setSeikyusho_RyoshushoUmu(請求書_領収書の有無);
    }

    /**
     * 提出物管理番号を設定します。
     *
     * @param 提出物管理番号 提出物管理番号
     */
    public void set提出物管理番号(int 提出物管理番号) {
        requireNonNull(提出物管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("提出物管理番号"));
        entity.setTeishutsubutsuKanriNo(提出物管理番号);
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
