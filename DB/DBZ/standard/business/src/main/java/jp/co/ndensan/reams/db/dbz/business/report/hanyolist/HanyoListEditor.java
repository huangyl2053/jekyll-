/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.hanyolist;

import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hanyolist.HanyoListEntity;
import jp.co.ndensan.reams.db.dbz.entity.report.hanyolist.HanyoListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 汎用リストのEditorです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
public class HanyoListEditor implements IHanyoListEditor {

    private final HanyoListEntity hanyolistentity;
    private final RString 表題;
    private final RString データ種別;
    private final RString 項目見出し;
    private final RString 項目内容;
    private final Association 地方公共団体;
    private final IOutputOrder outputOrder;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param hanyolistentity hanyolistentity
     * @param 表題 表題
     * @param データ種別 データ種別
     * @param 項目見出し 項目見出し
     * @param 項目内容 項目内容
     * @param 地方公共団体 地方公共団体
     * @param outputOrder outputOrder
     */
    protected HanyoListEditor(HanyoListEntity hanyolistentity, RString 表題, RString データ種別, RString 項目見出し,
            RString 項目内容, Association 地方公共団体, IOutputOrder outputOrder) {
        this.表題 = 表題;
        this.データ種別 = データ種別;
        this.項目見出し = 項目見出し;
        this.項目内容 = 項目内容;
        this.地方公共団体 = 地方公共団体;
        this.outputOrder = outputOrder;
        this.hanyolistentity = hanyolistentity;
    }

    /**
     * 汎用リストEditorです。
     *
     * @param source HanyoListReportSource
     * @return HanyoListReportSource
     */
    @Override
    public HanyoListReportSource edit(HanyoListReportSource source) {
        setHeader(source);
        set出力内容(source);
        return source;
    }

    private void setHeader(HanyoListReportSource source) {
        source.title = 表題;
        source.subtitle = データ種別;
        source.shichosoncode = 地方公共団体.getLasdecCode_().getColumnValue();
        source.shichosonmei = 地方公共団体.get市町村名();
        source.sakuseiymd = get印刷日時();
        Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(outputOrder);
        if (改頁Map.get(INDEX_1) != null) {
            source.page1 = 改頁Map.get(INDEX_1).getDB項目名() != null ? 改頁Map.get(INDEX_1).get項目名() : null;
        }
        if (改頁Map.get(INDEX_2) != null) {
            source.page2 = 改頁Map.get(INDEX_2).getDB項目名() != null ? 改頁Map.get(INDEX_2).get項目名() : null;
        }
        if (改頁Map.get(INDEX_3) != null) {
            source.page3 = 改頁Map.get(INDEX_3).getDB項目名() != null ? 改頁Map.get(INDEX_3).get項目名() : null;
        }
        if (改頁Map.get(INDEX_4) != null) {
            source.page4 = 改頁Map.get(INDEX_4).getDB項目名() != null ? 改頁Map.get(INDEX_4).get項目名() : null;
        }
        if (改頁Map.get(INDEX_5) != null) {
            source.page5 = 改頁Map.get(INDEX_5).getDB項目名() != null ? 改頁Map.get(INDEX_5).get項目名() : null;
        }
        setiOutputOrder(source);
        set改頁(source);
    }

    private void set出力内容(HanyoListReportSource source) {
        source.listMeisaititle = 項目見出し;
        source.listMeisailist_1 = 項目内容;
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(時分秒);
    }

    private void setiOutputOrder(HanyoListReportSource source) {
        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(outputOrder);
        if (出力順Map.get(INDEX_1) != null) {
            source.sort1 = 出力順Map.get(INDEX_1).getDB項目名() != null ? 出力順Map.get(INDEX_1).get項目名() : null;
        }
        if (出力順Map.get(INDEX_2) != null) {
            source.sort2 = 出力順Map.get(INDEX_2).getDB項目名() != null ? 出力順Map.get(INDEX_2).get項目名() : null;
        }
        if (出力順Map.get(INDEX_3) != null) {
            source.sort3 = 出力順Map.get(INDEX_3).getDB項目名() != null ? 出力順Map.get(INDEX_3).get項目名() : null;
        }
        if (出力順Map.get(INDEX_4) != null) {
            source.sort4 = 出力順Map.get(INDEX_4).getDB項目名() != null ? 出力順Map.get(INDEX_4).get項目名() : null;
        }
        if (出力順Map.get(INDEX_5) != null) {
            source.sort5 = 出力順Map.get(INDEX_5).getDB項目名() != null ? 出力順Map.get(INDEX_5).get項目名() : null;
        }
    }

    private void set改頁(HanyoListReportSource source) {
        if (hanyolistentity.get世帯コード() != null && !hanyolistentity.get世帯コード().isEmpty()) {
            source.setaiCode = hanyolistentity.get世帯コード();
        }
        if (hanyolistentity.get受給申請区分() != null && !hanyolistentity.get受給申請区分().isEmpty()) {
            source.jukyuShinseiKubun = hanyolistentity.get受給申請区分();
        }
        if (hanyolistentity.get受給申請日() != null && !hanyolistentity.get受給申請日().isEmpty()) {
            source.jukyuShinseiYMD = new RString(hanyolistentity.get受給申請日().toString());
        }
        if (hanyolistentity.get地区１() != null && !hanyolistentity.get地区１().isEmpty()) {
            source.chikuCode1 = hanyolistentity.get地区１();
        }
        if (hanyolistentity.get地区２() != null && !hanyolistentity.get地区２().isEmpty()) {
            source.chikuCode2 = hanyolistentity.get地区２();
        }
        if (hanyolistentity.get市町村コード() != null && !hanyolistentity.get市町村コード().isEmpty()) {
            source.shichosonCode1 = hanyolistentity.get市町村コード();
        }
        if (hanyolistentity.get性別() != null && !hanyolistentity.get性別().isEmpty()) {
            source.seibetsuCode = hanyolistentity.get性別();
        }
        if (hanyolistentity.get氏名５０音カナ() != null && !hanyolistentity.get氏名５０音カナ().isEmpty()) {
            source.kanaShimei = hanyolistentity.get氏名５０音カナ();
        }
        if (hanyolistentity.get生年月日() != null && !hanyolistentity.get生年月日().isEmpty()) {
            source.seinengappiYMD = new RString(hanyolistentity.get生年月日().toString());
        }
        if (hanyolistentity.get町域コード() != null && !hanyolistentity.get町域コード().isEmpty()) {
            source.choikiCode = hanyolistentity.get町域コード();
        }
        if (hanyolistentity.get番地コード() != null && !hanyolistentity.get番地コード().isEmpty()) {
            source.banchi = hanyolistentity.get番地コード();
        }
        if (hanyolistentity.get行政区コード() != null && !hanyolistentity.get行政区コード().isEmpty()) {
            source.gyoseikuCode = hanyolistentity.get行政区コード();
        }
        if (hanyolistentity.get被保険者番号() != null && !hanyolistentity.get被保険者番号().isEmpty()) {
            source.hokenshaNo = hanyolistentity.get被保険者番号();
        }
        if (hanyolistentity.get要介護度() != null && !hanyolistentity.get要介護度().isEmpty()) {
            source.yoKaigoJotaiKubunCode = hanyolistentity.get要介護度();
        }
        if (hanyolistentity.get証記載保険者番号() != null && !hanyolistentity.get証記載保険者番号().isEmpty()) {
            source.shoKisaiHokenshaNo = hanyolistentity.get証記載保険者番号();
        }
        if (hanyolistentity.get認定開始日() != null && !hanyolistentity.get認定開始日().isEmpty()) {
            source.ninteiKaishiYMD = new RString(hanyolistentity.get認定開始日().toString());
        }
        if (hanyolistentity.get識別コード() != null && !hanyolistentity.get識別コード().isEmpty()) {
            source.shikibetsuCode = hanyolistentity.get識別コード();
        }
        if (hanyolistentity.get資格区分() != null && !hanyolistentity.get資格区分().isEmpty()) {
            source.shikakuKubun = hanyolistentity.get資格区分();
        }
        if (hanyolistentity.get資格取得日() != null && !hanyolistentity.get資格取得日().isEmpty()) {
            source.shikakuShutokuYMD = new RString(hanyolistentity.get資格取得日().toString());
        }
        if (hanyolistentity.get資格喪失日() != null && !hanyolistentity.get資格喪失日().isEmpty()) {
            source.shikakuSoshitsuYMD = new RString(hanyolistentity.get資格喪失日().toString());
        }
        if (hanyolistentity.get郵便番号() != null && !hanyolistentity.get郵便番号().isEmpty()) {
            source.yubinNo = hanyolistentity.get郵便番号();
        }
    }
}
