/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakuteisei;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei.JushochiTokureiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei.ShikakuKanrenYidouEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei.ShikakuSyousayiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei.ShikakuTeyiseyiEntity;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.sikakuidocheck.SikakuIdoCheckManager;
import jp.co.ndensan.reams.db.dbz.service.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳管理（資格訂正）を管理するクラスです。
 */
public class HihokenshaShikakuTeiseiManager {

    private static final int AGE_40 = 40;
    private static final int AGE_65 = 65;
    //TODO QA:252 出力パラメータは「エラーコード」と「メッセージ」ですか。 2015/12/23まで
    private static final RString ERR_CODE_DBAE00020 = new RString("DBAE00020");
    private static final RString ERR_CODE_DBAE00021 = new RString("DBAE00021");
    private static final RString ERR_CODE_DBAE00022 = new RString("DBAE00022");
    private static final RString ERR_CODE_DBAE00023 = new RString("DBAE00023");
    private static final RString ERR_CODE_DBAE00009 = new RString("DBAE00009");
    private static final RString ERR_CODE_DBZE00006 = new RString("DBZE00006");
    private static final RString ERR_CODE_DBAE00008 = new RString("DBAE00008");
    private static final RString ERR_CODE_DBAE00010 = new RString("DBAE00010");
    private static final RString ERR_CODE_DBAE00011 = new RString("DBAE00011");
    private static final RString ERR_CODE_DBAE00012 = new RString("DBAE00012");
    private static final RString ERR_CODE_DBAE00013 = new RString("DBAE00013");
    private static final RString ERR_CODE_DBAE00014 = new RString("DBAE00014");
    private static final RString ERR_CODE_DBAE00015 = new RString("DBAE00015");
    private static final RString ERR_CODE_DBAE00024 = new RString("DBAE00024");
    private static final RString ERR_CODE_DBAE00018 = new RString("DBAE00018");
    private static final RString ERR_CODE_DBAE00019 = new RString("DBAE00019");
    private static final RString ERR_CODE_DBAE00025 = new RString("DBAE00025");
    private static final RString HIHORIREKI = new RString("被保履歴");
    private static final RString DATASYUUSEI = new RString("データ修正");
    private static final RString GAMENFLG = new RString("被保履歴");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_02 = new RString("02");
    private static final RString RSTRING_04 = new RString("04");
    private static final RString RSTRING_SPACE = new RString("");
    private static final RString FLG_削除 = new RString("削除");
    private static final RString FLG_無 = new RString("無");
    private static final LasdecCode コード = new LasdecCode("");
    private static final Code CODE_112 = new Code("112");
    private static final Code CODE_120 = new Code("120");
    private static final Code CODE_111 = new Code("111");
    private final DbT1001HihokenshaDaichoDac dac;
    private final HihokenshaShikakuShutokuManager getShutokuManager;
    private final KoikiShichosonJohoFinder 市町村情報取得Finder;
    private final SikakuIdoCheckManager getIdoCheckManager;
    private KyuShichosonCodeJoho kyuShichosonCodeJoho;
    private AgeCalculator getAge;
    private SikakuKikan sikakuKikan;
    private TokusoRireki tokusoRireki;

    /**
     * コンストラクタです。
     */
    HihokenshaShikakuTeiseiManager() {
        this.dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.getShutokuManager = InstanceProvider.create(HihokenshaShikakuShutokuManager.class);
        this.市町村情報取得Finder = InstanceProvider.create(KoikiShichosonJohoFinder.class);
        this.kyuShichosonCodeJoho = InstanceProvider.create(KyuShichosonCodeJoho.class);
        this.getIdoCheckManager = InstanceProvider.create(SikakuIdoCheckManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac IHihokenshaShikakuTeiseiDac
     */
    HihokenshaShikakuTeiseiManager(DbT1001HihokenshaDaichoDac dac, HihokenshaShikakuShutokuManager getShutokuManager,
            KoikiShichosonJohoFinder 市町村情報取得Finder, KyuShichosonCodeJoho kyuShichosonCodeJoho, SikakuIdoCheckManager getIdoCheckManager) {
        this.dac = dac;
        this.getShutokuManager = getShutokuManager;
        this.市町村情報取得Finder = 市町村情報取得Finder;
        this.kyuShichosonCodeJoho = kyuShichosonCodeJoho;
        this.getIdoCheckManager = getIdoCheckManager;
    }

    /**
     * 被保険者台帳管理資格訂正の処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 取得日 取得日
     * @param 喪失日 喪失日
     * @param 資格訂正登録リスト 資格訂正登録リスト
     */
    //TODO 入力項目「喪失日」に処理詳細で利用されない、QA301 2015/12/24まで
    public void saveHihokenshaShikakuTeisei(HihokenshaNo 被保険者番号, FlexibleDate 取得日, FlexibleDate 喪失日,
            List<HihokenshaShutokuJyoho> 資格訂正登録リスト) {
        List<DbT1001HihokenshaDaichoEntity> dbT1001List = dac.selectByHihokenshaNo(被保険者番号, 取得日);
        if (資格訂正登録リスト != null && !資格訂正登録リスト.isEmpty()) {
            for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
                for (DbT1001HihokenshaDaichoEntity dbT1001 : dbT1001List) {
                    if (!this.getListVsEntity(hihokenshaShutokuJyoho, dbT1001)) {
                        DbT1001HihokenshaDaichoEntity dbT1001entity = this.getListToEntity(hihokenshaShutokuJyoho,
                                new DbT1001HihokenshaDaichoEntity());
                        dbT1001entity.setEdaNo(getShutokuManager.getSaidaiEdaban(hihokenshaShutokuJyoho.get被保険者番号(),
                                hihokenshaShutokuJyoho.get異動日()));
                        dac.save(dbT1001entity);
                    }
                }
            }
        }
        if (dbT1001List != null && !dbT1001List.isEmpty()) {
            for (DbT1001HihokenshaDaichoEntity dbT1001 : dbT1001List) {
                for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
                    if (!this.getListVsEntity(hihokenshaShutokuJyoho, dbT1001)) {
                        DbT1001HihokenshaDaichoEntity dbT1001entity = this.getListToEntity2(hihokenshaShutokuJyoho, dbT1001);
                        dbT1001entity.setLogicalDeletedFlag(true);
                        dbT1001entity.setState(EntityDataState.Modified);
                        dac.save(dbT1001entity);
                    }
                }
            }
        }
    }

    /**
     * 資格訂正登録リスト取得の処理です。
     *
     * @param 資格詳細情報 資格詳細情報
     * @param 住所地特例 住所地特例
     * @param 資格関連異動 住所地特例
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @return SearchResult<HihokenshaShutokuJyoho> 資格訂正登録リスト
     */
    @SuppressWarnings("SIC_INNER_SHOULD_BE_STATIC_ANON")
    public SearchResult<HihokenshaShutokuJyoho> getShikakuTorukuList(ShikakuSyousayiEntity 資格詳細情報, List<JushochiTokureiEntity> 住所地特例,
            List<ShikakuKanrenYidouEntity> 資格関連異動, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        List<ShikakuTeyiseyiEntity> entityList = new ArrayList<>();
        List<HihokenshaShutokuJyoho> shutokuJyohoList = new ArrayList<>();
        //TODO 「被保履歴を追加する場合」と「データを修正場合」の判定フラグに画面中で設定されましたか？しかし入力項目には記載しない。QA301　2015/12/23まで
        if (GAMENFLG.equals(HIHORIREKI)) {
            entityList = this.get資格訂正情報リスト1(資格詳細情報, 住所地特例, 資格関連異動).records();
        } else if (GAMENFLG.equals(DATASYUUSEI)) {
            entityList = this.get資格訂正情報リスト2(資格詳細情報, 住所地特例, 資格関連異動).records();
        }
        Collections.sort(entityList);
        if (this.get資格訂正登録リスト(shutokuJyohoList, entityList, 被保険者番号, 識別コード).records().isEmpty()) {
            return SearchResult.of(shutokuJyohoList, 0, false);
        }
        return SearchResult.of(shutokuJyohoList, 0, false);
    }

    /**
     * 資格訂正登録リストチェックの処理です。
     *
     * @param 資格訂正登録リスト 資格訂正登録リスト
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @return ERR_CODE エラーコード
     */
    @SuppressWarnings("NM_METHOD_NAMING_CONVENTION")
    public RString shikakuTorukuListCheck(List<HihokenshaShutokuJyoho> 資格訂正登録リスト, IDateOfBirth 当該識別対象の生年月日) {
        //TODO 引数の資格訂正登録リストのデータは異動日昇順を配列する。 QA301　2015/12/24まで
        //Collections.sort(資格訂正登録リスト);
        RString errorCode = new RString("");
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
            if (!hihokenshaShutokuJyoho.get資格取得事由コード().isEmpty()) {
                errorCode = this.資格取得チェック処理(hihokenshaShutokuJyoho.get資格取得年月日(), hihokenshaShutokuJyoho.get資格取得事由コード(),
                        hihokenshaShutokuJyoho.get被保険者区分コード(), hihokenshaShutokuJyoho.get第1号資格取得年月日(), 当該識別対象の生年月日);
                if (!errorCode.isEmpty()) {
                    return errorCode;
                }
            }
            if (entity.getHihokenshaNo() != null) {
                if (!hihokenshaShutokuJyoho.get資格喪失事由コード().isEmpty()) {
                    for (HihokenshaShutokuJyoho kujyoho : 資格訂正登録リスト) {
                        tokusoRireki = new TokusoRireki(kujyoho.get資格取得年月日(), kujyoho.get資格喪失年月日());
                    }
                    List<TokusoRireki> tokusoRirekiList = new ArrayList<>();
                    tokusoRirekiList.add(tokusoRireki);
                    errorCode = this.資格喪失チェック処理(entity, hihokenshaShutokuJyoho.get資格喪失年月日(), 当該識別対象の生年月日, tokusoRirekiList);
                    if (!errorCode.isEmpty()) {
                        return errorCode;
                    }
                }
                if (!hihokenshaShutokuJyoho.get資格変更事由コード().isEmpty()) {
                    errorCode = this.資格変更チェック処理(entity, hihokenshaShutokuJyoho.get資格変更年月日(),
                            hihokenshaShutokuJyoho.get資格変更事由コード(), 当該識別対象の生年月日);
                    if (!errorCode.isEmpty()) {
                        return errorCode;
                    }
                }

                if (!hihokenshaShutokuJyoho.get住所地特例適用事由コード().isEmpty()) {
                    errorCode = this.住所地特例チェック処理(entity, hihokenshaShutokuJyoho.get適用年月日(),
                            hihokenshaShutokuJyoho.get住所地特例適用事由コード(), hihokenshaShutokuJyoho.get解除年月日(),
                            hihokenshaShutokuJyoho.get住所地特例解除事由コード());
                    if (!errorCode.isEmpty()) {
                        return errorCode;
                    }
                }
                if (!hihokenshaShutokuJyoho.get住所地特例解除事由コード().isEmpty()) {
                    errorCode = this.住所地特例チェック処理(entity, hihokenshaShutokuJyoho.get適用年月日(),
                            hihokenshaShutokuJyoho.get住所地特例適用事由コード(), hihokenshaShutokuJyoho.get解除年月日(),
                            hihokenshaShutokuJyoho.get住所地特例解除事由コード());
                    if (!errorCode.isEmpty()) {
                        return errorCode;
                    }
                }
            }
            entity = this.getListToEntity(hihokenshaShutokuJyoho, entity);
        }
        return errorCode;
    }

    /**
     * 資格取得チェック処理です。
     *
     * @param 取得日 取得日
     * @param 取得事由コード 取得事由コード
     * @param 被保区分コード 被保区分コード
     * @param 第1号資格取得年月日 第1号資格取得年月日
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @return ERR_CODE エラーコード
     */
    //TODO 入力項目「第1号資格取得年月日」に処理詳細で利用されない。QA301　2015/12/23まで
    @SuppressWarnings("UWF_UNWRITTEN_FIELD")
    private RString 資格取得チェック処理(FlexibleDate 取得日, RString 取得事由コード, RString 被保区分コード, FlexibleDate 第1号資格取得年月日,
            IDateOfBirth 当該識別対象の生年月日) {
        RString errorCode = new RString("");
        int age = Integer.valueOf(get年齢(当該識別対象の生年月日, 取得日).toString());
        if (取得事由コード.equals(ShikakuShutokuJiyu.年齢到達.getコード())) {
            FlexibleDate 年齢到達日 = getAge.get年齢到達日(AGE_65);
            if (取得日.isBefore(年齢到達日) || 年齢到達日.isBefore(取得日)) {
                return ERR_CODE_DBAE00020;
            }
        } else if (age < AGE_40) {
            return ERR_CODE_DBAE00021;
        }
        if (被保区分コード.equals(RSTRING_1) && age < AGE_65) {
            return ERR_CODE_DBAE00022;
        } else if (被保区分コード.equals(RSTRING_2) && age < AGE_65) {
            return ERR_CODE_DBAE00023;
        }
        return errorCode;
    }

    /**
     * 資格喪失チェック処理です。
     *
     * @param 最新データ 最新データ
     * @param 喪失年月日 喪失年月日
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @param tokusoRirekiList List<TokusoRireki>
     * @return ERR_CODE エラーコード
     */
    @SuppressWarnings("NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    @java.lang.SuppressWarnings("null")
    private RString 資格喪失チェック処理(DbT1001HihokenshaDaichoEntity 最新データ, FlexibleDate 喪失年月日, IDateOfBirth 当該識別対象の生年月日,
            List<TokusoRireki> tokusoRirekiList) {
        RString errorCode = new RString("");
        if (最新データ.getHihokenshaNo() != null && !最新データ.getHihokenshaNo().isEmpty()) {
            if (最新データ.getIchigoShikakuShutokuYMD() == null || 最新データ.getIchigoShikakuShutokuYMD().isEmpty()) {
                int age = Integer.valueOf(get年齢(当該識別対象の生年月日, 喪失年月日).toString());
                if (age >= AGE_65) {
                    return ERR_CODE_DBAE00009;
                }
                if (喪失年月日.isBefore(最新データ.getShikakuShutokuYMD())) {
                    return ERR_CODE_DBZE00006;
                }
                for (TokusoRireki tokusoRireki1 : tokusoRirekiList) {
                    sikakuKikan = new SikakuKikan(tokusoRireki1.getKaishiYMD(), tokusoRireki1.getShuryoYMD());
                }
                List<SikakuKikan> sikakuKikanList = new ArrayList<>();
                sikakuKikanList.add(sikakuKikan);
                errorCode = getIdoCheckManager.sikakuKikanRirekiChofukuCheck(sikakuKikanList);
                if (!errorCode.isEmpty()) {
                    return errorCode;
                }
                errorCode = getIdoCheckManager.tokusouTanoKikanChofukuCheck(tokusoRirekiList, 最新データ.getShikibetsuCode());
                if (!errorCode.isEmpty()) {
                    return errorCode;
                }
            }
        } else if (最新データ.getHihokenshaNo() == null || 最新データ.getHihokenshaNo().isEmpty()) {
            return ERR_CODE_DBAE00008;
        }
        return errorCode;
    }

    /**
     * 資格変更チェック処理です。
     *
     * @param 最新データ 最新データ
     * @param 変更日 変更日
     * @param 変更事由コード 変更事由コード
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @return ERR_CODE エラーコード
     */
    @java.lang.SuppressWarnings("null")
    @SuppressWarnings("NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    private RString 資格変更チェック処理(DbT1001HihokenshaDaichoEntity 最新データ, FlexibleDate 変更日, RString 変更事由コード,
            IDateOfBirth 当該識別対象の生年月日) {
        RString errorCode = new RString("");
        if (最新データ.getHihokenshaNo() != null && !最新データ.getHihokenshaNo().isEmpty()) {
            if (変更日.isBefore(最新データ.getIdoYMD())) {
                return ERR_CODE_DBAE00010;
            }
            int age = Integer.valueOf(get年齢(当該識別対象の生年月日, 変更日).toString());
            if (最新データ.getHihokennshaKubunCode().equals(RSTRING_1)) {
                if (age >= AGE_65 && 変更事由コード.equals(new RString(ShikakuHenkoJiyu._１号到達.getコード().toString()))) {
                    return ERR_CODE_DBAE00011;
                }
                if (age < AGE_65) {
                    return ERR_CODE_DBAE00012;
                }
            }
            if (最新データ.getHihokennshaKubunCode().equals(RSTRING_2)) {
                if (age >= AGE_65) {
                    if (!変更事由コード.equals(new RString(ShikakuHenkoJiyu._１号到達.getコード().toString()))) {
                        return ERR_CODE_DBAE00013;
                    }
                    if (変更事由コード.equals(new RString(ShikakuHenkoJiyu._１号到達.getコード().toString()))
                            && 変更日.isBefore(getAge.get年齢到達日(AGE_65)) || getAge.get年齢到達日(AGE_65).isBefore(変更日)) {
                        return ERR_CODE_DBAE00014;
                    }
                }
                if (age < AGE_65 && 変更事由コード.equals(new RString(ShikakuHenkoJiyu._１号到達.getコード().toString()))) {
                    return ERR_CODE_DBAE00014;
                }
            }
            if (変更事由コード.equals(new RString(ShikakuHenkoJiyu.広住特転入.getコード().toString()))
                    || 変更事由コード.equals(new RString(ShikakuHenkoJiyu.広住特居住.getコード().toString()))
                    && 最新データ.getKoikinaiJushochiTokureiFlag().equals(RSTRING_1)) {
                return ERR_CODE_DBAE00015;
            }
            if (最新データ.getKoikinaiJushochiTokureiFlag().equals(RSTRING_1)
                    && 変更事由コード.equals(new RString(ShikakuHenkoJiyu.広住特適用.getコード().toString()))) {
                return ERR_CODE_DBAE00024;
            }
        }
        return errorCode;
    }

    /**
     * 住所地特例チェック処理です。
     *
     * @param 最新データ 最新データ
     * @param 適用日 適用日
     * @param 適用事由コード 適用事由コード
     * @param 解除日 解除日
     * @param 解除事由コード 解除事由コード
     * @return ERR_CODE エラーコード
     */
    //TODO 入力項目「適用日」と「解除日」に処理詳細で利用されない。QA301　2015/12/23まで
    @SuppressWarnings("NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE")
    @java.lang.SuppressWarnings("null")
    private RString 住所地特例チェック処理(DbT1001HihokenshaDaichoEntity 最新データ, FlexibleDate 適用日, RString 適用事由コード,
            FlexibleDate 解除日, RString 解除事由コード) {
        RString errorCode = new RString("");
        if (最新データ.getJushochitokureiTekiyoJiyuCode() != null && 最新データ.getJushochitokureiKaijoJiyuCode() == null
                && !最新データ.getJushochitokureiTekiyoJiyuCode().isEmpty()) {
            this.getERRCODE(適用事由コード, 解除事由コード);
        } else if (最新データ.getJushochitokureiTekiyoJiyuCode() != null && 最新データ.getJushochitokureiKaijoJiyuCode() != null
                && !最新データ.getJushochitokureiTekiyoJiyuCode().isEmpty() && 最新データ.getJushochitokureiKaijoJiyuCode().isEmpty()) {
            this.getERRCODE(適用事由コード, 解除事由コード);
        }
        if (適用事由コード != null && 解除事由コード != null && !適用事由コード.isEmpty() && !解除事由コード.isEmpty()
                && 最新データ.getJushochitokureiTekiyoJiyuCode() != null && !最新データ.getJushochitokureiTekiyoJiyuCode().isEmpty()
                && 最新データ.getJushochitokureiKaijoJiyuCode() != null && !最新データ.getJushochitokureiKaijoJiyuCode().isEmpty()) {
            return ERR_CODE_DBAE00019;
        }
        return errorCode;
    }

    private RString getERRCODE(RString 適用事由コード, RString 解除事由コード) {
        RString errorCode = new RString("");
        if ((適用事由コード != null && !適用事由コード.isEmpty()) && (解除事由コード == null || 解除事由コード.isEmpty())) {
            return ERR_CODE_DBAE00018;
        }
        return errorCode;
    }

    /**
     * 画面訂正チェック処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return errorCode エラーコード
     */
    @SuppressWarnings("NM_METHOD_NAMING_CONVENTION")
    public RString teiseiCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RString errorCode = new RString("");
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = getShutokuManager.getSaishinDeta(識別コード, 被保険者番号);
        List<HihokenshaShutokuJyoho> saishin = new ArrayList<>();
        saishin.add(hihokenshaShutokuJyoho);
        if (saishin.isEmpty()) {
            return ERR_CODE_DBAE00025;
        }
        return errorCode;
    }

    private boolean getListVsEntity(HihokenshaShutokuJyoho hihokenshaShutokuJyoho, DbT1001HihokenshaDaichoEntity entity) {
        if (!hihokenshaShutokuJyoho.get被保険者番号().equals(entity.getHihokenshaNo())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get異動日().equals(entity.getIdoYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get異動事由コード().equals(entity.getIdoJiyuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get市町村コード().equals(entity.getShichosonCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get識別コード().equals(entity.getShikibetsuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格取得事由コード().equals(entity.getShikakuShutokuJiyuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格取得年月日().equals(entity.getShikakuShutokuYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格取得届出年月日().equals(entity.getShikakuShutokuTodokedeYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get第1号資格取得年月日().equals(entity.getIchigoShikakuShutokuYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get被保険者区分コード().equals(entity.getHihokennshaKubunCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格喪失事由コード().equals(entity.getShikakuSoshitsuJiyuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格喪失年月日().equals(entity.getShikakuSoshitsuYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格喪失届出年月日().equals(entity.getShikakuSoshitsuTodokedeYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格変更事由コード().equals(entity.getShikakuHenkoJiyuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格変更年月日().equals(entity.getShikakuHenkoYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get資格変更届出年月日().equals(entity.getShikakuHenkoTodokedeYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get住所地特例適用事由コード().equals(entity.getJushochitokureiTekiyoJiyuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get適用年月日().equals(entity.getJushochitokureiTekiyoYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get適用届出年月日().equals(entity.getJushochitokureiTekiyoTodokedeYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get住所地特例解除事由コード().equals(entity.getJushochitokureiKaijoJiyuCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get解除年月日().equals(entity.getJushochitokureiKaijoYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get解除届出年月日().equals(entity.getJushochitokureiKaijoTodokedeYMD())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get住所地特例フラグ().equals(entity.getJushochiTokureiFlag())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get広域内住所地特例フラグ().equals(entity.getKoikinaiJushochiTokureiFlag())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get広住特措置元市町村コード().equals(entity.getKoikinaiTokureiSochimotoShichosonCode())) {
            return false;
        } else if (!hihokenshaShutokuJyoho.get旧市町村コード().equals(entity.getKyuShichosonCode())) {
            return false;
        } else if (hihokenshaShutokuJyoho.is論理削除フラグ() != entity.getLogicalDeletedFlag()) {
            return false;
        }
        return true;
    }

    private DbT1001HihokenshaDaichoEntity getListToEntity(HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        dbT1001Entity.setEdaNo(hihokenshaShutokuJyoho.get枝番());
        dbT1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
        dbT1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
        dbT1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
        dbT1001Entity.setIdoJiyuCode(hihokenshaShutokuJyoho.get異動事由コード());
        dbT1001Entity.setIdoYMD(hihokenshaShutokuJyoho.get異動日());
        dbT1001Entity.setJushochiTokureiFlag(hihokenshaShutokuJyoho.get住所地特例フラグ());
        dbT1001Entity.setJushochitokureiKaijoJiyuCode(hihokenshaShutokuJyoho.get住所地特例解除事由コード());
        dbT1001Entity.setJushochitokureiKaijoTodokedeYMD(hihokenshaShutokuJyoho.get解除届出年月日());
        dbT1001Entity.setJushochitokureiKaijoYMD(hihokenshaShutokuJyoho.get解除年月日());
        dbT1001Entity.setJushochitokureiTekiyoJiyuCode(hihokenshaShutokuJyoho.get住所地特例適用事由コード());
        dbT1001Entity.setJushochitokureiTekiyoTodokedeYMD(hihokenshaShutokuJyoho.get適用届出年月日());
        dbT1001Entity.setJushochitokureiTekiyoYMD(hihokenshaShutokuJyoho.get適用年月日());
        dbT1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
        dbT1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
        dbT1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
        dbT1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        dbT1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
        dbT1001Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
        dbT1001Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
        dbT1001Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
        dbT1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
        dbT1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
        dbT1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
        dbT1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
        dbT1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
        dbT1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
        dbT1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
        return dbT1001Entity;
    }

    private DbT1001HihokenshaDaichoEntity getListToEntity2(HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            DbT1001HihokenshaDaichoEntity dbT1001Entity) {
        dbT1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
        dbT1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
        dbT1001Entity.setIdoJiyuCode(hihokenshaShutokuJyoho.get異動事由コード());
        dbT1001Entity.setJushochiTokureiFlag(hihokenshaShutokuJyoho.get住所地特例フラグ());
        dbT1001Entity.setJushochitokureiKaijoJiyuCode(hihokenshaShutokuJyoho.get住所地特例解除事由コード());
        dbT1001Entity.setJushochitokureiKaijoTodokedeYMD(hihokenshaShutokuJyoho.get解除届出年月日());
        dbT1001Entity.setJushochitokureiKaijoYMD(hihokenshaShutokuJyoho.get解除年月日());
        dbT1001Entity.setJushochitokureiTekiyoJiyuCode(hihokenshaShutokuJyoho.get住所地特例適用事由コード());
        dbT1001Entity.setJushochitokureiTekiyoTodokedeYMD(hihokenshaShutokuJyoho.get適用届出年月日());
        dbT1001Entity.setJushochitokureiTekiyoYMD(hihokenshaShutokuJyoho.get適用年月日());
        dbT1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
        dbT1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
        dbT1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
        dbT1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        dbT1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
        dbT1001Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
        dbT1001Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
        dbT1001Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
        dbT1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
        dbT1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
        dbT1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
        dbT1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
        dbT1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
        dbT1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
        dbT1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
        return dbT1001Entity;
    }

    private SearchResult<HihokenshaShutokuJyoho> get資格訂正登録リスト(List<HihokenshaShutokuJyoho> 資格訂正登録リスト,
            List<ShikakuTeyiseyiEntity> 資格訂正情報List, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        for (ShikakuTeyiseyiEntity 資格訂正情報Entity : 資格訂正情報List) {
            if (!資格訂正情報Entity.get状態().equals(FLG_削除)) {
                LasdecCode 市町村コード = コード;
                LasdecCode 広住特措置元市町村コード = コード;
                LasdecCode 旧市町村コード = コード;
                if (資格訂正情報Entity.get旧保険者() != null && !資格訂正情報Entity.get旧保険者().isEmpty()) {
                    if (市町村セキュリティ情報.get導入形態コード().equals(CODE_112)) {
                        kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村セキュリティ情報.get市町村情報().get市町村コード(),
                                DonyukeitaiCode.事務構成市町村);
                        旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
                    }
                    if (市町村セキュリティ情報.get導入形態コード().equals(CODE_120)) {
                        kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村セキュリティ情報.get市町村情報().get市町村コード(),
                                DonyukeitaiCode.事務単一);
                        旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
                    }
                }
                if (市町村セキュリティ情報.get導入形態コード().equals(CODE_111)) {
                    List<KoikiZenShichosonJoho> koseiShichosonJohoList = 市町村情報取得Finder.koseiShichosonJoho().records();
                    for (KoikiZenShichosonJoho 現市町村情報 : koseiShichosonJohoList) {
                        if (現市町村情報.get証記載保険者番号().equals(new ShoKisaiHokenshaNo(資格訂正情報Entity.get所在保険者()))) {
                            市町村コード = 現市町村情報.get市町村コード();
                        }
                        if (現市町村情報.get証記載保険者番号().equals(new ShoKisaiHokenshaNo(資格訂正情報Entity.get措置元保険者()))) {
                            広住特措置元市町村コード = 現市町村情報.get市町村コード();
                        }
                    }
                    if (!広住特措置元市町村コード.isEmpty()) {
                        kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(広住特措置元市町村コード, DonyukeitaiCode.事務広域);
                        旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
                    } else if (!市町村コード.isEmpty()) {
                        kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村コード, DonyukeitaiCode.事務広域);
                        旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
                    }
                }
                if (資格訂正情報Entity.get取得事由コード() != null && !資格訂正情報Entity.get取得事由コード().isEmpty()) {
                    資格訂正登録リスト.add(new HihokenshaShutokuJyoho(this.getList取得事由コード(資格訂正情報Entity, 被保険者番号,
                            識別コード, 市町村コード, 広住特措置元市町村コード, 旧市町村コード)));
                }
                if (資格訂正情報Entity.get喪失事由コード() != null && !資格訂正情報Entity.get喪失事由コード().isEmpty()) {
                    資格訂正登録リスト.add(new HihokenshaShutokuJyoho(this.getList喪失事由コード(資格訂正登録リスト, 資格訂正情報Entity)));
                }
                if (資格訂正情報Entity.get変更事由コード() != null && !資格訂正情報Entity.get変更事由コード().isEmpty()) {
                    資格訂正登録リスト = this.getList変更事由コード(資格訂正登録リスト, 資格訂正情報Entity, 識別コード, 市町村コード,
                            広住特措置元市町村コード, 旧市町村コード).records();
                }
                if (資格訂正情報Entity.get適用事由コード() != null && !資格訂正情報Entity.get適用事由コード().isEmpty()) {
                    資格訂正登録リスト.add(new HihokenshaShutokuJyoho(this.getList適用事由コード(資格訂正登録リスト, 資格訂正情報Entity)));
                }
                if (資格訂正情報Entity.get解除事由コード() != null && !資格訂正情報Entity.get解除事由コード().isEmpty()) {
                    資格訂正登録リスト.add(new HihokenshaShutokuJyoho(this.getList解除事由コード(資格訂正登録リスト, 資格訂正情報Entity)));
                }
            }
        }
        return SearchResult.of(資格訂正登録リスト, 0, false);
    }

    private DbT1001HihokenshaDaichoEntity getList取得事由コード(ShikakuTeyiseyiEntity entity, HihokenshaNo 被保番号, ShikibetsuCode 識別コード,
            LasdecCode 市町村コード, LasdecCode 広住特措置元市町村コード, LasdecCode 旧市町村コード) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        dbt1001Entity.setHihokenshaNo(被保番号);
        dbt1001Entity.setIdoYMD(entity.get異動日());
        dbt1001Entity.setIdoJiyuCode(entity.get取得事由コード());
        dbt1001Entity.setShichosonCode(市町村コード);
        dbt1001Entity.setShikibetsuCode(識別コード);
        dbt1001Entity.setShikakuShutokuJiyuCode(entity.get取得事由コード());
        dbt1001Entity.setShikakuShutokuYMD(entity.get取得日());
        dbt1001Entity.setShikakuShutokuTodokedeYMD(entity.get取得届出日());
        if (entity.get被保区分コード().equals(RSTRING_1)) {
            dbt1001Entity.setIchigoShikakuShutokuYMD(entity.get異動日());
        }
        dbt1001Entity.setHihokennshaKubunCode(entity.get被保区分コード());
        dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
        dbt1001Entity.setKyuShichosonCode(旧市町村コード);
        dbt1001Entity.setLogicalDeletedFlag(false);
        return dbt1001Entity;
    }

    private DbT1001HihokenshaDaichoEntity getList喪失事由コード(List<HihokenshaShutokuJyoho> 資格訂正登録リスト, ShikakuTeyiseyiEntity entity) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
            dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
            dbt1001Entity.setIdoYMD(entity.get異動日());
            dbt1001Entity.setIdoJiyuCode(entity.get喪失事由コード());
            dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
            dbt1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
            dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
            dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
            dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
            dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
            dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
            dbt1001Entity.setShikakuSoshitsuJiyuCode(entity.get喪失事由コード());
            dbt1001Entity.setShikakuSoshitsuYMD(entity.get喪失日());
            dbt1001Entity.setShikakuSoshitsuTodokedeYMD(entity.get喪失届出日());
            dbt1001Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
            dbt1001Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
            dbt1001Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
            dbt1001Entity.setJushochitokureiTekiyoJiyuCode(hihokenshaShutokuJyoho.get住所地特例適用事由コード());
            dbt1001Entity.setJushochitokureiTekiyoYMD(hihokenshaShutokuJyoho.get適用年月日());
            dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(hihokenshaShutokuJyoho.get適用届出年月日());
            dbt1001Entity.setJushochitokureiKaijoJiyuCode(hihokenshaShutokuJyoho.get住所地特例解除事由コード());
            dbt1001Entity.setJushochitokureiKaijoYMD(hihokenshaShutokuJyoho.get解除年月日());
            dbt1001Entity.setJushochitokureiKaijoTodokedeYMD(hihokenshaShutokuJyoho.get解除届出年月日());
            dbt1001Entity.setJushochiTokureiFlag(hihokenshaShutokuJyoho.get住所地特例フラグ());
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
            dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
            dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        }
        return dbt1001Entity;
    }

    private SearchResult<HihokenshaShutokuJyoho> getList変更事由コード(List<HihokenshaShutokuJyoho> 資格訂正登録リスト, ShikakuTeyiseyiEntity entity,
            ShikibetsuCode 識別コード, LasdecCode 市町村コード, LasdecCode 広特措置元市町村コード, LasdecCode 旧市町村コード) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
            dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
            dbt1001Entity.setIdoYMD(entity.get異動日());
            dbt1001Entity.setIdoJiyuCode(entity.get変更事由コード());
            dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
            dbt1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
            dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
            dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
            dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
            dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
            dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
            dbt1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
            dbt1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
            dbt1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
            dbt1001Entity.setShikakuHenkoJiyuCode(entity.get変更事由コード());
            dbt1001Entity.setShikakuHenkoYMD(entity.get変更日());
            dbt1001Entity.setShikakuHenkoTodokedeYMD(entity.get変更届出日());
            dbt1001Entity.setJushochiTokureiFlag(hihokenshaShutokuJyoho.get住所地特例フラグ());
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
            dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
            dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.広域内転居.getコード())) {
                dbt1001Entity.setShichosonCode(市町村コード);
                dbt1001Entity.setShikibetsuCode(識別コード);
            }
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.広住特適用.getコード())) {
                dbt1001Entity.setShichosonCode(市町村コード);
                dbt1001Entity.setShikibetsuCode(識別コード);
                dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(広特措置元市町村コード);
                dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_1);
            }
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.広住特転入.getコード())) {
                dbt1001Entity.setShichosonCode(市町村コード);
                dbt1001Entity.setShikibetsuCode(識別コード);
                dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(コード);
                dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_SPACE);
            }
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.広住特居住.getコード())) {
                dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(コード);
                dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_SPACE);
            }
            //TODO QA262 「DBA介護資格_Enum設定表」の資格変更事由に「合併旧市町村間転居」が存在しない　2015/12/23まで
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.合併内転居.getコード())) {
                dbt1001Entity.setShichosonCode(旧市町村コード);
            }
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu._１号到達.getコード())) {
                dbt1001Entity.setIchigoShikakuShutokuYMD(entity.get変更日());
                dbt1001Entity.setHihokennshaKubunCode(RSTRING_1);
            }
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.一本化.getコード()) && hihokenshaShutokuJyoho.get住所地特例適用事由コード() != null
                    && hihokenshaShutokuJyoho.get住所地特例適用事由コード().equals(ShikakuJutokuTekiyoJiyu.自特例適用.getコード())) {
                HihokenshaShutokuJyoho shaShutokuJyoho1 = new HihokenshaShutokuJyoho(this.get資格訂正登録1(dbt1001Entity, hihokenshaShutokuJyoho, entity));
                HihokenshaShutokuJyoho shaShutokuJyoho2 = new HihokenshaShutokuJyoho(this.get資格訂正登録2(dbt1001Entity, hihokenshaShutokuJyoho, entity));
                HihokenshaShutokuJyoho shaShutokuJyoho3 = new HihokenshaShutokuJyoho(this.get資格訂正登録3(dbt1001Entity, hihokenshaShutokuJyoho, entity,
                        識別コード, 広特措置元市町村コード));
                資格訂正登録リスト.add(shaShutokuJyoho1);
                資格訂正登録リスト.add(shaShutokuJyoho2);
                資格訂正登録リスト.add(shaShutokuJyoho3);
                return SearchResult.of(資格訂正登録リスト, 0, false);
            }
            if (entity.get変更事由コード().equals(ShikakuHenkoJiyu.合併.getコード()) && hihokenshaShutokuJyoho.get住所地特例適用事由コード() != null
                    && hihokenshaShutokuJyoho.get住所地特例適用事由コード().equals(ShikakuJutokuTekiyoJiyu.自特例適用.getコード())) {
                HihokenshaShutokuJyoho shaShutokuJyoho1 = new HihokenshaShutokuJyoho(this.get資格訂正登録1(dbt1001Entity, hihokenshaShutokuJyoho, entity));
                HihokenshaShutokuJyoho shaShutokuJyoho2 = new HihokenshaShutokuJyoho(this.get資格訂正登録2(dbt1001Entity, hihokenshaShutokuJyoho, entity));
                資格訂正登録リスト.add(shaShutokuJyoho1);
                資格訂正登録リスト.add(shaShutokuJyoho2);
                return SearchResult.of(資格訂正登録リスト, 0, false);
            }
        }
        HihokenshaShutokuJyoho 資格訂正登録 = new HihokenshaShutokuJyoho(dbt1001Entity);
        資格訂正登録リスト.add(資格訂正登録);
        return SearchResult.of(資格訂正登録リスト, 0, false);
    }

    private DbT1001HihokenshaDaichoEntity getList適用事由コード(List<HihokenshaShutokuJyoho> 資格訂正登録リスト, ShikakuTeyiseyiEntity entity) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
            dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
            dbt1001Entity.setIdoYMD(entity.get異動日());
            dbt1001Entity.setIdoJiyuCode(entity.get喪失事由コード());
            dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
            dbt1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
            dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
            dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
            dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
            dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
            dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
            dbt1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
            dbt1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
            dbt1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
            dbt1001Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
            dbt1001Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
            dbt1001Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
            dbt1001Entity.setJushochitokureiTekiyoJiyuCode(entity.get適用事由コード());
            dbt1001Entity.setJushochitokureiTekiyoYMD(entity.get適用日());
            dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(entity.get適用届出日());
            dbt1001Entity.setJushochitokureiKaijoJiyuCode(hihokenshaShutokuJyoho.get住所地特例解除事由コード());
            dbt1001Entity.setJushochitokureiKaijoYMD(hihokenshaShutokuJyoho.get解除年月日());
            dbt1001Entity.setJushochitokureiKaijoTodokedeYMD(hihokenshaShutokuJyoho.get解除届出年月日());
            dbt1001Entity.setJushochiTokureiFlag(RSTRING_1);
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
            dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
            dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        }
        return dbt1001Entity;
    }

    private DbT1001HihokenshaDaichoEntity getList解除事由コード(List<HihokenshaShutokuJyoho> 資格訂正登録リスト, ShikakuTeyiseyiEntity entity) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        for (HihokenshaShutokuJyoho hihokenshaShutokuJyoho : 資格訂正登録リスト) {
            dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
            dbt1001Entity.setIdoYMD(entity.get異動日());
            dbt1001Entity.setIdoJiyuCode(entity.get解除事由コード());
            dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
            dbt1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
            dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
            dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
            dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
            dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
            dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
            dbt1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
            dbt1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
            dbt1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
            dbt1001Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
            dbt1001Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
            dbt1001Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
            dbt1001Entity.setJushochitokureiTekiyoJiyuCode(hihokenshaShutokuJyoho.get住所地特例適用事由コード());
            dbt1001Entity.setJushochitokureiTekiyoYMD(hihokenshaShutokuJyoho.get適用年月日());
            dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(hihokenshaShutokuJyoho.get適用届出年月日());
            dbt1001Entity.setJushochitokureiKaijoJiyuCode(entity.get解除事由コード());
            dbt1001Entity.setJushochitokureiKaijoYMD(entity.get解除日());
            dbt1001Entity.setJushochitokureiKaijoTodokedeYMD(entity.get解除届出日());
            dbt1001Entity.setJushochiTokureiFlag(RSTRING_SPACE);
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
            dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
            dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        }
        return dbt1001Entity;
    }

    private DbT1001HihokenshaDaichoEntity get資格訂正登録1(DbT1001HihokenshaDaichoEntity dbt1001Entity, HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            ShikakuTeyiseyiEntity entity) {
        dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
        dbt1001Entity.setIdoYMD(entity.get異動日());
        dbt1001Entity.setIdoJiyuCode(RSTRING_02);
        dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
        dbt1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
        dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
        dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
        dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
        dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
        dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
        dbt1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
        dbt1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
        dbt1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
        dbt1001Entity.setShikakuHenkoJiyuCode(hihokenshaShutokuJyoho.get資格変更事由コード());
        dbt1001Entity.setShikakuHenkoYMD(hihokenshaShutokuJyoho.get資格変更年月日());
        dbt1001Entity.setShikakuHenkoTodokedeYMD(hihokenshaShutokuJyoho.get資格変更届出年月日());
        dbt1001Entity.setJushochitokureiTekiyoJiyuCode(hihokenshaShutokuJyoho.get住所地特例適用事由コード());
        dbt1001Entity.setJushochitokureiTekiyoYMD(hihokenshaShutokuJyoho.get適用年月日());
        dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(hihokenshaShutokuJyoho.get適用届出年月日());
        dbt1001Entity.setJushochitokureiKaijoJiyuCode(RSTRING_02);
        dbt1001Entity.setJushochitokureiKaijoYMD(entity.get変更日());
        dbt1001Entity.setJushochitokureiKaijoTodokedeYMD(entity.get解除届出日());
        dbt1001Entity.setJushochiTokureiFlag(RSTRING_SPACE);
        dbt1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
        dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
        dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
        dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        return dbt1001Entity;
    }

    private DbT1001HihokenshaDaichoEntity get資格訂正登録2(DbT1001HihokenshaDaichoEntity dbt1001Entity, HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            ShikakuTeyiseyiEntity entity) {
        dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
        dbt1001Entity.setIdoYMD(entity.get異動日());
        dbt1001Entity.setIdoJiyuCode(entity.get変更事由コード());
        dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
        dbt1001Entity.setShikibetsuCode(hihokenshaShutokuJyoho.get識別コード());
        dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
        dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
        dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
        dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
        dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
        dbt1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
        dbt1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
        dbt1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
        dbt1001Entity.setShikakuHenkoJiyuCode(entity.get変更事由コード());
        dbt1001Entity.setShikakuHenkoYMD(entity.get変更日());
        dbt1001Entity.setShikakuHenkoTodokedeYMD(entity.get変更届出日());
        dbt1001Entity.setJushochiTokureiFlag(hihokenshaShutokuJyoho.get住所地特例フラグ());
        dbt1001Entity.setKoikinaiJushochiTokureiFlag(hihokenshaShutokuJyoho.get広域内住所地特例フラグ());
        dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(hihokenshaShutokuJyoho.get広住特措置元市町村コード());
        dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
        dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        return dbt1001Entity;
    }

    private DbT1001HihokenshaDaichoEntity get資格訂正登録3(DbT1001HihokenshaDaichoEntity dbt1001Entity, HihokenshaShutokuJyoho hihokenshaShutokuJyoho,
            ShikakuTeyiseyiEntity entity, ShikibetsuCode 識別コード, LasdecCode 広住特措置元市町村コード) {
        dbt1001Entity.setHihokenshaNo(hihokenshaShutokuJyoho.get被保険者番号());
        dbt1001Entity.setIdoYMD(entity.get異動日());
        dbt1001Entity.setIdoJiyuCode(RSTRING_04);
        dbt1001Entity.setShichosonCode(hihokenshaShutokuJyoho.get市町村コード());
        dbt1001Entity.setShikibetsuCode(識別コード);
        dbt1001Entity.setShikakuShutokuJiyuCode(hihokenshaShutokuJyoho.get資格取得事由コード());
        dbt1001Entity.setShikakuShutokuYMD(hihokenshaShutokuJyoho.get資格取得年月日());
        dbt1001Entity.setShikakuShutokuTodokedeYMD(hihokenshaShutokuJyoho.get資格取得届出年月日());
        dbt1001Entity.setIchigoShikakuShutokuYMD(hihokenshaShutokuJyoho.get第1号資格取得年月日());
        dbt1001Entity.setHihokennshaKubunCode(hihokenshaShutokuJyoho.get被保険者区分コード());
        dbt1001Entity.setShikakuSoshitsuJiyuCode(hihokenshaShutokuJyoho.get資格喪失事由コード());
        dbt1001Entity.setShikakuSoshitsuYMD(hihokenshaShutokuJyoho.get資格喪失年月日());
        dbt1001Entity.setShikakuSoshitsuTodokedeYMD(hihokenshaShutokuJyoho.get資格喪失届出年月日());
        dbt1001Entity.setShikakuHenkoJiyuCode(RSTRING_04);
        dbt1001Entity.setShikakuHenkoYMD(entity.get変更日());
        dbt1001Entity.setShikakuHenkoTodokedeYMD(entity.get変更届出日());
        dbt1001Entity.setJushochiTokureiFlag(hihokenshaShutokuJyoho.get住所地特例フラグ());
        dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_1);
        dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
        dbt1001Entity.setKyuShichosonCode(hihokenshaShutokuJyoho.get旧市町村コード());
        dbt1001Entity.setLogicalDeletedFlag(hihokenshaShutokuJyoho.is論理削除フラグ());
        return dbt1001Entity;
    }

    private LasdecCode get旧市町村コード(ShikakuTeyiseyiEntity entity, LasdecCode 旧市町村コード) {
        for (KyuShichosonCode 旧市町村 : kyuShichosonCodeJoho.get旧市町村コード情報List()) {
            if (旧市町村.get旧保険者番号().equals(entity.get旧保険者())) {
                旧市町村コード = 旧市町村.get旧市町村コード();
            }
        }
        return 旧市町村コード;
    }

    private SearchResult<ShikakuTeyiseyiEntity> get資格訂正情報リスト1(ShikakuSyousayiEntity 資格詳細情報, List<JushochiTokureiEntity> 住所地特例List,
            List<ShikakuKanrenYidouEntity> 資格関連異動List) {
        List<ShikakuTeyiseyiEntity> 資格訂正情報List = new ArrayList<>();
        List<ShikakuSyousayiEntity> 資格詳細List = new ArrayList<>();
        資格詳細List.add(資格詳細情報);
        for (ShikakuSyousayiEntity 資格詳細 : 資格詳細List) {
            ShikakuTeyiseyiEntity shikakuteyiseyi = new ShikakuTeyiseyiEntity();
            shikakuteyiseyi.set状態(FLG_無);
            shikakuteyiseyi.set異動日(資格詳細.get取得日());
            shikakuteyiseyi.set取得日(資格詳細.get取得日());
            shikakuteyiseyi.set取得届出日(資格詳細.get取得届出日());
            shikakuteyiseyi.set取得事由コード(資格詳細.get取得事由コード());
            shikakuteyiseyi.set被保区分コード(資格詳細.get被保区分コード());
            shikakuteyiseyi.set所在保険者(資格詳細.get所在保険者());
            shikakuteyiseyi.set措置元保険者(資格詳細.get措置元保険者());
            shikakuteyiseyi.set旧保険者(資格詳細.get旧保険者());
            資格訂正情報List.add(shikakuteyiseyi);
        }
        for (ShikakuSyousayiEntity 資格詳細 : 資格詳細List) {
            ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
            shikakuseyiseyi.set状態(FLG_無);
            shikakuseyiseyi.set異動日(資格詳細.get喪失日());
            shikakuseyiseyi.set喪失日(資格詳細.get喪失日());
            shikakuseyiseyi.set喪失届出日(資格詳細.get喪失届出日());
            shikakuseyiseyi.set喪失事由コード(資格詳細.get喪失事由コード());
            資格訂正情報List.add(shikakuseyiseyi);
        }
        for (JushochiTokureiEntity 住所地特例 : 住所地特例List) {
            if (住所地特例.get適用事由コード() != null && !住所地特例.get適用事由コード().isEmpty()) {
                ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
                shikakuseyiseyi.set状態(住所地特例.get状態());
                shikakuseyiseyi.set異動日(住所地特例.get適用日());
                shikakuseyiseyi.set適用日(住所地特例.get適用日());
                shikakuseyiseyi.set適用届出日(住所地特例.get適用届出日());
                shikakuseyiseyi.set適用事由コード(住所地特例.get適用事由コード());
                資格訂正情報List.add(shikakuseyiseyi);
            }
        }
        for (JushochiTokureiEntity 住所地特例 : 住所地特例List) {
            if (!住所地特例.get解除事由コード().isEmpty() && 住所地特例.get解除事由コード() != null) {
                ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
                shikakuseyiseyi.set状態(住所地特例.get状態());
                shikakuseyiseyi.set異動日(住所地特例.get解除日());
                shikakuseyiseyi.set解除日(住所地特例.get解除日());
                shikakuseyiseyi.set解除届出日(住所地特例.get解除届出日());
                shikakuseyiseyi.set解除事由コード(住所地特例.get解除事由コード());
                資格訂正情報List.add(shikakuseyiseyi);
            } else {
            }
        }
        for (ShikakuKanrenYidouEntity 資格関連異動 : 資格関連異動List) {
            ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
            shikakuseyiseyi.set状態(資格関連異動.get状態());
            shikakuseyiseyi.set異動日(資格関連異動.get変更日());
            shikakuseyiseyi.set変更日(資格関連異動.get変更日());
            shikakuseyiseyi.set変更届出日(資格関連異動.get変更届出日());
            shikakuseyiseyi.set変更事由コード(資格関連異動.get変更事由コード());
            資格訂正情報List.add(shikakuseyiseyi);
        }
        return SearchResult.of(資格訂正情報List, 0, false);
    }

    private SearchResult<ShikakuTeyiseyiEntity> get資格訂正情報リスト2(ShikakuSyousayiEntity 資格詳細情報, List<JushochiTokureiEntity> 住所地特例List,
            List<ShikakuKanrenYidouEntity> 資格関連異動List) {
        List<ShikakuTeyiseyiEntity> 資格訂正情報List = new ArrayList<>();
        List<ShikakuSyousayiEntity> 資格詳細List = new ArrayList<>();
        資格詳細List.add(資格詳細情報);
        for (ShikakuSyousayiEntity 資格詳細 : 資格詳細List) {
            ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
            shikakuseyiseyi.set状態(FLG_無);
            shikakuseyiseyi.set異動日(資格詳細.get取得日());
            shikakuseyiseyi.set取得日(資格詳細.get取得日());
            shikakuseyiseyi.set取得届出日(資格詳細.get取得届出日());
            shikakuseyiseyi.set取得事由コード(資格詳細.get取得事由コード());
            資格訂正情報List.add(shikakuseyiseyi);
        }
        for (ShikakuSyousayiEntity 資格詳細 : 資格詳細List) {
            ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
            shikakuseyiseyi.set状態(FLG_無);
            shikakuseyiseyi.set異動日(資格詳細.get喪失日());
            shikakuseyiseyi.set喪失日(資格詳細.get喪失日());
            shikakuseyiseyi.set喪失届出日(資格詳細.get喪失届出日());
            shikakuseyiseyi.set喪失事由コード(資格詳細.get喪失事由コード());
            資格訂正情報List.add(shikakuseyiseyi);
        }
        for (JushochiTokureiEntity 住所地特例 : 住所地特例List) {
            if (住所地特例.get適用事由コード() != null && !住所地特例.get適用事由コード().isEmpty()) {
                ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
                shikakuseyiseyi.set状態(住所地特例.get状態());
                shikakuseyiseyi.set異動日(住所地特例.get適用日());
                shikakuseyiseyi.set適用日(住所地特例.get適用日());
                shikakuseyiseyi.set適用届出日(住所地特例.get適用届出日());
                shikakuseyiseyi.set適用事由コード(住所地特例.get適用事由コード());
                資格訂正情報List.add(shikakuseyiseyi);
            }
        }
        for (JushochiTokureiEntity 住所地特例 : 住所地特例List) {
            if (住所地特例.get解除事由コード() != null && !住所地特例.get解除事由コード().isEmpty()) {
                ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
                shikakuseyiseyi.set状態(住所地特例.get状態());
                shikakuseyiseyi.set異動日(住所地特例.get解除日());
                shikakuseyiseyi.set解除日(住所地特例.get解除日());
                shikakuseyiseyi.set解除届出日(住所地特例.get解除届出日());
                shikakuseyiseyi.set解除事由コード(住所地特例.get解除事由コード());
                資格訂正情報List.add(shikakuseyiseyi);
            }
        }
        for (ShikakuKanrenYidouEntity 資格関連異動 : 資格関連異動List) {
            if (!資格関連異動.get状態().equals(FLG_削除)) {
                ShikakuTeyiseyiEntity shikakuseyiseyi = new ShikakuTeyiseyiEntity();
                shikakuseyiseyi.set状態(資格関連異動.get状態());
                shikakuseyiseyi.set異動日(資格関連異動.get変更日());
                shikakuseyiseyi.set変更日(資格関連異動.get変更日());
                shikakuseyiseyi.set変更届出日(資格関連異動.get変更届出日());
                shikakuseyiseyi.set変更事由コード(資格関連異動.get変更事由コード());
                資格訂正情報List.add(shikakuseyiseyi);
            }
        }
        return SearchResult.of(資格訂正情報List, 0, false);
    }

    private RString get年齢(IDateOfBirth dateOfBirth, FlexibleDate shikakuShutokuYMD) {
        getAge = new AgeCalculator(dateOfBirth, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, shikakuShutokuYMD);
        return getAge.get年齢();
    }
}
