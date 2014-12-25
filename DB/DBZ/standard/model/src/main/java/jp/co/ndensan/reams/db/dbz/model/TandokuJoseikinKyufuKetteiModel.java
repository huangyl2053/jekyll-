/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村単独助成金給付決定のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class TandokuJoseikinKyufuKetteiModel implements Serializable {

    private DbT3097TandokuJoseikinKyufuKetteiEntity entity;

    /**
     * コンストラクタです。
     */
    public TandokuJoseikinKyufuKetteiModel() {
        entity = new DbT3097TandokuJoseikinKyufuKetteiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3097TandokuJoseikinKyufuKetteiEntity
     */
    public TandokuJoseikinKyufuKetteiModel(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3097TandokuJoseikinKyufuKetteiEntityを返します。
     *
     * @return DbT3097TandokuJoseikinKyufuKetteiEntity
     */
    public DbT3097TandokuJoseikinKyufuKetteiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3097TandokuJoseikinKyufuKetteiEntityを設定します。
     *
     * @param entity DbT3097TandokuJoseikinKyufuKetteiEntity
     */
    public void setEntity(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
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
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 有効期限を返します。
     *
     * @return 有効期限
     */
    public FlexibleDate get有効期限() {
        return entity.getYukoKigenYMD();
    }

    /**
     * 利用者負担_決定区分を返します。
     *
     * @return 利用者負担_決定区分
     */
    public RString get利用者負担_決定区分() {
        return entity.getRiyoshaFutan_KetteiKubun();
    }

    /**
     * 利用者負担_不承認理由を返します。
     *
     * @return 利用者負担_不承認理由
     */
    public RString get利用者負担_不承認理由() {
        return entity.getRiyoshaFutan_FuShoninRiyu();
    }

    /**
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohi_JukyushaNo();
    }

    /**
     * 公費負担者番号を返します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.getKohi_FutanshaNo();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * 受給者番号を返します。
     *
     * @return 受給者番号
     */
    public RString get受給者番号() {
        return entity.getJukyushaNo();
    }

    /**
     * 経過措置を返します。
     *
     * @return 経過措置
     */
    public RString get経過措置() {
        return entity.getKeikaSochiKubun();
    }

    /**
     * 国軽減を返します。
     *
     * @return 国軽減
     */
    public RString get国軽減() {
        return entity.getKuniKeigenKubun();
    }

    /**
     * 社会福祉法人軽減を返します。
     *
     * @return 社会福祉法人軽減
     */
    public RString get社会福祉法人軽減() {
        return entity.getShakaiFukushiHojinKeigenKubun();
    }

    /**
     * 特別地域加算を返します。
     *
     * @return 特別地域加算
     */
    public RString get特別地域加算() {
        return entity.getTokubetsuChiikiKasanKubun();
    }

    /**
     * 保留区分_滞納を返します。
     *
     * @return 保留区分_滞納
     */
    public RString get保留区分_滞納() {
        return entity.getTaino_HoryuKubun();
    }

    /**
     * 保留区分_認定申請中を返します。
     *
     * @return 保留区分_認定申請中
     */
    public RString get保留区分_認定申請中() {
        return entity.getNinteiShinseichu_HoryuKubun();
    }

    /**
     * 保留区分_認定有効期限切れを返します。
     *
     * @return 保留区分_認定有効期限切れ
     */
    public RString get保留区分_認定有効期限切れ() {
        return entity.getNinteiKigenGire_HoryuKubun();
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
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     */
    public void set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     */
    public void set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
    }

    /**
     * 有効期限を設定します。
     *
     * @param 有効期限 有効期限
     */
    public void set有効期限(FlexibleDate 有効期限) {
        requireNonNull(有効期限, UrSystemErrorMessages.値がnull.getReplacedMessage("有効期限"));
        entity.setYukoKigenYMD(有効期限);
    }

    /**
     * 利用者負担_決定区分を設定します。
     *
     * @param 利用者負担_決定区分 利用者負担_決定区分
     */
    public void set利用者負担_決定区分(RString 利用者負担_決定区分) {
        requireNonNull(利用者負担_決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担_決定区分"));
        entity.setRiyoshaFutan_KetteiKubun(利用者負担_決定区分);
    }

    /**
     * 利用者負担_不承認理由を設定します。
     *
     * @param 利用者負担_不承認理由 利用者負担_不承認理由
     */
    public void set利用者負担_不承認理由(RString 利用者負担_不承認理由) {
        requireNonNull(利用者負担_不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担_不承認理由"));
        entity.setRiyoshaFutan_FuShoninRiyu(利用者負担_不承認理由);
    }

    /**
     * 公費受給者番号を設定します。
     *
     * @param 公費受給者番号 公費受給者番号
     */
    public void set公費受給者番号(RString 公費受給者番号) {
        requireNonNull(公費受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費受給者番号"));
        entity.setKohi_JukyushaNo(公費受給者番号);
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     */
    public void set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohi_FutanshaNo(公費負担者番号);
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     */
    public void set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
    }

    /**
     * 受給者番号を設定します。
     *
     * @param 受給者番号 受給者番号
     */
    public void set受給者番号(RString 受給者番号) {
        requireNonNull(受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者番号"));
        entity.setJukyushaNo(受給者番号);
    }

    /**
     * 経過措置を設定します。
     *
     * @param 経過措置 経過措置
     */
    public void set経過措置(RString 経過措置) {
        requireNonNull(経過措置, UrSystemErrorMessages.値がnull.getReplacedMessage("経過措置"));
        entity.setKeikaSochiKubun(経過措置);
    }

    /**
     * 国軽減を設定します。
     *
     * @param 国軽減 国軽減
     */
    public void set国軽減(RString 国軽減) {
        requireNonNull(国軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("国軽減"));
        entity.setKuniKeigenKubun(国軽減);
    }

    /**
     * 社会福祉法人軽減を設定します。
     *
     * @param 社会福祉法人軽減 社会福祉法人軽減
     */
    public void set社会福祉法人軽減(RString 社会福祉法人軽減) {
        requireNonNull(社会福祉法人軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減"));
        entity.setShakaiFukushiHojinKeigenKubun(社会福祉法人軽減);
    }

    /**
     * 特別地域加算を設定します。
     *
     * @param 特別地域加算 特別地域加算
     */
    public void set特別地域加算(RString 特別地域加算) {
        requireNonNull(特別地域加算, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算"));
        entity.setTokubetsuChiikiKasanKubun(特別地域加算);
    }

    /**
     * 保留区分_滞納を設定します。
     *
     * @param 保留区分_滞納 保留区分_滞納
     */
    public void set保留区分_滞納(RString 保留区分_滞納) {
        requireNonNull(保留区分_滞納, UrSystemErrorMessages.値がnull.getReplacedMessage("保留区分_滞納"));
        entity.setTaino_HoryuKubun(保留区分_滞納);
    }

    /**
     * 保留区分_認定申請中を設定します。
     *
     * @param 保留区分_認定申請中 保留区分_認定申請中
     */
    public void set保留区分_認定申請中(RString 保留区分_認定申請中) {
        requireNonNull(保留区分_認定申請中, UrSystemErrorMessages.値がnull.getReplacedMessage("保留区分_認定申請中"));
        entity.setNinteiShinseichu_HoryuKubun(保留区分_認定申請中);
    }

    /**
     * 保留区分_認定有効期限切れを設定します。
     *
     * @param 保留区分_認定有効期限切れ 保留区分_認定有効期限切れ
     */
    public void set保留区分_認定有効期限切れ(RString 保留区分_認定有効期限切れ) {
        requireNonNull(保留区分_認定有効期限切れ, UrSystemErrorMessages.値がnull.getReplacedMessage("保留区分_認定有効期限切れ"));
        entity.setNinteiKigenGire_HoryuKubun(保留区分_認定有効期限切れ);
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
