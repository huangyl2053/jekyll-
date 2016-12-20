/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.zenkaininteikekkajoho.KekkaShosaiJohoRelate;
import jp.co.ndensan.reams.db.dbz.business.core.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoRelate;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 前回結果情報のHandlerクラスです。
 *
 * @reamsid_L DBE-3000-020 dongyabin
 */
public class ZenkaiNinteiKekkaJohoHandler {

    private static final RString モード_照会 = new RString("ShokaiMode");
    private final ZenkaiNinteiKekkaJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ZenkaiNinteiKekkaJohoHandler(ZenkaiNinteiKekkaJohoDiv div) {
        this.div = div;
    }

    /**
     * 前回認定結果Divの初期化です。
     *
     * @param subGyomuCode 画面モード
     * @param shinseishoKanriNo 申請書管理番号
     * @param 参照結果 参照結果
     */
    public void onLoad(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果) {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, shinseishoKanriNo);
        div.setHdnDatabaseSubGyomuCode(subGyomuCode.getColumnValue());
        if (new RString("1").equals(参照結果)) {
            set前回情報(subGyomuCode, shinseishoKanriNo);
        } else if (new RString("2").equals(参照結果)) {
            set今回情報(subGyomuCode, shinseishoKanriNo);
        }
        div.setHdnKekkaShosaiJohoModel(DataPassingConverter.serialize(set結果詳細情報パラメータ(div, shinseishoKanriNo)));
    }

    public RString get要介護状態区分コード(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果) {
        RString 要介護状態区分コード = RString.EMPTY;
        if (new RString("1").equals(参照結果)) {
            要介護状態区分コード = set前回情報(subGyomuCode, shinseishoKanriNo);
        } else if (new RString("2").equals(参照結果)) {
            要介護状態区分コード = set今回情報(subGyomuCode, shinseishoKanriNo);
        }
        return 要介護状態区分コード;
    }

    private RString set前回情報(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo) {
        RString 要介護状態区分コード = RString.EMPTY;
        if (SubGyomuCode.DBD介護受給.equals(subGyomuCode)) {
            List<HokenshaNinteiShinseiJoho> hokenshaNinteiShinseiJohoList = getService()
                    .get要介護度_前回受給(shinseishoKanriNo).records();
            if (!hokenshaNinteiShinseiJohoList.isEmpty()) {
                HokenshaNinteiShinseiJoho joho = hokenshaNinteiShinseiJohoList.get(0);
                div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード().getColumnValue(), joho.get前回要介護状態区分コード()));
                div.getTxtNinteiDay().setValue(joho.get前回認定年月日());
                div.getTxtYukoKikanFrom().setValue(joho.get前回認定有効期間_開始());
                div.getTxtYukoKikanTo().setValue(joho.get前回認定有効期間_終了());
                要介護状態区分コード = joho.get前回要介護状態区分コード().value();
            }
        } else if (SubGyomuCode.DBE認定支援.equals(subGyomuCode)) {
            List<NinteiShinseiJoho> ninteiShinseiJohoList = getService()
                    .get要介護度_前回認定(shinseishoKanriNo).records();
            if (!ninteiShinseiJohoList.isEmpty()) {
                NinteiShinseiJoho joho = ninteiShinseiJohoList.get(0);
                div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード().getColumnValue(), joho.get前回要介護状態区分コード()));
                div.getTxtNinteiDay().setValue(joho.get前回認定年月日());
                div.getTxtYukoKikanFrom().setValue(joho.get前回認定有効期間_開始_());
                div.getTxtYukoKikanTo().setValue(joho.get前回認定有効期間_終了_());
                要介護状態区分コード = joho.get前回要介護状態区分コード().value();
            }
        }
        return 要介護状態区分コード;
    }

    private RString set今回情報(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo) {
        RString 要介護状態区分コード = RString.EMPTY;
        if (SubGyomuCode.DBD介護受給.equals(subGyomuCode)) {
            List<ZenkaiNinteiKekkaJohoRelate> zenkaiNinteiKekkaJohoList = getService().get要介護度_今回受給(shinseishoKanriNo).records();
            if (!zenkaiNinteiKekkaJohoList.isEmpty()) {
                ZenkaiNinteiKekkaJohoRelate joho = zenkaiNinteiKekkaJohoList.get(0);
                if (!RString.isNullOrEmpty(joho.get二次判定要介護状態区分コード())) {
                    div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード(), new Code(joho.get二次判定要介護状態区分コード())));
                }
                div.getTxtNinteiDay().setValue(set共通ポリシーパターン1(joho.get次判定年月日()));
                div.getTxtYukoKikanFrom().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効開始年月日()));
                div.getTxtYukoKikanTo().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効終了年月日()));
                要介護状態区分コード = joho.get二次判定要介護状態区分コード();
            }
        } else if (SubGyomuCode.DBE認定支援.equals(subGyomuCode)) {
            List<ZenkaiNinteiKekkaJohoRelate> zenkaiNinteiKekkaJohoList = getService().get要介護度_今回認定(shinseishoKanriNo).records();
            if (!zenkaiNinteiKekkaJohoList.isEmpty()) {
                ZenkaiNinteiKekkaJohoRelate joho = zenkaiNinteiKekkaJohoList.get(0);
                if (!RString.isNullOrEmpty(joho.get二次判定要介護状態区分コード())) {
                    div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード(), new Code(joho.get二次判定要介護状態区分コード())));
                }
                div.getTxtNinteiDay().setValue(set共通ポリシーパターン1(joho.get次判定年月日()));
                div.getTxtYukoKikanFrom().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効開始年月日()));
                div.getTxtYukoKikanTo().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効終了年月日()));
                要介護状態区分コード = joho.get二次判定要介護状態区分コード();
            }
        }
        return 要介護状態区分コード;
    }

    private FlexibleDate set共通ポリシーパターン1(RString date) {
        if (date != null) {
            return new FlexibleDate(date);
        }
        return null;
    }

    private RString set要介護度(RString 厚労省IF識別コード, Code 前回要介護状態区分コード) {
        RString 要介護度 = RString.EMPTY;
        if (前回要介護状態区分コード != null) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun99.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun02.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun06.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun09.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            }
        }
        return 要介護度;
    }

    /**
     * 結果詳細情報パラメータを設定します。
     *
     * @param model 結果詳細情報画面のパラメータ
     * @param 受給flag 受給flag
     * @param result 結果詳細情報
     * @param zenkaiShinseishoKanriNo 前回申請管理番号
     * @return 結果詳細情報画面のパラメータ
     */
    public KekkaShosaiJohoModel set結果詳細情報パラメータ(KekkaShosaiJohoModel model,
            boolean 受給flag,
            KekkaShosaiJohoRelate result,
            RString zenkaiShinseishoKanriNo) {
        model.setMode(モード_照会);
        NinteiInputDataPassModel passModel = new NinteiInputDataPassModel();
        passModel.set認定区分(get認定区分(result));
        passModel.setSubGyomuCode(SubGyomuCode.DBE認定支援.value());
        if (result.get認定申請年月日() != null && !result.get認定申請年月日().isEmpty()) {
            passModel.set認定年月日(new RDate(result.get認定申請年月日().toString()));
        }
        passModel.set申請書管理番号(new ShinseishoKanriNo(zenkaiShinseishoKanriNo));
        passModel.set厚労省IFコード(result.get厚労省IF識別コード());
        passModel.set要介護度コード(result.get二次判定要介護状態区分コード());
        passModel.set要介護度名称(get要介護度(result));
        if (result.get二次判定認定有効開始年月日() != null && !result.get二次判定認定有効開始年月日().isEmpty()) {
            passModel.set有効開始年月日(new RDate(result.get二次判定認定有効開始年月日().toString()));
        }
        if (result.get二次判定認定有効終了年月日() != null && !result.get二次判定認定有効終了年月日().isEmpty()) {
            passModel.set有効終了年月日(new RDate(result.get二次判定認定有効終了年月日().toString()));
        }
        passModel.set審査会意見(result.get介護認定審査会意見());
        model.setRiyu(result.get直近異動事由コード());
        model.setTorisageDay(result.get取下年月日());
        if (!RString.isNullOrEmpty(result.get認定申請区分_申請時_コード())) {
            model.setShinseiKubunShinsei(NinteiShinseiShinseijiKubunCode.toValue(result.get認定申請区分_申請時_コード()).get名称());
        }
        if (!RString.isNullOrEmpty(result.get認定申請区分_法令_コード())) {
            model.setShinseiKubunLaw(NinteiShinseiHoreiCode.toValue(result.get認定申請区分_法令_コード()).get名称());
        }
        if (受給flag) {
            passModel.setSubGyomuCode(SubGyomuCode.DBD介護受給.value());
            model.setIdoJiyuCode(result.get直近異動事由コード());
            model.setSakujoJiyuCode(result.get削除事由コード());
            model.setToshoNinteiKikanFrom(result.get当初認定有効開始年月日());
            model.setToshoNinteiKikanTo(result.get当初認定有効終了年月日());
            model.setJukyuShikakuHakkoDay1(result.get受給資格証明書発行年月日１());
            model.setJukyuShikakuHakkoDay2(result.get受給資格証明書発行年月日２());
        }
        model.setDataPassModel(passModel);
        return model;
    }

    private RString get認定区分(KekkaShosaiJohoRelate result) {
        if (TorisageKubunCode.認定申請有効.getコード().equals(result.get取下区分コード())) {
            return TorisageKubunCode.認定申請有効.getコード();
        } else {
            return TorisageKubunCode.却下.getコード();
        }
    }

    private RString get要介護度(KekkaShosaiJohoRelate result) {
        RString 要介護度 = RString.EMPTY;
        RString 要介護度コード = result.get二次判定要介護状態区分コード();
        RString 厚労省IF識別コード = result.get厚労省IF識別コード();
        if (!RString.isNullOrEmpty(要介護度コード)) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
            }
        }
        return 要介護度;
    }

    private KekkaShosaiJohoModel set結果詳細情報パラメータ(ZenkaiNinteiKekkaJohoDiv div, ShinseishoKanriNo 申請書管理番号) {
        KekkaShosaiJohoModel model = new KekkaShosaiJohoModel();
        if (SubGyomuCode.DBD介護受給.getColumnValue().equals(div.getHdnDatabaseSubGyomuCode())) {
            RString zenkaiShinseishoKanriNo = getService().get前回申請管理番号_受給(申請書管理番号);
            return set受給_結果詳細情報パラメータ(zenkaiShinseishoKanriNo);
        } else if (SubGyomuCode.DBE認定支援.getColumnValue().equals(div.getHdnDatabaseSubGyomuCode())) {
            RString zenkaiShinseishoKanriNo = getService().get前回申請管理番号_認定(申請書管理番号);
            return set認定_結果詳細情報パラメータ(zenkaiShinseishoKanriNo);
        }
        return model;
    }

    private KekkaShosaiJohoModel set受給_結果詳細情報パラメータ(RString zenkaiShinseishoKanriNo) {
        KekkaShosaiJohoModel model = new KekkaShosaiJohoModel();
        model.setMode(モード_照会);
        NinteiInputDataPassModel passModel = new NinteiInputDataPassModel();
        passModel.set申請書管理番号(ShinseishoKanriNo.EMPTY);
        model.setDataPassModel(passModel);
        if (!RString.isNullOrEmpty(zenkaiShinseishoKanriNo)) {
            List<KekkaShosaiJohoRelate> resultList = getService().get受給_結果詳細情報(zenkaiShinseishoKanriNo).records();
            if (!resultList.isEmpty()) {
                KekkaShosaiJohoRelate result = resultList.get(0);
                return set結果詳細情報パラメータ(model, true, result, zenkaiShinseishoKanriNo);
            }
        }
        return model;
    }

    private KekkaShosaiJohoModel set認定_結果詳細情報パラメータ(RString zenkaiShinseishoKanriNo) {
        KekkaShosaiJohoModel model = new KekkaShosaiJohoModel();
        model.setMode(モード_照会);
        NinteiInputDataPassModel passModel = new NinteiInputDataPassModel();
        passModel.set申請書管理番号(ShinseishoKanriNo.EMPTY);
        model.setDataPassModel(passModel);
        if (!RString.isNullOrEmpty(zenkaiShinseishoKanriNo)) {
            List<KekkaShosaiJohoRelate> resultList = getService().get認定_結果詳細情報(zenkaiShinseishoKanriNo).records();
            if (!resultList.isEmpty()) {
                KekkaShosaiJohoRelate result = resultList.get(0);
                return set結果詳細情報パラメータ(model, false, result, zenkaiShinseishoKanriNo);
            }
        }
        return model;
    }

    private ZenkaiNinteiKekkaJohoFinder getService() {
        return ZenkaiNinteiKekkaJohoFinder.createInstance();
    }
}
