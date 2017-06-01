/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.kojinirainaiyoukoshin.KojinIraiNaiyouBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.KojinIraiNaiyouKoshinDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.KateiHomonUmu;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)の抽象Handlerクラスです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
public class KojinIraiNaiyouKoshinHandler {

    private final KojinIraiNaiyouKoshinDiv div;
    private static final RString キー_0 = new RString("key0");
    private static final RString キー_1 = new RString("key1");
    private static final RString 半角スペース = new RString(" ");
    private static final RString 半角スペースx2 = new RString("  ");
    private static final RString 調査依頼修正ボタン名 = new RString("btnChosaIraiNoToroku");
    private static final RString 意見書依頼修正ボタン名 = new RString("btnIkenshoIraiNoToroku");

    /**
     * コンストラクタです。
     *
     * @param div 個人依頼内容更新Div
     */
    public KojinIraiNaiyouKoshinHandler(KojinIraiNaiyouKoshinDiv div) {
        this.div = div;
    }

    /**
     * 個人依頼内容更新の初期化設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 今回調査情報 今回調査情報
     * @param 今回主治医情報 今回主治医情報
     * @param 前回調査情報 前回調査情報
     * @param 前回主治医情報 前回主治医情報
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, KojinIraiNaiyouBusiness 今回調査情報,
            KojinIraiNaiyouBusiness 今回主治医情報, KojinIraiNaiyouBusiness 前回調査情報,
            KojinIraiNaiyouBusiness 前回主治医情報) {
        div.getCcdNinteiShinseishaKihonInfo().initialize(申請書管理番号);
        div.getBtnChosaPrint().setDisabled(false);
        div.getBtnIkenshoPrint().setDisabled(false);
        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        NinteiShinseiJoho ninteiShinseiJoho = manager.get要介護認定申請情報(申請書管理番号);
        アクセスログ_照会(ninteiShinseiJoho.get証記載保険者番号(), ninteiShinseiJoho.get被保険者番号(), ninteiShinseiJoho.get申請書管理番号().getColumnValue());
        CommonButtonHolder.setDisabledByCommonButtonFieldName(調査依頼修正ボタン名, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼修正ボタン名, false);
        set今回調査依頼情報(今回調査情報);
        set前回調査依頼情報(前回調査情報);
        set今回主治医情報(今回主治医情報);
        set前回主治医情報(前回主治医情報);
    }
    
    private void アクセスログ_照会(RString 証記載保険者番号, RString 被保険者番号, RString 申請書管理番号) {
        DbAccessLogger accessLog = new DbAccessLogger();
        ExpandedInformation expandedInformation = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        accessLog.store(new ShoKisaiHokenshaNo(証記載保険者番号), 被保険者番号, expandedInformation);
        accessLog.flushBy(AccessLogType.照会);
    }

    private void set前回調査依頼情報(KojinIraiNaiyouBusiness 前回調査情報) {
        if (前回調査情報 != null 
                && 前回調査情報.getEntity() != null 
                && 前回調査情報.get認定調査依頼区分コード() != null 
                && NinteiChousaIraiKubunCode.初回.getコード().equals(前回調査情報.get認定調査依頼区分コード().value())) {
            div.getTxtChosaBashoKubunZen().setValue(前回調査情報.get認定調査実施場所コード() == null ? RString.EMPTY
                    : ChosaJisshiBashoCode.toValue(前回調査情報.get認定調査実施場所コード().value()).get名称());
            if (前回調査情報.get認定調査実施年月日() != null
                && !前回調査情報.get認定調査実施年月日().toString().equals("")) {
                div.getTxtChosaJisshibiZen().setValue(new RDate(前回調査情報.get認定調査実施年月日().toString()));
            }
            div.getTxtChosaJIsshiChikuCodeZen().setValue(前回調査情報.get地区コード());
            div.getTxtChosaJIsshiChikuZen().setValue(前回調査情報.get名称());
            div.getTxtChosaKikanCodeZen().setValue(前回調査情報.get認定調査委託先コード());
            div.getTxtChosaKikanZen().setValue(前回調査情報.get事業者名称());
            div.getTxtChosaItakuKubunZen().setValue(
                    RString.isNullOrEmpty(前回調査情報.get調査委託区分()) ||
                    前回調査情報.get調査委託区分().equals(半角スペース) ? RString.EMPTY
                    : ChosaItakuKubunCode.toValue(前回調査情報.get調査委託区分()).get名称());
            div.getTxtChosainCodeZen().setValue(前回調査情報.get認定調査員コード());
            div.getTxtChosainZen().setValue(前回調査情報.get調査員氏名());
            div.getTxtChosainShikakuZen().setValue(
                    RString.isNullOrEmpty(前回調査情報.get調査員資格()) ||
                    前回調査情報.get調査員資格().equals(半角スペースx2) ? RString.EMPTY
                    : Sikaku.toValue(前回調査情報.get調査員資格()).get名称());
            div.getTxtDenwaBangoZen().setDomain(前回調査情報.get電話番号());
            div.getTxtFaxZen().setDomain(前回調査情報.get番号());
        } else if (前回調査情報 != null 
                && 前回調査情報.getEntity() != null 
                && 前回調査情報.get認定調査依頼区分コード() != null 
                && (NinteiChousaIraiKubunCode.再依頼.getコード().equals(前回調査情報.get認定調査依頼区分コード().value())
                || NinteiChousaIraiKubunCode.再調査.getコード().equals(前回調査情報.get認定調査依頼区分コード().value()))) {
            div.getTxtChosaBashoKubunSaiZen().setValue(前回調査情報.get認定調査実施場所コード() == null
                    ? RString.EMPTY : ChosaJisshiBashoCode.toValue(前回調査情報.get認定調査実施場所コード().value()).get名称());                           
             if (前回調査情報.get認定調査実施年月日() != null 
                && !前回調査情報.get認定調査実施年月日().toString().equals("")) {
                div.getTxtChosaJisshibiSaiZen().setValue(new RDate(前回調査情報.get認定調査実施年月日().toString()));
            }
            div.getTxtChosaJIsshiChikuCodeSaiZen().setValue(前回調査情報.get地区コード());
            div.getTxtChosaJIsshiChikuSaiZen().setValue(前回調査情報.get名称());
            div.getTxtChosaKikanCodeSaiZen().setValue(前回調査情報.get認定調査委託先コード());
            div.getTxtChosaKikanSaiZen().setValue(前回調査情報.get事業者名称());
            div.getTxtChosaItakuKubunSaiZen().setValue(
                    RString.isNullOrEmpty(前回調査情報.get調査委託区分()) ||
                    前回調査情報.get調査委託区分().equals(半角スペース) ? RString.EMPTY
                    : ChosaItakuKubunCode.toValue(前回調査情報.get調査委託区分()).get名称());
            div.getTxtChosainCodeSaiZen().setValue(前回調査情報.get認定調査員コード());
            div.getTxtChosainSaiZen().setValue(前回調査情報.get調査員氏名());
            div.getTxtChosainShikakuSaiZen().setValue(
                    RString.isNullOrEmpty(前回調査情報.get調査員資格()) ||
                    前回調査情報.get調査員資格().equals(半角スペースx2) ? RString.EMPTY
                    : Sikaku.toValue(前回調査情報.get調査員資格()).get名称());
            div.getTxtDenwaBangoSaiZen().setDomain(前回調査情報.get電話番号());
            div.getTxtFaxSaiZen().setDomain(前回調査情報.get番号());
            div.getTxtHomonUmuZen().setValue(KateiHomonUmu.toValue(前回調査情報.is家庭訪問の有無()).get名称());
        }
    }

    private void set今回調査依頼情報(KojinIraiNaiyouBusiness 今回調査情報) {
        if (今回調査情報 != null 
                && 今回調査情報.getEntity() != null 
                && 今回調査情報.get認定調査依頼区分コード() != null 
                && NinteiChousaIraiKubunCode.初回.getコード().equals(今回調査情報.get認定調査依頼区分コード().value())) {
            div.getTxtChosaBashoKubun().setValue(今回調査情報.get認定調査実施場所コード() == null ? RString.EMPTY
                    : ChosaJisshiBashoCode.toValue(今回調査情報.get認定調査実施場所コード().value()).get名称());
            if (今回調査情報.get認定調査実施年月日() != null
                && !今回調査情報.get認定調査実施年月日().toString().equals("")) {
                div.getTxtChosaJisshibi().setValue(new RDate(今回調査情報.get認定調査実施年月日().toString()));
            }
            div.getTxtChosaJIsshiChikuCode().setValue(今回調査情報.get地区コード());
            div.getTxtChosaJIsshiChiku().setValue(今回調査情報.get名称());
            div.getTxtChosaKikanCode().setValue(今回調査情報.get認定調査委託先コード());
            div.getTxtChosaKikan().setValue(今回調査情報.get事業者名称());
            div.getTxtChosaItakuKubun().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査委託区分())||
                    今回調査情報.get調査委託区分().equals(半角スペース) ? RString.EMPTY
                    : ChosaItakuKubunCode.toValue(今回調査情報.get調査委託区分()).get名称());
            div.getTxtChosainCode().setValue(今回調査情報.get認定調査員コード());
            div.getTxtChosain().setValue(今回調査情報.get調査員氏名());
            div.getTxtChosainShikaku().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査員資格())||
                    今回調査情報.get調査員資格().equals(半角スペースx2) ? RString.EMPTY
                    : Sikaku.toValue(今回調査情報.get調査員資格()).get名称());
            div.getTxtDenwaBango().setDomain(今回調査情報.get電話番号());
            div.getTxtFax().setDomain(今回調査情報.get番号());
        } else if (今回調査情報 != null 
                && 今回調査情報.get認定調査依頼区分コード() != null 
                && (NinteiChousaIraiKubunCode.再依頼.getコード().equals(今回調査情報.get認定調査依頼区分コード().value())
                || NinteiChousaIraiKubunCode.再調査.getコード().equals(今回調査情報.get認定調査依頼区分コード().value()))) {
            div.getTxtChosaBashoKubunSai().setValue(今回調査情報.get認定調査実施場所コード() == null ? RString.EMPTY
                    : ChosaJisshiBashoCode.toValue(今回調査情報.get認定調査実施場所コード().value()).get名称());
            if (今回調査情報.get認定調査実施年月日() != null
                && !今回調査情報.get認定調査実施年月日().toString().equals("")) {
                div.getTxtChosaJisshibiSai().setValue(new RDate(今回調査情報.get認定調査実施年月日().toString()));
            }
            div.getTxtChosaJIsshiChikuCodeSai().setValue(今回調査情報.get地区コード());
            div.getTxtChosaJIsshiChikuSai().setValue(今回調査情報.get名称());
            div.getTxtChosaKikanCodeSai().setValue(今回調査情報.get認定調査委託先コード());
            div.getTxtChosaKikanSai().setValue(今回調査情報.get事業者名称());
            div.getTxtChosaItakuKubunSai().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査委託区分()) || 
                    今回調査情報.get調査委託区分().equals(半角スペース) ? RString.EMPTY
                    : ChosaItakuKubunCode.toValue(今回調査情報.get調査委託区分()).get名称());
            div.getTxtChosainCodeSai().setValue(今回調査情報.get認定調査員コード());
            div.getTxtChosainSai().setValue(今回調査情報.get調査員氏名());
            div.getTxtChosainShikakuSai().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査員資格()) ||
                    今回調査情報.get調査員資格().equals(半角スペースx2) ? RString.EMPTY
                    : Sikaku.toValue(今回調査情報.get調査員資格()).get名称());
            div.getTxtDenwaBangoSai().setDomain(今回調査情報.get電話番号());
            div.getTxtFaxSai().setDomain(今回調査情報.get番号());
            div.getTxtHomonUmu().setValue(KateiHomonUmu.toValue(今回調査情報.is家庭訪問の有無()).get名称());
        } else if (今回調査情報 != null 
                && 今回調査情報.getEntity() != null 
                && 今回調査情報.get認定調査依頼区分コード() == null 
                && (今回調査情報.get調査区分コード() == null 
                || ChosaKubun.新規調査.getコード().equals(今回調査情報.get調査区分コード().value()))) {
            div.getTxtChosaJIsshiChikuCode().setValue(今回調査情報.get地区コード_サブ());
            div.getTxtChosaJIsshiChiku().setValue(今回調査情報.get名称_サブ());
            div.getTxtChosaKikanCode().setValue(今回調査情報.get認定調査委託先コード_サブ());
            div.getTxtChosaKikan().setValue(今回調査情報.get事業者名称_サブ());
            div.getTxtChosaItakuKubun().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査委託区分_サブ())||
                    今回調査情報.get調査委託区分_サブ().equals(半角スペース) ? RString.EMPTY
                    : ChosaItakuKubunCode.toValue(今回調査情報.get調査委託区分_サブ()).get名称());
            div.getTxtChosainCode().setValue(今回調査情報.get認定調査員コード_サブ());
            div.getTxtChosain().setValue(今回調査情報.get調査員氏名_サブ());
            div.getTxtChosainShikaku().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査員資格_サブ())||
                    今回調査情報.get調査員資格_サブ().equals(半角スペースx2) ? RString.EMPTY
                    : Sikaku.toValue(今回調査情報.get調査員資格_サブ()).get名称());
            div.getTxtDenwaBango().setDomain(今回調査情報.get電話番号_サブ());
            div.getTxtFax().setDomain(今回調査情報.get番号_サブ());
            
            div.getBtnChosaPrint().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査依頼修正ボタン名, true);
        } else if (今回調査情報 != null 
                && 今回調査情報.getEntity() != null 
                && 今回調査情報.get認定調査依頼区分コード() == null 
                && ChosaKubun.再調査.getコード().equals(今回調査情報.get調査区分コード().value())) {
            div.getTxtChosaJIsshiChikuCodeSai().setValue(今回調査情報.get地区コード_サブ());
            div.getTxtChosaJIsshiChikuSai().setValue(今回調査情報.get名称_サブ());
            div.getTxtChosaKikanCodeSai().setValue(今回調査情報.get認定調査委託先コード_サブ());
            div.getTxtChosaKikanSai().setValue(今回調査情報.get事業者名称_サブ());
            div.getTxtChosaItakuKubunSai().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査委託区分_サブ()) || 
                    今回調査情報.get調査委託区分_サブ().equals(半角スペース) ? RString.EMPTY
                    : ChosaItakuKubunCode.toValue(今回調査情報.get調査委託区分_サブ()).get名称());
            div.getTxtChosainCodeSai().setValue(今回調査情報.get認定調査員コード_サブ());
            div.getTxtChosainSai().setValue(今回調査情報.get調査員氏名_サブ());
            div.getTxtChosainShikakuSai().setValue(
                    RString.isNullOrEmpty(今回調査情報.get調査員資格_サブ()) ||
                    今回調査情報.get調査員資格_サブ().equals(半角スペースx2) ? RString.EMPTY
                    : Sikaku.toValue(今回調査情報.get調査員資格_サブ()).get名称());
            div.getTxtDenwaBangoSai().setDomain(今回調査情報.get電話番号_サブ());
            div.getTxtFaxSai().setDomain(今回調査情報.get番号_サブ());
            div.getTxtHomonUmu().setValue(KateiHomonUmu.toValue(今回調査情報.is家庭訪問の有無()).get名称());
            
            div.getBtnChosaPrint().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査依頼修正ボタン名, true);
        } else {
            div.getBtnChosaPrint().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(調査依頼修正ボタン名, true);
        }
    }
    
   private void set今回主治医情報(KojinIraiNaiyouBusiness 今回主治医情報) {
        if (今回主治医情報 != null 
                && 今回主治医情報.getEntity() != null 
                && 今回主治医情報.get申請書管理番号() != null) {
            div.getTxtIkenshoSakuseiIraiRirekiBango().setValue(new RString(今回主治医情報.get主治医意見書作成依頼履歴番号()));
            div.getTxtIkenshoIraiKubun().setValue(IkenshoIraiKubun.toValue(今回主治医情報.get主治医意見書依頼区分()).get名称());
            div.getTxtIkenshoSakuseiKaisu().setValue(new Decimal(今回主治医情報.get主治医意見書作成回数()));
            if (今回主治医情報.get医師区分コード() != null 
                    && !今回主治医情報.get医師区分コード().value().isEmpty()) {
                div.getTxtShujiiShiteiiKubun().setValue(IshiKubunCode.toValue(今回主治医情報.get医師区分コード().value()).get名称());
            }
            if (今回主治医情報.get主治医意見書作成依頼年月日() != null
                && !今回主治医情報.get主治医意見書作成依頼年月日().toString().equals("")) {
                div.getTxtIkenshoIraibi().setValue(new RDate(今回主治医情報.get主治医意見書作成依頼年月日().toString()));
            }
            if (今回主治医情報.get主治医意見書記入年月日() != null
                && !今回主治医情報.get主治医意見書記入年月日().toString().equals("")) {
                div.getTxtIkenshoKinyubi().setValue(new RDate(今回主治医情報.get主治医意見書記入年月日().toString()));
            }
            List<RString> key = new ArrayList();
            if (今回主治医情報.is認定情報提供希望フラグ()) {
                key.add(キー_0);
            } else {
                key.add(キー_1);
            }
            div.getChkNinteiKekka().setSelectedItemsByKey(key);
            div.getTxtShujiiCode().setValue(今回主治医情報.get主治医コード());
            div.getTxtShujii().setValue(今回主治医情報.get主治医氏名());
            div.getTxtIryoKikanCode().setValue(今回主治医情報.get主治医医療機関コード());
            div.getTxtIryoKikan().setValue(今回主治医情報.get医療機関名称());
            div.getTxtYubinGango().setValue(今回主治医情報.get郵便番号());
            if (今回主治医情報.get住所() != null) {
                div.getTxtJusho().setDomain(new AtenaJusho(今回主治医情報.get住所()));
            }
            div.getTxtDenwaBangoIkensho().setDomain(今回主治医情報.get電話番号());
            div.getTxtFaxIkensho().setDomain(今回主治医情報.get番号());
            div.getTxtIryoKikanDaihyoshaShimei().setValue(今回主治医情報.get代表者名所());
        } else if (今回主治医情報 != null 
                && 今回主治医情報.getEntity() != null 
                && 今回主治医情報.get申請書管理番号() == null) {
            List<RString> key = new ArrayList();
            div.getChkNinteiKekka().setSelectedItemsByKey(key);
            div.getTxtShujiiCode().setValue(今回主治医情報.get主治医コード_サブ());
            div.getTxtShujii().setValue(今回主治医情報.get主治医氏名_サブ());
            div.getTxtIryoKikanCode().setValue(今回主治医情報.get主治医医療機関コード_サブ());
            div.getTxtIryoKikan().setValue(今回主治医情報.get医療機関名称_サブ());
            div.getTxtYubinGango().setValue(今回主治医情報.get郵便番号_サブ());
            div.getTxtJusho().setDomain(new AtenaJusho(今回主治医情報.get住所_サブ()));
            div.getTxtDenwaBangoIkensho().setDomain(今回主治医情報.get電話番号_サブ());
            div.getTxtFaxIkensho().setDomain(今回主治医情報.get番号_サブ());
            div.getTxtIryoKikanDaihyoshaShimei().setValue(今回主治医情報.get代表者名所_サブ());
            
            div.getBtnIkenshoPrint().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼修正ボタン名, true);
        } else {
            div.getBtnIkenshoPrint().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(意見書依頼修正ボタン名, true);
        }
   }
   private void set前回主治医情報(KojinIraiNaiyouBusiness 前回主治医情報) {
        if (前回主治医情報 != null 
                && 前回主治医情報.getEntity() != null 
                && 前回主治医情報.get申請書管理番号() != null) {
            div.getTxtIkenshoSakuseiIraiRirekiBangoZen().setValue(new RString(前回主治医情報.get主治医意見書作成依頼履歴番号()));
            div.getTxtIkenshoIraiKubunZen().setValue(IkenshoIraiKubun.toValue(前回主治医情報.get主治医意見書依頼区分()).get名称());
            div.getTxtIkenshoSakuseiKaisuZen().setValue(new Decimal(前回主治医情報.get主治医意見書作成回数()));
            div.getTxtShujiiShiteiiKubunZen().setValue(IshiKubunCode.toValue(前回主治医情報.get医師区分コード().value()).get名称());
            if (前回主治医情報.get主治医意見書作成依頼年月日() != null
                && !前回主治医情報.get主治医意見書作成依頼年月日().toString().equals("")) {
                div.getTxtIkenshoIraibiZen().setValue(new RDate(前回主治医情報.get主治医意見書作成依頼年月日().toString()));
            }
            if (前回主治医情報.get主治医意見書記入年月日() != null
                && !前回主治医情報.get主治医意見書記入年月日().toString().equals("")) {
                div.getTxtIkenshoKinyubiZen().setValue(new RDate(前回主治医情報.get主治医意見書記入年月日().toString()));
            }
            List<RString> key = new ArrayList();
            if (前回主治医情報.is認定情報提供希望フラグ()) {
                key.add(キー_0);
            } else {
                key.add(キー_1);
            }
            div.getChkNinteiKekkaZen().setSelectedItemsByKey(key);
            div.getTxtShujiiCodeZen().setValue(前回主治医情報.get主治医コード());
            div.getTxtShujiiZen().setValue(前回主治医情報.get主治医氏名());
            div.getTxtIryoKikanCodeZen().setValue(前回主治医情報.get主治医医療機関コード());
            div.getTxtIryoKikanZen().setValue(前回主治医情報.get医療機関名称());
            div.getTxtYubinGangoZen().setValue(前回主治医情報.get郵便番号());
            if (前回主治医情報.get住所() != null) {
                div.getTxtJushoZen().setDomain(new AtenaJusho(前回主治医情報.get住所()));
            }
            div.getTxtDenwaBangoIkenshoZen().setDomain(前回主治医情報.get電話番号());
            div.getTxtFaxIkenshoZen().setDomain(前回主治医情報.get番号());
            div.getTxtIryoKikanDaihyoshaShimeiZen().setValue(前回主治医情報.get代表者名所());
        }
   }
}
