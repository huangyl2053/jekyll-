/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyodojukyusha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710050.HanyoListKyodoJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710050.KyodoJukyushaKihonEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
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

    /**
     * CSVヘッダを設定します。
     *
     * @param processParameter HanyoListKyodoJukyushaProcessParameter
     * @return {@link List<RString>}
     */
    public List<RString> setHeaderList(HanyoListKyodoJukyushaProcessParameter processParameter) {
        List<RString> headerList = new ArrayList<>();
        if (processParameter.is連番付加()) {
            headerList.add(HEADER_連番);
        }
        headerList.add(HEADER_識別コード);
        headerList.add(HEADER_住民種別);
        headerList.add(HEADER_氏名);
        headerList.add(HEADER_氏名カナ);
        headerList.add(HEADER_生年月日);
        headerList.add(HEADER_年齢);
        headerList.add(HEADER_性別);
        headerList.add(HEADER_続柄コード);
        headerList.add(HEADER_世帯コード);
        headerList.add(HEADER_世帯主名);
        headerList.add(HEADER_住所コード);
        headerList.add(HEADER_郵便番号);
        headerList.add(HEADER_住所_番地_方書);
        headerList.add(HEADER_住所);
        headerList.add(HEADER_番地);
        headerList.add(HEADER_方書);
        headerList.add(HEADER_行政区コード);
        headerList.add(HEADER_行政区名);
        headerList.add(HEADER_地区１);
        headerList.add(HEADER_地区２);
        headerList.add(HEADER_地区３);
        headerList.add(HEADER_連絡先１);
        headerList.add(HEADER_連絡先２);
        headerList.add(HEADER_登録異動日);
        headerList.add(HEADER_登録事由);
        headerList.add(HEADER_登録届出日);
        headerList.add(HEADER_住定異動日);
        headerList.add(HEADER_住定事由);
        headerList.add(HEADER_住定届出日);
        headerList.add(HEADER_消除異動日);
        headerList.add(HEADER_消除事由);
        headerList.add(HEADER_消除届出日);
        headerList.add(HEADER_転出入理由);
        headerList.add(HEADER_前住所郵便番号);
        headerList.add(HEADER_前住所_番地_方書);
        headerList.add(HEADER_前住所);
        headerList.add(HEADER_前住所番地);
        headerList.add(HEADER_前住所方書);
        headerList.add(HEADER_市町村コード);
        headerList.add(HEADER_市町村名);
        headerList.add(HEADER_保険者コード);
        headerList.add(HEADER_保険者名);
        headerList.add(HEADER_空白);
        headerList.add(HEADER_処理対象年月);
        headerList.add(HEADER_被保険者番号);
        headerList.add(HEADER_履歴番号);
        headerList.add(HEADER_異動年月日);
        headerList.add(HEADER_異動区分);
        headerList.add(HEADER_異動事由);
        headerList.add(HEADER_給付_証記載保険者番号);
        headerList.add(HEADER_被保険者氏名漢字);
        headerList.add(HEADER_送付郵便番号);
        headerList.add(HEADER_送付住所カナ);
        headerList.add(HEADER_送付住所);
        headerList.add(HEADER_電話番号);
        headerList.add(HEADER_帳票出力順序コード);
        return headerList;
    }

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param param param
     * @param 地方公共団体情報 地方公共団体情報
     * @param 構成市町村マスタ 構成市町村マスタ
     * @param 連番 連番
     * @param 帳票制御共通 帳票制御共通
     * @return {@link List<RString>}
     */
    public List<RString> setBodyList(KyodoJukyushaKihonEntity entity, HanyoListKyodoJukyushaProcessParameter param,
            Association 地方公共団体情報, Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ, int 連番, ChohyoSeigyoKyotsu 帳票制御共通) {
        List<RString> bodyList = new ArrayList<>();
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        if (param.is連番付加()) {
            bodyList.add(new RString(連番));
        }
        bodyList.add(kojin.get識別コード().getColumnValue());
        bodyList.add(kojin.get住民状態().住民状態略称());
        bodyList.add(kojin.get名称().getName().getColumnValue());
        bodyList.add(kojin.get名称().getKana().getColumnValue());
        bodyList.add(format日付項目(kojin.get生年月日().toFlexibleDate(), param));
        bodyList.add(kojin.get年齢算出().get年齢());
        bodyList.add(kojin.get性別().getName().getShortJapanese());
        bodyList.add(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
        bodyList.add(kojin.get世帯コード().getColumnValue());
        bodyList.add(kojin.get世帯主名().getColumnValue());
        bodyList.add(kojin.get住所().get町域コード().getColumnValue());
        bodyList.add(kojin.get住所().get郵便番号().getEditedYubinNo());
        bodyList.add(JushoHenshu.editJusho(帳票制御共通, kojin, 地方公共団体情報));
        bodyList.add(kojin.get住所().get住所());
        bodyList.add(kojin.get住所().get番地().getBanchi().getColumnValue());
        bodyList.add(kojin.get住所().get方書().getColumnValue());
        bodyList.add(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        bodyList.add(kojin.get行政区画().getGyoseiku().get名称());
        bodyList.add(kojin.get行政区画().getChiku1().getコード().getColumnValue());
        bodyList.add(kojin.get行政区画().getChiku2().getコード().getColumnValue());
        bodyList.add(kojin.get行政区画().getChiku3().getコード().getColumnValue());
        bodyList.add(kojin.get連絡先１().getColumnValue());
        bodyList.add(kojin.get連絡先２().getColumnValue());
        bodyList.add(format日付項目(kojin.get登録異動年月日(), param));
        bodyList.add(kojin.get登録事由() != null ? kojin.get登録事由().get異動事由略称() : RString.EMPTY);
        bodyList.add(format日付項目(kojin.get登録届出年月日(), param));
        bodyList.add(format日付項目(kojin.get住定異動年月日(), param));
        bodyList.add(kojin.get住定事由() != null ? kojin.get住定事由().get異動事由略称() : RString.EMPTY);
        bodyList.add(format日付項目(kojin.get住定届出年月日(), param));
        bodyList.add(format日付項目(kojin.get消除異動年月日(), param));
        bodyList.add(kojin.get消除事由() != null ? kojin.get消除事由().get異動事由略称() : RString.EMPTY);
        bodyList.add(format日付項目(kojin.get消除届出年月日(), param));
        bodyList.add(RString.EMPTY);
        bodyList.add(kojin.get転入前().get郵便番号().getEditedYubinNo());
        if (kojin.get転入前().get方書() != null && !kojin.get転入前().get方書().isEmpty()) {
            bodyList.add(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()).
                    concat(RString.FULL_SPACE).concat(kojin.get転入前().get方書().getColumnValue()));
        } else {
            bodyList.add(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()));
        }
        bodyList.add(kojin.get転入前().get住所());
        bodyList.add(kojin.get転入前().get番地().getBanchi().getColumnValue());
        bodyList.add(kojin.get転入前().get方書().getColumnValue());
        bodyList.add(entity.get被保険者台帳管理().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get被保険者台帳管理().getShichosonCode())) {
            bodyList.add(構成市町村マスタ.get(entity.get被保険者台帳管理().getShichosonCode()).get市町村名称());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(地方公共団体情報.getLasdecCode_().getColumnValue());
        bodyList.add(地方公共団体情報.get市町村名());
        bodyList.add(空白);
        bodyList.add(format日付項目(entity.get共同処理用受給者異動基本送付().getSofuYM(), param));
        bodyList.add(entity.get共同処理用受給者異動基本送付().getHiHokenshaNo().getColumnValue());
        bodyList.add(new RString(entity.get共同処理用受給者異動基本送付().getRirekiNo()));
        bodyList.add(format日付項目(entity.get共同処理用受給者異動基本送付().getIdoYMD(), param));
        if (entity.get共同処理用受給者異動基本送付() != null) {
            if (!RString.isNullOrEmpty(entity.get共同処理用受給者異動基本送付().getIdoKubunCode())) {
                bodyList.add(JukyushaIF_IdoKubunCode.toValue(entity.get共同処理用受給者異動基本送付().getIdoKubunCode()).get名称());
            } else {
                bodyList.add(RString.EMPTY);
            }
//        bodyList.add(JukyushaIF_JukyushaIdoJiyu.toValue(entity.get共同処理用受給者異動基本送付().getJukyushaIdoJiyu()).get名称());
        }
        bodyList.add(RString.EMPTY);
        bodyList.add(entity.get共同処理用受給者異動基本送付().getShoKisaiHokenshaNo().getColumnValue());
        bodyList.add(entity.get共同処理用受給者異動基本送付().getHiHokenshaName());
        YubinNo 郵便番号 = entity.get共同処理用受給者異動基本送付().getYubinNo();
        if (YubinNo.EMPTY != 郵便番号 && 郵便番号 != null) {
            bodyList.add(郵便番号.getEditedYubinNo());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(entity.get共同処理用受給者異動基本送付().getDdressKana());
        bodyList.add(entity.get共同処理用受給者異動基本送付().getAddress());
        TelNo 電話番号 = entity.get共同処理用受給者異動基本送付().getTelNo();
        if (TelNo.EMPTY != 電話番号 && 電話番号 != null) {
            bodyList.add(電話番号.getColumnValue());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(entity.get共同処理用受給者異動基本送付().getChohyoOutputJunjyoCode());
        return bodyList;
    }

    private RString format日付項目(FlexibleDate date, HanyoListKyodoJukyushaProcessParameter param) {
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

    private RString format日付項目(FlexibleYearMonth date, HanyoListKyodoJukyushaProcessParameter param) {
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
