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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績所定疾患施設療養費等のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KyufujissekiShoteiShikkanShisetsuRyoyoModel implements Serializable {

    private DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoModel() {
        entity = new DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoModel(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityを返します。
     *
     * @return DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity
     */
    public DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityを設定します。
     *
     * @param entity DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity
     */
    public void setEntity(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity) {
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
     * 緊急時施設療養情報レコード順次番号を返します。
     *
     * @return 緊急時施設療養情報レコード順次番号
     */
    public RString get緊急時施設療養情報レコード順次番号() {
        return entity.getRecodeJunjiNo();
    }

    /**
     * 緊急時傷病名１を返します。
     *
     * @return 緊急時傷病名１
     */
    public RString get緊急時傷病名１() {
        return entity.getKinkyuShobyoName1();
    }

    /**
     * 緊急時傷病名２を返します。
     *
     * @return 緊急時傷病名２
     */
    public RString get緊急時傷病名２() {
        return entity.getKinkyuShobyoName2();
    }

    /**
     * 緊急時傷病名３を返します。
     *
     * @return 緊急時傷病名３
     */
    public RString get緊急時傷病名３() {
        return entity.getKinkyuShobyoName3();
    }

    /**
     * 緊急時治療開始年月日１を返します。
     *
     * @return 緊急時治療開始年月日１
     */
    public FlexibleDate get緊急時治療開始年月日１() {
        return entity.getKinkyuChiryoKaishiYMD1();
    }

    /**
     * 緊急時治療開始年月日２を返します。
     *
     * @return 緊急時治療開始年月日２
     */
    public FlexibleDate get緊急時治療開始年月日２() {
        return entity.getKinkyuChiryoKaishiYMD2();
    }

    /**
     * 緊急時治療開始年月日３を返します。
     *
     * @return 緊急時治療開始年月日３
     */
    public FlexibleDate get緊急時治療開始年月日３() {
        return entity.getKinkyuChiryoKaishiYMD3();
    }

    /**
     * 往診日数を返します。
     *
     * @return 往診日数
     */
    public int get往診日数() {
        return entity.getOshinNissu();
    }

    /**
     * 往診医療機関名を返します。
     *
     * @return 往診医療機関名
     */
    public RString get往診医療機関名() {
        return entity.getOshinIryoKikanName();
    }

    /**
     * 通院日数を返します。
     *
     * @return 通院日数
     */
    public int get通院日数() {
        return entity.getTsuinNissu();
    }

    /**
     * 通院医療機関名を返します。
     *
     * @return 通院医療機関名
     */
    public RString get通院医療機関名() {
        return entity.getTsuinIryoKikanName();
    }

    /**
     * 緊急時治療管理単位数を返します。
     *
     * @return 緊急時治療管理単位数
     */
    public int get緊急時治療管理単位数() {
        return entity.getKinkyuChiryoKanriTanisu();
    }

    /**
     * 緊急時治療管理日数を返します。
     *
     * @return 緊急時治療管理日数
     */
    public int get緊急時治療管理日数() {
        return entity.getKinkyuChiryoKanriNissu();
    }

    /**
     * 緊急時治療管理小計を返します。
     *
     * @return 緊急時治療管理小計
     */
    public int get緊急時治療管理小計() {
        return entity.getKinkyuChiryoKanriSubTotal();
    }

    /**
     * リハビリテーション点数を返します。
     *
     * @return リハビリテーション点数
     */
    public int getリハビリテーション点数() {
        return entity.getRehabilitationTensu();
    }

    /**
     * 処置点数を返します。
     *
     * @return 処置点数
     */
    public int get処置点数() {
        return entity.getShochiTensu();
    }

    /**
     * 手術点数を返します。
     *
     * @return 手術点数
     */
    public int get手術点数() {
        return entity.getShujutsuTensu();
    }

    /**
     * 麻酔点数を返します。
     *
     * @return 麻酔点数
     */
    public int get麻酔点数() {
        return entity.getMasuiTensu();
    }

    /**
     * 放射線治療点数を返します。
     *
     * @return 放射線治療点数
     */
    public int get放射線治療点数() {
        return entity.getHoshasenChiryoTensu();
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
     * 緊急時施設療養費合計点数を返します。
     *
     * @return 緊急時施設療養費合計点数
     */
    public int get緊急時施設療養費合計点数() {
        return entity.getKinkyuShisetsuRyoyohiTotalTensu();
    }

    /**
     * 所定疾患施設療養費傷病名１を返します。
     *
     * @return 所定疾患施設療養費傷病名１
     */
    public RString get所定疾患施設療養費傷病名１() {
        return entity.getShoteiShikkanShisetsuRyoyohiShobyoName1();
    }

    /**
     * 所定疾患施設療養費傷病名２を返します。
     *
     * @return 所定疾患施設療養費傷病名２
     */
    public RString get所定疾患施設療養費傷病名２() {
        return entity.getShoteiShikkanShisetsuRyoyohiShobyoName2();
    }

    /**
     * 所定疾患施設療養費傷病名３を返します。
     *
     * @return 所定疾患施設療養費傷病名３
     */
    public RString get所定疾患施設療養費傷病名３() {
        return entity.getShoteiShikkanShisetsuRyoyohiShobyoName3();
    }

    /**
     * 所定疾患施設療養費開始年月日１を返します。
     *
     * @return 所定疾患施設療養費開始年月日１
     */
    public FlexibleDate get所定疾患施設療養費開始年月日１() {
        return entity.getShoteiShikkanShisetsuRyoyohiKaishiYMD1();
    }

    /**
     * 所定疾患施設療養費開始年月日２を返します。
     *
     * @return 所定疾患施設療養費開始年月日２
     */
    public FlexibleDate get所定疾患施設療養費開始年月日２() {
        return entity.getShoteiShikkanShisetsuRyoyohiKaishiYMD2();
    }

    /**
     * 所定疾患施設療養費開始年月日３を返します。
     *
     * @return 所定疾患施設療養費開始年月日３
     */
    public FlexibleDate get所定疾患施設療養費開始年月日３() {
        return entity.getShoteiShikkanShisetsuRyoyohiKaishiYMD3();
    }

    /**
     * 所定疾患施設療養費単位数を返します。
     *
     * @return 所定疾患施設療養費単位数
     */
    public int get所定疾患施設療養費単位数() {
        return entity.getShoteiShikkanShisetsuRyoyohiTanisu();
    }

    /**
     * 所定疾患施設療養費日数を返します。
     *
     * @return 所定疾患施設療養費日数
     */
    public int get所定疾患施設療養費日数() {
        return entity.getShoteiShikkanShisetsuRyoyohiNissu();
    }

    /**
     * 所定疾患施設療養費小計を返します。
     *
     * @return 所定疾患施設療養費小計
     */
    public int get所定疾患施設療養費小計() {
        return entity.getShoteiShikkanShisetsuRyoyohiSubTotal();
    }

    /**
     * 後_往診日数を返します。
     *
     * @return 後_往診日数
     */
    public int get後_往診日数() {
        return entity.getAtoOshinNissu();
    }

    /**
     * 後_通院日数を返します。
     *
     * @return 後_通院日数
     */
    public int get後_通院日数() {
        return entity.getAtoTsuinNissu();
    }

    /**
     * 後_緊急時治療管理単位数を返します。
     *
     * @return 後_緊急時治療管理単位数
     */
    public int get後_緊急時治療管理単位数() {
        return entity.getAtoKinkyuChiryoKanriTanisu();
    }

    /**
     * 後_緊急時治療管理日数を返します。
     *
     * @return 後_緊急時治療管理日数
     */
    public int get後_緊急時治療管理日数() {
        return entity.getAtoKinkyuChiryoKanriNissu();
    }

    /**
     * 後_リハビリテーション点数を返します。
     *
     * @return 後_リハビリテーション点数
     */
    public int get後_リハビリテーション点数() {
        return entity.getAtoRehabilitationTensu();
    }

    /**
     * 後_処置点数を返します。
     *
     * @return 後_処置点数
     */
    public int get後_処置点数() {
        return entity.getAtoShochiTensu();
    }

    /**
     * 後_手術点数を返します。
     *
     * @return 後_手術点数
     */
    public int get後_手術点数() {
        return entity.getAtoShujutsuTensu();
    }

    /**
     * 後_麻酔点数を返します。
     *
     * @return 後_麻酔点数
     */
    public int get後_麻酔点数() {
        return entity.getAtoMasuiTensu();
    }

    /**
     * 後_放射線治療点数を返します。
     *
     * @return 後_放射線治療点数
     */
    public int get後_放射線治療点数() {
        return entity.getAtoHoshasenChiryoTensu();
    }

    /**
     * 後_所定疾患施設療養費単位数を返します。
     *
     * @return 後_所定疾患施設療養費単位数
     */
    public int get後_所定疾患施設療養費単位数() {
        return entity.getAtoShoteiShikkanShisetsuRyoyoHiTanisu();
    }

    /**
     * 後_所定疾患施設療養費日数を返します。
     *
     * @return 後_所定疾患施設療養費日数
     */
    public int get後_所定疾患施設療養費日数() {
        return entity.getAtoShoteiShikkanShisetsuRyoyoHiNissu();
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
     * 緊急時施設療養情報レコード順次番号を設定します。
     *
     * @param 緊急時施設療養情報レコード順次番号 緊急時施設療養情報レコード順次番号
     */
    public void set緊急時施設療養情報レコード順次番号(RString 緊急時施設療養情報レコード順次番号) {
        requireNonNull(緊急時施設療養情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養情報レコード順次番号"));
        entity.setRecodeJunjiNo(緊急時施設療養情報レコード順次番号);
    }

    /**
     * 緊急時傷病名１を設定します。
     *
     * @param 緊急時傷病名１ 緊急時傷病名１
     */
    public void set緊急時傷病名１(RString 緊急時傷病名１) {
        requireNonNull(緊急時傷病名１, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名１"));
        entity.setKinkyuShobyoName1(緊急時傷病名１);
    }

    /**
     * 緊急時傷病名２を設定します。
     *
     * @param 緊急時傷病名２ 緊急時傷病名２
     */
    public void set緊急時傷病名２(RString 緊急時傷病名２) {
        requireNonNull(緊急時傷病名２, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名２"));
        entity.setKinkyuShobyoName2(緊急時傷病名２);
    }

    /**
     * 緊急時傷病名３を設定します。
     *
     * @param 緊急時傷病名３ 緊急時傷病名３
     */
    public void set緊急時傷病名３(RString 緊急時傷病名３) {
        requireNonNull(緊急時傷病名３, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時傷病名３"));
        entity.setKinkyuShobyoName3(緊急時傷病名３);
    }

    /**
     * 緊急時治療開始年月日１を設定します。
     *
     * @param 緊急時治療開始年月日１ 緊急時治療開始年月日１
     */
    public void set緊急時治療開始年月日１(FlexibleDate 緊急時治療開始年月日１) {
        requireNonNull(緊急時治療開始年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日１"));
        entity.setKinkyuChiryoKaishiYMD1(緊急時治療開始年月日１);
    }

    /**
     * 緊急時治療開始年月日２を設定します。
     *
     * @param 緊急時治療開始年月日２ 緊急時治療開始年月日２
     */
    public void set緊急時治療開始年月日２(FlexibleDate 緊急時治療開始年月日２) {
        requireNonNull(緊急時治療開始年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日２"));
        entity.setKinkyuChiryoKaishiYMD2(緊急時治療開始年月日２);
    }

    /**
     * 緊急時治療開始年月日３を設定します。
     *
     * @param 緊急時治療開始年月日３ 緊急時治療開始年月日３
     */
    public void set緊急時治療開始年月日３(FlexibleDate 緊急時治療開始年月日３) {
        requireNonNull(緊急時治療開始年月日３, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療開始年月日３"));
        entity.setKinkyuChiryoKaishiYMD3(緊急時治療開始年月日３);
    }

    /**
     * 往診日数を設定します。
     *
     * @param 往診日数 往診日数
     */
    public void set往診日数(int 往診日数) {
        requireNonNull(往診日数, UrSystemErrorMessages.値がnull.getReplacedMessage("往診日数"));
        entity.setOshinNissu(往診日数);
    }

    /**
     * 往診医療機関名を設定します。
     *
     * @param 往診医療機関名 往診医療機関名
     */
    public void set往診医療機関名(RString 往診医療機関名) {
        requireNonNull(往診医療機関名, UrSystemErrorMessages.値がnull.getReplacedMessage("往診医療機関名"));
        entity.setOshinIryoKikanName(往診医療機関名);
    }

    /**
     * 通院日数を設定します。
     *
     * @param 通院日数 通院日数
     */
    public void set通院日数(int 通院日数) {
        requireNonNull(通院日数, UrSystemErrorMessages.値がnull.getReplacedMessage("通院日数"));
        entity.setTsuinNissu(通院日数);
    }

    /**
     * 通院医療機関名を設定します。
     *
     * @param 通院医療機関名 通院医療機関名
     */
    public void set通院医療機関名(RString 通院医療機関名) {
        requireNonNull(通院医療機関名, UrSystemErrorMessages.値がnull.getReplacedMessage("通院医療機関名"));
        entity.setTsuinIryoKikanName(通院医療機関名);
    }

    /**
     * 緊急時治療管理単位数を設定します。
     *
     * @param 緊急時治療管理単位数 緊急時治療管理単位数
     */
    public void set緊急時治療管理単位数(int 緊急時治療管理単位数) {
        requireNonNull(緊急時治療管理単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理単位数"));
        entity.setKinkyuChiryoKanriTanisu(緊急時治療管理単位数);
    }

    /**
     * 緊急時治療管理日数を設定します。
     *
     * @param 緊急時治療管理日数 緊急時治療管理日数
     */
    public void set緊急時治療管理日数(int 緊急時治療管理日数) {
        requireNonNull(緊急時治療管理日数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理日数"));
        entity.setKinkyuChiryoKanriNissu(緊急時治療管理日数);
    }

    /**
     * 緊急時治療管理小計を設定します。
     *
     * @param 緊急時治療管理小計 緊急時治療管理小計
     */
    public void set緊急時治療管理小計(int 緊急時治療管理小計) {
        requireNonNull(緊急時治療管理小計, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理小計"));
        entity.setKinkyuChiryoKanriSubTotal(緊急時治療管理小計);
    }

    /**
     * リハビリテーション点数を設定します。
     *
     * @param リハビリテーション点数 リハビリテーション点数
     */
    public void setリハビリテーション点数(int リハビリテーション点数) {
        requireNonNull(リハビリテーション点数, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション点数"));
        entity.setRehabilitationTensu(リハビリテーション点数);
    }

    /**
     * 処置点数を設定します。
     *
     * @param 処置点数 処置点数
     */
    public void set処置点数(int 処置点数) {
        requireNonNull(処置点数, UrSystemErrorMessages.値がnull.getReplacedMessage("処置点数"));
        entity.setShochiTensu(処置点数);
    }

    /**
     * 手術点数を設定します。
     *
     * @param 手術点数 手術点数
     */
    public void set手術点数(int 手術点数) {
        requireNonNull(手術点数, UrSystemErrorMessages.値がnull.getReplacedMessage("手術点数"));
        entity.setShujutsuTensu(手術点数);
    }

    /**
     * 麻酔点数を設定します。
     *
     * @param 麻酔点数 麻酔点数
     */
    public void set麻酔点数(int 麻酔点数) {
        requireNonNull(麻酔点数, UrSystemErrorMessages.値がnull.getReplacedMessage("麻酔点数"));
        entity.setMasuiTensu(麻酔点数);
    }

    /**
     * 放射線治療点数を設定します。
     *
     * @param 放射線治療点数 放射線治療点数
     */
    public void set放射線治療点数(int 放射線治療点数) {
        requireNonNull(放射線治療点数, UrSystemErrorMessages.値がnull.getReplacedMessage("放射線治療点数"));
        entity.setHoshasenChiryoTensu(放射線治療点数);
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
     * 緊急時施設療養費合計点数を設定します。
     *
     * @param 緊急時施設療養費合計点数 緊急時施設療養費合計点数
     */
    public void set緊急時施設療養費合計点数(int 緊急時施設療養費合計点数) {
        requireNonNull(緊急時施設療養費合計点数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養費合計点数"));
        entity.setKinkyuShisetsuRyoyohiTotalTensu(緊急時施設療養費合計点数);
    }

    /**
     * 所定疾患施設療養費傷病名１を設定します。
     *
     * @param 所定疾患施設療養費傷病名１ 所定疾患施設療養費傷病名１
     */
    public void set所定疾患施設療養費傷病名１(RString 所定疾患施設療養費傷病名１) {
        requireNonNull(所定疾患施設療養費傷病名１, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費傷病名１"));
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName1(所定疾患施設療養費傷病名１);
    }

    /**
     * 所定疾患施設療養費傷病名２を設定します。
     *
     * @param 所定疾患施設療養費傷病名２ 所定疾患施設療養費傷病名２
     */
    public void set所定疾患施設療養費傷病名２(RString 所定疾患施設療養費傷病名２) {
        requireNonNull(所定疾患施設療養費傷病名２, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費傷病名２"));
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName2(所定疾患施設療養費傷病名２);
    }

    /**
     * 所定疾患施設療養費傷病名３を設定します。
     *
     * @param 所定疾患施設療養費傷病名３ 所定疾患施設療養費傷病名３
     */
    public void set所定疾患施設療養費傷病名３(RString 所定疾患施設療養費傷病名３) {
        requireNonNull(所定疾患施設療養費傷病名３, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費傷病名３"));
        entity.setShoteiShikkanShisetsuRyoyohiShobyoName3(所定疾患施設療養費傷病名３);
    }

    /**
     * 所定疾患施設療養費開始年月日１を設定します。
     *
     * @param 所定疾患施設療養費開始年月日１ 所定疾患施設療養費開始年月日１
     */
    public void set所定疾患施設療養費開始年月日１(FlexibleDate 所定疾患施設療養費開始年月日１) {
        requireNonNull(所定疾患施設療養費開始年月日１, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費開始年月日１"));
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD1(所定疾患施設療養費開始年月日１);
    }

    /**
     * 所定疾患施設療養費開始年月日２を設定します。
     *
     * @param 所定疾患施設療養費開始年月日２ 所定疾患施設療養費開始年月日２
     */
    public void set所定疾患施設療養費開始年月日２(FlexibleDate 所定疾患施設療養費開始年月日２) {
        requireNonNull(所定疾患施設療養費開始年月日２, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費開始年月日２"));
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD2(所定疾患施設療養費開始年月日２);
    }

    /**
     * 所定疾患施設療養費開始年月日３を設定します。
     *
     * @param 所定疾患施設療養費開始年月日３ 所定疾患施設療養費開始年月日３
     */
    public void set所定疾患施設療養費開始年月日３(FlexibleDate 所定疾患施設療養費開始年月日３) {
        requireNonNull(所定疾患施設療養費開始年月日３, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費開始年月日３"));
        entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD3(所定疾患施設療養費開始年月日３);
    }

    /**
     * 所定疾患施設療養費単位数を設定します。
     *
     * @param 所定疾患施設療養費単位数 所定疾患施設療養費単位数
     */
    public void set所定疾患施設療養費単位数(int 所定疾患施設療養費単位数) {
        requireNonNull(所定疾患施設療養費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費単位数"));
        entity.setShoteiShikkanShisetsuRyoyohiTanisu(所定疾患施設療養費単位数);
    }

    /**
     * 所定疾患施設療養費日数を設定します。
     *
     * @param 所定疾患施設療養費日数 所定疾患施設療養費日数
     */
    public void set所定疾患施設療養費日数(int 所定疾患施設療養費日数) {
        requireNonNull(所定疾患施設療養費日数, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費日数"));
        entity.setShoteiShikkanShisetsuRyoyohiNissu(所定疾患施設療養費日数);
    }

    /**
     * 所定疾患施設療養費小計を設定します。
     *
     * @param 所定疾患施設療養費小計 所定疾患施設療養費小計
     */
    public void set所定疾患施設療養費小計(int 所定疾患施設療養費小計) {
        requireNonNull(所定疾患施設療養費小計, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費小計"));
        entity.setShoteiShikkanShisetsuRyoyohiSubTotal(所定疾患施設療養費小計);
    }

    /**
     * 後_往診日数を設定します。
     *
     * @param 後_往診日数 後_往診日数
     */
    public void set後_往診日数(int 後_往診日数) {
        requireNonNull(後_往診日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_往診日数"));
        entity.setAtoOshinNissu(後_往診日数);
    }

    /**
     * 後_通院日数を設定します。
     *
     * @param 後_通院日数 後_通院日数
     */
    public void set後_通院日数(int 後_通院日数) {
        requireNonNull(後_通院日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_通院日数"));
        entity.setAtoTsuinNissu(後_通院日数);
    }

    /**
     * 後_緊急時治療管理単位数を設定します。
     *
     * @param 後_緊急時治療管理単位数 後_緊急時治療管理単位数
     */
    public void set後_緊急時治療管理単位数(int 後_緊急時治療管理単位数) {
        requireNonNull(後_緊急時治療管理単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_緊急時治療管理単位数"));
        entity.setAtoKinkyuChiryoKanriTanisu(後_緊急時治療管理単位数);
    }

    /**
     * 後_緊急時治療管理日数を設定します。
     *
     * @param 後_緊急時治療管理日数 後_緊急時治療管理日数
     */
    public void set後_緊急時治療管理日数(int 後_緊急時治療管理日数) {
        requireNonNull(後_緊急時治療管理日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_緊急時治療管理日数"));
        entity.setAtoKinkyuChiryoKanriNissu(後_緊急時治療管理日数);
    }

    /**
     * 後_リハビリテーション点数を設定します。
     *
     * @param 後_リハビリテーション点数 後_リハビリテーション点数
     */
    public void set後_リハビリテーション点数(int 後_リハビリテーション点数) {
        requireNonNull(後_リハビリテーション点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_リハビリテーション点数"));
        entity.setAtoRehabilitationTensu(後_リハビリテーション点数);
    }

    /**
     * 後_処置点数を設定します。
     *
     * @param 後_処置点数 後_処置点数
     */
    public void set後_処置点数(int 後_処置点数) {
        requireNonNull(後_処置点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_処置点数"));
        entity.setAtoShochiTensu(後_処置点数);
    }

    /**
     * 後_手術点数を設定します。
     *
     * @param 後_手術点数 後_手術点数
     */
    public void set後_手術点数(int 後_手術点数) {
        requireNonNull(後_手術点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_手術点数"));
        entity.setAtoShujutsuTensu(後_手術点数);
    }

    /**
     * 後_麻酔点数を設定します。
     *
     * @param 後_麻酔点数 後_麻酔点数
     */
    public void set後_麻酔点数(int 後_麻酔点数) {
        requireNonNull(後_麻酔点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_麻酔点数"));
        entity.setAtoMasuiTensu(後_麻酔点数);
    }

    /**
     * 後_放射線治療点数を設定します。
     *
     * @param 後_放射線治療点数 後_放射線治療点数
     */
    public void set後_放射線治療点数(int 後_放射線治療点数) {
        requireNonNull(後_放射線治療点数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_放射線治療点数"));
        entity.setAtoHoshasenChiryoTensu(後_放射線治療点数);
    }

    /**
     * 後_所定疾患施設療養費単位数を設定します。
     *
     * @param 後_所定疾患施設療養費単位数 後_所定疾患施設療養費単位数
     */
    public void set後_所定疾患施設療養費単位数(int 後_所定疾患施設療養費単位数) {
        requireNonNull(後_所定疾患施設療養費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_所定疾患施設療養費単位数"));
        entity.setAtoShoteiShikkanShisetsuRyoyoHiTanisu(後_所定疾患施設療養費単位数);
    }

    /**
     * 後_所定疾患施設療養費日数を設定します。
     *
     * @param 後_所定疾患施設療養費日数 後_所定疾患施設療養費日数
     */
    public void set後_所定疾患施設療養費日数(int 後_所定疾患施設療養費日数) {
        requireNonNull(後_所定疾患施設療養費日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_所定疾患施設療養費日数"));
        entity.setAtoShoteiShikkanShisetsuRyoyoHiNissu(後_所定疾患施設療養費日数);
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
