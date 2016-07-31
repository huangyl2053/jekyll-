/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のEditorです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranEditor implements ITokubetsuChoshuMidoteiIchiranEditor {

    private static final RString 男性 = new RString("1");
    private static final RString 女性 = new RString("2");
    private static final RString 外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 日本人 = new RString("1");
    private static final RString 住登外日本人 = new RString("3");
    private static final RString 年度 = new RString("年度");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_10 = 10;
    private static final int NUM_12 = 12;
    private static final int 住所上段長さ = 30;
    private static final RString 厚労省 = new RString("厚労省");
    private static final RString 地共済 = new RString("地共済");
    private static final RString SHORTLINE = new RString("-");
    private static final List<Integer> 仮徴収月リスト = new ArrayList<>();
    private static final List<Integer> 本徴収月リスト = new ArrayList<>();
    private static final List<Integer> 翌年度仮徴収月リスト = new ArrayList<>();
    private static final List<RString> 住民種別日本人 = new ArrayList<>();
    private static final List<RString> 住民種別外国人 = new ArrayList<>();
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;
    private final Association association;
    private final RString 特徴開始月;
    private final TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定;

    /**
     * コンストラクタです。
     *
     * @param 特徴対象一覧未同定 TokushoTaishioIchiranMidoteiEntity
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 特徴開始月 特徴開始月
     * @param association Association
     */
    public TokubetsuChoshuMidoteiIchiranEditor(
            TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト,
            RString 特徴開始月,
            Association association) {
        this.特徴対象一覧未同定 = 特徴対象一覧未同定;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.association = association;
        this.特徴開始月 = 特徴開始月;
        仮徴収月リスト.add(NUM_8);
        本徴収月リスト.add(NUM_10);
        本徴収月リスト.add(NUM_12);
        本徴収月リスト.add(NUM_2);
        翌年度仮徴収月リスト.add(NUM_4);
        翌年度仮徴収月リスト.add(NUM_6);
        住民種別日本人.add(日本人);
        住民種別日本人.add(住登外日本人);
        住民種別外国人.add(住登外外国人);
        住民種別外国人.add(外国人);
    }

    @Override
    public TokubetsuChoshuMidoteiIchiranSource edit(TokubetsuChoshuMidoteiIchiranSource source) {
        set年度(source);
        set作成日時(source);
        set導入団体コード(source);
        set導入市町村名(source);
        set年金番号と年金コード(source);
        set識別コード(source);
        set生年月日(source);
        set性別(source);
        setカナ氏名(source);
        set漢字氏名(source);
        set郵便番号(source);
        set住所(source);
        set天引先区分(source);
        set出力事由(source);
        set出力順(source);
        set改ページ(source);
        return source;
    }

    private void set年度(TokubetsuChoshuMidoteiIchiranSource source) {
        RString 年 = BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (RString.isNullOrEmpty(年)) {
            return;
        }
        FlexibleYear fYear = new FlexibleYear(年);
        source.nendo = fYear.wareki().toDateString().concat(年度);
    }

    private void set作成日時(TokubetsuChoshuMidoteiIchiranSource source) {
        source.printTimeStamp = DateConverter.getSakuseiYmhm();
    }

    private void set導入団体コード(TokubetsuChoshuMidoteiIchiranSource source) {
        source.cityCd = association.getLasdecCode_().value();
    }

    private void set導入市町村名(TokubetsuChoshuMidoteiIchiranSource source) {
        source.cityMei = association.get市町村名();
    }

    private void set年金番号と年金コード(TokubetsuChoshuMidoteiIchiranSource source) {
        if (RString.isNullOrEmpty(特徴開始月)) {
            source.listList1_1 = this.特徴対象一覧未同定.getKisoNenkinNo();
            source.listList1_2 = this.特徴対象一覧未同定.getNenkinCode();
            return;
        }
        Integer 特徴開始月 = Integer.parseInt(this.特徴開始月.toString());
        if (仮徴収月リスト.contains(特徴開始月)) {
            source.listList1_1 = this.特徴対象一覧未同定.getKarichoshuKisoNenkinNo();
            source.listList1_2 = this.特徴対象一覧未同定.getKarichoshuNenkinCode();
        }
        if (本徴収月リスト.contains(特徴開始月)) {
            source.listList1_1 = this.特徴対象一覧未同定.getHonchoshuKisoNenkinNo();
            source.listList1_2 = this.特徴対象一覧未同定.getHonchoshuKisonenkinCode();
        }
        if (翌年度仮徴収月リスト.contains(特徴開始月)) {
            source.listList1_1 = this.特徴対象一覧未同定.getYokunendoKarichoshuKisoNenkinNo();
            source.listList1_2 = this.特徴対象一覧未同定.getYokunendoKariChoshuKisonenkinCode();
        }
    }

    private void set識別コード(TokubetsuChoshuMidoteiIchiranSource source) {
        ShikibetsuCode shikibetsuCode = this.特徴対象一覧未同定.getShikibetuCode();
        if (shikibetsuCode == null) {
            return;
        }
        source.shikibetsuCode = shikibetsuCode;
        source.listList1_3 = shikibetsuCode.value();
    }

    private void set生年月日(TokubetsuChoshuMidoteiIchiranSource source) {
        RString 住民種別コード = this.特徴対象一覧未同定.getJuminShubetsuCode();
        if (住民種別日本人.contains(住民種別コード)) {
            source.listList2_1 = DateConverter.getDate1(this.特徴対象一覧未同定.getUmareYMD());
        }
        if (住民種別外国人.contains(住民種別コード)) {
            source.listList2_1 = DateConverter.getDate31(this.特徴対象一覧未同定.getUmareYMD());
        }
    }

    private void set性別(TokubetsuChoshuMidoteiIchiranSource source) {
        RString seibetsuCode = this.特徴対象一覧未同定.getSeibetsuCode();
        if (男性.equals(seibetsuCode)) {
            source.listList1_4 = Seibetsu.男.get名称();
            return;
        }
        if (女性.equals(seibetsuCode)) {
            source.listList1_4 = Seibetsu.女.get名称();
            return;
        }
        source.listList1_4 = RString.EMPTY;
    }

    private void setカナ氏名(TokubetsuChoshuMidoteiIchiranSource source) {
        source.listList1_5 = this.特徴対象一覧未同定.getKanaShimei();
    }

    private void set漢字氏名(TokubetsuChoshuMidoteiIchiranSource source) {
        source.listList2_2 = this.特徴対象一覧未同定.getKanjiShimei();
    }

    private void set郵便番号(TokubetsuChoshuMidoteiIchiranSource source) {
        RString no = this.特徴対象一覧未同定.getYubinNo();
        if (RString.isNullOrEmpty(no) || no.length() < NUM_3) {
            return;
        }
        RString 郵便番号上段 = no.substring(0, NUM_3);
        RString 郵便番号下段 = no.substring(NUM_3, NUM_7);

        source.listList1_6 = 郵便番号上段.concat(SHORTLINE).concat(郵便番号下段);
    }

    private void set住所(TokubetsuChoshuMidoteiIchiranSource source) {
        RString jusho = this.特徴対象一覧未同定.getJusho();
        if (RString.isNullOrEmpty(jusho) || jusho.length() <= 住所上段長さ) {
            source.listList2_3 = RString.EMPTY;
            source.listList1_7 = jusho;
            return;
        }
        source.listList1_7 = jusho.substring(0, 住所上段長さ);
        source.listList2_3 = jusho.substring(住所上段長さ);
    }

    private void set天引先区分(TokubetsuChoshuMidoteiIchiranSource source) {
        Boolean 厚労省判定 = this.特徴対象一覧未同定.getKoroshoHantei();
        source.listList1_8 = 厚労省判定 ? 厚労省 : 地共済;
    }

    private void set出力事由(TokubetsuChoshuMidoteiIchiranSource source) {
        RString 不一致理由コード = this.特徴対象一覧未同定.getFuichiRiyuCode();
        if (RString.isNullOrEmpty(不一致理由コード)) {
            return;
        }
        for (DoteiFuitchiRiyu type : DoteiFuitchiRiyu.values()) {
            if (type.getコード().equals(不一致理由コード)) {
                source.listList1_9 = type.get不一致理由名();
                return;
            }
        }
        source.listList1_9 = RString.EMPTY;
    }

    private void set出力順(TokubetsuChoshuMidoteiIchiranSource source) {
        if (出力順項目リスト == null || 出力順項目リスト.isEmpty()) {
            return;
        }
        source.sortJunArea1 = 出力順項目リスト.get(NUM_0);
        if (出力順項目リスト.size() > NUM_1) {
            source.sortJunArea2 = 出力順項目リスト.get(NUM_1);
        }
        if (出力順項目リスト.size() > NUM_2) {
            source.sortJunArea3 = 出力順項目リスト.get(NUM_2);
        }
        if (出力順項目リスト.size() > NUM_3) {
            source.sortJunArea4 = 出力順項目リスト.get(NUM_3);
        }
        if (出力順項目リスト.size() > NUM_4) {
            source.sortJunArea5 = 出力順項目リスト.get(NUM_4);
        }
    }

    private void set改ページ(TokubetsuChoshuMidoteiIchiranSource source) {
        if (改頁項目リスト == null || 改頁項目リスト.isEmpty()) {
            return;
        }
        source.kaiPageArea1 = 改頁項目リスト.get(NUM_0);
        if (改頁項目リスト.size() > NUM_1) {
            source.kaiPageArea2 = 改頁項目リスト.get(NUM_1);
        }
        if (改頁項目リスト.size() > NUM_2) {
            source.kaiPageArea3 = 改頁項目リスト.get(NUM_2);
        }
        if (改頁項目リスト.size() > NUM_3) {
            source.kaiPageArea4 = 改頁項目リスト.get(NUM_3);
        }
        if (改頁項目リスト.size() > NUM_4) {
            source.kaiPageArea5 = 改頁項目リスト.get(NUM_4);
        }
    }
}
