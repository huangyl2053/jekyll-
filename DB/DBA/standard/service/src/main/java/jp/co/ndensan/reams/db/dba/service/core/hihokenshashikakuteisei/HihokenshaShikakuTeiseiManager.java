/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakuteisei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.IryoHokenJoho;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.RoreiFukushiJoho;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashisaku.HihokenshaShisaku;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashisaku.HihokenshaShisakuRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshashisaku.IHihokenshaShisakuMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokuso.ShikakuTokuso;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shikakutokuso.ShikakuTokusoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.db.dbz.service.core.shikakutokuso.ShikakuTokusoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.sikakuidocheck.SikakuIdoCheckManager;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IUaFt200FindShikibetsuTaishoFunctionMapper;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳管理（資格訂正）を管理するクラスです。
 *
 * @reamsid_L DBA-0521-030 zhengshukai
 *
 */
public class HihokenshaShikakuTeiseiManager {

    private static final int AGE_40 = 40;
    private static final int AGE_65 = 65;
    private static final RString MESSAGE_REPLACE_喪失年月日 = new RString("喪失年月日");
    private static final RString MESSAGE_REPLACE_資格取得年月日 = new RString("資格取得年月日");
    private static final Integer HIHORIREKI = 1;
    private static final Integer DATASYUUSEI = 2;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_SPACE = new RString("");
    private static final LasdecCode コード = new LasdecCode("");
    private static final Code CODE_112 = new Code("112");
    private static final Code CODE_120 = new Code("120");
    private static final Code CODE_111 = new Code("111");
    private static final RString チェックOK = new RString("チェックOK");
    private static final RString チェックNG = new RString("チェックNG");
    private final DbT1001HihokenshaDaichoDac dac;
    private final HihokenshaShikakuShutokuManager getShutokuManager;
    private final KoikiShichosonJohoFinder 市町村情報取得Finder;
    private KyuShichosonCodeJoho kyuShichosonCodeJoho;
    private final SikakuIdoCheckManager getIdoCheckManager;
    private AgeCalculator getAge;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    HihokenshaShikakuTeiseiManager() {
        this.dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.getShutokuManager = InstanceProvider.create(HihokenshaShikakuShutokuManager.class);
        this.市町村情報取得Finder = InstanceProvider.create(KoikiShichosonJohoFinder.class);
        this.kyuShichosonCodeJoho = InstanceProvider.create(KyuShichosonCodeJoho.class);
        this.getIdoCheckManager = InstanceProvider.create(SikakuIdoCheckManager.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac IHihokenshaShikakuTeiseiDac
     */
    HihokenshaShikakuTeiseiManager(DbT1001HihokenshaDaichoDac dac, HihokenshaShikakuShutokuManager getShutokuManager,
            KoikiShichosonJohoFinder 市町村情報取得Finder,
            KyuShichosonCodeJoho kyuShichosonCodeJoho,
            SikakuIdoCheckManager getIdoCheckManager,
            MapperProvider mapperProvider
    ) {
        this.dac = dac;
        this.getShutokuManager = getShutokuManager;
        this.市町村情報取得Finder = 市町村情報取得Finder;
        this.kyuShichosonCodeJoho = kyuShichosonCodeJoho;
        this.getIdoCheckManager = getIdoCheckManager;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuTeiseiManager}のインスタンスを返します。
     *
     * @return HihokenshaShikakuTeiseiManager
     */
    public static HihokenshaShikakuTeiseiManager createInstance() {
        return InstanceProvider.create(HihokenshaShikakuTeiseiManager.class);
    }

    /**
     * 資格訂正登録リスト取得の処理です。
     *
     * @param 資格詳細情報 ShikakuRirekiJoho
     * @param 住所地特例List List<HihokenshaDaicho>
     * @param 資格関連異動List List<HihokenshaDaicho>
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 被保履歴 Integer
     * @return SearchResult<HihokenshaShutokuJyoho> 資格訂正登録リスト
     */
    public SearchResult<HihokenshaDaicho> getShikakuTorukuList(ShikakuRirekiJoho 資格詳細情報, List<HihokenshaDaicho> 住所地特例List,
            List<HihokenshaDaicho> 資格関連異動List, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, Integer 被保履歴) {
        List<DbT1001HihokenshaDaichoEntity> entityList = new ArrayList<>();
        List<HihokenshaDaicho> shutokuJyohoList = new ArrayList<>();
        if (HIHORIREKI.equals(被保履歴)) {
            entityList = get資格訂正情報リスト1(資格詳細情報, 住所地特例List, 資格関連異動List).records();
        } else if (DATASYUUSEI.equals(被保履歴)) {
            entityList = get資格訂正情報リスト2(資格詳細情報, 住所地特例List, 資格関連異動List).records();
        }
        Collections.sort(entityList, new DateComparator());
        get資格訂正登録リスト(shutokuJyohoList, entityList, 被保険者番号, 識別コード);
        if (shutokuJyohoList.isEmpty()) {
            return SearchResult.of(Collections.<HihokenshaDaicho>emptyList(), 0, false);
        }
        return SearchResult.of(shutokuJyohoList, 0, false);
    }

    private SearchResult<DbT1001HihokenshaDaichoEntity> get資格訂正情報リスト1(ShikakuRirekiJoho 資格詳細情報, List<HihokenshaDaicho> 住所地特例List,
            List<HihokenshaDaicho> 資格関連異動List) {
        List<DbT1001HihokenshaDaichoEntity> 資格訂正情報List = new ArrayList<>();
        FlexibleDate 取得日 = 資格詳細情報.getShutokuDate();
        if (取得日 != null && !取得日.isEmpty()) {
            DbT1001HihokenshaDaichoEntity dbT1001Entity = new DbT1001HihokenshaDaichoEntity();
            dbT1001Entity.setState(EntityDataState.Added);
            dbT1001Entity.setIdoYMD(取得日);
            dbT1001Entity.setIdoJiyuCode(資格詳細情報.getShutokuJiyuKey());
            dbT1001Entity.setShikakuShutokuYMD(取得日);
            dbT1001Entity.setShikakuShutokuTodokedeYMD(資格詳細情報.getShutokuTodokedeDate());
            dbT1001Entity.setShikakuShutokuJiyuCode(資格詳細情報.getShutokuJiyuKey());
            dbT1001Entity.setHihokennshaKubunCode(資格詳細情報.getHihokenshaKubun());
            dbT1001Entity.setShichosonCode(new LasdecCode(資格詳細情報.getShozaiHokensha()));
            dbT1001Entity.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(資格詳細情報.getSochimotoHokensha()));
            dbT1001Entity.setKyuShichosonCode(new LasdecCode(資格詳細情報.getKyuHokensha()));
            資格訂正情報List.add(dbT1001Entity);
            FlexibleDate 喪失日 = 資格詳細情報.getSoshitsuDate();
            if (喪失日 != null && !喪失日.isEmpty()) {
                DbT1001HihokenshaDaichoEntity dbT1001Entity2 = new DbT1001HihokenshaDaichoEntity();
                dbT1001Entity2.setState(EntityDataState.Added);
                dbT1001Entity2.setIdoYMD(喪失日);
                dbT1001Entity2.setIdoJiyuCode(資格詳細情報.getSoshitsuJiyuKey());
                dbT1001Entity2.setShikakuSoshitsuYMD(喪失日);
                dbT1001Entity2.setShikakuSoshitsuTodokedeYMD(喪失日);
                dbT1001Entity2.setShikakuSoshitsuJiyuCode(資格詳細情報.getSoshitsuJiyuKey());
                資格訂正情報List.add(dbT1001Entity2);
            }
            for (HihokenshaDaicho 住所地特例 : 住所地特例List) {
                FlexibleDate 適用日 = 住所地特例.get適用年月日();
                if (適用日 != null && !適用日.isEmpty()) {
                    DbT1001HihokenshaDaichoEntity dbT1001Entity3 = new DbT1001HihokenshaDaichoEntity();
                    dbT1001Entity3.setState(住所地特例.toEntity().getState());
                    dbT1001Entity3.setIdoYMD(適用日);
                    dbT1001Entity3.setIdoJiyuCode(住所地特例.get住所地特例適用事由コード());
                    dbT1001Entity3.setJushochitokureiTekiyoYMD(適用日);
                    dbT1001Entity3.setJushochitokureiTekiyoTodokedeYMD(住所地特例.get適用届出年月日());
                    dbT1001Entity3.setJushochitokureiTekiyoJiyuCode(住所地特例.get住所地特例適用事由コード());
                    資格訂正情報List.add(dbT1001Entity3);
                    get住所地特例の解除情報(住所地特例, 資格訂正情報List);
                }
            }
            for (HihokenshaDaicho 資格関連異動 : 資格関連異動List) {
                FlexibleDate 変更日 = 資格関連異動.get資格変更年月日();
                if (変更日 != null && !変更日.isEmpty()) {
                    DbT1001HihokenshaDaichoEntity dbT1001Entity5 = new DbT1001HihokenshaDaichoEntity();
                    dbT1001Entity5.setState(資格関連異動.toEntity().getState());
                    dbT1001Entity5.setIdoYMD(変更日);
                    dbT1001Entity5.setIdoJiyuCode(資格関連異動.get資格変更事由コード());
                    dbT1001Entity5.setShikakuHenkoYMD(変更日);
                    dbT1001Entity5.setShikakuHenkoTodokedeYMD(資格関連異動.get資格変更届出年月日());
                    dbT1001Entity5.setShikakuHenkoJiyuCode(資格関連異動.get資格変更事由コード());
                    資格訂正情報List.add(dbT1001Entity5);
                }
            }
        }
        return SearchResult.of(資格訂正情報List, 0, false);
    }

    private void get住所地特例の解除情報(HihokenshaDaicho 住所地特例, List<DbT1001HihokenshaDaichoEntity> 資格訂正情報List) {
        FlexibleDate 解除日 = 住所地特例.get解除年月日();
        if (解除日 != null && !解除日.isEmpty()) {
            DbT1001HihokenshaDaichoEntity dbT1001Entity4 = new DbT1001HihokenshaDaichoEntity();
            dbT1001Entity4.setState(住所地特例.toEntity().getState());
            dbT1001Entity4.setIdoYMD(解除日);
            dbT1001Entity4.setIdoJiyuCode(住所地特例.get住所地特例解除事由コード());
            dbT1001Entity4.setJushochitokureiKaijoYMD(解除日);
            dbT1001Entity4.setJushochitokureiKaijoTodokedeYMD(住所地特例.get解除届出年月日());
            dbT1001Entity4.setJushochitokureiKaijoJiyuCode(住所地特例.get住所地特例解除事由コード());
            資格訂正情報List.add(dbT1001Entity4);
        }
    }

    private SearchResult<DbT1001HihokenshaDaichoEntity> get資格訂正情報リスト2(ShikakuRirekiJoho 資格詳細情報, List<HihokenshaDaicho> 住所地特例List,
            List<HihokenshaDaicho> 資格関連異動List) {
        List<DbT1001HihokenshaDaichoEntity> 資格訂正情報List = new ArrayList<>();
        FlexibleDate 取得日 = 資格詳細情報.getShutokuDate();
        if (取得日 != null && !取得日.isEmpty()) {
            DbT1001HihokenshaDaichoEntity dbT1001Entity = new DbT1001HihokenshaDaichoEntity();
            dbT1001Entity.setState(EntityDataState.Added);
            dbT1001Entity.setIdoYMD(取得日);
            dbT1001Entity.setIdoJiyuCode(資格詳細情報.getShutokuJiyuKey());
            dbT1001Entity.setShikakuShutokuYMD(取得日);
            dbT1001Entity.setShikakuShutokuTodokedeYMD(資格詳細情報.getShutokuTodokedeDate());
            dbT1001Entity.setShikakuShutokuJiyuCode(資格詳細情報.getShutokuJiyuKey());
            dbT1001Entity.setHihokennshaKubunCode(資格詳細情報.getHihokenshaKubun());
            dbT1001Entity.setShichosonCode(new LasdecCode(資格詳細情報.getShozaiHokensha()));
            dbT1001Entity.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(資格詳細情報.getSochimotoHokensha()));
            dbT1001Entity.setKyuShichosonCode(new LasdecCode(資格詳細情報.getKyuHokensha()));
            資格訂正情報List.add(dbT1001Entity);
            FlexibleDate 喪失日 = 資格詳細情報.getSoshitsuDate();
            if (喪失日 != null && !喪失日.isEmpty()) {
                DbT1001HihokenshaDaichoEntity dbT1001Entity2 = new DbT1001HihokenshaDaichoEntity();
                dbT1001Entity2.setState(EntityDataState.Added);
                dbT1001Entity2.setIdoYMD(喪失日);
                dbT1001Entity2.setIdoJiyuCode(資格詳細情報.getSoshitsuJiyuKey());
                dbT1001Entity2.setShikakuSoshitsuYMD(喪失日);
                dbT1001Entity2.setShikakuSoshitsuTodokedeYMD(喪失日);
                dbT1001Entity2.setShikakuSoshitsuJiyuCode(資格詳細情報.getSoshitsuJiyuKey());
                資格訂正情報List.add(dbT1001Entity2);
            }
            for (HihokenshaDaicho 住所地特例 : 住所地特例List) {
                FlexibleDate 適用日 = 住所地特例.get適用年月日();
                if (!EntityDataState.Deleted.equals(住所地特例.toEntity().getState()) && 適用日 != null && !適用日.isEmpty()) {
                    DbT1001HihokenshaDaichoEntity dbT1001Entity3 = new DbT1001HihokenshaDaichoEntity();
                    dbT1001Entity3.setState(住所地特例.toEntity().getState());
                    dbT1001Entity3.setIdoYMD(適用日);
                    dbT1001Entity3.setIdoJiyuCode(住所地特例.get住所地特例適用事由コード());
                    dbT1001Entity3.setJushochitokureiTekiyoYMD(適用日);
                    dbT1001Entity3.setJushochitokureiTekiyoTodokedeYMD(住所地特例.get適用届出年月日());
                    dbT1001Entity3.setJushochitokureiTekiyoJiyuCode(住所地特例.get住所地特例適用事由コード());
                    資格訂正情報List.add(dbT1001Entity3);
                    get住所地特例の解除情報(住所地特例, 資格訂正情報List);
                }
            }
            for (HihokenshaDaicho 資格関連異動 : 資格関連異動List) {
                FlexibleDate 変更日 = 資格関連異動.get資格変更年月日();
                if (!EntityDataState.Deleted.equals(資格関連異動.toEntity().getState()) && 変更日 != null && !変更日.isEmpty()) {
                    DbT1001HihokenshaDaichoEntity dbT1001Entity5 = new DbT1001HihokenshaDaichoEntity();
                    dbT1001Entity5.setState(資格関連異動.toEntity().getState());
                    dbT1001Entity5.setIdoYMD(変更日);
                    dbT1001Entity5.setIdoJiyuCode(資格関連異動.get資格変更事由コード());
                    dbT1001Entity5.setShikakuHenkoYMD(変更日);
                    dbT1001Entity5.setShikakuHenkoTodokedeYMD(資格関連異動.get資格変更届出年月日());
                    dbT1001Entity5.setShikakuHenkoJiyuCode(資格関連異動.get資格変更事由コード());
                    資格訂正情報List.add(dbT1001Entity5);
                }
            }
        }
        return SearchResult.of(資格訂正情報List, 0, false);
    }

    private void get資格訂正登録リスト(List<HihokenshaDaicho> 資格訂正登録リスト,
            List<DbT1001HihokenshaDaichoEntity> 資格訂正情報List, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        for (DbT1001HihokenshaDaichoEntity 資格訂正情報Entity : 資格訂正情報List) {
            if (!EntityDataState.Deleted.equals(資格訂正情報Entity.getState())) {
                LasdecCode 市町村コード = コード;
                LasdecCode 広住特措置元市町村コード = コード;
                LasdecCode 旧市町村コード = コード;
                LasdecCode 旧市町村 = 資格訂正情報Entity.getKyuShichosonCode();
                if (CODE_112.equals(市町村セキュリティ情報.get導入形態コード()) && 旧市町村 != null && !旧市町村.isEmpty()) {
                    kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村セキュリティ情報.get市町村情報().get市町村コード(),
                            DonyuKeitaiCode.事務構成市町村);
                    旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
                }
                if (CODE_120.equals(市町村セキュリティ情報.get導入形態コード()) && 旧市町村 != null && !旧市町村.isEmpty()) {
                    kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村セキュリティ情報.get市町村情報().get市町村コード(),
                            DonyuKeitaiCode.事務単一);
                    旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
                }
                if ((CODE_111.equals(市町村セキュリティ情報.get導入形態コード()))) {
                    市町村コード = get市町村コード(資格訂正情報Entity, 市町村コード);
                    広住特措置元市町村コード = get広住特措置元市町村コード(資格訂正情報Entity, 広住特措置元市町村コード);
                    旧市町村コード = get旧市町村コード(
                            資格訂正情報Entity, 市町村コード, 広住特措置元市町村コード, 旧市町村コード, 旧市町村);
                }
                if (資格訂正情報Entity.getShikakuShutokuJiyuCode() != null) {
                    資格訂正登録リスト.add(this.getList取得事由コード(資格訂正情報Entity, 被保険者番号,
                            識別コード, 市町村コード, 広住特措置元市町村コード, 旧市町村コード, 市町村セキュリティ情報));
                }
                if (資格訂正情報Entity.getShikakuSoshitsuJiyuCode() != null) {
                    this.getList喪失事由コード(資格訂正登録リスト, 資格訂正情報Entity);
                }
                if (資格訂正情報Entity.getShikakuHenkoJiyuCode() != null) {
                    this.getList変更事由コード(資格訂正登録リスト, 資格訂正情報Entity, 識別コード, 市町村コード,
                            広住特措置元市町村コード, 旧市町村コード);
                }
                if (資格訂正情報Entity.getJushochitokureiTekiyoJiyuCode() != null) {
                    this.getList適用事由コード(資格訂正登録リスト, 資格訂正情報Entity);
                }
                if (資格訂正情報Entity.getJushochitokureiKaijoJiyuCode() != null) {
                    this.getList解除事由コード(資格訂正登録リスト, 資格訂正情報Entity);
                }
            }
        }
    }

    private LasdecCode get市町村コード(
            DbT1001HihokenshaDaichoEntity 資格訂正情報Entity,
            LasdecCode 市町村コード) {
        List<KoikiZenShichosonJoho> 現市町村情報List = 市町村情報取得Finder.getGenShichosonJoho().records();
        for (KoikiZenShichosonJoho 現市町村情報 : 現市町村情報List) {
            RString 証記載保険者番号 = 現市町村情報.get証記載保険者番号().getColumnValue();
            RString 市町村 = 資格訂正情報Entity.getShichosonCode().getColumnValue();
            if (証記載保険者番号.equals(市町村)) {
                市町村コード = 現市町村情報.get市町村コード();
            }
        }
        return 市町村コード;
    }

    private LasdecCode get広住特措置元市町村コード(
            DbT1001HihokenshaDaichoEntity 資格訂正情報Entity,
            LasdecCode 広住特措置元市町村コード) {
        List<KoikiZenShichosonJoho> 現市町村情報List = 市町村情報取得Finder.getGenShichosonJoho().records();
        for (KoikiZenShichosonJoho 現市町村情報 : 現市町村情報List) {
            RString 証記載保険者番号 = 現市町村情報.get証記載保険者番号().getColumnValue();
            LasdecCode 措置元市町村 = 資格訂正情報Entity.getKoikinaiTokureiSochimotoShichosonCode();
            RString 広住特措置元市町村 = 措置元市町村 == null ? RString.EMPTY : 措置元市町村.getColumnValue();
            if (証記載保険者番号.equals(広住特措置元市町村)) {
                広住特措置元市町村コード = 現市町村情報.get市町村コード();
            }
        }
        return 広住特措置元市町村コード;
    }

    private LasdecCode get旧市町村コード(
            DbT1001HihokenshaDaichoEntity 資格訂正情報Entity,
            LasdecCode 市町村コード,
            LasdecCode 広住特措置元市町村コード,
            LasdecCode 旧市町村コード,
            LasdecCode 旧市町村) {
        if (旧市町村 != null && !旧市町村.isEmpty() && 広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(広住特措置元市町村コード, DonyuKeitaiCode.事務広域);
            旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
        }
        if (旧市町村 != null && !旧市町村.isEmpty() && 広住特措置元市町村コード == null
                && 旧市町村コード != null && !旧市町村コード.isEmpty()) {
            kyuShichosonCodeJoho = KyuShichosonCode.getKyuShichosonCodeJoho(市町村コード, DonyuKeitaiCode.事務広域);
            旧市町村コード = this.get旧市町村コード(資格訂正情報Entity, 旧市町村コード);
        }
        return 旧市町村コード;
    }

    private HihokenshaDaicho getList取得事由コード(DbT1001HihokenshaDaichoEntity entity, HihokenshaNo 被保番号, ShikibetsuCode 識別コード,
            LasdecCode 市町村コード, LasdecCode 広住特措置元市町村コード, LasdecCode 旧市町村コード, ShichosonSecurityJoho 市町村セキュリティ情報) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = new DbT1001HihokenshaDaichoEntity();
        dbt1001Entity.shallowCopy(entity);
        dbt1001Entity.setHihokenshaNo(被保番号);
        if (市町村コード == null || 市町村コード.isEmpty()) {
            dbt1001Entity.setShichosonCode(市町村セキュリティ情報.get市町村情報().get市町村コード());
        } else {
            dbt1001Entity.setShichosonCode(市町村コード);
        }
        dbt1001Entity.setShikibetsuCode(識別コード);
        if (RSTRING_1.equals(entity.getHihokennshaKubunCode())) {
            dbt1001Entity.setIchigoShikakuShutokuYMD(entity.getIdoYMD());
        }
        dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
        dbt1001Entity.setKyuShichosonCode(旧市町村コード);
        dbt1001Entity.setLogicalDeletedFlag(false);
        return new HihokenshaDaicho(dbt1001Entity);
    }

    private void getList喪失事由コード(List<HihokenshaDaicho> 資格訂正登録リスト, DbT1001HihokenshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = 資格訂正登録リスト.get(資格訂正登録リスト.size() - 1).toEntity();
        FlexibleDate 喪失年月日 = entity.getShikakuSoshitsuYMD();
        dbt1001Entity.setIdoYMD(喪失年月日 == null ? FlexibleDate.EMPTY : 喪失年月日);
        RString 喪失事由コード = entity.getShikakuSoshitsuJiyuCode();
        dbt1001Entity.setIdoJiyuCode(喪失事由コード == null ? RString.EMPTY : 喪失事由コード);
        dbt1001Entity.setShikakuSoshitsuJiyuCode(entity.getShikakuSoshitsuJiyuCode());
        dbt1001Entity.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbt1001Entity.setShikakuSoshitsuTodokedeYMD(entity.getShikakuSoshitsuTodokedeYMD());
        dbt1001Entity.setJushochitokureiTekiyoJiyuCode(RString.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setJushochitokureiKaijoJiyuCode(RString.EMPTY);
        dbt1001Entity.setJushochitokureiKaijoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setJushochitokureiKaijoTodokedeYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setShikakuHenkoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setShikakuHenkoTodokedeYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setShikakuHenkoJiyuCode(RString.EMPTY);
        資格訂正登録リスト.add(new HihokenshaDaicho(dbt1001Entity));
    }

    private void getList変更事由コード(List<HihokenshaDaicho> 資格訂正登録リスト, DbT1001HihokenshaDaichoEntity entity,
            ShikibetsuCode 識別コード, LasdecCode 市町村コード, LasdecCode 広特措置元市町村コード, LasdecCode 旧市町村コード) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = 資格訂正登録リスト.get(資格訂正登録リスト.size() - 1).toEntity();
        FlexibleDate 変更年月日 = entity.getShikakuHenkoYMD();
        dbt1001Entity.setIdoYMD(変更年月日 == null ? FlexibleDate.EMPTY : 変更年月日);
        RString 変更事由コード = entity.getShikakuHenkoJiyuCode();
        dbt1001Entity.setIdoJiyuCode(変更事由コード == null ? RString.EMPTY : 変更事由コード);
        dbt1001Entity.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        dbt1001Entity.setShikakuHenkoYMD(entity.getShikakuHenkoYMD());
        dbt1001Entity.setShikakuHenkoTodokedeYMD(entity.getShikakuHenkoTodokedeYMD());
        if (ShikakuHenkoJiyu.広域内転居.getコード().equals(entity.getShikakuHenkoJiyuCode())) {
            dbt1001Entity.setShichosonCode(市町村コード);
            dbt1001Entity.setShikibetsuCode(識別コード);
        }
        if (ShikakuHenkoJiyu.広住特適用.getコード().equals(entity.getShikakuHenkoJiyuCode())) {
            dbt1001Entity.setShichosonCode(市町村コード);
            dbt1001Entity.setShikibetsuCode(識別コード);
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(広特措置元市町村コード);
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_1);
        }
        if (ShikakuHenkoJiyu.広住特転入.getコード().equals(entity.getShikakuHenkoJiyuCode())) {
            dbt1001Entity.setShichosonCode(市町村コード);
            dbt1001Entity.setShikibetsuCode(識別コード);
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(コード);
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_SPACE);
        }
        if (ShikakuHenkoJiyu.広住特居住.getコード().equals(entity.getShikakuHenkoJiyuCode())) {
            dbt1001Entity.setKoikinaiTokureiSochimotoShichosonCode(コード);
            dbt1001Entity.setKoikinaiJushochiTokureiFlag(RSTRING_SPACE);
        }
        if (ShikakuHenkoJiyu.合併内転居.getコード().equals(entity.getShikakuHenkoJiyuCode())) {
            dbt1001Entity.setShichosonCode(旧市町村コード);
        }
        if (ShikakuHenkoJiyu._１号到達.getコード().equals(entity.getShikakuHenkoJiyuCode())) {
            dbt1001Entity.setIchigoShikakuShutokuYMD(entity.getShikakuHenkoYMD());
            dbt1001Entity.setHihokennshaKubunCode(RSTRING_1);
        }
        if (ShikakuHenkoJiyu.一本化.getコード().equals(entity.getShikakuHenkoJiyuCode())
                && ShikakuJutokuTekiyoJiyu.自特例適用.getコード().equals(dbt1001Entity.getJushochitokureiTekiyoJiyuCode())) {
            資格訂正登録リスト.add(this.get資格訂正登録(dbt1001Entity, entity));
        }
        if (ShikakuHenkoJiyu.合併.getコード().equals(entity.getShikakuHenkoJiyuCode())
                && ShikakuJutokuTekiyoJiyu.自特例適用.getコード().equals(dbt1001Entity.getJushochitokureiTekiyoJiyuCode())) {
            資格訂正登録リスト.add(this.get資格訂正登録(dbt1001Entity, entity));
        }
        資格訂正登録リスト.add(new HihokenshaDaicho(dbt1001Entity));
    }

    private void getList適用事由コード(List<HihokenshaDaicho> 資格訂正登録リスト, DbT1001HihokenshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = 資格訂正登録リスト.get(資格訂正登録リスト.size() - 1).toEntity();
        FlexibleDate 適用年月日 = entity.getJushochitokureiTekiyoYMD();
        dbt1001Entity.setIdoYMD(適用年月日 == null ? FlexibleDate.EMPTY : 適用年月日);
        RString 適用事由コード = entity.getJushochitokureiTekiyoJiyuCode();
        dbt1001Entity.setIdoJiyuCode(適用事由コード == null ? RString.EMPTY : 適用事由コード);
        dbt1001Entity.setJushochitokureiTekiyoJiyuCode(entity.getJushochitokureiTekiyoJiyuCode());
        dbt1001Entity.setJushochitokureiTekiyoYMD(entity.getJushochitokureiTekiyoYMD());
        dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(entity.getJushochitokureiTekiyoTodokedeYMD());
        dbt1001Entity.setJushochiTokureiFlag(RSTRING_1);
        dbt1001Entity.setShikakuHenkoJiyuCode(RString.EMPTY);
        dbt1001Entity.setShikakuHenkoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setShikakuHenkoTodokedeYMD(FlexibleDate.EMPTY);
        資格訂正登録リスト.add(new HihokenshaDaicho(dbt1001Entity));
    }

    private void getList解除事由コード(List<HihokenshaDaicho> 資格訂正登録リスト, DbT1001HihokenshaDaichoEntity entity) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = 資格訂正登録リスト.get(資格訂正登録リスト.size() - 1).toEntity();
        FlexibleDate 解除年月日 = entity.getJushochitokureiKaijoYMD();
        dbt1001Entity.setIdoYMD(解除年月日 == null ? FlexibleDate.EMPTY : 解除年月日);
        RString 解除事由コード = entity.getJushochitokureiKaijoJiyuCode();
        dbt1001Entity.setIdoJiyuCode(解除事由コード == null ? RString.EMPTY : 解除事由コード);
        dbt1001Entity.setJushochitokureiKaijoJiyuCode(entity.getJushochitokureiKaijoJiyuCode());
        dbt1001Entity.setJushochitokureiKaijoYMD(entity.getJushochitokureiKaijoYMD());
        dbt1001Entity.setJushochitokureiKaijoTodokedeYMD(entity.getJushochitokureiKaijoTodokedeYMD());
        dbt1001Entity.setJushochiTokureiFlag(RSTRING_SPACE);
        dbt1001Entity.setShikakuHenkoJiyuCode(RString.EMPTY);
        dbt1001Entity.setShikakuHenkoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setShikakuHenkoTodokedeYMD(FlexibleDate.EMPTY);
        資格訂正登録リスト.add(new HihokenshaDaicho(dbt1001Entity));
    }

    private HihokenshaDaicho get資格訂正登録(DbT1001HihokenshaDaichoEntity dbt1001Entity, DbT1001HihokenshaDaichoEntity entity) {
        FlexibleDate 変更年月日 = entity.getShikakuHenkoYMD();
        dbt1001Entity.setIdoYMD(変更年月日 == null ? FlexibleDate.EMPTY : 変更年月日);
        RString 変更事由コード = entity.getShikakuHenkoJiyuCode();
        dbt1001Entity.setIdoJiyuCode(変更事由コード == null ? RString.EMPTY : 変更事由コード);
        dbt1001Entity.setShikakuHenkoJiyuCode(entity.getShikakuHenkoJiyuCode());
        dbt1001Entity.setShikakuHenkoYMD(entity.getShikakuHenkoYMD());
        dbt1001Entity.setShikakuHenkoTodokedeYMD(entity.getShikakuHenkoTodokedeYMD());
        dbt1001Entity.setJushochitokureiTekiyoJiyuCode(RString.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoJiyuCode(RString.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoYMD(FlexibleDate.EMPTY);
        dbt1001Entity.setJushochitokureiTekiyoTodokedeYMD(FlexibleDate.EMPTY);
        return new HihokenshaDaicho(dbt1001Entity);
    }

    /**
     * 資格訂正登録リストチェックの処理です。
     *
     * @param 資格訂正登録リスト 資格訂正登録リスト
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     */
    public void checkShikakuTorukuList(List<HihokenshaDaicho> 資格訂正登録リスト, IDateOfBirth 当該識別対象の生年月日) {
        DbT1001HihokenshaDaichoEntity 前の資格訂正登録Entity = new DbT1001HihokenshaDaichoEntity();
        for (HihokenshaDaicho 資格訂正登録Entity : 資格訂正登録リスト) {
            if (資格訂正登録Entity.get資格取得事由コード() != null && !資格訂正登録Entity.get資格取得事由コード().isEmpty()) {
                checkShikakuShutoku(資格訂正登録Entity.get資格取得年月日(), 資格訂正登録Entity.get資格取得事由コード(),
                        資格訂正登録Entity.get被保険者区分コード(), 資格訂正登録Entity.get第1号資格取得年月日(), 当該識別対象の生年月日);
            }
            if (資格訂正登録Entity.get資格喪失事由コード() != null && !資格訂正登録Entity.get資格喪失事由コード().isEmpty()) {
                ShikakuTokusoFinder shikakuTokusoFinder = ShikakuTokusoFinder.createInstance();
                ShikakuTokusoParameter paramet = ShikakuTokusoParameter.createParam(資格訂正登録Entity.get被保険者番号(), 資格訂正登録Entity.get識別コード());
                List<ShikakuTokuso> tokusoRirekiList = shikakuTokusoFinder.getShikakuTokuso(paramet).records();
                checkShikakuSoshitsu(前の資格訂正登録Entity, 資格訂正登録Entity.get資格喪失年月日(), 当該識別対象の生年月日, tokusoRirekiList);
            }
            if (資格訂正登録Entity.get資格変更事由コード() != null && !資格訂正登録Entity.get資格変更事由コード().isEmpty()) {
                checkShikakuHenko(前の資格訂正登録Entity, 資格訂正登録Entity.get資格変更年月日(),
                        資格訂正登録Entity.get資格変更事由コード(), 当該識別対象の生年月日);
            }
            if (資格訂正登録Entity.get住所地特例適用事由コード() != null && !資格訂正登録Entity.get住所地特例適用事由コード().isEmpty()) {
                checkJushochiTokurei(前の資格訂正登録Entity, 資格訂正登録Entity.get住所地特例適用事由コード(),
                        資格訂正登録Entity.get住所地特例解除事由コード());
            }
            if (資格訂正登録Entity.get住所地特例解除事由コード() != null && !資格訂正登録Entity.get住所地特例解除事由コード().isEmpty()) {
                checkJushochiTokurei(前の資格訂正登録Entity, 資格訂正登録Entity.get住所地特例適用事由コード(),
                        資格訂正登録Entity.get住所地特例解除事由コード());
            }
            前の資格訂正登録Entity = 資格訂正登録Entity.toEntity();
        }
    }

    /**
     * 被保険者台帳管理資格訂正の処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 取得日 取得日
     * @param 喪失日 喪失日
     * @param 資格訂正登録リスト 資格訂正登録リスト
     */
    public void saveHihokenshaShikakuTeisei(HihokenshaNo 被保険者番号, FlexibleDate 取得日, FlexibleDate 喪失日,
            List<HihokenshaDaicho> 資格訂正登録リスト) {
        List<DbT1001HihokenshaDaichoEntity> dbT1001List = dac.selectByHihokenshaNo(被保険者番号, 取得日);
        if (!資格訂正登録リスト.isEmpty()) {
            if (dbT1001List.isEmpty()) {
                for (HihokenshaDaicho hihokenshaDaicho : 資格訂正登録リスト) {
                    DbT1001HihokenshaDaichoEntity dbT1001Entity = hihokenshaDaicho.toEntity();
                    dbT1001Entity.setEdaNo(
                            getShutokuManager.getSaidaiEdaban(hihokenshaDaicho.get被保険者番号(), hihokenshaDaicho.get異動日()));
                    dbT1001Entity.setState(EntityDataState.Added);
                    dac.save(dbT1001Entity);
                }
            } else {
                for (DbT1001HihokenshaDaichoEntity entity : dbT1001List) {
                    entity.setState(EntityDataState.Deleted);
                    dac.save(entity);
                }
                for (HihokenshaDaicho hihokenshaDaicho : 資格訂正登録リスト) {
                    DbT1001HihokenshaDaichoEntity dbT1001Entity = hihokenshaDaicho.toEntity();
                    dbT1001Entity.setEdaNo(
                            getShutokuManager.getSaidaiEdaban(hihokenshaDaicho.get被保険者番号(), hihokenshaDaicho.get異動日()));
                    dbT1001Entity.setState(EntityDataState.Added);
                    dac.save(dbT1001Entity);
                }

            }
        }
    }

    /**
     * 被保険者台帳管理資格訂正の削除処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 取得日 取得日
     */
    public void deleteHihokenshaShikakuTeisei(HihokenshaNo 被保険者番号, FlexibleDate 取得日) {
        List<DbT1001HihokenshaDaichoEntity> dbT1001List = dac.selectByHihokenshaNo(被保険者番号, 取得日);
        for (DbT1001HihokenshaDaichoEntity entity : dbT1001List) {
            entity.setLogicalDeletedFlag(true);
            entity.setState(EntityDataState.Modified);
            dac.save(entity);
        }
    }

    /**
     * 資格取得チェック処理です。
     *
     * @param 取得日 取得日
     * @param 取得事由コード 取得事由コード
     * @param 被保区分コード 被保区分コード
     * @param 第1号資格取得年月日 第1号資格取得年月日
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     */
    public void checkShikakuShutoku(FlexibleDate 取得日, RString 取得事由コード, RString 被保区分コード, FlexibleDate 第1号資格取得年月日,
            IDateOfBirth 当該識別対象の生年月日) {
        int age = Integer.valueOf(get年齢(当該識別対象の生年月日, 取得日).toString());
        if (ShikakuShutokuJiyu.年齢到達.getコード().equals(取得事由コード)) {
            FlexibleDate 年齢到達日 = getAge.get年齢到達日(AGE_65);
            if (取得日.isBefore(年齢到達日) || 年齢到達日.isBefore(取得日)) {
                throw new ApplicationException(DbaErrorMessages.資格取得日１号年齢到達日不一致.getMessage());
            }
        } else if (age < AGE_40) {
            throw new ApplicationException(DbaErrorMessages.資格取得日時点２号被保険者年齢未到達.getMessage());
        }
        if (被保区分コード.equals(RSTRING_1) && age < AGE_65) {
            throw new ApplicationException(DbaErrorMessages.資格取得日時点１号被保険者年齢でない.getMessage());
        } else if (被保区分コード.equals(RSTRING_2) && age >= AGE_65) {
            throw new ApplicationException(DbaErrorMessages.資格取得日時点２号被保険者年齢でない.getMessage());
        }
    }

    /**
     * 資格喪失チェック処理です。
     *
     * @param 最新データ 最新データ
     * @param 喪失年月日 喪失年月日
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @param 得喪履歴List 得喪履歴List
     */
    public void checkShikakuSoshitsu(
            DbT1001HihokenshaDaichoEntity 最新データ,
            FlexibleDate 喪失年月日,
            IDateOfBirth 当該識別対象の生年月日,
            List<ShikakuTokuso> 得喪履歴List) {
        if (最新データ == null) {
            throw new ApplicationException(DbaErrorMessages.資格喪失登録不可.getMessage());
        }
        FlexibleDate 第1号資格取得年月日 = 最新データ.getIchigoShikakuShutokuYMD();
        if (第1号資格取得年月日 == null || 第1号資格取得年月日.isEmpty()) {
            int age = Integer.valueOf(get年齢(当該識別対象の生年月日, 喪失年月日).toString());
            if (age >= AGE_65) {
                throw new ApplicationException(DbaErrorMessages.年齢到達取得異動未登録.getMessage());
            }
        }
        if (喪失年月日.isBefore(最新データ.getShikakuShutokuYMD())) {
            throw new ApplicationException(UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().
                    replace(MESSAGE_REPLACE_喪失年月日.toString(), MESSAGE_REPLACE_資格取得年月日.toString()));
        }
        List<SikakuKikan> sikakuKikanList = new ArrayList<>();
        List<TokusoRireki> tokusoRirekitList = new ArrayList<>();
        for (ShikakuTokuso shikakuTokuso : 得喪履歴List) {
            SikakuKikan sikakuKikan = new SikakuKikan(shikakuTokuso.get資格取得年月日(), shikakuTokuso.get資格喪失年月日());
            sikakuKikanList.add(sikakuKikan);
            TokusoRireki tokusoRirekit = new TokusoRireki(shikakuTokuso.get資格取得年月日(), shikakuTokuso.get資格喪失年月日());
            tokusoRirekitList.add(tokusoRirekit);
        }
        getIdoCheckManager.sikakuKikanRirekiChofukuCheck(sikakuKikanList);
        getIdoCheckManager.tokusouTanoKikanChofukuCheck(tokusoRirekitList, 最新データ.getShikibetsuCode());
    }

    /**
     * 資格変更チェック処理です。
     *
     * @param 最新データ 最新データ
     * @param 変更日 変更日
     * @param 変更事由コード 変更事由コード
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     */
    public void checkShikakuHenko(DbT1001HihokenshaDaichoEntity 最新データ, FlexibleDate 変更日, RString 変更事由コード,
            IDateOfBirth 当該識別対象の生年月日) {
        if (変更日.isBefore(最新データ.getIdoYMD())) {
            throw new ApplicationException(DbaErrorMessages.変更日移行新資格異動有り.getMessage());
        }
        int age = Integer.valueOf(get年齢(当該識別対象の生年月日, 変更日).toString());
        if (RSTRING_1.equals(最新データ.getHihokennshaKubunCode())) {
            if (age >= AGE_65 && ShikakuHenkoJiyu._１号到達.getコード().equals(変更事由コード)) {
                throw new ApplicationException(DbaErrorMessages._１号被保険者対象外資格変更事由.getMessage());
            }
            if (age < AGE_65) {
                throw new ApplicationException(DbaErrorMessages.変更日１号年齢到達日以前.getMessage());
            }
        }
        資格変更チェック処理2(最新データ, 変更日, 変更事由コード, age);
    }

    private void 資格変更チェック処理2(DbT1001HihokenshaDaichoEntity 最新データ, FlexibleDate 変更日, RString 変更事由コード, int age) {
        if (RSTRING_2.equals(最新データ.getHihokennshaKubunCode()) && age >= AGE_65) {
            if (!ShikakuHenkoJiyu._１号到達.getコード().equals(変更事由コード)) {
                throw new ApplicationException(DbaErrorMessages.年齢到達変更異動未登録.getMessage());
            }
            if (ShikakuHenkoJiyu._１号到達.getコード().equals(変更事由コード)
                    && 変更日.isBefore(getAge.get年齢到達日(AGE_65)) || getAge.get年齢到達日(AGE_65).isBefore(変更日)) {
                throw new ApplicationException(DbaErrorMessages.変更日１号年齢到達日不一致.getMessage());
            }
        }
        if (RSTRING_2.equals(最新データ.getHihokennshaKubunCode()) && age < AGE_65
                && ShikakuHenkoJiyu._１号到達.getコード().equals(変更事由コード)) {
            throw new ApplicationException(DbaErrorMessages.変更日１号年齢到達日不一致.getMessage());
        }
        if (ShikakuHenkoJiyu.広住特転入.getコード().equals(変更事由コード)
                || ShikakuHenkoJiyu.広住特居住.getコード().equals(変更事由コード)
                && RSTRING_1.equals(最新データ.getKoikinaiJushochiTokureiFlag())) {
            throw new ApplicationException(DbaErrorMessages.広域内住所地特例者でない.getMessage());
        }
        if (RSTRING_1.equals(最新データ.getKoikinaiJushochiTokureiFlag())
                && ShikakuHenkoJiyu.広住特適用.getコード().equals(変更事由コード)) {
            throw new ApplicationException(DbaErrorMessages.住特者のため広住特適用登録不可.getMessage());
        }
    }

    /**
     * 住所地特例チェック処理です。
     *
     * @param 最新データ 最新データ
     * @param 適用事由コード 適用事由コード
     * @param 解除事由コード 解除事由コード
     */
    public void checkJushochiTokurei(DbT1001HihokenshaDaichoEntity 最新データ, RString 適用事由コード, RString 解除事由コード) {
        RString 住所地特例適用事由コード = 最新データ.getJushochitokureiTekiyoJiyuCode();
        RString 住所地特例解除事由コード = 最新データ.getJushochitokureiKaijoJiyuCode();
        if (!RString.isNullOrEmpty(住所地特例適用事由コード) && RString.isNullOrEmpty(住所地特例解除事由コード)
                && !RString.isNullOrEmpty(適用事由コード) && RString.isNullOrEmpty(解除事由コード)) {
            throw new ApplicationException(DbaErrorMessages.住所地特例適用異動が未登録.getMessage());
        }
        if (!RString.isNullOrEmpty(適用事由コード) && !RString.isNullOrEmpty(解除事由コード)
                && !RString.isNullOrEmpty(住所地特例適用事由コード) && !RString.isNullOrEmpty(住所地特例解除事由コード)) {
            throw new ApplicationException(DbaErrorMessages.住所地特例解除異動が未登録.getMessage());
        }
    }

    /**
     * 画面訂正チェック処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void checkGamenTeisei(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = getShutokuManager.getSaishinDeta(識別コード, 被保険者番号);
        List<HihokenshaShutokuJyoho> saishin = new ArrayList<>();
        saishin.add(hihokenshaShutokuJyoho);
        if (saishin.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.該当資格異動情報なし.getMessage());
        }
    }

    /**
     * 医療保険チェック処理です。
     *
     * @param oldList 初期化時のList＜医療保険情報Entity＞
     * @param newList 保存ボタン押下時のList＜医療保険情報Entity＞
     * @return 医療保険比較結果フラグ
     */
    public RString checkIryoHoken(List<IryoHokenJoho> oldList, List<IryoHokenJoho> newList) {
        if (oldList.size() != newList.size()) {
            return チェックOK;
        }
        for (int i = 0; i <= oldList.size() - 1; i++) {
            if (!oldList.get(i).toRString().equals(newList.get(i).toRString())) {
                return チェックOK;
            }
        }
        return チェックNG;
    }

    /**
     * 老福年金チェック処理です。
     *
     * @param oldList 初期化時のList＜老福年金情報Entity＞
     * @param newList 保存ボタン押下時のList＜老福年金情報Entity＞
     * @return 老福年金比較結果フラグ
     */
    public RString checkRofukuNenkin(List<RoreiFukushiJoho> oldList, List<RoreiFukushiJoho> newList) {
        if (oldList.size() != newList.size()) {
            return チェックOK;
        }
        for (int i = 0; i <= oldList.size() - 1; i++) {
            if (!oldList.get(i).toRString().equals(newList.get(i).toRString())) {
                return チェックOK;
            }
        }
        return チェックNG;
    }

    /**
     * 被保険者資格詳細異動用の宛名情報の取得です。
     *
     * @param 識別コード ShikibetsuCode
     * @return 宛名情報 HihokenshaShisaku
     */
    public HihokenshaShisaku get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        ShikakuShutokuJogaishaKanriParameter parameter = new ShikakuShutokuJogaishaKanriParameter(
                識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        HihokenshaShisakuRelateEntity entity = mapperProvider.create(IHihokenshaShisakuMapper.class).get宛名情報(parameter);
        if (entity == null) {
            entity = new HihokenshaShisakuRelateEntity();
        }
        return new HihokenshaShisaku(entity);
    }

    /**
     * 被保険者資格詳細異動用の宛名情報の取得です。
     *
     * @return 宛名情報 List<HihokenshaShisaku>
     */
    public List<HihokenshaShisaku> get宛名情報全て() {
        IUaFt200FindShikibetsuTaishoFunctionMapper mapper = mapperProvider.create(IUaFt200FindShikibetsuTaishoFunctionMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> entityList = mapper.select();
        List<HihokenshaShisaku> businessList = new ArrayList<>();
        for (UaFt200FindShikibetsuTaishoEntity entity : entityList) {
            HihokenshaShisakuRelateEntity relateEntity = new HihokenshaShisakuRelateEntity();
            relateEntity.setGenLasdecCode(entity.getGenLasdecCode());
            relateEntity.setKyuLasdecCode(entity.getKyuLasdecCode());
            HihokenshaShisaku business = new HihokenshaShisaku(relateEntity);
            businessList.add(business);
        }
        return businessList;
    }

    private LasdecCode get旧市町村コード(DbT1001HihokenshaDaichoEntity entity, LasdecCode 旧市町村コード) {
        for (KyuShichosonCode 旧市町村 : kyuShichosonCodeJoho.get旧市町村コード情報List()) {
            LasdecCode 旧保険者番号 = new LasdecCode(旧市町村.get旧保険者番号().getColumnValue());
            LasdecCode kyuShichosonCode = entity.getKyuShichosonCode();
            if (旧保険者番号.equals(kyuShichosonCode)) {
                旧市町村コード = 旧市町村.get旧市町村コード();
            }
        }
        return 旧市町村コード;
    }

    private RString get年齢(IDateOfBirth dateOfBirth, FlexibleDate ichigoShikakuShutokuYMD) {
        getAge = new AgeCalculator(dateOfBirth, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, ichigoShikakuShutokuYMD);
        return getAge.get年齢();
    }

    private static class DateComparator implements Comparator<DbT1001HihokenshaDaichoEntity>, Serializable {

        @Override
        public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
            return o1.getIdoYMD().compareTo(o2.getIdoYMD());
        }
    }
}
