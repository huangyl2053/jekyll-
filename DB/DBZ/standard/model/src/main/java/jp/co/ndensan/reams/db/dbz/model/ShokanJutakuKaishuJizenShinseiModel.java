/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給住宅改修事前申請のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanJutakuKaishuJizenShinseiModel implements Serializable {

    private DbT3035ShokanJutakuKaishuJizenShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanJutakuKaishuJizenShinseiModel() {
        entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3035ShokanJutakuKaishuJizenShinseiEntity
     */
    public ShokanJutakuKaishuJizenShinseiModel(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3035ShokanJutakuKaishuJizenShinseiEntityを返します。
     *
     * @return DbT3035ShokanJutakuKaishuJizenShinseiEntity
     */
    public DbT3035ShokanJutakuKaishuJizenShinseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3035ShokanJutakuKaishuJizenShinseiEntityを設定します。
     *
     * @param entity DbT3035ShokanJutakuKaishuJizenShinseiEntity
     */
    public void setEntity(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaNameKanji();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    public RString get事業者名称カナ() {
        return entity.getJigyoshaNameKana();
    }

    /**
     * 事業者郵便番号を返します。
     *
     * @return 事業者郵便番号
     */
    public YubinNo get事業者郵便番号() {
        return entity.getJigyoshaYubunNo();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public RString get事業者住所() {
        return entity.getJigyoshaAddress();
    }

    /**
     * 事業者電話番号を返します。
     *
     * @return 事業者電話番号
     */
    public RString get事業者電話番号() {
        return entity.getJigyoshaTelNo();
    }

    /**
     * 事業者ＦＡＸ番号を返します。
     *
     * @return 事業者ＦＡＸ番号
     */
    public RString get事業者ＦＡＸ番号() {
        return entity.getJigyoshaFaxNo();
    }

    /**
     * 理由書作成者を返します。
     *
     * @return 理由書作成者
     */
    public RString get理由書作成者() {
        return entity.getRiyushoSakuseishaKanji();
    }

    /**
     * 理由書作成者カナを返します。
     *
     * @return 理由書作成者カナ
     */
    public RString get理由書作成者カナ() {
        return entity.getRiyushoSakuseishaKana();
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
     * 契約決定年月日を返します。
     *
     * @return 契約決定年月日
     */
    public FlexibleDate get契約決定年月日() {
        return entity.getKeiyakuKetteiYMD();
    }

    /**
     * 承認区分を返します。
     *
     * @return 承認区分
     */
    public RString get承認区分() {
        return entity.getShoninKubun();
    }

    /**
     * 不承認の理由を返します。
     *
     * @return 不承認の理由
     */
    public RString get不承認の理由() {
        return entity.getFushoninRiyu();
    }

    /**
     * 給付額等_費用額合計を返します。
     *
     * @return 給付額等_費用額合計
     */
    public int get給付額等_費用額合計() {
        return entity.getKyufugakuHiyogakuTotal();
    }

    /**
     * 給付額等_保険対象費用額を返します。
     *
     * @return 給付額等_保険対象費用額
     */
    public int get給付額等_保険対象費用額() {
        return entity.getKyufugakuHokenTaishoHiyogaku();
    }

    /**
     * 給付額等_利用者自己負担額を返します。
     *
     * @return 給付額等_利用者自己負担額
     */
    public int get給付額等_利用者自己負担額() {
        return entity.getKyufugakuRiyoshaJikofutangaku();
    }

    /**
     * 給付額等_保険給付費額を返します。
     *
     * @return 給付額等_保険給付費額
     */
    public int get給付額等_保険給付費額() {
        return entity.getKyufugakuHokenkyufuhigaku();
    }

    /**
     * 施工完了予定年月日を返します。
     *
     * @return 施工完了予定年月日
     */
    public FlexibleDate get施工完了予定年月日() {
        return entity.getSekoKanryoYoteiYMD();
    }

    /**
     * 申請取消事由コードを返します。
     *
     * @return 申請取消事由コード
     */
    public RString get申請取消事由コード() {
        return entity.getShinseiTorikeshiJiyuCode();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
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
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     */
    public void set事業者名称(RString 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaNameKanji(事業者名称);
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     */
    public void set事業者名称カナ(RString 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaNameKana(事業者名称カナ);
    }

    /**
     * 事業者郵便番号を設定します。
     *
     * @param 事業者郵便番号 事業者郵便番号
     */
    public void set事業者郵便番号(YubinNo 事業者郵便番号) {
        requireNonNull(事業者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者郵便番号"));
        entity.setJigyoshaYubunNo(事業者郵便番号);
    }

    /**
     * 事業者住所を設定します。
     *
     * @param 事業者住所 事業者住所
     */
    public void set事業者住所(RString 事業者住所) {
        requireNonNull(事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所"));
        entity.setJigyoshaAddress(事業者住所);
    }

    /**
     * 事業者電話番号を設定します。
     *
     * @param 事業者電話番号 事業者電話番号
     */
    public void set事業者電話番号(RString 事業者電話番号) {
        requireNonNull(事業者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者電話番号"));
        entity.setJigyoshaTelNo(事業者電話番号);
    }

    /**
     * 事業者ＦＡＸ番号を設定します。
     *
     * @param 事業者ＦＡＸ番号 事業者ＦＡＸ番号
     */
    public void set事業者ＦＡＸ番号(RString 事業者ＦＡＸ番号) {
        requireNonNull(事業者ＦＡＸ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者ＦＡＸ番号"));
        entity.setJigyoshaFaxNo(事業者ＦＡＸ番号);
    }

    /**
     * 理由書作成者を設定します。
     *
     * @param 理由書作成者 理由書作成者
     */
    public void set理由書作成者(RString 理由書作成者) {
        requireNonNull(理由書作成者, UrSystemErrorMessages.値がnull.getReplacedMessage("理由書作成者"));
        entity.setRiyushoSakuseishaKanji(理由書作成者);
    }

    /**
     * 理由書作成者カナを設定します。
     *
     * @param 理由書作成者カナ 理由書作成者カナ
     */
    public void set理由書作成者カナ(RString 理由書作成者カナ) {
        requireNonNull(理由書作成者カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("理由書作成者カナ"));
        entity.setRiyushoSakuseishaKana(理由書作成者カナ);
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
     * 契約決定年月日を設定します。
     *
     * @param 契約決定年月日 契約決定年月日
     */
    public void set契約決定年月日(FlexibleDate 契約決定年月日) {
        requireNonNull(契約決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("契約決定年月日"));
        entity.setKeiyakuKetteiYMD(契約決定年月日);
    }

    /**
     * 承認区分を設定します。
     *
     * @param 承認区分 承認区分
     */
    public void set承認区分(RString 承認区分) {
        requireNonNull(承認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("承認区分"));
        entity.setShoninKubun(承認区分);
    }

    /**
     * 不承認の理由を設定します。
     *
     * @param 不承認の理由 不承認の理由
     */
    public void set不承認の理由(RString 不承認の理由) {
        requireNonNull(不承認の理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不承認の理由"));
        entity.setFushoninRiyu(不承認の理由);
    }

    /**
     * 給付額等_費用額合計を設定します。
     *
     * @param 給付額等_費用額合計 給付額等_費用額合計
     */
    public void set給付額等_費用額合計(int 給付額等_費用額合計) {
        requireNonNull(給付額等_費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_費用額合計"));
        entity.setKyufugakuHiyogakuTotal(給付額等_費用額合計);
    }

    /**
     * 給付額等_保険対象費用額を設定します。
     *
     * @param 給付額等_保険対象費用額 給付額等_保険対象費用額
     */
    public void set給付額等_保険対象費用額(int 給付額等_保険対象費用額) {
        requireNonNull(給付額等_保険対象費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_保険対象費用額"));
        entity.setKyufugakuHokenTaishoHiyogaku(給付額等_保険対象費用額);
    }

    /**
     * 給付額等_利用者自己負担額を設定します。
     *
     * @param 給付額等_利用者自己負担額 給付額等_利用者自己負担額
     */
    public void set給付額等_利用者自己負担額(int 給付額等_利用者自己負担額) {
        requireNonNull(給付額等_利用者自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_利用者自己負担額"));
        entity.setKyufugakuRiyoshaJikofutangaku(給付額等_利用者自己負担額);
    }

    /**
     * 給付額等_保険給付費額を設定します。
     *
     * @param 給付額等_保険給付費額 給付額等_保険給付費額
     */
    public void set給付額等_保険給付費額(int 給付額等_保険給付費額) {
        requireNonNull(給付額等_保険給付費額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額等_保険給付費額"));
        entity.setKyufugakuHokenkyufuhigaku(給付額等_保険給付費額);
    }

    /**
     * 施工完了予定年月日を設定します。
     *
     * @param 施工完了予定年月日 施工完了予定年月日
     */
    public void set施工完了予定年月日(FlexibleDate 施工完了予定年月日) {
        requireNonNull(施工完了予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施工完了予定年月日"));
        entity.setSekoKanryoYoteiYMD(施工完了予定年月日);
    }

    /**
     * 申請取消事由コードを設定します。
     *
     * @param 申請取消事由コード 申請取消事由コード
     */
    public void set申請取消事由コード(RString 申請取消事由コード) {
        requireNonNull(申請取消事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請取消事由コード"));
        entity.setShinseiTorikeshiJiyuCode(申請取消事由コード);
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     */
    public void set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
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
