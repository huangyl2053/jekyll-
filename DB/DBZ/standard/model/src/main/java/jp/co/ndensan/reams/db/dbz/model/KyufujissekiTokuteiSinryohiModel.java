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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績特定診療費のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiTokuteiSinryohiModel implements Serializable {

    private DbT3020KyufujissekiTokuteiSinryohiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiTokuteiSinryohiModel() {
        entity = new DbT3020KyufujissekiTokuteiSinryohiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3020KyufujissekiTokuteiSinryohiEntity
     */
    public KyufujissekiTokuteiSinryohiModel(DbT3020KyufujissekiTokuteiSinryohiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3020KyufujissekiTokuteiSinryohiEntityを返します。
     *
     * @return DbT3020KyufujissekiTokuteiSinryohiEntity
     */
    public DbT3020KyufujissekiTokuteiSinryohiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3020KyufujissekiTokuteiSinryohiEntityを設定します。
     *
     * @param entity DbT3020KyufujissekiTokuteiSinryohiEntity
     */
    public void setEntity(DbT3020KyufujissekiTokuteiSinryohiEntity entity) {
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
     * 保険_指導管理料等を返します。
     *
     * @return 保険_指導管理料等
     */
    public int get保険_指導管理料等() {
        return entity.getHokenShidoKanriryo();
    }

    /**
     * 保険_単純エックス線を返します。
     *
     * @return 保険_単純エックス線
     */
    public int get保険_単純エックス線() {
        return entity.getHokenTanjunXsen();
    }

    /**
     * 保険_リハビリテーションを返します。
     *
     * @return 保険_リハビリテーション
     */
    public int get保険_リハビリテーション() {
        return entity.getHokenRehabilitation();
    }

    /**
     * 保険_精神科専門療法を返します。
     *
     * @return 保険_精神科専門療法
     */
    public int get保険_精神科専門療法() {
        return entity.getHokenSeishinkaSemmonRyoho();
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
     * 公費１_指導管理料等を返します。
     *
     * @return 公費１_指導管理料等
     */
    public int get公費１_指導管理料等() {
        return entity.getKohi1ShidoKanriryo();
    }

    /**
     * 公費１_単純エックス線を返します。
     *
     * @return 公費１_単純エックス線
     */
    public int get公費１_単純エックス線() {
        return entity.getKohi1TanjunXsen();
    }

    /**
     * 公費１_リハビリテーションを返します。
     *
     * @return 公費１_リハビリテーション
     */
    public int get公費１_リハビリテーション() {
        return entity.getKohi1Rehabilitation();
    }

    /**
     * 公費１_精神科専門療法を返します。
     *
     * @return 公費１_精神科専門療法
     */
    public int get公費１_精神科専門療法() {
        return entity.getKohi1SeishinkaSemmonRyoho();
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
     * 公費２_指導管理料等を返します。
     *
     * @return 公費２_指導管理料等
     */
    public int get公費２_指導管理料等() {
        return entity.getKohi2ShidoKanriryo();
    }

    /**
     * 公費２_単純エックス線を返します。
     *
     * @return 公費２_単純エックス線
     */
    public int get公費２_単純エックス線() {
        return entity.getKohi2TanjunXsen();
    }

    /**
     * 公費２_リハビリテーションを返します。
     *
     * @return 公費２_リハビリテーション
     */
    public int get公費２_リハビリテーション() {
        return entity.getKohi2Rehabilitation();
    }

    /**
     * 公費２_精神科専門療法を返します。
     *
     * @return 公費２_精神科専門療法
     */
    public int get公費２_精神科専門療法() {
        return entity.getKohi2SeishinkaSemmonRyoho();
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
     * 公費３_指導管理料等を返します。
     *
     * @return 公費３_指導管理料等
     */
    public int get公費３_指導管理料等() {
        return entity.getKohi3ShidoKanriryo();
    }

    /**
     * 公費３_単純エックス線を返します。
     *
     * @return 公費３_単純エックス線
     */
    public int get公費３_単純エックス線() {
        return entity.getKohi3TanjunXsen();
    }

    /**
     * 公費３_リハビリテーションを返します。
     *
     * @return 公費３_リハビリテーション
     */
    public int get公費３_リハビリテーション() {
        return entity.getKohi3Rehabilitation();
    }

    /**
     * 公費３_精神科専門療法を返します。
     *
     * @return 公費３_精神科専門療法
     */
    public int get公費３_精神科専門療法() {
        return entity.getKohi3SeishinkaSemmonRyoho();
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
     * 摘要１を返します。
     *
     * @return 摘要１
     */
    public RString get摘要１() {
        return entity.getTekiyo1();
    }

    /**
     * 摘要２を返します。
     *
     * @return 摘要２
     */
    public RString get摘要２() {
        return entity.getTekiyo2();
    }

    /**
     * 摘要３を返します。
     *
     * @return 摘要３
     */
    public RString get摘要３() {
        return entity.getTekiyo3();
    }

    /**
     * 摘要４を返します。
     *
     * @return 摘要４
     */
    public RString get摘要４() {
        return entity.getTekiyo4();
    }

    /**
     * 摘要５を返します。
     *
     * @return 摘要５
     */
    public RString get摘要５() {
        return entity.getTekiyo5();
    }

    /**
     * 摘要６を返します。
     *
     * @return 摘要６
     */
    public RString get摘要６() {
        return entity.getTekiyo6();
    }

    /**
     * 摘要７を返します。
     *
     * @return 摘要７
     */
    public RString get摘要７() {
        return entity.getTekiyo7();
    }

    /**
     * 摘要８を返します。
     *
     * @return 摘要８
     */
    public RString get摘要８() {
        return entity.getTekiyo8();
    }

    /**
     * 摘要９を返します。
     *
     * @return 摘要９
     */
    public RString get摘要９() {
        return entity.getTekiyo9();
    }

    /**
     * 摘要１０を返します。
     *
     * @return 摘要１０
     */
    public RString get摘要１０() {
        return entity.getTekiyo10();
    }

    /**
     * 摘要１１を返します。
     *
     * @return 摘要１１
     */
    public RString get摘要１１() {
        return entity.getTekiyo11();
    }

    /**
     * 摘要１２を返します。
     *
     * @return 摘要１２
     */
    public RString get摘要１２() {
        return entity.getTekiyo12();
    }

    /**
     * 摘要１３を返します。
     *
     * @return 摘要１３
     */
    public RString get摘要１３() {
        return entity.getTekiyo13();
    }

    /**
     * 摘要１４を返します。
     *
     * @return 摘要１４
     */
    public RString get摘要１４() {
        return entity.getTekiyo14();
    }

    /**
     * 摘要１５を返します。
     *
     * @return 摘要１５
     */
    public RString get摘要１５() {
        return entity.getTekiyo15();
    }

    /**
     * 摘要１６を返します。
     *
     * @return 摘要１６
     */
    public RString get摘要１６() {
        return entity.getTekiyo16();
    }

    /**
     * 摘要１７を返します。
     *
     * @return 摘要１７
     */
    public RString get摘要１７() {
        return entity.getTekiyo17();
    }

    /**
     * 摘要１８を返します。
     *
     * @return 摘要１８
     */
    public RString get摘要１８() {
        return entity.getTekiyo18();
    }

    /**
     * 摘要１９を返します。
     *
     * @return 摘要１９
     */
    public RString get摘要１９() {
        return entity.getTekiyo19();
    }

    /**
     * 摘要２０を返します。
     *
     * @return 摘要２０
     */
    public RString get摘要２０() {
        return entity.getTekiyo20();
    }

    /**
     * 後_保険_指導管理料等を返します。
     *
     * @return 後_保険_指導管理料等
     */
    public int get後_保険_指導管理料等() {
        return entity.getAtoHokenShidoKanriryo();
    }

    /**
     * 後_保険_単純エックス線を返します。
     *
     * @return 後_保険_単純エックス線
     */
    public int get後_保険_単純エックス線() {
        return entity.getAtoHokenTanjunXsen();
    }

    /**
     * 後_保険_リハビリテーションを返します。
     *
     * @return 後_保険_リハビリテーション
     */
    public int get後_保険_リハビリテーション() {
        return entity.getAtoHokenRehabilitation();
    }

    /**
     * 後_保険_精神科専門療法を返します。
     *
     * @return 後_保険_精神科専門療法
     */
    public int get後_保険_精神科専門療法() {
        return entity.getAtoHokenSeishinkaSemmonRyoho();
    }

    /**
     * 後_公費１_指導管理料等を返します。
     *
     * @return 後_公費１_指導管理料等
     */
    public int get後_公費１_指導管理料等() {
        return entity.getAtoKohi1ShidoKanriryo();
    }

    /**
     * 後_公費１_単純エックス線を返します。
     *
     * @return 後_公費１_単純エックス線
     */
    public int get後_公費１_単純エックス線() {
        return entity.getAtoKohi1TanjunXsen();
    }

    /**
     * 後_公費１_リハビリテーションを返します。
     *
     * @return 後_公費１_リハビリテーション
     */
    public int get後_公費１_リハビリテーション() {
        return entity.getAtoKohi1Rehabilitation();
    }

    /**
     * 後_公費１_精神科専門療法を返します。
     *
     * @return 後_公費１_精神科専門療法
     */
    public int get後_公費１_精神科専門療法() {
        return entity.getAtoKohi1SeishinkaSemmonRyoho();
    }

    /**
     * 後_公費２_指導管理料等を返します。
     *
     * @return 後_公費２_指導管理料等
     */
    public int get後_公費２_指導管理料等() {
        return entity.getAtoKohi2ShidoKanriryo();
    }

    /**
     * 後_公費２_単純エックス線を返します。
     *
     * @return 後_公費２_単純エックス線
     */
    public int get後_公費２_単純エックス線() {
        return entity.getAtoKohi2TanjunXsen();
    }

    /**
     * 後_公費２_リハビリテーションを返します。
     *
     * @return 後_公費２_リハビリテーション
     */
    public int get後_公費２_リハビリテーション() {
        return entity.getAtoKohi2Rehabilitation();
    }

    /**
     * 後_公費２_精神科専門療法を返します。
     *
     * @return 後_公費２_精神科専門療法
     */
    public int get後_公費２_精神科専門療法() {
        return entity.getAtoKohi2SeishinkaSemmonRyoho();
    }

    /**
     * 後_公費３_指導管理料等を返します。
     *
     * @return 後_公費３_指導管理料等
     */
    public int get後_公費３_指導管理料等() {
        return entity.getAtoKohi3ShidoKanriryo();
    }

    /**
     * 後_公費３_単純エックス線を返します。
     *
     * @return 後_公費３_単純エックス線
     */
    public int get後_公費３_単純エックス線() {
        return entity.getAtoKohi3TanjunXsen();
    }

    /**
     * 後_公費３_リハビリテーションを返します。
     *
     * @return 後_公費３_リハビリテーション
     */
    public int get後_公費３_リハビリテーション() {
        return entity.getAtoKohi3Rehabilitation();
    }

    /**
     * 後_公費３_精神科専門療法を返します。
     *
     * @return 後_公費３_精神科専門療法
     */
    public int get後_公費３_精神科専門療法() {
        return entity.getAtoKohi3SeishinkaSemmonRyoho();
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
     * 保険_指導管理料等を設定します。
     *
     * @param 保険_指導管理料等 保険_指導管理料等
     */
    public void set保険_指導管理料等(int 保険_指導管理料等) {
        requireNonNull(保険_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_指導管理料等"));
        entity.setHokenShidoKanriryo(保険_指導管理料等);
    }

    /**
     * 保険_単純エックス線を設定します。
     *
     * @param 保険_単純エックス線 保険_単純エックス線
     */
    public void set保険_単純エックス線(int 保険_単純エックス線) {
        requireNonNull(保険_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_単純エックス線"));
        entity.setHokenTanjunXsen(保険_単純エックス線);
    }

    /**
     * 保険_リハビリテーションを設定します。
     *
     * @param 保険_リハビリテーション 保険_リハビリテーション
     */
    public void set保険_リハビリテーション(int 保険_リハビリテーション) {
        requireNonNull(保険_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_リハビリテーション"));
        entity.setHokenRehabilitation(保険_リハビリテーション);
    }

    /**
     * 保険_精神科専門療法を設定します。
     *
     * @param 保険_精神科専門療法 保険_精神科専門療法
     */
    public void set保険_精神科専門療法(int 保険_精神科専門療法) {
        requireNonNull(保険_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_精神科専門療法"));
        entity.setHokenSeishinkaSemmonRyoho(保険_精神科専門療法);
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
     * 公費１_指導管理料等を設定します。
     *
     * @param 公費１_指導管理料等 公費１_指導管理料等
     */
    public void set公費１_指導管理料等(int 公費１_指導管理料等) {
        requireNonNull(公費１_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_指導管理料等"));
        entity.setKohi1ShidoKanriryo(公費１_指導管理料等);
    }

    /**
     * 公費１_単純エックス線を設定します。
     *
     * @param 公費１_単純エックス線 公費１_単純エックス線
     */
    public void set公費１_単純エックス線(int 公費１_単純エックス線) {
        requireNonNull(公費１_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_単純エックス線"));
        entity.setKohi1TanjunXsen(公費１_単純エックス線);
    }

    /**
     * 公費１_リハビリテーションを設定します。
     *
     * @param 公費１_リハビリテーション 公費１_リハビリテーション
     */
    public void set公費１_リハビリテーション(int 公費１_リハビリテーション) {
        requireNonNull(公費１_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_リハビリテーション"));
        entity.setKohi1Rehabilitation(公費１_リハビリテーション);
    }

    /**
     * 公費１_精神科専門療法を設定します。
     *
     * @param 公費１_精神科専門療法 公費１_精神科専門療法
     */
    public void set公費１_精神科専門療法(int 公費１_精神科専門療法) {
        requireNonNull(公費１_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_精神科専門療法"));
        entity.setKohi1SeishinkaSemmonRyoho(公費１_精神科専門療法);
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
     * 公費２_指導管理料等を設定します。
     *
     * @param 公費２_指導管理料等 公費２_指導管理料等
     */
    public void set公費２_指導管理料等(int 公費２_指導管理料等) {
        requireNonNull(公費２_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_指導管理料等"));
        entity.setKohi2ShidoKanriryo(公費２_指導管理料等);
    }

    /**
     * 公費２_単純エックス線を設定します。
     *
     * @param 公費２_単純エックス線 公費２_単純エックス線
     */
    public void set公費２_単純エックス線(int 公費２_単純エックス線) {
        requireNonNull(公費２_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_単純エックス線"));
        entity.setKohi2TanjunXsen(公費２_単純エックス線);
    }

    /**
     * 公費２_リハビリテーションを設定します。
     *
     * @param 公費２_リハビリテーション 公費２_リハビリテーション
     */
    public void set公費２_リハビリテーション(int 公費２_リハビリテーション) {
        requireNonNull(公費２_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_リハビリテーション"));
        entity.setKohi2Rehabilitation(公費２_リハビリテーション);
    }

    /**
     * 公費２_精神科専門療法を設定します。
     *
     * @param 公費２_精神科専門療法 公費２_精神科専門療法
     */
    public void set公費２_精神科専門療法(int 公費２_精神科専門療法) {
        requireNonNull(公費２_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_精神科専門療法"));
        entity.setKohi2SeishinkaSemmonRyoho(公費２_精神科専門療法);
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
     * 公費３_指導管理料等を設定します。
     *
     * @param 公費３_指導管理料等 公費３_指導管理料等
     */
    public void set公費３_指導管理料等(int 公費３_指導管理料等) {
        requireNonNull(公費３_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_指導管理料等"));
        entity.setKohi3ShidoKanriryo(公費３_指導管理料等);
    }

    /**
     * 公費３_単純エックス線を設定します。
     *
     * @param 公費３_単純エックス線 公費３_単純エックス線
     */
    public void set公費３_単純エックス線(int 公費３_単純エックス線) {
        requireNonNull(公費３_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_単純エックス線"));
        entity.setKohi3TanjunXsen(公費３_単純エックス線);
    }

    /**
     * 公費３_リハビリテーションを設定します。
     *
     * @param 公費３_リハビリテーション 公費３_リハビリテーション
     */
    public void set公費３_リハビリテーション(int 公費３_リハビリテーション) {
        requireNonNull(公費３_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_リハビリテーション"));
        entity.setKohi3Rehabilitation(公費３_リハビリテーション);
    }

    /**
     * 公費３_精神科専門療法を設定します。
     *
     * @param 公費３_精神科専門療法 公費３_精神科専門療法
     */
    public void set公費３_精神科専門療法(int 公費３_精神科専門療法) {
        requireNonNull(公費３_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_精神科専門療法"));
        entity.setKohi3SeishinkaSemmonRyoho(公費３_精神科専門療法);
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
     * 摘要１を設定します。
     *
     * @param 摘要１ 摘要１
     */
    public void set摘要１(RString 摘要１) {
        requireNonNull(摘要１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１"));
        entity.setTekiyo1(摘要１);
    }

    /**
     * 摘要２を設定します。
     *
     * @param 摘要２ 摘要２
     */
    public void set摘要２(RString 摘要２) {
        requireNonNull(摘要２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２"));
        entity.setTekiyo2(摘要２);
    }

    /**
     * 摘要３を設定します。
     *
     * @param 摘要３ 摘要３
     */
    public void set摘要３(RString 摘要３) {
        requireNonNull(摘要３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要３"));
        entity.setTekiyo3(摘要３);
    }

    /**
     * 摘要４を設定します。
     *
     * @param 摘要４ 摘要４
     */
    public void set摘要４(RString 摘要４) {
        requireNonNull(摘要４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要４"));
        entity.setTekiyo4(摘要４);
    }

    /**
     * 摘要５を設定します。
     *
     * @param 摘要５ 摘要５
     */
    public void set摘要５(RString 摘要５) {
        requireNonNull(摘要５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要５"));
        entity.setTekiyo5(摘要５);
    }

    /**
     * 摘要６を設定します。
     *
     * @param 摘要６ 摘要６
     */
    public void set摘要６(RString 摘要６) {
        requireNonNull(摘要６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要６"));
        entity.setTekiyo6(摘要６);
    }

    /**
     * 摘要７を設定します。
     *
     * @param 摘要７ 摘要７
     */
    public void set摘要７(RString 摘要７) {
        requireNonNull(摘要７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要７"));
        entity.setTekiyo7(摘要７);
    }

    /**
     * 摘要８を設定します。
     *
     * @param 摘要８ 摘要８
     */
    public void set摘要８(RString 摘要８) {
        requireNonNull(摘要８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要８"));
        entity.setTekiyo8(摘要８);
    }

    /**
     * 摘要９を設定します。
     *
     * @param 摘要９ 摘要９
     */
    public void set摘要９(RString 摘要９) {
        requireNonNull(摘要９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要９"));
        entity.setTekiyo9(摘要９);
    }

    /**
     * 摘要１０を設定します。
     *
     * @param 摘要１０ 摘要１０
     */
    public void set摘要１０(RString 摘要１０) {
        requireNonNull(摘要１０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１０"));
        entity.setTekiyo10(摘要１０);
    }

    /**
     * 摘要１１を設定します。
     *
     * @param 摘要１１ 摘要１１
     */
    public void set摘要１１(RString 摘要１１) {
        requireNonNull(摘要１１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１１"));
        entity.setTekiyo11(摘要１１);
    }

    /**
     * 摘要１２を設定します。
     *
     * @param 摘要１２ 摘要１２
     */
    public void set摘要１２(RString 摘要１２) {
        requireNonNull(摘要１２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１２"));
        entity.setTekiyo12(摘要１２);
    }

    /**
     * 摘要１３を設定します。
     *
     * @param 摘要１３ 摘要１３
     */
    public void set摘要１３(RString 摘要１３) {
        requireNonNull(摘要１３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１３"));
        entity.setTekiyo13(摘要１３);
    }

    /**
     * 摘要１４を設定します。
     *
     * @param 摘要１４ 摘要１４
     */
    public void set摘要１４(RString 摘要１４) {
        requireNonNull(摘要１４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１４"));
        entity.setTekiyo14(摘要１４);
    }

    /**
     * 摘要１５を設定します。
     *
     * @param 摘要１５ 摘要１５
     */
    public void set摘要１５(RString 摘要１５) {
        requireNonNull(摘要１５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１５"));
        entity.setTekiyo15(摘要１５);
    }

    /**
     * 摘要１６を設定します。
     *
     * @param 摘要１６ 摘要１６
     */
    public void set摘要１６(RString 摘要１６) {
        requireNonNull(摘要１６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１６"));
        entity.setTekiyo16(摘要１６);
    }

    /**
     * 摘要１７を設定します。
     *
     * @param 摘要１７ 摘要１７
     */
    public void set摘要１７(RString 摘要１７) {
        requireNonNull(摘要１７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１７"));
        entity.setTekiyo17(摘要１７);
    }

    /**
     * 摘要１８を設定します。
     *
     * @param 摘要１８ 摘要１８
     */
    public void set摘要１８(RString 摘要１８) {
        requireNonNull(摘要１８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１８"));
        entity.setTekiyo18(摘要１８);
    }

    /**
     * 摘要１９を設定します。
     *
     * @param 摘要１９ 摘要１９
     */
    public void set摘要１９(RString 摘要１９) {
        requireNonNull(摘要１９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１９"));
        entity.setTekiyo19(摘要１９);
    }

    /**
     * 摘要２０を設定します。
     *
     * @param 摘要２０ 摘要２０
     */
    public void set摘要２０(RString 摘要２０) {
        requireNonNull(摘要２０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２０"));
        entity.setTekiyo20(摘要２０);
    }

    /**
     * 後_保険_指導管理料等を設定します。
     *
     * @param 後_保険_指導管理料等 後_保険_指導管理料等
     */
    public void set後_保険_指導管理料等(int 後_保険_指導管理料等) {
        requireNonNull(後_保険_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_指導管理料等"));
        entity.setAtoHokenShidoKanriryo(後_保険_指導管理料等);
    }

    /**
     * 後_保険_単純エックス線を設定します。
     *
     * @param 後_保険_単純エックス線 後_保険_単純エックス線
     */
    public void set後_保険_単純エックス線(int 後_保険_単純エックス線) {
        requireNonNull(後_保険_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_単純エックス線"));
        entity.setAtoHokenTanjunXsen(後_保険_単純エックス線);
    }

    /**
     * 後_保険_リハビリテーションを設定します。
     *
     * @param 後_保険_リハビリテーション 後_保険_リハビリテーション
     */
    public void set後_保険_リハビリテーション(int 後_保険_リハビリテーション) {
        requireNonNull(後_保険_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_リハビリテーション"));
        entity.setAtoHokenRehabilitation(後_保険_リハビリテーション);
    }

    /**
     * 後_保険_精神科専門療法を設定します。
     *
     * @param 後_保険_精神科専門療法 後_保険_精神科専門療法
     */
    public void set後_保険_精神科専門療法(int 後_保険_精神科専門療法) {
        requireNonNull(後_保険_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_精神科専門療法"));
        entity.setAtoHokenSeishinkaSemmonRyoho(後_保険_精神科専門療法);
    }

    /**
     * 後_公費１_指導管理料等を設定します。
     *
     * @param 後_公費１_指導管理料等 後_公費１_指導管理料等
     */
    public void set後_公費１_指導管理料等(int 後_公費１_指導管理料等) {
        requireNonNull(後_公費１_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_指導管理料等"));
        entity.setAtoKohi1ShidoKanriryo(後_公費１_指導管理料等);
    }

    /**
     * 後_公費１_単純エックス線を設定します。
     *
     * @param 後_公費１_単純エックス線 後_公費１_単純エックス線
     */
    public void set後_公費１_単純エックス線(int 後_公費１_単純エックス線) {
        requireNonNull(後_公費１_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_単純エックス線"));
        entity.setAtoKohi1TanjunXsen(後_公費１_単純エックス線);
    }

    /**
     * 後_公費１_リハビリテーションを設定します。
     *
     * @param 後_公費１_リハビリテーション 後_公費１_リハビリテーション
     */
    public void set後_公費１_リハビリテーション(int 後_公費１_リハビリテーション) {
        requireNonNull(後_公費１_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_リハビリテーション"));
        entity.setAtoKohi1Rehabilitation(後_公費１_リハビリテーション);
    }

    /**
     * 後_公費１_精神科専門療法を設定します。
     *
     * @param 後_公費１_精神科専門療法 後_公費１_精神科専門療法
     */
    public void set後_公費１_精神科専門療法(int 後_公費１_精神科専門療法) {
        requireNonNull(後_公費１_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_精神科専門療法"));
        entity.setAtoKohi1SeishinkaSemmonRyoho(後_公費１_精神科専門療法);
    }

    /**
     * 後_公費２_指導管理料等を設定します。
     *
     * @param 後_公費２_指導管理料等 後_公費２_指導管理料等
     */
    public void set後_公費２_指導管理料等(int 後_公費２_指導管理料等) {
        requireNonNull(後_公費２_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_指導管理料等"));
        entity.setAtoKohi2ShidoKanriryo(後_公費２_指導管理料等);
    }

    /**
     * 後_公費２_単純エックス線を設定します。
     *
     * @param 後_公費２_単純エックス線 後_公費２_単純エックス線
     */
    public void set後_公費２_単純エックス線(int 後_公費２_単純エックス線) {
        requireNonNull(後_公費２_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_単純エックス線"));
        entity.setAtoKohi2TanjunXsen(後_公費２_単純エックス線);
    }

    /**
     * 後_公費２_リハビリテーションを設定します。
     *
     * @param 後_公費２_リハビリテーション 後_公費２_リハビリテーション
     */
    public void set後_公費２_リハビリテーション(int 後_公費２_リハビリテーション) {
        requireNonNull(後_公費２_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_リハビリテーション"));
        entity.setAtoKohi2Rehabilitation(後_公費２_リハビリテーション);
    }

    /**
     * 後_公費２_精神科専門療法を設定します。
     *
     * @param 後_公費２_精神科専門療法 後_公費２_精神科専門療法
     */
    public void set後_公費２_精神科専門療法(int 後_公費２_精神科専門療法) {
        requireNonNull(後_公費２_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_精神科専門療法"));
        entity.setAtoKohi2SeishinkaSemmonRyoho(後_公費２_精神科専門療法);
    }

    /**
     * 後_公費３_指導管理料等を設定します。
     *
     * @param 後_公費３_指導管理料等 後_公費３_指導管理料等
     */
    public void set後_公費３_指導管理料等(int 後_公費３_指導管理料等) {
        requireNonNull(後_公費３_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_指導管理料等"));
        entity.setAtoKohi3ShidoKanriryo(後_公費３_指導管理料等);
    }

    /**
     * 後_公費３_単純エックス線を設定します。
     *
     * @param 後_公費３_単純エックス線 後_公費３_単純エックス線
     */
    public void set後_公費３_単純エックス線(int 後_公費３_単純エックス線) {
        requireNonNull(後_公費３_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_単純エックス線"));
        entity.setAtoKohi3TanjunXsen(後_公費３_単純エックス線);
    }

    /**
     * 後_公費３_リハビリテーションを設定します。
     *
     * @param 後_公費３_リハビリテーション 後_公費３_リハビリテーション
     */
    public void set後_公費３_リハビリテーション(int 後_公費３_リハビリテーション) {
        requireNonNull(後_公費３_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_リハビリテーション"));
        entity.setAtoKohi3Rehabilitation(後_公費３_リハビリテーション);
    }

    /**
     * 後_公費３_精神科専門療法を設定します。
     *
     * @param 後_公費３_精神科専門療法 後_公費３_精神科専門療法
     */
    public void set後_公費３_精神科専門療法(int 後_公費３_精神科専門療法) {
        requireNonNull(後_公費３_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_精神科専門療法"));
        entity.setAtoKohi3SeishinkaSemmonRyoho(後_公費３_精神科専門療法);
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
