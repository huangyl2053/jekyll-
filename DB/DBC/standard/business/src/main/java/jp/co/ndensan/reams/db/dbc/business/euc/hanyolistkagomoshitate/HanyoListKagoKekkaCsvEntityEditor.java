/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkagomoshitate;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitateKekka_HokenshaKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710100.HanyoListKagoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710100.HanyoListKagoKekkaCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710100.HanyoListKagoKekkaNoRebanCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710100.HanyoListKagoKekkaEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.ShikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.ShikakuSositsuJiyuHihokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(過誤結果情報)CSVデータの編集クラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
public class HanyoListKagoKekkaCsvEntityEditor {

    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_住特 = new RString("住特");
    private static final RString 定数_初回申請 = new RString("初回申請");
    private static final RString 定数_再申請内 = new RString("再申請内");
    private static final RString 定数_再申請外 = new RString("再申請外");
    private static final RString 定数_支援から申請 = new RString("支援から申請");
    private static final RString 定数_区分変更申請 = new RString("区分変更申請");
    private static final RString 定数_サ変更申請 = new RString("サ変更申請");
    private static final RString 定数_施行前申請 = new RString("施行前申請");
    private static final RString 定数_追加 = new RString("追加");
    private static final RString 定数_旧措置者 = new RString("旧措置者");
    private static final RString 定数_みなし = new RString("みなし");
    private static final RString SLASH = new RString("/");

    private final HanyoListKagoKekkaEntity entity;
    private final HanyoListKagoKekkaProcessParameter param;
    private final Association 地方公共団体情報;
    private final Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private final FlexibleDate システム日付;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param param param
     * @param 地方公共団体情報 地方公共団体情報
     * @param 構成市町村マスタ 構成市町村マスタ
     * @param システム日付 システム日付
     * @param 連番 連番
     */
    public HanyoListKagoKekkaCsvEntityEditor(HanyoListKagoKekkaEntity entity, HanyoListKagoKekkaProcessParameter param,
            Association 地方公共団体情報, Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ, FlexibleDate システム日付, int 連番) {
        this.entity = entity;
        this.param = param;
        this.地方公共団体情報 = 地方公共団体情報;
        this.構成市町村マスタ = 構成市町村マスタ;
        this.システム日付 = システム日付;
        this.連番 = 連番;
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKagoKekkaCsvEntity}
     */
    public HanyoListKagoKekkaCsvEntity edit() {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HanyoListKagoKekkaCsvEntity csvEntity = new HanyoListKagoKekkaCsvEntity();
        csvEntity.set連番(new RString(連番));
        csvEntity.set識別コード(kojin.get識別コード().getColumnValue());
        csvEntity.set住民種別(kojin.get住民種別().toRString());
        csvEntity.set氏名(kojin.get名称().getName().getColumnValue());
        csvEntity.set氏名カナ(kojin.get名称().getKana().getColumnValue());
        csvEntity.set生年月日(format日付項目(kojin.get生年月日().toFlexibleDate()));
        csvEntity.set年齢(kojin.get年齢算出().get年齢());
        csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
        csvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
        csvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
        csvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
        csvEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
        csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
        if (kojin.get住所().get方書().getColumnValue() != null) {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue())
                    .concat(RString.FULL_SPACE).concat(kojin.get住所().get方書().getColumnValue()));
        } else {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set住所(kojin.get住所().get住所());
        csvEntity.set番地(kojin.get住所().get番地().getBanchi().getColumnValue());
        csvEntity.set方書(kojin.get住所().get方書().getColumnValue());
        csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        csvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
        csvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
        csvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
        csvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
        csvEntity.set連絡先１(kojin.get連絡先１().getColumnValue());
        csvEntity.set連絡先２(kojin.get連絡先２().getColumnValue());
        csvEntity.set登録異動日(format日付項目(kojin.get登録異動年月日()));
        csvEntity.set登録事由(kojin.get登録事由().get異動事由正式名称());
        csvEntity.set登録届出日(format日付項目(kojin.get登録届出年月日()));
        csvEntity.set住定異動日(format日付項目(kojin.get住定異動年月日()));
        csvEntity.set住定事由(kojin.get住定事由().get異動事由正式名称());
        csvEntity.set住定届出日(format日付項目(kojin.get住定届出年月日()));
        csvEntity.set消除異動日(format日付項目(kojin.get消除異動年月日()));
        csvEntity.set消除事由(kojin.get消除事由().get異動事由正式名称());
        csvEntity.set消除届出日(format日付項目(kojin.get消除届出年月日()));
        csvEntity.set転出入理由(RString.EMPTY);
        csvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
        if (kojin.get転入前().get方書() != null && !kojin.get転入前().get方書().isEmpty()) {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()).
                    concat(RString.FULL_SPACE).concat(kojin.get転入前().get方書().getColumnValue()));
        } else {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set前住所(kojin.get転入前().get住所());
        csvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().getColumnValue());
        csvEntity.set前住所方書(kojin.get転入前().get方書().getColumnValue());
        csvEntity.set市町村コード(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get最新被保台帳().getShichosonCode())) {
            csvEntity.set市町村名(構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get市町村名称());
            csvEntity.set資格証記載保険者番号(
                    構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get証記載保険者番号().getColumnValue());
        } else if (定数_1.equals(entity.get最新被保台帳().getKoikinaiJushochiTokureiFlag())) {
            LasdecCode temp = entity.get最新被保台帳().getKoikinaiTokureiSochimotoShichosonCode();
            if (temp != null) {
                csvEntity.set資格証記載保険者番号(temp.getColumnValue());
            }
        } else {
            csvEntity.set資格証記載保険者番号(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        }
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get最新被保台帳().getHihokenshaNo().getColumnValue());
        if (entity.get最新被保台帳().getShikakuShutokuJiyuCode() != null) {
            csvEntity.set資格取得事由(new ShikakuShutokuJiyuHihokensha(entity.get最新被保台帳().getShikakuShutokuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格取得日(format日付項目(entity.get最新被保台帳().getShikakuShutokuYMD()));
        csvEntity.set資格取得届出日(format日付項目(entity.get最新被保台帳().getShikakuShutokuTodokedeYMD()));
        if (entity.get最新被保台帳().getShikakuSoshitsuJiyuCode() != null) {
            csvEntity.set喪失事由(new ShikakuSositsuJiyuHihokensha(entity.get最新被保台帳().getShikakuSoshitsuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格喪失日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuYMD()));
        csvEntity.set資格喪失届日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuTodokedeYMD()));
        if (!RString.isNullOrEmpty(entity.get最新被保台帳().getHihokennshaKubunCode())) {
            csvEntity.set資格区分(ShikakuKubun.toValue(entity.get最新被保台帳().getHihokennshaKubunCode()).get名称());
        }
        if (定数_1.equals(entity.get最新被保台帳().getJushochiTokureiFlag())) {
            csvEntity.set住所地特例状態(定数_住特);
        }
        if (entity.get二次予防事業対象情報() != null) {
            csvEntity.set二次予防適用開始日(format日付項目(entity.get二次予防事業対象情報().getTekiyoKaishiYMD()));
            csvEntity.set二次予防適用終了日(format日付項目(entity.get二次予防事業対象情報().getTekiyoShuryoYMD()));
            csvEntity.set二次予防調査実施日(format日付項目(entity.get二次予防事業対象情報().getChosaJisshiYMD()));
            csvEntity.set二次予防決定日(format日付項目(entity.get二次予防事業対象情報().getKetteiYMD()));
        }
        edit_part2(csvEntity);
        return csvEntity;
    }

    private void edit_part2(HanyoListKagoKekkaCsvEntity csvEntity) {
        csvEntity.set取扱年月(format日付項目(entity.get過誤決定明細().getToriatsukaiYM()));
        if (entity.get過誤決定明細() != null) {
            if (!RString.isNullOrEmpty(entity.get過誤決定明細().getHokenshaKubun())) {
                csvEntity.set保険者区分(KagoMoshitateKekka_HokenshaKubun.toValue(entity.get過誤決定明細().getHokenshaKubun()).get略称());
            }
            csvEntity.set過誤事業者名(entity.get過誤決定事業者().getJigyoshaName().getColumnValue());
            csvEntity.set過誤事業者番号(entity.get過誤決定明細().getJigyoshoNo().getColumnValue());
        }
        if (entity != null && entity.get介護サービス種類() != null) {
            ServiceShuruiCode サービス種類コード = entity.get過誤決定明細().getServiceShuruiCode();
            if (サービス種類コード != null) {
                csvEntity.setサービス種類(サービス種類コード.getColumnValue());
            }
            RString 介護サービス種類 = entity.get介護サービス種類().getServiceShuruiRyakusho();
            if (介護サービス種類 != null) {
                csvEntity.setサービス種類名(介護サービス種類);
            }
        }
        csvEntity.setサービス提供年月(format日付項目(entity.get過誤決定明細().getServiceTeikyoYM()));
        Code 申立事由コード = entity.get過誤決定明細().getKagomoushitateJiyuCode();
        if (申立事由コード != null) {
            csvEntity.set申立事由コード(申立事由コード.getColumnValue());
        }
        csvEntity.set申立事由(entity.get過誤決定明細().getKagomoushitateJiyu());
        Decimal 単位数 = entity.get過誤決定明細().getTanisu();
        if (単位数 != null) {
            csvEntity.set単位数(new RString(単位数.toString()));
        }
        Decimal 保険者負担額 = entity.get過誤決定明細().getHokenshaFutangaku();
        if (保険者負担額 != null) {
            csvEntity.set保険者負担額(new RString(保険者負担額.toString()));
        }
        if (!RString.isNullOrEmpty(entity.get過誤決定明細().getKohiJukyushaNo())) {
            csvEntity.set公費受給者番号(entity.get過誤決定明細().getKohiJukyushaNo());
        }
        HokenshaNo 給付証記載保険者番号 = entity.get過誤決定明細().getShokisaiHokenshaNo();
        if (給付証記載保険者番号 != null) {
            csvEntity.set給付証記載保険者番号(給付証記載保険者番号.getColumnValue());
        }
        if (entity.get受給者台帳() != null) {
            csvEntity.set受給申請事由(get受給申請事由(entity.get受給者台帳().getJukyuShinseiJiyu().getColumnValue()));
            csvEntity.set受給申請日(format日付項目(entity.get受給者台帳().getJukyuShinseiYMD()));
            csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.
                    toValue(システム日付, entity.get受給者台帳().getYokaigoJotaiKubunCode().getColumnValue()).getName());
            csvEntity.set受給認定開始日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanKaishiYMD()));
            csvEntity.set受給認定終了日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanShuryoYMD()));
            csvEntity.set受給認定日(format日付項目(entity.get受給者台帳().getNinteiYMD()));
            if (entity.get受給者台帳().isKyuSochishaFlag()) {
                csvEntity.set受給旧措置(定数_旧措置者);
            } else {
                csvEntity.set受給旧措置(RString.EMPTY);
            }
            if (entity.get受給者台帳().getMinashiCode() != null && (MinashiCode.みなし認定_旧措置入所者
                    .getコード().equals(entity.get受給者台帳().getMinashiCode().getColumnValue())
                    || MinashiCode.やむを得ない事由.getコード().equals(entity.get受給者台帳().getMinashiCode().getColumnValue()))) {
                csvEntity.set受給みなし更新認定(定数_みなし);
            } else {
                csvEntity.set受給みなし更新認定(RString.EMPTY);
            }

            if (entity.get受給者台帳().getChokkinIdoJiyuCode() != null) {
                csvEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get受給者台帳().getChokkinIdoJiyuCode().getColumnValue()).get名称());
            }
        }
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKagoKekkaNoRebanCsvEntity}
     */
    public HanyoListKagoKekkaNoRebanCsvEntity noRenbanEdit() {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HanyoListKagoKekkaNoRebanCsvEntity csvEntity = new HanyoListKagoKekkaNoRebanCsvEntity();
        csvEntity.set識別コード(kojin.get識別コード().getColumnValue());
        csvEntity.set住民種別(kojin.get住民種別().toRString());
        csvEntity.set氏名(kojin.get名称().getName().getColumnValue());
        csvEntity.set氏名カナ(kojin.get名称().getKana().getColumnValue());
        csvEntity.set生年月日(format日付項目(kojin.get生年月日().toFlexibleDate()));
        csvEntity.set年齢(kojin.get年齢算出().get年齢());
        csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
        csvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
        csvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
        csvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
        csvEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
        csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
        if (kojin.get住所().get方書() != null && !kojin.get住所().get方書().isEmpty()) {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue())
                    .concat(RString.FULL_SPACE).concat(kojin.get住所().get方書().getColumnValue()));
        } else {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set住所(kojin.get住所().get住所());
        csvEntity.set番地(kojin.get住所().get番地().getBanchi().getColumnValue());
        csvEntity.set方書(kojin.get住所().get方書().getColumnValue());
        csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        csvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
        csvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
        csvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
        csvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
        csvEntity.set連絡先１(kojin.get連絡先１().getColumnValue());
        csvEntity.set連絡先２(kojin.get連絡先２().getColumnValue());
        csvEntity.set登録異動日(format日付項目(kojin.get登録異動年月日()));
        csvEntity.set登録事由(kojin.get登録事由() != null ? kojin.get登録事由().get異動事由略称() : RString.EMPTY);
        csvEntity.set登録届出日(format日付項目(kojin.get登録届出年月日()));
        csvEntity.set住定異動日(format日付項目(kojin.get住定異動年月日()));
        csvEntity.set住定事由(kojin.get住定事由() != null ? kojin.get住定事由().get異動事由略称() : RString.EMPTY);
        csvEntity.set住定届出日(format日付項目(kojin.get住定届出年月日()));
        csvEntity.set消除異動日(format日付項目(kojin.get消除異動年月日()));
        csvEntity.set消除事由(kojin.get消除事由() != null ? kojin.get消除事由().get異動事由略称() : RString.EMPTY);
        csvEntity.set消除届出日(format日付項目(kojin.get消除届出年月日()));
        csvEntity.set転出入理由(RString.EMPTY);
        csvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
        if (kojin.get転入前().get方書() != null && !kojin.get転入前().get方書().isEmpty()) {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()).
                    concat(RString.FULL_SPACE).concat(kojin.get転入前().get方書().getColumnValue()));
        } else {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set前住所(kojin.get転入前().get住所());
        csvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().getColumnValue());
        csvEntity.set前住所方書(kojin.get転入前().get方書().getColumnValue());
        csvEntity.set市町村コード(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get最新被保台帳().getShichosonCode())) {
            csvEntity.set市町村名(構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get市町村名称());
            csvEntity.set資格証記載保険者番号(
                    構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get証記載保険者番号().getColumnValue());
        } else if (定数_1.equals(entity.get最新被保台帳().getKoikinaiJushochiTokureiFlag())) {
            LasdecCode temp = entity.get最新被保台帳().getKoikinaiTokureiSochimotoShichosonCode();
            if (temp != null) {
                csvEntity.set資格証記載保険者番号(temp.getColumnValue());
            }
        } else {
            csvEntity.set資格証記載保険者番号(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        }
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get最新被保台帳().getHihokenshaNo().getColumnValue());
        if (entity.get最新被保台帳().getShikakuShutokuJiyuCode() != null) {
            csvEntity.set資格取得事由(new ShikakuShutokuJiyuHihokensha(entity.get最新被保台帳().getShikakuShutokuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格取得日(format日付項目(entity.get最新被保台帳().getShikakuShutokuYMD()));
        csvEntity.set資格取得届出日(format日付項目(entity.get最新被保台帳().getShikakuShutokuTodokedeYMD()));
        if (entity.get最新被保台帳().getShikakuSoshitsuJiyuCode() != null) {
            csvEntity.set喪失事由(new ShikakuSositsuJiyuHihokensha(entity.get最新被保台帳().getShikakuSoshitsuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格喪失日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuYMD()));
        csvEntity.set資格喪失届日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuTodokedeYMD()));
        if (!RString.isNullOrEmpty(entity.get最新被保台帳().getHihokennshaKubunCode())) {
            csvEntity.set資格区分(ShikakuKubun.toValue(entity.get最新被保台帳().getHihokennshaKubunCode()).get名称());
        }
        if (定数_1.equals(entity.get最新被保台帳().getJushochiTokureiFlag())) {
            csvEntity.set住所地特例状態(定数_住特);
        }
        if (entity.get二次予防事業対象情報() != null) {
            csvEntity.set二次予防適用開始日(format日付項目(entity.get二次予防事業対象情報().getTekiyoKaishiYMD()));
            csvEntity.set二次予防適用終了日(format日付項目(entity.get二次予防事業対象情報().getTekiyoShuryoYMD()));
            csvEntity.set二次予防調査実施日(format日付項目(entity.get二次予防事業対象情報().getChosaJisshiYMD()));
            csvEntity.set二次予防決定日(format日付項目(entity.get二次予防事業対象情報().getKetteiYMD()));
        }
        noRenbanEdit_part2(csvEntity);
        return csvEntity;
    }

    private void noRenbanEdit_part2(HanyoListKagoKekkaNoRebanCsvEntity csvEntity) {
        csvEntity.set取扱年月(format日付項目(entity.get過誤決定明細().getToriatsukaiYM()));
        if (!RString.isNullOrEmpty(entity.get過誤決定明細().getHokenshaKubun())) {
            csvEntity.set保険者区分(KagoMoshitateKekka_HokenshaKubun.toValue(entity.get過誤決定明細().getHokenshaKubun()).get名称());
        }
        csvEntity.set過誤事業者名(entity.get過誤決定事業者().getJigyoshaName().getColumnValue());
        csvEntity.set過誤事業者番号(entity.get過誤決定明細().getJigyoshoNo().getColumnValue());
        ServiceShuruiCode サービス種類コード = entity.get過誤決定明細().getServiceShuruiCode();
        if (サービス種類コード != null) {
            csvEntity.setサービス種類コード(サービス種類コード.getColumnValue());
        }
        if (entity.get介護サービス種類().getServiceShuruiRyakusho() != null) {
            csvEntity.setサービス種類名(entity.get介護サービス種類().getServiceShuruiRyakusho());
        }
        csvEntity.setサービス提供年月(format日付項目(entity.get過誤決定明細().getServiceTeikyoYM()));
        Code 申立事由コード = entity.get過誤決定明細().getKagomoushitateJiyuCode();
        if (申立事由コード != null) {
            csvEntity.set申立事由コード(申立事由コード.getColumnValue());
        }
        csvEntity.set申立事由(entity.get過誤決定明細().getKagomoushitateJiyu());
        Decimal 単位数 = entity.get過誤決定明細().getTanisu();
        if (単位数 != null) {
            csvEntity.set単位数(new RString(単位数.toString()));
        }
        Decimal 保険者負担額 = entity.get過誤決定明細().getHokenshaFutangaku();
        if (保険者負担額 != null) {
            csvEntity.set保険者負担額(new RString(保険者負担額.toString()));
        }
        if (!RString.isNullOrEmpty(entity.get過誤決定明細().getKohiJukyushaNo())) {
            csvEntity.set公費受給者番号(entity.get過誤決定明細().getKohiJukyushaNo());
        }
        HokenshaNo 給付証記載保険者番号 = entity.get過誤決定明細().getShokisaiHokenshaNo();
        if (給付証記載保険者番号 != null) {
            csvEntity.set給付証記載保険者番号(給付証記載保険者番号.getColumnValue());
        }
        if (entity.get受給者台帳() != null) {
            csvEntity.set受給申請事由(get受給申請事由(entity.get受給者台帳().getJukyuShinseiJiyu().getColumnValue()));
            csvEntity.set受給申請日(format日付項目(entity.get受給者台帳().getJukyuShinseiYMD()));
            csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.
                    toValue(システム日付, entity.get受給者台帳().getYokaigoJotaiKubunCode().getColumnValue()).getName());
            csvEntity.set受給認定開始日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanKaishiYMD()));
            csvEntity.set受給認定終了日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanShuryoYMD()));
            csvEntity.set受給認定日(format日付項目(entity.get受給者台帳().getNinteiYMD()));
            if (entity.get受給者台帳().isKyuSochishaFlag()) {
                csvEntity.set受給旧措置(定数_旧措置者);
            } else {
                csvEntity.set受給旧措置(RString.EMPTY);
            }
            if (MinashiCode.みなし認定_旧措置入所者.getコード().equals(entity.get受給者台帳().getMinashiCode().getColumnValue())
                    || MinashiCode.やむを得ない事由.getコード().equals(entity.get受給者台帳().getMinashiCode().getColumnValue())) {
                csvEntity.set受給みなし更新認定(定数_みなし);
            } else {
                csvEntity.set受給みなし更新認定(RString.EMPTY);
            }
            if (entity.get受給者台帳().getChokkinIdoJiyuCode() != null) {
                csvEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get受給者台帳().getChokkinIdoJiyuCode().getColumnValue()).get名称());
            }
        }
    }

    private RString format日付項目(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        RString temp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付スラッシュ付加()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }

    private RString get受給申請事由(RString key) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(key)) {
            return 定数_初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(key)) {
            return 定数_再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(key)) {
            return 定数_再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(key)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().
                    equals(entity.get受給者台帳().getYokaigoJotaiKubunCode().getColumnValue())) {
                return 定数_支援から申請;
            } else {
                return 定数_区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(key)) {
            return 定数_サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(key)) {
            return 定数_施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(key)) {
            return 定数_追加;
        }
        return RString.EMPTY;
    }

    private RString format日付項目(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        RString temp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付スラッシュ付加()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }
}
