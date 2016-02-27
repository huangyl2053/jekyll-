/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_4期 HokenryoNonyuTsuchishoGinfuriFourKiEditor
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiEditor implements IHokenryoNonyuTsuchishoGinfuriFourKiEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HokenryoNonyuTsuchishoGinfuriItem}
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     */
    protected HokenryoNonyuTsuchishoGinfuriFourKiEditor(
            HokenryoNonyuTsuchishoGinfuriItem item,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        this.本算定納入通知書情報 = null == item.get本算定納入通知書情報() ? new HonSanteiNonyuTsuchiShoJoho() : item.get本算定納入通知書情報();
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
    }

    @Override
    public HokenryoNonyuTsuchishoGinfuriFourKiSource edit(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        editレイヤ１(source);
        return source;
    }

    private void editレイヤ１(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = 編集後本算定通知書共通情報.get更正後();
        if (null == 更正後) {
            更正後 = new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection();
        }
        source.titleKanendo = RString.EMPTY;
        source.titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.santeiKisoKikanKaishi = 更正後.get期間_自();
        HyojiCodes 表示コード = 編集後本算定通知書共通情報.get表示コード();
        if (null == 表示コード) {
            表示コード = new HyojiCodes();
        }
        List<Kitsuki> 出力期リスト = 本算定納入通知書情報.get出力期リスト();
        Kitsuki 出力期リストの一番目 = get出力期By番目(出力期リスト, 0);
        Kitsuki 出力期リストの二番目 = get出力期By番目(出力期リスト, 1);
        source.HyojicodeName1 = 表示コード.get表示コード名１();
        source.HyojicodeName2 = 表示コード.get表示コード名２();
        source.HyojicodeName3 = 表示コード.get表示コード名３();
        source.santeiKisoKiaknShuryo = 更正後.get期間_至();
        source.titleKanendoBun = RString.EMPTY;
        source.Hyojicode2 = 表示コード.get表示コード１();
        source.Hyojicode3 = 表示コード.get表示コード２();
        source.Hyojicode1 = 表示コード.get表示コード３();
        source.santeiKisoNokisu = RStringUtil.convert半角to全角(更正後.get月数_ケ月());
        source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().getColumnValue();

        //編集後個人
        source.setaiCode = null;

        source.santeiKisoShotokuDankai = RStringUtil.convert半角to全角(更正後.get保険料段階());

        //編集後個人
        source.hihokenshaName = null;

        source.santeiKisoHokenryoRitsu = new RString(更正後.get保険料率().toString());

        //編集後個人
        source.setaiNushiName = null;

        source.santeiKisoCalHokenryoGaku = new RString(更正後.get確定保険料_年額().toString());
        source.nendoKa = RString.EMPTY;
        source.nendo1 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.hokenryoGaku = new RString(更正後.get確定保険料_年額().toString());
        source.santeiKisoGenmenGaku = new RString(更正後.get減免額().toString());
        source.santeiKisoTokuchoNofuSubekiGaku = new RString(更正後.get特別徴収額合計().toString());
        source.santeiKisoFuchoNofuSubekiGaku = new RString(更正後.get普通徴収額合計().toString());
        boolean is納付額算出方法が1 = is納付額算出方法が1();
        source.santeiKisoNofuzumiGaku = new RString(is納付額算出方法が1
                ? 編集後本算定通知書共通情報.get普徴納付済額_未到来期含む().toString()
                : 編集後本算定通知書共通情報.get普徴既に納付すべき額().toString());
        source.santeiKisoKongoNofuSubekiGaku = new RString(is納付額算出方法が1
                ? 編集後本算定通知書共通情報.get普徴今後納付すべき額_収入元に().toString()
                : 編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に().toString());
        source.santeiKisoKomokuTitle1 = new RString("第").concat(出力期リストの一番目.get期()).concat("期");
        source.santeiKisoKomokuTitle3 = null == 出力期リストの二番目 ? RString.EMPTY : new RString("次期以降");
        List<UniversalPhase> 普徴期別金額リスト = 更正後.get普徴期別金額リスト();
        source.santeiKisoTokiHokenryoGaku1 = new RString(get金額By期(普徴期別金額リスト, 出力期リストの一番目.get期AsInt()).toString());
        source.santeiKisoJikiHokenryoGaku1 = null == 出力期リストの二番目
                ? RString.EMPTY : new RString(get金額By期(普徴期別金額リスト, 出力期リストの二番目.get期AsInt()).toString());
        source.santeiKisoKomokuTitle2 = RString.EMPTY;
        source.santeiKisoYen1 = new RString("円");
        source.santeiKisoKomokuTitle4 = RString.EMPTY;
        source.santeiKisoYen2 = new RString("円");
        source.santeiKisoTokiHokenryoGaku2 = RString.EMPTY;
        source.santeiKisoJikiHokenryoGaku2 = RString.EMPTY;
        source.gekihenTitle = RString.EMPTY;
        source.gekihenMongon = RString.EMPTY;
        source.ryoshushoKanendo = RString.EMPTY;
        source.ryoshushoNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.ryoshushoKanendoBun = RString.EMPTY;
        NonyuTsuchiShoKiJoho 一番目の納入通知書期情報 = get納入通知書期情報By番目(0);
        NonyuTsuchiShoKiJoho 二番目の納入通知書期情報 = get納入通知書期情報By番目(1);
        //NonyuTsuchiShoKiJoho 三番目の納入通知書期情報 = get納入通知書期情報By番目(2);
        NonyuTsuchiShoKiJoho 銀振印字位置が1の納入通知書期情報 = get納入通知書期情報By銀振印字位置(1);
        boolean is一番目の納入通知書期情報がある = is納入通知書期情報がある(一番目の納入通知書期情報);
        boolean is二番目の納入通知書期情報がある = is納入通知書期情報がある(二番目の納入通知書期情報);
        //boolean is三番目の納入通知書期情報がある = is納入通知書期情報がある(三番目の納入通知書期情報);
        boolean is銀振印字位置が1の納入通知書期情報がある = is納入通知書期情報がある(銀振印字位置が1の納入通知書期情報);
        source.ryoshushoNofuGaku1 = is銀振印字位置が1の納入通知書期情報がある
                ? new RString("**********") : 銀振印字位置が1の納入通知書期情報.get領収証書納付額欄();
        source.ki1 = is一番目の納入通知書期情報がある ? RString.EMPTY : 一番目の納入通知書期情報.get期表記();
        source.nokiKaishi1 = is一番目の納入通知書期情報がある ? RString.EMPTY : 一番目の納入通知書期情報.get納期開始日表記();
        source.ryoshushoNofuin1 = is一番目の納入通知書期情報がある ? new RString("**") : 銀振印字位置が1の納入通知書期情報.get領収日付印欄();
        source.tsuki1 = is一番目の納入通知書期情報がある ? RString.EMPTY : 一番目の納入通知書期情報.get月表記();
        source.nokiShuryo1 = is一番目の納入通知書期情報がある ? RString.EMPTY : 一番目の納入通知書期情報.get納期終了日表記();
        source.ryoshushoRyoshuHizukein1 = is銀振印字位置が1の納入通知書期情報がある
                ? RString.EMPTY : 銀振印字位置が1の納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoKi1 = is銀振印字位置が1の納入通知書期情報がある ? new RString("**") : 銀振印字位置が1の納入通知書期情報.get領収書日付欄期月();
        source.ki2 = get納入通知書期情報(is二番目の納入通知書期情報がある, 二番目の納入通知書期情報.get期表記());
        source.nokiKaishi2 = get納入通知書期情報(is二番目の納入通知書期情報がある, 二番目の納入通知書期情報.get納期開始日表記());
        source.ryoshushoZuiji1 = get納入通知書期情報(is銀振印字位置が1の納入通知書期情報がある, 銀振印字位置が1の納入通知書期情報.get随時表記());
        source.tsuki2 = get納入通知書期情報(is二番目の納入通知書期情報がある, 二番目の納入通知書期情報.get月表記());
        source.nokiShuryo2 = get納入通知書期情報(is二番目の納入通知書期情報がある, 二番目の納入通知書期情報.get納期終了日表記());
    }

    private RString get納入通知書期情報(boolean is通知書期情報がある, RString 通知書期情報) {
        if (is通知書期情報がある) {
            return 通知書期情報;
        }
        return RString.EMPTY;
    }

    private boolean is納入通知書期情報がある(NonyuTsuchiShoKiJoho 納入通知書期情報) {
        return !(null == 納入通知書期情報);
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報By番目(int 番目) {
        if (!納入通知書期情報リスト.isEmpty() && 納入通知書期情報リスト.size() >= 番目 + 1) {
            return 納入通知書期情報リスト.get(番目);
        }
        return null;
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報By銀振印字位置(int 銀振印字位置) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (銀振印字位置 == 納入通知書期情報.get銀振印字位置()) {
                return 納入通知書期情報;
            }
        }
        return null;
    }

    private Decimal get金額By期(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (普徴期別金額.get期() == 期) {
                return 普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    private Kitsuki get出力期By番目(List<Kitsuki> 出力期リスト, int 番目) {
        if (!出力期リスト.isEmpty() && 出力期リスト.size() >= 番目 + 1) {
            return 出力期リスト.get(番目);
        }
        return null;
    }

    private boolean is納付額算出方法が1() {
        return NofugakuSanshutsuHoho.収入額をもとに算出
                .equals(本算定納入通知書情報.get本算定納入通知書制御情報().get納入通知書制御情報().get納付額算出方法());
    }

}
