/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuForPrinting;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KanendoMongon;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuHizukeRan;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshuinranHyojiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.RyoshushoHizukeranKiHyoji;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SagakuReishoHakkoShijiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SanteiKiso;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.noki.nokikanri.UrT0729NokiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 賦課帳票共通項目編集（仮算定）のクラスです。
 */
public class NonyuTsuchiShoDataHenshu {

    private final RString 空白 = RString.EMPTY;
    private final RString 単位_円 = new RString("円");
    private final RString 口座振替 = new RString("口座振替");

    /**
     * 仮算定納入通知書情報を作成する。
     *
     * @param 仮算定通知書情報 仮算定通知書情報
     * @param 仮算定納入通知書制御情報 仮算定納入通知書制御情報
     * @param 請求情報リスト 請求情報リスト
     * @param 収納科目 収納科目
     * @param 代納人氏名 代納人氏名
     * @param 出力期リスト 出力期リスト
     * @param 編集範囲区分 編集範囲区分
     * @return 仮算定納入通知書情報
     */
    public KariSanteiNonyuTsuchiShoJoho create仮算定納入通知書情報(
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報,
            List<SeikyuForPrinting> 請求情報リスト,
            IShunoKamoku 収納科目,
            IName 代納人氏名,
            List<Kitsuki> 出力期リスト,
            HenshuHaniKubun 編集範囲区分) {
        //TODO DBBBZ00007_1の仮算定通知書共通情報作成メソッドを呼び出  未作成
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト
                = create納入通知書期情報(null, null, null, 請求情報リスト, null, null, 出力期リスト, null, null);
        //TODO 前年度情報有無は、1.1からの編集後仮算定通知書共通情報.前年度情報有無　とする。
        Boolean 前年度情報有無 = true;
        SanteiNoKiso 算定基礎情報 = new SanteiNoKiso();
        //TODO パラメータ：1.1からの編集後仮算定通知書共通情報
        SanteiNoKiso 基礎1 = get算定の基礎_基礎(仮算定納入通知書制御情報.get算定の基礎1(), 前年度情報有無);
        SanteiNoKiso 基礎2 = get算定の基礎_基礎(仮算定納入通知書制御情報.get算定の基礎2(), 前年度情報有無);
        SanteiNoKiso 基礎3 = get算定の基礎_基礎(仮算定納入通知書制御情報.get算定の基礎3(), 前年度情報有無);
        算定基礎情報.set基礎1(基礎1);
        算定基礎情報.set基礎2(基礎2);
        算定基礎情報.set基礎3(基礎3);
        FlexibleDate 発行日 = 仮算定通知書情報.get発行日();
        NofuShoKyotsu 納付書共通 = create納付書共通(
                null,
                null,
                null,
                null,
                null,
                new RDate(発行日.getYearValue(), 発行日.getMonthValue(), 発行日.getDayValue()),
                代納人氏名,
                null,
                収納科目,
                仮算定納入通知書制御情報.get納入通知書制御情報());
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Return = new KariSanteiNonyuTsuchiShoJoho();
        仮算定納入通知書情報Return.set発行日(仮算定通知書情報.get発行日());
        仮算定納入通知書情報Return.set帳票分類ID(仮算定通知書情報.get帳票分類ID());
        仮算定納入通知書情報Return.set帳票ID(仮算定通知書情報.get帳票ID());
        仮算定納入通知書情報Return.set処理区分(仮算定通知書情報.get処理区分());
        //TODO 1.1の結果．編集後仮算定通知書共通情報
        仮算定納入通知書情報Return.set編集後仮算定通知書共通情報(null);
        仮算定納入通知書情報Return.set仮算定納入通知書制御情報(仮算定納入通知書制御情報);
        仮算定納入通知書情報Return.set算定の基礎(算定基礎情報);
        仮算定納入通知書情報Return.set地方公共団体(仮算定通知書情報.get地方公共団体());
        仮算定納入通知書情報Return.set納入通知書期情報リスト(納入通知書期情報リスト);
        仮算定納入通知書情報Return.set納付書共通(納付書共通);
        仮算定納入通知書情報Return.set編集範囲区分(編集範囲区分);
        仮算定納入通知書情報Return.set出力期リスト(出力期リスト);
        return 仮算定納入通知書情報Return;
    }

    /**
     * 算定の基礎の基礎1/基礎2/基礎3を設定する。
     *
     * @param 仮算定納入通知書制御情報 仮算定納入通知書制御情報
     * @param 収納科目 収納科目
     * @param 代納人氏名 代納人氏名
     * @return 算定の基礎の基礎1/基礎2/基礎3
     */
    private SanteiNoKiso get算定の基礎_基礎(SanteiKiso 算定基礎, Boolean 前年度情報有無) {
        SanteiNoKiso 基礎 = new SanteiNoKiso();
        if (SanteiKiso.空白.equals(算定基礎)) {
            基礎.set名称(空白);
            基礎.set年度(空白);
            基礎.set金額(空白);
            基礎.set単位(空白);
        } else {
            基礎.set単位(単位_円);
            基礎.set名称(算定基礎.get名称());
            if (SanteiKiso.保険料率.equals(算定基礎)) {
                //TODO 1.1からの編集後仮算定通知書共通情報.前年度賦課年度
                基礎.set年度(RString.FULL_SPACE);
                基礎.set金額(前年度情報有無 ? null : 空白);
            } else if (SanteiKiso.年額保険料.equals(算定基礎)) {
                //TODO 1.1からの編集後仮算定通知書共通情報.前年度賦課年度
                基礎.set年度(RString.HALF_SPACE);
                基礎.set金額(前年度情報有無 ? null : 空白);
            } else if (SanteiKiso.最終期保険料額.equals(算定基礎)) {
                //TODO 1.1からの編集後仮算定通知書共通情報.前年度賦課年度
                基礎.set年度(RString.EMPTY);
                基礎.set金額(前年度情報有無 ? null : 空白);
            } else {
                //TODO 1.1からの編集後仮算定通知書共通情報.賦課年度
                基礎.set年度(null);
                基礎.set金額(前年度情報有無 ? null : 空白);
            }
        }
        return 基礎;
    }

    /**
     * 本算定納入通知書情報を作成する。
     *
     * @param 本算定通知書情報 本算定通知書情報
     * @param 本算定納入通知書制御情報 本算定納入通知書制御情報
     * @param 請求情報リスト 請求情報リスト
     * @param 収納科目 収納科目
     * @param 代納人氏名 代納人氏名
     * @param 出力期リスト 出力期リスト
     * @param 編集範囲区分 編集範囲区分
     * @return 本算定納入通知書情報
     */
    public HonSanteiNonyuTsuchiShoJoho create本算定納入通知書情報(HonSanteiTsuchiShoKyotsu 本算定通知書情報,
            HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報,
            List<SeikyuForPrinting> 請求情報リスト,
            IShunoKamoku 収納科目,
            IName 代納人氏名,
            List<Kitsuki> 出力期リスト,
            HenshuHaniKubun 編集範囲区分) {
        //TODO DBBBZ00005_1の本算定通知書共通情報作成メソッドを呼び出し  未作成
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = new EditedHonSanteiTsuchiShoKyotsu();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = create納入通知書期情報(null, null, null, 請求情報リスト,
                本算定納入通知書制御情報.get納入通知書制御情報(), null, 出力期リスト, null, null);
        NofuShoKyotsu 納付書共通 = create納付書共通(
                new FlexibleYear(編集後本算定通知書共通情報.get調定年度()),
                new FlexibleYear(編集後本算定通知書共通情報.get賦課年度()),
                編集後本算定通知書共通情報.get編集後宛先(),
                null,
                編集後本算定通知書共通情報.get通知書番号(),
                本算定通知書情報.get発行日(),
                代納人氏名,
                編集後本算定通知書共通情報.get表示コード(),
                収納科目,
                本算定納入通知書制御情報.get納入通知書制御情報());
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        本算定納入通知書情報.set現年度_過年度区分(本算定通知書情報.get現年度_過年度区分());
        本算定納入通知書情報.set発行日(本算定通知書情報.get発行日());
        本算定納入通知書情報.set帳票分類ID(本算定通知書情報.get帳票分類ID());
        本算定納入通知書情報.set帳票ID(本算定通知書情報.get帳票ID());
        本算定納入通知書情報.set処理区分(本算定通知書情報.get処理区分());
        本算定納入通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        本算定納入通知書情報.set本算定納入通知書制御情報(本算定納入通知書制御情報);
        本算定納入通知書情報.set地方公共団体(本算定通知書情報.get地方公共団体());
        本算定納入通知書情報.set納付書共通(納付書共通);
        本算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        本算定納入通知書情報.set編集範囲区分(編集範囲区分);
        本算定納入通知書情報.set出力期リスト(出力期リスト);
        return 本算定納入通知書情報;
    }

    /**
     * 納入通知書期情報を作成する。
     *
     * @param 普徴納期情報リスト 普徴納期情報リスト
     * @param 更正後普徴期別金額リスト 更正後普徴期別金額リスト
     * @param 口座区分 口座区分
     * @param 納入通知書制御情報 納入通知書制御情報
     * @param 出力期リスト 出力期リスト
     * @param 普徴収入情報リスト 普徴収入情報リスト
     * @param 請求情報リスト 請求情報リスト
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @return 納入通知書期情報リスト
     */
    public List<NonyuTsuchiShoKiJoho> create納入通知書期情報(
            List<NokiJoho> 普徴納期情報リスト,
            List<UniversalPhase> 更正後普徴期別金額リスト,
            KozaKubun 口座区分,
            List<SeikyuForPrinting> 請求情報リスト,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報,
            List<SamantabhadraIncomeInformation> 普徴収入情報リスト,
            List<Kitsuki> 出力期リスト,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = new ArrayList<>();
        for (Kitsuki 出力期 : 出力期リスト) {
            int 期 = 出力期.get期AsInt();
            int 月 = 出力期.get月AsInt();
            Decimal 金額 = get金額(更正後普徴期別金額リスト, 期);
            Decimal 収入額 = get収入額(普徴収入情報リスト, 出力期);
            Decimal 納付額
                    = SagakuReishoHakkoShijiKubun.差額令書で発行する.equals(納入通知書制御情報.get差額令書発行指示()) ? 金額.subtract(収入額) : 金額;
            int 銀振印字位置;
            int ブック開始位置;
            int コンビニ連帳印字位置;
            int コンビニカット印字位置;
            if (調定年度.equals(賦課年度)) {
                List<RString> 各印字位置 = get各印字位置(月);
                銀振印字位置 = RString.isNullOrEmpty(各印字位置.get(0)) ? 0 : Integer.parseInt(各印字位置.get(0).toString());
                if (0 == 銀振印字位置) {
                    continue;
                }
                ブック開始位置 = RString.isNullOrEmpty(各印字位置.get(1)) ? 0 : Integer.parseInt(各印字位置.get(1).toString());
                コンビニ連帳印字位置
                        = RString.isNullOrEmpty(各印字位置.get(3)) ? 0 : Integer.parseInt(各印字位置.get(3).toString());
                コンビニカット印字位置
                        = RString.isNullOrEmpty(各印字位置.get(2)) ? 0 : Integer.parseInt(各印字位置.get(2).toString());
            } else {
                List<RString> 各印字位置 = get各印字位置2(月);
                銀振印字位置 = RString.isNullOrEmpty(各印字位置.get(0)) ? 0 : Integer.parseInt(各印字位置.get(0).toString());
                if (0 == 銀振印字位置) {
                    continue;
                }
                ブック開始位置 = RString.isNullOrEmpty(各印字位置.get(1)) ? 0 : Integer.parseInt(各印字位置.get(1).toString());
                コンビニ連帳印字位置 = RString.isNullOrEmpty(各印字位置.get(2)) ? 0 : Integer.parseInt(各印字位置.get(2).toString());
                コンビニカット印字位置 = RString.isNullOrEmpty(各印字位置.get(3)) ? 0 : Integer.parseInt(各印字位置.get(3).toString());
            }
            if (is処理中の期月の物である(請求情報リスト, 出力期.get期())) {
                continue;
            }
            NonyuTsuchiShoKiJoho 納入通知書期情報 = get納入通知書期情報(普徴納期情報リスト, 請求情報リスト, 期, 出力期, 銀振印字位置,
                    ブック開始位置, コンビニ連帳印字位置, コンビニカット印字位置, 納入通知書制御情報, 金額, 収入額, 納付額);
            納入通知書期情報リスト.add(納入通知書期情報);
        }
        return 納入通知書期情報リスト;
    }

    private boolean is処理中の期月の物である(List<SeikyuForPrinting> 請求情報リスト, RString 処理中の期) {
        for (SeikyuForPrinting 請求情報 : 請求情報リスト) {
            if (処理中の期.equals(請求情報.get請求対象情報().get請求明細リスト().get(0).get収納期別明細().get期別())) {
                return true;
            }
        }
        return false;
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報(List<NokiJoho> 普徴納期情報リスト, List<SeikyuForPrinting> 請求情報リスト, int 期,
            Kitsuki 出力期, int 銀振印字位置, int ブック開始位置, int コンビニ連帳印字位置, int コンビニカット印字位置,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, Decimal 金額, Decimal 収入額, Decimal 納付額) {
        NonyuTsuchiShoKiJoho 納入通知書期情報 = new NonyuTsuchiShoKiJoho();
        NokiJoho 普徴納期情報 = get普徴納期情報By期(普徴納期情報リスト, 期);
        Noki 納期 = null == 普徴納期情報.get納期() ? new Noki(new UrT0729NokiKanriEntity()) : 普徴納期情報.get納期();
        SeikyuForPrinting 請求情報 = get請求情報By期(請求情報リスト, 出力期.get期());
        納入通知書期情報.set銀振印字位置(銀振印字位置);
        納入通知書期情報.setコンビニ連帳印字位置(コンビニ連帳印字位置);
        納入通知書期情報.setコンビニカット印字位置(コンビニカット印字位置);
        納入通知書期情報.setブック開始位置(ブック開始位置);
        納入通知書期情報.set期(出力期.get期AsInt());
        納入通知書期情報.set月(出力期.get月());
        納入通知書期情報.set期表記(new RString(String.valueOf(出力期.get期AsInt())).padLeft(RString.HALF_SPACE, 2));
        納入通知書期情報.set月表記(new RString(String.valueOf(出力期.get月AsInt())).padLeft(RString.HALF_SPACE, 2));
        //TODO QA #76901
        納入通知書期情報.set随時表記(KanendoMongon.随時.equals(納入通知書制御情報.get過年度文言1()) ? null : RString.EMPTY);
        納入通知書期情報.set納期開始日(納期.get納期開始日());
        納入通知書期情報.set納期開始日表記(納期.get納期開始日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        納入通知書期情報.set納期終了日(納期.get納期終了日());
        納入通知書期情報.set納期終了日表記(納期.get納期終了日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        納入通知書期情報.set納期限(納期.get納期限());
        納入通知書期情報.set納期限表記(納付額.compareTo(Decimal.ZERO) <= 0 ? new RString("***********") : 納期.get納期限().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        納入通知書期情報.set納付額(納付額);
        納入通知書期情報.set納付額表記(new RString(String.valueOf(納付額)));
        納入通知書期情報.set調定額(金額);
        納入通知書期情報.set調定額表記(new RString(String.valueOf(金額)));
        納入通知書期情報.set収入額(収入額);
        納入通知書期情報.set収入額表記(new RString(String.valueOf(収入額)));
        納入通知書期情報.set差額(金額.subtract(収入額));
        納入通知書期情報.set差額表記(new RString(String.valueOf(金額.subtract(収入額))));
        if (is該当する請求情報ある(請求情報)) {
            納入通知書期情報.set収納機関番号表示用(請求情報.getMpn().get収納機関番号表示用());
            納入通知書期情報.set納付番号(請求情報.getMpn().get納付番号());
            納入通知書期情報.set確認番号(請求情報.getMpn().get確認番号());
            納入通知書期情報.set納付区分(請求情報.getMpn().get納付区分());
            //TODO 入力.口座区分＝「1：該当」の場合
            納入通知書期情報.setOCRID(null);
            納入通知書期情報.setOCR(null);
            納入通知書期情報.setバーコード情報((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニバーコード表示())
                    ? 請求情報.getCvs().getバーコード情報() : 空白));
            納入通知書期情報.setバーコード情報上段((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニバーコード表示())
                    ? 請求情報.getCvs().getバーコード情報上段() : 空白));
            納入通知書期情報.setバーコード情報下段((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニバーコード表示())
                    ? 請求情報.getCvs().getバーコード情報下段() : 空白));
            納入通知書期情報.setコンビニ支払期限((HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニ納付書取扱期限表示())
                    ? 請求情報.getCvs().getコンビニ支払期限() : new RDate(空白.toString())));
        } else {
            納入通知書期情報.set収納機関番号表示用(空白);
            納入通知書期情報.set納付番号(空白);
            納入通知書期情報.set確認番号(空白);
            納入通知書期情報.set納付区分(空白);
            納入通知書期情報.setOCRID(空白);
            納入通知書期情報.setOCR(null);
            納入通知書期情報.setバーコード情報(空白);
            納入通知書期情報.setバーコード情報上段(空白);
            納入通知書期情報.setバーコード情報下段(空白);
            納入通知書期情報.setコンビニ支払期限(new RDate(空白.toString()));
        }
        //TODO 入力.口座区分＝「1：該当」の場合
        納入通知書期情報.set領収証書納付額欄(null);
        納入通知書期情報.set納付書納付額欄(null);
        納入通知書期情報.set領収証書領収印欄(RyoshuinranHyojiKubun._口座振替_を印字する.equals(納入通知書制御情報.get領収証書領収印欄()) ? 口座振替 : 空白);
        納入通知書期情報.set納付書領収印欄(RyoshuinranHyojiKubun._口座振替_を印字する.equals(納入通知書制御情報.get納付書領収印欄()) ? 口座振替 : 空白);
        RString 領収日付印欄;
        RString 領収日付欄;
        RString 領収書日付欄期月;
        if (RyoshuHizukeRan.期で出力する.equals(納入通知書制御情報.get領収書領収日付印欄())) {
            領収日付印欄 = new RString(String.valueOf(出力期.get期AsInt()));
        } else if (RyoshuHizukeRan.月で出力する.equals(納入通知書制御情報.get領収書領収日付印欄())) {
            領収日付印欄 = new RString(String.valueOf(出力期.get月AsInt()));
        } else {
            領収日付印欄 = 空白;
        }
        if (RyoshuHizukeRan.期で出力する.equals(納入通知書制御情報.get納付書領収日付欄())) {
            領収日付欄 = new RString(String.valueOf(出力期.get期AsInt()));
        } else if (RyoshuHizukeRan.月で出力する.equals(納入通知書制御情報.get納付書領収日付欄())) {
            領収日付欄 = new RString(String.valueOf(出力期.get月AsInt()));
        } else {
            領収日付欄 = 空白;
        }
        if (RyoshushoHizukeranKiHyoji.期表示.equals(納入通知書制御情報.get領収書日付印欄の期())) {
            領収書日付欄期月 = new RString(String.valueOf(出力期.get期AsInt()));
        } else if (RyoshushoHizukeranKiHyoji.月表示.equals(納入通知書制御情報.get領収書日付印欄の期())) {
            領収書日付欄期月 = new RString(String.valueOf(出力期.get月AsInt()));
        } else {
            領収書日付欄期月 = 空白;
        }
        納入通知書期情報.set領収日付印欄(領収日付印欄);
        納入通知書期情報.set領収日付欄(領収日付欄);
        納入通知書期情報.set領収書日付欄期月(領収書日付欄期月);
        return 納入通知書期情報;
    }

    private List<RString> get各印字位置2(int 月) {
        RString 過年度期情報_納付書の印字位置;
        RString 過年度期情報_ブック開始位置;
        RString 過年度期情報_コンビニカット印字位置;
        RString 過年度期情報_コンビニ連帳印字位置;
        switch (月) {
            case 1:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 2:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 3:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 4:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 5:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 6:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 7:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 8:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 9:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 10:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 11:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 12:
                過年度期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                過年度期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニ連帳印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            default:
                過年度期情報_納付書の印字位置 = RString.EMPTY;
                過年度期情報_ブック開始位置 = RString.EMPTY;
                過年度期情報_コンビニカット印字位置 = RString.EMPTY;
                過年度期情報_コンビニ連帳印字位置 = RString.EMPTY;
                break;
        }
        List<RString> 各印字位置 = new ArrayList<>();
        各印字位置.add(過年度期情報_納付書の印字位置);
        各印字位置.add(過年度期情報_ブック開始位置);
        各印字位置.add(過年度期情報_コンビニカット印字位置);
        各印字位置.add(過年度期情報_コンビニ連帳印字位置);
        return 各印字位置;
    }

    private List<RString> get各印字位置(int 月) {
        RString 普徴期情報_納付書の印字位置;
        RString 普徴期情報_ブック開始位置;
        RString 普徴期情報_コンビニカット印字位置;
        RString 普徴期情報_コンビニ連帳印字位置;
        switch (月) {
            case 1:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置1, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 2:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置2, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 3:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置3, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 4:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置4, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 5:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置5, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 6:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置6, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 7:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置7, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 8:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置8, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 9:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置9, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 10:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置10, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 11:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置11, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 12:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置12, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 13:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置13, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            case 14:
                普徴期情報_納付書の印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_ブック開始位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニカット印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                普徴期情報_コンビニ連帳印字位置
                        = BusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニ連帳印字位置14, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
                break;
            default:
                普徴期情報_納付書の印字位置 = RString.EMPTY;
                普徴期情報_ブック開始位置 = RString.EMPTY;
                普徴期情報_コンビニカット印字位置 = RString.EMPTY;
                普徴期情報_コンビニ連帳印字位置 = RString.EMPTY;
                break;
        }
        List<RString> 各印字位置 = new ArrayList<>();
        各印字位置.add(普徴期情報_納付書の印字位置);
        各印字位置.add(普徴期情報_ブック開始位置);
        各印字位置.add(普徴期情報_コンビニカット印字位置);
        各印字位置.add(普徴期情報_コンビニ連帳印字位置);
        return 各印字位置;
    }

    private boolean is該当する請求情報ある(SeikyuForPrinting 請求情報) {
        return 請求情報 != null;
    }

    private SeikyuForPrinting get請求情報By期(List<SeikyuForPrinting> 請求情報リスト, RString 期別) {
        for (SeikyuForPrinting 請求情報 : 請求情報リスト) {
            if (期別.equals(請求情報.get請求対象情報().get請求明細リスト().get(0).get収納期別明細().get期別())) {
                return 請求情報;
            }
        }
        return null;
    }

    private NokiJoho get普徴納期情報By期(List<NokiJoho> 普徴納期情報リスト, int 期) {
        for (NokiJoho 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報;
            }
        }
        return new NokiJoho();
    }

    private Decimal get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (更正後普徴期別金額.get期() == 期) {
                return 更正後普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    private Decimal get収入額(List<SamantabhadraIncomeInformation> 普徴収入情報リスト, Kitsuki 出力期) {
        for (SamantabhadraIncomeInformation 普徴収入情報 : 普徴収入情報リスト) {
            if (出力期.equals(普徴収入情報.get期月())) {
                return 普徴収入情報.get収入額();
            }
        }
        return Decimal.ZERO;
    }

    /**
     * 納付書共通を作成する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 編集後宛先 編集後宛先
     * @param 世帯コード 世帯コード
     * @param 通知書番号 通知書番号
     * @param 発行日 発行日
     * @param 収納科目 収納科目
     * @param 表示コード 表示コード
     * @param 代納人氏名 代納人氏名
     * @param 納入通知書制御情報 納入通知書制御情報
     * @return 納付書共通 納付書共通
     */
    public NofuShoKyotsu create納付書共通(FlexibleYear 調定年度, FlexibleYear 賦課年度, EditedAtesaki 編集後宛先, SetaiCode 世帯コード,
            TsuchishoNo 通知書番号, RDate 発行日, IName 代納人氏名, HyojiCodes 表示コード, IShunoKamoku 収納科目,
            NonyuTsuchiShoSeigyoJoho 納入通知書制御情報) {
        NofuShoKyotsu 納付書共通 = new NofuShoKyotsu();
        納付書共通.set調定年度(調定年度);
        納付書共通.set調定年度表記(get共通ポリシーターン107(調定年度));
        納付書共通.set賦課年度(賦課年度);
        納付書共通.set調定年度表記(get共通ポリシーターン107(賦課年度).concat("分"));
        納付書共通.set年度年分表記(get共通ポリシーターン107(調定年度).concat("△").concat(get共通ポリシーターン107(賦課年度)).concat("分"));
        納付書共通.set通知書番号(通知書番号);
        納付書共通.set世帯コード(世帯コード);
        納付書共通.set表示コード(表示コード);
        納付書共通.set科目名称(収納科目.get名称());
        納付書共通.set発行日(発行日);
        納付書共通.set発行日表記(HyojiUmu.表示する.equals(納入通知書制御情報.getコンビニ納付書発行日表示())
                ? 発行日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString() : 空白);
        納付書共通.set住所(編集後宛先.get編集後住所());
        納付書共通.set郵便番号(編集後宛先.get郵便番号());
        //TODO 入力.編集後宛先.get行政区名() 編集後宛先.get方書()
        納付書共通.set行政区名(null);
        納付書共通.set方書(null);
        納付書共通.set代納人氏名(代納人氏名.getName());
        納付書共通.set被保険者氏名(編集後宛先.get本人名称().getName());
        if (AtesakiShubetsu.代納人送付先.equals(編集後宛先.get宛先種別()) || AtesakiShubetsu.代納人.equals(編集後宛先.get宛先種別())) {
            納付書共通.set納付者氏名(代納人氏名.getName().getColumnValue());
            納付書共通.set被代納人氏名(納付書共通.get被保険者氏名().getColumnValue());
        } else {
            納付書共通.set納付者氏名(空白);
            納付書共通.set被代納人氏名(空白);
        }
        納付書共通.set被代納人敬称(編集後宛先.get本人敬称());
        納付書共通.set納付書市町村名(HyojiUmu.表示する.equals(納入通知書制御情報.get納付書市町村名表示()) ? 納入通知書制御情報.get納付書市町村名() : 空白);
        return 納付書共通;
    }

    private RString get共通ポリシーターン107(FlexibleYear 年度) {
        return null == 年度 ? RString.EMPTY
                : 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }

}
