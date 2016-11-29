/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigyobunkogakugassanshikyukettei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_事業分高額合算支給決定情報ビジネスのクラスです
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
@Getter
@Setter
public class JigyoBunKogakuGassanShikyuKettei {

    private final JigyoBunKogakuGassanShikyuKetteiProcessParameter processParameter;
    private static final RString 文字1 = new RString("1");
    private static final int INT20 = 20;
    private List<PersonalData> personalDataList;

    /**
     * コンストラクタです。
     *
     * @param processParameter processParameter
     */
    public JigyoBunKogakuGassanShikyuKettei(JigyoBunKogakuGassanShikyuKetteiProcessParameter processParameter) {
        this.processParameter = processParameter;
        personalDataList = new ArrayList<>();
    }

    /**
     * JigyoBunKogakuGassanShikyuKetteibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param iKoza iKoza
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param association association
     * @param 連番 連番
     * @param 住所 RString
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity set連番ありEUCEntity(JigyoBunKogakuGassanShikyuKetteiRelateEntity entity, IKoza iKoza,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap, Association association, int 連番, RString 住所) {
        JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity eucEntity = new JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
            eucEntity.set住所_番地_方書(住所);
            eucEntity.set連番(new RString(連番));
            eucEntity.set識別コード(iKojin.get識別コード());
            eucEntity.set住民種別(iKojin.get住民状態().住民状態略称());
            eucEntity.set氏名(iKojin.get名称().getName());
            eucEntity.set氏名カナ(iKojin.get名称().getKana());
            eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate()));
            eucEntity.set年齢(iKojin.get年齢算出().get年齢());
            eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
            eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
            eucEntity.set世帯コード(iKojin.get世帯コード());
            eucEntity.set世帯主名(iKojin.get世帯主名());
            eucEntity.set住所コード(iKojin.get住所().get町域コード());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
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
            eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日()));
            eucEntity.set登録事由(iKojin.get登録事由());
            eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日()));
            eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set住定事由(iKojin.get住定事由());
            eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set消除異動日(set日付編集(iKojin.get消除異動年月日()));
            eucEntity.set消除事由(iKojin.get消除事由());
            eucEntity.set消除届出日(set日付編集(iKojin.get消除届出年月日()));
            eucEntity.set転出入理由(RString.EMPTY);
            eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号().getEditedYubinNo());
            eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                    get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        }
        UaFt250FindAtesakiEntity 宛先Entity = entity.get宛先Entity();
        if (宛先Entity != null) {
            IAtesaki iAtesaki = AtesakiFactory.createInstance(宛先Entity);
            eucEntity.set送付先氏名(iAtesaki.get宛先名称().getName());
            eucEntity.set送付先氏名カナ(iAtesaki.get宛先名称().getKana());
            eucEntity.set送付先住所コード(iAtesaki.get宛先住所().get全国住所コード());
            eucEntity.set送付先郵便番号(iAtesaki.get宛先住所().get郵便番号());
            eucEntity.set送付先住所_番地_方書(get住所_番地_方書(iAtesaki.get宛先住所().get住所(),
                    get番地(iAtesaki.get宛先住所().get番地()), get方書(iAtesaki.get宛先住所().get方書())));
            eucEntity.set送付先住所(iAtesaki.get宛先住所().get住所());
            eucEntity.set送付先番地(get番地(iAtesaki.get宛先住所().get番地()));
            eucEntity.set送付先方書(get方書(iAtesaki.get宛先住所().get方書()));
            eucEntity.set送付先行政区コード(iAtesaki.get宛先行政区().getコード());
            eucEntity.set送付先行政区名(iAtesaki.get宛先行政区().get名称());
        }
        if (iKoza != null) {
            eucEntity.set金融機関コード(iKoza.get金融機関コード());
            eucEntity.set金融機関名(iKoza.get金融機関().get金融機関名称());
            eucEntity.set金融機関支店コード(get金融機関支店コード(iKoza));
            eucEntity.set金融機関支店名(get金融機関支店名(iKoza));
            eucEntity.set口座種目名(iKoza.get預金種別().get預金種別名称());
            eucEntity.set口座番号(iKoza.get口座番号());
            eucEntity.set口座名義人_カナ(iKoza.get口座名義人());
        }
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.HALF_SPACE);
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), entity.get資格取得事由コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日()));
        eucEntity.set資格取得届出日(set日付編集(entity.get資格取得届出年月日()));
        eucEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), entity.get資格喪失事由コード()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日()));
        eucEntity.set資格喪失届日(set日付編集(entity.get資格喪失届出年月日()));
        eucEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        if (文字1.equals(entity.get住所地特例フラグ())) {
            eucEntity.set住所地特例状態(new RString("住特"));
        }
        eucEntity.set受給申請事由(get受給申請事由(entity));
        eucEntity.set受給申請日(set日付編集(entity.get受給申請年月日()));
        if (!isNullCheck(entity.get要介護認定状態区分コード())) {
            eucEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(FlexibleDate.getNowDate(), entity.get要介護認定状態区分コード()).getName());
        }
        eucEntity.set受給認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set受給認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set受給認定日(set日付編集(entity.get認定年月日()));
        if (entity.is旧措置者フラグ()) {
            eucEntity.set受給旧措置(new RString("旧措置者"));
        } else {
            eucEntity.set受給旧措置(RString.EMPTY);
        }
        if (!isNullCheck(entity.getみなし要介護区分コード())) {
            eucEntity.set受給みなし更新認定(get受給みなし更新認定(entity.getみなし要介護区分コード()));
        } else {
            eucEntity.set受給みなし更新認定(RString.EMPTY);
        }
        if (!isNullCheck(entity.get直近異動事由コード())) {
            eucEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get直近異動事由コード()).get名称());
        }
        eucEntity.set対象年度(entity.get対象年度());
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set連絡票整理番号(entity.get連絡票整理番号());
        eucEntity.set履歴番号(entity.get履歴番号());
        eucEntity.set自己負担額証明書整理番号(entity.get自己負担額証明書整理番号());
        eucEntity.set対象計算期間_開始(set日付編集(entity.get対象計算期間開始年月日()));
        eucEntity.set対象計算期間_終了(set日付編集(entity.get対象計算期間終了年月日()));
        eucEntity.set申請日(set日付編集(entity.get申請年月日()));
        eucEntity.set決定日(set日付編集(entity.get決定年月日()));
        eucEntity.set自己負担総額(entity.get自己負担総額());
        eucEntity.set支給区分コード(entity.get支給区分コード());
        eucEntity.set支給額(entity.get支給額());
        eucEntity.set給付の種類(entity.get給付の種類());
        eucEntity.set不支給理由(entity.get不支給理由());
        eucEntity.set支払方法区分(entity.get支払方法区分());
        eucEntity.set支払場所(entity.get支払場所());
        eucEntity.set支払期間開始日(set日付編集(entity.get支払期間開始年月日()));
        eucEntity.set支払期間終了日(set日付編集(entity.get支払期間終了年月日()));
        eucEntity.set支払期間開始日_曜日(get曜日(entity.get支払期間開始年月日()));
        eucEntity.set支払期間終了日_曜日(get曜日(entity.get支払期間終了年月日()));
        eucEntity.set支払期間開始日_時間(entity.get支払期間開始時間());
        eucEntity.set支払期間終了日_時間(entity.get支払期間終了時間());
        eucEntity.set決定通知書作成日(entity.get決定通知書作成年月日());
        eucEntity.set振込通知書作成日(entity.get振込通知書作成年月日());
        eucEntity.set受取年月(entity.get受取年月());
        eucEntity.set給付の種類_短(get内容短(entity.get給付の種類()));
        eucEntity.set不支給理由_短(get内容短(entity.get不支給理由()));
        eucEntity.set支払場所_短(get内容短(entity.get支払場所()));
        return eucEntity;
    }

    /**
     * JigyoBunKogakuGassanShikyuKetteibanAriEUCEntityの設定クラスです。
     *
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity set連番ありEUCEntity() {
        JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity eucEntity = new JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity();
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
        eucEntity.set送付先氏名(null);
        eucEntity.set送付先氏名カナ(null);
        eucEntity.set送付先住所コード(null);
        eucEntity.set送付先郵便番号(null);
        eucEntity.set送付先住所_番地_方書(null);
        eucEntity.set送付先住所(null);
        eucEntity.set送付先番地(null);
        eucEntity.set送付先方書(null);
        eucEntity.set送付先行政区コード(null);
        eucEntity.set送付先行政区名(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set資格取得事由(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格取得届出日(null);
        eucEntity.set喪失事由(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set資格喪失届日(null);
        eucEntity.set資格区分(null);
        eucEntity.set住所地特例状態(null);
        eucEntity.set受給申請事由(null);
        eucEntity.set受給申請日(null);
        eucEntity.set受給要介護度(null);
        eucEntity.set受給認定開始日(null);
        eucEntity.set受給認定終了日(null);
        eucEntity.set受給認定日(null);
        eucEntity.set受給旧措置(null);
        eucEntity.set受給みなし更新認定(null);
        eucEntity.set受給直近事由(null);
        eucEntity.set対象年度(null);
        eucEntity.set保険者番号(null);
        eucEntity.set連絡票整理番号(null);
        eucEntity.set履歴番号(null);
        eucEntity.set自己負担額証明書整理番号(null);
        eucEntity.set対象計算期間_開始(null);
        eucEntity.set対象計算期間_終了(null);
        eucEntity.set申請日(null);
        eucEntity.set決定日(null);
        eucEntity.set自己負担総額(null);
        eucEntity.set支給区分コード(null);
        eucEntity.set支給額(null);
        eucEntity.set給付の種類(null);
        eucEntity.set不支給理由(null);
        eucEntity.set支払方法区分(null);
        eucEntity.set支払場所(null);
        eucEntity.set支払期間開始日(null);
        eucEntity.set支払期間終了日(null);
        eucEntity.set支払期間開始日_曜日(null);
        eucEntity.set支払期間終了日_曜日(null);
        eucEntity.set支払期間開始日_時間(null);
        eucEntity.set支払期間終了日_時間(null);
        eucEntity.set金融機関コード(null);
        eucEntity.set金融機関名(null);
        eucEntity.set金融機関支店コード(null);
        eucEntity.set金融機関支店名(null);
        eucEntity.set口座種目名(null);
        eucEntity.set口座番号(null);
        eucEntity.set口座名義人_カナ(null);
        eucEntity.set決定通知書作成日(null);
        eucEntity.set振込通知書作成日(null);
        eucEntity.set受取年月(null);
        eucEntity.set給付の種類_短(null);
        eucEntity.set不支給理由_短(null);
        eucEntity.set支払場所_短(null);
        return eucEntity;
    }

    /**
     * JigyoBunKogakuGassanShikyuKetteibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param iKoza iKoza
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param association association
     * @param 住所 RString
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity set連番なしEUCEntity(JigyoBunKogakuGassanShikyuKetteiRelateEntity entity, IKoza iKoza,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap, Association association, RString 住所) {
        JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity eucEntity = new JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
            eucEntity.set住所_番地_方書(住所);
            eucEntity.set識別コード(iKojin.get識別コード());
            eucEntity.set住民種別(iKojin.get住民状態().住民状態略称());
            eucEntity.set氏名(iKojin.get名称().getName());
            eucEntity.set氏名カナ(iKojin.get名称().getKana());
            eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate()));
            eucEntity.set年齢(iKojin.get年齢算出().get年齢());
            eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
            eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
            eucEntity.set世帯コード(iKojin.get世帯コード());
            eucEntity.set世帯主名(iKojin.get世帯主名());
            eucEntity.set住所コード(iKojin.get住所().get町域コード());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
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
            eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日()));
            eucEntity.set登録事由(iKojin.get登録事由());
            eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日()));
            eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set住定事由(iKojin.get住定事由());
            eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set消除異動日(set日付編集(iKojin.get消除異動年月日()));
            eucEntity.set消除事由(iKojin.get消除事由());
            eucEntity.set消除届出日(set日付編集(iKojin.get消除届出年月日()));
            eucEntity.set転出入理由(RString.EMPTY);
            eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号().getEditedYubinNo());
            eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                    get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        }
        UaFt250FindAtesakiEntity 宛先Entity = entity.get宛先Entity();
        if (宛先Entity != null) {
            IAtesaki iAtesaki = AtesakiFactory.createInstance(宛先Entity);
            eucEntity.set送付先氏名(iAtesaki.get宛先名称().getName());
            eucEntity.set送付先氏名カナ(iAtesaki.get宛先名称().getKana());
            eucEntity.set送付先住所コード(iAtesaki.get宛先住所().get全国住所コード());
            eucEntity.set送付先郵便番号(iAtesaki.get宛先住所().get郵便番号());
            eucEntity.set送付先住所_番地_方書(get住所_番地_方書(iAtesaki.get宛先住所().get住所(),
                    get番地(iAtesaki.get宛先住所().get番地()), get方書(iAtesaki.get宛先住所().get方書())));
            eucEntity.set送付先住所(iAtesaki.get宛先住所().get住所());
            eucEntity.set送付先番地(get番地(iAtesaki.get宛先住所().get番地()));
            eucEntity.set送付先方書(get方書(iAtesaki.get宛先住所().get方書()));
            eucEntity.set送付先行政区コード(iAtesaki.get宛先行政区().getコード());
            eucEntity.set送付先行政区名(iAtesaki.get宛先行政区().get名称());
        }
        if (iKoza != null) {
            eucEntity.set金融機関コード(iKoza.get金融機関コード());
            eucEntity.set金融機関名(iKoza.get金融機関().get金融機関名称());
            eucEntity.set金融機関支店コード(get金融機関支店コード(iKoza));
            eucEntity.set金融機関支店名(get金融機関支店名(iKoza));
            eucEntity.set口座種目名(iKoza.get預金種別().get預金種別名称());
            eucEntity.set口座番号(iKoza.get口座番号());
            eucEntity.set口座名義人_カナ(iKoza.get口座名義人());
        }
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.HALF_SPACE);
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), entity.get資格取得事由コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日()));
        eucEntity.set資格取得届出日(set日付編集(entity.get資格取得届出年月日()));
        eucEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), entity.get資格喪失事由コード()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日()));
        eucEntity.set資格喪失届日(set日付編集(entity.get資格喪失届出年月日()));
        eucEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        if (文字1.equals(entity.get住所地特例フラグ())) {
            eucEntity.set住所地特例状態(new RString("住特"));
        }
        eucEntity.set受給申請事由(get受給申請事由(entity));
        eucEntity.set受給申請日(set日付編集(entity.get受給申請年月日()));
        if (!isNullCheck(entity.get要介護認定状態区分コード())) {
            eucEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(FlexibleDate.getNowDate(), entity.get要介護認定状態区分コード()).getName());
        }
        eucEntity.set受給認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set受給認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set受給認定日(set日付編集(entity.get認定年月日()));
        if (entity.is旧措置者フラグ()) {
            eucEntity.set受給旧措置(new RString("旧措置者"));
        } else {
            eucEntity.set受給旧措置(RString.EMPTY);
        }
        if (!isNullCheck(entity.getみなし要介護区分コード())) {
            eucEntity.set受給みなし更新認定(get受給みなし更新認定(entity.getみなし要介護区分コード()));
        } else {
            eucEntity.set受給みなし更新認定(RString.EMPTY);
        }
        if (!isNullCheck(entity.get直近異動事由コード())) {
            eucEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get直近異動事由コード()).get名称());
        }
        eucEntity.set対象年度(entity.get対象年度());
        eucEntity.set保険者番号(entity.get保険者番号());
        eucEntity.set連絡票整理番号(entity.get連絡票整理番号());
        eucEntity.set履歴番号(entity.get履歴番号());
        eucEntity.set自己負担額証明書整理番号(entity.get自己負担額証明書整理番号());
        eucEntity.set対象計算期間_開始(set日付編集(entity.get対象計算期間開始年月日()));
        eucEntity.set対象計算期間_終了(set日付編集(entity.get対象計算期間終了年月日()));
        eucEntity.set申請日(set日付編集(entity.get申請年月日()));
        eucEntity.set決定日(set日付編集(entity.get決定年月日()));
        eucEntity.set自己負担総額(entity.get自己負担総額());
        eucEntity.set支給区分コード(entity.get支給区分コード());
        eucEntity.set支給額(entity.get支給額());
        eucEntity.set給付の種類(entity.get給付の種類());
        eucEntity.set不支給理由(entity.get不支給理由());
        eucEntity.set支払方法区分(entity.get支払方法区分());
        eucEntity.set支払場所(entity.get支払場所());
        eucEntity.set支払期間開始日(set日付編集(entity.get支払期間開始年月日()));
        eucEntity.set支払期間終了日(set日付編集(entity.get支払期間終了年月日()));
        eucEntity.set支払期間開始日_曜日(get曜日(entity.get支払期間開始年月日()));
        eucEntity.set支払期間終了日_曜日(get曜日(entity.get支払期間終了年月日()));
        eucEntity.set支払期間開始日_時間(entity.get支払期間開始時間());
        eucEntity.set支払期間終了日_時間(entity.get支払期間終了時間());
        eucEntity.set決定通知書作成日(entity.get決定通知書作成年月日());
        eucEntity.set振込通知書作成日(entity.get振込通知書作成年月日());
        eucEntity.set受取年月(entity.get受取年月());
        eucEntity.set給付の種類_短(get内容短(entity.get給付の種類()));
        eucEntity.set不支給理由_短(get内容短(entity.get不支給理由()));
        eucEntity.set支払場所_短(get内容短(entity.get支払場所()));
        return eucEntity;
    }

    /**
     * JigyoBunKogakuGassanShikyuKetteibanAriEUCEntityの設定クラスです。
     *
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity set連番なしEUCEntity() {
        JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity eucEntity = new JigyoBunKogakuGassanShikyuKetteibanNashiEUCEntity();
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
        eucEntity.set送付先氏名(null);
        eucEntity.set送付先氏名カナ(null);
        eucEntity.set送付先住所コード(null);
        eucEntity.set送付先郵便番号(null);
        eucEntity.set送付先住所_番地_方書(null);
        eucEntity.set送付先住所(null);
        eucEntity.set送付先番地(null);
        eucEntity.set送付先方書(null);
        eucEntity.set送付先行政区コード(null);
        eucEntity.set送付先行政区名(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set資格取得事由(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格取得届出日(null);
        eucEntity.set喪失事由(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set資格喪失届日(null);
        eucEntity.set資格区分(null);
        eucEntity.set住所地特例状態(null);
        eucEntity.set受給申請事由(null);
        eucEntity.set受給申請日(null);
        eucEntity.set受給要介護度(null);
        eucEntity.set受給認定開始日(null);
        eucEntity.set受給認定終了日(null);
        eucEntity.set受給認定日(null);
        eucEntity.set受給旧措置(null);
        eucEntity.set受給みなし更新認定(null);
        eucEntity.set受給直近事由(null);
        eucEntity.set対象年度(null);
        eucEntity.set保険者番号(null);
        eucEntity.set連絡票整理番号(null);
        eucEntity.set履歴番号(null);
        eucEntity.set自己負担額証明書整理番号(null);
        eucEntity.set対象計算期間_開始(null);
        eucEntity.set対象計算期間_終了(null);
        eucEntity.set申請日(null);
        eucEntity.set決定日(null);
        eucEntity.set自己負担総額(null);
        eucEntity.set支給区分コード(null);
        eucEntity.set支給額(null);
        eucEntity.set給付の種類(null);
        eucEntity.set不支給理由(null);
        eucEntity.set支払方法区分(null);
        eucEntity.set支払場所(null);
        eucEntity.set支払期間開始日(null);
        eucEntity.set支払期間終了日(null);
        eucEntity.set支払期間開始日_曜日(null);
        eucEntity.set支払期間終了日_曜日(null);
        eucEntity.set支払期間開始日_時間(null);
        eucEntity.set支払期間終了日_時間(null);
        eucEntity.set金融機関コード(null);
        eucEntity.set金融機関名(null);
        eucEntity.set金融機関支店コード(null);
        eucEntity.set金融機関支店名(null);
        eucEntity.set口座種目名(null);
        eucEntity.set口座番号(null);
        eucEntity.set口座名義人_カナ(null);
        eucEntity.set決定通知書作成日(null);
        eucEntity.set振込通知書作成日(null);
        eucEntity.set受取年月(null);
        eucEntity.set給付の種類_短(null);
        eucEntity.set不支給理由_短(null);
        eucEntity.set支払場所_短(null);
        return eucEntity;
    }

    private RString get金融機関支店コード(IKoza iKoza) {
        RString 金融機関支店コード;
        if (iKoza.isゆうちょ銀行()) {
            金融機関支店コード = iKoza.get店番();
        } else {
            金融機関支店コード = iKoza.get支店コード().value();
        }
        return 金融機関支店コード;
    }

    private RString get金融機関支店名(IKoza iKoza) {
        RString 金融機関支店名;
        if (iKoza.isゆうちょ銀行()) {
            金融機関支店名 = iKoza.get店名();
        } else {
            金融機関支店名 = iKoza.get支店(FlexibleDate.getNowDate()).get支店名称();
        }
        return 金融機関支店名;
    }

    private RString get内容短(RString value) {
        RString 内容短;
        if (!RString.isNullOrEmpty(value) && INT20 < value.length()) {
            内容短 = value.substring(0, INT20);
        } else {
            内容短 = value;
        }
        return 内容短;
    }

    private RString get曜日(RString value) {
        RString 曜日 = RString.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            曜日 = new RString(new FlexibleDate(value).getDayOfWeek().getFullTerm());
        }
        return 曜日;
    }

    private RString get受給申請事由(JigyoBunKogakuGassanShikyuKetteiRelateEntity entity) {
        List jukyuShinseiJiyuList = new ArrayList();
        RString 受給申請事由 = RString.EMPTY;
        RString 受給申請事由コード = entity.get受給申請事由();
        for (JukyuShinseiJiyu jukyuShinseiJiyu : JukyuShinseiJiyu.values()) {
            jukyuShinseiJiyuList.add(jukyuShinseiJiyu.getコード());
        }
        if (jukyuShinseiJiyuList.contains(受給申請事由コード)) {
            受給申請事由 = getJukyuShinseiJiyu(受給申請事由コード, 受給申請事由, entity.get資格取得事由コード());
        }
        return 受給申請事由;
    }

    private RString getJukyuShinseiJiyu(RString 受給申請事由コード, RString 受給申請事由, RString 要支援者認定申請区分) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("初回申請　　");
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("再申請内　　");
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("再申請外　　");
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由コード)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(要支援者認定申請区分)) {
                受給申請事由 = new RString("支援から申請");
            } else {
                受給申請事由 = new RString("区分変更申請");
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("サ変更申請　");
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("施行前申請　");
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("追加　　　　");
        }
        return 受給申請事由;
    }

    private RString get受給みなし更新認定(RString みなし要介護区分コード) {
        RString 受給みなし更新認定 = RString.EMPTY;
        List minashiCodeList = new ArrayList();
        for (MinashiCode minashiCode : MinashiCode.values()) {
            minashiCodeList.add(minashiCode.getコード());
        }
        if (minashiCodeList.contains(みなし要介護区分コード) && !MinashiCode.通常の認定.getコード().equals(みなし要介護区分コード)) {
            受給みなし更新認定 = new RString("みなし");
        }
        return 受給みなし更新認定;
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

    private RString set日付編集(RString value) {
        RString 日付 = RString.EMPTY;
        if (processParameter.is日付編集() && !RString.isNullOrEmpty(value)) {
            日付 = new FlexibleDate(value).seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return 日付;
    }

    private RString set日付編集(FlexibleDate value) {
        RString 日付 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            if (processParameter.is日付編集()) {
                日付 = value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            } else {
                日付 = new RString(value.toString());
            }
        }
        return 日付;
    }

    private RString get住所_番地_方書(RString 住所, RString 番地, RString 方書) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(住所);
        builder.append(番地);
        builder.append(RString.FULL_SPACE);
        builder.append(方書);
        return builder.toRString();
    }

    private RString get方書(Katagaki katagaki) {
        RString 方書 = RString.EMPTY;
        if (katagaki != null) {
            方書 = katagaki.value();
        }
        return 方書;
    }

    private RString get番地(Banchi banchi) {
        RString 番地 = RString.EMPTY;
        if (banchi != null) {
            番地 = banchi.getBanchi().value();
        }
        return 番地;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @return AccessLogUUID
     */
    public AccessLogUUID getアクセスログ() {
        return AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
    }

    private PersonalData toPersonalData(RString 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @return List<RString>
     */
    public List<RString> set出力条件() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【抽出条件】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        if (RString.isNullOrEmpty(processParameter.get保険者コード())) {
            jokenBuilder.append(RString.EMPTY);
        } else if (new RString("000000").equals(processParameter.get保険者コード())) {
            jokenBuilder.append(new RString("保険者："));
            jokenBuilder.append(new RString("000000 全市町村"));
        } else {
            jokenBuilder.append(new RString("保険者："));
            RStringBuilder 市町村名builder = new RStringBuilder();
            市町村名builder.append(processParameter.get保険者コード());
            市町村名builder.append(RString.HALF_SPACE);
            市町村名builder.append(processParameter.get保険者名());
            jokenBuilder.append(市町村名builder.toRString());
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("支給区分："));
        if (1 < processParameter.get支給区分List().size()) {
            jokenBuilder.append(ShikyuKubun.すべて.get名称());
        } else {
            jokenBuilder.append(ShikyuKubun.toValue(processParameter.get支給区分List().get(0)).get名称());
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("支払方法区分："));
        if (1 < processParameter.get支払方法区分List().size()) {
            jokenBuilder.append(ShiharaiHohoKubun.すべて.get名称());
        } else {
            jokenBuilder.append(ShiharaiHohoKubun.toValue(processParameter.get支払方法区分List().get(0)).get名称());
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("金融機関："));
        jokenBuilder.append(processParameter.get金融機関コード());
        jokenBuilder.append(RString.HALF_SPACE);
        jokenBuilder.append(processParameter.get金融機関名());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("対象年度："));
        if (!RString.isNullOrEmpty(processParameter.get対象年度())) {
            jokenBuilder.append(new FlexibleYear(processParameter.get対象年度()).wareki().eraType(EraType.KANJI).toDateString()).append("年度");
        }
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    private boolean isNullCheck(RString value) {
        return RString.isNullOrEmpty(value);
    }

    /**
     * MybatisParameterを設定するメッソドです。
     *
     * @param 出力順 出力順
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public JigyoBunKogakuGassanShikyuKetteiMybatisParameter createMybatisParameter(RString 出力順) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        KozaSearchKeyBuilder keyBuilder = new KozaSearchKeyBuilder();
        KozaSearchKeyBuilder searchKey = new KozaSearchKeyBuilder();
        searchKey.set業務コード(GyomuCode.DB介護保険);
        searchKey.setサブ業務コード(SubGyomuCode.DBC介護給付);
        searchKey.set基準日(new FlexibleDate(RDate.getNowDate().toDateString()));
        List<KamokuCode> kamokuList = new ArrayList<>();
        IKozaSearchKey iKozaSearchKey = keyBuilder.build();
        return JigyoBunKogakuGassanShikyuKetteiMybatisParameter.createMybatisParameter(iKozaSearchKey,
                kamokuList,
                processParameter.get市町村コード(),
                processParameter.get対象年度(),
                processParameter.get支給区分List(),
                processParameter.get支払方法区分List(),
                processParameter.get金融機関コード(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()),
                出力順);
    }

    /**
     * 帳票分類ID「DBC701021_HanyoListJigyoBunKogakuGassanShikyuKettei」（汎用リスト_事業分高額合算支給決定情報）出力順設定可能項目です。
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
        市町村コード(new RString("0016"), new RString(""), new RString("\"shichosonCode\"")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""), new RString("\"hihokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"hihokenshaNo\"")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString(""), new RString("\"yokaigoJotaiKubunCode\"")),
        /**
         * 認定開始日
         */
        認定開始日(new RString("0411"), new RString(""), new RString("\"ninteiYukoKikanKaishiYMD\"")),
        /**
         * 整理番号
         */
        整理番号(new RString("0337"), new RString(""), new RString("\"shikyuSeiriNo\"")),
        /**
         * 支払方法
         */
        支払方法(new RString("0312"), new RString(""), new RString("\"shiharaiHohoKubun\"")),
        /**
         * 通知書作成日
         *
         */
        通知書作成日(new RString("0410"), new RString(""), new RString("\"ketteiTsuchiSakuseiYMD\"")),
        /**
         * 対象年度
         *
         */
        対象年度(new RString("0334"), new RString(""), new RString("\"taishoNendo\""));

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
