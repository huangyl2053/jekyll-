/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutisho;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutishoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutishoIkkatsuHakkoJoho;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.yokaigoninteijoho.YokaigoNinteiTsutishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.NinteiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.NinteiKekkaTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.NinteikyakkaTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.ServiceHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.YokaigodoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho.YokaigoNinteiTsutishoManager;
import jp.co.ndensan.reams.db.dbd.service.report.dbd532001.YokaigoNinteiKekkaTshuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd550001.YokaigoNinteiKyakkaTshuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd550002.ServiceHenkoTshuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd550003.YokaigodoHenkoTshuchishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiSearchDefault;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 要介護認定通知書発行画面のハンドラクラスです。
 *
 * @reamsid_L DBE-1430-010 lit
 */
public class NinteiTsuchishoHakkoHandler {

    private final NinteiTsuchishoHakkoDiv div;
    private final Association 地方公共団体;
    private static final RString LIKE符号 = new RString("%");
    private static final RString 連絡符号 = new RString(",");
    private static final RString 首長名印字位置 = new RString("1");
    private static final int 通知文_パターン番号_1 = 1;
    private static final int 通知文_パターン番号_2 = 2;
    private static final int 通知文_パターン番号_3 = 3;
    private static final int 通知文_パターン番号_4 = 4;
    private static final int 通知文_項目番号_1 = 1;
    private static final int 通知文_項目番号_2 = 2;
    private static final int 通知文_項目番号_33 = 33;
    private static final int 通知文_項目番号_3 = 3;
    private static final int 通知文_項目番号_4 = 4;
    private static final int 通知文_項目番号_5 = 5;
    private static final int 通知文_項目番号_6 = 6;
    private static final RString 左括弧 = new RString("（");
    private static final RString 右括弧 = new RString("）");

    public enum RadioValue {

        個別発行を行う(new RString("key0"), new RString("個別発行を行う")),
        一括発行を行う(new RString("key1"), new RString("一括発行を行う")),
        男(new RString("key0"), new RString("男")),
        女(new RString("key1"), new RString("女")),
        前方一致(new RString("key0"), new RString("前方一致")),
        後方一致(new RString("key1"), new RString("後方一致")),
        部分一致(new RString("key2"), new RString("部分一致")),
        完全一致(new RString("key3"), new RString("完全一致")),
        残す(new RString("key0"), new RString("残す")),
        残さない(new RString("key1"), new RString("残さない")),
        認定結果通知書(new RString("key0"), new RString("認定結果通知書")),
        サービス変更通知書(new RString("key1"), new RString("サービス変更通知書")),
        要介護度変更通知書(new RString("key2"), new RString("要介護度変更通知書")),
        発行済みを出力する(new RString("key0"), new RString("発行済みを出力する")),
        発行済みを出力しない(new RString("key1"), new RString("発行済みを出力しない"));

        private final RString key;
        private final RString value;

        RadioValue(RString key, RString value) {
            this.key = key;
            this.value = value;
        }

        public RString getKey() {
            return this.key;
        }

        public RString getValue() {
            return this.value;
        }

    }

    public enum PanelType {

        個別発行認定結果通知書パネル(new RString("個別発行認定結果通知書パネル"), ReportIdDBD.DBD532001.getReportId()),
        個別発行サービス変更通知書パネル(new RString("個別発行サービス変更通知書パネル"), ReportIdDBD.DBD550002.getReportId()),
        個別発行要介護度変更通知書パネル(new RString("個別発行要介護度変更通知書パネル"), ReportIdDBD.DBD550003.getReportId()),
        個別発行認定却下通知書パネル(new RString("認定却下通知書パネル"), ReportIdDBD.DBD550001.getReportId()),
        一括発行パネル(new RString("一括発行パネル"), ReportIdDBD.DBD532999.getReportId()),
        一括発行認定結果通知書パネル(new RString("一括発行認定結果通知書パネル"), ReportIdDBD.DBD532001.getReportId()),
        一括発行サービス変更通知書パネル(new RString("一括発行サービス変更通知書パネル"), ReportIdDBD.DBD550002.getReportId()),
        一括発行要介護度変更通知書パネル(new RString("一括発行要介護度変更通知書パネル"), ReportIdDBD.DBD550003.getReportId());

        private final RString name;
        private final ReportId chohyoId;

        PanelType(RString name, ReportId chohyoId) {
            this.name = name;
            this.chohyoId = chohyoId;
        }

        public RString getName() {
            return this.name;
        }

        public ReportId getChohyoId() {
            return this.chohyoId;
        }

    }

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定取消のコントロールdiv
     */
    public NinteiTsuchishoHakkoHandler(NinteiTsuchishoHakkoDiv div) {
        this.div = div;
        this.地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        div.getRadPrintSelect().setDataSource(get通知書発行方法データソース());
        div.getRadPrintSelect().setSelectedKey(RadioValue.個別発行を行う.getKey());

        // TODO. DBZ.HokenshaListを表示  initialがない。
//        div.getCcdHokenshaList()
        div.getChkSeibetsu().setDataSource(get性別データソース());
        div.getChkSeibetsu().setSelectedItemsByKey(new ArrayList<RString>());

        div.getDdlMachJoken().setDataSource(get検索条件区分データソース());
        div.getDdlMachJoken().setSelectedKey(RadioValue.前方一致.getKey());

        div.getTxtSaidaiHyojiKensu().setValue(get最大表示件数());
    }

    /**
     * 条件をクリアする
     */
    public void clearJoken() {
        // TODO. 保険者は初期表示時の選択値とする。
//        div.getCcdHokenshaList().c
        div.getTxtHihoNo().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtBirthYMD().clearValue();
        div.getChkSeibetsu().setSelectedItemsByKey(new ArrayList<RString>());
        div.getTxtShinseiDay().clearFromValue();
        div.getTxtShinseiDay().clearToValue();
        div.getTxtNinteiDay().clearFromValue();
        div.getTxtNinteiDay().clearToValue();
        div.getTxtSaidaiHyojiKensu().setValue(get最大表示件数());
    }

    /**
     * 検索する
     *
     * @return 対象者リスト 更新用画面データ
     */
    public List<YokaigoNinteiTsutisho> kensaku() {
        List<YokaigoNinteiTsutisho> 対象者リスト = get対象者リスト();
        set対象者一覧(対象者リスト);

        return 対象者リスト;
    }

    /**
     * 帳票エリアの表示処理。
     *
     * @param selected boolean
     * @return 帳票エリアのモード true:個別発行 | false:一括発行
     */
    public boolean displayChohyoArea(boolean selected) {

        RString 帳票発行Rad = div.getRadPrintSelect().getSelectedKey();

        clearChohyoArea();
        setChohyoAreaMode(帳票発行Rad, selected);

        return 帳票発行Rad.equals(NinteiTsuchishoHakkoHandler.RadioValue.個別発行を行う.getKey());
    }

    /**
     * 帳票エリアをクリアです。
     */
    public void clearChohyoArea() {
        clear個別発行();
        clear一括発行();
        clear出力順();
    }

    /**
     * 帳票エリアのOPEN処理
     *
     * @param パネル PanelType
     */
    public void openChohyoPanel(PanelType パネル) {
        clearChohyoArea();
        setChohyoPanelOpenClose(パネル);
        set出力順エリア(パネル);
        set帳票発行パネル(パネル);
    }

    /**
     * 「通知書を発行する」個別発行ボタンクリックイベント。
     *
     * @param 画面更新用情報 List<YokaigoNinteiTsutisho>
     * @return collection SourceDataCollection
     */
    public SourceDataCollection printAndSave(List<YokaigoNinteiTsutisho> 画面更新用情報) {
        YokaigoNinteiTsutisho 画面選択データ = get画面選択データ(画面更新用情報);
        SourceDataCollection collection = print個別発行(画面選択データ);
        画面選択データ = save個別発行(画面選択データ);
        YokaigoNinteiTsutishoManager.createInstance().save受給者台帳(画面選択データ);
        return collection;
    }

    /**
     * 「通知書を発行する」一括発行ボタンクリックイベント。
     *
     * @param 画面更新用情報 List<YokaigoNinteiTsutisho>
     */
    public void printAndSaveIkkatsuHakko(List<YokaigoNinteiTsutisho> 画面更新用情報) {
        // TODO.「バッチ設計_DBD532001_認定結果通知書発行.xlsx」を呼び

    }

    private YokaigoNinteiTsutisho get画面選択データ(List<YokaigoNinteiTsutisho> 画面更新用情報) {
        if (div.getDgTaishoshaIchiran().getSelectedItems().isEmpty() || null == 画面更新用情報 || 画面更新用情報.isEmpty()) {
            return null;
        }

        dgTaishoshaIchiran_Row row = div.getDgTaishoshaIchiran().getSelectedItems().get(0);

        for (YokaigoNinteiTsutisho データ : 画面更新用情報) {
            if (row.getShinseishokanrino().equals(データ.get申請書管理番号())
                    && row.getHihoNo().equals(データ.get被保険者番号())) {
                return データ;
            }
        }
        return null;
    }

    private SourceDataCollection print個別発行(YokaigoNinteiTsutisho 画面選択データ) {
        SourceDataCollection collection = new SourceDataCollection();
        if (div.getNinteiKekkaTsuchi().isIsOpen()) {
            collection = print個別発行認定結果通知書(画面選択データ);
        } else if (div.getServiceHenkoTsuchi().isIsOpen()) {
            collection = print個別発行サービス変更通知書(画面選択データ);
        } else if (div.getYokaigodoHenkoTsuchi().isIsOpen()) {
            collection = print個別発行要介護度変更通知書(画面選択データ);
        } else if (div.getNinteiKyakkaTshuchi().isIsOpen()) {
            collection = print個別発行認定却下通知書(画面選択データ);
        }
        return collection;
    }

    private YokaigoNinteiTsutisho save個別発行(YokaigoNinteiTsutisho 画面選択データ) {
        if (div.getNinteiKekkaTsuchi().isIsOpen()) {
            画面選択データ = edit個別発行受給者台帳(画面選択データ, PanelType.個別発行認定結果通知書パネル);
        } else if (div.getServiceHenkoTsuchi().isIsOpen()) {
            画面選択データ = edit個別発行受給者台帳(画面選択データ, PanelType.個別発行サービス変更通知書パネル);
        } else if (div.getYokaigodoHenkoTsuchi().isIsOpen()) {
            画面選択データ = edit個別発行受給者台帳(画面選択データ, PanelType.個別発行要介護度変更通知書パネル);
        } else if (div.getNinteiKyakkaTshuchi().isIsOpen()) {
            画面選択データ = edit個別発行受給者台帳(画面選択データ, PanelType.個別発行認定却下通知書パネル);
        }
        return 画面選択データ;
    }

    private ChohyoSeigyoHanyo get帳票制御情報(PanelType パネル) {
        SearchResult<ChohyoSeigyoHanyo> 帳票制御情報
                = new ChohyoSeigyoHanyoManager().get帳票制御汎用(SubGyomuCode.DBD介護受給, パネル.getChohyoId());
        if (null != 帳票制御情報 && !帳票制御情報.records().isEmpty()) {
            return 帳票制御情報.records().get(0);
        }
        return null;
    }

    private ChohyoSeigyoKyotsu get帳票共通情報(PanelType パネル) {
        return new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBD介護受給, パネル.getChohyoId());
    }

    private SourceDataCollection print個別発行認定結果通知書(YokaigoNinteiTsutisho 画面選択データ) {
        try (ReportManager reportManager = new ReportManager()) {
            YokaigoNinteiKekkaTshuchishoPrintService printService = new YokaigoNinteiKekkaTshuchishoPrintService();
//            printService.print(create個別発行認定結果通知書データ(), reportManager);

            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode()),
                    PanelType.個別発行認定結果通知書パネル.getChohyoId().getColumnValue());
            SourceDataCollection collection = reportManager.publish();
            List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
            shikibetsuCodeList.add(画面選択データ.get識別コード());
            for (SourceData data : collection) {
                insert発行履歴(data, div.getTxtNinteiKekkaSakuseiDay().getValue(), shikibetsuCodeList, hashMap);
            }
            return collection;
        }
    }

    private SourceDataCollection print個別発行サービス変更通知書(YokaigoNinteiTsutisho 画面選択データ) {
        try (ReportManager reportManager = new ReportManager()) {
            ServiceHenkoTshuchishoPrintService printService = new ServiceHenkoTshuchishoPrintService();
//            printService.print(create個別発行サービス変更通知書データ(), reportManager);

            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode()),
                    PanelType.個別発行サービス変更通知書パネル.getChohyoId().getColumnValue());
            SourceDataCollection collection = reportManager.publish();
            List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
            shikibetsuCodeList.add(画面選択データ.get識別コード());
            for (SourceData data : collection) {
                insert発行履歴(data, div.getTxtNinteiKekkaSakuseiDay().getValue(), shikibetsuCodeList, hashMap);
            }
            return collection;
        }
    }

    private SourceDataCollection print個別発行要介護度変更通知書(YokaigoNinteiTsutisho 画面選択データ) {
        try (ReportManager reportManager = new ReportManager()) {
            YokaigodoHenkoTshuchishoPrintService printService = new YokaigodoHenkoTshuchishoPrintService();
//            printService.print(create個別発行要介護度変更通知書データ(), reportManager);

            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode()),
                    PanelType.個別発行要介護度変更通知書パネル.getChohyoId().getColumnValue());
            SourceDataCollection collection = reportManager.publish();
            List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
            shikibetsuCodeList.add(画面選択データ.get識別コード());
            for (SourceData data : collection) {
                insert発行履歴(data, div.getTxtNinteiKekkaSakuseiDay().getValue(), shikibetsuCodeList, hashMap);
            }
            return collection;
        }
    }

    private SourceDataCollection print個別発行認定却下通知書(YokaigoNinteiTsutisho 画面選択データ) {
        try (ReportManager reportManager = new ReportManager()) {
            YokaigoNinteiKyakkaTshuchishoPrintService printService = new YokaigoNinteiKyakkaTshuchishoPrintService();
//            printService.print(create個別発行認定却下通知書データ(), reportManager);

            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode()),
                    PanelType.個別発行認定却下通知書パネル.getChohyoId().getColumnValue());
            SourceDataCollection collection = reportManager.publish();
            List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
            shikibetsuCodeList.add(画面選択データ.get識別コード());
            for (SourceData data : collection) {
                insert発行履歴(data, div.getTxtNinteiKekkaSakuseiDay().getValue(), shikibetsuCodeList, hashMap);
            }
            return collection;
        }
    }

    private void insert発行履歴(SourceData sourceData, FlexibleDate 発行日,
            List<ShikibetsuCode> shikibetsuCodeList, HashMap<Code, RString> hashMap) {
        IHakkoRirekiManager manager = HakkoRirekiManagerFactory.createInstance();
        manager.insert帳票発行履歴(sourceData, 発行日, ChohyoHakkoRirekiJotai.新規作成, hashMap, shikibetsuCodeList);
    }

    private RString get通知文情報通知文(PanelType パネル, int パターン番号, int 項目番号) {
        Map<Integer, RString> 通知文情報 = ReportUtil.get通知文(SubGyomuCode.DBD介護受給,
                パネル.getChohyoId(), KamokuCode.EMPTY, パターン番号);
        return null != 通知文情報 ? 通知文情報.get(項目番号) : RString.EMPTY;
    }

    private NinteiKekkaTsuchishoEntity create個別発行認定結果通知書データ() {
        ChohyoSeigyoHanyo 帳票制御情報 = get帳票制御情報(PanelType.個別発行認定結果通知書パネル);
        ChohyoSeigyoKyotsu 帳票共通情報 = get帳票共通情報(PanelType.個別発行認定結果通知書パネル);
        FlexibleDate 発行日 = div.getTxtNinteiKekkaSakuseiDay().getValue();
//        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
//                .get帳票認証者(GyomuCode.DB介護保険,
//                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                        発行日);
//        // TODO.イメージファイルパス　＝　ReportSourceWriter.getImageFolderPath()　より取得
//        boolean is公印に掛ける = 首長名印字位置.equals(帳票共通情報.get首長名印字位置());
//        boolean is公印を省略 = !帳票共通情報.is電子公印印字有無();

        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 送付物宛先情報 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        NinteiKekkaTsuchishoEntity printEntity = new NinteiKekkaTsuchishoEntity();

        printEntity.setBunshoNo(div.getCcdKobetsuNinteiKekkaBunshoBango().get文書番号());
        //TODO
//            printEntity.setTitle(連絡符号);
        printEntity.setTsuchibun1(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_1)
                .concat(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_2)));
        printEntity.setTsuchibun2(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_33));
        //TODO
//      printEntity.setHihokenshaName(LIKE符号);
//        printEntity.setHihokenshaNo1(LIKE符号);
//            printEntity.setHihokenshaNo2(LIKE符号);
//            printEntity.setHihokenshaNo3(LIKE符号);
//            printEntity.setHihokenshaNo4(LIKE符号);
//            printEntity.setHihokenshaNo5(LIKE符号);
//            printEntity.setHihokenshaNo6(LIKE符号);
//            printEntity.setHihokenshaNo7(LIKE符号);
//            printEntity.setHihokenshaNo8(LIKE符号);
//            printEntity.setHihokenshaNo9(LIKE符号);
//            printEntity.setHihokenshaNo10(LIKE符号);
//            printEntity.setKekkaKosho(LIKE符号);
//            printEntity.setKekkaName(LIKE符号);
//            printEntity.setKekkaYMDKosho(LIKE符号);
//            printEntity.setKekkaYMD(FlexibleDate.EMPTY);
//            printEntity.setRiyu(連絡符号);
//            printEntity.setServiceShurui1(LIKE符号);
//            printEntity.setYukoKaishiYMD(FlexibleDate.EMPTY);
//            printEntity.setYukoShuryoYMD(FlexibleDate.EMPTY);

        printEntity.setTsuchibun3(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_2, 通知文_項目番号_3));
        printEntity.setTsuchibun4(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_3));
        printEntity.setTsuchibun5(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_4));
        printEntity.setTsuchibun6(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_3));
        printEntity.setTsuchibun7(get通知文情報通知文(PanelType.個別発行認定結果通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_4));
        printEntity.setYubinNo(送付物宛先情報.get宛先住所().get郵便番号().value());
        printEntity.setGyoseiku(送付物宛先情報.get宛先行政区().get名称());
        //TODO
//        printEntity.setJushoText(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho1(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho2(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho3(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setKatagakiText(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki2(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall2(送付物宛先情報.get宛先住所().get方書().value());
        //TODO
//        printEntity.setDainoKubunMei(送付物宛先情報.代納人区分);
//        printEntity.setShimeiText(送付物宛先情報.氏名1);
//        printEntity.setShimei1(送付物宛先情報.氏名1);
//        printEntity.setShimei2(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall1(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall2(送付物宛先情報.氏名1);
//        printEntity.setSamabunShimeiText(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei2(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall2(送付物宛先情報.氏名2);
//        printEntity.setMeishoFuyo1(送付物宛先情報.氏名1);
//        printEntity.setMeishoFuyo2(送付物宛先情報.氏名1);
//        printEntity.setSamaBun1(送付物宛先情報.氏名2);
//        printEntity.setSamaBun2(送付物宛先情報.氏名2);
        printEntity.setKakkoLeft1(左括弧);
        printEntity.setKakkoLeft2(左括弧);
        printEntity.setKakkoRight1(右括弧);
        printEntity.setKakkoRight2(右括弧);
//        printEntity.setCustomerBarCode(送付物宛先情報.カスタマバーコード);
        return printEntity;
    }

    private ServiceHenkoTsuchishoEntity create個別発行サービス変更通知書データ() {
        ChohyoSeigyoHanyo 帳票制御情報 = get帳票制御情報(PanelType.個別発行サービス変更通知書パネル);
        ChohyoSeigyoKyotsu 帳票共通情報 = get帳票共通情報(PanelType.個別発行サービス変更通知書パネル);
        FlexibleDate 発行日 = div.getTxtServiceHenkoBunshoSakuseiDay().getValue();
//        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
//                .get帳票認証者(GyomuCode.DB介護保険,
//                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                        発行日);
//        // TODO.イメージファイルパス　＝　ReportSourceWriter.getImageFolderPath()　より取得
//        boolean is公印に掛ける = 首長名印字位置.equals(帳票共通情報.get首長名印字位置());
//        boolean is公印を省略 = !帳票共通情報.is電子公印印字有無();

        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 送付物宛先情報 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        ServiceHenkoTsuchishoEntity printEntity = new ServiceHenkoTsuchishoEntity();

        printEntity.setBunshoNo(div.getCcdKobetsuServiceHenkoBunshoBango().get文書番号());
        //TODO
//            printEntity.setTitle(連絡符号);
        printEntity.setTsuchibun1(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_1));
        printEntity.setTsuchibun2(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_2));
        //TODO
//      printEntity.setHihokenshaName(LIKE符号);
//        printEntity.setHihokenshaNo1(LIKE符号);
//            printEntity.setHihokenshaNo2(LIKE符号);
//            printEntity.setHihokenshaNo3(LIKE符号);
//            printEntity.setHihokenshaNo4(LIKE符号);
//            printEntity.setHihokenshaNo5(LIKE符号);
//            printEntity.setHihokenshaNo6(LIKE符号);
//            printEntity.setHihokenshaNo7(LIKE符号);
//            printEntity.setHihokenshaNo8(LIKE符号);
//            printEntity.setHihokenshaNo9(LIKE符号);
//            printEntity.setHihokenshaNo10(LIKE符号);
//           printEntity.setHenkoYMD();
//        printEntity.set
//        printEntity.set
//            printEntity.setRiyu(連絡符号);

        printEntity.setTsuchibun3(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_2, 通知文_項目番号_2));
        printEntity.setTsuchibun4(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_2));
        printEntity.setTsuchibun5(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_3));
        printEntity.setTsuchibun6(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_2));
        printEntity.setTsuchibun7(get通知文情報通知文(PanelType.個別発行サービス変更通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_3));
        printEntity.setYubinNo(送付物宛先情報.get宛先住所().get郵便番号().value());
        printEntity.setGyoseiku(送付物宛先情報.get宛先行政区().get名称());
        //TODO
//        printEntity.setJushoText(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho1(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho2(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho3(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setKatagakiText(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki2(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall2(送付物宛先情報.get宛先住所().get方書().value());
        //TODO
//        printEntity.setDainoKubunMei(送付物宛先情報.代納人区分);
//        printEntity.setShimeiText(送付物宛先情報.氏名1);
//        printEntity.setShimei1(送付物宛先情報.氏名1);
//        printEntity.setShimei2(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall1(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall2(送付物宛先情報.氏名1);
//        printEntity.setSamabunShimeiText(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei2(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall2(送付物宛先情報.氏名2);
//        printEntity.setMeishoFuyo1(送付物宛先情報.氏名1);
//        printEntity.setMeishoFuyo2(送付物宛先情報.氏名1);
//        printEntity.setSamaBun1(送付物宛先情報.氏名2);
//        printEntity.setSamaBun2(送付物宛先情報.氏名2);
        printEntity.setKakkoLeft1(左括弧);
        printEntity.setKakkoLeft2(左括弧);
        printEntity.setKakkoRight1(右括弧);
        printEntity.setKakkoRight2(右括弧);
//        printEntity.setCustomerBarCode(送付物宛先情報.カスタマバーコード);
        return printEntity;
    }

    private YokaigodoHenkoTsuchishoEntity create個別発行要介護度変更通知書データ() {
        ChohyoSeigyoHanyo 帳票制御情報 = get帳票制御情報(PanelType.個別発行要介護度変更通知書パネル);
        ChohyoSeigyoKyotsu 帳票共通情報 = get帳票共通情報(PanelType.個別発行要介護度変更通知書パネル);
        FlexibleDate 発行日 = div.getTxtYokaigodoHenkoTsuchiSakuseiDay().getValue();
//        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
//                .get帳票認証者(GyomuCode.DB介護保険,
//                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                        発行日);
//        // TODO.イメージファイルパス　＝　ReportSourceWriter.getImageFolderPath()　より取得
//        boolean is公印に掛ける = 首長名印字位置.equals(帳票共通情報.get首長名印字位置());
//        boolean is公印を省略 = !帳票共通情報.is電子公印印字有無();

        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 送付物宛先情報 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        YokaigodoHenkoTsuchishoEntity printEntity = new YokaigodoHenkoTsuchishoEntity();

        printEntity.setBunshoNo(div.getCcdKobetsuKaigodoHenkoBunshoBango().get文書番号());
        //TODO
//            printEntity.setTitle(連絡符号);
        printEntity.setTsuchibun1(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_1)
                .concat(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_2)));
        printEntity.setTsuchibun2(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_3));
        printEntity.setTsuchibun3(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_4));
        printEntity.setTsuchibun4(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_5));
        //TODO
//      printEntity.setHihokenshaName(LIKE符号);
//        printEntity.setHihokenshaNo1(LIKE符号);
//            printEntity.setHihokenshaNo2(LIKE符号);
//            printEntity.setHihokenshaNo3(LIKE符号);
//            printEntity.setHihokenshaNo4(LIKE符号);
//            printEntity.setHihokenshaNo5(LIKE符号);
//            printEntity.setHihokenshaNo6(LIKE符号);
//            printEntity.setHihokenshaNo7(LIKE符号);
//            printEntity.setHihokenshaNo8(LIKE符号);
//            printEntity.setHihokenshaNo9(LIKE符号);
//            printEntity.setHihokenshaNo10(LIKE符号);
//        printEntity.setKosho1(LIKE符号);
//        printEntity.setKosho2(LIKE符号);
//        printEntity.setBeforeYokaigoKubun(LIKE符号);
//        printEntity.setAfterYokaigoKubun(LIKE符号);
//        printEntity.setHenkoYmd();
//        printEntity.setYukoKaishiYMD();
//        printEntity.setYukoShuryoYMD();
//        printEntity.setKigenKosho(LIKE符号);
//        printEntity.setKigenYMD();

        printEntity.setTsuchibun5(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_2, 通知文_項目番号_5));
        printEntity.setTsuchibun6(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_5));
        printEntity.setTsuchibun7(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_6));
        printEntity.setTsuchibun8(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_5));
        printEntity.setTsuchibun9(get通知文情報通知文(PanelType.個別発行要介護度変更通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_6));
        //TODO

        printEntity.setYubinNo(送付物宛先情報.get宛先住所().get郵便番号().value());
        printEntity.setGyoseiku(送付物宛先情報.get宛先行政区().get名称());
        //TODO
//        printEntity.setJushoText(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho1(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho2(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho3(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setKatagakiText(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki2(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall2(送付物宛先情報.get宛先住所().get方書().value());
        //TODO
//        printEntity.setDainoKubunMei(送付物宛先情報.代納人区分);
//        printEntity.setShimeiText(送付物宛先情報.氏名1);
//        printEntity.setShimei1(送付物宛先情報.氏名1);
//        printEntity.setShimei2(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall1(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall2(送付物宛先情報.氏名1);
//        printEntity.setSamabunShimeiText(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei2(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall2(送付物宛先情報.氏名2);
//        printEntity.setMeishoFuyo1(送付物宛先情報.氏名1);
//        printEntity.setMeishoFuyo2(送付物宛先情報.氏名1);
//        printEntity.setSamaBun1(送付物宛先情報.氏名2);
//        printEntity.setSamaBun2(送付物宛先情報.氏名2);
        printEntity.setKakkoLeft1(左括弧);
        printEntity.setKakkoLeft2(左括弧);
        printEntity.setKakkoRight1(右括弧);
        printEntity.setKakkoRight2(右括弧);
//        printEntity.setCustomerBarCode(送付物宛先情報.カスタマバーコード);
        return printEntity;
    }

    private NinteikyakkaTsuchishoEntity create個別発行認定却下通知書データ() {
        ChohyoSeigyoHanyo 帳票制御情報 = get帳票制御情報(PanelType.個別発行認定却下通知書パネル);
        ChohyoSeigyoKyotsu 帳票共通情報 = get帳票共通情報(PanelType.個別発行認定却下通知書パネル);
        FlexibleDate 発行日 = div.getTxtNinteiKekkaSakuseiDay().getValue();
//        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance()
//                .get帳票認証者(GyomuCode.DB介護保険,
//                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                        発行日);
//        // TODO.イメージファイルパス　＝　ReportSourceWriter.getImageFolderPath()　より取得
//        boolean is公印に掛ける = 首長名印字位置.equals(帳票共通情報.get首長名印字位置());
//        boolean is公印を省略 = !帳票共通情報.is電子公印印字有無();

        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 送付物宛先情報 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        NinteikyakkaTsuchishoEntity printEntity = new NinteikyakkaTsuchishoEntity();

        printEntity.setBunshoNo(div.getCcdKobetsuNinteiKyakkaBunshoBango().get文書番号());
        //TODO
//            printEntity.setTitle(連絡符号);
        printEntity.setTsuchibun1(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_1));
        printEntity.setTsuchibun2(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_1, 通知文_項目番号_2));
        //TODO
//      printEntity.setHihokenshaName(LIKE符号);
//        printEntity.setHihokenshaNo1(LIKE符号);
//            printEntity.setHihokenshaNo2(LIKE符号);
//            printEntity.setHihokenshaNo3(LIKE符号);
//            printEntity.setHihokenshaNo4(LIKE符号);
//            printEntity.setHihokenshaNo5(LIKE符号);
//            printEntity.setHihokenshaNo6(LIKE符号);
//            printEntity.setHihokenshaNo7(LIKE符号);
//            printEntity.setHihokenshaNo8(LIKE符号);
//            printEntity.setHihokenshaNo9(LIKE符号);
//            printEntity.setHihokenshaNo10(LIKE符号);

//        printEntity.setKyakkaYMD();
//        printEntity.setRiyu(連絡符号);
        printEntity.setTsuchibun3(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_2, 通知文_項目番号_2));
        printEntity.setTsuchibun4(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_2));
        printEntity.setTsuchibun5(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_3, 通知文_項目番号_3));
        printEntity.setTsuchibun6(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_2));
        printEntity.setTsuchibun7(get通知文情報通知文(PanelType.個別発行認定却下通知書パネル, 通知文_パターン番号_4, 通知文_項目番号_3));
//        printEntity.set
//        printEntity.set
//        printEntity.set
        printEntity.setYubinNo(送付物宛先情報.get宛先住所().get郵便番号().value());
        printEntity.setGyoseiku(送付物宛先情報.get宛先行政区().get名称());
        //TODO
//        printEntity.setJushoText(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho1(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho2(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setJusho3(送付物宛先情報.get宛先住所().get住所());
//        printEntity.setKatagakiText(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagaki2(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall1(送付物宛先情報.get宛先住所().get方書().value());
//        printEntity.setKatagakiSmall2(送付物宛先情報.get宛先住所().get方書().value());
        //TODO
//        printEntity.setDainoKubunMei(送付物宛先情報.代納人区分);
//        printEntity.setShimeiText(送付物宛先情報.氏名1);
//        printEntity.setShimei1(送付物宛先情報.氏名1);
//        printEntity.setShimei2(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall1(送付物宛先情報.氏名1);
//        printEntity.setShimeiSmall2(送付物宛先情報.氏名1);
//        printEntity.setSamabunShimeiText(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimei2(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall1(送付物宛先情報.氏名2);
//        printEntity.setSamabunShimeiSmall2(送付物宛先情報.氏名2);
//        printEntity.setMeishoFuyo1(送付物宛先情報.氏名1);
//        printEntity.setMeishoFuyo2(送付物宛先情報.氏名1);
//        printEntity.setSamaBun1(送付物宛先情報.氏名2);
//        printEntity.setSamaBun2(送付物宛先情報.氏名2);
        printEntity.setKakkoLeft1(左括弧);
        printEntity.setKakkoLeft2(左括弧);
        printEntity.setKakkoRight1(右括弧);
        printEntity.setKakkoRight2(右括弧);
//        printEntity.setCustomerBarCode(送付物宛先情報.カスタマバーコード);
        return printEntity;
    }

    private YokaigoNinteiTsutisho edit個別発行受給者台帳(YokaigoNinteiTsutisho データ, PanelType パネル) {
        YokaigoNinteiTsutishoBuilder builder = データ.createBuilderForNyukyushaAddEdit();
        if (パネル.equals(PanelType.個別発行認定結果通知書パネル)) {
            builder.set認定結果通知書発行年月日(div.getTxtNinteiKekkaSakuseiDay().getValue());
        } else if (パネル.equals(PanelType.個別発行サービス変更通知書パネル)) {
            builder.setサービス変更通知書発行年月日(div.getTxtServiceHenkoBunshoSakuseiDay().getValue());
        } else if (パネル.equals(PanelType.個別発行要介護度変更通知書パネル)) {
            builder.set区分変更通知書発行年月日(div.getTxtYokaigodoHenkoTsuchiSakuseiDay().getValue());
        } else if (パネル.equals(PanelType.個別発行認定却下通知書パネル)) {
            builder.set認定却下通知書発行年月日(div.getTxtNinteiKyakkaTsuchi().getValue());
        }

        builder.set受給者台帳履歴番号(new RString(String.format("%04d", Integer.parseInt(データ.get履歴番号().toString()) + 1)));
        return builder.build();
    }

    private void set帳票発行パネル(PanelType パネル) {
        if (パネル.equals(PanelType.個別発行認定結果通知書パネル)) {
            set個別発行認定結果通知書(パネル);
        } else if (パネル.equals(PanelType.個別発行サービス変更通知書パネル)) {
            set個別発行サービス変更通知書(パネル);
        } else if (パネル.equals(PanelType.個別発行要介護度変更通知書パネル)) {
            set個別発行要介護度変更通知書(パネル);
        } else if (パネル.equals(PanelType.個別発行認定却下通知書パネル)) {
            set個別発行認定却下通知書(パネル);
        } else if (パネル.equals(PanelType.一括発行パネル)) {
            set一括発行();
        }
    }

    private void set個別発行認定結果通知書(PanelType パネル) {
        dgTaishoshaIchiran_Row selectedRow = div.getDgTaishoshaIchiran().getSelectedItems().get(0);

        YokaigoNinteiTsutishoMybatisParameter param = new YokaigoNinteiTsutishoMybatisParameter();
        param.set申請書管理番号(selectedRow.getShinseishokanrino());
        param.set出力順(get出力順(パネル));
        YokaigoNinteiTsutisho 認定結果通知書情報 = YokaigoNinteiTsutishoManager.createInstance().get認定結果通知書情報(param);
        if (null == 認定結果通知書情報) {
            return;
        }
        div.getCcdKobetsuNinteiKekkaBunshoBango().initialize(パネル.getChohyoId());
        div.getRadNinteiKekkaRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtNinteikekkaJoho().setValue(
                get要介護度名(selectedRow.getKoroshoIfShikibetsuCode(),
                        convertCodeToRString(認定結果通知書情報.get二次判定要介護状態区分コード())));
        div.getTxtNinteiKekka().setFromValue(convertFlexibleDateToRDate(認定結果通知書情報.get二次判定認定有効開始年月日()));
        div.getTxtNinteiKekka().setToValue(convertFlexibleDateToRDate(認定結果通知書情報.get二次判定認定有効終了年月日()));
        div.getTxtNinteiKekkaShinsakaiIken().setValue(認定結果通知書情報.get介護認定審査会意見());
        // TODO. 受給者台帳.要介護認定状態区分コード  コード種別が’0003’のコード値
        div.getTxtNinteiKekkaRiyu().setValue(認定結果通知書情報.get異動理由());
    }

    private RString get出力順(PanelType パネル) {
        // TODO.
        return RString.EMPTY;
    }

    private void set個別発行サービス変更通知書(PanelType パネル) {
        dgTaishoshaIchiran_Row selectedRow = div.getDgTaishoshaIchiran().getSelectedItems().get(0);

        YokaigoNinteiTsutishoMybatisParameter param = new YokaigoNinteiTsutishoMybatisParameter();
        param.set申請書管理番号(selectedRow.getShinseishokanrino());
        param.set要介護認定状態区分コード(selectedRow.getYokaigodoCode());
        param.set認定有効期間開始年月日(convertRDateToFlexibleDate(selectedRow.getKaishiDay().getValue()));
        param.set認定有効期間終了年月日(convertRDateToFlexibleDate(selectedRow.getShuryoDay().getValue()));
        param.set最大表示件数(2);
        param.set出力順(get出力順(パネル));
        List<YokaigoNinteiTsutisho> 受給者台帳情報リスト = YokaigoNinteiTsutishoManager.createInstance().get受給者台帳情報(param);
        if (null == 受給者台帳情報リスト || 受給者台帳情報リスト.isEmpty()) {
            return;
        }

        YokaigoNinteiTsutisho 変更後サービス通知書 = 受給者台帳情報リスト.get(0);
        YokaigoNinteiTsutisho 変更前サービス通知書 = 受給者台帳情報リスト.size() == 2 ? 受給者台帳情報リスト.get(1) : null;

        div.getCcdKobetsuServiceHenkoBunshoBango().initialize(パネル.getChohyoId());
        div.getRadServiceHenkoBunshoRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtServiceHenkoBunshoYukoKikanRange().setFromValue(convertFlexibleDateToRDate(変更後サービス通知書.get認定有効期間開始年月日()));
        div.getTxtServiceHenkoBunshoYukoKikanRange().setToValue(convertFlexibleDateToRDate(変更後サービス通知書.get認定有効期間終了年月日()));
        div.getTxtHenkoBeforeService().setValue(getサービス種類(変更前サービス通知書));
        div.getTxtHenkoAfterService().setValue(getサービス種類(変更後サービス通知書));
        div.getTxtServiceHenkoRiyu().setValue(変更後サービス通知書.get異動理由());
    }

    private RString getサービス種類(YokaigoNinteiTsutisho 受給者台帳情報) {
        if (null == 受給者台帳情報) {
            return RString.EMPTY;
        }
        RString サービス種類 = RString.EMPTY;
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類01());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類02());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類03());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類04());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類05());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類06());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類07());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類08());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類09());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類10());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類11());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類12());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類13());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類14());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類15());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類16());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類17());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類18());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類19());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類20());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類21());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類22());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類23());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類24());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類25());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類26());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類27());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類28());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類29());
        サービス種類 = get連絡後文字列(サービス種類, 受給者台帳情報.get指定サービス種類30());

        return サービス種類;
    }

    private RString get連絡後文字列(RString 連絡前文字列, ServiceShuruiCode サービス種類) {
        if (null == サービス種類 || サービス種類.isEmpty()) {
            return 連絡前文字列;
        }

        if (null == 連絡前文字列 || 連絡前文字列.isEmpty()) {
            return サービス種類.value();
        }

        return 連絡前文字列.concat(連絡符号).concat(サービス種類.value());
    }

    private void set個別発行要介護度変更通知書(PanelType パネル) {
        dgTaishoshaIchiran_Row selectedRow = div.getDgTaishoshaIchiran().getSelectedItems().get(0);

        YokaigoNinteiTsutishoMybatisParameter param = new YokaigoNinteiTsutishoMybatisParameter();
        param.set申請書管理番号(selectedRow.getShinseishokanrino());
        param.set認定有効期間開始年月日(convertRDateToFlexibleDate(selectedRow.getKaishiDay().getValue()));
        param.set認定有効期間終了年月日(convertRDateToFlexibleDate(selectedRow.getShuryoDay().getValue()));
        param.set最大表示件数(2);
        param.set出力順(get出力順(パネル));
        List<YokaigoNinteiTsutisho> 受給者台帳情報リスト = YokaigoNinteiTsutishoManager.createInstance().get受給者台帳情報(param);
        if (null == 受給者台帳情報リスト || 受給者台帳情報リスト.isEmpty()) {
            return;
        }
        YokaigoNinteiTsutisho 新要介護度変更通知書 = 受給者台帳情報リスト.get(0);
        YokaigoNinteiTsutisho 旧要介護度変更通知書 = 受給者台帳情報リスト.size() == 2 ? 受給者台帳情報リスト.get(1) : null;

        div.getCcdKobetsuKaigodoHenkoBunshoBango().initialize(パネル.getChohyoId());
        div.getRadYokaigodoHenkoRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtKyuYokaigodo().setValue(null == 旧要介護度変更通知書
                ? RString.EMPTY : get要介護度名(selectedRow.getKoroshoIfShikibetsuCode(),
                        convertCodeToRString(旧要介護度変更通知書.get要介護認定状態区分コード())));
        div.getTxtShinYokaigodo().setValue(get要介護度名(selectedRow.getKoroshoIfShikibetsuCode(),
                convertCodeToRString(新要介護度変更通知書.get要介護認定状態区分コード())));
        div.getTxtHenkoYMD().setValue(新要介護度変更通知書.get認定年月日());
        div.getTxtYukoKikanRange().setFromValue(convertFlexibleDateToRDate(新要介護度変更通知書.get認定有効期間開始年月日()));
        div.getTxtYukoKikanRange().setToValue(convertFlexibleDateToRDate(新要介護度変更通知書.get認定有効期間終了年月日()));
    }

    private void set個別発行認定却下通知書(PanelType パネル) {
        dgTaishoshaIchiran_Row selectedRow = div.getDgTaishoshaIchiran().getSelectedItems().get(0);

        YokaigoNinteiTsutishoMybatisParameter param = new YokaigoNinteiTsutishoMybatisParameter();
        param.set申請書管理番号(selectedRow.getShinseishokanrino());
        param.set認定年月日(convertRDateToFlexibleDate(selectedRow.getNinteiDay().getValue()));
        param.set認定有効期間開始年月日(convertRDateToFlexibleDate(selectedRow.getKaishiDay().getValue()));
        param.set認定有効期間終了年月日(convertRDateToFlexibleDate(selectedRow.getShuryoDay().getValue()));
        param.set最大表示件数(1);
        param.set出力順(get出力順(パネル));
        List<YokaigoNinteiTsutisho> 受給者台帳情報リスト = YokaigoNinteiTsutishoManager.createInstance().get受給者台帳情報(param);
        if (null == 受給者台帳情報リスト || 受給者台帳情報リスト.isEmpty()) {
            return;
        }

        YokaigoNinteiTsutisho 認定却下通知書 = 受給者台帳情報リスト.get(0);
        div.getCcdKobetsuNinteiKyakkaBunshoBango().initialize(パネル.getChohyoId());
        div.getRadNinteiKyakkaRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtKyakkaDay().setValue(認定却下通知書.get認定年月日());
        div.getTxtIdoJiyu().setValue(認定却下通知書.get異動理由());
    }

    private void set一括発行() {

        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == 市町村セキュリティ情報) {
            return;
        }
        RString 市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード().value();
        set一括発行認定結果通知書(市町村コード, PanelType.一括発行認定結果通知書パネル);
        set一括発行サービス変更通知書(市町村コード, PanelType.一括発行サービス変更通知書パネル);
        set一括発行要介護区分変更通知書(市町村コード, PanelType.一括発行要介護度変更通知書パネル);

    }

    private void set一括発行認定結果通知書(RString 市町村コード, PanelType パネル) {
        YokaigoNinteiTsutishoIkkatsuHakkoJoho 認定結果通知書 = YokaigoNinteiTsutishoManager.createInstance().get一括発行データ(
                市町村コード, ShoriName.認定結果通知書.get名称());
        if (null != 認定結果通知書) {
            div.getTxtNinteiKekkaZenkaiYMDFrom().setValue(認定結果通知書.get対象開始年月日());
            div.getTxtNinteiKekkaZenkaiTimeFrom().setValue(認定結果通知書.get対象開始日時());
            div.getTxtNinteiKekkaZenkaiYMDTo().setValue(認定結果通知書.get対象終了年月日());
            div.getTxtNinteiKekkaZenkaiTimeTo().setValue(認定結果通知書.get対象終了日時());
            div.getTxtNinteiKekkaKonkaiYMDFrom().setValue(認定結果通知書.get対象終了年月日());
            div.getTxtNinteiKekkaKonkaiTimeFrom().setValue(認定結果通知書.get対象終了日時().plusSeconds(1));
        } else {
            div.getTxtNinteiKekkaKonkaiYMDFrom().setValue(FlexibleDate.getNowDate());
            div.getTxtNinteiKekkaKonkaiTimeFrom().setValue(RTime.now());
        }
        div.getCcdIkkatsuNinteiKekkaBunshoBango().initialize(パネル.getChohyoId());
    }

    private void set一括発行サービス変更通知書(RString 市町村コード, PanelType パネル) {
        YokaigoNinteiTsutishoIkkatsuHakkoJoho サービス変更通知書 = YokaigoNinteiTsutishoManager.createInstance().get一括発行データ(
                市町村コード, ShoriName.サービス変更通知書.get名称());
        if (null != サービス変更通知書) {
            div.getTxtServiceHenkoZenkaiYMDFrom().setValue(サービス変更通知書.get対象開始年月日());
            div.getTxtServiceHenkoZenkaiTimeForm().setValue(サービス変更通知書.get対象開始日時());
            div.getTxtServiceHenkoZenkaiYMDTo().setValue(サービス変更通知書.get対象終了年月日());
            div.getTxtServiceHenkoZenkaiTimeTo().setValue(サービス変更通知書.get対象終了日時());
            div.getTxtServiceHenkoKonkaiYMDFrom().setValue(サービス変更通知書.get対象終了年月日());
            div.getTxtServiceHenkoKonkaiTimeFrom().setValue(サービス変更通知書.get対象終了日時().plusSeconds(1));
        } else {
            div.getTxtServiceHenkoKonkaiYMDFrom().setValue(FlexibleDate.getNowDate());
            div.getTxtServiceHenkoKonkaiTimeFrom().setValue(RTime.now());
        }
        div.getCcdIkkatsuServiceHenkoBunshoBango().initialize(パネル.getChohyoId());
    }

    private void set一括発行要介護区分変更通知書(RString 市町村コード, PanelType パネル) {
        YokaigoNinteiTsutishoIkkatsuHakkoJoho 要介護区分変更通知書 = YokaigoNinteiTsutishoManager.createInstance().get一括発行データ(
                市町村コード, ShoriName.要介護区分変更通知書.get名称());
        if (null != 要介護区分変更通知書) {
            div.getTxtKubunHenkoZenkaiYMDFrom().setValue(要介護区分変更通知書.get対象開始年月日());
            div.getTxtKubunHenkoZenkaiTimeFrom().setValue(要介護区分変更通知書.get対象開始日時());
            div.getTxtKubunHenkoZenkaiYMDTo().setValue(要介護区分変更通知書.get対象終了年月日());
            div.getTxtKubunHenkoZenkaiTimeTo().setValue(要介護区分変更通知書.get対象終了日時());
            div.getTxtKubunHenkoKonkaiYMDFrom().setValue(要介護区分変更通知書.get対象終了年月日());
            div.getTxtKubunHenkoKonkaiTimeFrom().setValue(要介護区分変更通知書.get対象終了日時().plusSeconds(1));
        } else {
            div.getTxtKubunHenkoKonkaiYMDFrom().setValue(FlexibleDate.getNowDate());
            div.getTxtKubunHenkoKonkaiTimeFrom().setValue(RTime.now());
        }
        div.getCcdIkkatsuKubunHenkoBunshoBango().initialize(パネル.getChohyoId());
    }

    private void setChohyoPanelOpenClose(PanelType パネル) {
        div.getIkkatsuHakko().setIsOpen(パネル.equals(PanelType.一括発行パネル));
        div.getNinteiKekkaTsuchi().setIsOpen(パネル.equals(PanelType.個別発行認定結果通知書パネル));
        div.getServiceHenkoTsuchi().setIsOpen(パネル.equals(PanelType.個別発行サービス変更通知書パネル));
        div.getYokaigodoHenkoTsuchi().setIsOpen(パネル.equals(PanelType.個別発行要介護度変更通知書パネル));
        div.getNinteiKyakkaTshuchi().setIsOpen(パネル.equals(PanelType.個別発行認定却下通知書パネル));
    }

    private void set出力順エリア(PanelType パネル) {
        div.getCcdChohyoShutsuryokujun().setIsOpen(true);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, パネル.getChohyoId());
    }

    private void clear個別発行認定結果通知書() {
        // TODO. clear方法がない。
        div.getCcdKobetsuNinteiKekkaBunshoBango().initialize(ReportIdDBD.DBD532001.getReportId());
        div.getRadNinteiKekkaRireki().setDataSource(get発行履歴データソース());
        div.getRadNinteiKekkaRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtNinteiKekkaSakuseiDay().clearValue();
        div.getTxtNinteikekkaJoho().clearValue();
        div.getTxtNinteiKekka().clearFromValue();
        div.getTxtNinteiKekka().clearToValue();
        div.getTxtNinteiKekkaShinsakaiIken().clearValue();
        div.getTxtNinteiKekkaRiyu().clearValue();
    }

    private void clear個別発行サービス変更通知書() {
        // TODO. clear方法がない。
        div.getCcdKobetsuServiceHenkoBunshoBango().initialize(ReportIdDBD.DBD550002.getReportId());
        div.getRadServiceHenkoBunshoRireki().setDataSource(get発行履歴データソース());
        div.getRadServiceHenkoBunshoRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtServiceHenkoBunshoSakuseiDay().clearValue();
        div.getTxtServiceHenkoBunshoYukoKikanRange().clearFromValue();
        div.getTxtServiceHenkoBunshoYukoKikanRange().clearToValue();
        div.getTxtHenkoBeforeService().clearValue();
        div.getTxtHenkoAfterService().clearValue();
        div.getTxtServiceHenkoRiyu().clearValue();

    }

    private void clear個別発行要介護度変更通知書() {
        // TODO. clear方法がない。
        div.getCcdKobetsuKaigodoHenkoBunshoBango().initialize(ReportIdDBD.DBD550003.getReportId());
        div.getRadYokaigodoHenkoRireki().setDataSource(get発行履歴データソース());
        div.getRadYokaigodoHenkoRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtYokaigodoHenkoTsuchiSakuseiDay().clearValue();
        div.getTxtKyuYokaigodo().clearValue();
        div.getTxtShinYokaigodo().clearValue();
        div.getTxtHenkoYMD().clearValue();
        div.getTxtYukoKikanRange().clearFromValue();
        div.getTxtYukoKikanRange().clearToValue();
        div.getTxtHihokenshashoTeishutsuKigen().clearValue();
    }

    private void clear個別発行認定却下通知書() {
        // TODO. clear方法がない。
        div.getCcdKobetsuNinteiKyakkaBunshoBango().initialize(ReportIdDBD.DBD550001.getReportId());
        div.getRadNinteiKyakkaRireki().setDataSource(get発行履歴データソース());
        div.getRadNinteiKyakkaRireki().setSelectedKey(RadioValue.残す.getKey());
        div.getTxtNinteiKyakkaTsuchi().clearValue();
        div.getTxtKyakkaDay().clearValue();
        div.getTxtIdoJiyu().clearValue();
        div.getTxtKyakkaRiyu().clearValue();
    }

    private void clear個別発行() {
        clear個別発行認定結果通知書();
        clear個別発行サービス変更通知書();
        clear個別発行要介護度変更通知書();
        clear個別発行認定却下通知書();
    }

    private void clear一括発行認定結果通知書() {
        div.getTxtNinteiKekkaZenkaiYMDFrom().clearValue();
        div.getTxtNinteiKekkaZenkaiTimeFrom().clearValue();
        div.getTxtNinteiKekkaZenkaiYMDTo().clearValue();
        div.getTxtNinteiKekkaZenkaiTimeTo().clearValue();
        div.getTxtNinteiKekkaKonkaiYMDFrom().clearValue();
        div.getTxtNinteiKekkaKonkaiTimeFrom().clearValue();
        div.getTxtNinteiKekkaKonkaiYMDTo().clearValue();
        div.getTxtNinteiKekkaKonkaiTimeTo().clearValue();
        // TODO. clearがない。
        div.getCcdIkkatsuNinteiKekkaBunshoBango().initialize(ReportIdDBD.DBD532001.getReportId());
    }

    private void clear一括発行サービス変更通知書() {
        div.getTxtServiceHenkoZenkaiYMDFrom().clearValue();
        div.getTxtServiceHenkoZenkaiTimeForm().clearValue();
        div.getTxtServiceHenkoZenkaiYMDTo().clearValue();
        div.getTxtServiceHenkoZenkaiTimeTo().clearValue();
        div.getTxtServiceHenkoKonkaiYMDFrom().clearValue();
        div.getTxtServiceHenkoKonkaiTimeFrom().clearValue();
        div.getTxtServiceHenkoKonkaiYMDTo().clearValue();
        div.getTxtServiceHenkoKonkaiTimeTo().clearValue();
        // TODO. clearがない。
        div.getCcdIkkatsuServiceHenkoBunshoBango().initialize(ReportIdDBD.DBD550002.getReportId());

    }

    private void clear一括発行要介護度変更通知書() {
        div.getTxtKubunHenkoZenkaiYMDFrom().clearValue();
        div.getTxtKubunHenkoZenkaiTimeFrom().clearValue();
        div.getTxtKubunHenkoZenkaiYMDTo().clearValue();
        div.getTxtKubunHenkoZenkaiTimeTo().clearValue();
        div.getTxtKubunHenkoKonkaiYMDFrom().clearValue();
        div.getTxtKubunHenkoKonkaiTimeFrom().clearValue();
        div.getTxtKubunHenkoKonkaiYMDTo().clearValue();
        div.getTxtKubunHenkoKonkaiTimeTo().clearValue();
        // TODO. clearがない。
        div.getCcdIkkatsuKubunHenkoBunshoBango().initialize(ReportIdDBD.DBD550003.getReportId());
    }

    private void clear一括発行() {
        div.getChkOutPutSelect().setDataSource(get帳票出力対象データソース());
        div.getChkOutPutSelect().setSelectedItemsByKey(new ArrayList<RString>());
        div.getTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay().clearValue();
        div.getRadTanpyoHakkoZumi().setDataSource(get単票発行済みデータソース());
        div.getRadTanpyoHakkoZumi().setSelectedKey(RadioValue.発行済みを出力する.getKey());

        clear一括発行認定結果通知書();
        clear一括発行サービス変更通知書();
        clear一括発行要介護度変更通知書();
    }

    private void clear出力順() {
        // TODO. clear方法がない。
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportId.EMPTY);
    }

    private void setChohyoAreaMode(RString 帳票発行Rad, boolean selected) {
        div.getCcdChohyoShutsuryokujun().setDisplayNone(!selected);

        if (帳票発行Rad.equals(NinteiTsuchishoHakkoHandler.RadioValue.個別発行を行う.getKey())) {
            div.getKobetsuPrint().setDisplayNone(!selected);
            div.getKobetsuPrint().setIsOpen(false);
            div.getNinteiKekkaTsuchi().setIsOpen(false);
            div.getNinteiKekkaTsuchi().setIsOpen(false);
            div.getYokaigodoHenkoTsuchi().setIsOpen(false);
            div.getNinteiKyakkaTshuchi().setIsOpen(false);
            div.getCcdChohyoShutsuryokujun().setIsOpen(false);
        } else {
            div.getIkkatsuHakko().setDisplayNone(!selected);
            div.getIkkatsuHakko().setIsOpen(false);
            div.getChushutsuTasho().setIsOpen(false);
            div.getCcdChohyoShutsuryokujun().setIsOpen(false);
        }

    }

    private void set対象者一覧(List<YokaigoNinteiTsutisho> 対象者リスト) {
        List<dgTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (YokaigoNinteiTsutisho 対象者 : 対象者リスト) {
            rowList.add(getRowData(対象者));
        }
        div.getDgTaishoshaIchiran().setDataSource(rowList);
    }

    private dgTaishoshaIchiran_Row getRowData(YokaigoNinteiTsutisho 対象者) {
        dgTaishoshaIchiran_Row row = new dgTaishoshaIchiran_Row();
        row.setHihoNo(対象者.get被保険者番号());
        row.setShimei(null != 対象者.get被保険者氏名() ? 対象者.get被保険者氏名().getColumnValue() : RString.EMPTY);
        try {
            row.setSeibetsu(Seibetsu.toValue(対象者.get性別().value()).get名称());
        } catch (IllegalArgumentException e) {
        }
        row.getBirthYMD().setValue(convertFlexibleDateToRDate(対象者.get生年月日()));
        row.getNinteiShinseiDay().setValue(convertFlexibleDateToRDate(対象者.get認定申請年月日()));
        try {
            row.setShinseiji(NinteiShinseiShinseijiKubunCode.toValue(対象者.get認定申請区分申請時コード().value()).get名称());
        } catch (IllegalArgumentException e) {
        }
        try {
            row.setHorei(NinteiShinseiHoreiCode.toValue(対象者.get認定申請区分法令コード().value()).get名称());
        } catch (IllegalArgumentException e) {
        }
        row.getNinteiDay().setValue(convertFlexibleDateToRDate(対象者.get認定年月日()));
        row.setYokaigodo(get要介護度名(convertCodeToRString(対象者.get厚労省IF識別コード()),
                convertCodeToRString(対象者.get要介護認定状態区分コード())));
        row.setTsukisu(get月数(対象者.get認定有効期間開始年月日(), 対象者.get認定有効期間終了年月日()));
        row.getKaishiDay().setValue(convertFlexibleDateToRDate(対象者.get認定有効期間開始年月日()));
        row.getShuryoDay().setValue(convertFlexibleDateToRDate(対象者.get認定有効期間終了年月日()));
        row.setShinseishokanrino(対象者.get申請書管理番号());
        row.setKoroshoIfShikibetsuCode(convertCodeToRString(対象者.get厚労省IF識別コード()));
        row.setYokaigodoCode(convertCodeToRString(対象者.get要介護認定状態区分コード()));
        return row;
    }

    private RString get要介護度名(RString 厚労省IF識別コード, RString 要介護度コード) {
        try {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
            }
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }

    private RString get月数(FlexibleDate from, FlexibleDate to) {
        if (null == from || from.isEmpty() || null == to || to.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(to.getBetweenMonths(from));
    }

    private List<YokaigoNinteiTsutisho> get対象者リスト() {
        YokaigoNinteiTsutishoMybatisParameter param = new YokaigoNinteiTsutishoMybatisParameter();
//        param.set保険者番号(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号());
        param.set被保険者番号(div.getTxtHihoNo().getValue());
        param.set識別コード(null != div.getTxtShikibetsuCode().getValue()
                ? new ShikibetsuCode(div.getTxtShikibetsuCode().getValue()) : ShikibetsuCode.EMPTY);
        RString 氏名 = div.getTxtShimei().getValue();
        if (null != 氏名 && !氏名.isEmpty()) {
            if (div.getDdlMachJoken().getSelectedKey().equals(RadioValue.前方一致.getKey())) {
                氏名 = 氏名.concat(LIKE符号);
            } else if (div.getDdlMachJoken().getSelectedKey().equals(RadioValue.後方一致.getKey())) {
                氏名 = LIKE符号.concat(氏名);
            } else if (div.getDdlMachJoken().getSelectedKey().equals(RadioValue.部分一致.getKey())) {
                氏名 = LIKE符号.concat(氏名).concat(LIKE符号);
            }
        }
        param.set氏名(氏名);
        param.set生年月日(div.getTxtBirthYMD().getValue());

        List<RString> 性別コードリスト = new ArrayList<>();
        if (div.getChkSeibetsu().getSelectedKeys().contains(RadioValue.男.getKey())) {
            性別コードリスト.add(Seibetsu.男.getコード());
        }
        if (div.getChkSeibetsu().getSelectedKeys().contains(RadioValue.女.getKey())) {
            性別コードリスト.add(Seibetsu.女.getコード());
        }
        param.set性別コードリスト(性別コードリスト);
        param.set申請開始日(convertRDateToFlexibleDate(div.getTxtShinseiDay().getFromValue()));
        param.set申請終了日(convertRDateToFlexibleDate(div.getTxtShinseiDay().getToValue()));
        param.set認定開始日(convertRDateToFlexibleDate(div.getTxtNinteiDay().getFromValue()));
        param.set認定終了日(convertRDateToFlexibleDate(div.getTxtNinteiDay().getToValue()));
        param.set最大表示件数(div.getTxtSaidaiHyojiKensu().getValue().intValue());
        return YokaigoNinteiTsutishoManager.createInstance().get対象者情報(param);
    }

    private List<KeyValueDataSource> get通知書発行方法データソース() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RadioValue.個別発行を行う.getKey(), RadioValue.個別発行を行う.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.一括発行を行う.getKey(), RadioValue.一括発行を行う.getValue()));
        return dataSource;
    }

    private List<KeyValueDataSource> get性別データソース() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RadioValue.男.getKey(), RadioValue.男.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.女.getKey(), RadioValue.女.getValue()));
        return dataSource;
    }

    private List<KeyValueDataSource> get検索条件区分データソース() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RadioValue.前方一致.getKey(), RadioValue.前方一致.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.後方一致.getKey(), RadioValue.後方一致.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.部分一致.getKey(), RadioValue.部分一致.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.完全一致.getKey(), RadioValue.完全一致.getValue()));
        return dataSource;
    }

    private List<KeyValueDataSource> get発行履歴データソース() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RadioValue.残す.getKey(), RadioValue.残す.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.残さない.getKey(), RadioValue.残さない.getValue()));
        return dataSource;
    }

    private List<KeyValueDataSource> get帳票出力対象データソース() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RadioValue.認定結果通知書.getKey(), RadioValue.認定結果通知書.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.サービス変更通知書.getKey(), RadioValue.サービス変更通知書.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.要介護度変更通知書.getKey(), RadioValue.要介護度変更通知書.getValue()));
        return dataSource;
    }

    private List<KeyValueDataSource> get単票発行済みデータソース() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RadioValue.発行済みを出力する.getKey(), RadioValue.発行済みを出力する.getValue()));
        dataSource.add(new KeyValueDataSource(RadioValue.発行済みを出力しない.getKey(), RadioValue.発行済みを出力しない.getValue()));
        return dataSource;
    }

    private Decimal get最大表示件数() {
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        return null != 最大表示件数 ? new Decimal(最大表示件数.toString()) : null;
    }

    private FlexibleDate convertRDateToFlexibleDate(RDate target) {
        if (null == target) {
            return null;
        }
        return new FlexibleDate(target.toDateString());
    }

    private RDate convertFlexibleDateToRDate(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return null;
        }
        return new RDate(target.toString());
    }

    private RString convertCodeToRString(Code target) {
        return null == target || target.isEmpty() ? RString.EMPTY : target.value();
    }

    /**
     * 「保存する」ボタンをクリック
     *
     * @param 認定情報 YokaigoNinteiJoho
     */
    public void save(YokaigoNinteiJoho 認定情報) {
//        // TODO. is受給の判断わからない。
//        boolean is受給 = ResponseHolder.getMenuID().equals(new RString("1"));
//
//        if (is受給) {
//            認定情報 = edit受給者台帳(認定情報);
//            認定情報 = edit要介護認定申請情報受給(認定情報);
//        } else {
//            認定情報 = edit要介護認定申請情報認定(認定情報);
//        }
//
//        YokaigoNinteiJohoManager.createInstance().save介護認定申請情報(認定情報, is受給);

    }
}
