/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.report;

import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoSofusakiInfoConfig;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshasho;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.IHihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoFinder;
import jp.co.ndensan.reams.ur.urz.business.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ur.urz.business.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.business.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ur.urz.business.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.ITsuchishoAtesaki;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.IZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.business.TsuchishoAtesakiFactory;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.report.IReportBuilder;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.KatagakiEditPattern;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.MeishoFuyoType;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IZenkokuJushoManager;
import jp.co.ndensan.reams.ur.urz.realservice.ZenkokuJushoManagerFactory;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IAtesakiFinder;
import jp.co.ndensan.reams.ur.urz.realservice.report.core.IReportManager;
import jp.co.ndensan.reams.ur.urz.realservice.report.core.IReportWriter;
import jp.co.ndensan.reams.ur.urz.realservice.report.core.ReportManagerFactory;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者証を発行するために使用するPrinterのBaseクラスです。<br/>
 * 他業務Manager・Finderから値を、必要な値を取得する処理などがまとまっています。<br/>
 * 被保険者証を発行するためのPrinterはこちらのクラスをメンバに持ち、これを利用して必要な情報を取得します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoPrinterBase {

    private final HihokenshashoSofusakiInfoConfig sofusakiConfig;

    private final IKojinFinder kojinFinder;
    private final IUrControlData controlData;
    private final IAtesakiFinder atesakiFinder;
    private final IZenkokuJushoManager zenkokuJushoManager;
    private final HihokenshaDaichoFinder hihoDaichoFinder;

    /**
     * コンストラクタです。
     */
    public HihokenshashoPrinterBase() {
        this.sofusakiConfig = new HihokenshashoSofusakiInfoConfig();

        this.kojinFinder = ShikibetsuTaishoService.getKojinFinder();
        this.controlData = UrControlDataFactory.createInstance();
        this.atesakiFinder = ShikibetsuTaishoService.getAtesakiFinder();
        this.zenkokuJushoManager = ZenkokuJushoManagerFactory.createInstance();
        this.hihoDaichoFinder = new HihokenshaDaichoFinder();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param kojinFinder 個人Finder
     * @param controlData コントロールデータ
     * @param atesakiFinder 宛先Finder
     * @param hihokenshashoAtesakiCreator 被保険者証宛先Creator
     * @param zenkokuJushoManager 全国住所Manager
     * @param hihoDaichoFinder 被保険者台帳Finder
     * @param hihoBuilderFactory 被保険者台帳BuilderFactory
     */
    HihokenshashoPrinterBase(HihokenshashoSofusakiInfoConfig sofusakiConfig, IKojinFinder kojinFinder, IUrControlData controlData,
            IAtesakiFinder atesakiFinder, IZenkokuJushoManager zenkokuJushoManager, HihokenshaDaichoFinder hihoDaichoFinder) {
        this.sofusakiConfig = sofusakiConfig;
        this.kojinFinder = kojinFinder;
        this.controlData = controlData;
        this.atesakiFinder = atesakiFinder;
        this.zenkokuJushoManager = zenkokuJushoManager;
        this.hihoDaichoFinder = hihoDaichoFinder;
    }

    /**
     * 被保険者台帳の識別コードを元に、個人の情報を取得します。
     *
     * @param daichoModel 被保険者台帳Model
     * @return 対応する個人の情報
     */
    public IKojin getKojin(IHihokenshaDaicho daichoModel) {
        return kojinFinder.get個人(GyomuCode.DB介護保険, daichoModel.get識別コード());
    }

    /**
     * 被保険者番号と、コントロールデータから取得する導入団体コードを元に、最新の被保険者台帳情報を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 被保険者台帳Model
     */
    public IHihokenshaDaicho getDaichoModel(HihokenshaNo hihokenshaNo) {
        LasdecCode lasdecCode = new LasdecCode(controlData.getDonyuDantaiCode().getColumnValue());
        IItemList<IHihokenshaDaicho> daichoModelList = hihoDaichoFinder.find被保険者台帳List(lasdecCode, hihokenshaNo);
        return daichoModelList.findFirst().get();
    }

    /**
     * 被保険者証に設定する、通知書宛先を取得します。
     *
     * @param 基準日 宛先を検索するための基準日
     * @param 識別コード 宛先検索対象の識別コード
     * @return 通知書宛先
     */
    public ITsuchishoAtesaki getTsuchishoAtesaki(FlexibleDate 基準日, ShikibetsuCode 識別コード) {
        //TODO n8178 城間篤人 世帯主の表示有無を設定したいが、IAtesakiPSMSearchKeyに設定できるのは検索対象が死亡していた場合に世帯主を設定するフラグであるため用途が違う。対応法が決まった後修正
        SetainushiRiyoKubun 世帯主表示 = SetainushiRiyoKubun.利用しない;
        MeishoFuyoType meishoFuyo = MeishoFuyoType.無し;

        if (sofusakiConfig.is世帯主表示有り()) {
            世帯主表示 = SetainushiRiyoKubun.利用する;
        }
        if (sofusakiConfig.is敬称表示有り()) {
            meishoFuyo = MeishoFuyoType.様;
        }

        IAtesakiGyomuHanteiKey 業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険);
        IAtesakiPSMSearchKey searchKey = new AtesakiPSMSearchKeyBuilder(業務判定キー)
                .set識別コード(識別コード)
                .set世帯主利用区分(世帯主表示)
                .set基準日(基準日)
                .build();
        IAtesaki atesaki = atesakiFinder.get宛先(searchKey);

        return TsuchishoAtesakiFactory.createInstance(atesaki,
                JushoEditPattern.町域番地,
                KatagakiEditPattern.方書,
                meishoFuyo,
                meishoFuyo,
                true);
    }

    /**
     * 被保険者の全国住所を取得します。
     *
     * @param target 被保険者証Model
     * @return 全国住所
     */
    public IZenkokuJushoItem getZenkokuJusho(HihokenshashoModel target) {
        IZenkokuJushoItem zenkokuJusho = zenkokuJushoManager
                .get全国住所By全国住所コード(target.getKojinJoho().get住所().get全国住所コード());
        return zenkokuJusho;
    }

    /**
     * 引数からフォームタイプ、帳票Id、帳票Builderを受け取り、その情報を元に印刷可能なデータを生成して返します。
     *
     * @param formType フォームタイプ
     * @param reportId 帳票Id
     * @param builder 帳票Builder
     * @return 印刷可能データ
     */
    public SourceDataCollection print(Class formType, RString reportId, IReportBuilder<IHihokenshasho> builder) {
        try (IReportManager manager = ReportManagerFactory.createInstance()) {
            try (IReportWriter<IHihokenshasho> writer
                    = manager.reportWriter(formType)
                    .reportId(reportId)
                    .create()) {
                writer.writeLine(builder);
            }
            return manager.publish();
        }

    }
}
