/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchBusiness;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.core.basic.IchijiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShujiiIkenshoJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 一次判定結果情報のハンドラークラスです。
 */
public class IchijiHanteiKekkaJohoHandler {

    private final IchijiHanteiKekkaJohoDiv div;
    private static final RString 未 = new RString("未");
    private static final RString 済 = new RString("済");

    /**
     * コンストラクタです。
     *
     * @param div 一次判定結果情報Div
     */
    public IchijiHanteiKekkaJohoHandler(IchijiHanteiKekkaJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {

        ShinseishoKanriNo shinseishoKanriNo = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ModeType modeType = ViewStateHolder.get(ViewStateKeys.モード, ModeType.class);

        if (ModeType.SHOKAI_MODE.equals(modeType)) {

            NinteiShinseiJohoManager ninteiShinseiJohoManager = new NinteiShinseiJohoManager();
            NinteiShinseiJoho ninteiShinseiJoho = ninteiShinseiJohoManager.
                    get要介護認定申請情報(shinseishoKanriNo);

            IchijiHanteiKekkaJohoManager ichijiHanteiKekkaJohoManager = new IchijiHanteiKekkaJohoManager();

            IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho = ichijiHanteiKekkaJohoManager.
                    get要介護認定一次判定結果情報(shinseishoKanriNo);

            NinteichosahyoKihonChosaManager ninteichosahyoKihonChosaManager = new NinteichosahyoKihonChosaManager();
            List<NinteichosahyoKihonChosa> returnListDbt5203
                    = ninteichosahyoKihonChosaManager.get認定調査票_基本調査By申請書管理番号(shinseishoKanriNo);
            if (returnListDbt5203.isEmpty()) {
                div.getTxtJiritsudoChosa().setValue(未);
            } else {
                div.getTxtJiritsudoChosa().setValue(済);
            }

            ShujiiIkenshoJohoManager shujiiIkenshoJohoManager = new ShujiiIkenshoJohoManager();
            List<ShujiiIkenshoJoho> returnListDbt5302
                    = shujiiIkenshoJohoManager.get要介護認定主治医意見書情報By申請書管理番号(shinseishoKanriNo);
            if (returnListDbt5302.isEmpty()) {
                div.getTxtJiritsudoIkensho().setValue(未);
            } else {
                div.getTxtJiritsudoIkensho().setValue(済);
            }

            if (ichijiHanteiKekkaJoho != null) {
                div.getTxtIchijiHanteibi().setValue(ichijiHanteiKekkaJoho.get要介護認定一次判定年月日());

                if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(
                        ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode99.toValue(ichijiHanteiKekkaJoho.get要介護認定一次判定結果コード().value()).get名称());
                } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(
                        ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode02.toValue(ichijiHanteiKekkaJoho.get要介護認定一次判定結果コード().value()).get名称());
                } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(
                        ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode06.toValue(ichijiHanteiKekkaJoho.get要介護認定一次判定結果コード().value()).get名称());
                } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                        ninteiShinseiJoho.get厚労省IF識別コード().value())
                        || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode09.toValue(ichijiHanteiKekkaJoho.get要介護認定一次判定結果コード().value()).get名称());
                }

                div.getTxtKijunJikan().setValue(new RString(String.valueOf(ichijiHanteiKekkaJoho.toEntity().getKijunJikan())));
                div.getTxtShokuji().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanShokuji()));
                div.getTxtHaisetsu().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanHaisetsu()));
                div.getTxtIdo().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanIdo()));
                div.getTxtSeiketsuHoji().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanSeiketsuHoji()));
                div.getTxtKansetsuCare().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanKansetsuCare()));
                div.getTxtBpsdKanren().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanBPSDKanren()));
                div.getTxtKinoKunren().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanKinoKunren()));
                div.getTxtIryoKanren().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanIryoKanren()));
                div.getTxtNinchishoKasan().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getKijunJikanNinchishoKasan()));
                div.getTxtDai1gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku1gun()));
                div.getTxtDai2gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku2gun()));
                div.getTxtDai3gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku3gun()));
                div.getTxtDai4gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku4gun()));
                div.getTxtDai5gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku5gun()));
                div.getTxtDai6gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku6gun()));
                div.getTxtDai7gun().setValue(new Decimal(ichijiHanteiKekkaJoho.toEntity().getChukanHyokaKomoku7gun()));
                div.getTxtGaizensei().setValue(ichijiHanteiKekkaJoho.toEntity().getNinchishoJiritsudoIIijoNoGaizensei());
                if (ichijiHanteiKekkaJoho.toEntity().getJotaiAnteiseiCode() != null) {
                    div.getTxtJyotaiAnteisei().setValue(
                            JotaiAnteiseiCode.toValue(ichijiHanteiKekkaJoho.toEntity().getJotaiAnteiseiCode().value()).get名称());
                }
                if (ichijiHanteiKekkaJoho.toEntity().getSuiteiKyufuKubunCode() != null) {
                    div.getTxtKyufuKbn().setValue(
                            SuiteiKyufuKubunCode.toValue(ichijiHanteiKekkaJoho.toEntity().getSuiteiKyufuKubunCode().value()).get名称());
                }
                List<dgIchijiHanteiKeikokuCode_Row> rowList = new ArrayList<>();
                List<RString> codeList = new ArrayList<>();

                RString 一次判定警告コード = ichijiHanteiKekkaJoho.toEntity().getIchijiHnateiKeikokuCode();
                if (一次判定警告コード != null) {
                    List<RString> 一次判定警告コードList = 一次判定警告コード.toRStringList();
                    for (int i = 0; i < 一次判定警告コードList.size(); i++) {
                        if (new RString("1").equals(一次判定警告コードList.get(i))) {
                            codeList.add(new RString(String.format("%02d", i + 1)));
                        }
                    }

                    for (int i = 0; i < codeList.size(); i++) {
                        dgIchijiHanteiKeikokuCode_Row row = new dgIchijiHanteiKeikokuCode_Row();
                        row.setNo(new RString(String.valueOf(i + 1)));
                        row.setCode(codeList.get(i));
                        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value())
                                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                                        ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                            row.setSetsumei(IchijiHanteiKeikoku.toValue(codeList.get(i)).get名称());
                        }
                        rowList.add(row);
                    }
                    div.getDgIchijiHanteiKeikokuCode().setDataSource(rowList);
                }
            }
        } else if (ModeType.ADD_MODE.equals(modeType)) {
            IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
            IchijiHanteiKekkaJohoSearchBusiness business = manager.getIchijiHanteiKekkaJoho(shinseishoKanriNo);

            if (business != null) {
                div.getTxtIchijiHanteibi().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
                div.getTxtIchijiHanteiKekka().setValue(
                        IchijiHanteiKekkaCode99.toValue(business.get一次判定結果()).get名称());
                div.getTxtKijunJikan().setValue(new RString(String.valueOf(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10)));
                // TODO
                div.getTxtShokuji().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtHaisetsu().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtIdo().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtSeiketsuHoji().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtKansetsuCare().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtBpsdKanren().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtKinoKunren().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtIryoKanren().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtNinchishoKasan().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtDai1gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai2gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai3gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai4gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai5gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai6gun().setValue(new Decimal(0));
                div.getTxtDai7gun().setValue(new Decimal(0));
                div.getTxtGaizensei().setValue(new Decimal(Integer.valueOf(business.get認知症自立度Ⅱ以上の蓋然性_評価の１０倍().toString()) / 10));
                if (business.get状態の安定性() != null) {
                    div.getTxtJyotaiAnteisei().setValue(
                            JotaiAnteiseiCode.toValue(business.get状態の安定性()).get名称());
                }
                if (business.get認知機能及び状態安定性から推定される給付区分() != null) {
                    div.getTxtKyufuKbn().setValue(
                            SuiteiKyufuKubunCode.toValue(business.get認知機能及び状態安定性から推定される給付区分()).get名称());
                }

                if (business.get認定調査票_基本調査_件数() == 0) {
                    div.getTxtJiritsudoChosa().setValue(未);
                } else {
                    div.getTxtJiritsudoChosa().setValue(済);
                }

                if (business.get要介護認定主治医意見書情報件数() == 0) {
                    div.getTxtJiritsudoIkensho().setValue(未);
                } else {
                    div.getTxtJiritsudoIkensho().setValue(済);
                }

                List<dgIchijiHanteiKeikokuCode_Row> rowList = new ArrayList<>();
                List<RString> codeList = new ArrayList<>();

                RString 一次判定警告コード = business.get一次判定警告コード();
                if (一次判定警告コード != null) {
                    List<RString> 一次判定警告コードList = 一次判定警告コード.toRStringList();
                    for (int i = 0; i < 一次判定警告コードList.size(); i++) {
                        if (new RString("1").equals(一次判定警告コードList.get(i))) {
                            codeList.add(new RString(String.format("%02d", i + 1)));
                        }
                    }

                    for (int i = 0; i < codeList.size(); i++) {
                        dgIchijiHanteiKeikokuCode_Row row = new dgIchijiHanteiKeikokuCode_Row();
                        row.setNo(new RString(String.valueOf(i + 1)));
                        row.setCode(codeList.get(i));
                        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                                business.get厚労省IF識別コード().value())
                                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                                        business.get厚労省IF識別コード().value())) {
                            row.setSetsumei(IchijiHanteiKeikoku.toValue(codeList.get(i)).get名称());
                        }
                        rowList.add(row);
                    }
                    div.getDgIchijiHanteiKeikokuCode().setDataSource(rowList);
                }
            }
        }
    }

    /**
     * 呼び出し元画面への戻り値設定。
     *
     */
    public void 呼び出し元画面への戻り値() {

        ShinseishoKanriNo shinseishoKanriNo = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ModeType modeType = ViewStateHolder.get(ViewStateKeys.モード, ModeType.class);
        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        IchijiHanteiKekkaJohoSearchBusiness business = manager.getIchijiHanteiKekkaJoho(shinseishoKanriNo);

        if (ModeType.SHOKAI_MODE.equals(modeType)) {

            RString 一次判定結果 = div.getTxtIchijiHanteiKekka().getValue();
            ViewStateHolder.put(ViewStateKeys.一次判定結果_一次判定結果, 一次判定結果);

        } else if (ModeType.ADD_MODE.equals(modeType)
                && business != null
                && (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                        business.get厚労省IF識別コード().value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                        business.get厚労省IF識別コード().value()))) {
            IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho = new IchijiHanteiKekkaJoho(shinseishoKanriNo);

            boolean kariIchijiHanteiKubun = false;
            if (div.getTxtJiritsudoIkensho().getValue().isNullOrEmpty()) {
                kariIchijiHanteiKubun = true;
            }
            ichijiHanteiKekkaJoho.toEntity().setKariIchijiHanteiKubun(kariIchijiHanteiKubun);
            ichijiHanteiKekkaJoho.toEntity().setIchijiHanteiYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
            ichijiHanteiKekkaJoho.toEntity().setIchijiHanteiKekkaCode(new Code(business.get一次判定結果()));
            ichijiHanteiKekkaJoho.toEntity().setIchijiHanteiKekkaNinchishoKasanCode(new Code(business.get認知症加算後の一次判定結果()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikan(Integer.valueOf(div.getTxtKijunJikan().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanShokuji(Integer.valueOf(div.getTxtShokuji().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanHaisetsu(Integer.valueOf(div.getTxtHaisetsu().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanIdo(Integer.valueOf(div.getTxtIdo().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanSeiketsuHoji(Integer.valueOf(div.getTxtSeiketsuHoji().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanKansetsuCare(Integer.valueOf(div.getTxtKansetsuCare().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanBPSDKanren(Integer.valueOf(div.getTxtBpsdKanren().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanKinoKunren(Integer.valueOf(div.getTxtKinoKunren().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanIryoKanren(Integer.valueOf(div.getTxtIryoKanren().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setKijunJikanNinchishoKasan(Integer.valueOf(div.getTxtNinchishoKasan().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku1gun(Integer.valueOf(div.getTxtDai1gun().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku2gun(Integer.valueOf(div.getTxtDai2gun().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku3gun(Integer.valueOf(div.getTxtDai3gun().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku4gun(Integer.valueOf(div.getTxtDai4gun().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku5gun(Integer.valueOf(div.getTxtDai5gun().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku6gun(0);
            ichijiHanteiKekkaJoho.toEntity().setChukanHyokaKomoku7gun(0);
            ichijiHanteiKekkaJoho.toEntity().setIchijiHnateiKeikokuCode(business.get一次判定警告コード());
            ichijiHanteiKekkaJoho.toEntity().setJotaiAnteiseiCode(new Code(business.get状態の安定性()));
            ichijiHanteiKekkaJoho.toEntity().
                    setNinchishoJiritsudoIIijoNoGaizensei(new Decimal(div.getTxtGaizensei().getValue().toString()));
            ichijiHanteiKekkaJoho.toEntity().setSuiteiKyufuKubunCode(new Code(business.get認知機能及び状態安定性から推定される給付区分()));
            ichijiHanteiKekkaJoho.toEntity().setNinchishoKoreishaShihyoCode(new Code("1"));
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase1(0);
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase2(0);
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase3(0);
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase4(0);
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase5(0);
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase6(0);
            ichijiHanteiKekkaJoho.toEntity().setJiritsudoKumiawase7(0);
            ichijiHanteiKekkaJoho.toEntity().setGaizenseiHyokaCode(Code.EMPTY);
            ichijiHanteiKekkaJoho.toEntity().setGaizenseiHyokaPercent(0);
            ichijiHanteiKekkaJoho.toEntity().setIchijiHanteiSofuKubun(RString.EMPTY);
            ichijiHanteiKekkaJoho.toEntity().setIchijiHanteiKekkaSofuYMD(FlexibleDate.EMPTY);
            ichijiHanteiKekkaJoho.toEntity().setChert(RString.EMPTY);
            ichijiHanteiKekkaJoho.toEntity().setJotaizo(RString.EMPTY);

            ViewStateHolder.put(ViewStateKeys.一次判定結果_一次判定結果情報, ichijiHanteiKekkaJoho);
        }
    }
}
