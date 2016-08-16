/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001;

import java.util.ArrayList;
import java.util.Arrays;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJohoBuilder;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiDiv;
import jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho.YokaigoNinteiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 *
 * 要介護認定取消画面のハンドラクラスです。
 *
 * @reamsid_L DBD-2090-010 lit
 */
public class NinteiShinseiTorokuTorikeshiShosaiHandler {

    private final NinteiShinseiTorokuTorikeshiShosaiDiv div;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定取消のコントロールdiv
     */
    public NinteiShinseiTorokuTorikeshiShosaiHandler(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        this.div = div;
        this.association = AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 RString
     *
     * @return 認定情報 YokaigoNinteiJoho
     */
    public YokaigoNinteiJoho onLoad(RString 被保険者番号) {

        YokaigoNinteiJoho 認定情報 = get認定情報(被保険者番号, true);
        if (null == 認定情報) {
            return null;
        }
        setHdnArea(認定情報);

        initialize(
                //                被保険者番号,
                認定情報, is受給());

        edit状態(認定情報.get申請状況区分().equals(ShinseiJokyoKubun.申請中.getコード()));

        return 認定情報;
    }

    /**
     * 「保存する」ボタンをクリック
     *
     * @param 認定情報 YokaigoNinteiJoho
     */
    public void save(YokaigoNinteiJoho 認定情報) {
        if (is受給()) {
            認定情報 = edit受給者台帳(認定情報);
            認定情報 = edit要介護認定申請情報受給(認定情報);
        } else {
            認定情報 = edit要介護認定申請情報認定(認定情報);
        }

        YokaigoNinteiJohoManager.createInstance().save介護認定申請情報(認定情報, is受給());

    }

//    /**
//     * 今回前回履歴情報情報を返す。
//     *
//     * @param 被保険者番号 被保険者番号
//     *
//     * @return 今回前回履歴情報 List<YokaigoRirekiJohoEntity>
//     */
//    public List<YokaigoRirekiJoho> get今回前回履歴情報(RString 被保険者番号) {
//        return YokaigoNinteiJohoManager.createInstance().get今回前回履歴情報(被保険者番号);
//    }
    private YokaigoNinteiJoho get認定情報(RString 被保険者番号, boolean is受給) {
        YokaigoNinteiJoho 認定情報;
        if (is受給) {
            認定情報 = YokaigoNinteiJohoManager.createInstance().get認定情報受給(被保険者番号);
        } else {
            認定情報 = YokaigoNinteiJohoManager.createInstance().get認定情報認定(被保険者番号);
        }
        return 認定情報;
    }

    private void initialize(
            //            RString 被保険者番号,
            YokaigoNinteiJoho 認定情報, boolean is受給) {
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        if (is受給) {
            div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(
                    new ShinseishoKanriNo(認定情報.get申請書管理番号受給()), 認定情報.get識別コード受給());
        } else {
            div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(
                    new ShinseishoKanriNo(認定情報.get申請書管理番号認定()), 認定情報.get識別コード認定());
        }

        // TODO. 共通部品　DBZ.KaigoNinteiShikakuInfoのinitializeについて、被保険者番号がだけですか。
//        div.getCcdKaigoNinteiShikakuInfo().initialize(association.get地方公共団体コード().value(), 識別コード.value(),
//        RString.EMPTY, 被保険者番号);
        IKaigoNinteiShinseiKihonJohoInputDiv 介護認定申請基本情報入力Div = div.getCcdKaigoNinteiShinseiKihon();
        介護認定申請基本情報入力Div.initialize();
        介護認定申請基本情報入力Div.setShinseiShubetsu(JukyuShinseiJiyu.toValue(convertCodeToRString(認定情報.get受給申請事由())));
        介護認定申請基本情報入力Div.setTxtShinseiJokyo(JukyuShinseiJiyu.toValue(認定情報.get申請状況区分()).get名称());
        介護認定申請基本情報入力Div.setKyuSochisha(認定情報.is旧措置者フラグ()
                ? Arrays.asList(new RString("key0")) : new ArrayList<RString>());
        介護認定申請基本情報入力Div.setChkShikakuShutokuMae(認定情報.is資格取得前申請フラグ()
                ? Arrays.asList(new RString("key0")) : new ArrayList<RString>());
        if (is受給) {
            介護認定申請基本情報入力Div.setRadShinseishoKubun(認定情報.get要支援申請の区分受給());
            介護認定申請基本情報入力Div.setTxtShinseiYMD(convertFlexibleDateToRDate(認定情報.get認定申請年月日受給()));
            介護認定申請基本情報入力Div.setShinseiKubunHorei(NinteiShinseiHoreiCode
                    .toValue(convertCodeToRString(認定情報.get認定申請区分法令コード受給())));
            介護認定申請基本情報入力Div.setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(convertCodeToRString(認定情報.get認定申請区分申請時コード受給())));
            介護認定申請基本情報入力Div.setShisho(new ShishoCode(認定情報.get支所コード受給()));
            介護認定申請基本情報入力Div.setHihokenshaKubun(HihokenshaKubunCode.toValue(認定情報.get被保険者区分コード受給()));
            介護認定申請基本情報入力Div.setTokuteiShippei(TokuteiShippei.toValue(convertCodeToRString(認定情報.get二号特定疾病コード受給())));
            介護認定申請基本情報入力Div.setNinteiShinseRiyuTeikeibun(認定情報.get認定申請理由受給());
            介護認定申請基本情報入力Div.setServiceSakujoTeikeibun(認定情報.get申請サービス削除の理由受給());
        } else {
            介護認定申請基本情報入力Div.setRadShinseishoKubun(認定情報.get要支援申請の区分認定());
            介護認定申請基本情報入力Div.setTxtShinseiYMD(convertFlexibleDateToRDate(認定情報.get認定申請年月日認定()));
            介護認定申請基本情報入力Div.setShinseiKubunHorei(NinteiShinseiHoreiCode
                    .toValue(convertCodeToRString(認定情報.get認定申請区分法令コード認定())));
            介護認定申請基本情報入力Div.setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(convertCodeToRString(認定情報.get認定申請区分申請時コード認定())));
            介護認定申請基本情報入力Div.setShisho(new ShishoCode(認定情報.get支所コード認定()));
            介護認定申請基本情報入力Div.setHihokenshaKubun(HihokenshaKubunCode.toValue(認定情報.get被保険者区分コード認定()));
            介護認定申請基本情報入力Div.setTokuteiShippei(TokuteiShippei.toValue(convertCodeToRString(認定情報.get二号特定疾病コード認定())));
            介護認定申請基本情報入力Div.setNinteiShinseRiyuTeikeibun(認定情報.get認定申請理由認定());
            介護認定申請基本情報入力Div.setServiceSakujoTeikeibun(認定情報.get申請サービス削除の理由認定());
        }
        介護認定申請基本情報入力Div.setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));

        IShujiiIryokikanAndShujiiInputDiv 主治医Div = div.getCcdShujiiIryokikanAndShujiiInput();
        主治医Div.setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleShokaiMode);
        if (is受給) {
            主治医Div.initialize(
                    association.get地方公共団体コード(),
                    new ShinseishoKanriNo(認定情報.get申請書管理番号受給()),
                    SubGyomuCode.DBD介護受給,
                    認定情報.get主治医医療機関コード受給(),
                    認定情報.get医療機関名称受給(),
                    認定情報.get主治医コード受給(),
                    認定情報.get主治医氏名受給());
            主治医Div.setShiteii(認定情報.is指定医フラグ受給());

        } else {
            主治医Div.initialize(
                    association.get地方公共団体コード(),
                    new ShinseishoKanriNo(認定情報.get申請書管理番号認定()),
                    SubGyomuCode.DBD介護受給,
                    認定情報.get主治医医療機関コード認定(),
                    認定情報.get医療機関名称認定(),
                    認定情報.get主治医コード認定(),
                    認定情報.get主治医氏名認定());
            主治医Div.setShiteii(認定情報.is指定医フラグ認定());
        }

        INinteiInputDiv 認定Div = div.getCcdNinteiInput();
        NinteiInputDataPassModel model = new NinteiInputDataPassModel();
        model.set要介護度コード(convertCodeToRString(認定情報.get要介護認定状態区分コード()));
        model.set要介護度名称(get要介護度名(認定情報.get厚労省IF識別コード(), convertCodeToRString(認定情報.get要介護認定状態区分コード())));
        model.set有効開始年月日(認定情報.get認定有効期間開始年月日());
        model.set有効終了年月日(認定情報.get認定有効期間終了年月日());
        model.set認定年月日(認定情報.get認定年月日());
        model.set審査会意見(認定情報.get介護認定審査会意見());
        model.set認定区分(new RString("1"));
        model.set申請書管理番号(new ShinseishoKanriNo(認定情報.get申請書管理番号受給()));
        認定Div.initialize(model);
        認定Div.set状態(
                new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));

        IZenkaiNinteiKekkaJohoDiv 前回結果情報Div = div.getCcdZenkaiNinteiKekkaJoho();
        前回結果情報Div.setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        if (is受給) {
            前回結果情報Div.getTxtYokaigodo().setValue(
                    get要介護度名(認定情報.get厚労省IF識別コード(), convertCodeToRString(認定情報.get前回要介護状態区分コード受給())));
            前回結果情報Div.getTxtNinteiDay().setValue(認定情報.get前回認定年月日受給());
            前回結果情報Div.getTxtYukoKikanFrom().setValue(認定情報.get前回認定有効期間開始受給());
            前回結果情報Div.getTxtYukoKikanTo().setValue(認定情報.get前回認定有効期間終了受給());
        } else {
            前回結果情報Div.getTxtYokaigodo().setValue(
                    get要介護度名(認定情報.get厚労省IF識別コード(), convertCodeToRString(認定情報.get前回要介護状態区分コード認定())));
            前回結果情報Div.getTxtNinteiDay().setValue(認定情報.get前回認定年月日認定());
            前回結果情報Div.getTxtYukoKikanFrom().setValue(認定情報.get前回認定有効期間開始認定());
            前回結果情報Div.getTxtYukoKikanTo().setValue(認定情報.get前回認定有効期間終了認定());
        }
        IShinseiSonotaJohoInputDiv 申請その他情報Div = div.getCcdSonotaJoho();

        申請その他情報Div.initialize();
        申請その他情報Div.setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuTsuikaMode);
        申請その他情報Div.set異動事由(convertCodeToRString(認定情報.getデータ区分()));
        申請その他情報Div.set削除事由(convertCodeToRString(認定情報.get削除事由コード()));
        申請その他情報Div.set理由(認定情報.get異動理由());
        申請その他情報Div.set喪失日(認定情報.get喪失年月日());
        申請その他情報Div.set当初認定期間From(認定情報.get当初認定有効開始年月日());
        申請その他情報Div.set当初認定期間To(認定情報.get当初認定有効終了年月日());
        申請その他情報Div.set発行日１(認定情報.get受給資格証明書発行年月日１());
        申請その他情報Div.set発行日2(認定情報.get受給資格証明書発行年月日２());
        if (is受給) {
            申請その他情報Div.set取消日(認定情報.get取下年月日受給());
        } else {
            申請その他情報Div.set取消日(認定情報.get取下年月日認定());
        }
    }

    private void edit状態(boolean is申請中) {
        div.getBtnIryohokenGuide().setDisabled(!is申請中);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(!is申請中);
        div.getBtnChosaJokyo().setDisabled(!is申請中);
        div.getBtnTainoJokyo().setDisabled(!is申請中);
        div.getCcdSonotaJoho().setDisabled(!is申請中);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnkousin"), !is申請中);
    }

    private void setHdnArea(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoManager manger = YokaigoNinteiJohoManager.createInstance();
        div.setHdnKaigoJimuCode(convertCodeToRString(manger.get介護導入形態コード(GyomuBunrui.介護事務.code())));
        div.setHdnKaigoNinteiCode(convertCodeToRString(manger.get介護導入形態コード(GyomuBunrui.介護認定.code())));
        div.setHdnShikibetsuKey(null != 認定情報.get識別コード受給() ? 認定情報.get識別コード受給().value() : RString.EMPTY);
    }

    private YokaigoNinteiJoho edit受給者台帳(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        builder.set受給者台帳データ区分(new Code(div.getCcdSonotaJoho().get異動事由()));
        builder.set受給者台帳異動理由(div.getCcdSonotaJoho().get理由());
        return builder.build();
    }

    private YokaigoNinteiJoho edit要介護認定申請情報受給(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        builder.set要介護認定申請情報受給取下区分コード(new Code(div.getCcdSonotaJoho().get異動事由()));
        builder.set要介護認定申請情報受給取下年月日(FlexibleDate.getNowDate());
        builder.set要介護認定申請情報受給取下理由(div.getCcdSonotaJoho().get理由());
        return builder.build();
    }

    private YokaigoNinteiJoho edit要介護認定申請情報認定(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        builder.set要介護認定申請情報認定取下区分コード(new Code(div.getCcdSonotaJoho().get異動事由()));
        builder.set要介護認定申請情報認定取下年月日(FlexibleDate.getNowDate());
        builder.set要介護認定申請情報認定取下理由(div.getCcdSonotaJoho().get理由());
        return builder.build();
    }

    private RDate convertFlexibleDateToRDate(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return null;
        }
        return new RDate(target.toString());
    }

    private RString convertCodeToRString(Code target) {
        return null == target || target.isEmpty() ? RString.EMPTY : target.value();
    }

    private RString get要介護度名(Code 厚労省IF識別コード, RString 要介護度コード) {
        RString 厚労省IF識別コードStr = convertCodeToRString(厚労省IF識別コード);
        try {
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
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }

    private boolean is受給() {
        return (DonyuKeitaiCode.事務単一.getCode().equals(div.getHdnKaigoJimuCode())
                && DonyuKeitaiCode.認定単一.getCode().equals(div.getHdnKaigoNinteiCode()))
                || (DonyuKeitaiCode.事務単一.getCode().equals(div.getHdnKaigoJimuCode())
                && div.getHdnKaigoNinteiCode().isNullOrEmpty())
                || (DonyuKeitaiCode.事務広域.getCode().equals(div.getHdnKaigoJimuCode())
                && DonyuKeitaiCode.認定広域.getCode().equals(div.getHdnKaigoNinteiCode()));
    }
}
