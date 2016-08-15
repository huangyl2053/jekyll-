/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.futanwariaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoDivParameter;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho.FutanWariaiShoReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.kojin.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMNK2001_負担割合証ソースファイル作成（service）
 *
 * @reamsid_L DBC-5010-041 surun
 */
public class FutanWariaisho {

    private final DbV1001HihokenshaDaichoAliveDac dac;
    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final RString 定数_事務広域 = new RString("事務広域");
    private static final RString 定数_認定広域 = new RString("認定広域");
    private static final int ZERO_INDEX = 0;

    /**
     * コンストラクタです。
     */
    public FutanWariaisho() {
        this.dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dac DbV1001HihokenshaDaichoAliveDac
     */
    public FutanWariaisho(DbV1001HihokenshaDaichoAliveDac dac) {
        this.dac = dac;
    }

    /**
     * createInstance
     *
     * @return FutanWariaisho
     */
    public static FutanWariaisho createInstance() {
        return InstanceProvider.create(FutanWariaisho.class);
    }

    /**
     * ソースデータ取得
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param entity FutanWariaiShoDivParameter
     * @param flag RString
     */
    public void getSourceData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FutanWariaiShoDivParameter entity, RString flag) {
        if (識別コード == null || 被保険者番号 == null || entity == null || flag == null) {
            throw new NullPointerException();
        }
        ReportManager reportManager = new ReportManager();
        FutanWariaiShoProperty property = new FutanWariaiShoProperty();
        try (ReportAssembler<FutanWariaiShoSource> assembler = createAssembler(property, reportManager)) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                    FlexibleDate.getNowDate());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ReportSourceWriter<FutanWariaiShoSource> reportSourceWriter = new ReportSourceWriter(assembler);
            RString 帳票イメージフォルダパス = reportSourceWriter.getImageFolderPath();
            NinshoshaSource 認証者ソースデータ = NinshoshaSourceBuilderFactory.createInstance(認証者,
                    地方公共団体,
                    帳票イメージフォルダパス,
                    RDate.getNowDate(),
                    false,
                    false,
                    KenmeiFuyoKubunType.付与なし).buildSource();
            //TODO QA#1176
//            GyomuKoyuKeyRiyoKubun 業務固有キー利用区分 = GyomuKoyuKeyRiyoKubun.利用しない;
//            SofusakiRiyoKubun 送付先利用区分 = SofusakiRiyoKubun.利用する;
//            IAtesakiGyomuHanteiKey 宛先業務判定キー
//                    = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
//            IAtesakiPSMSearchKey searchKey = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー)
//                    .set識別コード(識別コード)
//                    .set業務固有キー利用区分(業務固有キー利用区分)
//                    .set送付先利用区分(送付先利用区分)
//                    .build();
//                SofubutsuAtesakiSource 送付物宛先ソースデータ = null;
//                IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(searchKey);
//                if (宛先 != null) {
//                    ReportAtesakiEditor reportAtesakiEditor = new SofubutsuAtesakiEditorBuilder(宛先).build();
//                    送付物宛先ソースデータ = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor).buildSource();
//                }
            IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.
                    createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
            ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー);
            builder.set識別コード(識別コード);
            IShikibetsuTaishoSearchKey 識別対象検索キー = builder.build();
            IKojinFinder finder = ShikibetsuTaishoService.getKojinFinder();
            List<IKojin> kojinList = finder.get個人s(識別対象検索キー);
            ChohyoSeigyoKyotsu 帳票共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100065.getReportId());
            EditedKojin 編集後個人 = null;
            if (kojinList != null && !kojinList.isEmpty()) {
                //TODO QA#1173
                編集後個人 = new EditedKojin(kojinList.get(ZERO_INDEX), 帳票共通情報, null);
            }
            HokenshaNo 保険者コード取得 = getHokenshaCode(被保険者番号);
            //TODO QA#1174  RiyoshaFutanWariaiHantei riyoshaFutanWariaiHantei = RiyoshaFutanWariaiHantei.createInstance()
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細List = null;
            FutanWariaiShoReport report = new FutanWariaiShoReport(entity, 認証者ソースデータ, 被保険者番号, 編集後個人,
                    利用者負担割合明細List, 保険者コード取得, flag, kojinList);
            report.writeBy(reportSourceWriter);

        }

    }

    /**
     * 保険者コードを取得する
     *
     * @param 被保険者番号 HihokenshaNo
     * @return RString
     */
    private HokenshaNo getHokenshaCode(HihokenshaNo 被保険者番号) {
        HokenshaNo 証記載保険者番号;
        if (被保険者番号 == null) {
            throw new NullPointerException();
        }
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        if (定数_事務広域.equals(導入形態コード) || 定数_認定広域.equals(導入形態コード)) {
            //TODO QA#1175
            DbV1001HihokenshaDaichoEntity entity = dac.get被保険者台帳(被保険者番号);
            SearchResult<ShichosonCodeYoriShichoson> shichoson = null;
            if (entity.getKoikinaiTokureiSochimotoShichosonCode() == null) {
                shichoson = finder.shichosonCodeYoriShichosonJoho(entity.getShichosonCode());
            } else {
                shichoson = finder.shichosonCodeYoriShichosonJoho(entity.getKoikinaiTokureiSochimotoShichosonCode());
            }
            証記載保険者番号 = new HokenshaNo(shichoson.records().get(ZERO_INDEX).get証記載保険者番号().value());
        } else {
            SearchResult<KoikiZenShichosonJoho> shichosonjoho = finder.koseiShichosonJoho();
            証記載保険者番号 = new HokenshaNo(shichosonjoho.records().get(ZERO_INDEX).get証記載保険者番号().value());
        }
        return 証記載保険者番号;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
