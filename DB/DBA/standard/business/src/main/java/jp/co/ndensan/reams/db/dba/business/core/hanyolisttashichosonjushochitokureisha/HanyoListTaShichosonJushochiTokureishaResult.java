/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hanyolisttashichosonjushochitokureisha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku.JiyuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku.KijunbiKubun;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu.JogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト_他市町村住所地特例者のビジネスです。
 *
 * @reamsid_L DBA-1590-030 yaodongsheng
 */
public class HanyoListTaShichosonJushochiTokureishaResult {

    private static final RString 住所地特例 = new RString("住特");
    private static final RString 抽出条件 = new RString("【抽出条件】");
    private static final RString 日付抽出区分 = new RString("日付抽出区分：");
    private static final RString 範囲抽出日区分 = new RString("範囲抽出日区分：");
    private static final RString 基準日区分 = new RString("基準日区分：");
    private static final RString 基準日 = new RString("基準日：");
    private static final RString 範囲抽出日 = new RString("範囲抽出日：");
    private static final RString カラ = new RString("　～　");
    private static final RString 除外者情報 = new RString("除外者情報：");
    private static final RString 日本人 = new RString("日本人");
    private static final RString コンマ = new RString("、");
    private static final RString 外国人 = new RString("外国人");
    private static final RString 資格抽出区分 = new RString("資格抽出区分：");
    private static final RString 適用事由区分 = new RString("適用事由：");
    private static final RString 解除事由区分 = new RString("解除事由：");
    private static final RString 施設変更区分 = new RString("施設変更：");
    private static final RString 施設変更あり = new RString("施設変更あり");
    private static final RString 施設変更なし = new RString("施設変更なし");
    private static final RString 年齢 = new RString("年齢：");
    private static final RString 歳 = new RString("歳");
    private static final RString 年齢基準日 = new RString("　（年齢基準日：");
    private static final RString 右パーレン = new RString("）");
    private static final RString 生年月日 = new RString("生年月日：");
    private static final RString 地区区分 = new RString("地区区分：");

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param processParameter processParameter
     * @param entity 他市町村住所地特例者Entity
     * @param koseiShichosonJoho 構成市町村マスタ
     * @param association 地方公共団体管理
     * @return HanyoListTaShichosonJushochiTokureishaRenbanCsvEntity
     */
    public HanyoListTaShichosonJushochiTokureishaCsvEntity setEucCsvEntity(
            HanyoListTaShichosonJushochiTokureishaProcessParameter processParameter,
            HanyoListTaShichosonJushochiTokureishaRelateEntity entity,
            List<KoseiShichosonMaster> koseiShichosonJoho,
            Association association) {
        HanyoListTaShichosonJushochiTokureishaCsvEntity eucCsvEntity = new HanyoListTaShichosonJushochiTokureishaCsvEntity();
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住民種別(kojin.get住民種別().getCode());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
            eucCsvEntity.set生年月日(set年月日(processParameter, kojin.get生年月日().toFlexibleDate()));
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set性別(kojin.get性別().getCode());
            eucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            eucCsvEntity.set世帯コード(kojin.get世帯コード().value());
            eucCsvEntity.set世帯主名(kojin.get世帯主名().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            eucCsvEntity.set住所番地方書(address.toRString());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            eucCsvEntity.set方書(kojin.get住所().get方書().value());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucCsvEntity.set地区１(kojin.get行政区画().getChiku1().get名称());
            eucCsvEntity.set地区２(kojin.get行政区画().getChiku2().get名称());
            eucCsvEntity.set地区３(kojin.get行政区画().getChiku3().get名称());
            eucCsvEntity.set連絡先１(kojin.get連絡先１().value());
            eucCsvEntity.set連絡先２(kojin.get連絡先２().value());
            eucCsvEntity.set登録異動日(set年月日(processParameter, kojin.get登録異動年月日()));
            eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由コード());
            eucCsvEntity.set登録届出日(set年月日(processParameter, kojin.get登録届出年月日()));
            eucCsvEntity.set住定異動日(set年月日(processParameter, kojin.get住定異動年月日()));
            eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由コード());
            eucCsvEntity.set住定届出日(set年月日(processParameter, kojin.get住定届出年月日()));
            eucCsvEntity.set消除異動日(set年月日(processParameter, kojin.get消除異動年月日()));
            eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由コード());
            eucCsvEntity.set消除届出日(set年月日(processParameter, kojin.get消除届出年月日()));
            eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            eucCsvEntity.set前住所番地方書(addressZen.toRString());
            eucCsvEntity.set前住所(kojin.get転入前().get住所());
            eucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            eucCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        eucCsvEntity.set市町村名(association.get市町村名());
        eucCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        eucCsvEntity.set保険者名(association.getShichosonName_());
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set市町村コード(entity.get市町村コード());
        eucCsvEntity.set被保険者番号(entity.get被保険者番号());
        eucCsvEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get資格取得事由()));
        eucCsvEntity.set資格取得日(set年月日(processParameter, entity.get資格取得日()));
        eucCsvEntity.set資格取得届出日(set年月日(processParameter, entity.get資格取得届出日()));
        eucCsvEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), entity.get喪失事由()));
        eucCsvEntity.set資格喪失日(set年月日(processParameter, entity.get資格喪失日()));
        eucCsvEntity.set資格喪失届日(set年月日(processParameter, entity.get資格喪失届日()));
        RString 資格区分 = entity.get資格区分();
        if (資格区分 == null) {
            eucCsvEntity.set資格区分(RString.EMPTY);
        } else {
            eucCsvEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get資格区分()).get名称());
        }
        if (new RString("1").equals(entity.get住所地特例状態())) {
            eucCsvEntity.set住所地特例状態(住所地特例);
        } else {
            eucCsvEntity.set住所地特例状態(RString.EMPTY);
        }
        RString lasdecCode;
        if (new RString("1").equals(entity.get広域内住所地特例フラグ())) {
            lasdecCode = entity.get広住特措置元市町村コード();
        } else {
            lasdecCode = entity.get市町村コード();
        }
        for (KoseiShichosonMaster master : koseiShichosonJoho) {
            if (master.get市町村コード().value().equals(lasdecCode)) {
                eucCsvEntity.set資格証記載保険者番号(master.get証記載保険者番号().value());
                break;
            } else {
                eucCsvEntity.set資格証記載保険者番号(RString.EMPTY);
            }
        }
        eucCsvEntity.set他住所特例適用事由(JogaiTekiyoJiyu.toValue(entity.get他住所特例適用事由()).get名称());
        eucCsvEntity.set他住所特例適用日(set年月日(processParameter, entity.get他住所特例適用日()));
        eucCsvEntity.set他住所特例適用届出日(set年月日(processParameter, entity.get他住所特例適用届出日()));
        RString 適用除外解除事由 = entity.get他住所特例解除事由();
        if (適用除外解除事由 == null) {
            eucCsvEntity.set他住所特例解除事由(RString.EMPTY);
        } else {
            eucCsvEntity.set他住所特例解除事由(JogaiKaijoJiyu.toValue(適用除外解除事由).get名称());
        }
        eucCsvEntity.set他住所特例解除日(set年月日(processParameter, entity.get他住所特例解除日()));
        eucCsvEntity.set他住所特例解除届出日(set年月日(processParameter, entity.get他住所特例解除届出日()));
        eucCsvEntity.set他住所特例施設コード(entity.get他住所特例施設コード());
        eucCsvEntity.set他住所特例施設名称(entity.get他住所特例施設名称());
        eucCsvEntity.set他住所特例入所日(set年月日(processParameter, entity.get他住所特例入所日()));
        eucCsvEntity.set他住所特例退所日(set年月日(processParameter, entity.get他住所特例退所日()));
        eucCsvEntity.set前保険者番号(entity.get前保険者番号());
        eucCsvEntity.set他被保険者番号(entity.get他被保険者番号());
        eucCsvEntity.set他住所特例連絡票発行日(set年月日(processParameter, entity.get他住所特例連絡票発行日()));
        eucCsvEntity.set他住所特例施設郵便番号(set郵便番号(entity.get他住所特例施設郵便番号()));
        eucCsvEntity.set他住所特例施設住所(entity.get他住所特例施設住所());
        eucCsvEntity.set他住所特例施設電話番号(entity.get他住所特例施設電話番号());
        eucCsvEntity.set施設退所通知発行日(set年月日(processParameter, entity.get施設退所通知発行日()));
        eucCsvEntity.set施設変更通知発行日(set年月日(processParameter, entity.get施設変更通知発行日()));
        eucCsvEntity.set医療保険種別(getCodeNameByCode(DBACodeShubetsu.医療保険種類.getコード(), entity.get医療保険種別()));
        eucCsvEntity.set医療保険番号(entity.get医療保険番号());
        eucCsvEntity.set医療保険者名(entity.get医療保険者名());
        eucCsvEntity.set医療保険記号番号(entity.get医療保険記号番号());
        return eucCsvEntity;
    }

    /**
     * RenbanEucCsvEntityの設定メッソドです。
     *
     * @param processParameter processParameter
     * @param entity 他市町村住所地特例者Entity
     * @param koseiShichosonJoho 構成市町村マスタ
     * @param i index
     * @param association 地方公共団体管理
     * @return HanyoListTaShichosonJushochiTokureishaRenbanCsvEntity
     */
    public HanyoListTaShichosonJushochiTokureishaRenbanCsvEntity setRenbanEucCsvEntity(
            HanyoListTaShichosonJushochiTokureishaProcessParameter processParameter,
            HanyoListTaShichosonJushochiTokureishaRelateEntity entity,
            List<KoseiShichosonMaster> koseiShichosonJoho,
            int i,
            Association association) {
        HanyoListTaShichosonJushochiTokureishaRenbanCsvEntity eucRenbanCsvEntity = new HanyoListTaShichosonJushochiTokureishaRenbanCsvEntity();
        eucRenbanCsvEntity.set連番(new RString(String.valueOf(i)));
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucRenbanCsvEntity.set識別コード(kojin.get識別コード().value());
            eucRenbanCsvEntity.set住民種別(kojin.get住民種別().getCode());
            eucRenbanCsvEntity.set氏名(kojin.get名称().getName().value());
            eucRenbanCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
            eucRenbanCsvEntity.set生年月日(set年月日(processParameter, kojin.get生年月日().toFlexibleDate()));
            eucRenbanCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucRenbanCsvEntity.set性別(kojin.get性別().getCode());
            eucRenbanCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            eucRenbanCsvEntity.set世帯コード(kojin.get世帯コード().value());
            eucRenbanCsvEntity.set世帯主名(kojin.get世帯主名().value());
            eucRenbanCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucRenbanCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            eucRenbanCsvEntity.set住所番地方書(address.toRString());
            eucRenbanCsvEntity.set住所(kojin.get住所().get住所());
            eucRenbanCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            eucRenbanCsvEntity.set方書(kojin.get住所().get方書().value());
            eucRenbanCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucRenbanCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucRenbanCsvEntity.set地区１(kojin.get行政区画().getChiku1().get名称());
            eucRenbanCsvEntity.set地区２(kojin.get行政区画().getChiku2().get名称());
            eucRenbanCsvEntity.set地区３(kojin.get行政区画().getChiku3().get名称());
            eucRenbanCsvEntity.set連絡先１(kojin.get連絡先１().value());
            eucRenbanCsvEntity.set連絡先２(kojin.get連絡先２().value());
            eucRenbanCsvEntity.set登録異動日(set年月日(processParameter, kojin.get登録異動年月日()));
            eucRenbanCsvEntity.set登録事由(kojin.get登録事由().get異動事由コード());
            eucRenbanCsvEntity.set登録届出日(set年月日(processParameter, kojin.get登録届出年月日()));
            eucRenbanCsvEntity.set住定異動日(set年月日(processParameter, kojin.get住定異動年月日()));
            eucRenbanCsvEntity.set住定事由(kojin.get住定事由().get異動事由コード());
            eucRenbanCsvEntity.set住定届出日(set年月日(processParameter, kojin.get住定届出年月日()));
            eucRenbanCsvEntity.set消除異動日(set年月日(processParameter, kojin.get消除異動年月日()));
            eucRenbanCsvEntity.set消除事由(kojin.get消除事由().get異動事由コード());
            eucRenbanCsvEntity.set消除届出日(set年月日(processParameter, kojin.get消除届出年月日()));
            eucRenbanCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            eucRenbanCsvEntity.set前住所番地方書(addressZen.toRString());
            eucRenbanCsvEntity.set前住所(kojin.get転入前().get住所());
            eucRenbanCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            eucRenbanCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        eucRenbanCsvEntity.set市町村名(association.get市町村名());
        eucRenbanCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        eucRenbanCsvEntity.set保険者名(association.getShichosonName_());
        eucRenbanCsvEntity.set空白(RString.EMPTY);
        eucRenbanCsvEntity.set市町村コード(entity.get市町村コード());
        eucRenbanCsvEntity.set被保険者番号(entity.get被保険者番号());
        eucRenbanCsvEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get資格取得事由()));
        eucRenbanCsvEntity.set資格取得日(set年月日(processParameter, entity.get資格取得日()));
        eucRenbanCsvEntity.set資格取得届出日(set年月日(processParameter, entity.get資格取得届出日()));
        eucRenbanCsvEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), entity.get喪失事由()));
        eucRenbanCsvEntity.set資格喪失日(set年月日(processParameter, entity.get資格喪失日()));
        eucRenbanCsvEntity.set資格喪失届日(set年月日(processParameter, entity.get資格喪失届日()));
        RString 資格区分 = entity.get資格区分();
        if (資格区分 == null) {
            eucRenbanCsvEntity.set資格区分(RString.EMPTY);
        } else {
            eucRenbanCsvEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get資格区分()).get名称());
        }
        if (new RString("1").equals(entity.get住所地特例状態())) {
            eucRenbanCsvEntity.set住所地特例状態(住所地特例);
        } else {
            eucRenbanCsvEntity.set住所地特例状態(RString.EMPTY);
        }
        RString lasdecCode;
        if (new RString("1").equals(entity.get広域内住所地特例フラグ())) {
            lasdecCode = entity.get広住特措置元市町村コード();
        } else {
            lasdecCode = entity.get市町村コード();
        }
        for (KoseiShichosonMaster master : koseiShichosonJoho) {
            if (master.get市町村コード().value().equals(lasdecCode)) {
                eucRenbanCsvEntity.set資格証記載保険者番号(master.get証記載保険者番号().value());
                break;
            } else {
                eucRenbanCsvEntity.set資格証記載保険者番号(RString.EMPTY);
            }
        }
        eucRenbanCsvEntity.set他住所特例適用事由(JogaiTekiyoJiyu.toValue(entity.get他住所特例適用事由()).get名称());
        eucRenbanCsvEntity.set他住所特例適用日(set年月日(processParameter, entity.get他住所特例適用日()));
        eucRenbanCsvEntity.set他住所特例適用届出日(set年月日(processParameter, entity.get他住所特例適用届出日()));
        RString 適用除外解除事由 = entity.get他住所特例解除事由();
        if (適用除外解除事由 == null) {
            eucRenbanCsvEntity.set他住所特例解除事由(RString.EMPTY);
        } else {
            eucRenbanCsvEntity.set他住所特例解除事由(JogaiKaijoJiyu.toValue(適用除外解除事由).get名称());
        }
        eucRenbanCsvEntity.set他住所特例解除日(set年月日(processParameter, entity.get他住所特例解除日()));
        eucRenbanCsvEntity.set他住所特例解除届出日(set年月日(processParameter, entity.get他住所特例解除届出日()));
        eucRenbanCsvEntity.set他住所特例施設コード(entity.get他住所特例施設コード());
        eucRenbanCsvEntity.set他住所特例施設名称(entity.get他住所特例施設名称());
        eucRenbanCsvEntity.set他住所特例入所日(set年月日(processParameter, entity.get他住所特例入所日()));
        eucRenbanCsvEntity.set他住所特例退所日(set年月日(processParameter, entity.get他住所特例退所日()));
        eucRenbanCsvEntity.set前保険者番号(entity.get前保険者番号());
        eucRenbanCsvEntity.set他被保険者番号(entity.get他被保険者番号());
        eucRenbanCsvEntity.set他住所特例連絡票発行日(set年月日(processParameter, entity.get他住所特例連絡票発行日()));
        eucRenbanCsvEntity.set他住所特例施設郵便番号(set郵便番号(entity.get他住所特例施設郵便番号()));
        eucRenbanCsvEntity.set他住所特例施設住所(entity.get他住所特例施設住所());
        eucRenbanCsvEntity.set他住所特例施設電話番号(entity.get他住所特例施設電話番号());
        eucRenbanCsvEntity.set施設退所通知発行日(set年月日(processParameter, entity.get施設退所通知発行日()));
        eucRenbanCsvEntity.set施設変更通知発行日(set年月日(processParameter, entity.get施設変更通知発行日()));
        eucRenbanCsvEntity.set医療保険種別(getCodeNameByCode(DBACodeShubetsu.医療保険種類.getコード(), entity.get医療保険種別()));
        eucRenbanCsvEntity.set医療保険番号(entity.get医療保険番号());
        eucRenbanCsvEntity.set医療保険者名(entity.get医療保険者名());
        eucRenbanCsvEntity.set医療保険記号番号(entity.get医療保険記号番号());
        return eucRenbanCsvEntity;
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParameter processParameter
     * @param kaigoDonyuKeitai 導入形態
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(HanyoListTaShichosonJushochiTokureishaProcessParameter processParameter, List<KaigoDonyuKeitai> kaigoDonyuKeitai) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        出力条件List.add(抽出条件);
        jokenBuilder.append(日付抽出区分);
        jokenBuilder.append(HizukeChushutsuKubun.toValue(processParameter.getHitsukeChushutsuKubun()).get名称());
        出力条件List.add(jokenBuilder.toRString());
        if (HizukeChushutsuKubun.範囲.getコード().equals(processParameter.getHitsukeChushutsuKubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(範囲抽出日区分);
            jokenBuilder.append(HaniChushutsubiKubun.toValue(processParameter.getChushutsunichiKubun()).get名称());
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(範囲抽出日);
            jokenBuilder.append(set出力条件表の日付(processParameter.getChushutsunichiFrom()));
            jokenBuilder.append(カラ);
            jokenBuilder.append(set出力条件表の日付(processParameter.getChushutsunichiTo()));
            出力条件List.add(jokenBuilder.toRString());
        }
        if (HizukeChushutsuKubun.基準日.getコード().equals(processParameter.getHitsukeChushutsuKubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(基準日区分);
            jokenBuilder.append(KijunbiKubun.toValue(processParameter.getKijunYMDkubun()).get名称());
            出力条件List.add(jokenBuilder.toRString());
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(基準日);
            jokenBuilder.append(set出力条件表の日付(processParameter.getKijunYMD()));
            出力条件List.add(jokenBuilder.toRString());
        }
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(除外者情報);
        if (processParameter.isJukyushaJoho_Nihonjin()) {
            jokenBuilder.append(日本人);
        }
        if (processParameter.isJukyushaJoho_Nihonjin() && processParameter.isJukyushaJoho_Gaikokujin()) {
            jokenBuilder.append(コンマ);
        }
        if (processParameter.isJukyushaJoho_Gaikokujin()) {
            jokenBuilder.append(外国人);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(資格抽出区分);
        jokenBuilder.append(JiyuChushutsuKubun.toValue(processParameter.getJyuChusyutsuKubun()).get名称());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(適用事由区分);
        for (RString 適用事由 : processParameter.getDekyujyu()) {
            jokenBuilder.append(JogaiTekiyoJiyu.toValue(適用事由).get名称());
            jokenBuilder.append(コンマ);
        }
        if (!processParameter.getDekyujyu().isEmpty()) {
            jokenBuilder.deleteCharAt(jokenBuilder.length() - 1);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(解除事由区分);
        for (RString 解除事由 : processParameter.getKaijyojyu()) {
            jokenBuilder.append(JogaiKaijoJiyu.toValue(解除事由).get名称());
            jokenBuilder.append(コンマ);
        }
        if (!processParameter.getKaijyojyu().isEmpty()) {
            jokenBuilder.deleteCharAt(jokenBuilder.length() - 1);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(施設変更区分);
        if (processParameter.isShisetsuHenkoari()) {
            jokenBuilder.append(施設変更あり);
        }
        if (processParameter.isShisetsuHenkoari() && processParameter.isShisetsuHenkonashi()) {
            jokenBuilder.append(コンマ);
        }
        if (processParameter.isShisetsuHenkonashi()) {
            jokenBuilder.append(施設変更なし);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(processParameter.getPsmChushutsu_Kubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(年齢);
            setAge(processParameter.getPsmChushutsuAge_Start(), jokenBuilder);
            jokenBuilder.append(歳);
            jokenBuilder.append(カラ);
            setAge(processParameter.getPsmChushutsuAge_End(), jokenBuilder);
            jokenBuilder.append(歳);
            jokenBuilder.append(年齢基準日);
            jokenBuilder.append(set出力条件表の日付(processParameter.getPsmAgeKijunni()));
            jokenBuilder.append(右パーレン);
            出力条件List.add(jokenBuilder.toRString());
        }
        if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(processParameter.getPsmChushutsu_Kubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(生年月日);
            jokenBuilder.append(set出力条件表の日付(processParameter.getPsmSeinengappiYMD_Start()));
            jokenBuilder.append(カラ);
            jokenBuilder.append(set出力条件表の日付(processParameter.getPsmSeinengappiYMD_End()));
            出力条件List.add(jokenBuilder.toRString());
        }
        set地区(processParameter, 出力条件List);
        if (kaigoDonyuKeitai.get(0).get導入形態コード().is広域()) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("保険者："));
            jokenBuilder.append(processParameter.getShichoson_Code());
            jokenBuilder.append(RString.HALF_SPACE);
            jokenBuilder.append(processParameter.getShichoson_Name());
            出力条件List.add(jokenBuilder.toRString());
        }
        return 出力条件List;
    }

    private void setAge(Decimal age, RStringBuilder jokenBuilder) {
        if (age == null) {
            jokenBuilder.append(RString.EMPTY);
        } else {
            jokenBuilder.append(age);
        }
    }

    private void set地区(HanyoListTaShichosonJushochiTokureishaProcessParameter processParameter, List<RString> 出力条件List) {
        if (!Chiku.全て.getコード().equals(processParameter.getPsmChiku_Kubun())) {
            RStringBuilder jokenBuilder = new RStringBuilder();
            jokenBuilder.append(地区区分);
            if (Chiku.住所.getコード().equals(processParameter.getPsmChiku_Kubun())) {
                jokenBuilder.append(processParameter.getPsmJusho_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmJusho_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParameter.getPsmJusho_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmJusho_To_Name());
            } else if (Chiku.行政区.getコード().equals(processParameter.getPsmChiku_Kubun())) {
                jokenBuilder.append(processParameter.getPsmGyoseiku_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmGyoseiku_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParameter.getPsmGyoseiku_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmGyoseiku_To_Name());
            } else if (Chiku.地区.getコード().equals(processParameter.getPsmChiku_Kubun())) {
                jokenBuilder.append(processParameter.getPsmChiku1_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmChiku1_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParameter.getPsmChiku1_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmChiku1_To_Name());
                jokenBuilder.append(コンマ);
                jokenBuilder.append(processParameter.getPsmChiku2_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmChiku2_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParameter.getPsmChiku2_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmChiku2_To_Name());
                jokenBuilder.append(コンマ);
                jokenBuilder.append(processParameter.getPsmChiku3_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmChiku3_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParameter.getPsmChiku3_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParameter.getPsmChiku3_To_Name());
            }
            出力条件List.add(jokenBuilder.toRString());
        }
    }

    private RString set出力条件表の日付(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new FlexibleDate(date.toDateString()).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set出力条件表の日付(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set年月日(HanyoListTaShichosonJushochiTokureishaProcessParameter processParameter, FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (processParameter.isHitsukeHenshu()) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        }
    }

    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBA介護資格,
                codeShubetsu,
                new Code(code),
                FlexibleDate.getNowDate());
    }

    private RString set郵便番号(RString 郵便番号) {
        if (RString.isNullOrEmpty(郵便番号)) {
            return RString.EMPTY;
        }
        return new YubinNo(郵便番号).getEditedYubinNo();
    }
}
