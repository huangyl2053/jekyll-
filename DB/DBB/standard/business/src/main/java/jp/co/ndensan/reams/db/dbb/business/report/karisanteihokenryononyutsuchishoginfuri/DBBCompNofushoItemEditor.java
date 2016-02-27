/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】DBBCompNofushoItemEditor
 */
public class DBBCompNofushoItemEditor implements IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor {

    private final NofuShoKyotsu 納付書共通;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    private final ShoriKubun 処理区分;

    /**
     * インスタンスを生成します。
     *
     * @param 納付書共通
     * @param 納入通知書期情報リスト
     * @param 処理区分
     * @param 連番
     */
    protected DBBCompNofushoItemEditor(NofuShoKyotsu 納付書共通, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト, int 連番, ShoriKubun 処理区分) {
        this.納付書共通 = 納付書共通;
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.連番 = 連番;
        this.処理区分 = 処理区分;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriSource edit(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.nofushoKanendo3 = RString.EMPTY;
        source.nofushoNendo4
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(4) ? 納付書共通.get調定年度表記() : new RString("******"));
        source.nofushoKanendo2 = RString.EMPTY;
        source.nofushoKanendo1 = RString.EMPTY;
        source.nofushoKanendo4 = RString.EMPTY;
        source.nofushoNendo3
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(3) ? 納付書共通.get調定年度表記() : new RString("******"));
        source.nofushoNendo2
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(2) ? 納付書共通.get調定年度表記() : new RString("******"));
        source.nofushoNendo1
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(1) ? 納付書共通.get調定年度表記() : new RString("******"));
        source.nofushoKanendobun2 = RString.EMPTY;
        source.nofushoKanendobun3 = RString.EMPTY;
        source.nofushoKanendobun4 = RString.EMPTY;
        source.nofushoKanendobun1 = RString.EMPTY;
        edit納入通知書期情報(source);
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName2 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName3 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName4 = 納付書共通.get納付者氏名();
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName2 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName3 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName4 = 納付書共通.get被代納人氏名();
        source.nofushoKakko11 = RString.isNullOrEmpty(source.nofushoHonninName1) ? RString.EMPTY : new RString("(");
        source.nofushoKakko12 = RString.isNullOrEmpty(source.nofushoHonninName2) ? RString.EMPTY : new RString("(");
        source.nofushoKakko13 = RString.isNullOrEmpty(source.nofushoHonninName3) ? RString.EMPTY : new RString("(");
        source.nofushoKakko14 = RString.isNullOrEmpty(source.nofushoHonninName4) ? RString.EMPTY : new RString("(");
        source.nofushoKakko21 = RString.EMPTY;
        source.nofushoKakko31 = RString.isNullOrEmpty(source.nofushoHonninName1) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko22 = RString.EMPTY;
        source.nofushoKakko32 = RString.isNullOrEmpty(source.nofushoHonninName2) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko23 = RString.EMPTY;
        source.nofushoKakko33 = RString.isNullOrEmpty(source.nofushoHonninName3) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko24 = RString.EMPTY;
        source.nofushoKakko34 = RString.isNullOrEmpty(source.nofushoHonninName4) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushohyojicodeName11 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode11 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName12 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode12 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName13 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode13 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName14 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode14 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName21 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode21 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName22 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode22 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName23 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode23 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName24 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode24 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName31 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode31 = 納付書共通.get表示コード().get表示コード３();
        source.nofushohyojicodeName32 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode32 = 納付書共通.get表示コード().get表示コード３();
        source.nofushohyojicodeName33 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode33 = 納付書共通.get表示コード().get表示コード３();
        source.nofushohyojicodeName34 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode34 = 納付書共通.get表示コード().get表示コード３();
        editMRenban(source);
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei12 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei13 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei14 = 納付書共通.get納付書市町村名();
        return source;
    }

    private void editMRenban(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(処理区分)) {
            連番.padLeft(連番, 6);
        }
        source.mRenban = 連番;
    }

    private boolean is銀振印字位置の納入通知書期情報がある(int 銀振印字位置) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (銀振印字位置 == 納入通知書期情報.get銀振印字位置()) {
                return true;
            }
        }
        return false;
    }

    private void edit納入通知書期情報(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        boolean 納入通知書期情報1有無 = false;
        boolean 納入通知書期情報2有無 = false;
        boolean 納入通知書期情報3有無 = false;
        boolean 納入通知書期情報4有無 = false;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            switch (銀振印字位置) {
                case 1:
                    source.nofushoKi1 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki1 = 納入通知書期情報.get月表記();
                    source.nofushoOcr11 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr21 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr31 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr41 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku1 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen1 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin1 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein1 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji1 = 納入通知書期情報.get随時表記();
                    納入通知書期情報1有無 = true;
                    break;
                case 2:
                    source.nofushoKi2 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki2 = 納入通知書期情報.get月表記();
                    source.nofushoOcr12 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr22 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr32 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr42 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku2 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen2 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin2 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein2 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji2 = 納入通知書期情報.get随時表記();
                    納入通知書期情報2有無 = true;
                    break;
                case 3:
                    source.nofushoKi3 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki3 = 納入通知書期情報.get月表記();
                    source.nofushoOcr13 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr23 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr33 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr43 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku3 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen3 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin3 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein3 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji3 = 納入通知書期情報.get随時表記();
                    納入通知書期情報3有無 = true;
                    break;
                case 4:
                    source.nofushoKi4 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki4 = 納入通知書期情報.get月表記();
                    source.nofushoOcr14 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr24 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr34 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr44 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku4 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen4 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin4 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein4 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji4 = 納入通知書期情報.get随時表記();
                    納入通知書期情報4有無 = true;
                    break;
                default:
                    break;
            }
        }
        if (!納入通知書期情報1有無) {
            source.nofushoKi1 = new RString("**");
            source.nofushoTsuki1 = new RString("**");
            source.nofushoOcr11 = new RString("******");
            source.nofushoOcr21 = new RString("****************");
            source.nofushoOcr31 = new RString("*****************");
            source.nofushoOcr41 = new RString("************");
            source.nofushoNofugaku1 = new RString("**********");
            source.nofushoNokigen1 = new RString("***********");
            source.nofushoNofuin1 = new RString("**");
            source.nofushoRyoshuHizukein1 = RString.EMPTY;
            source.nofushoZuiji1 = RString.EMPTY;
        }
        if (!納入通知書期情報2有無) {
            source.nofushoKi2 = new RString("**");
            source.nofushoTsuki2 = new RString("**");
            source.nofushoOcr12 = new RString("******");
            source.nofushoOcr22 = new RString("****************");
            source.nofushoOcr32 = new RString("*****************");
            source.nofushoOcr42 = new RString("************");
            source.nofushoNofugaku2 = new RString("**********");
            source.nofushoNokigen2 = new RString("***********");
            source.nofushoNofuin2 = new RString("**");
            source.nofushoRyoshuHizukein2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
        }
        if (!納入通知書期情報3有無) {
            source.nofushoKi3 = new RString("**");
            source.nofushoTsuki3 = new RString("**");
            source.nofushoOcr13 = new RString("******");
            source.nofushoOcr23 = new RString("****************");
            source.nofushoOcr33 = new RString("*****************");
            source.nofushoOcr43 = new RString("************");
            source.nofushoNofugaku3 = new RString("**********");
            source.nofushoNokigen3 = new RString("***********");
            source.nofushoNofuin3 = new RString("**");
            source.nofushoRyoshuHizukein3 = RString.EMPTY;
            source.nofushoZuiji3 = RString.EMPTY;
        }
        if (!納入通知書期情報4有無) {
            source.nofushoKi4 = new RString("**");
            source.nofushoTsuki4 = new RString("**");
            source.nofushoOcr14 = new RString("******");
            source.nofushoOcr24 = new RString("****************");
            source.nofushoOcr34 = new RString("*****************");
            source.nofushoOcr44 = new RString("************");
            source.nofushoNofugaku4 = new RString("**********");
            source.nofushoNokigen4 = new RString("***********");
            source.nofushoNofuin4 = new RString("**");
            source.nofushoRyoshuHizukein4 = RString.EMPTY;
            source.nofushoZuiji4 = RString.EMPTY;
        }
    }

}
