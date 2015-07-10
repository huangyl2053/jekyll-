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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績明細のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiMeisaiModel implements Serializable {

    private DbT3018KyufujissekiMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiMeisaiModel() {
        entity = new DbT3018KyufujissekiMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3018KyufujissekiMeisaiEntity
     */
    public KyufujissekiMeisaiModel(DbT3018KyufujissekiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3018KyufujissekiMeisaiEntityを返します。
     *
     * @return DbT3018KyufujissekiMeisaiEntity
     */
    public DbT3018KyufujissekiMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3018KyufujissekiMeisaiEntityを設定します。
     *
     * @param entity DbT3018KyufujissekiMeisaiEntity
     */
    public void setEntity(DbT3018KyufujissekiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
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
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity.getTanisu();
    }

    /**
     * 日数_回数を返します。
     *
     * @return 日数_回数
     */
    public int get日数_回数() {
        return entity.getNissuKaisu();
    }

    /**
     * 公費１対象日数_回数を返します。
     *
     * @return 公費１対象日数_回数
     */
    public int get公費１対象日数_回数() {
        return entity.getKohi1TaishoNissuKaisu();
    }

    /**
     * 公費２対象日数_回数を返します。
     *
     * @return 公費２対象日数_回数
     */
    public int get公費２対象日数_回数() {
        return entity.getKohi2TaishoNissuKaisu();
    }

    /**
     * 公費３対象日数_回数を返します。
     *
     * @return 公費３対象日数_回数
     */
    public int get公費３対象日数_回数() {
        return entity.getKohi3TaishoNissuKaisu();
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
     * 公費１対象サービス単位数を返します。
     *
     * @return 公費１対象サービス単位数
     */
    public int get公費１対象サービス単位数() {
        return entity.getKohi1TaishoServiceTanisu();
    }

    /**
     * 公費２対象サービス単位数を返します。
     *
     * @return 公費２対象サービス単位数
     */
    public int get公費２対象サービス単位数() {
        return entity.getKohi2TaishoServiceTanisu();
    }

    /**
     * 公費３対象サービス単位数を返します。
     *
     * @return 公費３対象サービス単位数
     */
    public int get公費３対象サービス単位数() {
        return entity.getKohi3TaishoServiceTanisu();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 後_単位数を返します。
     *
     * @return 後_単位数
     */
    public int get後_単位数() {
        return entity.getAtoTanisu();
    }

    /**
     * 後_日数_回数を返します。
     *
     * @return 後_日数_回数
     */
    public int get後_日数_回数() {
        return entity.getAtoNissuKaisu();
    }

    /**
     * 後_公費１対象日数_回数を返します。
     *
     * @return 後_公費１対象日数_回数
     */
    public int get後_公費１対象日数_回数() {
        return entity.getAtoKohi1TaishoNissuKaisu();
    }

    /**
     * 後_公費２対象日数_回数を返します。
     *
     * @return 後_公費２対象日数_回数
     */
    public int get後_公費２対象日数_回数() {
        return entity.getAtoKohi2TaishoNissukaisu();
    }

    /**
     * 後_公費３対象日数_回数を返します。
     *
     * @return 後_公費３対象日数_回数
     */
    public int get後_公費３対象日数_回数() {
        return entity.getAtoKohi3TaishoNissuKaisu();
    }

    /**
     * 後_サービス単位数を返します。
     *
     * @return 後_サービス単位数
     */
    public int get後_サービス単位数() {
        return entity.getAtoServiceTanisu();
    }

    /**
     * 後_公費１対象サービス単位数を返します。
     *
     * @return 後_公費１対象サービス単位数
     */
    public int get後_公費１対象サービス単位数() {
        return entity.getAtoKohi1TaishoServiceTanisu();
    }

    /**
     * 後_公費２対象サービス単位数を返します。
     *
     * @return 後_公費２対象サービス単位数
     */
    public int get後_公費２対象サービス単位数() {
        return entity.getAtoKohi2TaishoServiceTanisu();
    }

    /**
     * 後_公費３対象サービス単位数を返します。
     *
     * @return 後_公費３対象サービス単位数
     */
    public int get後_公費３対象サービス単位数() {
        return entity.getAtoKohi3TaishoServiceTanisu();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public int get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public int get過誤回数() {
        return entity.getKagoKaisu();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
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
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     */
    public void set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     */
    public void setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
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
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     */
    public void set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
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
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     */
    public void set単位数(int 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
    }

    /**
     * 日数_回数を設定します。
     *
     * @param 日数_回数 日数_回数
     */
    public void set日数_回数(int 日数_回数) {
        requireNonNull(日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数_回数"));
        entity.setNissuKaisu(日数_回数);
    }

    /**
     * 公費１対象日数_回数を設定します。
     *
     * @param 公費１対象日数_回数 公費１対象日数_回数
     */
    public void set公費１対象日数_回数(int 公費１対象日数_回数) {
        requireNonNull(公費１対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象日数_回数"));
        entity.setKohi1TaishoNissuKaisu(公費１対象日数_回数);
    }

    /**
     * 公費２対象日数_回数を設定します。
     *
     * @param 公費２対象日数_回数 公費２対象日数_回数
     */
    public void set公費２対象日数_回数(int 公費２対象日数_回数) {
        requireNonNull(公費２対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象日数_回数"));
        entity.setKohi2TaishoNissuKaisu(公費２対象日数_回数);
    }

    /**
     * 公費３対象日数_回数を設定します。
     *
     * @param 公費３対象日数_回数 公費３対象日数_回数
     */
    public void set公費３対象日数_回数(int 公費３対象日数_回数) {
        requireNonNull(公費３対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象日数_回数"));
        entity.setKohi3TaishoNissuKaisu(公費３対象日数_回数);
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
     * 公費１対象サービス単位数を設定します。
     *
     * @param 公費１対象サービス単位数 公費１対象サービス単位数
     */
    public void set公費１対象サービス単位数(int 公費１対象サービス単位数) {
        requireNonNull(公費１対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象サービス単位数"));
        entity.setKohi1TaishoServiceTanisu(公費１対象サービス単位数);
    }

    /**
     * 公費２対象サービス単位数を設定します。
     *
     * @param 公費２対象サービス単位数 公費２対象サービス単位数
     */
    public void set公費２対象サービス単位数(int 公費２対象サービス単位数) {
        requireNonNull(公費２対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象サービス単位数"));
        entity.setKohi2TaishoServiceTanisu(公費２対象サービス単位数);
    }

    /**
     * 公費３対象サービス単位数を設定します。
     *
     * @param 公費３対象サービス単位数 公費３対象サービス単位数
     */
    public void set公費３対象サービス単位数(int 公費３対象サービス単位数) {
        requireNonNull(公費３対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象サービス単位数"));
        entity.setKohi3TaishoServiceTanisu(公費３対象サービス単位数);
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     */
    public void set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
    }

    /**
     * 後_単位数を設定します。
     *
     * @param 後_単位数 後_単位数
     */
    public void set後_単位数(int 後_単位数) {
        requireNonNull(後_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数"));
        entity.setAtoTanisu(後_単位数);
    }

    /**
     * 後_日数_回数を設定します。
     *
     * @param 後_日数_回数 後_日数_回数
     */
    public void set後_日数_回数(int 後_日数_回数) {
        requireNonNull(後_日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_日数_回数"));
        entity.setAtoNissuKaisu(後_日数_回数);
    }

    /**
     * 後_公費１対象日数_回数を設定します。
     *
     * @param 後_公費１対象日数_回数 後_公費１対象日数_回数
     */
    public void set後_公費１対象日数_回数(int 後_公費１対象日数_回数) {
        requireNonNull(後_公費１対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１対象日数_回数"));
        entity.setAtoKohi1TaishoNissuKaisu(後_公費１対象日数_回数);
    }

    /**
     * 後_公費２対象日数_回数を設定します。
     *
     * @param 後_公費２対象日数_回数 後_公費２対象日数_回数
     */
    public void set後_公費２対象日数_回数(int 後_公費２対象日数_回数) {
        requireNonNull(後_公費２対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２対象日数_回数"));
        entity.setAtoKohi2TaishoNissukaisu(後_公費２対象日数_回数);
    }

    /**
     * 後_公費３対象日数_回数を設定します。
     *
     * @param 後_公費３対象日数_回数 後_公費３対象日数_回数
     */
    public void set後_公費３対象日数_回数(int 後_公費３対象日数_回数) {
        requireNonNull(後_公費３対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３対象日数_回数"));
        entity.setAtoKohi3TaishoNissuKaisu(後_公費３対象日数_回数);
    }

    /**
     * 後_サービス単位数を設定します。
     *
     * @param 後_サービス単位数 後_サービス単位数
     */
    public void set後_サービス単位数(int 後_サービス単位数) {
        requireNonNull(後_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数"));
        entity.setAtoServiceTanisu(後_サービス単位数);
    }

    /**
     * 後_公費１対象サービス単位数を設定します。
     *
     * @param 後_公費１対象サービス単位数 後_公費１対象サービス単位数
     */
    public void set後_公費１対象サービス単位数(int 後_公費１対象サービス単位数) {
        requireNonNull(後_公費１対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１対象サービス単位数"));
        entity.setAtoKohi1TaishoServiceTanisu(後_公費１対象サービス単位数);
    }

    /**
     * 後_公費２対象サービス単位数を設定します。
     *
     * @param 後_公費２対象サービス単位数 後_公費２対象サービス単位数
     */
    public void set後_公費２対象サービス単位数(int 後_公費２対象サービス単位数) {
        requireNonNull(後_公費２対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２対象サービス単位数"));
        entity.setAtoKohi2TaishoServiceTanisu(後_公費２対象サービス単位数);
    }

    /**
     * 後_公費３対象サービス単位数を設定します。
     *
     * @param 後_公費３対象サービス単位数 後_公費３対象サービス単位数
     */
    public void set後_公費３対象サービス単位数(int 後_公費３対象サービス単位数) {
        requireNonNull(後_公費３対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３対象サービス単位数"));
        entity.setAtoKohi3TaishoServiceTanisu(後_公費３対象サービス単位数);
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     */
    public void set再審査回数(int 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     */
    public void set過誤回数(int 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     */
    public void set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
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
