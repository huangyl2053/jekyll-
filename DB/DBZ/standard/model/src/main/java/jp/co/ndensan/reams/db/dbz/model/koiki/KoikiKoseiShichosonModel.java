/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.koiki;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ForeignersNameOutput;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki.GappeiKyuShichosonOutput;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki.RokenJukyushaNoTaikei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.koiki.UnyoKeitaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki.GappeiLinkNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki.KokuhorenKoikiShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki.RokenShichosonNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域構成市町村マスタに対応するモデルです。
 *
 * @author N3327 三浦 凌
 */
public class KoikiKoseiShichosonModel implements IKoikiKoseiShichoson, Serializable, IValidatable {

    private final DbT7051KoseiShichosonMasterEntity entity;
    private transient ShichosonShikibetsuID shichosonShikibetsuId;
    private transient KokuhorenKoikiShichosonNo kokuhorenKoikiShichosonNo;
    private transient TopPriorityArea topPriorityArea;
    private transient TodofukenNamePrint todofukenNamePrint;
    private transient GunNamePrint gunNamePrint;
    private transient ShichosonNamePrint shichosonNamePrint;
    private transient JushoEditPattern jushoEditPattern;
    private transient KatagakiPrint katagakiPrint;
    private transient ForeignersNameOutput foreignersName;
    private transient RokenShichosonNo rokenShichosonNo;
    private transient RokenJukyushaNoTaikei rokenJukyushaNoTaikei;
    private transient GappeiKyuShichosonKubun kyuShichosonKubun;
    private transient GappeiKyuShichosonOutput gappeiShichosonOutput;
    private transient GappeiLinkNo gappeiLinkNo;
    private transient UnyoKeitaiKubun UnyoKeitaiKubun;

    /**
     * {@link DbT7051KoseiShichosonMasterEntity 構成市町村マスタエンティティ}から
     * KoikiKoseiShichosonModel を生成します。
     *
     * @param entity {@link DbT7051KoseiShichosonMasterEntity 構成市町村マスタエンティティ}
     * @throws NullPointerException 引数のentityがnullの時
     */
    public KoikiKoseiShichosonModel(DbT7051KoseiShichosonMasterEntity entity) throws NullPointerException {
        Objects.requireNonNull(entity);
        this.entity = entity;
        this.shichosonShikibetsuId = new ShichosonShikibetsuID(entity.getShichosonShokibetsuID());
        this.kokuhorenKoikiShichosonNo = new KokuhorenKoikiShichosonNo(entity.getKokuhorenKoikiShichosonNo());
        this.topPriorityArea = TopPriorityArea.toValue(entity.getYusenChikuCode());
        this.todofukenNamePrint = TodofukenNamePrint.toValue(entity.getTyohyoTodoufukenHyojiUmu());
        this.gunNamePrint = GunNamePrint.toValue(entity.getTyohyoGunHyojiUmu());
        this.shichosonNamePrint = ShichosonNamePrint.toValue(entity.getTyohyoShichosonHyojiUmu());
        //        this.jushoEditPattern =
        this.katagakiPrint = KatagakiPrint.toValue(entity.getTyohyoKatagakiHyojiUmu());
        this.foreignersName = ForeignersNameOutput.toValue(entity.getGaikokujinHyojiHouhou());
        this.rokenShichosonNo = new RokenShichosonNo(entity.getRojinhokenShichosonNo());
        this.rokenJukyushaNoTaikei = RokenJukyushaNoTaikei.toValue(entity.getRokenJukyushaNoTaikei());
        this.kyuShichosonKubun = GappeiKyuShichosonKubun.toValue(entity.getGappeiKyuShichosonKubun());
        this.gappeiLinkNo = new GappeiLinkNo(entity.getGappeiLinkNo());
        this.gappeiShichosonOutput = GappeiKyuShichosonOutput.toValue(entity.getGappeiKyuShichosonHyojiUmu());
        this.UnyoKeitaiKubun = UnyoKeitaiKubun.toValue(entity.getUnyoKeitaiKubun());
    }

    @Override
    public ShichosonShikibetsuID get市町村識別ID() {
        return this.shichosonShikibetsuId;
    }

    /**
     * 市町村識別IDを設定します。
     *
     * @param 市町村識別ID {@link ShichosonShikibetsuID 市町村識別ID}
     * @throws NullPointerException 引数がnullの時
     */
    public void set市町村識別ID(ShichosonShikibetsuID 市町村識別ID) throws NullPointerException {
        Objects.requireNonNull(市町村識別ID);
        this.entity.setShichosonShokibetsuID(市町村識別ID.value());
        this.shichosonShikibetsuId = 市町村識別ID;
    }

    @Override
    public ShichosonCode get市町村コード() {
        return this.entity.getShichosonCode();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード {@link ShichosonCode 市町村コード}
     * @throws NullPointerException 引数がnullの時
     */
    public void set市町村コード(ShichosonCode 市町村コード) throws NullPointerException {
        Objects.requireNonNull(市町村コード);
        this.entity.setShichosonCode(市町村コード);
    }

    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.entity.getShoKisaiHokenshaNo();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 {@link ShoKisaiHokenshaNo 証記載保険者番号}
     * @throws NullPointerException 引数がnullの時
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) throws NullPointerException {
        Objects.requireNonNull(証記載保険者番号);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    @Override
    public KokuhorenKoikiShichosonNo get国保連広域内市町村番号() {
        return this.kokuhorenKoikiShichosonNo;
    }

    /**
     * 国保連広域内市町村番号を設定します。引数がnullの時は、{@link KokuhorenKoikiShichosonNo#EMPTY}を設定します。
     *
     * @param 国保連広域内市町村番号 {@link KokuhorenKoikiShichosonNo 国保連広域内市町村番号}
     */
    public void set国保連広域内市町村番号(KokuhorenKoikiShichosonNo 国保連広域内市町村番号) {
        KokuhorenKoikiShichosonNo no = DbOptional.ofNullable(国保連広域内市町村番号).orElse(KokuhorenKoikiShichosonNo.EMPTY);
        this.entity.setKokuhorenKoikiShichosonNo(no.value());
        this.kokuhorenKoikiShichosonNo = no;
    }

    @Override
    public RString get市町村名() {
        return this.entity.getShichosonMeisho();
    }

    /**
     * 市町村名を設定します。引数がnullの場合は、{@link RString#EMPTY}を設定します。
     *
     * @param 市町村名 市町村名
     */
    public void set市町村名(RString 市町村名) {
        this.entity.setShichosonMeisho(DbOptional.ofNullable(市町村名).orElse(RString.EMPTY));
    }

    @Override
    public RString get都道府県名() {
        return this.entity.getTodofukenMeisho();
    }

    /**
     * 都道府県名を設定します。引数がnullの場合は、{@link RString#EMPTY}を設定します。
     *
     * @param 都道府県名 都道府県名
     */
    public void set都道府県名(RString 都道府県名) {
        this.entity.setTodofukenMeisho(DbOptional.ofNullable(都道府県名).orElse(RString.EMPTY));
    }

    @Override
    public RString get郡名() {
        return this.entity.getGunMeisho();
    }

    /**
     * 群名を設定します。引数がnullの場合は、{@link RString#EMPTY}を設定します。
     *
     * @param 群名 群名
     */
    public void set群名(RString 群名) {
        this.entity.setTodofukenMeisho(DbOptional.ofNullable(群名).orElse(RString.EMPTY));
    }

    @Override
    public AtenaJusho get住所() {
        return this.entity.getJusho();
    }

    /**
     * 保険者の住所を設定します。引数がnullの場合は、{@link AtenaJusho#EMPTY}を設定します。
     *
     * @param jusho 保険者の住所
     */
    public void set住所(AtenaJusho jusho) {
        this.entity.setJusho(DbOptional.ofNullable(jusho).orElse(AtenaJusho.EMPTY));
    }

    @Override
    public YubinNo get郵便番号() {
        return this.entity.getYubinNo();
    }

    /**
     * 保険者の郵便番号を設定します。引数がnullの場合は、{@link YubinNo#EMPTY}を設定します。
     *
     * @param yubinNo 保険者の郵便番号
     */
    public void set郵便番号(YubinNo yubinNo) {
        this.entity.setYubinNo(DbOptional.ofNullable(yubinNo).orElse(YubinNo.EMPTY));
    }

    @Override
    public TelNo get電話番号() {
        return this.entity.getTelNo();
    }

    /**
     * 保険者の電話番号を設定します。引数がnullの場合は、{@link TelNo#EMPTY}を設定します。
     *
     * @param telNo 保険者の電話番号
     */
    public void set電話番号(TelNo telNo) {
        this.entity.setTelNo(DbOptional.ofNullable(telNo).orElse(TelNo.EMPTY));
    }

    @Override
    public TopPriorityArea get最優先地区() {
        return this.topPriorityArea;
    }

    /**
     * 最優先地区を設定します。引数がnullの場合は、{@link TopPriorityArea#未設定}を設定します。
     *
     * @param 最優先地区 {@link TopPriorityArea 最優先地区}
     */
    public void set最優先地区(TopPriorityArea 最優先地区) {
        TopPriorityArea area = DbOptional.ofNullable(最優先地区).orElse(TopPriorityArea.未設定);
        this.entity.setYusenChikuCode(area.code());
        this.topPriorityArea = area;
    }

    @Override
    public TodofukenNamePrint get都道府県名表示有無() {
        return this.todofukenNamePrint;
    }

    /**
     * 都道府県名表示有無を設定します。
     *
     * @param 都道府県名表示有無 {@link TodofukenNamePrint 都道府県名表示有無}
     */
    public void set都道府県名表示有無(TodofukenNamePrint 都道府県名表示有無) {
        Objects.requireNonNull(都道府県名表示有無);
        this.entity.setTyohyoTodoufukenHyojiUmu(都道府県名表示有無.code());
        this.todofukenNamePrint = 都道府県名表示有無;
    }

    @Override
    public GunNamePrint get群名表示有無() {
        return this.gunNamePrint;
    }

    /**
     * 群名表示有無を設定します。
     *
     * @param 群名表示有無 {@link GunNamePrint 群名表示有無}
     */
    public void set群名表示有無(GunNamePrint 群名表示有無) throws NullPointerException {
        Objects.requireNonNull(群名表示有無);
        this.entity.setTyohyoGunHyojiUmu(群名表示有無.code());
        this.gunNamePrint = 群名表示有無;
    }

    @Override
    public ShichosonNamePrint get市町村名表示有無() {
        return this.shichosonNamePrint;
    }

    /**
     * 市町村名表示有無を設定します。
     *
     * @param 市町村名表示有無 {@link ShichosonNamePrint 市町村名表示有無}
     */
    public void set市町村名表示有無(ShichosonNamePrint 市町村名表示有無) {
        Objects.requireNonNull(市町村名表示有無);
        this.entity.setTyohyoShichosonHyojiUmu(市町村名表示有無.code());
        this.shichosonNamePrint = 市町村名表示有無;
    }

    @Override
    public JushoEditPattern get住所編集方法() {
        return this.jushoEditPattern;
    }

    /**
     * 住所編集方法を設定します。
     *
     * @param 住所編集方法 {@link JushoEditPattern 住所編集方法}
     */
    public void set住所編集方法(JushoEditPattern 住所編集方法) {
    }

    @Override
    public KatagakiPrint get方書表示有無() {
        return this.katagakiPrint;
    }

    /**
     * 方書表示有無を設定します。
     *
     * @param 方書表示有無 {@link KatagakiPrint 方書表示有無}
     */
    public void set方書表示有無(KatagakiPrint 方書表示有無) {
        this.entity.setTyohyoKatagakiHyojiUmu(方書表示有無.code());
        this.katagakiPrint = 方書表示有無;
    }

    @Override
    public ForeignersNameOutput get外国人氏名表示方法() {
        return this.foreignersName;
    }

    /**
     * 外国人表示方法を設定します。
     *
     * @param 外国人表示方法 {@link ForeignersNameOutput 外国人表示方法}
     */
    public void set外国人氏名表示方法(ForeignersNameOutput 外国人表示方法) {
        this.entity.setGaikokujinHyojiHouhou(外国人表示方法.code());
        this.foreignersName = 外国人表示方法;
    }

    @Override
    public RokenShichosonNo get老人保健市町村番号() {
        return this.rokenShichosonNo;
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 {@link RokenShichosonNo 老人保健市町村番号}
     */
    public void set老人保険市町村番号(RokenShichosonNo 老人保健市町村番号) {
        RokenShichosonNo no = DbOptional.ofNullable(老人保健市町村番号).orElse(RokenShichosonNo.EMPTY);
        this.entity.setRojinhokenShichosonNo(no.value());
        this.rokenShichosonNo = no;
    }

    @Override
    public RokenJukyushaNoTaikei get老人保健受給者番号体系() {
        return this.rokenJukyushaNoTaikei;
    }

    /**
     * 老人保健受給者番号体系を設定します。
     *
     * @param 老人保健受給者番号体系 {@link RokenJukyushaNoTaikei 老人保健受給者番号体系}
     */
    public void set老人保健受給者番号体系(RokenJukyushaNoTaikei 老人保健受給者番号体系) {
        RokenJukyushaNoTaikei taikei = DbOptional.ofNullable(老人保健受給者番号体系).orElse(RokenJukyushaNoTaikei.設定なし);
        this.entity.setRokenJukyushaNoTaikei(taikei.code());
        this.rokenJukyushaNoTaikei = taikei;
    }

    @Override
    public FlexibleDate get移行日() {
        return this.entity.getIkoYMD();
    }

    /**
     * 移行日を設定します。
     *
     * @param 移行日 移行日
     */
    public void set移行日(FlexibleDate 移行日) {
        this.entity.setIkoYMD(DbOptional.ofNullable(移行日).orElse(FlexibleDate.MAX));
    }

    @Override
    public FlexibleDate get加入日() {
        return this.entity.getKanyuYMD();
    }

    /**
     * 加入日を設定します。
     *
     * @param 加入日 加入日
     */
    public void set加入日(FlexibleDate 加入日) {
        this.entity.setKanyuYMD(DbOptional.ofNullable(加入日).orElse(FlexibleDate.EMPTY));
    }

    @Override
    public FlexibleDate get離脱日() {
        return this.entity.getRidatsuYMD();
    }

    /**
     * 離脱日を設定します。
     *
     * @param 離脱日 離脱日
     */
    public void set離脱日(FlexibleDate 離脱日) {
        this.entity.setRidatsuYMD(DbOptional.ofNullable(離脱日).orElse(FlexibleDate.MAX));
    }

    @Override
    public GappeiKyuShichosonKubun get合併旧市町村区分() {
        return this.kyuShichosonKubun;
    }

    /**
     * 合併旧市町村区分を設定します。
     *
     * @param 合併旧市町村区分 {@link GappeiKyuShichosonKubun 合併旧市町村区分}
     */
    public void set合併旧市町村区分(GappeiKyuShichosonKubun 合併旧市町村区分) {
        this.entity.setGappeiKyuShichosonKubun(合併旧市町村区分.code());
        this.kyuShichosonKubun = 合併旧市町村区分;
    }

    @Override
    public GappeiKyuShichosonOutput get合併旧市町村表示有無() {
        return this.gappeiShichosonOutput;
    }

    /**
     * 合併旧市町村表示有無を設定します。
     *
     * @param 合併旧市町村表示有無 {@link GappeiKyuShichosonOutput 合併旧市町村表示有無}
     */
    public void set合併旧市町村表示有無(GappeiKyuShichosonOutput 合併旧市町村表示有無) {
        GappeiKyuShichosonOutput kubun = DbOptional.ofNullable(合併旧市町村表示有無).orElse(GappeiKyuShichosonOutput.設定なし);
        this.entity.setGappeiKyuShichosonHyojiUmu(kubun.code());
        this.gappeiShichosonOutput = kubun;
    }

    @Override
    public GappeiLinkNo get合併情報地域番号() {
        return this.gappeiLinkNo;
    }

    /**
     * 合併情報地域番号を設定します。
     *
     * @param 合併情報地域番号 {@link GappeiLinkNo 合併情報地域番号}
     */
    public void set合併情報地域番号(GappeiLinkNo 合併情報地域番号) {
        GappeiLinkNo no = DbOptional.ofNullable(合併情報地域番号).orElse(GappeiLinkNo.EMPTY);
        this.entity.setGappeiLinkNo(no.value());
        this.gappeiLinkNo = no;
    }

    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return this.entity.getUnyoHokenshaNo();
    }

    /**
     * 運用保険者番号を設定します。
     *
     * @param 運用保険者番号 {@link ShoKisaiHokenshaNo 運用保険者番号}
     */
    public void set運用保険者番号(ShoKisaiHokenshaNo 運用保険者番号) {
        Objects.requireNonNull(運用保険者番号);
        this.entity.setUnyoHokenshaNo(運用保険者番号);
    }

    @Override
    public FlexibleDate get運用開始日() {
        return this.entity.getUnyoKaishiYMD();
    }

    /**
     * 運用開始日を設定します。
     *
     * @param date 運用開始日
     */
    public void set運用開始日(FlexibleDate date) {
        this.entity.setUnyoKaishiYMD(DbOptional.ofNullable(date).orElse(FlexibleDate.EMPTY));
    }

    @Override
    public FlexibleDate get運用終了日() {
        return this.entity.getUnyoShuryoYMD();
    }

    /**
     * 運用終了日を設定します。
     *
     * @param date 運用終了日
     */
    public void set運用終了日(FlexibleDate date) {
        this.entity.setUnyoShuryoYMD(DbOptional.ofNullable(date).orElse(FlexibleDate.MAX));
    }

    @Override
    public UnyoKeitaiKubun get運用形態区分() {
        return this.UnyoKeitaiKubun;
    }

    /**
     * 運用形態区分を設定します。
     *
     * @param 運用形態区分 {@link UnyoKeitaiKubun 運用形態区分}
     */
    public void set運用形態区分(UnyoKeitaiKubun 運用形態区分) {
        this.entity.setUnyoKeitaiKubun(運用形態区分.code());
        this.UnyoKeitaiKubun = 運用形態区分;
    }

    @Override
    public IValidationMessages validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * entityを返します。
     *
     * @return {@link DbT7051KoseiShichosonMasterEntity entity}
     */
    public DbT7051KoseiShichosonMasterEntity getEntity() {
        return this.entity;
    }

}
