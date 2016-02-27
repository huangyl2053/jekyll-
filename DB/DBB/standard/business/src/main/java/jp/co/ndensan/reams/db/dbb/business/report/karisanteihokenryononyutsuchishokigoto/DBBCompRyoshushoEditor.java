/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】DBBCompRyoshushoEditor
 */
public class DBBCompRyoshushoEditor implements IKarisanteiHokenryoNonyuTsuchishoKigotoEditor {

    private final NofuShoKyotsu 納付書共通;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final RString 領収書連番;

    /**
     * インスタンスを生成します。
     *
     * @param 納付書共通
     * @param 領収書連番
     * @param 納入通知書期情報
     */
    protected DBBCompRyoshushoEditor(NofuShoKyotsu 納付書共通, NonyuTsuchiShoKiJoho 納入通知書期情報, int 領収書連番) {
        this.納付書共通 = 納付書共通;
        this.納入通知書期情報 = 納入通知書期情報;
        this.領収書連番 = new RString(String.valueOf(領収書連番));
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoKigotoSource edit(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        editRyoshushoGyoseikuName(source);
        editRyoshushoHonninName(source);
        editRyoshushoJusho(source);
        editRyoshushoKakko1(source);
        editRyoshushoKakko2(source);
        editRyoshushoKakko3(source);
        editRyoshushoKanendo(source);
        editRyoshushoKanendobun(source);
        editRyoshushoKatagaki(source);
        editRyoshushoKi(source);
        editRyoshushoNendo(source);
        editRyoshushoNofugaku(source);
        editRyoshushoNofuin(source);
        editRyoshushoNokigen(source);
        editRyoshushoRenban(source);
        editRyoshushoRyoshuHizukein(source);
        editRyoshushoSetaiCode(source);
        editRyoshushoShichosonMei1(source);
        editRyoshushoShichosonMei2(source);
        editRyoshushoSofusakiName(source);
        editRyoshushoTsuchishoNo(source);
        editRyoshushoTsuki(source);
        editRyoshushoYubinNo(source);
        editRyoshushoZuiji(source);
        editRyoshushohyojicode1(source);
        editRyoshushohyojicode2(source);
        editRyoshushohyojicode3(source);
        editRyoshushohyojicodeName1(source);
        editRyoshushohyojicodeName2(source);
        editRyoshushohyojicodeName3(source);
        return source;
    }

    private void editRyoshushoKanendo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKanendo = RString.EMPTY;
    }

    private void editRyoshushoNendo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
    }

    private void editRyoshushoKanendobun(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKanendobun = RString.EMPTY;
    }

    private void editRyoshushoKi(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKi = 納入通知書期情報.get期表記();
    }

    private void editRyoshushoTsuki(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
    }

    private void editRyoshushoYubinNo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoYubinNo = 納付書共通.get郵便番号();
    }

    private void editRyoshushoGyoseikuName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
    }

    private void editRyoshushoJusho(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoJusho = 納付書共通.get住所();
    }

    private void editRyoshushoKatagaki(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKatagaki = 納付書共通.get方書();
    }

    private void editRyoshushoSofusakiName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
    }

    private void editRyoshushoKakko1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKakko1 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : new RString("(");
    }

    private void editRyoshushoHonninName(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoHonninName = 納付書共通.get被代納人氏名();
    }

    private void editRyoshushoKakko2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKakko2 = RString.EMPTY;
    }

    private void editRyoshushoKakko3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKakko3
                = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
    }

    private void editRyoshushoTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
    }

    private void editRyoshushoSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
    }

    private void editRyoshushohyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushohyojicodeName1 = null;//TODO 納付書共通.表示コード.表示コード名１
    }

    private void editRyoshushohyojicode1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushohyojicode1 = null;//TODO 納付書共通.表示コード.表示コード１
    }

    private void editRyoshushohyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushohyojicodeName2 = null;//TODO 納付書共通.表示コード.表示コード名2
    }

    private void editRyoshushohyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushohyojicode2 = null;//TODO 納付書共通.表示コード.表示コード2
    }

    private void editRyoshushohyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushohyojicodeName3 = null;//TODO 納付書共通.表示コード.表示コード名3
    }

    private void editRyoshushohyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushohyojicode1 = null;//TODO 納付書共通.表示コード.表示コード3
    }

    private void editRyoshushoNokigen(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
    }

    private void editRyoshushoNofugaku(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
    }

    private void editRyoshushoNofuin(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
    }

    private void editRyoshushoRyoshuHizukein(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
    }

    private void editRyoshushoZuiji(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoZuiji = 納入通知書期情報.get随時表記();
    }

    private void editRyoshushoRenban(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoRenban = 領収書連番;
    }

    private void editRyoshushoShichosonMei1(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
    }

    private void editRyoshushoShichosonMei2(KarisanteiHokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoShichosonMei2 = RString.EMPTY;
    }

}
