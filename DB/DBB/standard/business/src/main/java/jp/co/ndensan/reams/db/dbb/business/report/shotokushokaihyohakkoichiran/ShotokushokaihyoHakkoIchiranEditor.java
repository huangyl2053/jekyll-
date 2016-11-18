/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表のEditor
 *
 * @reamsid_L DBB-1720-060 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranEditor implements IShotokushokaihyoHakkoIchiranEditor {

    private static final RString 所得照会一覧表 = new RString("所得照会一覧表");
    private static final RString 前住所 = new RString("前住所");
    private static final RString 現住所 = new RString("現住所");
    private static final RString 照会日 = new RString("照会日");
    private static final RString 転入日 = new RString("転入日");
    private static final RString 転入届出日 = new RString("転入届出日");
    private static final RString 転出日 = new RString("転出日");
    private static final RString 候補者区分_転入者 = new RString("1");
    private static final RString 候補者区分_住特者 = new RString("2");
    private static final RString テストプリント_印字 = new RString("テストプリント");
    private static final RString 印字_１号 = new RString("１号");
    private static final RString 印字_１号予 = new RString("１号（予）");
    private static final RString 印字_２号 = new RString("２号");
    private static final RString 印字_世帯員 = new RString("世帯員");
    private static final RString 印字_世帯員予 = new RString("世帯員（予）");
    private static final RString 印字_１号住特 = new RString("１号住特");
    private static final RString 印字_２号住特 = new RString("２号住特");
    private static final RString 印字_広域 = new RString("広域");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final RString 被保険者区分コード_EMPTY = new RString("");
    private static final RString 被保険者区分コード_NUM1 = new RString("1");
    private static final RString 被保険者区分コード_NUM2 = new RString("2");
    private static final RString 外国人 = new RString("2");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 日本人 = new RString("1");
    private static final RString 住登外日本人 = new RString("3");
    private static final RString 本人 = new RString("1");
    private static final RString 世帯員 = new RString("2");
    private static final RString 年度 = new RString("年度");
    private static final RString 作成 = new RString("作成");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_8 = 8;
    private static final int NUM_10 = 10;
    private static final int NUM_12 = 12;
    private static final int NUM_14 = 14;

    private final ShotokuShoukaiDataTempEntity 所得照会票発行一覧;
    private final List<KoikiZenShichosonJoho> 構成市町村情報リスト;
    private final List<RString> 出力順項目リスト;
    private final Map<RString, RString> 改頁項目Map;
    private final List<RString> 改頁項目リスト;
    private final FlexibleDate 照会年月日;
    private final FlexibleYear 処理年度;
    private final boolean テストプリント;
    private final Association association;

    /**
     * コンストラクタです.
     *
     * @param 所得照会票発行一覧 ShotokuShoukaiDataTempEntity
     * @param 構成市町村情報リスト List<KoikiZenShichosonJoho>
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目Map Map<RString, RString>
     * @param 改頁項目リスト List<RString>
     * @param 照会年月日 FlexibleDate
     * @param 処理年度 FlexibleDate
     * @param テストプリント boolean
     * @param association Association
     */
    public ShotokushokaihyoHakkoIchiranEditor(ShotokuShoukaiDataTempEntity 所得照会票発行一覧,
            List<KoikiZenShichosonJoho> 構成市町村情報リスト,
            List<RString> 出力順項目リスト,
            Map<RString, RString> 改頁項目Map,
            List<RString> 改頁項目リスト,
            FlexibleDate 照会年月日,
            FlexibleYear 処理年度,
            boolean テストプリント,
            Association association) {
        this.所得照会票発行一覧 = 所得照会票発行一覧;
        this.構成市町村情報リスト = 構成市町村情報リスト;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目Map = 改頁項目Map;
        this.改頁項目リスト = 改頁項目リスト;
        this.照会年月日 = 照会年月日;
        this.処理年度 = 処理年度;
        this.テストプリント = テストプリント;
        this.association = association;
    }

    @Override
    public ShotokushokaihyoHakkoIchiranSource edit(ShotokushokaihyoHakkoIchiranSource source) {
        YMDHMS システム日時 = YMDHMS.now();
        RString 作成年月日 = new FlexibleDate(システム日時.toString().substring(NUM_0, NUM_8))
                .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時分 = new RString(システム日時.toString().substring(NUM_8, NUM_10).concat(時.toString())
                .concat(システム日時.toString().substring(NUM_10, NUM_12)).concat(分.toString()));
        RString 作成秒 = new RString(システム日時.toString().substring(NUM_12, NUM_14).concat(秒.toString()));
        source.printTimeStamp = 作成年月日.concat(RString.FULL_SPACE).concat(作成時分).concat(作成秒).concat(RString.FULL_SPACE).concat(作成);
        source.title = 所得照会一覧表;
        if (処理年度 != null) {
            source.nendo = 処理年度.wareki().toDateString().concat(年度);
        }
        if (テストプリント) {
            source.testShori = テストプリント_印字;
        }
        source.hokenshaNo = new RString(association.get地方公共団体コード().toString());
        source.hokenshaName = association.get市町村名();
        set出力順(source);
        set改ページ(source);
        source.jushoTitle1 = 前住所;
        source.jushoTitle2 = 現住所;
        RString 候補者区分 = 所得照会票発行一覧.getKouhoshakubun();
        if (候補者区分 != null && !候補者区分.isEmpty() && 候補者区分_転入者.equals(候補者区分)) {
            source.komokuNameTitle1 = 転入日;
            source.komokuNameTitle2 = 転入届出日;
        } else if (候補者区分 != null && !候補者区分.isEmpty() && 候補者区分_住特者.equals(候補者区分)) {
            source.komokuNameTitle1 = 転出日;
            source.komokuNameTitle2 = RString.EMPTY;
        }
        source.komokuNameTitle4 = 照会日;
        source.listUpper_1 = new RString(所得照会票発行一覧.getSetaiCode().toString());
        source.listUpper_2 = new RString(所得照会票発行一覧.getKanaMeisho().toString());
        if (候補者区分 != null && 候補者区分.equals(候補者区分_転入者)
                && 所得照会票発行一覧.getZenjusho() != null) {
            source.listUpper_3 = 所得照会票発行一覧.getZenjusho();
        } else if (候補者区分 != null
                && 候補者区分.equals(候補者区分_住特者)) {
            source.listUpper_3 = RString.EMPTY;
        }
        set生年月日(source);
        editorSource(source);
        source.choikiCode = 所得照会票発行一覧.getChoikiCode();
        source.gyoseikuCode = 所得照会票発行一覧.getGyoseikuCode();
        source.shichosonCode = 所得照会票発行一覧.getShichosonCode();
        source.idoYMD = 所得照会票発行一覧.getIdoYMD() == null ? RString.EMPTY
                : new RString(所得照会票発行一覧.getIdoYMD().toString());
        source.zenjushoCode = 所得照会票発行一覧.getZenjushoCode();
        return source;
    }

    private void editorSource(ShotokushokaihyoHakkoIchiranSource source) {
        if (照会年月日 != null) {
            source.listUpper_5 = 照会年月日.wareki().toDateString();
        }
        if (所得照会票発行一覧.getIdoYMD() != null) {
            source.listUpper_6 = new FlexibleDate(所得照会票発行一覧.getIdoYMD().toString()).wareki().toDateString();
        }
        set種別(source);
        if (所得照会票発行一覧.getShikibetsuCode() != null) {
            source.listLower_1 = 所得照会票発行一覧.getShikibetsuCode().getColumnValue();
        }
        if (所得照会票発行一覧.getMeisho() != null) {
            source.listLower_2 = 所得照会票発行一覧.getMeisho().getColumnValue();
        }
        source.listLower_3 = 所得照会票発行一覧.getGenjusho();
        set性別コード(source);
        RString 候補者区分 = 所得照会票発行一覧.getKouhoshakubun();
        if (候補者区分 != null && 候補者区分_転入者.equals(候補者区分)) {
            source.listLower_5 = 所得照会票発行一覧.getTorokuTodokedeYMD();
        } else if (候補者区分 != null && 候補者区分_住特者.equals(候補者区分)) {
            source.listLower_5 = RString.EMPTY;
        }
        if (所得照会票発行一覧.getHihokenshaNo() != null) {
            source.listLower_6 = 所得照会票発行一覧.getHihokenshaNo().getColumnValue();
        }
    }

    private void set性別コード(ShotokushokaihyoHakkoIchiranSource source) {
        if (Seibetsu.男.getコード().equals(所得照会票発行一覧.getSeibetsuCode())) {
            source.listLower_4 = Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(所得照会票発行一覧.getSeibetsuCode())) {
            source.listLower_4 = Seibetsu.女.get名称();
        } else {
            source.listLower_4 = RString.EMPTY;
        }
    }

    private void set生年月日(ShotokushokaihyoHakkoIchiranSource source) {
        RString 住民種別コード = 所得照会票発行一覧.getJuminShubetsuCode();
        if (所得照会票発行一覧.getSeinengappiYMD() != null && 住民種別コード != null) {
            if (外国人.equals(住民種別コード) || 住登外外国人.equals(住民種別コード)) {
                source.listUpper_4 = 所得照会票発行一覧.getSeinengappiYMD().seireki().toDateString();
            } else if (日本人.equals(住民種別コード) || 住登外日本人.equals(住民種別コード)) {
                source.listUpper_4 = 所得照会票発行一覧.getSeinengappiYMD().wareki().toDateString();
            }
        }
    }

    private void set出力順(ShotokushokaihyoHakkoIchiranSource source) {
        if (出力順項目リスト != null && !出力順項目リスト.isEmpty()) {
            if (出力順項目リスト.size() > NUM_0) {
                source.shutsuryokujun1 = 出力順項目リスト.get(NUM_0);
            }
            if (出力順項目リスト.size() > NUM_1) {
                source.shutsuryokujun2 = 出力順項目リスト.get(NUM_1);
            }
            if (出力順項目リスト.size() > NUM_2) {
                source.shutsuryokujun3 = 出力順項目リスト.get(NUM_2);
            }
            if (出力順項目リスト.size() > NUM_3) {
                source.shutsuryokujun4 = 出力順項目リスト.get(NUM_3);
            }
            if (出力順項目リスト.size() > NUM_4) {
                source.shutsuryokujun5 = 出力順項目リスト.get(NUM_4);
            }
        }
    }

    private void set改ページ(ShotokushokaihyoHakkoIchiranSource source) {
        if (改頁項目リスト != null && !改頁項目リスト.isEmpty()) {
            if (改頁項目リスト.size() > NUM_0) {
                source.kaipage1 = 改頁項目Map.get(改頁項目リスト.get(NUM_0));
            }
            if (改頁項目リスト.size() > NUM_1) {
                source.kaipage2 = 改頁項目Map.get(改頁項目リスト.get(NUM_1));
            }
            if (改頁項目リスト.size() > NUM_2) {
                source.kaipage3 = 改頁項目Map.get(改頁項目リスト.get(NUM_2));
            }
            if (改頁項目リスト.size() > NUM_3) {
                source.kaipage4 = 改頁項目Map.get(改頁項目リスト.get(NUM_3));
            }
            if (改頁項目リスト.size() > NUM_4) {
                source.kaipage5 = 改頁項目Map.get(改頁項目リスト.get(NUM_3));
            }
        }
    }

    private void set種別(ShotokushokaihyoHakkoIchiranSource source) {
        RString 候補者区分 = 所得照会票発行一覧.getKouhoshakubun();
        RString 被保険者区分コード = 所得照会票発行一覧.getHihokennshaKubunCode();
        RString 本人区分 = 所得照会票発行一覧.getHonninKubun();
        if (is１号(候補者区分, 本人区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_１号;
        } else if (is１号予(候補者区分, 本人区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_１号予;
        } else if (is２号(候補者区分, 本人区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_２号;
        } else if (is世帯員(候補者区分, 本人区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_世帯員;
        } else if (is世帯員予(候補者区分, 本人区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_世帯員予;
        } else if (is１号住特(候補者区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_１号住特;
        } else if (is２号住特(候補者区分, 被保険者区分コード)) {
            source.listUpper_7 = 印字_２号住特;
        } else if (is広域()) {
            source.listUpper_7 = 印字_広域;
        }
    }

    private boolean is広域() {
        RString 市町村コード = RString.EMPTY;
        RString 構成市町村情報_市町村コード = RString.EMPTY;
        if (所得照会票発行一覧.getZenkokuJushoCode() != null && !所得照会票発行一覧.getZenkokuJushoCode().isEmpty()) {
            if (NUM_6 <= 所得照会票発行一覧.getZenkokuJushoCode().toString().length()) {
                市町村コード = new RString(所得照会票発行一覧.getZenkokuJushoCode().toString().substring(NUM_0, NUM_5));
            } else {
                市町村コード = new RString(所得照会票発行一覧.getZenkokuJushoCode().toString());
            }
        }
        List<RString> 市町村コードリスト = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村情報 : 構成市町村情報リスト) {
            if (構成市町村情報.get市町村コード() != null) {
                構成市町村情報_市町村コード = new RString(構成市町村情報.get市町村コード()
                        .toString().substring(NUM_0, NUM_5));
            }
            市町村コードリスト.add(構成市町村情報_市町村コード);
        }
        return 市町村コードリスト.contains(市町村コード);
    }

    private boolean is２号住特(RString 候補者区分, RString 被保険者区分コード) {
        return 候補者区分_住特者.equals(候補者区分) && 被保険者区分コード_NUM2.equals(被保険者区分コード);
    }

    private boolean is１号住特(RString 候補者区分, RString 被保険者区分コード) {
        return 候補者区分_住特者.equals(候補者区分) && 被保険者区分コード_NUM1.equals(被保険者区分コード);
    }

    private boolean is世帯員予(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 世帯員.equals(本人区分)
                && 被保険者区分コード_EMPTY.equals(被保険者区分コード);
    }

    private boolean is世帯員(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 世帯員.equals(本人区分)
                && 被保険者区分コード_NUM1.equals(被保険者区分コード);
    }

    private boolean is２号(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 本人.equals(本人区分)
                && 被保険者区分コード_NUM2.equals(被保険者区分コード);
    }

    private boolean is１号予(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 本人.equals(本人区分)
                && 被保険者区分コード_EMPTY.equals(被保険者区分コード);
    }

    private boolean is１号(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 本人.equals(本人区分)
                && 被保険者区分コード_NUM1.equals(被保険者区分コード);
    }

}
