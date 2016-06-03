/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.hokenshalist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKubun;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.IShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonJohoEntities;
import jp.co.ndensan.reams.db.dbx.service.core.gappeijoho.KyuShichosonCodeFinder;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村リスト
 */
public class HokenshaListLoader {

    private final ShichosonSecurityJohoFinder shichosonSecurityJohoFinder;
    private final KyuShichosonCodeFinder kyuShichosonCodeFinder;
    private final KoseiShichosonJohoFinder koseiShichosonJohoFinder;
    private final GappeiJohoKanriConfig gappeiJohoKanriConfig;

    /**
     *
     */
    protected HokenshaListLoader() {
        this.shichosonSecurityJohoFinder = ShichosonSecurityJohoFinder.createInstance();
        this.kyuShichosonCodeFinder = KyuShichosonCodeFinder.createInstance();
        this.koseiShichosonJohoFinder = KoseiShichosonJohoFinder.createInstance();
        this.gappeiJohoKanriConfig = new GappeiJohoKanriConfig();
    }

    /**
     * HokenshaListLoaderのインスタンスを生成します。
     *
     * @return HokenshaListLoader
     */
    public static HokenshaListLoader createInstance() {
        return InstanceProvider.create(jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader.class);
    }

    HokenshaListLoader(ShichosonSecurityJohoFinder shichosonSecurityJohoFinder,
            KyuShichosonCodeFinder kyuShichosonCodeFinder,
            KoseiShichosonJohoFinder koikiShichosonJohoFinder,
            GappeiJohoKanriConfig gappeiJohoKanriConfig) {
        this.shichosonSecurityJohoFinder = shichosonSecurityJohoFinder;
        this.kyuShichosonCodeFinder = kyuShichosonCodeFinder;
        this.koseiShichosonJohoFinder = koikiShichosonJohoFinder;
        this.gappeiJohoKanriConfig = gappeiJohoKanriConfig;
    }

    /**
     * 市町村コード・名称リストを取得します。
     *
     * @param gyomuBunrui 業務分類
     * @return 市町村Entiyリスト
     */
    public HokenshaList getShichosonCodeNameList(GyomuBunrui gyomuBunrui) {
        ShichosonSecurityJoho shichosonJoho = shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui);
        if (shichosonJoho == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }

        DonyuKeitaiCode 導入形態 = shichosonJoho.get導入形態コード();
        IShichosonJoho 市町村情報 = shichosonJoho.get市町村情報();
        GappeiJohoKubun 合併情報区分 = this.gappeiJohoKanriConfig.get合併情報区分();

        if (導入形態.is広域()) {
            return HokenshaList.createFor広域(search市町村リストFor広域(合併情報区分, 市町村情報));
        } else {
            return HokenshaList.createFor単一(search市町村リストFor単一(合併情報区分, 市町村情報, 導入形態));
        }
    }

    private List<HokenshaSummary> search市町村リストFor広域(
            GappeiJohoKubun 合併情報区分,
            IShichosonJoho 市町村情報) {
        switch (合併情報区分) {
            case 合併あり:
                return search市町村リストFor広域When合併あり(市町村情報);
            case 合併なし:
                return search市町村リストFor広域When合併なし(市町村情報);
            default:
                return Collections.emptyList();
        }
    }

    private List<HokenshaSummary> search市町村リストFor広域When合併あり(IShichosonJoho 市町村情報) {
        if (!市町村情報.get市町村識別ID().is広域s()) {
            throw new ApplicationException(""/*DbaErrorMessages.補正処理は行えません.getMessage()*/); //TODO メッセージの作成
        }
        return _search市町村リストFor広域When合併あり(市町村情報);
    }

    private List<HokenshaSummary> _search市町村リストFor広域When合併あり(IShichosonJoho 市町村情報) {
        List<KoseiShichosonMaster> zenShichosonJohoList = koseiShichosonJohoFinder.get全市町村情報();

        if (zenShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("全市町村情報"));
        }

        List<HokenshaSummary> output = new ArrayList<>();
        output.add(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
        for (KoseiShichosonMaster genShichosonJoho : zenShichosonJohoList) {
            output.add(new HokenshaSummary(
                    genShichosonJoho.get市町村コード(),
                    genShichosonJoho.get市町村名称(),
                    genShichosonJoho.get証記載保険者番号(),
                    toTokeiTaishoKubun(genShichosonJoho.get合併旧市町村区分())
            ));
        }
        return output;
    }

    private HokenshaSummary toShichosonCodeNameResult(IShichosonJoho 市町村情報, TokeiTaishoKubun 保険者区分) {
        return new HokenshaSummary(
                市町村情報.get市町村コード(),
                市町村情報.get市町村名(),
                市町村情報.get証記載保険者番号(),
                保険者区分);
    }

    private TokeiTaishoKubun toTokeiTaishoKubun(GappeiKyuShichosonKubun 合併旧市町村区分) {
        switch (合併旧市町村区分) {
            case 合併旧市町村:
                return TokeiTaishoKubun.旧市町村分;
            case 構成市町村:
                return TokeiTaishoKubun.構成市町村分;
            default:
                return TokeiTaishoKubun.保険者分;
        }
    }

    private List<HokenshaSummary> search市町村リストFor広域When合併なし(IShichosonJoho 市町村情報) {
        if (!市町村情報.get市町村識別ID().is広域s()) {
            throw new ApplicationException(""/*DbaErrorMessages.補正処理は行えません.getMessage()*/); //TODO メッセージの作成
        }
        return _search市町村リストFor広域When合併なし(市町村情報);
    }

    private List<HokenshaSummary> _search市町村リストFor広域When合併なし(IShichosonJoho 市町村情報) {
        List<KoseiShichosonMaster> genShichosonJohoList = koseiShichosonJohoFinder.get現市町村情報();

        if (genShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
        }

        List<HokenshaSummary> output = new ArrayList<>();
        output.add(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
        for (KoseiShichosonMaster genShichosonJoho : genShichosonJohoList) {
            output.add(new HokenshaSummary(
                    genShichosonJoho.get市町村コード(),
                    genShichosonJoho.get市町村名称(),
                    genShichosonJoho.get証記載保険者番号(),
                    TokeiTaishoKubun.構成市町村分));
        }
        return output;
    }

    private List<HokenshaSummary> search市町村リストFor単一(
            GappeiJohoKubun 合併情報区分,
            IShichosonJoho 市町村情報,
            DonyuKeitaiCode 導入形態) {
        switch (合併情報区分) {
            case 合併あり:
                return search市町村リストFor単一When合併あり(市町村情報, 導入形態);
            case 合併なし:
                return Arrays.asList(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
            default:
                return Collections.emptyList();
        }
    }

    private List<HokenshaSummary> search市町村リストFor単一When合併あり(IShichosonJoho 市町村情報, DonyuKeitaiCode 導入形態) {
        KyuShichosonJohoEntities kyuShichosons = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村情報.get市町村コード(), 導入形態);

        if (kyuShichosons.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("旧市町村コード情報"));
        }

        List<HokenshaSummary> output = new ArrayList<>();
        output.add(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
        for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : kyuShichosons) {
            HokenshaNo hokenshaNo = gappeiShichosonEntity.getKyuHokenshaNo();
            ShoKisaiHokenshaNo 保険者コード = hokenshaNo == null ? ShoKisaiHokenshaNo.EMPTY : new ShoKisaiHokenshaNo(hokenshaNo.value());
            output.add(new HokenshaSummary(
                    gappeiShichosonEntity.getKyuShichosonCode(),
                    gappeiShichosonEntity.getKyuShichosonMeisho(),
                    保険者コード,
                    TokeiTaishoKubun.旧市町村分
            ));
        }
        return output;
    }
}
