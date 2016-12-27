/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE491001.DBE491001_NichijiShinchokuParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE525002.DBE525002_HanteiKekkaHokenshaParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.KanryoInfoPhase;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 判定結果情報出力(保険者)の取得するクラスです。
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public class NijihanteiKekkaOutputHandler {

    private final NijihanteiKekkaOutputDiv nijidiv;
    private final RString 男 = new RString("key0");
    private final RString 女 = new RString("key1");
    private final RString 判定結果ボタン = new RString("btnRenkeiDataOutput");
    private final RString 判定結果ボタン２ = new RString("btnCheck1");
    private final RString 連携ボタン = new RString("btnHanteikekkaOutput");
    private final RString 連携ボタン２ = new RString("btnCheck2");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString 未出力のみ = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param nijidiv 判定結果情報出力(保険者)
     */
    public NijihanteiKekkaOutputHandler(NijihanteiKekkaOutputDiv nijidiv) {
        this.nijidiv = nijidiv;
    }

    /**
     * 判定結果情報出力(保険者)初期処理する。
     */
    public void initialize() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(判定結果ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(連携ボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン２, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン２, true);
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().setValue(new Decimal(検索制御_最大取得件数.toString()));
        List<dgTaishoshaIchiran_Row> dgKoufuKaishuList = new ArrayList<>();
        nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgKoufuKaishuList);
        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNijiHanteiDateFrom().setDisplayNone(true);
        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getLblNijiHanteiDate().setDisplayNone(true);
        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtNijiHnateiDateTo().setDisplayNone(true);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 判定結果情報出力(保険者)検索処理する。
     *
     * @param 被保険者番号
     */
    public void kennsaku(RString 被保険者番号) {
        List<dgTaishoshaIchiran_Row> dgTaishoshaIchiranList = new ArrayList<>();
        HanteiKekkaJouhouShuturyokuParameter hanteiParameter = createParameter(被保険者番号);
        SearchResult<HanteiKekkaJouhouShuturyokuBusiness> 判定結果情報検索結果 = HanteiKekkaJouhouShuturyokuFinder.createInstance()
                .getHanteiKekka(hanteiParameter);
        List<HanteiKekkaJouhouShuturyokuBusiness> ninteiList = 判定結果情報検索結果.records();
        if (ninteiList != null && !ninteiList.isEmpty()) {
            for (HanteiKekkaJouhouShuturyokuBusiness jigyoshaInput : ninteiList) {
                dgTaishoshaIchiran_Row dgFukushiyoguShohin = new dgTaishoshaIchiran_Row();
                dgFukushiyoguShohin.getHihokenshaNo().setValue(nullToEmpty(jigyoshaInput.get被保険者番号()));
                dgFukushiyoguShohin.setHihokenshaShimei(nullToEmpty(jigyoshaInput.get被保険者氏名()));
                dgFukushiyoguShohin.setHihokenshaKanaShimei(nullToEmpty(jigyoshaInput.get被保険者カナ氏名()));
                dgFukushiyoguShohin.setSeibetsu(Seibetsu.toValue(jigyoshaInput.get性別()).get名称());
                if (jigyoshaInput.get生年月日() != null) {
                    dgFukushiyoguShohin.getBirthYMD().setValue(new FlexibleDate(jigyoshaInput.get生年月日().toString()));
                }
                dgFukushiyoguShohin.getNinteiShinseiDay().
                        setValue(jigyoshaInput.get認定申請年月日() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(jigyoshaInput.get認定申請年月日().toString()));
                dgFukushiyoguShohin.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.
                        toValue(jigyoshaInput.get認定申請区分_申請時コード()).get名称());
                if (jigyoshaInput.get二次判定要介護状態区分コード() != null) {
                    dgFukushiyoguShohin.setNijiHanteiKekka(YokaigoJotaiKubun09.toValue(jigyoshaInput.get二次判定要介護状態区分コード()).get名称());
                }
                RStringBuilder 審査会名称 = new RStringBuilder();
                審査会名称.append(new RString("第"));
                審査会名称.append(jigyoshaInput.get開催番号() == null ? RString.EMPTY : jigyoshaInput.get開催番号());
                審査会名称.append(new RString("回審査会"));
                dgFukushiyoguShohin.setKaigoNinteiShinsakaiName(審査会名称.toRString());
                hiduke(dgFukushiyoguShohin, jigyoshaInput);
                dgFukushiyoguShohin.setShinseishoKanriNo(jigyoshaInput.get申請書管理番号());
                dgTaishoshaIchiranList.add(dgFukushiyoguShohin);
                アクセスログ();
            }
            DataGridSetting gridSetting = nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getGridSetting();
            gridSetting.setLimitRowCount(hanteiParameter.getLimitCount());
            gridSetting.setSelectedRowCount(判定結果情報検索結果.totalCount());
            nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setGridSetting(gridSetting);

            CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(判定結果ボタン２, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(連携ボタン２, false);
        } else {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        }
        nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgTaishoshaIchiranList);
    }

    /**
     * 検索条件を作成します。
     *
     * @return 検索条件
     */
    private HanteiKekkaJouhouShuturyokuParameter createParameter(RString 被保険者番号) {
        HanteiKekkaJouhouShuturyokuParameter parameter = new HanteiKekkaJouhouShuturyokuParameter();
        int 最大表示件数 = Integer.parseInt(nijidiv.getKensakuJoken().getTxtHyojiDataLimit().getValue().toString());
        if (最大表示件数 != 0) {
            parameter.setUseLimitCount(true);
            parameter.setLimitCount(最大表示件数);
        }
        NinteiShinseishaFinderDiv finderDiv = nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv();
        editShosaiJokenForParameter(finderDiv, parameter, 被保険者番号);
        editNinteiChosaForParameter(finderDiv, parameter);
        editShujiiJohoForParameter(finderDiv, parameter);
        editShinsakaiJohoForParameter(finderDiv, parameter);
        editZenkaiJohoForParameter(finderDiv, parameter);
        editNowPhaseForParameter(finderDiv, parameter);
        editChkForParameter(finderDiv, parameter);
        return parameter;
    }

    private void editShosaiJokenForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter, RString 被保険者番号) {
        RString fromtime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue() != null) {
            fromtime = new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString());
        }
        RString totime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue() != null) {
            totime = new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString());
        }
        FlexibleDate 二次判定日FROM = new FlexibleDate(fromtime);
        if (!FlexibleDate.EMPTY.equals(二次判定日FROM)) {
            parameter.setNijiHanteiYMDFrom(二次判定日FROM);
            parameter.setUseNijiHanteiYMDFrom(true);
        }
        FlexibleDate 二次判定日To = new FlexibleDate(totime);
        if (!FlexibleDate.EMPTY.equals(二次判定日To)) {
            parameter.setNijiHanteiYMDTo(二次判定日To);
            parameter.setUseNijiHanteiYMDTo(true);
        }
        RString データ出力有無 = nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey();
        if (未出力のみ.equals(データ出力有無)) {
            parameter.setUseMisyutsuryokuNomi(true);
        }
        if (!RString.isNullOrEmpty(被保険者番号)) {
            parameter.setHihokenshaNo(被保険者番号);
            parameter.setUseHihokenshaNo(true);
        }
        RString 証記載保険者番号 = finderDiv.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号().getColumnValue();
        if (!RString.isNullOrEmpty(証記載保険者番号)) {
            parameter.setShoKisaiHokenshaNo(証記載保険者番号);
            parameter.setUseShoKisaiHokenshaNo(true);
        }

        RString 支所コード = finderDiv.getDdlShichosonCode().getSelectedKey();
        if (!RString.isNullOrEmpty(支所コード)) {
            parameter.setShishoCode(支所コード);
            parameter.setUseShishoCode(true);
        }

        RString 被保険者氏名 = finderDiv.getTxtHihokenshaName().getValue().replace(RString.FULL_SPACE, RString.EMPTY);
        if (!RString.isNullOrEmpty(被保険者氏名)) {
            RString hihokenshaNameMatchType = finderDiv.getDdlHihokenshaNameMatchType().getSelectedKey();
            if (KEY0.equals(hihokenshaNameMatchType)) {
                parameter.set前方一致(true);
            } else if (KEY1.equals(hihokenshaNameMatchType)) {
                parameter.set完全一致(true);
            } else if (KEY2.equals(hihokenshaNameMatchType)) {
                parameter.set部分一致(true);
            } else if (KEY3.equals(hihokenshaNameMatchType)) {
                parameter.set後方一致(true);
            }
            parameter.set被保険者名(被保険者氏名);
        }
        List<KeyValueDataSource> みなし２号申請 = finderDiv.getChkMinashiFlag().getSelectedItems();
        if (みなし２号申請.isEmpty()) {
            parameter.setMinashiNigoEtcTaishoFlag(false);
        } else {
            parameter.setMinashiNigoEtcTaishoFlag(true);
        }
        FlexibleDate 認定申請日FROM = finderDiv.getTxtNinteiShinseiDateFrom().getValue();
        if (認定申請日FROM != null && !FlexibleDate.EMPTY.equals(認定申請日FROM)) {
            parameter.setNinteiShinseiYMDFrom(認定申請日FROM);
            parameter.setUseNinteiShinseiYMDFrom(true);
        }

        FlexibleDate 認定申請日To = finderDiv.getTxtNinteiShinseiDateTo().getValue();
        if (認定申請日To != null && !FlexibleDate.EMPTY.equals(認定申請日To)) {
            parameter.setNinteiShinseiYMDTo(認定申請日To);
            parameter.setUseNinteiShinseiYMDTo(true);
        }
        FlexibleDate 生年月日From = finderDiv.getTxtBirthDateFrom().getValue();
        if (生年月日From != null && !FlexibleDate.EMPTY.equals(生年月日From)) {
            parameter.setSeinengappiYMDFrom(生年月日From);
            parameter.setUseSeinengappiYMDFrom(true);
        }
        FlexibleDate 生年月日To = finderDiv.getTxtBirthDateTO().getValue();
        if (生年月日To != null && !FlexibleDate.EMPTY.equals(生年月日To)) {
            parameter.setSeinengappiYMDTo(生年月日To);
            parameter.setUseSeinengappiYMDTo(true);
        }
        RString 認定申請区分申請時コード = finderDiv.getDdlShinseijiShinseiKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(認定申請区分申請時コード)) {
            parameter.setNinteiShinseiShinseijiKubun(認定申請区分申請時コード);
            parameter.setUseNinteiShinseiShinseijiKubun(true);
        }
        edit性別ForParameter(finderDiv, parameter);
    }

    private void edit性別ForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        List<KeyValueDataSource> 性別 = finderDiv.getChkSeibetsu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 性別) {
            if (男.equals(keyValueDataSource.getKey())) {
                parameter.setMan(true);
            }
            if (女.equals(keyValueDataSource.getKey())) {
                parameter.setWoman(true);
            }
        }
    }

    private void editNinteiChosaForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        RString 被保険者区分コード = finderDiv.getDdlHihokenshaKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(被保険者区分コード)) {
            parameter.setHihokenshaKubunCode(被保険者区分コード);
            parameter.setUseHihokenshaKubunCode(true);
        }
        RString 認定申請区分法令コード = finderDiv.getDdlHoreiShinseiji().getSelectedKey();
        if (!RString.isNullOrEmpty(認定申請区分法令コード)) {
            parameter.setNinteiShinseiHoreiKubunCode(認定申請区分法令コード);
            parameter.setUseNinteiShinseiHoreiKubunCode(true);
        }
        RString 処理状態区分 = finderDiv.getDdlShoriKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(処理状態区分)) {
            parameter.setShoriJotaiKubun(処理状態区分);
            parameter.setUseShoriJotaiKubun(true);
        }
        RString 厚労省IF識別コード = finderDiv.getDdlKoroshoShikibetsuCode().getSelectedKey();
        if (!RString.isNullOrEmpty(厚労省IF識別コード)) {
            parameter.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
            parameter.setUseKoroshoIfShikibetsuCode(true);
        }
        RString 郵便番号 = finderDiv.getTxtYubinNo().getValue().value();
        if (!RString.isNullOrEmpty(郵便番号)) {
            parameter.setYubinNo(郵便番号);
            parameter.setUseYubinNo(true);
        }
        RString 地区コード = finderDiv.getDdlChiku().getSelectedKey();
        if (!RString.isNullOrEmpty(地区コード)) {
            parameter.setChikuCode(地区コード);
            parameter.setUseChikuCode(true);
        }

        List<RString> 施設入所の有無List = finderDiv.getChkShisetsuNyusho().getSelectedKeys();
        boolean isAllSelectableOrNoSelected = finderDiv.getChkShisetsuNyusho().isIsAllSelectable() || 施設入所の有無List.size() == 0;
        if (!isAllSelectableOrNoSelected) {
            RString 施設入所の有無 = 施設入所の有無List.get(0);
            if (KEY0.equals(施設入所の有無)) {
                parameter.setShisetsuNyushoFlag(true);
            }
            if (KEY1.equals(施設入所の有無)) {
                parameter.setShisetsuNyushoFlag(false);
            }
            parameter.setIgnoreShisetsuNyusho(false);
        } else {
            parameter.setShisetsuNyushoFlag(false);
            parameter.setIgnoreShisetsuNyusho(true);
        }

        RString 認定調査委託先コード = finderDiv.getTxtNinteiChosaItakusakiName().getValue();
        if (!RString.isNullOrEmpty(認定調査委託先コード)) {
            parameter.setNinteiChosaItakusakiCode(finderDiv.getHdnChosaItakusakiCode());
            parameter.setUseNinteiChosaItakusakiCode(true);
        }

        RString 認定調査員氏名 = finderDiv.getTxtNinteiChosainName().getValue();
        if (!RString.isNullOrEmpty(認定調査員氏名)) {
            parameter.setNinteiChosainCode(finderDiv.getHdnChosainCode());
            parameter.setUseNinteiChosainCode(true);
        }
        boolean useNinteichosahyoGaikyoChosa = false;
        RString 認定調査実施場所コード = finderDiv.getDdlChosaJisshiBasho().getSelectedKey();
        if (!RString.isNullOrEmpty(認定調査実施場所コード)) {
            parameter.setChosaJisshiBashoCode(認定調査実施場所コード);
            parameter.setUseChosaJisshiBashoCode(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        RString 認定調査区分コード = finderDiv.getDdlChosaKubun().getSelectedKey();
        if (!RString.isNullOrEmpty(認定調査区分コード)) {
            parameter.setNinteiChosaKubunCode(認定調査区分コード);
            parameter.setUseNinteiChosaKubunCode(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        FlexibleDate 調査実施日FROM = finderDiv.getTxtChosaJisshiDateFrom().getValue();
        if (調査実施日FROM != null && !FlexibleDate.EMPTY.equals(調査実施日FROM)) {
            parameter.setNinteichosaJisshiYMDFrom(調査実施日FROM);
            parameter.setUseNinteichosaJisshiYMDFrom(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        FlexibleDate 調査実施日TO = finderDiv.getTxtChosaJisshiDateTo().getValue();
        if (調査実施日TO != null && !FlexibleDate.EMPTY.equals(調査実施日TO)) {
            parameter.setNinteichosaJisshiYMDTo(調査実施日TO);
            parameter.setUseNinteichosaJisshiYMDTo(true);
            useNinteichosahyoGaikyoChosa = true;
        }
        parameter.setUseNinteichosahyoGaikyoChosa(useNinteichosahyoGaikyoChosa);
        boolean useNinteichosahyoKihonChosa = false;
        RString 寝きたり度 = finderDiv.getDdlNinteiChosaNetakirido().getSelectedKey();
        if (!RString.isNullOrEmpty(寝きたり度)) {
            parameter.setNichijoSeikatsuJiritsudoCode(寝きたり度);
            parameter.setUseNichijoSeikatsuJiritsudoCd(true);
            useNinteichosahyoKihonChosa = true;
        }
        RString 認知度 = finderDiv.getDdlNinteiChosaNinchido().getSelectedKey();
        if (!RString.isNullOrEmpty(認知度)) {
            parameter.setNichijoSeikatsuJiritsudo(認知度);
            parameter.setUseNichijoSeikatsuJiritsudo(true);
            useNinteichosahyoKihonChosa = true;
        }
        parameter.setUseNinteichosahyoKihonChosa(useNinteichosahyoKihonChosa);
    }

    private void editShujiiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        RString 主治医医療機関 = finderDiv.getTxtShujiiIryokikanName().getValue();
        if (!RString.isNullOrEmpty(主治医医療機関)) {
            parameter.setShujiiIryokikanCode(finderDiv.getHdnShujiiIryokikanCode());
            parameter.setUseShujiiIryokikanCode(true);
        }
        RString 主治医氏名 = finderDiv.getTxtShujiiName().getValue();
        if (!RString.isNullOrEmpty(主治医氏名)) {
            parameter.setShujiiCode(finderDiv.getHdnShujiiCode());
            parameter.setUseShujiiCode(true);
        }

        RString 医師区分コード = finderDiv.getDdlShujiIkubun().getSelectedKey();
        if (!RString.isNullOrEmpty(医師区分コード)) {
            parameter.setIshiKubunCode(医師区分コード);
            parameter.setUseIshiKubunCode(true);
            parameter.setUseShujiiIkenshoIraiJoho(true);
        }
        boolean useShujiiIkenshoJoho = false;
        FlexibleDate 意見書受領日FROM = finderDiv.getTxtIkenshoKinyuDateFrom().getValue();
        if (意見書受領日FROM != null && !FlexibleDate.EMPTY.equals(意見書受領日FROM)) {
            parameter.setIkenshoJuryoYMDFrom(意見書受領日FROM);
            parameter.setUseIkenshoJuryoYMDFrom(true);
            useShujiiIkenshoJoho = true;
        }
        FlexibleDate 意見書受領日To = finderDiv.getTxtIkenshoKinyuDateTo().getValue();
        if (意見書受領日To != null && !FlexibleDate.EMPTY.equals(意見書受領日To)) {
            parameter.setIkenshoJuryoYMDTo(意見書受領日To);
            useShujiiIkenshoJoho = true;
        }
        parameter.setUseShujiiIkenshoJoho(useShujiiIkenshoJoho);
        boolean useShujiiIkenshoIkenItem = false;
        RString 意見項目13 = finderDiv.getDdlShujiJohoNetakirido().getSelectedKey();
        if (!RString.isNullOrEmpty(意見項目13)) {
            parameter.setIkenItem13(意見項目13);
            parameter.setUseIkenItem13(true);
            useShujiiIkenshoIkenItem = true;
        }
        RString 意見項目14 = finderDiv.getDdlShujiJohoNinchido().getSelectedKey();
        if (!RString.isNullOrEmpty(意見項目14)) {
            parameter.setIkenItem14(意見項目14);
            parameter.setUseIkenItem14(true);
            useShujiiIkenshoIkenItem = true;
        }
        parameter.setUseShujiiIkenshoIkenItem(useShujiiIkenshoIkenItem);
        boolean useIchijiHanteiKekkaJoho = false;
        FlexibleDate 一次判定日FROM = finderDiv.getTxtIchijiHanteiDateFrom().getValue();
        if (一次判定日FROM != null && !FlexibleDate.EMPTY.equals(一次判定日FROM)) {
            parameter.setIchijiHanteiYMDFrom(一次判定日FROM);
            parameter.setUseIchijiHanteiYMDFrom(true);
            useIchijiHanteiKekkaJoho = true;
        }
        FlexibleDate 一次判定日To = finderDiv.getTxtIchijiHanteiDateTo().getValue();
        if (一次判定日To != null && !FlexibleDate.EMPTY.equals(一次判定日To)) {
            parameter.setIchijiHanteiYMDTo(一次判定日To);
            parameter.setUseIchijiHanteiYMDTo(true);
            useIchijiHanteiKekkaJoho = true;
        }
        RString 一次判定結果コード = finderDiv.getDdlIchijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(一次判定結果コード)) {
            parameter.setIchijiHanteiKekkaCode(一次判定結果コード);
            parameter.setUseIchijiHanteiKekkaCode(true);
            useIchijiHanteiKekkaJoho = true;
        }
        parameter.setUseIchijiHanteiKekkaJoho(useIchijiHanteiKekkaJoho);
        editIchiGohanteiForParameter(finderDiv, parameter);
    }

    private void editIchiGohanteiForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        boolean useIchiGojiHanteiKekkaJoho = false;
        FlexibleDate ichiGoHanteiDateFrom = finderDiv.getTxtIchiGoHanteiDateFrom().getValue();
        if (ichiGoHanteiDateFrom != null && !FlexibleDate.EMPTY.equals(ichiGoHanteiDateFrom)) {
            parameter.setIchiGojiHanteiYMDFrom(ichiGoHanteiDateFrom);
            parameter.setUseIchiGojiHanteiYMDFrom(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        FlexibleDate ichiGoHanteiDateTo = finderDiv.getTxtIchiGoHanteiDateTo().getValue();
        if (ichiGoHanteiDateTo != null && !FlexibleDate.EMPTY.equals(ichiGoHanteiDateTo)) {
            parameter.setIchiGojiHanteiYMDTo(ichiGoHanteiDateTo);
            parameter.setUseIchiGojiHanteiYMDTo(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        RString ichiGohanteiKekka = finderDiv.getDdlIchiGohanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(ichiGohanteiKekka)) {
            parameter.setIchiGojiHanteiKekkaCode(ichiGohanteiKekka);
            parameter.setUseIchiGojiHanteiKekkaCode(true);
            useIchiGojiHanteiKekkaJoho = true;
        }
        parameter.setUseIchiGojiHanteiKekkaJoho(useIchiGojiHanteiKekkaJoho);
    }

    private void editShinsakaiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        boolean useNinteiKekkaJoho = false;
        RString 二次判定要介護状態区分コード = finderDiv.getDdlNijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(二次判定要介護状態区分コード)) {
            parameter.setNijiHanteiYokaigoJotaiKubun(二次判定要介護状態区分コード);
            parameter.setUseNijiHanteiYokaigoJotaiKubun(true);
            useNinteiKekkaJoho = true;
        }
        RString 認定有効期間 = finderDiv.getTxtNinteiYukoKikan().getValue();
        if (!RString.isNullOrEmpty(認定有効期間)) {
            parameter.setNijiHanteiNinteiYukoKikan(Integer.parseInt(認定有効期間.toString()));
            parameter.setUseNijiHanteiNinteiYukoKikan(true);
            useNinteiKekkaJoho = true;
        }
        RDate 認定有効な申請時点 = finderDiv.getTxtCheckDay().getValue();
        if (認定有効な申請時点 != null) {
            parameter.setYokaiYMD(認定有効な申請時点.toDateString());
            parameter.setUseYokaiYMD(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 認定有効開始日FROM = finderDiv.getTxtNinteiYukoKaishiDateFrom().getValue();
        if (認定有効開始日FROM != null && !FlexibleDate.EMPTY.equals(認定有効開始日FROM)) {
            parameter.setNinteiYukoKaishiYMDFrom(認定有効開始日FROM);
            parameter.setUseNinteiYukoKaishiYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 認定有効開始日To = finderDiv.getTxtNinteiYukoKaishiDateTo().getValue();
        if (認定有効開始日To != null && !FlexibleDate.EMPTY.equals(認定有効開始日To)) {
            parameter.setNinteiYukoKaishiYMDTo(認定有効開始日To);
            parameter.setUseNinteiYukoKaishiYMDTo(true);
            useNinteiKekkaJoho = true;
        }

        FlexibleDate 認定有効終了日FROM = finderDiv.getTxtNinteiYukoShuryoDateFrom().getValue();
        if (認定有効終了日FROM != null && !FlexibleDate.EMPTY.equals(認定有効終了日FROM)) {
            parameter.setNinteiYukoShuryoYMDFrom(認定有効終了日FROM);
            parameter.setUseNinteiYukoShuryoYMDFrom(true);
            useNinteiKekkaJoho = true;
        }
        FlexibleDate 認定有効終了日To = finderDiv.getTxtNinteiYukoShuryoDate().getValue();
        if (認定有効終了日To != null && !FlexibleDate.EMPTY.equals(認定有効終了日To)) {
            parameter.setNinteiYukoShuryoYMDTo(認定有効終了日To);
            parameter.setUseNinteiYukoShuryoYMDTo(true);
            useNinteiKekkaJoho = true;
        }
        parameter.setUseNinteiKekkaJoho(useNinteiKekkaJoho);
        editKaisaiDateForParameter(finderDiv, parameter);
    }

    private void editKaisaiDateForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        boolean useShinsakaiKaisaiKekkaJoho = false;
        FlexibleDate 開催日FROM = finderDiv.getTxtKaisaiDateFrom().getValue();
        if (開催日FROM != null && !FlexibleDate.EMPTY.equals(開催日FROM)) {
            parameter.setShinsakaiKaisaiYMDFrom(開催日FROM);
            parameter.setUseShinsakaiKaisaiYMDFrom(true);
            useShinsakaiKaisaiKekkaJoho = true;
        }
        FlexibleDate 開催日To = finderDiv.getTxtKaisaiDateTo().getValue();
        if (開催日To != null && !FlexibleDate.EMPTY.equals(開催日To)) {
            parameter.setShinsakaiKaisaiYMDTo(開催日To);
            parameter.setUseShinsakaiKaisaiYMDTo(true);
            useShinsakaiKaisaiKekkaJoho = true;
        }
        RString 開催番号FROM = finderDiv.getTxtKaisaiNumberStart().getValue();
        if (!RString.isNullOrEmpty(開催番号FROM)) {
            parameter.setShinsakaiKaisaiNoFrom(開催番号FROM);
            parameter.setUseShinsakaiKaisaiNoFrom(true);
            useShinsakaiKaisaiKekkaJoho = true;
        }
        RString 開催番号To = finderDiv.getTxtKaisaiNumberEnd().getValue();
        if (!RString.isNullOrEmpty(開催番号To)) {
            parameter.setShinsakaiKaisaiNoTo(開催番号To);
            parameter.setUseShinsakaiKaisaiNoTo(true);
            useShinsakaiKaisaiKekkaJoho = true;
        }
        parameter.setUseShinsakaiKaisaiKekkaJoho(useShinsakaiKaisaiKekkaJoho);
    }

    private void editZenkaiJohoForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        RString 前回認定調査委託先 = finderDiv.getTxtZenkaiNinteiChosaItakusakiName().getValue();
        if (!RString.isNullOrEmpty(前回認定調査委託先)) {
            parameter.setZenkaiNinteiChosaItakusaki(finderDiv.getHdnZenkaiChosaItakusakiCode());
            parameter.setUseZenkaiNinteiChosaItakusaki(true);
        }
        RString 前回主治医医療機関 = finderDiv.getTxtZenkaiShujiiIryokikanName().getValue();
        if (!RString.isNullOrEmpty(前回主治医医療機関)) {
            parameter.setZenkaiShujiiIryokikanCode(finderDiv.getHdnZenkaiShujiiIryokikanCode());
            parameter.setUseZenkaiShujiiIryokikanCode(true);
        }

        RString 前回二次判定結果コード = finderDiv.getDdlZenkaiNijiHanteiKekka().getSelectedKey();
        if (!RString.isNullOrEmpty(前回二次判定結果コード)) {
            parameter.setZenkaiJotaiKubunCode(前回二次判定結果コード);
            parameter.setUseZenkaiJotaiKubunCode(true);
        }

        RString 前回認定有効期間 = finderDiv.getTxtZenkaiNinteiYukoKikan().getValue();
        if (!RString.isNullOrEmpty(前回認定有効期間)) {
            parameter.setZenkaiYukoKikan(Integer.parseInt(前回認定有効期間.toString()));
            parameter.setUseZenkaiYukoKikan(true);
        }

        FlexibleDate 設定有効開始日FROM = finderDiv.getTxtZenkaiYukoKaishiDateFrom().getValue();
        if (設定有効開始日FROM != null && !FlexibleDate.EMPTY.equals(設定有効開始日FROM)) {
            parameter.setZenkaiYukoKikanStartFrom(設定有効開始日FROM);
            parameter.setUseZenkaiYukoKikanStartFrom(true);
        }
        FlexibleDate 設定有効開始日To = finderDiv.getTxtZenkaiYukoKaishiDateTo().getValue();
        if (設定有効開始日To != null && !FlexibleDate.EMPTY.equals(設定有効開始日To)) {
            parameter.setZenkaiYukoKikanStartTo(設定有効開始日To);
            parameter.setUseZenkaiYukoKikanStartTo(true);
        }
        RString 原因疾患 = finderDiv.getCcdGeninShikkan().getCode().value();
        if (!RString.isNullOrEmpty(原因疾患)) {
            parameter.setGeninShikkanCode(原因疾患);
            parameter.setUseGeninShikkanCode(true);
            parameter.setUseGeninShikkan(true);
        }
        Decimal 申請経過日数FROM = finderDiv.getTxtShinseiKeikaNissu().getFromValue();
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (申請経過日数FROM != null) {
            parameter.setShinseiKeikaDaysForm(nowDate.minusDay(申請経過日数FROM.intValue()));
            parameter.setUseShinseiKeikaDaysForm(true);
        }
        Decimal 申請経過日数To = finderDiv.getTxtShinseiKeikaNissu().getToValue();
        if (申請経過日数To != null) {
            parameter.setShinseiKeikaDaysTo(nowDate.minusDay(申請経過日数To.intValue()));
            parameter.setUseShinseiKeikaDaysTo(true);
        }
    }

    private void editNowPhaseForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        RString 現在のフェーズ = finderDiv.getDdlNowPhase().getSelectedKey();
        if (RString.isNullOrEmpty(現在のフェーズ)) {
            parameter.setNowPhaseBlank(true);
        } else if (KanryoInfoPhase.申請受付.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseShinseiUketsuke(true);
        } else if (KanryoInfoPhase.調査依頼.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseChosaIrai(true);
        } else if (KanryoInfoPhase.意見書依頼.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseIkenshoIrai(true);
        } else if (KanryoInfoPhase.意見書入手.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseIkenshoNyushu(true);
        } else if (KanryoInfoPhase.一次判定.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseIchijiHantei(true);
        } else if (KanryoInfoPhase.マスキング.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseMasking(true);
        } else if (KanryoInfoPhase.審査会登録.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseShinsakaiToroku(true);
        } else if (KanryoInfoPhase.二次判定.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseNijiHantei(true);
        } else if (KanryoInfoPhase.月例処理.getコード().equals(現在のフェーズ)) {
            parameter.setNowPhaseGetsureiShori(true);
        }
    }

    private void editChkForParameter(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        boolean useNinteiKanryoJoho = false;
        List<KeyValueDataSource> 申請受付処理状態CHK = finderDiv.getChkShinseiUketsuke().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 申請受付処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setShinseiUketsukeKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setShinseiUketsukeMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }

        List<KeyValueDataSource> 調査依頼処理状態CHK = finderDiv.getChkChosaIrai().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 調査依頼処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setChosaIraiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setChosaIraiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 意見書依頼処理状態CHK = finderDiv.getChkIkenshoIrai().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 意見書依頼処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoIraiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoIraiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 調査入手処理状態CHK = finderDiv.getChkChosaNyushu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 調査入手処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setChosaNyushuKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setChosaNyushuMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 意見書入手処理状態CHK = finderDiv.getChkIkenshoNyushu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 意見書入手処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoNyushuKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setIkenshoNyushuMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 一次判定処理状態CHK = finderDiv.getChkIchijiHantei().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 一次判定処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setIchijiHanteiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setIchijiHanteiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        parameter.setUseNinteiKanryoJoho(useNinteiKanryoJoho);
        editChkForParameter2(finderDiv, parameter);
    }

    private void editChkForParameter2(NinteiShinseishaFinderDiv finderDiv, HanteiKekkaJouhouShuturyokuParameter parameter) {
        boolean useNinteiKanryoJoho = parameter.isUseNinteiKanryoJoho();
        List<KeyValueDataSource> マスキング処理状態CHK = finderDiv.getChkMasking().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : マスキング処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setMaskingKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setMaskingMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 審査会登録処理状態CHK = finderDiv.getChkShinsakaiToroku().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 審査会登録処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setShinsakaiTorokuKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setShinsakaiTorokuMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 二次判定処理状態CHK = finderDiv.getChkNijiHantei().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 二次判定処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setNijiHanteiKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setNijiHanteiMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        List<KeyValueDataSource> 月例処理処理状態CHK = finderDiv.getChkGetsureiShori().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 月例処理処理状態CHK) {
            if (KEY0.equals(keyValueDataSource.getKey())) {
                parameter.setGetsureiShoriKanryo(true);
                useNinteiKanryoJoho = true;
            }
            if (KEY1.equals(keyValueDataSource.getKey())) {
                parameter.setGetsureiShoriMiKanryo(true);
                useNinteiKanryoJoho = true;
            }
        }
        parameter.setUseNinteiKanryoJoho(useNinteiKanryoJoho);
    }

    private void hiduke(dgTaishoshaIchiran_Row dgFukushiyoguShohin, HanteiKekkaJouhouShuturyokuBusiness jigyoshaInput) {
        if (jigyoshaInput.get開催予定日() != null) {
            dgFukushiyoguShohin.getKaisaiYoteiDay().setValue(new FlexibleDate(jigyoshaInput.get開催予定日().toString()));
        }
        if (jigyoshaInput.get開催日() != null) {
            dgFukushiyoguShohin.getKaisaiDay().setValue(new FlexibleDate(jigyoshaInput.get開催日().toString()));
        }
        if (jigyoshaInput.get審査会結果情報抽出年月日() == null) {
            dgFukushiyoguShohin.setDataShutsuryoku(nullToEmpty(jigyoshaInput.get審査会結果情報抽出年月日()));
        } else {
            dgFukushiyoguShohin.setDataShutsuryoku(new RString("済"));
        }
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return DBE525002_HanteiKekkaHokenshaParameter
     */
    public DBE525002_HanteiKekkaHokenshaParameter setBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        DBE525002_HanteiKekkaHokenshaParameter hanteibatchParameter
                = new DBE525002_HanteiKekkaHokenshaParameter();
        hanteibatchParameter.setShinseishoKanriNo(shinseishoKanriNo);
        hanteibatchParameter.setNijiHanteiYMDFrom(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue() == null ? RString.EMPTY
                : new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString()));
        hanteibatchParameter.setNijiHanteiYMDTo(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue() == null ? RString.EMPTY
                : new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString()));
        return hanteibatchParameter;
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return DBE491001_NichijiShinchokuParameter
     */
    public DBE491001_NichijiShinchokuParameter setCSVBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        DBE491001_NichijiShinchokuParameter shinchokuParameter
                = new DBE491001_NichijiShinchokuParameter();
        shinchokuParameter.setShinseishoKanriNoList(shinseishoKanriNo);
        shinchokuParameter.setFayirukuben(new RString("1"));
        return shinchokuParameter;
    }

    /**
     * アクセスログを出力します。
     *
     */
    public void アクセスログ() {
        AccessLogger.log(AccessLogType.照会, toPersonalData(ShikibetsuCode.EMPTY));
    }

    private PersonalData toPersonalData(ShikibetsuCode 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("申請書管理番号"), 申請書管理番号.value());
        return PersonalData.of(申請書管理番号, expandedInfo);
    }

}
