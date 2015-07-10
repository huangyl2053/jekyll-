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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績食事費用のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiShokujiHiyoModel implements Serializable {

    private DbT3022KyufujissekiShokujiHiyoEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiShokujiHiyoModel() {
        entity = new DbT3022KyufujissekiShokujiHiyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3022KyufujissekiShokujiHiyoEntity
     */
    public KyufujissekiShokujiHiyoModel(DbT3022KyufujissekiShokujiHiyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3022KyufujissekiShokujiHiyoEntityを返します。
     *
     * @return DbT3022KyufujissekiShokujiHiyoEntity
     */
    public DbT3022KyufujissekiShokujiHiyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3022KyufujissekiShokujiHiyoEntityを設定します。
     *
     * @param entity DbT3022KyufujissekiShokujiHiyoEntity
     */
    public void setEntity(DbT3022KyufujissekiShokujiHiyoEntity entity) {
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
     * 基本_提供日数を返します。
     *
     * @return 基本_提供日数
     */
    public int get基本_提供日数() {
        return entity.getKihonTeikyoNissu();
    }

    /**
     * 基本_提供単価を返します。
     *
     * @return 基本_提供単価
     */
    public int get基本_提供単価() {
        return entity.getKihonTeikyoTanka();
    }

    /**
     * 基本_提供金額を返します。
     *
     * @return 基本_提供金額
     */
    public int get基本_提供金額() {
        return entity.getKihonTeikyoKingaku();
    }

    /**
     * 特別_提供日数を返します。
     *
     * @return 特別_提供日数
     */
    public int get特別_提供日数() {
        return entity.getTokubestuTeikyoNissu();
    }

    /**
     * 特別_提供単価を返します。
     *
     * @return 特別_提供単価
     */
    public int get特別_提供単価() {
        return entity.getTokubestuTeikyoTanka();
    }

    /**
     * 特別_提供金額を返します。
     *
     * @return 特別_提供金額
     */
    public int get特別_提供金額() {
        return entity.getTokubestuTeikyoKingaku();
    }

    /**
     * 食事提供延べ日数を返します。
     *
     * @return 食事提供延べ日数
     */
    public int get食事提供延べ日数() {
        return entity.getSyokujiTeikyoNissu();
    }

    /**
     * 公費１対象食事提供延べ日数を返します。
     *
     * @return 公費１対象食事提供延べ日数
     */
    public int get公費１対象食事提供延べ日数() {
        return entity.getKohi1SyokujiTeikyoNissu();
    }

    /**
     * 公費２対象食事提供延べ日数を返します。
     *
     * @return 公費２対象食事提供延べ日数
     */
    public int get公費２対象食事提供延べ日数() {
        return entity.getKohi2SyokujiTeikyoNissu();
    }

    /**
     * 公費３対象食事提供延べ日数を返します。
     *
     * @return 公費３対象食事提供延べ日数
     */
    public int get公費３対象食事提供延べ日数() {
        return entity.getKohi3SyokujiTeikyoNissu();
    }

    /**
     * 食事提供費合計を返します。
     *
     * @return 食事提供費合計
     */
    public int get食事提供費合計() {
        return entity.getSyokujiTeikyohiTotal();
    }

    /**
     * 標準負担額_月額を返します。
     *
     * @return 標準負担額_月額
     */
    public int get標準負担額_月額() {
        return entity.getGetsugakuHyojunFutanGaku();
    }

    /**
     * 食事提供費請求額を返します。
     *
     * @return 食事提供費請求額
     */
    public int get食事提供費請求額() {
        return entity.getSyokujiTeikyohiSeikyugaku();
    }

    /**
     * 公費１食事提供費請求額を返します。
     *
     * @return 公費１食事提供費請求額
     */
    public int get公費１食事提供費請求額() {
        return entity.getKohi1SyokujiTeikyohiSeikyugaku();
    }

    /**
     * 公費２食事提供費請求額を返します。
     *
     * @return 公費２食事提供費請求額
     */
    public int get公費２食事提供費請求額() {
        return entity.getKohi2SyokujiTeikyohiSeikyugaku();
    }

    /**
     * 公費３食事提供費請求額を返します。
     *
     * @return 公費３食事提供費請求額
     */
    public int get公費３食事提供費請求額() {
        return entity.getKohi3SyokujiTeikyohiSeikyugaku();
    }

    /**
     * 標準負担額_日額を返します。
     *
     * @return 標準負担額_日額
     */
    public int get標準負担額_日額() {
        return entity.getNichigakuHyojunFutanGaku();
    }

    /**
     * 後_基本食提供費用提供単価を返します。
     *
     * @return 後_基本食提供費用提供単価
     */
    public int get後_基本食提供費用提供単価() {
        return entity.getAtoKihonTeikyoTanka();
    }

    /**
     * 後_特別食提供費用提供単価を返します。
     *
     * @return 後_特別食提供費用提供単価
     */
    public int get後_特別食提供費用提供単価() {
        return entity.getAtoTokubestuTeikyoTanka();
    }

    /**
     * 後_食事提供費請求額を返します。
     *
     * @return 後_食事提供費請求額
     */
    public int get後_食事提供費請求額() {
        return entity.getAtoSyokujiTeikyohiSeikyugaku();
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
     * 基本_提供日数を設定します。
     *
     * @param 基本_提供日数 基本_提供日数
     */
    public void set基本_提供日数(int 基本_提供日数) {
        requireNonNull(基本_提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("基本_提供日数"));
        entity.setKihonTeikyoNissu(基本_提供日数);
    }

    /**
     * 基本_提供単価を設定します。
     *
     * @param 基本_提供単価 基本_提供単価
     */
    public void set基本_提供単価(int 基本_提供単価) {
        requireNonNull(基本_提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("基本_提供単価"));
        entity.setKihonTeikyoTanka(基本_提供単価);
    }

    /**
     * 基本_提供金額を設定します。
     *
     * @param 基本_提供金額 基本_提供金額
     */
    public void set基本_提供金額(int 基本_提供金額) {
        requireNonNull(基本_提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("基本_提供金額"));
        entity.setKihonTeikyoKingaku(基本_提供金額);
    }

    /**
     * 特別_提供日数を設定します。
     *
     * @param 特別_提供日数 特別_提供日数
     */
    public void set特別_提供日数(int 特別_提供日数) {
        requireNonNull(特別_提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("特別_提供日数"));
        entity.setTokubestuTeikyoNissu(特別_提供日数);
    }

    /**
     * 特別_提供単価を設定します。
     *
     * @param 特別_提供単価 特別_提供単価
     */
    public void set特別_提供単価(int 特別_提供単価) {
        requireNonNull(特別_提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("特別_提供単価"));
        entity.setTokubestuTeikyoTanka(特別_提供単価);
    }

    /**
     * 特別_提供金額を設定します。
     *
     * @param 特別_提供金額 特別_提供金額
     */
    public void set特別_提供金額(int 特別_提供金額) {
        requireNonNull(特別_提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("特別_提供金額"));
        entity.setTokubestuTeikyoKingaku(特別_提供金額);
    }

    /**
     * 食事提供延べ日数を設定します。
     *
     * @param 食事提供延べ日数 食事提供延べ日数
     */
    public void set食事提供延べ日数(int 食事提供延べ日数) {
        requireNonNull(食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供延べ日数"));
        entity.setSyokujiTeikyoNissu(食事提供延べ日数);
    }

    /**
     * 公費１対象食事提供延べ日数を設定します。
     *
     * @param 公費１対象食事提供延べ日数 公費１対象食事提供延べ日数
     */
    public void set公費１対象食事提供延べ日数(int 公費１対象食事提供延べ日数) {
        requireNonNull(公費１対象食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象食事提供延べ日数"));
        entity.setKohi1SyokujiTeikyoNissu(公費１対象食事提供延べ日数);
    }

    /**
     * 公費２対象食事提供延べ日数を設定します。
     *
     * @param 公費２対象食事提供延べ日数 公費２対象食事提供延べ日数
     */
    public void set公費２対象食事提供延べ日数(int 公費２対象食事提供延べ日数) {
        requireNonNull(公費２対象食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象食事提供延べ日数"));
        entity.setKohi2SyokujiTeikyoNissu(公費２対象食事提供延べ日数);
    }

    /**
     * 公費３対象食事提供延べ日数を設定します。
     *
     * @param 公費３対象食事提供延べ日数 公費３対象食事提供延べ日数
     */
    public void set公費３対象食事提供延べ日数(int 公費３対象食事提供延べ日数) {
        requireNonNull(公費３対象食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象食事提供延べ日数"));
        entity.setKohi3SyokujiTeikyoNissu(公費３対象食事提供延べ日数);
    }

    /**
     * 食事提供費合計を設定します。
     *
     * @param 食事提供費合計 食事提供費合計
     */
    public void set食事提供費合計(int 食事提供費合計) {
        requireNonNull(食事提供費合計, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費合計"));
        entity.setSyokujiTeikyohiTotal(食事提供費合計);
    }

    /**
     * 標準負担額_月額を設定します。
     *
     * @param 標準負担額_月額 標準負担額_月額
     */
    public void set標準負担額_月額(int 標準負担額_月額) {
        requireNonNull(標準負担額_月額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_月額"));
        entity.setGetsugakuHyojunFutanGaku(標準負担額_月額);
    }

    /**
     * 食事提供費請求額を設定します。
     *
     * @param 食事提供費請求額 食事提供費請求額
     */
    public void set食事提供費請求額(int 食事提供費請求額) {
        requireNonNull(食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費請求額"));
        entity.setSyokujiTeikyohiSeikyugaku(食事提供費請求額);
    }

    /**
     * 公費１食事提供費請求額を設定します。
     *
     * @param 公費１食事提供費請求額 公費１食事提供費請求額
     */
    public void set公費１食事提供費請求額(int 公費１食事提供費請求額) {
        requireNonNull(公費１食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１食事提供費請求額"));
        entity.setKohi1SyokujiTeikyohiSeikyugaku(公費１食事提供費請求額);
    }

    /**
     * 公費２食事提供費請求額を設定します。
     *
     * @param 公費２食事提供費請求額 公費２食事提供費請求額
     */
    public void set公費２食事提供費請求額(int 公費２食事提供費請求額) {
        requireNonNull(公費２食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２食事提供費請求額"));
        entity.setKohi2SyokujiTeikyohiSeikyugaku(公費２食事提供費請求額);
    }

    /**
     * 公費３食事提供費請求額を設定します。
     *
     * @param 公費３食事提供費請求額 公費３食事提供費請求額
     */
    public void set公費３食事提供費請求額(int 公費３食事提供費請求額) {
        requireNonNull(公費３食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３食事提供費請求額"));
        entity.setKohi3SyokujiTeikyohiSeikyugaku(公費３食事提供費請求額);
    }

    /**
     * 標準負担額_日額を設定します。
     *
     * @param 標準負担額_日額 標準負担額_日額
     */
    public void set標準負担額_日額(int 標準負担額_日額) {
        requireNonNull(標準負担額_日額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_日額"));
        entity.setNichigakuHyojunFutanGaku(標準負担額_日額);
    }

    /**
     * 後_基本食提供費用提供単価を設定します。
     *
     * @param 後_基本食提供費用提供単価 後_基本食提供費用提供単価
     */
    public void set後_基本食提供費用提供単価(int 後_基本食提供費用提供単価) {
        requireNonNull(後_基本食提供費用提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("後_基本食提供費用提供単価"));
        entity.setAtoKihonTeikyoTanka(後_基本食提供費用提供単価);
    }

    /**
     * 後_特別食提供費用提供単価を設定します。
     *
     * @param 後_特別食提供費用提供単価 後_特別食提供費用提供単価
     */
    public void set後_特別食提供費用提供単価(int 後_特別食提供費用提供単価) {
        requireNonNull(後_特別食提供費用提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("後_特別食提供費用提供単価"));
        entity.setAtoTokubestuTeikyoTanka(後_特別食提供費用提供単価);
    }

    /**
     * 後_食事提供費請求額を設定します。
     *
     * @param 後_食事提供費請求額 後_食事提供費請求額
     */
    public void set後_食事提供費請求額(int 後_食事提供費請求額) {
        requireNonNull(後_食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_食事提供費請求額"));
        entity.setAtoSyokujiTeikyohiSeikyugaku(後_食事提供費請求額);
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
