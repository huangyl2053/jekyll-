/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.futangendogakunintei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.AtesakiPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.FutanGendogakuNinteiParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.ShikibetsuTaishoPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogakunintei.IAtesakiPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogakunintei.IShikibetsuTaishoPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiSearchDefault;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行（画面）というビジネスクラスです。
 *
 * @reamsid_L DBD-3570-030 wangchao
 */
public class FutanGendogakuNinteiKanshoTsuchisho {

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
        return new FutanGendogakuNinteiKanshoTsuchisho();
    }

    /**
     * 選択した帳票を発行する
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @return
     */
    public SourceDataCollection publish(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, int 履歴番号, RDate 発行日, RString 文書番号) {
        SourceDataCollection sourceDataCollection = new SourceDataCollection();
        // 業務概念「介護負担限度額認定の情報」を取得する
        FutanGendogakuNinteiManager futanGendogakuNinteiManager = FutanGendogakuNinteiManager.createInstance();
        FutanGendogakuNinteiParameter parameter
                = FutanGendogakuNinteiParameter.createSelectParam(GemmenGengakuShurui.負担限度額認定.getコード(), 被保険者番号, 履歴番号);
        ArrayList<FutanGendogakuNintei> 介護保険負担限度額認定List = futanGendogakuNinteiManager.get負担限度額認定帳票用リスト(parameter);
        //1.2.	地方公共団体を取得する
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        //1.3.	宛名情報を取得する
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();
        ShikibetsuTaishoPSMMybatisParameter shikibetsuTaishoPSMParameter = new ShikibetsuTaishoPSMMybatisParameter(shikibetsuTaishoPSMSearchKey);
        shikibetsuTaishoPSMParameter.setPsmShikibetsuTaisho(new RString(shikibetsuTaishoPSMParameter.toString()));
        IShikibetsuTaishoPSMMybatisMapper shikibetsuTaishoPSMMapper = this.mapperProvider.create(IShikibetsuTaishoPSMMybatisMapper.class);
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = shikibetsuTaishoPSMMapper.selectShikibetsuTaishoPSMMybatis(shikibetsuTaishoPSMParameter);

        //1.4.	宛先情報を取得する
        AtesakiPSMSearchKeyBuilder atesakiPSMKey
                = new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        atesakiPSMKey.set識別コード(識別コード);
        IAtesakiPSMSearchKey atesakiPSMSearchKey = atesakiPSMKey.build();
        AtesakiPSMMybatisParameter atesakiPSMMybatisParameter = new AtesakiPSMMybatisParameter(atesakiPSMSearchKey);
        atesakiPSMMybatisParameter.setPsmAtesaki(new RString(atesakiPSMMybatisParameter.toString()));
        IAtesakiPSMMybatisMapper atesakiPSMMapper = this.mapperProvider.create(IAtesakiPSMMybatisMapper.class);
        UaFt250FindAtesakiEntity uaFt250Entity = atesakiPSMMapper.selectAtesakiPSMMybatis(atesakiPSMMybatisParameter);

        // 2.1.	帳票分類IDを取得する
        DbT7068ChohyoBunruiKanriDac dbT7068Dac = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
        DbT7068ChohyoBunruiKanriEntity dbT7068Entity = dbT7068Dac.selectByKey(SubGyomuCode.DBD介護受給, ReportIdDBD.DBDPR12002_1.getReportId());
        ReportId 帳票分類ID = dbT7068Entity.getChohyoBunruiID();
        // 2.2.	帳票制御共通を取得する
        load帳票制御共通(帳票分類ID);

        // 2.3.	帳票制御汎用を取得する
        load帳票制御汎用(帳票分類ID);

        //2.4.	認証者を取得する
        //JoseikinKyufuShinseishoProperty proerty = new JoseikinKyufuShinseishoProperty();
        //ReportSourceWriter<JoseikinKyufuShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(createAssembler(proerty, new ReportManager()));
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID, new FlexibleDate(発行日.toDateString()), null);

        // 3.	帳票を発行する
        if (new RString("DBD100008_FutanGendogakuNinteiKoshinTsuchisho").equals(new RString(帳票分類ID.toString()))) {
            // 3.1.1.帳票IDを判断する
            ReportId 帳票ID;
            int パターン番号;
            RString TODO旧措置者区分 = RString.EMPTY;
            if (KyuSochishaKubun.空白.getコード().equals(TODO旧措置者区分)) {
                帳票ID = new ReportId("DBD100008_FutanGendogakuNinteiKoshinTsuchisho");
                パターン番号 = 1;
            } else {
                帳票ID = new ReportId("DBD100008_FutanGendogakuNinteiKoshinTsuchishoKyusochi");
                パターン番号 = 21;
            }

            //3.1.2.定型文情報を取得する
            Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票分類ID, KamokuCode.EMPTY, パターン番号);

            //3.1.3.帳票を編集する
            //3.1.4.プールの登録
            Printer printer = new Printer();
            IReportProperty property = null;
            Report report = null;
            sourceDataCollection = printer.spool(property, report);
            //3.1.5.		発行履歴の登録
            insert発行履歴(sourceDataCollection, 発行日, 帳票ID, 識別コード);

            // 4.  負担限度額認定申請書の発行
            // TODO
        }
        return sourceDataCollection;
    }

    private boolean insert発行履歴(SourceDataCollection sourceDataCollection, RDate 発行日, ReportId 帳票ID, ShikibetsuCode 識別コード) {
        IHakkoRirekiManager manager = HakkoRirekiManagerFactory.createInstance();
        Iterator<SourceData> sourceDataList = sourceDataCollection.iterator();
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        shikibetsuCodeList.add(識別コード);
        boolean is正常終了 = false;
        HashMap hashMap = new HashMap();
        hashMap.put(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode(), 帳票ID);

        while (sourceDataList.hasNext()) {

            is正常終了 = manager.insert帳票発行履歴(
                    sourceDataList.next(),
                    new FlexibleDate(発行日.toDateString()),
                    ChohyoHakkoRirekiJotai.新規作成,
                    hashMap, shikibetsuCodeList
            );
        }
        return is正常終了;
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
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByKey(SubGyomuCode.DBD介護受給, 帳票分類ID);
        return dbT7065Entity;
    }

    /**
     * 帳票制御汎用をキーから取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return List<帳票制御汎用>
     */
    public List
            load帳票制御汎用(ReportId 帳票分類ID) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        List<DbT7067ChohyoSeigyoHanyoEntity> dbT7067EntityList
                = dbT7067Dac.get帳票制御汎用(SubGyomuCode.DBD介護受給, 帳票分類ID, new FlexibleYear("0000"));
        return dbT7067EntityList;
    }

}
