/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 過誤決定集計のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KagoKetteiShukeiModel implements Serializable {

    private DbT3060KagoKetteiShukeiEntity entity;

    /**
     * コンストラクタです。
     */
    public KagoKetteiShukeiModel() {
        entity = new DbT3060KagoKetteiShukeiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3060KagoKetteiShukeiEntity
     */
    public KagoKetteiShukeiModel(DbT3060KagoKetteiShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3060KagoKetteiShukeiEntityを返します。
     *
     * @return DbT3060KagoKetteiShukeiEntity
     */
    public DbT3060KagoKetteiShukeiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3060KagoKetteiShukeiEntityを設定します。
     *
     * @param entity DbT3060KagoKetteiShukeiEntity
     */
    public void setEntity(DbT3060KagoKetteiShukeiEntity entity) {
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
     * 介護給付費件数を返します。
     *
     * @return 介護給付費件数
     */
    public int get介護給付費件数() {
        return entity.getKaigoKyufuhiKensu();
    }

    /**
     * 介護給付費単位数を返します。
     *
     * @return 介護給付費単位数
     */
    public Decimal get介護給付費単位数() {
        return entity.getKaigoKyufuhiTanisu();
    }

    /**
     * 介護給付費保険者負担額を返します。
     *
     * @return 介護給付費保険者負担額
     */
    public Decimal get介護給付費保険者負担額() {
        return entity.getKaigoKyufuhiFutangaku();
    }

    /**
     * 高額介護サービス費件数を返します。
     *
     * @return 高額介護サービス費件数
     */
    public int get高額介護サービス費件数() {
        return entity.getKogakuServicehiKensu();
    }

    /**
     * 高額介護サービス費単位数を返します。
     *
     * @return 高額介護サービス費単位数
     */
    public Decimal get高額介護サービス費単位数() {
        return entity.getKogakuServicehiTanisu();
    }

    /**
     * 高額介護サービス費保険者負担額を返します。
     *
     * @return 高額介護サービス費保険者負担額
     */
    public Decimal get高額介護サービス費保険者負担額() {
        return entity.getKogakuServicehiFutangaku();
    }

    /**
     * 特定入所者介護サービス費等件数を返します。
     *
     * @return 特定入所者介護サービス費等件数
     */
    public int get特定入所者介護サービス費等件数() {
        return entity.getTokuteiNyushoshaServicehiKensu();
    }

    /**
     * 特定入所者介護サービス費等費用額を返します。
     *
     * @return 特定入所者介護サービス費等費用額
     */
    public Decimal get特定入所者介護サービス費等費用額() {
        return entity.getTokuteiNyushoshaServicehiTanisu();
    }

    /**
     * 特定入所者介護サービス費等保険者負担額を返します。
     *
     * @return 特定入所者介護サービス費等保険者負担額
     */
    public Decimal get特定入所者介護サービス費等保険者負担額() {
        return entity.getTokuteiNyushoshaServicehiFutangaku();
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
     * 介護給付費件数を設定します。
     *
     * @param 介護給付費件数 介護給付費件数
     */
    public void set介護給付費件数(int 介護給付費件数) {
        requireNonNull(介護給付費件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費件数"));
        entity.setKaigoKyufuhiKensu(介護給付費件数);
    }

    /**
     * 介護給付費単位数を設定します。
     *
     * @param 介護給付費単位数 介護給付費単位数
     */
    public void set介護給付費単位数(Decimal 介護給付費単位数) {
        requireNonNull(介護給付費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費単位数"));
        entity.setKaigoKyufuhiTanisu(介護給付費単位数);
    }

    /**
     * 介護給付費保険者負担額を設定します。
     *
     * @param 介護給付費保険者負担額 介護給付費保険者負担額
     */
    public void set介護給付費保険者負担額(Decimal 介護給付費保険者負担額) {
        requireNonNull(介護給付費保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護給付費保険者負担額"));
        entity.setKaigoKyufuhiFutangaku(介護給付費保険者負担額);
    }

    /**
     * 高額介護サービス費件数を設定します。
     *
     * @param 高額介護サービス費件数 高額介護サービス費件数
     */
    public void set高額介護サービス費件数(int 高額介護サービス費件数) {
        requireNonNull(高額介護サービス費件数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費件数"));
        entity.setKogakuServicehiKensu(高額介護サービス費件数);
    }

    /**
     * 高額介護サービス費単位数を設定します。
     *
     * @param 高額介護サービス費単位数 高額介護サービス費単位数
     */
    public void set高額介護サービス費単位数(Decimal 高額介護サービス費単位数) {
        requireNonNull(高額介護サービス費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費単位数"));
        entity.setKogakuServicehiTanisu(高額介護サービス費単位数);
    }

    /**
     * 高額介護サービス費保険者負担額を設定します。
     *
     * @param 高額介護サービス費保険者負担額 高額介護サービス費保険者負担額
     */
    public void set高額介護サービス費保険者負担額(Decimal 高額介護サービス費保険者負担額) {
        requireNonNull(高額介護サービス費保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費保険者負担額"));
        entity.setKogakuServicehiFutangaku(高額介護サービス費保険者負担額);
    }

    /**
     * 特定入所者介護サービス費等件数を設定します。
     *
     * @param 特定入所者介護サービス費等件数 特定入所者介護サービス費等件数
     */
    public void set特定入所者介護サービス費等件数(int 特定入所者介護サービス費等件数) {
        requireNonNull(特定入所者介護サービス費等件数, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等件数"));
        entity.setTokuteiNyushoshaServicehiKensu(特定入所者介護サービス費等件数);
    }

    /**
     * 特定入所者介護サービス費等費用額を設定します。
     *
     * @param 特定入所者介護サービス費等費用額 特定入所者介護サービス費等費用額
     */
    public void set特定入所者介護サービス費等費用額(Decimal 特定入所者介護サービス費等費用額) {
        requireNonNull(特定入所者介護サービス費等費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等費用額"));
        entity.setTokuteiNyushoshaServicehiTanisu(特定入所者介護サービス費等費用額);
    }

    /**
     * 特定入所者介護サービス費等保険者負担額を設定します。
     *
     * @param 特定入所者介護サービス費等保険者負担額 特定入所者介護サービス費等保険者負担額
     */
    public void set特定入所者介護サービス費等保険者負担額(Decimal 特定入所者介護サービス費等保険者負担額) {
        requireNonNull(特定入所者介護サービス費等保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等保険者負担額"));
        entity.setTokuteiNyushoshaServicehiFutangaku(特定入所者介護サービス費等保険者負担額);
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
