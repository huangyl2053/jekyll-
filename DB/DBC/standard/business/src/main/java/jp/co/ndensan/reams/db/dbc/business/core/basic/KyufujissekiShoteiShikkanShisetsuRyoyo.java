/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績所定疾患施設療養費等を管理するクラスです。
 */
public class KyufujissekiShoteiShikkanShisetsuRyoyo 
extends ModelBase<KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier, 
        DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity, 
        KyufujissekiShoteiShikkanShisetsuRyoyo> implements Serializable {

    private final DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity;
    private final KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績所定疾患施設療養費等の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     * @param 緊急時施設療養情報レコード順次番号 緊急時施設療養情報レコード順次番号
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyo(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 緊急時施設療養情報レコード順次番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(緊急時施設療養情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養情報レコード順次番号"));
        this.entity = new DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.entity.setRecodeJunjiNo(緊急時施設療養情報レコード順次番号);
        this.id = new KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号,
                緊急時施設療養情報レコード順次番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}より{@link KyufujissekiShoteiShikkanShisetsuRyoyo}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyo(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績所定疾患施設療養費等"));
        this.id = new KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getRecodeJunjiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}
     * @param id {@link KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier}
     */
    KyufujissekiShoteiShikkanShisetsuRyoyo(
            DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity,
            KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
    public Decimal get往診日数() {
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
    public Decimal get通院日数() {
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
    public Decimal get緊急時治療管理日数() {
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
    public Decimal get所定疾患施設療養費日数() {
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
    public Decimal get後_往診日数() {
        return entity.getAtoOshinNissu();
    }

    /**
     * 後_通院日数を返します。
     *
     * @return 後_通院日数
     */
    public Decimal get後_通院日数() {
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
    public Decimal get後_緊急時治療管理日数() {
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
    public Decimal get後_所定疾患施設療養費日数() {
        return entity.getAtoShoteiShikkanShisetsuRyoyoHiNissu();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public Decimal get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public Decimal get過誤回数() {
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
     * {@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}のクローンを返します。
     *
     * @return {@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}のクローン
     */
    @Override
    public DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績所定疾患施設療養費等の識別子{@link KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier}を返します。
     *
     * @return
     * 給付実績所定疾患施設療養費等の識別子{@link KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier}
     */
    @Override
    public KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績所定疾患施設療養費等を削除対象とします。<br/>
     * {@link DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiShoteiShikkanShisetsuRyoyo}
     */
    @Override
    public KyufujissekiShoteiShikkanShisetsuRyoyo deleted() {
        DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiShoteiShikkanShisetsuRyoyo(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiShoteiShikkanShisetsuRyoyo}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiShoteiShikkanShisetsuRyoyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity;
        private final KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier id;

        private _SerializationProxy(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity, KyufujissekiShoteiShikkanShisetsuRyoyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiShoteiShikkanShisetsuRyoyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiShoteiShikkanShisetsuRyoyoBuilder createBuilderForEdit() {
        return new KyufujissekiShoteiShikkanShisetsuRyoyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
