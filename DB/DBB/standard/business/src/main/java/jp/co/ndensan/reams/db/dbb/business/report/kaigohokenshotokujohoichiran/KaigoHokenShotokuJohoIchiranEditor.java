/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.TorokuGyomu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のEditorです。
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranEditor implements IKaigoHokenShotokuJohoIchiranEditor {

    private final KaigoHokenShotokuTempEntity 所得情報一覧;
    private final RString 導入形態コード;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final List<RString> 出力順項目リスト;
    private final List<RString> 改頁項目リスト;
    private final Association association;
    private final int 連番;
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 導入形態コード_112 = new RString("112");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString 外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 日本人 = new RString("1");
    private static final RString 住登外日本人 = new RString("3");
    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private static final RString 定数_時 = new RString("時");
    private static final RString 定数_分 = new RString("分");
    private static final RString 定数_減免前 = new RString("減免前");
    private static final RString 定数_減免後 = new RString("減免後");
    private static final RString 定数_住民税課税区分 = new RString("住民税課税区分");
    private static final RString 定数_住民税 = new RString("住民税");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_8 = 8;
    private static final int NUM_10 = 10;
    private static final int NUM_12 = 12;

    /**
     * コンストラクタです。
     *
     * @param 所得情報一覧 KaigoHokenShotokuTempEntity
     * @param 導入形態コード RString
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param association Association
     * @param 連番 int
     */
    public KaigoHokenShotokuJohoIchiranEditor(KaigoHokenShotokuTempEntity 所得情報一覧,
            RString 導入形態コード,
            LasdecCode 市町村コード,
            RString 市町村名称,
            List<RString> 出力順項目リスト,
            List<RString> 改頁項目リスト,
            Association association,
            int 連番) {
        this.所得情報一覧 = 所得情報一覧;
        this.導入形態コード = 導入形態コード;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.association = association;
        this.連番 = 連番;
    }

    @Override
    public KaigoHokenShotokuJohoIchiranSource edit(KaigoHokenShotokuJohoIchiranSource source) {
        if (導入形態コード.equals(導入形態コード_112) || 導入形態コード.equals(導入形態コード_120)) {
            source.cityName = association.get市町村名();
            source.cityCode = association.get地方公共団体コード().getColumnValue();
        } else if (導入形態コード.equals(導入形態コード_111)) {
            source.cityCode = 市町村コード.getColumnValue();
            source.cityName = 市町村名称;
        }
        set出力順(source);
        set改ページ(source);
        source.listIchiranhyoUpper_1 = new RString(連番);
        if (所得情報一覧.getShikibetsuCode() != null) {
            source.listIchiranhyoUpper_2 = 所得情報一覧.getShikibetsuCode().getColumnValue();
        }
        if (所得情報一覧.getKanaMeisho() != null) {
            source.listIchiranhyoUpper_3 = 所得情報一覧.getKanaMeisho().getColumnValue();
        }
        if (所得情報一覧.getShotokuNendo() != null) {
            source.listIchiranhyoUpper_4 = 所得情報一覧.getShotokuNendo().wareki().toDateString();
        }
        set生年月日(source);
        set性別コード(source);
        RString 表示場合 = DbBusinessConfig.get(ConfigNameDBB.所得引出_住民税減免前後表示区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (表示場合.equals(表示する)) {
            source.kazeiKubun = 定数_住民税課税区分;
            source.kazeiKubunGemmenMae = 定数_減免前;
            source.kazeiKubunGemmenGo = 定数_減免後;
            set課税区分減免前(source);
            set課税区分減免後(source);
        } else if (表示場合.equals(表示しない)) {
            source.listIchiranhyoUpper_7 = RString.EMPTY;
            source.listIchiranhyoUpper_8 = RString.EMPTY;
            source.kazeiKubun = 定数_住民税;
            source.kazeiKubunGemmenMae = RString.EMPTY;
            source.kazeiKubunGemmenGo = RString.EMPTY;
        }
        source.listIchiranhyoUpper_9 = new RString(所得情報一覧.getGokeiShotokuGaku().toString());
        source.listIchiranhyoUpper_10 = new RString(所得情報一覧.getKazeiShotokuGaku().toString());
        set登録業務(source);
        if (所得情報一覧.getHihokenshaNo() != null) {
            source.listIchiranhyoLower_1 = 所得情報一覧.getHihokenshaNo().getColumnValue();
        }
        if (所得情報一覧.getMeisho() != null) {
            source.listIchiranhyoLower_2 = 所得情報一覧.getMeisho().getColumnValue();
        }
        source.listIchiranhyoLower_3 = new RString(所得情報一覧.getAge());
        set住民種別(source);
        source.listIchiranhyoLower_5 = new RString(所得情報一覧.getNenkiniShunyuGaku().toString());
        source.listIchiranhyoLower_6 = new RString(所得情報一覧.getNenkiniShotokuGaku().toString());
        YMDHMS システム日時 = YMDHMS.now();
        RString 作成年月 = new FlexibleDate(システム日時.toString().substring(NUM_0, NUM_8))
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().substring(NUM_0, NUM_8);
        RString 日時 = new RString(システム日時.toString().substring(NUM_8, NUM_10).concat(定数_時.toString())
                .concat(YMDHMS.now().toString().substring(NUM_10, NUM_12)).concat(定数_分.toString()));
        source.printTimeStamp = 作成年月.concat(RString.FULL_SPACE).concat(日時);
        return source;
    }

    private void set住民種別(KaigoHokenShotokuJohoIchiranSource source) {
        if (JuminShubetsu.住登外個人_外国人.getCode().equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoLower_4 = JuminShubetsu.住登外個人_外国人.toRString();
        } else if (JuminShubetsu.住登外個人_日本人.getCode().equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoLower_4 = JuminShubetsu.住登外個人_日本人.toRString();
        } else if (JuminShubetsu.共有者.getCode().equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoLower_4 = JuminShubetsu.共有者.toRString();
        } else if (JuminShubetsu.外国人.getCode().equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoLower_4 = JuminShubetsu.外国人.toRString();
        } else if (JuminShubetsu.日本人.getCode().equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoLower_4 = JuminShubetsu.日本人.toRString();
        } else if (JuminShubetsu.法人.getCode().equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoLower_4 = JuminShubetsu.法人.toRString();
        } else {
            source.listIchiranhyoLower_4 = RString.EMPTY;
        }
    }

    private void set登録業務(KaigoHokenShotokuJohoIchiranSource source) {
        if (TorokuGyomu.介護保険.getコード().equals(所得情報一覧.getTorokuGyomu())) {
            source.listIchiranhyoUpper_11 = TorokuGyomu.介護保険.get名称();
        } else if (TorokuGyomu.住民税.getコード().equals(所得情報一覧.getTorokuGyomu())) {
            source.listIchiranhyoUpper_11 = TorokuGyomu.介護保険.get名称();
        } else {
            source.listIchiranhyoUpper_11 = RString.EMPTY;
        }
    }

    private void set課税区分減免後(KaigoHokenShotokuJohoIchiranSource source) {
        if (KazeiKubun.課税.getコード().equals(所得情報一覧.getKazeiKubunGemmenGo())) {
            source.listIchiranhyoUpper_8 = KazeiKubun.課税.get名称();
        } else if (KazeiKubun.所得調査中.getコード().equals(所得情報一覧.getKazeiKubunGemmenGo())) {
            source.listIchiranhyoUpper_8 = KazeiKubun.所得調査中.get名称();
        } else if (KazeiKubun.未申告.getコード().equals(所得情報一覧.getKazeiKubunGemmenGo())) {
            source.listIchiranhyoUpper_8 = KazeiKubun.未申告.get名称();
        } else if (KazeiKubun.課税取消.getコード().equals(所得情報一覧.getKazeiKubunGemmenGo())) {
            source.listIchiranhyoUpper_8 = KazeiKubun.課税取消.get名称();
        } else if (KazeiKubun.非課税.getコード().equals(所得情報一覧.getKazeiKubunGemmenGo())) {
            source.listIchiranhyoUpper_8 = KazeiKubun.非課税.get名称();
        } else {
            source.listIchiranhyoUpper_8 = RString.EMPTY;
        }
    }

    private void set課税区分減免前(KaigoHokenShotokuJohoIchiranSource source) {
        if (KazeiKubun.課税.getコード().equals(所得情報一覧.getKazeiKubun())) {
            source.listIchiranhyoUpper_7 = KazeiKubun.課税.get名称();
        } else if (KazeiKubun.所得調査中.getコード().equals(所得情報一覧.getKazeiKubun())) {
            source.listIchiranhyoUpper_7 = KazeiKubun.所得調査中.get名称();
        } else if (KazeiKubun.未申告.getコード().equals(所得情報一覧.getKazeiKubun())) {
            source.listIchiranhyoUpper_7 = KazeiKubun.未申告.get名称();
        } else if (KazeiKubun.課税取消.getコード().equals(所得情報一覧.getKazeiKubun())) {
            source.listIchiranhyoUpper_7 = KazeiKubun.課税取消.get名称();
        } else if (KazeiKubun.非課税.getコード().equals(所得情報一覧.getKazeiKubun())) {
            source.listIchiranhyoUpper_7 = KazeiKubun.非課税.get名称();
        } else {
            source.listIchiranhyoUpper_7 = RString.EMPTY;
        }
    }

    private void set性別コード(KaigoHokenShotokuJohoIchiranSource source) {
        if (Seibetsu.男.getコード().equals(所得情報一覧.getSeibetsuCode())) {
            source.listIchiranhyoUpper_6 = Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(所得情報一覧.getSeibetsuCode())) {
            source.listIchiranhyoUpper_6 = Seibetsu.女.get名称();
        } else {
            source.listIchiranhyoUpper_6 = RString.EMPTY;
        }
    }

    private void set生年月日(KaigoHokenShotokuJohoIchiranSource source) {
        if (外国人.equals(所得情報一覧.getJuminShubetsuCode())
                || 住登外外国人.equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoUpper_5 = 所得情報一覧.getSeinengappiYMD().seireki().toDateString();
        }
        if (日本人.equals(所得情報一覧.getJuminShubetsuCode())
                || 住登外日本人.equals(所得情報一覧.getJuminShubetsuCode())) {
            source.listIchiranhyoUpper_5 = 所得情報一覧.getSeinengappiYMD().wareki().toDateString();
        }
    }

    private void set出力順(KaigoHokenShotokuJohoIchiranSource source) {
        if (出力順項目リスト != null && !出力順項目リスト.isEmpty()) {
            if (出力順項目リスト.size() > NUM_0) {
                source.sort1 = 出力順項目リスト.get(NUM_0);
            }
            if (出力順項目リスト.size() > NUM_1) {
                source.sort2 = 出力順項目リスト.get(NUM_1);
            }
            if (出力順項目リスト.size() > NUM_2) {
                source.sort3 = 出力順項目リスト.get(NUM_2);
            }
            if (出力順項目リスト.size() > NUM_3) {
                source.sort4 = 出力順項目リスト.get(NUM_3);
            }
            if (出力順項目リスト.size() > NUM_4) {
                source.sort5 = 出力順項目リスト.get(NUM_4);
            }
        }
    }

    private void set改ページ(KaigoHokenShotokuJohoIchiranSource source) {
        if (改頁項目リスト != null && !改頁項目リスト.isEmpty()) {
            if (改頁項目リスト.size() > NUM_0) {
                source.page1 = 改頁項目リスト.get(NUM_0);
            }
            if (改頁項目リスト.size() > NUM_1) {
                source.page2 = 改頁項目リスト.get(NUM_1);
            }
            if (改頁項目リスト.size() > NUM_2) {
                source.page3 = 改頁項目リスト.get(NUM_2);
            }
            if (改頁項目リスト.size() > NUM_3) {
                source.page4 = 改頁項目リスト.get(NUM_3);
            }
            if (改頁項目リスト.size() > NUM_4) {
                source.page5 = 改頁項目リスト.get(NUM_4);
            }
        }
    }

}
