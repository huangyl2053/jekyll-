/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo32;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser23;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser24;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * NinteiChosaJohohyoEntityの編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class NinteiChosaJohohyo32EntityEditor {

    private static final RString 判定結果コード09 = new RString("09");
    private static final RString 判定結果コード06 = new RString("06");
    private static final RString 判定結果コード02 = new RString("02");
    private static final RString 判定結果コード99 = new RString("99");
    private static final RString マスキング_あり = new RString("1");
    private static final RString マスキング_調査員名 = new RString("2");
    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final RString イメージID01 = new RString("C0001.png");
    private static final RString イメージID02 = new RString("C0002.png");
    private static final RString イメージID03 = new RString("C0003.png");
    private static final RString イメージID04 = new RString("C0004.png");
    private static final RString イメージID05 = new RString("C0005.png");
    private static final RString イメージID06 = new RString("C0006.png");
    private static final RString SEPARATOR = new RString("/");
    private static final RString 拡張子_PNG = new RString(".png");
    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番22 = 22;
    private static final int 連番23 = 23;
    private static final int 連番24 = 24;
    private static final int 連番25 = 25;
    private static final int 連番26 = 26;
    private static final int 連番27 = 27;
    private static final int 連番28 = 28;
    private static final int 連番29 = 29;
    private static final int 連番30 = 30;
    private static final int 連番31 = 31;
    private static final int 連番32 = 32;
    private static final int 連番33 = 33;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番41 = 41;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番54 = 54;
    private static final int 連番55 = 55;
    private static final int 連番56 = 56;
    private static final int 連番57 = 57;
    private static final int 連番58 = 58;
    private static final int 連番59 = 59;
    private static final int 連番60 = 60;
    private static final int 連番61 = 61;
    private static final int 連番62 = 62;
    private static final int 連番63 = 63;
    private static final int 連番64 = 64;
    private static final int 連番65 = 65;
    private static final int 連番66 = 66;
    private static final int 連番67 = 67;
    private static final int 連番68 = 68;
    private static final int 連番69 = 69;
    private static final int 連番70 = 70;
    private static final int 連番71 = 71;
    private static final int 連番72 = 72;
    private static final int 連番73 = 73;
    private static final int 連番74 = 74;
    private static final int 連番75 = 75;
    private static final int 連番76 = 76;
    private static final int 連番77 = 77;
    private static final int 連番78 = 78;
    private static final int 連番79 = 79;
    private static final int 連番80 = 80;
    private static final int 連番81 = 81;

    private NinteiChosaJohohyo32EntityEditor() {
    }

    /**
     * NinteiChosaJohohyoEntityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param 認定調査票サービス状況List NinteichosahyoServiceJokyoのリスト
     * @param 認定調査票サービス状況フラグList NinteichosahyoServiceJokyoFlagのリスト
     * @param 認定調査票調査項目List NinteichosahyoChosaItemのリスト
     * @param 認定調査票記入項目List NinteichosahyoKinyuItemのリスト
     * @param イメージID RDateTime
     * @param 認定調査票マスキング区分
     * @return NinteiChosaJohohyoEntity
     */
    public static NinteiChosaJohohyoEntity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RDateTime イメージID,
            RString 認定調査票マスキング区分) {
        NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity = new NinteiChosaJohohyoEntity();
        setBodyItem(ninteiChosaJohohyoEntity, yokaigoNinteiJohoTeikyoEntity, 認定調査票記入項目List, イメージID, 認定調査票マスキング区分);
        ninteiChosaJohohyoEntity.setサービス区分リスト_32(getサービス状況02(認定調査票サービス状況List,
                認定調査票サービス状況フラグList, yokaigoNinteiJohoTeikyoEntity.getサービス区分コード()));
        ninteiChosaJohohyoEntity.set麻痺拘縮1_リスト_32(get麻痺拘縮1_リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set麻痺拘縮2_リスト_32(get麻痺拘縮2_リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set移動リスト_32(get移動リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set複雑動作リスト_32(get複雑動作リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set特別介護リスト_32(get特別介護リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set身の回りリスト_32(get身の回りリスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set意思疎通リスト_32(get意思疎通リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set問題行動リスト_32(get問題行動リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set特別な医療リスト_32(get特別な医療リスト(認定調査票調査項目List));
        ninteiChosaJohohyoEntity.set活動参加リスト_32(get活動参加リスト(認定調査票調査項目List));
        return ninteiChosaJohohyoEntity;
    }

    private static List<RString> get活動参加リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 活動参加リスト = new ArrayList<>();
        活動参加リスト.add(get名称24(認定調査票調査項目List, 連番79));
        活動参加リスト.add(get名称13(認定調査票調査項目List, 連番80));
        活動参加リスト.add(get名称01(認定調査票調査項目List, 連番81));
        return 活動参加リスト;
    }

    private static List<RString> get特別な医療リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 特別な医療リスト = new ArrayList<>();
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番67));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番68));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番69));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番70));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番71));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番72));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番73));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番74));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番75));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番76));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番77));
        特別な医療リスト.add(get名称01(認定調査票調査項目List, 連番78));
        return 特別な医療リスト;
    }

    private static List<RString> get問題行動リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 問題行動リスト = new ArrayList<>();
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番48));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番49));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番50));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番51));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番52));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番53));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番54));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番55));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番56));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番57));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番58));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番59));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番60));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番61));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番62));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番63));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番64));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番65));
        問題行動リスト.add(get名称16(認定調査票調査項目List, 連番66));
        return 問題行動リスト;
    }

    private static List<RString> get意思疎通リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 意思疎通リスト = new ArrayList<>();
        意思疎通リスト.add(get名称08(認定調査票調査項目List, 連番38));
        意思疎通リスト.add(get名称09(認定調査票調査項目List, 連番39));
        意思疎通リスト.add(get名称14(認定調査票調査項目List, 連番40));
        意思疎通リスト.add(get名称23(認定調査票調査項目List, 連番41));
        意思疎通リスト.add(get名称15(認定調査票調査項目List, 連番42));
        意思疎通リスト.add(get名称15(認定調査票調査項目List, 連番43));
        意思疎通リスト.add(get名称15(認定調査票調査項目List, 連番44));
        意思疎通リスト.add(get名称15(認定調査票調査項目List, 連番45));
        意思疎通リスト.add(get名称15(認定調査票調査項目List, 連番46));
        意思疎通リスト.add(get名称15(認定調査票調査項目List, 連番47));
        return 意思疎通リスト;
    }

    private static List<RString> get身の回りリスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 身の回りリスト = new ArrayList<>();
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番28));
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番29));
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番30));
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番31));
        身の回りリスト.add(get名称20(認定調査票調査項目List, 連番32));
        身の回りリスト.add(get名称20(認定調査票調査項目List, 連番33));
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番34));
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番35));
        身の回りリスト.add(get名称22(認定調査票調査項目List, 連番36));
        身の回りリスト.add(get名称17(認定調査票調査項目List, 連番37));
        return 身の回りリスト;
    }

    private static List<RString> get特別介護リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 特別介護リスト = new ArrayList<>();
        特別介護リスト.add(get名称01(認定調査票調査項目List, 連番21));
        特別介護リスト.add(get名称01(認定調査票調査項目List, 連番22));
        特別介護リスト.add(get名称11(認定調査票調査項目List, 連番23));
        特別介護リスト.add(get名称20(認定調査票調査項目List, 連番24));
        特別介護リスト.add(get名称20(認定調査票調査項目List, 連番25));
        特別介護リスト.add(get名称20(認定調査票調査項目List, 連番26));
        特別介護リスト.add(get名称20(認定調査票調査項目List, 連番27));
        return 特別介護リスト;
    }

    private static List<RString> get複雑動作リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 複雑動作リスト = new ArrayList<>();
        複雑動作リスト.add(get名称02(認定調査票調査項目List, 連番18));
        複雑動作リスト.add(get名称04(認定調査票調査項目List, 連番19));
        複雑動作リスト.add(get名称21(認定調査票調査項目List, 連番20));
        return 複雑動作リスト;
    }

    private static List<RString> get麻痺拘縮1_リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 麻痺拘縮1_リスト = new ArrayList<>();
        麻痺拘縮1_リスト.add(get名称01(認定調査票調査項目List, 0));
        麻痺拘縮1_リスト.add(get名称01(認定調査票調査項目List, 連番2));
        麻痺拘縮1_リスト.add(get名称01(認定調査票調査項目List, 連番4));
        麻痺拘縮1_リスト.add(get名称01(認定調査票調査項目List, 連番5));
        麻痺拘縮1_リスト.add(get名称01(認定調査票調査項目List, 連番7));
        麻痺拘縮1_リスト.add(get名称01(認定調査票調査項目List, 連番9));
        return 麻痺拘縮1_リスト;
    }

    private static List<RString> get麻痺拘縮2_リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 麻痺拘縮2_リスト = new ArrayList<>();
        麻痺拘縮2_リスト.add(get名称01(認定調査票調査項目List, 連番1));
        麻痺拘縮2_リスト.add(get名称01(認定調査票調査項目List, 連番3));
        麻痺拘縮2_リスト.add(RString.EMPTY);
        麻痺拘縮2_リスト.add(get名称01(認定調査票調査項目List, 連番6));
        麻痺拘縮2_リスト.add(get名称01(認定調査票調査項目List, 連番8));
        麻痺拘縮2_リスト.add(get名称01(認定調査票調査項目List, 連番10));
        return 麻痺拘縮2_リスト;
    }

    private static List<RString> get移動リスト(List<NinteichosahyoChosaItem> 認定調査票調査項目List) {
        List<RString> 移動リスト = new ArrayList<>();
        移動リスト.add(get名称02(認定調査票調査項目List, 連番11));
        移動リスト.add(get名称02(認定調査票調査項目List, 連番12));
        移動リスト.add(get名称03(認定調査票調査項目List, 連番13));
        移動リスト.add(get名称04(認定調査票調査項目List, 連番14));
        移動リスト.add(get名称02(認定調査票調査項目List, 連番15));
        移動リスト.add(get名称20(認定調査票調査項目List, 連番16));
        移動リスト.add(get名称20(認定調査票調査項目List, 連番17));
        return 移動リスト;
    }

    private static List<RString> getサービス状況02(List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList, RString サービス区分コード) {
        List<RString> サービス区分リスト = new ArrayList<>();
        if (RString.isNullOrEmpty(サービス区分コード)
                || サービス区分コード.equals(ServiceKubunCode.なし.getコード())) {
            サービス区分リスト.add(RString.isNullOrEmpty(サービス区分コード) ? RString.EMPTY
                    : ServiceKubunCode.toValue(サービス区分コード).get名称());
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
            サービス区分リスト.add(RString.EMPTY);
        } else {
            サービス区分リスト.add(ServiceKubunCode.toValue(サービス区分コード).get名称());
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 0)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番1)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番2)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番3)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番4)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番5)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番6)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番10)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番7)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番8)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番15)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番9)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番11)));
            if (認定調査票サービス状況フラグList != null
                    && !認定調査票サービス状況フラグList.isEmpty()
                    && 認定調査票サービス状況フラグList.get(0).isサービスの状況フラグ()) {
                サービス区分リスト.add(new RString("あり"));
            } else {
                サービス区分リスト.add(new RString("なし"));
            }
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番12)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番13)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番14)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番16)));
            サービス区分リスト.add(new RString(getサービス状況02(認定調査票サービス状況List, 連番17)));
        }
        return サービス区分リスト;
    }

    private static int getサービス状況02(List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List, int 連番) {
        if (連番 < 認定調査票サービス状況List.size()) {
            return 認定調査票サービス状況List.get(連番).getサービスの状況();
        }
        return 0;
    }

    private static void setBodyItem(NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity,
            YokaigoNinteiJohoTeikyoEntity entity,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RDateTime イメージID,
            RString 認定調査票マスキング区分) {
        setマスキング情報(ninteiChosaJohohyoEntity, entity, 認定調査票マスキング区分);
        ninteiChosaJohohyoEntity.set申請日_元号(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaJohohyoEntity.set申請日_年(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaJohohyoEntity.set申請日_月(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaJohohyoEntity.set申請日_日(entity.get認定申請年月日() == null ? RString.EMPTY : entity.get認定申請年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaJohohyoEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaJohohyoEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaJohohyoEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaJohohyoEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaJohohyoEntity.set調査日_元号(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaJohohyoEntity.set調査日_年(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaJohohyoEntity.set調査日_月(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaJohohyoEntity.set調査日_日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaJohohyoEntity.set審査日_元号(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        ninteiChosaJohohyoEntity.set審査日_年(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        ninteiChosaJohohyoEntity.set審査日_月(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        ninteiChosaJohohyoEntity.set審査日_日(entity.get審査会開催日() == null ? RString.EMPTY : entity.get審査会開催日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        ninteiChosaJohohyoEntity.setタイトル(DbBusinessConfig.get(ConfigNameDBE.認定調査情報票, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        ninteiChosaJohohyoEntity.set年齢(new RStringBuilder().append(entity.get年齢()).append(new RString(" 歳")).toRString());
        ninteiChosaJohohyoEntity.set性別(Seibetsu.toValue(entity.get性別()).get名称());
        setBodyItem01(ninteiChosaJohohyoEntity, entity, 認定調査票記入項目List, イメージID, 認定調査票マスキング区分);
    }

    private static void setマスキング情報(NinteiChosaJohohyoEntity ninteiEntity, YokaigoNinteiJohoTeikyoEntity entity,
            RString 認定調査票マスキング区分) throws IllegalArgumentException, NullPointerException {
        if (マスキング_あり.equals(認定調査票マスキング区分)) {
            ninteiEntity.set保険者番号(RString.EMPTY);
            ninteiEntity.set被保険者番号(RString.EMPTY);
            ninteiEntity.set被保険者氏名(RString.EMPTY);
            ninteiEntity.set郵便番号(RString.EMPTY);
            ninteiEntity.set電話(RString.EMPTY);
            ninteiEntity.set現住所(RString.EMPTY);
            ninteiEntity.set家族連絡先郵便番号(RString.EMPTY);
            ninteiEntity.set家族連絡先電話1(RString.EMPTY);
            ninteiEntity.set家族連絡先電話2(RString.EMPTY);
            ninteiEntity.set家族連絡先住所(RString.EMPTY);
            ninteiEntity.set家族連絡先名(RString.EMPTY);
            ninteiEntity.set記入者(RString.EMPTY);
            ninteiEntity.set所属機関(RString.EMPTY);
        } else {
            ninteiEntity.set保険者番号(entity.get保険者番号());
            ninteiEntity.set被保険者番号(entity.get被保険者番号());
            ninteiEntity.set被保険者氏名(entity.get被保険者氏名());
            ninteiEntity.set郵便番号(RString.isNullOrEmpty(entity.get郵便番号())
                    ? RString.EMPTY : new YubinNo(entity.get郵便番号()).getEditedYubinNo());
            ninteiEntity.set電話(entity.get電話());
            ninteiEntity.set現住所(entity.get住所());
            ninteiEntity.set家族連絡先郵便番号(RString.isNullOrEmpty(entity.get連絡先郵便番号()) ? RString.EMPTY
                    : new YubinNo(entity.get連絡先郵便番号()).getEditedYubinNo());
            ninteiEntity.set家族連絡先電話1(entity.get連絡先電話電話());
            ninteiEntity.set家族連絡先電話2(entity.get連絡先携帯電話());
            ninteiEntity.set家族連絡先住所(entity.get連絡先住所());
            ninteiEntity.set家族連絡先名(entity.get連絡先氏名());
            if (マスキング_調査員名.equals(認定調査票マスキング区分)) {
                ninteiEntity.set記入者(RString.EMPTY);
                ninteiEntity.set所属機関(RString.EMPTY);
            } else {
                ninteiEntity.set記入者(entity.get調査員氏名());
                ninteiEntity.set所属機関(entity.get事業者名称());
            }
        }
    }

    private static void setBodyItem01(NinteiChosaJohohyoEntity ninteiEntity, YokaigoNinteiJohoTeikyoEntity entity,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List, RDateTime イメージID, RString 認定調査票マスキング区分) {
        setBodyItem02(ninteiEntity, entity);
        ninteiEntity.set家族連絡先関係(RString.isNullOrEmpty(entity.get関係()) ? RString.EMPTY
                : RensakusakiTsuzukigara.toValue(entity.get関係()).get名称());
        ninteiEntity.set申請区分_申(RString.isNullOrEmpty(entity.get申請区分_申()) ? RString.EMPTY : NinteiShinseiShinseijiKubunCode
                .toValue(entity.get申請区分_申()).get名称());
        ninteiEntity.set変更事由(entity.get変更事由());
        ninteiEntity.set二次判定日(entity.get二次判定年月日() == null ? RString.EMPTY : entity.get二次判定年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set認定有効時間_月(entity.get認定有効期間());
        ninteiEntity.set認定有効時間From(entity.get認定有効期間開始年月日() == null ? RString.EMPTY : entity.get認定有効期間開始年月日().
                wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set認定有効時間To(entity.get認定有効期間終了年月日() == null ? RString.EMPTY : entity.get認定有効期間終了年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set状態像コード(RString.isNullOrEmpty(entity.get要介護状態像例コード()) ? RString.EMPTY
                : YokaigoJotaizoReiCode.toValue(entity.get要介護状態像例コード()).get名称());
        ninteiEntity.set特定疾病(RString.isNullOrEmpty(entity.get特定疾病()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get特定疾病()).get名称());
        ninteiEntity.set審査会意見(entity.get審査会意見());
        ninteiEntity.set前回判定日(entity.get前回認定日() == null ? RString.EMPTY : entity.get前回認定日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set前回判定有効時間_月(entity.get前回認定有効期間());
        ninteiEntity.set前回判定有効時間From(entity.get前回認定有効期間開始年月日() == null ? RString.EMPTY : entity.get前回認定有効期間開始年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set前回判定有効時間To(entity.get前回認定有効期間終了年月日() == null ? RString.EMPTY : entity.get前回認定有効期間終了年月日()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set調査実施日(entity.get実施年月日() == null ? RString.EMPTY : entity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninteiEntity.set実施場所コード(RString.isNullOrEmpty(entity.get実施場所コード()) ? RString.EMPTY
                : ChosaJisshiBashoCode.toValue(entity.get実施場所コード()).get名称());
        ninteiEntity.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        ninteiEntity.setサービス区分コード(entity.getサービス区分コード());
        if (テキスト.equals(entity.getテキスト_イメージ区分())) {
            ninteiEntity.set実施場所名称(entity.get実施場所名称());
            ninteiEntity.set市町村特別給付(get市町村特別給付(認定調査票記入項目List, 0));
            ninteiEntity.set介護保険給付外の在宅(get市町村特別給付(認定調査票記入項目List, 連番1));
            ninteiEntity.set施設名(entity.get施設名());
            ninteiEntity.set施設住所(entity.get施設住所());
            ninteiEntity.set施設電話(entity.get施設電話番号());
        } else {
            ninteiEntity.set実施場所名称(RString.EMPTY);
            ninteiEntity.set市町村特別給付(RString.EMPTY);
            ninteiEntity.set介護保険給付外の在宅(RString.EMPTY);
            ninteiEntity.set施設名(RString.EMPTY);
            ninteiEntity.set施設住所(RString.EMPTY);
            ninteiEntity.set施設電話(RString.EMPTY);
        }
        if (イメージ.equals(entity.getテキスト_イメージ区分())) {
            RString 共有ファイル名 = entity.get保険者番号().concat(entity.get被保険者番号());
            RString path = copySharedFiles(イメージID, 共有ファイル名);
            ninteiEntity.set実施場所イメージ(getイメージファイル名(path, イメージID01, 認定調査票マスキング区分));
            ninteiEntity.set市町村特別給付イメージ(getイメージファイル名(path, イメージID02, 認定調査票マスキング区分));
            ninteiEntity.set介護保険給付外の在宅イメージ(getイメージファイル名(path, イメージID03, 認定調査票マスキング区分));
            ninteiEntity.set施設名イメージ(getイメージファイル名(path, イメージID04, 認定調査票マスキング区分));
            ninteiEntity.set施設住所イメージ(getイメージファイル名(path, イメージID05, 認定調査票マスキング区分));
            ninteiEntity.set施設電話イメージ(getイメージファイル名(path, イメージID06, 認定調査票マスキング区分));
        }
        ninteiEntity.set施設利用(RString.isNullOrEmpty(entity.get施設利用()) ? RString.EMPTY
                : GenzainoJokyoCode.toValue(entity.get施設利用()).get名称());
        List<RString> 日常生活自立度リスト = new ArrayList<>();
        日常生活自立度リスト.add(RString.isNullOrEmpty(entity.get障害高齢者自立度()) ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get障害高齢者自立度()).get名称());
        日常生活自立度リスト.add(RString.isNullOrEmpty(entity.get認知症高齢者自立度()) ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get認知症高齢者自立度()).get名称());
        ninteiEntity.set日常生活自立度リスト(日常生活自立度リスト);
    }

    private static RString copySharedFiles(RDateTime sharedFileId, RString 共有ファイル名) {
        if (sharedFileId != null) {
            RString 出力イメージフォルダパス = Directory.createTmpDirectory();
            ReadOnlySharedFileEntryDescriptor descriptor
                    = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有ファイル名), sharedFileId);
            try {
                return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
            } catch (Exception e) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private static RString getイメージファイル名(RString path, RString fileName, RString 認定調査票マスキング区分) {
        RString file = マスキング_あり.equals(認定調査票マスキング区分) ? fileName.replace(拡張子_PNG.toString(), "_BAK.png") : fileName;
        RString fileFullPath = getFilePath(path, file);
        if (!RString.isNullOrEmpty(fileFullPath)) {
            return fileFullPath;
        }
        return RString.EMPTY;
    }

    private static RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }

    private static RString get市町村特別給付(List<NinteichosahyoKinyuItem> 認定調査票記入項目List, int 連番) {
        if (連番 < 認定調査票記入項目List.size()) {
            return 認定調査票記入項目List.get(連番).getサービスの状況記入();
        }
        return RString.EMPTY;
    }

    private static void setBodyItem02(NinteiChosaJohohyoEntity ninteiEntity, YokaigoNinteiJohoTeikyoEntity entity) {
        if (判定結果コード09.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果()).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果_認知症加算()).get名称())
                            .toRString();
                }
            }
            ninteiEntity.set一次判定結果(一次判定結果);
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun09.toValue(entity.get前回認定結果()).get名称());
        }
        if (判定結果コード06.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = IchijiHanteiKekkaCode06.toValue(entity.get一次判定結果()).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(IchijiHanteiKekkaCode06.toValue(entity.get一次判定結果_認知症加算()).get名称())
                            .toRString();
                }
            }
            ninteiEntity.set一次判定結果(一次判定結果);
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun06.toValue(entity.get前回認定結果()).get名称());
        }
        if (判定結果コード02.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = IchijiHanteiKekkaCode02.toValue(entity.get一次判定結果()).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(IchijiHanteiKekkaCode02.toValue(entity.get一次判定結果_認知症加算()).get名称())
                            .toRString();
                }
            }
            ninteiEntity.set一次判定結果(一次判定結果);
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun02.toValue(entity.get前回認定結果()).get名称());
        }
        if (判定結果コード99.equals(entity.get厚労省IF識別コード().substring(0, 2))) {
            RString 一次判定結果;
            if (RString.isNullOrEmpty(entity.get一次判定結果())) {
                一次判定結果 = RString.EMPTY;
            } else {
                一次判定結果 = IchijiHanteiKekkaCode99.toValue(entity.get一次判定結果()).get名称();
                if (!RString.isNullOrEmpty(entity.get一次判定結果_認知症加算())
                        && !entity.get一次判定結果().equals(entity.get一次判定結果_認知症加算())) {
                    一次判定結果 = new RStringBuilder()
                            .append(一次判定結果)
                            .append("→")
                            .append(IchijiHanteiKekkaCode99.toValue(entity.get一次判定結果_認知症加算()).get名称())
                            .toRString();
                }
            }
            ninteiEntity.set一次判定結果(一次判定結果);
            ninteiEntity.set二次判定結果(RString.isNullOrEmpty(entity.get二次判定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get二次判定結果()).get名称());
            ninteiEntity.set前回判定結果(RString.isNullOrEmpty(entity.get前回認定結果()) ? RString.EMPTY
                    : YokaigoJotaiKubun99.toValue(entity.get前回認定結果()).get名称());
        }
    }

    private static RString get名称24(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser24.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称17(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser17.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称16(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser16.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称15(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser15.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称14(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser14.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称13(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser13.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称23(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser23.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称11(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser11.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称22(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser22.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称09(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser09.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称08(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser08.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称21(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser21.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称20(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser20.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称04(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser04.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称03(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser03.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称02(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser02.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称01(List<NinteichosahyoChosaItem> 認定調査票調査項目List, int 連番) {
        if (連番 < 認定調査票調査項目List.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目List.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser01.toValue(認定調査票調査項目List.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }
}
