/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk99A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg99A;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.NitijouSeikatsu;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TyukanHyouka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.IsJutakuKaishu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class SabisuJyoukyoA3 {

    private static final RString 記号 = new RString("+");
    private static final RString 月間 = new RString("月間");
    private static final Code A_99 = new Code("99A");
    private static final Code A_02 = new Code("02A");
    private static final Code A_06 = new Code("06A");
    private static final Code A_09 = new Code("09A");
    private static final Code B_09 = new Code("09B");
    private static final int 連番_0 = 0;
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;
    private static final int 連番_3 = 3;
    private static final int 連番_4 = 4;
    private static final int 連番_5 = 5;
    private static final int 連番_6 = 6;
    private static final int 連番_7 = 7;
    private static final int 連番_8 = 8;
    private static final int 連番_9 = 9;
    private static final int 連番_10 = 10;
    private static final int 連番_11 = 11;
    private static final int 連番_12 = 12;
    private static final int 連番_13 = 13;
    private static final int 連番_14 = 14;
    private static final int 連番_15 = 15;
    private static final int 連番_16 = 16;
    private static final int 連番_17 = 17;
    private static final int 連番_18 = 18;
    private static final int 連番_19 = 19;
    private static final int 連番_20 = 20;
    private static final Code 予防給付サービス = new Code("1");
    private static final Code 介護給付サービス = new Code("2");
    private static final RString 単位 = new RString(":");
    private static final RString 施設名ファイル名 = new RString("C0004_BAK.png");
    private static final RString 住所ファイル名 = new RString("C0005_BAK.png");
    private static final RString 電話ファイル名 = new RString("C0006_BAK.png");
    private static final RString 認定調査主治段階悪化 = new RString("★");
    private static final RString 認定調査主治段階改善 = new RString("☆");

    /**
     * サービスの状況を設定します。
     *
     * @param entity ItiziHanteiEntity
     * @param 項目 IchijihanteikekkahyoA4Entity
     * @param 予防給付 予防給付
     * @param 介護給付 介護給付
     * @param サービス状況フラグ サービス状況フラグ
     * @param 共通情報 ShinsakaiSiryoKyotsuEntity
     */
    public void setサービスの状況(ItiziHanteiEntity entity, IchijihanteikekkahyoA3Entity 項目,
            List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付, List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付,
            DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ, ShinsakaiSiryoKyotsuEntity 共通情報) {
        RStringBuilder builder;
        if (予防給付サービス.equals(entity.getServiceKubunCode())) {
            項目.setSabisuKubun(new RString("予防給付・総合事業"));
            for (DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity : 予防給付) {
                Code 厚労省IF識別コード = dbt5207Entity.getKoroshoIfShikibetsuCode();
                switch (dbt5207Entity.getRemban()) {
                    case 連番_1:
                        builder = new RStringBuilder();
                        項目.setSabisuName1(get帳票上の文言(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu1(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_1)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_1))).toRString());
                        項目.setSabisuName13(get帳票上の文言状況フラグ(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu13(IsJutakuKaishu.toValue(サービス状況フラグ.getServiceJokyoFlag()).get名称());
                        break;
                    case 連番_2:
                        builder = new RStringBuilder();
                        項目.setSabisuName2(get帳票上の文言(厚労省IF識別コード, new RString(連番_2)));
                        項目.setSabisuKaisu2(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_2)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_2))).toRString());
                        break;
                    case 連番_3:
                        builder = new RStringBuilder();
                        項目.setSabisuName3(get帳票上の文言(厚労省IF識別コード, new RString(連番_3)));
                        項目.setSabisuKaisu3(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_3)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_3))).toRString());
                        break;
                    case 連番_4:
                        builder = new RStringBuilder();
                        項目.setSabisuName4(get帳票上の文言(厚労省IF識別コード, new RString(連番_4)));
                        項目.setSabisuKaisu4(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_4)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_4))).toRString());
                        break;
                    case 連番_5:
                        builder = new RStringBuilder();
                        項目.setSabisuName5(get帳票上の文言(厚労省IF識別コード, new RString(連番_5)));
                        項目.setSabisuKaisu5(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_5)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_5))).toRString());
                        break;
                    case 連番_6:
                        builder = new RStringBuilder();
                        項目.setSabisuName6(get帳票上の文言(厚労省IF識別コード, new RString(連番_6)));
                        項目.setSabisuKaisu6(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_6)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_6))).toRString());
                        break;
                    case 連番_7:
                        builder = new RStringBuilder();
                        項目.setSabisuName7(get帳票上の文言(厚労省IF識別コード, new RString(連番_7)));
                        項目.setSabisuKaisu7(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_7)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_7))).toRString());
                        break;
                    default:
                        予防給付サービスの状況(dbt5207Entity, 項目, 厚労省IF識別コード);
                        break;
                }
            }
            setサービス(項目, 共通情報);
        } else if (介護給付サービス.equals(entity.getServiceKubunCode())) {
            項目.setSabisuKubun(new RString("介護給付"));
            for (DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity : 介護給付) {
                Code 厚労省IF識別コード = dbt5207Entity.getKoroshoIfShikibetsuCode();
                switch (dbt5207Entity.getRemban()) {
                    case 連番_1:
                        builder = new RStringBuilder();
                        項目.setSabisuName1(get帳票上の文言(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu1(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_1)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_1))).toRString());
                        項目.setSabisuName13(get帳票上の文言状況フラグ(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu13(IsJutakuKaishu.toValue(サービス状況フラグ.getServiceJokyoFlag()).get名称());
                        break;
                    case 連番_2:
                        builder = new RStringBuilder();
                        項目.setSabisuName2(get帳票上の文言(厚労省IF識別コード, new RString(連番_2)));
                        項目.setSabisuKaisu2(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_2)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_2))).toRString());
                        break;
                    case 連番_3:
                        builder = new RStringBuilder();
                        項目.setSabisuName3(get帳票上の文言(厚労省IF識別コード, new RString(連番_3)));
                        項目.setSabisuKaisu3(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_3)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_3))).toRString());
                        break;
                    case 連番_4:
                        builder = new RStringBuilder();
                        項目.setSabisuName4(get帳票上の文言(厚労省IF識別コード, new RString(連番_4)));
                        項目.setSabisuKaisu4(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_4)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_4))).toRString());
                        break;
                    case 連番_5:
                        builder = new RStringBuilder();
                        項目.setSabisuName5(get帳票上の文言(厚労省IF識別コード, new RString(連番_5)));
                        項目.setSabisuKaisu5(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_5)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_5))).toRString());
                        break;
                    case 連番_6:
                        builder = new RStringBuilder();
                        項目.setSabisuName6(get帳票上の文言(厚労省IF識別コード, new RString(連番_6)));
                        項目.setSabisuKaisu6(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_6)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_6))).toRString());
                        break;
                    case 連番_7:
                        builder = new RStringBuilder();
                        項目.setSabisuName7(get帳票上の文言(厚労省IF識別コード, new RString(連番_7)));
                        項目.setSabisuKaisu7(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_7)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_7))).toRString());
                        break;

                    default:
                        介護給付サービスの状況(dbt5207Entity, 項目, 厚労省IF識別コード);
                        break;
                }
            }
            setサービス(項目, 共通情報);
        } else {
            項目.setSabisuKubun(new RString("なし"));
            setサービス(項目, null);
        }
    }

    private void 予防給付サービスの状況(DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity,
            IchijihanteikekkahyoA3Entity 項目,
            Code 厚労省IF識別コード) {
        RStringBuilder builder;
        switch (dbt5207Entity.getRemban()) {
            case 連番_8:
                builder = new RStringBuilder();
                項目.setSabisuName8(get帳票上の文言(厚労省IF識別コード, new RString(連番_8)));
                項目.setSabisuKaisu8(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_8)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_8))).toRString());
                break;
            case 連番_9:
                builder = new RStringBuilder();
                項目.setSabisuName9(get帳票上の文言(厚労省IF識別コード, new RString(連番_9)));
                項目.setSabisuKaisu9(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_9)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_9))).toRString());
                break;
            case 連番_10:
                builder = new RStringBuilder();
                項目.setSabisuName10(get帳票上の文言(厚労省IF識別コード, new RString(連番_10)));
                項目.setSabisuKaisu10(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_10)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_10))).toRString());
                break;
            case 連番_11:
                builder = new RStringBuilder();
                項目.setSabisuName11(get帳票上の文言(厚労省IF識別コード, new RString(連番_11)));
                項目.setSabisuKaisu11(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_11))).toRString());
                break;
            case 連番_12:
                builder = new RStringBuilder();
                項目.setSabisuName12(get帳票上の文言(厚労省IF識別コード, new RString(連番_12)));
                項目.setSabisuKaisu12(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_12)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_12))).toRString());
                break;
            case 連番_14:
                builder = new RStringBuilder();
                項目.setSabisuName14(get帳票上の文言(厚労省IF識別コード, new RString(連番_14)));
                項目.setSabisuKaisu14(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_14)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_14))).toRString());
                break;
            case 連番_15:
                builder = new RStringBuilder();
                項目.setSabisuName15(get帳票上の文言(厚労省IF識別コード, new RString(連番_15)));
                項目.setSabisuKaisu15(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_15)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_15))).toRString());
                break;
            case 連番_16:
                builder = new RStringBuilder();
                項目.setSabisuName16(get帳票上の文言(厚労省IF識別コード, new RString(連番_16)));
                項目.setSabisuKaisu16(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_16)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_16))).toRString());
                break;
            default:
                項目.setSabisuName17(RString.EMPTY);
                項目.setSabisuKaisu17(RString.EMPTY);
                項目.setSabisuName18(RString.EMPTY);
                項目.setSabisuKaisu18(RString.EMPTY);
                項目.setSabisuName19(RString.EMPTY);
                項目.setSabisuKaisu19(RString.EMPTY);
                項目.setSabisuName20(RString.EMPTY);
                項目.setSabisuKaisu20(RString.EMPTY);
                項目.setSabisuName21(RString.EMPTY);
                項目.setSabisuKaisu21(RString.EMPTY);
                break;

        }
    }

    private void 介護給付サービスの状況(DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity,
            IchijihanteikekkahyoA3Entity 項目,
            Code 厚労省IF識別コード) {
        RStringBuilder builder;
        switch (dbt5207Entity.getRemban()) {
            case 連番_8:
                builder = new RStringBuilder();
                項目.setSabisuName8(get帳票上の文言(厚労省IF識別コード, new RString(連番_8)));
                項目.setSabisuKaisu8(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_8)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_8))).toRString());
                break;
            case 連番_9:
                builder = new RStringBuilder();
                項目.setSabisuName9(get帳票上の文言(厚労省IF識別コード, new RString(連番_9)));
                項目.setSabisuKaisu9(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_9)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_9))).toRString());
                break;
            case 連番_10:
                builder = new RStringBuilder();
                項目.setSabisuName10(get帳票上の文言(厚労省IF識別コード, new RString(連番_10)));
                項目.setSabisuKaisu10(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_10)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_10))).toRString());
                break;
            case 連番_11:
                builder = new RStringBuilder();
                項目.setSabisuName11(get帳票上の文言(厚労省IF識別コード, new RString(連番_11)));
                項目.setSabisuKaisu11(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_11))).toRString());
                break;
            case 連番_12:
                builder = new RStringBuilder();
                項目.setSabisuName12(get帳票上の文言(厚労省IF識別コード, new RString(連番_12)));
                項目.setSabisuKaisu12(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_12)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_12))).toRString());
                break;
            case 連番_13:
                builder = new RStringBuilder();
                項目.setSabisuName14(get帳票上の文言(厚労省IF識別コード, new RString(連番_13)));
                項目.setSabisuKaisu14(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_13)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_13))).toRString());
                break;
            case 連番_14:
                builder = new RStringBuilder();
                項目.setSabisuName15(get帳票上の文言(厚労省IF識別コード, new RString(連番_14)));
                項目.setSabisuKaisu15(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_14)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_14))).toRString());
                break;
            case 連番_15:
                builder = new RStringBuilder();
                項目.setSabisuName16(get帳票上の文言(厚労省IF識別コード, new RString(連番_15)));
                項目.setSabisuKaisu16(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_15)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_15))).toRString());
                break;
            case 連番_16:
                builder = new RStringBuilder();
                項目.setSabisuName17(get帳票上の文言(厚労省IF識別コード, new RString(連番_16)));
                項目.setSabisuKaisu17(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_16)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_16))).toRString());
                break;
            case 連番_17:
                builder = new RStringBuilder();
                項目.setSabisuName18(get帳票上の文言(厚労省IF識別コード, new RString(連番_17)));
                項目.setSabisuKaisu18(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_17)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_17))).toRString());
                break;
            case 連番_18:
                builder = new RStringBuilder();
                項目.setSabisuName19(get帳票上の文言(厚労省IF識別コード, new RString(連番_18)));
                項目.setSabisuKaisu19(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_18)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_18))).toRString());
                break;
            case 連番_19:
                builder = new RStringBuilder();
                項目.setSabisuName20(get帳票上の文言(厚労省IF識別コード, new RString(連番_19)));
                項目.setSabisuKaisu20(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_19)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_19))).toRString());
                break;
            case 連番_20:
                builder = new RStringBuilder();
                項目.setSabisuName21(get帳票上の文言(厚労省IF識別コード, new RString(連番_20)));
                項目.setSabisuKaisu21(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_20)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_20))).toRString());
                break;
            default:
                break;
        }
    }

    private RString get帳票上の文言(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk99A.toValue(連番).get名称();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk06A.toValue(連番).get名称();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk02A.toValue(連番).get名称();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09A.toValue(連番).get名称();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09B.toValue(連番).get名称();
        }
        return RString.EMPTY;
    }

    private RString get帳票上の文言状況フラグ(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg99A.toValue(連番).get名称();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg06A.toValue(連番).get名称();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg02A.toValue(連番).get名称();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg09A.toValue(連番).get名称();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg09B.toValue(連番).get名称();
        }
        return RString.EMPTY;
    }

    private RString get単位1(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk99A.toValue(連番).get単位1();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk06A.toValue(連番).get単位1();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk02A.toValue(連番).get単位1();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09A.toValue(連番).get単位1();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09B.toValue(連番).get単位1();
        }
        return RString.EMPTY;
    }

    private RString get単位2(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk99A.toValue(連番).get単位2();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk06A.toValue(連番).get単位2();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk02A.toValue(連番).get単位2();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09A.toValue(連番).get単位2();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09B.toValue(連番).get単位2();
        }
        return RString.EMPTY;
    }

    private void setサービス(IchijihanteikekkahyoA3Entity 項目, ShinsakaiSiryoKyotsuEntity 共通情報) {
        if (共通情報 == null) {
            項目.set施設名テキスト(RString.EMPTY);
            項目.set施設名イメージ(RString.EMPTY);
            項目.set住所テキスト(RString.EMPTY);
            項目.set住所イメージ(RString.EMPTY);
            項目.set電話番号テキスト(RString.EMPTY);
            項目.set電話番号イメージ(RString.EMPTY);
        } else {
            if (!RString.isNullOrEmpty(共通情報.getRiyoShisetsuShimei())) {
                項目.set施設名テキスト(共通情報.getRiyoShisetsuShimei());
            } else {
                項目.set施設名イメージ(共有ファイルを引き出す(共通情報.getImageSharedFileId(), 施設名ファイル名));
            }
            if (!RString.isNullOrEmpty(共通情報.getRiyoShisetsuJusho())) {
                項目.set住所テキスト(共通情報.getRiyoShisetsuJusho());
            } else {
                項目.set住所イメージ(共有ファイルを引き出す(共通情報.getImageSharedFileId(), 住所ファイル名));
            }
            if (!RString.isNullOrEmpty(共通情報.getRiyoShisetsuTelNo())) {
                項目.set電話番号テキスト(共通情報.getRiyoShisetsuTelNo());
            } else {
                項目.set電話番号イメージ(共有ファイルを引き出す(共通情報.getImageSharedFileId(), 電話ファイル名));
            }
        }
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

    /**
     * 麻痺_左上肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺_左上肢
     */
    public RString get主治医意見麻痺_左上肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.麻痺_左上肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.麻痺_左上肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.麻痺_左上肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_左下肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_左下肢
     */
    public RString get主治医意見麻痺_左下肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.麻痺_左下肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.麻痺_左下肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.麻痺_左下肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_右上肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_右上肢
     */
    public RString get主治医意見麻痺_右上肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.麻痺_右上肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.麻痺_右上肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.麻痺_右上肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_右下肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_右下肢
     */
    public RString get主治医意見麻痺_右下肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.麻痺_右下肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.麻痺_右下肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.麻痺_右下肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_その他コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_その他
     */
    public RString get主治医意見麻痺_その他(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.麻痺_その他.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.麻痺_その他.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.麻痺_その他.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 拘縮_肩関節コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 拘縮_肩関節
     */
    public RString get主治医意見拘縮_肩関節(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.関節の拘縮.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.関節の拘縮.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.関節の拘縮.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.関節の拘縮.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.関節の拘縮.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 食事摂取コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 食事摂取
     */
    public RString get主治医意見食事摂取(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.食事行為.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.食事行為.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.食事行為.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 意思の伝達コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 意思の伝達
     */
    public RString get主治医意見意思の伝達(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.伝達能力.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.伝達能力.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.伝達能力.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.伝達能力.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.伝達能力.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 短期記憶コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 短期記憶
     */
    public RString get主治医意見短期記憶(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.短期記憶.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.短期記憶.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.短期記憶.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.短期記憶.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.短期記憶.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 常時の徘徊コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 常時の徘徊
     */
    public RString get主治医意見徘徊(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.徘徊_問題行動.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.徘徊_問題行動.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.徘徊_認知症の周辺症状.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.徘徊_認知症の周辺症状.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 被害的コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 被害的
     */
    public RString get主治医意見被害的(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.妄想.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.妄想.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.妄想.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.妄想.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.妄想.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 昼夜逆転コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 昼夜逆転
     */
    public RString get主治医意見昼夜逆転(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.昼夜逆転.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.昼夜逆転.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.昼夜逆転.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.昼夜逆転.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.昼夜逆転.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 介護に抵抗コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 介護に抵抗
     */
    public RString get主治医意見介護に抵抗(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.介護への抵抗.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.介護への抵抗.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.介護への抵抗.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.介護への抵抗.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.介護への抵抗.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 日常の意思決定コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 日常の意思決定
     */
    public RString get主治医意見日常の意思決定(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.認知能力.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.認知能力.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.認知能力.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.認知能力.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.認知能力.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 点滴の管理コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 点滴の管理
     */
    public RString get主治医意見点滴の管理(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.点滴の管理.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.点滴の管理.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.点滴の管理.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.点滴の管理.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.点滴の管理.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 中心静脈栄養コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 中心静脈栄養
     */
    public RString get主治医意見中心静脈栄養(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.中心静脈栄養.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.中心静脈栄養.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.中心静脈栄養.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.中心静脈栄養.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.中心静脈栄養.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 透析コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 透析
     */
    public RString get主治医意見透析(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.透析.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.透析.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.透析.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.透析.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.透析.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * ストーマの処置コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return ストーマの処置
     */
    public RString get主治医意見ストーマの処置(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.ストーマの処置.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.ストーマの処置.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.ストーマの処置.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.ストーマの処置.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.ストーマの処置.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 酸素療法コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 酸素療法
     */
    public RString get主治医意見酸素療法(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.酸素療法.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.酸素療法.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.酸素療法.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.酸素療法.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.酸素療法.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * レスピレーターコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return レスピレーター
     */
    public RString get主治医意見レスピレーター(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.レスピレーター.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.レスピレーター.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.レスピレーター.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.レスピレーター.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.レスピレーター.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 気管切開の処置コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 気管切開の処置
     */
    public RString get主治医意見気管切開の処置(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.気管切開の処置.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.気管切開の処置.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.気管切開の処置.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.気管切開の処置.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.気管切開の処置.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 疼痛の看護コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 疼痛の看護
     */
    public RString get主治医意見疼痛の看護(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.疼痛の看護.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.疼痛の看護.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.疼痛の看護.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.疼痛の看護.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.疼痛の看護.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 経管栄養コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 経管栄養
     */
    public RString get主治医意見経管栄養(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.経管栄養.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.経管栄養.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.経管栄養.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.経管栄養.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.経管栄養.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * モニター測定コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return モニター測定
     */
    public RString get主治医意見モニター測定(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.モニター測定.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.モニター測定.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.モニター測定.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.モニター測定.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.モニター測定.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * じょくそうの処置コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return じょくそうの処置
     */
    public RString get主治医意見じょくそうの処置(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.じょくそうの処置.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.じょくそうの処置.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.じょくそうの処置.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.じょくそうの処置.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.じょくそうの処置.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * カテーテルコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return カテーテル
     */
    public RString get主治医意見カテーテル(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.カテーテル.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.カテーテル.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.カテーテル.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.カテーテル.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.カテーテル.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 項目を設定する。
     *
     * @param 項目 IchijihanteikekkahyoA3Entity
     * @param entity ItiziHanteiEntity
     */
    public void set項目(IchijihanteikekkahyoA3Entity 項目, ItiziHanteiEntity entity) {
        項目.set年齢(new RString(entity.getAge()));
        項目.set前々回要介護度(set要介護度(entity.getZzKoroshoIfShikibetsuCode(), entity.getZzNijiHanteiYokaigoJotaiKubunCode()));
        項目.set前々回認定有効期間(set有効期間(entity.getZzNijiHanteiNinteiYukoKikan()));
        項目.set前々回認定有効期間開始年月日(entity.getZzNijiHanteiNinteiYukoKaishiYMD());
        項目.set前々回認定有効期間終了年月日(entity.getZzNijiHanteiNinteiYukoShuryoYMD());
        項目.set前回要介護度(set要介護度(entity.getZKoroshoIfShikibetsuCode(), entity.getZNijiHanteiYokaigoJotaiKubunCode()));
        項目.set前回認定有効期間(set有効期間(entity.getZNijiHanteiNinteiYukoKikan()));
        項目.set前回認定有効期間開始年月日(entity.getZNijiHanteiNinteiYukoKaishiYMD());
        項目.set前回認定有効期間終了年月日(entity.getZNijiHanteiNinteiYukoShuryoYMD());
        項目.set前回認定日(entity.getZNijiHanteiYMD());
        項目.set前回状態像(set状態像(entity.getZYokaigoJotaizoReiCode()));
        項目.set審査会資料作成年月日(FlexibleDate.getNowDate());
        項目.set今回認定申請年月日(entity.getNinteiShinseiYMD());
        項目.set今回認定調査実施年月日(entity.getNinteichosaJisshiYMD());
        項目.set今回認定審査年月日(entity.getShinsakaiKaisaiYMD());
        項目.set被保険者番号(entity.getHihokenshaNo());
        項目.set保険者番号(entity.getShoKisaiHokenshaNo());
        項目.set市町村名(entity.getShichosonMeisho());
        項目.set事業者番号(entity.getNinteichosaItakusakiCode());
        項目.set事業者名(entity.getJigyoshaMeisho());
        項目.set認定調査員番号(entity.getNinteiChosainCode());
        項目.set認定調査員氏名(entity.getChosainShimei());
        項目.set調査日(entity.getNinteichosaJisshiYMD());
        項目.set調査実施場所(entity.getChosaJisshiBashoMeisho());
        項目.set医療機関番号(entity.getShujiiIryokikanCode());
        項目.set医療機関名称(entity.getIryoKikanMeisho());
        項目.set主治医番号(entity.getShujiiCode());
        項目.set主治医氏名(entity.getShujiiName());
        項目.set要介護認定等基準時間_食事(new RString(entity.getKijunJikanShokuji()));
        項目.set要介護認定等基準時間_排泄(new RString(entity.getKijunJikanHaisetsu()));
        項目.set要介護認定等基準時間_移動(new RString(entity.getKijunJikanIdo()));
        項目.set要介護認定等基準時間_清潔保持(new RString(entity.getKijunJikanSeiketsuHoji()));
        項目.set要介護認定等基準時間_間接(new RString(entity.getKijunJikanKansetsuCare()));
        項目.set要介護認定等基準時間_BPSD関連(new RString(entity.getKijunJikanBPSDKanren()));
        項目.set要介護認定等基準時間_機能訓練(new RString(entity.getKijunJikanKinoKunren()));
        項目.set要介護認定等基準時間_医療関連(new RString(entity.getKijunJikanIryoKanren()));
        項目.set要介護認定等基準時間_認知症加算(new RString(entity.getKijunJikanNinchishoKasan()));
        項目.set警告コード(entity.getIchijiHnateiKeikokuCode());
        List<TyukanHyouka> 中間評価リスト = new ArrayList<>();
        TyukanHyouka 中間評価項目 = new TyukanHyouka();
        中間評価項目.set第1群(new RString(entity.getChukanHyokaKomoku1gun()));
        中間評価項目.set第2群(new RString(entity.getChukanHyokaKomoku2gun()));
        中間評価項目.set第3群(new RString(entity.getChukanHyokaKomoku3gun()));
        中間評価項目.set第4群(new RString(entity.getChukanHyokaKomoku4gun()));
        中間評価項目.set第5群(new RString(entity.getChukanHyokaKomoku5gun()));
        TyukanHyouka 前中間評価項目 = new TyukanHyouka();
        前中間評価項目.set第1群(new RString(entity.getZChukanHyokaKomoku1gun()));
        前中間評価項目.set第2群(new RString(entity.getZChukanHyokaKomoku2gun()));
        前中間評価項目.set第3群(new RString(entity.getZChukanHyokaKomoku3gun()));
        前中間評価項目.set第4群(new RString(entity.getZChukanHyokaKomoku4gun()));
        前中間評価項目.set第5群(new RString(entity.getZChukanHyokaKomoku5gun()));
        中間評価リスト.add(中間評価項目);
        中間評価リスト.add(前中間評価項目);
        項目.set中間評価リスト(中間評価リスト);
        項目.set審査人数(new RString(entity.getShinsakaiOrder()));
        項目.set一次判定結果(set一次判定結果(entity.getKoroshoIfShikibetsuCode(),
                entity.getIchijiHanteiKekkaCode(), entity.getIchijiHanteiKekkaNinchishoKasanCode()));
        項目.set要介護認定等基準時間(set要介護認定等基準時間(entity.getKijunJikanShokuji(), entity.getKijunJikanHaisetsu(),
                entity.getKijunJikanIdo(), entity.getKijunJikanSeiketsuHoji(), entity.getKijunJikanKansetsuCare(),
                entity.getKijunJikanBPSDKanren(), entity.getKijunJikanKinoKunren(), entity.getKijunJikanIryoKanren(),
                entity.getKijunJikanNinchishoKasan(), entity.getKijunJikan()));
        項目.set前回要介護認定等基準時間(set要介護認定等基準時間(entity.getZKijunJikanShokuji(), entity.getZKijunJikanHaisetsu(),
                entity.getZKijunJikanIdo(), entity.getZKijunJikanSeiketsuHoji(), entity.getZKijunJikanKansetsuCare(),
                entity.getZKijunJikanBPSDKanren(), entity.getZKijunJikanKinoKunren(), entity.getZKijunJikanIryoKanren(),
                entity.getZKijunJikanNinchishoKasan(), entity.getZKijunJikan()));
        //TODO QA回答まち、
//        項目.set基準時間の積み上げグラフ(月間);

        List<NitijouSeikatsu> 日常生活自立度リスト = new ArrayList<>();
        NitijouSeikatsu 障害高齢者自立度 = new NitijouSeikatsu();
        障害高齢者自立度.set特記事項フラグ(entity.getShogaiNichijoSeikatsuJiritsudo());
        障害高齢者自立度.set認知症高齢者自立度(set障害高齢者自立度(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
        NitijouSeikatsu 認知症高齢者自立度 = new NitijouSeikatsu();
        認知症高齢者自立度.set特記事項フラグ(entity.getNinchishoNichijoSeikatsuJiritsudo());
        認知症高齢者自立度.set認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        日常生活自立度リスト.add(障害高齢者自立度);
        日常生活自立度リスト.add(認知症高齢者自立度);
        項目.set日常生活自立度リスト(日常生活自立度リスト);
        項目.set認定調査結果認知症高齢者自立度(set認知症高齢者自立度(entity.getNinchishoNichijoSeikatsuJiritsudoCode()));
        if (!RString.isNullOrEmpty(entity.getIkenItem())) {
            項目.set意見書認知症高齢者自立度(set認知症高齢者自立度(new Code(entity.getIkenItem())));
        }
        if (RString.isNullOrEmpty(entity.getHihokenshaKubunCode())) {
            項目.set被保険者区分(RString.EMPTY);
        } else {
            項目.set被保険者区分(HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称());
            if (HihokenshaKubunCode.第１号被保険者.getコード().equals(entity.getHihokenshaKubunCode())
                    || entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty()) {
                項目.set特定疾病名(RString.EMPTY);
            } else {
                項目.set特定疾病名(TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode().getColumnValue()).get名称());
            }
        }
        setコード(項目, entity);
    }

    private void setコード(IchijihanteikekkahyoA3Entity 項目, ItiziHanteiEntity entity) {

        if (entity.getNinteiShinseiShinseijiKubunCode() == null || entity.getNinteiShinseiShinseijiKubunCode().isEmpty()) {
            項目.set申請区分(RString.EMPTY);
        } else {
            項目.set申請区分(NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCode().getColumnValue()).get名称());
        }
        if (entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty()) {
            項目.set性別(RString.EMPTY);
        } else {
            項目.set性別(Seibetsu.toValue(entity.getSeibetsu().getColumnValue()).get名称());
        }
        if (entity.getShinseishoKanriNo() == null || entity.getShinseishoKanriNo().isEmpty()) {
            項目.set管理番号(RString.EMPTY);
        } else {
            項目.set管理番号(entity.getShinseishoKanriNo().getColumnValue());
        }
        if (entity.getHihokenshaName() == null || entity.getHihokenshaName().isEmpty()) {
            項目.set被保険者氏名(RString.EMPTY);
        } else {
            項目.set被保険者氏名(entity.getHihokenshaName().getColumnValue());
        }
        if (RString.isNullOrEmpty(entity.getChosainShikaku())) {
            項目.set調査員資格(RString.EMPTY);
        } else {
            項目.set調査員資格(Sikaku.toValue(entity.getChosainShikaku()).get名称());
        }
        if (entity.getNinchishoJiritsudoIIijoNoGaizensei() == null) {
            項目.set認知症自立度Ⅱ以上の蓋然性(RString.EMPTY);
        } else {
            項目.set認知症自立度Ⅱ以上の蓋然性(new RString(entity.getNinchishoJiritsudoIIijoNoGaizensei().toString()));
        }
        if (entity.getJotaiAnteiseiCode() == null || entity.getJotaiAnteiseiCode().isEmpty()) {
            項目.set状態の安定性(RString.EMPTY);
        } else {
            項目.set状態の安定性(JotaiAnteiseiCode.toValue(entity.getJotaiAnteiseiCode().getColumnValue()).get名称());
        }
        if (entity.getSuiteiKyufuKubunCode() == null || entity.getSuiteiKyufuKubunCode().isEmpty()) {
            項目.set給付区分(RString.EMPTY);
        } else {
            項目.set給付区分(SuiteiKyufuKubunCode.toValue(entity.getSuiteiKyufuKubunCode().getColumnValue()).get名称());
        }
    }

    /**
     * 認定調査特記事項番号を取得する。
     *
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return List<RString>
     */
    public List<RString> get認定調査特記事項番号(List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        return 認定調査特記事項番号;
    }

    private RString set有効期間(int 有効期間) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(有効期間)
                .append(月間);
        return builder.toRString();
    }

    private RString set要介護度(Code 厚労省IF識別コード, Code 二次判定要介護状態区分コード) {
        if (二次判定要介護状態区分コード != null && !二次判定要介護状態区分コード.isEmpty()) {
            if (A_99.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun02.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun06.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun09.toValue(二次判定要介護状態区分コード.getColumnValue()).get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString set状態像(Code 状態像) {
        if (状態像 != null && !状態像.isEmpty()) {
            return YokaigoJotaizoReiCode.toValue(状態像.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString set一次判定結果(Code 厚労省IF識別コード, Code 一次判定結果コード, Code 一次判定結果コード_認知症加算) {
        RString 一次判定結果 = RString.EMPTY;
        RString 一次判定結果_認知症加算 = RString.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        if (一次判定結果コード != null && !一次判定結果コード.isEmpty()) {
            if (A_99.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun99.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun02.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun06.toValue(一次判定結果コード.getColumnValue()).get名称();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                一次判定結果 = YokaigoJotaiKubun09.toValue(一次判定結果コード.getColumnValue()).get名称();
            }
        }
        if (一次判定結果コード_認知症加算 != null && !一次判定結果コード_認知症加算.isEmpty()) {
            if (A_99.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun99.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (A_02.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun02.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (A_06.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun06.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            } else if (A_09.equals(厚労省IF識別コード) || B_09.equals(厚労省IF識別コード)) {
                一次判定結果_認知症加算 = YokaigoJotaiKubun09.toValue(一次判定結果コード_認知症加算.getColumnValue()).get名称();
            }
        }
        return builder.append(一次判定結果)
                .append("→")
                .append(一次判定結果_認知症加算).toRString();
    }

    private RString set要介護認定等基準時間(int 食事, int 排泄,
            int 移動, int 清潔保持, int 間接,
            int 関連, int 機能訓練, int 医療関連,
            int 認知症加算, int 基準時間) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(new RString(食事)).append(記号)
                .append(new RString(排泄)).append(記号)
                .append(new RString(移動)).append(記号)
                .append(new RString(清潔保持)).append(記号)
                .append(new RString(間接)).append(記号)
                .append(new RString(関連)).append(記号)
                .append(new RString(機能訓練)).append(記号)
                .append(new RString(医療関連)).append(記号)
                .append(new RString(認知症加算)).append(new RString("="))
                .append(new RString(基準時間))
                .toRString();
    }

    private RString set障害高齢者自立度(Code 障害高齢者自立度コード) {
        if (障害高齢者自立度コード != null && !障害高齢者自立度コード.isEmpty()) {
            return ShogaiNichijoSeikatsuJiritsudoCode.toValue(障害高齢者自立度コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString set認知症高齢者自立度(Code 認知症高齢者自立度コード) {
        if (認知症高齢者自立度コード != null && !認知症高齢者自立度コード.isEmpty()) {
            return NinchishoNichijoSeikatsuJiritsudoCode.toValue(認知症高齢者自立度コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺認定調査と主治医意見書結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set麻痺認定調査と主治医意見書結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if (ChosaAnser01.あり.getコード().equals(今回結果コード) && IkenKomoku01.無.getコード().equals(前回調査結果コード)) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階改善);
        } else if (IkenKomoku01.有.getコード().equals(前回調査結果コード) && ChosaAnser01.なし.getコード().equals(今回結果コード)) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階悪化);
        } else {
            第１群.set認定調査と主治医意見書の結果比較(RString.EMPTY);
        }
    }

    /**
     * 食事摂取認定調査と主治医意見書結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set食事摂取認定調査と主治医意見書結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser10.全介助.getコード().equals(今回結果コード) && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(前回調査結果コード))) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階改善);
        } else if ((IkenKomoku14.全面介助.getコード().equals(前回調査結果コード) && (ChosaAnser10.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser10.見守り等.getコード().equals(今回結果コード) || ChosaAnser10.介助されていない.getコード().equals(今回結果コード)))
                || (IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(前回調査結果コード)
                && (ChosaAnser10.一部介助.getコード().equals(今回結果コード) || ChosaAnser10.見守り等.getコード().equals(今回結果コード)))) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階悪化);
        } else {
            第１群.set認定調査と主治医意見書の結果比較(RString.EMPTY);
        }
    }

    private boolean is意思の伝達認定調査と主治医意見書結果１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果悪 = false;
        if (ChosaAnser14.できない.getコード().equals(今回結果コード) && (IkenKomoku06.具体的要求に限られる.getコード().equals(前回調査結果コード)
                || IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード) || IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) {
            is認定調査と主治医意見書結果悪 = true;
        }
        return is認定調査と主治医意見書結果悪;
    }

    private boolean is意思の伝達認定調査と主治医意見書結果２(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果悪 = false;
        if (ChosaAnser14.ほとんど伝達できない.getコード().equals(今回結果コード) && (IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード)
                || IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) {
            is認定調査と主治医意見書結果悪 = true;
        }
        return is認定調査と主治医意見書結果悪;
    }

    private boolean is意思の伝達認定調査と主治医意見書比較１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果善 = false;
        if (IkenKomoku06.伝えられない.getコード().equals(前回調査結果コード) && (ChosaAnser14.ほとんど伝達できない.getコード().equals(今回結果コード)
                || ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード) || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) {
            is認定調査と主治医意見書結果善 = true;
        }
        return is認定調査と主治医意見書結果善;
    }

    private boolean is意思の伝達認定調査と主治医意見書比較２(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果善 = false;
        if (IkenKomoku06.具体的要求に限られる.getコード().equals(前回調査結果コード) && (ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード)
                || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) {
            is認定調査と主治医意見書結果善 = true;
        }
        return is認定調査と主治医意見書結果善;
    }

    /**
     * 意思の伝達認定調査と主治医意見書結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set意思の伝達認定調査と主治医意見書結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if (is意思の伝達認定調査と主治医意見書結果１(今回結果コード, 前回調査結果コード)
                || is意思の伝達認定調査と主治医意見書結果２(今回結果コード, 前回調査結果コード)
                || (ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード) && IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階改善);
        } else if (is意思の伝達認定調査と主治医意見書比較１(今回結果コード, 前回調査結果コード)
                || is意思の伝達認定調査と主治医意見書比較２(今回結果コード, 前回調査結果コード)
                || (IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード) && ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階悪化);
        } else {
            第１群.set認定調査と主治医意見書の結果比較(RString.EMPTY);
        }
    }

    /**
     * 短期記憶認定調査と主治医意見書結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set短期記憶認定調査と主治医意見書結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if (ChosaAnser15.できない.getコード().equals(今回結果コード) && IkenKomoku04.問題あり.getコード().equals(前回調査結果コード)) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階改善);
        } else if (IkenKomoku04.問題なし.getコード().equals(前回調査結果コード) && ChosaAnser15.できる.getコード().equals(今回結果コード)) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階悪化);
        } else {
            第１群.set認定調査と主治医意見書の結果比較(RString.EMPTY);
        }
    }

    /**
     * 徘徊認定調査と主治医意見書結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set徘徊認定調査と主治医意見書結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser16.ある.getコード().equals(今回結果コード) && IkenKomoku01.無.getコード().equals(前回調査結果コード))
                || (ChosaAnser16.ときどきある.getコード().equals(今回結果コード) && IkenKomoku01.無.getコード().equals(前回調査結果コード))) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階改善);
        } else if (IkenKomoku01.有.getコード().equals(前回調査結果コード) && (ChosaAnser16.ときどきある.getコード().equals(今回結果コード)
                || ChosaAnser16.ない.getコード().equals(今回結果コード))) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階悪化);
        } else {
            第１群.set認定調査と主治医意見書の結果比較(RString.EMPTY);
        }
    }

    private boolean is日常の意思決定認定調査と主治医意見書結果１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果善 = false;
        if ((ChosaAnser17.できない.getコード().equals(今回結果コード) && (IkenKomoku05.見守りが必要.getコード().equals(前回調査結果コード)
                || IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード) || IkenKomoku05.自立.getコード().equals(前回調査結果コード)))
                || (ChosaAnser17.日常的に困難.getコード().equals(今回結果コード) && (IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード)
                || IkenKomoku05.自立.getコード().equals(前回調査結果コード)))) {
            is認定調査と主治医意見書結果善 = true;
        }
        return is認定調査と主治医意見書結果善;
    }

    private boolean is日常の意思決定認定調査と主治医意見書結果２(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果善 = false;
        if (ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード) && IkenKomoku05.自立.getコード().equals(前回調査結果コード)) {
            is認定調査と主治医意見書結果善 = true;
        }
        return is認定調査と主治医意見書結果善;
    }

    private boolean is日常の意思決定認定調査と主治医意見書比較１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果悪 = false;
        if ((IkenKomoku05.判断できない.getコード().equals(前回調査結果コード) && (ChosaAnser17.日常的に困難.getコード().equals(今回結果コード)
                || ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード) || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード)))
                || (IkenKomoku05.見守りが必要.getコード().equals(前回調査結果コード) && (ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード)
                || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード)))) {
            is認定調査と主治医意見書結果悪 = true;
        }
        return is認定調査と主治医意見書結果悪;
    }

    private boolean is日常の意思決定認定調査と主治医意見書比較２(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is認定調査と主治医意見書結果悪 = false;
        if (IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード) && ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード)) {
            is認定調査と主治医意見書結果悪 = true;
        }
        return is認定調査と主治医意見書結果悪;
    }

    /**
     * 日常の意思決定認定調査と主治医意見書結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set日常の意思決定認定調査と主治医意見書結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if (is日常の意思決定認定調査と主治医意見書結果１(今回結果コード, 前回調査結果コード)
                || is日常の意思決定認定調査と主治医意見書結果２(今回結果コード, 前回調査結果コード)) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階改善);
        } else if (is日常の意思決定認定調査と主治医意見書比較１(今回結果コード, 前回調査結果コード)
                || is日常の意思決定認定調査と主治医意見書比較２(今回結果コード, 前回調査結果コード)) {
            第１群.set認定調査と主治医意見書の結果比較(認定調査主治段階悪化);
        } else {
            第１群.set認定調査と主治医意見書の結果比較(RString.EMPTY);
        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set認定調査と主治医意見書比較１(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見麻痺_左上肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_0);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見麻痺_右上肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_1);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見麻痺_左下肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_2);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見麻痺_右下肢(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_3);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見麻痺_その他(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_4);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見拘縮_肩関節(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_5);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }
        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set認定調査と主治医意見書比較２(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見食事摂取(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_3);
                主治医意見書コード = IkenKomoku14.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set食事摂取認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }

        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set認定調査と主治医意見書比較３(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見意思の伝達(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_0);
                主治医意見書コード = IkenKomoku06.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set意思の伝達認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見短期記憶(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_3);
                主治医意見書コード = IkenKomoku04.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set短期記憶認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見徘徊(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_7);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set徘徊認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }
        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set認定調査と主治医意見書比較４(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見被害的(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_0);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set徘徊認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見昼夜逆転(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_3);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set徘徊認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見介護に抵抗(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_6);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set徘徊認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }
        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set認定調査と主治医意見書比較５(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見日常の意思決定(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_2);
                主治医意見書コード = IkenKomoku05.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set日常の意思決定認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }
        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set特別な医療リスト認定調査と主治医意見書比較１(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見点滴の管理(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_0);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見中心静脈栄養(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_1);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見透析(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_2);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見ストーマの処置(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_3);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見酸素療法(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_4);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見レスピレーター(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_5);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }
        }
    }

    /**
     * 認定調査と主治医意見書比較設定する。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 第１群リスト 第１群リスト
     * @param 主治医意見書項目 主治医意見書項目
     */
    public void set特別な医療リスト認定調査と主治医意見書比較２(Code 厚労省IF識別コード, List<TiyosaKekka> 第１群リスト,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目) {
        SabisuJyoukyoA3 settei = new SabisuJyoukyoA3();
        for (DbT5304ShujiiIkenshoIkenItemEntity 主治医意見書 : 主治医意見書項目) {
            RString 主治医意見書連番 = new RString(主治医意見書.getRemban());
            TiyosaKekka 第１群;
            RString 主治医意見書コード;
            if (主治医意見書連番.equals(settei.get主治医意見気管切開の処置(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_0);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見疼痛の看護(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_1);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見経管栄養(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_2);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見モニター測定(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_3);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見じょくそうの処置(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_4);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            } else if (主治医意見書連番.equals(settei.get主治医意見カテーテル(厚労省IF識別コード))) {
                第１群 = 第１群リスト.get(連番_5);
                主治医意見書コード = IkenKomoku01.toValue(主治医意見書.getIkenItem()).getコード();
                settei.set麻痺認定調査と主治医意見書結果比(第１群.get調査結果コード(), 主治医意見書コード, 第１群);
            }
        }
    }
}
