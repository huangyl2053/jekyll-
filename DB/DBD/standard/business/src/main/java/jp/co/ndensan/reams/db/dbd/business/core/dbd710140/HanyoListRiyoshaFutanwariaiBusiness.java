/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd710140;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 汎用リスト出力(利用者負担割合)_Business処理クラスです。
 *
 * @reamsid_L DBD-5810-030 panxiaobo
 */
public class HanyoListRiyoshaFutanwariaiBusiness {

    private static final RString 住所地特例 = new RString("住特");
    private static final RString 職権変更 = new RString("職権変更");
    private static final RString 削除データ = new RString("削除データ");
    private static final RString 発行不要 = new RString("発行不要");
    private static final RString 未発行 = new RString("未発行");
    private static final RString 一括発行 = new RString("一括発行");
    private static final RString 単票発行 = new RString("単票発行");
    private static final RString 直近 = new RString("直近");
    private static final RString 発行区分_0 = new RString("0");
    private static final RString 発行区分_1 = new RString("1");
    private static final RString 発行区分_2 = new RString("2");
    private boolean isCsvhitsukesurasyuhensyu;

    /**
     * ＣＳＶ情報
     *
     * @param eucCsvEntity 出力ＣＳＶ情報
     * @param entity SQL検索結果情報
     * @param association 地方公共団体情報
     * @param hokenshaList 保険者リスト
     * @param csvhitsukesurasyuhensyu 日付スラッシュ付加
     * @param 市町村名 市町村名
     */
    public void setEucCsvEntity(Association association, boolean csvhitsukesurasyuhensyu,
            HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity, HanyoRisutoRiyoshaFutanWariaiEntity entity,
            HokenshaList hokenshaList, RString 市町村名) {
        isCsvhitsukesurasyuhensyu = csvhitsukesurasyuhensyu;
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
            eucCsvEntity.set生年月日(set年月日(kojin.get生年月日().toFlexibleDate()));
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set性別(kojin.get性別().getName().getShortJapanese());
            eucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            eucCsvEntity.set世帯コード(kojin.get世帯コード().value());
            eucCsvEntity.set世帯主名(kojin.get世帯主名().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            eucCsvEntity.set住所番地方書(address.toRString());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            eucCsvEntity.set方書(kojin.get住所().get方書().value());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucCsvEntity.set地区１(kojin.get行政区画().getChiku1().get名称());
            eucCsvEntity.set地区２(kojin.get行政区画().getChiku2().get名称());
            eucCsvEntity.set地区３(kojin.get行政区画().getChiku3().get名称());
            eucCsvEntity.set連絡先１(kojin.get連絡先１().value());
            eucCsvEntity.set連絡先２(kojin.get連絡先２().value());
            eucCsvEntity.set登録異動日(set年月日(kojin.get登録異動年月日()));
            eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            eucCsvEntity.set登録届出日(set年月日(kojin.get登録届出年月日()));
            eucCsvEntity.set住定異動日(set年月日(kojin.get住定異動年月日()));
            eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            eucCsvEntity.set住定届出日(set年月日(kojin.get住定届出年月日()));
            eucCsvEntity.set消除異動日(set年月日(kojin.get消除異動年月日()));
            eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            eucCsvEntity.set消除届出日(set年月日(kojin.get消除届出年月日()));
            eucCsvEntity.set転出入理由(RString.EMPTY);
            eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            eucCsvEntity.set前住所番地方書(addressZen.toRString());
            eucCsvEntity.set前住所(kojin.get転入前().get住所());
            eucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            eucCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        eucCsvEntity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        eucCsvEntity.set市町村名(市町村名);
        eucCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        eucCsvEntity.set保険者名(association.getShichosonName_());
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        eucCsvEntity.set資格取得事由(set資格取得事由(entity.get被保険者台帳管理_資格取得事由コード()));
        eucCsvEntity.set資格取得日(set年月日(entity.get被保険者台帳管理_資格取得年月日()));
        eucCsvEntity.set資格取得届出日(set年月日(entity.get被保険者台帳管理_資格取得届出年月日()));
        eucCsvEntity.set喪失事由(set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード()));
        eucCsvEntity.set資格喪失日(set年月日(entity.get被保険者台帳管理_資格喪失年月日()));
        eucCsvEntity.set資格喪失届日(set年月日(entity.get被保険者台帳管理_資格喪失届出年月日()));
        eucCsvEntity.set被保険者区分(set資格区分(entity.get被保険者台帳管理_被保険者区分コード()));
        eucCsvEntity.set住所地特例状態(new RString("1").equals(entity.get被保険者台帳管理_住所地特例フラグ()) ? 住所地特例 : RString.EMPTY);
        LasdecCode lasdecCode;
        if (new RString("1").equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード());
        } else {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_市町村コード());
        }
        eucCsvEntity.set資格証記載保険者番号(hokenshaList.get(lasdecCode).get証記載保険者番号().value());
        setEucCsvEntity2(eucCsvEntity, entity);
    }

    /**
     * ＣＳＶ情報
     *
     * @return eucCsvEntity eucCsvEntity
     */
    public HanyoRisutoRiyoshaFutanWariaiEucCsvEntity setNewBlank() {
        HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity = new HanyoRisutoRiyoshaFutanWariaiEucCsvEntity();
        eucCsvEntity.set連番(RString.EMPTY);
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set氏名カナ(RString.EMPTY);
        eucCsvEntity.set生年月日(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set性別(RString.EMPTY);
        eucCsvEntity.set続柄コード(RString.EMPTY);
        eucCsvEntity.set世帯コード(RString.EMPTY);
        eucCsvEntity.set世帯主名(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
        eucCsvEntity.set住所番地方書(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set番地(RString.EMPTY);
        eucCsvEntity.set方書(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set行政区名(RString.EMPTY);
        eucCsvEntity.set地区１(RString.EMPTY);
        eucCsvEntity.set地区２(RString.EMPTY);
        eucCsvEntity.set地区３(RString.EMPTY);
        eucCsvEntity.set連絡先１(RString.EMPTY);
        eucCsvEntity.set連絡先２(RString.EMPTY);
        eucCsvEntity.set登録異動日(RString.EMPTY);
        eucCsvEntity.set登録事由(RString.EMPTY);
        eucCsvEntity.set登録届出日(RString.EMPTY);
        eucCsvEntity.set住定異動日(RString.EMPTY);
        eucCsvEntity.set住定事由(RString.EMPTY);
        eucCsvEntity.set住定届出日(RString.EMPTY);
        eucCsvEntity.set消除異動日(RString.EMPTY);
        eucCsvEntity.set消除事由(RString.EMPTY);
        eucCsvEntity.set消除届出日(RString.EMPTY);
        eucCsvEntity.set転出入理由(RString.EMPTY);
        eucCsvEntity.set前住所郵便番号(RString.EMPTY);
        eucCsvEntity.set前住所番地方書(RString.EMPTY);
        eucCsvEntity.set前住所(RString.EMPTY);
        eucCsvEntity.set前住所番地(RString.EMPTY);
        eucCsvEntity.set前住所方書(RString.EMPTY);
        eucCsvEntity.set市町村コード(RString.EMPTY);
        eucCsvEntity.set市町村名(RString.EMPTY);
        eucCsvEntity.set保険者コード(RString.EMPTY);
        eucCsvEntity.set保険者名(RString.EMPTY);
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set送付先氏名(RString.EMPTY);
        eucCsvEntity.set送付先氏名カナ(RString.EMPTY);
        eucCsvEntity.set送付先住所コード(RString.EMPTY);
        eucCsvEntity.set送付先郵便番号(RString.EMPTY);
        eucCsvEntity.set送付先住所番地方書(RString.EMPTY);
        eucCsvEntity.set送付先住所(RString.EMPTY);
        eucCsvEntity.set送付先番地(RString.EMPTY);
        eucCsvEntity.set送付先方書(RString.EMPTY);
        eucCsvEntity.set送付先行政区コード(RString.EMPTY);
        eucCsvEntity.set送付先行政区名(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set資格取得事由(RString.EMPTY);
        eucCsvEntity.set資格取得日(RString.EMPTY);
        eucCsvEntity.set資格取得届出日(RString.EMPTY);
        eucCsvEntity.set喪失事由(RString.EMPTY);
        eucCsvEntity.set資格喪失日(RString.EMPTY);
        eucCsvEntity.set資格喪失届日(RString.EMPTY);
        eucCsvEntity.set資格区分(RString.EMPTY);
        eucCsvEntity.set住所地特例状態(RString.EMPTY);
        eucCsvEntity.set資格証記載保険者番号(RString.EMPTY);
        eucCsvEntity.set職権フラグ(RString.EMPTY);
        eucCsvEntity.set資格区分(RString.EMPTY);
        eucCsvEntity.set負担割合区分(RString.EMPTY);
        eucCsvEntity.set判定区分(RString.EMPTY);
        eucCsvEntity.set判定日(RString.EMPTY);
        eucCsvEntity.set有効開始年月日(RString.EMPTY);
        eucCsvEntity.set有効終了年月日(RString.EMPTY);
        eucCsvEntity.set本人合計所得金額(RString.EMPTY);
        eucCsvEntity.set世帯１号被保険者数(RString.EMPTY);
        eucCsvEntity.set年金収入合計(RString.EMPTY);
        eucCsvEntity.setその他の合計所得金額合計(RString.EMPTY);
        eucCsvEntity.set更正事由(RString.EMPTY);
        eucCsvEntity.set交付年月日(RString.EMPTY);
        eucCsvEntity.set削除データ(RString.EMPTY);
        eucCsvEntity.set年度(RString.EMPTY);
        eucCsvEntity.set履歴番号(RString.EMPTY);
        eucCsvEntity.set枝番(RString.EMPTY);
        eucCsvEntity.set直近情報(RString.EMPTY);
        eucCsvEntity.set発行不要(RString.EMPTY);
        eucCsvEntity.set発行区分(RString.EMPTY);
        eucCsvEntity.set発行年月日(RString.EMPTY);
        return eucCsvEntity;
    }

    private void setEucCsvEntity2(HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity, HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            eucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
            eucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
            eucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
            eucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            RStringBuilder 送付address = new RStringBuilder();
            送付address.append(atesaki.get宛先住所().get住所()).append(atesaki.get宛先住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(atesaki.get宛先住所().get方書().value());
            eucCsvEntity.set送付先住所番地方書(送付address.toRString());
            eucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            eucCsvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            eucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
            eucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
            eucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
        eucCsvEntity.set職権フラグ(entity.is利用者負担割合_職権変更フラグ() ? 職権変更 : RString.EMPTY);
        eucCsvEntity.set資格区分(ShikakuKubun.toValue(entity.get利用者負担割合明細_資格区分().substring(entity.get利用者負担割合明細_資格区分().length()-1)).get名称());
        eucCsvEntity.set負担割合区分((entity.get利用者負担割合明細_負担割合区分() != null && !entity.get利用者負担割合明細_負担割合区分().isEmpty())
                ? FutanwariaiKubun.toValue(entity.get利用者負担割合明細_負担割合区分()).get名称() : RString.EMPTY);
        eucCsvEntity.set判定区分(entity.get利用者負担割合_判定区分());
        eucCsvEntity.set判定日(set年月日(entity.get利用者負担割合_判定日()));
        eucCsvEntity.set有効開始年月日(set年月日(entity.get利用者負担割合明細_有効開始日()));
        eucCsvEntity.set有効終了年月日(set年月日(entity.get利用者負担割合明細_有効終了日()));
        eucCsvEntity.set本人合計所得金額(new RString(entity.get利用者負担割合明細_本人合計所得金額().toString()));
        eucCsvEntity.set世帯１号被保険者数(new RString(String.valueOf(entity.get利用者負担割合明細_世帯１号被保険者数())));
        eucCsvEntity.set年金収入合計(new RString(entity.get利用者負担割合明細_年金収入合計().toString()));
        if (entity.get利用者負担割合明細_その他の金額合計() != null) {
            eucCsvEntity.setその他の合計所得金額合計(new RString(entity.get利用者負担割合明細_その他の金額合計().toString()));
        }
        eucCsvEntity.set更正事由(entity.get利用者負担割合_更正事由());
        eucCsvEntity.set交付年月日(set年月日(entity.get利用者負担割合_交付日()));
        eucCsvEntity.set削除データ(entity.is利用者負担割合明細_論理削除フラグ() ? 削除データ : RString.EMPTY);
        eucCsvEntity.set年度(entity.get利用者負担割合_年度().toDateString());
        eucCsvEntity.set履歴番号(new RString(String.valueOf(entity.get利用者負担割合_履歴番号())));
        eucCsvEntity.set枝番(new RString(String.valueOf(entity.get利用者負担割合明細_枝番号())));
        eucCsvEntity.set直近情報(entity.get利用者負担割合明細_履歴番号() == entity.get利用者負担割合明細2_履歴番号()
                && entity.get利用者負担割合明細_枝番号() == entity.get利用者負担割合明細2_枝番号() ? 直近 : RString.EMPTY);
        eucCsvEntity.set発行不要(entity.is利用者負担割合_発行不要フラグ() ? 発行不要 : RString.EMPTY);
        if (entity.get利用者負担割合_発行区分() != null) {
            if (entity.get利用者負担割合_発行区分().equals(発行区分_0)) {
                eucCsvEntity.set発行区分(未発行);
            } else if (entity.get利用者負担割合_発行区分().equals(発行区分_1)) {
                eucCsvEntity.set発行区分(一括発行);
            } else if (entity.get利用者負担割合_発行区分().equals(発行区分_2)) {
                eucCsvEntity.set発行区分(単票発行);
            } else {
                eucCsvEntity.set発行区分(RString.EMPTY);
            }
        }
        eucCsvEntity.set発行年月日(set年月日(entity.get利用者負担割合_発行日()));
    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (isCsvhitsukesurasyuhensyu) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        }

    }

    private RString set資格区分(RString 被保険者区分コード) {
        if (RString.isNullOrEmpty(被保険者区分コード)) {
            return RString.EMPTY;
        }
        return HihokenshaKubunCode.toValue(被保険者区分コード).get名称();
    }

    private RString set資格取得事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 資格取得事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), new Code(事由コード));
        if (資格取得事由 == null) {
            return RString.EMPTY;
        }
        return 資格取得事由.getコード略称();
    }

    private RString set喪失事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 喪失事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), new Code(事由コード));
        if (喪失事由 == null) {
            return RString.EMPTY;
        }
        return 喪失事由.getコード略称();
    }
}
