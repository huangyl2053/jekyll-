package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者異動送付テーブルのエンティティクラスです。
 */
public class DbT3001JukyushaIdoRenrakuhyoEntity extends DbTableEntityBase<DbT3001JukyushaIdoRenrakuhyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3001JukyushaIdoRenrakuhyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString idoKubunCode;
    @PrimaryKey
    private RString jukyushaIdoJiyu;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString hiHokenshaNameKana;
    private FlexibleDate umareYMD;
    private RString seibetsuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString rojinHokenShichosonNo;
    private RString rojinHokenJukyushaNo;
    private RString kohiFutanshaNo;
    private HokenshaNo koikiRengoHokenshaNo;
    private RString shinseiShubetsuCode;
    private RString henkoShinseichuKubunCode;
    private FlexibleDate shinseiYMD;
    private RString minashiYokaigoJotaiKubunCode;
    private RString yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikankaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private RString kyotakuServiceSakuseiKubunCode;
    private JigyoshaNo kyotakuKaigoShienJigyoshoNo;
    private FlexibleDate kyotakuServiceTekiyoKaishiYMD;
    private FlexibleDate kyotakuServiceTekiyoShuryoYMD;
    private int homonTsushoServiceShikyuGendoKijungaku;
    private FlexibleDate homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    private FlexibleDate homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    private Decimal tankiNyushoServiceShikyuGendoKijungaku;
    private FlexibleDate tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    private FlexibleDate tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    private boolean kohiFutanJogenGengakuAriFlag;
    private FlexibleDate shokanbaraikaKaishiYMD;
    private FlexibleDate shokanbaraikaShuryoYMD;
    private FlexibleDate kyufuritsuHikisageKaishiYMD;
    private FlexibleDate kyufuritsuHikisageShuryoYMD;
    private RString gemmenShinseichuKubunCode;
    private RString riyoshaFutanKubunCode;
    private HokenKyufuRitsu kyufuritsu;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString hyojunFutanKubunCode;
    private int futangaku;
    private FlexibleDate futangakuTekiyoKaishiYMD;
    private FlexibleDate futangakuTekiyoShuryoYMD;
    private RString tokuteiNyushoshaNinteiShinseichuKubunCode;
    private RString tokuteiNyushoshaKaigoServiceKubunCode;
    private boolean kaizeisoTokureiGengakuSochiTaishoFlag;
    private Decimal shokuhiFutanGendogaku;
    private Decimal kyojuhiUnitGataKoshitsuFutanGendogaku;
    private Decimal kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    private Decimal kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    private Decimal kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    private Decimal kyujuhiTashoshitsuFutanGendogaku;
    private FlexibleDate futanGendogakuTekiyoKaishiYMD;
    private FlexibleDate futanGendogakuTekiyoShuryoYMD;
    private Decimal keigenritsu;
    private FlexibleDate keigenritsuTekiyoKaishiYMD;
    private FlexibleDate keigenritsuTekiyoShuryoYMD;
    private boolean shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    private RString kokiKoureiIryoHokenshaNo;
    private RString kokikoureiIryoHiHokenshaNo;
    private RString kokuhoHokenshaNo;
    private RString kokuhoHiHokenshaNo;
    private RString kokuhoKojinNo;
    private RString nijiyoboJigyoKubunCode;
    private FlexibleDate nijiyoboJigyoYukoKikanKaishiYMD;
    private FlexibleDate nijiyoboJigyoYukoKikanShuryoYMD;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;
    private RString jushochiTokureiTaishoshaKubunCode;
    private RString shisetsuShozaiHokenjaNo;
    private FlexibleDate jushochiTokureiTekiyoKaishiYMD;
    private FlexibleDate jushochiTokureiTekiyoShuryoYMD;
    private Decimal kyotakuhiShin1FutanGendogaku;
    private Decimal kyotakuhiShin2FutanGendogaku;
    private Decimal kyotakuhiShin3FutanGendogaku;
    private FlexibleDate riyosyaFutanWariaiYukoKaishiYMD;
    private FlexibleDate riyosyaFutanWariaiYukoShuryoYMD;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 異動年月日のgetメソッドです。
     *
     * @return 異動年月日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動年月日のsetメソッドです。
     *
     * @param idoYMD 異動年月日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 異動区分コードのgetメソッドです。
     * <br/>
     * <br/>1:新規,2:変更,3:終了
     *
     * @return 異動区分コード
     */
    public RString getIdoKubunCode() {
        return idoKubunCode;
    }

    /**
     * 異動区分コードのsetメソッドです。
     * <br/>
     * <br/>1:新規,2:変更,3:終了
     *
     * @param idoKubunCode 異動区分コード
     */
    public void setIdoKubunCode(RString idoKubunCode) {
        this.idoKubunCode = idoKubunCode;
    }

    /**
     * 受給者異動事由のgetメソッドです。
     * <br/>
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     *
     * @return 受給者異動事由
     */
    public RString getJukyushaIdoJiyu() {
        return jukyushaIdoJiyu;
    }

    /**
     * 受給者異動事由のsetメソッドです。
     * <br/>
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     *
     * @param jukyushaIdoJiyu 受給者異動事由
     */
    public void setJukyushaIdoJiyu(RString jukyushaIdoJiyu) {
        this.jukyushaIdoJiyu = jukyushaIdoJiyu;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 被保険者氏名カナのgetメソッドです。
     *
     * @return 被保険者氏名カナ
     */
    public RString getHiHokenshaNameKana() {
        return hiHokenshaNameKana;
    }

    /**
     * 被保険者氏名カナのsetメソッドです。
     *
     * @param hiHokenshaNameKana 被保険者氏名カナ
     */
    public void setHiHokenshaNameKana(RString hiHokenshaNameKana) {
        this.hiHokenshaNameKana = hiHokenshaNameKana;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     *
     * @param umareYMD 生年月日
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * 性別コードのsetメソッドです。
     *
     * @param seibetsuCode 性別コード
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * 資格取得年月日のgetメソッドです。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得年月日のsetメソッドです。
     *
     * @param shikakuShutokuYMD 資格取得年月日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格喪失年月日のgetメソッドです。
     * <br/>
     * <br/>資格喪失者のみ設定
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失年月日のsetメソッドです。
     * <br/>
     * <br/>資格喪失者のみ設定
     *
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 老人保健市町村番号のgetメソッドです。
     * <br/>
     * <br/>老人保健受給者のみ設定
     *
     * @return 老人保健市町村番号
     */
    public RString getRojinHokenShichosonNo() {
        return rojinHokenShichosonNo;
    }

    /**
     * 老人保健市町村番号のsetメソッドです。
     * <br/>
     * <br/>老人保健受給者のみ設定
     *
     * @param rojinHokenShichosonNo 老人保健市町村番号
     */
    public void setRojinHokenShichosonNo(RString rojinHokenShichosonNo) {
        this.rojinHokenShichosonNo = rojinHokenShichosonNo;
    }

    /**
     * 老人保健受給者番号のgetメソッドです。
     * <br/>
     * <br/>老人保健受給者のみ設定
     *
     * @return 老人保健受給者番号
     */
    public RString getRojinHokenJukyushaNo() {
        return rojinHokenJukyushaNo;
    }

    /**
     * 老人保健受給者番号のsetメソッドです。
     * <br/>
     * <br/>老人保健受給者のみ設定
     *
     * @param rojinHokenJukyushaNo 老人保健受給者番号
     */
    public void setRojinHokenJukyushaNo(RString rojinHokenJukyushaNo) {
        this.rojinHokenJukyushaNo = rojinHokenJukyushaNo;
    }

    /**
     * 公費負担者番号のgetメソッドです。
     * <br/>
     * <br/>福祉事務所からの異動情報提出時のみ設定
     *
     * @return 公費負担者番号
     */
    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    /**
     * 公費負担者番号のsetメソッドです。
     * <br/>
     * <br/>福祉事務所からの異動情報提出時のみ設定
     *
     * @param kohiFutanshaNo 公費負担者番号
     */
    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    /**
     * 広域連合（政令市）保険者番号のgetメソッドです。
     * <br/>
     * <br/>広域連合または政令市の場合のみ広域連合または政令市の保険者番号を設定
     *
     * @return 広域連合（政令市）保険者番号
     */
    public HokenshaNo getKoikiRengoHokenshaNo() {
        return koikiRengoHokenshaNo;
    }

    /**
     * 広域連合（政令市）保険者番号のsetメソッドです。
     * <br/>
     * <br/>広域連合または政令市の場合のみ広域連合または政令市の保険者番号を設定
     *
     * @param koikiRengoHokenshaNo 広域連合（政令市）保険者番号
     */
    public void setKoikiRengoHokenshaNo(HokenshaNo koikiRengoHokenshaNo) {
        this.koikiRengoHokenshaNo = koikiRengoHokenshaNo;
    }

    /**
     * 申請種別コードのgetメソッドです。
     * <br/>
     * <br/>1:新規申請,2:更新申請,3:変更申請,4:職権
     *
     * @return 申請種別コード
     */
    public RString getShinseiShubetsuCode() {
        return shinseiShubetsuCode;
    }

    /**
     * 申請種別コードのsetメソッドです。
     * <br/>
     * <br/>1:新規申請,2:更新申請,3:変更申請,4:職権
     *
     * @param shinseiShubetsuCode 申請種別コード
     */
    public void setShinseiShubetsuCode(RString shinseiShubetsuCode) {
        this.shinseiShubetsuCode = shinseiShubetsuCode;
    }

    /**
     * 変更申請中区分コードのgetメソッドです。
     * <br/>
     * <br/>1:申請無し,2:申請中,3:決定済み
     *
     * @return 変更申請中区分コード
     */
    public RString getHenkoShinseichuKubunCode() {
        return henkoShinseichuKubunCode;
    }

    /**
     * 変更申請中区分コードのsetメソッドです。
     * <br/>
     * <br/>1:申請無し,2:申請中,3:決定済み
     *
     * @param henkoShinseichuKubunCode 変更申請中区分コード
     */
    public void setHenkoShinseichuKubunCode(RString henkoShinseichuKubunCode) {
        this.henkoShinseichuKubunCode = henkoShinseichuKubunCode;
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * みなし要介護状態区分コードのgetメソッドです。
     * <br/>
     * <br/>1:通常の認定,2:みなし認定,3:やむを得ない事由
     *
     * @return みなし要介護状態区分コード
     */
    public RString getMinashiYokaigoJotaiKubunCode() {
        return minashiYokaigoJotaiKubunCode;
    }

    /**
     * みなし要介護状態区分コードのsetメソッドです。
     * <br/>
     * <br/>1:通常の認定,2:みなし認定,3:やむを得ない事由
     *
     * @param minashiYokaigoJotaiKubunCode みなし要介護状態区分コード
     */
    public void setMinashiYokaigoJotaiKubunCode(RString minashiYokaigoJotaiKubunCode) {
        this.minashiYokaigoJotaiKubunCode = minashiYokaigoJotaiKubunCode;
    }

    /**
     * 要介護状態区分コードのgetメソッドです。
     * <br/>
     * <br/>01:非該当,11:要支援（経過的要介護）,12:要支援１,13:要支援２,21:要介護１,22:要介護２,23:要介護３,24:要介護４,25:要介護５
     *
     * @return 要介護状態区分コード
     */
    public RString getYokaigoJotaiKubunCode() {
        return yokaigoJotaiKubunCode;
    }

    /**
     * 要介護状態区分コードのsetメソッドです。
     * <br/>
     * <br/>01:非該当,11:要支援（経過的要介護）,12:要支援１,13:要支援２,21:要介護１,22:要介護２,23:要介護３,24:要介護４,25:要介護５
     *
     * @param yokaigoJotaiKubunCode 要介護状態区分コード
     */
    public void setYokaigoJotaiKubunCode(RString yokaigoJotaiKubunCode) {
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
    }

    /**
     * 認定有効期間開始年月日のgetメソッドです。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate getNinteiYukoKikankaishiYMD() {
        return ninteiYukoKikankaishiYMD;
    }

    /**
     * 認定有効期間開始年月日のsetメソッドです。
     *
     * @param ninteiYukoKikankaishiYMD 認定有効期間開始年月日
     */
    public void setNinteiYukoKikankaishiYMD(FlexibleDate ninteiYukoKikankaishiYMD) {
        this.ninteiYukoKikankaishiYMD = ninteiYukoKikankaishiYMD;
    }

    /**
     * 認定有効期間終了年月日のgetメソッドです。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        return ninteiYukoKikanShuryoYMD;
    }

    /**
     * 認定有効期間終了年月日のsetメソッドです。
     *
     * @param ninteiYukoKikanShuryoYMD 認定有効期間終了年月日
     */
    public void setNinteiYukoKikanShuryoYMD(FlexibleDate ninteiYukoKikanShuryoYMD) {
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
    }

    /**
     * 居宅サービス計画作成区分コードのgetメソッドです。
     * <br/>
     * <br/>1:居宅介護支援事業所作成,2:自己作成,3:介護予防支援事業所作成
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString getKyotakuServiceSakuseiKubunCode() {
        return kyotakuServiceSakuseiKubunCode;
    }

    /**
     * 居宅サービス計画作成区分コードのsetメソッドです。
     * <br/>
     * <br/>1:居宅介護支援事業所作成,2:自己作成,3:介護予防支援事業所作成
     *
     * @param kyotakuServiceSakuseiKubunCode 居宅サービス計画作成区分コード
     */
    public void setKyotakuServiceSakuseiKubunCode(RString kyotakuServiceSakuseiKubunCode) {
        this.kyotakuServiceSakuseiKubunCode = kyotakuServiceSakuseiKubunCode;
    }

    /**
     * 居宅介護支援事業所番号のgetメソッドです。
     * <br/>
     * <br/>居宅サービス計画作成区分コードが「2:自己作成」である場合、設定不要
     *
     * @return 居宅介護支援事業所番号
     */
    public JigyoshaNo getKyotakuKaigoShienJigyoshoNo() {
        return kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * 居宅介護支援事業所番号のsetメソッドです。
     * <br/>
     * <br/>居宅サービス計画作成区分コードが「2:自己作成」である場合、設定不要
     *
     * @param kyotakuKaigoShienJigyoshoNo 居宅介護支援事業所番号
     */
    public void setKyotakuKaigoShienJigyoshoNo(JigyoshaNo kyotakuKaigoShienJigyoshoNo) {
        this.kyotakuKaigoShienJigyoshoNo = kyotakuKaigoShienJigyoshoNo;
    }

    /**
     * 居宅サービス計画適用開始年月日のgetメソッドです。
     *
     * @return 居宅サービス計画適用開始年月日
     */
    public FlexibleDate getKyotakuServiceTekiyoKaishiYMD() {
        return kyotakuServiceTekiyoKaishiYMD;
    }

    /**
     * 居宅サービス計画適用開始年月日のsetメソッドです。
     *
     * @param kyotakuServiceTekiyoKaishiYMD 居宅サービス計画適用開始年月日
     */
    public void setKyotakuServiceTekiyoKaishiYMD(FlexibleDate kyotakuServiceTekiyoKaishiYMD) {
        this.kyotakuServiceTekiyoKaishiYMD = kyotakuServiceTekiyoKaishiYMD;
    }

    /**
     * 居宅サービス計画適用終了年月日のgetメソッドです。
     *
     * @return 居宅サービス計画適用終了年月日
     */
    public FlexibleDate getKyotakuServiceTekiyoShuryoYMD() {
        return kyotakuServiceTekiyoShuryoYMD;
    }

    /**
     * 居宅サービス計画適用終了年月日のsetメソッドです。
     *
     * @param kyotakuServiceTekiyoShuryoYMD 居宅サービス計画適用終了年月日
     */
    public void setKyotakuServiceTekiyoShuryoYMD(FlexibleDate kyotakuServiceTekiyoShuryoYMD) {
        this.kyotakuServiceTekiyoShuryoYMD = kyotakuServiceTekiyoShuryoYMD;
    }

    /**
     * 訪問通所サービス支給限度基準額のgetメソッドです。
     *
     * @return 訪問通所サービス支給限度基準額
     */
    public int getHomonTsushoServiceShikyuGendoKijungaku() {
        return homonTsushoServiceShikyuGendoKijungaku;
    }

    /**
     * 訪問通所サービス支給限度基準額のsetメソッドです。
     *
     * @param homonTsushoServiceShikyuGendoKijungaku 訪問通所サービス支給限度基準額
     */
    public void setHomonTsushoServiceShikyuGendoKijungaku(int homonTsushoServiceShikyuGendoKijungaku) {
        this.homonTsushoServiceShikyuGendoKijungaku = homonTsushoServiceShikyuGendoKijungaku;
    }

    /**
     * 訪問通所サービス上限管理適用期間開始年月日のgetメソッドです。
     *
     * @return 訪問通所サービス上限管理適用期間開始年月日
     */
    public FlexibleDate getHomonTsushoServiceJogenKanriTekiyoKaishiYMD() {
        return homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * 訪問通所サービス上限管理適用期間開始年月日のsetメソッドです。
     *
     * @param homonTsushoServiceJogenKanriTekiyoKaishiYMD 訪問通所サービス上限管理適用期間開始年月日
     */
    public void setHomonTsushoServiceJogenKanriTekiyoKaishiYMD(FlexibleDate homonTsushoServiceJogenKanriTekiyoKaishiYMD) {
        this.homonTsushoServiceJogenKanriTekiyoKaishiYMD = homonTsushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * 訪問通所サービス上限管理適用期間終了年月日のgetメソッドです。
     *
     * @return 訪問通所サービス上限管理適用期間終了年月日
     */
    public FlexibleDate getHomonTsushoServiceJogenKanriTekiyoShuryoYMD() {
        return homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * 訪問通所サービス上限管理適用期間終了年月日のsetメソッドです。
     *
     * @param homonTsushoServiceJogenKanriTekiyoShuryoYMD 訪問通所サービス上限管理適用期間終了年月日
     */
    public void setHomonTsushoServiceJogenKanriTekiyoShuryoYMD(FlexibleDate homonTsushoServiceJogenKanriTekiyoShuryoYMD) {
        this.homonTsushoServiceJogenKanriTekiyoShuryoYMD = homonTsushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * 短期入所サービス支給限度基準額のgetメソッドです。
     *
     * @return 短期入所サービス支給限度基準額
     */
    public Decimal getTankiNyushoServiceShikyuGendoKijungaku() {
        return tankiNyushoServiceShikyuGendoKijungaku;
    }

    /**
     * 短期入所サービス支給限度基準額のsetメソッドです。
     *
     * @param tankiNyushoServiceShikyuGendoKijungaku 短期入所サービス支給限度基準額
     */
    public void setTankiNyushoServiceShikyuGendoKijungaku(Decimal tankiNyushoServiceShikyuGendoKijungaku) {
        this.tankiNyushoServiceShikyuGendoKijungaku = tankiNyushoServiceShikyuGendoKijungaku;
    }

    /**
     * 短期入所サービス上限管理適用期間開始年月日のgetメソッドです。
     *
     * @return 短期入所サービス上限管理適用期間開始年月日
     */
    public FlexibleDate getTankinyushoServiceJogenKanriTekiyoKaishiYMD() {
        return tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * 短期入所サービス上限管理適用期間開始年月日のsetメソッドです。
     *
     * @param tankinyushoServiceJogenKanriTekiyoKaishiYMD 短期入所サービス上限管理適用期間開始年月日
     */
    public void setTankinyushoServiceJogenKanriTekiyoKaishiYMD(FlexibleDate tankinyushoServiceJogenKanriTekiyoKaishiYMD) {
        this.tankinyushoServiceJogenKanriTekiyoKaishiYMD = tankinyushoServiceJogenKanriTekiyoKaishiYMD;
    }

    /**
     * 短期入所サービス上限管理適用期間終了年月日のgetメソッドです。
     *
     * @return 短期入所サービス上限管理適用期間終了年月日
     */
    public FlexibleDate getTankinyushoServiceJogenKanriTekiyoShuryoYMD() {
        return tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * 短期入所サービス上限管理適用期間終了年月日のsetメソッドです。
     *
     * @param tankinyushoServiceJogenKanriTekiyoShuryoYMD 短期入所サービス上限管理適用期間終了年月日
     */
    public void setTankinyushoServiceJogenKanriTekiyoShuryoYMD(FlexibleDate tankinyushoServiceJogenKanriTekiyoShuryoYMD) {
        this.tankinyushoServiceJogenKanriTekiyoShuryoYMD = tankinyushoServiceJogenKanriTekiyoShuryoYMD;
    }

    /**
     * 公費負担上限額減額有フラグのgetメソッドです。
     *
     * @return 公費負担上限額減額有フラグ
     */
    public boolean getKohiFutanJogenGengakuAriFlag() {
        return kohiFutanJogenGengakuAriFlag;
    }

    /**
     * 公費負担上限額減額有フラグのsetメソッドです。
     *
     * @param kohiFutanJogenGengakuAriFlag 公費負担上限額減額有フラグ
     */
    public void setKohiFutanJogenGengakuAriFlag(boolean kohiFutanJogenGengakuAriFlag) {
        this.kohiFutanJogenGengakuAriFlag = kohiFutanJogenGengakuAriFlag;
    }

    /**
     * 償還払化開始年月日のgetメソッドです。
     *
     * @return 償還払化開始年月日
     */
    public FlexibleDate getShokanbaraikaKaishiYMD() {
        return shokanbaraikaKaishiYMD;
    }

    /**
     * 償還払化開始年月日のsetメソッドです。
     *
     * @param shokanbaraikaKaishiYMD 償還払化開始年月日
     */
    public void setShokanbaraikaKaishiYMD(FlexibleDate shokanbaraikaKaishiYMD) {
        this.shokanbaraikaKaishiYMD = shokanbaraikaKaishiYMD;
    }

    /**
     * 償還払化終了年月日のgetメソッドです。
     *
     * @return 償還払化終了年月日
     */
    public FlexibleDate getShokanbaraikaShuryoYMD() {
        return shokanbaraikaShuryoYMD;
    }

    /**
     * 償還払化終了年月日のsetメソッドです。
     *
     * @param shokanbaraikaShuryoYMD 償還払化終了年月日
     */
    public void setShokanbaraikaShuryoYMD(FlexibleDate shokanbaraikaShuryoYMD) {
        this.shokanbaraikaShuryoYMD = shokanbaraikaShuryoYMD;
    }

    /**
     * 給付率引下げ開始年月日のgetメソッドです。
     *
     * @return 給付率引下げ開始年月日
     */
    public FlexibleDate getKyufuritsuHikisageKaishiYMD() {
        return kyufuritsuHikisageKaishiYMD;
    }

    /**
     * 給付率引下げ開始年月日のsetメソッドです。
     *
     * @param kyufuritsuHikisageKaishiYMD 給付率引下げ開始年月日
     */
    public void setKyufuritsuHikisageKaishiYMD(FlexibleDate kyufuritsuHikisageKaishiYMD) {
        this.kyufuritsuHikisageKaishiYMD = kyufuritsuHikisageKaishiYMD;
    }

    /**
     * 給付率引下げ終了年月日のgetメソッドです。
     *
     * @return 給付率引下げ終了年月日
     */
    public FlexibleDate getKyufuritsuHikisageShuryoYMD() {
        return kyufuritsuHikisageShuryoYMD;
    }

    /**
     * 給付率引下げ終了年月日のsetメソッドです。
     *
     * @param kyufuritsuHikisageShuryoYMD 給付率引下げ終了年月日
     */
    public void setKyufuritsuHikisageShuryoYMD(FlexibleDate kyufuritsuHikisageShuryoYMD) {
        this.kyufuritsuHikisageShuryoYMD = kyufuritsuHikisageShuryoYMD;
    }

    /**
     * 減免申請中区分コードのgetメソッドです。
     * <br/>
     * <br/>1:申請無し
     *
     * <br/>2:申請中
     *
     * <br/>3:決定済み
     *
     * @return 減免申請中区分コード
     */
    public RString getGemmenShinseichuKubunCode() {
        return gemmenShinseichuKubunCode;
    }

    /**
     * 減免申請中区分コードのsetメソッドです。
     * <br/>
     * <br/>1:申請無し
     *
     * <br/>2:申請中
     *
     * <br/>3:決定済み
     *
     * @param gemmenShinseichuKubunCode 減免申請中区分コード
     */
    public void setGemmenShinseichuKubunCode(RString gemmenShinseichuKubunCode) {
        this.gemmenShinseichuKubunCode = gemmenShinseichuKubunCode;
    }

    /**
     * 利用者負担区分コードのgetメソッドです。
     * <br/>
     * <br/>1:利用者負担,2:旧措置入所者利用者負担
     *
     * @return 利用者負担区分コード
     */
    public RString getRiyoshaFutanKubunCode() {
        return riyoshaFutanKubunCode;
    }

    /**
     * 利用者負担区分コードのsetメソッドです。
     * <br/>
     * <br/>1:利用者負担,2:旧措置入所者利用者負担
     *
     * @param riyoshaFutanKubunCode 利用者負担区分コード
     */
    public void setRiyoshaFutanKubunCode(RString riyoshaFutanKubunCode) {
        this.riyoshaFutanKubunCode = riyoshaFutanKubunCode;
    }

    /**
     * 給付率のgetメソッドです。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu getKyufuritsu() {
        return kyufuritsu;
    }

    /**
     * 給付率のsetメソッドです。
     *
     * @param kyufuritsu 給付率
     */
    public void setKyufuritsu(HokenKyufuRitsu kyufuritsu) {
        this.kyufuritsu = kyufuritsu;
    }

    /**
     * 適用開始年月日のgetメソッドです。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月日のsetメソッドです。
     *
     * @param tekiyoKaishiYMD 適用開始年月日
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 適用終了年月日のgetメソッドです。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * 適用終了年月日のsetメソッドです。
     *
     * @param tekiyoShuryoYMD 適用終了年月日
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * 標準負担区分コードのgetメソッドです。
     * <br/>
     * <br/>1:標準負担,2:特定標準負担
     *
     * @return 標準負担区分コード
     */
    public RString getHyojunFutanKubunCode() {
        return hyojunFutanKubunCode;
    }

    /**
     * 標準負担区分コードのsetメソッドです。
     * <br/>
     * <br/>1:標準負担,2:特定標準負担
     *
     * @param hyojunFutanKubunCode 標準負担区分コード
     */
    public void setHyojunFutanKubunCode(RString hyojunFutanKubunCode) {
        this.hyojunFutanKubunCode = hyojunFutanKubunCode;
    }

    /**
     * 負担額のgetメソッドです。
     *
     * @return 負担額
     */
    public int getFutangaku() {
        return futangaku;
    }

    /**
     * 負担額のsetメソッドです。
     *
     * @param futangaku 負担額
     */
    public void setFutangaku(int futangaku) {
        this.futangaku = futangaku;
    }

    /**
     * 負担額適用開始年月日のgetメソッドです。
     *
     * @return 負担額適用開始年月日
     */
    public FlexibleDate getFutangakuTekiyoKaishiYMD() {
        return futangakuTekiyoKaishiYMD;
    }

    /**
     * 負担額適用開始年月日のsetメソッドです。
     *
     * @param futangakuTekiyoKaishiYMD 負担額適用開始年月日
     */
    public void setFutangakuTekiyoKaishiYMD(FlexibleDate futangakuTekiyoKaishiYMD) {
        this.futangakuTekiyoKaishiYMD = futangakuTekiyoKaishiYMD;
    }

    /**
     * 負担額適用終了年月日のgetメソッドです。
     *
     * @return 負担額適用終了年月日
     */
    public FlexibleDate getFutangakuTekiyoShuryoYMD() {
        return futangakuTekiyoShuryoYMD;
    }

    /**
     * 負担額適用終了年月日のsetメソッドです。
     *
     * @param futangakuTekiyoShuryoYMD 負担額適用終了年月日
     */
    public void setFutangakuTekiyoShuryoYMD(FlexibleDate futangakuTekiyoShuryoYMD) {
        this.futangakuTekiyoShuryoYMD = futangakuTekiyoShuryoYMD;
    }

    /**
     * 特定入所者認定申請中区分コードのgetメソッドです。
     * <br/>
     * <br/>1:申請無し,2:申請中,3:決定済み
     *
     * @return 特定入所者認定申請中区分コード
     */
    public RString getTokuteiNyushoshaNinteiShinseichuKubunCode() {
        return tokuteiNyushoshaNinteiShinseichuKubunCode;
    }

    /**
     * 特定入所者認定申請中区分コードのsetメソッドです。
     * <br/>
     * <br/>1:申請無し,2:申請中,3:決定済み
     *
     * @param tokuteiNyushoshaNinteiShinseichuKubunCode 特定入所者認定申請中区分コード
     */
    public void setTokuteiNyushoshaNinteiShinseichuKubunCode(RString tokuteiNyushoshaNinteiShinseichuKubunCode) {
        this.tokuteiNyushoshaNinteiShinseichuKubunCode = tokuteiNyushoshaNinteiShinseichuKubunCode;
    }

    /**
     * 特定入所者介護サービス区分コードのgetメソッドです。
     * <br/>
     * <br/>1:通常の受給者,2:旧措置入所者
     *
     * @return 特定入所者介護サービス区分コード
     */
    public RString getTokuteiNyushoshaKaigoServiceKubunCode() {
        return tokuteiNyushoshaKaigoServiceKubunCode;
    }

    /**
     * 特定入所者介護サービス区分コードのsetメソッドです。
     * <br/>
     * <br/>1:通常の受給者,2:旧措置入所者
     *
     * @param tokuteiNyushoshaKaigoServiceKubunCode 特定入所者介護サービス区分コード
     */
    public void setTokuteiNyushoshaKaigoServiceKubunCode(RString tokuteiNyushoshaKaigoServiceKubunCode) {
        this.tokuteiNyushoshaKaigoServiceKubunCode = tokuteiNyushoshaKaigoServiceKubunCode;
    }

    /**
     * 課税層の特例減額措置対象フラグのgetメソッドです。
     * <br/>
     * <br/>1:該当無し,2:該当有り
     *
     * @return 課税層の特例減額措置対象フラグ
     */
    public boolean getKaizeisoTokureiGengakuSochiTaishoFlag() {
        return kaizeisoTokureiGengakuSochiTaishoFlag;
    }

    /**
     * 課税層の特例減額措置対象フラグのsetメソッドです。
     * <br/>
     * <br/>1:該当無し,2:該当有り
     *
     * @param kaizeisoTokureiGengakuSochiTaishoFlag 課税層の特例減額措置対象フラグ
     */
    public void setKaizeisoTokureiGengakuSochiTaishoFlag(boolean kaizeisoTokureiGengakuSochiTaishoFlag) {
        this.kaizeisoTokureiGengakuSochiTaishoFlag = kaizeisoTokureiGengakuSochiTaishoFlag;
    }

    /**
     * 食費負担限度額のgetメソッドです。
     *
     * @return 食費負担限度額
     */
    public Decimal getShokuhiFutanGendogaku() {
        return shokuhiFutanGendogaku;
    }

    /**
     * 食費負担限度額のsetメソッドです。
     *
     * @param shokuhiFutanGendogaku 食費負担限度額
     */
    public void setShokuhiFutanGendogaku(Decimal shokuhiFutanGendogaku) {
        this.shokuhiFutanGendogaku = shokuhiFutanGendogaku;
    }

    /**
     * 居住費ユニット型個室負担限度額のgetメソッドです。
     *
     * @return 居住費ユニット型個室負担限度額
     */
    public Decimal getKyojuhiUnitGataKoshitsuFutanGendogaku() {
        return kyojuhiUnitGataKoshitsuFutanGendogaku;
    }

    /**
     * 居住費ユニット型個室負担限度額のsetメソッドです。
     *
     * @param kyojuhiUnitGataKoshitsuFutanGendogaku 居住費ユニット型個室負担限度額
     */
    public void setKyojuhiUnitGataKoshitsuFutanGendogaku(Decimal kyojuhiUnitGataKoshitsuFutanGendogaku) {
        this.kyojuhiUnitGataKoshitsuFutanGendogaku = kyojuhiUnitGataKoshitsuFutanGendogaku;
    }

    /**
     * 居住費ユニット型準個室負担限度額のgetメソッドです。
     *
     * @return 居住費ユニット型準個室負担限度額
     */
    public Decimal getKyojuhiUnitGataJunKoshitsuFutanGendogaku() {
        return kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    }

    /**
     * 居住費ユニット型準個室負担限度額のsetメソッドです。
     *
     * @param kyojuhiUnitGataJunKoshitsuFutanGendogaku 居住費ユニット型準個室負担限度額
     */
    public void setKyojuhiUnitGataJunKoshitsuFutanGendogaku(Decimal kyojuhiUnitGataJunKoshitsuFutanGendogaku) {
        this.kyojuhiUnitGataJunKoshitsuFutanGendogaku = kyojuhiUnitGataJunKoshitsuFutanGendogaku;
    }

    /**
     * 居住費従来型個室特養等負担限度額のgetメソッドです。
     *
     * @return 居住費従来型個室特養等負担限度額
     */
    public Decimal getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku() {
        return kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    }

    /**
     * 居住費従来型個室特養等負担限度額のsetメソッドです。
     *
     * @param kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku 居住費従来型個室特養等負担限度額
     */
    public void setKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku(Decimal kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku) {
        this.kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku = kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
    }

    /**
     * 居住費従来型個室老健療養等負担限度額のgetメソッドです。
     *
     * @return 居住費従来型個室老健療養等負担限度額
     */
    public Decimal getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku() {
        return kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    }

    /**
     * 居住費従来型個室老健療養等負担限度額のsetメソッドです。
     *
     * @param kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku
     * 居住費従来型個室老健療養等負担限度額
     */
    public void setKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku(Decimal kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku) {
        this.kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku = kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
    }

    /**
     * 居住費多床室負担限度額のgetメソッドです。
     *
     * @return 居住費多床室負担限度額
     */
    public Decimal getKyujuhiTashoshitsuFutanGendogaku() {
        return kyujuhiTashoshitsuFutanGendogaku;
    }

    /**
     * 居住費多床室負担限度額のsetメソッドです。
     *
     * @param kyujuhiTashoshitsuFutanGendogaku 居住費多床室負担限度額
     */
    public void setKyujuhiTashoshitsuFutanGendogaku(Decimal kyujuhiTashoshitsuFutanGendogaku) {
        this.kyujuhiTashoshitsuFutanGendogaku = kyujuhiTashoshitsuFutanGendogaku;
    }

    /**
     * 負担限度額適用開始年月日のgetメソッドです。
     *
     * @return 負担限度額適用開始年月日
     */
    public FlexibleDate getFutanGendogakuTekiyoKaishiYMD() {
        return futanGendogakuTekiyoKaishiYMD;
    }

    /**
     * 負担限度額適用開始年月日のsetメソッドです。
     *
     * @param futanGendogakuTekiyoKaishiYMD 負担限度額適用開始年月日
     */
    public void setFutanGendogakuTekiyoKaishiYMD(FlexibleDate futanGendogakuTekiyoKaishiYMD) {
        this.futanGendogakuTekiyoKaishiYMD = futanGendogakuTekiyoKaishiYMD;
    }

    /**
     * 負担限度額適用終了年月日のgetメソッドです。
     *
     * @return 負担限度額適用終了年月日
     */
    public FlexibleDate getFutanGendogakuTekiyoShuryoYMD() {
        return futanGendogakuTekiyoShuryoYMD;
    }

    /**
     * 負担限度額適用終了年月日のsetメソッドです。
     *
     * @param futanGendogakuTekiyoShuryoYMD 負担限度額適用終了年月日
     */
    public void setFutanGendogakuTekiyoShuryoYMD(FlexibleDate futanGendogakuTekiyoShuryoYMD) {
        this.futanGendogakuTekiyoShuryoYMD = futanGendogakuTekiyoShuryoYMD;
    }

    /**
     * 軽減率のgetメソッドです。
     *
     * @return 軽減率
     */
    public Decimal getKeigenritsu() {
        return keigenritsu;
    }

    /**
     * 軽減率のsetメソッドです。
     *
     * @param keigenritsu 軽減率
     */
    public void setKeigenritsu(Decimal keigenritsu) {
        this.keigenritsu = keigenritsu;
    }

    /**
     * 軽減率適用開始年月日のgetメソッドです。
     *
     * @return 軽減率適用開始年月日
     */
    public FlexibleDate getKeigenritsuTekiyoKaishiYMD() {
        return keigenritsuTekiyoKaishiYMD;
    }

    /**
     * 軽減率適用開始年月日のsetメソッドです。
     *
     * @param keigenritsuTekiyoKaishiYMD 軽減率適用開始年月日
     */
    public void setKeigenritsuTekiyoKaishiYMD(FlexibleDate keigenritsuTekiyoKaishiYMD) {
        this.keigenritsuTekiyoKaishiYMD = keigenritsuTekiyoKaishiYMD;
    }

    /**
     * 軽減率適用終了年月日のgetメソッドです。
     *
     * @return 軽減率適用終了年月日
     */
    public FlexibleDate getKeigenritsuTekiyoShuryoYMD() {
        return keigenritsuTekiyoShuryoYMD;
    }

    /**
     * 軽減率適用終了年月日のsetメソッドです。
     *
     * @param keigenritsuTekiyoShuryoYMD 軽減率適用終了年月日
     */
    public void setKeigenritsuTekiyoShuryoYMD(FlexibleDate keigenritsuTekiyoShuryoYMD) {
        this.keigenritsuTekiyoShuryoYMD = keigenritsuTekiyoShuryoYMD;
    }

    /**
     * 小多機能居宅介護利用開始月利用有フラグのgetメソッドです。
     * <br/>
     * <br/>1:利用無し,2:利用有り
     *
     * @return 小多機能居宅介護利用開始月利用有フラグ
     */
    public boolean getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag() {
        return shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    }

    /**
     * 小多機能居宅介護利用開始月利用有フラグのsetメソッドです。
     * <br/>
     * <br/>1:利用無し,2:利用有り
     *
     * @param shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag 小多機能居宅介護利用開始月利用有フラグ
     */
    public void setShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag(boolean shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag) {
        this.shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag = shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
    }

    /**
     * 後期高齢者医療保険者番号のgetメソッドです。
     *
     * @return 後期高齢者医療保険者番号
     */
    public RString getKokiKoureiIryoHokenshaNo() {
        return kokiKoureiIryoHokenshaNo;
    }

    /**
     * 後期高齢者医療保険者番号のsetメソッドです。
     *
     * @param kokiKoureiIryoHokenshaNo 後期高齢者医療保険者番号
     */
    public void setKokiKoureiIryoHokenshaNo(RString kokiKoureiIryoHokenshaNo) {
        this.kokiKoureiIryoHokenshaNo = kokiKoureiIryoHokenshaNo;
    }

    /**
     * 後期高齢者医療被保険者番号のgetメソッドです。
     *
     * @return 後期高齢者医療被保険者番号
     */
    public RString getKokikoureiIryoHiHokenshaNo() {
        return kokikoureiIryoHiHokenshaNo;
    }

    /**
     * 後期高齢者医療被保険者番号のsetメソッドです。
     *
     * @param kokikoureiIryoHiHokenshaNo 後期高齢者医療被保険者番号
     */
    public void setKokikoureiIryoHiHokenshaNo(RString kokikoureiIryoHiHokenshaNo) {
        this.kokikoureiIryoHiHokenshaNo = kokikoureiIryoHiHokenshaNo;
    }

    /**
     * 国民健康保険保険者番号のgetメソッドです。
     *
     * @return 国民健康保険保険者番号
     */
    public RString getKokuhoHokenshaNo() {
        return kokuhoHokenshaNo;
    }

    /**
     * 国民健康保険保険者番号のsetメソッドです。
     *
     * @param kokuhoHokenshaNo 国民健康保険保険者番号
     */
    public void setKokuhoHokenshaNo(RString kokuhoHokenshaNo) {
        this.kokuhoHokenshaNo = kokuhoHokenshaNo;
    }

    /**
     * 国民健康保険被保険者証番号のgetメソッドです。
     *
     * @return 国民健康保険被保険者証番号
     */
    public RString getKokuhoHiHokenshaNo() {
        return kokuhoHiHokenshaNo;
    }

    /**
     * 国民健康保険被保険者証番号のsetメソッドです。
     *
     * @param kokuhoHiHokenshaNo 国民健康保険被保険者証番号
     */
    public void setKokuhoHiHokenshaNo(RString kokuhoHiHokenshaNo) {
        this.kokuhoHiHokenshaNo = kokuhoHiHokenshaNo;
    }

    /**
     * 国民健康保険個人番号のgetメソッドです。
     *
     * @return 国民健康保険個人番号
     */
    public RString getKokuhoKojinNo() {
        return kokuhoKojinNo;
    }

    /**
     * 国民健康保険個人番号のsetメソッドです。
     *
     * @param kokuhoKojinNo 国民健康保険個人番号
     */
    public void setKokuhoKojinNo(RString kokuhoKojinNo) {
        this.kokuhoKojinNo = kokuhoKojinNo;
    }

    /**
     * 二次予防事業区分コードのgetメソッドです。
     * <br/>
     * <br/>1:非該当,2:該当
     *
     * @return 二次予防事業区分コード
     */
    public RString getNijiyoboJigyoKubunCode() {
        return nijiyoboJigyoKubunCode;
    }

    /**
     * 二次予防事業区分コードのsetメソッドです。
     * <br/>
     * <br/>1:非該当,2:該当
     *
     * @param nijiyoboJigyoKubunCode 二次予防事業区分コード
     */
    public void setNijiyoboJigyoKubunCode(RString nijiyoboJigyoKubunCode) {
        this.nijiyoboJigyoKubunCode = nijiyoboJigyoKubunCode;
    }

    /**
     * 二次予防事業有効期間開始年月日のgetメソッドです。
     *
     * @return 二次予防事業有効期間開始年月日
     */
    public FlexibleDate getNijiyoboJigyoYukoKikanKaishiYMD() {
        return nijiyoboJigyoYukoKikanKaishiYMD;
    }

    /**
     * 二次予防事業有効期間開始年月日のsetメソッドです。
     *
     * @param nijiyoboJigyoYukoKikanKaishiYMD 二次予防事業有効期間開始年月日
     */
    public void setNijiyoboJigyoYukoKikanKaishiYMD(FlexibleDate nijiyoboJigyoYukoKikanKaishiYMD) {
        this.nijiyoboJigyoYukoKikanKaishiYMD = nijiyoboJigyoYukoKikanKaishiYMD;
    }

    /**
     * 二次予防事業有効期間終了年月日のgetメソッドです。
     *
     * @return 二次予防事業有効期間終了年月日
     */
    public FlexibleDate getNijiyoboJigyoYukoKikanShuryoYMD() {
        return nijiyoboJigyoYukoKikanShuryoYMD;
    }

    /**
     * 二次予防事業有効期間終了年月日のsetメソッドです。
     *
     * @param nijiyoboJigyoYukoKikanShuryoYMD 二次予防事業有効期間終了年月日
     */
    public void setNijiyoboJigyoYukoKikanShuryoYMD(FlexibleDate nijiyoboJigyoYukoKikanShuryoYMD) {
        this.nijiyoboJigyoYukoKikanShuryoYMD = nijiyoboJigyoYukoKikanShuryoYMD;
    }

    /**
     * 訂正連絡票フラグのgetメソッドです。
     * <br/>
     * <br/>異動or訂正 訂正ならtrue
     *
     * @return 訂正連絡票フラグ
     */
    public boolean getTeiseiRenrakuhyoFlag() {
        return teiseiRenrakuhyoFlag;
    }

    /**
     * 訂正連絡票フラグのsetメソッドです。
     * <br/>
     * <br/>異動or訂正 訂正ならtrue
     *
     * @param teiseiRenrakuhyoFlag 訂正連絡票フラグ
     */
    public void setTeiseiRenrakuhyoFlag(boolean teiseiRenrakuhyoFlag) {
        this.teiseiRenrakuhyoFlag = teiseiRenrakuhyoFlag;
    }

    /**
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     *
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * 住所地特例対象者区分コードのgetメソッドです。
     *
     * @return 住所地特例対象者区分コード
     */
    public RString getJushochiTokureiTaishoshaKubunCode() {
        return jushochiTokureiTaishoshaKubunCode;
    }

    /**
     * 住所地特例対象者区分コードのsetメソッドです。
     *
     * @param jushochiTokureiTaishoshaKubunCode 住所地特例対象者区分コード
     */
    public void setJushochiTokureiTaishoshaKubunCode(RString jushochiTokureiTaishoshaKubunCode) {
        this.jushochiTokureiTaishoshaKubunCode = jushochiTokureiTaishoshaKubunCode;
    }

    /**
     * 施設所在保険者番号のgetメソッドです。
     *
     * @return 施設所在保険者番号
     */
    public RString getShisetsuShozaiHokenjaNo() {
        return shisetsuShozaiHokenjaNo;
    }

    /**
     * 施設所在保険者番号のsetメソッドです。
     *
     * @param shisetsuShozaiHokenjaNo 施設所在保険者番号
     */
    public void setShisetsuShozaiHokenjaNo(RString shisetsuShozaiHokenjaNo) {
        this.shisetsuShozaiHokenjaNo = shisetsuShozaiHokenjaNo;
    }

    /**
     * 住所地特例適用開始日のgetメソッドです。
     *
     * @return 住所地特例適用開始日
     */
    public FlexibleDate getJushochiTokureiTekiyoKaishiYMD() {
        return jushochiTokureiTekiyoKaishiYMD;
    }

    /**
     * 住所地特例適用開始日のsetメソッドです。
     *
     * @param jushochiTokureiTekiyoKaishiYMD 住所地特例適用開始日
     */
    public void setJushochiTokureiTekiyoKaishiYMD(FlexibleDate jushochiTokureiTekiyoKaishiYMD) {
        this.jushochiTokureiTekiyoKaishiYMD = jushochiTokureiTekiyoKaishiYMD;
    }

    /**
     * 住所地特例適用終了日のgetメソッドです。
     *
     * @return 住所地特例適用終了日
     */
    public FlexibleDate getJushochiTokureiTekiyoShuryoYMD() {
        return jushochiTokureiTekiyoShuryoYMD;
    }

    /**
     * 住所地特例適用終了日のsetメソッドです。
     *
     * @param jushochiTokureiTekiyoShuryoYMD 住所地特例適用終了日
     */
    public void setJushochiTokureiTekiyoShuryoYMD(FlexibleDate jushochiTokureiTekiyoShuryoYMD) {
        this.jushochiTokureiTekiyoShuryoYMD = jushochiTokureiTekiyoShuryoYMD;
    }

    /**
     * 居宅費（新１）負担限度額のgetメソッドです。
     *
     * @return 居宅費（新１）負担限度額
     */
    public Decimal getKyotakuhiShin1FutanGendogaku() {
        return kyotakuhiShin1FutanGendogaku;
    }

    /**
     * 居宅費（新１）負担限度額のsetメソッドです。
     *
     * @param kyotakuhiShin1FutanGendogaku 居宅費（新１）負担限度額
     */
    public void setKyotakuhiShin1FutanGendogaku(Decimal kyotakuhiShin1FutanGendogaku) {
        this.kyotakuhiShin1FutanGendogaku = kyotakuhiShin1FutanGendogaku;
    }

    /**
     * 居宅費（新２）負担限度額のgetメソッドです。
     *
     * @return 居宅費（新２）負担限度額
     */
    public Decimal getKyotakuhiShin2FutanGendogaku() {
        return kyotakuhiShin2FutanGendogaku;
    }

    /**
     * 居宅費（新２）負担限度額のsetメソッドです。
     *
     * @param kyotakuhiShin2FutanGendogaku 居宅費（新２）負担限度額
     */
    public void setKyotakuhiShin2FutanGendogaku(Decimal kyotakuhiShin2FutanGendogaku) {
        this.kyotakuhiShin2FutanGendogaku = kyotakuhiShin2FutanGendogaku;
    }

    /**
     * 居宅費（新３）負担限度額のgetメソッドです。
     *
     * @return 居宅費（新３）負担限度額
     */
    public Decimal getKyotakuhiShin3FutanGendogaku() {
        return kyotakuhiShin3FutanGendogaku;
    }

    /**
     * 居宅費（新３）負担限度額のsetメソッドです。
     *
     * @param kyotakuhiShin3FutanGendogaku 居宅費（新３）負担限度額
     */
    public void setKyotakuhiShin3FutanGendogaku(Decimal kyotakuhiShin3FutanGendogaku) {
        this.kyotakuhiShin3FutanGendogaku = kyotakuhiShin3FutanGendogaku;
    }

    /**
     * 利用者負担割合有効開始日のgetメソッドです。
     *
     * @return 利用者負担割合有効開始日
     */
    public FlexibleDate getRiyosyaFutanWariaiYukoKaishiYMD() {
        return riyosyaFutanWariaiYukoKaishiYMD;
    }

    /**
     * 利用者負担割合有効開始日のsetメソッドです。
     *
     * @param riyosyaFutanWariaiYukoKaishiYMD 利用者負担割合有効開始日
     */
    public void setRiyosyaFutanWariaiYukoKaishiYMD(FlexibleDate riyosyaFutanWariaiYukoKaishiYMD) {
        this.riyosyaFutanWariaiYukoKaishiYMD = riyosyaFutanWariaiYukoKaishiYMD;
    }

    /**
     * 利用者負担割合有効終了日のgetメソッドです。
     *
     * @return 利用者負担割合有効終了日
     */
    public FlexibleDate getRiyosyaFutanWariaiYukoShuryoYMD() {
        return riyosyaFutanWariaiYukoShuryoYMD;
    }

    /**
     * 利用者負担割合有効終了日のsetメソッドです。
     *
     * @param riyosyaFutanWariaiYukoShuryoYMD 利用者負担割合有効終了日
     */
    public void setRiyosyaFutanWariaiYukoShuryoYMD(FlexibleDate riyosyaFutanWariaiYukoShuryoYMD) {
        this.riyosyaFutanWariaiYukoShuryoYMD = riyosyaFutanWariaiYukoShuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3001JukyushaIdoRenrakuhyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3001JukyushaIdoRenrakuhyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3001JukyushaIdoRenrakuhyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
            return false;
        }
        if (!Objects.equals(this.idoKubunCode, other.idoKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.jukyushaIdoJiyu, other.jukyushaIdoJiyu)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        this.idoYMD = entity.idoYMD;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.hiHokenshaNameKana = entity.hiHokenshaNameKana;
        this.umareYMD = entity.umareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.rojinHokenShichosonNo = entity.rojinHokenShichosonNo;
        this.rojinHokenJukyushaNo = entity.rojinHokenJukyushaNo;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.koikiRengoHokenshaNo = entity.koikiRengoHokenshaNo;
        this.shinseiShubetsuCode = entity.shinseiShubetsuCode;
        this.henkoShinseichuKubunCode = entity.henkoShinseichuKubunCode;
        this.shinseiYMD = entity.shinseiYMD;
        this.minashiYokaigoJotaiKubunCode = entity.minashiYokaigoJotaiKubunCode;
        this.yokaigoJotaiKubunCode = entity.yokaigoJotaiKubunCode;
        this.ninteiYukoKikankaishiYMD = entity.ninteiYukoKikankaishiYMD;
        this.ninteiYukoKikanShuryoYMD = entity.ninteiYukoKikanShuryoYMD;
        this.kyotakuServiceSakuseiKubunCode = entity.kyotakuServiceSakuseiKubunCode;
        this.kyotakuKaigoShienJigyoshoNo = entity.kyotakuKaigoShienJigyoshoNo;
        this.kyotakuServiceTekiyoKaishiYMD = entity.kyotakuServiceTekiyoKaishiYMD;
        this.kyotakuServiceTekiyoShuryoYMD = entity.kyotakuServiceTekiyoShuryoYMD;
        this.homonTsushoServiceShikyuGendoKijungaku = entity.homonTsushoServiceShikyuGendoKijungaku;
        this.homonTsushoServiceJogenKanriTekiyoKaishiYMD = entity.homonTsushoServiceJogenKanriTekiyoKaishiYMD;
        this.homonTsushoServiceJogenKanriTekiyoShuryoYMD = entity.homonTsushoServiceJogenKanriTekiyoShuryoYMD;
        this.tankiNyushoServiceShikyuGendoKijungaku = entity.tankiNyushoServiceShikyuGendoKijungaku;
        this.tankinyushoServiceJogenKanriTekiyoKaishiYMD = entity.tankinyushoServiceJogenKanriTekiyoKaishiYMD;
        this.tankinyushoServiceJogenKanriTekiyoShuryoYMD = entity.tankinyushoServiceJogenKanriTekiyoShuryoYMD;
        this.kohiFutanJogenGengakuAriFlag = entity.kohiFutanJogenGengakuAriFlag;
        this.shokanbaraikaKaishiYMD = entity.shokanbaraikaKaishiYMD;
        this.shokanbaraikaShuryoYMD = entity.shokanbaraikaShuryoYMD;
        this.kyufuritsuHikisageKaishiYMD = entity.kyufuritsuHikisageKaishiYMD;
        this.kyufuritsuHikisageShuryoYMD = entity.kyufuritsuHikisageShuryoYMD;
        this.gemmenShinseichuKubunCode = entity.gemmenShinseichuKubunCode;
        this.riyoshaFutanKubunCode = entity.riyoshaFutanKubunCode;
        this.kyufuritsu = entity.kyufuritsu;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.hyojunFutanKubunCode = entity.hyojunFutanKubunCode;
        this.futangaku = entity.futangaku;
        this.futangakuTekiyoKaishiYMD = entity.futangakuTekiyoKaishiYMD;
        this.futangakuTekiyoShuryoYMD = entity.futangakuTekiyoShuryoYMD;
        this.tokuteiNyushoshaNinteiShinseichuKubunCode = entity.tokuteiNyushoshaNinteiShinseichuKubunCode;
        this.tokuteiNyushoshaKaigoServiceKubunCode = entity.tokuteiNyushoshaKaigoServiceKubunCode;
        this.kaizeisoTokureiGengakuSochiTaishoFlag = entity.kaizeisoTokureiGengakuSochiTaishoFlag;
        this.shokuhiFutanGendogaku = entity.shokuhiFutanGendogaku;
        this.kyojuhiUnitGataKoshitsuFutanGendogaku = entity.kyojuhiUnitGataKoshitsuFutanGendogaku;
        this.kyojuhiUnitGataJunKoshitsuFutanGendogaku = entity.kyojuhiUnitGataJunKoshitsuFutanGendogaku;
        this.kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku = entity.kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku;
        this.kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku = entity.kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku;
        this.kyujuhiTashoshitsuFutanGendogaku = entity.kyujuhiTashoshitsuFutanGendogaku;
        this.futanGendogakuTekiyoKaishiYMD = entity.futanGendogakuTekiyoKaishiYMD;
        this.futanGendogakuTekiyoShuryoYMD = entity.futanGendogakuTekiyoShuryoYMD;
        this.keigenritsu = entity.keigenritsu;
        this.keigenritsuTekiyoKaishiYMD = entity.keigenritsuTekiyoKaishiYMD;
        this.keigenritsuTekiyoShuryoYMD = entity.keigenritsuTekiyoShuryoYMD;
        this.shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag = entity.shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag;
        this.kokiKoureiIryoHokenshaNo = entity.kokiKoureiIryoHokenshaNo;
        this.kokikoureiIryoHiHokenshaNo = entity.kokikoureiIryoHiHokenshaNo;
        this.kokuhoHokenshaNo = entity.kokuhoHokenshaNo;
        this.kokuhoHiHokenshaNo = entity.kokuhoHiHokenshaNo;
        this.kokuhoKojinNo = entity.kokuhoKojinNo;
        this.nijiyoboJigyoKubunCode = entity.nijiyoboJigyoKubunCode;
        this.nijiyoboJigyoYukoKikanKaishiYMD = entity.nijiyoboJigyoYukoKikanKaishiYMD;
        this.nijiyoboJigyoYukoKikanShuryoYMD = entity.nijiyoboJigyoYukoKikanShuryoYMD;
        this.teiseiRenrakuhyoFlag = entity.teiseiRenrakuhyoFlag;
        this.sofuYM = entity.sofuYM;
        this.jushochiTokureiTaishoshaKubunCode = entity.jushochiTokureiTaishoshaKubunCode;
        this.shisetsuShozaiHokenjaNo = entity.shisetsuShozaiHokenjaNo;
        this.jushochiTokureiTekiyoKaishiYMD = entity.jushochiTokureiTekiyoKaishiYMD;
        this.jushochiTokureiTekiyoShuryoYMD = entity.jushochiTokureiTekiyoShuryoYMD;
        this.kyotakuhiShin1FutanGendogaku = entity.kyotakuhiShin1FutanGendogaku;
        this.kyotakuhiShin2FutanGendogaku = entity.kyotakuhiShin2FutanGendogaku;
        this.kyotakuhiShin3FutanGendogaku = entity.kyotakuhiShin3FutanGendogaku;
        this.riyosyaFutanWariaiYukoKaishiYMD = entity.riyosyaFutanWariaiYukoKaishiYMD;
        this.riyosyaFutanWariaiYukoShuryoYMD = entity.riyosyaFutanWariaiYukoShuryoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(idoYMD, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, hiHokenshaNo, rirekiNo, hiHokenshaNameKana, umareYMD, seibetsuCode, shikakuShutokuYMD, shikakuSoshitsuYMD, rojinHokenShichosonNo, rojinHokenJukyushaNo, kohiFutanshaNo, koikiRengoHokenshaNo, shinseiShubetsuCode, henkoShinseichuKubunCode, shinseiYMD, minashiYokaigoJotaiKubunCode, yokaigoJotaiKubunCode, ninteiYukoKikankaishiYMD, ninteiYukoKikanShuryoYMD, kyotakuServiceSakuseiKubunCode, kyotakuKaigoShienJigyoshoNo, kyotakuServiceTekiyoKaishiYMD, kyotakuServiceTekiyoShuryoYMD, homonTsushoServiceShikyuGendoKijungaku, homonTsushoServiceJogenKanriTekiyoKaishiYMD, homonTsushoServiceJogenKanriTekiyoShuryoYMD, tankiNyushoServiceShikyuGendoKijungaku, tankinyushoServiceJogenKanriTekiyoKaishiYMD, tankinyushoServiceJogenKanriTekiyoShuryoYMD, kohiFutanJogenGengakuAriFlag, shokanbaraikaKaishiYMD, shokanbaraikaShuryoYMD, kyufuritsuHikisageKaishiYMD, kyufuritsuHikisageShuryoYMD, gemmenShinseichuKubunCode, riyoshaFutanKubunCode, kyufuritsu, tekiyoKaishiYMD, tekiyoShuryoYMD, hyojunFutanKubunCode, futangaku, futangakuTekiyoKaishiYMD, futangakuTekiyoShuryoYMD, tokuteiNyushoshaNinteiShinseichuKubunCode, tokuteiNyushoshaKaigoServiceKubunCode, kaizeisoTokureiGengakuSochiTaishoFlag, shokuhiFutanGendogaku, kyojuhiUnitGataKoshitsuFutanGendogaku, kyojuhiUnitGataJunKoshitsuFutanGendogaku, kyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku, kyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku, kyujuhiTashoshitsuFutanGendogaku, futanGendogakuTekiyoKaishiYMD, futanGendogakuTekiyoShuryoYMD, keigenritsu, keigenritsuTekiyoKaishiYMD, keigenritsuTekiyoShuryoYMD, shoTakinoKyotakuKaigoRiyozukiRiyoAriFlag, kokiKoureiIryoHokenshaNo, kokikoureiIryoHiHokenshaNo, kokuhoHokenshaNo, kokuhoHiHokenshaNo, kokuhoKojinNo, nijiyoboJigyoKubunCode, nijiyoboJigyoYukoKikanKaishiYMD, nijiyoboJigyoYukoKikanShuryoYMD, teiseiRenrakuhyoFlag, sofuYM, jushochiTokureiTaishoshaKubunCode, shisetsuShozaiHokenjaNo, jushochiTokureiTekiyoKaishiYMD, jushochiTokureiTekiyoShuryoYMD, kyotakuhiShin1FutanGendogaku, kyotakuhiShin2FutanGendogaku, kyotakuhiShin3FutanGendogaku, riyosyaFutanWariaiYukoKaishiYMD, riyosyaFutanWariaiYukoShuryoYMD);
    }

// </editor-fold>
}
