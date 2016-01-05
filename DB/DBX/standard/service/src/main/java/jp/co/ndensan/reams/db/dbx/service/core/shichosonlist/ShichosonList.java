/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.shichosonlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKubun;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonlist.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.KoseiShichosonJohoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonCodeJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.service.core.gappeijoho.KyuShichosonCodeFinder;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 */
public class ShichosonList {

    private static final RString 合併旧市町村区分_最新の広域構成市町村である = new RString("0");
    private static final RString 合併旧市町村区分_合併前の旧市町村である = new RString("1");
    private static final RString 市町村識別ID_00 = new RString("00");
    private final ShichosonSecurityJohoFinder shichosonSecurityJohoFinder;
    private final KyuShichosonCodeFinder kyuShichosonCodeFinder;
    private final KoikiShichosonJohoFinder koikiShichosonJohoFinder;

    ShichosonList() {
        this.shichosonSecurityJohoFinder = ShichosonSecurityJohoFinder.createInstance();
        this.kyuShichosonCodeFinder = KyuShichosonCodeFinder.createInstance();
        this.koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
    }

    /**
     * ShichosonListのインスタンスを生成します。
     *
     * @return ShichosonList
     */
    public static ShichosonList createInstance() {
        return InstanceProvider.create(ShichosonList.class);
    }

    /**
     * 市町村コード・名称リストを取得します。
     *
     * @return 市町村Entiyリスト
     */
    public List<ShichosonCodeNameResult> getShichosonCodeNameList() {
        ShichosonSecurityJoho shichosonJohoEntity = shichosonSecurityJohoFinder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonJohoEntity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }

        DonyukeitaiCode 導入形態 = shichosonJohoEntity.get導入形態();
        KoseiShichosonJohoEntity 市町村情報 = shichosonJohoEntity.get市町村情報();
        GappeiJohoKubun 合併情報区分 = new GappeiJohoKanriConfig().get合併情報区分();

        if (導入形態 == DonyukeitaiCode.事務広域 || 導入形態 == DonyukeitaiCode.認定広域) {
            return get市町村情報リストBy導入形態コードは事務広域と認定広域の場合(合併情報区分, 市町村情報);
        } else {
            return get市町村情報リストBy導入形態コード以外の場合(合併情報区分, 市町村情報, 導入形態);
        }
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy導入形態コードは事務広域と認定広域の場合(
            GappeiJohoKubun 合併情報区分,
            KoseiShichosonJohoEntity 市町村情報) {
        switch (合併情報区分) {
            case 合併あり:
                return get市町村情報リストBy合併情報区分は合併ありの場合(市町村情報);
            case 合併なし:
                return get市町村情報リストBy合併情報区分は合併なしの場合(市町村情報);
            default:
                return Collections.emptyList();
        }
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy導入形態コード以外の場合(
            GappeiJohoKubun 合併情報区分,
            KoseiShichosonJohoEntity 市町村情報,
            DonyukeitaiCode 導入形態) {
        switch (合併情報区分) {
            case 合併あり:
                return get市町村情報リストBy導入形態コード以外と合併あり(市町村情報, 導入形態);
            case 合併なし:
                return Arrays.asList(toShichosonCodeNameResult(市町村情報));
            default:
                return Collections.emptyList();
        }
    }

    private ShichosonCodeNameResult toShichosonCodeNameResult(KoseiShichosonJohoEntity 市町村情報) {
        return new ShichosonCodeNameResult(
                市町村情報.getShichosonCode(),
                市町村情報.getShichosonMeisho(),
                市町村情報.getShoKisaiHokenshaNo(),
                TokeiTaishoKubun.保険者分);
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併情報区分は合併ありの場合(KoseiShichosonJohoEntity 市町村情報) {
        if (市町村識別ID_00.equals(市町村情報.getShichosonShokibetsuID())) {
            return get市町村情報リストBy合併ありと市町村識別IDは00の場合(市町村情報);
        } else {
            throw new ApplicationException(""/*DbaErrorMessages.補正処理は行えません.getMessage()*/);
        }
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併情報区分は合併なしの場合(KoseiShichosonJohoEntity 市町村情報) {
        if (市町村識別ID_00.equals(市町村情報.getShichosonShokibetsuID())) {
            return get市町村情報リストBy合併なしと市町村識別IDは00の場合(市町村情報);
        } else {
            throw new ApplicationException(""/*DbaErrorMessages.補正処理は行えません.getMessage()*/);
        }
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy導入形態コード以外と合併あり(
            KoseiShichosonJohoEntity 市町村情報, DonyukeitaiCode 導入形態) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        LasdecCode 市町村コード;
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        TokeiTaishoKubun 保険者区分;
        市町村コード = 市町村情報.getShichosonCode();
        市町村名称 = 市町村情報.getShichosonMeisho();
        保険者コード = 市町村情報.getShoKisaiHokenshaNo();
        保険者区分 = TokeiTaishoKubun.保険者分;

        出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));

        KyuShichosonCodeJohoRelateEntity relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村コード, 導入形態);
        List<DbT7056GappeiShichosonEntity> gappeiShichosonEntityList = null;
        if (relateEntity != null) {
            gappeiShichosonEntityList = relateEntity.getEntitys();
        }
        if (gappeiShichosonEntityList == null || gappeiShichosonEntityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("旧市町村コード情報"));
        }
        for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : gappeiShichosonEntityList) {
            市町村コード = gappeiShichosonEntity.getKyuShichosonCode();
            市町村名称 = gappeiShichosonEntity.getKyuShichosonMeisho();
            HokenshaNo hokenshaNo = gappeiShichosonEntity.getKyuHokenshaNo();
            保険者コード = hokenshaNo == null ? ShoKisaiHokenshaNo.EMPTY : new ShoKisaiHokenshaNo(hokenshaNo.value());
            保険者区分 = TokeiTaishoKubun.旧市町村分;
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        }

        return 出力市町村情報リスト;
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併ありと市町村識別IDは00の場合(KoseiShichosonJohoEntity 市町村情報) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        LasdecCode 市町村コード;
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        TokeiTaishoKubun 保険者区分;
        市町村コード = 市町村情報.getShichosonCode();
        市町村名称 = 市町村情報.getShichosonMeisho();
        保険者コード = 市町村情報.getShoKisaiHokenshaNo();
        保険者区分 = TokeiTaishoKubun.保険者分;

        出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));

        List<DbT7051KoseiShichosonMasterEntity> zenShichosonJohoList = koikiShichosonJohoFinder.getZenShichosonJoho();

        if (zenShichosonJohoList == null || zenShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("全市町村情報"));
        }
        for (DbT7051KoseiShichosonMasterEntity genShichosonJoho : zenShichosonJohoList) {
            市町村コード = genShichosonJoho.getShichosonCode();
            市町村名称 = genShichosonJoho.getShichosonMeisho();
            保険者コード = genShichosonJoho.getShoKisaiHokenshaNo();
            RString 合併旧市町村区分 = genShichosonJoho.getGappeiKyuShichosonKubun();
            if (合併旧市町村区分_最新の広域構成市町村である.equals(合併旧市町村区分)) {
                保険者区分 = TokeiTaishoKubun.構成市町村分;
            } else if (合併旧市町村区分_合併前の旧市町村である.equals(合併旧市町村区分)) {
                保険者区分 = TokeiTaishoKubun.旧市町村分;
            }
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        }

        return 出力市町村情報リスト;
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併なしと市町村識別IDは00の場合(KoseiShichosonJohoEntity 市町村情報) {
        List<ShichosonCodeNameResult> 出力市町村情報リスト = new ArrayList<>();
        LasdecCode 市町村コード;
        RString 市町村名称;
        ShoKisaiHokenshaNo 保険者コード;
        TokeiTaishoKubun 保険者区分;
        市町村コード = 市町村情報.getShichosonCode();
        市町村名称 = 市町村情報.getShichosonMeisho();
        保険者コード = 市町村情報.getShoKisaiHokenshaNo();
        保険者区分 = TokeiTaishoKubun.保険者分;

        出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));

        List<DbT7051KoseiShichosonMasterEntity> genShichosonJohoList = koikiShichosonJohoFinder.getGenShichosonJoho();

        if (genShichosonJohoList == null || genShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
        }
        for (DbT7051KoseiShichosonMasterEntity genShichosonJoho : genShichosonJohoList) {
            市町村コード = genShichosonJoho.getShichosonCode();
            市町村名称 = genShichosonJoho.getShichosonMeisho();
            保険者コード = genShichosonJoho.getShoKisaiHokenshaNo();
            保険者区分 = TokeiTaishoKubun.構成市町村分;
            出力市町村情報リスト.add(new ShichosonCodeNameResult(市町村コード, 市町村名称, 保険者コード, 保険者区分));
        }

        return 出力市町村情報リスト;
    }
}
