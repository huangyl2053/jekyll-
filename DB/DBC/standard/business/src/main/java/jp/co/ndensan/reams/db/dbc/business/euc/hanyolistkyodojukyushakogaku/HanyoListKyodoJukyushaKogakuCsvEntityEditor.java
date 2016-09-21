/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyodojukyushakogaku;

import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuSetaiShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710060.HanyoListKyodoJukyushaKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710060.HanyoListKyodoJukyushaKogakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710060.HanyoListKyodoJukyushaKogakuNoReBanCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710060.HanyoListKyodoJukyushaKogakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
public class HanyoListKyodoJukyushaKogakuCsvEntityEditor {

    private static final RString SLASH = new RString("/");
    private static final RString 有り = new RString("有り");
    private static final RString 無し = new RString("無し");

    private final HanyoListKyodoJukyushaKogakuEntity entity;
    private final HanyoListKyodoJukyushaKogakuProcessParameter param;
    private final Association 地方公共団体情報;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param param param
     * @param 地方公共団体情報 地方公共団体情報
     * @param 連番 連番
     */
    public HanyoListKyodoJukyushaKogakuCsvEntityEditor(HanyoListKyodoJukyushaKogakuEntity entity,
            HanyoListKyodoJukyushaKogakuProcessParameter param, Association 地方公共団体情報, int 連番) {
        this.entity = entity;
        this.param = param;
        this.地方公共団体情報 = 地方公共団体情報;
        this.連番 = 連番;
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKyodoJukyushaKogakuCsvEntity}
     */
    public HanyoListKyodoJukyushaKogakuCsvEntity edit() {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HanyoListKyodoJukyushaKogakuCsvEntity csvEntity = new HanyoListKyodoJukyushaKogakuCsvEntity();
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
        Association association = AssociationFinderFactory.
                createInstance().getAssociation(entity.get被保険者台帳管理().getShichosonCode());
        csvEntity.set市町村名(association.get市町村名());
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());

        csvEntity.set空白(RString.HALF_SPACE);
        edit_part2(csvEntity);
        return csvEntity;
    }

    private void edit_part2(HanyoListKyodoJukyushaKogakuCsvEntity csvEntity) {
        csvEntity.set処理対象年月(format日付項目(entity.get受給者異動高額().getSofuYM()));
        csvEntity.set被保険者番号(entity.get被保険者台帳管理().getHihokenshaNo().getColumnValue());
        csvEntity.set履歴番号(new RString(entity.get受給者異動高額().getRirekiNo()));
        csvEntity.set異動年月日(format日付項目(entity.get受給者異動高額().getIdoYMD()));
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getIdoKubunCode())) {
            csvEntity.set異動区分(JukyushaIF_IdoKubunCode.toValue(entity.get受給者異動高額().getIdoKubunCode()).get名称());
        } else {
            csvEntity.set異動区分(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getJukyushaIdoJiyu())) {
            csvEntity.set異動事由(JukyushaIF_JukyushaIdoJiyu.toValue(entity.get受給者異動高額().getJukyushaIdoJiyu()).get名称());
        } else {
            csvEntity.set異動事由(RString.EMPTY);
        }
        csvEntity.set給付証記載保険者番号(entity.get受給者異動高額().getShoKisaiHokenshaNo().getColumnValue());
        HihokenshaNo hihokenshaNo = entity.get受給者異動高額().getSetaiShuyakuNo();
        if (hihokenshaNo != null) {
            csvEntity.set世帯集約番号(hihokenshaNo.getColumnValue());
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getSetaiShotokuKubunCode())) {
            csvEntity.set世帯所得区分(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.toValue(entity.get受給者異動高額().getSetaiShotokuKubunCode()).get名称());
        } else {
            csvEntity.set世帯所得区分(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getShotokuKubunCode())) {
            csvEntity.set所得区分(JukyushaIF_KyodoKogakuShotokuKubunCode.toValue(entity.get受給者異動高額().getShotokuKubunCode()).get名称());
        } else {
            csvEntity.set所得区分(RString.EMPTY);
        }
        if (entity.get受給者異動高額().getRoureiFukushiNenkinJukyuAriFlag()) {
            csvEntity.set老齢福祉年金受給(有り);
        } else {
            csvEntity.set老齢福祉年金受給(無し);
        }
        if (entity.get受給者異動高額().getRiyoshaFutan2DankaiAriFlag()) {
            csvEntity.set利用者負担第２段階(有り);
        } else {
            csvEntity.set利用者負担第２段階(無し);
        }
        if (entity.get受給者異動高額().getShikyuShinseishoOutputAriFlag()) {
            csvEntity.set支給申請書出力の有無(有り);
        } else {
            csvEntity.set支給申請書出力の有無(無し);
        }
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKyodoJukyushaKogakuNoReBanCsvEntity}
     */
    public HanyoListKyodoJukyushaKogakuNoReBanCsvEntity noReBanEdit() {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HanyoListKyodoJukyushaKogakuNoReBanCsvEntity csvEntity = new HanyoListKyodoJukyushaKogakuNoReBanCsvEntity();
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
        Association association = AssociationFinderFactory.
                createInstance().getAssociation(entity.get被保険者台帳管理().getShichosonCode());
        csvEntity.set市町村名(association.get市町村名());
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());

        csvEntity.set空白(RString.HALF_SPACE);
        noReBanEdit_part2(csvEntity);
        return csvEntity;
    }

    private void noReBanEdit_part2(HanyoListKyodoJukyushaKogakuNoReBanCsvEntity csvEntity) {
        csvEntity.set処理対象年月(format日付項目(entity.get受給者異動高額().getSofuYM()));
        csvEntity.set被保険者番号(entity.get被保険者台帳管理().getHihokenshaNo().getColumnValue());
        csvEntity.set履歴番号(new RString(entity.get受給者異動高額().getRirekiNo()));
        csvEntity.set異動年月日(format日付項目(entity.get受給者異動高額().getIdoYMD()));
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getIdoKubunCode())) {
            csvEntity.set異動区分(JukyushaIF_IdoKubunCode.toValue(entity.get受給者異動高額().getIdoKubunCode()).get名称());
        } else {
            csvEntity.set異動区分(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getJukyushaIdoJiyu())) {
            csvEntity.set異動事由(JukyushaIF_JukyushaIdoJiyu.toValue(entity.get受給者異動高額().getJukyushaIdoJiyu()).get名称());
        } else {
            csvEntity.set異動事由(RString.EMPTY);
        }
        csvEntity.set給付証記載保険者番号(entity.get受給者異動高額().getShoKisaiHokenshaNo().getColumnValue());
        HihokenshaNo hihokenshaNo = entity.get受給者異動高額().getSetaiShuyakuNo();
        if (hihokenshaNo != null) {
            csvEntity.set世帯集約番号(hihokenshaNo.getColumnValue());
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getSetaiShotokuKubunCode())) {
            csvEntity.set世帯所得区分(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.toValue(entity.get受給者異動高額().getSetaiShotokuKubunCode()).get名称());
        } else {
            csvEntity.set世帯所得区分(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(entity.get受給者異動高額().getShotokuKubunCode())) {
            csvEntity.set所得区分(JukyushaIF_KyodoKogakuShotokuKubunCode.toValue(entity.get受給者異動高額().getShotokuKubunCode()).get名称());
        } else {
            csvEntity.set所得区分(RString.EMPTY);
        }
        if (entity.get受給者異動高額().getRoureiFukushiNenkinJukyuAriFlag()) {
            csvEntity.set老齢福祉年金受給(有り);
        } else {
            csvEntity.set老齢福祉年金受給(無し);
        }
        if (entity.get受給者異動高額().getRiyoshaFutan2DankaiAriFlag()) {
            csvEntity.set利用者負担第２段階(有り);
        } else {
            csvEntity.set利用者負担第２段階(無し);
        }
        if (entity.get受給者異動高額().getShikyuShinseishoOutputAriFlag()) {
            csvEntity.set支給申請書出力の有無(有り);
        } else {
            csvEntity.set支給申請書出力の有無(無し);
        }
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

    private RString format日付項目(FlexibleYearMonth month) {
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

}
