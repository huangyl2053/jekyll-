/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.futangendogakunintei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.NinteiKoshinTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.AtesakiPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.FutanGendogakuNinteiParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.ShikibetsuTaishoPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogakunintei.IAtesakiPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogakunintei.IShikibetsuTaishoPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiManager;
import jp.co.ndensan.reams.db.dbd.service.core.ninteikoshintsuchisho.NinteiKoshinTsuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行（画面）というビジネスクラスです。
 *
 * @reamsid_L DBD-3570-030 wangchao
 */
public class FutanGendogakuNinteiKanshoTsuchisho {

    private static final int パターン番号_21 = 21;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public FutanGendogakuNinteiKanshoTsuchisho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FutanGendogakuNinteiKanshoTsuchisho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FutanGendogakuNinteiKanshoTsuchisho}のインスタンス
     */
    public static FutanGendogakuNinteiKanshoTsuchisho createInstance() {
        return InstanceProvider.create(FutanGendogakuNinteiKanshoTsuchisho.class);
    }

    /**
     * 選択した帳票を発行する
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param お知らせ通知書 willPublishお知らせ通知書
     * @param 申請書 willPublish申請書
     * @param reportManager 帳票発行処理の制御機能
     */
    public void publish(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            int 履歴番号, RDate 発行日, RString 文書番号, boolean お知らせ通知書, boolean 申請書, ReportManager reportManager) {
        if (お知らせ通知書) {
            publishお知らせ通知書(被保険者番号, 識別コード, 履歴番号, 発行日, 文書番号, お知らせ通知書, 申請書, reportManager);
        }
        if (申請書) {
            FutanGendogakuNinteiShinseisho futanGendogakuNinteiShinseisho = FutanGendogakuNinteiShinseisho.createInstance();
            futanGendogakuNinteiShinseisho.createFutanGendogakuNinteiShinseishoChohyo(識別コード, 被保険者番号, reportManager);
        }
    }

    /**
     * お知らせ通知書発行
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param お知らせ通知書 willPublishお知らせ通知書
     * @param 申請書 willPublish申請書
     * @param reportManager 帳票発行処理の制御機能
     */
    public void publishお知らせ通知書(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            int 履歴番号, RDate 発行日, RString 文書番号, boolean お知らせ通知書, boolean 申請書, ReportManager reportManager) {
        FutanGendogakuNintei 介護保険負担限度額認定 = get介護負担限度額認定の情報(被保険者番号, 履歴番号);
        if (介護保険負担限度額認定 == null) {
            介護保険負担限度額認定 = new FutanGendogakuNintei(ShoKisaiHokenshaNo.EMPTY, 被保険者番号, 履歴番号);
        }
        Association association = get地方公共団体();

        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = get宛名情報(識別コード);

        UaFt250FindAtesakiEntity uaFt250Entity = get宛先情報(識別コード);

        ReportId 帳票分類ID = get帳票分類ID();

        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);

        List<DbT7067ChohyoSeigyoHanyoEntity> dbT7067EntityList = load帳票制御汎用(帳票分類ID);

        Ninshosha ninshosha = get認証者情報(new FlexibleDate(発行日.toDateString()));

        if (new RString("DBD100008_FutanGendogakuNinteiKoshinTsuchisho").equals(new RString(帳票分類ID.toString()))) {
            int パターン番号;
            if (介護保険負担限度額認定.get旧措置者区分() == null || 介護保険負担限度額認定.get旧措置者区分().isNullOrEmpty()) {
                パターン番号 = 1;
            } else {
                パターン番号 = パターン番号_21;
            }

            Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票分類ID, KamokuCode.EMPTY, パターン番号);
            List<RString> 通知書定型文List = new ArrayList<>();
            for (Map.Entry<Integer, RString> entry : 通知文Map.entrySet()) {
                通知書定型文List.add(entry.getValue());
            }

            List<NinteiKoshinTsuchishoItem> itemList = new ArrayList<>();
            NinteiKoshinTsuchishoItem item = new NinteiKoshinTsuchishoItem(
                    介護保険負担限度額認定,
                    ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                    AtesakiFactory.createInstance(uaFt250Entity),
                    new ChohyoSeigyoKyotsu(dbT7065Entity),
                    dbT7067EntityList,
                    association,
                    発行日,
                    文書番号,
                    通知書定型文List,
                    帳票分類ID,
                    ninshosha);

            itemList.add(item);
            NinteiKoshinTsuchishoService service = new NinteiKoshinTsuchishoService();
            service.print(itemList, reportManager);
        }
    }

    /**
     * 発行履歴の登録
     *
     * @param sourceData SourceDataCollectionのSourceData
     * @param 発行日 発行日
     * @param 識別コード 識別コード
     * @param hashMap 業務固有情報hashmap
     */
    public void insert発行履歴(SourceData sourceData, RDate 発行日, ShikibetsuCode 識別コード, HashMap<Code, RString> hashMap) {
        IHakkoRirekiManager manager = HakkoRirekiManagerFactory.createInstance();
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        shikibetsuCodeList.add(識別コード);

        manager.insert帳票発行履歴(
                sourceData,
                new FlexibleDate(発行日.toDateString()),
                ChohyoHakkoRirekiJotai.新規作成,
                hashMap, shikibetsuCodeList
        );
    }

    private Ninshosha get認証者情報(FlexibleDate kaisiYMD) {
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        return ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), kaisiYMD);
    }

    private FutanGendogakuNintei get介護負担限度額認定の情報(HihokenshaNo 被保険者番号, int 履歴番号) {
        FutanGendogakuNinteiManager futanGendogakuNinteiManager = FutanGendogakuNinteiManager.createInstance();
        FutanGendogakuNinteiParameter parameter
                = FutanGendogakuNinteiParameter.createSelectParam(GemmenGengakuShurui.負担限度額認定.getコード(), 被保険者番号, 履歴番号);
        return futanGendogakuNinteiManager.get負担限度額認定帳票用(parameter);
    }

    private Association get地方公共団体() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        return finder.getAssociation();
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();
        ShikibetsuTaishoPSMMybatisParameter shikibetsuTaishoPSMParameter = new ShikibetsuTaishoPSMMybatisParameter(shikibetsuTaishoPSMSearchKey);
        shikibetsuTaishoPSMParameter.setPsmShikibetsuTaisho(new RString(shikibetsuTaishoPSMParameter.toString()));
        IShikibetsuTaishoPSMMybatisMapper shikibetsuTaishoPSMMapper = this.mapperProvider.create(IShikibetsuTaishoPSMMybatisMapper.class);
        return shikibetsuTaishoPSMMapper.selectAtesakiPSMMybatis(shikibetsuTaishoPSMParameter);
    }

    private UaFt250FindAtesakiEntity get宛先情報(ShikibetsuCode 識別コード) {
        AtesakiPSMSearchKeyBuilder atesakiPSMKey
                = new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        atesakiPSMKey.set識別コード(識別コード);
        IAtesakiPSMSearchKey atesakiPSMSearchKey = atesakiPSMKey.build();
        AtesakiPSMMybatisParameter atesakiPSMMybatisParameter = new AtesakiPSMMybatisParameter(atesakiPSMSearchKey);
        atesakiPSMMybatisParameter.setPsmAtesaki(new RString(atesakiPSMMybatisParameter.toString()));
        IAtesakiPSMMybatisMapper atesakiPSMMapper = this.mapperProvider.create(IAtesakiPSMMybatisMapper.class);
        return atesakiPSMMapper.selectAtesakiPSMMybatis(atesakiPSMMybatisParameter);
    }

    private ReportId get帳票分類ID() {
        DbT7068ChohyoBunruiKanriDac dbT7068Dac = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
        DbT7068ChohyoBunruiKanriEntity dbT7068Entity = dbT7068Dac.selectByKey(SubGyomuCode.DBD介護受給, ReportIdDBD.DBDPR12002_1_1.getReportId());
        return dbT7068Entity.getChohyoBunruiID();
    }

    /**
     * 帳票制御共通を取得します
     *
     * @param 帳票分類ID 帳票分類ID
     * @return 帳票制御共通
     */
    public DbT7065ChohyoSeigyoKyotsuEntity load帳票制御共通(ReportId 帳票分類ID) {
        if (帳票分類ID == null || 帳票分類ID.isEmpty()) {
            throw new NullPointerException();
        }
        DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        return dbT7065Dac.selectByKey(SubGyomuCode.DBD介護受給, 帳票分類ID);
    }

    /**
     * 帳票制御汎用をキーから取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return List<帳票制御汎用>
     */
    public List load帳票制御汎用(ReportId 帳票分類ID) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        return dbT7067Dac.get帳票制御汎用(SubGyomuCode.DBD介護受給, 帳票分類ID, new FlexibleYear("0000"));
    }

}
