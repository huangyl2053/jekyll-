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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給額計算結果明細のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanShikyugakuKeisanKekkaMeisaiModel implements Serializable {

    private DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiModel() {
        entity = new DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiModel(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityを返します。
     *
     * @return DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity
     */
    public DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityを設定します。
     *
     * @param entity DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity
     */
    public void setEntity(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
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
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
    }

    /**
     * 明細番号を返します。
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return entity.getMeisanNo();
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
     * 保険制度コードを返します。
     *
     * @return 保険制度コード
     */
    public RString get保険制度コード() {
        return entity.getHokenSeidoCode();
    }

    /**
     * 内訳保険者番号を返します。
     *
     * @return 内訳保険者番号
     */
    public RString get内訳保険者番号() {
        return entity.getUchiwakeHokenshaNo();
    }

    /**
     * 国保被保険者証記号を返します。
     *
     * @return 国保被保険者証記号
     */
    public RString get国保被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 被保険者_証番号を返します。
     *
     * @return 被保険者_証番号
     */
    public RString get被保険者_証番号() {
        return entity.getHiHokenshaShoNo();
    }

    /**
     * 内訳保険者名を返します。
     *
     * @return 内訳保険者名
     */
    public RString get内訳保険者名() {
        return entity.getUchiwakeHokenshaMei();
    }

    /**
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 対象者氏名_漢字を返します。
     *
     * @return 対象者氏名_漢字
     */
    public RString get対象者氏名_漢字() {
        return entity.getTaishoshaShimei();
    }

    /**
     * 70歳以上負担額を返します。
     *
     * @return 70歳以上負担額
     */
    public RString get70歳以上負担額() {
        return entity.getOver70_Futangaku();
    }

    /**
     * 70歳以上按分率を返します。
     *
     * @return 70歳以上按分率
     */
    public RString get70歳以上按分率() {
        return entity.getOver70_AmbunRitsu();
    }

    /**
     * 70歳以上支給額を返します。
     *
     * @return 70歳以上支給額
     */
    public RString get70歳以上支給額() {
        return entity.getOver70_Shikyugaku();
    }

    /**
     * 70歳未満負担額を返します。
     *
     * @return 70歳未満負担額
     */
    public RString get70歳未満負担額() {
        return entity.getUnder70_Futangaku();
    }

    /**
     * 負担額を返します。
     *
     * @return 負担額
     */
    public RString get負担額() {
        return entity.getFutangaku();
    }

    /**
     * 按分率を返します。
     *
     * @return 按分率
     */
    public RString get按分率() {
        return entity.getAmbunRitsu();
    }

    /**
     * 70歳未満支給額を返します。
     *
     * @return 70歳未満支給額
     */
    public RString get70歳未満支給額() {
        return entity.getUnder70_Shikyugaku();
    }

    /**
     * 支給額を返します。
     *
     * @return 支給額
     */
    public RString get支給額() {
        return entity.getShikyugaku();
    }

    /**
     * 備考欄記載70歳以上負担額を返します。
     *
     * @return 備考欄記載70歳以上負担額
     */
    public RString get備考欄記載70歳以上負担額() {
        return entity.getOver70_Biko();
    }

    /**
     * 備考欄記載70歳未満負担額を返します。
     *
     * @return 備考欄記載70歳未満負担額
     */
    public RString get備考欄記載70歳未満負担額() {
        return entity.getUnder70_Biko();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getDataKubun();
    }

    /**
     * 受取年月を返します。
     *
     * @return 受取年月
     */
    public FlexibleYearMonth get受取年月() {
        return entity.getUketoriYM();
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
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     */
    public void set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
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
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     */
    public void set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     */
    public void set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisanNo(明細番号);
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
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     */
    public void set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
    }

    /**
     * 内訳保険者番号を設定します。
     *
     * @param 内訳保険者番号 内訳保険者番号
     */
    public void set内訳保険者番号(RString 内訳保険者番号) {
        requireNonNull(内訳保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("内訳保険者番号"));
        entity.setUchiwakeHokenshaNo(内訳保険者番号);
    }

    /**
     * 国保被保険者証記号を設定します。
     *
     * @param 国保被保険者証記号 国保被保険者証記号
     */
    public void set国保被保険者証記号(RString 国保被保険者証記号) {
        requireNonNull(国保被保険者証記号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保被保険者証記号"));
        entity.setKokuho_HihokenshaShoKigo(国保被保険者証記号);
    }

    /**
     * 被保険者_証番号を設定します。
     *
     * @param 被保険者_証番号 被保険者_証番号
     */
    public void set被保険者_証番号(RString 被保険者_証番号) {
        requireNonNull(被保険者_証番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者_証番号"));
        entity.setHiHokenshaShoNo(被保険者_証番号);
    }

    /**
     * 内訳保険者名を設定します。
     *
     * @param 内訳保険者名 内訳保険者名
     */
    public void set内訳保険者名(RString 内訳保険者名) {
        requireNonNull(内訳保険者名, UrSystemErrorMessages.値がnull.getReplacedMessage("内訳保険者名"));
        entity.setUchiwakeHokenshaMei(内訳保険者名);
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     */
    public void set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
    }

    /**
     * 対象者氏名_漢字を設定します。
     *
     * @param 対象者氏名_漢字 対象者氏名_漢字
     */
    public void set対象者氏名_漢字(RString 対象者氏名_漢字) {
        requireNonNull(対象者氏名_漢字, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者氏名_漢字"));
        entity.setTaishoshaShimei(対象者氏名_漢字);
    }

    /**
     * 70歳以上負担額を設定します。
     *
     * @param _70歳以上負担額 70歳以上負担額
     */
    public void set70歳以上負担額(RString _70歳以上負担額) {
        requireNonNull(_70歳以上負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上負担額"));
        entity.setOver70_Futangaku(_70歳以上負担額);
    }

    /**
     * 70歳以上按分率を設定します。
     *
     * @param _70歳以上按分率 70歳以上按分率
     */
    public void set70歳以上按分率(RString _70歳以上按分率) {
        requireNonNull(_70歳以上按分率, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上按分率"));
        entity.setOver70_AmbunRitsu(_70歳以上按分率);
    }

    /**
     * 70歳以上支給額を設定します。
     *
     * @param _70歳以上支給額 70歳以上支給額
     */
    public void set70歳以上支給額(RString _70歳以上支給額) {
        requireNonNull(_70歳以上支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上支給額"));
        entity.setOver70_Shikyugaku(_70歳以上支給額);
    }

    /**
     * 70歳未満負担額を設定します。
     *
     * @param _70歳未満負担額 70歳未満負担額
     */
    public void set70歳未満負担額(RString _70歳未満負担額) {
        requireNonNull(_70歳未満負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満負担額"));
        entity.setUnder70_Futangaku(_70歳未満負担額);
    }

    /**
     * 負担額を設定します。
     *
     * @param 負担額 負担額
     */
    public void set負担額(RString 負担額) {
        requireNonNull(負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額"));
        entity.setFutangaku(負担額);
    }

    /**
     * 按分率を設定します。
     *
     * @param 按分率 按分率
     */
    public void set按分率(RString 按分率) {
        requireNonNull(按分率, UrSystemErrorMessages.値がnull.getReplacedMessage("按分率"));
        entity.setAmbunRitsu(按分率);
    }

    /**
     * 70歳未満支給額を設定します。
     *
     * @param _70歳未満支給額 70歳未満支給額
     */
    public void set70歳未満支給額(RString _70歳未満支給額) {
        requireNonNull(_70歳未満支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満支給額"));
        entity.setUnder70_Shikyugaku(_70歳未満支給額);
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     */
    public void set支給額(RString 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyugaku(支給額);
    }

    /**
     * 備考欄記載70歳以上負担額を設定します。
     *
     * @param 備考欄記載70歳以上負担額 備考欄記載70歳以上負担額
     */
    public void set備考欄記載70歳以上負担額(RString 備考欄記載70歳以上負担額) {
        requireNonNull(備考欄記載70歳以上負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("備考欄記載70歳以上負担額"));
        entity.setOver70_Biko(備考欄記載70歳以上負担額);
    }

    /**
     * 備考欄記載70歳未満負担額を設定します。
     *
     * @param 備考欄記載70歳未満負担額 備考欄記載70歳未満負担額
     */
    public void set備考欄記載70歳未満負担額(RString 備考欄記載70歳未満負担額) {
        requireNonNull(備考欄記載70歳未満負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("備考欄記載70歳未満負担額"));
        entity.setUnder70_Biko(備考欄記載70歳未満負担額);
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     */
    public void setデータ区分(RString データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     */
    public void set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
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
