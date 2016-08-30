/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKanri;
import jp.co.ndensan.reams.ca.cax.business.core.shuno.ShunoKey;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuForPrinting;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuItem;
import jp.co.ndensan.reams.ca.cax.business.report.seikyu.SeikyuItemMeisai;
import jp.co.ndensan.reams.ca.cax.definition.core.nofusho.FukusuKibetsuShuyakuKamoku;
import jp.co.ndensan.reams.ca.cax.definition.core.nofusho.FukusuKibetsuShuyakuNendo;
import jp.co.ndensan.reams.ca.cax.definition.core.seikyu.SeikyushoType;
import jp.co.ndensan.reams.ca.cax.definition.core.seikyu.ToriatsukaiKigenCheckKubun;
import jp.co.ndensan.reams.ca.cax.definition.core.seikyu.ocr.OcrPattern;
import jp.co.ndensan.reams.ca.cax.service.core.seikyu.SeikyuManager;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoDataHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokitsuki.NokitsukiCollection;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.authority.AuthorityKind;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.JigyoKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.noki.nokitsuki.NokitsukiManager;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.shunokamoku.ShunoKamokuManager;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 納入通知書情報作成サービスのクラスです。
 *
 * @reamsid_L DBB-9110-012 wangjie2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class NonyuTsuchiShoJohoFactory {

    private static final int 期_1 = 1;
    private static final int 期_2 = 2;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int 期_7 = 7;
    private static final int 期_8 = 8;
    private static final int 期_9 = 9;
    private static final int 期_10 = 10;
    private static final int 期_11 = 11;
    private static final int 期_12 = 12;
    private static final int 期_13 = 13;
    private static final int 期_14 = 14;
    private final IShunoKamoku 収納科目;
    private final Map<FlexibleYear, NokitsukiCollection> 納期月コレクションマップ;
    private static Map<ReportId, OcrPattern> パターンOCR;

    /**
     * コンストラクタです。
     */
    public NonyuTsuchiShoJohoFactory() {
        ShunoKamokuManager shunoKamokuManager = new ShunoKamokuManager(AuthorityKind.参照権限収納科目);
        this.収納科目 = shunoKamokuManager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        this.納期月コレクションマップ = new HashMap<>();
    }

    /**
     * 本算定納入通知書情報を作成する。
     *
     * @param 本算定通知書情報 本算定通知書情報
     * @param 本算定納入通知書制御情報 本算定納入通知書制御情報
     * @param 出力期リスト 出力期リスト
     * @param 代納人氏名 代納人氏名
     * @return 本算定納入通知書情報
     * @throws NullPointerException パラメータのいずれかがNullの場合。
     */
    public HonSanteiNonyuTsuchiShoJoho create本算定納入通知書情報(
            HonSanteiTsuchiShoKyotsu 本算定通知書情報,
            HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報,
            List<Kitsuki> 出力期リスト,
            IName 代納人氏名) {
        requireNonNull(本算定通知書情報, UrSystemErrorMessages.値がnull.getReplacedMessage("本算定通知書情報"));
        requireNonNull(本算定納入通知書制御情報, UrSystemErrorMessages.値がnull.getReplacedMessage("本算定納入通知書制御情報"));
        requireNonNull(出力期リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("出力期リスト"));
        FukaAtena 賦課の情報_更正後 = 本算定通知書情報.get賦課の情報_更正後();
        if (賦課の情報_更正後 != null && 賦課の情報_更正後.get賦課情報() != null
                && !this.納期月コレクションマップ.containsKey(賦課の情報_更正後.get賦課情報().get調定年度())) {
            NokitsukiManager nokitsukiManager = new NokitsukiManager();
            NokitsukiCollection 納期月コレクションマップ = nokitsukiManager.get納期月Collection(
                    収納科目, Code.EMPTY, new RYear(賦課の情報_更正後.get賦課情報().get調定年度().toDateString()),
                    GennenKanen.過年度.equals(本算定通知書情報.get現年度_過年度区分()));
            this.納期月コレクションマップ.put(賦課の情報_更正後.get賦課情報().get調定年度(), 納期月コレクションマップ);
        }
        FukaJoho 賦課情報 = null;
        if (賦課の情報_更正後 != null) {
            賦課情報 = 賦課の情報_更正後.get賦課情報();
        }
        FlexibleYear 調定年度 = FlexibleYear.EMPTY;
        FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
        TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        if (賦課情報 != null) {
            if (賦課情報.get調定年度() != null) {
                調定年度 = 賦課情報.get調定年度();
            }
            if (賦課情報.get賦課年度() != null) {
                賦課年度 = 賦課情報.get賦課年度();
            }
            if (賦課情報.get通知書番号() != null) {
                通知書番号 = 賦課情報.get通知書番号();
            }
            if (賦課情報.get識別コード() != null) {
                識別コード = 賦課情報.get識別コード();
            }
        }
        List<SeikyuForPrinting> 請求情報リスト = create請求情報(収納科目, this.納期月コレクションマップ.get(調定年度),
                本算定通知書情報.get地方公共団体().getLasdecCode_().getColumnValue(), 賦課年度, 調定年度, 通知書番号, 識別コード,
                getOcrPatternOf(本算定通知書情報.get帳票ID()), 賦課の情報_更正後, get普徴期別金額リスト(賦課の情報_更正後),
                本算定通知書情報.get普徴納期情報リスト());
        NonyuTsuchiShoDataHenshu 納入通知書データ編集 = new NonyuTsuchiShoDataHenshu();
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = 納入通知書データ編集.create本算定納入通知書情報(
                本算定通知書情報,
                本算定納入通知書制御情報,
                請求情報リスト,
                収納科目,
                代納人氏名,
                出力期リスト,
                HenshuHaniKubun.全てのレイアウト);
        return 本算定納入通知書情報;
    }

    private List<UniversalPhase> get普徴期別金額リスト(FukaAtena 賦課の情報_更正後) {
        List<UniversalPhase> 普徴期別金額リスト = new ArrayList<>();
        if (賦課の情報_更正後 != null && 賦課の情報_更正後.get賦課情報() != null) {
            FukaJoho 賦課情報 = 賦課の情報_更正後.get賦課情報();
            int 期 = 期_1;
            while (期 <= 期_14) {
                普徴期別金額リスト.add(get普徴期別金額By期(期, 賦課情報));
                期++;
            }
        } else {
            int 期 = 期_1;
            while (期 <= 期_14) {
                普徴期別金額リスト.add(get普徴期別金額金額が0(期));
                期++;
            }
        }
        return 普徴期別金額リスト;
    }

    private UniversalPhase get普徴期別金額金額が0(int 期) {
        UniversalPhase 普徴期別金額 = new UniversalPhase();
        普徴期別金額.set期(期);
        普徴期別金額.set金額(Decimal.ZERO);
        return 普徴期別金額;
    }

    private UniversalPhase get普徴期別金額By期(int 期, FukaJoho 賦課情報) {
        UniversalPhase 普徴期別金額 = new UniversalPhase();
        普徴期別金額.set期(期);
        switch (期) {
            case 期_1:
                普徴期別金額.set金額(賦課情報.get普徴期別金額01());
                break;
            case 期_2:
                普徴期別金額.set金額(賦課情報.get普徴期別金額02());
                break;
            case 期_3:
                普徴期別金額.set金額(賦課情報.get普徴期別金額03());
                break;
            case 期_4:
                普徴期別金額.set金額(賦課情報.get普徴期別金額04());
                break;
            case 期_5:
                普徴期別金額.set金額(賦課情報.get普徴期別金額05());
                break;
            case 期_6:
                普徴期別金額.set金額(賦課情報.get普徴期別金額06());
                break;
            case 期_7:
                普徴期別金額.set金額(賦課情報.get普徴期別金額07());
                break;
            case 期_8:
                普徴期別金額.set金額(賦課情報.get普徴期別金額08());
                break;
            case 期_9:
                普徴期別金額.set金額(賦課情報.get普徴期別金額09());
                break;
            case 期_10:
                普徴期別金額.set金額(賦課情報.get普徴期別金額10());
                break;
            case 期_11:
                普徴期別金額.set金額(賦課情報.get普徴期別金額11());
                break;
            case 期_12:
                普徴期別金額.set金額(賦課情報.get普徴期別金額12());
                break;
            case 期_13:
                普徴期別金額.set金額(賦課情報.get普徴期別金額13());
                break;
            default:
                普徴期別金額.set金額(賦課情報.get普徴期別金額14());
                break;

        }
        return 普徴期別金額;
    }

    /**
     * 仮算定納入通知書情報を作成する。
     *
     * @param 仮算定通知書情報 仮算定通知書情報
     * @param 仮算定納入通知書制御情報 仮算定納入通知書制御情報
     * @param 出力期リスト 出力期リスト
     * @param 代納人氏名 代納人氏名
     * @return 仮算定納入通知書情報
     * @throws NullPointerException パラメータのいずれかがNullの場合。
     */
    public KariSanteiNonyuTsuchiShoJoho create仮算定納入通知書情報(
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報,
            List<Kitsuki> 出力期リスト,
            IName 代納人氏名) {
        requireNonNull(仮算定通知書情報, UrSystemErrorMessages.値がnull.getReplacedMessage("仮算定通知書情報"));
        requireNonNull(仮算定納入通知書制御情報, UrSystemErrorMessages.値がnull.getReplacedMessage("仮算定納入通知書制御情報"));
        requireNonNull(出力期リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("出力期リスト"));
        FukaAtena 賦課の情報_更正後 = 仮算定通知書情報.get賦課の情報_更正後();
        if (賦課の情報_更正後 != null && 賦課の情報_更正後.get賦課情報() != null
                && !this.納期月コレクションマップ.containsKey(賦課の情報_更正後.get賦課情報().get調定年度())) {
            NokitsukiManager nokitsukiManager = new NokitsukiManager();
            NokitsukiCollection 納期月コレクションマップ = nokitsukiManager.get納期月Collection(収納科目, Code.EMPTY,
                    new RYear(賦課の情報_更正後.get賦課情報().get調定年度().toDateString()), false);
            this.納期月コレクションマップ.put(賦課の情報_更正後.get賦課情報().get調定年度(), 納期月コレクションマップ);
        }
        FlexibleYear 調定年度 = FlexibleYear.EMPTY;
        FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
        TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        FukaJoho 賦課情報 = null;
        if (賦課の情報_更正後 != null) {
            賦課情報 = 賦課の情報_更正後.get賦課情報();
        }
        if (賦課情報 != null) {
            if (賦課情報.get調定年度() != null) {
                調定年度 = 賦課情報.get調定年度();
            }
            if (賦課情報.get賦課年度() != null) {
                賦課年度 = 賦課情報.get賦課年度();
            }
            if (賦課情報.get通知書番号() != null) {
                通知書番号 = 賦課情報.get通知書番号();
            }
            if (賦課情報.get識別コード() != null) {
                識別コード = 賦課情報.get識別コード();
            }
        }
        List<SeikyuForPrinting> 請求情報リスト = create請求情報(収納科目, this.納期月コレクションマップ.get(調定年度),
                仮算定通知書情報.get地方公共団体().getLasdecCode_().getColumnValue(), 賦課年度,
                調定年度, 通知書番号, 識別コード, getOcrPatternOf(仮算定通知書情報.get帳票ID()), 賦課の情報_更正後,
                get普徴期別金額リスト(賦課の情報_更正後), 仮算定通知書情報.get普徴納期情報リスト());
        NonyuTsuchiShoDataHenshu 納入通知書データ編集 = new NonyuTsuchiShoDataHenshu();
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = 納入通知書データ編集.create仮算定納入通知書情報(
                仮算定通知書情報,
                仮算定納入通知書制御情報,
                請求情報リスト,
                収納科目,
                代納人氏名,
                出力期リスト,
                HenshuHaniKubun.全てのレイアウト);
        return 仮算定納入通知書情報;
    }

    /**
     * 請求情報取得作成する。
     *
     * @param 収納科目 収納科目
     * @param 納期月リスト 納期月リスト
     * @param 賦課年度 賦課年度
     * @param 調定年度 調定年度
     * @param 通知書番号 通知書番号
     * @param 地方公共団体コード 地方公共団体コード
     * @param 納付書タイプ 納付書タイプ
     * @param 識別コード 識別コード
     * @param 賦課の情報 賦課の情報
     * @param 普徴期別金額リスト 普徴期別金額リスト
     * @param 普徴納期情報リスト 普徴納期情報リスト
     * @return 請求情報リスト
     */
    public List<SeikyuForPrinting> create請求情報(IShunoKamoku 収納科目, NokitsukiCollection 納期月リスト, RString 地方公共団体コード,
            FlexibleYear 賦課年度, FlexibleYear 調定年度, TsuchishoNo 通知書番号, ShikibetsuCode 識別コード, OcrPattern 納付書タイプ,
            FukaAtena 賦課の情報, List<UniversalPhase> 普徴期別金額リスト, List<NokiJoho> 普徴納期情報リスト) {
        List<SeikyuForPrinting> 請求情報リスト = new ArrayList<>();
        for (NokiJoho 納期情報 : 普徴納期情報リスト) {
            int 期 = 納期情報.get期月().get期AsInt();
            ShunoKanri.Builder builder = ShunoKanri.newBuilder();
            builder.setKamokuCode(収納科目.getコード());
            builder.setKamokuEdabanCode(収納科目.get枝番コード());
            builder.setChoteiNendo(new RYear(調定年度.toDateString()));
            builder.setKazeiNendo(new RYear(賦課年度.toDateString()));
            builder.setTsuchishoNo(new jp.co.ndensan.reams.ur.urc.definition.core.shuno.tsuchishono.TsuchishoNo(
                    new Decimal(通知書番号.getColumnValue().toString())));
            builder.setShikibetsuCode(識別コード);
            builder.setJigyoKubunCode(JigyoKubun.未使用);
            builder.setChoshukenUmu(true);
            builder.setKibetsu(期);
            FukaJoho 賦課情報 = 賦課の情報.get賦課情報();
            if (賦課情報 != null) {
                List<Kibetsu> kibetsuList = 賦課情報.getKibetsuList();
                if (!is該当期ある(期, kibetsuList)) {
                    continue;
                }
                Long 収納ID = get収納IDBy期(期, 賦課情報);
                builder.setShunoId(収納ID);
            } else {
                builder.setShunoId(Long.MIN_VALUE);
            }
            ShunoKanri shunoKanri = builder.build();
            ShunoKey 収納キー = new ShunoKey(shunoKanri, 収納科目, 納期月リスト.get納期月From期(期));
            Decimal 普徴期別金額 = get金額By期(普徴期別金額リスト, 期);
            SeikyuItemMeisai 請求明細 = new SeikyuItemMeisai(
                    収納キー, 普徴期別金額, Decimal.ZERO, Decimal.ZERO, Decimal.ZERO, Collections.EMPTY_LIST, 納期情報.get納期().get納期限());
            List<SeikyuItemMeisai> 請求明細リスト = new ArrayList<>();
            請求明細リスト.add(請求明細);
            SeikyuItem 編集元情報 = new SeikyuItem(地方公共団体コード, SeikyushoType.納付書, new RYear(調定年度.toDateString()),
                    納期情報.get納期().get通知書発行日(), 識別コード, 納期情報.get納期().get納期限(), null,
                    ToriatsukaiKigenCheckKubun.発行日を取扱期限とする, false, RString.EMPTY, false,
                    0, FukusuKibetsuShuyakuKamoku.複数科目を集約しない, FukusuKibetsuShuyakuNendo.年度毎に集約する, 請求明細リスト,
                    納期情報.get納期().get現年過年区分(), null, null);
            SeikyuManager seikyuManager = new SeikyuManager();
            if (納付書タイプ != null && 編集元情報 != null) {
                List<SeikyuForPrinting> 請求情報リスト1 = seikyuManager.get印字用請求情報(SubGyomuCode.DBB介護賦課, 納付書タイプ, 編集元情報);
                請求情報リスト.addAll(請求情報リスト1);
            }
        }
        return 請求情報リスト;
    }

    private boolean is該当期ある(int 期, List<Kibetsu> kibetsuList) {
        for (Kibetsu kibetsu : kibetsuList) {
            if (kibetsu.get期() == 期) {
                return true;
            }
        }
        return false;
    }

    private Long get収納IDBy期(int 期, FukaJoho 賦課情報) {
        if (期 == 期_1) {
            return 賦課情報.get収納ID01();
        } else if (期 == 期_2) {
            return 賦課情報.get収納ID02();
        } else if (期 == 期_3) {
            return 賦課情報.get収納ID03();
        } else if (期 == 期_4) {
            return 賦課情報.get収納ID04();
        } else if (期 == 期_5) {
            return 賦課情報.get収納ID05();
        } else if (期 == 期_6) {
            return 賦課情報.get収納ID06();
        } else if (期 == 期_7) {
            return 賦課情報.get収納ID07();
        } else if (期 == 期_8) {
            return 賦課情報.get収納ID08();
        } else if (期 == 期_9) {
            return 賦課情報.get収納ID09();
        } else if (期 == 期_10) {
            return 賦課情報.get収納ID10();
        } else if (期 == 期_11) {
            return 賦課情報.get収納ID11();
        } else if (期 == 期_12) {
            return 賦課情報.get収納ID12();
        } else if (期 == 期_13) {
            return 賦課情報.get収納ID13();
        } else if (期 == 期_14) {
            return 賦課情報.get収納ID14();
        }
        return null;
    }

    private Decimal get金額By期(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (期 == 普徴期別金額.get期()) {
                return null == 普徴期別金額.get金額() ? Decimal.ZERO : 普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    /**
     * 帳票IDからOcrPatternを判定する。
     *
     * @param 帳票ID 帳票ID
     * @return OcrPattern
     */
    public OcrPattern getOcrPatternOf(ReportId 帳票ID) {
        if (null == パターンOCR) {
            パターンOCR = new HashMap<>();
        }
        if (パターンOCR.isEmpty()) {
            パターンOCR.put(new ReportId("DBB100045_HokenryoNonyuTsuchishoKigoto"), OcrPattern.期別納付書_OCRID300);
            パターンOCR.put(new ReportId("DBB100046_HokenryoNonyuTsuchishoKigotoRencho"), OcrPattern.期別納付書_OCRID300);
            パターンOCR.put(new ReportId("DBB100053_HokenryoNonyuTsuchishoGinfuriFiveKi"), OcrPattern.期別納付書_OCRID300);
            パターンOCR.put(new ReportId("DBB100054_HokenryoNonyuTsuchishoGinfuriFiveKiRencho"), OcrPattern.期別納付書_OCRID300);
            パターンOCR.put(new ReportId("DBB100051_HokenryoNonyuTsuchishoGinfuriFourKi"), OcrPattern.期別納付書_OCRID300);
            パターンOCR.put(new ReportId("DBB100052_HokenryoNonyuTsuchishoGinfuriFourKiRencho"), OcrPattern.期別納付書_OCRID300);
            パターンOCR.put(new ReportId("DBB100056_HokenryoNonyuTsuchishoBookFuriKaeNashi"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            パターンOCR.put(new ReportId("DBB100058_HokenryoNonyuTsuchishoBookFuriKaeNashiRencho"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            パターンOCR.put(new ReportId("DBB100055_NonyuTsuchishoBookFuriKaeAri"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            パターンOCR.put(new ReportId("DBB100057_NonyuTsuchishoBookFuriKaeAriRencho"), OcrPattern.期別納付書_ブックタイプ_OCRID318);
            パターンOCR.put(new ReportId("DBB100061_NonyuTsuchishoCVSMulti"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            パターンOCR.put(new ReportId("DBB100062_NonyuTsuchishoCVSMultiRencho"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            パターンOCR.put(new ReportId("DBB100063_NonyuTsuchishoCVSKigoto"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            パターンOCR.put(new ReportId("DBB100064_NonyuTsuchishoCVSKigotoRencho"), OcrPattern.マルペイ納付書_手書き_OCRID378);
            パターンOCR.put(new ReportId("DBB100059_NonyuTsuchishoCVSKakuko"), OcrPattern.マルペイ納付書_ＭＴ_OCRID375);
            パターンOCR.put(new ReportId("DBB100060_NonyuTsuchishoCVSKakukoRencho"), OcrPattern.マルペイ納付書_ＭＴ_OCRID375);
        }
        return パターンOCR.get(帳票ID);
    }
}
