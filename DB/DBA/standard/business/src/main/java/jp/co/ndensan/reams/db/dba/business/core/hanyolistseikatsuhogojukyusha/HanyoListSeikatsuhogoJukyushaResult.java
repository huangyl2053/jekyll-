/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hanyolistseikatsuhogojukyusha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.seiho.HaniChushutsubiKubun;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト_生活保護受給者のビジネスです。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
public class HanyoListSeikatsuhogoJukyushaResult {

    private static final RString 住所地特例 = new RString("住特");
    private static final RString 抽出条件 = new RString("【抽出条件】");
    private static final RString 日付抽出区分 = new RString("日付抽出区分：");
    private static final RString 範囲抽出日区分 = new RString("範囲抽出日区分：");
    private static final RString 基準日 = new RString("基準日：");
    private static final RString 範囲抽出日 = new RString("範囲抽出日：");
    private static final RString カラ = new RString("　～　");
    private static final RString 生活保護受給者情報 = new RString("生活保護受給者情報：");
    private static final RString 日本人 = new RString("日本人");
    private static final RString コンマ = new RString("、");
    private static final RString 外国人 = new RString("外国人");
    private static final RString 生活保護 = new RString("生活保護：");
    private static final RString 年齢 = new RString("年齢：");
    private static final RString 歳 = new RString("歳");
    private static final RString 年齢基準日 = new RString("　（年齢基準日：");
    private static final RString 右パーレン = new RString("）");
    private static final RString 生年月日 = new RString("生年月日：");
    private static final RString 地区区分 = new RString("地区区分：");
    private static final RString フラグ = new RString("1");

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param processParamter processParamter
     * @param entity 生活保護受給者Entity
     * @param koseiShichosonJoho 構成市町村マスタ
     * @param association 地方公共団体管理
     * @param 生活保護種別builder 生活保護種別
     * @return SeikatsuhogoJukyushaRenbanCsvEntity
     */
    public SeikatsuhogoJukyushaCsvEntity setEucCsvEntity(
            SeikatsuhogoJukyushaProcessParameter processParamter,
            SeikatsuhogoJukyushaRelateEntity entity,
            List<KoseiShichosonMaster> koseiShichosonJoho,
            Association association,
            RStringBuilder 生活保護種別builder) {
        SeikatsuhogoJukyushaCsvEntity eucCsvEntity = new SeikatsuhogoJukyushaCsvEntity();
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            if (kojin != null) {
                eucCsvEntity.set識別コード(kojin.get識別コード().value());
                eucCsvEntity.set住民種別(kojin.get住民種別().getCode());
                eucCsvEntity.set氏名(kojin.get名称().getName().value());
                eucCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
                eucCsvEntity.set生年月日(set年月日(processParamter, kojin.get生年月日().toFlexibleDate()));
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
                eucCsvEntity.set住所_番地_方書(address.toRString());
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
                eucCsvEntity.set登録異動日(set年月日(processParamter, kojin.get登録異動年月日()));
                eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由コード());
                eucCsvEntity.set登録届出日(set年月日(processParamter, kojin.get登録届出年月日()));
                eucCsvEntity.set住定異動日(set年月日(processParamter, kojin.get住定異動年月日()));
                eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由コード());
                eucCsvEntity.set住定届出日(set年月日(processParamter, kojin.get住定届出年月日()));
                eucCsvEntity.set消除異動日(set年月日(processParamter, kojin.get消除異動年月日()));
                eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由コード());
                eucCsvEntity.set消除届出日(set年月日(processParamter, kojin.get消除届出年月日()));
                eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
                RStringBuilder addressZen = new RStringBuilder();
                addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                        .append(kojin.get転入前().get方書().value());
                eucCsvEntity.set前住所_番地_方書(addressZen.toRString());
                eucCsvEntity.set前住所(kojin.get転入前().get住所());
                eucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
                eucCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
            }
        }
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            if (atesaki != null) {
                eucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
                eucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
                eucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
                eucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
                RStringBuilder 送付address = new RStringBuilder();
                送付address.append(atesaki.get宛先住所().get住所()).append(
                        atesaki.get宛先住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                        .append(atesaki.get宛先住所().get方書().value());
                eucCsvEntity.set送付先住所_番地_方書(送付address.toRString());
                eucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
                eucCsvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
                eucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
                eucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
                eucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
            }
        }
        eucCsvEntity.set市町村名(association.get市町村名());
        eucCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        eucCsvEntity.set保険者名(association.getShichosonName_());
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set市町村コード(entity.get市町村コード());
        eucCsvEntity.set被保険者番号(entity.get被保険者番号());
        eucCsvEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get資格取得事由()));
        eucCsvEntity.set資格取得日(set年月日(processParamter, entity.get資格取得日()));
        eucCsvEntity.set資格取得届出日(set年月日(processParamter, entity.get資格取得届出日()));
        eucCsvEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get喪失事由()));
        eucCsvEntity.set資格喪失日(set年月日(processParamter, entity.get資格喪失日()));
        eucCsvEntity.set資格喪失届日(set年月日(processParamter, entity.get資格喪失届日()));
        eucCsvEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get資格区分()).get名称());
        if (フラグ.equals(entity.get住所地特例状態())) {
            eucCsvEntity.set住所地特例状態(住所地特例);
        } else {
            eucCsvEntity.set住所地特例状態(RString.EMPTY);
        }
        RString lasdecCode;
        if (フラグ.equals(entity.get広域内住所地特例フラグ())) {
            lasdecCode = entity.get広住特措置元市町村コード();
        } else {
            lasdecCode = entity.get市町村コード();
        }
        for (KoseiShichosonMaster master : koseiShichosonJoho) {
            if (master.get市町村コード().value().equals(lasdecCode)) {
                eucCsvEntity.set資格_証記載保険者番号(master.get証記載保険者番号().value());
                break;
            } else {
                eucCsvEntity.set資格_証記載保険者番号(RString.EMPTY);
            }
        }
        eucCsvEntity.set老齢福祉年金開始日(set年月日(processParamter, entity.get老齢福祉年金開始日()));
        eucCsvEntity.set老齢福祉年金終了日(set年月日(processParamter, entity.get老齢福祉年金終了日()));
        eucCsvEntity.set生活保護開始日(set年月日(processParamter, entity.get生活保護開始日()));
        eucCsvEntity.set生活保護終了日(set年月日(processParamter, entity.get生活保護終了日()));
        eucCsvEntity.set生活保護種別(生活保護種別builder.toRString().remove(生活保護種別builder.length() - 1));
        eucCsvEntity.set医療保険種別(getCodeNameByCode(DBACodeShubetsu.医療保険種類.getコード(), entity.get医療保険種別()));
        eucCsvEntity.set医療保険番号(entity.get医療保険番号());
        eucCsvEntity.set医療保険者名(entity.get医療保険者名());
        eucCsvEntity.set医療保険記号番号(entity.get医療保険記号番号());
        return eucCsvEntity;
    }

    /**
     * RenbanEucCsvEntityの設定メッソドです。
     *
     * @param processParamter processParamter
     * @param entity 生活保護受給者Entity
     * @param koseiShichosonJoho 構成市町村マスタ
     * @param i index
     * @param association 地方公共団体管理
     * @param 生活保護種別builder 生活保護種別
     * @return SeikatsuhogoJukyushaRenbanCsvEntity
     */
    public SeikatsuhogoJukyushaRenbanCsvEntity setRenbanEucCsvEntity(
            SeikatsuhogoJukyushaProcessParameter processParamter,
            SeikatsuhogoJukyushaRelateEntity entity,
            List<KoseiShichosonMaster> koseiShichosonJoho,
            int i,
            Association association,
            RStringBuilder 生活保護種別builder) {
        SeikatsuhogoJukyushaRenbanCsvEntity renbanEucCsvEntity = new SeikatsuhogoJukyushaRenbanCsvEntity();
        renbanEucCsvEntity.set連番(new RString(String.valueOf(i)));
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            renbanEucCsvEntity.set識別コード(kojin.get識別コード().value());
            renbanEucCsvEntity.set住民種別(kojin.get住民種別().getCode());
            renbanEucCsvEntity.set氏名(kojin.get名称().getName().value());
            renbanEucCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
            renbanEucCsvEntity.set生年月日(set年月日(processParamter, kojin.get生年月日().toFlexibleDate()));
            renbanEucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            renbanEucCsvEntity.set性別(kojin.get性別().getCode());
            renbanEucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            renbanEucCsvEntity.set世帯コード(kojin.get世帯コード().value());
            renbanEucCsvEntity.set世帯主名(kojin.get世帯主名().value());
            renbanEucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            renbanEucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            renbanEucCsvEntity.set住所_番地_方書(address.toRString());
            renbanEucCsvEntity.set住所(kojin.get住所().get住所());
            renbanEucCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            renbanEucCsvEntity.set方書(kojin.get住所().get方書().value());
            renbanEucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            renbanEucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            renbanEucCsvEntity.set地区１(kojin.get行政区画().getChiku1().get名称());
            renbanEucCsvEntity.set地区２(kojin.get行政区画().getChiku2().get名称());
            renbanEucCsvEntity.set地区３(kojin.get行政区画().getChiku3().get名称());
            renbanEucCsvEntity.set連絡先１(kojin.get連絡先１().value());
            renbanEucCsvEntity.set連絡先２(kojin.get連絡先２().value());
            renbanEucCsvEntity.set登録異動日(set年月日(processParamter, kojin.get登録異動年月日()));
            renbanEucCsvEntity.set登録事由(kojin.get登録事由().get異動事由コード());
            renbanEucCsvEntity.set登録届出日(set年月日(processParamter, kojin.get登録届出年月日()));
            renbanEucCsvEntity.set住定異動日(set年月日(processParamter, kojin.get住定異動年月日()));
            renbanEucCsvEntity.set住定事由(kojin.get住定事由().get異動事由コード());
            renbanEucCsvEntity.set住定届出日(set年月日(processParamter, kojin.get住定届出年月日()));
            renbanEucCsvEntity.set消除異動日(set年月日(processParamter, kojin.get消除異動年月日()));
            renbanEucCsvEntity.set消除事由(kojin.get消除事由().get異動事由コード());
            renbanEucCsvEntity.set消除届出日(set年月日(processParamter, kojin.get消除届出年月日()));
            renbanEucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            renbanEucCsvEntity.set前住所_番地_方書(addressZen.toRString());
            renbanEucCsvEntity.set前住所(kojin.get転入前().get住所());
            renbanEucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            renbanEucCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            renbanEucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
            renbanEucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
            renbanEucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
            renbanEucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            RStringBuilder 送付address = new RStringBuilder();
            送付address.append(atesaki.get宛先住所().get住所()).append(
                    atesaki.get宛先住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(atesaki.get宛先住所().get方書().value());
            renbanEucCsvEntity.set送付先住所_番地_方書(送付address.toRString());
            renbanEucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            renbanEucCsvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            renbanEucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
            renbanEucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
            renbanEucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
        renbanEucCsvEntity.set市町村名(association.get市町村名());
        renbanEucCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        renbanEucCsvEntity.set保険者名(association.getShichosonName_());
        renbanEucCsvEntity.set空白(RString.EMPTY);
        renbanEucCsvEntity.set市町村コード(entity.get市町村コード());
        renbanEucCsvEntity.set被保険者番号(entity.get被保険者番号());
        renbanEucCsvEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get資格取得事由()));
        renbanEucCsvEntity.set資格取得日(set年月日(processParamter, entity.get資格取得日()));
        renbanEucCsvEntity.set資格取得届出日(set年月日(processParamter, entity.get資格取得届出日()));
        renbanEucCsvEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), entity.get喪失事由()));
        renbanEucCsvEntity.set資格喪失日(set年月日(processParamter, entity.get資格喪失日()));
        renbanEucCsvEntity.set資格喪失届日(set年月日(processParamter, entity.get資格喪失届日()));
        renbanEucCsvEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get資格区分()).get名称());
        if (フラグ.equals(entity.get住所地特例状態())) {
            renbanEucCsvEntity.set住所地特例状態(住所地特例);
        } else {
            renbanEucCsvEntity.set住所地特例状態(RString.EMPTY);
        }
        RString lasdecCode;
        if (フラグ.equals(entity.get広域内住所地特例フラグ())) {
            lasdecCode = entity.get広住特措置元市町村コード();
        } else {
            lasdecCode = entity.get市町村コード();
        }
        for (KoseiShichosonMaster master : koseiShichosonJoho) {
            if (master.get市町村コード().value().equals(lasdecCode)) {
                renbanEucCsvEntity.set資格_証記載保険者番号(master.get証記載保険者番号().value());
                break;
            } else {
                renbanEucCsvEntity.set資格_証記載保険者番号(RString.EMPTY);
            }
        }
        renbanEucCsvEntity.set老齢福祉年金開始日(set年月日(processParamter, entity.get老齢福祉年金開始日()));
        renbanEucCsvEntity.set老齢福祉年金終了日(set年月日(processParamter, entity.get老齢福祉年金終了日()));
        renbanEucCsvEntity.set生活保護開始日(set年月日(processParamter, entity.get生活保護開始日()));
        renbanEucCsvEntity.set生活保護終了日(set年月日(processParamter, entity.get生活保護終了日()));
        renbanEucCsvEntity.set生活保護種別(生活保護種別builder.toRString().remove(生活保護種別builder.length() - 1));
        renbanEucCsvEntity.set医療保険種別(getCodeNameByCode(DBACodeShubetsu.医療保険種類.getコード(), entity.get医療保険種別()));
        renbanEucCsvEntity.set医療保険番号(entity.get医療保険番号());
        renbanEucCsvEntity.set医療保険者名(entity.get医療保険者名());
        renbanEucCsvEntity.set医療保険記号番号(entity.get医療保険記号番号());
        return renbanEucCsvEntity;
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @param processParamter processParamter
     * @param kaigoDonyuKeitai 導入形態
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(SeikatsuhogoJukyushaProcessParameter processParamter, List<KaigoDonyuKeitai> kaigoDonyuKeitai) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(抽出条件);
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(日付抽出区分);
        jokenBuilder.append(HizukeChushutsuKubun.toValue(processParamter.getHitsukeChushutsuKubun()).get名称());
        出力条件List.add(jokenBuilder.toRString());
        if (HizukeChushutsuKubun.範囲.getコード().equals(processParamter.getHitsukeChushutsuKubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(範囲抽出日区分);
            jokenBuilder.append(HaniChushutsubiKubun.toValue(processParamter.getChushutsunichiKubun()).get名称());
            出力条件List.add(jokenBuilder.toRString());
        }
        if (HizukeChushutsuKubun.基準日.getコード().equals(processParamter.getHitsukeChushutsuKubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(基準日);
            jokenBuilder.append(set出力条件表の日付(processParamter.getKijunYMD()));
            出力条件List.add(jokenBuilder.toRString());
        }
        if (HizukeChushutsuKubun.範囲.getコード().equals(processParamter.getHitsukeChushutsuKubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(範囲抽出日);
            jokenBuilder.append(set出力条件表の日付(processParamter.getChushutsunichiFrom()));
            jokenBuilder.append(カラ);
            jokenBuilder.append(set出力条件表の日付(processParamter.getChushutsunichiTo()));
            出力条件List.add(jokenBuilder.toRString());
        }
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(生活保護受給者情報);
        if (processParamter.isJukyushaJoho_Nihonjin()) {
            jokenBuilder.append(日本人);
        }
        if (processParamter.isJukyushaJoho_Gaikokujin()) {
            jokenBuilder.append(コンマ);
            jokenBuilder.append(外国人);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(生活保護);
        for (RString 生保 : processParamter.getFujoShurui()) {
            jokenBuilder.append(new FujoShuruiCodeValue(生保).getRyakusho());
            jokenBuilder.append(コンマ);
        }
        if (!RString.isNullOrEmpty(jokenBuilder.toRString())) {
            jokenBuilder.deleteCharAt(jokenBuilder.length() - 1);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(processParamter.getPsmChushutsu_Kubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(年齢);
            jokenBuilder.append(processParamter.getPsmChushutsuAge_Start());
            jokenBuilder.append(歳);
            jokenBuilder.append(カラ);
            jokenBuilder.append(processParamter.getPsmChushutsuAge_End());
            jokenBuilder.append(歳);
            jokenBuilder.append(年齢基準日);
            jokenBuilder.append(set出力条件表の日付(processParamter.getPsmAgeKijunni().toDateString()));
            jokenBuilder.append(右パーレン);
            出力条件List.add(jokenBuilder.toRString());
        }
        if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(processParamter.getPsmChushutsu_Kubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(生年月日);
            jokenBuilder.append(set出力条件表の日付(processParamter.getPsmSeinengappiYMD_Start().toDateString()));
            jokenBuilder.append(カラ);
            jokenBuilder.append(set出力条件表の日付(processParamter.getPsmSeinengappiYMD_End().toDateString()));
            出力条件List.add(jokenBuilder.toRString());
        }
        if (!Chiku.全て.getコード().equals(processParamter.getPsmChiku_Kubun())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(地区区分);
            if (Chiku.住所.getコード().equals(processParamter.getPsmChiku_Kubun())) {
                jokenBuilder.append(processParamter.getPsmJusho_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmJusho_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParamter.getPsmJusho_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmJusho_To_Name());
            } else if (Chiku.行政区.getコード().equals(processParamter.getPsmChiku_Kubun())) {
                jokenBuilder.append(processParamter.getPsmGyoseiku_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmGyoseiku_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParamter.getPsmGyoseiku_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmGyoseiku_To_Name());
            } else if (Chiku.地区.getコード().equals(processParamter.getPsmChiku_Kubun())) {
                jokenBuilder.append(processParamter.getPsmChiku1_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmChiku1_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParamter.getPsmChiku1_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmChiku1_To_Name());
                jokenBuilder.append(コンマ);
                jokenBuilder.append(processParamter.getPsmChiku2_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmChiku2_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParamter.getPsmChiku2_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmChiku2_To_Name());
                jokenBuilder.append(コンマ);
                jokenBuilder.append(processParamter.getPsmChiku3_From());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmChiku3_From_Name());
                jokenBuilder.append(カラ);
                jokenBuilder.append(processParamter.getPsmChiku3_To());
                jokenBuilder.append(RString.HALF_SPACE);
                jokenBuilder.append(processParamter.getPsmChiku3_To_Name());
            }
            出力条件List.add(jokenBuilder.toRString());
        }
        if (kaigoDonyuKeitai.get(0).get導入形態コード().is広域()) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("保険者："));
            jokenBuilder.append(processParamter.getShichoson_Code());
            jokenBuilder.append(RString.HALF_SPACE);
            jokenBuilder.append(processParamter.getShichoson_Name());
            出力条件List.add(jokenBuilder.toRString());
        }
        return 出力条件List;
    }

    private RString set出力条件表の日付(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set年月日(SeikatsuhogoJukyushaProcessParameter processParamter, FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (processParamter.isHitsukeHenshu()) {
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
                new FlexibleDate(RDate.getNowDate().toDateString()));
    }
}
