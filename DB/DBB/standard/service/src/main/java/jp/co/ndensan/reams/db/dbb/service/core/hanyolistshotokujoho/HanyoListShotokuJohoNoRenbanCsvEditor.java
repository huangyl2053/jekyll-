/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hanyolistshotokujoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistshotokujoho.HanyoListShotokuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho.HanyoListShotokuJohoNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.GekihenkanwaSochi;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報NoRenCsvEditorのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
public class HanyoListShotokuJohoNoRenbanCsvEditor {

    private static final RString 特例状態住特 = new RString("住特");
    private static final RString FLAG = new RString("1");
    private static final RString 定数対象外 = new RString("対象外");
    private static final int 定数_ZERO = 0;

    /**
     * editor
     *
     * @param entity HanyoListShotokuJohoEntity
     * @param parameter HanyoListShotokuJohoProcessParameter
     * @param 保険料段階リスト HokenryoDankaiList
     * @param 構成市町村マスタlist List<KoseiShichosonMaster>
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @return HanyoListShotokuJohoNoRenbanCsvEntity
     */
    public HanyoListShotokuJohoNoRenbanCsvEntity editor(HanyoListShotokuJohoEntity entity,
            HanyoListShotokuJohoProcessParameter parameter, HokenryoDankaiList 保険料段階リスト,
            List<KoseiShichosonMaster> 構成市町村マスタlist, ChohyoSeigyoKyotsu 帳票制御共通) {
        HanyoListShotokuJohoNoRenbanCsvEntity csvEntity = new HanyoListShotokuJohoNoRenbanCsvEntity();
        editor宛名(csvEntity, entity, parameter);
        editor地区(csvEntity, entity, 帳票制御共通);
        editor前住所(csvEntity, entity, parameter);
        editor宛先(csvEntity, entity);
        editor資格(csvEntity, entity, parameter);
        editor資格Two(csvEntity, entity, parameter, 保険料段階リスト, 構成市町村マスタlist);
        return csvEntity;
    }

    private void editor宛名(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity, HanyoListShotokuJohoEntity entity,
            HanyoListShotokuJohoProcessParameter parameter) {
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        ShikibetsuCode shikibetsuCode = entity.get宛名Entity().getShikibetsuCode();
        if (shikibetsuCode != null) {
            csvEntity.set識別コード(shikibetsuCode.getColumnValue());
        } else {
            csvEntity.set識別コード(RString.EMPTY);
        }
        RString 住民種別 = 宛名.get住民状態().住民状態略称();
        csvEntity.set住民種別(isNull(住民種別) ? RString.EMPTY : 住民種別);
        AtenaMeisho atenaMeisho = entity.get宛名Entity().getKanjiShimei();
        if (atenaMeisho != null) {
            csvEntity.set氏名(atenaMeisho.getColumnValue());
        } else {
            csvEntity.set氏名(RString.EMPTY);
        }
        AtenaKanaMeisho atenaKanaMeisho = entity.get宛名Entity().getKanaShimei();
        if (atenaKanaMeisho != null) {
            csvEntity.set氏名カナ(atenaKanaMeisho.getColumnValue());
        } else {
            csvEntity.set氏名カナ(RString.EMPTY);
        }
        csvEntity.set生年月日(dataToRString(entity.get宛名Entity().getSeinengappiYMD(), parameter));
        AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(),
                宛名.get消除異動年月日());
        csvEntity.set年齢(ageCalculator.get年齢());
        if (宛名.get性別() != null) {
            csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
        }
        TsuzukigaraCode tsuzukigaraCode = entity.get宛名Entity().getTsuzukigaraCode();
        if (tsuzukigaraCode != null) {
            csvEntity.set続柄コード(tsuzukigaraCode.getColumnValue());
        } else {
            csvEntity.set続柄コード(RString.EMPTY);
        }
        SetaiCode setaiCode = entity.get宛名Entity().getSetaiCode();
        if (setaiCode != null) {
            csvEntity.set世帯コード(setaiCode.getColumnValue());
        } else {
            csvEntity.set世帯コード(RString.EMPTY);
        }
        AtenaMeisho atenaMeisho1 = entity.get宛名Entity().getSetainushiMei();
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
        YubinNo yubinNo = entity.get宛名Entity().getYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            csvEntity.set郵便番号(yubinNo.getEditedYubinNo());
        } else {
            csvEntity.set郵便番号(RString.EMPTY);
        }
    }

    private void editor地区(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity,
            HanyoListShotokuJohoEntity entity, ChohyoSeigyoKyotsu 帳票制御共通) {
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(entity.get市町村コード(),
                FlexibleDate.getNowDate());
        RString 住所番地方書 = JushoHenshu.editJusho(帳票制御共通, 宛名, 地方公共団体);
        csvEntity.set住所番地方書(住所番地方書);
        AtenaJusho atenaJusho = entity.get宛名Entity().getJusho();
        AtenaBanchi atenaBanchi = entity.get宛名Entity().getBanchi();
        Katagaki katagaki = entity.get宛名Entity().getKatagaki();
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
        GyoseikuCode gyoseikuCode = entity.get宛名Entity().getGyoseikuCode();
        if (gyoseikuCode != null) {
            csvEntity.set行政区コード(gyoseikuCode.value());
        } else {
            csvEntity.set行政区コード(RString.EMPTY);
        }
        csvEntity.set行政区名(isNull(entity.get宛名Entity().getGyoseikuName())
                ? RString.EMPTY : entity.get宛名Entity().getGyoseikuName());
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
        TelNo telNo = entity.get宛名Entity().getRenrakusaki1();
        if (telNo != null) {
            csvEntity.set連絡先１(telNo.value());
        } else {
            csvEntity.set連絡先１(RString.EMPTY);
        }
        TelNo telNo2 = entity.get宛名Entity().getRenrakusaki2();
        if (telNo2 != null) {
            csvEntity.set連絡先２(telNo2.value());
        } else {
            csvEntity.set連絡先２(RString.EMPTY);
        }
    }

    private void editor前住所(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity,
            HanyoListShotokuJohoEntity entity, HanyoListShotokuJohoProcessParameter parameter) {

        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        IIdoJiyu 登録事由 = 宛名.get登録事由();
        IIdoJiyu 住定事由 = 宛名.get住定事由();
        IIdoJiyu 消除事由 = 宛名.get消除事由();
        csvEntity.set登録異動日(dataToRString(entity.get宛名Entity().getTorokuIdoYMD(), parameter));
        csvEntity.set登録事由(登録事由 != null ? 登録事由.get異動事由コード() : RString.EMPTY);
        csvEntity.set登録届出日(dataToRString(entity.get宛名Entity().getTorokuTodokedeYMD(), parameter));
        csvEntity.set住定異動日(dataToRString(entity.get宛名Entity().getJuteiIdoYMD(), parameter));
        csvEntity.set住定事由(住定事由 != null ? 住定事由.get異動事由コード() : RString.EMPTY);
        csvEntity.set住定届出日(dataToRString(entity.get宛名Entity().getJuteiTodokedeYMD(), parameter));
        csvEntity.set消除異動日(dataToRString(entity.get宛名Entity().getShojoIdoYMD(), parameter));
        csvEntity.set消除事由(登録事由 != null ? 消除事由.get異動事由コード() : RString.EMPTY);
        csvEntity.set消除届出日(dataToRString(entity.get宛名Entity().getShojoTodokedeYMD(), parameter));
        csvEntity.set転出入理由(RString.EMPTY);
        YubinNo yubinNo = entity.get宛名Entity().getTennyumaeYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            csvEntity.set前住所郵便番号(yubinNo.getEditedYubinNo());
        } else {
            csvEntity.set前住所郵便番号(RString.EMPTY);
        }
        AtenaJusho atenaJusho1 = entity.get宛名Entity().getTennyumaeJusho();
        AtenaBanchi atenaBanchi1 = entity.get宛名Entity().getTennyumaeBanchi();
        Katagaki katagaki1 = entity.get宛名Entity().getTennyumaeKatagaki();
        StringBuilder stringBuilder1 = new StringBuilder();
        if (atenaJusho1 != null) {
            stringBuilder1.append(atenaJusho1.value());
        }
        if (atenaBanchi1 != null) {
            stringBuilder1.append(atenaBanchi1.value());
        }
        if (stringBuilder1.length() > 0) {
            stringBuilder1.append(RString.FULL_SPACE);
        }
        if (katagaki1 != null) {
            stringBuilder1.append(katagaki1.value());
        }
        if (stringBuilder1.length() > 0) {
            csvEntity.set前住所番地方書(new RString(stringBuilder1.toString()));
        } else {
            csvEntity.set前住所番地方書(RString.EMPTY);
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

    private void editor宛先(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity,
            HanyoListShotokuJohoEntity entity) {
        csvEntity.set市町村コード(isNull(entity.get市町村コード())
                ? RString.EMPTY : entity.get市町村コード().value());
        if (entity.get市町村コード() != null) {
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(entity.get市町村コード(),
                    FlexibleDate.getNowDate());
            csvEntity.set市町村名(地方公共団体.get市町村名());
        } else {
            csvEntity.set市町村名(RString.EMPTY);
        }
        AtenaMeisho atenaMeisho2 = entity.get宛先Entity().getKanjiShimei();
        if (atenaMeisho2 != null) {
            csvEntity.set送付先氏名(atenaMeisho2.value());
        } else {
            csvEntity.set送付先氏名(RString.EMPTY);
        }
        AtenaKanaMeisho atenaKanaMeisho1 = entity.get宛先Entity().getKanaShimei();
        if (atenaKanaMeisho1 != null) {
            csvEntity.set送付先氏名カナ(atenaKanaMeisho1.value());
        } else {
            csvEntity.set送付先氏名カナ(RString.EMPTY);
        }
        ZenkokuJushoCode zenkokuJushoCode1 = entity.get宛先Entity().getZenkokuJushoCode();
        if (zenkokuJushoCode1 != null) {
            csvEntity.set送付先住所コード(zenkokuJushoCode1.getColumnValue());
        } else {
            csvEntity.set送付先住所コード(RString.EMPTY);
        }
        YubinNo yubinNo = entity.get宛先Entity().getYubinNo();
        if (yubinNo != null && !yubinNo.isEmpty()) {
            csvEntity.set送付先郵便番号(yubinNo.getEditedYubinNo());
        } else {
            csvEntity.set送付先郵便番号(RString.EMPTY);
        }
        AtenaJusho atenaJusho2 = entity.get宛先Entity().getJusho();
        AtenaBanchi atenaBanchi2 = entity.get宛先Entity().getBanchi();
        Katagaki katagaki2 = entity.get宛先Entity().getKatagaki();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (atenaJusho2 != null) {
            stringBuilder2.append(atenaJusho2.getColumnValue());
        }
        if (atenaBanchi2 != null) {
            stringBuilder2.append(atenaBanchi2.getColumnValue());
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.append(RString.FULL_SPACE);
        }
        if (katagaki2 != null) {
            stringBuilder2.append(katagaki2.getColumnValue());
        }
        if (stringBuilder2.length() > 0) {
            csvEntity.set送付先住所番地方書(new RString(stringBuilder2.toString()));
        } else {
            csvEntity.set送付先住所番地方書(RString.EMPTY);
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
        GyoseikuCode gyoseikuCode1 = entity.get宛先Entity().getGyoseikuCode();
        if (gyoseikuCode1 != null) {
            csvEntity.set送付先行政区コード(gyoseikuCode1.value());
        } else {
            csvEntity.set送付先行政区コード(RString.EMPTY);
        }
    }

    private void editor資格(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity,
            HanyoListShotokuJohoEntity entity, HanyoListShotokuJohoProcessParameter parameter) {
        csvEntity.set送付先行政区名(isNull(entity.get宛先Entity().getGyoseiku())
                ? RString.EMPTY : entity.get宛名Entity().getGyoseikuName());
        csvEntity.set被保険者番号(isNull(entity.getDbv1001被保険者番号())
                ? RString.EMPTY : entity.getDbv1001被保険者番号().value());
        RString 資格取得事由 = RString.EMPTY;
        if (entity.get資格取得事由コード() != null && !entity.get資格取得事由コード().isEmpty()) {
            資格取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get資格取得事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set資格取得事由(isNull(資格取得事由)
                ? RString.EMPTY : 資格取得事由);
        csvEntity.set資格取得日(dataToRString(entity.get資格取得年月日(), parameter));
        csvEntity.set資格取得届出日(dataToRString(entity.get資格取得届出年月日(), parameter));
        RString 喪失事由 = RString.EMPTY;
        if (entity.get資格喪失事由コード() != null && !entity.get資格喪失事由コード().isEmpty()) {
            喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get資格喪失事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set喪失事由(isNull(喪失事由)
                ? RString.EMPTY : 喪失事由);
        csvEntity.set資格喪失日(dataToRString(entity.get資格喪失年月日(), parameter));
        csvEntity.set資格喪失届日(dataToRString(entity.get資格喪失届出年月日(), parameter));
        if (!RString.isNullOrEmpty(entity.get被保険者区分コード())) {
            HihokenshaKubunCode hihokenshaKubunCode = HihokenshaKubunCode.toValue(entity.get被保険者区分コード());
            csvEntity.set資格区分(hihokenshaKubunCode.get名称());
        }
        if (FLAG.equals(entity.get住所地特例フラグ())) {
            csvEntity.set住所地特例状態(特例状態住特);
        } else {
            csvEntity.set住所地特例状態(RString.EMPTY);
        }

    }

    private void editor資格Two(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity,
            HanyoListShotokuJohoEntity entity, HanyoListShotokuJohoProcessParameter parameter, HokenryoDankaiList 保険料段階リスト,
            List<KoseiShichosonMaster> 構成市町村マスタlist) {
        if (FLAG.equals(entity.get広域内住所地特例フラグ())) {
            set保険者番号By広住特措置元市町村コード(csvEntity, entity, 構成市町村マスタlist);
        } else {
            set保険者番号By市町村コード(csvEntity, entity, 構成市町村マスタlist);
        }
        if (保険料段階リスト != null && !RString.isNullOrEmpty(entity.get保険料段階())
                && 保険料段階リスト.getBy段階区分(entity.get保険料段階()) != null) {
            csvEntity.set保険料段階(保険料段階リスト.getBy段階区分(entity.get保険料段階()).get表記());
        }
        if (entity.get所得年度() != null) {
            csvEntity.set賦課年度(entity.get所得年度().toDateString());
        }
        KazeiKubun kazeiKubun = KazeiKubun.toValue(entity.get課税区分減免前());
        csvEntity.set課税区分減免前(kazeiKubun.get名称());
        KazeiKubun kazeiKubun1 = KazeiKubun.toValue(entity.get課税区分減免後());
        csvEntity.set課税区分減免後(kazeiKubun1.get名称());
        csvEntity.set合計所得金額(numToRString(entity.get合計所得金額()));
        csvEntity.set公的年金等収入(numToRString(entity.get公的年金収入額()));
        csvEntity.set公的年金等所得(numToRString(entity.get公的年金所得額()));
        if (entity.get処理日時() != null) {
            FlexibleDate 処理日付 = new FlexibleDate(entity.get処理日時().getDate().toDateString());
            csvEntity.set住民税更正日(dataToRString(処理日付, parameter));
        }
        if (GekihenkanwaSochi.対象外.getコード().equals(entity.get激変緩和措置区分())) {
            csvEntity.set激変緩和区分(定数対象外);
        } else {
            csvEntity.set激変緩和区分(RString.EMPTY);
        }
    }

    private void set保険者番号By広住特措置元市町村コード(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity, HanyoListShotokuJohoEntity entity,
            List<KoseiShichosonMaster> 構成市町村マスタlist) {
        if (構成市町村マスタlist.size() > 定数_ZERO && entity.get広住特措置元市町村コード() != null) {
            for (int i = 定数_ZERO; i < 構成市町村マスタlist.size(); i++) {
                if (entity.get広住特措置元市町村コード().equals(構成市町村マスタlist.get(i).get市町村コード())) {
                    csvEntity.set資格証記載保険者番号(構成市町村マスタlist.get(i).get証記載保険者番号().getColumnValue());
                }
            }
        }
    }

    private void set保険者番号By市町村コード(HanyoListShotokuJohoNoRenbanCsvEntity csvEntity, HanyoListShotokuJohoEntity entity,
            List<KoseiShichosonMaster> 構成市町村マスタlist) {
        if (構成市町村マスタlist.size() > 定数_ZERO && entity.get市町村コード() != null) {
            for (int i = 定数_ZERO; i < 構成市町村マスタlist.size(); i++) {
                if (entity.get市町村コード().equals(構成市町村マスタlist.get(i).get市町村コード())) {
                    csvEntity.set資格証記載保険者番号(構成市町村マスタlist.get(i).get証記載保険者番号().getColumnValue());
                }
            }
        }
    }

    private RString numToRString(Decimal 数字) {
        if (数字 == null) {
            return RString.EMPTY;
        }
        return new RString(数字.toString());
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private RString dataToRString(FlexibleDate 日付, HanyoListShotokuJohoProcessParameter parameter) {
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
