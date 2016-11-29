/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyodojukyushakogaku;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuSetaiShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710060.HanyoListKyodoJukyushaKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710060.HanyoListKyodoJukyushaKogakuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 汎用リスト 共同処理用受給者情報（高額）CSVデータの編集クラスです。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
public class HanyoListKyodoJukyushaKogakuCsvEditor {

    private static final RString SLASH = new RString("/");
    private static final RString 有り = new RString("有り");
    private static final RString 無し = new RString("無し");
    private static final RString CSV_連番 = new RString("連番");
    private static final RString CSV_識別コード = new RString("識別コード");
    private static final RString CSV_住民種別 = new RString("住民種別");
    private static final RString CSV_氏名 = new RString("氏名");
    private static final RString CSV_氏名カナ = new RString("氏名カナ");
    private static final RString CSV_生年月日 = new RString("生年月日");
    private static final RString CSV_年齢 = new RString("年齢");
    private static final RString CSV_性別 = new RString("性別");
    private static final RString CSV_続柄コード = new RString("続柄コード");
    private static final RString CSV_世帯コード = new RString("世帯コード");
    private static final RString CSV_世帯主名 = new RString("世帯主名");
    private static final RString CSV_住所コード = new RString("住所コード");
    private static final RString CSV_郵便番号 = new RString("郵便番号");
    private static final RString CSV_住所番地方書 = new RString("住所＋番地＋方書");
    private static final RString CSV_住所 = new RString("住所");
    private static final RString CSV_番地 = new RString("番地");
    private static final RString CSV_方書 = new RString("方書");
    private static final RString CSV_行政区コード = new RString("行政区コード");
    private static final RString CSV_行政区名 = new RString("行政区名");
    private static final RString CSV_地区１ = new RString("地区１");
    private static final RString CSV_地区２ = new RString("地区２");
    private static final RString CSV_地区３ = new RString("地区３");
    private static final RString CSV_連絡先１ = new RString("連絡先１");
    private static final RString CSV_連絡先２ = new RString("連絡先２");
    private static final RString CSV_登録異動日 = new RString("登録異動日");
    private static final RString CSV_登録事由 = new RString("登録事由");
    private static final RString CSV_登録届出日 = new RString("登録届出日");
    private static final RString CSV_住定異動日 = new RString("住定異動日");
    private static final RString CSV_住定事由 = new RString("住定事由");
    private static final RString CSV_住定届出日 = new RString("住定届出日");
    private static final RString CSV_消除異動日 = new RString("消除異動日");
    private static final RString CSV_消除事由 = new RString("消除事由");
    private static final RString CSV_消除届出日 = new RString("消除届出日");
    private static final RString CSV_転出入理由 = new RString("転出入理由");
    private static final RString CSV_前住所郵便番号 = new RString("前住所郵便番号");
    private static final RString CSV_前住所番地方書 = new RString("前住所＋番地＋方書");
    private static final RString CSV_前住所 = new RString("前住所");
    private static final RString CSV_前住所番地 = new RString("前住所番地");
    private static final RString CSV_前住所方書 = new RString("前住所方書");
    private static final RString CSV_市町村コード = new RString("市町村コード");
    private static final RString CSV_市町村名 = new RString("市町村名");
    private static final RString CSV_保険者コード = new RString("保険者コード");
    private static final RString CSV_保険者名 = new RString("保険者名");
    private static final RString CSV_空白 = new RString("空白");
    private static final RString CSV_処理対象年月 = new RString("処理対象年月");
    private static final RString CSV_被保険者番号 = new RString("被保険者番号");
    private static final RString CSV_履歴番号 = new RString("履歴番号");
    private static final RString CSV_異動年月日 = new RString("異動年月日");
    private static final RString CSV_異動区分 = new RString("異動区分");
    private static final RString CSV_異動事由 = new RString("異動事由");
    private static final RString CSV_給付_証記載保険者番号 = new RString("（給付）証記載保険者番号");
    private static final RString CSV_世帯集約番号 = new RString("世帯集約番号");
    private static final RString CSV_世帯所得区分 = new RString("世帯所得区分");
    private static final RString CSV_所得区分 = new RString("所得区分");
    private static final RString CSV_老齢福祉年金受給 = new RString("老齢福祉年金受給");
    private static final RString CSV_利用者負担第２段階 = new RString("利用者負担第２段階");
    private static final RString CSV_支給申請書出力の有無 = new RString("支給申請書出力の有無");

    /**
     * CSVヘッダを設定します。
     *
     * @param processParameter HanyoListKyodoJukyushaKogakuProcessParameter
     * @return {@link List<RString>}
     */
    public List<RString> setHeaderList(HanyoListKyodoJukyushaKogakuProcessParameter processParameter) {
        List<RString> headerList = new ArrayList<>();
        if (processParameter.is連番付加()) {
            headerList.add(CSV_連番);
        }
        headerList.add(CSV_識別コード);
        headerList.add(CSV_住民種別);
        headerList.add(CSV_氏名);
        headerList.add(CSV_氏名カナ);
        headerList.add(CSV_生年月日);
        headerList.add(CSV_年齢);
        headerList.add(CSV_性別);
        headerList.add(CSV_続柄コード);
        headerList.add(CSV_世帯コード);
        headerList.add(CSV_世帯主名);
        headerList.add(CSV_住所コード);
        headerList.add(CSV_郵便番号);
        headerList.add(CSV_住所番地方書);
        headerList.add(CSV_住所);
        headerList.add(CSV_番地);
        headerList.add(CSV_方書);
        headerList.add(CSV_行政区コード);
        headerList.add(CSV_行政区名);
        headerList.add(CSV_地区１);
        headerList.add(CSV_地区２);
        headerList.add(CSV_地区３);
        headerList.add(CSV_連絡先１);
        headerList.add(CSV_連絡先２);
        headerList.add(CSV_登録異動日);
        headerList.add(CSV_登録事由);
        headerList.add(CSV_登録届出日);
        headerList.add(CSV_住定異動日);
        headerList.add(CSV_住定事由);
        headerList.add(CSV_住定届出日);
        headerList.add(CSV_消除異動日);
        headerList.add(CSV_消除事由);
        headerList.add(CSV_消除届出日);
        headerList.add(CSV_転出入理由);
        headerList.add(CSV_前住所郵便番号);
        headerList.add(CSV_前住所番地方書);
        headerList.add(CSV_前住所);
        headerList.add(CSV_前住所番地);
        headerList.add(CSV_前住所方書);
        headerList.add(CSV_市町村コード);
        headerList.add(CSV_市町村名);
        headerList.add(CSV_保険者コード);
        headerList.add(CSV_保険者名);
        headerList.add(CSV_空白);
        headerList.add(CSV_処理対象年月);
        headerList.add(CSV_被保険者番号);
        headerList.add(CSV_履歴番号);
        headerList.add(CSV_異動年月日);
        headerList.add(CSV_異動区分);
        headerList.add(CSV_異動事由);
        headerList.add(CSV_給付_証記載保険者番号);
        headerList.add(CSV_世帯集約番号);
        headerList.add(CSV_世帯所得区分);
        headerList.add(CSV_所得区分);
        headerList.add(CSV_老齢福祉年金受給);
        headerList.add(CSV_利用者負担第２段階);
        headerList.add(CSV_支給申請書出力の有無);
        return headerList;
    }

    /**
     * CSVレコードを取得します。
     *
     * @param entity HanyoListKyodoJukyushaKogakuEntity
     * @param param HanyoListKyodoJukyushaKogakuProcessParameter
     * @param 構成市町村マスタ Map<LasdecCode, KoseiShichosonMaster>
     * @param 地方公共団体情報 Association
     * @param 連番 int
     * @param 帳票制御共通 帳票制御共通
     * @return {@link List<RString>}
     */
    public List<RString> setBodyList(HanyoListKyodoJukyushaKogakuEntity entity, HanyoListKyodoJukyushaKogakuProcessParameter param,
            Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ, Association 地方公共団体情報, int 連番, ChohyoSeigyoKyotsu 帳票制御共通) {
        List<RString> bodyList = new ArrayList<>();
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理 = entity.get被保険者台帳管理();
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
        if (kojin.get登録事由() != null) {
            bodyList.add(kojin.get登録事由().get異動事由略称());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(format日付項目(kojin.get登録届出年月日(), param));
        bodyList.add(format日付項目(kojin.get住定異動年月日(), param));
        if (kojin.get住定事由() != null) {
            bodyList.add(kojin.get住定事由().get異動事由略称());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(format日付項目(kojin.get住定届出年月日(), param));
        bodyList.add(format日付項目(kojin.get消除異動年月日(), param));
        if (kojin.get消除事由() != null) {
            bodyList.add(kojin.get消除事由().get異動事由略称());
        } else {
            bodyList.add(RString.EMPTY);
        }
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
        if (構成市町村マスタ.containsKey(被保険者台帳管理.getShichosonCode())) {
            bodyList.add(構成市町村マスタ.get(被保険者台帳管理.getShichosonCode()).get市町村名称());
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(地方公共団体情報.getLasdecCode_().getColumnValue());
        bodyList.add(地方公共団体情報.get市町村名());
        bodyList.add(RString.HALF_SPACE);
        bodyList.add(format日付項目(entity.get受給者異動高額().getSofuYM(), param));
        bodyList.add(entity.get被保険者台帳管理().getHihokenshaNo().getColumnValue());
        bodyList.add(new RString(entity.get受給者異動高額().getRirekiNo()));
        bodyList.add(format日付項目(entity.get受給者異動高額().getIdoYMD(), param));
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getIdoKubunCode())) {
            bodyList.add(edit異動区分(entity.get受給者異動高額().getIdoKubunCode()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getJukyushaIdoJiyu())) {
            bodyList.add(edit異動事由(entity.get受給者異動高額().getJukyushaIdoJiyu()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(entity.get受給者異動高額().getShoKisaiHokenshaNo().getColumnValue());
        HihokenshaNo hihokenshaNo = entity.get受給者異動高額().getSetaiShuyakuNo();
        if (hihokenshaNo != null) {
            bodyList.add(hihokenshaNo.getColumnValue());
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getSetaiShotokuKubunCode())) {
            bodyList.add(edit世帯所得区分(entity.get受給者異動高額().getSetaiShotokuKubunCode()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getShotokuKubunCode())) {
            bodyList.add(edit所得区分(entity.get受給者異動高額().getShotokuKubunCode()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (entity.get受給者異動高額().getRoureiFukushiNenkinJukyuAriFlag()) {
            bodyList.add(有り);
        } else {
            bodyList.add(無し);
        }
        if (entity.get受給者異動高額().getRiyoshaFutan2DankaiAriFlag()) {
            bodyList.add(有り);
        } else {
            bodyList.add(無し);
        }
        if (entity.get受給者異動高額().getShikyuShinseishoOutputAriFlag()) {
            bodyList.add(有り);
        } else {
            bodyList.add(無し);
        }
        return bodyList;
    }

    private RString format日付項目(FlexibleDate date, HanyoListKyodoJukyushaKogakuProcessParameter param) {
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

    private RString format日付項目(FlexibleYearMonth month, HanyoListKyodoJukyushaKogakuProcessParameter param) {
        if (month == null) {
            return RString.EMPTY;
        }
        RString temp = month.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付編集()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }

    private RString edit異動区分(RString idoKubunCode) {
        if (RString.isNullOrEmpty(idoKubunCode)) {
            return RString.EMPTY;
        } else if (JukyushaIF_IdoKubunCode.新規.getコード().equals(idoKubunCode)) {
            return JukyushaIF_IdoKubunCode.新規.get名称();
        } else if (JukyushaIF_IdoKubunCode.変更.getコード().equals(idoKubunCode)) {
            return JukyushaIF_IdoKubunCode.変更.get名称();
        } else if (JukyushaIF_IdoKubunCode.終了.getコード().equals(idoKubunCode)) {
            return JukyushaIF_IdoKubunCode.終了.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit異動事由(RString idoJiyu) {
        if (RString.isNullOrEmpty(idoJiyu)) {
            return RString.EMPTY;
        } else if (JukyushaIF_JukyushaIdoJiyu.受給資格取得.getコード().equals(idoJiyu)) {
            return JukyushaIF_JukyushaIdoJiyu.受給資格取得.get名称();
        } else if (JukyushaIF_JukyushaIdoJiyu.受給資格喪失.getコード().equals(idoJiyu)) {
            return JukyushaIF_JukyushaIdoJiyu.受給資格喪失.get名称();
        } else if (JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.getコード().equals(idoJiyu)) {
            return JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.get名称();
        } else if (JukyushaIF_JukyushaIdoJiyu.合併による新規.getコード().equals(idoJiyu)) {
            return JukyushaIF_JukyushaIdoJiyu.合併による新規.get名称();
        } else if (JukyushaIF_JukyushaIdoJiyu.その他異動.getコード().equals(idoJiyu)) {
            return JukyushaIF_JukyushaIdoJiyu.その他異動.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit世帯所得区分(RString setaiShotokuKubunCode) {
        if (RString.isNullOrEmpty(setaiShotokuKubunCode)) {
            return RString.EMPTY;
        } else if (JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.一般.getコード().equals(setaiShotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.一般.get名称();
        } else if (JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.市町村民税世帯非課税者等.getコード().equals(setaiShotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.市町村民税世帯非課税者等.get名称();
        } else if (JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.生活保護.getコード().equals(setaiShotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.生活保護.get名称();
        } else if (JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.getコード().equals(setaiShotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.get名称();
        } else if (JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.getコード().equals(setaiShotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit所得区分(RString shotokuKubunCode) {
        if (RString.isNullOrEmpty(shotokuKubunCode)) {
            return RString.EMPTY;
        } else if (JukyushaIF_KyodoKogakuShotokuKubunCode.一般.getコード().equals(shotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.一般.get名称();
        } else if (JukyushaIF_KyodoKogakuShotokuKubunCode.市町村民税世帯非課税者等.getコード().equals(shotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.市町村民税世帯非課税者等.get名称();
        } else if (JukyushaIF_KyodoKogakuShotokuKubunCode.生活保護.getコード().equals(shotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.生活保護.get名称();
        } else if (JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.getコード().equals(shotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.get名称();
        } else if (JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.getコード().equals(shotokuKubunCode)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.get名称();
        } else {
            return RString.EMPTY;
        }
    }
}
