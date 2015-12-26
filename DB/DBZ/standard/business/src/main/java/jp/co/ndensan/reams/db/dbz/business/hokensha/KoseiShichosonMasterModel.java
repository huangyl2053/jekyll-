/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hokensha;

//import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.ForeignersNameOutput;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.GappeiKyuShichosonHyoji;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.RokenJukyushaNoTaikei;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.UnyoKeitaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hokensha.GappeiChiikiNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hokensha.KokuhorenKoikiShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.hokensha.RokenShichosonNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村マスタのモデルクラスです。
 *
 * @author LDNS 宋文娟
 * @author N3327 三浦 凌
 */
public class KoseiShichosonMasterModel implements IKoikiKoseiShichosonMaster {
//    , Serializable {

    private DbT7051KoseiShichosonMasterEntity entity;
    private transient ShichosonShikibetsuID shichosonShikibetsuId;
    private transient KokuhorenKoikiShichosonNo kokuhorenKoikiShichosonNo;
    private transient TopPriorityArea topPriorityArea;
    private transient TodofukenNamePrint todofukenNamePrint;
    private transient GunNamePrint gunNamePrint;
    private transient ShichosonNamePrint shichosonNamePrint;
    private transient HowToEditJusho howToEditJusho;
    private transient KatagakiPrint katagakiPrint;
    private transient ForeignersNameOutput foreignersNameOutput;
    private transient RokenShichosonNo rokenShichosonNo;
    private transient RokenJukyushaNoTaikei rokenJukyushaNoTaikei;
    private transient GappeiKyuShichosonKubun gappeiKyuShichosonKubun;
    private transient GappeiKyuShichosonHyoji gappeiShichosonHyoji;
    private transient GappeiChiikiNo gappeiChiikiNo;
    private transient UnyoKeitaiKubun unyoKeitaiKubun;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterModel() {
        entity = new DbT7051KoseiShichosonMasterEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public KoseiShichosonMasterModel(DbT7051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを返します。
     *
     * @return DbT7051KoseiShichosonMasterEntity
     */
    public DbT7051KoseiShichosonMasterEntity getEntity() {
        return entity;
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを設定します。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public void setEntity(DbT7051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    @Override
    public ShichosonShikibetsuID get市町村識別ID() {
        if (shichosonShikibetsuId == null) {
            shichosonShikibetsuId = new ShichosonShikibetsuID(entity.getShichosonShokibetsuID());
        }
        return shichosonShikibetsuId;
    }

    @Override
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    @Override
    public KokuhorenKoikiShichosonNo get国保連広域内市町村番号() {
        if (kokuhorenKoikiShichosonNo == null) {
            kokuhorenKoikiShichosonNo = new KokuhorenKoikiShichosonNo(entity.getKokuhorenKoikiShichosonNo());
        }
        return kokuhorenKoikiShichosonNo;
    }

    @Override
    public RString get市町村名() {
        return entity.getShichosonMeisho();
    }

    @Override
    public RString get都道府県名() {
        return entity.getTodofukenMeisho();
    }

    @Override
    public RString get郡名() {
        return entity.getGunMeisho();
    }

    @Override
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    @Override
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    @Override
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    @Override
    public TopPriorityArea get最優先地区() {
        if (topPriorityArea == null) {
            topPriorityArea = TopPriorityArea.toValue(entity.getYusenChikuCode());
        }
        return topPriorityArea;
    }

    @Override
    public HowToEditJusho get印字住所編集方法() {
        if (howToEditJusho == null) {
            howToEditJusho = HowToEditJusho.toValue(entity.getTyohyoJushoHenshuHouhou());
        }
        return howToEditJusho;
    }

    @Override
    public TodofukenNamePrint get都道府名印字有無() {
        if (todofukenNamePrint == null) {
            todofukenNamePrint = TodofukenNamePrint.toValue(entity.getTyohyoTodoufukenHyojiUmu());
        }
        return todofukenNamePrint;
    }

    @Override
    public GunNamePrint get群名印字有無() {
        if (gunNamePrint == null) {
            gunNamePrint = GunNamePrint.toValue(entity.getTyohyoGunHyojiUmu());
        }
        return gunNamePrint;
    }

    @Override
    public ShichosonNamePrint get市町村名印字有無() {
        if (shichosonNamePrint == null) {
            shichosonNamePrint = ShichosonNamePrint.toValue(entity.getTyohyoShichosonHyojiUmu());
        }
        return shichosonNamePrint;
    }

    @Override
    public KatagakiPrint get方書印字有無() {
        if (katagakiPrint == null) {
            katagakiPrint = KatagakiPrint.toValue(entity.getTyohyoKatagakiHyojiUmu());
        }
        return katagakiPrint;
    }

    @Override
    public ForeignersNameOutput get外国人氏名表示方法() {
        if (foreignersNameOutput == null) {
            foreignersNameOutput = ForeignersNameOutput.toValue(entity.getGaikokujinHyojiHouhou());
        }
        return foreignersNameOutput;
    }

    @Override
    public RokenShichosonNo get老人保健市町村番号() {
        if (rokenShichosonNo == null) {
            rokenShichosonNo = new RokenShichosonNo(entity.getRojinhokenShichosonNo());
        }
        return rokenShichosonNo;
    }

    @Override
    public RokenJukyushaNoTaikei get老人保健受給者番号体系() {
        if (rokenJukyushaNoTaikei == null) {
            rokenJukyushaNoTaikei = RokenJukyushaNoTaikei.toValue(entity.getRokenJukyushaNoTaikei());
        }
        return rokenJukyushaNoTaikei;
    }

    @Override
    public FlexibleDate get移行日() {
        return entity.getIkoYMD();
    }

    @Override
    public FlexibleDate get加入日() {
        return entity.getKanyuYMD();
    }

    @Override
    public FlexibleDate get離脱日() {
        return entity.getRidatsuYMD();
    }

    @Override
    public GappeiKyuShichosonKubun get合併旧市町村区分() {
        if (gappeiKyuShichosonKubun == null) {
            gappeiKyuShichosonKubun = GappeiKyuShichosonKubun.toValue(entity.getGappeiKyuShichosonKubun());
        }
        return gappeiKyuShichosonKubun;
    }

    @Override
    public GappeiKyuShichosonHyoji get合併旧市町村表示有無() {
        if (gappeiShichosonHyoji == null) {
            gappeiShichosonHyoji = GappeiKyuShichosonHyoji.toValue(entity.getGappeiKyuShichosonHyojiUmu());
        }
        return gappeiShichosonHyoji;
    }

    @Override
    public GappeiChiikiNo get合併地域番号() {
        if (gappeiChiikiNo == null) {
            gappeiChiikiNo = new GappeiChiikiNo(entity.getGappeiChiikiNo());
        }
        return gappeiChiikiNo;
    }

    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return entity.getUnyoHokenshaNo();
    }

    @Override
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    @Override
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    @Override
    public UnyoKeitaiKubun get運用形態区分() {
        if (unyoKeitaiKubun == null) {
            unyoKeitaiKubun = UnyoKeitaiKubun.toValue(entity.getUnyoKeitaiKubun());
        }
        return unyoKeitaiKubun;
    }

    /**
     * 市町村識別IDを設定します。
     *
     * @param 市町村識別ID 市町村識別ID
     */
    public void set市町村識別ID(ShichosonShikibetsuID 市町村識別ID) {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        entity.setShichosonShokibetsuID(市町村識別ID.value());
        this.shichosonShikibetsuId = 市町村識別ID;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 国保連広域内市町村番号を設定します。
     *
     * @param 国保連広域内市町村番号 国保連広域内市町村番号
     */
    public void set国保連広域内市町村番号(KokuhorenKoikiShichosonNo 国保連広域内市町村番号) {
        requireNonNull(国保連広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連広域内市町村番号"));
        entity.setKokuhorenKoikiShichosonNo(国保連広域内市町村番号.value());
        this.kokuhorenKoikiShichosonNo = 国保連広域内市町村番号;
    }

    /**
     * 市町村名称を設定します。
     *
     * @param 市町村名称 市町村名称
     */
    public void set市町村名称(RString 市町村名称) {
        requireNonNull(市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村名称"));
        entity.setShichosonMeisho(市町村名称);
    }

    /**
     * 都道府県名称を設定します。
     *
     * @param 都道府県名称 都道府県名称
     */
    public void set都道府県名称(RString 都道府県名称) {
        requireNonNull(都道府県名称, UrSystemErrorMessages.値がnull.getReplacedMessage("都道府県名称"));
        entity.setTodofukenMeisho(都道府県名称);
    }

    /**
     * 郡名称を設定します。
     *
     * @param 郡名称 郡名称
     */
    public void set郡名称(RString 郡名称) {
        requireNonNull(郡名称, UrSystemErrorMessages.値がnull.getReplacedMessage("郡名称"));
        entity.setGunMeisho(郡名称);
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     */
    public void set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     */
    public void set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
    }

    /**
     * 最優先地区を設定します。
     *
     * @param 最優先地区 最優先地区
     */
    public void set最優先地区(TopPriorityArea 最優先地区) {
        requireNonNull(最優先地区, UrSystemErrorMessages.値がnull.getReplacedMessage("最優先地区"));
        entity.setYusenChikuCode(最優先地区.code());
        this.topPriorityArea = 最優先地区;
    }

    /**
     * 帳票用都道府県名称表示有無を設定します。
     *
     * @param 帳票用都道府県名称表示有無 帳票用都道府県名称表示有無
     */
    public void set都道府県名印字有無(TodofukenNamePrint 帳票用都道府県名称表示有無) {
        requireNonNull(帳票用都道府県名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用都道府県名称表示有無"));
        entity.setTyohyoTodoufukenHyojiUmu(帳票用都道府県名称表示有無.code());
        this.todofukenNamePrint = 帳票用都道府県名称表示有無;
    }

    /**
     * 帳票用郡名称表示有無を設定します。
     *
     * @param 帳票用郡名称表示有無 帳票用郡名称表示有無
     */
    public void set郡名印字有無(GunNamePrint 帳票用郡名称表示有無) {
        requireNonNull(帳票用郡名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用郡名称表示有無"));
        entity.setTyohyoGunHyojiUmu(帳票用郡名称表示有無.code());
        this.gunNamePrint = 帳票用郡名称表示有無;
    }

    /**
     * 帳票用市町村名称表示有無を設定します。
     *
     * @param 帳票用市町村名称表示有無 帳票用市町村名称表示有無
     */
    public void set市町村名印字有無(ShichosonNamePrint 帳票用市町村名称表示有無) {
        requireNonNull(帳票用市町村名称表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用市町村名称表示有無"));
        entity.setTyohyoShichosonHyojiUmu(帳票用市町村名称表示有無.code());
        this.shichosonNamePrint = 帳票用市町村名称表示有無;
    }

    /**
     * 帳票用住所編集方法を設定します。
     *
     * @param 帳票用住所編集方法 帳票用住所編集方法
     */
    public void set印字住所編集方法(RString 帳票用住所編集方法) {
        requireNonNull(帳票用住所編集方法, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用住所編集方法"));
        entity.setTyohyoJushoHenshuHouhou(帳票用住所編集方法);
    }

    /**
     * 帳票用方書表示有無を設定します。
     *
     * @param 帳票用方書表示有無 帳票用方書表示有無
     */
    public void set方書印字有無(KatagakiPrint 帳票用方書表示有無) {
        requireNonNull(帳票用方書表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票用方書表示有無"));
        entity.setTyohyoKatagakiHyojiUmu(帳票用方書表示有無.code());
        this.katagakiPrint = 帳票用方書表示有無;
    }

    /**
     * 外国人氏名表示方法を設定します。
     *
     * @param 外国人氏名表示方法 外国人氏名表示方法
     */
    public void set外国人氏名表示方法(ForeignersNameOutput 外国人氏名表示方法) {
        requireNonNull(外国人氏名表示方法, UrSystemErrorMessages.値がnull.getReplacedMessage("外国人氏名表示方法"));
        entity.setGaikokujinHyojiHouhou(外国人氏名表示方法.code());
        this.foreignersNameOutput = 外国人氏名表示方法;
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     */
    public void set老人保健市町村番号(RokenShichosonNo 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinhokenShichosonNo(老人保健市町村番号.value());
        this.rokenShichosonNo = 老人保健市町村番号;
    }

    /**
     * 老人保健受給者番号体系を設定します。
     *
     * @param 老人保健受給者番号体系 老人保健受給者番号体系
     */
    public void set老人保健受給者番号体系(RokenJukyushaNoTaikei 老人保健受給者番号体系) {
        requireNonNull(老人保健受給者番号体系, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号体系"));
        entity.setRokenJukyushaNoTaikei(老人保健受給者番号体系.code());
        this.rokenJukyushaNoTaikei = 老人保健受給者番号体系;
    }

    /**
     * 移行日を設定します。
     *
     * @param 移行日 移行日
     */
    public void set移行日(FlexibleDate 移行日) {
        requireNonNull(移行日, UrSystemErrorMessages.値がnull.getReplacedMessage("移行日"));
        entity.setIkoYMD(移行日);
    }

    /**
     * 加入日を設定します。
     *
     * @param 加入日 加入日
     */
    public void set加入日(FlexibleDate 加入日) {
        requireNonNull(加入日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入日"));
        entity.setKanyuYMD(加入日);
    }

    /**
     * 離脱日を設定します。
     *
     * @param 離脱日 離脱日
     */
    public void set離脱日(FlexibleDate 離脱日) {
        requireNonNull(離脱日, UrSystemErrorMessages.値がnull.getReplacedMessage("離脱日"));
        entity.setRidatsuYMD(離脱日);
    }

    /**
     * 合併旧市町村区分を設定します。
     *
     * @param 合併旧市町村区分 合併旧市町村区分
     */
    public void set合併旧市町村区分(GappeiKyuShichosonKubun 合併旧市町村区分) {
        requireNonNull(合併旧市町村区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合併旧市町村区分"));
        entity.setGappeiKyuShichosonKubun(合併旧市町村区分.code());
        this.gappeiKyuShichosonKubun = 合併旧市町村区分;
    }

    /**
     * 合併旧市町村表示有無を設定します。
     *
     * @param 合併旧市町村表示有無 合併旧市町村表示有無
     */
    public void set合併旧市町村表示有無(GappeiKyuShichosonHyoji 合併旧市町村表示有無) {
        requireNonNull(合併旧市町村表示有無, UrSystemErrorMessages.値がnull.getReplacedMessage("合併旧市町村表示有無"));
        entity.setGappeiKyuShichosonHyojiUmu(合併旧市町村表示有無.code());
        this.gappeiShichosonHyoji = 合併旧市町村表示有無;
    }

    /**
     * 合併地域番号を設定します。
     *
     * @param 合併地域番号 合併地域番号
     */
    public void set合併地域番号(GappeiChiikiNo 合併地域番号) {
        requireNonNull(合併地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報リンク番号"));
        entity.setGappeiChiikiNo(合併地域番号.value());
        this.gappeiChiikiNo = 合併地域番号;
    }

    /**
     * 運用保険者番号を設定します。
     *
     * @param 運用保険者番号 運用保険者番号
     */
    public void set運用保険者番号(ShoKisaiHokenshaNo 運用保険者番号) {
        requireNonNull(運用保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("運用保険者番号"));
        entity.setUnyoHokenshaNo(運用保険者番号);
    }

    /**
     * 運用開始日を設定します。
     *
     * @param 運用開始日 運用開始日
     */
    public void set運用開始日(FlexibleDate 運用開始日) {
        requireNonNull(運用開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用開始日"));
        entity.setUnyoKaishiYMD(運用開始日);
    }

    /**
     * 運用終了日を設定します。
     *
     * @param 運用終了日 運用終了日
     */
    public void set運用終了日(FlexibleDate 運用終了日) {
        requireNonNull(運用終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("運用終了日"));
        entity.setUnyoShuryoYMD(運用終了日);
    }

    /**
     * 運用形態区分を設定します。
     *
     * @param 運用形態区分 運用形態区分
     */
    public void set運用形態区分(UnyoKeitaiKubun 運用形態区分) {
        requireNonNull(運用形態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("運用形態区分"));
        entity.setUnyoKeitaiKubun(運用形態区分.code());
        this.unyoKeitaiKubun = 運用形態区分;
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
