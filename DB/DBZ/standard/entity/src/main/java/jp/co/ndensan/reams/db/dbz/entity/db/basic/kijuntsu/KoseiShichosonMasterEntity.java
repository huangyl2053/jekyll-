/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.kijuntsu;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 広域合併市町村情報の取得のEntity
 */
public class KoseiShichosonMasterEntity implements IDbAccessable {

    private RString shichosonShokibetsuID;
    private LasdecCode shichosonCode;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString kokuhorenKoikiShichosonNo;
    private RString shichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private RString yusenChikuCode;
    private RString tyohyoTodoufukenHyojiUmu;
    private RString tyohyoGunHyojiUmu;
    private RString tyohyoShichosonHyojiUmu;
    private RString tyohyoJushoHenshuHouhou;
    private RString tyohyoKatagakiHyojiUmu;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private RString tokuchoBunpaishuyaku;
    private FlexibleDate ikoYMD;
    private FlexibleDate kanyuYMD;
    private FlexibleDate ridatsuYMD;
    private RString gappeiKyuShichosonKubun;
    private RString gappeiKyuShichosonHyojiUmu;
    private RString gappeiChiikiNo;
    private ShoKisaiHokenshaNo unyoHokenshaNo;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private RString unyoKeitaiKubun;
    private FlexibleDate gappeiYMD;
    private FlexibleDate kokuhorenDataFromYMD;

    /**
     * 市町村識別IDのgetメソッドです。
     *
     * @return 市町村識別ID
     */
    public RString getShichosonShokibetsuID() {
        return shichosonShokibetsuID;
    }

    /**
     * 市町村識別IDのsetメソッドです。
     *
     * @param shichosonShokibetsuID 市町村識別ID
     */
    public void setShichosonShokibetsuID(@Nonnull RString shichosonShokibetsuID) {
        this.shichosonShokibetsuID = shichosonShokibetsuID;
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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 国保連広域内市町村番号のgetメソッドです。
     *
     * @return 国保連広域内市町村番号
     */
    @CheckForNull
    public RString getKokuhorenKoikiShichosonNo() {
        return kokuhorenKoikiShichosonNo;
    }

    /**
     * 国保連広域内市町村番号のsetメソッドです。
     *
     * @param kokuhorenKoikiShichosonNo 国保連広域内市町村番号
     */
    public void setKokuhorenKoikiShichosonNo(RString kokuhorenKoikiShichosonNo) {
        this.kokuhorenKoikiShichosonNo = kokuhorenKoikiShichosonNo;
    }

    /**
     * 市町村名称のgetメソッドです。
     *
     * @return 市町村名称
     */
    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    /**
     * 市町村名称のsetメソッドです。
     *
     * @param shichosonMeisho 市町村名称
     */
    public void setShichosonMeisho(@Nonnull RString shichosonMeisho) {
        this.shichosonMeisho = shichosonMeisho;
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
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    @CheckForNull
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param jusho 住所
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
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
     * 最優先地区コードのgetメソッドです。
     *
     * @return 最優先地区コード
     */
    @CheckForNull
    public RString getYusenChikuCode() {
        return yusenChikuCode;
    }

    /**
     * 最優先地区コードのsetメソッドです。
     *
     * @param yusenChikuCode 最優先地区コード
     */
    public void setYusenChikuCode(RString yusenChikuCode) {
        this.yusenChikuCode = yusenChikuCode;
    }

    /**
     * 帳票用都道府県名称表示有無のgetメソッドです。
     *
     * @return 帳票用都道府県名称表示有無
     */
    public RString getTyohyoTodoufukenHyojiUmu() {
        return tyohyoTodoufukenHyojiUmu;
    }

    /**
     * 帳票用都道府県名称表示有無のsetメソッドです。
     *
     * @param tyohyoTodoufukenHyojiUmu 帳票用都道府県名称表示有無
     */
    public void setTyohyoTodoufukenHyojiUmu(@Nonnull RString tyohyoTodoufukenHyojiUmu) {
        this.tyohyoTodoufukenHyojiUmu = tyohyoTodoufukenHyojiUmu;
    }

    /**
     * 帳票用郡名称表示有無のgetメソッドです。
     *
     * @return 帳票用郡名称表示有無
     */
    public RString getTyohyoGunHyojiUmu() {
        return tyohyoGunHyojiUmu;
    }

    /**
     * 帳票用郡名称表示有無のsetメソッドです。
     *
     * @param tyohyoGunHyojiUmu 帳票用郡名称表示有無
     */
    public void setTyohyoGunHyojiUmu(@Nonnull RString tyohyoGunHyojiUmu) {
        this.tyohyoGunHyojiUmu = tyohyoGunHyojiUmu;
    }

    /**
     * 帳票用市町村名称表示有無のgetメソッドです。
     *
     * @return 帳票用市町村名称表示有無
     */
    public RString getTyohyoShichosonHyojiUmu() {
        return tyohyoShichosonHyojiUmu;
    }

    /**
     * 帳票用市町村名称表示有無のsetメソッドです。
     *
     * @param tyohyoShichosonHyojiUmu 帳票用市町村名称表示有無
     */
    public void setTyohyoShichosonHyojiUmu(@Nonnull RString tyohyoShichosonHyojiUmu) {
        this.tyohyoShichosonHyojiUmu = tyohyoShichosonHyojiUmu;
    }

    /**
     * 帳票用住所編集方法のgetメソッドです。
     *
     * @return 帳票用住所編集方法
     */
    public RString getTyohyoJushoHenshuHouhou() {
        return tyohyoJushoHenshuHouhou;
    }

    /**
     * 帳票用住所編集方法のsetメソッドです。
     *
     * @param tyohyoJushoHenshuHouhou 帳票用住所編集方法
     */
    public void setTyohyoJushoHenshuHouhou(@Nonnull RString tyohyoJushoHenshuHouhou) {
        this.tyohyoJushoHenshuHouhou = tyohyoJushoHenshuHouhou;
    }

    /**
     * 帳票用方書表示有無のgetメソッドです。
     *
     * @return 帳票用方書表示有無
     */
    public RString getTyohyoKatagakiHyojiUmu() {
        return tyohyoKatagakiHyojiUmu;
    }

    /**
     * 帳票用方書表示有無のsetメソッドです。
     *
     * @param tyohyoKatagakiHyojiUmu 帳票用方書表示有無
     */
    public void setTyohyoKatagakiHyojiUmu(@Nonnull RString tyohyoKatagakiHyojiUmu) {
        this.tyohyoKatagakiHyojiUmu = tyohyoKatagakiHyojiUmu;
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
     *
     * @return 老人保健受給者番号体系
     */
    @CheckForNull
    public RString getRokenJukyushaNoTaikei() {
        return rokenJukyushaNoTaikei;
    }

    /**
     * 老人保健受給者番号体系のsetメソッドです。
     *
     * @param rokenJukyushaNoTaikei 老人保健受給者番号体系
     */
    public void setRokenJukyushaNoTaikei(RString rokenJukyushaNoTaikei) {
        this.rokenJukyushaNoTaikei = rokenJukyushaNoTaikei;
    }

    /**
     * 特徴分配集約のgetメソッドです。
     * <br/>
     * <br/>0：なし　1：あり（国保／後期）　2：あり（後期）
     *
     * @return 特徴分配集約
     */
    @CheckForNull
    public RString getTokuchoBunpaishuyaku() {
        return tokuchoBunpaishuyaku;
    }

    /**
     * 特徴分配集約のsetメソッドです。
     * <br/>
     * <br/>0：なし　1：あり（国保／後期）　2：あり（後期）
     *
     * @param tokuchoBunpaishuyaku 特徴分配集約
     */
    public void setTokuchoBunpaishuyaku(RString tokuchoBunpaishuyaku) {
        this.tokuchoBunpaishuyaku = tokuchoBunpaishuyaku;
    }

    /**
     * 移行日のgetメソッドです。
     *
     * @return 移行日
     */
    @CheckForNull
    public FlexibleDate getIkoYMD() {
        return ikoYMD;
    }

    /**
     * 移行日のsetメソッドです。
     *
     * @param ikoYMD 移行日
     */
    public void setIkoYMD(FlexibleDate ikoYMD) {
        this.ikoYMD = ikoYMD;
    }

    /**
     * 加入日のgetメソッドです。
     *
     * @return 加入日
     */
    public FlexibleDate getKanyuYMD() {
        return kanyuYMD;
    }

    /**
     * 加入日のsetメソッドです。
     *
     * @param kanyuYMD 加入日
     */
    public void setKanyuYMD(@Nonnull FlexibleDate kanyuYMD) {
        this.kanyuYMD = kanyuYMD;
    }

    /**
     * 離脱日のgetメソッドです。
     *
     * @return 離脱日
     */
    @CheckForNull
    public FlexibleDate getRidatsuYMD() {
        return ridatsuYMD;
    }

    /**
     * 離脱日のsetメソッドです。
     *
     * @param ridatsuYMD 離脱日
     */
    public void setRidatsuYMD(FlexibleDate ridatsuYMD) {
        this.ridatsuYMD = ridatsuYMD;
    }

    /**
     * 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村であるのgetメソッドです。
     *
     * @return 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村である
     */
    @CheckForNull
    public RString getGappeiKyuShichosonKubun() {
        return gappeiKyuShichosonKubun;
    }

    /**
     * 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村であるのsetメソッドです。
     *
     * @param gappeiKyuShichosonKubun 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村である
     */
    public void setGappeiKyuShichosonKubun(RString gappeiKyuShichosonKubun) {
        this.gappeiKyuShichosonKubun = gappeiKyuShichosonKubun;
    }

    /**
     * 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しないのgetメソッドです。
     *
     * @return 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しない
     */
    @CheckForNull
    public RString getGappeiKyuShichosonHyojiUmu() {
        return gappeiKyuShichosonHyojiUmu;
    }

    /**
     * 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しないのsetメソッドです。
     *
     * @param gappeiKyuShichosonHyojiUmu 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しない
     */
    public void setGappeiKyuShichosonHyojiUmu(RString gappeiKyuShichosonHyojiUmu) {
        this.gappeiKyuShichosonHyojiUmu = gappeiKyuShichosonHyojiUmu;
    }

    /**
     * 合併情報地域番号のgetメソッドです。
     *
     * @return 合併情報地域番号
     */
    @CheckForNull
    public RString getGappeiChiikiNo() {
        return gappeiChiikiNo;
    }

    /**
     * 合併情報地域番号のsetメソッドです。
     *
     * @param gappeiChiikiNo 合併情報地域番号
     */
    public void setGappeiChiikiNo(RString gappeiChiikiNo) {
        this.gappeiChiikiNo = gappeiChiikiNo;
    }

    /**
     * 運用保険者番号のgetメソッドです。
     *
     * @return 運用保険者番号
     */
    public ShoKisaiHokenshaNo getUnyoHokenshaNo() {
        return unyoHokenshaNo;
    }

    /**
     * 運用保険者番号のsetメソッドです。
     *
     * @param unyoHokenshaNo 運用保険者番号
     */
    public void setUnyoHokenshaNo(@Nonnull ShoKisaiHokenshaNo unyoHokenshaNo) {
        this.unyoHokenshaNo = unyoHokenshaNo;
    }

    /**
     * 運用開始日のgetメソッドです。
     *
     * @return 運用開始日
     */
    public FlexibleDate getUnyoKaishiYMD() {
        return unyoKaishiYMD;
    }

    /**
     * 運用開始日のsetメソッドです。
     *
     * @param unyoKaishiYMD 運用開始日
     */
    public void setUnyoKaishiYMD(@Nonnull FlexibleDate unyoKaishiYMD) {
        this.unyoKaishiYMD = unyoKaishiYMD;
    }

    /**
     * 運用終了日のgetメソッドです。
     *
     * @return 運用終了日
     */
    public FlexibleDate getUnyoShuryoYMD() {
        return unyoShuryoYMD;
    }

    /**
     * 運用終了日のsetメソッドです。
     *
     * @param unyoShuryoYMD 運用終了日
     */
    public void setUnyoShuryoYMD(@Nonnull FlexibleDate unyoShuryoYMD) {
        this.unyoShuryoYMD = unyoShuryoYMD;
    }

    /**
     * 運用形態区分のgetメソッドです。
     * <br/>
     * <br/>単独
     * <br/>広域連合
     * <br/>一部事務組合
     *
     * @return 運用形態区分
     */
    public RString getUnyoKeitaiKubun() {
        return unyoKeitaiKubun;
    }

    /**
     * 運用形態区分のsetメソッドです。
     * <br/>
     * <br/>単独
     * <br/>広域連合
     * <br/>一部事務組合
     *
     * @param unyoKeitaiKubun 運用形態区分
     */
    public void setUnyoKeitaiKubun(@Nonnull RString unyoKeitaiKubun) {
        this.unyoKeitaiKubun = unyoKeitaiKubun;
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
}
