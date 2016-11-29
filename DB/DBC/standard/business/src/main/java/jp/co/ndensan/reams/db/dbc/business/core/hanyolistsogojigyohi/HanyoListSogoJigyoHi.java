/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hanyolistsogojigyohi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.keikoku.KeikokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.JigyoshoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistsogojigyo.HanyoListSogoJigyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsogojigyohi.HanyoListSogoJigyoHiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsogojigyohi.HanyoListSogoJigyoHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity;
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
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(総合事業費情報)のbusinessクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListSogoJigyoHi {

    private static final RString 基本情報 = new RString("基本情報のみ");
    private static final RString 基本明細情報 = new RString("基本情報＋明細情報");
    private static final RString 基本集計情報 = new RString("基本情報＋集計情報");
    private static final RString 基本ケアマネジメント情報 = new RString("基本情報＋ケアマネジメント費情報");
    private static final RString サービス種類_すべて = new RString("Empty");
    private HanyoListSogoJigyoHiProcessParameter processParameter;
    private List<PersonalData> personalDataList;

    /**
     * コンストラクタです。
     *
     * @param processParameter processParameter
     */
    public HanyoListSogoJigyoHi(HanyoListSogoJigyoHiProcessParameter processParameter) {
        this.processParameter = processParameter;
        personalDataList = new ArrayList<>();
    }

    /**
     * HanyoListSogoJigyoHiKiHonReibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 連番 連番
     * @param 導入団体情報 Association
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonReibanAriEUCEntity set連番基本ありEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報, int 連番) {
        HanyoListSogoJigyoHiKiHonReibanAriEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonReibanAriEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set給付実績情報作成区分(KyufukanrihyoSakuseiKubun.toValue(entity.get給付実績情報作成区分コード()).get名称());
        eucEntity.set給付実績区分(KyufuJissekiKubun.toValue(entity.get給付実績区分()).get名称());
        eucEntity.set給付証記載保険者番号(entity.get証記載保険者番号());
        eucEntity.setサービス提供年月(set年月(entity.getサービス提供年月()));
        eucEntity.set給付実績事業者番号(entity.get事業所番号());
        if (RString.isNullOrEmpty(entity.get事業者名称())) {
            eucEntity.set給付実績事業者名(RString.EMPTY);
        } else {
            eucEntity.set給付実績事業者名(entity.get事業者名称());
        }
        eucEntity.set整理番号(entity.get整理番号());
        eucEntity.set給付実績生年月日(set日付編集(entity.get生年月日()));
        eucEntity.set給付実績性別(Seibetsu.toValue(entity.get性別コード()).get名称());
        eucEntity.set給付実績要介護状態区分(YokaigoJotaiKubun.toValue(entity.get要介護状態区分コード()).get名称());
        eucEntity.set給付実績認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set給付実績認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
        eucEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
        eucEntity.set保険者番号後期(entity.get保険者番号後期());
        eucEntity.set被保険者番号後期(entity.get被保険者番号後期());
        eucEntity.set保険者番号国保(entity.get保険者番号国保());
        eucEntity.set被保険者証番号国保(entity.get被保険者証番号国保());
        eucEntity.set個人番号国保(entity.get個人番号国保());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @param 連番 連番
     * @return HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity set連番基本明細ありEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報, int 連番) {
        HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.setサービス種類コード(entity.get明細サービス種類コード());
        eucEntity.setサービス種類名称(entity.get明細サービス種類名称());
        eucEntity.setサービス項目コード(entity.get明細サービス項目コード());
        eucEntity.setサービス項目名称(entity.get明細サービス名称());
        eucEntity.set点数(entity.get明細単位数());
        eucEntity.set日数回数(entity.get明細日数回数());
        eucEntity.setサービス点数(entity.get明細サービス単位数());
        eucEntity.set摘要(entity.get明細摘要());
        eucEntity.set後点数(entity.get明細後単位数());
        eucEntity.set後日数回数(entity.get明細後日数回数());
        eucEntity.set後サービス点数(entity.get明細後サービス単位数());
        eucEntity.set再審査回数(entity.get明細再審査回数());
        eucEntity.set過誤回数(entity.get明細過誤回数());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @param 連番 連番
     * @return HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity set連番基本集計ありEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報, int 連番) {
        HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.setサービス種類コード(entity.get集計サービス種類コード());
        eucEntity.setサービス種類名称(entity.get集計サービス種類名称());
        eucEntity.setサービス実日数(entity.get集計サービス実日数());
        eucEntity.set計画点数(entity.get集計計画単位数());
        eucEntity.set限度額管理対象点数(entity.get集計限度額管理対象単位数());
        eucEntity.set限度額管理対象外点数(entity.get集計限度額管理対象外単位数());
        eucEntity.set請求点数合計(entity.get集計保険単位数合計());
        eucEntity.set請求点数単価(entity.get集計保険単位数単価());
        eucEntity.set請求額(entity.get集計保険請求額());
        eucEntity.set利用者負担額(entity.get集計保険利用者負担額());
        eucEntity.set後点数合計(entity.get集計後単位数合計());
        eucEntity.set後保険請求分請求額(entity.get集計後保険請求分請求額());
        eucEntity.set再審査回数(entity.get集計再審査回数());
        eucEntity.set過誤回数(entity.get集計過誤回数());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @param 連番 連番
     * @return HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity set連番基本マネジありEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報, int 連番) {
        HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.set指定基準該当事業者区分(JigyoshoKubun.toValue(entity.getケアマネジメント費指定基準該当事業所区分()).get名称());
        eucEntity.set単位数単価(entity.getケアマネジメント費単位数単価());
        eucEntity.setサービスコード(entity.getケアマネジメント費サービスコード());
        eucEntity.setサービス名称(entity.getケアマネジメント費サービス種類名称());
        eucEntity.set単位数(entity.getケアマネジメント費単位数());
        eucEntity.set回数(entity.getケアマネジメント費回数());
        eucEntity.setサービス単位数(entity.getケアマネジメント費サービス単位数());
        eucEntity.setサービス単位数合計(entity.getケアマネジメント費サービス単位数合計());
        eucEntity.set請求金額(entity.getケアマネジメント費請求金額());
        eucEntity.set摘要(entity.getケアマネジメント費摘要());
        eucEntity.set利用者負担額(entity.getケアマネジメント費利用者負担額());
        eucEntity.set後単位数(entity.getケアマネジメント費後単位数());
        eucEntity.set後回数(entity.getケアマネジメント費後回数());
        eucEntity.set後サービス単位数(entity.getケアマネジメント費後サービス単位数());
        eucEntity.set後サービス単位数合計(entity.getケアマネジメント費後サービス単位数合計());
        eucEntity.set後請求金額(entity.getケアマネジメント費後請求金額());
        eucEntity.set後利用者負担額(entity.getケアマネジメント費後利用者負担額());
        eucEntity.set再審査回数(entity.getケアマネジメント費再審査回数());
        eucEntity.set過誤回数(entity.getケアマネジメント費過誤回数());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity HanyoListSogoJigyoHiRelateEntity
     * @param 市町村名MasterMap Map<RString, KoseiShichosonMaster>
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @return HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity set連番基本なしEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報) {
        HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set給付実績情報作成区分(KyufukanrihyoSakuseiKubun.toValue(entity.get給付実績情報作成区分コード()).get名称());
        eucEntity.set給付実績区分(KyufuJissekiKubun.toValue(entity.get給付実績区分()).get名称());
        eucEntity.set給付証記載保険者番号(entity.get証記載保険者番号());
        eucEntity.setサービス提供年月(set年月(entity.getサービス提供年月()));
        eucEntity.set給付実績事業者番号(entity.get事業所番号());
        if (RString.isNullOrEmpty(entity.get事業者名称())) {
            eucEntity.set給付実績事業者名(RString.EMPTY);
        } else {
            eucEntity.set給付実績事業者名(entity.get事業者名称());
        }
        eucEntity.set整理番号(entity.get整理番号());
        eucEntity.set給付実績生年月日(set日付編集(entity.get生年月日()));
        eucEntity.set給付実績性別(Seibetsu.toValue(entity.get性別コード()).get名称());
        eucEntity.set給付実績要介護状態区分(YokaigoJotaiKubun.toValue(entity.get要介護状態区分コード()).get名称());
        eucEntity.set給付実績認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set給付実績認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set老人保健市町村番号(entity.get老人保健市町村番号());
        eucEntity.set老人保健受給者番号(entity.get老人保健受給者番号());
        eucEntity.set保険者番号後期(entity.get保険者番号後期());
        eucEntity.set被保険者番号後期(entity.get被保険者番号後期());
        eucEntity.set保険者番号国保(entity.get保険者番号国保());
        eucEntity.set被保険者証番号国保(entity.get被保険者証番号国保());
        eucEntity.set個人番号国保(entity.get個人番号国保());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @return HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity set連番基本明細なしEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報) {
        HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.setサービス種類コード(entity.get明細サービス種類コード());
        eucEntity.setサービス種類名称(entity.get明細サービス種類名称());
        eucEntity.setサービス項目コード(entity.get明細サービス項目コード());
        eucEntity.setサービス項目名称(entity.get明細サービス名称());
        eucEntity.set点数(entity.get明細単位数());
        eucEntity.set日数回数(entity.get明細日数回数());
        eucEntity.setサービス点数(entity.get明細サービス単位数());
        eucEntity.set摘要(entity.get明細摘要());
        eucEntity.set後点数(entity.get明細後単位数());
        eucEntity.set後日数回数(entity.get明細後日数回数());
        eucEntity.set後サービス点数(entity.get明細後サービス単位数());
        eucEntity.set再審査回数(entity.get明細再審査回数());
        eucEntity.set過誤回数(entity.get明細過誤回数());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @return HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity set連番基本集計なしEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報) {
        HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.setサービス種類コード(entity.get集計サービス種類コード());
        eucEntity.setサービス種類名称(entity.get集計サービス種類名称());
        eucEntity.setサービス実日数(entity.get集計サービス実日数());
        eucEntity.set計画点数(entity.get集計計画単位数());
        eucEntity.set限度額管理対象点数(entity.get集計限度額管理対象単位数());
        eucEntity.set限度額管理対象外点数(entity.get集計限度額管理対象外単位数());
        eucEntity.set請求点数合計(entity.get集計保険単位数合計());
        eucEntity.set請求点数単価(entity.get集計保険単位数単価());
        eucEntity.set請求額(entity.get集計保険請求額());
        eucEntity.set利用者負担額(entity.get集計保険利用者負担額());
        eucEntity.set後点数合計(entity.get集計後単位数合計());
        eucEntity.set後保険請求分請求額(entity.get集計後保険請求分請求額());
        eucEntity.set再審査回数(entity.get集計再審査回数());
        eucEntity.set過誤回数(entity.get集計過誤回数());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     * @param 導入団体情報 Association
     * @return HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity
     */
    public HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity set連番基本マネジなしEUCEntity(HanyoListSogoJigyoHiRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報) {
        HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity eucEntity = new HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity();
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
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.EMPTY);
        eucEntity.set指定基準該当事業者区分(JigyoshoKubun.toValue(entity.getケアマネジメント費指定基準該当事業所区分()).get名称());
        eucEntity.set単位数単価(entity.getケアマネジメント費単位数単価());
        eucEntity.setサービスコード(entity.getケアマネジメント費サービスコード());
        eucEntity.setサービス名称(entity.getケアマネジメント費サービス種類名称());
        eucEntity.set単位数(entity.getケアマネジメント費単位数());
        eucEntity.set回数(entity.getケアマネジメント費回数());
        eucEntity.setサービス単位数(entity.getケアマネジメント費サービス単位数());
        eucEntity.setサービス単位数合計(entity.getケアマネジメント費サービス単位数合計());
        eucEntity.set請求金額(entity.getケアマネジメント費請求金額());
        eucEntity.set摘要(entity.getケアマネジメント費摘要());
        eucEntity.set利用者負担額(entity.getケアマネジメント費利用者負担額());
        eucEntity.set後単位数(entity.getケアマネジメント費後単位数());
        eucEntity.set後回数(entity.getケアマネジメント費後回数());
        eucEntity.set後サービス単位数(entity.getケアマネジメント費後サービス単位数());
        eucEntity.set後サービス単位数合計(entity.getケアマネジメント費後サービス単位数合計());
        eucEntity.set後請求金額(entity.getケアマネジメント費後請求金額());
        eucEntity.set後利用者負担額(entity.getケアマネジメント費後利用者負担額());
        eucEntity.set再審査回数(entity.getケアマネジメント費再審査回数());
        eucEntity.set過誤回数(entity.getケアマネジメント費過誤回数());
        eucEntity.set開始年月日(set日付編集(entity.get開始年月日()));
        eucEntity.set中止年月日(set日付編集(entity.get中止年月日()));
        eucEntity.set前保険サービス単位数(entity.get前保険サービス単位数());
        eucEntity.set前保険請求額(entity.get前保険請求額());
        eucEntity.set前保険利用者負担額(entity.get前保険利用者負担額());
        eucEntity.set後保険サービス単位数(entity.get後保険サービス単位数());
        eucEntity.set後保険請求額(entity.get後保険請求額());
        eucEntity.set後保険利用者負担額(entity.get後保険利用者負担額());
        eucEntity.set警告区分(KeikokuKubun.toValue(entity.get警告区分コード()).get名称());
        eucEntity.set審査年月(set年月(entity.get審査年月()));
        eucEntity.set取込年月(set年月(entity.get取込年月()));
        return eucEntity;
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @return List<RString>
     */
    public List<RString> set出力条件() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【抽出対象者】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        if (RString.isNullOrEmpty(processParameter.get保険者コード())) {
            jokenBuilder.append(RString.EMPTY);
        } else if (new RString("000000").equals(processParameter.get保険者コード())) {
            jokenBuilder.append(new RString("保険者："));
            jokenBuilder.append(new RString(" 全市町村"));
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
        jokenBuilder.append(new RString("抽出方法："));
        jokenBuilder.append(set抽出方法());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("サービス提供年月："));
        jokenBuilder.append(setサービス提供年月());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("審査年月："));
        jokenBuilder.append(set審査年月());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("取込年月："));
        jokenBuilder.append(set取込年月());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("事業者コード："));
        if (!RString.isNullOrEmpty(processParameter.get事業者コード())) {
            jokenBuilder.append(new RString("（"));
            jokenBuilder.append(processParameter.get事業者コード());
            jokenBuilder.append(new RString("） "));
            jokenBuilder.append(processParameter.get事業者名());
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        if (!基本情報.equals(processParameter.get抽出方法())) {
            jokenBuilder.append(new RString("サービス種類コード："));
            if (!RString.isNullOrEmpty(processParameter.getサービス種類コード()) && !サービス種類_すべて.equals(processParameter.getサービス種類コード())) {
                jokenBuilder.append(new RString("（"));
                jokenBuilder.append(processParameter.getサービス種類コード());
                jokenBuilder.append(new RString("） "));
                jokenBuilder.append(processParameter.getサービス名称());
            }
            if (サービス種類_すべて.equals(processParameter.getサービス種類コード())) {
                jokenBuilder.append(new RString("すべて"));
            }
        }
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @return AccessLogUUID
     */
    public AccessLogUUID getアクセスログ() {
        return AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
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

    private RString set日付編集(RString value) {
        RString 日付 = RString.EMPTY;
        if (processParameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(value)) {
            日付 = new FlexibleDate(value).seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return 日付;
    }

    private RString set年月(RString date) {
        if (date.isNullOrEmpty()) {
            return RString.EMPTY;
        }
        return new FlexibleDate(date).seireki().separator(Separator.SLASH).fillType(FillType.ZERO).getYearMonth();
    }

    private RStringBuilder set抽出方法() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        if (基本情報.equals(processParameter.get抽出方法())) {
            jokenBuilder.append(new RString("基本情報のみ"));
        } else if (基本明細情報.equals(processParameter.get抽出方法())) {
            jokenBuilder.append(new RString("基本情報＋明細情報"));
        } else if (基本集計情報.equals(processParameter.get抽出方法())) {
            jokenBuilder.append(new RString("基本情報＋集計情報"));
        } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
            jokenBuilder.append(new RString("基本情報＋ケアマネジメント費情報"));
        }
        return jokenBuilder;
    }

    private RStringBuilder setサービス提供年月() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        if (!RString.isNullOrEmpty(processParameter.getサービス提供年月開始年月())
                && !RString.isNullOrEmpty(processParameter.getサービス提供年月終了年月())) {
            jokenBuilder.append(set年月(processParameter.getサービス提供年月開始年月()));
            jokenBuilder.append(new RString("～"));
            jokenBuilder.append(set年月(processParameter.getサービス提供年月終了年月()));
        } else if (!RString.isNullOrEmpty(processParameter.getサービス提供年月開始年月())
                && RString.isNullOrEmpty(processParameter.getサービス提供年月終了年月())) {
            jokenBuilder.append(set年月(processParameter.getサービス提供年月開始年月()));
            jokenBuilder.append(new RString("～"));
        } else if (RString.isNullOrEmpty(processParameter.getサービス提供年月開始年月())
                && !RString.isNullOrEmpty(processParameter.getサービス提供年月終了年月())) {
            jokenBuilder.append(new RString("～"));
            jokenBuilder.append(set年月(processParameter.getサービス提供年月終了年月()));
        }
        return jokenBuilder;
    }

    private RStringBuilder set審査年月() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        if (!RString.isNullOrEmpty(processParameter.get審査年月開始年月())
                && !RString.isNullOrEmpty(processParameter.get審査年月終了年月())) {
            jokenBuilder.append(set年月(processParameter.get審査年月開始年月()));
            jokenBuilder.append(new RString("～"));
            jokenBuilder.append(set年月(processParameter.get審査年月終了年月()));
        } else if (!RString.isNullOrEmpty(processParameter.get審査年月開始年月())
                && RString.isNullOrEmpty(processParameter.get審査年月終了年月())) {
            jokenBuilder.append(set年月(processParameter.get審査年月開始年月()));
            jokenBuilder.append(new RString("～"));
        } else if (RString.isNullOrEmpty(processParameter.get審査年月開始年月())
                && !RString.isNullOrEmpty(processParameter.get審査年月終了年月())) {
            jokenBuilder.append(new RString("～"));
            jokenBuilder.append(set年月(processParameter.get審査年月終了年月()));
        }
        return jokenBuilder;
    }

    private RStringBuilder set取込年月() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        if (!RString.isNullOrEmpty(processParameter.get取込年月開始年月())
                && !RString.isNullOrEmpty(processParameter.get取込年月終了年月())) {
            jokenBuilder.append(set年月(processParameter.get取込年月開始年月()));
            jokenBuilder.append(new RString("～"));
            jokenBuilder.append(set年月(processParameter.get取込年月終了年月()));
        } else if (!RString.isNullOrEmpty(processParameter.get取込年月開始年月())
                && RString.isNullOrEmpty(processParameter.get取込年月終了年月())) {
            jokenBuilder.append(set年月(processParameter.get取込年月開始年月()));
            jokenBuilder.append(new RString("～"));
        } else if (RString.isNullOrEmpty(processParameter.get取込年月開始年月())
                && !RString.isNullOrEmpty(processParameter.get取込年月終了年月())) {
            jokenBuilder.append(new RString("～"));
            jokenBuilder.append(set年月(processParameter.get取込年月終了年月()));
        }
        return jokenBuilder;
    }

    private PersonalData toPersonalData(RString 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    private RString set日付編集(FlexibleDate value) {
        RString 日付 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            if (processParameter.is日付スラッシュ付加()) {
                日付 = value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            } else {
                日付 = new RString(value.toString());
            }
        }
        return 日付;
    }

    /**
     * MybatisParameterを設定するメッソドです。
     *
     * @param 出力順 RString
     * @return HanyoListSogoJigyoMybatisParameter
     */
    public HanyoListSogoJigyoMybatisParameter createMybatisParameter(RString 出力順) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return HanyoListSogoJigyoMybatisParameter.createMybatisParameter(processParameter.get出力順ID(),
                processParameter.get出力順項目ID(),
                processParameter.is項目名付加(),
                processParameter.is連番付加(),
                processParameter.is日付スラッシュ付加(),
                processParameter.get事業者コード(),
                processParameter.getサービス種類コード(),
                processParameter.get保険者コード(),
                processParameter.get抽出方法(),
                processParameter.getサービス提供年月開始年月(),
                processParameter.getサービス提供年月終了年月(),
                processParameter.get審査年月開始年月(),
                processParameter.get審査年月終了年月(),
                processParameter.get取込年月開始年月(),
                processParameter.get取込年月終了年月(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                出力順);
    }

    /**
     * 帳票分類ID「DBC701018_HanyoListSogoJigyoHi」（汎用リスト_総合事業費）出力順設定可能項目です。
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
        証記載保険者番号(new RString("0103"), new RString(""), new RString("\"shoKisaiHokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"hihokenshaNo\"")),
        /**
         * 要介護度
         */
        サービス年月(new RString("0301"), new RString(""), new RString("\"serviceYM\"")),
        /**
         * 有効開始年月
         */
        整理番号(new RString("0305"), new RString(""), new RString("\"seiriNo\"")),
        /**
         * 要介護度
         */
        給付実績事業者(new RString("0352"), new RString(""), new RString("\"kyufuJissekiJigyosha\"")),
        /**
         * 要介護度
         */
        サービス種類(new RString("0308"), new RString(""), new RString("\"serviceShuruiCode\"")),
        /**
         * 要介護度
         */
        サービス項目(new RString("0350"), new RString(""), new RString("\"serviceKomoku\"")),
        /**
         * 要介護度
         */
        サービスコード(new RString("0351"), new RString(""), new RString("\"ketteiServiceCode\""));

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
