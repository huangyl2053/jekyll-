/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_MoshitateshaKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitate.SaishinsamoshitateProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitate.SaishinsaMoshitateRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.saishinsamoshitate.HanyoListSaishinsaMoshitateAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.saishinsamoshitate.HanyoListSaishinsaMoshitateNashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト 再審査申立情報ビジネスのクラスです
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
public class SaishinsaMoshitate {

    private static final RString 住特 = new RString("住特");
    private static final RString 初回申請 = new RString("初回申請");
    private static final RString 再申請内 = new RString("再申請内");
    private static final RString 再申請外 = new RString("再申請外");
    private static final RString 支援から申請 = new RString("支援から申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString サ変更申請 = new RString("サ変更申請");
    private static final RString 施行前申請 = new RString("施行前申請");
    private static final RString 追加 = new RString("追加");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 抽出条件 = new RString("【抽出条件】");
    private static final RString 保険者コード_全市町村 = new RString("000000");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 全市町村 = new RString("000000 全市町村");
    private static final RString 国保連送付年月 = new RString("国保連送付年月：");
    private static final RString サービス提供年月 = new RString("サービス提供年月：");
    private static final RString 事業者番号 = new RString("事業者番号：");
    private static final RString みなし = new RString("みなし");

    /**
     * HanyoListSaishinsaMoshitateAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 連番 連番
     * @param processParameter processParameter
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association association
     * @return HanyoListSaishinsaMoshitateAriEUCEntity
     */
    public HanyoListSaishinsaMoshitateAriEUCEntity setRenbanariEUCEntity(SaishinsaMoshitateRelateEntity entity,
            int 連番,
            SaishinsamoshitateProcessParameter processParameter,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association association) {
        HanyoListSaishinsaMoshitateAriEUCEntity eucEntity = new HanyoListSaishinsaMoshitateAriEUCEntity();
        eucEntity.set連番(new RString(String.valueOf(連番)));
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.getPsmEntity();
        if (宛名Entity == null) {
            return eucEntity;
        }
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(宛名Entity).to個人();
        eucEntity.set識別コード(iKojin.get識別コード());
        eucEntity.set住民種別(iKojin.get住民状態().住民状態略称());
        eucEntity.set氏名(iKojin.get名称().getName());
        eucEntity.set氏名カナ(iKojin.get名称().getKana());
        eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate(), processParameter));
        eucEntity.set年齢(iKojin.get年齢算出().get年齢());
        eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
        eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
        eucEntity.set世帯コード(iKojin.get世帯コード());
        eucEntity.set世帯主名(iKojin.get世帯主名());
        eucEntity.set住所コード(iKojin.get住所().get町域コード().value());
        eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
        eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, association));
        eucEntity.set住所(iKojin.get住所().get住所());
        eucEntity.set番地(get番地(iKojin.get住所().get番地()));
        eucEntity.set方書(get方書(iKojin.get住所().get方書()));
        eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
        eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
        eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
        eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
        eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
        eucEntity.set連絡先１(iKojin.get連絡先１());
        eucEntity.set連絡先２(iKojin.get連絡先２());
        eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日(), processParameter));
        eucEntity.set登録事由(iKojin.get登録事由());
        eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日(), processParameter));
        eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日(), processParameter));
        eucEntity.set住定事由(iKojin.get住定事由());
        eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日(), processParameter));
        eucEntity.set消除異動日(set日付編集(iKojin.get消除異動年月日(), processParameter));
        eucEntity.set消除事由(iKojin.get消除事由());
        eucEntity.set消除届出日(set日付編集(iKojin.get消除届出年月日(), processParameter));
        eucEntity.set転出入理由(RString.EMPTY);
        eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号().getEditedYubinNo());
        eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
        eucEntity.set前住所(iKojin.get転入前().get住所());
        eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
        eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(get市町村名(市町村名MasterMap.get(entity.get市町村コード().value())));
        }
        eucEntity.set保険者コード(association.get地方公共団体コード());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(new RString(" "));
        eucEntity.set被保険者番号(nullToEmpty(entity.get被保険者番号()));
        eucEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), entity.get資格取得事由コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日(), processParameter));
        eucEntity.set資格取得届出日(set日付編集(entity.get資格取得届出年月日(), processParameter));
        eucEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), entity.get資格喪失事由コード()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日(), processParameter));
        eucEntity.set資格喪失届日(set日付編集(entity.get資格喪失届出年月日(), processParameter));
        eucEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        if (entity.is住所地特例フラグ()) {
            eucEntity.set住所地特例状態(住特);
        }
        eucEntity.set資格_証記載保険者番号(get証記載保険者番号(entity, 市町村名MasterMap));
        eucEntity.set再審査事業者番号(nullToEmpty(entity.get事業所番号()));
        eucEntity.set再審査事業者名(nullToEmpty(entity.get事業者名称()));
        eucEntity.setサービス提供年月(getサービス日付(entity.getサービス提供年月(), processParameter));
        eucEntity.setサービス種類(nullToEmpty(entity.getサービス種類コード()));
        eucEntity.setサービス種類名(entity.getサービス種類名());
        eucEntity.setサービス項目(nullToEmpty(entity.getサービス項目コード()));
        eucEntity.set給付_証記載保険者番号(nullToEmpty(entity.get証記載保険者番号()));
        eucEntity.set申立年月日(set日付編集(entity.get申立年月日(), processParameter));
        eucEntity.set申立者区分(KagoMoshitate_MoshitateshaKubun.toValue(entity.get申立者区分コード()).get名称());
        eucEntity.set申立単位数(new RString(String.valueOf(entity.get申立単位数())));
        eucEntity.set申立事由コード(entity.get申立事由コード());
        eucEntity.set申立事由(getCodeByCode(DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード(), entity.get申立事由コード()));
        eucEntity.set国保連送付年月(getサービス日付(entity.get国保連送付年月(), processParameter));
        RString 申請事由 = nullToEmpty(entity.get受給申請事由());
        eucEntity.set受給申請事由(set受給申請事由(申請事由, entity));
        eucEntity.set受給申請日(set日付編集(entity.get受給申請年月日(), processParameter));
        if (entity.get要介護認定状態区分コード() != null && !entity.get要介護認定状態区分コード().isEmpty()) {
            eucEntity.set受給要介護度(YokaigoJotaiKubun.toValue(entity.get要介護認定状態区分コード().value()).get名称());
        } else {
            eucEntity.set受給要介護度(RString.EMPTY);
        }
        eucEntity.set受給認定開始日(set日付編集(entity.get認定有効期間開始年月日(), processParameter));
        eucEntity.set受給認定終了日(set日付編集(entity.get認定有効期間終了年月日(), processParameter));
        eucEntity.set受給認定日(set日付編集(entity.get認定年月日(), processParameter));
        if (entity.is旧措置者フラグ()) {
            eucEntity.set受給旧措置(旧措置者);
        }
        RString 要介護区分 = nullToEmpty(entity.getみなし要介護区分コード());
        eucEntity.set受給みなし更新認定(set受給みなし更新認定(要介護区分));
        RString 受給直近事由 = nullToEmpty(entity.get直近異動事由コード());
        if (!受給直近事由.isNullOrEmpty()) {
            eucEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(受給直近事由).get名称());
        }
        return eucEntity;
    }

    /**
     * HanyoListSaishinsaMoshitateNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param processParameter processParameter
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association association
     * @return HanyoListSaishinsaMoshitateNashiEUCEntity
     */
    public HanyoListSaishinsaMoshitateNashiEUCEntity setRenbanashiEUCEntity(SaishinsaMoshitateRelateEntity entity,
            SaishinsamoshitateProcessParameter processParameter,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association association) {
        HanyoListSaishinsaMoshitateNashiEUCEntity eucEntity = new HanyoListSaishinsaMoshitateNashiEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.getPsmEntity();
        if (宛名Entity == null) {
            return eucEntity;
        }
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(宛名Entity).to個人();
        eucEntity.set識別コード(iKojin.get識別コード());
        eucEntity.set住民種別(iKojin.get住民状態().住民状態略称());
        eucEntity.set氏名(iKojin.get名称().getName());
        eucEntity.set氏名カナ(iKojin.get名称().getKana());
        eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate(), processParameter));
        eucEntity.set年齢(iKojin.get年齢算出().get年齢());
        eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
        eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
        eucEntity.set世帯コード(iKojin.get世帯コード());
        eucEntity.set世帯主名(iKojin.get世帯主名());
        eucEntity.set住所コード(iKojin.get住所().get町域コード().value());
        eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
        eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, association));
        eucEntity.set住所(iKojin.get住所().get住所());
        eucEntity.set番地(get番地(iKojin.get住所().get番地()));
        eucEntity.set方書(get方書(iKojin.get住所().get方書()));
        eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
        eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
        eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
        eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
        eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
        eucEntity.set連絡先１(iKojin.get連絡先１());
        eucEntity.set連絡先２(iKojin.get連絡先２());
        eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日(), processParameter));
        eucEntity.set登録事由(iKojin.get登録事由());
        eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日(), processParameter));
        eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日(), processParameter));
        eucEntity.set住定事由(iKojin.get住定事由());
        eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日(), processParameter));
        eucEntity.set消除異動日(set日付編集(iKojin.get消除異動年月日(), processParameter));
        eucEntity.set消除事由(iKojin.get消除事由());
        eucEntity.set消除届出日(set日付編集(iKojin.get消除届出年月日(), processParameter));
        eucEntity.set転出入理由(RString.EMPTY);
        eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号().getEditedYubinNo());
        eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
        eucEntity.set前住所(iKojin.get転入前().get住所());
        eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
        eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(get市町村名(市町村名MasterMap.get(entity.get市町村コード().value())));
        }
        eucEntity.set保険者コード(association.get地方公共団体コード());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(new RString(" "));
        eucEntity.set被保険者番号(nullToEmpty(entity.get被保険者番号()));
        eucEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), entity.get資格取得事由コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日(), processParameter));
        eucEntity.set資格取得届出日(set日付編集(entity.get資格取得届出年月日(), processParameter));
        eucEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), entity.get資格喪失事由コード()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日(), processParameter));
        eucEntity.set資格喪失届日(set日付編集(entity.get資格喪失届出年月日(), processParameter));
        eucEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        if (entity.is住所地特例フラグ()) {
            eucEntity.set住所地特例状態(住特);
        }
        eucEntity.set資格_証記載保険者番号(get証記載保険者番号(entity, 市町村名MasterMap));
        eucEntity.set再審査事業者番号(nullToEmpty(entity.get事業所番号()));
        eucEntity.set再審査事業者名(nullToEmpty(entity.get事業者名称()));
        eucEntity.setサービス提供年月(getサービス日付(entity.getサービス提供年月(), processParameter));
        eucEntity.setサービス種類(nullToEmpty(entity.getサービス種類コード()));
        eucEntity.setサービス種類名(entity.getサービス種類名());
        eucEntity.setサービス項目(nullToEmpty(entity.getサービス項目コード()));
        eucEntity.set給付_証記載保険者番号(nullToEmpty(entity.get証記載保険者番号()));
        eucEntity.set申立年月日(set日付編集(entity.get申立年月日(), processParameter));
        eucEntity.set申立者区分(KagoMoshitate_MoshitateshaKubun.toValue(entity.get申立者区分コード()).get名称());
        eucEntity.set申立単位数(new RString(String.valueOf(entity.get申立単位数())));
        eucEntity.set申立事由コード(entity.get申立事由コード());
        eucEntity.set申立事由(getCodeByCode(DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード(), entity.get申立事由コード()));
        eucEntity.set国保連送付年月(getサービス日付(entity.get国保連送付年月(), processParameter));
        RString 申請事由 = nullToEmpty(entity.get受給申請事由());
        eucEntity.set受給申請事由(set受給申請事由(申請事由, entity));
        eucEntity.set受給申請日(set日付編集(entity.get受給申請年月日(), processParameter));
        if (entity.get要介護認定状態区分コード() != null && !entity.get要介護認定状態区分コード().isEmpty()) {
            eucEntity.set受給要介護度(YokaigoJotaiKubun.toValue(entity.get要介護認定状態区分コード().value()).get名称());
        } else {
            eucEntity.set受給要介護度(RString.EMPTY);
        }
        eucEntity.set受給認定開始日(set日付編集(entity.get認定有効期間開始年月日(), processParameter));
        eucEntity.set受給認定終了日(set日付編集(entity.get認定有効期間終了年月日(), processParameter));
        eucEntity.set受給認定日(set日付編集(entity.get認定年月日(), processParameter));
        if (entity.is旧措置者フラグ()) {
            eucEntity.set受給旧措置(旧措置者);
        }
        RString 要介護区分 = nullToEmpty(entity.getみなし要介護区分コード());
        eucEntity.set受給みなし更新認定(set受給みなし更新認定(要介護区分));
        RString 受給直近事由 = nullToEmpty(entity.get直近異動事由コード());
        if (!受給直近事由.isNullOrEmpty()) {
            eucEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(受給直近事由).get名称());
        }
        return eucEntity;
    }

    /**
     * 出力条件の編集です。
     *
     * @param processParameter processParameter
     * @return List<RString>
     */
    public List<RString> set出力条件(SaishinsamoshitateProcessParameter processParameter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(抽出条件);
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        if (RString.isNullOrEmpty(processParameter.getHokenshacode().value())) {
            jokenBuilder.append(RString.EMPTY);
        } else if (保険者コード_全市町村.equals(processParameter.getHokenshacode().value())) {
            jokenBuilder.append(保険者);
            jokenBuilder.append(全市町村);
        } else {
            jokenBuilder.append(保険者);
            RStringBuilder 市町村名builder = new RStringBuilder();
            市町村名builder.append(processParameter.getHokenshacode().value());
            市町村名builder.append(RString.HALF_SPACE);
            市町村名builder.append(processParameter.getHokenshamei());
            jokenBuilder.append(市町村名builder.toRString());
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(RString.EMPTY);
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(国保連送付年月);
        出力条件List.add(get期間(jokenBuilder, processParameter.getKokuhorensouhunengetsufrom(), processParameter.getKokuhorensouhunengetsuto()));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(サービス提供年月);
        出力条件List.add(get期間(jokenBuilder, processParameter.getSeverteikyounengetsufrom(), processParameter.getSeverteikyounengetsuto()));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(事業者番号);
        jokenBuilder.append(processParameter.getJigyoushabangou());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    /**
     * HanyoListSaishinsaMoshitateAriEUCEntityの設定クラスです。
     *
     * @return HanyoListSaishinsaMoshitateAriEUCEntity
     */
    public HanyoListSaishinsaMoshitateAriEUCEntity setRenbanariEUCEntity() {
        HanyoListSaishinsaMoshitateAriEUCEntity eucEntity = new HanyoListSaishinsaMoshitateAriEUCEntity();
        eucEntity.set連番(null);
        eucEntity.set識別コード(null);
        eucEntity.set住民種別(null);
        eucEntity.set氏名(null);
        eucEntity.set氏名カナ(null);
        eucEntity.set生年月日(null);
        eucEntity.set年齢(null);
        eucEntity.set性別(null);
        eucEntity.set続柄コード(null);
        eucEntity.set世帯コード(null);
        eucEntity.set世帯主名(null);
        eucEntity.set住所コード(null);
        eucEntity.set郵便番号(null);
        eucEntity.set住所_番地_方書(null);
        eucEntity.set住所(null);
        eucEntity.set番地(null);
        eucEntity.set方書(null);
        eucEntity.set行政区コード(null);
        eucEntity.set行政区名(null);
        eucEntity.set地区１(null);
        eucEntity.set地区２(null);
        eucEntity.set地区３(null);
        eucEntity.set連絡先１(null);
        eucEntity.set連絡先２(null);
        eucEntity.set登録異動日(null);
        eucEntity.set登録事由(null);
        eucEntity.set登録届出日(null);
        eucEntity.set住定異動日(null);
        eucEntity.set住定事由(null);
        eucEntity.set住定届出日(null);
        eucEntity.set消除異動日(null);
        eucEntity.set消除事由(null);
        eucEntity.set消除届出日(null);
        eucEntity.set転出入理由(null);
        eucEntity.set前住所郵便番号(null);
        eucEntity.set前住所_番地_方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set資格取得事由(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格取得届出日(null);
        eucEntity.set喪失事由(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set資格喪失届日(null);
        eucEntity.set資格区分(null);
        eucEntity.set住所地特例状態(null);
        eucEntity.set資格_証記載保険者番号(null);
        eucEntity.set再審査事業者番号(null);
        eucEntity.set再審査事業者名(null);
        eucEntity.setサービス提供年月(null);
        eucEntity.setサービス種類(null);
        eucEntity.setサービス種類名(null);
        eucEntity.setサービス項目(null);
        eucEntity.set給付_証記載保険者番号(null);
        eucEntity.set申立年月日(null);
        eucEntity.set申立者区分(null);
        eucEntity.set申立単位数(null);
        eucEntity.set申立事由コード(null);
        eucEntity.set申立事由(null);
        eucEntity.set国保連送付年月(null);
        eucEntity.set受給申請事由(null);
        eucEntity.set受給申請日(null);
        eucEntity.set受給要介護度(null);
        eucEntity.set受給認定開始日(null);
        eucEntity.set受給認定終了日(null);
        eucEntity.set受給認定日(null);
        eucEntity.set受給旧措置(null);
        eucEntity.set受給みなし更新認定(null);
        eucEntity.set受給直近事由(null);
        return eucEntity;
    }

    /**
     * HanyoListSaishinsaMoshitateNashiEUCEntityの設定クラスです。
     *
     * @return HanyoListSaishinsaMoshitateNashiEUCEntity
     */
    public HanyoListSaishinsaMoshitateNashiEUCEntity setRenbanashiEUCEntity() {
        HanyoListSaishinsaMoshitateNashiEUCEntity eucEntity = new HanyoListSaishinsaMoshitateNashiEUCEntity();
        eucEntity.set識別コード(null);
        eucEntity.set住民種別(null);
        eucEntity.set氏名(null);
        eucEntity.set氏名カナ(null);
        eucEntity.set生年月日(null);
        eucEntity.set年齢(null);
        eucEntity.set性別(null);
        eucEntity.set続柄コード(null);
        eucEntity.set世帯コード(null);
        eucEntity.set世帯主名(null);
        eucEntity.set住所コード(null);
        eucEntity.set郵便番号(null);
        eucEntity.set住所_番地_方書(null);
        eucEntity.set住所(null);
        eucEntity.set番地(null);
        eucEntity.set方書(null);
        eucEntity.set行政区コード(null);
        eucEntity.set行政区名(null);
        eucEntity.set地区１(null);
        eucEntity.set地区２(null);
        eucEntity.set地区３(null);
        eucEntity.set連絡先１(null);
        eucEntity.set連絡先２(null);
        eucEntity.set登録異動日(null);
        eucEntity.set登録事由(null);
        eucEntity.set登録届出日(null);
        eucEntity.set住定異動日(null);
        eucEntity.set住定事由(null);
        eucEntity.set住定届出日(null);
        eucEntity.set消除異動日(null);
        eucEntity.set消除事由(null);
        eucEntity.set消除届出日(null);
        eucEntity.set転出入理由(null);
        eucEntity.set前住所郵便番号(null);
        eucEntity.set前住所_番地_方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set資格取得事由(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格取得届出日(null);
        eucEntity.set喪失事由(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set資格喪失届日(null);
        eucEntity.set資格区分(null);
        eucEntity.set住所地特例状態(null);
        eucEntity.set資格_証記載保険者番号(null);
        eucEntity.set再審査事業者番号(null);
        eucEntity.set再審査事業者名(null);
        eucEntity.setサービス提供年月(null);
        eucEntity.setサービス種類(null);
        eucEntity.setサービス種類名(null);
        eucEntity.setサービス項目(null);
        eucEntity.set給付_証記載保険者番号(null);
        eucEntity.set申立年月日(null);
        eucEntity.set申立者区分(null);
        eucEntity.set申立単位数(null);
        eucEntity.set申立事由コード(null);
        eucEntity.set申立事由(null);
        eucEntity.set国保連送付年月(null);
        eucEntity.set受給申請事由(null);
        eucEntity.set受給申請日(null);
        eucEntity.set受給要介護度(null);
        eucEntity.set受給認定開始日(null);
        eucEntity.set受給認定終了日(null);
        eucEntity.set受給認定日(null);
        eucEntity.set受給旧措置(null);
        eucEntity.set受給みなし更新認定(null);
        eucEntity.set受給直近事由(null);
        return eucEntity;
    }

    private RString set受給申請事由(RString 申請事由, SaishinsaMoshitateRelateEntity entity) {
        RString 受給申請事由;
        if (申請事由.isNullOrEmpty()) {
            return RString.EMPTY;
        }
        try {
            JukyuShinseiJiyu.toValue(申請事由);
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        受給申請事由 = JukyuShinseiJiyu.toValue(申請事由).getコード();
        if (受給申請事由.equals(JukyuShinseiJiyu.初回申請.getコード())) {
            return 初回申請;
        } else if (受給申請事由.equals(JukyuShinseiJiyu.再申請_有効期限内.getコード())) {
            return 再申請内;
        } else if (受給申請事由.equals(JukyuShinseiJiyu.再申請_有効期限外.getコード())) {
            return 再申請外;
        } else if (受給申請事由.equals(JukyuShinseiJiyu.要介護度変更申請.getコード())) {
            if (entity.is要支援者認定申請区分()) {
                return 支援から申請;
            } else {
                return 区分変更申請;
            }
        } else if (受給申請事由.equals(JukyuShinseiJiyu.指定サービス種類変更申請.getコード())) {
            return サ変更申請;
        } else if (受給申請事由.equals(JukyuShinseiJiyu.申請_法施行前.getコード())) {
            return 施行前申請;
        } else if (受給申請事由.equals(JukyuShinseiJiyu.追加_申請なしの追加.getコード())) {
            return 追加;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set受給みなし更新認定(RString みなし要介護区分コード) {
        RString 受給みなし更新認定 = RString.EMPTY;
        List minashiCodeList = new ArrayList();
        for (MinashiCode minashiCode : MinashiCode.values()) {
            minashiCodeList.add(minashiCode.getコード());
        }
        if (minashiCodeList.contains(みなし要介護区分コード) && !MinashiCode.通常の認定.getコード().equals(みなし要介護区分コード)) {
            受給みなし更新認定 = みなし;
        }
        return 受給みなし更新認定;
    }

    private RString get市町村名(KoseiShichosonMaster koseiShichosonMaster) {
        if (koseiShichosonMaster != null) {
            return koseiShichosonMaster.get市町村名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString get期間(RStringBuilder jokenBuilder, RString fromYMD, RString toYMD) {
        if (!RString.isNullOrEmpty(fromYMD)) {
            jokenBuilder.append(new FlexibleDate(fromYMD).wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).getYearMonth());
        }
        jokenBuilder.append(new RString("　～　"));
        if (!RString.isNullOrEmpty(toYMD)) {
            jokenBuilder.append(new FlexibleDate(toYMD).wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).getYearMonth());
        }
        return jokenBuilder.toRString();
    }

    private RString getCodeByCode(CodeShubetsu codeShubetsu, RString code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBC介護給付,
                codeShubetsu,
                new Code(code),
                FlexibleDate.getNowDate());
    }

    private RString getサービス日付(FlexibleYearMonth value, SaishinsamoshitateProcessParameter processParameter) {
        RString 日付 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            if (processParameter.isHitsukeHenshu()) {
                日付 = value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            } else {
                日付 = new RString(value.toString());
            }
        }
        return 日付;
    }

    private RString get証記載保険者番号(SaishinsaMoshitateRelateEntity entity, Map<RString, KoseiShichosonMaster> 市町村名MasterMap) {
        RString 証記載保険者番号 = null;
        if (entity.is広域内住所地特例フラグ() && 市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            if (!isNullCheck(entity.get広住特措置元市町村コード())) {
                証記載保険者番号 = get保険者番号(市町村名MasterMap.get(entity.get広住特措置元市町村コード()));
            }
        } else if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty() && entity.get市町村コード() != null && !entity.get市町村コード().isEmpty()) {
            証記載保険者番号 = get保険者番号(市町村名MasterMap.get(entity.get市町村コード().value()));
        }
        return 証記載保険者番号;
    }

    private RString get保険者番号(KoseiShichosonMaster koseiShichosonMaster) {
        if (koseiShichosonMaster != null) {
            return koseiShichosonMaster.get証記載保険者番号().value();
        } else {
            return RString.EMPTY;
        }
    }

    private boolean isNullCheck(RString value) {
        return RString.isNullOrEmpty(value);
    }

    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBA介護資格,
                codeShubetsu,
                new Code(code),
                FlexibleDate.getNowDate());
    }

    private RString get住所_番地_方書(RString 住所, RString 番地, RString 方書) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(住所);
        builder.append(番地);
        builder.append(new RString("　"));
        builder.append(方書);
        return builder.toRString();
    }

    private RString set日付編集(FlexibleDate value, SaishinsamoshitateProcessParameter processParameter) {
        RString 日付 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            if (processParameter.isHitsukeHenshu()) {
                日付 = value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            } else {
                日付 = new RString(value.toString());
            }
        }
        return 日付;
    }

    private RString get番地(Banchi banchi) {
        RString 番地 = RString.EMPTY;
        if (banchi != null) {
            番地 = banchi.getBanchi().value();
        }
        return 番地;
    }

    private RString get方書(Katagaki katagaki) {
        RString 方書 = RString.EMPTY;
        if (katagaki != null) {
            方書 = katagaki.value();
        }
        return 方書;
    }

    private RString nullToEmpty(Code obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    private RString nullToEmpty(HihokenshaNo obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    private RString nullToEmpty(JigyoshaNo obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    private RString nullToEmpty(AtenaMeisho obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    private RString nullToEmpty(ServiceShuruiCode obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    private RString nullToEmpty(ServiceKomokuCode obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    private RString nullToEmpty(ShoKisaiHokenshaNo obj) {
        if (obj == null || obj.isEmpty()) {
            return RString.EMPTY;
        } else {
            return obj.value();
        }
    }

    /**
     * 帳票分類ID「DBC701011_HanyoListSaishinsaMoshitate」（汎用リスト 再審査申立情報）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("\"ShikibetsuTaisho_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"ShikibetsuTaisho_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShikibetsuTaisho_kanaShimei\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"市町村コード\"")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""), new RString("\"証記載保険者番号\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"被保険者番号\"")),
        /**
         * 被保険要介護度者番号
         */
        要介護度(new RString("0403"), new RString(""), new RString("\"要介護認定状態区分コード\"")),
        /**
         * 認定開始日
         */
        認定開始日(new RString("0411"), new RString(""), new RString("\"認定有効期間開始年月日\"")),
        /**
         * サービス年月
         */
        サービス年月(new RString("0301"), new RString(""), new RString("\"サービス提供年月\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
