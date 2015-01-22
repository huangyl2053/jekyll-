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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績特定入所者介護サービス費用のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoModel implements Serializable {

    private DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoModel() {
        entity = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoModel(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityを返します。
     *
     * @return DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity
     */
    public DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityを設定します。
     *
     * @param entity DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity
     */
    public void setEntity(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity) {
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
     * 特定入所者介護サービス費用情報レコード順次番号を返します。
     *
     * @return 特定入所者介護サービス費用情報レコード順次番号
     */
    public RString get特定入所者介護サービス費用情報レコード順次番号() {
        return entity.getRecodeJunjiNo();
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
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 費用単価を返します。
     *
     * @return 費用単価
     */
    public int get費用単価() {
        return entity.getHiyoTanka();
    }

    /**
     * 負担限度額を返します。
     *
     * @return 負担限度額
     */
    public int get負担限度額() {
        return entity.getFutanGendogaku();
    }

    /**
     * 日数を返します。
     *
     * @return 日数
     */
    public int get日数() {
        return entity.getNissu();
    }

    /**
     * 公費１日数を返します。
     *
     * @return 公費１日数
     */
    public int get公費１日数() {
        return entity.getKohi1Nissu();
    }

    /**
     * 公費２日数を返します。
     *
     * @return 公費２日数
     */
    public int get公費２日数() {
        return entity.getKohi2Nissu();
    }

    /**
     * 公費３日数を返します。
     *
     * @return 公費３日数
     */
    public int get公費３日数() {
        return entity.getKohi3Nissu();
    }

    /**
     * 費用額を返します。
     *
     * @return 費用額
     */
    public int get費用額() {
        return entity.getHiyogaku();
    }

    /**
     * 保険分請求額を返します。
     *
     * @return 保険分請求額
     */
    public int get保険分請求額() {
        return entity.getHokenbunSeikyugaku();
    }

    /**
     * 公費１負担額_明細を返します。
     *
     * @return 公費１負担額_明細
     */
    public int get公費１負担額_明細() {
        return entity.getKohi1Futangaku();
    }

    /**
     * 公費２負担額_明細を返します。
     *
     * @return 公費２負担額_明細
     */
    public int get公費２負担額_明細() {
        return entity.getKohi2Futangaku();
    }

    /**
     * 公費３負担額_明細を返します。
     *
     * @return 公費３負担額_明細
     */
    public int get公費３負担額_明細() {
        return entity.getKohi3Futangaku();
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
     * 費用額合計を返します。
     *
     * @return 費用額合計
     */
    public int get費用額合計() {
        return entity.getHiyogakuTotal();
    }

    /**
     * 保険分請求額合計を返します。
     *
     * @return 保険分請求額合計
     */
    public int get保険分請求額合計() {
        return entity.getHokenbunSeikyugakuTotal();
    }

    /**
     * 利用者負担額合計を返します。
     *
     * @return 利用者負担額合計
     */
    public int get利用者負担額合計() {
        return entity.getRiyoshaFutangakuTotal();
    }

    /**
     * 公費１_負担額合計を返します。
     *
     * @return 公費１_負担額合計
     */
    public int get公費１_負担額合計() {
        return entity.getKohi1FutangakuTotal();
    }

    /**
     * 公費１_請求額を返します。
     *
     * @return 公費１_請求額
     */
    public int get公費１_請求額() {
        return entity.getKohi1Seikyugaku();
    }

    /**
     * 公費１_本人負担月額を返します。
     *
     * @return 公費１_本人負担月額
     */
    public int get公費１_本人負担月額() {
        return entity.getKohi1HonninFutanGetsugaku();
    }

    /**
     * 公費２_負担額合計を返します。
     *
     * @return 公費２_負担額合計
     */
    public int get公費２_負担額合計() {
        return entity.getKohi2FutangakuTotal();
    }

    /**
     * 公費２_請求額を返します。
     *
     * @return 公費２_請求額
     */
    public int get公費２_請求額() {
        return entity.getKohi2Seikyugaku();
    }

    /**
     * 公費２_本人負担月額を返します。
     *
     * @return 公費２_本人負担月額
     */
    public int get公費２_本人負担月額() {
        return entity.getKohi2HonninFutanGetsugaku();
    }

    /**
     * 公費３_負担額合計を返します。
     *
     * @return 公費３_負担額合計
     */
    public int get公費３_負担額合計() {
        return entity.getKohi3FutangakuTotal();
    }

    /**
     * 公費３_請求額を返します。
     *
     * @return 公費３_請求額
     */
    public int get公費３_請求額() {
        return entity.getKohi3Seikyugaku();
    }

    /**
     * 公費３_本人負担月額を返します。
     *
     * @return 公費３_本人負担月額
     */
    public int get公費３_本人負担月額() {
        return entity.getKohi3HonninFutanGetsugaku();
    }

    /**
     * 後_費用単価を返します。
     *
     * @return 後_費用単価
     */
    public int get後_費用単価() {
        return entity.getAtoHiyoTanka();
    }

    /**
     * 後_日数を返します。
     *
     * @return 後_日数
     */
    public int get後_日数() {
        return entity.getAtoNissu();
    }

    /**
     * 後_公費１日数を返します。
     *
     * @return 後_公費１日数
     */
    public int get後_公費１日数() {
        return entity.getAtoKohi1Nissu();
    }

    /**
     * 後_公費２日数を返します。
     *
     * @return 後_公費２日数
     */
    public int get後_公費２日数() {
        return entity.getAtoKohi2Nissu();
    }

    /**
     * 後_公費３日数を返します。
     *
     * @return 後_公費３日数
     */
    public int get後_公費３日数() {
        return entity.getAtoKohi3Nissu();
    }

    /**
     * 後_費用額を返します。
     *
     * @return 後_費用額
     */
    public int get後_費用額() {
        return entity.getAtoHiyogaku();
    }

    /**
     * 後_保険分請求額を返します。
     *
     * @return 後_保険分請求額
     */
    public int get後_保険分請求額() {
        return entity.getAtoHokenbunSeikyugaku();
    }

    /**
     * 後_公費１負担額_明細を返します。
     *
     * @return 後_公費１負担額_明細
     */
    public int get後_公費１負担額_明細() {
        return entity.getAtoKohi1Futangaku();
    }

    /**
     * 後_公費２負担額_明細を返します。
     *
     * @return 後_公費２負担額_明細
     */
    public int get後_公費２負担額_明細() {
        return entity.getAtoKohi2Futangaku();
    }

    /**
     * 後_公費３負担額_明細を返します。
     *
     * @return 後_公費３負担額_明細
     */
    public int get後_公費３負担額_明細() {
        return entity.getAtoKohi3Futangaku();
    }

    /**
     * 後_利用者負担額を返します。
     *
     * @return 後_利用者負担額
     */
    public int get後_利用者負担額() {
        return entity.getAtoRiyoshaFutangaku();
    }

    /**
     * 後_費用額合計を返します。
     *
     * @return 後_費用額合計
     */
    public int get後_費用額合計() {
        return entity.getAtoHiyogakuTotal();
    }

    /**
     * 後_保険分請求額合計を返します。
     *
     * @return 後_保険分請求額合計
     */
    public int get後_保険分請求額合計() {
        return entity.getAtoHokenbunSeikyugakuTotal();
    }

    /**
     * 後_利用者負担額合計を返します。
     *
     * @return 後_利用者負担額合計
     */
    public int get後_利用者負担額合計() {
        return entity.getAtoRiyoshaFutangakuTotal();
    }

    /**
     * 後_公費１_負担額合計を返します。
     *
     * @return 後_公費１_負担額合計
     */
    public int get後_公費１_負担額合計() {
        return entity.getAtoKohi1FutangakuTotal();
    }

    /**
     * 後_公費１_請求額を返します。
     *
     * @return 後_公費１_請求額
     */
    public int get後_公費１_請求額() {
        return entity.getAtoKohi1Seikyugaku();
    }

    /**
     * 後_公費１_本人負担月額を返します。
     *
     * @return 後_公費１_本人負担月額
     */
    public int get後_公費１_本人負担月額() {
        return entity.getAtoKohi1HonninFutanGetsugaku();
    }

    /**
     * 後_公費２_負担額合計を返します。
     *
     * @return 後_公費２_負担額合計
     */
    public int get後_公費２_負担額合計() {
        return entity.getAtoKohi2FutangakuTotal();
    }

    /**
     * 後_公費２_請求額を返します。
     *
     * @return 後_公費２_請求額
     */
    public int get後_公費２_請求額() {
        return entity.getAtoKohi2Seikyugaku();
    }

    /**
     * 後_公費２_本人負担月額を返します。
     *
     * @return 後_公費２_本人負担月額
     */
    public int get後_公費２_本人負担月額() {
        return entity.getAtoKohi2HonninFutanGetsugaku();
    }

    /**
     * 後_公費３_負担額合計を返します。
     *
     * @return 後_公費３_負担額合計
     */
    public int get後_公費３_負担額合計() {
        return entity.getAtoKohi3FutangakuTotal();
    }

    /**
     * 後_公費３_請求額を返します。
     *
     * @return 後_公費３_請求額
     */
    public int get後_公費３_請求額() {
        return entity.getAtoKohi3Seikyugaku();
    }

    /**
     * 後_公費３_本人負担月額を返します。
     *
     * @return 後_公費３_本人負担月額
     */
    public int get後_公費３_本人負担月額() {
        return entity.getAtoKohi3HonninFutanGetsugaku();
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
     * 特定入所者介護サービス費用情報レコード順次番号を設定します。
     *
     * @param 特定入所者介護サービス費用情報レコード順次番号 特定入所者介護サービス費用情報レコード順次番号
     */
    public void set特定入所者介護サービス費用情報レコード順次番号(RString 特定入所者介護サービス費用情報レコード順次番号) {
        requireNonNull(特定入所者介護サービス費用情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費用情報レコード順次番号"));
        entity.setRecodeJunjiNo(特定入所者介護サービス費用情報レコード順次番号);
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
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
    }

    /**
     * 費用単価を設定します。
     *
     * @param 費用単価 費用単価
     */
    public void set費用単価(int 費用単価) {
        requireNonNull(費用単価, UrSystemErrorMessages.値がnull.getReplacedMessage("費用単価"));
        entity.setHiyoTanka(費用単価);
    }

    /**
     * 負担限度額を設定します。
     *
     * @param 負担限度額 負担限度額
     */
    public void set負担限度額(int 負担限度額) {
        requireNonNull(負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額"));
        entity.setFutanGendogaku(負担限度額);
    }

    /**
     * 日数を設定します。
     *
     * @param 日数 日数
     */
    public void set日数(int 日数) {
        requireNonNull(日数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数"));
        entity.setNissu(日数);
    }

    /**
     * 公費１日数を設定します。
     *
     * @param 公費１日数 公費１日数
     */
    public void set公費１日数(int 公費１日数) {
        requireNonNull(公費１日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１日数"));
        entity.setKohi1Nissu(公費１日数);
    }

    /**
     * 公費２日数を設定します。
     *
     * @param 公費２日数 公費２日数
     */
    public void set公費２日数(int 公費２日数) {
        requireNonNull(公費２日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２日数"));
        entity.setKohi2Nissu(公費２日数);
    }

    /**
     * 公費３日数を設定します。
     *
     * @param 公費３日数 公費３日数
     */
    public void set公費３日数(int 公費３日数) {
        requireNonNull(公費３日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３日数"));
        entity.setKohi3Nissu(公費３日数);
    }

    /**
     * 費用額を設定します。
     *
     * @param 費用額 費用額
     */
    public void set費用額(int 費用額) {
        requireNonNull(費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額"));
        entity.setHiyogaku(費用額);
    }

    /**
     * 保険分請求額を設定します。
     *
     * @param 保険分請求額 保険分請求額
     */
    public void set保険分請求額(int 保険分請求額) {
        requireNonNull(保険分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分請求額"));
        entity.setHokenbunSeikyugaku(保険分請求額);
    }

    /**
     * 公費１負担額_明細を設定します。
     *
     * @param 公費１負担額_明細 公費１負担額_明細
     */
    public void set公費１負担額_明細(int 公費１負担額_明細) {
        requireNonNull(公費１負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１負担額_明細"));
        entity.setKohi1Futangaku(公費１負担額_明細);
    }

    /**
     * 公費２負担額_明細を設定します。
     *
     * @param 公費２負担額_明細 公費２負担額_明細
     */
    public void set公費２負担額_明細(int 公費２負担額_明細) {
        requireNonNull(公費２負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２負担額_明細"));
        entity.setKohi2Futangaku(公費２負担額_明細);
    }

    /**
     * 公費３負担額_明細を設定します。
     *
     * @param 公費３負担額_明細 公費３負担額_明細
     */
    public void set公費３負担額_明細(int 公費３負担額_明細) {
        requireNonNull(公費３負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３負担額_明細"));
        entity.setKohi3Futangaku(公費３負担額_明細);
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
     * 費用額合計を設定します。
     *
     * @param 費用額合計 費用額合計
     */
    public void set費用額合計(int 費用額合計) {
        requireNonNull(費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額合計"));
        entity.setHiyogakuTotal(費用額合計);
    }

    /**
     * 保険分請求額合計を設定します。
     *
     * @param 保険分請求額合計 保険分請求額合計
     */
    public void set保険分請求額合計(int 保険分請求額合計) {
        requireNonNull(保険分請求額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分請求額合計"));
        entity.setHokenbunSeikyugakuTotal(保険分請求額合計);
    }

    /**
     * 利用者負担額合計を設定します。
     *
     * @param 利用者負担額合計 利用者負担額合計
     */
    public void set利用者負担額合計(int 利用者負担額合計) {
        requireNonNull(利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額合計"));
        entity.setRiyoshaFutangakuTotal(利用者負担額合計);
    }

    /**
     * 公費１_負担額合計を設定します。
     *
     * @param 公費１_負担額合計 公費１_負担額合計
     */
    public void set公費１_負担額合計(int 公費１_負担額合計) {
        requireNonNull(公費１_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_負担額合計"));
        entity.setKohi1FutangakuTotal(公費１_負担額合計);
    }

    /**
     * 公費１_請求額を設定します。
     *
     * @param 公費１_請求額 公費１_請求額
     */
    public void set公費１_請求額(int 公費１_請求額) {
        requireNonNull(公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_請求額"));
        entity.setKohi1Seikyugaku(公費１_請求額);
    }

    /**
     * 公費１_本人負担月額を設定します。
     *
     * @param 公費１_本人負担月額 公費１_本人負担月額
     */
    public void set公費１_本人負担月額(int 公費１_本人負担月額) {
        requireNonNull(公費１_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_本人負担月額"));
        entity.setKohi1HonninFutanGetsugaku(公費１_本人負担月額);
    }

    /**
     * 公費２_負担額合計を設定します。
     *
     * @param 公費２_負担額合計 公費２_負担額合計
     */
    public void set公費２_負担額合計(int 公費２_負担額合計) {
        requireNonNull(公費２_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_負担額合計"));
        entity.setKohi2FutangakuTotal(公費２_負担額合計);
    }

    /**
     * 公費２_請求額を設定します。
     *
     * @param 公費２_請求額 公費２_請求額
     */
    public void set公費２_請求額(int 公費２_請求額) {
        requireNonNull(公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_請求額"));
        entity.setKohi2Seikyugaku(公費２_請求額);
    }

    /**
     * 公費２_本人負担月額を設定します。
     *
     * @param 公費２_本人負担月額 公費２_本人負担月額
     */
    public void set公費２_本人負担月額(int 公費２_本人負担月額) {
        requireNonNull(公費２_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_本人負担月額"));
        entity.setKohi2HonninFutanGetsugaku(公費２_本人負担月額);
    }

    /**
     * 公費３_負担額合計を設定します。
     *
     * @param 公費３_負担額合計 公費３_負担額合計
     */
    public void set公費３_負担額合計(int 公費３_負担額合計) {
        requireNonNull(公費３_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_負担額合計"));
        entity.setKohi3FutangakuTotal(公費３_負担額合計);
    }

    /**
     * 公費３_請求額を設定します。
     *
     * @param 公費３_請求額 公費３_請求額
     */
    public void set公費３_請求額(int 公費３_請求額) {
        requireNonNull(公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_請求額"));
        entity.setKohi3Seikyugaku(公費３_請求額);
    }

    /**
     * 公費３_本人負担月額を設定します。
     *
     * @param 公費３_本人負担月額 公費３_本人負担月額
     */
    public void set公費３_本人負担月額(int 公費３_本人負担月額) {
        requireNonNull(公費３_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_本人負担月額"));
        entity.setKohi3HonninFutanGetsugaku(公費３_本人負担月額);
    }

    /**
     * 後_費用単価を設定します。
     *
     * @param 後_費用単価 後_費用単価
     */
    public void set後_費用単価(int 後_費用単価) {
        requireNonNull(後_費用単価, UrSystemErrorMessages.値がnull.getReplacedMessage("後_費用単価"));
        entity.setAtoHiyoTanka(後_費用単価);
    }

    /**
     * 後_日数を設定します。
     *
     * @param 後_日数 後_日数
     */
    public void set後_日数(int 後_日数) {
        requireNonNull(後_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_日数"));
        entity.setAtoNissu(後_日数);
    }

    /**
     * 後_公費１日数を設定します。
     *
     * @param 後_公費１日数 後_公費１日数
     */
    public void set後_公費１日数(int 後_公費１日数) {
        requireNonNull(後_公費１日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１日数"));
        entity.setAtoKohi1Nissu(後_公費１日数);
    }

    /**
     * 後_公費２日数を設定します。
     *
     * @param 後_公費２日数 後_公費２日数
     */
    public void set後_公費２日数(int 後_公費２日数) {
        requireNonNull(後_公費２日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２日数"));
        entity.setAtoKohi2Nissu(後_公費２日数);
    }

    /**
     * 後_公費３日数を設定します。
     *
     * @param 後_公費３日数 後_公費３日数
     */
    public void set後_公費３日数(int 後_公費３日数) {
        requireNonNull(後_公費３日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３日数"));
        entity.setAtoKohi3Nissu(後_公費３日数);
    }

    /**
     * 後_費用額を設定します。
     *
     * @param 後_費用額 後_費用額
     */
    public void set後_費用額(int 後_費用額) {
        requireNonNull(後_費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_費用額"));
        entity.setAtoHiyogaku(後_費用額);
    }

    /**
     * 後_保険分請求額を設定します。
     *
     * @param 後_保険分請求額 後_保険分請求額
     */
    public void set後_保険分請求額(int 後_保険分請求額) {
        requireNonNull(後_保険分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険分請求額"));
        entity.setAtoHokenbunSeikyugaku(後_保険分請求額);
    }

    /**
     * 後_公費１負担額_明細を設定します。
     *
     * @param 後_公費１負担額_明細 後_公費１負担額_明細
     */
    public void set後_公費１負担額_明細(int 後_公費１負担額_明細) {
        requireNonNull(後_公費１負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１負担額_明細"));
        entity.setAtoKohi1Futangaku(後_公費１負担額_明細);
    }

    /**
     * 後_公費２負担額_明細を設定します。
     *
     * @param 後_公費２負担額_明細 後_公費２負担額_明細
     */
    public void set後_公費２負担額_明細(int 後_公費２負担額_明細) {
        requireNonNull(後_公費２負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２負担額_明細"));
        entity.setAtoKohi2Futangaku(後_公費２負担額_明細);
    }

    /**
     * 後_公費３負担額_明細を設定します。
     *
     * @param 後_公費３負担額_明細 後_公費３負担額_明細
     */
    public void set後_公費３負担額_明細(int 後_公費３負担額_明細) {
        requireNonNull(後_公費３負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３負担額_明細"));
        entity.setAtoKohi3Futangaku(後_公費３負担額_明細);
    }

    /**
     * 後_利用者負担額を設定します。
     *
     * @param 後_利用者負担額 後_利用者負担額
     */
    public void set後_利用者負担額(int 後_利用者負担額) {
        requireNonNull(後_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_利用者負担額"));
        entity.setAtoRiyoshaFutangaku(後_利用者負担額);
    }

    /**
     * 後_費用額合計を設定します。
     *
     * @param 後_費用額合計 後_費用額合計
     */
    public void set後_費用額合計(int 後_費用額合計) {
        requireNonNull(後_費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_費用額合計"));
        entity.setAtoHiyogakuTotal(後_費用額合計);
    }

    /**
     * 後_保険分請求額合計を設定します。
     *
     * @param 後_保険分請求額合計 後_保険分請求額合計
     */
    public void set後_保険分請求額合計(int 後_保険分請求額合計) {
        requireNonNull(後_保険分請求額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険分請求額合計"));
        entity.setAtoHokenbunSeikyugakuTotal(後_保険分請求額合計);
    }

    /**
     * 後_利用者負担額合計を設定します。
     *
     * @param 後_利用者負担額合計 後_利用者負担額合計
     */
    public void set後_利用者負担額合計(int 後_利用者負担額合計) {
        requireNonNull(後_利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_利用者負担額合計"));
        entity.setAtoRiyoshaFutangakuTotal(後_利用者負担額合計);
    }

    /**
     * 後_公費１_負担額合計を設定します。
     *
     * @param 後_公費１_負担額合計 後_公費１_負担額合計
     */
    public void set後_公費１_負担額合計(int 後_公費１_負担額合計) {
        requireNonNull(後_公費１_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_負担額合計"));
        entity.setAtoKohi1FutangakuTotal(後_公費１_負担額合計);
    }

    /**
     * 後_公費１_請求額を設定します。
     *
     * @param 後_公費１_請求額 後_公費１_請求額
     */
    public void set後_公費１_請求額(int 後_公費１_請求額) {
        requireNonNull(後_公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_請求額"));
        entity.setAtoKohi1Seikyugaku(後_公費１_請求額);
    }

    /**
     * 後_公費１_本人負担月額を設定します。
     *
     * @param 後_公費１_本人負担月額 後_公費１_本人負担月額
     */
    public void set後_公費１_本人負担月額(int 後_公費１_本人負担月額) {
        requireNonNull(後_公費１_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_本人負担月額"));
        entity.setAtoKohi1HonninFutanGetsugaku(後_公費１_本人負担月額);
    }

    /**
     * 後_公費２_負担額合計を設定します。
     *
     * @param 後_公費２_負担額合計 後_公費２_負担額合計
     */
    public void set後_公費２_負担額合計(int 後_公費２_負担額合計) {
        requireNonNull(後_公費２_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_負担額合計"));
        entity.setAtoKohi2FutangakuTotal(後_公費２_負担額合計);
    }

    /**
     * 後_公費２_請求額を設定します。
     *
     * @param 後_公費２_請求額 後_公費２_請求額
     */
    public void set後_公費２_請求額(int 後_公費２_請求額) {
        requireNonNull(後_公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_請求額"));
        entity.setAtoKohi2Seikyugaku(後_公費２_請求額);
    }

    /**
     * 後_公費２_本人負担月額を設定します。
     *
     * @param 後_公費２_本人負担月額 後_公費２_本人負担月額
     */
    public void set後_公費２_本人負担月額(int 後_公費２_本人負担月額) {
        requireNonNull(後_公費２_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_本人負担月額"));
        entity.setAtoKohi2HonninFutanGetsugaku(後_公費２_本人負担月額);
    }

    /**
     * 後_公費３_負担額合計を設定します。
     *
     * @param 後_公費３_負担額合計 後_公費３_負担額合計
     */
    public void set後_公費３_負担額合計(int 後_公費３_負担額合計) {
        requireNonNull(後_公費３_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_負担額合計"));
        entity.setAtoKohi3FutangakuTotal(後_公費３_負担額合計);
    }

    /**
     * 後_公費３_請求額を設定します。
     *
     * @param 後_公費３_請求額 後_公費３_請求額
     */
    public void set後_公費３_請求額(int 後_公費３_請求額) {
        requireNonNull(後_公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_請求額"));
        entity.setAtoKohi3Seikyugaku(後_公費３_請求額);
    }

    /**
     * 後_公費３_本人負担月額を設定します。
     *
     * @param 後_公費３_本人負担月額 後_公費３_本人負担月額
     */
    public void set後_公費３_本人負担月額(int 後_公費３_本人負担月額) {
        requireNonNull(後_公費３_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_本人負担月額"));
        entity.setAtoKohi3HonninFutanGetsugaku(後_公費３_本人負担月額);
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
