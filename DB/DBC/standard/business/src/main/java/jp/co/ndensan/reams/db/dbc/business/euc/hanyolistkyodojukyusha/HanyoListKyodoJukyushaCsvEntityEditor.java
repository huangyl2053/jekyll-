/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyodojukyusha;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710050.HanyoListKyodoJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710050.HanyoListKyodoJukyushaCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710050.HanyoListKyodoJukyushaNoRebanCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710050.KyodoJukyushaKihonEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 汎用リスト_共同処理用受給者情報（基本）CSVデータの編集クラスです。
 *
 * @reamsid_L DBC-3097-020 qinzhen
 */
public class HanyoListKyodoJukyushaCsvEntityEditor {

    private static final RString SLASH = new RString("/");
    private static final RString 空白 = new RString(" ");
    private static final RString HEADER_連番 = new RString("連番");
    private static final RString HEADER_識別コード = new RString("識別コード");
    private static final RString HEADER_住民種別 = new RString("住民種別");
    private static final RString HEADER_氏名 = new RString("氏名");
    private static final RString HEADER_氏名カナ = new RString("氏名カナ");
    private static final RString HEADER_生年月日 = new RString("生年月日");
    private static final RString HEADER_年齢 = new RString("年齢");
    private static final RString HEADER_性別 = new RString("性別");
    private static final RString HEADER_続柄コード = new RString("続柄コード");
    private static final RString HEADER_世帯コード = new RString("世帯コード");
    private static final RString HEADER_世帯主名 = new RString("世帯主名");
    private static final RString HEADER_住所コード = new RString("住所コード");
    private static final RString HEADER_郵便番号 = new RString("郵便番号");
    private static final RString HEADER_住所_番地_方書 = new RString("住所＋番地＋方書");
    private static final RString HEADER_住所 = new RString("住所");
    private static final RString HEADER_番地 = new RString("番地");
    private static final RString HEADER_方書 = new RString("方書");
    private static final RString HEADER_行政区コード = new RString("行政区コード");
    private static final RString HEADER_行政区名 = new RString("行政区名");
    private static final RString HEADER_地区１ = new RString("地区１");
    private static final RString HEADER_地区２ = new RString("地区２");
    private static final RString HEADER_地区３ = new RString("地区３");
    private static final RString HEADER_連絡先１ = new RString("連絡先１");
    private static final RString HEADER_連絡先２ = new RString("連絡先２");
    private static final RString HEADER_登録異動日 = new RString("登録異動日");
    private static final RString HEADER_登録事由 = new RString("登録事由");
    private static final RString HEADER_登録届出日 = new RString("登録届出日");
    private static final RString HEADER_住定異動日 = new RString("住定異動日");
    private static final RString HEADER_住定事由 = new RString("住定事由");
    private static final RString HEADER_住定届出日 = new RString("住定届出日");
    private static final RString HEADER_消除異動日 = new RString("消除異動日");
    private static final RString HEADER_消除事由 = new RString("消除事由");
    private static final RString HEADER_消除届出日 = new RString("消除届出日");
    private static final RString HEADER_転出入理由 = new RString("転出入理由");
    private static final RString HEADER_前住所郵便番号 = new RString("前住所郵便番号");
    private static final RString HEADER_前住所_番地_方書 = new RString("前住所＋番地＋方書");
    private static final RString HEADER_前住所 = new RString("前住所");
    private static final RString HEADER_前住所番地 = new RString("前住所番地");
    private static final RString HEADER_前住所方書 = new RString("前住所方書");
    private static final RString HEADER_市町村コード = new RString("市町村コード");
    private static final RString HEADER_市町村名 = new RString("市町村名");
    private static final RString HEADER_保険者コード = new RString("保険者コード");
    private static final RString HEADER_保険者名 = new RString("保険者名");
    private static final RString HEADER_空白 = new RString("空白");
    private static final RString HEADER_処理対象年月 = new RString("処理対象年月");
    private static final RString HEADER_被保険者番号 = new RString("被保険者番号");
    private static final RString HEADER_履歴番号 = new RString("履歴番号");
    private static final RString HEADER_異動年月日 = new RString("異動年月日");
    private static final RString HEADER_異動区分 = new RString("異動区分");
    private static final RString HEADER_異動事由 = new RString("異動事由");
    private static final RString HEADER_給付_証記載保険者番号 = new RString("（給付）証記載保険者番号");
    private static final RString HEADER_被保険者氏名漢字 = new RString("被保険者氏名漢字");
    private static final RString HEADER_送付郵便番号 = new RString("送付郵便番号");
    private static final RString HEADER_送付住所カナ = new RString("送付住所カナ");
    private static final RString HEADER_送付住所 = new RString("送付住所");
    private static final RString HEADER_電話番号 = new RString("電話番号");
    private static final RString HEADER_帳票出力順序コード = new RString("帳票出力順序コード");

    private final KyodoJukyushaKihonEntity entity;
    private final HanyoListKyodoJukyushaProcessParameter param;
    private final Association 地方公共団体情報;
    private final Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param param param
     * @param 地方公共団体情報 地方公共団体情報
     * @param 構成市町村マスタ 構成市町村マスタ
     * @param 連番 連番
     */
    public HanyoListKyodoJukyushaCsvEntityEditor(KyodoJukyushaKihonEntity entity, HanyoListKyodoJukyushaProcessParameter param,
            Association 地方公共団体情報, Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ, int 連番) {
        this.entity = entity;
        this.param = param;
        this.地方公共団体情報 = 地方公共団体情報;
        this.構成市町村マスタ = 構成市町村マスタ;
        this.連番 = 連番;
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKyodoJukyushaCsvEntity}
     */
    public HanyoListKyodoJukyushaCsvEntity edit() {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HanyoListKyodoJukyushaCsvEntity csvEntity = new HanyoListKyodoJukyushaCsvEntity();
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
        csvEntity.set市町村コード(entity.get被保険者台帳管理().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get被保険者台帳管理().getShichosonCode())) {
            csvEntity.set市町村名(構成市町村マスタ.get(entity.get被保険者台帳管理().getShichosonCode()).get市町村名称());
        }
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());
        csvEntity.set空白(空白);
        csvEntity.set処理対象年月(format日付項目(entity.get共同処理用受給者異動基本送付().getSofuYM()));
        csvEntity.set被保険者番号(entity.get共同処理用受給者異動基本送付().getHiHokenshaNo().getColumnValue());
        csvEntity.set履歴番号(new RString(entity.get共同処理用受給者異動基本送付().getRirekiNo()));
        csvEntity.set異動年月日(format日付項目(entity.get共同処理用受給者異動基本送付().getIdoYMD()));
        if (entity.get共同処理用受給者異動基本送付() != null) {
            if (!RString.isNullOrEmpty(entity.get共同処理用受給者異動基本送付().getIdoKubunCode())) {
                csvEntity.set異動区分(JukyushaIF_IdoKubunCode.toValue(entity.get共同処理用受給者異動基本送付().getIdoKubunCode()).get名称());
            } else {
                csvEntity.set異動区分(RString.EMPTY);
            }
        }
        csvEntity.set異動事由(JukyushaIF_JukyushaIdoJiyu.toValue(entity.get共同処理用受給者異動基本送付().getJukyushaIdoJiyu()).get名称());
        csvEntity.set給付_証記載保険者番号(entity.get共同処理用受給者異動基本送付().getShoKisaiHokenshaNo().getColumnValue());
        csvEntity.set被保険者氏名漢字(entity.get共同処理用受給者異動基本送付().getHiHokenshaName());
        YubinNo 郵便番号 = entity.get共同処理用受給者異動基本送付().getYubinNo();
        if (YubinNo.EMPTY != 郵便番号 && 郵便番号 != null) {
            csvEntity.set送付郵便番号(郵便番号.getEditedYubinNo());
        }
        csvEntity.set送付住所カナ(entity.get共同処理用受給者異動基本送付().getDdressKana());
        csvEntity.set送付住所(entity.get共同処理用受給者異動基本送付().getAddress());
        TelNo 電話番号 = entity.get共同処理用受給者異動基本送付().getTelNo();
        if (TelNo.EMPTY != 電話番号 && 電話番号 != null) {
            csvEntity.set電話番号(電話番号.getColumnValue());
        }
        csvEntity.set帳票出力順序コード(entity.get共同処理用受給者異動基本送付().getChohyoOutputJunjyoCode());
        return csvEntity;
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKyodoJukyushaNoRebanCsvEntity}
     */
    public HanyoListKyodoJukyushaNoRebanCsvEntity noRenbanEdit() {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HanyoListKyodoJukyushaNoRebanCsvEntity csvEntity = new HanyoListKyodoJukyushaNoRebanCsvEntity();
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
        csvEntity.set市町村コード(entity.get被保険者台帳管理().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get被保険者台帳管理().getShichosonCode())) {
            csvEntity.set市町村名(構成市町村マスタ.get(entity.get被保険者台帳管理().getShichosonCode()).get市町村名称());
        }
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());
        csvEntity.set空白(空白);
        csvEntity.set処理対象年月(format日付項目(entity.get共同処理用受給者異動基本送付().getSofuYM()));
        csvEntity.set被保険者番号(entity.get共同処理用受給者異動基本送付().getHiHokenshaNo().getColumnValue());
        csvEntity.set履歴番号(new RString(entity.get共同処理用受給者異動基本送付().getRirekiNo()));
        csvEntity.set異動年月日(format日付項目(entity.get共同処理用受給者異動基本送付().getIdoYMD()));
        if (entity.get共同処理用受給者異動基本送付() != null) {
            if (!RString.isNullOrEmpty(entity.get共同処理用受給者異動基本送付().getIdoKubunCode())) {
                csvEntity.set異動区分(JukyushaIF_IdoKubunCode.toValue(entity.get共同処理用受給者異動基本送付().getIdoKubunCode()).get名称());
            } else {
                csvEntity.set異動区分(RString.EMPTY);
            }
        }
        csvEntity.set異動事由(JukyushaIF_JukyushaIdoJiyu.toValue(entity.get共同処理用受給者異動基本送付().getJukyushaIdoJiyu()).get名称());
        csvEntity.set給付_証記載保険者番号(entity.get共同処理用受給者異動基本送付().getShoKisaiHokenshaNo().getColumnValue());
        csvEntity.set被保険者氏名漢字(entity.get共同処理用受給者異動基本送付().getHiHokenshaName());
        YubinNo 郵便番号 = entity.get共同処理用受給者異動基本送付().getYubinNo();
        if (YubinNo.EMPTY != 郵便番号 && 郵便番号 != null) {
            csvEntity.set送付郵便番号(郵便番号.getEditedYubinNo());
        }
        csvEntity.set送付住所カナ(entity.get共同処理用受給者異動基本送付().getDdressKana());
        csvEntity.set送付住所(entity.get共同処理用受給者異動基本送付().getAddress());
        TelNo 電話番号 = entity.get共同処理用受給者異動基本送付().getTelNo();
        if (TelNo.EMPTY != 電話番号 && 電話番号 != null) {
            csvEntity.set電話番号(電話番号.getColumnValue());
        }
        csvEntity.set帳票出力順序コード(entity.get共同処理用受給者異動基本送付().getChohyoOutputJunjyoCode());
        return csvEntity;
    }

    /**
     * CSVのHeaderを取得します。
     *
     * @return HanyoListKyodoJukyushaCsvEntity
     */
    public static HanyoListKyodoJukyushaCsvEntity getHeader() {
        return new HanyoListKyodoJukyushaCsvEntity(
                HEADER_連番,
                HEADER_識別コード,
                HEADER_住民種別,
                HEADER_氏名,
                HEADER_氏名カナ,
                HEADER_生年月日,
                HEADER_年齢,
                HEADER_性別,
                HEADER_続柄コード,
                HEADER_世帯コード,
                HEADER_世帯主名,
                HEADER_住所コード,
                HEADER_郵便番号,
                HEADER_住所_番地_方書,
                HEADER_住所,
                HEADER_番地,
                HEADER_方書,
                HEADER_行政区コード,
                HEADER_行政区名,
                HEADER_地区１,
                HEADER_地区２,
                HEADER_地区３,
                HEADER_連絡先１,
                HEADER_連絡先２,
                HEADER_登録異動日,
                HEADER_登録事由,
                HEADER_登録届出日,
                HEADER_住定異動日,
                HEADER_住定事由,
                HEADER_住定届出日,
                HEADER_消除異動日,
                HEADER_消除事由,
                HEADER_消除届出日,
                HEADER_転出入理由,
                HEADER_前住所郵便番号,
                HEADER_前住所_番地_方書,
                HEADER_前住所,
                HEADER_前住所番地,
                HEADER_前住所方書,
                HEADER_市町村コード,
                HEADER_市町村名,
                HEADER_保険者コード,
                HEADER_保険者名,
                HEADER_空白,
                HEADER_処理対象年月,
                HEADER_被保険者番号,
                HEADER_履歴番号,
                HEADER_異動年月日,
                HEADER_異動区分,
                HEADER_異動事由,
                HEADER_給付_証記載保険者番号,
                HEADER_被保険者氏名漢字,
                HEADER_送付郵便番号,
                HEADER_送付住所カナ,
                HEADER_送付住所,
                HEADER_電話番号,
                HEADER_帳票出力順序コード);
    }

    public static HanyoListKyodoJukyushaNoRebanCsvEntity getHeaderNoRenban() {
        return new HanyoListKyodoJukyushaNoRebanCsvEntity(
                HEADER_識別コード,
                HEADER_住民種別,
                HEADER_氏名,
                HEADER_氏名カナ,
                HEADER_生年月日,
                HEADER_年齢,
                HEADER_性別,
                HEADER_続柄コード,
                HEADER_世帯コード,
                HEADER_世帯主名,
                HEADER_住所コード,
                HEADER_郵便番号,
                HEADER_住所_番地_方書,
                HEADER_住所,
                HEADER_番地,
                HEADER_方書,
                HEADER_行政区コード,
                HEADER_行政区名,
                HEADER_地区１,
                HEADER_地区２,
                HEADER_地区３,
                HEADER_連絡先１,
                HEADER_連絡先２,
                HEADER_登録異動日,
                HEADER_登録事由,
                HEADER_登録届出日,
                HEADER_住定異動日,
                HEADER_住定事由,
                HEADER_住定届出日,
                HEADER_消除異動日,
                HEADER_消除事由,
                HEADER_消除届出日,
                HEADER_転出入理由,
                HEADER_前住所郵便番号,
                HEADER_前住所_番地_方書,
                HEADER_前住所,
                HEADER_前住所番地,
                HEADER_前住所方書,
                HEADER_市町村コード,
                HEADER_市町村名,
                HEADER_保険者コード,
                HEADER_保険者名,
                HEADER_空白,
                HEADER_処理対象年月,
                HEADER_被保険者番号,
                HEADER_履歴番号,
                HEADER_異動年月日,
                HEADER_異動区分,
                HEADER_異動事由,
                HEADER_給付_証記載保険者番号,
                HEADER_被保険者氏名漢字,
                HEADER_送付郵便番号,
                HEADER_送付住所カナ,
                HEADER_送付住所,
                HEADER_電話番号,
                HEADER_帳票出力順序コード);
    }

    private RString format日付項目(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        RString temp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付編集()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }

    private RString format日付項目(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        RString temp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付編集()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }
}
