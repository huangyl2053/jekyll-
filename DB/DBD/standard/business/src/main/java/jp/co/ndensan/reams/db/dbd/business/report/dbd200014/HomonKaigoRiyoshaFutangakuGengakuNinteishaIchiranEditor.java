/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.SetaiInRisutoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200014.HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 訪問介護利用者負担額減額認定者リストEditorです
 *
 * @reamsid_L DBD-3970-060 b_liuyang2
 */
public class HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor implements
        IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final RString 作成 = new RString("作成");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 星 = new RString("＊");
    private static final RString 課 = new RString("課");
    private static final RString 承認 = new RString("承認");
    private static final RString 却下 = new RString("却下");
    private static final RString 認定者リスト = new RString("介護保険 訪問介護利用者負担額減額認定者リスト");
    private static final RString 該当者リスト = new RString("介護保険 訪問介護利用者負担額減額該当者リスト");
    private final RDateTime 作成日時;
    private final TargetList 対象リスト;
    private final NinteishaListSakuseiEntity 訪問介護利用者負担額減額認定者Entity;
    private final Association 導入団体;
    private final IOutputOrder 出力順;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 RDateTime
     * @param 対象リスト TargetList
     * @param 訪問介護利用者負担額減額認定者Entity NinteishaListSakuseiEntity
     * @param 導入団体 Association
     * @param 出力順 IOutputOrder
     */
    public HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor(RDateTime 作成日時, TargetList 対象リスト,
            NinteishaListSakuseiEntity 訪問介護利用者負担額減額認定者Entity, Association 導入団体, IOutputOrder 出力順) {
        this.作成日時 = 作成日時;
        this.対象リスト = 対象リスト;
        this.訪問介護利用者負担額減額認定者Entity = 訪問介護利用者負担額減額認定者Entity;
        this.導入団体 = 導入団体;
        this.出力順 = 出力順;
    }

    @Override
    public HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource
            edit(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        editHeader(source);
        edit被保険者情報Upper1(source);
        edit被保険者情報Upper2(source);
        edit被保険者情報Center1(source);
        edit被保険者情報Center2(source);
        edit被保険者情報Lower1(source);
        edit被保険者情報Lower2(source);
        return source;
    }

    private void editHeader(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(作成).toRString();
        if (null != this.対象リスト && this.対象リスト.getコード().equals(ONE)) {
            source.title = 認定者リスト;
        }
        if (null != this.対象リスト && this.対象リスト.getコード().equals(TWO)) {
            source.title = 該当者リスト;
        }
        if (null != this.導入団体.get地方公共団体コード()) {
            source.hokenshaNo = this.導入団体.get地方公共団体コード().value();
        }
        if (null != this.導入団体.getShichosonName_()) {
            source.hokenshaName = this.導入団体.getShichosonName_();
        }
        set出力順改頁(source);
    }

    private void edit被保険者情報Upper1(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {

        if (null != this.訪問介護利用者負担額減額認定者Entity.get被保険者番号()) {
            source.listUpper_1 = this.訪問介護利用者負担額減額認定者Entity.get被保険者番号().value();
        }
        if (null != this.訪問介護利用者負担額減額認定者Entity.getPsmEntity()) {
            UaFt200FindShikibetsuTaishoEntity 宛名 = this.訪問介護利用者負担額減額認定者Entity.getPsmEntity();
            IKojin 宛名1 = ShikibetsuTaishoFactory.createKojin(宛名);
            if (null != 宛名1.get住所() && null != 宛名1.get住所().get郵便番号()) {
                source.listUpper_2 = 宛名1.get住所().get郵便番号().getYubinNo();
            }
            if (null != 宛名1.get名称()) {
                source.listUpper_3 = 宛名1.get名称().getName().value();
            }
            if (null != 宛名1.get年齢算出() && null != 宛名1.get年齢算出().get年齢()) {
                source.listUpper_4 = 宛名1.get年齢算出().get年齢();
            }
        }
        if (null != this.訪問介護利用者負担額減額認定者Entity.get訪問介護利用者負担額減額()) {
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 訪問介護利用者負担額減額
                    = this.訪問介護利用者負担額減額認定者Entity.get訪問介護利用者負担額減額();
            if (null != 訪問介護利用者負担額減額.getShinseiYMD()) {
                FlexibleDate shinseiYMD = 訪問介護利用者負担額減額.getShinseiYMD();
                get申請日(source, shinseiYMD);
            }
            if (null != 訪問介護利用者負担額減額.getKetteiYMD()) {
                FlexibleDate ketteiYMD = 訪問介護利用者負担額減額.getKetteiYMD();
                get決定日(source, ketteiYMD);

            }
        }
        if (this.訪問介護利用者負担額減額認定者Entity.is老齢福祉年金受給者()) {
            source.listUpper_7 = 星;
        }
        if (KazeiKubun.課税.getコード().equals(this.訪問介護利用者負担額減額認定者Entity.get本人課税区分())) {
            source.listUpper_8 = 課;
        }
        if (this.訪問介護利用者負担額減額認定者Entity.is所得税課税者()) {
            source.listUpper_9 = 課;
        }
        if (this.訪問介護利用者負担額減額認定者Entity.is生活保護受給者()) {
            source.listUpper_10 = 星;
        }
        source.listUpper_11 = get要介護度();
        if (this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity() != null
                && this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_認定年月日() != null) {
            source.listUpper_12 = this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_認定年月日().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit被保険者情報Upper2(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        if (null != this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト()
                && !this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト().isEmpty()) {
            List<SetaiInRisutoEntity> 世帯員リスト = this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト();
            for (int index = 0; index < 世帯員リスト.size(); index++) {
                SetaiInRisutoEntity 世帯員情報 = 世帯員リスト.get(index);
                if (index == 0) {
                    get世帯員Upper(source, 世帯員情報);
                }
                if (index > 0) {
                    source.listUpper_1 = RString.EMPTY;
                    source.listUpper_2 = RString.EMPTY;
                    source.listUpper_3 = RString.EMPTY;
                    source.listUpper_4 = RString.EMPTY;
                    source.listUpper_5 = RString.EMPTY;
                    source.listUpper_6 = RString.EMPTY;
                    source.listUpper_7 = RString.EMPTY;
                    source.listUpper_8 = RString.EMPTY;
                    source.listUpper_9 = RString.EMPTY;
                    source.listUpper_10 = RString.EMPTY;
                    source.listUpper_11 = RString.EMPTY;
                    source.listUpper_12 = RString.EMPTY;
                    get世帯員Upper(source, 世帯員情報);
                }
            }
        }
        source.listUpper_17 = RString.EMPTY;
    }

    private void edit被保険者情報Center1(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        if (null != this.訪問介護利用者負担額減額認定者Entity.getPsmEntity()) {
            UaFt200FindShikibetsuTaishoEntity 宛名 = this.訪問介護利用者負担額減額認定者Entity.getPsmEntity();
            IKojin 宛名1 = ShikibetsuTaishoFactory.createKojin(宛名);
            if (宛名1.get住所() != null) {
                source.listCenter_2 = 宛名1.get住所().get全国住所コード().value();
                source.listCenter_3 = 宛名1.get住所().get住所();
            }
            if (宛名1.get住民状態() != null) {
                source.listCenter_4 = 宛名1.get住民状態().住民状態略称();
            }
        }
        if (null != this.訪問介護利用者負担額減額認定者Entity.get訪問介護利用者負担額減額()) {
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 訪問介護利用者負担額減額
                    = this.訪問介護利用者負担額減額認定者Entity.get訪問介護利用者負担額減額();
            if (null != 訪問介護利用者負担額減額.getShoKisaiHokenshaNo()) {
                source.listCenter_1 = 訪問介護利用者負担額減額.getShoKisaiHokenshaNo().value();
            }
            if (null != 訪問介護利用者負担額減額.getTekiyoKaishiYMD()) {
                FlexibleDate tekiyoKaishiYMD = 訪問介護利用者負担額減額.getTekiyoKaishiYMD();
                get適用開始日(source, tekiyoKaishiYMD);
            }
            if (null != 訪問介護利用者負担額減額.getTekiyoShuryoYMD()) {
                FlexibleDate tekiyoShuryoYMD = 訪問介護利用者負担額減額.getTekiyoShuryoYMD();
                get適用終了日(source, tekiyoShuryoYMD);
            }
            if (null != 訪問介護利用者負担額減額.getShogaishaTechoTokyu()) {
                source.listCenter_7 = 訪問介護利用者負担額減額.getShogaishaTechoTokyu();
            }
            if (null != 訪問介護利用者負担額減額.getShogaishaTechoNo()) {
                source.listCenter_8 = 訪問介護利用者負担額減額.getShogaishaTechoNo();
            }
        }
        if (this.訪問介護利用者負担額減額認定者Entity.is受給者台帳Newest_旧措置者フラグ()) {
            source.listCenter_9 = 星;
        }
        if (this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity() != null
                && this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_認定有効期間開始年月日() != null) {
            source.listCenter_10 = this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_認定有効期間開始年月日().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit被保険者情報Center2(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        if (this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト() != null
                && !this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト().isEmpty()) {
            List<SetaiInRisutoEntity> 世帯員リスト = this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト();
            for (int index = 0; index < 世帯員リスト.size(); index++) {
                SetaiInRisutoEntity 世帯員情報 = 世帯員リスト.get(index);
                if (index == 0) {
                    get世帯員Center(source, 世帯員情報);
                }
                if (index > 0) {
                    source.listCenter_1 = RString.EMPTY;
                    source.listCenter_2 = RString.EMPTY;
                    source.listCenter_3 = RString.EMPTY;
                    source.listCenter_4 = RString.EMPTY;
                    source.listCenter_5 = RString.EMPTY;
                    source.listCenter_6 = RString.EMPTY;
                    source.listCenter_7 = RString.EMPTY;
                    source.listCenter_8 = RString.EMPTY;
                    source.listCenter_9 = RString.EMPTY;
                    source.listCenter_10 = RString.EMPTY;
                    get世帯員Center(source, 世帯員情報);
                }
            }
        }
        source.listCenter_15 = RString.EMPTY;
    }

    private void edit被保険者情報Lower1(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        if (null != this.訪問介護利用者負担額減額認定者Entity.getPsmEntity()) {
            UaFt200FindShikibetsuTaishoEntity 宛名 = this.訪問介護利用者負担額減額認定者Entity.getPsmEntity();
            IKojin 宛名1 = ShikibetsuTaishoFactory.createKojin(宛名);
            if (null != 宛名1.get行政区画()) {
                source.listLower_2 = 宛名1.get行政区画().getGyoseiku().getコード().value();
                source.listLower_3 = 宛名1.get行政区画().getGyoseiku().get名称();
            }
        }
        if (null != this.訪問介護利用者負担額減額認定者Entity.get訪問介護利用者負担額減額()) {
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 訪問介護利用者負担額減額
                    = this.訪問介護利用者負担額減額認定者Entity.get訪問介護利用者負担額減額();
            if (null != 訪問介護利用者負担額減額.getKohiJukyushaNo()) {
                source.listLower_1 = 訪問介護利用者負担額減額.getKohiJukyushaNo();
            }
            if (null != 訪問介護利用者負担額減額.getHobetsuKubun()) {
                source.listLower_4 = 訪問介護利用者負担額減額.getHobetsuKubun();
            }
            if (null != 訪問介護利用者負担額減額.getKetteiKubun()) {
                RString ketteiKubun = 訪問介護利用者負担額減額.getKetteiKubun();
                get決定区分(source, ketteiKubun);
            }
            if (null != 訪問介護利用者負担額減額.getKyufuritsu()) {
                HokenKyufuRitsu kyufuritsu = 訪問介護利用者負担額減額.getKyufuritsu();
                get給付率(source, kyufuritsu);
            }
        }
        if (null != this.訪問介護利用者負担額減額認定者Entity.get要介護認定申請情報_2号特定疾病コード()) {
            source.listLower_7 = this.訪問介護利用者負担額減額認定者Entity.get要介護認定申請情報_2号特定疾病コード();
        }
        source.listLower_8 = RString.EMPTY;
        if (訪問介護利用者負担額減額認定者Entity.get認定情報Entity() != null
                && null != this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_認定有効期間終了年月日()) {
            source.listLower_9 = this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_認定有効期間終了年月日().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
    }

    private void edit被保険者情報Lower2(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        if (null != this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト()
                && !this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト().isEmpty()) {
            List<SetaiInRisutoEntity> 世帯員リスト = this.訪問介護利用者負担額減額認定者Entity.get世帯員リスト();
            for (int index = 0; index < 世帯員リスト.size(); index++) {
                SetaiInRisutoEntity 世帯員情報 = 世帯員リスト.get(index);
                if (index == 0) {
                    get世帯員Lower(source, 世帯員情報);
                }
                if (index > 0) {
                    source.listLower_1 = RString.EMPTY;
                    source.listLower_2 = RString.EMPTY;
                    source.listLower_3 = RString.EMPTY;
                    source.listLower_4 = RString.EMPTY;
                    source.listLower_5 = RString.EMPTY;
                    source.listLower_6 = RString.EMPTY;
                    source.listLower_7 = RString.EMPTY;
                    source.listLower_8 = RString.EMPTY;
                    source.listLower_9 = RString.EMPTY;
                    get世帯員Lower(source, 世帯員情報);
                }
            }
        }
        source.listLower_14 = RString.EMPTY;
    }

    private RString get要介護度() {

        if (this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity() != null
                && null != this.訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_要介護状態区分コード()
                && null != this.訪問介護利用者負担額減額認定者Entity.get要介護認定申請情報_厚労省IF識別コード()) {
            RString 要介護状態区分コード = 訪問介護利用者負担額減額認定者Entity.get認定情報Entity().get認定情報_要介護状態区分コード();
            KoroshoInterfaceShikibetsuCode 厚労省IF識別コード = KoroshoInterfaceShikibetsuCode.
                    toValue(訪問介護利用者負担額減額認定者Entity.get要介護認定申請情報_厚労省IF識別コード());
            return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護状態区分コード).getName();
        }
        return RString.EMPTY;

    }

    private void get世帯員Upper(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, SetaiInRisutoEntity 世帯員情報) {
        if (世帯員情報.get世帯員宛名() != null) {
            UaFt200FindShikibetsuTaishoEntity 世帯員宛名 = 世帯員情報.get世帯員宛名();
            IKojin 世帯員宛名1 = ShikibetsuTaishoFactory.createKojin(世帯員宛名);
            if (世帯員宛名1.get名称() != null) {
                source.listUpper_13 = 世帯員宛名1.get名称().getName().value();
            }
            if (世帯員宛名1.get住民状態() != null) {
                source.listUpper_14 = 世帯員宛名1.get住民状態().住民状態略称();
            }
        }
        if (KazeiKubun.課税.getコード().equals(世帯員情報.get課税区分())) {
            source.listUpper_15 = 課;
        }
        if (世帯員情報.get課税所得額() != null && 世帯員情報.get課税所得額().compareTo(Decimal.ZERO) > 0) {
            source.listUpper_16 = 課;
        }
    }

    private void get世帯員Center(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, SetaiInRisutoEntity 世帯員情報) {
        if (世帯員情報.get世帯員宛名() != null) {
            UaFt200FindShikibetsuTaishoEntity 世帯員宛名 = 世帯員情報.get世帯員宛名();
            IKojin 世帯員宛名1 = ShikibetsuTaishoFactory.createKojin(世帯員宛名);
            if (世帯員宛名1.get名称() != null) {
                source.listCenter_11 = 世帯員宛名1.get名称().getName().value();
            }
            if (世帯員宛名1.get住民状態() != null) {
                source.listCenter_12 = 世帯員宛名1.get住民状態().住民状態略称();
            }
        }
        if (KazeiKubun.課税.getコード().equals(世帯員情報.get課税区分())) {
            source.listCenter_13 = 課;
        }
        if (世帯員情報.get課税所得額() != null && 世帯員情報.get課税所得額().compareTo(Decimal.ZERO) > 0) {
            source.listCenter_14 = 課;
        }
    }

    private void get世帯員Lower(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, SetaiInRisutoEntity 世帯員情報) {
        if (世帯員情報.get世帯員宛名() != null) {
            UaFt200FindShikibetsuTaishoEntity 世帯員宛名 = 世帯員情報.get世帯員宛名();
            IKojin 世帯員宛名1 = ShikibetsuTaishoFactory.createKojin(世帯員宛名);
            if (世帯員宛名1.get名称() != null) {
                source.listLower_10 = 世帯員宛名1.get名称().getName().value();
            }
            if (世帯員宛名1.get住民状態() != null) {
                source.listLower_11 = 世帯員宛名1.get住民状態().住民状態略称();
            }
        }
        if (KazeiKubun.課税.getコード().equals(世帯員情報.get課税区分())) {
            source.listLower_12 = 課;
        }
        if (世帯員情報.get課税所得額() != null && 世帯員情報.get課税所得額().compareTo(Decimal.ZERO) > 0) {
            source.listLower_13 = 課;
        }
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource
            set出力順改頁(HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source) {
        List<ISetSortItem> list = new ArrayList<>();
        if (出力順 != null && 出力順.get設定項目リスト() == null) {
            list = 出力順.get設定項目リスト();
        }
        if (list.size() > LISTINDEX_0) {
            source.shutsuryokujun1 = list.get(LISTINDEX_0).get項目名();
        }
        if (list.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = list.get(LISTINDEX_1).get項目名();
        }
        if (list.size() > LISTINDEX_2) {
            source.shutsuryokujun3 = list.get(LISTINDEX_2).get項目名();
        }
        if (list.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = list.get(LISTINDEX_3).get項目名();
        }
        if (list.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = list.get(LISTINDEX_4).get項目名();
        }
        if (list.size() > LISTINDEX_0 && list.get(LISTINDEX_0).is改頁項目()) {
            source.kaiPege1 = list.get(0).get項目名();
        }
        if (list.size() > LISTINDEX_1 && list.get(LISTINDEX_1).is改頁項目()) {
            source.kaiPege2 = list.get(LISTINDEX_1).get項目名();
        }
        if (list.size() > LISTINDEX_2 && list.get(LISTINDEX_2).is改頁項目()) {
            source.kaiPege3 = list.get(LISTINDEX_2).get項目名();
        }
        if (list.size() > LISTINDEX_3 && list.get(LISTINDEX_3).is改頁項目()) {
            source.kaiPege4 = list.get(LISTINDEX_3).get項目名();
        }
        if (list.size() > LISTINDEX_4 && list.get(LISTINDEX_4).is改頁項目()) {
            source.kaiPege5 = list.get(LISTINDEX_4).get項目名();
        }
        return source;
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource get申請日(
            HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, FlexibleDate shinseiYMD) {
        if (null != shinseiYMD) {
            source.listUpper_5 = shinseiYMD.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource get決定日(
            HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, FlexibleDate ketteiYMD) {
        if (null != ketteiYMD) {
            source.listUpper_6 = ketteiYMD.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource get適用開始日(
            HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, FlexibleDate tekiyoKaishiYMD) {
        if (null != tekiyoKaishiYMD) {
            source.listCenter_5 = tekiyoKaishiYMD.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource get適用終了日(
            HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, FlexibleDate tekiyoShuryoYMD) {
        if (null != tekiyoShuryoYMD) {
            source.listCenter_6 = tekiyoShuryoYMD.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return source;
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource get決定区分(
            HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, RString ketteiKubun) {
        if (null != ketteiKubun) {
            if (KetteiKubun.承認する.getコード().equals(ketteiKubun)) {
                source.listLower_5 = 承認;
            }
            if (KetteiKubun.承認しない.getコード().equals(ketteiKubun)) {
                source.listLower_5 = 却下;
            }
        }
        return source;
    }

    private HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource get給付率(
            HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource source, HokenKyufuRitsu kyufuritsu) {
        if (null != kyufuritsu) {
            source.listLower_6 = new RString(kyufuritsu.value().toString());
        }
        return source;
    }
}
