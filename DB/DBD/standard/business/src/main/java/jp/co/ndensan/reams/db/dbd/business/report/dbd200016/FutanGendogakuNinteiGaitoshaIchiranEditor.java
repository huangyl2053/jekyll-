/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200016;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.SetaiInRisutoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200001.FutanGendogakuNinteiGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
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
 * 負担限度額認定者リストEditorです。
 *
 * @reamsid_L DBD-3960-060 donghj
 */
public class FutanGendogakuNinteiGaitoshaIchiranEditor implements IFutanGendogakuNinteiGaitoshaIchiranEditor {

    private final RDateTime 作成日時;
    private final TargetList 対象リスト;
    private final NinteishaListSakuseiEntity 負担限度額認定者リストEntity;
    private final Association 導入団体;
    private final IOutputOrder 出力順;
    private final int index;

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final RString 該当 = new RString("該当");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 旧措軽減 = new RString("旧措軽減");
    private static final RString 認定者リスト = new RString("介護保険 負担限度額認定者リスト");
    private static final RString 該当者リスト = new RString("介護保険 負担限度額該当者リスト");
    private static final RString 課 = new RString("課");
    private static final RString 星 = new RString("＊");
    private static final RString 有 = new RString("有");

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 RDateTime
     * @param 対象リスト TargetList
     * @param 負担限度額認定者リストEntity NinteishaListSakuseiEntity
     * @param 導入団体 Association
     * @param 出力順 IOutputOrder
     * @param index int
     */
    public FutanGendogakuNinteiGaitoshaIchiranEditor(RDateTime 作成日時, TargetList 対象リスト,
            NinteishaListSakuseiEntity 負担限度額認定者リストEntity, Association 導入団体, IOutputOrder 出力順, int index) {
        this.作成日時 = 作成日時;
        this.対象リスト = 対象リスト;
        this.負担限度額認定者リストEntity = 負担限度額認定者リストEntity;
        this.導入団体 = 導入団体;
        this.出力順 = 出力順;
        this.index = index;
    }

    @Override
    public FutanGendogakuNinteiGaitoshaIchiranReportSource edit(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        if (index == 1) {
            editHeader(source);
            edit被保険者情報Upper(source);
            edit被保険者情報Center(source);
            edit被保険者情報Lower(source);
            edit世帯員(source);
        } else {
            edit世帯員(source);
        }
        source.shikibetsuCode = RString.EMPTY;
        return source;
    }

    private void editHeader(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(new RString("作成")).toRString();
        if (null != this.対象リスト && this.対象リスト.getコード().equals(TargetList.認定者リスト.getコード())) {
            source.title = 認定者リスト;
        }
        if (null != this.対象リスト && this.対象リスト.getコード().equals(TargetList.該当者リスト.getコード())) {
            source.title = 該当者リスト;
        }

        if (null != 導入団体) {
            source.hokenshaNo = 導入団体.get地方公共団体コード().value();
            source.hokenshaName = 導入団体.getShichosonName_();
        }
        if (null != 出力順) {
            set出力順改頁(source);
        }
    }

    private void edit被保険者情報Upper(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        if (null != this.負担限度額認定者リストEntity.get被保険者番号()) {
            source.listUpper_1 = this.負担限度額認定者リストEntity.get被保険者番号().value();
        }
        if (null != this.負担限度額認定者リストEntity.getPsmEntity()) {
            UaFt200FindShikibetsuTaishoEntity 宛名 = this.負担限度額認定者リストEntity.getPsmEntity();
            IKojin 宛名1 = ShikibetsuTaishoFactory.createKojin(宛名);
            if (null != 宛名1.get名称()) {
                source.listUpper_2 = 宛名1.get名称().getName().value();
            }
            if (null != 宛名1.get年齢算出() && null != 宛名1.get年齢算出().get年齢()) {
                source.listUpper_3 = 宛名1.get年齢算出().get年齢();
            }
        }

        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKetteiKubun()) {
            if (KetteiKubun.承認する.getコード().equals(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKetteiKubun())) {
                source.listUpper_4 = 承認;
            } else if (KetteiKubun.承認しない.getコード().equals(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKetteiKubun())) {
                source.listUpper_4 = 却下;
            } else {
                source.listUpper_4 = RString.EMPTY;
            }
        }

        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKetteiYMD()) {
            FlexibleDate ketteiYMD = this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKetteiYMD();
            get決定日(source, ketteiYMD);
        }

        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getRiyoshaFutanDankai()) {
            RString rs = this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getRiyoshaFutanDankai();
            source.listUpper_6 = RiyoshaFutanDankai.toValue(rs).get名称();
        }

        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKyokaisoGaitoshaKubun()) {
            source.listUpper_7 = 該当;
        } else {
            source.listUpper_7 = RString.EMPTY;
        }

        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getShinseiYMD()) {
            FlexibleDate shinseiYMD = this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKetteiYMD();
            get申請日(source, shinseiYMD);
        }

        if (this.負担限度額認定者リストEntity.is老齢福祉年金受給者()) {
            source.listUpper_9 = 星;
        } else {
            source.listUpper_9 = RString.EMPTY;
        }

        if (null != this.負担限度額認定者リストEntity.get本人課税区分()) {
            if (KazeiKubun.課税.getコード().equals(this.負担限度額認定者リストEntity.get本人課税区分())) {
                source.listUpper_10 = 課;
            } else {
                source.listUpper_10 = RString.EMPTY;
            }
        }

        if (this.負担限度額認定者リストEntity.is所得税課税者()) {
            source.listUpper_11 = 課;
        } else {
            source.listUpper_11 = RString.EMPTY;
        }

        if (this.負担限度額認定者リストEntity.is生活保護受給者()) {
            source.listUpper_12 = 星;
        } else {
            source.listUpper_12 = RString.EMPTY;
        }

        if (null != this.負担限度額認定者リストEntity.get合計所得_含年金収入()) {
            source.listUpper_13 = editDecimal(this.負担限度額認定者リストEntity.get合計所得_含年金収入());
        }

        if (null != this.負担限度額認定者リストEntity.get認定情報Entity() && null != this.負担限度額認定者リストEntity.get認定情報Entity().get認定情報_認定年月日()) {
            FlexibleDate ninteiYMD = this.負担限度額認定者リストEntity.get認定情報Entity().get認定情報_認定年月日();
            source.listUpper_14 = editTime(ninteiYMD);
        }

        if (null != this.負担限度額認定者リストEntity.get被保険者台帳情報_住所地特例フラグ()) {
            if (new RString("1").equals(this.負担限度額認定者リストEntity.get被保険者台帳情報_住所地特例フラグ())) {
                source.listUpper_15 = 星;
            } else {
                source.listUpper_15 = RString.EMPTY;
            }
        }
    }

    private void edit被保険者情報Center(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        IKojin 世帯員宛名 = ShikibetsuTaishoFactory.createKojin(this.負担限度額認定者リストEntity.getPsmEntity());
        if (null != 世帯員宛名) {
            edit宛名(source, 世帯員宛名);
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getTekiyoKaishiYMD()) {
            FlexibleDate tekiyoKaishiYMD = this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getTekiyoKaishiYMD();
            if (null != tekiyoKaishiYMD) {
                source.listCenter_5 = editTime(tekiyoKaishiYMD);
            }
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getShokuhiFutanGendogaku()) {
            source.listCenter_6 = editDecimal(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getShokuhiFutanGendogaku());
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getUnitTypeJunKoshitsu()) {
            source.listCenter_7 = editDecimal(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getUnitTypeJunKoshitsu());
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Roken_Ryoyo()) {
            source.listCenter_8 = editDecimal(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Roken_Ryoyo());
        }
        if (null != this.負担限度額認定者リストEntity.get利用者負担段階()) {
            source.listCenter_9 = RiyoshaFutanDankai.toValue(this.負担限度額認定者リストEntity.get利用者負担段階()).get名称();
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKyusochishaKubun()) {
            if (KyuSochishaKubun.旧措置者.getコード().equals(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKyusochishaKubun())) {
                source.listCenter_10 = 旧措置者;
            } else if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getKyusochishaKubun())) {
                source.listCenter_10 = 旧措軽減;
            }
        }
        if (this.負担限度額認定者リストEntity.is受給者台帳Newest_旧措置者フラグ()) {
            source.listCenter_11 = 星;
        } else {
            source.listCenter_11 = RString.EMPTY;
        }
        source.listCenter_12 = get要介護度();

        if (null != this.負担限度額認定者リストEntity.get認定情報Entity() && null != this.負担限度額認定者リストEntity.get認定情報Entity().get認定情報_認定有効期間開始年月日()) {
            source.listCenter_13 = editTime(this.負担限度額認定者リストEntity.get認定情報Entity().get認定情報_認定有効期間開始年月日());
        }

        if (null != this.負担限度額認定者リストEntity.get非課税年金勘案額()) {
            source.listCenter_14 = 星;
        }
    }

    private RString editDecimal(Decimal decimal) {
        return new RString(KingakuFormatter.create(decimal).format(KingakuUnit.円)
                .setCommaSeparated().toString());
    }

    private RString editTime(FlexibleDate tempTime) {
        return tempTime.wareki().toDateString();
    }

    private RString get要介護度() {

        if (this.負担限度額認定者リストEntity.get認定情報Entity() != null
                && null != this.負担限度額認定者リストEntity.get認定情報Entity().get認定情報_要介護状態区分コード()
                && null != this.負担限度額認定者リストEntity.get要介護認定申請情報_厚労省IF識別コード()) {
            RString 要介護状態区分コード = 負担限度額認定者リストEntity.get認定情報Entity().get認定情報_要介護状態区分コード();
            KoroshoInterfaceShikibetsuCode 厚労省IF識別コード = KoroshoInterfaceShikibetsuCode.
                    toValue(負担限度額認定者リストEntity.get要介護認定申請情報_厚労省IF識別コード());
            return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護状態区分コード).getName();
        }
        return RString.EMPTY;

    }

    private void edit宛名(FutanGendogakuNinteiGaitoshaIchiranReportSource source, IKojin 世帯員宛名) {
        if (null != 世帯員宛名.get住所().get全国住所コード()) {
            source.listCenter_1 = 世帯員宛名.get住所().get全国住所コード().value();
        }
        if (null != 世帯員宛名.get住所().get郵便番号()) {
            source.listCenter_2 = 世帯員宛名.get住所().get郵便番号().value();
        }
        if (null != 世帯員宛名.get住所().get住所()) {
            source.listCenter_3 = 世帯員宛名.get住所().get住所();
        }
        if (null != 世帯員宛名.get住民状態().住民状態略称()) {
            source.listCenter_4 = 世帯員宛名.get住民状態().住民状態略称();
        }
        if (null != 世帯員宛名.get行政区画()) {
            source.listLower_2 = 世帯員宛名.get行政区画().getGyoseiku().getコード().value();
            source.listLower_3 = 世帯員宛名.get行政区画().getGyoseiku().get名称();
        }
        if (null != 世帯員宛名.get異動年月日()) {
            source.listLower_4 = editTime(世帯員宛名.get異動年月日());
        }

    }

    private void edit被保険者情報Lower(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getShoKisaiHokenshaNo()) {
            source.listLower_1 = this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getShoKisaiHokenshaNo().value();
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getTekiyoShuryoYMD()) {
            source.listLower_5 = this.editTime(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getTekiyoShuryoYMD());
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getUnitTypeKoshitsu()) {
            source.listLower_6 = editDecimal(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getUnitTypeKoshitsu());
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Tokuyo()) {
            source.listLower_7 = editDecimal(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Tokuyo());
        }
        if (null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getTashoshitsu()) {
            source.listLower_8 = editDecimal(this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getTashoshitsu());
        }
        if (null != this.負担限度額認定者リストEntity.get入所施設コード()) {
            source.listLower_9 = this.負担限度額認定者リストEntity.get入所施設コード();
        }
        if (null != this.負担限度額認定者リストEntity.get入所施設名称()) {
            source.listLower_10 = this.負担限度額認定者リストEntity.get入所施設名称();
        }
        if (null != this.負担限度額認定者リストEntity.get認定情報Entity() && null != this.負担限度額認定者リストEntity
                .get認定情報Entity().get認定情報_認定有効期間終了年月日()) {
            source.listLower_11 = editTime(this.負担限度額認定者リストEntity.get認定情報Entity().get認定情報_認定有効期間終了年月日());
        }
        if ((null != this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity() && null != this.負担限度額認定者リストEntity
                .get介護保険負担限度額認定Entity()) && (this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity()
                .getIzokuNenkinJukyuFlag() || this.負担限度額認定者リストEntity.get介護保険負担限度額認定Entity().getShogaiNenkinJukyuFlag())) {
            source.listLower_12 = 星;
        } else {
            source.listLower_12 = RString.EMPTY;
        }
    }

    private void edit世帯員(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        if (null != this.負担限度額認定者リストEntity.get世帯員リスト()
                && !this.負担限度額認定者リストEntity.get世帯員リスト().isEmpty()) {
            List<SetaiInRisutoEntity> 世帯員リスト = this.負担限度額認定者リストEntity.get世帯員リスト();
            if (世帯員リスト.size() > ((LISTINDEX_3 * index) - LISTINDEX_3)) {
                get世帯員Upper(source, 世帯員リスト.get((LISTINDEX_3 * index) - LISTINDEX_3));
            }
            if (世帯員リスト.size() > ((LISTINDEX_3 * index) - 2)) {
                get世帯員Center(source, 世帯員リスト.get((LISTINDEX_3 * index) - 2));
            }
            if (世帯員リスト.size() > ((LISTINDEX_3 * index) - 1)) {
                get世帯員Lower(source, 世帯員リスト.get((LISTINDEX_3 * index) - 1));
            }
        }
    }

    private void get世帯員Upper(FutanGendogakuNinteiGaitoshaIchiranReportSource source, SetaiInRisutoEntity 世帯員情報) {
        if (世帯員情報.get世帯員宛名() != null) {
            UaFt200FindShikibetsuTaishoEntity 世帯員宛名 = 世帯員情報.get世帯員宛名();
            IKojin 世帯員宛名1 = ShikibetsuTaishoFactory.createKojin(世帯員宛名);
            if (世帯員宛名1.get名称() != null) {
                source.listUpper_16 = 世帯員宛名1.get名称().getName().value();
            }
            if (世帯員宛名1.get住民状態() != null) {
                source.listUpper_17 = 世帯員宛名1.get住民状態().住民状態略称();
            }
            if (世帯員宛名1.get年齢算出().get年齢() != null) {
                source.listUpper_20 = 世帯員宛名1.get年齢算出().get年齢();
            }
        }
        if (世帯員情報.is受給者()) {
            source.listUpper_21 = 有;
        } else {
            source.listUpper_21 = RString.EMPTY;
        }

        if (KazeiKubun.課税.getコード().equals(世帯員情報.get課税区分())) {
            source.listUpper_18 = 課;
        } else {
            source.listUpper_18 = RString.EMPTY;
        }
        if (世帯員情報.get課税所得額() != null && 世帯員情報.get課税所得額().compareTo(Decimal.ZERO) > 0) {
            source.listUpper_19 = 課;
        } else {
            source.listUpper_19 = RString.EMPTY;
        }

    }

    private void get世帯員Center(FutanGendogakuNinteiGaitoshaIchiranReportSource source, SetaiInRisutoEntity 世帯員情報) {
        if (世帯員情報.get世帯員宛名() != null) {
            UaFt200FindShikibetsuTaishoEntity 世帯員宛名 = 世帯員情報.get世帯員宛名();
            IKojin 世帯員宛名1 = ShikibetsuTaishoFactory.createKojin(世帯員宛名);
            if (世帯員宛名1.get名称() != null) {
                source.listCenter_15 = 世帯員宛名1.get名称().getName().value();
            }
            if (世帯員宛名1.get住民状態() != null) {
                source.listCenter_16 = 世帯員宛名1.get住民状態().住民状態略称();
            }
            if (世帯員宛名1.get年齢算出().get年齢() != null) {
                source.listCenter_19 = 世帯員宛名1.get年齢算出().get年齢();
            }

        }
        if (世帯員情報.is受給者()) {
            source.listCenter_20 = 有;
        } else {
            source.listCenter_20 = RString.EMPTY;
        }
        if (KazeiKubun.課税.getコード().equals(世帯員情報.get課税区分())) {
            source.listCenter_17 = 課;
        }
        if (世帯員情報.get課税所得額() != null && 世帯員情報.get課税所得額().compareTo(Decimal.ZERO) > 0) {
            source.listCenter_18 = 課;
        }
    }

    private void get世帯員Lower(FutanGendogakuNinteiGaitoshaIchiranReportSource source, SetaiInRisutoEntity 世帯員情報) {
        if (世帯員情報.get世帯員宛名() != null) {
            UaFt200FindShikibetsuTaishoEntity 世帯員宛名 = 世帯員情報.get世帯員宛名();
            IKojin 世帯員宛名1 = ShikibetsuTaishoFactory.createKojin(世帯員宛名);
            if (世帯員宛名1.get名称() != null) {
                source.listLower_13 = 世帯員宛名1.get名称().getName().value();
            }
            if (世帯員宛名1.get住民状態() != null) {
                source.listLower_14 = 世帯員宛名1.get住民状態().住民状態略称();
            }
            if (世帯員宛名1.get年齢算出().get年齢() != null) {
                source.listLower_17 = 世帯員宛名1.get年齢算出().get年齢();
            }
        }
        if (世帯員情報.is受給者()) {
            source.listLower_18 = 有;
        } else {
            source.listLower_18 = RString.EMPTY;
        }
        if (KazeiKubun.課税.getコード().equals(世帯員情報.get課税区分())) {
            source.listLower_15 = 課;
        }
        if (世帯員情報.get課税所得額() != null && 世帯員情報.get課税所得額().compareTo(Decimal.ZERO) > 0) {
            source.listLower_16 = 課;
        }
    }

    private FutanGendogakuNinteiGaitoshaIchiranReportSource get申請日(
            FutanGendogakuNinteiGaitoshaIchiranReportSource source, FlexibleDate shinseiYMD) {
        if (null != shinseiYMD) {
            source.listUpper_8 = shinseiYMD.wareki().toDateString();
        }
        return source;
    }

    private FutanGendogakuNinteiGaitoshaIchiranReportSource get決定日(
            FutanGendogakuNinteiGaitoshaIchiranReportSource source, FlexibleDate ketteiYMD) {
        if (null != ketteiYMD) {
            source.listUpper_5 = ketteiYMD.wareki().toDateString();
        }
        return source;
    }

    private void set出力順改頁(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        List<ISetSortItem> 設定項目リスト = this.出力順.get設定項目リスト();
        if (設定項目リスト.size() > LISTINDEX_0) {
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                source.kaiPege1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                source.kaiPege2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_2) {
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                source.kaiPege3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
    }

}
