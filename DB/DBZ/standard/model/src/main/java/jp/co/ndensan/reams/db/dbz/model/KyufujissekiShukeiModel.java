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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績集計のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KyufujissekiShukeiModel implements Serializable {

    private DbT3033KyufujissekiShukeiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiShukeiModel() {
        entity = new DbT3033KyufujissekiShukeiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3033KyufujissekiShukeiEntity
     */
    public KyufujissekiShukeiModel(DbT3033KyufujissekiShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3033KyufujissekiShukeiEntityを返します。
     *
     * @return DbT3033KyufujissekiShukeiEntity
     */
    public DbT3033KyufujissekiShukeiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3033KyufujissekiShukeiEntityを設定します。
     *
     * @param entity DbT3033KyufujissekiShukeiEntity
     */
    public void setEntity(DbT3033KyufujissekiShukeiEntity entity) {
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
        return entity.getServiceSyuruiCode();
    }

    /**
     * サービス実日数を返します。
     *
     * @return サービス実日数
     */
    public int getサービス実日数() {
        return entity.getServiceJitsunissu();
    }

    /**
     * 計画単位数を返します。
     *
     * @return 計画単位数
     */
    public int get計画単位数() {
        return entity.getPlanTanisu();
    }

    /**
     * 限度額管理対象単位数を返します。
     *
     * @return 限度額管理対象単位数
     */
    public int get限度額管理対象単位数() {
        return entity.getGendogakuKanriTaishoTanisu();
    }

    /**
     * 限度額管理対象外単位数を返します。
     *
     * @return 限度額管理対象外単位数
     */
    public int get限度額管理対象外単位数() {
        return entity.getGendogakuKanritaishogaiTanisu();
    }

    /**
     * 短期入所計画日数を返します。
     *
     * @return 短期入所計画日数
     */
    public int get短期入所計画日数() {
        return entity.getTankiNyushoPlanNissu();
    }

    /**
     * 短期入所実日数を返します。
     *
     * @return 短期入所実日数
     */
    public int get短期入所実日数() {
        return entity.getTankiNyushoJitsunissu();
    }

    /**
     * 保険_単位数合計を返します。
     *
     * @return 保険_単位数合計
     */
    public int get保険_単位数合計() {
        return entity.getHokenTanisuTotal();
    }

    /**
     * 保険_単位数単価を返します。
     *
     * @return 保険_単位数単価
     */
    public Decimal get保険_単位数単価() {
        return entity.getHokenTanisuTani();
    }

    /**
     * 保険_請求額を返します。
     *
     * @return 保険_請求額
     */
    public RString get保険_請求額() {
        return entity.getHokenSeikyugaku();
    }

    /**
     * 保険_利用者負担額を返します。
     *
     * @return 保険_利用者負担額
     */
    public int get保険_利用者負担額() {
        return entity.getHokenRiyoshaFutangaku();
    }

    /**
     * 公費１_単位数合計を返します。
     *
     * @return 公費１_単位数合計
     */
    public int get公費１_単位数合計() {
        return entity.getKohi1TanisuTotal();
    }

    /**
     * 公費１_請求額を返します。
     *
     * @return 公費１_請求額
     */
    public RString get公費１_請求額() {
        return entity.getKohi1Seikyugaku();
    }

    /**
     * 公費１_本人負担額を返します。
     *
     * @return 公費１_本人負担額
     */
    public int get公費１_本人負担額() {
        return entity.getKohi1HonninFutangaku();
    }

    /**
     * 公費２_単位数合計を返します。
     *
     * @return 公費２_単位数合計
     */
    public int get公費２_単位数合計() {
        return entity.getKohi2TanisuTotal();
    }

    /**
     * 公費２_請求額を返します。
     *
     * @return 公費２_請求額
     */
    public RString get公費２_請求額() {
        return entity.getKohi2Seikyugaku();
    }

    /**
     * 公費２_本人負担額を返します。
     *
     * @return 公費２_本人負担額
     */
    public int get公費２_本人負担額() {
        return entity.getKohi2HonninFutangaku();
    }

    /**
     * 公費３_単位数合計を返します。
     *
     * @return 公費３_単位数合計
     */
    public int get公費３_単位数合計() {
        return entity.getKohi3TanisuTotal();
    }

    /**
     * 公費３_請求額を返します。
     *
     * @return 公費３_請求額
     */
    public RString get公費３_請求額() {
        return entity.getKohi3Seikyugaku();
    }

    /**
     * 公費３_本人負担額を返します。
     *
     * @return 公費３_本人負担額
     */
    public int get公費３_本人負担額() {
        return entity.getKohi3HonninFutangaku();
    }

    /**
     * 保険_出来高単位数合計を返します。
     *
     * @return 保険_出来高単位数合計
     */
    public int get保険_出来高単位数合計() {
        return entity.getHokenDekidakaTanisuTotal();
    }

    /**
     * 保険_出来高請求額を返します。
     *
     * @return 保険_出来高請求額
     */
    public RString get保険_出来高請求額() {
        return entity.getHokenDekidakaSeikyugaku();
    }

    /**
     * 保険_出来高医療費利用者負担額を返します。
     *
     * @return 保険_出来高医療費利用者負担額
     */
    public int get保険_出来高医療費利用者負担額() {
        return entity.getHokenDekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 公費１_出来高単位数合計を返します。
     *
     * @return 公費１_出来高単位数合計
     */
    public int get公費１_出来高単位数合計() {
        return entity.getKohi1DekidakaTanisuTotal();
    }

    /**
     * 公費１_出来高請求額を返します。
     *
     * @return 公費１_出来高請求額
     */
    public RString get公費１_出来高請求額() {
        return entity.getKohi1DekidakaSeikyugaku();
    }

    /**
     * 公費１_出来高医療費利用者負担額を返します。
     *
     * @return 公費１_出来高医療費利用者負担額
     */
    public int get公費１_出来高医療費利用者負担額() {
        return entity.getKohi1DekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 公費２_出来高単位数合計を返します。
     *
     * @return 公費２_出来高単位数合計
     */
    public int get公費２_出来高単位数合計() {
        return entity.getKohi2DekidakaTanisuTotal();
    }

    /**
     * 公費２_出来高請求額を返します。
     *
     * @return 公費２_出来高請求額
     */
    public RString get公費２_出来高請求額() {
        return entity.getKohi2DekidakaSeikyugaku();
    }

    /**
     * 公費２_出来高医療費本人負担額を返します。
     *
     * @return 公費２_出来高医療費本人負担額
     */
    public int get公費２_出来高医療費本人負担額() {
        return entity.getKohi2DekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 公費３_出来高単位数合計を返します。
     *
     * @return 公費３_出来高単位数合計
     */
    public int get公費３_出来高単位数合計() {
        return entity.getKohi3DekidakaTanisuTotal();
    }

    /**
     * 公費３_出来高請求額を返します。
     *
     * @return 公費３_出来高請求額
     */
    public RString get公費３_出来高請求額() {
        return entity.getKohi3DekidakaSeikyugaku();
    }

    /**
     * 公費３_出来高医療費本人負担額を返します。
     *
     * @return 公費３_出来高医療費本人負担額
     */
    public int get公費３_出来高医療費本人負担額() {
        return entity.getKohi3DekidakaIryohiRiyoshaFutangaku();
    }

    /**
     * 後_短期入所実日数を返します。
     *
     * @return 後_短期入所実日数
     */
    public int get後_短期入所実日数() {
        return entity.getAtoTankiNyushoJitsunissu();
    }

    /**
     * 後_単位数合計を返します。
     *
     * @return 後_単位数合計
     */
    public int get後_単位数合計() {
        return entity.getAtoHokenTanisuTotal();
    }

    /**
     * 後_保険請求分請求額を返します。
     *
     * @return 後_保険請求分請求額
     */
    public RString get後_保険請求分請求額() {
        return entity.getAtoHokenSeikyugaku();
    }

    /**
     * 後_公費１_単位数合計を返します。
     *
     * @return 後_公費１_単位数合計
     */
    public int get後_公費１_単位数合計() {
        return entity.getAtoKohi1TanisuTotal();
    }

    /**
     * 後_公費１_請求額を返します。
     *
     * @return 後_公費１_請求額
     */
    public RString get後_公費１_請求額() {
        return entity.getAtoKohi1Seikyugaku();
    }

    /**
     * 後_公費２_単位数合計を返します。
     *
     * @return 後_公費２_単位数合計
     */
    public int get後_公費２_単位数合計() {
        return entity.getAtoKohi2TanisuTotal();
    }

    /**
     * 後_公費２_請求額を返します。
     *
     * @return 後_公費２_請求額
     */
    public RString get後_公費２_請求額() {
        return entity.getAtoKohi2Seikyugaku();
    }

    /**
     * 後_公費３_単位数合計を返します。
     *
     * @return 後_公費３_単位数合計
     */
    public int get後_公費３_単位数合計() {
        return entity.getAtoKohi3TanisuTotal();
    }

    /**
     * 後_公費３_請求額を返します。
     *
     * @return 後_公費３_請求額
     */
    public RString get後_公費３_請求額() {
        return entity.getAtoKohi3Seikyugaku();
    }

    /**
     * 後_保険_出来高単位数合計を返します。
     *
     * @return 後_保険_出来高単位数合計
     */
    public int get後_保険_出来高単位数合計() {
        return entity.getAtoHokenDekidakaTanisuTotal();
    }

    /**
     * 後_保険_出来高請求額を返します。
     *
     * @return 後_保険_出来高請求額
     */
    public RString get後_保険_出来高請求額() {
        return entity.getAtoHokenDekidakaSeikyugaku();
    }

    /**
     * 後_公費１_出来高単位数合計を返します。
     *
     * @return 後_公費１_出来高単位数合計
     */
    public int get後_公費１_出来高単位数合計() {
        return entity.getAtoKohi1DekidakaTanisuTotal();
    }

    /**
     * 後_公費１_出来高請求額を返します。
     *
     * @return 後_公費１_出来高請求額
     */
    public RString get後_公費１_出来高請求額() {
        return entity.getAtoKohi1DekidakaSeikyugaku();
    }

    /**
     * 後_公費２_出来高単位数合計を返します。
     *
     * @return 後_公費２_出来高単位数合計
     */
    public int get後_公費２_出来高単位数合計() {
        return entity.getAtoKohi2DekidakaTanisuTotal();
    }

    /**
     * 後_公費２_出来高請求額を返します。
     *
     * @return 後_公費２_出来高請求額
     */
    public RString get後_公費２_出来高請求額() {
        return entity.getAtoKohi2DekidakaSeikyugaku();
    }

    /**
     * 後_公費３_出来高単位数合計を返します。
     *
     * @return 後_公費３_出来高単位数合計
     */
    public int get後_公費３_出来高単位数合計() {
        return entity.getAtoKohi3DekidakaTanisuTotal();
    }

    /**
     * 後_公費３_出来高請求額を返します。
     *
     * @return 後_公費３_出来高請求額
     */
    public RString get後_公費３_出来高請求額() {
        return entity.getAtoKohi3DekidakaSeikyugaku();
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
        entity.setServiceSyuruiCode(サービス種類コード);
    }

    /**
     * サービス実日数を設定します。
     *
     * @param サービス実日数 サービス実日数
     */
    public void setサービス実日数(int サービス実日数) {
        requireNonNull(サービス実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス実日数"));
        entity.setServiceJitsunissu(サービス実日数);
    }

    /**
     * 計画単位数を設定します。
     *
     * @param 計画単位数 計画単位数
     */
    public void set計画単位数(int 計画単位数) {
        requireNonNull(計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("計画単位数"));
        entity.setPlanTanisu(計画単位数);
    }

    /**
     * 限度額管理対象単位数を設定します。
     *
     * @param 限度額管理対象単位数 限度額管理対象単位数
     */
    public void set限度額管理対象単位数(int 限度額管理対象単位数) {
        requireNonNull(限度額管理対象単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象単位数"));
        entity.setGendogakuKanriTaishoTanisu(限度額管理対象単位数);
    }

    /**
     * 限度額管理対象外単位数を設定します。
     *
     * @param 限度額管理対象外単位数 限度額管理対象外単位数
     */
    public void set限度額管理対象外単位数(int 限度額管理対象外単位数) {
        requireNonNull(限度額管理対象外単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象外単位数"));
        entity.setGendogakuKanritaishogaiTanisu(限度額管理対象外単位数);
    }

    /**
     * 短期入所計画日数を設定します。
     *
     * @param 短期入所計画日数 短期入所計画日数
     */
    public void set短期入所計画日数(int 短期入所計画日数) {
        requireNonNull(短期入所計画日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所計画日数"));
        entity.setTankiNyushoPlanNissu(短期入所計画日数);
    }

    /**
     * 短期入所実日数を設定します。
     *
     * @param 短期入所実日数 短期入所実日数
     */
    public void set短期入所実日数(int 短期入所実日数) {
        requireNonNull(短期入所実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所実日数"));
        entity.setTankiNyushoJitsunissu(短期入所実日数);
    }

    /**
     * 保険_単位数合計を設定します。
     *
     * @param 保険_単位数合計 保険_単位数合計
     */
    public void set保険_単位数合計(int 保険_単位数合計) {
        requireNonNull(保険_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_単位数合計"));
        entity.setHokenTanisuTotal(保険_単位数合計);
    }

    /**
     * 保険_単位数単価を設定します。
     *
     * @param 保険_単位数単価 保険_単位数単価
     */
    public void set保険_単位数単価(Decimal 保険_単位数単価) {
        requireNonNull(保険_単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_単位数単価"));
        entity.setHokenTanisuTani(保険_単位数単価);
    }

    /**
     * 保険_請求額を設定します。
     *
     * @param 保険_請求額 保険_請求額
     */
    public void set保険_請求額(RString 保険_請求額) {
        requireNonNull(保険_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_請求額"));
        entity.setHokenSeikyugaku(保険_請求額);
    }

    /**
     * 保険_利用者負担額を設定します。
     *
     * @param 保険_利用者負担額 保険_利用者負担額
     */
    public void set保険_利用者負担額(int 保険_利用者負担額) {
        requireNonNull(保険_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_利用者負担額"));
        entity.setHokenRiyoshaFutangaku(保険_利用者負担額);
    }

    /**
     * 公費１_単位数合計を設定します。
     *
     * @param 公費１_単位数合計 公費１_単位数合計
     */
    public void set公費１_単位数合計(int 公費１_単位数合計) {
        requireNonNull(公費１_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_単位数合計"));
        entity.setKohi1TanisuTotal(公費１_単位数合計);
    }

    /**
     * 公費１_請求額を設定します。
     *
     * @param 公費１_請求額 公費１_請求額
     */
    public void set公費１_請求額(RString 公費１_請求額) {
        requireNonNull(公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_請求額"));
        entity.setKohi1Seikyugaku(公費１_請求額);
    }

    /**
     * 公費１_本人負担額を設定します。
     *
     * @param 公費１_本人負担額 公費１_本人負担額
     */
    public void set公費１_本人負担額(int 公費１_本人負担額) {
        requireNonNull(公費１_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_本人負担額"));
        entity.setKohi1HonninFutangaku(公費１_本人負担額);
    }

    /**
     * 公費２_単位数合計を設定します。
     *
     * @param 公費２_単位数合計 公費２_単位数合計
     */
    public void set公費２_単位数合計(int 公費２_単位数合計) {
        requireNonNull(公費２_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_単位数合計"));
        entity.setKohi2TanisuTotal(公費２_単位数合計);
    }

    /**
     * 公費２_請求額を設定します。
     *
     * @param 公費２_請求額 公費２_請求額
     */
    public void set公費２_請求額(RString 公費２_請求額) {
        requireNonNull(公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_請求額"));
        entity.setKohi2Seikyugaku(公費２_請求額);
    }

    /**
     * 公費２_本人負担額を設定します。
     *
     * @param 公費２_本人負担額 公費２_本人負担額
     */
    public void set公費２_本人負担額(int 公費２_本人負担額) {
        requireNonNull(公費２_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_本人負担額"));
        entity.setKohi2HonninFutangaku(公費２_本人負担額);
    }

    /**
     * 公費３_単位数合計を設定します。
     *
     * @param 公費３_単位数合計 公費３_単位数合計
     */
    public void set公費３_単位数合計(int 公費３_単位数合計) {
        requireNonNull(公費３_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_単位数合計"));
        entity.setKohi3TanisuTotal(公費３_単位数合計);
    }

    /**
     * 公費３_請求額を設定します。
     *
     * @param 公費３_請求額 公費３_請求額
     */
    public void set公費３_請求額(RString 公費３_請求額) {
        requireNonNull(公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_請求額"));
        entity.setKohi3Seikyugaku(公費３_請求額);
    }

    /**
     * 公費３_本人負担額を設定します。
     *
     * @param 公費３_本人負担額 公費３_本人負担額
     */
    public void set公費３_本人負担額(int 公費３_本人負担額) {
        requireNonNull(公費３_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_本人負担額"));
        entity.setKohi3HonninFutangaku(公費３_本人負担額);
    }

    /**
     * 保険_出来高単位数合計を設定します。
     *
     * @param 保険_出来高単位数合計 保険_出来高単位数合計
     */
    public void set保険_出来高単位数合計(int 保険_出来高単位数合計) {
        requireNonNull(保険_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_出来高単位数合計"));
        entity.setHokenDekidakaTanisuTotal(保険_出来高単位数合計);
    }

    /**
     * 保険_出来高請求額を設定します。
     *
     * @param 保険_出来高請求額 保険_出来高請求額
     */
    public void set保険_出来高請求額(RString 保険_出来高請求額) {
        requireNonNull(保険_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_出来高請求額"));
        entity.setHokenDekidakaSeikyugaku(保険_出来高請求額);
    }

    /**
     * 保険_出来高医療費利用者負担額を設定します。
     *
     * @param 保険_出来高医療費利用者負担額 保険_出来高医療費利用者負担額
     */
    public void set保険_出来高医療費利用者負担額(int 保険_出来高医療費利用者負担額) {
        requireNonNull(保険_出来高医療費利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_出来高医療費利用者負担額"));
        entity.setHokenDekidakaIryohiRiyoshaFutangaku(保険_出来高医療費利用者負担額);
    }

    /**
     * 公費１_出来高単位数合計を設定します。
     *
     * @param 公費１_出来高単位数合計 公費１_出来高単位数合計
     */
    public void set公費１_出来高単位数合計(int 公費１_出来高単位数合計) {
        requireNonNull(公費１_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_出来高単位数合計"));
        entity.setKohi1DekidakaTanisuTotal(公費１_出来高単位数合計);
    }

    /**
     * 公費１_出来高請求額を設定します。
     *
     * @param 公費１_出来高請求額 公費１_出来高請求額
     */
    public void set公費１_出来高請求額(RString 公費１_出来高請求額) {
        requireNonNull(公費１_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_出来高請求額"));
        entity.setKohi1DekidakaSeikyugaku(公費１_出来高請求額);
    }

    /**
     * 公費１_出来高医療費利用者負担額を設定します。
     *
     * @param 公費１_出来高医療費利用者負担額 公費１_出来高医療費利用者負担額
     */
    public void set公費１_出来高医療費利用者負担額(int 公費１_出来高医療費利用者負担額) {
        requireNonNull(公費１_出来高医療費利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_出来高医療費利用者負担額"));
        entity.setKohi1DekidakaIryohiRiyoshaFutangaku(公費１_出来高医療費利用者負担額);
    }

    /**
     * 公費２_出来高単位数合計を設定します。
     *
     * @param 公費２_出来高単位数合計 公費２_出来高単位数合計
     */
    public void set公費２_出来高単位数合計(int 公費２_出来高単位数合計) {
        requireNonNull(公費２_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_出来高単位数合計"));
        entity.setKohi2DekidakaTanisuTotal(公費２_出来高単位数合計);
    }

    /**
     * 公費２_出来高請求額を設定します。
     *
     * @param 公費２_出来高請求額 公費２_出来高請求額
     */
    public void set公費２_出来高請求額(RString 公費２_出来高請求額) {
        requireNonNull(公費２_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_出来高請求額"));
        entity.setKohi2DekidakaSeikyugaku(公費２_出来高請求額);
    }

    /**
     * 公費２_出来高医療費本人負担額を設定します。
     *
     * @param 公費２_出来高医療費本人負担額 公費２_出来高医療費本人負担額
     */
    public void set公費２_出来高医療費本人負担額(int 公費２_出来高医療費本人負担額) {
        requireNonNull(公費２_出来高医療費本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_出来高医療費本人負担額"));
        entity.setKohi2DekidakaIryohiRiyoshaFutangaku(公費２_出来高医療費本人負担額);
    }

    /**
     * 公費３_出来高単位数合計を設定します。
     *
     * @param 公費３_出来高単位数合計 公費３_出来高単位数合計
     */
    public void set公費３_出来高単位数合計(int 公費３_出来高単位数合計) {
        requireNonNull(公費３_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_出来高単位数合計"));
        entity.setKohi3DekidakaTanisuTotal(公費３_出来高単位数合計);
    }

    /**
     * 公費３_出来高請求額を設定します。
     *
     * @param 公費３_出来高請求額 公費３_出来高請求額
     */
    public void set公費３_出来高請求額(RString 公費３_出来高請求額) {
        requireNonNull(公費３_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_出来高請求額"));
        entity.setKohi3DekidakaSeikyugaku(公費３_出来高請求額);
    }

    /**
     * 公費３_出来高医療費本人負担額を設定します。
     *
     * @param 公費３_出来高医療費本人負担額 公費３_出来高医療費本人負担額
     */
    public void set公費３_出来高医療費本人負担額(int 公費３_出来高医療費本人負担額) {
        requireNonNull(公費３_出来高医療費本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_出来高医療費本人負担額"));
        entity.setKohi3DekidakaIryohiRiyoshaFutangaku(公費３_出来高医療費本人負担額);
    }

    /**
     * 後_短期入所実日数を設定します。
     *
     * @param 後_短期入所実日数 後_短期入所実日数
     */
    public void set後_短期入所実日数(int 後_短期入所実日数) {
        requireNonNull(後_短期入所実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_短期入所実日数"));
        entity.setAtoTankiNyushoJitsunissu(後_短期入所実日数);
    }

    /**
     * 後_単位数合計を設定します。
     *
     * @param 後_単位数合計 後_単位数合計
     */
    public void set後_単位数合計(int 後_単位数合計) {
        requireNonNull(後_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数合計"));
        entity.setAtoHokenTanisuTotal(後_単位数合計);
    }

    /**
     * 後_保険請求分請求額を設定します。
     *
     * @param 後_保険請求分請求額 後_保険請求分請求額
     */
    public void set後_保険請求分請求額(RString 後_保険請求分請求額) {
        requireNonNull(後_保険請求分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険請求分請求額"));
        entity.setAtoHokenSeikyugaku(後_保険請求分請求額);
    }

    /**
     * 後_公費１_単位数合計を設定します。
     *
     * @param 後_公費１_単位数合計 後_公費１_単位数合計
     */
    public void set後_公費１_単位数合計(int 後_公費１_単位数合計) {
        requireNonNull(後_公費１_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_単位数合計"));
        entity.setAtoKohi1TanisuTotal(後_公費１_単位数合計);
    }

    /**
     * 後_公費１_請求額を設定します。
     *
     * @param 後_公費１_請求額 後_公費１_請求額
     */
    public void set後_公費１_請求額(RString 後_公費１_請求額) {
        requireNonNull(後_公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_請求額"));
        entity.setAtoKohi1Seikyugaku(後_公費１_請求額);
    }

    /**
     * 後_公費２_単位数合計を設定します。
     *
     * @param 後_公費２_単位数合計 後_公費２_単位数合計
     */
    public void set後_公費２_単位数合計(int 後_公費２_単位数合計) {
        requireNonNull(後_公費２_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_単位数合計"));
        entity.setAtoKohi2TanisuTotal(後_公費２_単位数合計);
    }

    /**
     * 後_公費２_請求額を設定します。
     *
     * @param 後_公費２_請求額 後_公費２_請求額
     */
    public void set後_公費２_請求額(RString 後_公費２_請求額) {
        requireNonNull(後_公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_請求額"));
        entity.setAtoKohi2Seikyugaku(後_公費２_請求額);
    }

    /**
     * 後_公費３_単位数合計を設定します。
     *
     * @param 後_公費３_単位数合計 後_公費３_単位数合計
     */
    public void set後_公費３_単位数合計(int 後_公費３_単位数合計) {
        requireNonNull(後_公費３_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_単位数合計"));
        entity.setAtoKohi3TanisuTotal(後_公費３_単位数合計);
    }

    /**
     * 後_公費３_請求額を設定します。
     *
     * @param 後_公費３_請求額 後_公費３_請求額
     */
    public void set後_公費３_請求額(RString 後_公費３_請求額) {
        requireNonNull(後_公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_請求額"));
        entity.setAtoKohi3Seikyugaku(後_公費３_請求額);
    }

    /**
     * 後_保険_出来高単位数合計を設定します。
     *
     * @param 後_保険_出来高単位数合計 後_保険_出来高単位数合計
     */
    public void set後_保険_出来高単位数合計(int 後_保険_出来高単位数合計) {
        requireNonNull(後_保険_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_出来高単位数合計"));
        entity.setAtoHokenDekidakaTanisuTotal(後_保険_出来高単位数合計);
    }

    /**
     * 後_保険_出来高請求額を設定します。
     *
     * @param 後_保険_出来高請求額 後_保険_出来高請求額
     */
    public void set後_保険_出来高請求額(RString 後_保険_出来高請求額) {
        requireNonNull(後_保険_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_出来高請求額"));
        entity.setAtoHokenDekidakaSeikyugaku(後_保険_出来高請求額);
    }

    /**
     * 後_公費１_出来高単位数合計を設定します。
     *
     * @param 後_公費１_出来高単位数合計 後_公費１_出来高単位数合計
     */
    public void set後_公費１_出来高単位数合計(int 後_公費１_出来高単位数合計) {
        requireNonNull(後_公費１_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_出来高単位数合計"));
        entity.setAtoKohi1DekidakaTanisuTotal(後_公費１_出来高単位数合計);
    }

    /**
     * 後_公費１_出来高請求額を設定します。
     *
     * @param 後_公費１_出来高請求額 後_公費１_出来高請求額
     */
    public void set後_公費１_出来高請求額(RString 後_公費１_出来高請求額) {
        requireNonNull(後_公費１_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_出来高請求額"));
        entity.setAtoKohi1DekidakaSeikyugaku(後_公費１_出来高請求額);
    }

    /**
     * 後_公費２_出来高単位数合計を設定します。
     *
     * @param 後_公費２_出来高単位数合計 後_公費２_出来高単位数合計
     */
    public void set後_公費２_出来高単位数合計(int 後_公費２_出来高単位数合計) {
        requireNonNull(後_公費２_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_出来高単位数合計"));
        entity.setAtoKohi2DekidakaTanisuTotal(後_公費２_出来高単位数合計);
    }

    /**
     * 後_公費２_出来高請求額を設定します。
     *
     * @param 後_公費２_出来高請求額 後_公費２_出来高請求額
     */
    public void set後_公費２_出来高請求額(RString 後_公費２_出来高請求額) {
        requireNonNull(後_公費２_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_出来高請求額"));
        entity.setAtoKohi2DekidakaSeikyugaku(後_公費２_出来高請求額);
    }

    /**
     * 後_公費３_出来高単位数合計を設定します。
     *
     * @param 後_公費３_出来高単位数合計 後_公費３_出来高単位数合計
     */
    public void set後_公費３_出来高単位数合計(int 後_公費３_出来高単位数合計) {
        requireNonNull(後_公費３_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_出来高単位数合計"));
        entity.setAtoKohi3DekidakaTanisuTotal(後_公費３_出来高単位数合計);
    }

    /**
     * 後_公費３_出来高請求額を設定します。
     *
     * @param 後_公費３_出来高請求額 後_公費３_出来高請求額
     */
    public void set後_公費３_出来高請求額(RString 後_公費３_出来高請求額) {
        requireNonNull(後_公費３_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_出来高請求額"));
        entity.setAtoKohi3DekidakaSeikyugaku(後_公費３_出来高請求額);
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
