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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給申請のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanShinseiModel implements Serializable {

    private DbT3034ShokanShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanShinseiModel() {
        entity = new DbT3034ShokanShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3034ShokanShinseiEntity
     */
    public ShokanShinseiModel(DbT3034ShokanShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3034ShokanShinseiEntityを返します。
     *
     * @return DbT3034ShokanShinseiEntity
     */
    public DbT3034ShokanShinseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3034ShokanShinseiEntityを設定します。
     *
     * @param entity DbT3034ShokanShinseiEntity
     */
    public void setEntity(DbT3034ShokanShinseiEntity entity) {
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
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * 申請者区分を返します。
     *
     * @return 申請者区分
     */
    public RString get申請者区分() {
        return entity.getShinseishaKubun();
    }

    /**
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public RString get申請者氏名() {
        return entity.getShinseishaNameKanji();
    }

    /**
     * 申請者氏名カナを返します。
     *
     * @return 申請者氏名カナ
     */
    public RString get申請者氏名カナ() {
        return entity.getShinseishaNameKana();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaAddress();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public RString get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請事業者コードを返します。
     *
     * @return 申請事業者コード
     */
    public RString get申請事業者コード() {
        return entity.getShinseiJigyoshaCode();
    }

    /**
     * 支払金額合計を返します。
     *
     * @return 支払金額合計
     */
    public Decimal get支払金額合計() {
        return entity.getShiharaiKingakuTotal();
    }

    /**
     * 保険給付額を返します。
     *
     * @return 保険給付額
     */
    public int get保険給付額() {
        return entity.getHokenKyufuritsu();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 支給申請審査区分を返します。
     *
     * @return 支給申請審査区分
     */
    public RString get支給申請審査区分() {
        return entity.getShikyuShinseiShinsaKubun();
    }

    /**
     * 審査方法区分を返します。
     *
     * @return 審査方法区分
     */
    public RString get審査方法区分() {
        return entity.getShinsaHohoKubun();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
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
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     */
    public void set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
    }

    /**
     * 申請者区分を設定します。
     *
     * @param 申請者区分 申請者区分
     */
    public void set申請者区分(RString 申請者区分) {
        requireNonNull(申請者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者区分"));
        entity.setShinseishaKubun(申請者区分);
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     */
    public void set申請者氏名(RString 申請者氏名) {
        requireNonNull(申請者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名"));
        entity.setShinseishaNameKanji(申請者氏名);
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     */
    public void set申請者氏名カナ(RString 申請者氏名カナ) {
        requireNonNull(申請者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名カナ"));
        entity.setShinseishaNameKana(申請者氏名カナ);
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     */
    public void set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaAddress(申請者住所);
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     */
    public void set申請者電話番号(RString 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
    }

    /**
     * 申請事業者コードを設定します。
     *
     * @param 申請事業者コード 申請事業者コード
     */
    public void set申請事業者コード(RString 申請事業者コード) {
        requireNonNull(申請事業者コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事業者コード"));
        entity.setShinseiJigyoshaCode(申請事業者コード);
    }

    /**
     * 支払金額合計を設定します。
     *
     * @param 支払金額合計 支払金額合計
     */
    public void set支払金額合計(Decimal 支払金額合計) {
        requireNonNull(支払金額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額合計"));
        entity.setShiharaiKingakuTotal(支払金額合計);
    }

    /**
     * 保険給付額を設定します。
     *
     * @param 保険給付額 保険給付額
     */
    public void set保険給付額(int 保険給付額) {
        requireNonNull(保険給付額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付額"));
        entity.setHokenKyufuritsu(保険給付額);
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     */
    public void set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
    }

    /**
     * 支給申請審査区分を設定します。
     *
     * @param 支給申請審査区分 支給申請審査区分
     */
    public void set支給申請審査区分(RString 支給申請審査区分) {
        requireNonNull(支給申請審査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請審査区分"));
        entity.setShikyuShinseiShinsaKubun(支給申請審査区分);
    }

    /**
     * 審査方法区分を設定します。
     *
     * @param 審査方法区分 審査方法区分
     */
    public void set審査方法区分(RString 審査方法区分) {
        requireNonNull(審査方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分"));
        entity.setShinsaHohoKubun(審査方法区分);
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     */
    public void set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
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
