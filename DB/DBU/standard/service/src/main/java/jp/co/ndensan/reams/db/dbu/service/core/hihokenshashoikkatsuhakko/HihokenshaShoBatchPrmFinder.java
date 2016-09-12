package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashoikkatsuhakko;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.chohyoseigyohanyo.ChohyoSeigyoHanyoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashoikkatsuhakko.HihokenshashoIkkatsuHakkoModel;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 被保険者証一括作成の発行するクラスです。
 *
 * @reamsid_L DBU-0420-010 duanzhanli
 */
public class HihokenshaShoBatchPrmFinder {

    private final DbT7022ShoriDateKanriDac datekanridac;
    private final DbT7067ChohyoSeigyoHanyoDac dbt7067dac;

    /**
     * コンストラクタ
     *
     */
    public HihokenshaShoBatchPrmFinder() {
        this.datekanridac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.dbt7067dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * クラスをcreateメソッドです。
     *
     * @return 一覧情報の取得処理するクラス
     */
    public static HihokenshaShoBatchPrmFinder createInstance() {
        return InstanceProvider.create(HihokenshaShoBatchPrmFinder.class);
    }

    /**
     * 抽出期間を取得します。
     *
     * @param 処理枝番 処理枝番
     * @return HihokenList List<HihokenshashoIkkatsuHakkoModel>
     *
     */
    public SearchResult<HihokenshashoIkkatsuHakkoModel> getChushutsuKikan(RString 処理枝番) {
        List<HihokenshashoIkkatsuHakkoModel> hihokenList = new ArrayList<>();
        List<RString> 処理枝番リスト = new ArrayList<>();
        処理枝番リスト.add(処理枝番);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = association.get地方公共団体コード();
        DbT7022ShoriDateKanriEntity entityList = datekanridac.selectBy抽出期間の取得(
                SubGyomuCode.DBU介護統計報告,
                new RString("被保険者証一括発行"),
                処理枝番リスト,
                市町村コード);
        if (entityList == null) {
            return SearchResult.of(Collections.<HihokenshashoIkkatsuHakkoModel>emptyList(), 0, false);
        }
        HihokenshashoIkkatsuHakkoModel model = new HihokenshashoIkkatsuHakkoModel();
        model.setKijunTimestamp(entityList.getKijunTimestamp());
        model.setTaishoKaishiYMD(entityList.getTaishoKaishiYMD());
        model.setTaishoKaishiTimestamp(entityList.getTaishoKaishiTimestamp());
        model.setTaishoShuryoTimestamp(entityList.getTaishoShuryoTimestamp());
        model.setTaishoShuryoYMD(entityList.getTaishoShuryoYMD());
        hihokenList.add(model);
        return SearchResult.of(hihokenList, 0, false);
    }

    /**
     * 「再発行する」のselectイベント処理です。
     *
     * @param 処理枝番 処理枝番
     * @return HihokenList List<HihokenshashoIkkatsuHakkoModel>
     *
     */
    public SearchResult<HihokenshashoIkkatsuHakkoModel> getAgainHakko(List<RString> 処理枝番) {
        List<HihokenshashoIkkatsuHakkoModel> hihokenList = new ArrayList<>();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = association.get地方公共団体コード();
        DbT7022ShoriDateKanriEntity entityList = datekanridac.selectBy抽出期間の取得(
                SubGyomuCode.DBU介護統計報告,
                new RString("被保険者証一括発行"),
                処理枝番,
                市町村コード);
        if (entityList == null) {
            return SearchResult.of(Collections.<HihokenshashoIkkatsuHakkoModel>emptyList(), 0, false);
        }
        HihokenshashoIkkatsuHakkoModel model = new HihokenshashoIkkatsuHakkoModel();
        model.setKijunTimestamp(entityList.getKijunTimestamp());
        model.setTaishoKaishiYMD(entityList.getTaishoKaishiYMD());
        model.setTaishoKaishiTimestamp(entityList.getTaishoKaishiTimestamp());
        model.setTaishoShuryoTimestamp(entityList.getTaishoShuryoTimestamp());
        model.setTaishoShuryoYMD(entityList.getTaishoShuryoYMD());
        hihokenList.add(model);
        return SearchResult.of(hihokenList, 0, false);
    }

    /**
     * 項目名を取得します。
     *
     * @param 出力条件 出力条件
     * @return 帳票制御汎用
     */
    public ChohyoSeigyoHanyoBusiness getKomokuValue(RString 出力条件) {
        return new ChohyoSeigyoHanyoBusiness(dbt7067dac.getKomokuValue(出力条件));
    }
}
