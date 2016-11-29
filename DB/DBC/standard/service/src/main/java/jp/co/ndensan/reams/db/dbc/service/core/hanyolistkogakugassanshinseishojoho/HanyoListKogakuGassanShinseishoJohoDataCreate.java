/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hanyolistkogakugassanshinseishojoho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Kokuho_Zokugara;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiJokyoKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKeitai;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_SoshitsuJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_KinyuKikanKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.models.ITennyuMae;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)DataCreate
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public class HanyoListKogakuGassanShinseishoJohoDataCreate {

    private static final RString 住特 = new RString("住特");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString みなし = new RString("みなし");
    private static final RString 受給申請事由_初回申請 = new RString("初回申請　　");
    private static final RString 受給申請事由_再申請内 = new RString("再申請内　　");
    private static final RString 受給申請事由_再申請外 = new RString("再申請外　　");
    private static final RString 受給申請事由_支援から申請 = new RString("支援から申請");
    private static final RString 受給申請事由_区分変更申請 = new RString("区分変更申請");
    private static final RString 受給申請事由_サ変更申請 = new RString("サ変更申請　");
    private static final RString 受給申請事由_施行前申請 = new RString("施行前申請　");
    private static final RString 受給申請事由_追加 = new RString("追加　　　　");
    private static final RString 斜線 = new RString("/");
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
    private static final int INT_20 = 20;
    private static final RString 銀行 = new RString("銀行");

    /**
     * コンストラクタ
     */
    public HanyoListKogakuGassanShinseishoJohoDataCreate() {
    }

    /**
     * createCsvData
     *
     * @param entity HanyoListKogakuGassanShinseishoJohoEntity
     * @param parameter HanyoListKogakuGassanShinseishoJohoProcessParameter
     * @param 連番 Decimal
     * @param 市町村名MasterMap Map<RString, KoseiShichosonMaster>
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @return HanyoListKogakuGassanShinseishoJohoCSVEntity
     */
    public HanyoListKogakuGassanShinseishoJohoCSVEntity createCsvData(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoProcessParameter parameter,
            Decimal 連番, Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity = new HanyoListKogakuGassanShinseishoJohoCSVEntity();
        csvEntity.set連番(numToRString(連番));
        set宛名(entity, csvEntity, parameter, 帳票制御共通, 地方公共団体);
        set宛先(entity, csvEntity);
        set被保険者台帳管理(entity, csvEntity, parameter, 市町村名MasterMap, 地方公共団体);
        set口座情報(entity, csvEntity);
        set高額合算申請書(entity, csvEntity, parameter);
        return csvEntity;
    }

    private void set高額合算申請書(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity,
            HanyoListKogakuGassanShinseishoJohoProcessParameter parameter) {
        csvEntity.set対象年度(entity.get高額合算申請書_対象年度().wareki().toDateString());
        if (entity.get高額合算申請書加入歴_保険者番号() != null) {
            csvEntity.set給付証記載保険者番号(entity.get高額合算申請書加入歴_保険者番号().getColumnValue());
        }
        csvEntity.set整理番号(entity.get高額合算申請書_整理番号());
        csvEntity.set履歴番号(entity.get高額合算申請書_履歴番号());
        if (entity.get高額合算申請書_申請状況区分() != null) {
            csvEntity.set申請状況区分(KaigoGassan_ShinseiJokyoKbn.toValue(entity.get高額合算申請書_申請状況区分()).get名称());
        }
        csvEntity.set申請年月日(dataToRString(entity.get高額合算申請書_申請年月日(), parameter));
        csvEntity.set支給申請書整理番号(entity.get高額合算申請書_支給申請書整理番号());
        csvEntity.set国保支給申請書整理番号(entity.get高額合算申請書_国保支給申請書整理番号());
        if (entity.get高額合算申請書_支給申請区分() != null) {
            csvEntity.set支給申請区分(KaigoGassan_ShinseiKbn.toValue(entity.get高額合算申請書_支給申請区分()).get名称());
        }
        csvEntity.set対象計算期間開始(dataToRString(entity.get高額合算申請書_対象計算期間開始年月日(), parameter));
        csvEntity.set対象計算期間終了(dataToRString(entity.get高額合算申請書_対象計算期間終了年月日(), parameter));
        if (entity.get高額合算申請書_支給申請形態() != null) {
            csvEntity.set支給申請形態(KaigoGassan_ShinseiKeitai.toValue(entity.get高額合算申請書_支給申請形態()).get名称());
        }
        csvEntity.set自己負担額証明書交付申請の有無(entity.get高額合算申請書_自己負担額証明書交付申請の有無());
        csvEntity.set申請代表者氏名漢字(entity.get高額合算申請書_申請代表者氏名());
        if (entity.get高額合算申請書_所得区分() != null) {
            csvEntity.set所得区分(KaigoGassan_ShotokuKbn.toValue(entity.get高額合算申請書_所得区分()).get名称());
        }
        if (entity.get高額合算申請書_70歳以上の者に係る所得区分() != null) {
            csvEntity.set歳以上の者に係る所得区分(KaigoGassan_Over70_ShotokuKbn.
                    toValue(entity.get高額合算申請書_70歳以上の者に係る所得区分()).get名称());
        }
        csvEntity.set資格喪失年月日(dataToRString(entity.get高額合算申請書_資格喪失年月日(), parameter));
        if (entity.get高額合算申請書_資格喪失事由() != null) {
            csvEntity.set資格喪失事由(KaigoGassan_SoshitsuJiyu.toValue(entity.get高額合算申請書_資格喪失事由()).get名称());
        }
        csvEntity.set加入期間開始年月日(dataToRString(entity.get高額合算申請書_加入期間開始年月日(), parameter));
        csvEntity.set加入期間終了年月日(dataToRString(entity.get高額合算申請書_加入期間終了年月日(), parameter));
        csvEntity.set国保保険者番号(entity.get高額合算申請書_国保保険者番号());
        csvEntity.set国保保険者名称(entity.get高額合算申請書_国保保険者名称());
        csvEntity.set国保被保険者証記号(entity.get高額合算申請書_国保被保険者証記号());
        csvEntity.set国保被保険者証番号(entity.get高額合算申請書_国保被保険者証番号());
        csvEntity.set国保世帯番号(entity.get高額合算申請書_国保世帯番号());
        if (entity.get高額合算申請書_国保続柄() != null) {
            csvEntity.set国保続柄(KaigoGassan_Kokuho_Zokugara.toValue(entity.get高額合算申請書_国保続柄()).get名称());
        }
        csvEntity.set国保加入期間開始年月日(dataToRString(entity.get高額合算申請書_国保加入期間開始年月日(), parameter));
        csvEntity.set国保加入期間終了年月日(dataToRString(entity.get高額合算申請書_国保加入期間終了年月日(), parameter));
        csvEntity.set後期保険者番号(entity.get高額合算申請書_後期保険者番号());
        csvEntity.set後期広域連合名称(entity.get高額合算申請書_後期広域連合名称());
        csvEntity.set後期被保険者番号(entity.get高額合算申請書_後期被保険者番号());
        csvEntity.set後期加入期間開始年月日(dataToRString(entity.get高額合算申請書_後期加入期間開始年月日(), parameter));
        csvEntity.set後期加入期間終了年月日(dataToRString(entity.get高額合算申請書_後期加入期間終了年月日(), parameter));
        csvEntity.set支払方法区分(entity.get高額合算申請書_支払方法区分());
        csvEntity.set支払場所(entity.get高額合算申請書_支払場所());
        if (entity.get高額合算申請書_支払場所() != null && entity.get高額合算申請書_支払場所().length() > INT_10) {
            csvEntity.set支払場所短(entity.get高額合算申請書_支払場所().substring(0, INT_10));
        } else {
            csvEntity.set支払場所短(entity.get高額合算申請書_支払場所());
        }
        csvEntity.set支払期間開始年月日(dataToRString(entity.get高額合算申請書_支払期間開始年月日(), parameter));
        csvEntity.set支払期間終了年月日(dataToRString(entity.get高額合算申請書_支払期間終了年月日(), parameter));
        DayOfWeek 支払開始曜日 = null;
        if (entity.get高額合算申請書_支払期間開始年月日() != null) {
            支払開始曜日 = entity.get高額合算申請書_支払期間開始年月日().getDayOfWeek();
        }
        csvEntity.set支払期間開始年月日曜日(支払開始曜日 != null ? new RString(支払開始曜日.toString()) : RString.EMPTY);
        DayOfWeek 支払終了曜日 = null;
        if (entity.get高額合算申請書_支払期間終了年月日() != null) {
            支払終了曜日 = entity.get高額合算申請書_支払期間終了年月日().getDayOfWeek();
        }
        csvEntity.set支払期間終了年月日曜日(支払終了曜日 != null ? new RString(支払終了曜日.toString()) : RString.EMPTY);
        csvEntity.set支払期間開始年月日時間(entity.get高額合算申請書_支払期間開始時間());
        csvEntity.set支払期間終了年月日時間(entity.get高額合算申請書_支払期間終了時間());
        csvEntity.set口座履歴番号(entity.get高額合算申請書_口座ID());
        csvEntity.set加入０１保険者名(entity.get高額合算申請書加入歴01_保険者名());
        csvEntity.set加入０１加入開始日(dataToRString(entity.get高額合算申請書加入歴01_加入期間開始年月日(), parameter));
        csvEntity.set加入０１加入終了日(dataToRString(entity.get高額合算申請書加入歴01_加入期間終了年月日(), parameter));
        csvEntity.set加入０１証明書番号(entity.get高額合算申請書加入歴01_自己負担額証明書整理番号());
        csvEntity.set加入０２保険者名(entity.get高額合算申請書加入歴02_保険者名());
        csvEntity.set加入０２加入開始日(dataToRString(entity.get高額合算申請書加入歴02_加入期間開始年月日(), parameter));
        csvEntity.set加入０２加入終了日(dataToRString(entity.get高額合算申請書加入歴02_加入期間終了年月日(), parameter));
        csvEntity.set加入０２証明書番号(entity.get高額合算申請書加入歴02_自己負担額証明書整理番号());
        csvEntity.set加入０３保険者名(entity.get高額合算申請書加入歴03_保険者名());
        csvEntity.set加入０３加入開始日(dataToRString(entity.get高額合算申請書加入歴03_加入期間開始年月日(), parameter));
        csvEntity.set加入０３加入終了日(dataToRString(entity.get高額合算申請書加入歴03_加入期間終了年月日(), parameter));
        csvEntity.set加入０３証明書番号(entity.get高額合算申請書加入歴03_自己負担額証明書整理番号());
        csvEntity.set加入０４保険者名(entity.get高額合算申請書加入歴04_保険者名());
        csvEntity.set加入０４加入開始日(dataToRString(entity.get高額合算申請書加入歴04_加入期間開始年月日(), parameter));
        csvEntity.set加入０４加入終了日(dataToRString(entity.get高額合算申請書加入歴04_加入期間終了年月日(), parameter));
        csvEntity.set加入０４証明書番号(entity.get高額合算申請書加入歴04_自己負担額証明書整理番号());
        csvEntity.set加入０５保険者名(entity.get高額合算申請書加入歴05_保険者名());
        csvEntity.set加入０５加入開始日(dataToRString(entity.get高額合算申請書加入歴05_加入期間開始年月日(), parameter));
        csvEntity.set加入０５加入終了日(dataToRString(entity.get高額合算申請書加入歴05_加入期間終了年月日(), parameter));
        csvEntity.set加入０５証明書番号(entity.get高額合算申請書加入歴05_自己負担額証明書整理番号());
        csvEntity.set加入０６保険者名(entity.get高額合算申請書加入歴06_保険者名());
        csvEntity.set加入０６加入開始日(dataToRString(entity.get高額合算申請書加入歴06_加入期間開始年月日(), parameter));
        csvEntity.set加入０６加入終了日(dataToRString(entity.get高額合算申請書加入歴06_加入期間終了年月日(), parameter));
        csvEntity.set加入０６証明書番号(entity.get高額合算申請書加入歴06_自己負担額証明書整理番号());
        csvEntity.set加入０７保険者名(entity.get高額合算申請書加入歴07_保険者名());
        csvEntity.set加入０７加入開始日(dataToRString(entity.get高額合算申請書加入歴07_加入期間開始年月日(), parameter));
        csvEntity.set加入０７加入終了日(dataToRString(entity.get高額合算申請書加入歴07_加入期間終了年月日(), parameter));
        csvEntity.set加入０７証明書番号(entity.get高額合算申請書加入歴07_自己負担額証明書整理番号());
        csvEntity.set加入０８保険者名(entity.get高額合算申請書加入歴08_保険者名());
        csvEntity.set加入０８加入開始日(dataToRString(entity.get高額合算申請書加入歴08_加入期間開始年月日(), parameter));
        csvEntity.set加入０８加入終了日(dataToRString(entity.get高額合算申請書加入歴08_加入期間終了年月日(), parameter));
        csvEntity.set加入０８証明書番号(entity.get高額合算申請書加入歴08_自己負担額証明書整理番号());
        csvEntity.set加入０９保険者名(entity.get高額合算申請書加入歴09_保険者名());
        csvEntity.set加入０９加入開始日(dataToRString(entity.get高額合算申請書加入歴09_加入期間開始年月日(), parameter));
        csvEntity.set加入０９加入終了日(dataToRString(entity.get高額合算申請書加入歴09_加入期間終了年月日(), parameter));
        csvEntity.set加入０９証明書番号(entity.get高額合算申請書加入歴09_自己負担額証明書整理番号());
        csvEntity.set加入１０保険者名(entity.get高額合算申請書加入歴10_保険者名());
        csvEntity.set加入１０加入開始日(dataToRString(entity.get高額合算申請書加入歴10_加入期間開始年月日(), parameter));
        csvEntity.set加入１０加入終了日(dataToRString(entity.get高額合算申請書加入歴10_加入期間終了年月日(), parameter));
        csvEntity.set加入１０証明書番号(entity.get高額合算申請書加入歴10_自己負担額証明書整理番号());
        csvEntity.set支給申請書情報送付年月(monthToRString(entity.get高額合算申請書_支給申請書情報送付年月(), parameter));
        csvEntity.set自己負担額計算年月(monthToRString(entity.get高額合算申請書_自己負担額計算年月(), parameter));

    }

    private void set宛名(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity,
            HanyoListKogakuGassanShinseishoJohoProcessParameter parameter,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体) {

        if (entity.get宛名Entity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            ShikibetsuCode 識別コード = 宛名.get識別コード();
            csvEntity.set識別コード(識別コード != null
                    ? 識別コード.getColumnValue() : RString.EMPTY);
            csvEntity.set住民種別(宛名.get住民状態().住民状態略称());
            AtenaMeisho 氏名 = 宛名.get名称().getName();
            csvEntity.set氏名(氏名 != null
                    ? 氏名.getColumnValue() : RString.EMPTY);
            AtenaKanaMeisho 氏名カナ = 宛名.get名称().getKana();
            csvEntity.set氏名カナ(氏名カナ != null
                    ? 氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set生年月日(dataToRString(宛名.get生年月日().toFlexibleDate(), parameter));
            csvEntity.set年齢(宛名.get年齢算出().get年齢());
            if (宛名.get性別() != null) {
                csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
            }
            TsuzukigaraCode 続柄コード = 宛名.get続柄コードリスト().toTsuzukigaraCode();
            csvEntity.set続柄コード(続柄コード != null
                    ? 続柄コード.getColumnValue() : RString.EMPTY);
            SetaiCode 世帯コード = 宛名.get世帯コード();
            csvEntity.set世帯コード(世帯コード != null
                    ? 世帯コード.getColumnValue() : RString.EMPTY);
            AtenaMeisho 世帯主名 = 宛名.get世帯主名();
            csvEntity.set世帯主名(世帯主名 != null
                    ? 世帯主名.getColumnValue() : RString.EMPTY);
            csvEntity.set住所コード(宛名.get住所().get町域コード() != null
                    ? 宛名.get住所().get町域コード().value() : RString.EMPTY);
            YubinNo 郵便番号 = 宛名.get住所() != null ? 宛名.get住所().get郵便番号() : null;
            csvEntity.set郵便番号(郵便番号 != null
                    ? 郵便番号.getEditedYubinNo() : RString.EMPTY);
            set住所番地方書(entity, csvEntity, 帳票制御共通, 地方公共団体);
            set宛名本人(entity, csvEntity, parameter);
        }
    }

    private void set住所番地方書(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association 地方公共団体
    ) {
        if (entity.get宛名Entity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            IJusho 住所 = 宛名.get住所();
            csvEntity.set住所番地方書(JushoHenshu.editJusho(帳票制御共通, 宛名, 地方公共団体));
            csvEntity.set住所(住所 != null
                    ? 住所.get住所() : RString.EMPTY);
            csvEntity.set番地(住所 != null && 住所.get番地() != null && 住所.get番地().getBanchi() != null
                    ? 住所.get番地().getBanchi().getColumnValue() : RString.EMPTY);
            csvEntity.set方書(住所 != null && 住所.get方書() != null
                    ? 住所.get方書().getColumnValue() : RString.EMPTY);
        }

    }

    private void set宛名本人(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity,
            HanyoListKogakuGassanShinseishoJohoProcessParameter parameter) {
        if (entity.get宛名Entity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            GyoseikuCode 行政区コード = 宛名.get行政区画() != null && 宛名.get行政区画().getGyoseiku() != null
                    ? 宛名.get行政区画().getGyoseiku().getコード() : null;
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
            TelNo 連絡先1 = 宛名.get連絡先１();
            TelNo 連絡先2 = 宛名.get連絡先２();
            csvEntity.set行政区コード(行政区コード != null
                    ? 行政区コード.getColumnValue() : RString.EMPTY);
            csvEntity.set行政区名(宛名.get行政区画() != null && 宛名.get行政区画().getGyoseiku() != null
                    ? 宛名.get行政区画().getGyoseiku().get名称() : RString.EMPTY);
            csvEntity.set地区１(地区1);
            csvEntity.set地区２(地区2);
            csvEntity.set地区３(地区3);
            csvEntity.set連絡先１(連絡先1 != null
                    ? 連絡先1.getColumnValue() : RString.EMPTY);
            csvEntity.set連絡先２(連絡先2 != null
                    ? 連絡先2.getColumnValue() : RString.EMPTY);
            csvEntity.set登録異動日(dataToRString(宛名.get登録異動年月日(), parameter));
            set事由(csvEntity, 宛名, parameter);
        }
        set前住所番地方書(entity, csvEntity);
    }

    private void set事由(HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity,
            IKojin 宛名, HanyoListKogakuGassanShinseishoJohoProcessParameter parameter) {
        YubinNo 前住所郵便番号 = 宛名.get転入前() != null ? 宛名.get転入前().get郵便番号() : null;
        IIdoJiyu 登録事由 = 宛名.get登録事由();
        IIdoJiyu 住定事由 = 宛名.get住定事由();
        IIdoJiyu 消除事由 = 宛名.get消除事由();
        csvEntity.set登録事由(登録事由 != null ? 登録事由.get異動事由略称() : RString.EMPTY);
        csvEntity.set登録届出日(dataToRString(宛名.get登録届出年月日(), parameter));
        csvEntity.set住定異動日(dataToRString(宛名.get住定異動年月日(), parameter));
        csvEntity.set住定事由(住定事由 != null ? 住定事由.get異動事由略称() : RString.EMPTY);
        csvEntity.set住定届出日(dataToRString(宛名.get住定届出年月日(), parameter));
        csvEntity.set消除異動日(dataToRString(宛名.get消除異動年月日(), parameter));
        csvEntity.set消除事由(登録事由 != null ? 消除事由.get異動事由略称() : RString.EMPTY);
        csvEntity.set消除届出日(dataToRString(宛名.get消除届出年月日(), parameter));
        csvEntity.set転出入理由(RString.EMPTY);
        csvEntity.set前住所郵便番号(前住所郵便番号 != null
                ? 前住所郵便番号.getEditedYubinNo() : RString.EMPTY);
    }

    private void set前住所番地方書(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity) {
        if (entity.get宛名Entity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            ITennyuMae 前住所 = 宛名.get転入前();

            if (前住所 != null && 前住所.get番地() != null && 前住所.get番地().getBanchi() != null
                    && 前住所.get方書() != null) {
                Banchi 前住所番地 = 前住所.get番地();
                Katagaki 前住所方書 = 前住所.get方書();
                csvEntity.set前住所番地方書(前住所.get住所()
                        .concat(前住所番地.getBanchi().getColumnValue()).concat(RString.FULL_SPACE)
                        .concat(前住所方書.getColumnValue()));
            }
            csvEntity.set前住所(前住所 != null
                    ? 前住所.get住所() : RString.EMPTY);
            csvEntity.set前住所番地(前住所 != null && 前住所.get番地() != null && 前住所.get番地().getBanchi() != null
                    ? 前住所.get番地().getBanchi().getColumnValue() : RString.EMPTY);
            csvEntity.set前住所方書(前住所 != null && 前住所.get方書() != null
                    ? 前住所.get方書().getColumnValue() : RString.EMPTY);
        }

    }

    private void set宛先(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity) {
        if (entity.get宛先Entity() != null) {
            IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先Entity());
            IName 送付先氏名 = 宛先.get宛先名称();
            AtenaKanaMeisho 送付先氏名カナ = 宛先.get宛先名称() != null ? 宛先.get宛先名称().getKana() : null;
            ZenkokuJushoCode 送付先住所コード = 宛先.get宛先住所() != null ? 宛先.get宛先住所().get全国住所コード() : null;
            YubinNo 送付先郵便番号 = 宛先.get宛先住所() != null ? 宛先.get宛先住所().get郵便番号() : null;
            GyoseikuCode 送付先行政区コード = 宛先.get宛先行政区() != null ? 宛先.get宛先行政区().getコード() : null;
            csvEntity.set送付先氏名(送付先氏名 != null
                    ? 送付先氏名.getName().getColumnValue() : RString.EMPTY);
            csvEntity.set送付先氏名カナ(送付先氏名カナ != null
                    ? 送付先氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先住所コード(送付先住所コード != null
                    ? 送付先住所コード.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先郵便番号(送付先郵便番号 != null
                    ? 送付先郵便番号.getEditedYubinNo() : RString.EMPTY);

            csvEntity.set送付先行政区コード(送付先行政区コード != null
                    ? 送付先行政区コード.value() : RString.EMPTY);
            csvEntity.set送付先行政区名(宛先.get宛先行政区().get名称());
            set送付先住所番地方書(entity, csvEntity);
        }
    }

    private void set送付先住所番地方書(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity) {
        if (entity.get宛先Entity() != null) {
            IAtesaki 宛先 = AtesakiFactory.createInstance(entity.get宛先Entity());
            IJusho 送付先住所 = 宛先.get宛先住所();
            if (送付先住所 != null && 送付先住所.get番地() != null && 送付先住所.get番地().getBanchi() != null
                    && 送付先住所.get方書() != null) {
                Banchi 送付先番地 = 送付先住所.get番地();
                Katagaki 送付先方書 = 送付先住所.get方書();
                csvEntity.set送付先住所番地方書(送付先住所.get住所()
                        .concat(送付先番地.getBanchi().getColumnValue()).concat(RString.FULL_SPACE)
                        .concat(送付先方書.getColumnValue()));
            }
            csvEntity.set送付先住所(送付先住所 != null
                    ? 送付先住所.get住所() : RString.EMPTY);
            csvEntity.set送付先番地(送付先住所 != null && 送付先住所.get番地() != null
                    && 送付先住所.get番地().getBanchi() != null
                            ? 送付先住所.get番地().getBanchi().getColumnValue() : RString.EMPTY);
            csvEntity.set送付先方書(送付先住所 != null && 送付先住所.get方書() != null
                    ? 送付先住所.get方書().getColumnValue() : RString.EMPTY);
        }

    }

    private void set被保険者台帳管理(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity,
            HanyoListKogakuGassanShinseishoJohoProcessParameter parameter,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap, Association 地方公共団体) {

        csvEntity.set市町村コード(entity.get最新被保台帳_市町村コード() != null
                ? entity.get最新被保台帳_市町村コード().getColumnValue() : RString.EMPTY);
        if (entity.get最新被保台帳_市町村コード() != null) {
            csvEntity.set市町村名(市町村名MasterMap.get(entity.get最新被保台帳_市町村コード().value()) != null
                    ? 市町村名MasterMap.get(entity.get最新被保台帳_市町村コード().value()).get市町村名称() : RString.EMPTY);
        }
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().getColumnValue());
        csvEntity.set保険者名(地方公共団体.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get最新被保台帳_被保険者番号() != null
                ? entity.get最新被保台帳_被保険者番号().getColumnValue() : RString.EMPTY);
        RString 資格取得事由 = RString.EMPTY;
        if (entity.get最新被保台帳_資格取得事由コード() != null && !entity.get最新被保台帳_資格取得事由コード().isEmpty()) {
            資格取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get最新被保台帳_資格取得事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set資格取得事由(資格取得事由);
        csvEntity.set資格取得日(dataToRString(entity.get最新被保台帳_資格取得年月日(), parameter));
        csvEntity.set資格取得届出日(dataToRString(entity.get最新被保台帳_資格取得届出年月日(), parameter));
        RString 資格喪失事由 = RString.EMPTY;
        if (entity.get最新被保台帳_資格喪失事由コード() != null && !entity.get最新被保台帳_資格喪失事由コード().isEmpty()) {
            資格喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get最新被保台帳_資格喪失事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set喪失事由(資格喪失事由);
        csvEntity.set資格喪失日(dataToRString(entity.get最新被保台帳_資格喪失年月日(), parameter));
        csvEntity.set資格喪失届日(dataToRString(entity.get最新被保台帳_資格喪失届出年月日(), parameter));
        if (entity.get最新被保台帳_被保険者区分コード() != null && !entity.get最新被保台帳_被保険者区分コード().isEmpty()) {
            HihokenshaKubunCode 被保険者区分コード = HihokenshaKubunCode.toValue(entity.get最新被保台帳_被保険者区分コード());
            csvEntity.set資格区分(被保険者区分コード != null ? 被保険者区分コード.get名称() : RString.EMPTY);
        }
        csvEntity.set住所地特例状態(entity.is最新被保台帳_住所地特例フラグ() ? 住特 : RString.EMPTY);
        csvEntity.set受給申請事由(get受給申請事由(entity));

        csvEntity.set受給申請日(dataToRString(entity.get受給者台帳_受給申請年月日(), parameter));
        if (!RString.isNullOrEmpty(entity.get受給者台帳_要介護認定状態区分コード())) {
            csvEntity.set受給要介護度(YokaigoJotaiKubun.toValue(entity.get受給者台帳_要介護認定状態区分コード()).get名称());
        }
        csvEntity.set受給認定開始日(dataToRString(entity.get受給者台帳_認定有効期間開始年月日(), parameter));
        csvEntity.set受給認定終了日(dataToRString(entity.get受給者台帳_認定有効期間終了年月日(), parameter));
        csvEntity.set受給認定日(dataToRString(entity.get受給者台帳_認定年月日(), parameter));
        csvEntity.set受給旧措置(entity.is受給者台帳_旧措置者フラグ() ? 旧措置者 : RString.EMPTY);
        if (!RString.isNullOrEmpty(entity.get受給者台帳_みなし要介護区分コード())) {
            csvEntity.set受給みなし更新認定(get受給みなし更新認定(entity.get受給者台帳_みなし要介護区分コード()));
        }
        if (entity.get受給者台帳_直近異動事由コード() != null) {
            csvEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get受給者台帳_直近異動事由コード()).get名称());
        }
    }

    private RString get受給みなし更新認定(RString みなし要介護区分コード) {
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

    private RString get受給申請事由(HanyoListKogakuGassanShinseishoJohoEntity entity) {
        RString 受給申請事由コード = RString.EMPTY;
        if (entity.get受給者台帳_受給申請事由() != null) {
            受給申請事由コード = entity.get受給者台帳_受給申請事由();
        }
        return getJukyuShinseiJiyu(受給申請事由コード, entity.get受給者台帳_要支援者認定申請区分());
    }

    private RString getJukyuShinseiJiyu(RString 受給申請事由コード, RString 要支援者認定申請区分) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由コード)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(要支援者認定申請区分)) {
                return 受給申請事由_支援から申請;
            } else {
                return 受給申請事由_区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(受給申請事由コード)) {
            return 受給申請事由_追加;
        }
        return RString.EMPTY;
    }

    private void set口座情報(HanyoListKogakuGassanShinseishoJohoEntity entity,
            HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity) {
        KozaRelateEntity releteEntity = entity.get口座情報Entity();
        if (releteEntity != null) {
            IKoza 口座 = new Koza(releteEntity);
            KinyuKikanShiten 支店 = 口座.get支店();
            if (口座.isゆうちょ銀行()) {
                csvEntity.set銀行郵便区分(Kaigogassan_KinyuKikanKubun.ゆうちょ.get名称());
                csvEntity.set支店コード(口座.get店番());
                csvEntity.set支店名カナ(RString.EMPTY);
                csvEntity.set支店名(口座.get店名());
            } else {
                csvEntity.set銀行郵便区分(銀行);
                KinyuKikanShitenCode 支店コード = 口座.get支店コード();
                csvEntity.set支店コード(支店コード != null ? 支店コード.getColumnValue() : RString.EMPTY);
                csvEntity.set支店名カナ(支店 != null ? 支店.get支店カナ名称() : RString.EMPTY);
                csvEntity.set支店名(支店 != null ? 支店.get支店名称() : RString.EMPTY);
            }
            KinyuKikanCode 銀行コード = 口座.get金融機関コード();
            KinyuKikan 金融機関 = 口座.get金融機関();
            csvEntity.set銀行コード(銀行コード != null ? 銀行コード.getColumnValue() : RString.EMPTY);
            csvEntity.set銀行名カナ(金融機関 != null ? 金融機関.get金融機関カナ名称() : RString.EMPTY);
            csvEntity.set銀行名(金融機関 != null ? 金融機関.get金融機関名称() : RString.EMPTY);
            csvEntity.set口座種目(口座.get預金種別() != null ? 口座.get預金種別().get預金種別コード() : RString.EMPTY);
            csvEntity.set口座番号(口座.get口座番号());

            AtenaKanaMeisho 名義人カナ = 口座.get口座名義人();
            csvEntity.set名義人カナ(名義人カナ != null ? 名義人カナ.getColumnValue() : RString.EMPTY);
            AtenaMeisho 名義人 = 口座.get口座名義人漢字();
            csvEntity.set名義人(名義人 != null ? 名義人.getColumnValue() : RString.EMPTY);
            if (名義人カナ != null && 名義人カナ.getColumnValue().toString().length() > INT_8) {
                csvEntity.set名義人カナ短(new RString(名義人カナ.getColumnValue()
                        .toString().substring(0, INT_8)));
            } else {
                csvEntity.set名義人カナ短(名義人カナ != null ? 名義人カナ.getColumnValue() : RString.EMPTY);
            }
            if (名義人 != null && 名義人.getColumnValue().length() > INT_20) {
                csvEntity.set名義人短(名義人.getColumnValue().substring(0, INT_20));
            } else {
                csvEntity.set名義人短(名義人 != null ? 名義人.getColumnValue() : RString.EMPTY);
            }

        }
    }

    private RString dataToRString(FlexibleDate 日付, HanyoListKogakuGassanShinseishoJohoProcessParameter parameter) {
        RString temp = getパターン32(日付);
        if (!parameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(temp)) {
            temp = temp.replace(斜線, RString.EMPTY);
        }
        return temp;
    }

    private RString getパターン32(FlexibleDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン32(FlexibleYearMonth date) {
        if (date != null) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString monthToRString(FlexibleYearMonth 日付, HanyoListKogakuGassanShinseishoJohoProcessParameter parameter) {
        RString temp = getパターン32(日付);
        if (!parameter.is日付スラッシュ付加() && !RString.isNullOrEmpty(temp)) {
            temp = temp.replace(斜線, RString.EMPTY);
        }
        return temp;
    }

    private RString numToRString(Decimal 数字) {
        if (数字 == null) {
            return RString.EMPTY;
        }
        return new RString(数字.toString());
    }
}
