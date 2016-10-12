/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.ModifyNinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.KouikiyoukaigoNinteishinseiJouhouTempEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報IF編集_business処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class ModifyNinteiShinseiJohoManager {

    private static final int NO_10 = 10;
    private static final int NO_24 = 24;
    private static final int NO_32 = 32;
    private static final int NO_33 = 33;
    private static final int NO_34 = 34;
    private static final int NO_35 = 35;
    private static final int NO_36 = 36;
    private static final int NO_37 = 37;
    private static final int NO_38 = 38;
    private static final int NO_39 = 39;
    private static final int NO_40 = 40;
    private static final int NO_41 = 41;
    private static final int NO_42 = 42;
    private static final int NO_43 = 43;
    private static final int NO_44 = 44;
    private static final int NO_45 = 45;
    private static final int NO_46 = 46;
    private static final int NO_47 = 47;
    private static final int NO_48 = 48;
    private static final int NO_49 = 49;
    private static final int NO_50 = 50;
    private static final int NO_51 = 51;
    private static final int NO_52 = 52;
    private static final int NO_53 = 53;
    private static final int NO_54 = 54;
    private static final int NO_55 = 55;
    private static final int NO_56 = 56;
    private static final int NO_57 = 57;
    private static final int NO_58 = 58;
    private static final int NO_59 = 59;
    private static final int NO_60 = 60;
    private static final int NO_61 = 61;
    private static final int NO_62 = 62;
    private static final int NO_63 = 63;
    private static final int NO_64 = 64;
    private static final int NO_65 = 65;
    private static final int NO_66 = 66;
    private static final int NO_67 = 67;
    private static final int NO_68 = 68;
    private static final int NO_69 = 69;
    private static final int NO_70 = 70;
    private static final int NO_71 = 71;
    private static final int NO_72 = 72;
    private static final int NO_73 = 73;
    private static final int NO_74 = 74;
    private static final int NO_75 = 75;
    private static final int NO_76 = 76;
    private static final int NO_77 = 77;
    private static final int NO_78 = 78;
    private static final int NO_79 = 79;
    private static final int NO_80 = 80;
    private static final int NO_81 = 81;
    private static final int NO_82 = 82;
    private static final int NO_83 = 83;
    private static final int NO_84 = 84;
    private static final int NO_85 = 85;
    private static final int NO_86 = 86;
    private static final int NO_87 = 87;
    private static final int NO_88 = 88;
    private static final int NO_89 = 89;
    private static final int NO_90 = 90;
    private static final int NO_91 = 91;
    private static final int NO_92 = 92;
    private static final int NO_93 = 93;
    private static final int NO_94 = 94;
    private static final int NO_95 = 95;
    private static final int NO_96 = 96;
    private static final int NO_97 = 97;
    private static final int NO_98 = 98;
    private static final int NO_99 = 99;
    private static final int NO_100 = 100;
    private static final int NO_101 = 101;
    private static final int NO_102 = 102;
    private static final int NO_103 = 103;
    private static final int NO_104 = 104;
    private static final int NO_105 = 105;
    private static final int NO_106 = 106;
    private static final int NO_107 = 107;
    private static final int NO_108 = 108;
    private static final int NO_109 = 109;
    private static final int NO_110 = 110;
    private static final int NO_111 = 111;
    private static final int NO_112 = 112;
    private static final int NO_113 = 113;
    private static final int NO_114 = 114;
    private static final int NO_115 = 115;
    private static final int NO_116 = 116;
    private static final int NO_117 = 117;
    private static final int NO_118 = 118;
    private static final int NO_119 = 119;
    private static final int NO_120 = 120;
    private static final int NO_121 = 121;
    private static final int NO_122 = 122;
    private static final int NO_123 = 123;
    private static final int NO_124 = 124;
    private static final int NO_125 = 125;
    private static final int NO_126 = 126;
    private static final int NO_127 = 127;
    private static final int NO_128 = 128;
    private static final int NO_129 = 129;
    private static final int NO_130 = 130;
    private static final int NO_131 = 131;
    private static final int NO_132 = 132;
    private static final int NO_133 = 133;
    private static final int NO_134 = 134;
    private static final int NO_135 = 135;
    private static final int NO_136 = 136;
    private static final int NO_137 = 137;
    private static final int NO_138 = 138;
    private static final int NO_139 = 139;
    private static final int NO_140 = 140;
    private static final int NO_141 = 141;
    private static final int NO_142 = 142;
    private static final int NO_143 = 143;
    private static final int NO_144 = 144;
    private static final int NO_145 = 145;
    private static final int NO_146 = 146;
    private static final int NO_147 = 147;
    private static final int NO_148 = 148;
    private static final int NO_149 = 149;
    private static final int NO_150 = 150;
    private static final int NO_151 = 151;
    private static final int NO_152 = 152;
    private static final int NO_153 = 153;
    private static final int NO_154 = 154;
    private static final int NO_155 = 155;
    private static final int NO_156 = 156;
    private static final int NO_157 = 157;
    private static final int NO_158 = 158;
    private static final int NO_159 = 159;
    private static final int NO_160 = 160;
    private static final int NO_161 = 161;
    private static final int NO_162 = 162;
    private static final int NO_163 = 163;
    private static final int NO_164 = 164;
    private static final int NO_165 = 165;
    private static final int NO_166 = 166;
    private static final int NO_167 = 167;
    private static final int NO_168 = 168;
    private static final int NO_169 = 169;
    private static final int NO_170 = 170;
    private static final int NO_171 = 171;
    private RString 編集状況フラグ = new RString("0");

    /**
     * 申請情報IF編集。
     *
     * @param entity ModifyNinteiShinseiJohoEntity
     * @param i int
     * @param 認定申請IF種類 RString
     * @param 市町村コード LasdecCode
     * @param tempEntity KouikiyoukaigoNinteishinseiJouhouTempEntity
     * @return 編集状況フラグ
     */
    public RString 申請情報IF編集(ModifyNinteiShinseiJohoEntity entity, long i, RString 認定申請IF種類, LasdecCode 市町村コード,
            KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity) {
        List<RString> 前回データ情報リスト = new ArrayList<>();
        if (entity.get一次判定内容() != null) {
            前回データ情報リスト = entity.get一次判定内容().split("|");
        }
        RString シーケンシャル番号 = new RString(String.format("%06d", i));
        creatTempEntity(entity, シーケンシャル番号, tempEntity);
        setTempEntityBy前回データ情報1(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報2(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報3(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報4(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報5(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報6(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報7(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報8(tempEntity, 前回データ情報リスト);
        setTempEntityBy前回データ情報9(tempEntity, 前回データ情報リスト);
        List<DbT4150RenrakusakiJohoEntity> 介護連絡先情報List = new ArrayList<>();
        if (entity.get連絡先情報() != null) {
            介護連絡先情報List = entity.get連絡先情報();
        }
        if (!認定申請IF種類.equals(new RString("4"))) {
            setTempEntity電算標準版(entity, tempEntity, 市町村コード);
            setTempEntity(tempEntity, 介護連絡先情報List);
            checkTempEntity(tempEntity, entity);
        }
        checkTempEntity1(tempEntity, entity);
        checkTempEntity2(tempEntity, entity);
        return 編集状況フラグ;
    }

    private void setTempEntity(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity,
            List<DbT4150RenrakusakiJohoEntity> 介護連絡先情報List) {
        if (介護連絡先情報List.size() >= 1) {
            if (介護連絡先情報List.get(0).getRenrakusakiShimei() != null) {
                tempEntity.setHonninKinkyuurenrakuMeishou1(介護連絡先情報List.get(0).getRenrakusakiShimei().value());
            } else {
                tempEntity.setHonninKinkyuurenrakuMeishou1(RString.EMPTY);
            }
            if (介護連絡先情報List.get(0).getRenrakusakiJusho() != null) {
                tempEntity.setHonninKinkyuurenrakuJosho1(介護連絡先情報List.get(0).getRenrakusakiJusho().value());
            } else {
                tempEntity.setHonninKinkyuurenrakuJosho1(RString.EMPTY);
            }
            if (介護連絡先情報List.get(0).getRenrakusakiTelNo() != null) {
                tempEntity.setHonninKinkyuurenrakuNo1(介護連絡先情報List.get(0).getRenrakusakiTelNo().value());
            } else {
                tempEntity.setHonninKinkyuurenrakuNo1(RString.EMPTY);
            }
        }
        if (介護連絡先情報List.size() >= 2) {
            if (介護連絡先情報List.get(1).getRenrakusakiShimei() != null) {
                tempEntity.setHonninKinkyuurenrakuMeishou2(介護連絡先情報List.get(1).getRenrakusakiShimei().value());
            } else {
                tempEntity.setHonninKinkyuurenrakuMeishou2(RString.EMPTY);
            }
            if (介護連絡先情報List.get(1).getRenrakusakiJusho() != null) {
                tempEntity.setHonninKinkyuurenrakuJosho2(介護連絡先情報List.get(1).getRenrakusakiJusho().value());
            } else {
                tempEntity.setHonninKinkyuurenrakuJosho2(RString.EMPTY);
            }
            if (介護連絡先情報List.get(1).getRenrakusakiTelNo() != null) {
                tempEntity.setHonninKinkyuurenrakuNo2(介護連絡先情報List.get(1).getRenrakusakiTelNo().value());
            } else {
                tempEntity.setHonninKinkyuurenrakuNo2(RString.EMPTY);
            }
        }
    }

    private void checkTempEntity(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, ModifyNinteiShinseiJohoEntity entity) {
        if (entity.get申請届出代行区分コード() != null && !entity.get申請届出代行区分コード().value().equals(new RString("4"))) {
            if (entity.get申請届出者氏名カナ() == null || entity.get申請届出者氏名カナ().isEmpty()) {
                tempEntity.setShinseishaShimeiKana(new RString("申請者フリガナの入力がありません"));
                編集状況フラグ = new RString("1");
            }
            if (entity.get申請届出者氏名() == null || entity.get申請届出者氏名().isEmpty()) {
                tempEntity.setShinseishaShimei(new RString("申請者氏名の入力がありません"));
                編集状況フラグ = new RString("1");
            }
        }
        if (tempEntity.getShichousonCode().isEmpty() || tempEntity.getShichousonCode().equals(new RString("00000000"))) {
            tempEntity.setShichousonCode(new RString("市町村コードの入力がありません"));
            編集状況フラグ = new RString("1");
        }
        if (tempEntity.getHihokenshaKubunCodeo().equals(new RString("2"))) {
            List<RString> 特定疾病コード = new ArrayList<>();
            for (TokuteiShippei code : TokuteiShippei.values()) {
                特定疾病コード.add(code.getコード());
            }
            if (!特定疾病コード.contains(tempEntity.getTokuteiShippeiCode())) {
                tempEntity.setTokuteiShippeiCode(new RString("特定疾病コードが不正です"));
                編集状況フラグ = new RString("1");
            }
        }
    }

    private void checkTempEntity1(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, ModifyNinteiShinseiJohoEntity entity) {
        if (entity.get認定申請区分申請時コード().isEmpty()) {
            tempEntity.setShinseiKubunShinseijiCode(new RString("申請区分の入力がありません"));
            編集状況フラグ = new RString("1");
        }
        List<RString> codes = new ArrayList<>();
        for (NinteiShinseiShinseijiKubunCode code : NinteiShinseiShinseijiKubunCode.values()) {
            codes.add(code.getコード());
        }
        if (!codes.contains(tempEntity.getShinseiKubunShinseijiCode())) {
            tempEntity.setShinseiKubunShinseijiCode(new RString("申請区分が不正です"));
            編集状況フラグ = new RString("1");
        }
        if (tempEntity.getNinteiShinseiYMD().isEmpty() || tempEntity.getNinteiShinseiYMD().equals(new RString("00000000"))) {
            tempEntity.setNinteiShinseiYMD(new RString("申請日の入力がありません"));
            編集状況フラグ = new RString("1");
        }
        if (tempEntity.getHihokenshaNo().isEmpty() || tempEntity.getHihokenshaNo().equals(new RString("0000000000"))) {
            tempEntity.setHihokenshaNo(new RString("被保険者番号の入力がありません"));
            編集状況フラグ = new RString("1");
        }
        if (tempEntity.getSeinengappiYMD().isEmpty() || tempEntity.getSeinengappiYMD().equals(new RString("00000000"))) {
            tempEntity.setSeinengappiYMD(new RString("生年月日の入力がありません"));
            編集状況フラグ = new RString("1");
        }
        AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory.createInstance(
                entity.get生年月日()),
                JuminJotai.住民,
                FlexibleDate.MAX);
        if (ageCalculator.get年齢() == null || ageCalculator.get年齢().isEmpty()
                || entity.get生年月日().isEmpty() || tempEntity.getSeinengappiYMD().equals(new RString("00000000"))
                || !entity.get生年月日().isValid()) {
            tempEntity.setAge(new RString("年齢の算出が出来ませんでした"));
            編集状況フラグ = new RString("1");
        }
        if (!entity.get認定申請年月日().isValid()) {
            tempEntity.setNinteiShinseiYMD(new RString("申請日のデータが不正です"));
            編集状況フラグ = new RString("1");
        }
        if (!entity.get生年月日().isValid()) {
            tempEntity.setSeinengappiYMD(new RString("生年月日のデータが不正です"));
            編集状況フラグ = new RString("1");
        }
        List<RString> 性別コード = new ArrayList<>();
        for (Seibetsu seibetsu : Seibetsu.values()) {
            性別コード.add(seibetsu.getコード());
        }
        if (!性別コード.contains(tempEntity.getSeibetsu())) {
            tempEntity.setSeibetsu(new RString("性別のデータが不正です"));
            編集状況フラグ = new RString("1");
        }
    }

    private void checkTempEntity2(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, ModifyNinteiShinseiJohoEntity entity) {
        if (tempEntity.getSeibetsu().isEmpty()) {
            tempEntity.setSeibetsu(new RString("性別の入力がありません"));
            編集状況フラグ = new RString("1");
        }
        if (entity.get被保険者番号().length() != NO_10) {
            tempEntity.setHihokenshaNo(new RString("被保険者番号の桁数が間違っています"));
            編集状況フラグ = new RString("1");
        }
        if (!entity.get前回認定有効期間開始().isEmpty()) {
            if (!entity.get前回認定有効期間開始().isValid()) {
                tempEntity.setZenkaiNinteiYuukoukaishikikan(new RString("認定有効期間開始日のデータが不正です"));
                編集状況フラグ = new RString("1");
            }
        }
        if (!entity.get前回認定有効期間終了().isEmpty()) {
            if (!entity.get前回認定有効期間終了().isValid()) {
                tempEntity.setZenkaiNinteiYuukoushuuryoukikan(new RString("認定有効期間終了日のデータが不正です"));
                編集状況フラグ = new RString("1");
            }
        }
        if (!entity.get前回認定有効期間開始().isEmpty() && !entity.get前回認定有効期間終了().isEmpty()
                && entity.get前回認定有効期間終了().isValid()
                && entity.get前回認定有効期間開始().isValid()) {
            if (entity.get前回認定有効期間終了().getBetweenMonths(entity.get前回認定有効期間開始()) > NO_24) {
                tempEntity.setZenkaiNinteiYuukoukaishikikan(new RString("認定有効期間開のデータが不正です"));
                tempEntity.setZenkaiNinteiYuukoushuuryoukikan(new RString("認定有効期間のデータが不正です"));
                編集状況フラグ = new RString("1");
            }
        }
    }

    private void creatTempEntity(ModifyNinteiShinseiJohoEntity entity,
            RString シーケンシャル番号, KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity) {
        tempEntity.setShikensharuNo(シーケンシャル番号);
        tempEntity.setShikibetsuCode(entity.get厚労省IF識別コード().value());
        tempEntity.setHokenshaNo(entity.get証記載保険者番号());
        tempEntity.setHihokenshaNo(entity.get被保険者番号());
        if (entity.get取下区分コード() != null) {
            tempEntity.setTorisageKubunCode(entity.get取下区分コード().value());
        } else {
            tempEntity.setTorisageKubunCode(RString.EMPTY);
        }
        if (entity.get認定申請年月日() != null) {
            tempEntity.setNinteiShinseiYMD(new RString(entity.get認定申請年月日().toString()));
        } else {
            tempEntity.setNinteiShinseiYMD(RString.EMPTY);
        }
        tempEntity.setShuKiHojoKoumoku(new RString("0"));
        tempEntity.setShinseiKubunHoureiCode(entity.get認定申請区分法令コード().value());
        tempEntity.setShinseiKubunShinseijiCode(entity.get認定申請区分申請時コード().value());
        tempEntity.setHihokenshaKubunCodeo(entity.get被保険者区分コード());
        if (entity.get申請届出代行区分コード() != null) {
            tempEntity.setShinseiDaikouKubunCode(entity.get申請届出代行区分コード().value());
        } else {
            tempEntity.setShinseiDaikouKubunCode(RString.EMPTY);
        }
        tempEntity.setSeinengappiYMD(new RString(entity.get生年月日().toString()));
        tempEntity.setAge(new RString(entity.get年齢()));
        tempEntity.setSeibetsu(entity.get性別().value());
        tempEntity.setShimeiKana(entity.get被保険者氏名カナ().value());
        tempEntity.setShimei(entity.get被保険者氏名().value());
        tempEntity.setYuubinNo(entity.get郵便番号().getYubinNo());
        tempEntity.setJuusho(entity.get住所().value());
        if (entity.get連絡先1() != null) {
            tempEntity.setHonninRenrakusaki1(entity.get連絡先1().value());
        } else {
            tempEntity.setHonninRenrakusaki1(RString.EMPTY);
        }
        if (entity.get事業者名称() != null) {
            tempEntity.setByouinShisetsutouMeishou(entity.get事業者名称().value());
        } else {
            tempEntity.setByouinShisetsutouMeishou(RString.EMPTY);
        }
        if (entity.get事業者住所() != null) {
            tempEntity.setByouinShisetsutoujuusho(entity.get事業者住所().value());
        } else {
            tempEntity.setByouinShisetsutoujuusho(RString.EMPTY);
        }
        if (entity.get前回要介護状態区分コード() != null) {
            tempEntity.setZenkaiShinsakaiKekka(entity.get前回要介護状態区分コード().value());
        } else {
            tempEntity.setZenkaiShinsakaiKekka(RString.EMPTY);
        }
        if (entity.get前回認定有効期間開始() != null) {
            tempEntity.setZenkaiNinteiYuukoukaishikikan(new RString(entity.get前回認定有効期間開始().toString()));
        } else {
            tempEntity.setZenkaiNinteiYuukoukaishikikan(RString.EMPTY);
        }
        if (entity.get前回認定有効期間終了() != null) {
            tempEntity.setZenkaiNinteiYuukoushuuryoukikan(new RString(entity.get前回認定有効期間終了().toString()));
        } else {
            tempEntity.setZenkaiNinteiYuukoushuuryoukikan(RString.EMPTY);
        }
        if (entity.get主治医医療機関コード() != null) {
            tempEntity.setShujiiIryoukikanCode(entity.get主治医医療機関コード());
        } else {
            tempEntity.setShujiiIryoukikanCode(RString.EMPTY);
        }
        if (entity.get主治医コード() != null) {
            tempEntity.setShujiiNo(entity.get主治医コード());
        } else {
            tempEntity.setShujiiNo(RString.EMPTY);
        }
    }

    private void setTempEntityBy前回データ情報1(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_33) {
            tempEntity.setZenkaikekkaMahizaJoushi(前回データ情報リスト.get(NO_32));
        }
        if (前回データ情報リスト.size() >= NO_34) {
            tempEntity.setZenkaikekkaMahiyuuJoushi(前回データ情報リスト.get(NO_33));
        }
        if (前回データ情報リスト.size() >= NO_35) {
            tempEntity.setZenkaikekkaMahizaKashi(前回データ情報リスト.get(NO_34));
        }
        if (前回データ情報リスト.size() >= NO_36) {
            tempEntity.setZenkaikekkaMahiyuuKashi(前回データ情報リスト.get(NO_35));
        }
        if (前回データ情報リスト.size() >= NO_37) {
            tempEntity.setZenkaikekkaMahiSonoTa(前回データ情報リスト.get(NO_36));
        }
        if (前回データ情報リスト.size() >= NO_38) {
            tempEntity.setZenkaiKekkaKoushukuKatakansetsu(前回データ情報リスト.get(NO_37));
        }
        if (前回データ情報リスト.size() >= NO_39) {
            tempEntity.setZenkaiKekkaKoushukuKokansetsu(前回データ情報リスト.get(NO_38));
        }
        if (前回データ情報リスト.size() >= NO_40) {
            tempEntity.setZenkaiKekkaKoushukuShitsukansetsu(前回データ情報リスト.get(NO_39));
        }
        if (前回データ情報リスト.size() >= NO_41) {
            tempEntity.setZenkaiKekkaKoushukuSonoTa(前回データ情報リスト.get(NO_40));
        }
        if (前回データ情報リスト.size() >= NO_42) {
            tempEntity.setZenkaiKekkaNegaeri(前回データ情報リスト.get(NO_41));
        }
        if (前回データ情報リスト.size() >= NO_43) {
            tempEntity.setZenkaiKekkaOkiagari(前回データ情報リスト.get(NO_42));
        }
        if (前回データ情報リスト.size() >= NO_44) {
            tempEntity.setZaihoji(前回データ情報リスト.get(NO_43));
        }
    }

    private void setTempEntityBy前回データ情報2(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_45) {
            tempEntity.setZenkaiKekkaRyouashideNoritsui(前回データ情報リスト.get(NO_44));
        }
        if (前回データ情報リスト.size() >= NO_46) {
            tempEntity.setZenkaiKekkaHokou(前回データ情報リスト.get(NO_45));
        }
        if (前回データ情報リスト.size() >= NO_47) {
            tempEntity.setZenkaiKekkaTachiagari(前回データ情報リスト.get(NO_46));
        }
        if (前回データ情報リスト.size() >= NO_48) {
            tempEntity.setZenkaiKekkaKataashiDeNoRitsui(前回データ情報リスト.get(NO_47));
        }
        if (前回データ情報リスト.size() >= NO_49) {
            tempEntity.setZenkaiKekkaSenShin(前回データ情報リスト.get(NO_48));
        }
        if (前回データ情報リスト.size() >= NO_50) {
            tempEntity.setZenkaiKekkaTsuMeKiri(前回データ情報リスト.get(NO_49));
        }
        if (前回データ情報リスト.size() >= NO_51) {
            tempEntity.setZenkaiKekkaShiryoku(前回データ情報リスト.get(NO_50));
        }
        if (前回データ情報リスト.size() >= NO_52) {
            tempEntity.setZenkaiKekkaChouryoku(前回データ情報リスト.get(NO_51));
        }
        if (前回データ情報リスト.size() >= NO_53) {
            tempEntity.setZenkaiKekkaIjou(前回データ情報リスト.get(NO_52));
        }
        if (前回データ情報リスト.size() >= NO_54) {
            tempEntity.setZenkaiKekkaIdou(前回データ情報リスト.get(NO_53));
        }
        if (前回データ情報リスト.size() >= NO_55) {
            tempEntity.setZenkaiKekkaEnKa(前回データ情報リスト.get(NO_54));
        }
        if (前回データ情報リスト.size() >= NO_56) {
            tempEntity.setZenkaiKekkaShokujiSesshu(前回データ情報リスト.get(NO_55));
        }
        if (前回データ情報リスト.size() >= NO_57) {
            tempEntity.setZenkaiKekkaShokuHainyou(前回データ情報リスト.get(NO_56));
        }
        if (前回データ情報リスト.size() >= NO_58) {
            tempEntity.setZenkaiKekkaHaiben(前回データ情報リスト.get(NO_57));
        }
        if (前回データ情報リスト.size() >= NO_59) {
            tempEntity.setZenkaiKekkakoukuuSeiketsu(前回データ情報リスト.get(NO_58));
        }
        if (前回データ情報リスト.size() >= NO_60) {
            tempEntity.setZenkaiKekkaSengan(前回データ情報リスト.get(NO_59));
        }
        if (前回データ情報リスト.size() >= NO_61) {
            tempEntity.setZenkaiKekkaSeihatsu(前回データ情報リスト.get(NO_60));
        }

    }

    private void setTempEntityBy前回データ情報3(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_62) {
            tempEntity.setZenkaiKekkajouinoChakudatsu(前回データ情報リスト.get(NO_61));
        }
        if (前回データ情報リスト.size() >= NO_63) {
            tempEntity.setZenkaiKekkaZuBontounoChakudatsu(前回データ情報リスト.get(NO_62));
        }
        if (前回データ情報リスト.size() >= NO_64) {
            tempEntity.setZenkaiKekkaSotodehindo(前回データ情報リスト.get(NO_63));
        }
        if (前回データ情報リスト.size() >= NO_65) {
            tempEntity.setZenkaiKekkaIshinoDentatsu(前回データ情報リスト.get(NO_64));
        }
        if (前回データ情報リスト.size() >= NO_66) {
            tempEntity.setZenkaiKekkaMainichinoNikkawoRikai(前回データ情報リスト.get(NO_65));
        }
        if (前回データ情報リスト.size() >= NO_67) {
            tempEntity.setZenkaiKekkaSeinengappiwoiu(前回データ情報リスト.get(NO_66));
        }
        if (前回データ情報リスト.size() >= NO_68) {
            tempEntity.setZenkaiKekkaTankikioku(前回データ情報リスト.get(NO_67));
        }
        if (前回データ情報リスト.size() >= NO_69) {
            tempEntity.setZenkaiKekkaJibunnoNamaewoiu(前回データ情報リスト.get(NO_68));
        }
        if (前回データ情報リスト.size() >= NO_70) {
            tempEntity.setZenkaiKekkaImanoKisetsuwoRikai(前回データ情報リスト.get(NO_69));
        }
        if (前回データ情報リスト.size() >= NO_71) {
            tempEntity.setZenkaiKekkaBashonoRikai(前回データ情報リスト.get(NO_70));
        }
        if (前回データ情報リスト.size() >= NO_72) {
            tempEntity.setZenkaiKekkaJoujinoHaikai(前回データ情報リスト.get(NO_71));
        }
        if (前回データ情報リスト.size() >= NO_73) {
            tempEntity.setZenkaiKekkaGaishutsushiteMotorenai(前回データ情報リスト.get(NO_72));
        }
        if (前回データ情報リスト.size() >= NO_74) {
            tempEntity.setZenkaiKekkaHigaiteki(前回データ情報リスト.get(NO_73));
        }
        if (前回データ情報リスト.size() >= NO_75) {
            tempEntity.setZenkaiKekkaSakuwa(前回データ情報リスト.get(NO_74));
        }
        if (前回データ情報リスト.size() >= NO_76) {
            tempEntity.setZenkaiKekkaKanjougaFuantei(前回データ情報リスト.get(NO_75));
        }
        if (前回データ情報リスト.size() >= NO_77) {
            tempEntity.setZenkaiKekkaChuuyagyakuten(前回データ情報リスト.get(NO_76));
        }
        if (前回データ情報リスト.size() >= NO_78) {
            tempEntity.setZenkaiKekkaOnnajiwawosuru(前回データ情報リスト.get(NO_77));
        }
        if (前回データ情報リスト.size() >= NO_79) {
            tempEntity.setZenkaiKekkaTaiseiwodasu(前回データ情報リスト.get(NO_78));
        }
    }

    private void setTempEntityBy前回データ情報4(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_80) {
            tempEntity.setZenkaiKekkaKaigoniTeikou(前回データ情報リスト.get(NO_79));
        }
        if (前回データ情報リスト.size() >= NO_81) {
            tempEntity.setZenkaiKekkaOchitsukinashi(前回データ情報リスト.get(NO_80));
        }
        if (前回データ情報リスト.size() >= NO_82) {
            tempEntity.setZenkaiKekkaHitorideDetagaru(前回データ情報リスト.get(NO_81));
        }
        if (前回データ情報リスト.size() >= NO_83) {
            tempEntity.setZenkaiKekkaShuushuuheki(前回データ情報リスト.get(NO_82));
        }
        if (前回データ情報リスト.size() >= NO_84) {
            tempEntity.setZenkaiKekkaMonoyaIruiwoKowasu(前回データ情報リスト.get(NO_83));
        }
        if (前回データ情報リスト.size() >= NO_85) {
            tempEntity.setZenkaiKekkaHidoimonowasure(前回データ情報リスト.get(NO_84));
        }
        if (前回データ情報リスト.size() >= NO_86) {
            tempEntity.setZenkaiKekkaHitorigotoHitoriwarai(前回データ情報リスト.get(NO_85));
        }
        if (前回データ情報リスト.size() >= NO_87) {
            tempEntity.setZenkaiKekkaJibunkatteniKoudousuru(前回データ情報リスト.get(NO_86));
        }
        if (前回データ情報リスト.size() >= NO_88) {
            tempEntity.setZenkaiKekkaWagamatomaranai(前回データ情報リスト.get(NO_87));
        }
        if (前回データ情報リスト.size() >= NO_89) {
            tempEntity.setZenkaiKekkaYakunoNaifuku(前回データ情報リスト.get(NO_88));
        }
        if (前回データ情報リスト.size() >= NO_90) {
            tempEntity.setZenkaiKekkaKinsennoKanri(前回データ情報リスト.get(NO_89));
        }
        if (前回データ情報リスト.size() >= NO_91) {
            tempEntity.setZenkaiKekkaNichijounoIshikettei(前回データ情報リスト.get(NO_90));
        }
        if (前回データ情報リスト.size() >= NO_92) {
            tempEntity.setZenkaiKekkaShuudanhenoFutekiou(前回データ情報リスト.get(NO_91));
        }
        if (前回データ情報リスト.size() >= NO_93) {
            tempEntity.setZenkaiKekkaKaimono(前回データ情報リスト.get(NO_92));
        }
        if (前回データ情報リスト.size() >= NO_94) {
            tempEntity.setZenkaiKekkaKantannaChouri(前回データ情報リスト.get(NO_93));
        }
        if (前回データ情報リスト.size() >= NO_95) {
            tempEntity.setZenkaiKekkaTentekiKanri(前回データ情報リスト.get(NO_94));
        }
        if (前回データ情報リスト.size() >= NO_96) {
            tempEntity.setZenkaiKekkaChuushinJoumyakuEiyou(前回データ情報リスト.get(NO_95));
        }
        if (前回データ情報リスト.size() >= NO_97) {
            tempEntity.setZenkaiKekkaTouseki(前回データ情報リスト.get(NO_96));
        }
    }

    private void setTempEntityBy前回データ情報5(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_98) {
            tempEntity.setZenkaiKekkaSutomanoShochi(前回データ情報リスト.get(NO_97));
        }
        if (前回データ情報リスト.size() >= NO_99) {
            tempEntity.setZenkaiKekkaSansoRyouhou(前回データ情報リスト.get(NO_98));
        }
        if (前回データ情報リスト.size() >= NO_100) {
            tempEntity.setZenkaiKekkaresupireta(前回データ情報リスト.get(NO_99));
        }
        if (前回データ情報リスト.size() >= NO_101) {
            tempEntity.setZenkaiKekkaKikanSekkainoShochi(前回データ情報リスト.get((NO_100)));
        }
        if (前回データ情報リスト.size() >= NO_102) {
            tempEntity.setZenkaiKekkaToutsuunoKango(前回データ情報リスト.get(NO_101));
        }
        if (前回データ情報リスト.size() >= NO_103) {
            tempEntity.setZenkaiKekkaHeKanEiyou(前回データ情報リスト.get(NO_102));
        }
        if (前回データ情報リスト.size() >= NO_104) {
            tempEntity.setZenkaiKekkaMonitaSokutei(前回データ情報リスト.get(NO_103));
        }
        if (前回データ情報リスト.size() >= NO_105) {
            tempEntity.setZenkaiKekkaJokusounoShochi(前回データ情報リスト.get(NO_104));
        }
        if (前回データ情報リスト.size() >= NO_106) {
            tempEntity.setZenkaiKekkaKateteru(前回データ情報リスト.get(NO_105));
        }
        if (前回データ情報リスト.size() >= NO_107) {
            tempEntity.setZenkaiKekkaShougaiKoureishaJiritsudo(前回データ情報リスト.get(NO_106));
        }
        if (前回データ情報リスト.size() >= NO_108) {
            tempEntity.setZenkaiKekkaNinchiShouKoureishaJiritsudo(前回データ情報リスト.get(NO_107));
        }
        if (前回データ情報リスト.size() >= NO_109) {
            tempEntity.setZenkaiKekkaIchijiHanteikekka(前回データ情報リスト.get(NO_108));
        }
        if (前回データ情報リスト.size() >= NO_110) {
            tempEntity.setZenkaiKekkaNinchishoukazan(前回データ情報リスト.get(NO_109));
        }
        if (前回データ情報リスト.size() >= NO_111) {
            tempEntity.setZenkaiKekkaKijunJikan(前回データ情報リスト.get(NO_110));
        }
        if (前回データ情報リスト.size() >= NO_112) {
            tempEntity.setZenkaiKekkaKijunJikanShokuji(前回データ情報リスト.get(NO_111));
        }
        if (前回データ情報リスト.size() >= NO_113) {
            tempEntity.setZenkaiKekkaKijunJikanHaisetsu(前回データ情報リスト.get((NO_112)));
        }
        if (前回データ情報リスト.size() >= NO_114) {
            tempEntity.setZenkaiKekkaKijunJikanIdou(前回データ情報リスト.get(NO_113));
        }
        if (前回データ情報リスト.size() >= NO_115) {
            tempEntity.setZenkaiKekkaKijunJikanSeiketsuhoji(前回データ情報リスト.get(NO_114));
        }
    }

    private void setTempEntityBy前回データ情報6(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_116) {
            tempEntity.setZenkaiKekkaKansetsukea(前回データ情報リスト.get(NO_115));
        }
        if (前回データ情報リスト.size() >= NO_117) {
            tempEntity.setZenkaiKekkaBPSDkanren(前回データ情報リスト.get(NO_116));
        }
        if (前回データ情報リスト.size() >= NO_118) {
            tempEntity.setZenkaiKekkaKinoukunren(前回データ情報リスト.get(NO_117));
        }
        if (前回データ情報リスト.size() >= NO_119) {
            tempEntity.setZenkaiKekkaIryoukanren(前回データ情報リスト.get(NO_118));
        }
        if (前回データ情報リスト.size() >= NO_120) {
            tempEntity.setZenkaiKekkaNinKunchiShouKazan(前回データ情報リスト.get(NO_119));
        }
        if (前回データ情報リスト.size() >= NO_121) {
            tempEntity.setZenkaiKekkaChuukanHyouka1(前回データ情報リスト.get(NO_120));
        }
        if (前回データ情報リスト.size() >= NO_122) {
            tempEntity.setZenkaiKekkaChuukanHyouka2(前回データ情報リスト.get(NO_121));
        }
        if (前回データ情報リスト.size() >= NO_123) {
            tempEntity.setZenkaiKekkaChuukanHyouka3(前回データ情報リスト.get(NO_122));
        }
        if (前回データ情報リスト.size() >= NO_124) {
            tempEntity.setZenkaiKekkaChuukanHyouka4(前回データ情報リスト.get(NO_123));
        }
        if (前回データ情報リスト.size() >= NO_125) {
            tempEntity.setZenkaiKekkaChuukanHyouka5(前回データ情報リスト.get(NO_124));
        }
        if (前回データ情報リスト.size() >= NO_126) {
            tempEntity.setZenkaiKekkaIchijiHanteiKeikokuCode(前回データ情報リスト.get(NO_125));
        }
        if (前回データ情報リスト.size() >= NO_127) {
            tempEntity.setZenkaiKekkaJoutainoAnteisei(前回データ情報リスト.get(NO_126));
        }
        if (前回データ情報リスト.size() >= NO_128) {
            tempEntity.setZenkaiKekkaNinchiShouJiritsudo2(前回データ情報リスト.get(NO_127));
        }
        if (前回データ情報リスト.size() >= NO_129) {
            tempEntity.setZenkaiKekkaJoutaiKubun(前回データ情報リスト.get(NO_128));
        }
        if (前回データ情報リスト.size() >= NO_130) {
            tempEntity.setZenkaiKekkaShinseiYMD(前回データ情報リスト.get(NO_129));
        }
        if (前回データ情報リスト.size() >= NO_131) {
            tempEntity.setZenkaiKekkaNijiHanteiYMD(前回データ情報リスト.get(NO_130));
        }
        if (前回データ情報リスト.size() >= NO_132) {
            tempEntity.setZenkaiKekkaGenzainosabisuKubunCode(前回データ情報リスト.get(NO_131));
        }
        if (前回データ情報リスト.size() >= NO_133) {
            tempEntity.setZenkaiKekkaGenzainoJoukyou(前回データ情報リスト.get(NO_132));
        }
    }

    private void setTempEntityBy前回データ情報7(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_134) {
            tempEntity.setZenkaiKekkaHoumonkaigohomuherupusabisu(前回データ情報リスト.get(NO_133));
        }
        if (前回データ情報リスト.size() >= NO_135) {
            tempEntity.setZenkaiKekkaHoumonNyuuyokuKaigo(前回データ情報リスト.get(NO_134));
        }
        if (前回データ情報リスト.size() >= NO_136) {
            tempEntity.setZenkaiKekkaHoumonkango(前回データ情報リスト.get(NO_135));
        }
        if (前回データ情報リスト.size() >= NO_137) {
            tempEntity.setZenkaiKekkaHoumonrihabiriteshon(前回データ情報リスト.get(NO_136));
        }
        if (前回データ情報リスト.size() >= NO_138) {
            tempEntity.setZenkaiKekkaKyotakuRyouyouKanrishidou(前回データ情報リスト.get(NO_137));
        }
        if (前回データ情報リスト.size() >= NO_139) {
            tempEntity.setZenkaiKekkaTsuushoKaigodeisabisu(前回データ情報リスト.get(NO_138));
        }
        if (前回データ情報リスト.size() >= NO_140) {
            tempEntity.setZenkaiKekkaTsuushorihabiriteshon(前回データ情報リスト.get(NO_139));
        }
        if (前回データ情報リスト.size() >= NO_141) {
            tempEntity.setZenkaiKekkaKaigoshotosutei(前回データ情報リスト.get(NO_140));
        }
        if (前回データ情報リスト.size() >= NO_142) {
            tempEntity.setZenkaiKekkaRyouyouKaigo(前回データ情報リスト.get(NO_141));
        }
        if (前回データ情報リスト.size() >= NO_143) {
            tempEntity.setZenkaiKekkaNyuukyoshaSeikatsukaigo(前回データ情報リスト.get(NO_142));
        }
        if (前回データ情報リスト.size() >= NO_144) {
            tempEntity.setZenkaiKekkaFukushiYouguTaiyo(前回データ情報リスト.get(NO_143));
        }
        if (前回データ情報リスト.size() >= NO_145) {
            tempEntity.setZenkaiKekkaTokuteiFukushiYouguHambai(前回データ情報リスト.get(NO_144));
        }
        if (前回データ情報リスト.size() >= NO_146) {
            tempEntity.setZenkaiKekkaJuutakuKaishuukaigoKyuufu(前回データ情報リスト.get(NO_145));
        }
        if (前回データ情報リスト.size() >= NO_147) {
            tempEntity.setZenkaiKekkaYakanTaiougataHoumonkaigo(前回データ情報リスト.get(NO_146));
        }
        if (前回データ情報リスト.size() >= NO_148) {
            tempEntity.setZenkaiKekkaNinchishouTaiougataTsuushoKaigo(前回データ情報リスト.get(NO_147));
        }
        if (前回データ情報リスト.size() >= NO_149) {
            tempEntity.setZenkaiKekkaShoukiboTakinouKeiKyotakuKaigo(前回データ情報リスト.get(NO_148));
        }
        if (前回データ情報リスト.size() >= NO_150) {
            tempEntity.setZenkaiKekkaNinchiShoutaiougata(前回データ情報リスト.get(NO_149));
        }
        if (前回データ情報リスト.size() >= NO_151) {
            tempEntity.setZenkaiKekkaSeikatsukaigo(前回データ情報リスト.get(NO_150));
        }
    }

    private void setTempEntityBy前回データ情報8(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_152) {
            tempEntity.setZenkaiKekkaChiikimitchakukeikaigoroujin(前回データ情報リスト.get(NO_151));
        }
        if (前回データ情報リスト.size() >= NO_153) {
            tempEntity.setZenkaiKekkaHoumonkaigokango(前回データ情報リスト.get(NO_152));
        }
        if (前回データ情報リスト.size() >= NO_154) {
            tempEntity.setZenkaiKekkaFukugougatasabisu(前回データ情報リスト.get(NO_153));
        }
        if (前回データ情報リスト.size() >= NO_155) {
            tempEntity.setZenkaiKekkaHomuherupusabisu(前回データ情報リスト.get(NO_154));
        }
        if (前回データ情報リスト.size() >= NO_156) {
            tempEntity.setZenkaiKekkaKaigoYobouHoumonNyuuyokukaigo(前回データ情報リスト.get(NO_155));
        }
        if (前回データ情報リスト.size() >= NO_157) {
            tempEntity.setZenkaiKekkaKaigoYobouHoumonkango(前回データ情報リスト.get(NO_156));
        }
        if (前回データ情報リスト.size() >= NO_158) {
            tempEntity.setZenkaiKekkaKaigoYobouHoumonrihabiriteshon(前回データ情報リスト.get(NO_157));
        }
        if (前回データ情報リスト.size() >= NO_159) {
            tempEntity.setZenkaiKekkaKaigoRyouyoukanriShidou(前回データ情報リスト.get(NO_158));
        }
        if (前回データ情報リスト.size() >= NO_160) {
            tempEntity.setZenkaiKekkaKaigoYobouTsuushoKaigodeisabisu(前回データ情報リスト.get(NO_159));
        }
        if (前回データ情報リスト.size() >= NO_161) {
            tempEntity.setZenkaiKekkaKaigoYobouTsuushorihabiriteshon(前回データ情報リスト.get(NO_160));
        }
        if (前回データ情報リスト.size() >= NO_162) {
            tempEntity.setZenkaiKekkaKaigoyobouTankiNyuushosei(前回データ情報リスト.get(NO_161));
        }
        if (前回データ情報リスト.size() >= NO_163) {
            tempEntity.setZenkaiKekkanyuushoRyouyoukaigo(前回データ情報リスト.get(NO_162));
        }
        if (前回データ情報リスト.size() >= NO_164) {
            tempEntity.setZenkaiKekkaKaigoYobouTokuteishisetsu(前回データ情報リスト.get(NO_163));
        }
        if (前回データ情報リスト.size() >= NO_165) {
            tempEntity.setZenkaiKekkaKaigoYobouFukushiYouguTaiyo(前回データ情報リスト.get(NO_164));
        }
        if (前回データ情報リスト.size() >= NO_166) {
            tempEntity.setZenkaiKekkaTokuteiKaigoYobouFukushi(前回データ情報リスト.get(NO_165));
        }
        if (前回データ情報リスト.size() >= NO_167) {
            tempEntity.setZenkaiKekkaJuutakuKaishuu(前回データ情報リスト.get(NO_166));
        }
        if (前回データ情報リスト.size() >= NO_168) {
            tempEntity.setZenkaiKekkaTsuushoKaigo(前回データ情報リスト.get(NO_167));
        }
        if (前回データ情報リスト.size() >= NO_169) {
            tempEntity.setZenkaiKekkaKyotakukaigo(前回データ情報リスト.get(NO_168));
        }
    }

    private void setTempEntityBy前回データ情報9(KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, List<RString> 前回データ情報リスト) {
        if (前回データ情報リスト.size() >= NO_170) {
            tempEntity.setZenkaiKekkaKyoudouseikatsuKaigo(前回データ情報リスト.get(NO_169));
        }
        if (前回データ情報リスト.size() >= NO_171) {
            tempEntity.setZenkaiShikibetsuCode(前回データ情報リスト.get(NO_170));
        }
    }

    private void setTempEntity電算標準版(ModifyNinteiShinseiJohoEntity entity,
            KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity, LasdecCode 市町村コード) {
        if (市町村コード != null) {
            tempEntity.setShichousonCode(市町村コード.value());
        } else {
            tempEntity.setShichousonCode(RString.EMPTY);
        }
        if (entity.get連絡先2() != null) {
            tempEntity.setHonninRenrakusaki2(entity.get連絡先2().value());
        } else {
            tempEntity.setHonninRenrakusaki2(RString.EMPTY);
        }
        if (entity.getに号特定疾病コード() != null) {
            tempEntity.setTokuteiShippeiCode(entity.getに号特定疾病コード().value());
        } else {
            tempEntity.setTokuteiShippeiCode(RString.EMPTY);
        }
        if (entity.get入所施設コード() != null) {
            tempEntity.setNyuushoJigyoushoCode(entity.get入所施設コード().value());
        } else {
            tempEntity.setNyuushoJigyoushoCode(RString.EMPTY);
        }
        if (entity.get事業者名称カナ() != null) {
            tempEntity.setNyuushoShisetsukana(entity.get事業者名称カナ().value());
        } else {
            tempEntity.setNyuushoShisetsukana(RString.EMPTY);
        }
        if (entity.getDbT7060郵便番号() != null) {
            tempEntity.setNyuushoShisetsuYoubinNo(entity.getDbT7060郵便番号().getYubinNo());
        } else {
            tempEntity.setNyuushoShisetsuYoubinNo(RString.EMPTY);
        }
        if (entity.get電話番号() != null) {
            tempEntity.setNyuushoShisetsutelNo(entity.get電話番号().value());
        } else {
            tempEntity.setNyuushoShisetsutelNo(RString.EMPTY);
        }
        if (entity.get申請者関係コード() != null) {
            tempEntity.setShinseishaKankeiCode(entity.get申請者関係コード().value());
        } else {
            tempEntity.setShinseishaKankeiCode(RString.EMPTY);
        }
        tempEntity.setHonninKankei(entity.get本人との関係());
        if (entity.get申請届出者郵便番号() != null) {
            tempEntity.setShinseishaYoubinNo(entity.get申請届出者郵便番号().getYubinNo());
        } else {
            tempEntity.setShinseishaYoubinNo(RString.EMPTY);
        }
        tempEntity.setShinseishaJosho(entity.get申請届出者住所());
        if (entity.get申請届出者電話番号() != null) {
            tempEntity.setShinseishaRenrakusaki(entity.get申請届出者電話番号().value());
        } else {
            tempEntity.setShinseishaRenrakusaki(RString.EMPTY);
        }
        if (entity.get認定調査委託先コード() != null) {
            tempEntity.setChousaiCode(entity.get認定調査委託先コード().value());
        } else {
            tempEntity.setChousaiCode(RString.EMPTY);
        }
        if (entity.get申請届出代行区分コード() != null && entity.get申請届出代行区分コード().value().equals(new RString("4"))) {
            tempEntity.setShinseiJigyoushaName(entity.get申請届出者氏名());
            tempEntity.setShinseiJigyoushaKana(entity.get申請届出者氏名カナ());
        } else {
            tempEntity.setShinseishaShimei(entity.get申請届出者氏名());
            tempEntity.setShinseishaShimeiKana(entity.get申請届出者氏名カナ());
        }
    }
}
