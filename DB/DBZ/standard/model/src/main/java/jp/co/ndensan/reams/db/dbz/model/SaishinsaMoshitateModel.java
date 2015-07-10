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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 再審査申立のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class SaishinsaMoshitateModel implements Serializable {

    private DbT3062SaishinsaMoshitateEntity entity;

    /**
     * コンストラクタです。
     */
    public SaishinsaMoshitateModel() {
        entity = new DbT3062SaishinsaMoshitateEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3062SaishinsaMoshitateEntity
     */
    public SaishinsaMoshitateModel(DbT3062SaishinsaMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3062SaishinsaMoshitateEntityを返します。
     *
     * @return DbT3062SaishinsaMoshitateEntity
     */
    public DbT3062SaishinsaMoshitateEntity getEntity() {
        return entity;
    }

    /**
     * DbT3062SaishinsaMoshitateEntityを設定します。
     *
     * @param entity DbT3062SaishinsaMoshitateEntity
     */
    public void setEntity(DbT3062SaishinsaMoshitateEntity entity) {
        this.entity = entity;
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceTeikyoShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
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
     * 申立年月日を返します。
     *
     * @return 申立年月日
     */
    public FlexibleDate get申立年月日() {
        return entity.getMoshitateYMD();
    }

    /**
     * 申立者区分コードを返します。
     *
     * @return 申立者区分コード
     */
    public RString get申立者区分コード() {
        return entity.getMoshitateshaKubunCode();
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
     * 申立単位数を返します。
     *
     * @return 申立単位数
     */
    public int get申立単位数() {
        return entity.getMoshitateTanisu();
    }

    /**
     * 申立事由コードを返します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.getMoshitateJiyuCode();
    }

    /**
     * 国保連送付年月を返します。
     *
     * @return 国保連送付年月
     */
    public FlexibleYearMonth get国保連送付年月() {
        return entity.getKokuhorenSofuYM();
    }

    /**
     * 国保連再送付有フラグを返します。
     *
     * @return 国保連再送付有フラグ
     */
    public boolean get国保連再送付有フラグ() {
        return entity.getKokuhirenSaiSofuAriFlag();
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
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
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
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceTeikyoShuruiCode(サービス種類コード);
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
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
     * 申立年月日を設定します。
     *
     * @param 申立年月日 申立年月日
     */
    public void set申立年月日(FlexibleDate 申立年月日) {
        requireNonNull(申立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申立年月日"));
        entity.setMoshitateYMD(申立年月日);
    }

    /**
     * 申立者区分コードを設定します。
     *
     * @param 申立者区分コード 申立者区分コード
     */
    public void set申立者区分コード(RString 申立者区分コード) {
        requireNonNull(申立者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立者区分コード"));
        entity.setMoshitateshaKubunCode(申立者区分コード);
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
     * 申立単位数を設定します。
     *
     * @param 申立単位数 申立単位数
     */
    public void set申立単位数(int 申立単位数) {
        requireNonNull(申立単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("申立単位数"));
        entity.setMoshitateTanisu(申立単位数);
    }

    /**
     * 申立事由コードを設定します。
     *
     * @param 申立事由コード 申立事由コード
     */
    public void set申立事由コード(RString 申立事由コード) {
        requireNonNull(申立事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由コード"));
        entity.setMoshitateJiyuCode(申立事由コード);
    }

    /**
     * 国保連送付年月を設定します。
     *
     * @param 国保連送付年月 国保連送付年月
     */
    public void set国保連送付年月(FlexibleYearMonth 国保連送付年月) {
        requireNonNull(国保連送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連送付年月"));
        entity.setKokuhorenSofuYM(国保連送付年月);
    }

    /**
     * 国保連再送付有フラグを設定します。
     *
     * @param 国保連再送付有フラグ 国保連再送付有フラグ
     */
    public void set国保連再送付有フラグ(boolean 国保連再送付有フラグ) {
        requireNonNull(国保連再送付有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連再送付有フラグ"));
        entity.setKokuhirenSaiSofuAriFlag(国保連再送付有フラグ);
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
