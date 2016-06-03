/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳Editorです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoEditor implements IHihokenshaDaichoEditor {

    private final HihokenshaDaichoSakusei joho;
    private static final RString FOMART_TEN = new RString(".");
    private static final RString FOMART_LINE = new RString("/");
    private static final int ZERO = 0;

    /**
     * コンストラクタです。
     *
     * @param joho 被保険者台帳リストです
     */
    public HihokenshaDaichoEditor(HihokenshaDaichoSakusei joho) {
        this.joho = joho;
    }

    /**
     * 被保険者台帳ReportSourceを作成します。
     *
     * @param source 被保険者台帳ReportSource
     * @return 被保険者台帳ReportSource
     */
    @Override
    public HihokenshaDaichoReportSource edit(HihokenshaDaichoReportSource source) {
        return editBody(source);
    }

    private HihokenshaDaichoReportSource editBody(HihokenshaDaichoReportSource source) {
        source.printTimeStamp = joho.get印刷日時();
        source.title = joho.getタイトル();
        source.shichosonCode = joho.get市町村コード() == null ? RString.EMPTY : joho.get市町村コード().value();
        source.shichosonName = joho.get市町村名称();
        source.hihokenshaNoTitle = joho.get被保険者番号タイトル();
        source.hihokenshaNo = joho.get被保険者番号() == null ? RString.EMPTY : joho.get被保険者番号().value();
        source.shimeiKana = joho.get氏名カナ() == null ? RString.EMPTY : joho.get氏名カナ().value();
        source.birthYMD = joho.get生年月日();
        source.seibetsu = joho.get性別();
        source.setaiCode = joho.get世帯コード() == null ? RString.EMPTY : joho.get世帯コード().value();
        source.shikibetsuCode = joho.get識別コード() == null ? RString.EMPTY : joho.get識別コード().value();
        source.shimei = joho.get氏名() == null ? RString.EMPTY : joho.get氏名().value();
        source.chiku1CodeTitle = joho.get地区タイトル1();
        source.chiku1Code = joho.get地区コード1() == null ? RString.EMPTY : joho.get地区コード1().value();
        source.jotai = joho.get状態();
        source.telNoTitle = joho.get電話番号タイトル();
        source.jusho = joho.get住所();
        source.chiku2CodeTitle = joho.get地区タイトル2();
        source.chiku2Code = joho.get地区コード2() == null ? RString.EMPTY : joho.get地区コード2().value();
        source.telNo1 = joho.get電話番号１();
        source.jushoTitle = joho.get住所タイトル();
        source.telNo2 = joho.get電話番号２();
        source.chiku3CodeTitle = joho.get地区タイトル3();
        source.chiku3Code = joho.get地区コード3() == null ? RString.EMPTY : joho.get地区コード3().value();
        source.gyoseikuCode = joho.get行政区コード() == null ? RString.EMPTY : joho.get行政区コード().value();
        source.gyoseikuTitle = joho.get行政区タイトル();
        source.jushoCode = joho.get住所コード() == null ? RString.EMPTY : joho.get住所コード();
        source.jigyoshaNo = joho.get事業者番号();
        source.jigyoshaName = joho.get事業者名称() == null ? RString.EMPTY : joho.get事業者名称().value();
        source.kigoNo = joho.get記号番号();
        source.iryohokenShubetsu = joho.get医療保険種別();
        source.iryohokenshaName = joho.get医療保険者名称();
        source.sochiHokensha = joho.get措置保険者タイトル();
        source.kyuHokensha = joho.get旧保険者タイトル();
        source.junno = joho.get順番号();
        source.setaiinShimei1 = joho.get世帯氏名1();
        source.setaiinShimei2 = joho.get世帯氏名2();
        source.setaiinShimei3 = joho.get世帯氏名3();
        source.setaiinShimei4 = joho.get世帯氏名4();
        source.setaiinShimei5 = joho.get世帯氏名5();
        return source;
    }

    /**
     * 日付型はFlexibleDateをRStringに変換します。
     *
     * @param dateList 変換前 yyyyMMdd
     * @param index 指定Index
     *
     * @return 変換後 yyyy/MM/dd
     */
    public static RString dataFomart(List<FlexibleDate> dateList, int index) {
        if (dateList.isEmpty()) {
            return RString.EMPTY;
        }
        FlexibleDate date = dateList.get(index);
        RString fomartDate = RString.EMPTY;
        if (date != null) {
            fomartDate = date.seireki().toDateString().replace(FOMART_TEN, FOMART_LINE);
        }
        return fomartDate;
    }

    /**
     * リスト項目の指定Index項を取得します。
     *
     * @param list リスト項目
     * @param index 指定Index
     * @return リスト項目の指定Index項
     */
    public static RString getIndexValue(List<RString> list, int index) {
        if (list == null || list.isEmpty()) {
            return RString.EMPTY;
        }
        return list.get(index);
    }

    /**
     * リストサイズを取得します。
     *
     * @param list リスト項目
     * @return サイズ
     */
    public static int getMaxIndex(List<RString> list) {

        if (list == null || list.isEmpty()) {
            return ZERO;
        }
        return list.size();
    }
}
