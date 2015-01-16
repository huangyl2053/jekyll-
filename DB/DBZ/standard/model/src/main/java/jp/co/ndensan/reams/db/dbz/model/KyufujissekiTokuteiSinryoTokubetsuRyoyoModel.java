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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績特定診療費・特別療養費のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoModel implements Serializable {

    private DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoModel() {
        entity = new DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoModel(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityを返します。
     *
     * @return DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity
     */
    public DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntityを設定します。
     *
     * @param entity DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity
     */
    public void setEntity(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
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
     * 特定診療情報レコード順次番号を返します。
     *
     * @return 特定診療情報レコード順次番号
     */
    public RString get特定診療情報レコード順次番号() {
        return entity.getRecodeJunjiNo();
    }

    /**
     * 傷病名を返します。
     *
     * @return 傷病名
     */
    public RString get傷病名() {
        return entity.getShobyoName();
    }

    /**
     * 識別番号を返します。
     *
     * @return 識別番号
     */
    public RString get識別番号() {
        return entity.getShikibetsuNo();
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
     * 保険_回数を返します。
     *
     * @return 保険_回数
     */
    public int get保険_回数() {
        return entity.getHokenKaisu();
    }

    /**
     * 保険_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 保険_ｻｰﾋﾞｽ単位数
     */
    public int get保険_ｻｰﾋﾞｽ単位数() {
        return entity.getHokenServiceTanisu();
    }

    /**
     * 保険_合計単位数を返します。
     *
     * @return 保険_合計単位数
     */
    public int get保険_合計単位数() {
        return entity.getHokenTotalTanisu();
    }

    /**
     * 公費１_回数を返します。
     *
     * @return 公費１_回数
     */
    public int get公費１_回数() {
        return entity.getKohi1Kaisu();
    }

    /**
     * 公費１_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 公費１_ｻｰﾋﾞｽ単位数
     */
    public int get公費１_ｻｰﾋﾞｽ単位数() {
        return entity.getKohi1ServiceTanisu();
    }

    /**
     * 公費１_合計単位数を返します。
     *
     * @return 公費１_合計単位数
     */
    public int get公費１_合計単位数() {
        return entity.getKohi1TotalTanisu();
    }

    /**
     * 公費２_回数を返します。
     *
     * @return 公費２_回数
     */
    public int get公費２_回数() {
        return entity.getKohi2Kaisu();
    }

    /**
     * 公費２_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 公費２_ｻｰﾋﾞｽ単位数
     */
    public int get公費２_ｻｰﾋﾞｽ単位数() {
        return entity.getKohi2ServiceTanisu();
    }

    /**
     * 公費２_合計単位数を返します。
     *
     * @return 公費２_合計単位数
     */
    public int get公費２_合計単位数() {
        return entity.getKohi2TotalTanisu();
    }

    /**
     * 公費３_回数を返します。
     *
     * @return 公費３_回数
     */
    public int get公費３_回数() {
        return entity.getKohi3Kaisu();
    }

    /**
     * 公費３_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 公費３_ｻｰﾋﾞｽ単位数
     */
    public int get公費３_ｻｰﾋﾞｽ単位数() {
        return entity.getKohi3ServiceTanisu();
    }

    /**
     * 公費３_合計単位数を返します。
     *
     * @return 公費３_合計単位数
     */
    public int get公費３_合計単位数() {
        return entity.getKohi3TotalTanisu();
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
     * 後_保険_回数を返します。
     *
     * @return 後_保険_回数
     */
    public int get後_保険_回数() {
        return entity.getAtoHokenKaisu();
    }

    /**
     * 後_保険_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_保険_ｻｰﾋﾞｽ単位数
     */
    public int get後_保険_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoHokenServiceTanisu();
    }

    /**
     * 後_保険_合計単位数を返します。
     *
     * @return 後_保険_合計単位数
     */
    public int get後_保険_合計単位数() {
        return entity.getAtoHokenTotalTanisu();
    }

    /**
     * 後_公費１_回数を返します。
     *
     * @return 後_公費１_回数
     */
    public int get後_公費１_回数() {
        return entity.getAtoKohi1Kaisu();
    }

    /**
     * 後_公費１_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_公費１_ｻｰﾋﾞｽ単位数
     */
    public int get後_公費１_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoKohi1ServiceTanisu();
    }

    /**
     * 後_公費１_合計単位数を返します。
     *
     * @return 後_公費１_合計単位数
     */
    public int get後_公費１_合計単位数() {
        return entity.getAtoKohi1TotalTanisu();
    }

    /**
     * 後_公費２_回数を返します。
     *
     * @return 後_公費２_回数
     */
    public int get後_公費２_回数() {
        return entity.getAtoKohi2Kaisu();
    }

    /**
     * 後_公費２_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_公費２_ｻｰﾋﾞｽ単位数
     */
    public int get後_公費２_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoKohi2ServiceTanisu();
    }

    /**
     * 後_公費２_合計単位数を返します。
     *
     * @return 後_公費２_合計単位数
     */
    public int get後_公費２_合計単位数() {
        return entity.getAtoKohi2TotalTanisu();
    }

    /**
     * 後_公費３_回数を返します。
     *
     * @return 後_公費３_回数
     */
    public int get後_公費３_回数() {
        return entity.getAtoKohi3Kaisu();
    }

    /**
     * 後_公費３_ｻｰﾋﾞｽ単位数を返します。
     *
     * @return 後_公費３_ｻｰﾋﾞｽ単位数
     */
    public int get後_公費３_ｻｰﾋﾞｽ単位数() {
        return entity.getAtoKohi3ServiceTanisu();
    }

    /**
     * 後_公費３_合計単位数を返します。
     *
     * @return 後_公費３_合計単位数
     */
    public int get後_公費３_合計単位数() {
        return entity.getAtoKohi3TotalTanisu();
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
     * 特定診療情報レコード順次番号を設定します。
     *
     * @param 特定診療情報レコード順次番号 特定診療情報レコード順次番号
     */
    public void set特定診療情報レコード順次番号(RString 特定診療情報レコード順次番号) {
        requireNonNull(特定診療情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療情報レコード順次番号"));
        entity.setRecodeJunjiNo(特定診療情報レコード順次番号);
    }

    /**
     * 傷病名を設定します。
     *
     * @param 傷病名 傷病名
     */
    public void set傷病名(RString 傷病名) {
        requireNonNull(傷病名, UrSystemErrorMessages.値がnull.getReplacedMessage("傷病名"));
        entity.setShobyoName(傷病名);
    }

    /**
     * 識別番号を設定します。
     *
     * @param 識別番号 識別番号
     */
    public void set識別番号(RString 識別番号) {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        entity.setShikibetsuNo(識別番号);
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
     * 保険_回数を設定します。
     *
     * @param 保険_回数 保険_回数
     */
    public void set保険_回数(int 保険_回数) {
        requireNonNull(保険_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_回数"));
        entity.setHokenKaisu(保険_回数);
    }

    /**
     * 保険_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 保険_ｻｰﾋﾞｽ単位数 保険_ｻｰﾋﾞｽ単位数
     */
    public void set保険_ｻｰﾋﾞｽ単位数(int 保険_ｻｰﾋﾞｽ単位数) {
        requireNonNull(保険_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_ｻｰﾋﾞｽ単位数"));
        entity.setHokenServiceTanisu(保険_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 保険_合計単位数を設定します。
     *
     * @param 保険_合計単位数 保険_合計単位数
     */
    public void set保険_合計単位数(int 保険_合計単位数) {
        requireNonNull(保険_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_合計単位数"));
        entity.setHokenTotalTanisu(保険_合計単位数);
    }

    /**
     * 公費１_回数を設定します。
     *
     * @param 公費１_回数 公費１_回数
     */
    public void set公費１_回数(int 公費１_回数) {
        requireNonNull(公費１_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_回数"));
        entity.setKohi1Kaisu(公費１_回数);
    }

    /**
     * 公費１_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費１_ｻｰﾋﾞｽ単位数 公費１_ｻｰﾋﾞｽ単位数
     */
    public void set公費１_ｻｰﾋﾞｽ単位数(int 公費１_ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費１_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_ｻｰﾋﾞｽ単位数"));
        entity.setKohi1ServiceTanisu(公費１_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 公費１_合計単位数を設定します。
     *
     * @param 公費１_合計単位数 公費１_合計単位数
     */
    public void set公費１_合計単位数(int 公費１_合計単位数) {
        requireNonNull(公費１_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_合計単位数"));
        entity.setKohi1TotalTanisu(公費１_合計単位数);
    }

    /**
     * 公費２_回数を設定します。
     *
     * @param 公費２_回数 公費２_回数
     */
    public void set公費２_回数(int 公費２_回数) {
        requireNonNull(公費２_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_回数"));
        entity.setKohi2Kaisu(公費２_回数);
    }

    /**
     * 公費２_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費２_ｻｰﾋﾞｽ単位数 公費２_ｻｰﾋﾞｽ単位数
     */
    public void set公費２_ｻｰﾋﾞｽ単位数(int 公費２_ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費２_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_ｻｰﾋﾞｽ単位数"));
        entity.setKohi2ServiceTanisu(公費２_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 公費２_合計単位数を設定します。
     *
     * @param 公費２_合計単位数 公費２_合計単位数
     */
    public void set公費２_合計単位数(int 公費２_合計単位数) {
        requireNonNull(公費２_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_合計単位数"));
        entity.setKohi2TotalTanisu(公費２_合計単位数);
    }

    /**
     * 公費３_回数を設定します。
     *
     * @param 公費３_回数 公費３_回数
     */
    public void set公費３_回数(int 公費３_回数) {
        requireNonNull(公費３_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_回数"));
        entity.setKohi3Kaisu(公費３_回数);
    }

    /**
     * 公費３_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費３_ｻｰﾋﾞｽ単位数 公費３_ｻｰﾋﾞｽ単位数
     */
    public void set公費３_ｻｰﾋﾞｽ単位数(int 公費３_ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費３_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_ｻｰﾋﾞｽ単位数"));
        entity.setKohi3ServiceTanisu(公費３_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 公費３_合計単位数を設定します。
     *
     * @param 公費３_合計単位数 公費３_合計単位数
     */
    public void set公費３_合計単位数(int 公費３_合計単位数) {
        requireNonNull(公費３_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_合計単位数"));
        entity.setKohi3TotalTanisu(公費３_合計単位数);
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
     * 後_保険_回数を設定します。
     *
     * @param 後_保険_回数 後_保険_回数
     */
    public void set後_保険_回数(int 後_保険_回数) {
        requireNonNull(後_保険_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_回数"));
        entity.setAtoHokenKaisu(後_保険_回数);
    }

    /**
     * 後_保険_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_保険_ｻｰﾋﾞｽ単位数 後_保険_ｻｰﾋﾞｽ単位数
     */
    public void set後_保険_ｻｰﾋﾞｽ単位数(int 後_保険_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_保険_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_ｻｰﾋﾞｽ単位数"));
        entity.setAtoHokenServiceTanisu(後_保険_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 後_保険_合計単位数を設定します。
     *
     * @param 後_保険_合計単位数 後_保険_合計単位数
     */
    public void set後_保険_合計単位数(int 後_保険_合計単位数) {
        requireNonNull(後_保険_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_合計単位数"));
        entity.setAtoHokenTotalTanisu(後_保険_合計単位数);
    }

    /**
     * 後_公費１_回数を設定します。
     *
     * @param 後_公費１_回数 後_公費１_回数
     */
    public void set後_公費１_回数(int 後_公費１_回数) {
        requireNonNull(後_公費１_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_回数"));
        entity.setAtoKohi1Kaisu(後_公費１_回数);
    }

    /**
     * 後_公費１_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_公費１_ｻｰﾋﾞｽ単位数 後_公費１_ｻｰﾋﾞｽ単位数
     */
    public void set後_公費１_ｻｰﾋﾞｽ単位数(int 後_公費１_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_公費１_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi1ServiceTanisu(後_公費１_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 後_公費１_合計単位数を設定します。
     *
     * @param 後_公費１_合計単位数 後_公費１_合計単位数
     */
    public void set後_公費１_合計単位数(int 後_公費１_合計単位数) {
        requireNonNull(後_公費１_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_合計単位数"));
        entity.setAtoKohi1TotalTanisu(後_公費１_合計単位数);
    }

    /**
     * 後_公費２_回数を設定します。
     *
     * @param 後_公費２_回数 後_公費２_回数
     */
    public void set後_公費２_回数(int 後_公費２_回数) {
        requireNonNull(後_公費２_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_回数"));
        entity.setAtoKohi2Kaisu(後_公費２_回数);
    }

    /**
     * 後_公費２_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_公費２_ｻｰﾋﾞｽ単位数 後_公費２_ｻｰﾋﾞｽ単位数
     */
    public void set後_公費２_ｻｰﾋﾞｽ単位数(int 後_公費２_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_公費２_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi2ServiceTanisu(後_公費２_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 後_公費２_合計単位数を設定します。
     *
     * @param 後_公費２_合計単位数 後_公費２_合計単位数
     */
    public void set後_公費２_合計単位数(int 後_公費２_合計単位数) {
        requireNonNull(後_公費２_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_合計単位数"));
        entity.setAtoKohi2TotalTanisu(後_公費２_合計単位数);
    }

    /**
     * 後_公費３_回数を設定します。
     *
     * @param 後_公費３_回数 後_公費３_回数
     */
    public void set後_公費３_回数(int 後_公費３_回数) {
        requireNonNull(後_公費３_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_回数"));
        entity.setAtoKohi3Kaisu(後_公費３_回数);
    }

    /**
     * 後_公費３_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_公費３_ｻｰﾋﾞｽ単位数 後_公費３_ｻｰﾋﾞｽ単位数
     */
    public void set後_公費３_ｻｰﾋﾞｽ単位数(int 後_公費３_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_公費３_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi3ServiceTanisu(後_公費３_ｻｰﾋﾞｽ単位数);
    }

    /**
     * 後_公費３_合計単位数を設定します。
     *
     * @param 後_公費３_合計単位数 後_公費３_合計単位数
     */
    public void set後_公費３_合計単位数(int 後_公費３_合計単位数) {
        requireNonNull(後_公費３_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_合計単位数"));
        entity.setAtoKohi3TotalTanisu(後_公費３_合計単位数);
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
