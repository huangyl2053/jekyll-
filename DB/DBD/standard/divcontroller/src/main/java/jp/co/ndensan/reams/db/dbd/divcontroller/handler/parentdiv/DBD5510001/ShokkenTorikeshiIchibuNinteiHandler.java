/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5510001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001.ShokkenTorikeshiIchibuNinteiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoOutModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoServiceShuri;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
public class ShokkenTorikeshiIchibuNinteiHandler {

    private final ShokkenTorikeshiIchibuNinteiDiv div;

    private static final RString メニュID_職権修正 = new RString("DBDMN55002");
    private static final RString メニュID_職権取消一部喪失 = new RString("DBDMN55004");
    private static final RString メニュID_区分変更認定 = new RString("DBDMN52003");
    private static final RString メニュID_サービス変更認定 = new RString("DBDMN52004");
    private static final RString メニュID_認定データ更新 = new RString("DBDMN52013");
    private static final RString KEY0 = new RString("key0");
    private static final RString 符号 = new RString(";");
    private static final RString タイトル_職権修正 = new RString("職権修正");
    private static final RString タイトル_職権取消一部喪失 = new RString("職権取消(一部喪失)");
    private static final RString タイトル_要介護認定区分変更認定 = new RString("区分変更認定");
    private static final RString タイトル_要介護認定サービス変更認定 = new RString("サービス変更認定");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final RString 認定区分_却 = new RString("却");
    private static final RString 認定区分_喪 = new RString("喪");
    private static final RString 渡された認定区分_却下 = new RString("却");

    /**
     * コンストラクタです。
     *
     * @param div 職権修正/職権取消(一部)/認定結果入力(サ変・区変)のコントロールdiv
     */
    public ShokkenTorikeshiIchibuNinteiHandler(ShokkenTorikeshiIchibuNinteiDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param menuId メニューID
     * @param 今回情報 認定情報_今回情報
     * @param 前回情報 認定情報_前回情報
     */
    public void initialize(ShinseishoKanriNo 申請書管理番号, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, RString menuId,
            ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness 前回情報) {

        div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(申請書管理番号, 識別コード);
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        div.getCcdShinseiTodokedesha().set状態(new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(new RString(NinteiShinseiTodokedeshaDiv.DisplayType.管内.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        if (メニュID_職権修正.equals(menuId)) {
            div.setTitle(タイトル_職権修正);
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(new RString(
                    KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokkenShuseiAndTorikeshiMode.toString()));
            div.getTxtSoshitsubi().setDisabled(false);
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            div.setTitle(タイトル_職権取消一部喪失);
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(new RString(
                    KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokkenShuseiAndTorikeshiMode.toString()));
            div.getTxtSoshitsubi().setDisabled(false);
        } else if (メニュID_区分変更認定.equals(menuId) || メニュID_認定データ更新.equals(menuId)) {
            div.setTitle(タイトル_要介護認定区分変更認定);
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(new RString(
                    KaigoNinteiShinseiKihonJohoInputDiv.InputType.KubunHenkoMode.toString()));
            div.getTxtSoshitsubi().setDisabled(true);
        } else if (メニュID_サービス変更認定.equals(menuId)) {
            div.setTitle(タイトル_要介護認定サービス変更認定);
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(new RString(
                    KaigoNinteiShinseiKihonJohoInputDiv.InputType.ServiceHenkoMode.toString()));
            div.getTxtSoshitsubi().setDisabled(true);
        }
        if (今回情報 == null) {
            div.setHdnShokikomoku(get画面項目());
            return;
        }
        div.getCcdKaigoNinteiShikakuInfo().initialize(今回情報.get受給者台帳().get市町村コード().value(), 今回情報.get受給者台帳().get被保険者番号().value());
        div.getCcdKaigoNinteiShinseiKihonJohoInput().initialize();
        set介護認定申請基本情報(今回情報);
        set認定情報(今回情報, 前回情報);

        NinteiShinseiTodokedeshaDataPassModel model = new NinteiShinseiTodokedeshaDataPassModel();
        DbT4120ShinseitodokedeJoho 申請届出者情報 = 今回情報.get申請届出者情報();
        model.set申請書管理番号(申請書管理番号.value());
        model.setカナ氏名(申請届出者情報.get申請届出者氏名カナ());
        model.set住所(申請届出者情報.get申請届出者住所());
        model.set氏名(申請届出者情報.get申請届出者氏名());
        model.set続柄(申請届出者情報.get申請届出者続柄());
        model.set識別コード(識別コード.value());
        model.set事業者区分(申請届出者情報.get事業者区分());
        if (申請届出者情報.get申請届出代行区分コード() != null) {
            model.set申請届出代行区分コード(申請届出者情報.get申請届出代行区分コード().value());
        }
        if (申請届出者情報.get申請届出代行事業者番号() != null) {
            model.set申請届出代行事業者番号(申請届出者情報.get申請届出代行事業者番号().value());
        }
        if (申請届出者情報.get申請届出者郵便番号() != null) {
            model.set郵便番号(申請届出者情報.get申請届出者郵便番号().value());
        }
        if (申請届出者情報.get申請届出者電話番号() != null) {
            model.set電話番号(申請届出者情報.get申請届出者電話番号().value());
        }
        div.getCcdShinseiTodokedesha().initialize(model);
        div.getCcdShujiiIryokikanAndShujiiInput().initialize(
                今回情報.get主治医医療機関情報().get市町村コード(), 申請書管理番号, SubGyomuCode.DBD介護受給, 今回情報.get主治医医療機関情報().get主治医医療機関コード(),
                今回情報.get主治医医療機関情報().get医療機関名称(), 今回情報.get主治医情報().get主治医コード(), 今回情報.get主治医情報().get主治医氏名());
        div.getCcdShujiiIryokikanAndShujiiInput().setShiteii(今回情報.get要介護認定申請情報().is指定医フラグ());
        div.getCcdChosaItakusakiAndChosainInput().setHdnShichosonCode(今回情報.get認定調査委託先情報().get市町村コード().value());
        div.getCcdChosaItakusakiAndChosainInput().setHdnShinseishoKanriNo(申請書管理番号.value());
        RString 認定調査委託先コード = RString.EMPTY;
        if (今回情報.get認定調査委託先情報().get認定調査委託先コード() != null) {
            認定調査委託先コード = 今回情報.get認定調査委託先情報().get認定調査委託先コード();
        }
        RString 認定調査員コード = RString.EMPTY;
        if (今回情報.get調査員情報().get認定調査員コード() != null) {
            認定調査員コード = 今回情報.get調査員情報().get認定調査員コード();
        }
        div.getCcdChosaItakusakiAndChosainInput().initialize(new RString(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode.toString()),
                認定調査委託先コード, 今回情報.get認定調査委託先情報().get事業者名称(), 認定調査員コード, 今回情報.get調査員情報().get調査員氏名());
        if (今回情報.get受給者台帳().get喪失年月日() != null && !今回情報.get受給者台帳().get喪失年月日().isEmpty()) {
            div.getTxtSoshitsubi().setValue(new RDate(今回情報.get受給者台帳().get喪失年月日().toString()));
        }
        div.setHdnRenrakuJiko(今回情報.get要介護認定申請情報().get市町村連絡事項());
        div.setHdnShokikomoku(get画面項目());
    }

    /**
     * 「今回認定値」ダイアログOPENボタン押した後のメソッドです。
     *
     * @param 認定情報 認定情報
     * @param menuId メニューID
     * @param is今回 今回情報かどうか
     * @return 結果詳細情報画面のパラメータ
     */
    public KekkaShosaiJohoModel getKekkaShosaiJohoModel(ShokkenTorikeshiNinteiJohoKonkaiBusiness 認定情報, RString menuId, boolean is今回) {

        KekkaShosaiJohoOutModel outModel = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        KekkaShosaiJohoModel model = new KekkaShosaiJohoModel();
        NinteiInputDataPassModel passModel = new NinteiInputDataPassModel();
        passModel.setSubGyomuCode(SubGyomuCode.DBD介護受給.value());
        if (メニュID_職権修正.equals(menuId)) {
            model.setMode(new RString(KekkaShosaiJohoDiv.ShoriType.SoshitsuMode.toString()));
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            model.setMode(new RString(KekkaShosaiJohoDiv.ShoriType.ShokkenTorikeshiInputMode.toString()));
        } else {
            model.setMode(new RString(KekkaShosaiJohoDiv.ShoriType.InputMode.toString()));
        }
        if (!is今回 || (is今回 && outModel == null)) {
            passModel.set認定区分(new RString("1"));
            passModel.setみなし更新認定(new ArrayList<RString>());
            if (認定情報 == null) {
                passModel.set申請書管理番号(ShinseishoKanriNo.EMPTY);
                model.setDataPassModel(passModel);
                return model;
            }
            DbT4101NinteiShinseiJoho 要介護認定申請情報 = 認定情報.get要介護認定申請情報();
            passModel.set申請書管理番号(要介護認定申請情報.get申請書管理番号());
            JukyushaDaicho 受給者台帳 = 認定情報.get受給者台帳();
            passModel.set厚労省IFコード(convertCodeToRString(要介護認定申請情報.get厚労省IF識別コード()));
            passModel.set有効開始年月日(受給者台帳.get認定有効期間開始年月日());
            passModel.set有効終了年月日(受給者台帳.get認定有効期間終了年月日());
            passModel.set要介護度コード(受給者台帳.get要介護認定状態区分コード().getKey());
            passModel.set要介護度名称(get要介護度名(要介護認定申請情報.get厚労省IF識別コード(), 受給者台帳.get要介護認定状態区分コード().value()));
            passModel.set審査会意見(認定情報.get要介護認定結果情報().get介護認定審査会意見());
            passModel.set認定年月日(受給者台帳.get認定年月日());
            model.setDataPassModel(passModel);
            model.setIdoJiyuCode(convertCodeToRString(受給者台帳.getデータ区分()));
            model.setJukyuShikakuHakkoDay1(受給者台帳.get受給資格証明書発行年月日１());
            model.setJukyuShikakuHakkoDay2(受給者台帳.get受給資格証明書発行年月日２());
            model.setRiyu(受給者台帳.get異動理由());
            model.setSakujoJiyuCode(convertCodeToRString(受給者台帳.get削除事由コード()));
            model.setShinseiKubunLaw(convertCodeToRString(要介護認定申請情報.get認定申請区分_法令_コード()));
            model.setShinseiKubunShinsei(convertCodeToRString(要介護認定申請情報.get認定申請区分_申請時_コード()));
            model.setSoshitsuDay(受給者台帳.get喪失年月日());
            model.setTorisageDay(要介護認定申請情報.get取下年月日());
            model.setToshoNinteiKikanFrom(受給者台帳.get当初認定有効開始年月日());
            model.setToshoNinteiKikanTo(受給者台帳.get当初認定有効終了年月日());
        } else {
            NinteiInputNaiyo 認定内容 = outModel.get認定内容();
            passModel.set認定区分(認定内容.get認定区分());
            passModel.setみなし更新認定(認定内容.getみなし更新認定());
            passModel.set有効開始年月日(認定内容.get有効開始年月日());
            passModel.set有効終了年月日(認定内容.get有効終了年月日());
            passModel.set要介護度コード(認定内容.get要介護度コード());
            passModel.set要介護度名称(認定内容.get要介護度名称());
            passModel.set審査会意見(認定内容.get審査会意見());
            passModel.set認定年月日(認定内容.get認定年月日());
            if (認定情報 == null) {
                passModel.set申請書管理番号(ShinseishoKanriNo.EMPTY);
                model.setDataPassModel(passModel);
                return model;
            }
            DbT4101NinteiShinseiJoho 要介護認定申請情報 = 認定情報.get要介護認定申請情報();
            passModel.set申請書管理番号(要介護認定申請情報.get申請書管理番号());
            JukyushaDaicho 受給者台帳 = 認定情報.get受給者台帳();
            passModel.set厚労省IFコード(convertCodeToRString(要介護認定申請情報.get厚労省IF識別コード()));
            model.setDataPassModel(passModel);
            model.setIdoJiyuCode(convertCodeToRString(受給者台帳.getデータ区分()));
            model.setJukyuShikakuHakkoDay1(受給者台帳.get受給資格証明書発行年月日１());
            model.setJukyuShikakuHakkoDay2(受給者台帳.get受給資格証明書発行年月日２());
            model.setRiyu(受給者台帳.get異動理由());
            model.setSakujoJiyuCode(convertCodeToRString(受給者台帳.get削除事由コード()));
            model.setShinseiKubunLaw(convertCodeToRString(要介護認定申請情報.get認定申請区分_法令_コード()));
            model.setShinseiKubunShinsei(convertCodeToRString(要介護認定申請情報.get認定申請区分_申請時_コード()));
            model.setSoshitsuDay(受給者台帳.get喪失年月日());
            model.setTorisageDay(要介護認定申請情報.get取下年月日());
            model.setToshoNinteiKikanFrom(受給者台帳.get当初認定有効開始年月日());
            model.setToshoNinteiKikanTo(受給者台帳.get当初認定有効終了年月日());
        }
        return model;
    }

    /**
     * 「今回認定値」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param model 結果詳細情報画面の出力パラメータ
     * @param menuId メニューID
     */
    public void setKonkaiNinteichi(KekkaShosaiJohoOutModel model, RString menuId) {

        if (model == null) {
            return;
        }
        NinteiInputNaiyo 認定内容 = model.get認定内容();
        div.setHdnYokaigodoCodeKonkai(認定内容.get要介護度コード());
        if (!RString.isNullOrEmpty(認定内容.get要介護度コード())) {
            div.getTxtYokaigodoKonkai().setValue(認定内容.get要介護度名称());
        } else {
            div.getTxtYokaigodoKonkai().setValue(RString.EMPTY);
        }
        div.getTxtYukoKaishibiKonkai().setValue(認定内容.get有効開始年月日());
        div.getTxtYukoShuryobiKonkai().setValue(認定内容.get有効終了年月日());
        div.getTxtNinteibiKonkai().setValue(認定内容.get認定年月日());
        RString サービス種類 = RString.EMPTY;
        List<KekkaShosaiJohoServiceShuri> サービス類リスト = model.getサービス類リスト();
        if (サービス類リスト != null && !サービス類リスト.isEmpty()) {
            for (int i = 0; i < サービス類リスト.size(); i++) {
                if (i == 0) {
                    サービス種類 = サービス類リスト.get(i).getServiceShuriCode();
                } else {
                    サービス種類 = サービス種類.concat(符号).concat(サービス類リスト.get(i).getServiceShuriCode());
                }
            }
        }
        div.getTxtServiceShuruiKonkai().setValue(サービス種類);
        div.getTxtShinsakaiIkenKonkai().setValue(認定内容.get審査会意見());

        if (メニュID_区分変更認定.equals(menuId) || メニュID_サービス変更認定.equals(menuId) || メニュID_認定データ更新.equals(menuId)) {
            if (渡された認定区分_却下.equals(model.get認定内容().get認定区分())) {
                div.getTxtKubunKonkai().setValue(認定区分_却);
            } else {
                div.getTxtKubunKonkai().setValue(RString.EMPTY);
            }
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            div.getTxtKubunKonkai().setValue(認定区分_喪);
        } else {
            div.getTxtKubunKonkai().setValue(RString.EMPTY);
        }
    }

    /**
     * 更新用受給者台帳を作成します。
     *
     * @param menuId メニューID
     * @param 今回情報 今回情報
     * @return 受給者台帳
     */
    public JukyushaDaicho create更新用受給者台帳(RString menuId, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
        KekkaShosaiJohoOutModel outModel = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        JukyushaDaichoBuilder 修正用builder = 受給者台帳.createBuilderForEdit();
        修正用builder.set直近異動年月日(FlexibleDate.getNowDate());
        if (メニュID_職権修正.equals(menuId)) {
            修正用builder.set直近フラグ(false);
            修正用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.職権修正.getコード()));
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            修正用builder.set直近フラグ(false);
            if (outModel != null) {
                修正用builder.set認定有効期間終了年月日(outModel.get当初認定期間開始().minusDay(ONE));
            }
            RDate 喪失日 = div.getTxtSoshitsubi().getValue();
            if (喪失日 != null) {
                修正用builder.set喪失年月日(new FlexibleDate(喪失日.toString()));
            }
            修正用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.職権取消.getコード()));
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
        } else if (メニュID_区分変更認定.equals(menuId) || メニュID_認定データ更新.equals(menuId)) {
            修正用builder = create区変更新用受給者台帳(修正用builder, outModel, 今回情報);
        } else if (メニュID_サービス変更認定.equals(menuId)) {
            修正用builder = createサ変更新用受給者台帳(修正用builder, outModel, 今回情報);
        }
        return 修正用builder.build();
    }

    /**
     * 要介護認定申請情報を作成します。
     *
     * @param menuId メニューID
     * @param 今回情報 今回情報
     * @return 要介護認定申請情報List
     */
    public DbT4101NinteiShinseiJoho create更新用介護認定申請情報(RString menuId, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        DbT4101NinteiShinseiJoho 要介護認定申請情報 = 今回情報.get要介護認定申請情報();
        KekkaShosaiJohoOutModel outModel = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        DbT4101NinteiShinseiJohoBuilder 更新用情報Builder = 要介護認定申請情報.createBuilderForEdit();
        if (メニュID_職権修正.equals(menuId)) {
            return null;
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            更新用情報Builder.set前回認定有効期間_終了(outModel.get認定内容().get有効開始年月日());
        } else if (メニュID_区分変更認定.equals(menuId) || メニュID_認定データ更新.equals(menuId)) {
            更新用情報Builder.set審査継続区分(false);
            更新用情報Builder = create区変介護認定申請情報(更新用情報Builder, outModel, 今回情報);
        } else if (メニュID_サービス変更認定.equals(menuId)) {
            更新用情報Builder.set審査継続区分(false);
            更新用情報Builder = createサ変介護認定申請情報(更新用情報Builder, outModel, 今回情報);
        }
        return 更新用情報Builder.build();
    }

    /**
     * 認定結果情報を作成します。
     *
     * @param menuId メニューID
     * @param 今回情報 今回情報
     * @return 認定結果情報
     */
    public DbT4102NinteiKekkaJoho create認定結果情報(RString menuId, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        DbT4102NinteiKekkaJoho 要介護認定結果情報 = 今回情報.get要介護認定結果情報();
        KekkaShosaiJohoOutModel outModel = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        if (!メニュID_職権取消一部喪失.equals(menuId) && outModel != null) {
            DbT4102NinteiKekkaJohoBuilder build = 要介護認定結果情報.createBuilderForEdit();
            build.set審査会メモ(outModel.get認定内容().get審査会意見());
            return build.build();
        }
        return null;
    }

    /**
     * 認定結果情報を作成します。
     *
     * @param menuId メニューID
     * @param 今回情報 今回情報
     * @return 申請履歴情報
     */
    public ShinseiRirekiJoho create申請履歴情報(RString menuId, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        if (メニュID_職権取消一部喪失.equals(menuId)) {
            ShinseiRirekiJoho 申請履歴情報 = new ShinseiRirekiJoho(get申請書管理番号(今回情報.get市町村コード()));
            ShinseiRirekiJohoBuilder build = 申請履歴情報.createBuilderForEdit();
            build.set前回申請管理番号(今回情報.get要介護認定申請情報().get申請書管理番号());
            return build.build();
        }
        return null;
    }

    /**
     * 登録用要介護認定申請情報を作成します。
     *
     * @param menuId メニューID
     * @param 今回情報 今回情報
     * @return 登録用要介護認定申請情報
     */
    public DbT4101NinteiShinseiJoho create登録用要介護認定申請情報(RString menuId, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        DbT4101NinteiShinseiJoho 要介護認定申請情報 = 今回情報.get要介護認定申請情報();
        DbT4101NinteiShinseiJoho 登録用要介護認定申請情報 = new DbT4101NinteiShinseiJoho(get申請書管理番号(今回情報.get市町村コード()));
        DbT4101NinteiShinseiJohoBuilder 登録用情報Builder = 登録用要介護認定申請情報.createBuilderForEdit();
        RDate 申請日 = div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue();
        登録用情報Builder.set厚労省IF識別コード(要介護認定申請情報.get厚労省IF識別コード());
        登録用情報Builder.set証記載保険者番号(要介護認定申請情報.get証記載保険者番号());
        登録用情報Builder.set申請年度(new FlexibleYear(申請日.getNendo().toDateString()));
        登録用情報Builder.set被保険者番号(要介護認定申請情報.get被保険者番号());
        登録用情報Builder.set認定申請年月日(new FlexibleDate(申請日.toDateString()));
        登録用情報Builder.set認定申請枝番コード(要介護認定申請情報.get認定申請枝番コード());
        登録用情報Builder.set認定申請区分_法令_コード(要介護認定申請情報.get認定申請区分_法令_コード());
        登録用情報Builder.set認定申請区分_申請時_コード(要介護認定申請情報.get認定申請区分_申請時_コード());
        登録用情報Builder.set取下区分コード(要介護認定申請情報.get取下区分コード());
        登録用情報Builder.set被保険者区分コード(要介護認定申請情報.get被保険者区分コード());
        登録用情報Builder.set生年月日(要介護認定申請情報.get生年月日());
        登録用情報Builder.set年齢(要介護認定申請情報.get年齢());
        登録用情報Builder.set性別(要介護認定申請情報.get性別());
        登録用情報Builder.set被保険者氏名カナ(要介護認定申請情報.get被保険者氏名カナ());
        登録用情報Builder.set被保険者氏名(要介護認定申請情報.get被保険者氏名());
        登録用情報Builder.set郵便番号(要介護認定申請情報.get郵便番号());
        登録用情報Builder.set住所(要介護認定申請情報.get住所());
        登録用情報Builder.set電話番号(要介護認定申請情報.get電話番号());
        登録用情報Builder.set支所コード(要介護認定申請情報.get支所コード());
        登録用情報Builder.set識別コード(要介護認定申請情報.get識別コード());
        登録用情報Builder.set地区コード(要介護認定申請情報.get地区コード());
        登録用情報Builder.setみなし２号等対象フラグ(要介護認定申請情報.isみなし２号等対象フラグ());
        登録用情報Builder.set広域内転居区分(要介護認定申請情報.get広域内転居区分());
        登録用情報Builder.set認定申請有効区分(new Code(NinteiShinseiYukoKubunCode.無効.getコード()));
        登録用情報Builder.set要介護申請_要支援申請の区分(要介護認定申請情報.get要介護申請_要支援申請の区分());
        登録用情報Builder.set認定申請理由(要介護認定申請情報.get認定申請理由());
        登録用情報Builder.set申請サービス削除の理由(要介護認定申請情報.get申請サービス削除の理由());
        if (メニュID_職権修正.equals(menuId)) {
            登録用情報Builder.set前回要介護状態区分コード(要介護認定申請情報.get前回要介護状態区分コード());
            登録用情報Builder.set前回認定年月日(要介護認定申請情報.get前回認定年月日());
            登録用情報Builder.set前回認定有効期間_開始(要介護認定申請情報.get前回認定有効期間_開始());
            登録用情報Builder.set前回認定有効期間_終了(要介護認定申請情報.get前回認定有効期間_終了());
            登録用情報Builder.set2号医療保険者名(要介護認定申請情報.get２号医療保険者名());
            登録用情報Builder.set2号医療保険記号番号(要介護認定申請情報.get２号医療保険記号番号());
            登録用情報Builder.set2号特定疾病コード(要介護認定申請情報.get２号特定疾病コード());
            登録用情報Builder.set自動割当除外者区分(要介護認定申請情報.get自動割当除外者区分());
            登録用情報Builder.set情報提供への同意有無(要介護認定申請情報.is情報提供への同意有無());
            登録用情報Builder.set情報提供資料出力年月日(要介護認定申請情報.get情報提供資料出力年月日());
            登録用情報Builder.set調査区分(要介護認定申請情報.get調査区分());
            登録用情報Builder.set認定調査委託先コード(要介護認定申請情報.get認定調査委託先コード());
            登録用情報Builder.set認定調査員コード(要介護認定申請情報.get認定調査員コード());
            登録用情報Builder.set調査員への連絡事項(要介護認定申請情報.get調査員への連絡事項());
            登録用情報Builder.set主治医医療機関コード(要介護認定申請情報.get主治医医療機関コード());
            登録用情報Builder.set主治医コード(要介護認定申請情報.get主治医コード());
            登録用情報Builder.set指定医フラグ(要介護認定申請情報.is指定医フラグ());
            登録用情報Builder.set意見書データ種別(要介護認定申請情報.get意見書データ種別());
            登録用情報Builder.set主治医への連絡事項(要介護認定申請情報.get主治医への連絡事項());
            登録用情報Builder.set認定延期通知発行しないことに対する同意有無(要介護認定申請情報.is認定延期通知発行しないことに対する同意有無());
            登録用情報Builder.set施設入所の有無(要介護認定申請情報.is施設入所の有無());
            登録用情報Builder.set入所施設コード(要介護認定申請情報.get入所施設コード());
            登録用情報Builder.set家庭訪問の有無(要介護認定申請情報.is家庭訪問の有無());
            登録用情報Builder.set訪問調査先郵便番号(要介護認定申請情報.get訪問調査先郵便番号());
            登録用情報Builder.set訪問調査先住所(要介護認定申請情報.get訪問調査先住所());
            登録用情報Builder.set訪問調査先名称(要介護認定申請情報.get訪問調査先名称());
            登録用情報Builder.set訪問調査先電話番号(要介護認定申請情報.get訪問調査先電話番号());
            登録用情報Builder.set市町村連絡事項(要介護認定申請情報.get市町村連絡事項());
            登録用情報Builder.set処理状態区分(要介護認定申請情報.get処理状態区分());
            登録用情報Builder.set取下年月日(要介護認定申請情報.get取下年月日());
            登録用情報Builder.set取下理由(要介護認定申請情報.get取下理由());
            登録用情報Builder.set却下年月日(要介護認定申請情報.get却下年月日());
            登録用情報Builder.set却下理由(要介護認定申請情報.get却下理由());
            登録用情報Builder.set延期決定年月日(要介護認定申請情報.get延期決定年月日());
            登録用情報Builder.set延期理由(要介護認定申請情報.get延期理由());
            登録用情報Builder.set延期通知発行年月日(要介護認定申請情報.get延期通知発行年月日());
            登録用情報Builder.set延期通知発行回数(要介護認定申請情報.get延期通知発行回数());
            登録用情報Builder.set延期見込期間開始年月日(要介護認定申請情報.get延期見込期間開始年月日());
            登録用情報Builder.set延期見込期間終了年月日(要介護認定申請情報.get延期見込期間終了年月日());
            登録用情報Builder.set審査継続区分(要介護認定申請情報.is審査継続区分());
            登録用情報Builder.set介護認定審査会優先振分区分コード(要介護認定申請情報.get介護認定審査会優先振分区分コード());
            登録用情報Builder.set更新通知発行年月日(要介護認定申請情報.get更新通知発行年月日());
            登録用情報Builder.set更新通知発行完了年月日(要介護認定申請情報.get更新通知発行完了年月日());
            登録用情報Builder.set認定申請情報登録年月日(要介護認定申請情報.get認定申請情報登録年月日());
            登録用情報Builder.set再調査依頼回数(要介護認定申請情報.get再調査依頼回数());
            登録用情報Builder.set再作成依頼回数(要介護認定申請情報.get再作成依頼回数());
            登録用情報Builder.setＩＦ送付年月日(要介護認定申請情報.getＩＦ送付年月日());
            登録用情報Builder.set論理削除フラグ(要介護認定申請情報.is論理削除フラグ());
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            KekkaShosaiJohoOutModel outModel = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
            登録用情報Builder.set前回要介護状態区分コード(今回情報.get受給者台帳().get要介護認定状態区分コード());
            if (outModel != null) {
                登録用情報Builder.set前回認定年月日(outModel.get認定内容().get認定年月日());
                登録用情報Builder.set前回認定有効期間_開始(outModel.get認定内容().get有効開始年月日());
                登録用情報Builder.set前回認定有効期間_終了(outModel.get認定内容().get有効終了年月日());
            }
            登録用情報Builder.set論理削除フラグ(true);
        }
        return 登録用情報Builder.build();
    }

    /**
     * 登録用受給者台帳を作成します。
     *
     * @param 今回情報 今回情報
     * @param menuId メニューID
     * @return 登録用受給者台帳
     */
    public JukyushaDaicho create登録用受給者台帳(ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報, RString menuId) {

        KekkaShosaiJohoOutModel outModel = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
        JukyushaDaicho 登録用受給者台帳 = new JukyushaDaicho(受給者台帳.get市町村コード(), 受給者台帳.get被保険者番号(),
                new RString(String.valueOf(Integer.parseInt(受給者台帳.get履歴番号().toString()) + 1)),
                受給者台帳.get枝番(), 受給者台帳.get受給申請事由());
        JukyushaDaichoBuilder 登録用builder = 登録用受給者台帳.createBuilderForEdit();
        if (メニュID_職権修正.equals(menuId)) {
            登録用builder.set喪失年月日(new FlexibleDate(div.getTxtSoshitsubi().getValue().toString()));
            登録用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.職権取消.getコード()));
            登録用builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
            登録用builder.set指定サービス種類01(受給者台帳.get指定サービス種類01());
            登録用builder.set指定サービス種類02(受給者台帳.get指定サービス種類02());
            登録用builder.set指定サービス種類03(受給者台帳.get指定サービス種類03());
            登録用builder.set指定サービス種類04(受給者台帳.get指定サービス種類04());
            登録用builder.set指定サービス種類05(受給者台帳.get指定サービス種類05());
            登録用builder.set指定サービス種類06(受給者台帳.get指定サービス種類06());
            登録用builder.set指定サービス種類07(受給者台帳.get指定サービス種類07());
            登録用builder.set指定サービス種類08(受給者台帳.get指定サービス種類08());
            登録用builder.set指定サービス種類09(受給者台帳.get指定サービス種類09());
            登録用builder.set指定サービス種類10(受給者台帳.get指定サービス種類10());
            登録用builder.set指定サービス種類11(受給者台帳.get指定サービス種類11());
            登録用builder.set指定サービス種類12(受給者台帳.get指定サービス種類12());
            登録用builder.set指定サービス種類13(受給者台帳.get指定サービス種類13());
            登録用builder.set指定サービス種類14(受給者台帳.get指定サービス種類14());
            登録用builder.set指定サービス種類15(受給者台帳.get指定サービス種類15());
            登録用builder.set指定サービス種類16(受給者台帳.get指定サービス種類16());
            登録用builder.set指定サービス種類17(受給者台帳.get指定サービス種類17());
            登録用builder.set指定サービス種類18(受給者台帳.get指定サービス種類18());
            登録用builder.set指定サービス種類19(受給者台帳.get指定サービス種類19());
            登録用builder.set指定サービス種類20(受給者台帳.get指定サービス種類20());
            登録用builder.set指定サービス種類21(受給者台帳.get指定サービス種類21());
            登録用builder.set指定サービス種類22(受給者台帳.get指定サービス種類22());
            登録用builder.set指定サービス種類23(受給者台帳.get指定サービス種類23());
            登録用builder.set指定サービス種類24(受給者台帳.get指定サービス種類24());
            登録用builder.set指定サービス種類25(受給者台帳.get指定サービス種類25());
            登録用builder.set指定サービス種類26(受給者台帳.get指定サービス種類26());
            登録用builder.set指定サービス種類27(受給者台帳.get指定サービス種類27());
            登録用builder.set指定サービス種類28(受給者台帳.get指定サービス種類28());
            登録用builder.set指定サービス種類29(受給者台帳.get指定サービス種類29());
            登録用builder.set指定サービス種類30(受給者台帳.get指定サービス種類30());
        } else {
            登録用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.職権修正.getコード()));
            登録用builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
            登録用builder.set削除事由コード(受給者台帳.get削除事由コード());
            int index = ZERO;
            List<RString> サービス種類 = div.getTxtServiceShuruiKonkai().getValue().split(",");
            登録用builder.set指定サービス種類01(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類02(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類03(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類04(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類05(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類06(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類07(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類08(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類09(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類10(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類11(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類12(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類13(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類14(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類15(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類16(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類17(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類18(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類18(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類19(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類20(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類21(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類22(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類23(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類24(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類25(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類26(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類27(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類28(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類29(get指定サービス種類(++index, サービス種類));
            登録用builder.set指定サービス種類30(get指定サービス種類(++index, サービス種類));
        }
        登録用builder.set申請書管理番号(get申請書管理番号(今回情報.get市町村コード()));
        登録用builder.set申請状況区分(受給者台帳.get申請状況区分());
        登録用builder.set支所コード(受給者台帳.get支所コード());
        登録用builder.set直近フラグ(受給者台帳.is直近フラグ());
        登録用builder.set識別コード(受給者台帳.get識別コード());
        登録用builder.set申請理由(受給者台帳.get申請理由());
        登録用builder.set届出者_申請者関係コード(受給者台帳.get届出者_申請者関係コード());
        登録用builder.set届出者_本人との関係(受給者台帳.get届出者_本人との関係());
        登録用builder.set受給申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv().
                getTxtShinseiYMD().getValue().toString()));
        登録用builder.set２号特定疾病コード(受給者台帳.get２号特定疾病コード());
        登録用builder.set審査会依頼年月日(受給者台帳.get審査会依頼年月日());
        登録用builder.set要介護認定状態区分コード(受給者台帳.get要介護認定状態区分コード());
        登録用builder.set認定有効期間開始年月日(div.getRirekiNintei().getTxtYukoKaishibiKonkai().getValue());
        登録用builder.set認定有効期間終了年月日(div.getRirekiNintei().getTxtYukoShuryobiKonkai().getValue());
        登録用builder.set認定年月日(div.getRirekiNintei().getTxtNinteibiKonkai().getValue());
        登録用builder.setみなし要介護区分コード(受給者台帳.getみなし要介護区分コード());
        登録用builder.set直近異動年月日(FlexibleDate.getNowDate());
        if (outModel != null) {
            登録用builder.setデータ区分(new Code(outModel.get異動事由コード()));
            登録用builder.set異動理由(outModel.get理由());
        }
        登録用builder.set同一連番(new RString(String.valueOf(Integer.parseInt(受給者台帳.get履歴番号().toString()) + 1)));
        登録用builder.set申請書区分(受給者台帳.get申請書区分());
        登録用builder.set要支援者認定申請区分(受給者台帳.is要支援者認定申請区分());
        登録用builder.set支給限度単位数(受給者台帳.get支給限度単位数());
        登録用builder.set支給限度有効開始年月日(受給者台帳.get支給限度有効開始年月日());
        登録用builder.set支給限度有効終了年月日(受給者台帳.get支給限度有効終了年月日());
        登録用builder.set短期入所支給限度日数(受給者台帳.get短期入所支給限度日数());
        登録用builder.set短期入所支給限度開始年月日(受給者台帳.get短期入所支給限度開始年月日());
        登録用builder.set短期入所支給限度終了年月日(受給者台帳.get短期入所支給限度終了年月日());
        登録用builder.set当初認定有効開始年月日(受給者台帳.get当初認定有効開始年月日());
        登録用builder.set当初認定有効終了年月日(受給者台帳.get当初認定有効終了年月日());
        登録用builder.set受給資格証明書発行年月日１(受給者台帳.get受給資格証明書発行年月日１());
        登録用builder.set受給資格証明書発行年月日２(受給者台帳.get受給資格証明書発行年月日２());
        登録用builder.set診断命令書発行年月日(受給者台帳.get診断命令書発行年月日());
        登録用builder.set２号申請受理通知書発行年月日(受給者台帳.get２号申請受理通知書発行年月日());
        登録用builder.set認定結果通知書発行年月日(受給者台帳.get認定結果通知書発行年月日());
        登録用builder.set区分変更通知書発行年月日(受給者台帳.get区分変更通知書発行年月日());
        登録用builder.setサービス変更通知書発行年月日(受給者台帳.getサービス変更通知書発行年月日());
        登録用builder.set認定却下通知書発行年月日(受給者台帳.get認定却下通知書発行年月日());
        登録用builder.set認定取消通知書発行年月日(受給者台帳.get認定取消通知書発行年月日());
        登録用builder.set資格取得前申請フラグ(受給者台帳.is資格取得前申請フラグ());
        登録用builder.set旧措置者フラグ(受給者台帳.is旧措置者フラグ());
        登録用builder.set論理削除フラグ(false);
        return 登録用builder.build();
    }

    /**
     * メニューIDによって、完了メッセージを返却します。
     *
     * @param menuId メニューID
     * @return 完了メッセージ
     */
    public RString get完了メッセージ(RString menuId) {

        RString 完了メッセージ;
        if (メニュID_職権修正.equals(menuId)) {
            完了メッセージ = new RString("職権修正処理が正常に終了しました。");
        } else if (メニュID_職権取消一部喪失.equals(menuId)) {
            完了メッセージ = new RString("職権取消（一部喪失）処理が正常に終了しました。");
        } else if (メニュID_区分変更認定.equals(menuId)) {
            完了メッセージ = new RString("要介護認定申請認定（区分変更）処理が正常に終了しました。");
        } else if (メニュID_サービス変更認定.equals(menuId)) {
            完了メッセージ = new RString("要介護認定申請認定（サービス種類変更）処理が正常に終了しました。");
        } else {
            完了メッセージ = new RString("認定データ更新処理が正常に終了しました。");
        }
        return 完了メッセージ;
    }

    private void set介護認定申請基本情報(ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        DbT4101NinteiShinseiJoho 要介護認定申請情報 = 今回情報.get要介護認定申請情報();
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setRadShinseishoKubun(要介護認定申請情報.get要介護申請_要支援申請の区分());
        if (要介護認定申請情報.get認定申請年月日() != null && !要介護認定申請情報.get認定申請年月日().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setTxtShinseiYMD(new RDate(要介護認定申請情報.get認定申請年月日().toString()));
        }
        if (要介護認定申請情報.get認定申請区分_法令_コード() != null && !要介護認定申請情報.get認定申請区分_法令_コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setShinseiKubunHorei(
                    NinteiShinseiHoreiCode.toValue(要介護認定申請情報.get認定申請区分_法令_コード().getKey()));
        }
        if (要介護認定申請情報.get認定申請区分_申請時_コード() != null && !要介護認定申請情報.get認定申請区分_申請時_コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(要介護認定申請情報.get認定申請区分_申請時_コード().value()));
        }
        if (要介護認定申請情報.get被保険者区分コード() != null && !要介護認定申請情報.get被保険者区分コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setHihokenshaKubun(
                    HihokenshaKubunCode.toValue(要介護認定申請情報.get被保険者区分コード()));
        }
        if (要介護認定申請情報.get２号特定疾病コード() != null && !要介護認定申請情報.get２号特定疾病コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setTokuteiShippei(
                    TokuteiShippei.toValue(要介護認定申請情報.get２号特定疾病コード().getKey()));
        }
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setShisho(new ShishoCode(要介護認定申請情報.get支所コード()));
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setNinteiShinseRiyuTeikeibun(要介護認定申請情報.get認定申請理由());
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setTxtShinseiJokyo(今回情報.get受給者台帳().get申請状況区分());
        List<RString> key = new ArrayList<>();
        if (今回情報.get受給者台帳().is旧措置者フラグ()) {
            key.add(KEY0);
        }
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setKyuSochisha(key);
        key = new ArrayList<>();
        if (今回情報.get受給者台帳().is資格取得前申請フラグ()) {
            key.add(KEY0);
        }
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setChkShikakuShutokuMae(key);
    }

    private void set認定情報(ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報, ShokkenTorikeshiNinteiJohoKonkaiBusiness 前回情報) {

        if (前回情報 != null) {
            JukyushaDaicho 受給者台帳 = 前回情報.get受給者台帳();
            div.setHdnYokaigodoCodeKonkai(受給者台帳.get要介護認定状態区分コード().value());
            div.getTblRireki().getTxtYukoKaishibiZenkai().setValue(受給者台帳.get認定有効期間開始年月日());
            div.getTblRireki().getTxtYukoShuryobiZenkai().setValue(受給者台帳.get認定有効期間終了年月日());
            div.getTblRireki().getTxtNinteibiZenkai().setValue(受給者台帳.get認定年月日());
            div.getTblRireki().getTxtServiceShuruiZenkai().setValue(setサービス種類(受給者台帳));
            div.getTblRireki().getTxtShinsakaiIkenZenkai().setValue(前回情報.get要介護認定結果情報().get介護認定審査会意見());
            div.getTblRireki().getTxtYokaigodoZenkai().setValue(get要介護度名(前回情報.get要介護認定申請情報().get厚労省IF識別コード(),
                    受給者台帳.get要介護認定状態区分コード().value()));
        }
        if (今回情報 != null) {
            JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
            div.setHdnYokaigodoCodeZenkai(受給者台帳.get要介護認定状態区分コード().value());
            div.getTblRireki().getTxtYukoKaishibiKonkai().setValue(受給者台帳.get認定有効期間開始年月日());
            div.getTblRireki().getTxtYukoShuryobiKonkai().setValue(受給者台帳.get認定有効期間終了年月日());
            div.getTblRireki().getTxtNinteibiKonkai().setValue(受給者台帳.get認定年月日());
            div.getTblRireki().getTxtServiceShuruiKonkai().setValue(setサービス種類(受給者台帳));
            div.getTblRireki().getTxtShinsakaiIkenKonkai().setValue(今回情報.get要介護認定結果情報().get介護認定審査会意見());
            div.getTblRireki().getTxtYokaigodoKonkai().setValue(get要介護度名(今回情報.get要介護認定申請情報().get厚労省IF識別コード(),
                    受給者台帳.get要介護認定状態区分コード().value()));
        }
    }

    private RString get指定サービス種類(ServiceShuruiCode サービス種類) {

        RStringBuilder 指定サービス種類 = new RStringBuilder();
        if (サービス種類 != null && !サービス種類.isEmpty()) {
            指定サービス種類.append(サービス種類.value());
            指定サービス種類.append(符号);
        }
        return 指定サービス種類.toRString();
    }

    private RString setサービス種類(JukyushaDaicho business) {

        RStringBuilder サービス種類 = new RStringBuilder();
        サービス種類.append(get指定サービス種類(business.get指定サービス種類01()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類02()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類03()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類04()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類05()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類06()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類07()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類08()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類09()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類10()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類11()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類12()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類13()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類14()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類15()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類16()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類17()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類18()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類19()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類20()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類21()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類22()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類23()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類24()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類25()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類26()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類27()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類28()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類29()));
        サービス種類.append(get指定サービス種類(business.get指定サービス種類30()));
        RString result = サービス種類.toRString();
        if (result.endsWith(符号)) {
            result = result.substring(ZERO, サービス種類.length() - ONE);
        }
        return result;
    }

    private RString get要介護度名(Code 厚労省IF識別コード, RString 要介護度コード) {

        RString 厚労省IF識別コードStr = RString.EMPTY;
        if (厚労省IF識別コード != null && !厚労省IF識別コード.isEmpty()) {
            厚労省IF識別コードStr = 厚労省IF識別コード.value();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コードStr)) {
            return YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コードStr)) {
            return YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コードStr)) {
            return YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コードStr)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コードStr)) {
            return YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString convertCodeToRString(Code target) {
        return target == null || target.isEmpty() ? RString.EMPTY : target.value();
    }

    private ServiceShuruiCode get指定サービス種類(int サービス種類番号, List<RString> サービス種類) {

        if (サービス種類 != null && サービス種類番号 < サービス種類.size() && !サービス種類.get(サービス種類番号).isEmpty()) {
            return new ServiceShuruiCode(サービス種類.get(サービス種類番号));
        }
        return null;
    }

    private ShinseishoKanriNo get申請書管理番号(LasdecCode 市町村コード) {

        RString 連番 = Saiban.get(SubGyomuCode.DBD介護受給, SaibanHanyokeyName.市町村コード_西暦_月.getコード()).nextString();
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(市町村コード);
        rsb.append(RDate.getNowDate().getYearMonth().toDateString());
        rsb.append(連番);
        return new ShinseishoKanriNo(rsb.toRString());
    }

    /**
     * 画面初期項目を設定します。
     *
     * @return 画面初期項目値
     */
    public RString get画面項目() {

        RStringBuilder 画面初期項目 = new RStringBuilder();
        KaigoNinteiShinseiKihonJohoInputDiv 認定申請基本DIV = div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv();
        画面初期項目.append(認定申請基本DIV.getTxtNinteiShinseRiyu().getValue());
        画面初期項目.append(認定申請基本DIV.getTxtServiceSakujo().getValue());
        画面初期項目.append(認定申請基本DIV.getTxtShinseiJokyo().getValue());
        if (認定申請基本DIV.getTxtShinseiYMD().getValue() != null) {
            画面初期項目.append(認定申請基本DIV.getTxtShinseiYMD().getValue().toDateString());
        } else {
            画面初期項目.append(RString.HALF_SPACE);
        }
        画面初期項目.append(認定申請基本DIV.getDdlHihokenshaKubun().getSelectedKey());
        画面初期項目.append(認定申請基本DIV.getDdlShinseiKubunHorei().getSelectedKey());
        画面初期項目.append(認定申請基本DIV.getDdlShinseiKubunShinseiji().getSelectedKey());
        画面初期項目.append(認定申請基本DIV.getDdlShinseiShubetsu().getSelectedKey());
        画面初期項目.append(認定申請基本DIV.getDdlShisho().getSelectedKey());
        画面初期項目.append(認定申請基本DIV.getDdlTokuteiShippei().getSelectedKey());
        画面初期項目.append(認定申請基本DIV.getRadShinseishoKubun().getSelectedKey());
        if (認定申請基本DIV.getChkKyuSochisha().getSelectedKeys().isEmpty()) {
            画面初期項目.append(RString.HALF_SPACE);
        } else {
            画面初期項目.append(認定申請基本DIV.getChkKyuSochisha().getSelectedKeys().get(ZERO));
        }
        if (認定申請基本DIV.getChkShikakuShutokuMae().getSelectedKeys().isEmpty()) {
            画面初期項目.append(RString.HALF_SPACE);
        } else {
            画面初期項目.append(認定申請基本DIV.getChkShikakuShutokuMae().getSelectedKeys().get(ZERO));
        }
        画面初期項目.append(div.getTxtYokaigodoKonkai().getValue());
        if (div.getTxtYukoKaishibiKonkai().getValue() != null && !div.getTxtYukoKaishibiKonkai().getValue().isEmpty()) {
            画面初期項目.append(new RString(div.getTxtYukoKaishibiKonkai().getValue().toString()));
        } else {
            画面初期項目.append(RString.HALF_SPACE);
        }
        if (div.getTxtYukoShuryobiKonkai().getValue() != null && !div.getTxtYukoShuryobiKonkai().getValue().isEmpty()) {
            画面初期項目.append(new RString(div.getTxtYukoShuryobiKonkai().getValue().toString()));
        } else {
            画面初期項目.append(RString.HALF_SPACE);
        }
        if (div.getTxtNinteibiKonkai().getValue() != null && !div.getTxtNinteibiKonkai().getValue().isEmpty()) {
            画面初期項目.append(new RString(div.getTxtNinteibiKonkai().getValue().toString()));
        } else {
            画面初期項目.append(RString.HALF_SPACE);
        }
        画面初期項目.append(div.getTxtServiceShuruiKonkai().getValue());
        画面初期項目.append(div.getTxtShinsakaiIkenKonkai().getValue());
        return 画面初期項目.toRString();
    }

    private DbT4101NinteiShinseiJohoBuilder create区変介護認定申請情報(DbT4101NinteiShinseiJohoBuilder 更新用情報Builder,
            KekkaShosaiJohoOutModel outModel, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
        if (!認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            if (outModel != null) {
                更新用情報Builder.set認定申請区分_法令_コード(new Code(outModel.get申請区分法令()));
                更新用情報Builder.set認定申請区分_申請時_コード(new Code(outModel.get申請区分申請時()));
            }
            更新用情報Builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
            更新用情報Builder.set取下区分コード(new Code(TorisageKubunCode.認定申請有効.getコード()));
        }
        if (認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            更新用情報Builder.set取下区分コード(new Code(TorisageKubunCode.区分変更却下.getコード()));
            更新用情報Builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
            if (outModel != null) {
                更新用情報Builder.set却下年月日(outModel.get認定内容().get認定年月日());
                更新用情報Builder.set却下理由(outModel.get理由());
            }
        }
        return 更新用情報Builder;
    }

    private DbT4101NinteiShinseiJohoBuilder createサ変介護認定申請情報(DbT4101NinteiShinseiJohoBuilder 更新用情報Builder,
            KekkaShosaiJohoOutModel outModel, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
        if (!認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            更新用情報Builder.set取下区分コード(new Code(TorisageKubunCode.認定申請有効.getコード()));
            更新用情報Builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        }
        if (認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            更新用情報Builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
            if (outModel != null) {
                更新用情報Builder.set却下年月日(outModel.get認定内容().get認定年月日());
                更新用情報Builder.set却下理由(outModel.get理由());
            }
        }
        return 更新用情報Builder;
    }

    private JukyushaDaichoBuilder create区変更新用受給者台帳(JukyushaDaichoBuilder 修正用builder,
            KekkaShosaiJohoOutModel outModel, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
        if (!認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {

            if (outModel != null) {
                修正用builder.set要介護認定状態区分コード(new Code(outModel.get認定内容().get要介護度コード()));
                修正用builder.set認定有効期間開始年月日(outModel.get認定内容().get有効開始年月日());
                修正用builder.set認定有効期間終了年月日(outModel.get認定内容().get有効終了年月日());
                修正用builder.set認定年月日(outModel.get認定内容().get認定年月日());
            }
            修正用builder.set申請状況区分(ShinseiJokyoKubun.認定完了.getコード());
            修正用builder.set直近フラグ(true);
            修正用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.要介護度変更申請認定.getコード()));
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
            修正用builder.setデータ区分(new Code(Datakubun.通常_認定.getコード()));
            修正用builder.set同一連番(受給者台帳.get履歴番号());
            if (div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv().
                    getChkKyuSochisha().getSelectedKeys().isEmpty()) {
                修正用builder.set旧措置者フラグ(false);
            } else {
                修正用builder.set旧措置者フラグ(true);
            }
        }

        if (!認定区分_却.equals(div.getTxtKubunKonkai().getValue()) && 受給者台帳.is直近フラグ()) {
            修正用builder.set直近フラグ(false);
            // TODO QA1561確認中
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
            修正用builder.setデータ区分(new Code(Datakubun.開始日同日の区分変更前情報.getコード()));
        }

        if (認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            修正用builder.set直近フラグ(true);
            修正用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.要介護度変更申請却下.getコード()));
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
            if (outModel != null) {
                修正用builder.setデータ区分(new Code(outModel.get異動事由コード()));
                修正用builder.set異動理由(outModel.get理由());
            }
        }
        return 修正用builder;
    }

    private JukyushaDaichoBuilder createサ変更新用受給者台帳(JukyushaDaichoBuilder 修正用builder,
            KekkaShosaiJohoOutModel outModel, ShokkenTorikeshiNinteiJohoKonkaiBusiness 今回情報) {

        JukyushaDaicho 受給者台帳 = 今回情報.get受給者台帳();
        if (!認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            修正用builder.set申請状況区分(ShinseiJokyoKubun.認定完了.getコード());
            修正用builder.set直近フラグ(true);
            修正用builder.set認定有効期間開始年月日(div.getRirekiNintei().getTxtYukoKaishibiKonkai().getValue());
            修正用builder.set認定有効期間終了年月日(div.getRirekiNintei().getTxtYukoShuryobiKonkai().getValue());
            修正用builder.set認定年月日(div.getRirekiNintei().getTxtNinteibiKonkai().getValue());
            修正用builder.setみなし要介護区分コード(受給者台帳.getみなし要介護区分コード());
            int index = ZERO;
            List<RString> サービス種類 = div.getTxtServiceShuruiKonkai().getValue().split(",");
            修正用builder.set指定サービス種類01(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類02(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類03(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類04(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類05(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類06(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類07(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類08(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類09(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類10(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類11(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類12(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類13(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類14(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類15(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類16(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類17(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類18(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類18(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類19(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類20(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類21(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類22(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類23(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類24(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類25(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類26(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類27(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類28(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類29(get指定サービス種類(++index, サービス種類));
            修正用builder.set指定サービス種類30(get指定サービス種類(++index, サービス種類));
            修正用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.サービス種類変更申請認定.getコード()));
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
            修正用builder.setデータ区分(new Code(Datakubun.通常_認定.getコード()));
        }
        if (!認定区分_却.equals(div.getTxtKubunKonkai().getValue()) && 受給者台帳.is直近フラグ()) {
            修正用builder.set直近フラグ(false);
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
        }
        if (認定区分_却.equals(div.getTxtKubunKonkai().getValue())
                && ShinseiJokyoKubun.申請中.getコード().equals(受給者台帳.get申請状況区分())) {
            修正用builder.set直近フラグ(true);
            修正用builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.サービス種類変更申請却下.getコード()));
            修正用builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
            if (outModel != null) {
                修正用builder.setデータ区分(new Code(outModel.get異動事由コード()));
                修正用builder.set異動理由(outModel.get理由());
            }
        }
        return 修正用builder;
    }
}
