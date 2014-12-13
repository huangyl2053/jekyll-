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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求基本のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanKihonModel implements Serializable {

    private DbT3038ShokanKihonEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanKihonModel() {
        entity = new DbT3038ShokanKihonEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3038ShokanKihonEntity
     */
    public ShokanKihonModel(DbT3038ShokanKihonEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3038ShokanKihonEntityを返します。
     *
     * @return DbT3038ShokanKihonEntity
     */
    public DbT3038ShokanKihonEntity getEntity() {
        return entity;
    }

    /**
     * DbT3038ShokanKihonEntityを設定します。
     *
     * @param entity DbT3038ShokanKihonEntity
     */
    public void setEntity(DbT3038ShokanKihonEntity entity) {
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
        return entity.getSeiriNp();
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
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
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
     * 旧措置入所者特例コードを返します。
     *
     * @return 旧措置入所者特例コード
     */
    public RString get旧措置入所者特例コード() {
        return entity.getKyuSochiNyushoshaTokureiCode();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.getKyotakuServiceSakuseiKubunCode();
    }

    /**
     * 居宅サービス計画事業者番号を返します。
     *
     * @return 居宅サービス計画事業者番号
     */
    public JigyoshaNo get居宅サービス計画事業者番号() {
        return entity.getKyotakuserviceJigyoshaNo();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 中止年月日を返します。
     *
     * @return 中止年月日
     */
    public FlexibleDate get中止年月日() {
        return entity.getChushiYMD();
    }

    /**
     * 中止理由_入所_院前の状況コードを返します。
     *
     * @return 中止理由_入所_院前の状況コード
     */
    public RString get中止理由_入所_院前の状況コード() {
        return entity.getChushiRiyuNyushomaeJyokyoCode();
    }

    /**
     * 入所_院年月日を返します。
     *
     * @return 入所_院年月日
     */
    public FlexibleDate get入所_院年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所_院年月日を返します。
     *
     * @return 退所_院年月日
     */
    public FlexibleDate get退所_院年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所_院実日数を返します。
     *
     * @return 入所_院実日数
     */
    public int get入所_院実日数() {
        return entity.getNyushoJitsuNissu();
    }

    /**
     * 外泊日数を返します。
     *
     * @return 外泊日数
     */
    public int get外泊日数() {
        return entity.getGaihakuNissu();
    }

    /**
     * 退所_院後の状態コードを返します。
     *
     * @return 退所_院後の状態コード
     */
    public RString get退所_院後の状態コード() {
        return entity.getTaishogoJotaiCode();
    }

    /**
     * 保険給付率を返します。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu get保険給付率() {
        return entity.getHokenKyufuritsu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * 保険請求額を返します。
     *
     * @return 保険請求額
     */
    public Decimal get保険請求額() {
        return entity.getHokenSeikyugaku();
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
     * 緊急時施設療養費請求額を返します。
     *
     * @return 緊急時施設療養費請求額
     */
    public Decimal get緊急時施設療養費請求額() {
        return entity.getKinkyuShisetsuRyoyoSeikyugaku();
    }

    /**
     * 特定診療費請求額を返します。
     *
     * @return 特定診療費請求額
     */
    public Decimal get特定診療費請求額() {
        return entity.getTokuteiShinryoSeikyugaku();
    }

    /**
     * 特定入所者介護サービス費等請求額を返します。
     *
     * @return 特定入所者介護サービス費等請求額
     */
    public int get特定入所者介護サービス費等請求額() {
        return entity.getTokuteiNyushoshaKaigoServiceSeikyugaku();
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
        entity.setSeiriNp(整理番号);
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
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    public void set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
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
     * 旧措置入所者特例コードを設定します。
     *
     * @param 旧措置入所者特例コード 旧措置入所者特例コード
     */
    public void set旧措置入所者特例コード(RString 旧措置入所者特例コード) {
        requireNonNull(旧措置入所者特例コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置入所者特例コード"));
        entity.setKyuSochiNyushoshaTokureiCode(旧措置入所者特例コード);
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     */
    public void set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        requireNonNull(居宅サービス計画作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成区分コード"));
        entity.setKyotakuServiceSakuseiKubunCode(居宅サービス計画作成区分コード);
    }

    /**
     * 居宅サービス計画事業者番号を設定します。
     *
     * @param 居宅サービス計画事業者番号 居宅サービス計画事業者番号
     */
    public void set居宅サービス計画事業者番号(JigyoshaNo 居宅サービス計画事業者番号) {
        requireNonNull(居宅サービス計画事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画事業者番号"));
        entity.setKyotakuserviceJigyoshaNo(居宅サービス計画事業者番号);
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     */
    public void set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
    }

    /**
     * 中止年月日を設定します。
     *
     * @param 中止年月日 中止年月日
     */
    public void set中止年月日(FlexibleDate 中止年月日) {
        requireNonNull(中止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("中止年月日"));
        entity.setChushiYMD(中止年月日);
    }

    /**
     * 中止理由_入所_院前の状況コードを設定します。
     *
     * @param 中止理由_入所_院前の状況コード 中止理由_入所_院前の状況コード
     */
    public void set中止理由_入所_院前の状況コード(RString 中止理由_入所_院前の状況コード) {
        requireNonNull(中止理由_入所_院前の状況コード, UrSystemErrorMessages.値がnull.getReplacedMessage("中止理由_入所_院前の状況コード"));
        entity.setChushiRiyuNyushomaeJyokyoCode(中止理由_入所_院前の状況コード);
    }

    /**
     * 入所_院年月日を設定します。
     *
     * @param 入所_院年月日 入所_院年月日
     */
    public void set入所_院年月日(FlexibleDate 入所_院年月日) {
        requireNonNull(入所_院年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所_院年月日"));
        entity.setNyushoYMD(入所_院年月日);
    }

    /**
     * 退所_院年月日を設定します。
     *
     * @param 退所_院年月日 退所_院年月日
     */
    public void set退所_院年月日(FlexibleDate 退所_院年月日) {
        requireNonNull(退所_院年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所_院年月日"));
        entity.setTaishoYMD(退所_院年月日);
    }

    /**
     * 入所_院実日数を設定します。
     *
     * @param 入所_院実日数 入所_院実日数
     */
    public void set入所_院実日数(int 入所_院実日数) {
        requireNonNull(入所_院実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("入所_院実日数"));
        entity.setNyushoJitsuNissu(入所_院実日数);
    }

    /**
     * 外泊日数を設定します。
     *
     * @param 外泊日数 外泊日数
     */
    public void set外泊日数(int 外泊日数) {
        requireNonNull(外泊日数, UrSystemErrorMessages.値がnull.getReplacedMessage("外泊日数"));
        entity.setGaihakuNissu(外泊日数);
    }

    /**
     * 退所_院後の状態コードを設定します。
     *
     * @param 退所_院後の状態コード 退所_院後の状態コード
     */
    public void set退所_院後の状態コード(RString 退所_院後の状態コード) {
        requireNonNull(退所_院後の状態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("退所_院後の状態コード"));
        entity.setTaishogoJotaiCode(退所_院後の状態コード);
    }

    /**
     * 保険給付率を設定します。
     *
     * @param 保険給付率 保険給付率
     */
    public void set保険給付率(HokenKyufuRitsu 保険給付率) {
        requireNonNull(保険給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付率"));
        entity.setHokenKyufuritsu(保険給付率);
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     */
    public void setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
    }

    /**
     * 保険請求額を設定します。
     *
     * @param 保険請求額 保険請求額
     */
    public void set保険請求額(Decimal 保険請求額) {
        requireNonNull(保険請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険請求額"));
        entity.setHokenSeikyugaku(保険請求額);
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
     * 緊急時施設療養費請求額を設定します。
     *
     * @param 緊急時施設療養費請求額 緊急時施設療養費請求額
     */
    public void set緊急時施設療養費請求額(Decimal 緊急時施設療養費請求額) {
        requireNonNull(緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養費請求額"));
        entity.setKinkyuShisetsuRyoyoSeikyugaku(緊急時施設療養費請求額);
    }

    /**
     * 特定診療費請求額を設定します。
     *
     * @param 特定診療費請求額 特定診療費請求額
     */
    public void set特定診療費請求額(Decimal 特定診療費請求額) {
        requireNonNull(特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療費請求額"));
        entity.setTokuteiShinryoSeikyugaku(特定診療費請求額);
    }

    /**
     * 特定入所者介護サービス費等請求額を設定します。
     *
     * @param 特定入所者介護サービス費等請求額 特定入所者介護サービス費等請求額
     */
    public void set特定入所者介護サービス費等請求額(int 特定入所者介護サービス費等請求額) {
        requireNonNull(特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費等請求額"));
        entity.setTokuteiNyushoshaKaigoServiceSeikyugaku(特定入所者介護サービス費等請求額);
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
