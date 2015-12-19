/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.kijuntsu;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 単一合併市町村情報の取得のEntity
 *
 */
public class GappeiShichosonEntity implements IDbAccessable {

    private LasdecCode kyuShichosonCode;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private HokenshaNo kyuHokenshaNo;
    private RString kyuShichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private YubinNo yubinNo;
    private TelNo telNo;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private RString hyojiUmu;
    private FlexibleDate gappeiYMD;
    private RString chiikiNo;
    private LasdecCode shichosonCode;
    private RString gappeiShurui;
    private HokenshaNo hokenshaNo;
    private FlexibleDate kyuJohoFuyoToYMD;
    private FlexibleDate kokuhorenDataFromYMD;

    /**
     * 旧市町村コードのgetメソッドです。
     *
     * @return 旧市町村コード
     */
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * 旧市町村コードのsetメソッドです。
     *
     * @param kyuShichosonCode 旧市町村コード
     */
    public void setKyuShichosonCode(@Nonnull LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * 運用開始年月日のgetメソッドです。
     *
     * @return 運用開始年月日
     */
    @CheckForNull
    public FlexibleDate getUnyoKaishiYMD() {
        return unyoKaishiYMD;
    }

    /**
     * 運用開始年月日のsetメソッドです。
     *
     * @param unyoKaishiYMD 運用開始年月日
     */
    public void setUnyoKaishiYMD(FlexibleDate unyoKaishiYMD) {
        this.unyoKaishiYMD = unyoKaishiYMD;
    }

    /**
     * 運用終了年月日のgetメソッドです。
     *
     * @return 運用終了年月日
     */
    @CheckForNull
    public FlexibleDate getUnyoShuryoYMD() {
        return unyoShuryoYMD;
    }

    /**
     * 運用終了年月日のsetメソッドです。
     *
     * @param unyoShuryoYMD 運用終了年月日
     */
    public void setUnyoShuryoYMD(FlexibleDate unyoShuryoYMD) {
        this.unyoShuryoYMD = unyoShuryoYMD;
    }

    /**
     * 旧保険者番号のgetメソッドです。
     *
     * @return 旧保険者番号
     */
    @CheckForNull
    public HokenshaNo getKyuHokenshaNo() {
        return kyuHokenshaNo;
    }

    /**
     * 旧保険者番号のsetメソッドです。
     *
     * @param kyuHokenshaNo 旧保険者番号
     */
    public void setKyuHokenshaNo(HokenshaNo kyuHokenshaNo) {
        this.kyuHokenshaNo = kyuHokenshaNo;
    }

    /**
     * 旧市町村名称のgetメソッドです。
     *
     * @return 旧市町村名称
     */
    @CheckForNull
    public RString getKyuShichosonMeisho() {
        return kyuShichosonMeisho;
    }

    /**
     * 旧市町村名称のsetメソッドです。
     *
     * @param kyuShichosonMeisho 旧市町村名称
     */
    public void setKyuShichosonMeisho(RString kyuShichosonMeisho) {
        this.kyuShichosonMeisho = kyuShichosonMeisho;
    }

    /**
     * 都道府県名称のgetメソッドです。
     *
     * @return 都道府県名称
     */
    @CheckForNull
    public RString getTodofukenMeisho() {
        return todofukenMeisho;
    }

    /**
     * 都道府県名称のsetメソッドです。
     *
     * @param todofukenMeisho 都道府県名称
     */
    public void setTodofukenMeisho(RString todofukenMeisho) {
        this.todofukenMeisho = todofukenMeisho;
    }

    /**
     * 郡名称のgetメソッドです。
     *
     * @return 郡名称
     */
    @CheckForNull
    public RString getGunMeisho() {
        return gunMeisho;
    }

    /**
     * 郡名称のsetメソッドです。
     *
     * @param gunMeisho 郡名称
     */
    public void setGunMeisho(RString gunMeisho) {
        this.gunMeisho = gunMeisho;
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     *
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     *
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * 老人保健市町村番号のgetメソッドです。
     *
     * @return 老人保健市町村番号
     */
    @CheckForNull
    public RString getRojinhokenShichosonNo() {
        return rojinhokenShichosonNo;
    }

    /**
     * 老人保健市町村番号のsetメソッドです。
     *
     * @param rojinhokenShichosonNo 老人保健市町村番号
     */
    public void setRojinhokenShichosonNo(RString rojinhokenShichosonNo) {
        this.rojinhokenShichosonNo = rojinhokenShichosonNo;
    }

    /**
     * 老人保健受給者番号体系のgetメソッドです。
     * <br/>
     * <br/>1:住民コード 2:医療給付サブシステム 3:市町村独自
     *
     * @return 老人保健受給者番号体系
     */
    @CheckForNull
    public RString getRokenJukyushaNoTaikei() {
        return rokenJukyushaNoTaikei;
    }

    /**
     * 老人保健受給者番号体系のsetメソッドです。
     * <br/>
     * <br/>1:住民コード 2:医療給付サブシステム 3:市町村独自
     *
     * @param rokenJukyushaNoTaikei 老人保健受給者番号体系
     */
    public void setRokenJukyushaNoTaikei(RString rokenJukyushaNoTaikei) {
        this.rokenJukyushaNoTaikei = rokenJukyushaNoTaikei;
    }

    /**
     * 表示有無のgetメソッドです。
     * <br/>
     * <br/>1:表示対象とする 0:表示対象としない
     *
     * @return 表示有無
     */
    @CheckForNull
    public RString getHyojiUmu() {
        return hyojiUmu;
    }

    /**
     * 表示有無のsetメソッドです。
     * <br/>
     * <br/>1:表示対象とする 0:表示対象としない
     *
     * @param hyojiUmu 表示有無
     */
    public void setHyojiUmu(RString hyojiUmu) {
        this.hyojiUmu = hyojiUmu;
    }

    /**
     * 合併年月日のgetメソッドです。
     *
     * @return 合併年月日
     */
    public FlexibleDate getGappeiYMD() {
        return gappeiYMD;
    }

    /**
     * 合併年月日のsetメソッドです。
     *
     * @param gappeiYMD 合併年月日
     */
    public void setGappeiYMD(@Nonnull FlexibleDate gappeiYMD) {
        this.gappeiYMD = gappeiYMD;
    }

    /**
     * 地域番号のgetメソッドです。
     *
     * @return 地域番号
     */
    public RString getChiikiNo() {
        return chiikiNo;
    }

    /**
     * 地域番号のsetメソッドです。
     *
     * @param chiikiNo 地域番号
     */
    public void setChiikiNo(@Nonnull RString chiikiNo) {
        this.chiikiNo = chiikiNo;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 合併種類のgetメソッドです。
     * <br/>
     * <br/>1:対等合併 2:吸収合併
     *
     * @return 合併種類
     */
    public RString getGappeiShurui() {
        return gappeiShurui;
    }

    /**
     * 合併種類のsetメソッドです。
     * <br/>
     * <br/>1:対等合併 2:吸収合併
     *
     * @param gappeiShurui 合併種類
     */
    public void setGappeiShurui(@Nonnull RString gappeiShurui) {
        this.gappeiShurui = gappeiShurui;
    }

    /**
     * 保険者番号のgetメソッドです。
     *
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     *
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(@Nonnull HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * 旧市町村情報付与終了年月日のgetメソッドです。
     * <br/>
     * <br/>旧市町村情報を合併日以降、いつまで管理するかを設定
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate getKyuJohoFuyoToYMD() {
        return kyuJohoFuyoToYMD;
    }

    /**
     * 旧市町村情報付与終了年月日のsetメソッドです。
     * <br/>
     * <br/>旧市町村情報を合併日以降、いつまで管理するかを設定
     *
     * @param kyuJohoFuyoToYMD 旧市町村情報付与終了年月日
     */
    public void setKyuJohoFuyoToYMD(@Nonnull FlexibleDate kyuJohoFuyoToYMD) {
        this.kyuJohoFuyoToYMD = kyuJohoFuyoToYMD;
    }

    /**
     * 国保連データ連携開始年月日のgetメソッドです。
     *
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate getKokuhorenDataFromYMD() {
        return kokuhorenDataFromYMD;
    }

    /**
     * 国保連データ連携開始年月日のsetメソッドです。
     *
     * @param kokuhorenDataFromYMD 国保連データ連携開始年月日
     */
    public void setKokuhorenDataFromYMD(@Nonnull FlexibleDate kokuhorenDataFromYMD) {
        this.kokuhorenDataFromYMD = kokuhorenDataFromYMD;
    }

}
