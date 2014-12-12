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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 再審査決定明細のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class SaishinsaKetteiMeisaiModel implements Serializable {

    private DbT3064SaishinsaKetteiMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiMeisaiModel() {
        entity = new DbT3064SaishinsaKetteiMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3064SaishinsaKetteiMeisaiEntity
     */
    public SaishinsaKetteiMeisaiModel(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3064SaishinsaKetteiMeisaiEntityを返します。
     *
     * @return DbT3064SaishinsaKetteiMeisaiEntity
     */
    public DbT3064SaishinsaKetteiMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3064SaishinsaKetteiMeisaiEntityを設定します。
     *
     * @param entity DbT3064SaishinsaKetteiMeisaiEntity
     */
    public void setEntity(DbT3064SaishinsaKetteiMeisaiEntity entity) {
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 事業所名を返します。
     *
     * @return 事業所名
     */
    public RString get事業所名() {
        return entity.getJigyoshoName();
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
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohiJukyushaNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス種類名を返します。
     *
     * @return サービス種類名
     */
    public RString getサービス種類名() {
        return entity.getServiceShuruiName();
    }

    /**
     * 申立事由コードを返します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.getMoushitateJiyuCode();
    }

    /**
     * 申立事由を返します。
     *
     * @return 申立事由
     */
    public RString get申立事由() {
        return entity.getMoushitateJiyu();
    }

    /**
     * 再審査結果コードを返します。
     *
     * @return 再審査結果コード
     */
    public RString get再審査結果コード() {
        return entity.getSaishinsaResultCode();
    }

    /**
     * 当初請求単位数を返します。
     *
     * @return 当初請求単位数
     */
    public Decimal get当初請求単位数() {
        return entity.getToshoSeikyuTanisu();
    }

    /**
     * 原審単位数を返します。
     *
     * @return 原審単位数
     */
    public Decimal get原審単位数() {
        return entity.getGenshinSeikyuTanisu();
    }

    /**
     * 申立単位数を返します。
     *
     * @return 申立単位数
     */
    public Decimal get申立単位数() {
        return entity.getMoushitateTanisu();
    }

    /**
     * 決定単位数を返します。
     *
     * @return 決定単位数
     */
    public Decimal get決定単位数() {
        return entity.getKetteiTanisu();
    }

    /**
     * 調整単位数を返します。
     *
     * @return 調整単位数
     */
    public Decimal get調整単位数() {
        return entity.getChoseiTanisu();
    }

    /**
     * 保険者負担額を返します。
     *
     * @return 保険者負担額
     */
    public Decimal get保険者負担額() {
        return entity.getHokenshaFutangaku();
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
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
    }

    /**
     * 事業所名を設定します。
     *
     * @param 事業所名 事業所名
     */
    public void set事業所名(RString 事業所名) {
        requireNonNull(事業所名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所名"));
        entity.setJigyoshoName(事業所名);
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
     * 公費受給者番号を設定します。
     *
     * @param 公費受給者番号 公費受給者番号
     */
    public void set公費受給者番号(RString 公費受給者番号) {
        requireNonNull(公費受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費受給者番号"));
        entity.setKohiJukyushaNo(公費受給者番号);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
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
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
    }

    /**
     * サービス種類名を設定します。
     *
     * @param サービス種類名 サービス種類名
     */
    public void setサービス種類名(RString サービス種類名) {
        requireNonNull(サービス種類名, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類名"));
        entity.setServiceShuruiName(サービス種類名);
    }

    /**
     * 申立事由コードを設定します。
     *
     * @param 申立事由コード 申立事由コード
     */
    public void set申立事由コード(RString 申立事由コード) {
        requireNonNull(申立事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由コード"));
        entity.setMoushitateJiyuCode(申立事由コード);
    }

    /**
     * 申立事由を設定します。
     *
     * @param 申立事由 申立事由
     */
    public void set申立事由(RString 申立事由) {
        requireNonNull(申立事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由"));
        entity.setMoushitateJiyu(申立事由);
    }

    /**
     * 再審査結果コードを設定します。
     *
     * @param 再審査結果コード 再審査結果コード
     */
    public void set再審査結果コード(RString 再審査結果コード) {
        requireNonNull(再審査結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査結果コード"));
        entity.setSaishinsaResultCode(再審査結果コード);
    }

    /**
     * 当初請求単位数を設定します。
     *
     * @param 当初請求単位数 当初請求単位数
     */
    public void set当初請求単位数(Decimal 当初請求単位数) {
        requireNonNull(当初請求単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("当初請求単位数"));
        entity.setToshoSeikyuTanisu(当初請求単位数);
    }

    /**
     * 原審単位数を設定します。
     *
     * @param 原審単位数 原審単位数
     */
    public void set原審単位数(Decimal 原審単位数) {
        requireNonNull(原審単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("原審単位数"));
        entity.setGenshinSeikyuTanisu(原審単位数);
    }

    /**
     * 申立単位数を設定します。
     *
     * @param 申立単位数 申立単位数
     */
    public void set申立単位数(Decimal 申立単位数) {
        requireNonNull(申立単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("申立単位数"));
        entity.setMoushitateTanisu(申立単位数);
    }

    /**
     * 決定単位数を設定します。
     *
     * @param 決定単位数 決定単位数
     */
    public void set決定単位数(Decimal 決定単位数) {
        requireNonNull(決定単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("決定単位数"));
        entity.setKetteiTanisu(決定単位数);
    }

    /**
     * 調整単位数を設定します。
     *
     * @param 調整単位数 調整単位数
     */
    public void set調整単位数(Decimal 調整単位数) {
        requireNonNull(調整単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("調整単位数"));
        entity.setChoseiTanisu(調整単位数);
    }

    /**
     * 保険者負担額を設定します。
     *
     * @param 保険者負担額 保険者負担額
     */
    public void set保険者負担額(Decimal 保険者負担額) {
        requireNonNull(保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者負担額"));
        entity.setHokenshaFutangaku(保険者負担額);
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
