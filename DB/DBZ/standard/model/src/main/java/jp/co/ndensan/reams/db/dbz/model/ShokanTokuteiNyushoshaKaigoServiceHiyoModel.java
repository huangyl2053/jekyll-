/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求特定入所者介護サービス費用のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanTokuteiNyushoshaKaigoServiceHiyoModel implements Serializable {

    private DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoModel() {
        entity = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity
     */
    public ShokanTokuteiNyushoshaKaigoServiceHiyoModel(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityを返します。
     *
     * @return DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity
     */
    public DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityを設定します。
     *
     * @param entity DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity
     */
    public void setEntity(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
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
        return entity.getSeiriNo();
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
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
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
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShikyuKubunCode();
    }

    /**
     * 点数金額を返します。
     *
     * @return 点数金額
     */
    public int get点数金額() {
        return entity.getTensuKingaku();
    }

    /**
     * 支給金額を返します。
     *
     * @return 支給金額
     */
    public int get支給金額() {
        return entity.getShikyuKingaku();
    }

    /**
     * 増減点を返します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity.getZougenten();
    }

    /**
     * 差額金額を返します。
     *
     * @return 差額金額
     */
    public int get差額金額() {
        return entity.getSagakuKingaku();
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
        entity.setSeiriNo(整理番号);
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
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     */
    public void set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
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
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     */
    public void set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
    }

    /**
     * 点数金額を設定します。
     *
     * @param 点数金額 点数金額
     */
    public void set点数金額(int 点数金額) {
        requireNonNull(点数金額, UrSystemErrorMessages.値がnull.getReplacedMessage("点数金額"));
        entity.setTensuKingaku(点数金額);
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     */
    public void set支給金額(int 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShikyuKingaku(支給金額);
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     */
    public void set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenten(増減点);
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     */
    public void set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
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
