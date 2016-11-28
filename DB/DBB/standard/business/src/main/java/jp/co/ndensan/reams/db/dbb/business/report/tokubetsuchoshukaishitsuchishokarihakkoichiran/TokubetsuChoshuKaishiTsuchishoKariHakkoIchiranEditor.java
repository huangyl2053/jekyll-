/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Editor
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor implements ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor {

    private static final RString SAKUSEI = new RString("作成");
    private static final RString タイトル = new RString("特別徴収開始通知書（仮徴収）発行一覧表");
    private static final RString 徴収額タイトル = new RString("仮徴収額");
    private static final RString 仮徴収月4月 = new RString("4月");
    private static final RString 仮徴収月6月 = new RString("6月");
    private static final RString 仮徴収月8月 = new RString("8月");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private final KariSanteiTsuchiShoKyotsu 仮算定通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity;
    private final FlexibleYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final int 連番;
    private final Association association;
    private final List<RString> 改頁項目リスト;
    private final List<RString> 出力項目リスト;
    private final TsuchishoDataTempEntity entity;

    /**
     * コンストラクタです
     *
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 編集後仮算定通知書共通情報entity EditedKariSanteiTsuchiShoKyotsu
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param 連番 int
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param entity TsuchishoDataTempEntity
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity,
            FlexibleYear 調定年度, YMDHMS 帳票作成日時,
            int 連番, Association association, List<RString> 出力項目リスト, List<RString> 改頁項目リスト,
            TsuchishoDataTempEntity entity) {
        this.仮算定通知書情報 = 仮算定通知書情報;
        this.編集後仮算定通知書共通情報entity = 編集後仮算定通知書共通情報entity;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.連番 = 連番;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.entity = entity;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource edit(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        initializeSource(source);
        if (entity != null) {
            if (entity.get宛先() != null) {
                set宛先改頁(source, entity.get宛先());
            }
            if (entity.get宛名() != null) {
                set宛名改頁(source, entity.get宛名());
            }
            if (entity.get計算後情報() != null) {
                set計算後情報改頁(source, entity.get計算後情報());
            }
            if (entity.get対象者_追加含む情報() != null) {
                set対象者_追加含む情報改頁(source, entity.get対象者_追加含む情報());
            }
            if (entity.get納組() != null) {
                set納組(source, entity.get納組());
            }
        }

        if (帳票作成日時 != null && !帳票作成日時.isEmpty()) {
            RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成日.concat(RString.HALF_SPACE).concat(帳票作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        }
        source.title = タイトル;
        if (調定年度 != null && !調定年度.isEmpty()) {
            source.nendo = 調定年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        }
        if (association != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
            source.hokenshaName = association.get市町村名();
        }
        set出力改頁(source);
        source.titleChoshugaku = 徴収額タイトル;
        source.listUpper_1 = new RString(連番);
        if (編集後仮算定通知書共通情報entity != null) {
            set編集後宛先(source, 編集後仮算定通知書共通情報entity);
            set編集後個人(source, 編集後仮算定通知書共通情報entity);
            set更正後(source, 編集後仮算定通知書共通情報entity);
            source.listLower_1 = 編集後仮算定通知書共通情報entity.get通知書番号().value();
            source.listLower_6 = 仮徴収月4月;
            source.listLower_8 = 仮徴収月6月;
            source.listLower_10 = 仮徴収月8月;
        }
        set改頁(source);
        setPageBreakEmpty(source);
        return source;
    }

    private void initializeSource(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        source.listUpper_2 = RString.EMPTY;
        source.listLower_2 = RString.EMPTY;
        source.listUpper_5 = RString.EMPTY;
        source.listUpper_6 = RString.EMPTY;
        source.hokenshaNo = RString.EMPTY;
        source.atesaki_choikiCode = RString.EMPTY;
        source.atesaki_banchiCode = RString.EMPTY;
        source.atesaki_gyoseikuCode = RString.EMPTY;
        source.atesaki_chikuCode1 = RString.EMPTY;
        source.atesaki_chikuCode2 = RString.EMPTY;
        source.atesaki_chikuCode3 = RString.EMPTY;
        source.atena_shikibetsuCode = RString.EMPTY;
        source.atena_kanaMeisho = RString.EMPTY;
        source.dbT2015KeisangoJoho_fukaShichosonCode = RString.EMPTY;
        source.nenkinTokuchoKaifuJoho_nenkinCode = RString.EMPTY;
        source.dbT2015KeisangoJoho_seihofujoShurui = RString.EMPTY;
        source.caT0714SeikyuHoho_nokumiCode = RString.EMPTY;
        source.dbT2015KeisangoJoho_choteiJiyu1 = RString.EMPTY;
    }

    private void set宛先改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source, UaFt250FindAtesakiEntity 宛先) {
        ChoikiCode 町域コード = 宛先.getChoikiCode();
        RString 番地コード = entity.get番地コード();
        GyoseikuCode 行政区コード = 宛先.getGyoseikuCode();
        ChikuCode 地区１ = 宛先.getChikuCode1();
        ChikuCode 地区２ = 宛先.getChikuCode2();
        ChikuCode 地区３ = 宛先.getChikuCode3();
        if (町域コード != null) {
            source.atesaki_choikiCode = 町域コード.value();
        }
        if (番地コード != null) {
            source.atesaki_banchiCode = 番地コード;
        }
        if (行政区コード != null) {
            source.atesaki_gyoseikuCode = 行政区コード.value();
        }
        if (地区１ != null) {
            source.atesaki_chikuCode1 = 地区１.value();
        }
        if (地区２ != null) {
            source.atesaki_chikuCode2 = 地区２.value();
        }
        if (地区３ != null) {
            source.atesaki_chikuCode3 = 地区３.value();
        }
    }

    private void set宛名改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            UaFt200FindShikibetsuTaishoEntity 宛名) {

        ShikibetsuCode 識別コード = 宛名.getShikibetsuCode();
        AtenaKanaMeisho 氏名５０音カナ = 宛名.getKanaMeisho();
        if (識別コード != null) {
            source.atena_shikibetsuCode = 識別コード.value();
        }
        if (氏名５０音カナ != null) {
            source.atena_kanaMeisho = 氏名５０音カナ.value();
        }
    }

    private void set計算後情報改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            DbTKeisangoJohoTempTableEntity 計算後情報) {
        RString 生活保護種別 = 計算後情報.getSeihofujoShurui();
        LasdecCode 賦課市町村コード = 計算後情報.getFukaShichosonCode();
        RString 調定事由 = 計算後情報.getChoteiJiyu1();
        if (生活保護種別 != null) {
            source.dbT2015KeisangoJoho_seihofujoShurui = 生活保護種別;
        }
        if (賦課市町村コード != null) {
            source.dbT2015KeisangoJoho_fukaShichosonCode = 賦課市町村コード.value();
        }
        if (調定事由 != null) {
            source.dbT2015KeisangoJoho_choteiJiyu1 = 調定事由;
        }
    }

    private void set対象者_追加含む情報改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む情報) {
        RString 年金コード = 対象者_追加含む情報.getNenkinCode();
        if (年金コード != null) {
            source.dbT2015KeisangoJoho_fukaShichosonCode = 年金コード;
        }
    }

    private void set納組(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            CaFt703FindNokumiEntity 納組) {
        if (納組.getNokumi() != null) {
            RString 納組コード = 納組.getNokumi().getNokumiCode();
            if (納組コード != null) {
                source.caT0714SeikyuHoho_nokumiCode = 納組コード;
            }
        }
    }

    private void set出力改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (NUM0 < 出力項目リスト.size()) {
            source.shutsuryokujun1 = 出力項目リスト.get(NUM0);
            if (NUM0 < 改頁項目リスト.size()) {
                source.kaipage1 = 改頁項目リスト.get(NUM0);
            }
        }
        if (NUM1 < 出力項目リスト.size()) {
            source.shutsuryokujun2 = 出力項目リスト.get(NUM1);
            if (NUM1 < 改頁項目リスト.size()) {
                source.kaipage2 = 改頁項目リスト.get(NUM1);
            }
        }
        if (NUM2 < 出力項目リスト.size()) {
            source.shutsuryokujun3 = 出力項目リスト.get(NUM2);
            if (NUM2 < 改頁項目リスト.size()) {
                source.kaipage3 = 改頁項目リスト.get(NUM2);
            }
        }
        if (NUM3 < 出力項目リスト.size()) {
            source.shutsuryokujun4 = 出力項目リスト.get(NUM3);
            if (NUM3 < 改頁項目リスト.size()) {
                source.kaipage4 = 改頁項目リスト.get(NUM3);
            }
        }
        if (NUM4 < 出力項目リスト.size()) {
            source.shutsuryokujun5 = 出力項目リスト.get(NUM4);
            if (NUM4 < 改頁項目リスト.size()) {
                source.kaipage5 = 改頁項目リスト.get(NUM4);
            }
        }
    }

    private void set編集後宛先(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity) {
        if (編集後仮算定通知書共通情報entity.get編集後宛先() != null) {
            source.listUpper_2 = 編集後仮算定通知書共通情報entity.get編集後宛先().get郵便番号();
            source.listUpper_3 = 編集後仮算定通知書共通情報entity.get編集後宛先().get編集後住所();
            source.listUpper_4 = 編集後仮算定通知書共通情報entity.get編集後宛先().get宛先行政区();
        }

    }

    private void set編集後個人(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity) {
        if (編集後仮算定通知書共通情報entity.get編集後個人() != null) {
            source.listUpper_5 = 編集後仮算定通知書共通情報entity.get編集後個人().get生年月日();
            source.listUpper_6 = 編集後仮算定通知書共通情報entity.get編集後個人().get性別();
            if (編集後仮算定通知書共通情報entity.get編集後個人().get世帯主名() != null) {
                source.listUpper_7 = 編集後仮算定通知書共通情報entity.get編集後個人().get世帯主名().value();
            }
            if (編集後仮算定通知書共通情報entity.get編集後個人().get世帯コード() != null) {
                source.listLower_2 = 編集後仮算定通知書共通情報entity.get編集後個人().get世帯コード().value();
            }
            if (編集後仮算定通知書共通情報entity.get編集後個人().get名称() != null) {
                source.listLower_3 = new RString(編集後仮算定通知書共通情報entity.get編集後個人().get名称().getName().toString());
            }
        }
    }

    private void set更正後(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity) {
        if (編集後仮算定通知書共通情報entity.get更正後() != null) {
            source.listLower_4 = 編集後仮算定通知書共通情報entity.get更正後().get更正後特別徴収義務者();
            source.listLower_5 = 編集後仮算定通知書共通情報entity.get更正後().get更正後特別徴収対象年金();
            if (編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額01() != null) {
                source.listLower_7 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                        get更正後特徴期別金額01(), 0);
            }
            if (編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額02() != null) {
                source.listLower_9 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                        get更正後特徴期別金額02(), 0);
            }
            if (編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額03() != null) {
                source.listLower_11 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                        get更正後特徴期別金額03(), 0);
            }
        }
    }

    private void set改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (編集後仮算定通知書共通情報entity.get編集後宛先() != null) {
            source.banchiCode = 編集後仮算定通知書共通情報entity.get編集後宛先().get編集番地コード();
            source.choikiCode = 編集後仮算定通知書共通情報entity.get編集後宛先().get町域コード();
            source.gyoseikuCode = 編集後仮算定通知書共通情報entity.get編集後宛先().get行政区コード().getColumnValue();
            source.chikuCode1 = 編集後仮算定通知書共通情報entity.get編集後宛先().get地区１();
            source.chikuCode2 = 編集後仮算定通知書共通情報entity.get編集後宛先().get地区２();
            source.chikuCode3 = 編集後仮算定通知書共通情報entity.get編集後宛先().get地区３();
        }
        if (編集後仮算定通知書共通情報entity.get編集後個人() != null) {
            source.shikibetsuCode = 編集後仮算定通知書共通情報entity.get編集後個人().get識別コード().value();
            source.kanaMeisho = 編集後仮算定通知書共通情報entity.get編集後個人().get氏名５０音カナ();
        }
        source.hihokenshaNo = 編集後仮算定通知書共通情報entity.get被保険者番号().getColumnValue();
        if (仮算定通知書情報.get徴収方法情報_更正後() != null) {
            source.nenkinCode = 仮算定通知書情報.get徴収方法情報_更正後().get本徴収_年金コード();
        }
        if (仮算定通知書情報.get納組情報() != null && 仮算定通知書情報.get納組情報().getNokumi() != null) {
            source.nokumiCode = 仮算定通知書情報.get納組情報().getNokumi().getNokumiCode();
        }
        source.seihoFlag = 仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get生活保護扶助種類();
        source.choteiJiyu = get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由1())
                .concat(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由2()))
                .concat(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由3()))
                .concat(get調定事由(仮算定通知書情報.get賦課の情報_更正後().get賦課情報().get調定事由4()));
    }

    private RString get調定事由(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private void setPageBreakEmpty(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (source.listUpper_2 == null) {
            source.listUpper_2 = RString.EMPTY;
        }
        if (source.atesaki_choikiCode == null) {
            source.atesaki_choikiCode = RString.EMPTY;
        }
        if (source.atesaki_banchiCode == null) {
            source.atesaki_banchiCode = RString.EMPTY;
        }
        if (source.atesaki_gyoseikuCode == null) {
            source.atesaki_gyoseikuCode = RString.EMPTY;
        }
        if (source.atesaki_chikuCode1 == null) {
            source.atesaki_chikuCode1 = RString.EMPTY;
        }
        if (source.atesaki_chikuCode2 == null) {
            source.atesaki_chikuCode2 = RString.EMPTY;
        }
        if (source.atesaki_chikuCode3 == null) {
            source.atesaki_chikuCode3 = RString.EMPTY;
        }
        if (source.listLower_2 == null) {
            source.listLower_2 = RString.EMPTY;
        }

        setPageBreakEmpty_2(source);

    }

    private void setPageBreakEmpty_2(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (source.atena_shikibetsuCode == null) {
            source.atena_shikibetsuCode = RString.EMPTY;
        }
        if (source.atena_kanaMeisho == null) {
            source.atena_kanaMeisho = RString.EMPTY;
        }
        if (source.listUpper_5 == null) {
            source.listUpper_5 = RString.EMPTY;
        }
        if (source.listUpper_6 == null) {
            source.listUpper_6 = RString.EMPTY;
        }
        if (source.dbT2015KeisangoJoho_fukaShichosonCode == null) {
            source.dbT2015KeisangoJoho_fukaShichosonCode = RString.EMPTY;
        }
        if (source.hokenshaNo == null) {
            source.hokenshaNo = RString.EMPTY;
        }
        if (source.nenkinTokuchoKaifuJoho_nenkinCode == null) {
            source.nenkinTokuchoKaifuJoho_nenkinCode = RString.EMPTY;
        }
        if (source.dbT2015KeisangoJoho_seihofujoShurui == null) {
            source.dbT2015KeisangoJoho_seihofujoShurui = RString.EMPTY;
        }
        if (source.caT0714SeikyuHoho_nokumiCode == null) {
            source.caT0714SeikyuHoho_nokumiCode = RString.EMPTY;
        }
        if (source.dbT2015KeisangoJoho_choteiJiyu1 == null) {
            source.dbT2015KeisangoJoho_choteiJiyu1 = RString.EMPTY;
        }
    }
}
