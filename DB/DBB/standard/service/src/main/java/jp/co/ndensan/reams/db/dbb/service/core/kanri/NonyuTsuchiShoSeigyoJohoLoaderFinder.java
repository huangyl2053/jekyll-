/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.GinfuriTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KanendoMongon;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoShutsuryoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.OCRShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuHizukeRan;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuinranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshushoHizukeranKiHyoji;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SagakuReishoHakkoShijiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SanteiKiso;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuHoshiki;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SokuhoTorikomiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SonotaTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ToshoShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri.KariSanteiNonyuTsuchiShoSeigyoJohoParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kanri.INonyuTsuchiShoSeigyoJohoLoaderMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 納入通知書制御情報取得クラス。
 *
 * @reamsid_L DBB-9110-011 wangjie2
 */
public class NonyuTsuchiShoSeigyoJohoLoaderFinder {

    private final MapperProvider mapperProvider;
    private FlexibleYear 調定年度;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("4");
    private final RString 標準版ブックタイプ = new RString("001");
    private final RString 標準版コンビニタイプ = new RString("101");
    private final RString 飯田市版コンビニタイプ = new RString("10E");
    private final RString コンビニマルチ収納タイプ = new RString("301");
    private final RString コンビニ角公タイプ = new RString("302");
    private final RString 差額令書発行指示 = new RString("差額令書発行指示");
    private final RString 当初出力_中期開始期 = new RString("当初出力_中期開始期");
    private final RString 当初出力_後期開始期 = new RString("当初出力_後期開始期");
    private final RString 当初出力_出力方法 = new RString("当初出力_出力方法");
    private final RString 期毎納入通知書タイプ = new RString("期毎納入通知書タイプ");
    private final RString 銀振納入通知書タイプ = new RString("銀振納入通知書タイプ");
    private final RString その他納入通知書タイプ = new RString("その他納入通知書タイプ");
    private final RString コンビニ明細書表示 = new RString("コンビニ明細書表示");
    private final RString ブック口座振替依頼表示 = new RString("ブック口座振替依頼表示");
    private final RString コンビニバーコード表示 = new RString("コンビニバーコード表示");
    private final RString コンビニ_ブック口座用納付書表示 = new RString("コンビニ_ブック口座用納付書表示");
    private final RString コンビニ納付書発行日表示 = new RString("コンビニ納付書発行日表示");
    private final RString コンビニ納付書取扱期限表示 = new RString("コンビニ納付書取扱期限表示");
    private final RString コンビニ期毎出力 = new RString("コンビニ期毎出力");
    private final RString 算定の基礎1 = new RString("算定の基礎1");
    private final RString 算定の基礎2 = new RString("算定の基礎2");
    private final RString 算定の基礎3 = new RString("算定の基礎3");
    private final RString 出力部数 = new RString("出力部数");
    private final RString 領収証書納付額欄 = new RString("領収証書納付額欄");
    private final RString 納付書納付額欄 = new RString("納付書納付額欄");
    private final RString 領収証書領収印欄 = new RString("領収証書領収印欄");
    private final RString 納付書領収印欄 = new RString("納付書領収印欄");
    private final RString 口座振替のOCR出力方法 = new RString("口座振替のOCR出力方法");
    private final RString 領収書領収日付印欄 = new RString("領収書領収日付印欄");
    private final RString 納付書領収日付欄 = new RString("納付書領収日付欄");
    private final RString 納期限出力方法 = new RString("納期限出力方法");
    private final RString 領収書日付印欄の期 = new RString("領収書日付印欄の期");
    private final RString 納付書市町村名表示 = new RString("納付書市町村名表示");
    private final RString 納付書市町村名 = new RString("納付書市町村名");
    private final RString 速報取込区分 = new RString("速報取込区分");
    private final RString 納付額算出方法 = new RString("納付額算出方法");
    private final RString 単票発行_出力方式 = new RString("単票発行_出力方式");
    private final RString 単票発行_出力形式 = new RString("単票発行_出力形式");
    private final RString 過年度文言1 = new RString("過年度文言1");
    private final RString 過年度文言2 = new RString("過年度文言2");

    /**
     * コンストラクタです。
     */
    NonyuTsuchiShoSeigyoJohoLoaderFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NonyuTsuchiShoSeigyoJohoLoader}のインスタンスを返します。
     *
     * @param 調定年度 調定年度
     * @return {@link InstanceProvider#create}にて生成した{@link NonyuTsuchiShoSeigyoJohoLoader}のインスタンス
     */
    public static NonyuTsuchiShoSeigyoJohoLoaderFinder createInstance(FlexibleYear 調定年度) {
        NonyuTsuchiShoSeigyoJohoLoaderFinder nonyuTsuchiShoSeigyoJohoLoader
                = InstanceProvider.create(NonyuTsuchiShoSeigyoJohoLoaderFinder.class);
        nonyuTsuchiShoSeigyoJohoLoader.調定年度 = 調定年度;
        return nonyuTsuchiShoSeigyoJohoLoader;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NonyuTsuchiShoSeigyoJohoLoader}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NonyuTsuchiShoSeigyoJohoLoader}のインスタンス
     */
    public static NonyuTsuchiShoSeigyoJohoLoaderFinder createInstance() {
        NonyuTsuchiShoSeigyoJohoLoaderFinder nonyuTsuchiShoSeigyoJohoLoader
                = InstanceProvider.create(NonyuTsuchiShoSeigyoJohoLoaderFinder.class);
        FlexibleYear 調定年度
                = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        nonyuTsuchiShoSeigyoJohoLoader.調定年度 = 調定年度.isEmpty() ? new FlexibleYear("0000") : 調定年度;
        return nonyuTsuchiShoSeigyoJohoLoader;
    }

    /**
     * 「帳票制御汎用」テーブル　から、仮算定納入通知書制御情報取得します。
     *
     * @return 仮算定納入通知書制御情報
     */
    public KariSanteiNonyuTsuchiShoSeigyoJoho get仮算定納入通知書制御情報() {
        INonyuTsuchiShoSeigyoJohoLoaderMapper mapper = mapperProvider.create(INonyuTsuchiShoSeigyoJohoLoaderMapper.class);
        KariSanteiNonyuTsuchiShoSeigyoJohoParameter 納入通知書制御情報取得パラメータ
                = KariSanteiNonyuTsuchiShoSeigyoJohoParameter.createParam(SubGyomuCode.DBB介護賦課, 調定年度);
        List<DbT7067ChohyoSeigyoHanyoEntity> chohyoSeigyoHanyoEntityLst = mapper.get仮算定納入通知書制御情報(納入通知書制御情報取得パラメータ);
        KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報 = new KariSanteiNonyuTsuchiShoSeigyoJoho();
        for (DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity : chohyoSeigyoHanyoEntityLst) {
            RString 項目名 = dbT7067ChohyoSeigyoHanyoEntity.getKomokuName();
            RString 設定値 = dbT7067ChohyoSeigyoHanyoEntity.getKomokuValue();
            if (算定の基礎1.equals(項目名)) {
                仮算定納入通知書制御情報.set算定の基礎1(get算定の基礎(設定値));
            }
            if (算定の基礎2.equals(項目名)) {
                仮算定納入通知書制御情報.set算定の基礎2(get算定の基礎(設定値));
            }
            if (算定の基礎3.equals(項目名)) {
                仮算定納入通知書制御情報.set算定の基礎3(get算定の基礎(設定値));
            }
        }
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = set納入通知書制御情報(chohyoSeigyoHanyoEntityLst);
        仮算定納入通知書制御情報.set納入通知書制御情報(納入通知書制御情報);
        return 仮算定納入通知書制御情報;
    }

    /**
     * 仮算定納入通知書制御情報設定します。
     *
     * @param chohyoSeigyoHanyoEntityLst テーブルから取得した仮算定納入通知書制御情報
     * @return 納入通知書制御情報
     */
    private NonyuTsuchiShoSeigyoJoho set納入通知書制御情報(
            List<DbT7067ChohyoSeigyoHanyoEntity> chohyoSeigyoHanyoEntityLst) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = new NonyuTsuchiShoSeigyoJoho();
        納入通知書制御情報.setExists中期開始期(false);
        納入通知書制御情報.setExists後期開始期(false);
        for (DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity : chohyoSeigyoHanyoEntityLst) {
            RString 項目名 = dbT7067ChohyoSeigyoHanyoEntity.getKomokuName();
            RString 設定値 = dbT7067ChohyoSeigyoHanyoEntity.getKomokuValue();
            set納入通知書制御情報1(納入通知書制御情報, 項目名, 設定値);
            set納入通知書制御情報2(納入通知書制御情報, 項目名, 設定値);
            set納入通知書制御情報3(納入通知書制御情報, 項目名, 設定値);
            set納入通知書制御情報4(納入通知書制御情報, 項目名, 設定値);
            set納入通知書制御情報5(納入通知書制御情報, 項目名, 設定値);
            set納入通知書制御情報6(納入通知書制御情報, 項目名, 設定値);
        }
        return 納入通知書制御情報;
    }

    private void set納入通知書制御情報1(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 項目名, RString 設定値) {
        if (出力部数.equals(項目名)) {
            納入通知書制御情報.set出力部数(null == 設定値 ? 0 : Integer.parseInt(設定値.toString()));
        }
        if (差額令書発行指示.equals(項目名)) {
            SagakuReishoHakkoShijiKubun 差額令書発行指示設定値 = RSTRING_0.equals(設定値)
                    ? SagakuReishoHakkoShijiKubun.差額令書で発行する : SagakuReishoHakkoShijiKubun.差額令書で発行しない;
            納入通知書制御情報.set差額令書発行指示(差額令書発行指示設定値);
        }
        if (当初出力_中期開始期.equals(項目名)) {
            納入通知書制御情報.set当初出力_中期開始期(RString.isNullOrEmpty(設定値)
                    ? 0 : Integer.parseInt(設定値.toString()));
            納入通知書制御情報.setExists中期開始期(!RString.isNullOrEmpty(設定値));
        }
        if (当初出力_後期開始期.equals(項目名)) {
            納入通知書制御情報.set当初出力_後期開始期(RString.isNullOrEmpty(設定値)
                    ? 0 : Integer.parseInt(設定値.toString()));
            納入通知書制御情報.setExists後期開始期(!RString.isNullOrEmpty(設定値));
        }
        if (当初出力_出力方法.equals(項目名)) {
            ToshoShutsuryokuHoho 当初出力_出力方法設定値 = RSTRING_0.equals(設定値)
                    ? ToshoShutsuryokuHoho.別々出力 : ToshoShutsuryokuHoho.全件出力;
            納入通知書制御情報.set当初出力_出力方法(当初出力_出力方法設定値);
        }
        if (期毎納入通知書タイプ.equals(項目名)) {
            KigotoTsuchishoType 期毎納入通知書タイプ設定値 = null == 設定値 || 設定値.isEmpty() ? null : KigotoTsuchishoType.標準版期毎タイプ;
            納入通知書制御情報.set期毎納入通知書タイプ(期毎納入通知書タイプ設定値);
        }
    }

    private void set納入通知書制御情報2(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 項目名, RString 設定値) {
        if (銀振納入通知書タイプ.equals(項目名)) {
            GinfuriTsuchishoType 銀振納入通知書タイプ設定値 = null == 設定値 || 設定値.isEmpty() ? null : GinfuriTsuchishoType.標準版銀振タイプ;
            納入通知書制御情報.set銀振納入通知書タイプ(銀振納入通知書タイプ設定値);
        }
        if (その他納入通知書タイプ.equals(項目名)) {
            SonotaTsuchishoType その他納入通知書タイプ設定値;
            if (標準版ブックタイプ.equals(設定値)) {
                その他納入通知書タイプ設定値 = SonotaTsuchishoType.標準版ブックタイプ;
            } else if (標準版コンビニタイプ.equals(設定値)) {
                その他納入通知書タイプ設定値 = SonotaTsuchishoType.標準版コンビニタイプ;
            } else if (飯田市版コンビニタイプ.equals(設定値)) {
                その他納入通知書タイプ設定値 = SonotaTsuchishoType.飯田市版コンビニタイプ;
            } else if (コンビニマルチ収納タイプ.equals(設定値)) {
                その他納入通知書タイプ設定値 = SonotaTsuchishoType.コンビニマルチ収納タイプ;
            } else if (コンビニ角公タイプ.equals(設定値)) {
                その他納入通知書タイプ設定値 = SonotaTsuchishoType.コンビニ角公タイプ;
            } else {
                その他納入通知書タイプ設定値 = SonotaTsuchishoType.上田市版コンビニタイプ;
            }
            納入通知書制御情報.setその他納入通知書タイプ(その他納入通知書タイプ設定値);
        }
        if (コンビニ明細書表示.equals(項目名)) {
            HyojiUmu コンビニ明細書表示設定値 = RSTRING_1.equals(設定値) ? HyojiUmu.表示する : HyojiUmu.表示しない;
            納入通知書制御情報.setコンビニ明細書表示(コンビニ明細書表示設定値);
        }
        if (ブック口座振替依頼表示.equals(項目名)) {
            HyojiUmu ブック口座振替依頼表示設定値 = RSTRING_1.equals(設定値) ? HyojiUmu.表示する : HyojiUmu.表示しない;
            納入通知書制御情報.setブック口座振替依頼表示(ブック口座振替依頼表示設定値);
        }
        if (コンビニバーコード表示.equals(項目名)) {
            HyojiUmu コンビニバーコード表示設定値 = RSTRING_1.equals(設定値) ? HyojiUmu.表示する : HyojiUmu.表示しない;
            納入通知書制御情報.setコンビニバーコード表示(コンビニバーコード表示設定値);
        }
        if (コンビニ_ブック口座用納付書表示.equals(項目名)) {
            HyojiUmu コンビニ_ブック口座用納付書表示設定値 = RSTRING_1.equals(設定値) ? HyojiUmu.表示する : HyojiUmu.表示しない;
            納入通知書制御情報.setコンビニ_ブック口座用納付書表示(コンビニ_ブック口座用納付書表示設定値);
        }
    }

    private void set納入通知書制御情報3(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 項目名, RString 設定値) {
        if (コンビニ納付書発行日表示.equals(項目名)) {
            HyojiUmu コンビニ納付書発行日表示設定値 = RSTRING_1.equals(設定値) ? HyojiUmu.表示する : HyojiUmu.表示しない;
            納入通知書制御情報.setコンビニ納付書発行日表示(コンビニ納付書発行日表示設定値);
        }
        if (コンビニ納付書取扱期限表示.equals(項目名)) {
            HyojiUmu コンビニ納付書取扱期限表示設定値 = RSTRING_1.equals(設定値) ? HyojiUmu.表示する : HyojiUmu.表示しない;
            納入通知書制御情報.setコンビニ納付書取扱期限表示(コンビニ納付書取扱期限表示設定値);
        }
        if (コンビニ期毎出力.equals(項目名)) {
            KigotoShutsuryoku コンビニ期毎出力設定値 = RSTRING_0.equals(設定値) ? KigotoShutsuryoku.通常出力 : KigotoShutsuryoku.期毎出力;
            納入通知書制御情報.setコンビニ期毎出力(コンビニ期毎出力設定値);
        }
        if (領収証書納付額欄.equals(項目名)) {
            納入通知書制御情報.set領収証書納付額欄(get付額欄(設定値));
        }
        if (納付書納付額欄.equals(項目名)) {
            納入通知書制御情報.set納付書納付額欄(get付額欄(設定値));
        }
        if (領収証書領収印欄.equals(項目名)) {
            RyoshuinranHyojiKubun 領収証書領収印欄設定値
                    = RSTRING_1.equals(設定値) ? RyoshuinranHyojiKubun.口座振替を印字する : RyoshuinranHyojiKubun.空白を印字する;
            納入通知書制御情報.set領収証書領収印欄(領収証書領収印欄設定値);
        }
        if (納付書領収印欄.equals(項目名)) {
            RyoshuinranHyojiKubun 納付書領収印欄設定値
                    = RSTRING_1.equals(設定値) ? RyoshuinranHyojiKubun.口座振替を印字する : RyoshuinranHyojiKubun.空白を印字する;
            納入通知書制御情報.set納付書領収印欄(納付書領収印欄設定値);
        }
    }

    private void set納入通知書制御情報4(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 項目名, RString 設定値) {
        if (口座振替のOCR出力方法.equals(項目名)) {
            OCRShutsuryokuHoho 口座振替のOCR出力方法設定値;
            if (RSTRING_1.equals(設定値)) {
                口座振替のOCR出力方法設定値 = OCRShutsuryokuHoho.マスクでつぶす;
            } else if (RSTRING_2.equals(設定値)) {
                口座振替のOCR出力方法設定値 = OCRShutsuryokuHoho.印字する;
            } else {
                口座振替のOCR出力方法設定値 = OCRShutsuryokuHoho.印字しない;
            }
            納入通知書制御情報.set口座振替のOCR出力方法(口座振替のOCR出力方法設定値);
        }
        if (領収書領収日付印欄.equals(項目名)) {
            RyoshuHizukeRan 領収書領収日付印欄設定値;
            if (RSTRING_1.equals(設定値)) {
                領収書領収日付印欄設定値 = RyoshuHizukeRan.期で出力する;
            } else if (RSTRING_2.equals(設定値)) {
                領収書領収日付印欄設定値 = RyoshuHizukeRan.月で出力する;
            } else {
                領収書領収日付印欄設定値 = RyoshuHizukeRan.何も表示しない;
            }
            納入通知書制御情報.set領収書領収日付印欄(領収書領収日付印欄設定値);
        }
        if (納付書領収日付欄.equals(項目名)) {
            RyoshuHizukeRan 納付書領収日付欄設定値;
            if (RSTRING_1.equals(設定値)) {
                納付書領収日付欄設定値 = RyoshuHizukeRan.期で出力する;
            } else if (RSTRING_2.equals(設定値)) {
                納付書領収日付欄設定値 = RyoshuHizukeRan.月で出力する;
            } else {
                納付書領収日付欄設定値 = RyoshuHizukeRan.何も表示しない;
            }
            納入通知書制御情報.set納付書領収日付欄(納付書領収日付欄設定値);
        }
        if (納期限出力方法.equals(項目名)) {
            NokigenShutsuryokuHoho 納期限出力方法設定値;
            if (RSTRING_1.equals(設定値)) {
                納期限出力方法設定値 = NokigenShutsuryokuHoho.全ての期;
            } else {
                納期限出力方法設定値 = NokigenShutsuryokuHoho.対象の期;
            }
            納入通知書制御情報.set納期限出力方法(納期限出力方法設定値);
        }
    }

    private void set納入通知書制御情報5(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 項目名, RString 設定値) {
        if (領収書日付印欄の期.equals(項目名)) {
            RyoshushoHizukeranKiHyoji 領収書日付印欄の期設定値;
            if (RSTRING_1.equals(設定値)) {
                領収書日付印欄の期設定値 = RyoshushoHizukeranKiHyoji.期表示;
            } else if (RSTRING_2.equals(設定値)) {
                領収書日付印欄の期設定値 = RyoshushoHizukeranKiHyoji.月表示;
            } else {
                領収書日付印欄の期設定値 = RyoshushoHizukeranKiHyoji.表示しない;
            }
            納入通知書制御情報.set領収書日付印欄の期(領収書日付印欄の期設定値);
        }
        if (納付書市町村名表示.equals(項目名)) {
            HyojiUmu 納付書市町村名表示設定値 = RSTRING_0.equals(設定値) ? HyojiUmu.表示しない : HyojiUmu.表示する;
            納入通知書制御情報.set納付書市町村名表示(納付書市町村名表示設定値);
        }
        if (納付書市町村名.equals(項目名)) {
            納入通知書制御情報.set納付書市町村名(設定値);
        }
    }

    private void set納入通知書制御情報6(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 項目名, RString 設定値) {
        if (速報取込区分.equals(項目名)) {
            SokuhoTorikomiKubun 速報取込区分設定値 = RSTRING_0.equals(設定値) ? SokuhoTorikomiKubun.取り込まない : SokuhoTorikomiKubun.取り込む;
            納入通知書制御情報.set速報取込区分(速報取込区分設定値);
        }
        if (納付額算出方法.equals(項目名)) {
            NofugakuSanshutsuHoho 納付額算出方法設定値
                    = RSTRING_1.equals(設定値) ? NofugakuSanshutsuHoho.収入額をもとに算出 : NofugakuSanshutsuHoho.調定額をもとに算出;
            納入通知書制御情報.set納付額算出方法(納付額算出方法設定値);
        }
        if (単票発行_出力方式.equals(項目名)) {
            ShutsuryokuHoshiki 単票発行_出力方式設定値 = RSTRING_1.equals(設定値) ? ShutsuryokuHoshiki.全件出力 : ShutsuryokuHoshiki.別々出力;
            納入通知書制御情報.set単票発行_出力方式(単票発行_出力方式設定値);
        }
        if (単票発行_出力形式.equals(項目名)) {
            ShutsuryokuHoshiki 単票発行_出力形式設定値 = RSTRING_1.equals(設定値) ? ShutsuryokuHoshiki.全件出力 : ShutsuryokuHoshiki.別々出力;
            納入通知書制御情報.set単票発行_出力形式(単票発行_出力形式設定値);
        }
    }

    /**
     * 算定の基礎取得します。
     *
     * @param 設定値 設定値
     * @return 算定の基礎設定値
     */
    private SanteiKiso get算定の基礎(RString 設定値) {
        SanteiKiso 算定の基礎設定値;
        if (RSTRING_4.equals(設定値)) {
            算定の基礎設定値 = SanteiKiso.保険料率_今年度;
        } else if (RSTRING_1.equals(設定値)) {
            算定の基礎設定値 = SanteiKiso.保険料率;
        } else if (RSTRING_2.equals(設定値)) {
            算定の基礎設定値 = SanteiKiso.年額保険料;
        } else if (RSTRING_3.equals(設定値)) {
            算定の基礎設定値 = SanteiKiso.最終期保険料額;
        } else {
            算定の基礎設定値 = SanteiKiso.空白;
        }
        return 算定の基礎設定値;
    }

    /**
     * 付額欄取得します。
     *
     * @param 設定値 設定値
     * @return 付額欄設定値
     */
    private NofugakuranHyojiKubun get付額欄(RString 設定値) {
        NofugakuranHyojiKubun 付額欄設定値;
        if (RSTRING_1.equals(設定値)) {
            付額欄設定値 = NofugakuranHyojiKubun.口座振替を印字する;
        } else if (RSTRING_2.equals(設定値)) {
            付額欄設定値 = NofugakuranHyojiKubun.空白を印字する;
        } else if (RSTRING_3.equals(設定値)) {
            付額欄設定値 = NofugakuranHyojiKubun.マスクを印字する;
        } else {
            付額欄設定値 = NofugakuranHyojiKubun.金額出力;
        }
        return 付額欄設定値;
    }

    /**
     * 「帳票制御汎用」テーブル　から、仮算定納入通知書制御情報取得します。
     *
     * @return 本算定納入通知書制御情報
     */
    public HonSanteiNonyuTsuchiShoSeigyoJoho get本算定納入通知書制御情報() {
        INonyuTsuchiShoSeigyoJohoLoaderMapper mapper = mapperProvider.create(INonyuTsuchiShoSeigyoJohoLoaderMapper.class);
        KariSanteiNonyuTsuchiShoSeigyoJohoParameter 納入通知書制御情報取得パラメータ
                = KariSanteiNonyuTsuchiShoSeigyoJohoParameter.createParam(SubGyomuCode.DBB介護賦課, 調定年度);
        List<DbT7067ChohyoSeigyoHanyoEntity> chohyoSeigyoHanyoLst = mapper.get本算定納入通知書制御情報(納入通知書制御情報取得パラメータ);
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = new HonSanteiNonyuTsuchiShoSeigyoJoho();
        for (DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity : chohyoSeigyoHanyoLst) {
            RString 項目名 = dbT7067ChohyoSeigyoHanyoEntity.getKomokuName();
            RString 設定値 = dbT7067ChohyoSeigyoHanyoEntity.getKomokuValue();
            if (過年度文言1.equals(項目名)) {
                本算定納入通知書制御情報.set過年度文言1(RSTRING_1.equals(設定値) ? KanendoMongon.随時 : KanendoMongon.スペース);
            }
            if (過年度文言2.equals(項目名)) {
                本算定納入通知書制御情報.set過年度文言2(RSTRING_1.equals(設定値) ? KanendoMongon.随時 : KanendoMongon.スペース);
            }
        }
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = set納入通知書制御情報(chohyoSeigyoHanyoLst);
        本算定納入通知書制御情報.set納入通知書制御情報(納入通知書制御情報);
        return 本算定納入通知書制御情報;
    }
}
