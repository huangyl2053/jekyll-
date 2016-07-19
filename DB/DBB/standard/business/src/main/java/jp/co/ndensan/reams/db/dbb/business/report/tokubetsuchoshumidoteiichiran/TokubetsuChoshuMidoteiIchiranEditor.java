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
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のEditorです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranEditor implements ITokubetsuChoshuMidoteiIchiranEditor {

    private static final RString 外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 日本人 = new RString("1");
    private static final RString 住登外日本人 = new RString("3");
    private static final int NUM_3 = 3;
    private static final int NUM_7 = 7;
    private static final int 住所上段長さ = 30;
    private static final RString 厚労省 = new RString("厚労省");
    private static final RString 地共済 = new RString("地共済");
    private static final RString SHORTLINE = new RString("-");
    private static final List<RString> 住民種別日本人 = new ArrayList<>();
    private static final List<RString> 住民種別外国人 = new ArrayList<>();

    private final Association association;
    private final TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定;

    /**
     * コンストラクタです。
     *
     * @param 特徴対象一覧未同定
     * @param association Association
     */
    public TokubetsuChoshuMidoteiIchiranEditor(
            TokushoTaishioIchiranMidoteiEntity 特徴対象一覧未同定,
            Association association) {
        this.特徴対象一覧未同定 = 特徴対象一覧未同定;
        this.association = association;
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
        return source;
    }

    private void set年度(TokubetsuChoshuMidoteiIchiranSource source) {
        RString 年 = BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課);
        if (RString.isNullOrEmpty(年)) {
            return;
        }
        FlexibleYear fYear = new FlexibleYear(年);
        source.nendo = fYear.wareki().toDateString();
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
        source.listList1_1 = this.特徴対象一覧未同定.getKisoNenkinNo();
        source.listList1_2 = this.特徴対象一覧未同定.getNenkinCode();
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
        if (RString.isNullOrEmpty(seibetsuCode)) {
            source.listList1_4 = RString.EMPTY;
            return;
        }
        source.listList1_4 = Gender.toValue(seibetsuCode).getName().getFullJapanese();
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
        source.listList1_9 = DoteiFuitchiRiyu.toValue(不一致理由コード).get不一致理由名();
    }

}
