/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hanyolistfukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KyokaisoKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistfukadaicho.HanyoListFukaDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * バッチ設計_DBBBT22002_汎用リスト 賦課台帳CsvEditorのクラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
public class HanyoListFukaDaichoCsvEditor {

    private HanyoListFukaDaichoEntity 賦課台帳;
    private DbV1001HihokenshaDaichoEntity 被保険者台帳管理;
    private DbT2002FukaEntity 介護賦課;
    private List<UrT0705ChoteiKyotsuEntity> 調定共通list;
    private List<DbT2003KibetsuEntity> 介護期別list;
    private HanyoListFukaDaichoProcessParameter parameter;

    private static final RString 特例状態住特 = new RString("住特");
    private static final RString RSTONE = new RString("1");
    private static final RString 捕捉月２月 = new RString("02");
    private static final RString 捕捉月４月 = new RString("04");
    private static final RString 捕捉月６月 = new RString("06");
    private static final RString 捕捉月８月 = new RString("08");
    private static final RString 捕捉月１０月 = new RString("10");
    private static final RString 捕捉月１２月 = new RString("12");
    private static final RString 老年 = new RString("老年");
    private static final RString 生保 = new RString("生保");
    private static final RString 老年生保 = new RString("老年・生保");
    private static final RString 厚労省 = new RString("厚労省");
    private static final RString 地共済 = new RString("地共済");
    private static final RString 特徴 = new RString("特徴");
    private static final RString 普徴 = new RString("普徴");
    private static final RString 併徴 = new RString("併徴");
    private static final RString HOSHI = new RString("*");
    private static final RString 境界層 = new RString("境界層");
    private static final int INT_ONE = 1;
    private static final int INT_TWO = 2;
    private static final int INT_THREE = 3;
    private static final int INT_FOUR = 4;
    private static final int INT_FIVE = 5;
    private static final int INT_SIX = 6;
    private static final int INT_SEVEN = 7;
    private static final int INT_EIGHT = 8;
    private static final int INT_NINE = 9;
    private static final int INT_TEN = 10;
    private static final int INT_ELEVEN = 11;
    private static final int INT_TWELVE = 12;
    private static final int INT_THIRTEEN = 13;
    private static final int INT_FOURTEEN = 14;

    /**
     * editor
     *
     * @param entity HanyoListFukaDaichoEntity
     * @param parameter HanyoListFukaDaichoProcessParameter
     * @param 連番 Decimal
     * @param 保険料段階リスト HokenryoDankaiList
     * @param 構成市町村マスタlist List<KoseiShichosonMaster>
     * @param バッチ処理日 RDate
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @return HanyoListFukaDaichoCsvEntity
     */
    public HanyoListFukaDaichoCsvEntity editor(HanyoListFukaDaichoEntity entity,
            HanyoListFukaDaichoProcessParameter parameter, Decimal 連番, HokenryoDankaiList 保険料段階リスト,
            List<KoseiShichosonMaster> 構成市町村マスタlist, FlexibleDate バッチ処理日, ChohyoSeigyoKyotsu 帳票制御共通) {
        賦課台帳 = entity;
        被保険者台帳管理 = entity.get被保険者台帳管理Newest();
        介護賦課 = entity.get介護賦課();
        調定共通list = entity.get調定共通リスト();
        介護期別list = entity.get介護期別リスト();
        this.parameter = parameter;
        HanyoListFukaDaichoCsvEntity csvEntity = new HanyoListFukaDaichoCsvEntity();
        csvEntity.set連番(numToRString(連番));
        edit宛名(csvEntity, entity);
        edit地区(csvEntity, entity, 帳票制御共通);
        edit前住所(csvEntity, entity);
        edit宛先(csvEntity, entity);
        edit資格(csvEntity, entity);
        edit資格Two(csvEntity, 保険料段階リスト, 構成市町村マスタlist);
        edit介護賦課(csvEntity, バッチ処理日);
        csvEntity.set翌４月特依頼額(get翌４月特徴額(entity));
        editその他(csvEntity, バッチ処理日);
        return csvEntity;
    }

    private RString get徴収方法(int 偶数月) {
        RString 徴収方法 = RString.EMPTY;
        switch (偶数月) {
            case INT_ONE:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho12gatsu();
                break;
            case INT_TWO:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho2gatsu();
                break;
            case INT_THREE:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho2gatsu();
                break;
            case INT_FOUR:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho4gatsu();
                break;
            case INT_FIVE:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho4gatsu();
                break;
            case INT_SIX:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho6gatsu();
                break;
            case INT_SEVEN:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho6gatsu();
                break;
            case INT_EIGHT:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho8gatsu();
                break;
            case INT_NINE:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho8gatsu();
                break;
            case INT_TEN:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho10gatsu();
                break;
            case INT_ELEVEN:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho10gatsu();
                break;
            case INT_TWELVE:
                徴収方法 = 賦課台帳.get介護徴収方法().getChoshuHoho12gatsu();
                break;
            default:
                break;
        }
        return 徴収方法;
    }

    private void editその他(HanyoListFukaDaichoCsvEntity csvEntity, FlexibleDate バッチ処理日) {
        if (賦課台帳.is本算定後()) {
            csvEntity.set年金コード(賦課台帳.get介護徴収方法().getHonNenkinCode());
            csvEntity.set年金番号(賦課台帳.get介護徴収方法().getHonNenkinNo());
        } else {
            csvEntity.set年金コード(賦課台帳.get介護徴収方法().getKariNenkinCode());
            csvEntity.set年金番号(賦課台帳.get介護徴収方法().getKariNenkinNo());
        }
        if (parameter.get賦課年度().compareTo(parameter.get調定年度()) == 0) {
            int 偶数月;
            if (parameter.get基準日() != null) {
                偶数月 = parameter.get基準日().getMonthValue();
            } else {
                偶数月 = バッチ処理日.getMonthValue();
            }
            RString 徴収方法 = get徴収方法(偶数月);
            if (ChoshuHoho.特別徴収_厚生労働省.getコード().equals(徴収方法)) {
                csvEntity.set天引区分(厚労省);
            }
            if (ChoshuHoho.特別徴収_地共済.getコード().equals(徴収方法)) {
                csvEntity.set天引区分(地共済);
            }
        }
        if (賦課台帳.get特別徴収義務者コード() != null) {
            csvEntity.set特徴義務者(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(賦課台帳.get特別徴収義務者コード())));
        }
        RString 本徴収年金コード = 賦課台帳.get介護徴収方法().getHonNenkinCode();
        RString 仮徴収年金コード = 賦課台帳.get介護徴収方法().getKariNenkinCode();
        if (本徴収年金コード != null && 仮徴収年金コード != null) {
            if (賦課台帳.is本算定後()) {
                csvEntity.set年金種類(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                        UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                        new Code(本徴収年金コード.substring(0, INT_THREE))));
            } else {
                csvEntity.set年金種類(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                        UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                        new Code(仮徴収年金コード.substring(0, INT_THREE))));
            }
        }
        if (賦課台帳.get介護徴収方法().getHonHosokuM() != null
                && 賦課台帳.get介護徴収方法().getKariHosokuM() != null) {
            if (賦課台帳.is本算定後()) {
                csvEntity.set特徴捕捉月(賦課台帳.get介護徴収方法().getHonHosokuM());
            } else {
                csvEntity.set特徴捕捉月(賦課台帳.get介護徴収方法().getKariHosokuM());
            }
        }
        if (!csvEntity.get特徴捕捉月().isNullOrEmpty() && parameter.get調定年度() != null) {
            csvEntity.set特徴開始月(特別徴収開始月の判定(csvEntity.get特徴捕捉月()));
        }
        受給者台帳Newestの設定(csvEntity);
    }

    private void 受給者台帳Newestの設定(HanyoListFukaDaichoCsvEntity csvEntity) {
        if (賦課台帳.get受給者台帳Newest() != null) {
            if (賦課台帳.get受給者台帳Newest().getYokaigoJotaiKubunCode() != null) {
                csvEntity.set要介護度(YokaigoJotaiKubun.toValue(賦課台帳.get受給者台帳Newest().getYokaigoJotaiKubunCode().value()).getName());
            }
            if (賦課台帳.get受給者台帳Newest().getNinteiYukoKikanKaishiYMD() != null) {
                csvEntity.set認定開始日(dataToRString(賦課台帳.get受給者台帳Newest().getNinteiYukoKikanKaishiYMD()));
            }
            if (賦課台帳.get受給者台帳Newest().getNinteiYukoKikanShuryoYMD() != null) {
                csvEntity.set認定終了日(dataToRString(賦課台帳.get受給者台帳Newest().getNinteiYukoKikanShuryoYMD()));
            }
            if (賦課台帳.get受給者台帳Newest().getNinteiYMD() != null) {
                csvEntity.set認定日(dataToRString(賦課台帳.get受給者台帳Newest().getNinteiYMD()));
            }
        }
    }

    private RString 特別徴収開始月の判定(RString 特徴捕捉月) {
        RString 特徴開始月;
        if (捕捉月２月.equals(特徴捕捉月)) {
            特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_2月捕捉,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (捕捉月８月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().plusYear(1).getYearValue()).concat(特徴開始月);
            }
        }
        if (捕捉月４月.equals(特徴捕捉月)) {
            特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_4月捕捉,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (捕捉月１０月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().getYearValue()).concat(特徴開始月);
            }
        }
        if (捕捉月６月.equals(特徴捕捉月)) {
            特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (捕捉月１２月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().getYearValue()).concat(特徴開始月);
            }
            if (捕捉月４月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().plusYear(1).getYearValue()).concat(特徴開始月);
            }
        }
        if (捕捉月８月.equals(特徴捕捉月)) {
            特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (捕捉月２月.equals(特徴開始月) || 捕捉月４月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().plusYear(1).getYearValue()).concat(特徴開始月);
            }
        }
        if (捕捉月１０月.equals(特徴捕捉月)) {
            特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_10月捕捉,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (捕捉月４月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().plusYear(1).getYearValue()).concat(特徴開始月);
            }
        }
        if (捕捉月１２月.equals(特徴捕捉月)) {
            特徴開始月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_12月捕捉,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
            if (捕捉月６月.equals(特徴開始月)) {
                return new RString(parameter.get賦課年度().plusYear(1).getYearValue()).concat(特徴開始月);
            }
        }
        return RString.EMPTY;
    }

    private void edit介護賦課(HanyoListFukaDaichoCsvEntity csvEntity, FlexibleDate バッチ処理日) {
        if (介護賦課.getGokeiShotokuGaku() != null) {
            csvEntity.set本人所得額(numToRString(介護賦課.getGokeiShotokuGaku()));
        }
        csvEntity.set課税区分(KazeiKubun.toValue(介護賦課.getKazeiKubun()).get名称());
        csvEntity.set世帯課税区分(KazeiKubun.toValue(介護賦課.getSetaikazeiKubun()).get名称());
        csvEntity.set確定年額保険料(numToRString(介護賦課.getKakuteiHokenryo()));
        for (DbT2003KibetsuEntity entity : 介護期別list) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(entity.getChoshuHouhou())) {
                switch (entity.getKi()) {
                    case INT_ONE:
                        csvEntity.set特徴納付額１期(get調定額(entity.getChoteiId()));
                        break;
                    case INT_TWO:
                        csvEntity.set特徴納付額２期(get調定額(entity.getChoteiId()));
                        break;
                    case INT_THREE:
                        csvEntity.set特徴納付額３期(get調定額(entity.getChoteiId()));
                        break;
                    case INT_FOUR:
                        csvEntity.set特徴納付額４期(get調定額(entity.getChoteiId()));
                        break;
                    case INT_FIVE:
                        csvEntity.set特徴納付額５期(get調定額(entity.getChoteiId()));
                        break;
                    case INT_SIX:
                        csvEntity.set特徴納付額６期(get調定額(entity.getChoteiId()));
                        break;
                    default:
                        break;
                }
            }
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(entity.getChoshuHouhou())) {
                set普徴納付額(csvEntity, entity);
            }
        }
        csvEntity.set減免額(numToRString(介護賦課.getGemmenGaku()));
        edit老年と生保(csvEntity, バッチ処理日);
        YMDHMS 調定日 = 介護賦課.getChoteiNichiji();
        if (調定日 != null) {
            csvEntity.set調定日(dataToRString(new FlexibleDate(調定日.getDate().toString())));
        }
        if (KozaKubun.口座振替.getコード().equals(介護賦課.getKozaKubun())) {
            csvEntity.set口座対象者(HOSHI);
        }
        csvEntity.set年金収入額(numToRString(介護賦課.getNenkinShunyuGaku()));
        csvEntity.set生活保護種別(new FujoShuruiCodeValue(介護賦課.getSeihofujoShurui()).getRyakusho());
        if (KyokaisoKubun.該当.getコード().equals(介護賦課.getKyokaisoKubun())) {
            csvEntity.set境界層区分(境界層);
        }

        csvEntity.set調定年度(new RString(介護賦課.getChoteiNendo().getYearValue()));
        csvEntity.set賦課年度(new RString(介護賦課.getFukaNendo().getYearValue()));
        csvEntity.set特徴歳出還付額(numToRString(介護賦課.getTkSaishutsuKampuGaku()));
        csvEntity.set普徴歳出還付額(numToRString(介護賦課.getFuSaishutsuKampuGaku()));
    }

    private RString get調定額(Decimal 調定ID) {
        for (UrT0705ChoteiKyotsuEntity entity : 調定共通list) {
            if (調定ID.compareTo(new Decimal(entity.getChoteiId())) == 0) {
                return numToRString(entity.getChoteigaku());
            }
        }
        return RString.EMPTY;
    }

    private void set普徴納付額(HanyoListFukaDaichoCsvEntity csvEntity, DbT2003KibetsuEntity entity) {
        switch (entity.getKi()) {
            case INT_ONE:
                csvEntity.set普徴納付額１期(get調定額(entity.getChoteiId()));
                break;
            case INT_TWO:
                csvEntity.set普徴納付額２期(get調定額(entity.getChoteiId()));
                break;
            case INT_THREE:
                csvEntity.set普徴納付額３期(get調定額(entity.getChoteiId()));
                break;
            case INT_FOUR:
                csvEntity.set普徴納付額４期(get調定額(entity.getChoteiId()));
                break;
            case INT_FIVE:
                csvEntity.set普徴納付額５期(get調定額(entity.getChoteiId()));
                break;
            case INT_SIX:
                csvEntity.set普徴納付額６期(get調定額(entity.getChoteiId()));
                break;
            case INT_SEVEN:
                csvEntity.set普徴納付額７期(get調定額(entity.getChoteiId()));
                break;
            case INT_EIGHT:
                csvEntity.set普徴納付額８期(get調定額(entity.getChoteiId()));
                break;
            case INT_NINE:
                csvEntity.set普徴納付額９期(get調定額(entity.getChoteiId()));
                break;
            case INT_TEN:
                csvEntity.set普徴納付額１０期(get調定額(entity.getChoteiId()));
                break;
            case INT_ELEVEN:
                csvEntity.set普徴納付額１１期(get調定額(entity.getChoteiId()));
                break;
            case INT_TWELVE:
                csvEntity.set普徴納付額１２期(get調定額(entity.getChoteiId()));
                break;
            case INT_THIRTEEN:
                csvEntity.set普徴納付額１３期(get調定額(entity.getChoteiId()));
                break;
            case INT_FOURTEEN:
                csvEntity.set普徴納付額１４期(get調定額(entity.getChoteiId()));
                break;
            default:
                break;
        }
    }

    private void edit老年と生保(HanyoListFukaDaichoCsvEntity csvEntity, FlexibleDate バッチ処理日) {
        boolean 老年flag = false;
        boolean 生保flag = false;
        FlexibleDate 老年開始日 = 介護賦課.getRonenKaishiYMD();
        FlexibleDate 老年廃止日 = 介護賦課.getRonenHaishiYMD();
        FlexibleDate 生保開始日 = 介護賦課.getSeihoKaishiYMD();
        FlexibleDate 生保廃止日 = 介護賦課.getSeihoHaishiYMD();
        if (老年開始日 != null && !老年開始日.isEmpty() && 老年開始日.isBeforeOrEquals(バッチ処理日)
                && (老年廃止日 == null || バッチ処理日.isBeforeOrEquals(老年廃止日))) {
            老年flag = true;
        }
        if (生保開始日 != null && !生保開始日.isEmpty() && 生保開始日.isBeforeOrEquals(バッチ処理日)
                && (生保廃止日 == null || バッチ処理日.isBeforeOrEquals(生保廃止日))) {
            生保flag = true;
        }
        if (老年flag && 生保flag) {
            csvEntity.set老年_生保(老年生保);
        }
        if (老年flag && !生保flag) {
            csvEntity.set老年_生保(老年);
        }
        if (!老年flag && 生保flag) {
            csvEntity.set老年_生保(生保);
        }
    }

    private void edit宛名(HanyoListFukaDaichoCsvEntity csvEntity, HanyoListFukaDaichoEntity entity) {
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        ShikibetsuCode shikibetsuCode = entity.get宛名().getShikibetsuCode();
        if (shikibetsuCode != null) {
            csvEntity.set識別コード(shikibetsuCode.getColumnValue());
        } else {
            csvEntity.set識別コード(RString.EMPTY);
        }
        RString 住民種別 = 宛名.get住民状態().住民状態略称();
        csvEntity.set住民種別(isNull(住民種別) ? RString.EMPTY : 住民種別);
        AtenaMeisho atenaMeisho = entity.get宛名().getKanjiShimei();
        if (atenaMeisho != null) {
            csvEntity.set氏名(atenaMeisho.getColumnValue());
        } else {
            csvEntity.set氏名(RString.EMPTY);
        }
        AtenaKanaMeisho atenaKanaMeisho = entity.get宛名().getKanaShimei();
        if (atenaKanaMeisho != null) {
            csvEntity.set氏名カナ(atenaKanaMeisho.getColumnValue());
        } else {
            csvEntity.set氏名カナ(RString.EMPTY);
        }
        csvEntity.set生年月日(dataToRString(entity.get宛名().getSeinengappiYMD()));
        AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(),
                宛名.get消除異動年月日());
        csvEntity.set年齢(ageCalculator.get年齢());
        if (宛名.get性別() != null) {
            csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
        }
        TsuzukigaraCode tsuzukigaraCode = entity.get宛名().getTsuzukigaraCode();
        if (tsuzukigaraCode != null) {
            csvEntity.set続柄コード(tsuzukigaraCode.getColumnValue());
        } else {
            csvEntity.set続柄コード(RString.EMPTY);
        }
        SetaiCode setaiCode = entity.get宛名().getSetaiCode();
        if (setaiCode != null) {
            csvEntity.set世帯コード(setaiCode.getColumnValue());
        } else {
            csvEntity.set世帯コード(RString.EMPTY);
        }
        AtenaMeisho atenaMeisho1 = entity.get宛名().getSetainushiMei();
        if (atenaMeisho1 != null) {
            csvEntity.set世帯主名(atenaMeisho1.getColumnValue());
        } else {
            csvEntity.set世帯主名(RString.EMPTY);
        }
        ChoikiCode 住所コード = 宛名.get住所().get町域コード();
        if (住所コード != null) {
            csvEntity.set住所コード(住所コード.getColumnValue());
        } else {
            csvEntity.set住所コード(RString.EMPTY);
        }
        YubinNo yubinNo = entity.get宛名().getYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            csvEntity.set郵便番号(yubinNo.getEditedYubinNo());
        } else {
            csvEntity.set郵便番号(RString.EMPTY);
        }
    }

    private void edit地区(HanyoListFukaDaichoCsvEntity csvEntity,
            HanyoListFukaDaichoEntity entity, ChohyoSeigyoKyotsu 帳票制御共通) {
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(entity.get被保険者台帳管理Newest().getShichosonCode(),
                FlexibleDate.getNowDate());
        RString 住所番地方書 = JushoHenshu.editJusho(帳票制御共通, 宛名, 地方公共団体);
        csvEntity.set住所と番地と方書(住所番地方書);
        AtenaJusho atenaJusho = entity.get宛名().getJusho();
        AtenaBanchi atenaBanchi = entity.get宛名().getBanchi();
        Katagaki katagaki = entity.get宛名().getKatagaki();
        if (atenaJusho != null) {
            csvEntity.set住所(atenaJusho.getColumnValue());
        } else {
            csvEntity.set住所(RString.EMPTY);
        }
        if (atenaBanchi != null) {
            csvEntity.set番地(atenaBanchi.getColumnValue());
        } else {
            csvEntity.set番地(RString.EMPTY);
        }
        if (katagaki != null) {
            csvEntity.set方書(katagaki.getColumnValue());
        } else {
            csvEntity.set方書(RString.EMPTY);
        }
        GyoseikuCode gyoseikuCode = entity.get宛名().getGyoseikuCode();
        if (gyoseikuCode != null) {
            csvEntity.set行政区コード(gyoseikuCode.value());
        } else {
            csvEntity.set行政区コード(RString.EMPTY);
        }
        csvEntity.set行政区名(isNull(entity.get宛名().getGyoseikuName())
                ? RString.EMPTY : entity.get宛名().getGyoseikuName());
        RString 地区1 = RString.EMPTY;
        RString 地区2 = RString.EMPTY;
        RString 地区3 = RString.EMPTY;
        if (宛名.get行政区画() != null && 宛名.get行政区画().getChiku1() != null) {
            地区1 = 宛名.get行政区画().getChiku1().getコード().getColumnValue();
        }
        if (宛名.get行政区画() != null && 宛名.get行政区画().getChiku2() != null) {
            地区2 = 宛名.get行政区画().getChiku2().getコード().getColumnValue();
        }
        if (宛名.get行政区画() != null && 宛名.get行政区画().getChiku3() != null) {
            地区3 = 宛名.get行政区画().getChiku3().getコード().getColumnValue();
        }
        csvEntity.set地区１(地区1);
        csvEntity.set地区２(地区2);
        csvEntity.set地区３(地区3);
        TelNo telNo = entity.get宛名().getRenrakusaki1();
        if (telNo != null) {
            csvEntity.set連絡先１(telNo.value());
        } else {
            csvEntity.set連絡先１(RString.EMPTY);
        }
        TelNo telNo2 = entity.get宛名().getRenrakusaki2();
        if (telNo2 != null) {
            csvEntity.set連絡先２(telNo2.value());
        } else {
            csvEntity.set連絡先２(RString.EMPTY);
        }
    }

    private void edit前住所(HanyoListFukaDaichoCsvEntity csvEntity, HanyoListFukaDaichoEntity entity) {
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        IIdoJiyu 登録事由 = 宛名.get登録事由();
        IIdoJiyu 住定事由 = 宛名.get住定事由();
        IIdoJiyu 消除事由 = 宛名.get消除事由();
        csvEntity.set登録異動日(dataToRString(entity.get宛名().getTorokuIdoYMD()));
        csvEntity.set登録事由(登録事由 != null ? 登録事由.get異動事由コード() : RString.EMPTY);
        csvEntity.set登録届出日(dataToRString(entity.get宛名().getTorokuTodokedeYMD()));
        csvEntity.set住定異動日(dataToRString(entity.get宛名().getJuteiIdoYMD()));
        csvEntity.set住定事由(住定事由 != null ? 住定事由.get異動事由コード() : RString.EMPTY);
        csvEntity.set住定届出日(dataToRString(entity.get宛名().getJuteiTodokedeYMD()));
        csvEntity.set消除異動日(dataToRString(entity.get宛名().getShojoIdoYMD()));
        csvEntity.set消除事由(登録事由 != null ? 消除事由.get異動事由コード() : RString.EMPTY);
        csvEntity.set消除届出日(dataToRString(entity.get宛名().getShojoTodokedeYMD()));
        csvEntity.set転出入理由(RString.EMPTY);
        YubinNo yubinNo = entity.get宛名().getTennyumaeYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            csvEntity.set前住所郵便番号(yubinNo.getEditedYubinNo());
        } else {
            csvEntity.set前住所郵便番号(RString.EMPTY);
        }
        AtenaJusho atenaJusho1 = entity.get宛名().getTennyumaeJusho();
        AtenaBanchi atenaBanchi1 = entity.get宛名().getTennyumaeBanchi();
        Katagaki katagaki1 = entity.get宛名().getTennyumaeKatagaki();
        StringBuilder stringBuilder1 = new StringBuilder();
        if (atenaJusho1 != null) {
            stringBuilder1.append(atenaJusho1.value());
        }
        if (atenaBanchi1 != null) {
            stringBuilder1.append(atenaBanchi1.value());
        }
        if (0 < stringBuilder1.length()) {
            stringBuilder1.append(RString.FULL_SPACE);
        }
        if (katagaki1 != null) {
            stringBuilder1.append(katagaki1.value());
        }
        if (0 < stringBuilder1.length()) {
            csvEntity.set前住所と番地と方書(new RString(stringBuilder1.toString()));
        } else {
            csvEntity.set前住所と番地と方書(RString.EMPTY);
        }
        if (atenaJusho1 != null) {
            csvEntity.set前住所(atenaJusho1.value());
        } else {
            csvEntity.set前住所(RString.EMPTY);
        }
        if (atenaBanchi1 != null) {
            csvEntity.set前住所番地(atenaBanchi1.value());
        } else {
            csvEntity.set前住所番地(RString.EMPTY);
        }
        if (katagaki1 != null) {
            csvEntity.set前住所方書(katagaki1.value());
        } else {
            csvEntity.set前住所方書(RString.EMPTY);
        }
    }

    private void edit宛先(HanyoListFukaDaichoCsvEntity csvEntity,
            HanyoListFukaDaichoEntity entity) {
        csvEntity.set市町村コード(isNull(entity.get被保険者台帳管理Newest().getShichosonCode())
                ? RString.EMPTY : entity.get被保険者台帳管理Newest().getShichosonCode().value());
        Association 地方公共団体 = AssociationFinderFactory.createInstance()
                .getAssociation(entity.get被保険者台帳管理Newest().getShichosonCode(), FlexibleDate.getNowDate());
        csvEntity.set市町村名(地方公共団体.get市町村名());
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        if (association != null) {
            csvEntity.set保険者コード(association.get地方公共団体コード().getColumnValue());
            csvEntity.set保険者名(association.get市町村名());
        }
        AtenaMeisho atenaMeisho2 = entity.get宛先().getKanjiShimei();
        if (atenaMeisho2 != null) {
            csvEntity.set送付先氏名(atenaMeisho2.value());
        } else {
            csvEntity.set送付先氏名(RString.EMPTY);
        }
        AtenaKanaMeisho atenaKanaMeisho1 = entity.get宛先().getKanaShimei();
        if (atenaKanaMeisho1 != null) {
            csvEntity.set送付先氏名カナ(atenaKanaMeisho1.value());
        } else {
            csvEntity.set送付先氏名カナ(RString.EMPTY);
        }
        ZenkokuJushoCode zenkokuJushoCode1 = entity.get宛先().getZenkokuJushoCode();
        if (zenkokuJushoCode1 != null) {
            csvEntity.set送付先住所コード(zenkokuJushoCode1.getColumnValue());
        } else {
            csvEntity.set送付先住所コード(RString.EMPTY);
        }
        YubinNo yubinNo = entity.get宛先().getYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            csvEntity.set送付先郵便番号(yubinNo.getEditedYubinNo());
        } else {
            csvEntity.set送付先郵便番号(RString.EMPTY);
        }
        AtenaJusho atenaJusho2 = entity.get宛先().getJusho();
        AtenaBanchi atenaBanchi2 = entity.get宛先().getBanchi();
        Katagaki katagaki2 = entity.get宛先().getKatagaki();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (atenaJusho2 != null) {
            stringBuilder2.append(atenaJusho2.getColumnValue());
        }
        if (atenaBanchi2 != null) {
            stringBuilder2.append(atenaBanchi2.getColumnValue());
        }
        if (0 < stringBuilder2.length()) {
            stringBuilder2.append(RString.FULL_SPACE);
        }
        if (katagaki2 != null) {
            stringBuilder2.append(katagaki2.getColumnValue());
        }
        if (0 < stringBuilder2.length()) {
            csvEntity.set送付先住所と番地と方書(new RString(stringBuilder2.toString()));
        } else {
            csvEntity.set送付先住所と番地と方書(RString.EMPTY);
        }
        if (atenaJusho2 != null) {
            csvEntity.set送付先住所(atenaJusho2.getColumnValue());
        } else {
            csvEntity.set送付先住所(RString.EMPTY);
        }
        if (atenaBanchi2 != null) {
            csvEntity.set送付先番地(atenaBanchi2.value());
        } else {
            csvEntity.set送付先番地(RString.EMPTY);
        }
        if (katagaki2 != null) {
            csvEntity.set送付先方書(katagaki2.value());
        } else {
            csvEntity.set送付先方書(RString.EMPTY);
        }
        GyoseikuCode gyoseikuCode1 = entity.get宛先().getGyoseikuCode();
        if (gyoseikuCode1 != null) {
            csvEntity.set送付先行政区コード(gyoseikuCode1.value());
        } else {
            csvEntity.set送付先行政区コード(RString.EMPTY);
        }
    }

    private void edit資格(HanyoListFukaDaichoCsvEntity csvEntity, HanyoListFukaDaichoEntity entity) {
        csvEntity.set送付先行政区名(isNull(entity.get宛先().getGyoseiku())
                ? RString.EMPTY : entity.get宛名().getGyoseikuName());
        csvEntity.set被保険者番号(isNull(被保険者台帳管理.getHihokenshaNo())
                ? RString.EMPTY : 被保険者台帳管理.getHihokenshaNo().value());
        RString 資格取得事由 = RString.EMPTY;
        if (被保険者台帳管理.getShikakuShutokuJiyuCode() != null) {
            資格取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格取得事由_被保険者.getコード(),
                    new Code(被保険者台帳管理.getShikakuShutokuJiyuCode()), FlexibleDate.getNowDate());
        }
        csvEntity.set資格取得事由(資格取得事由);
        csvEntity.set資格取得日(dataToRString(被保険者台帳管理.getShikakuShutokuYMD()));
        csvEntity.set資格取得届出日(dataToRString(被保険者台帳管理.getShikakuShutokuTodokedeYMD()));
        RString 喪失事由 = RString.EMPTY;
        if (被保険者台帳管理.getShikakuSoshitsuJiyuCode() != null && !被保険者台帳管理.getShikakuSoshitsuJiyuCode().isEmpty()) {
            喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(),
                    new Code(被保険者台帳管理.getShikakuSoshitsuJiyuCode()), FlexibleDate.getNowDate());
        }
        csvEntity.set喪失事由(喪失事由);
        csvEntity.set資格喪失日(dataToRString(被保険者台帳管理.getShikakuSoshitsuYMD()));
        csvEntity.set資格喪失届出日(dataToRString(被保険者台帳管理.getShikakuSoshitsuTodokedeYMD()));
        HihokenshaKubunCode hihokenshaKubunCode = HihokenshaKubunCode.toValue(被保険者台帳管理.getHihokennshaKubunCode());
        csvEntity.set資格区分(hihokenshaKubunCode.get名称());
        if (RSTONE.equals(被保険者台帳管理.getJushochiTokureiFlag())) {
            csvEntity.set住所地特例状態(特例状態住特);
        } else {
            csvEntity.set住所地特例状態(RString.EMPTY);
        }
    }

    private void edit資格Two(HanyoListFukaDaichoCsvEntity csvEntity,
            HokenryoDankaiList 保険料段階リスト, List<KoseiShichosonMaster> 構成市町村マスタlist) {
        if (RSTONE.equals(被保険者台帳管理.getKoikinaiJushochiTokureiFlag())) {
            set保険者番号By広住特措置元市町村コード(csvEntity, 構成市町村マスタlist);
        } else {
            set保険者番号By市町村コード(csvEntity, 構成市町村マスタlist);
        }
        csvEntity.set通知書番号(介護賦課.getTsuchishoNo().value());
        csvEntity.set徴収方法(get徴収方法2());
        if (保険料段階リスト != null && 介護賦課.getHokenryoDankai() != null) {
            csvEntity.set保険料段階(保険料段階リスト.getBy段階区分(介護賦課.getHokenryoDankai()).get表記());
        }
        if (保険料段階リスト != null && 介護賦課.getHokenryoDankaiKarisanntei() != null) {
            csvEntity.set保険料段階_仮算定時(保険料段階リスト.getBy段階区分(介護賦課.getHokenryoDankaiKarisanntei()).get表記());
        }
    }

    private RString get徴収方法2() {
        boolean 特別徴収flag = false;
        boolean 普通徴収flag = false;
        for (DbT2003KibetsuEntity 介護期別 : 介護期別list) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(介護期別.getChoshuHouhou())) {
                if (特別徴収flag) {
                    continue;
                }
                特別徴収flag = 徴収方法判定(介護期別);
            }
            if (ChoshuHohoKibetsu.普通徴収.getコード().equals(介護期別.getChoshuHouhou())) {
                if (普通徴収flag) {
                    continue;
                }
                普通徴収flag = 徴収方法判定(介護期別);
            }
        }
        if (特別徴収flag && 普通徴収flag) {
            return 併徴;
        }
        if (特別徴収flag && !普通徴収flag) {
            return 特徴;
        }
        if (!特別徴収flag && 普通徴収flag) {
            return 普徴;
        }
        return RString.EMPTY;
    }

    private boolean 徴収方法判定(DbT2003KibetsuEntity 介護期別) {
        for (UrT0705ChoteiKyotsuEntity 調定共通 : 調定共通list) {
            if (介護期別.getChoteiId().compareTo(new Decimal(調定共通.getChoteiId())) == 0) {
                return Decimal.ZERO
                        .compareTo(調定共通.getChoteigaku() == null ? Decimal.ZERO : 調定共通.getChoteigaku()) < 0;
            }
        }
        return false;
    }

    private void set保険者番号By広住特措置元市町村コード(HanyoListFukaDaichoCsvEntity csvEntity,
            List<KoseiShichosonMaster> 構成市町村マスタlist) {
        if (0 < 構成市町村マスタlist.size() && 被保険者台帳管理.getKoikinaiTokureiSochimotoShichosonCode() != null) {
            for (int i = 0; i < 構成市町村マスタlist.size(); i++) {
                if (被保険者台帳管理.getKoikinaiTokureiSochimotoShichosonCode()
                        .equals(構成市町村マスタlist.get(i).get市町村コード())) {
                    csvEntity.set資格_証記載保険者番号(構成市町村マスタlist.get(i).get証記載保険者番号().getColumnValue());
                }
            }
        }
    }

    private void set保険者番号By市町村コード(HanyoListFukaDaichoCsvEntity csvEntity,
            List<KoseiShichosonMaster> 構成市町村マスタlist) {
        if (0 < 構成市町村マスタlist.size() && 被保険者台帳管理.getShichosonCode() != null) {
            for (int i = 0; i < 構成市町村マスタlist.size(); i++) {
                if (被保険者台帳管理.getShichosonCode().equals(構成市町村マスタlist.get(i).get市町村コード())) {
                    csvEntity.set資格_証記載保険者番号(構成市町村マスタlist.get(i).get証記載保険者番号().getColumnValue());
                }
            }
        }
    }

    private RString get翌４月特徴額(HanyoListFukaDaichoEntity entity) {
        Decimal 翌４月特徴額 = Decimal.ZERO;
        for (UrT0705ChoteiKyotsuEntity 調定共通 : entity.get調定共通リスト()) {
            if (翌４月特徴額.compareTo(調定共通.getChoteigaku()) < 0) {
                翌４月特徴額 = 調定共通.getChoteigaku();
            }
        }
        return numToRString(翌４月特徴額);
    }

    private RString numToRString(Decimal decimal) {
        if (decimal == null) {
            return RString.EMPTY;
        }
        return new RString(decimal.toString());
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private RString dataToRString(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        if (!parameter.is日付編集()) {
            return new RString(日付.toString());
        } else {
            return 日付.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
    }
}
