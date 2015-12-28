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
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonlist.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonCodeJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.service.core.gappeijoho.KyuShichosonCodeFinder;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村リスト
 */
public class ShichosonList {

    private static final RString 合併旧市町村区分_最新の広域構成市町村である = new RString("0");
    private static final RString 合併旧市町村区分_合併前の旧市町村である = new RString("1");
    private final ShichosonSecurityJohoFinder shichosonSecurityJohoFinder;
    private final KyuShichosonCodeFinder kyuShichosonCodeFinder;
    private final KoseiShichosonJohoFinder koikiShichosonJohoFinder;

    ShichosonList() {
        this.shichosonSecurityJohoFinder = ShichosonSecurityJohoFinder.createInstance();
        this.kyuShichosonCodeFinder = KyuShichosonCodeFinder.createInstance();
        this.koikiShichosonJohoFinder = KoseiShichosonJohoFinder.createInstance();
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
        ShichosonSecurityJoho shichosonJoho = shichosonSecurityJohoFinder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonJoho == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }

        DonyuKeitaiCode 導入形態 = shichosonJoho.get導入形態コード();
        ShichosonJoho 市町村情報 = shichosonJoho.get市町村情報();
        GappeiJohoKubun 合併情報区分 = new GappeiJohoKanriConfig().get合併情報区分();

        if (導入形態 == DonyuKeitaiCode.事務広域 || 導入形態 == DonyuKeitaiCode.認定広域) {
            return get市町村情報リストBy導入形態コードは事務広域と認定広域の場合(合併情報区分, 市町村情報);
        } else {
            return get市町村情報リストBy導入形態コード以外の場合(合併情報区分, 市町村情報, 導入形態);
        }
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy導入形態コードは事務広域と認定広域の場合(
            GappeiJohoKubun 合併情報区分,
            ShichosonJoho 市町村情報) {
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
            ShichosonJoho 市町村情報,
            DonyuKeitaiCode 導入形態) {
        switch (合併情報区分) {
            case 合併あり:
                return get市町村情報リストBy導入形態コード以外と合併あり(市町村情報, 導入形態);
            case 合併なし:
                return Arrays.asList(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
            default:
                return Collections.emptyList();
        }
    }

    private ShichosonCodeNameResult toShichosonCodeNameResult(ShichosonJoho 市町村情報, TokeiTaishoKubun 保険者区分) {
        return new ShichosonCodeNameResult(
                市町村情報.getShichosonCode(),
                市町村情報.getShichosonMeisho(),
                市町村情報.getShoKisaiHokenshaNo(),
                保険者区分);
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併情報区分は合併ありの場合(ShichosonJoho 市町村情報) {
        if (!市町村情報.getShichosonShokibetsuID().isDefault()) {
            throw new ApplicationException(""/*DbaErrorMessages.補正処理は行えません.getMessage()*/);
        }
        return get市町村情報リストBy合併ありと市町村識別IDは00の場合(市町村情報);
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併情報区分は合併なしの場合(ShichosonJoho 市町村情報) {
        if (!市町村情報.getShichosonShokibetsuID().isDefault()) {
            throw new ApplicationException(""/*DbaErrorMessages.補正処理は行えません.getMessage()*/);
        }
        return get市町村情報リストBy合併なしと市町村識別IDは00の場合(市町村情報);
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy導入形態コード以外と合併あり(ShichosonJoho 市町村情報, DonyuKeitaiCode 導入形態) {
        KyuShichosonCodeJohoRelateEntity relateEntity = kyuShichosonCodeFinder.getKyuShichosonCodeJoho(市町村情報.getShichosonCode(), 導入形態);

        if (relateEntity.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("旧市町村コード情報"));
        }

        List<ShichosonCodeNameResult> output = new ArrayList<>();
        output.add(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
        for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : relateEntity) {
            HokenshaNo hokenshaNo = gappeiShichosonEntity.getKyuHokenshaNo();
            ShoKisaiHokenshaNo 保険者コード = hokenshaNo == null ? ShoKisaiHokenshaNo.EMPTY : new ShoKisaiHokenshaNo(hokenshaNo.value());
            output.add(new ShichosonCodeNameResult(
                    gappeiShichosonEntity.getKyuShichosonCode(),
                    gappeiShichosonEntity.getKyuShichosonMeisho(),
                    保険者コード,
                    TokeiTaishoKubun.旧市町村分
            ));
        }
        return output;
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併ありと市町村識別IDは00の場合(ShichosonJoho 市町村情報) {
        List<KoseiShichosonMaster> zenShichosonJohoList = koikiShichosonJohoFinder.get全市町村情報();

        if (zenShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("全市町村情報"));
        }

        List<ShichosonCodeNameResult> output = new ArrayList<>();
        output.add(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
        for (KoseiShichosonMaster genShichosonJoho : zenShichosonJohoList) {
            output.add(new ShichosonCodeNameResult(
                    genShichosonJoho.get市町村コード(),
                    genShichosonJoho.get市町村名称(),
                    genShichosonJoho.get証記載保険者番号(),
                    toTokeiTaishoKubun(genShichosonJoho.get合併旧市町村区分())
            ));
        }
        return output;
    }

    private TokeiTaishoKubun toTokeiTaishoKubun(RString 合併旧市町村区分) {
        if (合併旧市町村区分_最新の広域構成市町村である.equals(合併旧市町村区分)) {
            return TokeiTaishoKubun.構成市町村分;
        } else if (合併旧市町村区分_合併前の旧市町村である.equals(合併旧市町村区分)) {
            return TokeiTaishoKubun.旧市町村分;
        }
        return TokeiTaishoKubun.保険者分;
    }

    private List<ShichosonCodeNameResult> get市町村情報リストBy合併なしと市町村識別IDは00の場合(ShichosonJoho 市町村情報) {
        List<KoseiShichosonMaster> genShichosonJohoList = koikiShichosonJohoFinder.get現市町村情報();

        if (genShichosonJohoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("現市町村情報"));
        }

        List<ShichosonCodeNameResult> output = new ArrayList<>();
        output.add(toShichosonCodeNameResult(市町村情報, TokeiTaishoKubun.保険者分));
        for (KoseiShichosonMaster genShichosonJoho : genShichosonJohoList) {
            output.add(new ShichosonCodeNameResult(
                    genShichosonJoho.get市町村コード(),
                    genShichosonJoho.get市町村名称(),
                    genShichosonJoho.get証記載保険者番号(),
                    TokeiTaishoKubun.構成市町村分));
        }
        return output;
    }
}
