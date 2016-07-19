/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票設計_DBBPR81003_1_特別徴収同定一覧表のEditorクラスです。
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
public class TokubetsuChoshuDoteiIchiranEditor implements ITokubetsuChoshuDoteiIchiranEditor {

    private static final RString 外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 日本人 = new RString("1");
    private static final RString 住登外日本人 = new RString("3");
    private static final int NUM_3 = 3;
    private static final int NUM_7 = 7;
    private static final RString SHORTLINE = new RString("-");
    private static final List<RString> 住民種別日本人 = new ArrayList<>();
    private static final List<RString> 住民種別外国人 = new ArrayList<>();
    private final Association association;
    private final TokushoTaishioIchiranEntity 特徴対象一覧;

    /**
     * コンストラクタです.
     *
     * @param 特徴対象一覧 TokushoTaishioIchiranEntity
     * @param association Association
     */
    public TokubetsuChoshuDoteiIchiranEditor(TokushoTaishioIchiranEntity 特徴対象一覧,
            Association association) {
        this.association = association;
        this.特徴対象一覧 = 特徴対象一覧;
        住民種別日本人.add(日本人);
        住民種別日本人.add(住登外日本人);
        住民種別外国人.add(住登外外国人);
        住民種別外国人.add(外国人);
    }

    @Override
    public TokubetsuChoshuDoteiIchiranSource edit(TokubetsuChoshuDoteiIchiranSource source) {
        set年度(source);
        set作成日時(source);
        set導入団体コード(source);
        set導入市町村名(source);
        set被保険者番号(source);
        set年金番号と年金コード(source);
        set識別コード(source);
        set世帯コード(source);
        set行政区コード(source);
        set生年月日(source);
        set性別(source);
        setカナ氏名(source);
        set漢字氏名(source);
        set郵便番号(source);
        set住所(source);
        return source;
    }

    private void set年度(TokubetsuChoshuDoteiIchiranSource source) {
        RString 年 = BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課);
        if (RString.isNullOrEmpty(年)) {
            return;
        }
        FlexibleYear fYear = new FlexibleYear(年);
        source.nendo = fYear.wareki().toDateString();
    }

    private void set作成日時(TokubetsuChoshuDoteiIchiranSource source) {
        source.printTimeStamp = DateConverter.getSakuseiYmhm();
    }

    private void set導入団体コード(TokubetsuChoshuDoteiIchiranSource source) {
        source.cityCd = association.getLasdecCode_().value();
    }

    private void set導入市町村名(TokubetsuChoshuDoteiIchiranSource source) {
        source.cityMei = association.get市町村名();
    }

    private void set被保険者番号(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList1_1 = this.特徴対象一覧.getHihokenshaNo();
    }

    private void set年金番号と年金コード(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList1_2 = this.特徴対象一覧.getKisoNenkinNo();
        source.listList2_1 = this.特徴対象一覧.getNenkinCode();
    }

    private void set識別コード(TokubetsuChoshuDoteiIchiranSource source) {
        ShikibetsuCode shikibetsuCode = this.特徴対象一覧.getShikibetuCode();
        if (shikibetsuCode == null) {
            return;
        }
        source.shikibetsuCode = shikibetsuCode;
        source.listList1_3 = shikibetsuCode.value();
    }

    private void set世帯コード(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList2_2 = this.特徴対象一覧.getSetaiCode();
    }

    private void set行政区コード(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList1_4 = this.特徴対象一覧.getGyoseikuCode();
    }

    private void set生年月日(TokubetsuChoshuDoteiIchiranSource source) {
        RString 住民種別コード = this.特徴対象一覧.getJuminShubetsuCode();
        if (住民種別日本人.contains(住民種別コード)) {
            source.listList1_5 = DateConverter.getDate1(this.特徴対象一覧.getUmareYMD());
        }
        if (住民種別外国人.contains(住民種別コード)) {
            source.listList1_5 = DateConverter.getDate31(this.特徴対象一覧.getUmareYMD());
        }

    }

    private void set性別(TokubetsuChoshuDoteiIchiranSource source) {
        RString seibetsuCode = this.特徴対象一覧.getSeibetsuCode();
        if (RString.isNullOrEmpty(seibetsuCode)) {
            source.listList2_3 = RString.EMPTY;
            return;
        }
        source.listList2_3 = Gender.toValue(seibetsuCode).getName().getFullJapanese();
    }

    private void setカナ氏名(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList1_6 = this.特徴対象一覧.getKanashimeiJodan();
        source.listList2_4 = this.特徴対象一覧.getKanashimeiKadan();
    }

    private void set漢字氏名(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList1_7 = this.特徴対象一覧.getKanjiShimei();
    }

    private void set郵便番号(TokubetsuChoshuDoteiIchiranSource source) {
        RString no = this.特徴対象一覧.getYubinNo();
        if (RString.isNullOrEmpty(no) || no.length() < NUM_3) {
            return;
        }
        RString 郵便番号上段 = no.substring(0, NUM_3);
        RString 郵便番号下段 = no.substring(NUM_3, NUM_7);
        source.listList2_5 = 郵便番号上段.concat(SHORTLINE).concat(郵便番号下段);
    }

    private void set住所(TokubetsuChoshuDoteiIchiranSource source) {
        source.listList2_6 = this.特徴対象一覧.getJusho();
    }

}
