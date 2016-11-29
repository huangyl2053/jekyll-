/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistkokuhorenjukyusha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyodoshoriyojukyushajoho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_GemmenShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HenkoShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HyojunFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NijiyoboJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_RiyoshaFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ServiceKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShinseiShubetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TokureiGengakuSochiTaisho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaNashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト 国保連受給者情報ビジネスのクラスです
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
public class HanyoListKokuhorenJukyushaResult {

    private static final int LENGTH = 6;
    private static final RString 通常認定 = new RString("1");
    private static final RString 旧措置入所者 = new RString("2");
    private static final RString やむを得ない理由 = new RString("3");
    private final HanyoListKokuhorenJukyushaProcessParameter processParameter;
    private final List<PersonalData> personalDataList;

    /**
     * コンストラクタです。
     *
     * @param processParameter processParameter
     */
    public HanyoListKokuhorenJukyushaResult(HanyoListKokuhorenJukyushaProcessParameter processParameter) {
        this.processParameter = processParameter;
        personalDataList = new ArrayList<>();
    }

    /**
     * HanyoListKokuhorenJukyushaReibanAriEUCEntityの設定クラスです。
     *
     * @param entity HanyoListKokuhorenJukyushaRelateEntity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param asociation Asociation
     * @param 導入団体情報 Association
     * @param 連番 連番
     * @return HanyoListKokuhorenJukyushaAriEUCEntity
     */
    public HanyoListKokuhorenJukyushaAriEUCEntity set連番ありEUCEntity(HanyoListKokuhorenJukyushaRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association asociation,
            Association 導入団体情報, int 連番
    ) {
        HanyoListKokuhorenJukyushaAriEUCEntity eucEntity = new HanyoListKokuhorenJukyushaAriEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
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
            eucEntity.set住所コード(iKojin.get住所().get町域コード().value());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
            eucEntity.set住所番地方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
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
            eucEntity.set前住所番地方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                    get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        }
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(asociation.get地方公共団体コード().value());
        eucEntity.set保険者名(asociation.get市町村名());
        eucEntity.set空白(RString.HALF_SPACE);
        eucEntity.set処理対象年月(set日付編集(entity.get送付年月()));
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set履歴番号(new RString(String.valueOf(entity.get履歴番号())));
        eucEntity.set異動年月日(set日付編集(entity.get異動年月日()));
        eucEntity.set異動区分(set異動区分(entity.get異動区分コード()));
        eucEntity.set異動事由(set異動事由(entity.get受給者異動事由()));
        eucEntity.set給付証記載保険者番号(entity.get証記載保険者番号());
        eucEntity.set被保険者氏名(entity.get被保険者氏名カナ());
        eucEntity.set送付生年月日(set日付編集(entity.get生年月日()));
        eucEntity.set送付性別(set性別(entity.get性別コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日()));
        eucEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
        eucEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
        eucEntity.set公費負担者番号(entity.get公費負担者番号());
        eucEntity.set広域保険者番号(entity.get広域連合政令市保険者番号());
        eucEntity.set申請種別(set申請種別(entity.get申請種別コード()));
        eucEntity.set変更申請中区分(set変更申請中区分(entity.get変更申請中区分コード()));
        eucEntity.set申請日(set日付編集(entity.get申請年月日()));
        eucEntity.setみなし更新認定(setみなし更新認定(entity.getみなし要介護状態区分コード()));
        eucEntity.set要介護状態度(set要介護状態(entity.get要介護状態区分コード()));
        eucEntity.set認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set居宅計画作成区分(set居宅計画作成区分(entity.get居宅サービス計画作成区分コード()));
        eucEntity.set居宅支援事業者番号(entity.get居宅介護支援事業所番号());
        eucEntity.set居宅支援事業者名(entity.get事業者名称());
        eucEntity.setサービス計画適用開始日(set日付編集(entity.get居宅サービス計画適用開始年月日()));
        eucEntity.setサービス計画適用終了日(set日付編集(entity.get居宅サービス計画適用終了年月日()));
        eucEntity.set訪問通所支給限度基準額(new RString(String.valueOf(entity.get訪問通所サービス支給限度基準額())));
        eucEntity.set訪問通所管理適用開始日(set日付編集(entity.get訪問通所サービス上限管理適用期間開始年月日()));
        eucEntity.set訪問通所管理適用終了日(set日付編集(entity.get訪問通所サービス上限管理適用期間終了年月日()));
        eucEntity.set短期入所支給限度基準額(new RString(String.valueOf(entity.get短期入所サービス支給限度基準額())));
        eucEntity.set短期入所管理適用開始日(set日付編集(entity.get短期入所サービス上限管理適用期間開始年月日()));
        eucEntity.set短期入所管理適用終了日(set日付編集(entity.get短期入所サービス上限管理適用期間終了年月日()));
        eucEntity.set公費負担上限額減額の有無(set公費負担上限額減額の有無(entity.is公費負担上限額減額有フラグ()));
        eucEntity.set償還払化開始日(set日付編集(entity.get償還払化開始年月日()));
        eucEntity.set償還払化終了日(set日付編集(entity.get償還払化終了年月日()));
        eucEntity.set給付率引下げ開始日(set日付編集(entity.get給付率引下げ開始年月日()));
        eucEntity.set給付率引下げ終了日(set日付編集(entity.get給付率引下げ終了年月日()));
        eucEntity.set減免申請中区分(set減免申請中区分(entity.get減免申請中区分コード()));
        eucEntity.set利用者負担区分(set利用者負担区分(entity.get利用者負担区分コード()));
        eucEntity.set利用者負担給付率(new RString(String.valueOf(entity.get給付率())));
        eucEntity.set利用者負担適用開始日(set日付編集(entity.get適用開始年月日()));
        eucEntity.set利用者負担適用終了日(set日付編集(entity.get適用終了年月日()));
        eucEntity.set標準負担区分(set標準負担区分(entity.get標準負担区分コード()));
        eucEntity.set標準負担額(new RString(entity.get負担額()));
        eucEntity.set標準負担適用開始日(set日付編集(entity.get負担額適用開始年月日()));
        eucEntity.set標準負担適用終了日(set日付編集(entity.get負担額適用終了年月日()));
        eucEntity.set特定入所者認定申請中区分コード(set特定入所者認定申請中区分(entity.get特定入所者認定申請中区分コード()));
        eucEntity.set特定入所介護サービス区分コード(set特定入所介護サービス区分(entity.get特定入所者介護サービス区分コード()));
        eucEntity.set課税層の特例減額措置対象(set課税層の特例減額措置対象(entity.get課税層の特例減額措置対象フラグ()));
        eucEntity.set食費負担限度額(entity.get食費負担限度額());
        eucEntity.set居住費ユ個負担限度額(entity.get居住費ユニット型個室負担限度額());
        eucEntity.set居住費ユ準負担限度額(entity.get居住費ユニット型準個室負担限度額());
        eucEntity.set居住費従特養負担限度額(entity.get居住費従来型個室特養等負担限度額());
        eucEntity.set居住費従老療負担限度額(entity.get居住費従来型個室老健療養等負担限度額());
        eucEntity.set居住費多床室負担限度額(entity.get居住費多床室負担限度額());
        eucEntity.set負担限度額適用開始日(set日付編集(entity.get負担限度額適用開始年月日()));
        eucEntity.set負担限度額適用終了日(set日付編集(entity.get負担限度額適用終了年月日()));
        eucEntity.set社会福祉法人軽減率(entity.get軽減率());
        eucEntity.set社会福祉法人軽減率適用開始日(set日付編集(entity.get軽減率適用開始年月日()));
        eucEntity.set社会福祉法人軽減率適用終了日(set日付編集(entity.get軽減率適用終了年月日()));
        eucEntity.set小規模居宅サービス有無(set小規模居宅サービス有無(entity.is小多機能居宅介護利用開始月利用有フラグ()));
        eucEntity.set保険者番号後期(entity.get後期高齢者医療保険者番号());
        eucEntity.set被保険者番号後期(entity.get後期高齢者医療被保険者番号());
        eucEntity.set保険者番号国保(entity.get国民健康保険保険者番号());
        eucEntity.set被保険者証番号国保(entity.get国民健康保険被保険者証番号());
        eucEntity.set個人番号国保(entity.get国民健康保険個人番号());
        eucEntity.set二次予防事業開始日(set日付編集(entity.get二次予防事業有効期間開始年月日()));
        eucEntity.set二次予防事業終了日(set日付編集(entity.get二次予防事業有効期間終了年月日()));
        eucEntity.set二次予防事業区分(set二次予防事業区分(entity.get二次予防事業区分コード()));
        eucEntity.set住所地特例対象者区分コード(entity.get住所地特例対象者区分コード());
        eucEntity.set施設所在保険者番号(entity.get施設所在保険者番号());
        eucEntity.set住所地特例適用開始日(set日付編集(entity.get住所地特例適用開始日()));
        eucEntity.set住所地特例適用終了日(set日付編集(entity.get住所地特例適用終了日()));
        eucEntity.set居宅費新１負担限度額(entity.get居宅費新1負担限度額());
        eucEntity.set居宅費新２負担限度額(entity.get居宅費新2負担限度額());
        eucEntity.set居宅費新３負担限度額(entity.get居宅費新3負担限度額());
        eucEntity.set利用者負担割合有効開始日(set日付編集(entity.get利用者負担割合有効開始日()));
        eucEntity.set利用者負担割合有効終了日(set日付編集(entity.get利用者負担割合有効終了日()));
        return eucEntity;
    }

    /**
     * HanyoListKokuhorenJukyushaReibanAriEUCEntityの設定クラスです。
     *
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public HanyoListKokuhorenJukyushaAriEUCEntity set連番ありEUCEntity() {
        HanyoListKokuhorenJukyushaAriEUCEntity eucEntity = new HanyoListKokuhorenJukyushaAriEUCEntity();
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
        eucEntity.set住所番地方書(null);
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
        eucEntity.set前住所番地方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set処理対象年月(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set履歴番号(null);
        eucEntity.set異動年月日(null);
        eucEntity.set異動区分(null);
        eucEntity.set異動事由(null);
        eucEntity.set給付証記載保険者番号(null);
        eucEntity.set被保険者氏名(null);
        eucEntity.set送付生年月日(null);
        eucEntity.set送付性別(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set老人保健市町村番号(null);
        eucEntity.set老人保健受給者番号(null);
        eucEntity.set公費負担者番号(null);
        eucEntity.set広域保険者番号(null);
        eucEntity.set申請種別(null);
        eucEntity.set変更申請中区分(null);
        eucEntity.set申請日(null);
        eucEntity.setみなし更新認定(null);
        eucEntity.set要介護状態度(null);
        eucEntity.set認定開始日(null);
        eucEntity.set認定終了日(null);
        eucEntity.set居宅計画作成区分(null);
        eucEntity.set居宅支援事業者番号(null);
        eucEntity.set居宅支援事業者名(null);
        eucEntity.setサービス計画適用開始日(null);
        eucEntity.setサービス計画適用終了日(null);
        eucEntity.set訪問通所支給限度基準額(null);
        eucEntity.set訪問通所管理適用開始日(null);
        eucEntity.set訪問通所管理適用終了日(null);
        eucEntity.set短期入所支給限度基準額(null);
        eucEntity.set短期入所管理適用開始日(null);
        eucEntity.set短期入所管理適用終了日(null);
        eucEntity.set公費負担上限額減額の有無(null);
        eucEntity.set償還払化開始日(null);
        eucEntity.set償還払化終了日(null);
        eucEntity.set給付率引下げ開始日(null);
        eucEntity.set給付率引下げ終了日(null);
        eucEntity.set減免申請中区分(null);
        eucEntity.set利用者負担区分(null);
        eucEntity.set利用者負担給付率(null);
        eucEntity.set利用者負担適用開始日(null);
        eucEntity.set利用者負担適用終了日(null);
        eucEntity.set標準負担区分(null);
        eucEntity.set標準負担額(null);
        eucEntity.set標準負担適用開始日(null);
        eucEntity.set標準負担適用終了日(null);
        eucEntity.set特定入所者認定申請中区分コード(null);
        eucEntity.set特定入所介護サービス区分コード(null);
        eucEntity.set課税層の特例減額措置対象(null);
        eucEntity.set食費負担限度額(null);
        eucEntity.set居住費ユ個負担限度額(null);
        eucEntity.set居住費ユ準負担限度額(null);
        eucEntity.set居住費従特養負担限度額(null);
        eucEntity.set居住費従老療負担限度額(null);
        eucEntity.set居住費多床室負担限度額(null);
        eucEntity.set負担限度額適用開始日(null);
        eucEntity.set負担限度額適用終了日(null);
        eucEntity.set社会福祉法人軽減率(null);
        eucEntity.set社会福祉法人軽減率適用開始日(null);
        eucEntity.set社会福祉法人軽減率適用終了日(null);
        eucEntity.set小規模居宅サービス有無(null);
        eucEntity.set保険者番号後期(null);
        eucEntity.set被保険者番号後期(null);
        eucEntity.set保険者番号国保(null);
        eucEntity.set被保険者証番号国保(null);
        eucEntity.set個人番号国保(null);
        eucEntity.set二次予防事業開始日(null);
        eucEntity.set二次予防事業終了日(null);
        eucEntity.set二次予防事業区分(null);
        eucEntity.set住所地特例対象者区分コード(null);
        eucEntity.set施設所在保険者番号(null);
        eucEntity.set住所地特例適用開始日(null);
        eucEntity.set住所地特例適用終了日(null);
        eucEntity.set居宅費新１負担限度額(null);
        eucEntity.set居宅費新２負担限度額(null);
        eucEntity.set居宅費新３負担限度額(null);
        eucEntity.set利用者負担割合有効開始日(null);
        eucEntity.set利用者負担割合有効終了日(null);
        return eucEntity;
    }

    /**
     * HanyoListKokuhorenJukyushaReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param asociation Association
     * @param 導入団体情報 Association
     * @return HanyoListKokuhorenJukyushaReibanNashiEUCEntity
     */
    public HanyoListKokuhorenJukyushaNashiEUCEntity set連番なしEUCEntity(HanyoListKokuhorenJukyushaRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association asociation, Association 導入団体情報) {
        HanyoListKokuhorenJukyushaNashiEUCEntity eucEntity = new HanyoListKokuhorenJukyushaNashiEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
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
            eucEntity.set住所コード(iKojin.get住所().get町域コード().value());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
            eucEntity.set住所番地方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
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
            eucEntity.set前住所番地方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                    get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
        }
        eucEntity.set市町村コード(entity.get市町村コード());
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(asociation.get地方公共団体コード().value());
        eucEntity.set保険者名(asociation.get市町村名());
        eucEntity.set空白(RString.HALF_SPACE);
        eucEntity.set処理対象年月(set日付編集(entity.get送付年月()));
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set履歴番号(new RString(String.valueOf(entity.get履歴番号())));
        eucEntity.set異動年月日(set日付編集(entity.get異動年月日()));
        eucEntity.set異動区分(set異動区分(entity.get異動区分コード()));
        eucEntity.set異動事由(set異動事由(entity.get受給者異動事由()));
        eucEntity.set給付証記載保険者番号(entity.get証記載保険者番号());
        eucEntity.set被保険者氏名(entity.get被保険者氏名カナ());
        eucEntity.set送付生年月日(set日付編集(entity.get生年月日()));
        eucEntity.set送付性別(set性別(entity.get性別コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日()));
        eucEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
        eucEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
        eucEntity.set公費負担者番号(entity.get公費負担者番号());
        eucEntity.set広域保険者番号(entity.get広域連合政令市保険者番号());
        eucEntity.set申請種別(set申請種別(entity.get申請種別コード()));
        eucEntity.set変更申請中区分(set変更申請中区分(entity.get変更申請中区分コード()));
        eucEntity.set申請日(set日付編集(entity.get申請年月日()));
        eucEntity.setみなし更新認定(setみなし更新認定(entity.getみなし要介護状態区分コード()));
        eucEntity.set要介護状態度(set要介護状態(entity.get要介護状態区分コード()));
        eucEntity.set認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set居宅計画作成区分(set居宅計画作成区分(entity.get居宅サービス計画作成区分コード()));
        eucEntity.set居宅支援事業者番号(entity.get居宅介護支援事業所番号());
        eucEntity.set居宅支援事業者名(entity.get事業者名称());
        eucEntity.setサービス計画適用開始日(set日付編集(entity.get居宅サービス計画適用開始年月日()));
        eucEntity.setサービス計画適用終了日(set日付編集(entity.get居宅サービス計画適用終了年月日()));
        eucEntity.set訪問通所支給限度基準額(new RString(String.valueOf(entity.get訪問通所サービス支給限度基準額())));
        eucEntity.set訪問通所管理適用開始日(set日付編集(entity.get訪問通所サービス上限管理適用期間開始年月日()));
        eucEntity.set訪問通所管理適用終了日(set日付編集(entity.get訪問通所サービス上限管理適用期間終了年月日()));
        eucEntity.set短期入所支給限度基準額(new RString(String.valueOf(entity.get短期入所サービス支給限度基準額())));
        eucEntity.set短期入所管理適用開始日(set日付編集(entity.get短期入所サービス上限管理適用期間開始年月日()));
        eucEntity.set短期入所管理適用終了日(set日付編集(entity.get短期入所サービス上限管理適用期間終了年月日()));
        eucEntity.set公費負担上限額減額の有無(set公費負担上限額減額の有無(entity.is公費負担上限額減額有フラグ()));
        eucEntity.set償還払化開始日(set日付編集(entity.get償還払化開始年月日()));
        eucEntity.set償還払化終了日(set日付編集(entity.get償還払化終了年月日()));
        eucEntity.set給付率引下げ開始日(set日付編集(entity.get給付率引下げ開始年月日()));
        eucEntity.set給付率引下げ終了日(set日付編集(entity.get給付率引下げ終了年月日()));
        eucEntity.set減免申請中区分(set減免申請中区分(entity.get減免申請中区分コード()));
        eucEntity.set利用者負担区分(set利用者負担区分(entity.get利用者負担区分コード()));
        eucEntity.set利用者負担給付率(new RString(String.valueOf(entity.get給付率())));
        eucEntity.set利用者負担適用開始日(set日付編集(entity.get適用開始年月日()));
        eucEntity.set利用者負担適用終了日(set日付編集(entity.get適用終了年月日()));
        eucEntity.set標準負担区分(set標準負担区分(entity.get標準負担区分コード()));
        eucEntity.set標準負担額(new RString(entity.get負担額()));
        eucEntity.set標準負担適用開始日(set日付編集(entity.get負担額適用開始年月日()));
        eucEntity.set標準負担適用終了日(set日付編集(entity.get負担額適用終了年月日()));
        eucEntity.set特定入所者認定申請中区分コード(set特定入所者認定申請中区分(entity.get特定入所者認定申請中区分コード()));
        eucEntity.set特定入所介護サービス区分コード(set特定入所介護サービス区分(entity.get特定入所者介護サービス区分コード()));
        eucEntity.set課税層の特例減額措置対象(set課税層の特例減額措置対象(entity.get課税層の特例減額措置対象フラグ()));
        eucEntity.set食費負担限度額(entity.get食費負担限度額());
        eucEntity.set居住費ユ個負担限度額(entity.get居住費ユニット型個室負担限度額());
        eucEntity.set居住費ユ準負担限度額(entity.get居住費ユニット型準個室負担限度額());
        eucEntity.set居住費従特養負担限度額(entity.get居住費従来型個室特養等負担限度額());
        eucEntity.set居住費従老療負担限度額(entity.get居住費従来型個室老健療養等負担限度額());
        eucEntity.set居住費多床室負担限度額(entity.get居住費多床室負担限度額());
        eucEntity.set負担限度額適用開始日(set日付編集(entity.get負担限度額適用開始年月日()));
        eucEntity.set負担限度額適用終了日(set日付編集(entity.get負担限度額適用終了年月日()));
        eucEntity.set社会福祉法人軽減率(entity.get軽減率());
        eucEntity.set社会福祉法人軽減率適用開始日(set日付編集(entity.get軽減率適用開始年月日()));
        eucEntity.set社会福祉法人軽減率適用終了日(set日付編集(entity.get軽減率適用終了年月日()));
        eucEntity.set小規模居宅サービス有無(set小規模居宅サービス有無(entity.is小多機能居宅介護利用開始月利用有フラグ()));
        eucEntity.set保険者番号後期(entity.get後期高齢者医療保険者番号());
        eucEntity.set被保険者番号後期(entity.get後期高齢者医療被保険者番号());
        eucEntity.set保険者番号国保(entity.get国民健康保険保険者番号());
        eucEntity.set被保険者証番号国保(entity.get国民健康保険被保険者証番号());
        eucEntity.set個人番号国保(entity.get国民健康保険個人番号());
        eucEntity.set二次予防事業開始日(set日付編集(entity.get二次予防事業有効期間開始年月日()));
        eucEntity.set二次予防事業終了日(set日付編集(entity.get二次予防事業有効期間終了年月日()));
        eucEntity.set二次予防事業区分(set二次予防事業区分(entity.get二次予防事業区分コード()));
        eucEntity.set住所地特例対象者区分コード(entity.get住所地特例対象者区分コード());
        eucEntity.set施設所在保険者番号(entity.get施設所在保険者番号());
        eucEntity.set住所地特例適用開始日(set日付編集(entity.get住所地特例適用開始日()));
        eucEntity.set住所地特例適用終了日(set日付編集(entity.get住所地特例適用終了日()));
        eucEntity.set居宅費新１負担限度額(entity.get居宅費新1負担限度額());
        eucEntity.set居宅費新２負担限度額(entity.get居宅費新2負担限度額());
        eucEntity.set居宅費新３負担限度額(entity.get居宅費新3負担限度額());
        eucEntity.set利用者負担割合有効開始日(set日付編集(entity.get利用者負担割合有効開始日()));
        eucEntity.set利用者負担割合有効終了日(set日付編集(entity.get利用者負担割合有効終了日()));
        return eucEntity;
    }

    /**
     * HanyoListKokuhorenJukyushaReibanNashiEUCEntityの設定クラスです。
     *
     * @return HanyoListKokuhorenJukyushaReibanNashiEUCEntity
     */
    public HanyoListKokuhorenJukyushaNashiEUCEntity set連番なしEUCEntity() {
        HanyoListKokuhorenJukyushaNashiEUCEntity eucEntity = new HanyoListKokuhorenJukyushaNashiEUCEntity();
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
        eucEntity.set住所番地方書(null);
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
        eucEntity.set前住所番地方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set処理対象年月(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set履歴番号(null);
        eucEntity.set異動年月日(null);
        eucEntity.set異動区分(null);
        eucEntity.set異動事由(null);
        eucEntity.set給付証記載保険者番号(null);
        eucEntity.set被保険者氏名(null);
        eucEntity.set送付生年月日(null);
        eucEntity.set送付性別(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set老人保健市町村番号(null);
        eucEntity.set老人保健受給者番号(null);
        eucEntity.set公費負担者番号(null);
        eucEntity.set広域保険者番号(null);
        eucEntity.set申請種別(null);
        eucEntity.set変更申請中区分(null);
        eucEntity.set申請日(null);
        eucEntity.setみなし更新認定(null);
        eucEntity.set要介護状態度(null);
        eucEntity.set認定開始日(null);
        eucEntity.set認定終了日(null);
        eucEntity.set居宅計画作成区分(null);
        eucEntity.set居宅支援事業者番号(null);
        eucEntity.set居宅支援事業者名(null);
        eucEntity.setサービス計画適用開始日(null);
        eucEntity.setサービス計画適用終了日(null);
        eucEntity.set訪問通所支給限度基準額(null);
        eucEntity.set訪問通所管理適用開始日(null);
        eucEntity.set訪問通所管理適用終了日(null);
        eucEntity.set短期入所支給限度基準額(null);
        eucEntity.set短期入所管理適用開始日(null);
        eucEntity.set短期入所管理適用終了日(null);
        eucEntity.set公費負担上限額減額の有無(null);
        eucEntity.set償還払化開始日(null);
        eucEntity.set償還払化終了日(null);
        eucEntity.set給付率引下げ開始日(null);
        eucEntity.set給付率引下げ終了日(null);
        eucEntity.set減免申請中区分(null);
        eucEntity.set利用者負担区分(null);
        eucEntity.set利用者負担給付率(null);
        eucEntity.set利用者負担適用開始日(null);
        eucEntity.set利用者負担適用終了日(null);
        eucEntity.set標準負担区分(null);
        eucEntity.set標準負担額(null);
        eucEntity.set標準負担適用開始日(null);
        eucEntity.set標準負担適用終了日(null);
        eucEntity.set特定入所者認定申請中区分コード(null);
        eucEntity.set特定入所介護サービス区分コード(null);
        eucEntity.set課税層の特例減額措置対象(null);
        eucEntity.set食費負担限度額(null);
        eucEntity.set居住費ユ個負担限度額(null);
        eucEntity.set居住費ユ準負担限度額(null);
        eucEntity.set居住費従特養負担限度額(null);
        eucEntity.set居住費従老療負担限度額(null);
        eucEntity.set居住費多床室負担限度額(null);
        eucEntity.set負担限度額適用開始日(null);
        eucEntity.set負担限度額適用終了日(null);
        eucEntity.set社会福祉法人軽減率(null);
        eucEntity.set社会福祉法人軽減率適用開始日(null);
        eucEntity.set社会福祉法人軽減率適用終了日(null);
        eucEntity.set小規模居宅サービス有無(null);
        eucEntity.set保険者番号後期(null);
        eucEntity.set被保険者番号後期(null);
        eucEntity.set保険者番号国保(null);
        eucEntity.set被保険者証番号国保(null);
        eucEntity.set個人番号国保(null);
        eucEntity.set二次予防事業開始日(null);
        eucEntity.set二次予防事業終了日(null);
        eucEntity.set二次予防事業区分(null);
        eucEntity.set住所地特例対象者区分コード(null);
        eucEntity.set施設所在保険者番号(null);
        eucEntity.set住所地特例適用開始日(null);
        eucEntity.set住所地特例適用終了日(null);
        eucEntity.set居宅費新１負担限度額(null);
        eucEntity.set居宅費新２負担限度額(null);
        eucEntity.set居宅費新３負担限度額(null);
        eucEntity.set利用者負担割合有効開始日(null);
        eucEntity.set利用者負担割合有効終了日(null);
        return eucEntity;
    }

    private RString set小規模居宅サービス有無(boolean 小多機能居宅介護利用開始月利用有フラグ) {
        if (小多機能居宅介護利用開始月利用有フラグ) {
            return new RString("有り");
        }
        return new RString("無し");
    }

    private RString set公費負担上限額減額の有無(boolean 公費負担上限額減額有フラグ) {
        if (公費負担上限額減額有フラグ) {
            return new RString("有り");
        }
        return new RString("無し");
    }

    private RString set二次予防事業区分(RString 二次予防事業区分コード) {
        if (RString.isNullOrEmpty(二次予防事業区分コード)) {
            return RString.EMPTY;
        }
        RString 二次予防事業区分;
        try {
            二次予防事業区分 = JukyushaIF_NijiyoboJigyoKubunCode.toValue(二次予防事業区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 二次予防事業区分;
    }

    private RString set課税層の特例減額措置対象(RString 課税層の特例減額措置対象コード) {
        if (RString.isNullOrEmpty(課税層の特例減額措置対象コード)) {
            return RString.EMPTY;
        }
        RString 課税層の特例減額措置対象;
        try {
            課税層の特例減額措置対象 = JukyushaIF_TokureiGengakuSochiTaisho.toValue(課税層の特例減額措置対象コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 課税層の特例減額措置対象;
    }

    private RString set特定入所介護サービス区分(RString 特定入所介護サービス区分コード) {
        if (RString.isNullOrEmpty(特定入所介護サービス区分コード)) {
            return RString.EMPTY;
        }
        RString 特定入所介護サービス区分;
        try {
            特定入所介護サービス区分 = JukyushaIF_ServiceKubunCode.toValue(特定入所介護サービス区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 特定入所介護サービス区分;
    }

    private RString set特定入所者認定申請中区分(RString 特定入所者認定申請中区分コード) {
        if (RString.isNullOrEmpty(特定入所者認定申請中区分コード)) {
            return RString.EMPTY;
        }
        RString 特定入所者認定申請中区分;
        try {
            特定入所者認定申請中区分 = JukyushaIF_GemmenShinseichuKubunCode.toValue(特定入所者認定申請中区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 特定入所者認定申請中区分;
    }

    private RString set標準負担区分(RString 標準負担区分コード) {
        if (RString.isNullOrEmpty(標準負担区分コード)) {
            return RString.EMPTY;
        }
        RString 標準負担区分;
        try {
            標準負担区分 = JukyushaIF_HyojunFutanKubunCode.toValue(標準負担区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 標準負担区分;
    }

    private RString set利用者負担区分(RString 利用者負担区分コード) {
        if (RString.isNullOrEmpty(利用者負担区分コード)) {
            return RString.EMPTY;
        }
        RString 利用者負担区分;
        try {
            利用者負担区分 = JukyushaIF_RiyoshaFutanKubunCode.toValue(利用者負担区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 利用者負担区分;
    }

    private RString set減免申請中区分(RString 減免申請中区分コード) {
        if (RString.isNullOrEmpty(減免申請中区分コード)) {
            return RString.EMPTY;
        }
        RString 減免申請中区分;
        try {
            減免申請中区分 = JukyushaIF_GemmenShinseichuKubunCode.toValue(減免申請中区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 減免申請中区分;
    }

    private RString set居宅計画作成区分(RString 居宅計画作成区分コード) {
        if (RString.isNullOrEmpty(居宅計画作成区分コード)) {
            return RString.EMPTY;
        }
        RString 居宅計画作成区分;
        try {
            居宅計画作成区分 = JukyushaIF_KeikakuSakuseiKubunCode.toValue(居宅計画作成区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 居宅計画作成区分;
    }

    private RString set要介護状態(RString 要介護状態区分コード) {
        if (RString.isNullOrEmpty(要介護状態区分コード)) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubun.toValue(要介護状態区分コード).get名称();
    }

    private RString setみなし更新認定(RString みなし更新認定コード) {
        if (RString.isNullOrEmpty(みなし更新認定コード)) {
            return RString.EMPTY;
        }
        Map<RString, RString> minashikoshin = new HashMap<>();
        minashikoshin.put(通常認定, new RString("通常認定"));
        minashikoshin.put(旧措置入所者, new RString("旧措置入所者"));
        minashikoshin.put(やむを得ない理由, new RString("やむを得ない理由"));
        if (minashikoshin.containsKey(みなし更新認定コード)) {
            return minashikoshin.get(みなし更新認定コード);
        }
        return RString.EMPTY;
    }

    private RString set変更申請中区分(RString 変更申請中区分コード) {
        if (RString.isNullOrEmpty(変更申請中区分コード)) {
            return RString.EMPTY;
        }
        RString 変更申請中区分;
        try {
            変更申請中区分 = JukyushaIF_HenkoShinseichuKubunCode.toValue(変更申請中区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 変更申請中区分;
    }

    private RString set申請種別(RString 申請種別コード) {
        if (RString.isNullOrEmpty(申請種別コード)) {
            return RString.EMPTY;
        }
        RString 申請種別;
        try {
            申請種別 = JukyushaIF_ShinseiShubetsuCode.toValue(申請種別コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 申請種別;
    }

    private RString set性別(RString 性別コード) {
        if (RString.isNullOrEmpty(性別コード)) {
            return RString.EMPTY;
        }
        return Seibetsu.toValue(性別コード).get名称();
    }

    private RString set異動区分(RString 異動区分コード) {
        if (RString.isNullOrEmpty(異動区分コード)) {
            return RString.EMPTY;
        }
        RString 異動区分;
        try {
            異動区分 = JukyushaIF_IdoKubunCode.toValue(異動区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 異動区分;
    }

    private RString set異動事由(RString 異動事由コード) {
        if (RString.isNullOrEmpty(異動事由コード)) {
            return RString.EMPTY;
        }
        RString 異動事由;
        try {
            異動事由 = JukyushaIF_JukyushaIdoJiyu.toValue(異動事由コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return 異動事由;
    }

    private RString set日付編集(RString value) {
        RString 日付 = RString.EMPTY;
        if (processParameter.is日付編集() && !RString.isNullOrEmpty(value)) {
            日付 = set日付編集(日付, value);
        }
        return 日付;
    }

    private RString set日付編集(RString 日付, RString value) {
        日付 = value;
        if (value.length() == LENGTH) {
            if (FlexibleYearMonth.canConvert(value)) {
                日付 = new FlexibleYearMonth(value).seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            }
        } else if (FlexibleDate.canConvert(value)) {
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
        builder.append(new RString("　"));
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
            市町村名builder.append(new RString(" "));
            市町村名builder.append(processParameter.get保険者名());
            jokenBuilder.append(市町村名builder.toRString());
        }
        出力条件List.add(jokenBuilder.toRString());
        出力条件List.add(RString.EMPTY);
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("日付抽出区分："));
        jokenBuilder.append(HizukeChushutsuKubun.toValue(processParameter.get日付抽出区分()).get名称());
        出力条件List.add(jokenBuilder.toRString());
        if (HizukeChushutsuKubun.範囲指定.getコード().equals(processParameter.get日付抽出区分())) {
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("処理対象年月："));
            出力条件List.add(get期間(jokenBuilder, processParameter.get処理対象年月From(), processParameter.get処理対象年月To()));
            jokenBuilder = new RStringBuilder();
            jokenBuilder.append(new RString("異動年月　　　："));
            出力条件List.add(get期間(jokenBuilder, processParameter.get異動年月From(), processParameter.get異動年月To()));
            if (processParameter.is各異動月の最新のみ()) {
                出力条件List.add(new RString("■各異動月の最新情報のみ抽出する"));
            } else {
                出力条件List.add(RString.EMPTY);
            }
        }
        出力条件List.add(RString.EMPTY);
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append("異動区分：　");
        出力条件List.add(get異動区分(jokenBuilder));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append("みなし要介護区分：　");
        出力条件List.add(getみなし要介護区分(jokenBuilder));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append("事業者番号：　").append(processParameter.get事業者番号());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append("公費負担上限額減額：　");
        出力条件List.add(get公費負担上限額減額(jokenBuilder));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append("利用者負担区分：　");
        出力条件List.add(get利用者負担区分(jokenBuilder));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append("特定入所者サービス区分：　");
        出力条件List.add(get特定入所者サービス区分(jokenBuilder));
        出力条件List.add(RString.EMPTY);
        if (processParameter.is削除含める()) {
            出力条件List.add(new RString("■削除された情報を含める"));
        } else {
            出力条件List.add(RString.EMPTY);
        }
        return 出力条件List;
    }

    private RString get特定入所者サービス区分(RStringBuilder jokenBuilder) {
        RString 適用なし = new RString("□適用なし　　");
        RString 受給者 = new RString("□受給者　　　　　");
        RString 旧措置者 = new RString("□旧措置者");
        for (RString 特定入所者サービス区分 : processParameter.get特定入所者サービス区分s()) {
            if (new RString("*").equals(特定入所者サービス区分)) {
                適用なし = new RString("■適用なし　　");
            } else if (JukyushaIF_ServiceKubunCode.通常の受給者.getコード().equals(特定入所者サービス区分)) {
                受給者 = new RString("■受給者　　");
            } else if (JukyushaIF_ServiceKubunCode.旧措置入所者.getコード().equals(特定入所者サービス区分)) {
                旧措置者 = new RString("■旧措置者");
            }
        }
        return jokenBuilder.append(適用なし).append(受給者).append(旧措置者).toRString();
    }

    private RString get利用者負担区分(RStringBuilder jokenBuilder) {
        RString 適用なし = new RString("□適用なし　　");
        RString 利用者負担 = new RString("□利用者負担　　　");
        RString 旧措置利用者負担 = new RString("□旧措置利用者負担");
        for (RString 利用者負担区分 : processParameter.get利用者負担区分s()) {
            if (new RString("*").equals(利用者負担区分)) {
                適用なし = new RString("■適用なし　　");
            } else if (JukyushaIF_RiyoshaFutanKubunCode.利用者負担.getコード().equals(利用者負担区分)) {
                利用者負担 = new RString("■利用者負担　　　");
            } else if (JukyushaIF_RiyoshaFutanKubunCode.旧措置入所者利用者負担.getコード().equals(利用者負担区分)) {
                旧措置利用者負担 = new RString("■旧措置利用者負担");
            }
        }
        return jokenBuilder.append(適用なし).append(利用者負担).append(旧措置利用者負担).toRString();
    }

    private RString get公費負担上限額減額(RStringBuilder jokenBuilder) {
        List<Boolean> 公費負担上限額減額s = processParameter.get公費負担上限額減額s();
        if (公費負担上限額減額s.size() == 2) {
            jokenBuilder.append(new RString("すべて"));
        } else if (!公費負担上限額減額s.isEmpty()) {
            if (公費負担上限額減額s.get(0)) {
                jokenBuilder.append(new RString("あり（生保）"));
            } else {
                jokenBuilder.append(new RString("なし"));
            }
        }
        return jokenBuilder.toRString();
    }

    private RString getみなし要介護区分(RStringBuilder jokenBuilder) {
        RString 通常認定値 = new RString("□通常認定　　");
        RString 旧措置入所者値 = new RString("□旧措置入所者　　");
        RString やむを得ない理由値 = new RString("□やむを得ない理由");
        for (RString みなし要介護区分 : processParameter.getみなし要介護区分s()) {
            if (通常認定.equals(みなし要介護区分)) {
                通常認定値 = new RString("■通常認定　　");
            } else if (旧措置入所者.equals(みなし要介護区分)) {
                旧措置入所者値 = new RString("■旧措置入所者　　");
            } else if (やむを得ない理由.equals(みなし要介護区分)) {
                やむを得ない理由値 = new RString("■やむを得ない理由");
            }
        }
        return jokenBuilder.append(通常認定値).append(旧措置入所者値).append(やむを得ない理由値).toRString();
    }

    private RString get異動区分(RStringBuilder jokenBuilder) {
        RString 新規 = new RString("□新規　　");
        RString 変更 = new RString("□変更　　");
        RString 終了 = new RString("□終了");
        for (RString 異動区分 : processParameter.get異動区分s()) {
            if (JukyushaIF_IdoKubunCode.新規.getコード().equals(異動区分)) {
                新規 = new RString("■新規　　");
            } else if (JukyushaIF_IdoKubunCode.変更.getコード().equals(異動区分)) {
                変更 = new RString("■変更　　");
            } else if (JukyushaIF_IdoKubunCode.終了.getコード().equals(異動区分)) {
                終了 = new RString("■終了");
            }
        }
        return jokenBuilder.append(新規).append(変更).append(終了).toRString();
    }

    private RString get期間(RStringBuilder jokenBuilder, RString fromYMD, RString toYMD) {
        if (!RString.isNullOrEmpty(fromYMD)) {
            jokenBuilder.append(new FlexibleDate(fromYMD).getYearMonth().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        jokenBuilder.append(new RString("　～　"));
        if (!RString.isNullOrEmpty(toYMD)) {
            jokenBuilder.append(new FlexibleDate(toYMD).getYearMonth().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        return jokenBuilder.toRString();
    }

    /**
     * MybatisParameterを設定するメッソドです。
     *
     * @param 出力順 出力順
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public HanyoListKokuhorenJukyushaMybatisParameter createMybatisParameter(RString 出力順) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return HanyoListKokuhorenJukyushaMybatisParameter.createMybatisParameter(processParameter.get保険者コード(),
                processParameter.get市町村コード(),
                processParameter.get日付抽出区分(),
                processParameter.get処理対象年月From(),
                processParameter.get処理対象年月To(),
                processParameter.get異動年月From(),
                processParameter.get異動年月To(),
                processParameter.is各異動月の最新のみ(),
                processParameter.get異動区分s(),
                processParameter.getみなし要介護区分s(),
                processParameter.get事業者番号(),
                processParameter.get公費負担上限額減額s(),
                processParameter.get利用者負担区分s(),
                processParameter.get特定入所者サービス区分s(),
                processParameter.is削除含める(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                出力順);
    }

    /**
     * 帳票分類ID「DBC701004_HanyoListKokuhorenJukyusha」汎用リスト　国保連受給者 出力順設定可能項目です。
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
        市町村コード(new RString("0016"), new RString(""), new RString("市町村コード")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""), new RString("証記載保険者番号")),
        /**
         * 異動年月日
         */
        異動年月日(new RString("0017"), new RString(""), new RString("異動年月日")),
        /**
         * 計画適用開始日
         */
        計画適用開始日(new RString("0409"), new RString(""), new RString("居宅サービス計画適用開始年月日"));
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
