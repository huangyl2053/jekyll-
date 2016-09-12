/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KaishiKi;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KanendoMongon;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.OCRShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuHizukeRan;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuinranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshushoHizukeranKiHyoji;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SagakuReishoHakkoShijiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SanteiKiso;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuHoshiki;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ShutsuryokuKeishiki;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SokuhoTorikomiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.ToshoShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.NonyuTsuchishoTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * システム管理情報（納入通知書）ハンドラクラスです。
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public final class NonyuTsuchishoTotalHandler {

    private final NonyuTsuchishoTotalDiv div;
    private static final RString 帳票分類ID = new RString("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString 仮算定_帳票分類ID = new RString("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString キー_出力部数 = new RString("出力部数");
    private static final RString キー_速報取込区分 = new RString("速報取込区分");
    private static final RString キー_単票発行_出力方式 = new RString("単票発行_出力方式");
    private static final RString キー_単票発行_出力形式 = new RString("単票発行_出力形式");
    private static final RString キー_領収書日付印欄の期 = new RString("領収書日付印欄の期");
    private static final RString キー_納付書市町村名表示 = new RString("納付書市町村名表示");
    private static final RString キー_納付書市町村名 = new RString("納付書市町村名");
    private static final RString キー_領収証書納付額欄 = new RString("領収証書納付額欄");
    private static final RString キー_納付書納付額欄 = new RString("納付書納付額欄");
    private static final RString キー_領収証書領収印欄 = new RString("領収証書領収印欄");
    private static final RString キー_納付書領収印欄 = new RString("納付書領収印欄");
    private static final RString キー_領収書領収日付印欄 = new RString("領収書領収日付印欄");
    private static final RString キー_納付書領収日付欄 = new RString("納付書領収日付欄");
    private static final RString キー_納期限出力方法 = new RString("納期限出力方法");
    private static final RString キー_口座振替のOCR出力方法 = new RString("口座振替のOCR出力方法");
    private static final RString キー_差額令書発行指示 = new RString("差額令書発行指示");
    private static final RString キー_コンビニバーコード表示 = new RString("コンビニバーコード表示");
    private static final RString キー_コンビニ_ブック口座用納付書表示 = new RString("コンビニ_ブック口座用納付書表示");
    private static final RString キー_コンビニ納付書発行日表示 = new RString("コンビニ納付書発行日表示");
    private static final RString キー_コンビニ納付書取扱期限表示 = new RString("コンビニ納付書取扱期限表示");
    private static final RString キー_当初出力_出力方法 = new RString("当初出力_出力方法");
    private static final RString キー_当初出力_中期開始期 = new RString("当初出力_中期開始期");
    private static final RString キー_当初出力_後期開始期 = new RString("当初出力_後期開始期");
    private static final RString キー_算定の基礎1 = new RString("算定の基礎1");
    private static final RString キー_算定の基礎2 = new RString("算定の基礎2");
    private static final RString キー_算定の基礎3 = new RString("算定の基礎3");
    private static final RString キー_過年度文言1 = new RString("過年度文言1");
    private static final RString キー_過年度文言2 = new RString("過年度文言2");
    private static final RString 完了メッセージ = new RString("システム管理登録_納入通知書保存処理");
    private static final RString 対象情報 = new RString("調定年度：XX年度");
    private static final RString XX年度 = new RString("XX");
    private static final RString 新年度管理情報_未作成 = new RString("未作成");
    private static final RString 新年度管理情報_作成済 = new RString("作成済");
    private static final int 帳票制御汎用_1条目 = 0;
    private static final int 帳票制御汎用_2条目 = 1;
    private static final int 帳票制御汎用_3条目 = 2;
    private static final int 帳票制御汎用_4条目 = 3;
    private static final int 帳票制御汎用_5条目 = 4;
    private static final int 帳票制御汎用_6条目 = 5;
    private static final int 帳票制御汎用_7条目 = 6;
    private static final int 帳票制御汎用_8条目 = 7;
    private static final int 帳票制御汎用_9条目 = 8;
    private static final int 帳票制御汎用_10条目 = 9;
    private static final int 帳票制御汎用_11条目 = 10;
    private static final int 帳票制御汎用_12条目 = 11;
    private static final int 帳票制御汎用_13条目 = 12;
    private static final int 帳票制御汎用_14条目 = 13;
    private static final int 帳票制御汎用_15条目 = 14;
    private static final int 帳票制御汎用_16条目 = 15;
    private static final int 帳票制御汎用_17条目 = 16;
    private static final int 帳票制御汎用_18条目 = 17;
    private static final int 帳票制御汎用_19条目 = 18;
    private static final int 帳票制御汎用_20条目 = 19;
    private static final int 帳票制御汎用_21条目 = 20;
    private static final int 帳票制御汎用_22条目 = 21;
    private static final int 帳票制御汎用_23条目 = 22;
    private static final int 帳票制御汎用_24条目 = 23;
    private static final int 帳票制御汎用_25条目 = 24;
    private static final int 帳票制御汎用_26条目 = 25;
    private static final int 帳票制御汎用_27条目 = 26;
    private static final int 帳票制御汎用_28条目 = 27;
    private static final int 帳票制御汎用_29条目 = 28;
    private static final int 帳票制御汎用_30条目 = 29;
    private static final int 帳票制御汎用_31条目 = 30;
    private static final int 帳票制御汎用_32条目 = 31;
    private static final int 帳票制御汎用_33条目 = 32;
    private static final int 帳票制御汎用_34条目 = 33;
    private static final int 帳票制御汎用_35条目 = 34;
    private static final int 帳票制御汎用_36条目 = 35;
    private static final int 平成12年_西暦 = 2000;

    /**
     * コンストラクタです。
     *
     * @param div システム管理情報（納入通知書）Div
     */
    private NonyuTsuchishoTotalHandler(NonyuTsuchishoTotalDiv div) {
        this.div = div;
    }

    /**
     * ハンドラー生成するメソッドです。
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static NonyuTsuchishoTotalHandler of(NonyuTsuchishoTotalDiv div) {
        return new NonyuTsuchishoTotalHandler(div);
    }

    /**
     * システム管理情報（納入通知書）の画面初期化処理するメソッドです。
     *
     * @param 帳票制御汎用リスト List<ChohyoSeigyoHanyo>
     */
    public void initialize(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ReportId 帳票分類 = new ReportId(帳票分類ID);
        div.getNotsuInfo().getCcdKaigoChohyoSeigyoKyotsu().initialize(SubGyomuCode.DBB介護賦課, 帳票分類);
        setDataSource();
        set初期化(new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedKey()),
                帳票制御汎用リスト);
    }

    private void setDataSource() {
        List<KeyValueDataSource> 速報取込区分 = new ArrayList<>();
        速報取込区分.add(new KeyValueDataSource(SokuhoTorikomiKubun.取り込まない.getコード(),
                SokuhoTorikomiKubun.取り込まない.get名称()));
        速報取込区分.add(new KeyValueDataSource(SokuhoTorikomiKubun.取り込む.getコード(),
                SokuhoTorikomiKubun.取り込む.get名称()));
        div.getNotsuInfo().getRadSokuhoTorikomiKubun().setDataSource(速報取込区分);

        List<KeyValueDataSource> 出力方式 = new ArrayList<>();
        出力方式.add(new KeyValueDataSource(
                ShutsuryokuHoshiki.全件出力.getコード(), ShutsuryokuHoshiki.全件出力.get名称()));
        出力方式.add(new KeyValueDataSource(
                ShutsuryokuHoshiki.別々出力.getコード(), ShutsuryokuHoshiki.別々出力.get名称()));
        div.getNotsuInfo().getRadSokujiHakkoHoshiki().setDataSource(出力方式);

        List<KeyValueDataSource> 出力形式 = new ArrayList<>();
        出力形式.add(new KeyValueDataSource(ShutsuryokuKeishiki.口座.getコード(), ShutsuryokuKeishiki.口座.get名称()));
        出力形式.add(new KeyValueDataSource(ShutsuryokuKeishiki.現金.getコード(), ShutsuryokuKeishiki.現金.get名称()));
        div.getNotsuInfo().getRadSokujiHakkoKeishiki().setDataSource(出力形式);

        List<KeyValueDataSource> 納付額欄 = new ArrayList<>();
        納付額欄.add(new KeyValueDataSource(NofugakuranHyojiKubun.__を印字する.getコード(),
                NofugakuranHyojiKubun.__を印字する.get略称()));
        納付額欄.add(new KeyValueDataSource(NofugakuranHyojiKubun._口座振替_を印字する.getコード(),
                NofugakuranHyojiKubun._口座振替_を印字する.get略称()));
        納付額欄.add(new KeyValueDataSource(NofugakuranHyojiKubun.星印を印字する.getコード(),
                NofugakuranHyojiKubun.星印を印字する.get略称()));
        納付額欄.add(new KeyValueDataSource(NofugakuranHyojiKubun.金額出力.getコード(),
                NofugakuranHyojiKubun.金額出力.get略称()));
        div.getNotsuInfo().getDdlKozaMongonRyoshushoNofugaku().setDataSource(納付額欄);
        div.getNotsuInfo().getDdlKozaMongonNofushoNofugaku().setDataSource(納付額欄);

        List<KeyValueDataSource> 領収印欄 = new ArrayList<>();
        領収印欄.add(new KeyValueDataSource(RyoshuinranHyojiKubun.__を印字する.getコード(),
                RyoshuinranHyojiKubun.__を印字する.get略称()));
        領収印欄.add(new KeyValueDataSource(RyoshuinranHyojiKubun._口座振替_を印字する.getコード(),
                RyoshuinranHyojiKubun._口座振替_を印字する.get略称()));
        div.getNotsuInfo().getDdlKozaMongonRyoshushoRyoshuin().setDataSource(領収印欄);
        div.getNotsuInfo().getDdlKozaMongonNofushoRyoshuin().setDataSource(領収印欄);

        List<KeyValueDataSource> 領収日付印欄 = new ArrayList<>();
        領収日付印欄.add(new KeyValueDataSource(RyoshuHizukeRan.何も表示しない.getコード(),
                RyoshuHizukeRan.何も表示しない.get名称()));
        領収日付印欄.add(new KeyValueDataSource(RyoshuHizukeRan.月で出力する.getコード(),
                RyoshuHizukeRan.月で出力する.get名称()));
        領収日付印欄.add(new KeyValueDataSource(RyoshuHizukeRan.期で出力する.getコード(),
                RyoshuHizukeRan.期で出力する.get名称()));
        div.getNotsuInfo().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn().setDataSource(領収日付印欄);
        div.getNotsuInfo().getDdlShutsuryokuHohoNofushoRyoshuHiduke().setDataSource(領収日付印欄);

        List<KeyValueDataSource> 領収書日付印欄の期 = new ArrayList<>();
        領収書日付印欄の期.add(new KeyValueDataSource(RyoshushoHizukeranKiHyoji.月表示.getコード(),
                RyoshushoHizukeranKiHyoji.月表示.get名称()));
        領収書日付印欄の期.add(new KeyValueDataSource(RyoshushoHizukeranKiHyoji.期表示.getコード(),
                RyoshushoHizukeranKiHyoji.期表示.get名称()));
        領収書日付印欄の期.add(new KeyValueDataSource(RyoshushoHizukeranKiHyoji.表示しない.getコード(),
                RyoshushoHizukeranKiHyoji.表示しない.get名称()));
        div.getNotsuInfo().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi().setDataSource(領収書日付印欄の期);

        List<KeyValueDataSource> 納付書市町村名 = new ArrayList<>();
        納付書市町村名.add(new KeyValueDataSource(HyojiUmu.表示しない.getコード(), HyojiUmu.表示しない.get名称()));
        納付書市町村名.add(new KeyValueDataSource(HyojiUmu.表示する.getコード(), HyojiUmu.表示する.get名称()));
        div.getNotsuInfo().getDdlNofushoShichosonNameUmu().setDataSource(納付書市町村名);

        List<KeyValueDataSource> 納期限出力方法 = new ArrayList<>();
        納期限出力方法.add(new KeyValueDataSource(NokigenShutsuryokuHoho.全ての期分を印字する.getコード(),
                NokigenShutsuryokuHoho.全ての期分を印字する.get略称()));
        納期限出力方法.add(new KeyValueDataSource(
                NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.getコード(),
                NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.get略称()));
        div.getNotsuInfo().getDdlNokigenShutsuryokuHoho().setDataSource(納期限出力方法);

        List<KeyValueDataSource> 口座振替のOCR出力方法 = new ArrayList<>();
        口座振替のOCR出力方法.add(new KeyValueDataSource(OCRShutsuryokuHoho._口座振替_ならOCR欄を_星印_でつぶす.getコード(),
                OCRShutsuryokuHoho._口座振替_ならOCR欄を_星印_でつぶす.get略称()));
        口座振替のOCR出力方法.add(new KeyValueDataSource(OCRShutsuryokuHoho._口座振替_ならOCR欄を印字しない.getコード(),
                OCRShutsuryokuHoho._口座振替_ならOCR欄を印字しない.get略称()));
        口座振替のOCR出力方法.add(new KeyValueDataSource(OCRShutsuryokuHoho._口座振替_ならOCR欄を印字する.getコード(),
                OCRShutsuryokuHoho._口座振替_ならOCR欄を印字する.get略称()));
        div.getNotsuInfo().getDdlOCRShutsuryokuHoho().setDataSource(口座振替のOCR出力方法);

        List<KeyValueDataSource> 差額令書発行指示区分 = new ArrayList<>();
        差額令書発行指示区分.add(new KeyValueDataSource(SagakuReishoHakkoShijiKubun.差額令書で発行しない.getコード(),
                SagakuReishoHakkoShijiKubun.差額令書で発行しない.get名称()));
        差額令書発行指示区分.add(new KeyValueDataSource(SagakuReishoHakkoShijiKubun.差額令書で発行する.getコード(),
                SagakuReishoHakkoShijiKubun.差額令書で発行する.get名称()));
        div.getNotsuInfo().getRadSagakuReishoHakkoUmuK().setDataSource(差額令書発行指示区分);
        div.getNotsuInfo().getRadSagakuReishoHakkoUmuH().setDataSource(差額令書発行指示区分);

        List<KeyValueDataSource> コンビニ表示 = new ArrayList<>();
        コンビニ表示.add(new KeyValueDataSource(HyojiUmu.表示しない.getコード(), HyojiUmu.表示しない.get名称()));
        コンビニ表示.add(new KeyValueDataSource(HyojiUmu.表示する.getコード(), HyojiUmu.表示する.get名称()));
        div.getNotsuInfo().getRadBarCodeHyojiK().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadKozaNofushoHyojiK().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadNofishoHakkoYMDHyojiK().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadNofishoToriatsukaiKigenHyojiK().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadBarCodeHyojiH().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadKozaNofushoHyojiH().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadNofishoHakkoYMDHyojiH().setDataSource(コンビニ表示);
        div.getNotsuInfo().getRadNofishoToriatsukaiKigenHyojiH().setDataSource(コンビニ表示);

        List<KeyValueDataSource> 当初出力方法 = new ArrayList<>();
        当初出力方法.add(new KeyValueDataSource(ToshoShutsuryokuHoho.前期_中期_後期を全件出力.getコード(),
                ToshoShutsuryokuHoho.前期_中期_後期を全件出力.get略称()));
        当初出力方法.add(new KeyValueDataSource(ToshoShutsuryokuHoho.前期_中期_後期を別々に出力.getコード(),
                ToshoShutsuryokuHoho.前期_中期_後期を別々に出力.get略称()));
        div.getNotsuInfo().getRadToshoShutsuryokuK().setDataSource(当初出力方法);
        div.getNotsuInfo().getRadToshoShutsuryokuH().setDataSource(当初出力方法);

        List<KeyValueDataSource> 開始期 = new ArrayList<>();
        開始期.add(new KeyValueDataSource(KaishiKi.無し.getコード(), KaishiKi.無し.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._1期.getコード(), KaishiKi._1期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._2期.getコード(), KaishiKi._2期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._3期.getコード(), KaishiKi._3期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._4期.getコード(), KaishiKi._4期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._5期.getコード(), KaishiKi._5期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._6期.getコード(), KaishiKi._6期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._7期.getコード(), KaishiKi._7期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._8期.getコード(), KaishiKi._8期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._9期.getコード(), KaishiKi._9期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._10期.getコード(), KaishiKi._10期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._11期.getコード(), KaishiKi._11期.get名称()));
        開始期.add(new KeyValueDataSource(KaishiKi._12期.getコード(), KaishiKi._12期.get名称()));
        div.getNotsuInfo().getDdlChukiKaishiKiK().setDataSource(開始期);
        div.getNotsuInfo().getDdlKokiKaishiKiK().setDataSource(開始期);
        div.getNotsuInfo().getDdlChukiKaishiKiH().setDataSource(開始期);
        div.getNotsuInfo().getDdlKokiKaishiKiH().setDataSource(開始期);

        List<KeyValueDataSource> 算定の基礎 = new ArrayList<>();
        算定の基礎.add(new KeyValueDataSource(SanteiKiso.空白.getコード(), SanteiKiso.空白.get略称()));
        算定の基礎.add(new KeyValueDataSource(SanteiKiso.保険料率.getコード(), SanteiKiso.保険料率.get略称()));
        算定の基礎.add(new KeyValueDataSource(SanteiKiso.年額保険料.getコード(), SanteiKiso.年額保険料.get略称()));
        算定の基礎.add(new KeyValueDataSource(SanteiKiso.最終期保険料額.getコード(), SanteiKiso.最終期保険料額.get略称()));
        算定の基礎.add(new KeyValueDataSource(SanteiKiso.保険料率_今年度.getコード(), SanteiKiso.保険料率_今年度.get略称()));
        div.getNotsuInfo().getDdlKiso1().setDataSource(算定の基礎);
        div.getNotsuInfo().getDdlKiso2().setDataSource(算定の基礎);
        div.getNotsuInfo().getDdlKiso3().setDataSource(算定の基礎);

        List<KeyValueDataSource> 過年度文言 = new ArrayList<>();
        過年度文言.add(new KeyValueDataSource(KanendoMongon.スペース.getコード(), KanendoMongon.スペース.get名称()));
        過年度文言.add(new KeyValueDataSource(KanendoMongon.随時.getコード(), KanendoMongon.随時.get名称()));
        div.getNotsuInfo().getRadKanendoMongon1().setDataSource(過年度文言);
        div.getNotsuInfo().getRadKanendoMongon2().setDataSource(過年度文言);
    }

    private void set初期化(FlexibleYear 調定年度DDLの調定年度, List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        宛先住所コード出力順初期化(manager, 帳票制御汎用リスト);
        口座文言領収日付欄等初期化(manager, 調定年度DDLの調定年度, 帳票制御汎用リスト);
        仮算定初期化(manager, 調定年度DDLの調定年度, 帳票制御汎用リスト);
        本算定初期化(manager, 調定年度DDLの調定年度, 帳票制御汎用リスト);
    }

    private void 口座文言領収日付欄等初期化(ChohyoSeigyoHanyoManager manager, FlexibleYear 調定年度DDLの調定年度,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 帳票制御汎用_領収証書納付額欄 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_領収証書納付額欄);
        div.getNotsuInfo().getDdlKozaMongonRyoshushoNofugaku().setSelectedKey(
                帳票制御汎用_領収証書納付額欄.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_領収証書納付額欄);
        ChohyoSeigyoHanyo 帳票制御汎用_納付書納付額欄 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_納付書納付額欄);
        div.getNotsuInfo().getDdlKozaMongonNofushoNofugaku().setSelectedKey(帳票制御汎用_納付書納付額欄.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_納付書納付額欄);
        ChohyoSeigyoHanyo 帳票制御汎用_領収証書領収印欄 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_領収証書領収印欄);
        div.getNotsuInfo().getDdlKozaMongonRyoshushoRyoshuin().setSelectedKey(
                帳票制御汎用_領収証書領収印欄.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_領収証書領収印欄);
        ChohyoSeigyoHanyo 帳票制御汎用_納付書領収印欄 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_納付書領収印欄);
        div.getNotsuInfo().getDdlKozaMongonNofushoRyoshuin().setSelectedKey(帳票制御汎用_納付書領収印欄.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_納付書領収印欄);
        ChohyoSeigyoHanyo 帳票制御汎用_領収書領収日付印欄 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_領収書領収日付印欄);
        div.getNotsuInfo().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn().setSelectedKey(
                帳票制御汎用_領収書領収日付印欄.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_領収書領収日付印欄);
        ChohyoSeigyoHanyo 帳票制御汎用_納付書領収日付欄 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_納付書領収日付欄);
        div.getNotsuInfo().getDdlShutsuryokuHohoNofushoRyoshuHiduke().setSelectedKey(
                帳票制御汎用_納付書領収日付欄.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_納付書領収日付欄);
        ChohyoSeigyoHanyo 帳票制御汎用_領収書日付印欄の期 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_領収書日付印欄の期);
        div.getNotsuInfo().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi().setSelectedKey(
                帳票制御汎用_領収書日付印欄の期.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_領収書日付印欄の期);
        ChohyoSeigyoHanyo 帳票制御汎用_納付書市町村名表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_納付書市町村名表示);
        div.getNotsuInfo().getDdlNofushoShichosonNameUmu().setSelectedKey(帳票制御汎用_納付書市町村名表示.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_納付書市町村名表示);
        ChohyoSeigyoHanyo 帳票制御汎用_納付書市町村名 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_納付書市町村名);
        div.getNotsuInfo().getTxtNofushoShichosonName().setValue(帳票制御汎用_納付書市町村名.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_納付書市町村名);
        ChohyoSeigyoHanyo 帳票制御汎用_納期限出力方法 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_納期限出力方法);
        div.getNotsuInfo().getDdlNokigenShutsuryokuHoho().setSelectedKey(帳票制御汎用_納期限出力方法.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_納期限出力方法);
        ChohyoSeigyoHanyo 帳票制御汎用_口座振替のOCR出力方法 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_口座振替のOCR出力方法);
        div.getNotsuInfo().getDdlOCRShutsuryokuHoho().setSelectedKey(帳票制御汎用_口座振替のOCR出力方法.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_口座振替のOCR出力方法);
    }

    private void 宛先住所コード出力順初期化(ChohyoSeigyoHanyoManager manager,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 帳票制御汎用_項目名 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_出力部数);
        div.getNotsuInfo().getTxtHakkoBusu().setValue(帳票制御汎用_項目名.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_項目名);
        ChohyoSeigyoHanyo 帳票制御汎用_速報取込区分 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_速報取込区分);
        div.getNotsuInfo().getRadSokuhoTorikomiKubun().setSelectedKey(帳票制御汎用_速報取込区分.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_速報取込区分);
        ChohyoSeigyoHanyo 帳票制御汎用_単票発行_出力方式 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_単票発行_出力方式);
        div.getNotsuInfo().getRadSokujiHakkoHoshiki().setSelectedKey(帳票制御汎用_単票発行_出力方式.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_単票発行_出力方式);
        ChohyoSeigyoHanyo 帳票制御汎用_単票発行_出力形式 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_単票発行_出力形式);
        div.getNotsuInfo().getRadSokujiHakkoKeishiki().setSelectedKey(帳票制御汎用_単票発行_出力形式.get設定値());
        帳票制御汎用リスト.add(帳票制御汎用_単票発行_出力形式);
    }

    private void 仮算定初期化(ChohyoSeigyoHanyoManager manager, FlexibleYear 調定年度DDLの調定年度,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 仮算定_差額令書発行指示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_差額令書発行指示);
        div.getNotsuInfo().getRadSagakuReishoHakkoUmuK().setSelectedKey(仮算定_差額令書発行指示.get設定値());
        帳票制御汎用リスト.add(仮算定_差額令書発行指示);
        ChohyoSeigyoHanyo 仮算定_コンビニバーコード表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_コンビニバーコード表示);
        div.getNotsuInfo().getRadBarCodeHyojiK().setSelectedKey(仮算定_コンビニバーコード表示.get設定値());
        帳票制御汎用リスト.add(仮算定_コンビニバーコード表示);
        ChohyoSeigyoHanyo 仮算定_コンビニ_ブック口座用納付書表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_コンビニ_ブック口座用納付書表示);
        div.getNotsuInfo().getRadKozaNofushoHyojiK().setSelectedKey(仮算定_コンビニ_ブック口座用納付書表示.get設定値());
        帳票制御汎用リスト.add(仮算定_コンビニ_ブック口座用納付書表示);
        ChohyoSeigyoHanyo 仮算定_コンビニ納付書発行日表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 管理年度, キー_コンビニ納付書発行日表示);
        div.getNotsuInfo().getRadNofishoHakkoYMDHyojiK().setSelectedKey(仮算定_コンビニ納付書発行日表示.get設定値());
        帳票制御汎用リスト.add(仮算定_コンビニ納付書発行日表示);
        ChohyoSeigyoHanyo 仮算定_コンビニ納付書取扱期限表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 管理年度, キー_コンビニ納付書取扱期限表示);
        div.getNotsuInfo().getRadNofishoToriatsukaiKigenHyojiK().setSelectedKey(
                仮算定_コンビニ納付書取扱期限表示.get設定値());
        帳票制御汎用リスト.add(仮算定_コンビニ納付書取扱期限表示);
        ChohyoSeigyoHanyo 仮算定_当初出力_出力方法 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_当初出力_出力方法);
        div.getNotsuInfo().getRadToshoShutsuryokuK().setSelectedKey(仮算定_当初出力_出力方法.get設定値());
        帳票制御汎用リスト.add(仮算定_当初出力_出力方法);
        ChohyoSeigyoHanyo 仮算定_当初出力_中期開始期 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_当初出力_中期開始期);
        div.getNotsuInfo().getDdlChukiKaishiKiK().setSelectedKey(仮算定_当初出力_中期開始期.get設定値());
        帳票制御汎用リスト.add(仮算定_当初出力_中期開始期);
        ChohyoSeigyoHanyo 仮算定_当初出力_後期開始期 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_当初出力_後期開始期);
        div.getNotsuInfo().getDdlKokiKaishiKiK().setSelectedKey(仮算定_当初出力_後期開始期.get設定値());
        帳票制御汎用リスト.add(仮算定_当初出力_後期開始期);
        ChohyoSeigyoHanyo 仮算定_算定の基礎1 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_算定の基礎1);
        div.getNotsuInfo().getDdlKiso1().setSelectedKey(仮算定_算定の基礎1.get設定値());
        帳票制御汎用リスト.add(仮算定_算定の基礎1);
        ChohyoSeigyoHanyo 仮算定_算定の基礎2 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_算定の基礎2);
        div.getNotsuInfo().getDdlKiso2().setSelectedKey(仮算定_算定の基礎2.get設定値());
        帳票制御汎用リスト.add(仮算定_算定の基礎2);
        ChohyoSeigyoHanyo 仮算定_算定の基礎3 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(仮算定_帳票分類ID), 調定年度DDLの調定年度, キー_算定の基礎3);
        div.getNotsuInfo().getDdlKiso3().setSelectedKey(仮算定_算定の基礎3.get設定値());
        帳票制御汎用リスト.add(仮算定_算定の基礎3);
    }

    private void 本算定初期化(ChohyoSeigyoHanyoManager manager, FlexibleYear 調定年度DDLの調定年度,
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 本算定_差額令書発行指示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_差額令書発行指示);
        div.getNotsuInfo().getRadSagakuReishoHakkoUmuH().setSelectedKey(本算定_差額令書発行指示.get設定値());
        帳票制御汎用リスト.add(本算定_差額令書発行指示);
        ChohyoSeigyoHanyo 本算定_コンビニバーコード表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_コンビニバーコード表示);
        div.getNotsuInfo().getRadBarCodeHyojiH().setSelectedKey(本算定_コンビニバーコード表示.get設定値());
        帳票制御汎用リスト.add(本算定_コンビニバーコード表示);
        ChohyoSeigyoHanyo 本算定_コンビニ_ブック口座用納付書表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_コンビニ_ブック口座用納付書表示);
        div.getNotsuInfo().getRadKozaNofushoHyojiH().setSelectedKey(本算定_コンビニ_ブック口座用納付書表示.get設定値());
        帳票制御汎用リスト.add(本算定_コンビニ_ブック口座用納付書表示);
        ChohyoSeigyoHanyo 本算定_コンビニ納付書発行日表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_コンビニ納付書発行日表示);
        div.getNotsuInfo().getRadNofishoHakkoYMDHyojiH().setSelectedKey(本算定_コンビニ納付書発行日表示.get設定値());
        帳票制御汎用リスト.add(本算定_コンビニ納付書発行日表示);
        ChohyoSeigyoHanyo 本算定_コンビニ納付書取扱期限表示 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 管理年度, キー_コンビニ納付書取扱期限表示);
        div.getNotsuInfo().getRadNofishoToriatsukaiKigenHyojiH().setSelectedKey(
                本算定_コンビニ納付書取扱期限表示.get設定値());
        帳票制御汎用リスト.add(本算定_コンビニ納付書取扱期限表示);
        ChohyoSeigyoHanyo 本算定_当初出力_出力方法 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_当初出力_出力方法);
        div.getNotsuInfo().getRadToshoShutsuryokuH().setSelectedKey(本算定_当初出力_出力方法.get設定値());
        帳票制御汎用リスト.add(本算定_当初出力_出力方法);
        ChohyoSeigyoHanyo 本算定_当初出力_中期開始期 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_当初出力_中期開始期);
        div.getNotsuInfo().getDdlChukiKaishiKiH().setSelectedKey(本算定_当初出力_中期開始期.get設定値());
        帳票制御汎用リスト.add(本算定_当初出力_中期開始期);
        ChohyoSeigyoHanyo 本算定_当初出力_後期開始期 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_当初出力_後期開始期);
        div.getNotsuInfo().getDdlKokiKaishiKiH().setSelectedKey(本算定_当初出力_後期開始期.get設定値());
        帳票制御汎用リスト.add(本算定_当初出力_後期開始期);
        ChohyoSeigyoHanyo 本算定_過年度文言1 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_過年度文言1);
        div.getNotsuInfo().getRadKanendoMongon1().setSelectedKey(本算定_過年度文言1.get設定値());
        帳票制御汎用リスト.add(本算定_過年度文言1);
        ChohyoSeigyoHanyo 本算定_過年度文言2 = manager.get帳票制御汎用(SubGyomuCode.DBB介護賦課,
                new ReportId(帳票分類ID), 調定年度DDLの調定年度, キー_過年度文言2);
        div.getNotsuInfo().getRadKanendoMongon2().setSelectedKey(本算定_過年度文言2.get設定値());
        帳票制御汎用リスト.add(本算定_過年度文言2);
    }

    /**
     * システム管理情報（納入通知書）を画面保存処理しました。
     *
     * @param 帳票制御汎用リスト List<ChohyoSeigyoHanyo>
     */
    public void save(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        div.getNotsuInfo().getCcdKaigoChohyoSeigyoKyotsu().save(SubGyomuCode.DBB介護賦課, new ReportId(帳票分類ID));
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        宛先住所コード出力順等リスト作成(帳票制御汎用リスト);
        口座文言領収日付欄等リスト作成(帳票制御汎用リスト);
        差額令書当初出力方法等仮算定リスト作成(帳票制御汎用リスト);
        差額令書当初出力方法等本算定リスト作成(帳票制御汎用リスト);
        manager.update帳票制御汎用(帳票制御汎用リスト);
    }

    private void 宛先住所コード出力順等リスト作成(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 帳票制御汎用_項目名 = 帳票制御汎用リスト.get(帳票制御汎用_1条目);
        帳票制御汎用リスト.set(帳票制御汎用_1条目, 帳票制御汎用_項目名.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getTxtHakkoBusu().getValue()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_速報取込区分 = 帳票制御汎用リスト.get(帳票制御汎用_2条目);
        帳票制御汎用リスト.set(帳票制御汎用_2条目, 帳票制御汎用_速報取込区分.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadSokuhoTorikomiKubun().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_単票発行_出力方式 = 帳票制御汎用リスト.get(帳票制御汎用_3条目);
        帳票制御汎用リスト.set(帳票制御汎用_3条目, 帳票制御汎用_単票発行_出力方式.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadSokujiHakkoHoshiki().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_単票発行_出力形式 = 帳票制御汎用リスト.get(帳票制御汎用_4条目);
        帳票制御汎用リスト.set(帳票制御汎用_4条目, 帳票制御汎用_単票発行_出力形式.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadSokujiHakkoKeishiki().getSelectedKey()).build());
    }

    private void 口座文言領収日付欄等リスト作成(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 帳票制御汎用_領収証書納付額欄 = 帳票制御汎用リスト.get(帳票制御汎用_5条目);
        帳票制御汎用リスト.set(帳票制御汎用_5条目, 帳票制御汎用_領収証書納付額欄.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKozaMongonRyoshushoNofugaku().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_納付書納付額欄 = 帳票制御汎用リスト.get(帳票制御汎用_6条目);
        帳票制御汎用リスト.set(帳票制御汎用_6条目, 帳票制御汎用_納付書納付額欄.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKozaMongonNofushoNofugaku().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_領収証書領収印欄 = 帳票制御汎用リスト.get(帳票制御汎用_7条目);
        帳票制御汎用リスト.set(帳票制御汎用_7条目, 帳票制御汎用_領収証書領収印欄.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKozaMongonRyoshushoRyoshuin().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_納付書領収印欄 = 帳票制御汎用リスト.get(帳票制御汎用_8条目);
        帳票制御汎用リスト.set(帳票制御汎用_8条目, 帳票制御汎用_納付書領収印欄.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKozaMongonNofushoRyoshuin().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_領収書領収日付印欄 = 帳票制御汎用リスト.get(帳票制御汎用_9条目);
        帳票制御汎用リスト.set(帳票制御汎用_9条目, 帳票制御汎用_領収書領収日付印欄.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_納付書領収日付欄 = 帳票制御汎用リスト.get(帳票制御汎用_10条目);
        帳票制御汎用リスト.set(帳票制御汎用_10条目, 帳票制御汎用_納付書領収日付欄.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlShutsuryokuHohoNofushoRyoshuHiduke().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_領収書日付印欄の期 = 帳票制御汎用リスト.get(帳票制御汎用_11条目);
        帳票制御汎用リスト.set(帳票制御汎用_11条目, 帳票制御汎用_領収書日付印欄の期.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_納付書市町村名表示 = 帳票制御汎用リスト.get(帳票制御汎用_12条目);
        帳票制御汎用リスト.set(帳票制御汎用_12条目, 帳票制御汎用_納付書市町村名表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlNofushoShichosonNameUmu().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_納付書市町村名 = 帳票制御汎用リスト.get(帳票制御汎用_13条目);
        帳票制御汎用リスト.set(帳票制御汎用_13条目, 帳票制御汎用_納付書市町村名.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getTxtNofushoShichosonName().getValue()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_納期限出力方法 = 帳票制御汎用リスト.get(帳票制御汎用_14条目);
        帳票制御汎用リスト.set(帳票制御汎用_14条目, 帳票制御汎用_納期限出力方法.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlNokigenShutsuryokuHoho().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_口座振替のOCR出力方法 = 帳票制御汎用リスト.get(帳票制御汎用_15条目);
        帳票制御汎用リスト.set(帳票制御汎用_15条目, 帳票制御汎用_口座振替のOCR出力方法.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlOCRShutsuryokuHoho().getSelectedKey()).build());
    }

    private void 差額令書当初出力方法等仮算定リスト作成(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 仮算定_差額令書発行指示 = 帳票制御汎用リスト.get(帳票制御汎用_16条目);
        帳票制御汎用リスト.set(帳票制御汎用_16条目, 仮算定_差額令書発行指示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadSagakuReishoHakkoUmuK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_コンビニバーコード表示 = 帳票制御汎用リスト.get(帳票制御汎用_17条目);
        帳票制御汎用リスト.set(帳票制御汎用_17条目, 仮算定_コンビニバーコード表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadBarCodeHyojiK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_コンビニ_ブック口座用納付書表示 = 帳票制御汎用リスト.get(帳票制御汎用_18条目);
        帳票制御汎用リスト.set(帳票制御汎用_18条目, 仮算定_コンビニ_ブック口座用納付書表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadKozaNofushoHyojiK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_コンビニ納付書発行日表示 = 帳票制御汎用リスト.get(帳票制御汎用_19条目);
        帳票制御汎用リスト.set(帳票制御汎用_19条目, 仮算定_コンビニ納付書発行日表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadNofishoHakkoYMDHyojiK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_コンビニ納付書取扱期限表示 = 帳票制御汎用リスト.get(帳票制御汎用_20条目);
        帳票制御汎用リスト.set(帳票制御汎用_20条目, 仮算定_コンビニ納付書取扱期限表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadNofishoToriatsukaiKigenHyojiK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_当初出力_出力方法 = 帳票制御汎用リスト.get(帳票制御汎用_21条目);
        帳票制御汎用リスト.set(帳票制御汎用_21条目, 仮算定_当初出力_出力方法.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadToshoShutsuryokuK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_当初出力_中期開始期 = 帳票制御汎用リスト.get(帳票制御汎用_22条目);
        帳票制御汎用リスト.set(帳票制御汎用_22条目, 仮算定_当初出力_中期開始期.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlChukiKaishiKiK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_当初出力_後期開始期 = 帳票制御汎用リスト.get(帳票制御汎用_23条目);
        帳票制御汎用リスト.set(帳票制御汎用_23条目, 仮算定_当初出力_後期開始期.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKokiKaishiKiK().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_キー_算定の基礎1 = 帳票制御汎用リスト.get(帳票制御汎用_24条目);
        帳票制御汎用リスト.set(帳票制御汎用_24条目, 仮算定_キー_算定の基礎1.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKiso1().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_キー_算定の基礎2 = 帳票制御汎用リスト.get(帳票制御汎用_25条目);
        帳票制御汎用リスト.set(帳票制御汎用_25条目, 仮算定_キー_算定の基礎2.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKiso2().getSelectedKey()).build());
        ChohyoSeigyoHanyo 仮算定_キー_算定の基礎3 = 帳票制御汎用リスト.get(帳票制御汎用_26条目);
        帳票制御汎用リスト.set(帳票制御汎用_26条目, 仮算定_キー_算定の基礎3.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKiso3().getSelectedKey()).build());
    }

    private void 差額令書当初出力方法等本算定リスト作成(List<ChohyoSeigyoHanyo> 帳票制御汎用リスト) {
        ChohyoSeigyoHanyo 帳票制御汎用_差額令書発行指示 = 帳票制御汎用リスト.get(帳票制御汎用_27条目);
        帳票制御汎用リスト.set(帳票制御汎用_27条目, 帳票制御汎用_差額令書発行指示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadSagakuReishoHakkoUmuH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_コンビニバーコード表示 = 帳票制御汎用リスト.get(帳票制御汎用_28条目);
        帳票制御汎用リスト.set(帳票制御汎用_28条目, 帳票制御汎用_コンビニバーコード表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadBarCodeHyojiH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_コンビニ_ブック口座用納付書表示 = 帳票制御汎用リスト.get(帳票制御汎用_29条目);
        帳票制御汎用リスト.set(帳票制御汎用_29条目, 帳票制御汎用_コンビニ_ブック口座用納付書表示.createBuilderForEdit()
                .set設定値(div.getNotsuInfo().getRadKozaNofushoHyojiH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_コンビニ納付書発行日表示 = 帳票制御汎用リスト.get(帳票制御汎用_30条目);
        帳票制御汎用リスト.set(帳票制御汎用_30条目, 帳票制御汎用_コンビニ納付書発行日表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadNofishoHakkoYMDHyojiH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_コンビニ納付書取扱期限表示 = 帳票制御汎用リスト.get(帳票制御汎用_31条目);
        帳票制御汎用リスト.set(帳票制御汎用_31条目, 帳票制御汎用_コンビニ納付書取扱期限表示.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadNofishoToriatsukaiKigenHyojiH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_当初出力_出力方法 = 帳票制御汎用リスト.get(帳票制御汎用_32条目);
        帳票制御汎用リスト.set(帳票制御汎用_32条目, 帳票制御汎用_当初出力_出力方法.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadToshoShutsuryokuH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_当初出力_中期開始期 = 帳票制御汎用リスト.get(帳票制御汎用_33条目);
        帳票制御汎用リスト.set(帳票制御汎用_33条目, 帳票制御汎用_当初出力_中期開始期.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlChukiKaishiKiH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_当初出力_後期開始期 = 帳票制御汎用リスト.get(帳票制御汎用_34条目);
        帳票制御汎用リスト.set(帳票制御汎用_34条目, 帳票制御汎用_当初出力_後期開始期.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getDdlKokiKaishiKiH().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_過年度文言1 = 帳票制御汎用リスト.get(帳票制御汎用_35条目);
        帳票制御汎用リスト.set(帳票制御汎用_35条目, 帳票制御汎用_過年度文言1.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadKanendoMongon1().getSelectedKey()).build());
        ChohyoSeigyoHanyo 帳票制御汎用_過年度文言2 = 帳票制御汎用リスト.get(帳票制御汎用_36条目);
        帳票制御汎用リスト.set(帳票制御汎用_36条目, 帳票制御汎用_過年度文言2.createBuilderForEdit().set設定値(
                div.getNotsuInfo().getRadKanendoMongon2().getSelectedKey()).build());
    }

    /**
     * 完了画面のメッセージ表示するメソッドです。
     */
    public void set完了メッセージ表示() {
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(対象情報.replace(XX年度,
                div.getKonkaiShoriNaiyo().getDdlChoteiNendo().getSelectedValue()), new RString(
                        UrInformationMessages.正常終了.getMessage().replace(完了メッセージ.toString()).evaluate()),
                RString.EMPTY, true);
    }

    /**
     * 調定年度Ddlを設定するメソッドです。
     */
    public void set調定年度() {
        RString 調定年度 = DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        ShoriDateKanriManager manager = InstanceProvider.create(ShoriDateKanriManager.class);
        ShoriDateKanri result = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課,
                ShoriName.新年度管理情報作成.get名称(),
                new FlexibleYear(調定年度).plusYear(1));
        RString 新年度管理情報 = 新年度管理情報_未作成;
        if (result != null && !FlexibleDate.EMPTY.equals(result.get基準年月日())) {
            新年度管理情報 = 新年度管理情報_作成済;
        }
        if (新年度管理情報_未作成.equals(新年度管理情報)) {
            setDataSource(Integer.parseInt(調定年度.toString()));
        } else if (新年度管理情報_作成済.equals(新年度管理情報)) {
            setDataSource(Integer.parseInt(調定年度.toString()) + 1);
        }
        div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setSelectedKey(調定年度);
    }

    private void setDataSource(int 調定年度) {
        List<KeyValueDataSource> ddlSourceList = new ArrayList<>();
        for (int i = 平成12年_西暦; i <= 調定年度; i++) {
            KeyValueDataSource source = new KeyValueDataSource(new RString(String.valueOf(i)),
                    new FlexibleYear(String.valueOf(i)).wareki().firstYear(FirstYear.ICHI_NEN).getYear());
            ddlSourceList.add(source);
        }
        Collections.reverse(ddlSourceList);
        div.getKonkaiShoriNaiyo().getDdlChoteiNendo().setDataSource(ddlSourceList);
    }
}
