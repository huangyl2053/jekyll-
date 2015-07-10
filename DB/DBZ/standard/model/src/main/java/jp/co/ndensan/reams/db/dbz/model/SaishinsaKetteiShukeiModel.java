/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 再審査決定集計のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class SaishinsaKetteiShukeiModel implements Serializable {

    private DbT3063SaishinsaKetteiShukeiEntity entity;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiShukeiModel() {
        entity = new DbT3063SaishinsaKetteiShukeiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3063SaishinsaKetteiShukeiEntity
     */
    public SaishinsaKetteiShukeiModel(DbT3063SaishinsaKetteiShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3063SaishinsaKetteiShukeiEntityを返します。
     *
     * @return DbT3063SaishinsaKetteiShukeiEntity
     */
    public DbT3063SaishinsaKetteiShukeiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3063SaishinsaKetteiShukeiEntityを設定します。
     *
     * @param entity DbT3063SaishinsaKetteiShukeiEntity
     */
    public void setEntity(DbT3063SaishinsaKetteiShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * 取扱年月を返します。
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth get取扱年月() {
        return entity.getToriatsukaiYM();
    }

    /**
     * 保険者区分を返します。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return entity.getHokenshaKubun();
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
     * 介護給付費_請求_件数を返します。
     *
     * @return 介護給付費_請求_件数
     */
    public int get介護給付費_請求_件数() {
        return entity.getKaigoKyufuhiSeikyuKensu();
    }

    /**
     * 介護給付費_請求_単位数を返します。
     *
     * @return 介護給付費_請求_単位数
     */
    public Decimal get介護給付費_請求_単位数() {
        return entity.getKaigoKyufuhiSeikyuTanisu();
    }

    /**
     * 介護給付費_請求_保険者負担額を返します。
     *
     * @return 介護給付費_請求_保険者負担額
     */
    public Decimal get介護給付費_請求_保険者負担額() {
        return entity.getKaigoKyufuhiSeikyuFutangaku();
    }

    /**
     * 介護給付費_決定_件数を返します。
     *
     * @return 介護給付費_決定_件数
     */
    public int get介護給付費_決定_件数() {
        return entity.getKaigoKyufuhiKetteiKensu();
    }

    /**
     * 介護給付費_決定_単位数を返します。
     *
     * @return 介護給付費_決定_単位数
     */
    public Decimal get介護給付費_決定_単位数() {
        return entity.getKaigoKyufuhiKetteiTanisu();
    }

    /**
     * 介護給付費_決定_保険者負担額を返します。
     *
     * @return 介護給付費_決定_保険者負担額
     */
    public Decimal get介護給付費_決定_保険者負担額() {
        return entity.getKaigoKyufuhiKetteiFutangaku();
    }

    /**
     * 介護給付費_調整_件数を返します。
     *
     * @return 介護給付費_調整_件数
     */
    public int get介護給付費_調整_件数() {
        return entity.getKaigoKyufuhiChoseiKensu();
    }

    /**
     * 介護給付費_調整_単位数を返します。
     *
     * @return 介護給付費_調整_単位数
     */
    public Decimal get介護給付費_調整_単位数() {
        return entity.getKaigoKyufuhiChoseiTanisu();
    }

    /**
     * 介護給付費_調整_保険者負担額を返します。
     *
     * @return 介護給付費_調整_保険者負担額
     */
    public Decimal get介護給付費_調整_保険者負担額() {
        return entity.getKaigoKyufuhiChoseiFutangaku();
    }

    /**
     * 高額介護サービス費_請求_件数を返します。
     *
     * @return 高額介護サービス費_請求_件数
     */
    public int get高額介護サービス費_請求_件数() {
        return entity.getKogakuKaigoServicehiSeikyuKensu();
    }

    /**
     * 高額介護サービス費_請求_単位数を返します。
     *
     * @return 高額介護サービス費_請求_単位数
     */
    public Decimal get高額介護サービス費_請求_単位数() {
        return entity.getKogakuKaigoServicehiSeikyuTanisu();
    }

    /**
     * 高額介護サービス費_請求_保険者負担額を返します。
     *
     * @return 高額介護サービス費_請求_保険者負担額
     */
    public Decimal get高額介護サービス費_請求_保険者負担額() {
        return entity.getKogakuKaigoServicehiSeikyuFutangaku();
    }

    /**
     * 高額介護サービス費_決定_件数を返します。
     *
     * @return 高額介護サービス費_決定_件数
     */
    public int get高額介護サービス費_決定_件数() {
        return entity.getKogakuKaigoServicehiKetteiKensu();
    }

    /**
     * 高額介護サービス費_決定_単位数を返します。
     *
     * @return 高額介護サービス費_決定_単位数
     */
    public Decimal get高額介護サービス費_決定_単位数() {
        return entity.getKogakuKaigoServicehiKetteiTanisu();
    }

    /**
     * 高額介護サービス費_決定_保険者負担額を返します。
     *
     * @return 高額介護サービス費_決定_保険者負担額
     */
    public Decimal get高額介護サービス費_決定_保険者負担額() {
        return entity.getKogakuKaigoServicehiKetteiFutangaku();
    }

    /**
     * 高額介護サービス費_調整_件数を返します。
     *
     * @return 高額介護サービス費_調整_件数
     */
    public int get高額介護サービス費_調整_件数() {
        return entity.getKogakuKaigoServicehiChoseiKensu();
    }

    /**
     * 高額介護サービス費_調整_単位数を返します。
     *
     * @return 高額介護サービス費_調整_単位数
     */
    public Decimal get高額介護サービス費_調整_単位数() {
        return entity.getKogakuKaigoServicehiChoseiTanisu();
    }

    /**
     * 高額介護サービス費_調整_保険者負担額を返します。
     *
     * @return 高額介護サービス費_調整_保険者負担額
     */
    public Decimal get高額介護サービス費_調整_保険者負担額() {
        return entity.getKogakuKaigoServicehiChoseiFutangaku();
    }

    /**
     * 公費負担者番号を返します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.getKohiFutanshaNo();
    }

    /**
     * 作成年月日を返します。
     *
     * @return 作成年月日
     */
    public FlexibleDate get作成年月日() {
        return entity.getSakuseiYMD();
    }

    /**
     * 審査委員会名を返します。
     *
     * @return 審査委員会名
     */
    public RString get審査委員会名() {
        return entity.getSinsaiinkaiName();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * 取扱年月を設定します。
     *
     * @param 取扱年月 取扱年月
     */
    public void set取扱年月(FlexibleYearMonth 取扱年月) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        entity.setToriatsukaiYM(取扱年月);
    }

    /**
     * 保険者区分を設定します。
     *
     * @param 保険者区分 保険者区分
     */
    public void set保険者区分(RString 保険者区分) {
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        entity.setHokenshaKubun(保険者区分);
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
     * 介護給付費_請求_件数を設定します。
     *
     * @param 介護給付費_請求_件数 介護給付費_請求_件数
     */
    public void set介護給付費_請求_件数(int 介護給付費_請求_件数) {
        requireNonNull(介護給付費_請求_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_請求_件数"));
        entity.setKaigoKyufuhiSeikyuKensu(介護給付費_請求_件数);
    }

    /**
     * 介護給付費_請求_単位数を設定します。
     *
     * @param 介護給付費_請求_単位数 介護給付費_請求_単位数
     */
    public void set介護給付費_請求_単位数(Decimal 介護給付費_請求_単位数) {
        requireNonNull(介護給付費_請求_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_請求_単位数"));
        entity.setKaigoKyufuhiSeikyuTanisu(介護給付費_請求_単位数);
    }

    /**
     * 介護給付費_請求_保険者負担額を設定します。
     *
     * @param 介護給付費_請求_保険者負担額 介護給付費_請求_保険者負担額
     */
    public void set介護給付費_請求_保険者負担額(Decimal 介護給付費_請求_保険者負担額) {
        requireNonNull(介護給付費_請求_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_請求_保険者負担額"));
        entity.setKaigoKyufuhiSeikyuFutangaku(介護給付費_請求_保険者負担額);
    }

    /**
     * 介護給付費_決定_件数を設定します。
     *
     * @param 介護給付費_決定_件数 介護給付費_決定_件数
     */
    public void set介護給付費_決定_件数(int 介護給付費_決定_件数) {
        requireNonNull(介護給付費_決定_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_決定_件数"));
        entity.setKaigoKyufuhiKetteiKensu(介護給付費_決定_件数);
    }

    /**
     * 介護給付費_決定_単位数を設定します。
     *
     * @param 介護給付費_決定_単位数 介護給付費_決定_単位数
     */
    public void set介護給付費_決定_単位数(Decimal 介護給付費_決定_単位数) {
        requireNonNull(介護給付費_決定_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_決定_単位数"));
        entity.setKaigoKyufuhiKetteiTanisu(介護給付費_決定_単位数);
    }

    /**
     * 介護給付費_決定_保険者負担額を設定します。
     *
     * @param 介護給付費_決定_保険者負担額 介護給付費_決定_保険者負担額
     */
    public void set介護給付費_決定_保険者負担額(Decimal 介護給付費_決定_保険者負担額) {
        requireNonNull(介護給付費_決定_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_決定_保険者負担額"));
        entity.setKaigoKyufuhiKetteiFutangaku(介護給付費_決定_保険者負担額);
    }

    /**
     * 介護給付費_調整_件数を設定します。
     *
     * @param 介護給付費_調整_件数 介護給付費_調整_件数
     */
    public void set介護給付費_調整_件数(int 介護給付費_調整_件数) {
        requireNonNull(介護給付費_調整_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_調整_件数"));
        entity.setKaigoKyufuhiChoseiKensu(介護給付費_調整_件数);
    }

    /**
     * 介護給付費_調整_単位数を設定します。
     *
     * @param 介護給付費_調整_単位数 介護給付費_調整_単位数
     */
    public void set介護給付費_調整_単位数(Decimal 介護給付費_調整_単位数) {
        requireNonNull(介護給付費_調整_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_調整_単位数"));
        entity.setKaigoKyufuhiChoseiTanisu(介護給付費_調整_単位数);
    }

    /**
     * 介護給付費_調整_保険者負担額を設定します。
     *
     * @param 介護給付費_調整_保険者負担額 介護給付費_調整_保険者負担額
     */
    public void set介護給付費_調整_保険者負担額(Decimal 介護給付費_調整_保険者負担額) {
        requireNonNull(介護給付費_調整_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費_調整_保険者負担額"));
        entity.setKaigoKyufuhiChoseiFutangaku(介護給付費_調整_保険者負担額);
    }

    /**
     * 高額介護サービス費_請求_件数を設定します。
     *
     * @param 高額介護サービス費_請求_件数 高額介護サービス費_請求_件数
     */
    public void set高額介護サービス費_請求_件数(int 高額介護サービス費_請求_件数) {
        requireNonNull(高額介護サービス費_請求_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_請求_件数"));
        entity.setKogakuKaigoServicehiSeikyuKensu(高額介護サービス費_請求_件数);
    }

    /**
     * 高額介護サービス費_請求_単位数を設定します。
     *
     * @param 高額介護サービス費_請求_単位数 高額介護サービス費_請求_単位数
     */
    public void set高額介護サービス費_請求_単位数(Decimal 高額介護サービス費_請求_単位数) {
        requireNonNull(高額介護サービス費_請求_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_請求_単位数"));
        entity.setKogakuKaigoServicehiSeikyuTanisu(高額介護サービス費_請求_単位数);
    }

    /**
     * 高額介護サービス費_請求_保険者負担額を設定します。
     *
     * @param 高額介護サービス費_請求_保険者負担額 高額介護サービス費_請求_保険者負担額
     */
    public void set高額介護サービス費_請求_保険者負担額(Decimal 高額介護サービス費_請求_保険者負担額) {
        requireNonNull(高額介護サービス費_請求_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_請求_保険者負担額"));
        entity.setKogakuKaigoServicehiSeikyuFutangaku(高額介護サービス費_請求_保険者負担額);
    }

    /**
     * 高額介護サービス費_決定_件数を設定します。
     *
     * @param 高額介護サービス費_決定_件数 高額介護サービス費_決定_件数
     */
    public void set高額介護サービス費_決定_件数(int 高額介護サービス費_決定_件数) {
        requireNonNull(高額介護サービス費_決定_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_決定_件数"));
        entity.setKogakuKaigoServicehiKetteiKensu(高額介護サービス費_決定_件数);
    }

    /**
     * 高額介護サービス費_決定_単位数を設定します。
     *
     * @param 高額介護サービス費_決定_単位数 高額介護サービス費_決定_単位数
     */
    public void set高額介護サービス費_決定_単位数(Decimal 高額介護サービス費_決定_単位数) {
        requireNonNull(高額介護サービス費_決定_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_決定_単位数"));
        entity.setKogakuKaigoServicehiKetteiTanisu(高額介護サービス費_決定_単位数);
    }

    /**
     * 高額介護サービス費_決定_保険者負担額を設定します。
     *
     * @param 高額介護サービス費_決定_保険者負担額 高額介護サービス費_決定_保険者負担額
     */
    public void set高額介護サービス費_決定_保険者負担額(Decimal 高額介護サービス費_決定_保険者負担額) {
        requireNonNull(高額介護サービス費_決定_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_決定_保険者負担額"));
        entity.setKogakuKaigoServicehiKetteiFutangaku(高額介護サービス費_決定_保険者負担額);
    }

    /**
     * 高額介護サービス費_調整_件数を設定します。
     *
     * @param 高額介護サービス費_調整_件数 高額介護サービス費_調整_件数
     */
    public void set高額介護サービス費_調整_件数(int 高額介護サービス費_調整_件数) {
        requireNonNull(高額介護サービス費_調整_件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_調整_件数"));
        entity.setKogakuKaigoServicehiChoseiKensu(高額介護サービス費_調整_件数);
    }

    /**
     * 高額介護サービス費_調整_単位数を設定します。
     *
     * @param 高額介護サービス費_調整_単位数 高額介護サービス費_調整_単位数
     */
    public void set高額介護サービス費_調整_単位数(Decimal 高額介護サービス費_調整_単位数) {
        requireNonNull(高額介護サービス費_調整_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_調整_単位数"));
        entity.setKogakuKaigoServicehiChoseiTanisu(高額介護サービス費_調整_単位数);
    }

    /**
     * 高額介護サービス費_調整_保険者負担額を設定します。
     *
     * @param 高額介護サービス費_調整_保険者負担額 高額介護サービス費_調整_保険者負担額
     */
    public void set高額介護サービス費_調整_保険者負担額(Decimal 高額介護サービス費_調整_保険者負担額) {
        requireNonNull(高額介護サービス費_調整_保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費_調整_保険者負担額"));
        entity.setKogakuKaigoServicehiChoseiFutangaku(高額介護サービス費_調整_保険者負担額);
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     */
    public void set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohiFutanshaNo(公費負担者番号);
    }

    /**
     * 作成年月日を設定します。
     *
     * @param 作成年月日 作成年月日
     */
    public void set作成年月日(FlexibleDate 作成年月日) {
        requireNonNull(作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("作成年月日"));
        entity.setSakuseiYMD(作成年月日);
    }

    /**
     * 審査委員会名を設定します。
     *
     * @param 審査委員会名 審査委員会名
     */
    public void set審査委員会名(RString 審査委員会名) {
        requireNonNull(審査委員会名, UrSystemErrorMessages.値がnull.getReplacedMessage("審査委員会名"));
        entity.setSinsaiinkaiName(審査委員会名);
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     */
    public void set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
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
